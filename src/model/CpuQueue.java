package model;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Class which model a queue of processes.
 * Created by wookie on 6/27/16.
 */
public class CpuQueue {
    public static final int MAX_SIZE = 5;
    private List<CpuProcess> queue = new LinkedList<>();
    private int count = 0;

    /**
     * Method puts CpuProcess to the queue.
     * @param process CpuProcess to push.
     */
    public void push(CpuProcess process) {
        synchronized (this) {
            queue.add(process);
            count++;
            notify();
        }
    }

    /**
     * Method pulls CpuProcess from the queue.
     * @return first CpuProcess in the queue.
     */
    public CpuProcess pull() {
        CpuProcess result = null;

//        synchronized (this) {
//            if(queue.isEmpty()) {
//                try {
//                    wait();
//                } catch (InterruptedException e) {
//
//                }
//            }
            result = queue.isEmpty() ? null : queue.remove(0);
//        }
        return result;
    }

    public int getSize() {
        return queue.size();
    }

    public int getCount() {
        return count;
    }

    public List<CpuProcess> getQueue() {
        return queue;
    }
}
