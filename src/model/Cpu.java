package model;

/**
 * Abstract class CPU.
 * Created by wookie on 7/1/16.
 */
public abstract class Cpu extends Thread {
    protected int time;
    protected String name;
    protected CpuQueue queue1;
    protected CpuQueue queue2;
    protected int count;

    public int getCount() {
        return count;
    }

    public String getCpuName() {
        return name;
    }
}
