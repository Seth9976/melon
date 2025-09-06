package com.google.android.exoplayer2.decoder;

public abstract class Buffer {
    private int flags;

    public final void addFlag(int v) {
        this.flags |= v;
    }

    public void clear() {
        this.flags = 0;
    }

    public final void clearFlag(int v) {
        this.flags &= ~v;
    }

    public final boolean getFlag(int v) {
        return (this.flags & v) == v;
    }

    public final boolean hasSupplementalData() {
        return this.getFlag(0x10000000);
    }

    public final boolean isDecodeOnly() {
        return this.getFlag(0x80000000);
    }

    public final boolean isEndOfStream() {
        return this.getFlag(4);
    }

    public final boolean isKeyFrame() {
        return this.getFlag(1);
    }

    public final void setFlags(int v) {
        this.flags = v;
    }
}

