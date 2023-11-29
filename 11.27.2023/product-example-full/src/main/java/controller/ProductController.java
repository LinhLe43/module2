package controller;

import model.Category;
import model.Product;
import service.CategoryService;
import service.ProductService;
import service.impl.CategoryServiceImpl;
import service.impl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "productController", value = "/products")
public class ProductController extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();
    private CategoryService categoryService = new CategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "home":
                showHome(req, resp);
                break;
            case "create":
                showCreate(req, resp);
                break;
        }
    }

    private void showHome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("product/home.jsp");
        List<Product> products = productService.findAll();
        req.setAttribute("products", products);
        dispatcher.forward(req, resp);
    }

    private void showCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("product/create.jsp");
        List<Category> categories = categoryService.findAll();
        req.setAttribute("categories", categories);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "create":
                String name = req.getParameter("name");
                Double price = Double.valueOf(req.getParameter("price"));
                int idCategory = Integer.parseInt(req.getParameter("idCategory"));
                int quantity = Integer.parseInt(req.getParameter("quantity"));
                Category category = new Category(idCategory);
                Product newProduct = new Product(name, price, quantity, category);
                productService.add(newProduct);
                resp.sendRedirect("/products?action=home");
        }
    }
}
