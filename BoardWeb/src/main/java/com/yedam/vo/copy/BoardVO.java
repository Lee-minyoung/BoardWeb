package com.yedam.vo.copy;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardVO { // tbl_board
	private int boardNo; // board_no
	private String title;
	private String content;
	private String writer;
	private Date writeDate;
	private int viewCnt;
	private String img;

//	public BoardVO() {
//		super();
//		this.boardNo = boardNo;
//		this.title = title;
//		this.content = content;
//		this.writer = writer;
//		this.writeDate = writeDate;
//		this.viewCnt = viewCnt;
//		
//	}
}
