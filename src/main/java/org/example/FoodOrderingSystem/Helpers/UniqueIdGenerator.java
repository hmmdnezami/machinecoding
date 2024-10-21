package org.example.FoodOrderingSystem.Helpers;

public class UniqueIdGenerator {
    private String prefix;
    private long n = 1; // Java does not have `ulong`, so we use `long`

    // Constructor
    public UniqueIdGenerator(String prefix) {
        this.prefix = prefix;
    }

    // Method to generate unique ID
    public String getUid() {
        if (n == Long.MAX_VALUE) {
            n = 1;
        }
        return prefix + (n++);
    }
}
