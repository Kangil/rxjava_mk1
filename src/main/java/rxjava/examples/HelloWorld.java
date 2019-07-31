package rxjava.examples;

import io.reactivex.Flowable;
import io.reactivex.Single;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.reactivex.Flowable.interval;

public class HelloWorld {
    public static void main(String[] args) throws Exception {

        final int maxNum = 1000000;
        Single<Long> numbers = Flowable.fromCallable(() -> (int)(Math.random() * maxNum) + 1)
                .repeat(maxNum)
                .distinct()
                .timeout(100L, TimeUnit.MILLISECONDS)
                .count();
        numbers.subscribe(new DebugSingleObserver<>());


        Flowable<String> sequences = Flowable.interval(100L, TimeUnit.MILLISECONDS)
                .repeat()
                .skip(1)
                .take(10)
                .map(Object::toString);
        Flowable<String> names = Flowable.fromIterable(Arrays.asList(
                    "Emma",
                    "Liam",
                    "Noah",
                    "Ava",
                    "Lucas",
                    "Amelia",
                    "Mia"
                )).repeat()
                .take(10);
        Flowable<String> combined = Flowable.zip(sequences, names, (data1, data2) -> data1 + " " + data2);
        combined.subscribe(new DebugSubscriber<>());
        Thread.sleep(1500L);
    }
}
