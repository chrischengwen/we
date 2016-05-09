package com.sxxy.dao;

import java.util.List;

import com.sxxy.po.CustomerCareInfo;
import com.sxxy.po.CustomerInfo;
import com.sxxy.po.LinkRecordInfo;
import com.sxxy.po.NoticeInfo;

public interface WorkDAO {
	
	/**
	 * 通过日期查询客户是否过生日
	 * @return 返回一个List
	 */
	public List<CustomerInfo>  getAllList(int addTime  ) ;
	
	/**
	 * 获取所有在公告时间范围内的有效公告
	 * @return  List<NoticeInfo>
	 */
	public List<NoticeInfo> getNotice();
	
	/**
	 * 获取一段时间内要联系的人
	 * @return  List<NoticeInfo>
	 */
	public List<LinkRecordInfo> getLinkMan(int addTime);
	
	/**
	 * 获取一段时间内的关怀
	 * @return  List<NoticeInfo>
	 */
	public List<CustomerCareInfo> getCustomerCare(int addTime);
}
