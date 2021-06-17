package com.assignments.mvcDesign.dao;

import com.assignments.mvcDesign.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl extends DBConnection implements ProductDao{
    ResultSet rs = null;
    private final Connection conn = getConnection();
    private final String create = "INSERT INTO product (name, description, price, category_id) VALUES (?,?,?,?)";
    private final String getById = "SELECT * FORM product WHERE id = ?";
    private final String getAll = " SELECT * FORM product";
    private final String update = "UPDATE product SET name = ?, description = ?, price = ?, category_id = ?";
    private final String delete = "DELETE FROM product WHERE id = ?";
    @Override
    public void create(Product product) {
        try {
            PreparedStatement ps = conn.prepareStatement(create, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, product.getName());
            ps.setString(2,product.getDesc());
            ps.setDouble(3,product.getPrice());
            ps.setInt(4,product.getCategory_Id());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if(rs.next()){
                product.setId(rs.getInt(1));
            }
        }catch (SQLException e){
            System.out.println("Invalid!!!");
        }
    }

    @Override
    public Product getProductById(int id) {
        Product product = new Product();
        try {
            PreparedStatement ps = conn.prepareStatement(getById);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setDesc(rs.getString(3));
                product.setPrice(rs.getDouble(4));
                product.setCategory_Id(rs.getInt(5));
            }
        } catch (SQLException throwables) {
            return null;
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(getAll);
            rs = ps.executeQuery();
            while (rs.next()){
                Product product = new Product();
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setDesc(rs.getString(3));
                product.setPrice(rs.getDouble(4));
                product.setCategory_Id(rs.getInt(5));

                productList.add(product);
            }
        } catch (SQLException throwables) {
            return null;
        }
        return productList;
    }

    @Override
    public void update(Product product) {
        try {
            PreparedStatement ps = conn.prepareStatement(update);
            ps.setString(1,product.getName());
            ps.setString(2,product.getDesc());
            ps.setDouble(3,product.getPrice());
            ps.setInt(4,product.getCategory_Id());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            PreparedStatement ps = conn.prepareStatement(delete);
            ps.setInt(1,id);
            ps.executeUpdate();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
