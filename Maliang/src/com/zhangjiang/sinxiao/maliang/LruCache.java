package com.zhangjiang.sinxiao.maliang;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Environment;

/**
 * 图片缓存器，缓存在内存里， 缓存在本地disk里。
 * 
 * @author ok
 * 
 */
public class LruCache implements Cache {

	@SuppressWarnings("unused")
	private LruCache() {
	}

	private static LruCache cache;

	public static LruCache getInstence() {
		if (cache == null) {
			return null;
		}
		return cache;
	}

	private Context mContxt;

	private android.util.LruCache<String, Bitmap> lrucache;

	ExecutorService executors = Executors.newFixedThreadPool(2);

	@SuppressLint("DefaultLocale")
	public void storeDisk(String key, Bitmap bp) {
		File f = new File(Environment.getExternalStorageDirectory(),
				mContxt.getPackageName());
		if (!f.exists()) {
			f.mkdirs();
		}
		f = new File(f.getAbsolutePath() + File.separator + key);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(f);
			if (key.toLowerCase().endsWith("png")) {
				bp.compress(CompressFormat.PNG, 100, fos);
			} else {
				bp.compress(CompressFormat.JPEG, 100, fos);
			}
			try {
				fos.flush();
				fos.close();
				fos = null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.flush();
					fos.close();
					fos = null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public Bitmap getDisk(String key) {
		File f = new File(Environment.getExternalStorageDirectory(),
				mContxt.getPackageName());
		if (!f.exists()) {
			return null;
		}
		f = new File(f.getAbsolutePath() + File.separator + key);
		return BitmapFactory.decodeFile(f.getAbsolutePath());
	}

	public LruCache(Context mContext) {
		if (mContxt == null) {
			mContxt = mContext;
			lrucache = new android.util.LruCache<String, Bitmap>(16 * 2);
			cache = this;
		}
	}

	@Override
	public void add(final Bitmap bitmap, final String key) {

		lrucache.put(key, bitmap);
		executors.execute(new Runnable() {

			public void run() {
				storeDisk(key, bitmap);
			}
		});
	}

	@Override
	public Bitmap get(String key) {
		Bitmap bp = lrucache.get(key);
		if (bp == null) {
			bp = getDisk(key);
		}
		return bp;
	}

	@Override
	public void clear() {
		Iterator<String> iterator = lrucache.snapshot().keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			lrucache.remove(key);
		}

	}

}
