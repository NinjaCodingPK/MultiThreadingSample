package model;

/**
 * Class which produce processes.
 * Created by wookie on 6/27/16.
 */
public class ProcessProducer extends  Thread {
    private final static int UPPER_BORDER = 600;
    private final static int LOWER_BORDER = 355;
    /**
     * Name of thread.
     */
    private String name;
    private CpuQueue queue;
    /**
     * Count of generated processes.
     */
    private int count;

    public ProcessProducer(String name, CpuQueue queue) {
        this.queue = queue;
        this.name = name;
    }

    /**
     * Method generate and push CpuProducers into a queue.
     */
    @Override
    public void run(){
        while(!isInterrupted()){
            int toughness = (int)(Math.random()*(UPPER_BORDER - LOWER_BORDER)*10);
            queue.push(new CpuProcess(toughness));
            count++;
            System.out.println("Push by " + name + ". Queue size " + queue.getSize());
            try {
                //Thread.sleep(toughness);
                Thread.sleep(920);
            } catch (InterruptedException ex) {
                return;
            }
        }
    }

    public int getCount() {
        return count;
    }
}
