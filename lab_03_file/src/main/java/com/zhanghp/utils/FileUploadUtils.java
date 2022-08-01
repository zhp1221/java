package com.zhanghp.utils;

import cn.hutool.core.io.file.FileNameUtil;
import cn.hutool.core.lang.UUID;
import com.zhanghp.exception.ServiceException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * 文件上传相关工具类
 *
 * @author zhanghp
 * @date 2022-07-30 13:35
 */
public class FileUploadUtils {

    /**
     * 上文文件限制：50MB
     */
    private static final long FILE_LIMIT_SIZE = 50 * 1024 * 1024;

    /**
     * 文件上传统一调度入口
     *
     * @param file      上传的文件
     * @param baseDir   保存目标目录
     * @param mimeTypes 允许上传的文件扩展名
     * @return 保存的文件的绝对路径
     */
    public static String upload(MultipartFile file, String baseDir, String[] mimeTypes) throws IOException {
        // 文件判空
        if (ObjectUtils.isEmpty(file)) {
            throw new ServiceException(HttpStatus.BAD_REQUEST.value(), "上传文件为空");
        }
        // 校验文件大小及类型判断
        checkFile(file, mimeTypes);
        // 生成日期目录，并编码文件名称
        String encodingFileName = encodingFileName(file);
        // 父级目录生成
        File desc = getAbsoluteFile(baseDir, encodingFileName);
        // 文件流保存
        FileUtils.copyInputStreamToFile(file.getInputStream(), desc);
        // 回显
        return baseDir + File.separator + encodingFileName;
    }

    /**
     * 文件大小及文件尾缀判断
     *
     * @param file      上传的文件
     * @param mimeTypes 允许上传的文件类型
     */
    private static void checkFile(MultipartFile file, String[] mimeTypes) {
        // 文件大小判断
        if (file.getSize() > FILE_LIMIT_SIZE) {
            throw new ServiceException(HttpStatus.BAD_REQUEST.value(), "上传文件大小超过50MB");
        }
        // 文件尾缀判断
        if (!isAllowedExtension(getExtension(file), mimeTypes)) {
            throw new ServiceException(HttpStatus.BAD_REQUEST.value(), "不是规定的文件类型");
        }
    }

    /**
     * 根据文件获取其Mime类型
     *
     * @param file 上传文件
     * @return 尾缀
     */
    private static String getExtension(MultipartFile file) {
        String result;
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取尾缀
        result = FileNameUtil.getSuffix(fileName);
        // 判空
        if (ObjectUtils.isEmpty(result)) {
            throw new ServiceException(HttpStatus.BAD_REQUEST.value(), "上传文件不含尾缀，请检查上传文件类型及名称");
        }
        return result;
    }

    /**
     * 文件尾缀规则判断
     *
     * @param extension 上传的文件尾缀
     * @param mimeTypes 允许传的mime类型
     * @return 是/否
     */
    private static boolean isAllowedExtension(String extension, String[] mimeTypes) {
        // 判空
        if (ObjectUtils.isEmpty(mimeTypes)) {
            throw new ServiceException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "文件规范尾缀为空，请联系管理员");
        }
        // 文件尾缀类型对比
        for (String it : mimeTypes) {
            if (it.equals(extension)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 编码文件名，并规范生成存储路径
     *
     * @param file 上传的文件
     * @return 文件路径 -> 年/月/uuid.尾缀
     */
    private static String encodingFileName(MultipartFile file) {
        // 目录格式
        final String format = "yyyy" + File.separator + "MM";
        // 获取文件尾缀
        String extension = getExtension(file);
        // 返回文件系统路径：年/月/uuid.尾缀
        return DateFormatUtils.format(new Date(), format) + File.separator + UUID.fastUUID() + "." + extension;
    }

    /**
     * 获取上传文件
     *
     * @param baseDir          基路径
     * @param encodingFileName 编码后文件名 -》 年/月/uuid.尾缀
     * @return 文件
     */
    private static File getAbsoluteFile(String baseDir, String encodingFileName) {
        File file = new File(baseDir + File.separator + encodingFileName);
        // 父级目录判断
        if (!file.getParentFile().exists()) {
            // 创建父级目录
            file.getParentFile().mkdirs();
        }
        return file;
    }
}
