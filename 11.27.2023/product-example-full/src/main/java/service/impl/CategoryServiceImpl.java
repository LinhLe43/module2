package service.impl;

import model.Category;
import service.CategoryService;
import service.connection.ConnectionToMySQL;

import javax.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService<Category> {
    Connection connection = ConnectionToMySQL.getConnection();

    @Override
    public void add(Category category) {

    }

    @Override
    public void edit(int id, Category category) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        String sql = "select * from category";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Category category = new Category(id, name);
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }
}
