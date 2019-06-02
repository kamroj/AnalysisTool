package com.koguty.spocone.datamanagement;

/**
 * @author Kamil Rojek
 */
public class DataGenerator {
    private IDataGenerator generator;

    public DataGenerator(IDataGenerator generator) {
        this.generator = generator;
    }

    public void generateEmployeeAdvancedRaport() {
        generator.generateEmployeeAdvancedRaport();
    }

    public void generateProjectAdvancedRaport() {
        generator.generateProjectAdvancedRaport();
    }
}
