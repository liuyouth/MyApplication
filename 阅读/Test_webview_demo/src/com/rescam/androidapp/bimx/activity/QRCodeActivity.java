package com.rescam.androidapp.bimx.activity;

import java.io.IOException;
import java.util.Vector;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.test_webview_demo.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.rescam.androidapp.bimx.utils.camera.CameraManager;
import com.rescam.androidapp.bimx.utils.decoding.InactivityTimer;
import com.rescam.androidapp.bimx.utils.decoding.QRCodeActivityHandler;
import com.rescam.androidapp.bimx.view.ViewfinderView;

public class QRCodeActivity extends Activity implements Callback {
	private QRCodeActivityHandler handler;
	private ViewfinderView viewfinderView;
	private boolean hasSurface;
	private Vector<BarcodeFormat> decodeFormats;
	private String characterSet;
	private InactivityTimer inactivityTimer;
	private MediaPlayer mediaPlayer;
	private boolean playBeep;
	private static final float BEEP_VOLUME = 0.10f;
	private boolean vibrate;
	private Button button2, button1,btnback;
    private int cardType=1;
	private long exitTime = 0;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.camera);
		// ViewUtil.addTopView(getApplicationContext(), this,
		// R.string.scan_card);
		CameraManager.init(getApplication());
		viewfinderView = (ViewfinderView) findViewById(R.id.viewfinder_view);
		hasSurface = false;
		inactivityTimer = new InactivityTimer(this);

		button1 = (Button) findViewById(R.id.btn1);
		button2 = (Button) findViewById(R.id.btn2);
		btnback = (Button) findViewById(R.id.back);
		btnback.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				finish();
				System.exit(0);

			}
		});
		button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(QRCodeActivity.this, "您选择了单个扫描",
						Toast.LENGTH_SHORT).show();
				cardType = 1;
			}
		});

		button2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(QRCodeActivity.this, "您选择了多个扫描",
						Toast.LENGTH_SHORT).show();
				cardType = 2;

			}
		});
		
	}

	@Override
	protected void onResume() {
		super.onResume();
		SurfaceView surfaceView = (SurfaceView) findViewById(R.id.preview_view);
		SurfaceHolder surfaceHolder = surfaceView.getHolder();
		if (hasSurface) {
			initCamera(surfaceHolder);
		} else {
			surfaceHolder.addCallback(this);
			surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		}
		decodeFormats = null;
		characterSet = null;

		playBeep = true;
		AudioManager audioService = (AudioManager) getSystemService(AUDIO_SERVICE);
		if (audioService.getRingerMode() != AudioManager.RINGER_MODE_NORMAL) {
			playBeep = false;
		}
		initBeepSound();
		vibrate = true;

	}

	@Override
	protected void onPause() {
		super.onPause();
		if (handler != null) {
			handler.quitSynchronously();
			handler = null;
		}
		CameraManager.get().closeDriver();
	}

	@Override
	protected void onDestroy() {
		inactivityTimer.shutdown();
		super.onDestroy();
	}

	/**
	 * Handler scan result
	 * 
	 * @param result
	 * @param barcode
	 */
	public void handleDecode(Result result, Bitmap barcode) {
		inactivityTimer.onActivity();
		playBeepSoundAndVibrate();
		String resultString = result.getText();
		// FIXME
		btnback.setVisibility(View.VISIBLE);
		System.out.println(resultString);
		
		if (cardType==1) {
			if (resultString.equals("http://bimx.rescam.com/component?code=A_IV")) {
				
		
				
				Intent resultIntent = new Intent();
				Bundle bundle = new Bundle();
				bundle.putString("result", resultString);
				resultIntent.putExtras(bundle);
				this.setResult(-1, resultIntent);
				QRCodeActivity.this.finish();
			}else {
				//CameraManager.init(getApplication());
				//viewfinderView = (ViewfinderView) findViewById(R.id.viewfinder_view);
				//hasSurface = false;
				//inactivityTimer = new InactivityTimer(this);
				//SurfaceView surfaceView = (SurfaceView) findViewById(R.id.preview_view);
				//SurfaceHolder surfaceHolder = surfaceView.getHolder();
				onPause();
				onResume();

				Toast.makeText(QRCodeActivity.this, "请扫描正确的二维码",
						Toast.LENGTH_SHORT).show();
//				try {
//					CameraManager.get().openDriver(surfaceHolder);
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
				
			}
		}else {
			
			button1.setText("完成");
			button1.setClickable(false);
			button1.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					QRCodeActivity.this.finish();
				}
			});
			
			if (resultString.equals("http://bimx.rescam.com/component?code=A_IV")) {
			
				button1.setClickable(true);
//				System.out.println("Result:" + resultString);
				Intent resultIntent = new Intent();
				Bundle bundle = new Bundle();
				bundle.putString("result", resultString);
				resultIntent.putExtras(bundle);
				this.setResult(2, resultIntent);
			}else {
				onPause();
				onResume();
				Toast.makeText(QRCodeActivity.this, "请扫描正确的二维码",
						Toast.LENGTH_SHORT).show();
			}
		}
		
	}
	

	private void initCamera(SurfaceHolder surfaceHolder) {
		try {
			CameraManager.get().openDriver(surfaceHolder);
		} catch (IOException ioe) {
			return;
		} catch (RuntimeException e) {
			return;
		}
		if (handler == null) {
			handler = new QRCodeActivityHandler(this, decodeFormats,
					characterSet);
		}
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {

	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		if (!hasSurface) {
			hasSurface = true;
			initCamera(holder);
		}

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		hasSurface = false;

	}

	public ViewfinderView getViewfinderView() {
		return viewfinderView;
	}

	public Handler getHandler() {
		return handler;
	}

	public void drawViewfinder() {
		viewfinderView.drawViewfinder();

	}

	private void initBeepSound() {
		if (playBeep && mediaPlayer == null) {
			// The volume on STREAM_SYSTEM is not adjustable, and users found it
			// too loud,
			// so we now play on the music stream.
			setVolumeControlStream(AudioManager.STREAM_MUSIC);
			mediaPlayer = new MediaPlayer();
			mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
			mediaPlayer.setOnCompletionListener(beepListener);

			AssetFileDescriptor file = getResources().openRawResourceFd(
					R.raw.beep);
			try {
				mediaPlayer.setDataSource(file.getFileDescriptor(),
						file.getStartOffset(), file.getLength());
				file.close();
				mediaPlayer.setVolume(BEEP_VOLUME, BEEP_VOLUME);
				mediaPlayer.prepare();
			} catch (IOException e) {
				mediaPlayer = null;
			}
		}
	}

	private static final long VIBRATE_DURATION = 200L;

	private void playBeepSoundAndVibrate() {
		if (playBeep && mediaPlayer != null) {
			mediaPlayer.start();
		}
		if (vibrate) {
			Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
			vibrator.vibrate(VIBRATE_DURATION);
		}
	}

	/**
	 * When the beep has finished playing, rewind to queue up another one.
	 */
	private final OnCompletionListener beepListener = new OnCompletionListener() {
		public void onCompletion(MediaPlayer mediaPlayer) {
			mediaPlayer.seekTo(0);
		}
	};

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// �����ؼ�ʱ
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if ((System.currentTimeMillis() - exitTime) > 2000) {
				Toast.makeText(getApplicationContext(), "再按一次，退出扫描",
						Toast.LENGTH_SHORT).show();
				exitTime = System.currentTimeMillis();
			} else {
				finish();
				System.exit(0);

			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	public void onRe() {
		if (handler != null) {
			handler.quitSynchronously();
			handler = null;
		}
		CameraManager.get().closeDriver();
	}

}
