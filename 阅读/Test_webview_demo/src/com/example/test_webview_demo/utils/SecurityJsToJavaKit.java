package com.example.test_webview_demo.utils;

public class SecurityJsToJavaKit {
	
	/**
	 * @author yuanhaizhou
	 * 用于建立安全的 android  js之间通信的桥梁包
	 */
	
	private JsPromptListener jsPromptListener;//监听器
	
	
	private static final String JS_FEATURE="JsMsg::";
	
	
	/**
	 * 检查当前的msg是否为js端的通信信号
	 * @param msg
	 * @return
	 */
	public static boolean isJsMsgCommunication(String msg){
		return false ;
	}
	
	
	/**
	 * 
	 * @author Administrator
	 *jsPrompt监听器
	 */
	public interface JsPromptListener{
		void onJsPromptHappend();
	}

}
