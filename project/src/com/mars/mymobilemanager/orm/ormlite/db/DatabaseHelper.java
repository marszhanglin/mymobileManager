package com.mars.mymobilemanager.orm.ormlite.db;

import java.sql.SQLException;
import java.util.HashMap;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.mars.mymobilemanager.base.App;
import com.mars.mymobilemanager.orm.ormlite.bean.StartImg;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

	private static final String TABLE_NAME = "sqlite-mymobile.db";

	/**
	 * 单例
	 * 
	 * @param context
	 */
	private DatabaseHelper(Context context) {
		super(context, TABLE_NAME, null, 4);
	}

	private static DatabaseHelper instance;
	private HashMap<String, Dao> daos;

	/**
	 * 单例获取该Helper
	 * 
	 * @param context
	 * @return
	 */
	public static synchronized DatabaseHelper getHelper(Context context) {
		context = context.getApplicationContext();
		if (instance == null) {
			synchronized (DatabaseHelper.class) {
				if (instance == null)
					instance = new DatabaseHelper(context);
			}
		}

		return instance;
	}
	
	//当数据库创建时
	@Override
	public void onCreate(SQLiteDatabase database,
			ConnectionSource connectionSource) {
		try {
			TableUtils.clearTable(connectionSource, StartImg.class);//创建数据库表
		} catch (SQLException e) {
			Log.e(App.instance.getPackageName(), "orm框架创表失败");
		} 
	}
	//当数据库更新时
	@Override
	public void onUpgrade(SQLiteDatabase database,
			ConnectionSource connectionSource, int oldVersion, int newVersion) {
		try {
			TableUtils.dropTable(connectionSource, StartImg.class, true);
		} catch (SQLException e) {
			Log.e(App.instance.getPackageName(), "orm框架删表失败");
		}
		
	}
	
	
	
	/**
	 * 获取dao
	 */
	public synchronized Dao getDao(Class clazz) throws SQLException
	{
		Dao dao = null;
		String className = clazz.getSimpleName();
		if (daos.containsKey(className))
		{
			dao = daos.get(className);
		}
		if (dao == null)
		{
			dao = super.getDao(clazz);
			daos.put(className, dao);
		}
		return dao;
	}

	/**
	 * 释放资源
	 */
	@Override
	public void close()
	{
		super.close();

		for (String key : daos.keySet())
		{
			Dao dao = daos.get(key);
			dao = null;
		}
	}
}
