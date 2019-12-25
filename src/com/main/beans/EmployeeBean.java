package com.main.beans;

import java.io.Serializable;
import java.util.Date;

public class EmployeeBean implements Serializable {

  /**
   * 
  */
  private static final long serialVersionUID = 1L;

  private Long employeeId;
  private String employeeName;
  private Long salary;
  private int deptId;
  private Date joiningDate;

  public Long getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(Long employeeId) {
    this.employeeId = employeeId;
  }

  public String getEmployeeName() {
    return employeeName;
  }

  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
  }

  public Long getSalary() {
    return salary;
  }

  public void setSalary(Long salary) {
    this.salary = salary;
  }

  public int getDeptId() {
    return deptId;
  }

  public void setDeptId(int deptId) {
    this.deptId = deptId;
  }

  public Date getJoiningDate() {
    return joiningDate;
  }

  public void setJoiningDate(Date joiningDate) {
    this.joiningDate = joiningDate;
  }

  @Override
  public String toString() {
    return "EmployeeBean [employeeId=" + employeeId + ", employeeName=" + employeeName + ", salary=" + salary
        + ", deptId=" + deptId + ", joiningDate=" + joiningDate + "]";
  }

}
