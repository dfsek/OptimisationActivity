package org.corpnet.data;

public final class Entry {
    private final String department;
    private final int quantity;
    private final double price;
    private final double tax;

    public Entry(String department, int quantity, double price, double tax) {
        this.department = department;
        this.quantity = quantity;
        this.price = price;
        this.tax = tax;
    }

    public double getPrice() {
        return price;
    }

    public double getTax() {
        return tax;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDepartment() {
        return department;
    }

    public double getTotalPrice() {
        return quantity * (price + (price * tax));
    }
}
