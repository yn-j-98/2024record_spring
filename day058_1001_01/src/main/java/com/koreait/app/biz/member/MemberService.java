package com.koreait.app.biz.member;

import java.util.List;

public interface MemberService {
	List<MemberDTO> SelectAll(MemberDTO memberDTO);
	MemberDTO SelectOne(MemberDTO memberDTO);
	boolean insert(MemberDTO memberDTO);
	boolean update(MemberDTO memberDTO);
	boolean delete(MemberDTO memberDTO);
}

