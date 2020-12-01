package com.company.documents.sales;

import com.company.documents.Document;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.ArrayList;

public class SalesDocument implements Document {
    @JacksonXmlElementWrapper(useWrapping = false)
    private ArrayList<Sale> sale = new ArrayList<>();

    public ArrayList<Sale> getSale() {
        return sale;
    }

    @Override
    public void printDocument() {
        System.out.println(sale);
    }

    @Override
    public String toString() {
        return "" + sale;
    }
}
