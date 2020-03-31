package com.cakeonline.screen;

import java.awt.image.BufferedImage;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ScreenController {
	
	@RequestMapping("showscreen")
	public void show(HttpServletResponse response) {
		try {
			Map<String, BufferedImage> map = ScreenJob.map;
			
			ImageIO.write(map.get("1"), "png", response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
