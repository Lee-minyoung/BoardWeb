package com.yedam.vo.copy;

import java.util.Date;

import lombok.Data;

@Data
public class ReplyVO {
	private int replyNo;
	private String reply;
	private String replyer;
	private int boardNo;
	private Date replyDate;
	
}
