package com.finance.service;

public class ReportThread extends Thread {
    private final int userId;

    public ReportThread(int userId) {
        this.userId = userId;
    }

    @Override
    public void run() {
        System.out.println("Report generation started for user: " + userId);
        try {
            Thread.sleep(500);
            System.out.println("Report generation completed for user: " + userId);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
