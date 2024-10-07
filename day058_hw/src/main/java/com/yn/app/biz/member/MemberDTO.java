package com.yn.app.biz.member;

import org.springframework.stereotype.Component;

@Component("memberDTO")
public class MemberDTO {
	private int member_num;
	private String member_id;
	private String member_password;

	
	public int getMember_num() {
		return member_num;
	}
	public void setMember_num(int member_num) {
		this.member_num = member_num;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_password() {
		return member_password;
	}
	public void setMember_password(String member_password) {
		this.member_password = member_password;
	}
	@Override
	public String toString() {
		return "MemberDTO [member_num=" + member_num + ", member_id=" + member_id + ", member_password="
				+ member_password + "]";
	}

	

}
