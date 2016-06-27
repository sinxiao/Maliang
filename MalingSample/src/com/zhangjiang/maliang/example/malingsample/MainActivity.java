package com.zhangjiang.maliang.example.malingsample;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;
import com.zhangjiang.sinxiao.maliang.Maliang;

public class MainActivity extends Activity {
	private ImageView igv;
	private Button fetch;
	private List<String> testimagepaths;

	private LinearLayout layoutImages;
	private Button fetchMany;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		fetch = (Button) findViewById(R.id.fetch);
		igv = (ImageView) findViewById(R.id.igv);
		fetch.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Maliang.with(getApplicationContext())
						.load("http://img5.imgtn.bdimg.com/it/u=3982011729,247805372&fm=21&gp=0.jpg")
						.into(igv);
			}
		});
		testimagepaths = new ArrayList<String>();
		testimagepaths
				.add("http://pic44.nipic.com/20140722/17961491_162711251000_2.jpg");
		testimagepaths
				.add("http://img.taopic.com/uploads/allimg/130728/318764-130HPZ33685.jpg");
		testimagepaths
				.add("http://image.cnsc8.com/tupian_201410/Big_Pic/xTZGtTZ4xq.jpg");
		testimagepaths
				.add("http://www.fansimg.com/uploads2013/10/userid84214time20131021161840.jpg");
		testimagepaths
				.add("http://pic21.nipic.com/20120530/5916570_154035303199_2.jpg");
		testimagepaths
				.add("http://img0.imgtn.bdimg.com/it/u=1340945503,2472626207&fm=21&gp=0.jpg");
		testimagepaths
				.add("http://pic44.nipic.com/20140721/8421130_143649249000_2.jpg");
		testimagepaths
				.add("http://pic4.nipic.com/20090825/2250800_114859094597_2.jpg");
		testimagepaths
				.add("http://pic75.nipic.com/file/20150818/10903821_170435122000_2.jpg");
		testimagepaths
				.add("http://pic23.nipic.com/20120806/8575724_072806380158_2.jpg");
		testimagepaths
				.add("http://imgbbs.heiguang.net/forum/201403/25/112913hjg53qjs3qsq95sl.jpg");
		testimagepaths
				.add("http://p2.gexing.com/G1/M00/13/8C/rBACE1O7U_CxsJkIAAENCFnrzGA616_600x.jpg");
		testimagepaths
				.add("http://pic74.nipic.com/file/20150807/9448607_114353567000_2.jpg");
		testimagepaths
				.add("http://pic14.nipic.com/20110607/3211026_171155489135_2.jpg");
		testimagepaths
				.add("http://www.6188.com/upload_6188s/flashAll/s800/20120803/1343957913E4iRBg.jpg");
		testimagepaths
				.add("http://c.hiphotos.baidu.com/zhidao/pic/item/2f738bd4b31c8701cba62eb8277f9e2f0708ff58.jpg");
		testimagepaths
				.add("http://img4.imgtn.bdimg.com/it/u=2904366686,1599241884&fm=21&gp=0.jpg");
		testimagepaths
				.add("http://pic63.nipic.com/file/20150330/12443929_143056473000_2.jpg");
		testimagepaths
				.add("http://pic50.nipic.com/file/20141012/17961491_092705112000_2.jpg");
		testimagepaths
				.add("http://pic31.nipic.com/20130703/8821914_135026681137_2.jpg");
		testimagepaths
				.add("http://pic34.nipic.com/20131029/8952533_150842505000_2.jpg");
		testimagepaths
				.add("http://img.sucai.redocn.com/attachments/images/201003/20100326/Redocn_2010032516563131.jpg");
		testimagepaths
				.add("http://img5.imgtn.bdimg.com/it/u=1505592017,244531614&fm=21&gp=0.jpg");
		testimagepaths
				.add("http://www.zlcool.com/d/file/2010/03/09/525a064059dcaa32a561816855d3e996.jpg");
		testimagepaths
				.add("http://pic.58pic.com/58pic/11/31/78/66N58PICWqz.jpg");
		testimagepaths
				.add("http://pic9.nipic.com/20100811/5426754_091947929125_2.jpg");
		testimagepaths
				.add("http://pic64.nipic.com/file/20150414/610812_172220227577_2.jpg");
		testimagepaths
				.add("http://img4.mypsd.com.cn/20110329/Mypsd_29368_201103290936170009B.jpg");
		testimagepaths
				.add("http://image78.360doc.com/DownloadImg/2014/09/0910/45098262_19.jpg");
		testimagepaths
				.add("http://img.taopic.com/uploads/allimg/140323/240451-1403230I30960.jpg");
		testimagepaths
				.add("http://hiphotos.baidu.com/sailor198195/pic/item/7879a60bfe5498e662d986ba.jpg");
		testimagepaths
				.add("http://tupian.enterdesk.com/2013/mxy/12/09/2/3.jpg");
		testimagepaths
				.add("http://img4.imgtn.bdimg.com/it/u=1836088703,821816543&fm=21&gp=0.jpg");
		testimagepaths
				.add("http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1308/17/c7/24564676_1376705117811.jpg");
		testimagepaths
				.add("http://pic22.nipic.com/20120702/6647776_112823199191_2.jpg");
		testimagepaths
				.add("http://img3.redocn.com/20100423/Redocn_2010041806140528.jpg");
		testimagepaths
				.add("http://img.sucai.redocn.com/attachments/images/201204/20120428/Redocn_2012042800151065.jpg");
		testimagepaths
				.add("http://www.jiemeng8.com/uploads/allimg/c140324/1395645060F-1H05.jpg");
		testimagepaths
				.add("http://img2.ph.126.net/IXFBo3N5MsIAcYt4cFlckg==/1598214917863427534.gif");
		testimagepaths
				.add("http://www.enterdesk.com/uploadfile/2013/0823/20130823101317753.jpg");
		testimagepaths
				.add("http://pic1a.nipic.com/2008-12-17/2008121710485688_2.jpg");
		testimagepaths
				.add("http://img01.tooopen.com/Downs/images/2009/8/13/sy_20090813160802062122.jpg");
		testimagepaths
				.add("http://img4.imgtn.bdimg.com/it/u=808485460,3826307440&fm=21&gp=0.jpg");
		testimagepaths
				.add("http://img4.duitang.com/uploads/item/201407/25/20140725133608_TUyCA.jpeg");
		testimagepaths
				.add("http://img1.imgtn.bdimg.com/it/u=1603748731,2430306156&fm=21&gp=0.jpg");
		testimagepaths
				.add("http://f.hiphotos.baidu.com/zhidao/pic/item/8cb1cb134954092310a498609458d109b2de49db.jpg");
		testimagepaths
				.add("http://img1.sc115.com/uploads/sc/jpg/HD/9/6627.jpg");
		testimagepaths
				.add("http://pic21.nipic.com/20120612/2786001_183632311000_2.jpg");
		testimagepaths
				.add("http://www.coolsc.net/imguploads/Image_0709/2007/desk/7/71.jpg");
		testimagepaths
				.add("http://img5.duitang.com/uploads/item/201407/25/20140725133733_sB5VC.jpeg");
		testimagepaths
				.add("http://pic.58pic.com/58pic/15/15/93/91558PICyME_1024.jpg");
		testimagepaths
				.add("http://img4.imgtn.bdimg.com/it/u=2583325910,3933860382&fm=21&gp=0.jpg");
		testimagepaths
				.add("http://pic61.nipic.com/file/20150307/9448607_123825484000_2.jpg");
		testimagepaths
				.add("http://img.redocn.com/sheying/20150318/qingcheweilandedahai_4020658.jpg");
		testimagepaths
				.add("http://img.taopic.com/uploads/allimg/140329/234991-14032915012459.jpg");
		testimagepaths
				.add("http://pic1a.nipic.com/2009-03-06/20093620236974_2.jpg");
		testimagepaths
				.add("http://pic18.nipic.com/20111130/1458915_134903651196_2.jpg");
		testimagepaths
				.add("http://www.bz55.com/uploads/allimg/150130/139-150130103450.jpg");
		testimagepaths
				.add("http://img.51ztzj.com/upload/image/20140716/dn201407154005_670x419.jpg");
		testimagepaths.add("http://img1.3lian.com/2015/a1/34/d/30.jpg");
		layoutImages = (LinearLayout) findViewById(R.id.layoutImages);
		fetchMany = (Button) findViewById(R.id.fetchmany);
		fetchMany.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				for (int i = 0; i < testimagepaths.size(); i++) {
					ImageView igv = new ImageView(getApplicationContext());
					igv.setLayoutParams(new LayoutParams(
							LayoutParams.WRAP_CONTENT,
							LayoutParams.WRAP_CONTENT));

					Maliang.with(getApplicationContext())
							.load(testimagepaths.get(i)).into(igv);
					
//					Picasso.with(getApplicationContext()).load(testimagepaths.get(i)).into(igv);

					layoutImages.addView(igv);

				}

			}
		});

	}
}
