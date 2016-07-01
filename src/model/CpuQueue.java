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
//    ReentrantLock lock = new ReentrantLock();
//    Condition emptyCondition = lock.newCondition();
//    Condition fullCondition = lock.newCondition();
//
//    public /*synchronized*/ void push(CpuProcess item) {
//        lock.tryLock();
//        lock.lock();
//        try {
//            if (queue.size() >= MAX_SIZE) {
//                try {
//                    fullCondition.await();
//                } catch (InterruptedException ex) {
//                    //Logger.getLogger(Queue.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            queue.add(item);
//            emptyCondition.signal();
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public /*synchronized*/ CpuProcess pull(){
//        CpuProcess result = null;
//        lock.lock();
//        try{
//
//            if( queue.isEmpty() ){
//                try {
//                /*wait();*/
//                    emptyCondition.await();
//                } catch (InterruptedException ex) {
//                    //Logger.getLogger(Queue.class.getName()).log(Level.SEVERE, null, ex);
//                    return null;
//                }
//            }
//
//            result =  queue.isEmpty() ? null :queue.remove(0);
//            fullCondition.signal();
//        }finally{
//            lock.unlock();
//        }
//        return result;
//
//    }

    public synchronized void push(CpuProcess process) {
        synchronized (this) {
            queue.add(process);
            count++;
        }
    }

//    public CpuProcess pull() {
//        CpuProcess result = null;
//        result =  queue.isEmpty() ? null :queue.remove(0);
//
//        return result;
//    }

    public synchronized CpuProcess pull() {
        CpuProcess result = null;

        synchronized (this) {
//            try {
//
//                if (queue.isEmpty()) {
////                    try {
////                        //wait();
////                        //emptyCondition.await();
////                    } catch (InterruptedException ex) {
////                        //Logger.getLogger(Queue.class.getName()).log(Level.SEVERE, null, ex);
////                        return null;
////                    }
//                }

            result = queue.isEmpty() ? null : queue.remove(0);
            //fullCondition.signal();
//            } finally {
//                //notify();
//                //lock.unlock();
//            }
//        }
        }
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
