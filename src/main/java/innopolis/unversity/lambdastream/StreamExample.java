package innopolis.unversity.lambdastream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {

        Arrays.asList(
                new Container(Arrays.asList(
                        "Hello",
                        "bob"
                )),
                new Container(Arrays.asList(
                        "Bye",
                        "john"
                ))
        ).stream()
                .flatMap(container -> container.getList().stream())
                .forEach(System.out::println);

    }

    public static class Container {
        private List<String> list;

        public Container(List<String> list) {
            this.list = list;
        }

        public List<String> getList() {
            return list;
        }
    }
}
