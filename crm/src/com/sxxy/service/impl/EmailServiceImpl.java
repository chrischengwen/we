package com.sxxy.service.impl;

import java.util.List;

import com.sxxy.dao.EmailDAO;
import com.sxxy.dao.impl.EmailDAOImpl;
import com.sxxy.po.EmailInfo;
import com.sxxy.service.EmailService;

public class EmailServiceImpl implements EmailService{
	
	private EmailDAO dao=new EmailDAOImpl();

	public boolean add(EmailInfo email) {
		// TODO Auto-generated method stub
		return dao.add(email);
	}

	public boolean delete(int emailId) {
		// TODO Auto-generated method stub
		return dao.delete(emailId);
	}

	public List<EmailInfo> getAllEmail(String emailIput, String queryType) {
		// TODO Auto-generated method stub
		return dao.getAllEmail(emailIput, queryType);
	}

	public EmailInfo getEmail(int emailId) {
		// TODO Auto-generated method stub
		return dao.getEmail(emailId);
	}

	public List<EmailInfo> getNoSendAllEmail(String emailIput, String queryType) {
		// TODO Auto-generated method stub
		return dao.getNoSendAllEmail(emailIput, queryType);
	}

	public boolean upadate(EmailInfo eamInfo) {
		// TODO Auto-generated method stub
		return dao.upadate(eamInfo);
	}


}
