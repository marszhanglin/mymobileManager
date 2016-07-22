package com.mars.mymobilemanager.orm.ormlite.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName = "start_img")
public class StartImg {
	
	@DatabaseField(generatedId = true)
	private int id;
	@DatabaseField(columnName = "image_url")
	private String imageurl;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	@Override
	public String toString() { 
		return "[id:"+id+",image_url:"+imageurl+"]";
	}
	
	
	
}
