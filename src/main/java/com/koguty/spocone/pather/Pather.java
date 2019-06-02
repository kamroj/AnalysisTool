package com.koguty.spocone.pather;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pather implements IPather {
    private List<String> patchList;
    private String absolutPath;

    public Pather(String entryPath) throws FileNotFoundException {
        this.patchList = filePathfinder(entryPath);
    }

    private List<String> filePathfinder(String path) throws FileNotFoundException {
        File folder = new File(path);
        if (absolutPath == null) absolutPath = folder.getAbsolutePath();
        File[] listOfFiles = folder.listFiles();
        return generateListOfFiles(listOfFiles);
    }

    private List<String> generateListOfFiles(File[] listOfFiles) throws FileNotFoundException {
        if(listOfFiles == null)
            throw new FileNotFoundException("Have not found any .xls files!");

        List<String> list = new ArrayList<>();
        for (File file : listOfFiles) {
            if (file.isDirectory()) {
                list.addAll(filePathfinder(file.getAbsolutePath()));
            } else {
                if (file.getAbsolutePath().endsWith(".xls")) {
                    System.out.println(file.getAbsolutePath());
                    list.add(file.getAbsolutePath());
                }
            }
        }
        return list;
    }
    
    private String getScope() {
    	DateScope dateScope = new DateScope(patchList, absolutPath);
    	return dateScope.getScope();
    }

    @Override
    public List<String> getPatchList() {
    	System.out.println(getScope());
        return patchList;
    }

}
