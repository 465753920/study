package org.xiaomao.servlet;

import java.io.UnsupportedEncodingException;

public class Utils {

	public static String getNewString(String str) throws UnsupportedEncodingException{
		return new String(str.getBytes("ISO-8859-1"),"UTF-8");
	}
	
}
