package com.revature.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No card of that id was found.")
public class CardNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
}
