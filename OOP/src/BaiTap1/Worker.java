package BaiTap1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import BaiTap1.Database.JobDb;

public class Worker extends Personel{
    private int jobID;
    private double cocf;
    private double workingDay;
    public Worker(int id, String code, String firstName, String lastName, LocalDate dateOfBirth, int jobID, double cocf,
            double workingDay) {
        super(id, code, firstName, lastName, dateOfBirth);
        this.jobID = jobID;
        this.cocf = cocf;
        this.workingDay = workingDay;
    }
    public Worker(int jobID, double cocf, double workingDay) {
        this.jobID = jobID;
        this.cocf = cocf;
        this.workingDay = workingDay;
    }
    public Worker(){
        super();
    }
    public int getJobID() {
        return jobID;
    }
    public void setJobID(int jobID) {
        this.jobID = jobID;
    }
    public double getCocf() {
        return cocf;
    }
    public void setCocf(double cocf) {
        this.cocf = cocf;
    }
    public double getWorkingDay() {
        return workingDay;
    }
    public void setWorkingDay(double workingDay) {
        this.workingDay = workingDay;
    }
    public double salary(){
        return cocf * 3500000 + workingDay * 60000;
    }
    public void display(){
        Job job = JobDb.findById(jobID);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String str = dateOfBirth.format(dtf);
        System.out.printf("%3d %5s %-25s %10s %-35s %8.2f %9.1f %,15.2f%n",
            id, code, firstName + " "+lastName,
            str, job.getName(), cocf, workingDay, salary()
        );
    }
}
