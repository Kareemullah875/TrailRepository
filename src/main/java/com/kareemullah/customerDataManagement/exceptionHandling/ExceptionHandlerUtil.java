package com.kareemullah.customerDataManagement.exceptionHandling;

import java.time.LocalDateTime;
import java.util.InputMismatchException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.kareemullah.customerDataManagement.dto.ResponseStructure;

@ControllerAdvice
public class ExceptionHandlerUtil
{
	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<ResponseStructure<String>> noNoDataFoundException(NoDataFoundException ie)
	{
		ResponseStructure<String> responseStructure= new ResponseStructure<String>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("No Data Found");
		responseStructure.setData(ie.getMessage());
		responseStructure.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	
	}
	
	@ExceptionHandler(InputMismatchException.class)
	public ResponseEntity<ResponseStructure<String>> inInputMismatchException(InputMismatchException im)
	{
		ResponseStructure<String> responseStructure= new ResponseStructure<String>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Input Mismatched");
		responseStructure.setData(im.getMessage());
		responseStructure.setTimeStamp(LocalDateTime.now());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	
	}

}
