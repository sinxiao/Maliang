package com.zhangjiang.sinxiao.maliang;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.graphics.BitmapFactory;
import android.os.Message;
import android.util.Log;

public class RemoteRequest extends IRequest {

	private String TAG ="RemoteRequest";
	/**
	 * 首先，查找内存里是否存在该图， 调用处理说明，根据工厂类获取web请求方式，URLConnection
	 * ，HttpClient,OKHttp,Valley等 通过BitmapFactory.decodeStream 处理获取的
	 * InputStream输入流。 将获取的Bitmap里放到Cache里。 将获取的Bitmap保存到本地sdcard中...
	 * 发送图片下载成功，控件刷新的命令...
	 */
	public void performRequest() {
		Log.e(TAG, "key +++> "+key);
		bp = LruCache.getInstence().get(key);
		if(bp!=null)
		{
			Log.e(TAG, "bp +++> not null");	
			ok();
			return ;
		}else{
			Log.e(TAG, "bp +++> null");
		}
		URLConnection conn = null;
		try {
			conn = new URL(url).openConnection();
			Log.e(TAG, "request url +++> "+url);
			try {

				bp = BitmapFactory.decodeStream(conn.getInputStream());
				// 保存图片到Cache
				LruCache.getInstence().add(bp, key);
				ok();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}

	}

	private void ok() {
		if (view != null) {
			Message msg =Maliang.mHanlder.obtainMessage();
			msg.obj = this;
			msg.what = Maliang.GETIMAGEOK;
			Maliang.mHanlder.sendMessage(msg);
		}
	}

	private void fail() {
		if (view != null) {
			Message msg = Maliang.mHanlder.obtainMessage();
			msg.obj = this;
			msg.what = Maliang.GETIMAGEFAIL;
			Maliang.mHanlder.sendMessage(msg);
		}

	}

}
