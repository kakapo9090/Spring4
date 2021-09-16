package com.iu.s4.util;

import java.io.File;
import java.util.UUID;


import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
@Component
public class FileManager {
	//fileDelete() 
	public void fileDelete(File file) throws Exception{
		//3. 파일 삭제 		출처:MemberService.java
	
		file.delete();
	}
	
	
	//fileSave()
	//최종목적: 파일 저장  NoticeService 클래스 연동 (파일, 경로명)
	public String fileSave(MultipartFile multipartFile, File file) throws Exception{
		//파일객체(폴더)가 존재 하지 않다면 폴더만들기
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//파일명 생성
		String fileName = UUID.randomUUID().toString();
		fileName = fileName + "_" + multipartFile.getOriginalFilename();
		
		//file 객체에 대입(디렉토리, 파일명)
		file = new File(file, fileName);//(폴더디렉토리, 파일명)
		
		//저장	2가지 방법
		//1. FileCopyUtils
		//FileCopyUtils.copy(multipartFile.getBytes(), file);
		//2. MultipartFile
		multipartFile.transferTo(file);
		
		return fileName;
	}
	
}
