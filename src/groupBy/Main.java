package groupBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        User user1 = new User();
        user1.setFname("John");
        user1.setLname("Brown");
        User user2 = new User();
        user2.setFname("Ban");
        user2.setLname("Cole");
        User user3 = new User();
        user3.setFname("John");
        user3.setLname("Smith");

        Account account1 = new Account();
        account1.setId("1");
        account1.setUser(user1);
        Account account2 = new Account();
        account2.setId("2");
        account2.setUser(user2);
        Account account3 = new Account();
        account3.setId("3");
        account3.setUser(user3);

        List<Account> list = Stream.of(account1, account2, account3).collect(Collectors.toList());

        // 1 variant
        System.out.println(list.stream().collect(Collectors.groupingBy(a -> a.getUser().getFname())));

        // 2 variant
        Map<String, List<User>> userMap = list.stream()
                .collect(Collectors.toMap(
                        a -> a.getUser().getFname(),
                        a -> Collections.singletonList(a.getUser()),
                        (oldValue, newValue) -> {
                            List<User> merged = new ArrayList<>(oldValue);
                            merged.addAll(newValue);
                            return merged;
                        }));
        System.out.println(userMap);
    }
}