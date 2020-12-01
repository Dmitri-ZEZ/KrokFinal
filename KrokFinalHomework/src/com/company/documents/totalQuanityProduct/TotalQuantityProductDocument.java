package com.company.documents.totalQuanityProduct;

import com.company.documents.productsInStock.ProductInStock;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.ArrayList;
import java.util.List;

public class TotalQuantityProductDocument {
    private List<TotalQuantityProduct> productInStockList = new ArrayList<>();

    public List<TotalQuantityProduct> getTotalQuantityProductList() {
        return productInStockList;
    }

    public void setProductInStockList(List<TotalQuantityProduct> productInStockList) {
        this.productInStockList = productInStockList;
    }

    @Override
    public String toString() {
        return "" + productInStockList.toString();
    }
}
