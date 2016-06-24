package com.zhangjiang.sinxiao.maliang;

import android.graphics.Bitmap;

public interface Cache {
	
	public void add(Bitmap bitmap,String key);
	
	public Bitmap get(String key);
	
	public void clear();
	
}
