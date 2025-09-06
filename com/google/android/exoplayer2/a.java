package com.google.android.exoplayer2;

public final class a implements Runnable {
    public final AudioFocusListener a;
    public final int b;

    public a(AudioFocusListener audioFocusManager$AudioFocusListener0, int v) {
        this.a = audioFocusManager$AudioFocusListener0;
        this.b = v;
    }

    @Override
    public final void run() {
        this.a.lambda$onAudioFocusChange$0(this.b);
    }
}

