package model;

/**
 * Created by wookie on 6/27/16.
 */
public class Cpu extends Thread {
    private int time = (int)(Math.random()*10);
    private String name;
    private CpuQueue queue1;
    private CpuQueue queue2;
    private int count = 0;

    public Cpu(String name, CpuQueue queue1, CpuQueue queue2) {
        this.queue1 = queue1;
        this.queue2 = queue2;
        this.name = name;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {

            CpuProcess prod;
            if(queue1.getSize() > queue2.getSize())
                prod = queue1.pull();
            else
                prod = queue2.pull();

            if (prod != null) {
                try {
                    System.out.println("Task is performing by " + this.name + queue1.getSize() + queue2.getSize());
                    Thread.sleep(300);
                    count++;
                } catch (InterruptedException ex) {
                    return;
                }
            } else {
                Thread.yield();
            }
        }
    }

    public int getCount() {
        return count;
    }

    public CpuQueue getQueue1() {
        return queue1;
    }

    public CpuQueue getQueue2() {
        return queue2;
    }

    public String getCpuName() {
        return name;
    }
}
