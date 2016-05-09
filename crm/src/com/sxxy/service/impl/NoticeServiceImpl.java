package com.sxxy.service.impl;

import java.util.List;

import com.sxxy.dao.NoticeDAO;
import com.sxxy.dao.impl.NoticeDaoImpl;
import com.sxxy.po.NoticeInfo;
import com.sxxy.service.NoticeService;

public class NoticeServiceImpl  implements NoticeService{

	NoticeDAO dao = new	NoticeDaoImpl();
	public boolean add(NoticeInfo noticeInfo) {
		// TODO Auto-generated method stub
		return dao.add(noticeInfo);
	}

	public boolean delete(int noticeId) {
		// TODO Auto-generated method stub
		return dao.delete(noticeId);
	}

	public List<NoticeInfo> query(String noticeInput, String queryType) {
		// TODO Auto-generated method stub
		return dao.query(noticeInput, queryType);
	}

	public boolean update(NoticeInfo noticeInfo) {
		// TODO Auto-generated method stub
		return dao.update(noticeInfo);
	}

}
