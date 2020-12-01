package com.company.documents;

import com.company.documents.products.ProductsDocument;
import com.company.documents.productsInStock.ProductInStock;
import com.company.documents.productsInStock.ProductsInStockDocument;
import com.company.documents.sales.Sale;
import com.company.documents.sales.SalesDocument;
import com.company.documents.sellers.SellersDocument;
import com.company.documents.totalQuanityProduct.TotalQuantityProductDocument;
import com.company.documents.totalQuanityProduct.TotalQuantityProduct;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;


public class DocumentFactory {
    public static Document getDocument(TypeDocument typeDocument, String path) throws IOException {
        String xml = getXml(path);
        XmlMapper xmlMapper = new XmlMapper();
        switch (typeDocument) {
            case Products:
                return xmlMapper.readValue(xml, ProductsDocument.class);
            case Sellers:
                return xmlMapper.readValue(xml, SellersDocument.class);
            case ProductsInStock:
                return xmlMapper.readValue(xml, ProductsInStockDocument.class);
            case Sales:
                return xmlMapper.readValue(xml, SalesDocument.class);
            default:
                throw new IllegalArgumentException("Задан неверный тип документа");
        }
    }

    public static ProductsDocument getProductsDocument(String path) throws IOException{
        String xml = getXml(path);
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(xml, ProductsDocument.class);
    }
    public static SellersDocument getSellersDocument(String path) throws IOException{
        String xml = getXml(path);
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(xml, SellersDocument.class);
    }
    public static ProductsInStockDocument getProductsInStockDocument(String path) throws IOException{
        String xml = getXml(path);
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(xml, ProductsInStockDocument.class);
    }
    public static SalesDocument getSalesDocument(String path) throws IOException{
        String xml = getXml(path);
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(xml, SalesDocument.class);
    }


    public static String getXml(String path) throws IOException {
        File file = new File(path);
        String xml = inputStreamToString(new FileInputStream(file));
        return xml;
    }


    public static String inputStreamToString (InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }

    public static long getTotalQuantityProduct(ProductsInStockDocument productsInStockDocument,int idProduct){
        return productsInStockDocument.getProductInStock().stream().
                filter(i-> i.getIdProduct()==idProduct).
                mapToInt(ProductInStock::getQuantityProduct).
                sum();
    }

    public static TotalQuantityProductDocument getTotalQuantityProductDocument(ProductsInStockDocument productsInStockDocument) {
        TotalQuantityProductDocument document = new TotalQuantityProductDocument();

        for (ProductInStock p : productsInStockDocument.getProductInStock()) {
            document.getTotalQuantityProductList().add(new TotalQuantityProduct(p.getIdProduct(), (int) getTotalQuantityProduct(productsInStockDocument,p.getIdProduct())));
        }
        document.setProductInStockList(document.getTotalQuantityProductList().stream().distinct().collect(Collectors.toList()));
        return document;
    }

    public static void createFileTotalQuantityProductDocument(TotalQuantityProductDocument document) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File("TotalQuantityProduct.xml"), document);
    }

    public static AverageSalesDocument averageSalesDocument(SalesDocument salesDocument){
        int products = 0;
        int days = 0;

        long salesDay = Arrays.stream(salesDocument.getSale().stream().map(Sale::getDateOfSale).toArray()).distinct().count();

        long salesProduct = salesDocument.getSale().stream().mapToInt(Sale::getQuantitySold).sum();

        AverageSalesDocument document = new AverageSalesDocument((double) ((double)salesProduct/salesDay));

        return document;
    }

    public static void createFileAverageSalesDocument(AverageSalesDocument document) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File("AverageSales.xml"), document);
    }

}
