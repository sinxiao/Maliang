package com.zhangjiang.sinxiao.maliang;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.graphics.BitmapFactory;
import android.os.Message;

public class RemoteRequest extends IRequest {

	/**
	 * 首先，查找内存里是否存在该图， 调用处理说明，根据工厂类获取web请求方式，URLConnection
	 * ，HttpClient,OKHttp,Valley等 通过BitmapFactory.decodeStream 处理获取的
	 * InputStream输入流。 将获取的Bitmap里放到Cache里。 将获取的Bitmap保存到本地sdcard中...
	 * 发送图片下载成功，控件刷新的命令...
	 */
	public void performRequest() {

		bp = LruCache.getInstence().get(key);
		if(bp!=null)
		{
			ok();
			return ;
		}
		URLConnection conn = null;
		try {
			conn = new URL(url).openConnection();
			try {

				bp = BitmapFactory.decodeStream(conn.getInputStream());
				// 保存图片到Cache

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
			Message msg = mHandler.obtainMessage();
			msg.obj = this;
			msg.what = Maliang.GETIMAGEOK;
			mHandler.sendMessage(msg);
		}
	}

	private void fail() {
		if (view != null) {
			Message msg = mHandler.obtainMessage();
			msg.obj = this;
			msg.what = Maliang.GETIMAGEFAIL;
			mHandler.sendMessage(msg);
		}

	}

}
