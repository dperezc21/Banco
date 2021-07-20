package com.cmc.commons.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static Date convertir(String dato) throws ParseException{
		SimpleDateFormat formato = new SimpleDateFormat("yyyy/dd/MM");
		return formato.parse(dato);
		
	}

}
