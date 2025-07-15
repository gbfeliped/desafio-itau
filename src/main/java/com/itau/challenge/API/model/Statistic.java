package com.itau.challenge.API.model;

public class Statistic {
    private long count = 0;
    private double sum = 0;
    private double avg = 0;
    private double min = 0;
    private double max = 0;

    public Statistic(long count, double sum, double avg, double min, double max) {
        this.count = count;
        this.sum = Double.isFinite(sum) ? sum : 0;
        this.avg = Double.isFinite(avg) ? avg : 0;
        this.min = Double.isFinite(min) ? min : 0;
        this.max = Double.isFinite(max) ? max : 0;
    }

    public long getCount() {
        return count;
    }
    public double getMin() {
        return min;
    }
    public double getMax() {
        return max;
    }
    public double getAvg() {
        return avg;
    }
    public double getSum() {
        return sum;
    }
}
