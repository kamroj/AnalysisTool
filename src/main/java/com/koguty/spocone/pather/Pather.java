package com.koguty.spocone.pather;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Pather implements IPather {

	private List<String> patchList;
	
	public Pather(String entryPath) {
		this.patchList = filePathfinder(entryPath);
	}
	
	
	private List<String> filePathfinder(String path) {
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		List<String> list = new ArrayList<>();

		for (File file : listOfFiles) {
			if (file.isDirectory()) {
				list.addAll(filePathfinder(file.getAbsolutePath()));
			} else{
				if (file.getAbsolutePath().endsWith(".xls")) {
					System.out.println(file.getAbsolutePath());
					list.add(file.getAbsolutePath());
				}
			}
		}
		return list;
	}

	@Override
	public List<String> getPatchList() {
		return patchList;
	}
}
