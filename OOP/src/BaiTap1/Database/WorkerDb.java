package BaiTap1.Database;

import java.time.LocalDate;

import BaiTap1.Worker;

public class WorkerDb {
    private static int wokerId = 1;

    public static int getWokerId() {
        return wokerId;
    }

    public static void setWokerId(int wokerId) {
        WorkerDb.wokerId = wokerId;
    }
    private static Worker[] workers = {
        new Worker(wokerId++, "101", "Nguyen Van", "Tung", 
        LocalDate.of(2000, 2, 21), 1, 3.67, 22.5),
        new Worker(wokerId++, "102", "Nguyen Van", "Hai", 
        LocalDate.of(1998, 5, 11), 2, 3.33, 23.5),
        new Worker(wokerId++, "103", "Nguyen Van", "Hieu", 
        LocalDate.of(1996, 12, 14), 5, 2.67, 24.5),
    };

    public static Worker[] getWorkers() {
        return workers;
    }

    public static void setWorkers(Worker[] workers) {
        WorkerDb.workers = workers;
    }
    
}
