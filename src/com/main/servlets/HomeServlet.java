package com.main.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/home", "/home.html" }, loadOnStartup = 0)
public class HomeServlet extends HttpServlet {

  /**
   * 
  */
  private static final long serialVersionUID = 1L;
  
  public static final String HTML_START = "<html><body>";
  public static final String HTML_END = "</html></body>";

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    PrintWriter pw = response.getWriter();
    pw.append(HTML_START);
    pw.append("<p>Home page</p>");
    pw.append("<a href='").append(request.getContextPath()).append("/getEmployeeDetails.html").append("'>Get employee details</a>");
    pw.append(HTML_END);
    pw.close();
  }
}
