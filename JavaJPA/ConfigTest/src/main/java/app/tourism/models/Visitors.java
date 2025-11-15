package app.tourism.models;

import app.tourism.data.EmployeeEntity;

public record Visitors(String ename, int empno, double sal, double comm,String deptName) {

    public static Visitors fromVisitors(EmployeeEntity employee){
        var dept = employee.getDept();

        return new Visitors(employee.getEname(), employee.getEmpno(), employee.getSal(), employee.getComm(),dept!=null? dept.getDname(): null);
       
    }
    
}
