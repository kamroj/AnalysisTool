package com.koguty.spocone.pather;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DateScope {

//	public static void main(String[] args) throws FileNotFoundException {
//		IPather pather = new Pather("C:\\Users\\student4\\Desktop\\MU\\AnalysisTool\\AnalysisTool\\reporter-dane");
//		List<String> pathList = pather.getPatchList();
//
//		String mainPath = pather.getMainAbsolutePath();
//		int mainPathlength = mainPath.length();
//
//		List<String> dateList = new ArrayList<String>();
//
//		for (String s : pathList) {
//			dateList.add(s.substring(mainPathlength + 1, mainPathlength + 8));
//		}
//		Collections.sort(dateList);
//
//		String scope = "Zakres raportu od " + dateList.get(0) + " do " + dateList.get(dateList.size() - 1);
//		System.out.println(scope);
//	}

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
