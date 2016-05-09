package com.sxxy.service;

import java.util.List;

import com.sxxy.po.LinkManInfo;

public interface LinkManService {

	/**
	 * 增加联系人
	 * 
	 * @param Linkman
	 * @return true 成功 false 失败
	 */
	public boolean add(LinkManInfo Linkman);

	/**
	 * 修改联系人
	 * 
	 * @param Linkman
	 * @return true 成功 false 失败
	 */
	public boolean update(LinkManInfo LinkmanInfo);

	/**
	 * 删除联系人
	 * 
	 * @param LinkmanId
	 * @return true 成功 false 失败
	 */
	public boolean delete(int LinkmanId);

	/**
	 * 查询联系人
	 * 
	 * @param LinkmanId
	 * @return true 成功 false失败
	 */
	public List<LinkManInfo> query(String LinkmanInput ,String queryType);
	
	/**
	 * 查询一条联系人
	 * 
	 * @param LinkmanId
	 * @return true 成功 false失败
	 */
	public LinkManInfo getList(int LinkmanId);

	
}
