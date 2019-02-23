package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServerListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("kuku");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("bye bye");
    }
}

