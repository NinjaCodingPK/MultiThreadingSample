package model;

/**
 * CPU class which will be work by condition.
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


    /**
     * Method get values from queues only when size of one of queues become bigger the MAX_SIZE.
     */
    @Override
    public void run() {
        CpuProcess proc = null;
        while (!isInterrupted()) {
            if(queue1.getSize() > CpuQueue.MAX_SIZE) {
                proc = queue1.pull();
            }
            else if(queue2.getSize() > CpuQueue.MAX_SIZE) {
                proc = queue2.pull();
            }


            if (proc != null) {
                try {
                    System.out.println("Task is performing by " + this.name);
                    //Thread.sleep(time);
                    Thread.sleep(200);
                    count++;
                    proc = null;
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
