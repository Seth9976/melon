package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Assertions;

public final class SeekParameters {
    public static final SeekParameters CLOSEST_SYNC;
    public static final SeekParameters DEFAULT;
    public static final SeekParameters EXACT;
    public static final SeekParameters NEXT_SYNC;
    public static final SeekParameters PREVIOUS_SYNC;
    public final long toleranceAfterUs;
    public final long toleranceBeforeUs;

    static {
        SeekParameters seekParameters0 = new SeekParameters(0L, 0L);
        SeekParameters.EXACT = seekParameters0;
        SeekParameters.CLOSEST_SYNC = new SeekParameters(0x7FFFFFFFFFFFFFFFL, 0x7FFFFFFFFFFFFFFFL);
        SeekParameters.PREVIOUS_SYNC = new SeekParameters(0x7FFFFFFFFFFFFFFFL, 0L);
        SeekParameters.NEXT_SYNC = new SeekParameters(0L, 0x7FFFFFFFFFFFFFFFL);
        SeekParameters.DEFAULT = seekParameters0;
    }

    public SeekParameters(long v, long v1) {
        boolean z = false;
        Assertions.checkArgument(Long.compare(v, 0L) >= 0);
        if(v1 >= 0L) {
            z = true;
        }
        Assertions.checkArgument(z);
        this.toleranceBeforeUs = v;
        this.toleranceAfterUs = v1;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return SeekParameters.class == class0 && this.toleranceBeforeUs == ((SeekParameters)object0).toleranceBeforeUs && this.toleranceAfterUs == ((SeekParameters)object0).toleranceAfterUs;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return ((int)this.toleranceBeforeUs) * 0x1F + ((int)this.toleranceAfterUs);
    }
}

