package com.stock.mvc.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.stock.mvc.dao.impl.FlickrDaoImp;

public class TestFlickr {

	public static void main(String[] args) {

			FlickrDaoImp flickr= new FlickrDaoImp();
			//flickr.auth();
			
			try {
				InputStream stream = new FileInputStream(new File("D:\\lass.jpg"));
				String url = flickr.savePhoto(stream, "MyFace");
				System.out.println(url);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


