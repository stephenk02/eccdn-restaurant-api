package com.skoren.eccdn.restaurantapi.dto.response;

public class PeakDealWindowResponse {
    private String peakTimeStart;
    private String peakTimeEnd;

    public String getPeakTimeStart() {
        return peakTimeStart;
    }

    public void setPeakTimeStart(String peakTimeStart) {
        this.peakTimeStart = peakTimeStart;
    }

    public String getPeakTimeEnd() {
        return peakTimeEnd;
    }

    public void setPeakTimeEnd(String peakTimeEnd) {
        this.peakTimeEnd = peakTimeEnd;
    }

    public PeakDealWindowResponse(String peakTimeStart, String peakTimeEnd) {
        this.peakTimeStart = peakTimeStart;
        this.peakTimeEnd = peakTimeEnd;
    }
}
