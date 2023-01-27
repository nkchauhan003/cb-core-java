package java8.lambda;

public class LambdasDemo {

    @FunctionalInterface
    interface UserName {
        // single abstract method
        String getFullName(String firstName, String lastName);
    }

    public static void main(String[] args) {

        // Before Java 8
        UserName userNameBeforeJava8 = new UserName() {
            @Override
            public String getFullName(String firstName, String lastName) {
                return firstName + " " + lastName;
            }
        };
        String fullNameBeforeJava8 = userNameBeforeJava8.getFullName("Tech", "Burps");

        // With Java 8
        UserName userNameInJava8 = (firstName, lastName) -> firstName + " " + lastName;
        String fullNameInJava8 = userNameInJava8.getFullName("Tech", "Burps");
    }
}
