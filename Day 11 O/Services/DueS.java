package Services;

import MainLibM.LendingRecords;
import java.util.*;

public class DueS extends Thread {
    private LibraryS service;
    public DueS(LibraryS service) { this.service = service; }
    public void run() {
        while (true) {
            List<LendingRecords> overdue = service.getOverdueRecords();
            for (LendingRecords r : overdue) {
                System.out.println("Overdue: " + r.book.title + " by " + r.member.name);
            }
            try { Thread.sleep(60000); } catch (InterruptedException e) { break; }
        }
    }
}