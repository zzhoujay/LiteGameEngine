package com.zzhoujay.litegameengine.core;

/**
 * Created by zhou on 16-4-25.
 */
public abstract class WorkThread extends Thread {

    private boolean working = true;
    private final int intervalTime;

    public WorkThread(int intervalTime) {
        this.intervalTime = intervalTime;
    }

    protected abstract void work();

    @Override
    public void run() {
        while (working) {
            long startTime = System.currentTimeMillis();
            work();
            long endTime = System.currentTimeMillis();
            int remainTime = intervalTime - (int) (endTime - startTime);
            if (remainTime > 0) {
                try {
                    sleep(remainTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }
}
