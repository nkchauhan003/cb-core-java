package java8.methodreference;

public class ConstructorReferenceMultipleParameter {

    public static void main(String[] args) {
        FourParameterFunction<Integer, String, Integer, User> user = User::new;
        System.out.println(user.apply(1, "Diana", 16)); // User{id=1, name='Diana', age=16}
    }

    @FunctionalInterface
    private interface FourParameterFunction<T, U, V, W> {
        W apply(T t, U u, V v);
    }
}
