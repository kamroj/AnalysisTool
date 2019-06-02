package com.koguty.spocone.pather;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DateScope {

	private int mainPathlength;
	private List<String> pathList;
	private List<String> dateList;

	public DateScope(List<String> pathList, String absolutPath) {
		this.mainPathlength = absolutPath.length();
		this.pathList = pathList;
		this.dateList = makeDateList();
	}

	private List<String> makeDateList() {
		List<String> dateList = new ArrayList<String>();

		for (String s : pathList) {
			dateList.add(s.substring(mainPathlength + 1, mainPathlength + 8));
		}
		Collections.sort(dateList);
		return dateList;
	}

	public String getScope() {
		return "Zakres raportu od " + dateList.get(0) + " do " + dateList.get(dateList.size() - 1);
	}

}
