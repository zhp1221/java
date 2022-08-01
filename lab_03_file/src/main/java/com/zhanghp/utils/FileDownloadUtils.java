package com.zhanghp.utils;

import cn.hutool.core.util.ArrayUtil;
import com.zhanghp.exception.ServiceException;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.SocketException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * 文件下载工具类
 *
 * @author zhanghp
 * @date 2022-08-01 15:03
 */
public class FileDownloadUtils {

    /**
     * 浏览器下载文件
     */
    public static final String DISPOSITION_ATTACHMENT = "attachment";
    /**
     * 浏览器内嵌显示一个文件
     */
    public static final String DISPOSITION_INLINE = "inline";

    /**
     * 文件下载统一调度方法入口
     *
     * @param response    http servlet response
     * @param fileName    文件名
     * @param filePath    文件路径
     * @param mimeTypes   媒体类型
     * @param disposition 响应内容处理类型
     */
    public static void download(HttpServletResponse response, String fileName, String filePath, String[] mimeTypes, String disposition) throws IOException {
        try {
            // 文件名称判空
            if (ObjectUtils.isEmpty(fileName) || !new File(filePath).exists()) {
                throw new ServiceException(HttpStatus.BAD_REQUEST.value(), "未上传文件名称，请联系管理员");
            }
            // 校验文件
            checkAllowDownload(fileName, filePath, mimeTypes);
            // 媒体格式类型设置
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            // 响应头设置
            setAttachmentResponseHeader(response, fileName, disposition);
            // 流传输
            writeBytes(filePath, response.getOutputStream());
        } catch (ServiceException e) {
            // 遇到错误，请求头修改回来
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            throw new SocketException(e.getMessage());
        }
    }

    /**
     * 校验文件是否允许被下载
     *
     * @param fileName  文件名称
     * @param filePath  文件路径
     * @param mimeTypes 媒体格式类型
     */
    private static void checkAllowDownload(String fileName, String filePath, String[] mimeTypes) {
        // 文件存在校验
        if (!new File(filePath).exists()) {
            throw new ServiceException(HttpStatus.BAD_REQUEST.value(), "系统中不存在该文件");
        }
        // 尾缀校验
        if (!ArrayUtil.contains(mimeTypes, getExtension(fileName))) {
            throw new ServiceException(HttpStatus.BAD_REQUEST.value(), "该文件类型不在规定的类型里");
        }
    }

    /**
     * 通过文件名获取扩展类型
     *
     * @param fileName 文件名称
     * @return 扩展类型
     */
    private static String getExtension(String fileName) {
        int index = fileName.lastIndexOf(".");
        if (index == -1) {
            throw new ServiceException(HttpStatus.BAD_REQUEST.value(), "文件类型异常，请检查文件类型");
        }
        return fileName.substring(index + 1);
    }

    private static void setAttachmentResponseHeader(HttpServletResponse response, String fileName, String disposition) {
        String encodeFileName = encode(fileName, StandardCharsets.UTF_8.toString());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(disposition + "; ")
                .append("filename=" + encodeFileName + ";")
                .append("filename*=utf-8'' " + encodeFileName);
        response.setHeader("Content-disposition", stringBuilder.toString());
    }

    /**
     * 编码文件名
     *
     * @param fileName   文件名
     * @param encodeType 编码类型
     * @return
     */
    private static String encode(String fileName, String encodeType) {
        String result = "";
        try {
            result = URLEncoder.encode(fileName, encodeType);

        } catch (UnsupportedEncodingException e) {
            throw new ServiceException(HttpStatus.BAD_REQUEST.value(), "该文件不支持编码");
        }
        return result;
    }

    /**
     * 文件流写进OutputStream中
     *
     * @param filePath 文件路径
     * @param os       输出流
     */
    private static void writeBytes(String filePath, OutputStream os) {
        FileInputStream fis = null;
        File file = new File(filePath);
        if (!file.exists()) {
            throw new ServiceException(HttpStatus.BAD_REQUEST.value(), "系统中不存在该文件");
        }
        try {
            fis = new FileInputStream(file);
            byte[] b = new byte[1024];
            int length;
            while ((length = fis.read(b)) != -1) {
                os.write(b, 0, length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new ServiceException(HttpStatus.BAD_REQUEST.value(), "文件未找到");
        } catch (IOException e) {
            e.printStackTrace();
            throw new ServiceException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "文件传输出错， 请联系管理员");
        } finally {
            try {
                IOUtils.close(os);
            } catch (IOException e) {
                e.printStackTrace();
                throw new ServiceException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "文件传输关闭出错， 请联系管理员");
            }
            try {
                IOUtils.close(fis);
            } catch (IOException e) {
                e.printStackTrace();
                throw new ServiceException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "文件传输关闭出错， 请联系管理员");
            }
        }

    }
}
