package poolstrings;

public class Main {
    public static void main(String[] args) {
        // task pool string
        String str1 = "Hello"; // String literal, pooled
        String str2 = new String("Hello"); // New string object, not pooled

        System.out.println(str1); // Prints "Hello"
        System.out.println(str2); // Prints "Hello"

        // one way pool sr2 use intern
    }
}