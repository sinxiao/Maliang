package com.zhangjiang.sinxiao.maliang;

import android.os.Handler;
import android.view.View;

public class RequestBuilder {

	private String path;
	private View view;
	private RequestBuilder builder = null;
	private Handler ml;
	public RequestBuilder(Handler maliang) {
		ml = maliang;
	}

	RequestBuilder load(String path) {
		builder.path = path;
		return builder;
	}

	void into(View view) {
		builder.view = view;
		IRequest req = null;
		if (path != null && (path.startsWith("http") || path.startsWith("ftp"))) {
			req = new RemoteRequest();
			req.url = path;
		} else {
			req = new LocalRequest();
			req.path = path;
		}
		req.view = view;
		
		Dispatch.getInstence().add(req);
		// return builder;
	}

}
