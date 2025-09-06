package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.Assertions;

public final class PlaybackParameters {
    public static final PlaybackParameters DEFAULT;
    public final float pitch;
    private final int scaledUsPerMs;
    public final boolean skipSilence;
    public final float speed;

    static {
        PlaybackParameters.DEFAULT = new PlaybackParameters(1.0f);
    }

    public PlaybackParameters(float f) {
        this(f, 1.0f, false);
    }

    public PlaybackParameters(float f, float f1) {
        this(f, f1, false);
    }

    public PlaybackParameters(float f, float f1, boolean z) {
        boolean z1 = false;
        Assertions.checkArgument(Float.compare(f, 0.0f) > 0);
        if(f1 > 0.0f) {
            z1 = true;
        }
        Assertions.checkArgument(z1);
        this.speed = f;
        this.pitch = f1;
        this.skipSilence = z;
        this.scaledUsPerMs = Math.round(f * 1000.0f);
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return PlaybackParameters.class == class0 && this.speed == ((PlaybackParameters)object0).speed && this.pitch == ((PlaybackParameters)object0).pitch && this.skipSilence == ((PlaybackParameters)object0).skipSilence;
        }
        return false;
    }

    public long getMediaTimeUsForPlayoutTimeMs(long v) {
        return v * ((long)this.scaledUsPerMs);
    }

    @Override
    public int hashCode() {
        return (Float.floatToRawIntBits(this.pitch) + (Float.floatToRawIntBits(this.speed) + 0x20F) * 0x1F) * 0x1F + this.skipSilence;
    }
}

