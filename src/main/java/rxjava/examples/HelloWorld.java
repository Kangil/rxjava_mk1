package rxjava.examples;

import io.reactivex.Flowable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.reactivex.Flowable.interval;

public class HelloWorld {
    public static void main(String[] args) throws Exception {
//        Flowable<String> f = Flowable.just("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

        String[] arr = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
//        Flowable<String> f = Flowable.fromArray(arr);
//        Flowable<String> f = Flowable.fromArray("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12");
//        Flowable<Long> f = Flowable.fromCallable(() -> System.currentTimeMillis());
        Integer a[] = new Integer[] { 10, 20, 30, 40 };
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(12);
        list.add(14);
        list.add(16);

//        List<String> words = Arrays.asList(
//            "12","q23"
//        );
//        Flowable<String> f = Flowable.fromIterable(Arrays.asList(
//                "the",
//                "quick",
//                "brown",
//                "fox",
//                "jumps",
//                "over",
//                "the",
//                "lazy",
//                "dog"
//        ));

        Flowable<Long> f = Flowable.interval(1000L, TimeUnit.MILLISECONDS);
        f = f.take(3);
        f.subscribe(new DebugSubscriber<>());
        Thread.sleep(5000L);
    }
}
