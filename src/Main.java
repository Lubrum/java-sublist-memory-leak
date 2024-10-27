import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final List<List<Integer>> data = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            final List<Integer> integersList = IntStream.rangeClosed(1, 500000)
                .boxed()
                .collect(Collectors.toList());

            printListSize(integersList);
            System.out.println();
            integersList.subList(0, 0).forEach(System.out::print);
            System.out.println();
            //data.add(new ArrayList<>(integersList.subList(0, 1))); this is the correct and safe way
            data.add(integersList.subList(0, 1)); // this way we will have soon OOM error

            Thread.sleep(200);

            printMemoryUsage(i);
        }
    }

    private static void printListSize(final List<Integer> integersList) {
        long listBytesSize = ObjectSizeFetcher.getObjectSize(integersList);
        long totalSize = 0;
        for (final Integer j : integersList) {
            totalSize += ObjectSizeFetcher.getObjectSize(j);
        }

        System.out.print(" Size of List: " + (listBytesSize + totalSize)/1000000.0 + " MB");
    }

    private static void printMemoryUsage(int count) {
        final Runtime runtime = Runtime.getRuntime();
        final long usedMemory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println(" Count: " + count +
            ", Used memory: " + usedMemory / (1024 * 1024) + " MB" +
            ", Free memory: " + runtime.freeMemory() / (1024 * 1024) + " MB" +
            ", Total memory: " + runtime.totalMemory() / (1024 * 1024) + " MB"
        );
    }
}