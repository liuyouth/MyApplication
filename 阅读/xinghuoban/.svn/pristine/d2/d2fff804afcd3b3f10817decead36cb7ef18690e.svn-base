package com.rescam.xhb.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.util.PropertyResourceBundle;

public class GetPropertiesFile {

	/**
	 * 根据包名取得{@link Properties}类的对象. 封装文件访问异常.
	 * 
	 * @param bundleName
	 *            包名
	 * @return {@link Properties}对象
	 * @throws CommonException
	 *             通用层的异常
	 */
	public static Properties getPropObjFromBundle(final String bundleName) {

		PropertyResourceBundle bundle;
		bundle = (PropertyResourceBundle) PropertyResourceBundle
				.getBundle(bundleName);

		Properties propObj = new Properties();
		Enumeration<String> enm = bundle.getKeys();
		/* 填充Properties对象 */
		while (enm.hasMoreElements()) {
			String key = enm.nextElement();
			String value = bundle.getString(key);
			propObj.setProperty(key, value);
		}
		return propObj;
	}

	/**
	 * 根据物理路径取得{@link Properties}类的对象. 封装文件访问异常.
	 * 
	 * @param filePath
	 *            文件的物理路径
	 * 
	 * @return {@link Properties}对象
	 * @throws CommonException
	 *             通用层的异常
	 */
	public static Properties getPropObjFromFile(final String filePath) {

		Properties propObj = new Properties();
		InputStream inStream = null;
		try {
			File file = new File(filePath);

			try {
				inStream = new FileInputStream(file);
				propObj.load(inStream);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} finally {
			/* In流不为空的情况,关闭该流 */
			if (inStream != null) {
				try {
					inStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}

		return propObj;
	}
}
