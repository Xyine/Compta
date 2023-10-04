package model;

public class Transaction {
    private String category;
    private String subcategory; // New field for subcategory
    private float amount;

    public Transaction(String category, String subcategory, float amount) {
        this.category = category;
        this.subcategory = subcategory;
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public float getAmount() {
        return amount;
    }
}
