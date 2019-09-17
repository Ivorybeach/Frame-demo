package com.test.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.test.pojo.Role;
import com.test.pojo.RoleParam;

/**
 * @ClassName: RoleService
 * @Description:
 * @author ����ң
 * @date 2018��7��12�� ����1:49:27
 */
@Service
public interface RoleService {

	// ����id��ȡ����
	public Role getRoleById(Long id);

	// ����role
	public int addRole(Role role);

	// ��ȡ���role
	public List<Role> findRoles(RoleParam roleParam);

	// ��ȡ����role
	public List<Role> findAll();
}
