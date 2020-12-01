package com.company.documents.sales;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

public class Sale {
    private int idSale;
    private int idSeller;
    private int idProduct;
    private int quantitySold;
    @JacksonXmlElementWrapper(useWrapping = false)
    private DateOfSale dateOfSale;

    public int getIdSeller() {
        return idSeller;
    }

    public DateOfSale getDateOfSale() {
        return dateOfSale;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public int getIdSale() {
        return idSale;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    @Override
    public String toString() {
        return "idSale: " + idSale +
                " | idSeller: " + idSeller +
                " | idProduct: " + idProduct +
                " | quantitySold: " + quantitySold +
                " | dateOfSale: " + dateOfSale + "\n";
    }
}
