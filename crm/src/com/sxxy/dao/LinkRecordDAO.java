package com.sxxy.dao;

import java.util.List;

import com.sxxy.po.LinkRecordInfo;

/**
 * 联系记录的实体类
 * @author k48
 *
 */
public interface LinkRecordDAO {
	
	/**
	 * 查询联系记录信息
	 * @param linkrecordInfo
	 * @param 联系记录信息
	 * @return
	 */
	public List<LinkRecordInfo> getWholink(String whoLinkInput ,String queryType);
	
	/**
	 * 添加联系记录
	 * @param linkRecordInfo
	 * @return
	 */
	public boolean add(LinkRecordInfo linkRecordInfo);
	
	/**
	 * 删除联系记录信息
	 * @param recordIdeturn
	 */
	public boolean delete(int recordId);
}
