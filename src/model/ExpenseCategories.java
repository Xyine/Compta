package model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseCategories {

    private static final Map<String, List<String>> CATEGORY_SUBCATEGORIES = new HashMap<>();

    static {
        CATEGORY_SUBCATEGORIES.put("Food", Arrays.asList("Groceries", "Dining out", "Fast food", "Snacks", "Beverages"));
        CATEGORY_SUBCATEGORIES.put("Housing", Arrays.asList("Rent or Mortgage", "Utilities", "Property Taxes", "Home Insurance", "Maintenance and Repairs"));
        CATEGORY_SUBCATEGORIES.put("Transportation", Arrays.asList("Gasoline or Fuel", "Public Transport", "Vehicle Maintenance", "Parking Fees", "Car Insurance"));
        CATEGORY_SUBCATEGORIES.put("Health", Arrays.asList("Health Insurance Premiums", "Doctor Visits", "Medications", "Health Supplements", "Gym Memberships"));
        CATEGORY_SUBCATEGORIES.put("Entertainment", Arrays.asList("Movies", "Concerts", "Streaming Services", "Hobbies", "Vacations"));
        CATEGORY_SUBCATEGORIES.put("Utilities", Arrays.asList("Internet", "Cable TV", "Phone", "Streaming Services", "Subscriptions"));
        CATEGORY_SUBCATEGORIES.put("Education", Arrays.asList("Tuition Fees", "Books and Supplies", "School Trips", "Educational Workshops", "Online Courses"));
        CATEGORY_SUBCATEGORIES.put("Debts and Loans", Arrays.asList("Credit Card Payments", "Student Loans", "Personal Loans", "Car Loans", "Mortgage Payments"));
        CATEGORY_SUBCATEGORIES.put("Savings and Investments", Arrays.asList("Retirement Funds", "Savings Accounts", "Stock Investments", "Mutual Funds", "Real Estate Investments"));
        CATEGORY_SUBCATEGORIES.put("Miscellaneous", Arrays.asList("Clothing", "Gifts", "Charitable Donations", "Pet Expenses", "Home Decor"));
    }

    public static List<String> getMainCategories() {
        return Arrays.asList("Food", "Housing", "Transportation", "Health", "Entertainment", "Utilities", "Education", "Debts and Loans", "Savings and Investments", "Miscellaneous");
    }

    public static List<String> getSubcategoriesForCategory(String category) {
        return CATEGORY_SUBCATEGORIES.getOrDefault(category, Arrays.asList());
    }
}
