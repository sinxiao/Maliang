package com.zhangjiang.sinxiao.maliang;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

public class Maliang {

	private Context mContext;
	static final int GETIMAGEOK = 0;
	static final int GETIMAGEFAIL = 1;
	Handler mHanlder = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case GETIMAGEOK:
				IRequest req = (IRequest) msg.obj;
				req.paintSkin();
				break;
			case GETIMAGEFAIL:
				req = (IRequest) msg.obj;
				req.paintError();
				break;
			default:
				break;
			}
		};
	};
	private RequestBuilder nowRequest;

	public RequestBuilder with(Context context) {
		if (mContext == null) {
			mContext = context.getApplicationContext();
			mHanlder = new Handler(Looper.getMainLooper());
		}
		if (nowRequest == null) {
			nowRequest = new RequestBuilder(mHanlder);
		}
		// nowRequest.with(mContext);
		return nowRequest;
	}

	public RequestBuilder load(String url) {
		if (nowRequest == null) {
			nowRequest = new RequestBuilder(mHanlder);
		}
		nowRequest.load(url);
		return nowRequest.load(url);
	}

	public void into(View v) {
		nowRequest.into(v);
		nowRequest = null;
	}

}
