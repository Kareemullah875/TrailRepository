package com.kareemullah.customerDataManagement.theatre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheatreService
{
	
	@Autowired
	private TheatreDao theatreDao;
	
	public Theatre save(Theatre theatre)
	{
		return theatreDao.save(theatre);
	}

}
