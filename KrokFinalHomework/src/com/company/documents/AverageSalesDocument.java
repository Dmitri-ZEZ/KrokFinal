package com.company.documents;

public class AverageSalesDocument {
    private double average;

    public AverageSalesDocument(double average) {
        this.average = average;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return "average: " + average;
    }
}
