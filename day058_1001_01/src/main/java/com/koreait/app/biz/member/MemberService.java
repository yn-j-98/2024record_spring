package com.koreait.app.biz.member;

import java.util.List;

public interface MemberService {
<<<<<<< HEAD
	List<MemberDTO> selectAll(MemberDTO memberDTO);
	MemberDTO selectOne(MemberDTO memberDTO);
	boolean insert(MemberDTO memberDTO);
	boolean update(MemberDTO memberDTO);
	boolean delete(MemberDTO memberDTO);
}
// Service의 메서드가 DAO의 메서드 시그니쳐와 동일해야함!!!!!
=======
	List<MemberDTO> SelectAll(MemberDTO memberDTO);
	MemberDTO SelectOne(MemberDTO memberDTO);
	boolean insert(MemberDTO memberDTO);
	boolean update(MemberDTO memberDTO);
	boolean delete(MemberDTO memberDTO);
}

>>>>>>> branch 'main' of https://github.com/yn-j-98/2024record_spring.git
