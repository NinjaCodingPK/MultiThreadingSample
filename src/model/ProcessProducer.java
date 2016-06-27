package model;

/**
 * Created by wookie on 6/27/16.
 */
public class ProcessProducer extends  Thread {
    private final static int UPPER_BORDER = 600;
    private final static int LOWER_BORDER = 400;
    private String name;
    private CpuQueue queue;
    private int count;

    public ProcessProducer(String name, CpuQueue queue) {
        this.queue = queue;
        this.name = name;
    }

    @Override
    public void run(){
        while(!isInterrupted()){
        //for(int i = 0; i < 10; i++) {
            int toughness = (int)(Math.random()*(UPPER_BORDER - LOWER_BORDER)*10);
            queue.push(new CpuProcess(toughness));
            count++;
            System.out.println("Push by " + name);
            try {
                Thread.sleep(toughness);
            } catch (InterruptedException ex) {
                return;
            }
        }
    }

    public int getCount() {
        return count;
    }
}
