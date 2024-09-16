/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package nguyen.dev;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

import nguyen.dev.data.dao.CategoryDao;
import nguyen.dev.data.dao.DatabaseDao;
import nguyen.dev.data.model.Category;
import nguyen.dev.data.dao.Database;

/**
 *
 * @author Trung Nguyên
 */
public class HomeSevlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DatabaseDao.init(new Database());
        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
        List<Category> categoryList = categoryDao.findAll();
        
        request.setAttribute("categoryList", categoryList);
        request.getRequestDispatcher("home.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
