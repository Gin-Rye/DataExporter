package com.github.ginrye.base.log;

public class Logger {
	public static void info(String message) {
		System.out.println(message);
	}
	public static void error(Exception e) {
		e.printStackTrace();
	}
	public static void debug(String message) {
		System.out.println(message);
	}
}
