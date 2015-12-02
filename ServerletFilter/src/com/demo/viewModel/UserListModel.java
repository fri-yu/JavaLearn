package com.demo.viewModel;

import java.util.Dictionary;
import java.util.List;
import java.util.Map;

import com.demo.domain.User;

public class UserListModel extends VModelBase {
	private List<User> uList;

	public List<User> getuList() {
		return uList;
	}

	public void setuList(List<User> uList) {
		this.uList = uList;
	}
}
