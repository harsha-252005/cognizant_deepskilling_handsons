package com.fse.country;
import org.springframework.http.HttpStatus; import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.NOT_FOUND) public class CountryNotFoundException extends RuntimeException { public CountryNotFoundException(String code) { super("Country not found: " + code); } }
