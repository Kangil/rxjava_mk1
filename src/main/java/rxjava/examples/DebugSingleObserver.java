package rxjava.examples;

import io.reactivex.observers.DisposableSingleObserver;

public class DebugSingleObserver<T> extends DisposableSingleObserver<T> {
    private String label;

    DebugSingleObserver() {
        super();
    }

    DebugSingleObserver(String label) {
        super();
        this.label = label;
    }

    @Override
    public void onSuccess(T data) {
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
}
