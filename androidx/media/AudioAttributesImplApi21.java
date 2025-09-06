package androidx.media;

import android.media.AudioAttributes;

public class AudioAttributesImplApi21 implements AudioAttributesImpl {
    public AudioAttributes a;
    public int b;

    public AudioAttributesImplApi21() {
        this.b = -1;
    }

    public AudioAttributesImplApi21(AudioAttributes audioAttributes0, int v) {
        this.a = audioAttributes0;
        this.b = -1;
    }

    @Override  // androidx.media.AudioAttributesImpl
    public final int a() {
        int v = this.b;
        return v == -1 ? AudioAttributesCompat.b(this.a.getFlags(), this.a.getUsage()) : v;
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof AudioAttributesImplApi21 ? this.a.equals(((AudioAttributesImplApi21)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.a;
    }
}

