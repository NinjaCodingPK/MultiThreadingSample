package model;

/**
 * Created by wookie on 6/27/16.
 */
public class Planner extends Thread {
    private final Cpu cpu;

    public Planner(Cpu cpu) {
        this.cpu = cpu;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            if ((cpu.getQueue1().getSize() > CpuQueue.MAX_SIZE) || (cpu.getQueue2().getSize() > CpuQueue.MAX_SIZE)) {
                if (cpu.isAlive()) {
                    cpu.notify();
                } else {
                    cpu.start();
                }
            }

            synchronized (cpu) {
                if (cpu.isAlive()) {
                    try {
                        //cpu.join();
                        cpu.wait();
                    } catch (InterruptedException e) {
                        //e.printStackTrace();
                    }
                }
            }
        }
    }
}
