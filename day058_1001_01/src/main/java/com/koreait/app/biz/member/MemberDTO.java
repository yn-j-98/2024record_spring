package com.koreait.app.biz.member;

import org.springframework.stereotype.Component;

@Component("memberDTO") 
public class MemberDTO {
	private int member_num;
	private String member_id;
	private String member_password;
	private String member_date;
	private boolean member_role;
	
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
	public String getMember_date() {
		return member_date;
	}
	public void setMember_date(String member_date) {
		this.member_date = member_date;
	}
	public boolean isMember_role() {
		return member_role;
	}
	public void setMember_role(boolean member_role) {
		this.member_role = member_role;
	}
	@Override
	public String toString() {
		return "MemberDTO [member_num=" + member_num + ", member_id=" + member_id + ", member_password="
				+ member_password + ", member_date=" + member_date + ", member_role=" + member_role + "]";
	}
}
