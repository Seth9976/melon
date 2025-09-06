package androidx.car.app.model;

import U4.x;
import android.annotation.SuppressLint;
import java.time.Duration;

public final class DurationSpan extends CarSpan {
    private final long mDurationSeconds;

    private DurationSpan() {
        this.mDurationSeconds = 0L;
    }

    public DurationSpan(long v) {
        this.mDurationSeconds = v;
    }

    public static DurationSpan create(long v) {
        return new DurationSpan(v);
    }

    public static DurationSpan create(Duration duration0) {
        return j.a(duration0);
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof DurationSpan ? this.mDurationSeconds == ((DurationSpan)object0).mDurationSeconds : false;
    }

    @SuppressLint({"MethodNameUnits"})
    public long getDurationSeconds() {
        return this.mDurationSeconds;
    }

    @Override
    public int hashCode() {
        return (int)(this.mDurationSeconds ^ this.mDurationSeconds >>> 0x20);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("[seconds: ");
        return x.h(this.mDurationSeconds, "]", stringBuilder0);
    }
}

