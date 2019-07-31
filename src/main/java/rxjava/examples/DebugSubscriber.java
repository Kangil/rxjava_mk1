package rxjava.examples;

import io.reactivex.subscribers.DisposableSubscriber;

public class DebugSubscriber<T> extends DisposableSubscriber<T> {
    private String label;

    public DebugSubscriber() {
        super();
    }

    public DebugSubscriber(String label) {
        super();
        this.label = label;
    }

    @Override
    public void onNext(T data) {
        String threadName = Thread.currentThread().getName();
        if (label == null) {
            System.out.println(threadName + ": " + data);
        } else {
            System.out.println(threadName + ": " + label + ": " + data);
        }
    }

    @Override
    public void onError(Throwable t) {
        String threadName = Thread.currentThread().getName();
        if (label == null) {
            System.out.println(threadName + ": onError = " + t);
        } else {
            System.out.println(threadName + ": " + label + ": onError! = " + t);
        }
    }

    @Override
    public void onComplete() {
        String threadName = Thread.currentThread().getName();
        if (label == null) {
            System.out.println(threadName + ": onComplete");
        } else {
            System.out.println(threadName + ": " + label + ": onComplete!");
        }
    }
}
