package com.k214111950.model;

import java.io.Serializable;

public class Product implements Serializable {

    int productCode;

    String productName;

    double productPrice;

    int productThumb;

    String productDescription;

    public Product(int productCode, String productName, double productPrice, int productThumb, String productDescription) {
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productThumb = productThumb;
        this.productDescription = productDescription;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductThumb() {
        return productThumb;
    }

    public void setProductThumb(int productThumb) {
        this.productThumb = productThumb;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}
