package com.google.android.exoplayer2.extractor;

import U4.x;

public final class SeekPoint {
    public static final SeekPoint START;
    public final long position;
    public final long timeUs;

    static {
        SeekPoint.START = new SeekPoint(0L, 0L);
    }

    public SeekPoint(long v, long v1) {
        this.timeUs = v;
        this.position = v1;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            return SeekPoint.class == class0 && this.timeUs == ((SeekPoint)object0).timeUs && this.position == ((SeekPoint)object0).position;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return ((int)this.timeUs) * 0x1F + ((int)this.position);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder(60);
        stringBuilder0.append("[timeUs=");
        stringBuilder0.append(this.timeUs);
        stringBuilder0.append(", position=");
        return x.h(this.position, "]", stringBuilder0);
    }
}

