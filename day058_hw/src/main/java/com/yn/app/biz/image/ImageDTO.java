package com.yn.app.biz.image;

import org.springframework.web.multipart.MultipartFile;

public class ImageDTO {
	private int imageid;
	private String path;
	private int bid;
	private MultipartFile file;
	public int getImageid() {
		return imageid;
	}
	public void setImageid(int imageid) {
		this.imageid = imageid;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "ImageDTO [imageid=" + imageid + ", path=" + path + ", bid=" + bid + ", file=" + file + "]";
	}

	

}
