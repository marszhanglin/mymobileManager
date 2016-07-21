package com.mars.mymobilemanager.base;

import java.io.File;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.utils.StorageUtils;

/**
 * 
 * @author mars_zhang
 * 
 */
public class App extends Application {
	public static App instance;
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		instance = this;
		initUIL(getApplicationContext());
	}
	
	
	

	/**
	 * 初始化图片加载组件
	 * 
	 * @param context
	 */
	private void initUIL(Context context) {
		// 缓存保存位置
		File cacheDir = StorageUtils.getCacheDirectory(context);
		ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(
				context).threadPoolSize(3)
				.threadPriority(Thread.NORM_PRIORITY - 2)
				.memoryCache(new LruMemoryCache(2 * 1024 * 1024))
				.denyCacheImageMultipleSizesInMemory()
				.tasksProcessingOrder(QueueProcessingType.LIFO)
				.diskCache(new UnlimitedDiskCache(cacheDir)).writeDebugLogs()
				.build();
		ImageLoader.getInstance().init(configuration);
	}

}
