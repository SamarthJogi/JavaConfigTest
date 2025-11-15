package app.tourism.data;

public class EmployeeEntity {
    private int empno;
    private String ename;
   
   
    private double sal;
    private double comm;
    private DeptEntity dept;

    public int getEmpno() {
        return empno;
    }
    public void setEmpno(int empno) {
        this.empno = empno;
    }
    public String getEname() {
        return ename;
    }
    public void setEname(String ename) {
        this.ename = ename;
    }
  
   
    public double getSal() {
        return sal;
    }
    public void setSal(double sal) {
        this.sal = sal;
    }
    public double getComm() {
        return comm;
    }
    public void setComm(double comm) {
        this.comm = comm;
    }
    public DeptEntity getDept() {
        return dept;
    }
    public void setDept(DeptEntity dept) {
        this.dept = dept;
    }
 
   
    
}
