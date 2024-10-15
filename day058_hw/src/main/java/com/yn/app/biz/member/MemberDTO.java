package com.yn.app.biz.member;

public class MemberDTO {
	private String mid;
	private String password;
	private String name;
	private String role;
	private String condition;
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	@Override
	public String toString() {
		return "MemberDTO [mid=" + mid + ", password=" + password + ", name=" + name + ", role=" + role + ", condition="
				+ condition + "]";
	}
	
	
	
}
