package com.google.android.material.slider;

public final class d implements Runnable {
    public int a;
    public final BaseSlider b;

    public d(BaseSlider baseSlider0) {
        this.b = baseSlider0;
        this.a = -1;
    }

    @Override
    public final void run() {
        this.b.h.o(this.a, 4);
    }
}

