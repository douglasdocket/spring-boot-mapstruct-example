package com.github.douglasdocket.mapstruct.service;

import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class DateService {

	public Optional<Date> stringToDate(String dateString, String dateFormat) {
		try {
			Date dateParsed = new SimpleDateFormat(dateFormat).parse(dateString);

			return Optional.of(dateParsed);
		} catch (ParseException e) {
			e.printStackTrace();
			return Optional.empty();
		}
	}

}
