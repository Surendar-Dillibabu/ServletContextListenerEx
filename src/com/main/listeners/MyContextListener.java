package com.main.listeners;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyContextListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("contextInitialized method called");
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "dev_user", "devuser");
      sce.getServletContext().setAttribute("conn", conn);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    System.out.println("contextDestroyed method called");
    sce.getServletContext().removeAttribute("conn");
  }

}
