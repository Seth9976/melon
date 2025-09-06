package androidx.window.area;

public final class b implements Runnable {
    public final RearDisplaySessionConsumer a;
    public final RearDisplaySessionImpl b;

    public b(RearDisplaySessionConsumer windowAreaControllerImpl$RearDisplaySessionConsumer0, RearDisplaySessionImpl rearDisplaySessionImpl0) {
        this.a = windowAreaControllerImpl$RearDisplaySessionConsumer0;
        this.b = rearDisplaySessionImpl0;
    }

    @Override
    public final void run() {
        RearDisplaySessionConsumer.a(this.a, this.b);
    }
}

