package androidx.car.app;

public final class e implements Runnable {
    public final CarAppBinder a;
    public final String b;
    public final IOnDoneCallback c;

    public e(CarAppBinder carAppBinder0, String s, IOnDoneCallback iOnDoneCallback0) {
        this.a = carAppBinder0;
        this.b = s;
        this.c = iOnDoneCallback0;
    }

    @Override
    public final void run() {
        this.a.lambda$getManager$7(this.b, this.c);
    }
}

