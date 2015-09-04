package com.staf.pages;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.sikuli.script.*;

import com.staf.common.Browser;
import com.staf.common.Utilities;
import com.staf.common.constants.DataConstants;
import com.staf.common.constants.ObjectConstants;
import com.staf.controls.*;
import com.staf.model.Page;
import com.staf.reader.ConfigReader;
import com.staf.reader.ExcelReader;

public class PG_02_firstSetSlides extends Page {
	private Map<String, String[]> data = new HashMap<String, String[]>(); 
	
	private Screen screen = new Screen();
	//private int index =  ConfigReader.getInstance().getDataCurrentRow();
	

	public Map<String, String[]> getData() {
		return data;
	}


	public void setData(Map<String, String[]> data) {
		this.data = data;
	}

	public PG_02_firstSetSlides() throws Exception  {
		super("PG_02_firstSetSlides");
		String [] dataFields = new String[]{"PickupLocation","PickupMonth","PickupDay","PickupTime",
											"DropOffMonth","DropOffDay","DropOffTime"};
		this.setData(ExcelReader.readTestData(dataFields));  
	}
	
	public void verifyImage(Pattern p, int i) throws FindFailed, IOException, InterruptedException{
		String st = p.getFilename();
		String fileName = st.substring(st.lastIndexOf("\\")+1, st.lastIndexOf("."));	
		screen.wait(p,i);
		Browser.report(fileName+" image verified");
		
	}

}
