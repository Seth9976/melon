package com.google.android.material.datepicker;

public final class k implements Runnable {
    public final int a;
    public final p b;

    public k(p p0, int v) {
        this.b = p0;
        this.a = v;
    }

    @Override
    public final void run() {
        this.b.j.smoothScrollToPosition(this.a);
    }
}

