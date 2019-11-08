package innopolis.unversity.lambdastream;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaExample {
    public static void main(String[] args) {
        Consumer<String> consumer = System.out::println;
        consumer.accept("Hello world");

        Function<Integer, Age> function = Age::new;
        System.out.println(function.apply(100));

        Supplier<Age> supplier = Age::new;
        System.out.println(supplier.get());

        Predicate<String> predicate = "Hello world"::equals;
        System.out.println(predicate.test("Hello world"));

        Optional<Age> optional = generateObject();
        Age obj = optional.map(age -> {
            age.setAge(10);
            return age;
        })
                .orElse(new Age());
        System.out.println(obj);

    }

    private Age supllier12376513721538() {
        Supplier<Age> supplier = new Supplier<Age>() {
            @Override
            public Age get() {
                return new Age();
            }
        };
        return null;
    }

    public static class Age {
        private Integer age;

        public Age() {
        }

        public Age(Integer age) {
            this.age = age;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "age: " + age;
        }
    }

    public static Optional<Age> generateObject() {
        return Optional.ofNullable(Math.random() > 0.5 ? new Age() : null);
    }
}
