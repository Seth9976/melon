package androidx.window.area;

public final class a implements Runnable {
    public final int a;
    public final int b;
    public final RearDisplayPresentationSessionConsumer c;
    public final WindowAreaControllerImpl d;

    public a(int v, int v1, RearDisplayPresentationSessionConsumer windowAreaControllerImpl$RearDisplayPresentationSessionConsumer0, WindowAreaControllerImpl windowAreaControllerImpl0) {
        this.a = v;
        this.b = v1;
        this.c = windowAreaControllerImpl$RearDisplayPresentationSessionConsumer0;
        this.d = windowAreaControllerImpl0;
    }

    @Override
    public final void run() {
        RearDisplayPresentationSessionConsumer.a(this.a, this.b, this.c, this.d);
    }
}

