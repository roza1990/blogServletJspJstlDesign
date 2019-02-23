package servlet;

import manager.CategoryManager;
import manager.PostManager;
import model.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/home")
public class HomeServlet extends HttpServlet {

    private PostManager postManager = new PostManager();
    private CategoryManager categoryManager = new CategoryManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String categoryId = req.getParameter("categoryId");

        List<Post> posts = new ArrayList<Post>();
        if (categoryId != null && !categoryId.equals("")) {
            posts = postManager.getAllPostByCategory(Integer.parseInt(categoryId));
        } else {
            posts = postManager.getAllPost();
        }
        req.setAttribute("posts", posts);
        req.setAttribute("categories", categoryManager.getAllCategories());
        req.getRequestDispatcher("/WEB-INF/home.jsp").forward(req, resp);

    }
}
