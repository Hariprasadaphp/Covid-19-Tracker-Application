package com.hari.covid19.Model;

public class LocationStats {
    private String state;
    private String country;
    private long previousDayCases;
    private long currentDayCases;
    private long ChangesInCasesAsOfToday;
    private long totalCasesToday;
    private long totalChangedCasesToday;
    public void setTotalCasesToday(long totalCasesToday) {
        this.totalCasesToday = totalCasesToday;
    }
    public long getTotalCasesToday() {
        return totalCasesToday;
    }
    public void setTotalChangedCasesToday(long totalChangedCasesToday) {
        this.totalChangedCasesToday = totalChangedCasesToday;
    }
    public long getTotalChangedCasesToday() {
        return totalChangedCasesToday;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCountry() {
        return country;
    }
    public void setPreviousDayCases(long previousDayCases) {
        this.previousDayCases = previousDayCases;
    }
    public long getPreviousDayCases() {
        return previousDayCases;
    }
    public void setCurrentDayCases(long currentDayCases) {
        this.currentDayCases = currentDayCases;
    }
    public long getCurrentDayCases() {
        return currentDayCases;
    }
    public void setChangesInCasesAsOfToday(long ChangesInCasesAsOfToday) {
        this.ChangesInCasesAsOfToday = ChangesInCasesAsOfToday;
    }
    public long getChangesInCasesAsOfToday() {
        return ChangesInCasesAsOfToday;
    }
}