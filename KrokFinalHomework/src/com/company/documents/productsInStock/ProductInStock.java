package com.company.documents.productsInStock;

public class ProductInStock {
        private int idSeller;
        private int idProduct;
        private int priceProduct;
        private int quantityProduct;

        public int getIdSeller() {
            return idSeller;
        }

        public int getIdProduct() {
            return idProduct;
        }

        public int getPriceProduct() {
            return priceProduct;
        }

        public int getQuantityProduct() {
            return quantityProduct;
        }

    @Override
    public String toString() {
        return "idSeller: " + idSeller +
                " | idProduct: " + idProduct +
                " | priceProduct: " + priceProduct +
                " | quantityProduct: " + quantityProduct + "\n";
    }
}
