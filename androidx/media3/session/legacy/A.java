package androidx.media3.session.legacy;

import android.media.AudioAttributes;
import java.util.Objects;

public final class a {
    public final AudioAttributes a;

    public a(AudioAttributes audioAttributes0, int v) {
        this.a = audioAttributes0;
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof a ? Objects.equals(this.a, ((a)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        this.a.getClass();
        return this.a.hashCode();
    }

    @Override
    public final String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.a;
    }
}

