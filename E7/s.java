package e7;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class s implements ThreadFactory {
    public final int a;
    public final Number b;

    public s() {
        this.a = 1;
        super();
        this.b = new AtomicInteger(0);
    }

    public s(AtomicLong atomicLong0) {
        this.a = 0;
        super();
        this.b = atomicLong0;
    }

    @Override
    public final Thread newThread(Runnable runnable0) {
        if(this.a != 0) {
            Thread thread0 = new Thread(runnable0);
            thread0.setName("arch_disk_io_" + ((AtomicInteger)this.b).getAndIncrement());
            return thread0;
        }
        Thread thread1 = Executors.defaultThreadFactory().newThread(new r(runnable0));
        thread1.setName("awaitEvenIfOnMainThread task continuation executor" + ((AtomicLong)this.b).getAndIncrement());
        return thread1;
    }
}

