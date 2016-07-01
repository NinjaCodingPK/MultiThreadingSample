package model;

/**
 * Created by wookie on 7/1/16.
 */
public class AddedCpu extends Cpu {
    private final static int UPPER_BORDER = 600;
    private final static int LOWER_BORDER = 400;

    {
        time = (int)(Math.random()*(UPPER_BORDER - LOWER_BORDER)*10);
    }

    public AddedCpu(String name, CpuQueue queue1, CpuQueue queue2) {
        this.queue1 = queue1;
        this.queue2 = queue2;
        this.name = name;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            if((queue1.getSize() > CpuQueue.MAX_SIZE) || (queue2.getSize() > CpuQueue.MAX_SIZE)) {
                CpuProcess proc;
                if (queue1.getSize() > queue2.getSize())
                    proc = queue1.pull();
                else
                    proc = queue2.pull();

                if (proc != null) {
                    try {
                        //System.out.println("Task is performing by " + this.name + queue1.getSize() + queue2.getSize());
                        System.out.println("Task is performing by " + this.name);
                        //Thread.sleep(time);
                        Thread.sleep(200);
                        count++;
                        //System.out.println("Added CPU stopped");
                        //this.wait();
                    } catch (InterruptedException ex) {
                        return;
                    }
                } else {
                    Thread.yield();
                }
            }
        }
    }
}
