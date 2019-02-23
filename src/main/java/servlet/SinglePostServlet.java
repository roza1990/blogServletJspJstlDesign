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

@WebServlet(urlPatterns = "/singlePost")
public class SinglePostServlet extends HttpServlet {

    PostManager postManager = new PostManager();
    private CategoryManager categoryManager = new CategoryManager();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id == null || "".equals(id)) {
            resp.sendRedirect("/home");
            return;
        }
        int postId = Integer.parseInt(id);
        Post postById = postManager.getPostById(postId);
        req.setAttribute("post",postById);
        req.setAttribute("categories", categoryManager.getAllCategories());

        req.getRequestDispatcher("/WEB-INF/single_post.jsp").forward(req,resp);

    }
}
