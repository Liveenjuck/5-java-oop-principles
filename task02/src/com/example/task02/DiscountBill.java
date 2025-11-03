package com.example.task02;

public class DiscountBill extends Bill{
    private final double discount;

    public DiscountBill(double discount) {
        this.discount = discount;
    }

    @Override
    public long getPrice() {
        long price = super.getPrice();
        return (long)(price - (price * (discount / 100)));
    }

    public long getAbsoluteDiscount() {
        return super.getPrice() - getPrice();
    }

    public String getDiscount() {
        return discount + "%";
    }
}
