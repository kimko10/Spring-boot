package com.carrotglobal.common.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ErrorHandle {
	
	private String locale;
	
	private String message;
	
	private LocalDateTime timestamp;
	
	private String status;
	
	private String uri;
	
	private int code;
	
	private HttpStatus httpStatus;
	

}
