package app.tourism.models;

import java.util.List;

import app.tourism.data.DeptEntity;
import app.tourism.data.EmployeeEntity;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class SiteModel {

    private static final EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("app.data");

    public DeptEntity getDeptById(int deptno) {
        try (var em = emf.createEntityManager()) {
            return em.find(DeptEntity.class, deptno);
        }
    }

    public List<EmployeeEntity> getDeptEmp(int deptno){
        List<EmployeeEntity>emps;
        try(var em = emf.createEntityManager()){
         emps =   em.createQuery("SELECT e FROM EmployeeEntity e WHERE e.dept.deptno = "+deptno,
           EmployeeEntity.class).getResultList();
        }
        return emps;
    }


    public List<EmployeeEntity> getEmp() {
        try (var em = emf.createEntityManager()) {
            var query = em.createQuery(
                "SELECT e FROM EmployeeEntity e", 
                EmployeeEntity.class
            );
            return query.getResultList();
        }
    }

 
  

    public boolean handleEmp(
        int empno, 
        String empName, 

        Double sal,
        Double comm, 
        DeptEntity dept) {

        if (empName == null ||  sal == null || comm == null || dept == null) {
            return false;
        }

        try (var em = emf.createEntityManager()) {

            var tx = em.getTransaction();
            tx.begin();

            EmployeeEntity employee = em.find(EmployeeEntity.class, empno);

            if (employee == null) {
                employee = new EmployeeEntity();
                employee.setEmpno(empno);
            }

            employee.setEname(empName);
           
            employee.setSal(sal);
            employee.setComm(comm);
            employee.setDept(dept);

            em.merge(employee);
            tx.commit();
            return true;
        }
    }
}
