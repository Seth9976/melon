package com.google.android.exoplayer2.upstream;

public final class b implements Runnable {
    public final ConnectivityActionReceiver a;
    public final DefaultBandwidthMeter b;

    public b(ConnectivityActionReceiver defaultBandwidthMeter$ConnectivityActionReceiver0, DefaultBandwidthMeter defaultBandwidthMeter0) {
        this.a = defaultBandwidthMeter$ConnectivityActionReceiver0;
        this.b = defaultBandwidthMeter0;
    }

    @Override
    public final void run() {
        this.a.lambda$register$0(this.b);
    }
}

