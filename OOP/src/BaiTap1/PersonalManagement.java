package BaiTap1;

import java.lang.reflect.Array;
import java.time.LocalDate;

import BaiTap1.Database.WorkerDb;

public class PersonalManagement {
    //Hiển thị danh sách
    public static void display(){
        System.out.println("\nDANH SACH CONG NHAN");
        Worker[] workers = WorkerDb.getWorkers();
        for(Worker w : workers){
            w.display();
        }
    }
    //Hiển thị ds công nhân luong dưới 5tr
     public static void display5Tr(){
        System.out.println("\nDANH SACH CONG NHAN");
        Worker[] workers = WorkerDb.getWorkers();
        boolean y = false;
        for(Worker w : workers){
            if(w.salary() < 5000000){
                w.display();
                y = true;
            }
            
        }
        if(!y){
            System.out.println("khong co cong nhan nao");
        }
     }
     //Them 1 công nhan mới vào vtri thu k trong danh sách
    public static void addNewWorker(int k, Worker w){
        Worker[] workers = WorkerDb.getWorkers();
       if(k<1 || k>workers.length){
           System.out.println("Ko hop le");return;
       }
       
      
       // cho phep chen o cuoi: k tu 1 den workers.length+1
       if (k < 1 || k > workers.length + 1) {
           System.out.println("Ko hop le");
           return;
       }
       Worker[] temp = workers.clone();
       workers = new Worker[temp.length + 1];
       int i;
       for (i = 0; i < k - 1; i++) {
           workers[i] = temp[i];
       }
       workers[k - 1] = w;
       // copy phan con lai: phan tu temp[i-1] -> workers[i]
             for (i = k; i < workers.length; i++) {
           workers[i] = temp[i - 1];
       }
        WorkerDb.setWorkers(workers);
     }
     public static double totalSalary(){
        double total = 0;
        for(Worker w : WorkerDb.getWorkers()){
            total += w.salary();
        }
        return total;
     }
     
    public static void moveWorkerOffToEnd(){
        Worker[] workers = WorkerDb.getWorkers();
        int i=0 ; int j=workers.length-1;
        while(i<j){
            if(workers[i].getWorkingDay()==0 && workers[j].getWorkingDay()  !=0){
                Worker tmp = workers[i];
                workers[i] = workers[j];
                workers[j] = tmp;
                i++;j--;
            }
            else{
                i++;
            }
        }
        
        WorkerDb.setWorkers(workers);
     }
     public static void main(String[] args) {
        display();
        display5Tr();
        Worker w = new Worker(WorkerDb.getWokerId(), "104", "Nguyen Ngoc", "Hieu", LocalDate.of(2005, 10, 2), 3, 3.36, 0);
        WorkerDb.setWokerId(WorkerDb.getWokerId()+1);
        addNewWorker(1, w);

         Worker w1 = new Worker(WorkerDb.getWokerId(), "105", "Nguyen Ngoc", "Han", LocalDate.of(2005, 10, 2), 3, 3.36, 0);
        WorkerDb.setWokerId(WorkerDb.getWokerId()+1);
        addNewWorker(3, w1);
        display();
        System.out.println("Tong luong = "+totalSalary());
        moveWorkerOffToEnd();
        display();
    }
    
}
