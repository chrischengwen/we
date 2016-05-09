package com.sxxy.service.impl;

import java.util.List;

import com.sxxy.dao.UserDAO;
import com.sxxy.dao.impl.UserDAOImpl;
import com.sxxy.po.UserInfo;
import com.sxxy.service.UserService;

public class UserServiceImpl implements UserService {
	
	//数据访问DAO
	UserDAO dao= new UserDAOImpl();
	
	public boolean add(UserInfo usInfo) {
		
try {
			
			if(usInfo!=null ){
				if(usInfo.getUserName()!=null && !"".equals(usInfo.getUserName().trim())){
					System.out.println("执行添加操作");
				return dao.add(usInfo);
				}else{
					System.out.println("没有执行添加");
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(int usId) {
		try {

			if (usId>0) {

					System.out.println("执行删除操作");
					return dao.delete(usId);
				}else{
					System.out.println("没有执行删除");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return false;
	}

	public List<UserInfo> getList(String userInput, String queryType) {
		System.out.println("执行查询操作");
		return dao.getList(userInput,queryType);
	}

	public UserInfo getUser(int usId) {
		try {
			if(usId>0){
				
				System.out.println("执行ID查询操作");
				return dao.getUser(usId);
				
			}
			else{
				System.out.println("没有执行ID查询");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public boolean update(UserInfo usInfo) {
		try {
			if(usInfo!=null){
				if(usInfo.getUserId()!=0){
					//查询数据库中的内容
					UserInfo user1 = dao.getUser(usInfo.getUserId());
					
					//user1.setUserName(usInfo.getUserName());
					user1.setUserAge(usInfo.getUserAge());
					user1.setUserSex(usInfo.getUserSex());
					user1.setDepartmentId(usInfo.getDepartmentId());
					user1.setUserNation(usInfo.getUserNation());
					user1.setIsMarried(usInfo.getIsMarried());
					user1.setUserMobile(usInfo.getUserMobile());
					user1.setUserTel(usInfo.getUserTel());
					user1.setUserIntest(usInfo.getUserIntest());
					user1.setUserBankcard(usInfo.getUserBankcard());
					user1.setUserAddress(usInfo.getUserAddress());
					user1.setUserIdnum(usInfo.getUserIdnum());
					user1.setUserChangetime(usInfo.getUserChangetime());
					user1.setUserEmail(usInfo.getUserEmail());
					//user1.setRoleId(usInfo.getRoleId());
					user1.setUserChangeman(usInfo.getUserChangeman());
					//user1.setUserAddman(usInfo.getUserAddman());

					System.out.println("执行修改操作");
					return dao.update(user1);
				}
				
			}else{
				System.out.println("没有执行修改");
			}
	
		} catch (Exception e) {
			e.printStackTrace();// 打印异常信息
		}
		return false;
	}

}
