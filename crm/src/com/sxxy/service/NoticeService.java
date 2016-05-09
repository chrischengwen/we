package com.sxxy.service;

import java.util.List;

import com.sxxy.po.NoticeInfo;

public interface NoticeService {

	/**
	 * 查询公告信息
	 * @param NoticeInfo
	 * @return 公告信息
	 */
	public List<NoticeInfo> query(String noticeInput , String queryType);
	
	/**
	 * 添加公告信息
	 * @param noticeInfo
	 * @return
	 */
	public boolean add(NoticeInfo noticeInfo);
	
	/**
	 * 删除公告信息
	 * @param noticeId
	 * @return
	 */
	public	boolean delete(int noticeId);
	
	/**
	 * 修改公告信息
	 * @param noticeId
	 * @return
	 */
	public	boolean update(NoticeInfo noticeInfo);
}
