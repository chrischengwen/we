package com.sxxy.service.impl;

import java.util.List;

import com.sxxy.dao.LinkManDAO;
import com.sxxy.dao.impl.LinkManDAOImpl;
import com.sxxy.po.LinkManInfo;
import com.sxxy.service.LinkManService;

public class LinkManServiceImpl implements LinkManService {

	LinkManDAO dao= new LinkManDAOImpl();
	public boolean add(LinkManInfo Linkman) {
		// TODO Auto-generated method stub
		return dao.add(Linkman);
	}

	public boolean delete(int LinkmanId) {
		// TODO Auto-generated method stub
		return dao.delete(LinkmanId);
	}

	public LinkManInfo getList(int LinkmanId) {
		// TODO Auto-generated method stub
		return dao.getList(LinkmanId);
	}

	public List<LinkManInfo> query(String LinkmanInput, String queryType) {
		// TODO Auto-generated method stub
		return dao.query(LinkmanInput, queryType);
	}

	public boolean update(LinkManInfo LinkmanInfo) {
	
			LinkManInfo lManInfo		 =	dao.getList(LinkmanInfo.getLinkmanId());
			
		try {
			if(LinkmanInfo!=null){
				if(LinkmanInfo.getLinkmanId()!=0){
					//查询数据库中的内容
				
					lManInfo.setCoustomerId(LinkmanInfo.getCoustomerId());
					lManInfo.setLinkmanSex(LinkmanInfo.getLinkmanSex());
					lManInfo.setLinkmanJob(LinkmanInfo.getLinkmanJob());
					lManInfo.setLinkmanMobile(LinkmanInfo.getLinkmanMobile());
					lManInfo.setLinkmanAge(LinkmanInfo.getLinkmanAge());
					lManInfo.setLinkmanRelation(LinkmanInfo.getLinkmanRelation());

					
					return dao.update(lManInfo);
				}
				
			}else{
				System.out.println("没有执行修改");
			}
	
		} catch (Exception e) {
			e.printStackTrace();// 打印异常信息
		}
		return dao.update(LinkmanInfo);
	}
	
    
}
