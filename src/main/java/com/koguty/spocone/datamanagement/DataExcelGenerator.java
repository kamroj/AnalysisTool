package com.koguty.spocone.datamanagement;

import com.koguty.spocone.analyzing.DataReceiver;

/**
 * @author Kamil Rojek
 */
public class DataExcelGenerator implements IDataGenerator {
    private DataReceiver dataReceiver;

    public DataExcelGenerator(DataReceiver dataReceiver) {
        this.dataReceiver = dataReceiver;
    }

    @Override
    public void generateEmployeeRaport() {
        //todo
    }

    @Override
    public void generateProjectRaport() {
        //todo
    }
}
