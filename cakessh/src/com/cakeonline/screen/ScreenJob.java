package com.cakeonline.screen;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScreenJob {
	
	public static Map<String, BufferedImage> map = new HashMap<String, BufferedImage>(10);
	public static int count = 1;
	
//	@Scheduled(cron="* * * * * ? ")
	public void createScreen() {
		try {
			BufferedImage  image = ScreenCapture.getScreen();
			if(count>11) {
				count = 1;
			}
			map.put(""+count, image);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
