package com.kareemullah.customerDataManagement.theatre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheatreController 
{
	@Autowired
	private TheatreService theatreService;
	
	@PostMapping("/save")
	public Theatre save(@RequestBody Theatre theatre)
	{
		return theatreService.save(theatre);
		
	}

}
