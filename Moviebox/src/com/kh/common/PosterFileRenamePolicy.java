package com.kh.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class PosterFileRenamePolicy implements FileRenamePolicy{
	
	@Override
	public File rename(File originFile) {
		
		// 원본 파일명
		String originName = originFile.getName();
		// 1. 파일이 업로드된 시간 추출 => String currentTime
		String currentTime = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
		// 2. 5자리 랜덤값 만들기 => int randomNo
		int randomNo = (int)(Math.random() * 90000) + 10000;
		// 3. 확장자 => String ext
		// lastIndexOf(찾고자하는문자열)
		String ext = originName.substring(originName.lastIndexOf("."));
		// 1 + 2 + 3 조합해서 수정파일명을 변수에 대입하기
		String changeName = "poster_" +  originName + "_" + currentTime + "_" + randomNo + ext;
		//poster_사용자가 올리는 파일명 + 파일이 업로드된 시간 +  5자리 랜덤값
		// 기존 파일명을 수정된 파일명으로 적용시켜서 반환
		return new File(originFile.getParent(), changeName);
	}

}
