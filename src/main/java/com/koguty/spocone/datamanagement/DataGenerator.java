package com.koguty.spocone.datamanagement;

import com.koguty.spocone.analyzing.DataReceiver;

/**
 * @author Kamil Rojek
 */
public class DataGenerator {
    private IDataGenerator generator;

    public DataGenerator(IDataGenerator generator) {
        this.generator = generator;
    }

    public void generateEmployeeRaport() {
        generator.generateEmployeeRaport();
    }

    public void generateProjectRaport() {
        generator.generateProjectRaport();
    }
}
