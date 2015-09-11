package com.rescam.xhb.common.action;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class BasicAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	protected String imageFileName = null;

	/**
	 * 以源文件类型来保存上传的文件，使用UUID作为文件名，并返回为文件存储的全路径
	 * 
	 * @param upload
	 * @param uploadFileName
	 * @param key
	 * @return savePath + UUIDfileName
	 * @throws IOException
	 */
	public String saveFile(String key, File upload, String uploadFileName)
	        throws IOException {
		long now = new Date().getTime();
		if (upload != null) {
			// 读取配置文件中的路径
			Properties pro = new Properties();
			InputStream path = Thread.currentThread().getContextClassLoader()
			        .getResourceAsStream("path.properties");// 获取路径并转换成流
			pro.load(path);
			String savePath = pro.getProperty(key);// key表示配置文件中的key
			// 1.设置保存上传的文件全部路径
			String uploadPath = ServletActionContext.getServletContext()
			        .getRealPath("/") + savePath;

			// 判断上传文件名是否有扩展名
			int index = uploadFileName.lastIndexOf('.');
			if (index != -1) {
				imageFileName = now + uploadFileName;// .substring(index);
			} else {
				imageFileName = Long.toString(now);
			}
			// 使用当前时间毫秒数+1000内随机数编辑文件名，以解决重名的问题
			String timeRandomFileName = Long.toString(now)
			        + (int) Math.random() * 1000 + imageFileName;
			// 如果文件夹不存在，就创建
			File dir = new File(uploadPath);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			File destFile = new File(uploadPath, timeRandomFileName);
			upload.renameTo(destFile);// 移动到目的地
			return timeRandomFileName;// savePath + UUIDfileName;
		}
		return null;
	}
}
