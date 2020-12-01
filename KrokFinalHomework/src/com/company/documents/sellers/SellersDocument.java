package com.company.documents.sellers;

import com.company.documents.Document;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.ArrayList;

public class SellersDocument implements Document {
    @JacksonXmlElementWrapper(useWrapping = false)
    private ArrayList<Seller> seller = new ArrayList<>();

    public ArrayList<Seller> getSeller() {
        return seller;
    }

    @Override
    public void printDocument() {
        System.out.println(seller);
    }

    @Override
    public String toString() {
        return ""+seller;
    }
}
