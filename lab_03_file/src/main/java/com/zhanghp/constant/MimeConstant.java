package com.zhanghp.constant;

/**
 * <a href = "https://baike.baidu.com/item/MIME/2900607?fr=aladdin"> Mime 说明 </a>
 *
 * @author: zhanghp
 * @date: 2022-07-30 13:38
 */
public class MimeConstant {

	/**
	 * JPG
	 */
	public static final String IMAGE_JPG = "image/jpg";

	/**
	 * PNG
	 */
	public static final String IMAGE_PNG = "image/png";

	/**
	 * JPEG
	 */
	public static final String IMAGE_JPEG = "image/jpeg";

	/**
	 * BMP
	 */
	public static final String IMAGE_BMP = "image/bmp";

	/**
	 * GIF
	 */
	public static final String IMAGE_GIF = "image/gif";

	/**
	 * IMAGE(图片相关尾缀)
	 */
	public static final String[] IMAGE_EXTENSION = { "bmp", "gif", "jpg", "jpeg", "png" };

	/**
	 * NORMAL(标准的相关尾缀)
	 */
	public static final String[] NORMAL_WORD_EXTENSION = {
			// IMAGE
			"bmp", "gif", "jpg", "jpeg", "png",
			// partial wps
			"pdf", "doc", "docx", "wps" };

	/**
	 * FLASH
	 */
	public static final String[] FLASH_EXTENSION = { "swf", "flv" };

	/**
	 * MEDIA
	 */
	public static final String[] MEDIA_EXTENSION = { "swf", "flv", "mp3", "wav", "wma", "wmv", "mid", "avi", "mpg",
			"asf", "rm", "rmvb" };

	/**
	 * VIDEO
	 */
	public static final String[] VIDEO_EXTENSION = { "mp4", "avi", "rmvb" };

	/**
	 * 默认尾缀
	 */
	public static final String[] DEFAULT_ALLOWED_EXTENSION = {
			// IMAGE
			"bmp", "gif", "jpg", "jpeg", "png",
			// wps
			"pdf", "doc", "docx", "wps", "xls", "xlsx", "ppt",
			// htm
			"html", "htm",
			// txt
			"txt",
			// COMPRESS
			"rar", "zip", "gz", "bz2",
			// video
			"mp4", "avi", "rmvb" };

}
