package listenerPackage;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.*;
import loginPackage.*;

/**
 * Application Lifecycle Listener implementation class LoginListener
 *
 */
@WebListener
public class LoginListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public LoginListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
        AccountManager manager = new AccountManager();
        ServletContext context = arg0.getServletContext();
        context.setAttribute("manager", manager);
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
