package service.impl;

import model.Category;
import model.Product;
import service.ProductService;
import service.connection.ConnectionToMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService<Product> {
    Connection connection = ConnectionToMySQL.getConnection();

    @Override
    public void add(Product product) {
        String sql = "insert into product(name, price, quantity, idCategory) values (?, ?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setInt(4, product.getCategory().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void edit(int id, Product product) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        String sql = "select p.*, c.name as nameCategory from product p join category c on p.idCategory = c.id";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                int idCategory = resultSet.getInt("idCategory");
                String nameCategory = resultSet.getString("nameCategory");
                Category category = new Category(idCategory, nameCategory);
                Product product = new Product(id, name, price, quantity, category);
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
}
