package com.hunter.dao;

import java.io.Serializable;
import java.sql.*;
import java.util.List;


public abstract class BaseDAO<T extends Serializable> {
    private String driver = "com.mysql.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/goods";
    private String user = "root";
    private String password = "123456";

    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    /**
     * 打开数据连接
     */
    public Connection OpenConnection()
    {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 设置参数
     * @param ps
     * @param objects
     * @throws SQLException
     */
    public void setPram(PreparedStatement ps,Object[] objects) throws SQLException {
        if(null != objects)
        {
            for (int i = 0;i<objects.length;i++)
            {
                ps.setObject(i+1,objects[i]);
            }
        }
    }

    /**
     *  查询
     * @param sql sql语句
     * @param objects 参数
     * @return 执行是否成功
     */
    public List<T> executeQuery(String sql, Object[] objects)
    {
        OpenConnection();
        try {
            ps = conn.prepareStatement(sql);
            setPram(ps,objects);
            rs = ps.executeQuery();
            return rsToList(rs);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }finally {
            try {
                closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public abstract List<T> rsToList(ResultSet rs) throws SQLException;

    public int executeUpdate(String sql,Object[] objects)
    {
        int flag = -1;
        OpenConnection();
        try {
            ps = conn.prepareStatement(sql);
            setPram(ps,objects);
            flag = ps.executeUpdate();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }finally {
            try {
                closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    /***
     * 关闭数据操作
     * @throws SQLException
     */
    public void closeConnection() throws SQLException {
        if(null != rs)
            rs.close();
        if(null != ps)
            ps.close();
        if(null != conn)
            conn.close();
    }
}
