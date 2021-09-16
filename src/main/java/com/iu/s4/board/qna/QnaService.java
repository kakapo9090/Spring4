package com.iu.s4.board.qna;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.s4.board.BoardDTO;
import com.iu.s4.board.BoardFilesDTO;
import com.iu.s4.board.BoardService;
import com.iu.s4.util.FileManager;
import com.iu.s4.util.Pager;
@Service
public class QnaService implements BoardService {
	@Autowired
	private QnaDAO qnaDAO;
	@Autowired
	private ServletContext servletContext;
	@Autowired
	private FileManager fileManager;
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		Long totalCount = qnaDAO.getCount(pager);
		pager.makeNum(totalCount);
		pager.makeRow();
		return qnaDAO.getList(pager);
	}

	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		qnaDAO.setHitUpdate(boardDTO);
		return qnaDAO.getSelect(boardDTO);
	}
	//게시물 이미지 출력 09-15
	public List<BoardFilesDTO> getFiles(BoardDTO boardDTO)throws Exception{
		return qnaDAO.getFiles(boardDTO);
	}
	
	// QNA 글쓰기 등록
	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile[] files) throws Exception {
		//1. 어느 폴더 /resources/upload/qna/
		String realPath = this.servletContext.getRealPath("/resources/upload/qna/");
		System.out.println(realPath);
		//파일객체(경로명)
		File file = new File(realPath);
		//시퀀스를 사용한 쿼리의 결과값의 넘(시퀀스)번호를 가져와야함
		System.out.println("Before Num : "+boardDTO.getNum());	// null값 출력
		int result = qnaDAO.setInsert(boardDTO); 
		
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
			
			result = qnaDAO.setFile(boardFilesDTO);
		}
		
		
		
		return result;
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int setReply(QnaDTO qnaDTO) throws Exception{
		//1. 부모의 정보(num) 조회
		System.out.println("Qna서비스Num : " + qnaDTO.getNum());
		QnaDTO parent = (QnaDTO)qnaDAO.getSelect(qnaDTO);	//강제 형변환
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep()+1);
		qnaDTO.setDepth(parent.getDepth()+1);
		
		
		//2. update
		int result = qnaDAO.setReplyUpdate(parent);
		
		
		//3. insert
		result = qnaDAO.setReply(qnaDTO);
		
		
		return result;
	}
}
