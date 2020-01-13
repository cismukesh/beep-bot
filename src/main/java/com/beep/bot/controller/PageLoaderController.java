package com.beep.bot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageLoaderController {
	
	/**
	 * This method is used to get page location
	 * load beep-bot-home 
	 * @return String
	 */
	@GetMapping(path = "beep-bot-home")
	public String getLocationPage() {
		return "location";
	}
}
