package com.demo.utils;

public class UploadUtils {

	//解决文件名重复的问题
	public static String getUuidFileName(String uploadFileName){
		int lastIndexOfExtension = uploadFileName.lastIndexOf(".");
		String extensionStr = uploadFileName.substring(lastIndexOfExtension);
		return UUIDUtils.getId()+extensionStr;
	
	}
	
	public static void main(String[] args) {
		System.out.println(getUuidFileName("aa.txt"));
	}
	
	//目录分离的工具
	public static String getPath(String fileName){
		int code = fileName.hashCode();
		int d1 = code & 0xf;//作为1级目录
		int code2 = d1 >>> 4;
		int d2 = code2 & 0xf;//作为2级目录
		return "/"+d1+"/"+d2;
	}
}
