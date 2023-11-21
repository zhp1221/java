package com.zhanghp.ctrl;

import com.zhanghp.constant.MimeConstant;
import com.zhanghp.model.FileDown;
import com.zhanghp.utils.FileDownloadUtils;
import com.zhanghp.utils.FileUploadUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhanghpmvn
 * @date 2022-07-30 16:22
 */
@RestController
public class FileController {

	@PostMapping("/upload")
	public String upload(@RequestBody MultipartFile file) throws IOException {
		// 文件上传
		return FileUploadUtils.upload(file, "C:\\upload", MimeConstant.DEFAULT_ALLOWED_EXTENSION);
	}

	@PostMapping("/download")
	public void download(HttpServletResponse response, @RequestBody FileDown file) throws IOException {
		// 文件上传
		FileDownloadUtils.download(response, file.getFileName(), file.getFilePath(),
				MimeConstant.DEFAULT_ALLOWED_EXTENSION, FileDownloadUtils.DISPOSITION_ATTACHMENT);
	}

}
