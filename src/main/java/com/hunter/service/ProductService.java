package com.hunter.service;

import com.hunter.dao.ProductDAOImpl;
import com.hunter.entity.ProductEntity;

import java.util.List;

/**
 * Created by hunter on 2018/6/3.
 */
public class ProductService {
    private ProductDAOImpl dao=new ProductDAOImpl();
    //查询商品信息（此demo没有用到这个方法）
    public ProductEntity query_by_id(int a){
        String sql="select * from product where productid=?";
        List<ProductEntity> list=dao.executeQuery(sql,new Object[]{a});
        if (list.size()>0){
            return list.get(0);
        }else return null;
    }
    //显示商品信息
    public List<ProductEntity> showall(){
        String sql="select * from product";
        return dao.executeQuery(sql,null);
    }
    //删除商品信息
    public int delete_by_id(ProductEntity a){
        String sql="delete from product where productid=?";
        Object[] objects=new Object[]{
                a.getProductid()
        };
        return dao.executeUpdate(sql,objects);
    }
    //修改商品信息
    public int update_by_id(ProductEntity p){
        String sql="update product set productname=?,productprice=?,productnum=? where productid=?";
        Object[] objects=new Object[]{
                p.getProductname(),
                p.getProductprice(),
                p.getProductnum(),
                p.getProductid()
        };
        return dao.executeUpdate(sql,objects);
    }
    //增加商品信息
    public int add_product(ProductEntity p){
        String sql="insert into product (productname,productprice,productnum) values(?,?,?)";
        Object[] objects=new Object[]{
                p.getProductname(),
                p.getProductprice(),
                p.getProductnum()
        };
        return dao.executeUpdate(sql,objects);
    }
}
