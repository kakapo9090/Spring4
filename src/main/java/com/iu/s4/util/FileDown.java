package com.iu.s4.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.iu.s4.board.BoardFilesDTO;

@Component
public class FileDown extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// model -> Controller의 model의 정보를 여기서 꺼낸다
		
		
		//폴더명
		String board = (String)model.get("board");
		//파일명
		BoardFilesDTO boardFilesDTO = (BoardFilesDTO)model.get("dto");
		
		
		
		
		//realPath작업
		board = request.getSession().getServletContext().getRealPath("/resources/upload/"+board);
		
		//(realPath경로, 파일명)
		File file = new File(board, boardFilesDTO.getFileName());
		
		
		//파일명에 한글이 들어간 경우 처리
		response.setCharacterEncoding("UTF-8");
		
		//파일크기 설정
		response.setContentLength((int)file.length());
		
		//다운시 파일 이름 인코딩
		//String downName = URLEncoder.encode(boardFilesDTO.getOriName(), "UTF-8");
		String fileName = boardFilesDTO.getFileName();
		String downName = fileName.substring(fileName.lastIndexOf("-")+1);
		//response header 설정
		response.setHeader("Content-Disposition", "attachment;fileName=\""+downName+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		//파일을 읽어서 Client로 전송
		FileInputStream fi = new FileInputStream(file);
		OutputStream os = response.getOutputStream();
		
		FileCopyUtils.copy(fi, os);	//파일을 읽고 아웃풋으로 내보냄
		
		//자원 해제
		os.close();
		fi.close();
		
	
	}
}
