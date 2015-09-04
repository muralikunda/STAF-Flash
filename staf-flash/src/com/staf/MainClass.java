package com.staf;

import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

import com.staf.common.*;
import com.staf.reader.ConfigReader;

public class MainClass  {

	//public static void main(String[] args) throws Exception{
		
	@Test
	public void runScript() throws Exception{
		
		ConfigReader.getInstance().readConfiguration();
		ConfigReader.getInstance().setTestCaseName("MainClass");
		Screen screen = new Screen();
		
		Pattern play = new Pattern("D:\\STAF\\Images\\Play.png");
		Pattern pause = new Pattern("D:\\STAF\\Images\\pause.png");
		Pattern firstImage = new Pattern("D:\\STAF\\Images\\startImage.png");
		Pattern s1978 = new Pattern("D:\\STAF\\Images\\1978.png");
		Pattern thirdImage = new Pattern("D:\\STAF\\Images\\ships.png");
		Pattern fourthImage = new Pattern("D:\\STAF\\Images\\clickArrowContinue.png");
		Pattern refresh = new Pattern("D:\\STAF\\Images\\refresh.png");
		
		
		Application app = new Application();
		Browser.launchBrowser(ConfigReader.getInstance().getBrowserType(), ConfigReader.getInstance().getUrl());
		Browser.maximize();
		ConfigReader.getInstance().setDataRowsCount(0);
		for(int currentRow=0; currentRow<=ConfigReader.getInstance().getDataRowsCount(); currentRow++){
			ConfigReader.getInstance().setDataCurrentRow(currentRow);
			

			app.PG_01_Bar.clickPaus(pause);
			app.PG_01_Bar.clickResources();
			app.PG_01_Bar.verifyResourcePopup();
			app.PG_01_Bar.clickCloseResourcePopup();
			app.PG_01_Bar.clickAudioScript();
			app.PG_01_Bar.verifyAudioScriptPopup();
			app.PG_01_Bar.clickCloseAudioScriptPopup();
			app.PG_01_Bar.clickPlay(play);
						
			app.PG_02_firstSetSlides.verifyImage(firstImage, 20);
			app.PG_02_firstSetSlides.verifyImage(s1978, 20);
			app.PG_02_firstSetSlides.verifyImage(thirdImage, 20);
			app.PG_02_firstSetSlides.verifyImage(fourthImage, 20);
			
			app.PG_01_Bar.clickRefresh(refresh);
			
			Thread.sleep(1000);
			
			app.PG_01_Bar.clickNext();
			
		
			
			//Browser.back();
		}
		//Browser.quit();
	}
}


