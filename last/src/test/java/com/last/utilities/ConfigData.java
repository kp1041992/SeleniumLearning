package com.last.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigData {

	Properties pro;

	public ConfigData() {
		// TODO Auto-generated constructor stub
	}

	{
		File src = new File(System.getProperty("user.dir") + "/config/config.properties");
		try {
			FileInputStream fin = new FileInputStream(src);
			pro = new Properties();
			pro.load(fin);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("unable to read excel file" + e.getMessage());
		}

	}

	public String getProperty(String prop) {

		if(pro.getProperty(prop).isEmpty()) {
			System.out.println("There is no properties by that name");
		}
		return pro.getProperty(prop);
		

	}

	public String getBrowser() {

		return pro.getProperty("browser");

	}

	public String getUrl() {

		return pro.getProperty("appUrl");

	}
}
