package model;

/**
 * Class which model a process.
 * Created by wookie on 6/27/16.
 */
public class CpuProcess {
    private int toughness;

    public CpuProcess(int toughness) {
        this.toughness = toughness;
    }

    public int getToughness() {
        return toughness;
    }

    public void setToughness(int toughness) {
        this.toughness = toughness;
    }
}
