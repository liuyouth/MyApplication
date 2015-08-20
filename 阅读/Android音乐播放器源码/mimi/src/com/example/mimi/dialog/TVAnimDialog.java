package com.example.mimi.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.example.mimi.R;
import com.example.mimi.constant.MyConstant;

/**
 * By CWD 2013 Open Source Project
 * 
 * <br>
 * <b>���ӻ�����Ч����Dialog</b></br>
 * 
 * <br>
 * ȡ���ſ���Ƶ�ͻ����˳�ʱ���ӻ��رն���Ч���������Ƴ���Ч�����̳и���ʹ��иö���Ч��</br>
 * 
 * @author CWD
 * @version 2013.07.31 v1.0 ʵ�ֶ���Ч�� <br>
 *          2013.08.01 v1.1 ʵ�ֶԻ���رյļ��� </br>
 */
public class TVAnimDialog extends Dialog {

	private int dialogId = MyConstant.DIALOG_DISMISS;
	private OnTVAnimDialogDismissListener listener;

	public TVAnimDialog(Context context) {
		super(context, R.style.TVAnimDialog);// �˴�����Dialog��ʽ
		// TODO Auto-generated constructor stub
	}

	public TVAnimDialog(Context context, int theme) {
		super(context, theme);
		// TODO Auto-generated constructor stub
	}

	protected TVAnimDialog(Context context, boolean cancelable,
			OnCancelListener cancelListener) {
		super(context, cancelable, cancelListener);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getWindow().setWindowAnimations(R.style.TVAnimDialogWindowAnim);// �˴�����Dialog����
	}

	@Override
	public void dismiss() {
		// TODO Auto-generated method stub
		super.dismiss();
		if (listener != null) {
			listener.onDismiss(dialogId);
		}
	}

	/**
	 * ��������Dialog��;
	 * 
	 * @param dialogId
	 *            Dialog ID
	 */
	public void setDialogId(int dialogId) {
		this.dialogId = dialogId;
	}

	/**
	 * ���ü�����
	 * 
	 * @param listener
	 *            OnTVAnimDialogDismissListener
	 */
	public void setOnTVAnimDialogDismissListener(
			OnTVAnimDialogDismissListener listener) {
		this.listener = listener;
	}

	/**
	 * ���ڼ����Ի���رյĽӿ�
	 */
	public interface OnTVAnimDialogDismissListener {
		/**
		 * �Ի���ر�
		 * 
		 * @param dialogId
		 *            Dialog ID
		 */
		void onDismiss(int dialogId);
	}

}
