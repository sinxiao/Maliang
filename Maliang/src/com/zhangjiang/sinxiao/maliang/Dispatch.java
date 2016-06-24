package com.zhangjiang.sinxiao.maliang;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Pattern;

import android.util.Log;

public class Dispatch {
	private static final String TAG = "Dispatch";
	private Dispatch(){}
	private static Dispatch dispatch;
	public static Dispatch getInstence()
	{
		if(dispatch==null)
		{
			dispatch = new Dispatch();
		}
		return dispatch ;
	}
	private int getNumCores() {
		// Private Class to display only CPU devices in the directory listing
		class CpuFilter implements FileFilter {
			@Override
			public boolean accept(File pathname) {
				// Check if filename is "cpu", followed by a single digit number
				if (Pattern.matches("cpu[0-9]", pathname.getName())) {
					return true;
				}
				return false;
			}
		}

		try {
			// Get directory containing CPU info
			File dir = new File("/sys/devices/system/cpu/");
			// Filter to only list the devices we care about
			File[] files = dir.listFiles(new CpuFilter());
			Log.d(TAG, "CPU Count: " + files.length);
			// Return the number of cores (virtual CPU devices)
			return files.length;
		} catch (Exception e) {
			// Print exception
			Log.d(TAG, "CPU Count: Failed.");
			e.printStackTrace();
			// Default to return 1 core
			return 1;
		}
	}

	private final int CPU_NUM = getNumCores();
	private final BlockingQueue<IRequest> requests = new ArrayBlockingQueue<IRequest>(
			CPU_NUM * 2 * 8, false);

	private ThreadFactory threadFactory = new ThreadFactory() {
		public Thread newThread(Runnable r) {
			Thread thread = new Thread(r);
			thread.setPriority(Thread.MAX_PRIORITY);
			return thread;
		}
	};

	private ExecutorService executor = Executors.newFixedThreadPool(
			CPU_NUM * 2, threadFactory);

	public void add(IRequest req) {
		try {
			if (!run) {
				run = true;
				performNow();
			}
			requests.put(req);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void destory() {
		run = false;
		executor.shutdownNow();
		requests.clear();
	}

	private boolean run = false;

	private void performNow() {
		while (run) {
			try {
				final IRequest req = requests.take();
				executor.execute(new Runnable() {
					public void run() {
						req.performRequest();
					}
				});
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
