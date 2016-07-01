package model;

/**
 * Created by wookie on 6/27/16.
 */
public class MainCpu extends Cpu {
    private final static int UPPER_BORDER = 600;
    private final static int LOWER_BORDER = 400;

    {
        time = (int)(Math.random()*(UPPER_BORDER - LOWER_BORDER)*10);
    }

    public MainCpu(String name, CpuQueue queue1, CpuQueue queue2) {
        this.queue1 = queue1;
        this.queue2 = queue2;
        this.name = name;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {

            CpuProcess proc;
            if(queue1.getSize() > queue2.getSize())
                proc = queue1.pull();
            else
                proc = queue2.pull();

            if (proc != null) {
                try {
                    System.out.println("Task is performing by " + this.name);
                    //Thread.sleep(time);
                    Thread.sleep(410);
                    count++;
                } catch (InterruptedException ex) {
                    return;
                }
            } else {
                Thread.yield();
            }
        }
    }
}
