package org.corpnet.data;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataFile {
    private final List<Entry> entries = new ArrayList<>();

    public DataFile(String data) {
        for (int lineIndex = 0; lineIndex < data.split("\n").length; lineIndex++) {
            String line = data.split("\n")[lineIndex];
            String department = line.split(",")[0];
            double price = Double.parseDouble(line.split(",")[1]);
            int quantity = Integer.parseInt(line.split(",")[2]);
            double tax = Double.parseDouble(line.split(",")[3]);
            entries.add(new Entry(department, quantity, price, tax));
        }
    }

    public DataFile(InputStream data) throws IOException {
        this(IOUtils.toString(data, Charset.defaultCharset()));
    }

    public double getTotalPrice() {
        double price = 0;
        for (Entry entry : entries) {
            price += entry.getTotalPrice();
        }
        return price;
    }

    public double getTotalPrice(String department) {
        double price = 0;
        for (Entry entry : entries) {
            if(entry.getDepartment().equals(department)) {
                price += entry.getTotalPrice();
            }
        }
        return price;
    }

    public String getMostExpensiveDepartment() {
        String mostExpensive = null;
        double mostExpensivePrice = 0;
        for (Entry entry : entries) {
            if(getTotalPrice(entry.getDepartment()) > mostExpensivePrice) {
                mostExpensivePrice = getTotalPrice(entry.getDepartment());
                mostExpensive = entry.getDepartment();
            }
        }
        return mostExpensive;
    }

    public Set<String> getDepartments() {
        Set<String> departments = new HashSet<>();
        for (Entry entry : entries) {
            departments.add(entry.getDepartment());
        }
        return departments;
    }
}
