package com.zhangjiang.sinxiao.maliang;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

public class Maliang {

	private static Context mContext;
	static final int GETIMAGEOK = 0;
	static final int GETIMAGEFAIL = 1;
	static Handler mHanlder = null;

	// static Handler thirdThread = null;

	public static RequestBuilder with(Context context) {
		if (mContext == null) {
			mContext = context.getApplicationContext();
			mHanlder = new Handler(Looper.getMainLooper()) {
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
			new LruCache(mContext);
		}
		RequestBuilder nowRequest = new RequestBuilder();
		return nowRequest;
	}

}
