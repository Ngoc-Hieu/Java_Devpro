package BaiTap1.Database;

import BaiTap1.Job;

public class JobDb {
    private static Job[] jobs = {
        new Job(1, "101", "May"),
        new Job(2,"102","Giat la"),
        new Job(3, "103", "Bao duong may khau"),
        new Job(4, "104", "Van chuyen"),
        new Job(5, "105", "Kiem tra kho hang")
    };

    public static Job[] getJobs() {
        return jobs;
    }

    public static void setJobs(Job[] jobs) {
        JobDb.jobs = jobs;
    }
    public static Job findById(int id){
        for(Job job : jobs){
            if(job.getId() == id) return job;
        }
        return null;
    }
}
