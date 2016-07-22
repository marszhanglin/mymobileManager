package com.mars.mymobilemanager.orm.ormlite.dao;

import java.sql.SQLException;

import net.mutil.util.L;
import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.mars.mymobilemanager.orm.ormlite.bean.StartImg;
import com.mars.mymobilemanager.orm.ormlite.db.DatabaseHelper;

public class StartImgDao {

	private Context context;
	private Dao<StartImg, Integer> dao;
	private DatabaseHelper helper;

	public StartImgDao(Context context) {
		this.context = context;
		try {
			helper = DatabaseHelper.getHelper(context);
			dao = helper.getDao(StartImg.class);
		} catch (SQLException e) {
			L.e("StartImgDao-----StartImgDao:" + e.getMessage());
		}
	}

	/**
	 * 增加一个用户
	 * 
	 * @param user
	 * @throws SQLException
	 */
	public void add(StartImg bean) {
		try {
			dao.create(bean);
		} catch (SQLException e) {
			L.e("StartImgDao-----add:" + e.getMessage());
		}

	}

	
	
	public boolean deleteById(int id) {
		int num = 0;
		try {
			num = dao.deleteById(id);
		} catch (SQLException e) {
			L.e("StartImgDao-----deleteById:" + e.getMessage());
		}
		return num > 0;
	}

	public boolean uptate(StartImg bean) {
		int num = 0;
		try {
			num = dao.update(bean);
		} catch (SQLException e) {
			L.e("StartImgDao-----uptate:" + e.getMessage());
		}
		return num > 0;
	}

	public StartImg get(int id) {
		try {
			return dao.queryForId(id);
		} catch (SQLException e) {
			L.e("StartImgDao-----queryForId:" + e.getMessage());
		}
		return null;
	}
	
	/**
	 * 这个URL是否存在
	 * @param url
	 * @return
	 */
	public boolean isUrlExit(String url){
		try {
			dao.queryBuilder().where().eq("image_url", url).query();
		} catch (SQLException e) { 
			L.e("StartImgDao-----isUrlExit:" + e.getMessage());
		}
		return true;
	}
	
}
