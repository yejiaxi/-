package cn.jiaxi.common.file;

import java.io.File;

import com.jfinal.core.Controller;
import com.jfinal.kit.PathKit;
import com.jfinal.upload.UploadFile;
/**
 * 文件上传控制器
 */
public class UploadController extends Controller {
	//一定到导入cos.jar包 不然会报错
	public void upload(){
		//UploadService.basePath  路径为相对于根路径的相对路径
		UploadFile file = this.getFile("img", UploadService.basePath);
		System.out.println(file);
		renderText("上传成功");
		
	}
}
