package main;

import main.model.Invoice;

import java.util.*;
import java.util.stream.Collectors;

public class Java8Task {
    public static void main (String[] args){
        Task1();
        Task2();
    }

    public static void Task1() {
        System.out.println("Task 1");

        List<Integer> listInt = new ArrayList<Integer>();

        for(int i = 50; i >= 1; i-- ){
            listInt.add(i);
        }

        for(int i = 51; i <= 100; i++ ){
            listInt.add(i);
        }
        System.out.println("Original = " + listInt);

//    1. Find all the even numbers using Stream
        List<Integer> evenNumbers = listInt.stream()
                .filter(num -> (num % 2) == 0)
                .collect(Collectors.toList());

        System.out.println("Even = " + evenNumbers);

//    2. Find all numbers starting with 1 using Stream
///        1st Method
        List<Integer> numStartWithOneA = listInt.stream()
                .map(n -> n.toString())
                .filter(s -> s.startsWith("1"))
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
        System.out.println("Starts with 1 (Method A) = " + numStartWithOneA);


///        2nd Method
        List<Integer> numStartWithOneB = listInt.stream()
                .filter(n -> {
                    boolean b = false;
                    while(n > 0) {
                        b = (n == 1);
                        n /= 10;
                        if (b) break;
                    };
                    return b;
                })
                .collect(Collectors.toList());

        System.out.println("Starts with 1 (Method B) = " + numStartWithOneB);

//    3. Find the total number of elements using Stream
        Long totalElements = listInt.stream()
                .collect(Collectors.counting());

        System.out.println("Total elements = " + totalElements);

//    4. Sort all numbers using Stream
        List<Integer> sortedList = listInt.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Sorted = " + sortedList);
    }

    public static void Task2() {
        System.out.println("\nTask 2");

        List<Invoice> invoices = new ArrayList<Invoice>();

        invoices.add(new Invoice(1, "Jono Oracle", 500000,"Java Training"));
        invoices.add(new Invoice(2, "Emil", 400000, "Training Python"));
        invoices.add(new Invoice(3, "Budi Oracle", 150000, "Headset"));
        invoices.add(new Invoice(4, "Ika ", 650000, "Backend Training"));
        invoices.add(new Invoice(5, "Hari Oracle", 2000000, "Monitor"));
        invoices.add(new Invoice(6, "Fita Oracle", 600000, "Design Training"));
        invoices.add(new Invoice(7, "Kintan Oracle", 400000,"Training Python"));
        invoices.add(new Invoice(8, "Dodi Oracle", 550000, "Training C++"));
        invoices.add(new Invoice(9, "Ghina Oracle", 300000, "Keyboard"));
        invoices.add(new Invoice(10, "Charlie Oracle", 500000,"Java Training"));
        invoices.add(new Invoice(11, "Laeli Oracle", 2000000,"Monitor"));
        invoices.add(new Invoice(11, "Dilla Oracle", 600000,"Design Training"));

        for (Invoice inv:invoices)
            System.out.println(inv);

        List<Invoice> oracleAndTrainingInvoices = invoices.stream()
                .filter(inv -> inv.getCustomer().contains("Oracle"))
                .filter(inv -> inv.getTitle().contains("Training"))
                .sorted(Comparator.comparingDouble(Invoice::getAmount))
                .collect(Collectors.toList());

        System.out.println("\nOracle and Training Invoices");
        for (Invoice inv:oracleAndTrainingInvoices)
            System.out.println(inv);

        List<Integer> firstFiveIds = oracleAndTrainingInvoices.stream()
                .limit(5)
                .map(Invoice::getId)
                .collect(Collectors.toList());

        System.out.println("\nFirst 5 Ids of Oracle and Training Invoices");
        for (Integer i:firstFiveIds)
            System.out.println(i);

    }
}
