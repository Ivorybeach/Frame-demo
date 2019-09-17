package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sun.org.apache.regexp.internal.recompile;
import com.test.mapper.RoleMapper;
import com.test.pojo.Role;
import com.test.pojo.RoleParam;
import com.test.service.RoleService;

/** 
* @ClassName: RoleServiceImpl 
* @Description: 
* @author ����ң
* @date 2018��7��12�� ����1:50:25 
*/
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public Role getRoleById(Long id) {
		Role role = roleMapper.getRole(id);
		return role;
	}

	@Override
	public int addRole(Role role) {
		roleMapper.addRole(role);
		return 0;
	}

	@Override
	public List<Role> findRoles(RoleParam roleParam) {
		List<Role> rolelist = roleMapper.findRoles(roleParam);
		return rolelist;
	}

	@Override
	public List<Role> findAll() {
		List<Role> roleList = roleMapper.findAll();
		return roleList;
	}



}
