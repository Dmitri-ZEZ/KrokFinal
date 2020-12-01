package com.company.documents;

/**
 * Перечисление для определения типа входного документа <br>
 * <b>Products</b> - файл с товарами <br>
 * <b>Sellers</b> - файл с продавцами <br>
 * <b>ProductsInStock</b> - файл с данными по наличию товаров у продавцов <br>
 * <b>Sales</b> - файл с продажами
 */
public enum TypeDocument {
    Products,
    Sellers,
    ProductsInStock,
    Sales
}
