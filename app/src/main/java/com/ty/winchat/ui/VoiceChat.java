package com.ty.winchat.ui;

import java.io.IOException;
import java.net.InetAddress;

import android.os.Bundle;

import com.ty.winchat.R;
import com.ty.winchat.listener.UDPVoiceListener;

/**
 * ÓïÒôÁÄÌì
 * @author wj
 * @creation 2013-5-7
 */
public class VoiceChat extends Base{

	private String chatterIP;//¼ÇÂ¼µ±Ç°ÓÃ»§ip
	private UDPVoiceListener voiceListener;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.video_chat);
		chatterIP=getIntent().getStringExtra("IP");
		findViews();
		try {
			voiceListener=UDPVoiceListener.getInstance(InetAddress.getByName(chatterIP));
			voiceListener.open();
		} catch (IOException e) {
			e.printStackTrace();
//				finish();
			showToast("±§Ç¸£¬ÓïÒôÁÄÌìÆ÷´ò¿ªÊ§°Ü");
		}
	}

	private void findViews(){

	}


	@Override
	protected void onDestroy() {
		super.onDestroy();
		try {
			voiceListener.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
