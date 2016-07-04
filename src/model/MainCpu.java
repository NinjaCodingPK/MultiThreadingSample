package model;

/**
 * CPU class which will be work all time.
 * Created by wookie on 6/27/16.
 */
public class MainCpu extends Cpu {
    private final static int UPPER_BORDER = 600;
    private final static int LOWER_BORDER = 400;
    private final AddedCpu addedCpu;

    {
        time = (int)(Math.random()*(UPPER_BORDER-LOWER_BORDER)+LOWER_BORDER);
    }

    public MainCpu(String name, CpuQueue queue1, CpuQueue queue2, AddedCpu addedCpu) {
        this.queue1 = queue1;
        this.queue2 = queue2;
        this.name = name;
        this.addedCpu = addedCpu;
    }

    /**
     * Method get processes from queues every time.
     */
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
                    Thread.sleep(610);
                    count++;
                } catch (InterruptedException ex) {
                    return;
                }
            } else {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {

                    }

                //Thread.yield();
            }

            synchronized (addedCpu) {
                if ((queue1.getSize() > CpuQueue.MAX_SIZE) || (queue1.getSize() > CpuQueue.MAX_SIZE)) {
                    if (!addedCpu.isAlive())
                        addedCpu.start();
                    addedCpu.notify();

                }
            }
        }


    }
}
