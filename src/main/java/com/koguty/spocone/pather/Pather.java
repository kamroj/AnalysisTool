package com.koguty.spocone.pather;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Pather {

	private List<String> patchList;
	
	public Pather(String entryPath) {
		this.patchList = filePathfinder(entryPath);
	}
	
	
	private List<String> filePathfinder(String path) {
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		List<String> list = new ArrayList<String>();
		
		for (File file : listOfFiles) {
			if (file.isDirectory()) {
				list.addAll(filePathfinder(file.getAbsolutePath()));
			} else{
				if (file.getAbsolutePath().toString().endsWith(".xls")) {
					list.add(file.getAbsolutePath());
				}
			}
		}
		return list;
	}


	public List<String> getPatchList() {
		return patchList;
	}
}
