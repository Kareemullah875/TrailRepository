package com.kareemullah.customerDataManagement.exceptionHandling;

public class NoDataFoundException extends RuntimeException
{
	public String message="No data found for the given request";

	public NoDataFoundException()
	{
		
	}
	
	public NoDataFoundException(String message )
	{
		this.message=message;
	}
	
	@Override
	public String getMessage()
	{
		return message;
	}

	
	
}
