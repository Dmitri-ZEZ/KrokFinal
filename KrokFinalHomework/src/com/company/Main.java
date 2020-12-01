package com.company;

import com.company.documents.AverageSalesDocument;
import com.company.documents.Document;
import com.company.documents.DocumentFactory;
import com.company.documents.sales.SalesDocument;
import com.company.documents.totalQuanityProduct.TotalQuantityProductDocument;
import com.company.documents.TypeDocument;
import com.company.documents.products.ProductsDocument;
import com.company.documents.productsInStock.ProductsInStockDocument;
import com.company.documents.sellers.SellersDocument;

import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        //Создание объектов через вызов фабричного метода
        ProductsDocument productsDocument = DocumentFactory.getProductsDocument("XmlInput/Products.xml");
        System.out.println(productsDocument);

        SellersDocument sellersDocument = DocumentFactory.getSellersDocument("XmlInput/Sellers.xml");
        System.out.println(sellersDocument);

        ProductsInStockDocument productsInStockDocument = DocumentFactory.getProductsInStockDocument("XmlInput/ProductsInStock.xml");
        System.out.println(productsInStockDocument);

        SalesDocument salesDocument = DocumentFactory.getSalesDocument("XmlInput/Sales.xml");
        System.out.println(salesDocument);

        //Также можно создать объектого от общего интерфейса
        Document d4 = DocumentFactory.getDocument(TypeDocument.Sales,"XmlInput/Sales.xml");
        d4.printDocument();


        //Получим объект с общим колличеством товара в наличии
        TotalQuantityProductDocument totalQuantityProductDocument = DocumentFactory.getTotalQuantityProductDocument(productsInStockDocument);
        System.out.println(totalQuantityProductDocument);

        //Создадим xml файл с этой ифнормацией (TotalQuantityProduct.xml)
        DocumentFactory.createFileTotalQuantityProductDocument(totalQuantityProductDocument);

        //Получим объект со средним колличеством проданных товров
        AverageSalesDocument averageSalesDocument = DocumentFactory.averageSalesDocument(salesDocument);
        System.out.println(averageSalesDocument);

        //Создадим xml файл с этой ифнормацией (AverageSales.xml)
        DocumentFactory.createFileAverageSalesDocument(averageSalesDocument);
    }

}
