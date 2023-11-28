package Com.ORANGE.Kavish.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Read_File {

	Properties pro;

	public Read_File() {
		File xyz = new File("E:\\ORANGE\\Read_Config\\Properties");
		try {
			FileInputStream File = new FileInputStream(xyz);
			pro = new Properties();
			pro.load(File);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public String readfile() {
		String url = pro.getProperty("URL");
		return url;

	}
}
