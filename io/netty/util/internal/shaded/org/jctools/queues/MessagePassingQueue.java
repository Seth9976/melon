package io.netty.util.internal.shaded.org.jctools.queues;

public interface MessagePassingQueue {
    public interface Consumer {
        void accept(Object arg1);
    }

    public interface ExitCondition {
        boolean keepRunning();
    }

    public interface Supplier {
        Object get();
    }

    public interface WaitStrategy {
        int idle(int arg1);
    }

    public static final int UNBOUNDED_CAPACITY = -1;

    int capacity();

    void clear();

    int drain(Consumer arg1);

    int drain(Consumer arg1, int arg2);

    void drain(Consumer arg1, WaitStrategy arg2, ExitCondition arg3);

    int fill(Supplier arg1);

    int fill(Supplier arg1, int arg2);

    void fill(Supplier arg1, WaitStrategy arg2, ExitCondition arg3);

    boolean isEmpty();

    boolean offer(Object arg1);

    Object peek();

    Object poll();

    boolean relaxedOffer(Object arg1);

    Object relaxedPeek();

    Object relaxedPoll();

    int size();
}

