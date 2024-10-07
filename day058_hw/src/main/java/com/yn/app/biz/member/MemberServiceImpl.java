package com.yn.app.biz.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


// 인터페이스인 MemberService의 구현체(실현체)
@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public List<MemberDTO> SelectAll(MemberDTO memberDTO) {
		return this.memberDAO.SelectAll(memberDTO);
	}

	@Override
	public MemberDTO SelectOne(MemberDTO memberDTO) {
		return this.memberDAO.SelectOne(memberDTO);
	}

	@Override
	public boolean insert(MemberDTO memberDTO) {
		return this.memberDAO.insert(memberDTO);
	}

	@Override
	public boolean update(MemberDTO memberDTO) {
		return this.memberDAO.update(memberDTO);
	}

	@Override
	public boolean delete(MemberDTO memberDTO) {
		return this.memberDAO.delete(memberDTO);
	}

}
