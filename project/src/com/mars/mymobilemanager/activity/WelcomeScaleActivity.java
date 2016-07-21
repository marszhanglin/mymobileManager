package com.mars.mymobilemanager.activity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import net.mutil.util.Constants;
import net.mutil.util.HttpUtils;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.BinaryHttpResponseHandler;
import com.mars.mymobilemanager.R;
import com.mars.mymobilemanager.base.BaseActivity;
/**
 * 放大欢迎界面   
 * @author mars_zhang
 *
 */
public class WelcomeScaleActivity  extends BaseActivity{

	private ImageView scaleImageView;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcomescale);
		initView();
		initImageView();
	}
	
	
	private void initView() {
		scaleImageView = (ImageView) findViewById(R.id.image_scale);
	}
	
	
	
	
    private void initImageView(){
        File dir=getFilesDir();//  /data/data/com.mars.mymobilemanager/files #
        final File imaFile = new File(dir,"start.jpg");//缓存  
        if(imaFile.exists()){//如果图片存在显示
        	scaleImageView.setImageBitmap(BitmapFactory.decodeFile(imaFile.getAbsolutePath()));
        }else{//不存在显示默认
        	scaleImageView.setImageResource(R.drawable.start);
        }
        //放大动画
        ScaleAnimation scaleAnim = new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

        scaleAnim.setFillAfter(true);
        scaleAnim.setDuration(3000);//持续3秒
        //动画监听
        scaleAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {//动画开始
//                Toast.makeText(WelcomeActivity.this, "onAnimationStart", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(Animation animation) {//动画结束  结束后请求图片下次显示 
            	
            	log("动画结束", 1);
            	
                HttpUtils.get(Constants.START, new AsyncHttpResponseHandler() {//请求json
					@Override
					public void onSuccess(int arg0, Header[] arg1, byte[] bytes) {
						log("json下载完成", 1);
						//==================================================
						JSONObject jsonObject;
						String url = null;
						try {
							jsonObject = new JSONObject(new String(bytes));
							url = jsonObject.getString("img");
							toast(url, 0);
						} catch (JSONException e) {
							e.printStackTrace();
						}
						//==================================================
						
						//将https请求改成http请求  坑死爹爹了  
                        if(url!=null&&url.length()>0&&url.startsWith("https")){
                            url= url.replaceFirst("s", "");
                        }
						
						HttpUtils.getImage(url, new BinaryHttpResponseHandler() {//请求图片流
							
							@Override
							public void onSuccess(int arg0, Header[] arg1, byte[] bytes) {
								//保存图片
								saveImage(imaFile, bytes);
							}
							
							@Override
							public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
								
							}
						});
						//==================================================
			            
					}
					
					@Override
					public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
						// TODO Auto-generated method stub
						
					}
				});
            }

            @Override
            public void onAnimationRepeat(Animation animation) {//动画重复
//                Toast.makeText(WelcomeActivity.this, "onAnimationRepeat", Toast.LENGTH_SHORT).show();
            }
        });

        //给View设置动画
        scaleImageView.setAnimation(scaleAnim);
    }


    /**
     * 保存文件
     * @param imgfile
     * @param bytes
     */
    private void saveImage(File imgfile, byte[] bytes)  {
        imgfile.delete();//先删再存
        try {
            FileOutputStream fos=new FileOutputStream(imgfile);
            fos.write(bytes);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
	
}



 