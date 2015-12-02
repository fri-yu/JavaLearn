package com.demo.viewModel;

import java.util.List;

import com.demo.domain.Paper;

public class PaperListModel extends VModelBase {
	private List<Paper> pList;

	public List<Paper> getpList() {
		return pList;
	}

	public void setpList(List<Paper> uList) {
		this.pList = uList;
	}

}
