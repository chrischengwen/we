package com.sxxy.service.impl;

import java.util.List;

import com.sxxy.dao.DepartmentDAO;
import com.sxxy.dao.impl.DepartmentDAOImpl;
import com.sxxy.po.DepartmentInfo;
import com.sxxy.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentDAO dao=new DepartmentDAOImpl();
	public boolean add(DepartmentInfo deInfo) {
		 
		return dao.add(deInfo);
		
	}

	public boolean delete(int deId) {
		
		return dao.delete(deId);
	
	}

	public List<DepartmentInfo> getList(String deName) {
		
		return dao.getList(deName);
	
	}

	public boolean update(DepartmentInfo deInfo) {
		
		try {
			if(deInfo!=null){
				if(deInfo.getDepartmentId()!=0){
					//查询数据库中的内容
					DepartmentInfo de = dao.getDepartment(deInfo.getDepartmentId());
					de.setDepartmentName(deInfo.getDepartmentName());
					de.setDepartmentDesc(deInfo.getDepartmentDesc());
					System.out.println("执行修改操作");
					return dao.update(de);
				}
				
			}else{
				System.out.println("没有执行修改");
			}
	
		} catch (Exception e) {
			e.printStackTrace();// 打印异常信息
		}
		return false;
			
		
	}

	public DepartmentInfo getDepartment(int deId) {
		
		try {
			if(deId>0){
				
				System.out.println("执行ID查询操作");
				return dao.getDepartment(deId);
				
			}
			else{
				System.out.println("没有执行ID查询");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
		
	}

}
