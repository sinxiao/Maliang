package com.zhangjiang.sinxiao.maliang;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public abstract class IRequest {
	String key;
	String path;
	String url;
	View view;
	Bitmap bp;

	/**
	 * 执行处理操作
	 */
	public abstract void performRequest();

	/**
	 * 执行刷新控件操作
	 */
	@SuppressWarnings("deprecation")
	public void paintSkin() {
		if (view instanceof ImageView) {
			((ImageView) view).setImageBitmap(bp);
		} else if (view instanceof TextView) {

			((TextView) view).setBackground(new BitmapDrawable(bp));
		}
	}

	public void paintError() {
		if (view instanceof ImageView) {
			((ImageView) view).setImageResource(R.drawable.ic_launcher);
		} else if (view instanceof TextView) {

			((TextView) view).setBackgroundResource(R.drawable.ic_launcher);
		}
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getUrl() {
		
		return url;
	}

	public void setUrl(String url) {
		key = url.replace("://", "~");
		key = key.replace("/", "@");
		this.url = url;
	}

	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

}
