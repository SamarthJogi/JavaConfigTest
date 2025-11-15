package app;

import app.tourism.data.DeptEntity;
import app.tourism.models.SiteModel;

public class Program {

    public static void main(String[] args) throws Exception {
        var site = new SiteModel();
      if(args.length > 0 && args.length <=1){
            int deps = Integer.parseInt(args[0]);

            for(var e: site.getDeptEmp(deps)){
                System.out.printf("%-16s %8d %10.2f %10.2f %n",
                e.getEname(),
                e.getEmpno(),
                e.getSal(),
                e.getComm()
            );
            }
        
        } 
        else if (args.length > 0) {

            int empno     = Integer.parseInt(args[0]);
            String ename  = args[1];

            double sal    = Double.parseDouble(args[2]);
            double comm   = Double.parseDouble(args[3]);
            int deptno    = Integer.parseInt(args[4]);

            DeptEntity dept = site.getDeptById(deptno);

            if (dept == null) {
                System.out.println("Invalid department number: " + deptno);
                return;
            }

            site.handleEmp(empno, ename, sal, comm, dept);

            System.out.println("Welcome " + ename);

        } else {

            for (var e : site.getEmp()) {

                System.out.printf("%-16s %8d %10.2f %10.2f %n",
                    e.getEname(),
                    e.getEmpno(),
                    e.getSal(),
                    e.getComm()

                );
            }
        }
    }
}
