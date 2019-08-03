package com.hunter.dao;

import com.hunter.entity.ProductEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hunter on 2018/6/3.
 */
public class ProductDAOImpl extends BaseDAO<ProductEntity> {
    @Override
    public List<ProductEntity> rsToList(ResultSet rs) throws SQLException {
        List<ProductEntity> list=new ArrayList<>();
        while (rs.next()){
            ProductEntity p=new ProductEntity();
            p.setProductid(rs.getInt("productid"));
            p.setProductname(rs.getString("productname"));
            p.setProductprice(rs.getDouble("productprice"));
            p.setProductnum(rs.getInt("productnum"));
            list.add(p);
        }return list;
    }
}
