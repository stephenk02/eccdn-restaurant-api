package com.skoren.eccdn.restaurantapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.cglib.core.Local;

import java.time.LocalTime;
import java.util.Optional;

public class Deal {
    private String objectId;
    private Integer discount;
    private Boolean dineIn;
    private Boolean lightning;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "h:mma")
    private LocalTime start;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "h:mma")
    private LocalTime end;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "h:mma")
    private LocalTime open;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "h:mma")
    private LocalTime close;
    private Integer qtyLeft;

    public Deal() {}

    public Deal(String objectId, Integer discount, Boolean dineIn, Boolean lightning, Integer qtyLeft) {
        this.objectId = objectId;
        this.discount = discount;
        this.dineIn = dineIn;
        this.lightning = lightning;
        this.qtyLeft = qtyLeft;
        this.start = LocalTime.of(0,0,0);
        this.end = LocalTime.of(23,59,59);
        this.open = this.start;
        this.close = this.end;
    }

    public Deal(String objectId, Integer discount, Boolean dineIn, Boolean lightning, LocalTime startOrOpen, LocalTime endOrClose, Integer qtyLeft) {
        this.objectId = objectId;
        this.discount = discount;
        this.dineIn = dineIn;
        this.lightning = lightning;
        this.qtyLeft = qtyLeft;
        this.start = startOrOpen;
        this.end = endOrClose;
        this.open = startOrOpen;
        this.close = endOrClose;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Boolean getDineIn() {
        return dineIn;
    }

    public void setDineIn(Boolean dineIn) {
        this.dineIn = dineIn;
    }

    public Boolean getLightning() {
        return lightning;
    }

    public void setLightning(Boolean lightning) {
        this.lightning = lightning;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public LocalTime getOpen() {
        return open;
    }

    public void setOpen(LocalTime open) {
        this.open = open;
    }

    public LocalTime getClose() {
        return close;
    }

    public void setClose(LocalTime close) {
        this.close = close;
    }

    public Integer getQtyLeft() {
        return qtyLeft;
    }

    public void setQtyLeft(Integer qtyLeft) {
        this.qtyLeft = qtyLeft;
    }

    @Override
    public String toString() {
        return "Deal{" +
                "objectId='" + objectId + '\'' +
                ", discount=" + discount +
                ", dineIn=" + dineIn +
                ", lightning=" + lightning +
                ", start=" + start +
                ", end=" + end +
                ", open=" + open +
                ", close=" + close +
                ", qtyLeft=" + qtyLeft +
                '}';
    }
}
