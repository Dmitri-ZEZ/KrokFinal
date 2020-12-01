package com.company.documents.totalQuanityProduct;


import java.util.Objects;

public class TotalQuantityProduct {
    private int idProduct;
    private int totalQuantityProduct;

    public TotalQuantityProduct(int idProduct,int totalQuantityProduct){
        this.idProduct = idProduct;
        this.totalQuantityProduct = totalQuantityProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public void setTotalQuantityProduct(int totalQuantityProduct) {
        this.totalQuantityProduct = totalQuantityProduct;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public int getTotalQuantityProduct() {
        return totalQuantityProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TotalQuantityProduct that = (TotalQuantityProduct) o;
        return idProduct == that.idProduct &&
                totalQuantityProduct == that.totalQuantityProduct;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, totalQuantityProduct);
    }

    @Override
    public String toString() {
        return "idProduct: " + idProduct +
                " | totalQuantityProduct: " + totalQuantityProduct + "\n";
    }
}
