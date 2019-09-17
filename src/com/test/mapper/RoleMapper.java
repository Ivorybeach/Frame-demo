package com.test.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.pojo.Role;
import com.test.pojo.RoleParam;

/**
 * @ClassName: RoleMapper
 * @Description:
 * @author ����ң
 * @date 2018��7��12�� ����12:25:09
 */

public interface RoleMapper {

	// ����id��ȡ��ɫ
	public Role getRole(Long id);

	// �����ɫ
	public int addRole(Role role);

	// ��ȡ�����ɫ
	public List<Role> findRoles(RoleParam roleParam);

	// ��ȡ���н�ɫ
	public List<Role> findAll();
}
