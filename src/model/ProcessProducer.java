package model;

/**
 * Created by wookie on 6/27/16.
 */
public class ProcessProducer extends  Thread {
    private String name;
    private CpuQueue queue;

    public ProcessProducer(String name, CpuQueue queue) {
        this.queue = queue;
        this.name = name;
    }

    @Override
    public void run(){
        while(!isInterrupted()){
        //for(int i = 0; i < 10; i++) {
            queue.push(new CpuProcess());
            System.out.println("Push by " + name);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                return;
            }
        }
    }
}
