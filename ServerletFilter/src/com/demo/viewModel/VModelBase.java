package com.demo.viewModel;

import java.util.Map;

public class VModelBase {
	private int pageSize;
	private int pageCount;
	private int currentPage;
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public Map<String, String> getPageLinkDic() {
		return pageLinkDic;
	}

	public void setPageLinkDic(Map<String, String> pageLinkDic) {
		this.pageLinkDic = pageLinkDic;
	}

	private Map<String, String> pageLinkDic;
}
