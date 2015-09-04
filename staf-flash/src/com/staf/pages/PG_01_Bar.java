package com.staf.pages;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.staf.common.Browser;
import com.staf.common.Utilities;
import com.staf.common.constants.DataConstants;
import com.staf.common.constants.ObjectConstants;
import com.staf.controls.*;
import com.staf.model.Page;
import com.staf.reader.ConfigReader;
import com.staf.reader.ExcelReader;
import org.sikuli.script.*;

public class PG_01_Bar extends Page{
	
	private Map<String, String[]> data = new HashMap<String, String[]>(); 
	//private int index =  ConfigReader.getInstance().getDataCurrentRow();
	private Screen screen = new Screen();
	
	public Map<String, String[]> getData() {
		return data;
	}


	public void setData(Map<String, String[]> data) {
		this.data = data;
	}

	public PG_01_Bar() throws Exception  {
		super("PG_01_Bar");
		String [] dataFields = new String[]{"PickupLocation","PickupMonth","PickupDay","PickupTime",
											"DropOffMonth","DropOffDay","DropOffTime"};
		this.setData(ExcelReader.readTestData(dataFields));  
	}


	public void clickResources() throws IOException, InterruptedException {
		Image.click(this.getPageObjectsMap().get(ObjectConstants.PG_01_Resources));
		Browser.report("Resources Clicked");
	}

	public void verifyResourcePopup() throws IOException, InterruptedException{
		if(Image.isVisible(this.getPageObjectsMap().get(ObjectConstants.PG_01_Resourcespopup))== true){
			Browser.report("Resources PopUP displayed");
		}
			else{
				Browser.report("Resources PopUP not displayed");
		}
	}
	
	public void clickCloseResourcePopup(){
		Image.click(this.getPageObjectsMap().get(ObjectConstants.PG_01_Resourcespopupclose));
	}
	
	public void clickAudioScript() throws IOException, InterruptedException {
		Image.click(this.getPageObjectsMap().get(ObjectConstants.PG_01_Audioscript));
		Browser.report("Clicked AudioScript");
	}

	public void verifyAudioScriptPopup() throws IOException, InterruptedException{
		if(Image.isVisible(this.getPageObjectsMap().get(ObjectConstants.PG_01_Audioscriptpopup))== true){
			Browser.report("Audio script PopUP displayed");
		}
			else{
				Browser.report("Audio script PopUP not displayed");
		}
	}
	
	public void clickCloseAudioScriptPopup() throws IOException, InterruptedException{
		Image.click(this.getPageObjectsMap().get(ObjectConstants.PG_01_Audioscriptpopupclose));
		Browser.report("AudioScript Popup Closed");
	}
	
	public void clickPlay(Pattern p) throws FindFailed, IOException, InterruptedException{
		screen.click(p);
		Browser.report("Clicked Play button");
	}
	
	public void clickRefresh(Pattern p) throws FindFailed, IOException, InterruptedException{
		screen.click(p);
		Browser.report("Clicked Refresh button");
	}
	
	public void clickNext() throws IOException, InterruptedException {
		Image.click(this.getPageObjectsMap().get(ObjectConstants.PG_01_Next));
		Browser.report("Clicked Next");
	}
	
	public void clickPaus(Pattern p) throws FindFailed, IOException, InterruptedException{
		screen.click(p);
		Browser.report("Clicked Pause button");
	}
}
