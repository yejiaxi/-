package cn.jiaxi.common.file;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;



import com.jfinal.kit.PathKit;

public class UploadService {
	/**
	 * 上传图片允许的最大尺寸，目前只允许 200KB
	 */
	public static final int imageMaxSize = 200 * 1024;
	
	/**
	 * 上传图片临时目录，相对于 baseUploadPath 的路径，是否以 "/" 并无影响
	 * 本项目的 baseUploadLoad 为 /var/www/project_name/upload
	 */
	public static final String uploadTempPath = "/img/temp";
	/**
	 * 相对于 webRootPath 之后的目录，与"/upload" 是与 baseUploadPath 重合的部分
	 */
	public static final String basePath ="upload"+File.separator+"img" + File.separator;
	
	/**
	 * 每个子目录允许存 5000 个文件
 	 */
	public static final int FILES_PER_SUB_DIR = 5000;
	
	/**
	 * 生成规范的文件名
	 * accountId_年月日时分秒.jpg
	 * 包含 accountId 以便于找到某人上传的图片，便于定位该用户所有文章，方便清除恶意上传
	 * 图片中添加一些 meta 信息：accountId_201604161359.jpg
	 * 目录中已经包含了模块名了，这里的 meta 只需要体现 accountId 与时间就可以了
	 */
	public String generateFileName(Integer accountId, String extName) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String timeStr = sdf.format(new Date());
		return accountId + "_" + timeStr + extName;
	}

}
