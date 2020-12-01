package com.company.documents.products;

import com.company.documents.Document;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;


import java.io.*;
import java.util.ArrayList;

public class ProductsDocument  implements Document {
    @Override
    public void printDocument() {
        System.out.println(product);
    }

    @JacksonXmlElementWrapper(useWrapping = false)
    private ArrayList<Product> product = new ArrayList<>();

    public ArrayList<Product> getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return  "" + product;
    }

}