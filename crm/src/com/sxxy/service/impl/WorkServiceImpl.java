package com.sxxy.service.impl;

import java.util.List;

import com.sxxy.dao.WorkDAO;
import com.sxxy.dao.impl.WorkDAOImpl;
import com.sxxy.po.CustomerCareInfo;
import com.sxxy.po.CustomerInfo;
import com.sxxy.po.LinkRecordInfo;
import com.sxxy.po.NoticeInfo;
import com.sxxy.service.WorkService;

public class WorkServiceImpl  implements WorkService {

	WorkDAO   dao = new  WorkDAOImpl();
	
	public List<CustomerInfo> getAllList(  int  addTime) {
		// 生日提示
		return dao.getAllList(addTime);
	}

	public List<CustomerCareInfo> getCustomerCare(int addTime) {
		// 关怀提醒
		return dao.getCustomerCare(addTime);
	}

	public List<LinkRecordInfo> getLinkMan(int  addTime) {
		// 联系提醒
		return dao.getLinkMan( addTime);
	}

	public List<NoticeInfo> getNotice() {
		// 有效公告
		return dao.getNotice();
	}

	
}
