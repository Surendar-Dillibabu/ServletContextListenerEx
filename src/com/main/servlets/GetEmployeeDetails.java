package com.main.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.main.beans.EmployeeBean;

@WebServlet(urlPatterns = "/getEmployeeDetails.html")
public class GetEmployeeDetails extends HttpServlet {

  /**
   * 
  */
  private static final long serialVersionUID = 1L;

  public static final String HTML_START = "<html><body>";
  public static final String HTML_END = "</html></body>";

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    List<EmployeeBean> employeeList = new ArrayList<>();
    try (Connection conn = (Connection) getServletContext().getAttribute("conn")) {
      if (conn != null) {
        try (Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(
                "select EMPLOYEE_ID, EMPLOYEE_NAME, SALARY, DEPT_ID, JOINING_DATE from employee_details")) {
          EmployeeBean employeeBean = null;
          while (rs.next()) {
            employeeBean = new EmployeeBean();
            employeeBean.setEmployeeId(rs.getLong("EMPLOYEE_ID"));
            employeeBean.setEmployeeName(rs.getString("EMPLOYEE_NAME"));
            employeeBean.setSalary(rs.getLong("SALARY"));
            employeeBean.setDeptId(rs.getInt("DEPT_ID"));
            employeeBean.setJoiningDate(rs.getDate("JOINING_DATE"));
            employeeList.add(employeeBean);
          }
        }
      }
    } catch (SQLException e1) {
      e1.printStackTrace();
    }
    request.setAttribute("employeeList", employeeList);
    request.getRequestDispatcher("/employeeDetails.jsp").forward(request, response);
  }

}
