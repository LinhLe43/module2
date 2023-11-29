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
    private ProductServiceImpl productService = new ProductServiceImpl();
    private CategoryServiceImpl categoryService = new CategoryServiceImpl();

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
            case "delete":
                showDelete(req, resp);
                break;
            case "update":
                RequestDispatcher dispatcher = req.getRequestDispatcher("product/update.jsp");
                int updateId = Integer.parseInt(req.getParameter("id"));
                Product updateProduct = productService.getById(updateId);
                req.setAttribute("product", updateProduct);
                List<Category> categories = categoryService.findAll();
                req.setAttribute("categories", categories);
                dispatcher.forward(req, resp);
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

    private void showDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("product/delete.jsp");
        int idDelete = Integer.parseInt(req.getParameter("id"));
        Product product = productService.getById(idDelete);
        req.setAttribute("product", product);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "create":
                create(req, resp);
                break;
            case "delete":
                int idDelete = Integer.parseInt(req.getParameter("id"));
                productService.delete(idDelete);
                resp.sendRedirect("/products?action=home");
                break;
            case "update":
                int idUpdate = Integer.parseInt(req.getParameter("id"));
                String name = req.getParameter("name");
                Double price = Double.valueOf(req.getParameter("price"));
                int quantity = Integer.parseInt(req.getParameter("quantity"));
                int idCategory = Integer.parseInt(req.getParameter("idCategory"));
                Category category = new Category(idCategory);
                Product updateProduct = new Product(name, price, quantity, category);
                productService.edit(idUpdate, updateProduct);
                resp.sendRedirect("/products?action=home");
        }
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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
