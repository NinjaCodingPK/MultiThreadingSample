package main;

import model.*;
/**
 * Created by wookie on 6/27/16.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        CpuQueue queue1 = new CpuQueue();
        CpuQueue queue2 = new CpuQueue();

        Cpu cpu1 = new Cpu("CPU1", queue1, queue2);
        Cpu cpu2 = new Cpu("CPU2", queue1, queue2);
        ProcessProducer producer1 = new ProcessProducer("Producer 1", queue1);
        ProcessProducer producer2 = new ProcessProducer("Producer 2", queue2);
        Planner planner = new Planner(cpu1);

        producer1.start();
        producer2.start();
        cpu2.start();
        planner.start();

        Thread.sleep(15000);
        planner.interrupt();
        producer1.interrupt();
        producer2.interrupt();
        cpu1.interrupt();
        cpu2.interrupt();

        System.out.print("CpuProcesses generated: ");
        System.out.println(producer1.getCount() + producer2.getCount());

        System.out.print("CpuProcesses processed: ");
        System.out.println(cpu1.getCount() + cpu2.getCount());

    }
}
