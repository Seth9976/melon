package kotlinx.coroutines.selects;

public final class a implements Runnable {
    public final SelectInstance a;
    public final OnTimeout b;

    public a(SelectInstance selectInstance0, OnTimeout onTimeout0) {
        this.a = selectInstance0;
        this.b = onTimeout0;
    }

    @Override
    public final void run() {
        OnTimeout.register$lambda$0(this.a, this.b);
    }
}

