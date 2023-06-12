package com.kareemullah.customerDataManagement.theatre;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TheatreDao
{
	@Autowired
	private TheatreRepository theatreRepository;
	
	@Autowired
	private ScreenRepository screenRepository;
	
	public Theatre save(Theatre theatre)
	{
		List<Screens> listscreens = theatre.getNoOfScreens();
		
		for(int i=0;i<listscreens.size();i++)
		{
			Screens screens = listscreens.get(i);
			
			screens.setTheatre(theatre);
			
			screenRepository.save(screens);
			
			
		}
		
		return theatre;
	}
	
	
}
