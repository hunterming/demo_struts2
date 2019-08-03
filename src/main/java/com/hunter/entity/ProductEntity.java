package com.hunter.entity;

import java.io.Serializable;

/**
 * Created by hunter on 2018/6/3.
 */
public class ProductEntity implements Serializable {
    private int productid;
    private String productname;
    private double productprice;
    private int productnum;

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public double getProductprice() {
        return productprice;
    }

    public void setProductprice(double productprice) {
        this.productprice = productprice;
    }

    public int getProductnum() {
        return productnum;
    }

    public void setProductnum(int productnum) {
        this.productnum = productnum;
    }
}
