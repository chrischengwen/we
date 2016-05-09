package com.sxxy.service.impl;

import java.util.List;

import com.sxxy.dao.LinkRecordDAO;
import com.sxxy.dao.impl.LinkRecordDAOImpl;
import com.sxxy.po.LinkRecordInfo;
import com.sxxy.service.LinkRecordService;

public class LinkRecordServiceImpl implements LinkRecordService{

	private	LinkRecordDAO dao = new LinkRecordDAOImpl();
	public boolean add(LinkRecordInfo linkRecordInfo) {
		if (linkRecordInfo != null) {

			if (linkRecordInfo.getCustomerId() != 0) {

				return dao.add(linkRecordInfo);
			}
		}

		return false;
	}


	public boolean delete(int recordId) {
		try {

			if (recordId != 0 ) {

				return dao.delete(recordId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public List<LinkRecordInfo> getWholink(String whoLinkInput, String queryType) {
		return dao.getWholink(whoLinkInput,queryType);
	}


}

