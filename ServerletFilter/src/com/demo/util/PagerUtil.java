package com.demo.util;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class PagerUtil {
	/**
	 * @author 介丽雨 
	 * @param 页码总数
	 * @param 当前页
	 * @param 分页大小
	 * @param 其他的查询参数
	 * @return 分页参数字符串MAP
	 */
	public static Map<String, String> getPagerMap(int pageCount,
			int currentPage, int pageSize, String queryString) {
		
		Map<String, String> pagerMap = new LinkedHashMap<String, String>();
		if (pageCount > 0) {

			pagerMap.put("&pageSize=" + pageSize + queryString, "首页");
			if (pageCount > 5) {
				if (currentPage > 3)
					pagerMap.put("<-", "...");
			}
			if (pageCount >= 5) {
				if (currentPage < 3) {
					pagerMap.put("&pageSize=" + pageSize + "&currentPage=1"
							+ queryString, "1");
					pagerMap.put("&pageSize=" + pageSize + "&currentPage=2"
							+ queryString, "2");
					pagerMap.put("&pageSize=" + pageSize + "&currentPage=3"
							+ queryString, "3");
					pagerMap.put("&pageSize=" + pageSize + "&currentPage=4"
							+ queryString, "4");
					pagerMap.put("&pageSize=" + pageSize + "&currentPage=5"
							+ queryString, "5");
				} else {
					if (currentPage < pageCount - 2) {
						pagerMap.put(

						"&pageSize=" + pageSize + "&currentPage="
								+ (currentPage - 2) + queryString, currentPage
								- 2 + "");
						pagerMap.put(

						"&pageSize=" + pageSize + "&currentPage="
								+ (currentPage - 1) + queryString, currentPage
								- 1 + "");
						pagerMap.put(

						"&pageSize=" + pageSize + "&currentPage="
								+ (currentPage) + queryString, currentPage + "");
						pagerMap.put(

						"&pageSize=" + pageSize + "&currentPage="
								+ (currentPage + 1) + queryString, currentPage
								+ 1 + "");
						pagerMap.put(

						"&pageSize=" + pageSize + "&currentPage="
								+ (currentPage + 2) + queryString, currentPage
								+ 2 + "");
					} else {
						pagerMap.put(

						"&pageSize=" + pageSize + "&currentPage="
								+ (pageCount - 4) + queryString, pageCount - 4
								+ "");
						pagerMap.put(

						"&pageSize=" + pageSize + "&currentPage="
								+ (pageCount - 3) + queryString, pageCount - 3
								+ "");
						pagerMap.put(

						"&pageSize=" + pageSize + "&currentPage="
								+ (pageCount - 2) + queryString, pageCount - 2
								+ "");
						pagerMap.put(

						"&pageSize=" + pageSize + "&currentPage="
								+ (pageCount - 1) + queryString, pageCount - 1
								+ "");
						pagerMap.put(

						"&pageSize=" + pageSize + "&currentPage=" + (pageCount)
								+ queryString, pageCount + "");
					}
				}
			} else {
				for (int i = 0; i < pageCount; i++) {
					pagerMap.put("&pageSize=" + pageSize + "&currentPage="
							+ (i + 1) + queryString, (i + 1) + "");
				}
			}
			if (pageCount > 5) {
				System.out.println(pageCount + "-" + currentPage);
				if (pageCount - currentPage > 2) {
					pagerMap.put("->", "...");
				}
			}
			pagerMap.put("&pageSize=" + pageSize + "&currentPage= " + pageCount
					+ queryString, "尾页");
		}

		return pagerMap;
	}
}
