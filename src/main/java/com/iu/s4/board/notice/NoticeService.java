package com.iu.s4.board.notice;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s4.board.BoardDTO;
import com.iu.s4.board.BoardFilesDTO;
import com.iu.s4.board.BoardService;
import com.iu.s4.util.FileManager;
import com.iu.s4.util.Pager;
@Service
public class NoticeService implements BoardService {
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private FileManager fileManager;
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		Long totalCount= noticeDAO.getCount(pager);
		pager.makeNum(totalCount);
		pager.makeRow();
		
		return noticeDAO.getList(pager);
	}
	
	//게시물 조회시 글 하나를 출력
	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		
		//List<BoardFilesDTO> ar = noticeDAO.getFiles(boardDTO);
		
		noticeDAO.setHitUpdate(boardDTO);
		return noticeDAO.getSelect(boardDTO);
	}
	// 게시물 이미지 출력 09-15 파일명가져오기?
	public List<BoardFilesDTO> getFiles(BoardDTO boardDTO)throws Exception{
		return noticeDAO.getFiles(boardDTO);
	}
	
	
	// NOTICE 글쓰기 등록
	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		//1. 어느 폴더 /resources/upload/notice/
		String realPath = this.servletContext.getRealPath("/resources/upload/notice/");
		System.out.println(realPath);
		//파일객체(경로명)
		File file = new File(realPath);
		//시퀀스를 사용한 쿼리의 결과값의 넘(시퀀스)번호를 가져와야함
		System.out.println("Before Num : "+boardDTO.getNum());	// null값 출력
		int result = noticeDAO.setInsert(boardDTO); 
		
		
		//시퀀스 번호는 글을 쓸 때마다 1씩 증가...
		//작성글은 그 테이블에서 가장 큰 번호값을 가짐 -> 쿼리문 수정
		
		
		System.out.println("After Num : "+ boardDTO.getNum());	//selectKey 쿼리문을 통한 결과key값
		
		//유틸 FileManager클래스의 fileSave 메소드 호출
		for(MultipartFile multipartFile:files) {
			String fileName = fileManager.fileSave(multipartFile, file);
			System.out.println(fileName);
			BoardFilesDTO boardFilesDTO = new BoardFilesDTO();
			boardFilesDTO.setFileName(fileName);
			boardFilesDTO.setOriName(multipartFile.getOriginalFilename());
			boardFilesDTO.setNum(boardDTO.getNum());
			
			result = noticeDAO.setFile(boardFilesDTO);
		}
		
		
		//3. 파일 저장
		return result; //noticeDAO.setInsert(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		//Files Table에서 삭제할 파일명들 조회
		//해당 글번호의 파일명들을 불러오기
		List<BoardFilesDTO> ar = noticeDAO.getFiles(boardDTO);
		
		//어느 폴더에서?
		String realPath = servletContext.getRealPath("resources/upload/notice/");
		
		//파일명들 순차로 꺼내서 삭제
		for(BoardFilesDTO bDto: ar) {
			File file = new File(realPath, bDto.getFileName());
			fileManager.fileDelete(file);			
		}
		
		
		// DB삭제
		noticeDAO.setDelete(boardDTO);
		
		return noticeDAO.setDelete(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
