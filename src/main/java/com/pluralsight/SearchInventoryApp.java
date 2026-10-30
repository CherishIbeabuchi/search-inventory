package com.pluralsight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class SearchInventoryApp {

    public static void main(String[] args) {

        /// cScans for life
        Scanner cScans = new Scanner(System.in);

        ArrayList<Product> inventory = getInventory();

        /// Sort the products by name (Alphabetically)
        Collections.sort(inventory,Comparator.comparing(Product::getName));

        /// Variable used to store the user's menu choice
        int menuChoice = 0;

        /// My Header Trying to be more creative
        System.out.println("""
        \n=============================================
                 ♞ KNIGHT STORE INVENTORY ♞
        =============================================
                 Chess Equipment & Accessories
        ==============================================
        """);

        ///* ... My LOOP
        while (menuChoice != 5) {

            System.out.println();
            System.out.println("------------------ MENU ----------------");
            System.out.println("1. List All Products");
            System.out.println("2. Lookup Product By ID");
            System.out.println("3. Find Products By Price Range");
            System.out.println("4. Add New Product");
            System.out.println("5. Quit");
            System.out.println("----------------------------------------");
            System.out.println("Enter Choice: ");

            ///Read user's menu choice
            menuChoice = cScans.nextInt();

            switch (menuChoice) {
                case 1:
                    displayInventory(inventory);
                    break;

                case 2:
                    findProductById(inventory, cScans);
                    break;
                case 3:
                    findProductByPrice(inventory, cScans);
                    break;
                case 4:
                    addProduct(inventory, cScans);
                    break;
                case 5:
                    System.out.println("\nGoodbye!");
                    break;
                default:
                    System.out.println("\nInvalid option. Please try again");

            }

        }
        //...Close my Scanner
        cScans.close();

    }
    /// Display my products in the inventory
    public static void displayInventory(ArrayList<Product> inventory) {

        System.out.println("\nInventory:");

        for (Product cProduct : inventory) {

            System.out.printf("%d | %s | $%.2f%n",
                    cProduct.getProductId(),
                    cProduct.getName(),
                    cProduct.getPrice());
        }

    }
    public static void findProductById(ArrayList<Product> inventory, Scanner cScans) {
        System.out.println("Enter Product ID: ");
        int id = cScans.nextInt();

        boolean found = false;

        for (Product cProduct : inventory) {

            if (cProduct.getProductId() == id) {

                System.out.println("\nProduct Found");
                System.out.println("ID: " + cProduct.getName());
                System.out.println("Name: " + cProduct.getProductId());
                System.out.println("Price: " + cProduct.getPrice());

                found = true;
                break;


            }

        }
        if (!found) {
            System.out.println("This product does not exist.");
        }

    }
    public static void findProductByPrice(ArrayList<Product> inventory, Scanner cScans) {
        System.out.println("Minimum Price:");
        double min = cScans.nextDouble();

        System.out.println("Maximum Price: ");
        double max = cScans.nextDouble();

        System.out.println("\nProducts in Range:");

        for (Product cProduct : inventory) {

            if (cProduct.getPrice() >= min && cProduct.getPrice() <= max) {
                System.out.printf("%d | %s | $%.2f%n",
                        cProduct.getProductId(),
                        cProduct.getName(),
                        cProduct.getPrice());

            }
        }

    }
    /// Adding a new product to the inventory
    public static void addProduct(ArrayList<Product> inventory, Scanner cScans) {

        cScans.nextLine();

        System.out.println("Enter Product ID: ");
        int id = Integer.parseInt(cScans.nextLine());

        System.out.println("Enter Product Name: ");
        String name = cScans.nextLine();

        System.out.println("Enter Product Price: ");
        double price = Double.parseDouble(cScans.nextLine());

        inventory.add(new Product(id, name, price));

        ///Re- sort inventory after adding a new product
        Collections.sort(inventory, Comparator.comparing(Product::getName));

        System.out.println("Product added successfully.");


    }
    /// Creates and returns the starting inventory
    public static ArrayList<Product> getInventory() {

        ArrayList<Product> inventory = new ArrayList<>();

        inventory.add(new Product(3001, "Tournament Chess Set", 34.99));
        inventory.add(new Product(3002, "Wooden Chess Board", 49.99));
        inventory.add(new Product(3003, "Chess Puzzle Book", 14.99));
        inventory.add(new Product(3004, "Magnetic Travel Chess Set", 24.99));
        inventory.add(new Product(3005, "Knight Chess Mug", 12.99));



        return inventory;
    }
}
