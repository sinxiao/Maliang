package com.zhangjiang.sinxiao.maliang;

import android.view.View;

public class RequestBuilder {

	private String path;
	private RequestBuilder builder = null;

	public RequestBuilder() {
	}

	public RequestBuilder load(String path) {
		if (builder == null) {
			builder = new RequestBuilder();
		}
		builder.path = path;
		return builder;
	}

	public void into(View view) {
		if (builder == null) {
			builder = new RequestBuilder();
		}
		IRequest req = new RemoteRequest();
		req.setUrl(path);
		req.setView(view);

		Dispatch.getInstence().add(req);

	}
}
