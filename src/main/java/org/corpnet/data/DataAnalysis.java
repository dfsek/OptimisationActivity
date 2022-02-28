package org.corpnet.data;

import org.corpnet.data.util.Pair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class DataAnalysis {
    public static void main(String... args) throws IOException {
        DataFile file = new DataFile(DataAnalysis.class.getResourceAsStream("/data.csv"));
        System.out.println("Total Asset Cost: $" + file.getTotalPrice());
        System.out.println("Most Expensive Department: " + file.getMostExpensiveDepartment());
        System.out.println("Department Cost: $" + file.getTotalPrice(file.getMostExpensiveDepartment()));

        System.out.println("Departments:");
        List<Pair<String, Double>> departments = new ArrayList<>();
        for (String department : file.getDepartments()) {
            departments.add(Pair.of(department, file.getTotalPrice(department)));
        }

        departments.sort(Comparator.comparing(Pair::getRight));
        for (int i = departments.size() - 1; i >= 0; i--) {
            Pair<String, Double> department = departments.get(i);
            System.out.println(department.getLeft() + ": $" + department.getRight());
        }
    }
}
