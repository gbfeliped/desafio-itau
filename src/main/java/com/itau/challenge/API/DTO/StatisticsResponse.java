package com.itau.challenge.API.DTO;

import java.util.DoubleSummaryStatistics;

public class StatisticsResponse {
    private long count = 0;
    private double sum = 0;
    private double avg = 0;
    private double min = 0;
    private double max = 0;

    public StatisticsResponse(DoubleSummaryStatistics stats) {
        this.count = stats.getCount();
        this.sum = stats.getSum();
        this.avg = stats.getAverage();
        this.min = stats.getMin();
        this.max = stats.getMax();
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
