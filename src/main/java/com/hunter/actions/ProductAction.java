package com.hunter.actions;

import com.hunter.entity.ProductEntity;
import com.hunter.service.ProductService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.interceptor.RequestAware;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by hunter on 2018/6/3.
 */
@ParentPackage("struts-default")
@Namespace("/")
@Results({
        @Result(name = "show",location = "/view/show.jsp"),
        @Result(name = "update",location = "showall",type = "chain"),
        @Result(name = "add",location = "showall",type = "chain"),
        @Result(name = "update",location = "showall",type = "chain")

})
public class ProductAction extends ActionSupport implements RequestAware {
   private ProductService service=new ProductService();
   private Map<String, Object> request;
   private List<ProductEntity> list_product=new ArrayList<>();
   private ProductEntity product;
   private int productid;
   private String productname;
   private Double productprice;
   private int productnum;

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Double getProductprice() {
        return productprice;
    }

    public void setProductprice(Double productprice) {
        this.productprice = productprice;
    }

    public int getProductnum() {
        return productnum;
    }

    public void setProductnum(int productnum) {
        this.productnum = productnum;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public List<ProductEntity> getList_product() {
        return list_product;
    }

    public void setList_product(List<ProductEntity> list_product) {
        this.list_product = list_product;
    }



    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    @Override
    public void setRequest(Map<String, Object> request) {
         this.request=request;
    }
    @Action("showall")
    public String showall(){
        List<ProductEntity> list=service.showall();
        list_product= list;

        /*request.put("Product",list);*/
        return "show";
    }
    @Action("delete")
    public String delete_product(){
        ProductEntity product=new ProductEntity();
        System.out.println(productid);
        product.setProductid(productid);
        service.delete_by_id(product);
        return "update";
    }
    @Action("add")
    public String add_product(){
        ProductEntity product=new ProductEntity();
        product.setProductname(productname);
        product.setProductprice(productprice);
        product.setProductnum(productnum);
        service.add_product(product);
        return "add";
    }
    @Action("update")
    public String update_product(){
        ProductEntity product=new ProductEntity();
        product.setProductname(productname);
        product.setProductprice(productprice);
        product.setProductnum(productnum);
        product.setProductid(productid);
        service.update_by_id(product);
        return "update";
    }


}
