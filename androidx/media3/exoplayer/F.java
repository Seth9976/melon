package androidx.media3.exoplayer;

import U4.x;
import androidx.appcompat.app.o;

public final class f {
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public long k;
    public int l;

    @Override
    public final String toString() {
        int v = this.c;
        int v1 = this.d;
        int v2 = this.e;
        int v3 = this.f;
        int v4 = this.g;
        int v5 = this.h;
        int v6 = this.i;
        int v7 = this.j;
        long v8 = this.k;
        int v9 = this.l;
        StringBuilder stringBuilder0 = o.t(this.a, this.b, "DecoderCounters {\n decoderInits=", ",\n decoderReleases=", "\n queuedInputBuffers=");
        x.x(stringBuilder0, v, "\n skippedInputBuffers=", v1, "\n renderedOutputBuffers=");
        x.x(stringBuilder0, v2, "\n skippedOutputBuffers=", v3, "\n droppedBuffers=");
        x.x(stringBuilder0, v4, "\n droppedInputBuffers=", v5, "\n maxConsecutiveDroppedBuffers=");
        x.x(stringBuilder0, v6, "\n droppedToKeyframeEvents=", v7, "\n totalVideoFrameProcessingOffsetUs=");
        stringBuilder0.append(v8);
        stringBuilder0.append("\n videoFrameProcessingOffsetCount=");
        stringBuilder0.append(v9);
        stringBuilder0.append("\n}");
        return stringBuilder0.toString();
    }
}

