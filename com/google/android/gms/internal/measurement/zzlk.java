package com.google.android.gms.internal.measurement;

import java.io.IOException;
import k8.Y;

public final class zzlk extends IOException {
    public zzlk() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    public zzlk(long v, long v1, int v2, Throwable throwable0) {
        StringBuilder stringBuilder0 = Y.o(v, "Pos: ", ", limit: ");
        stringBuilder0.append(v1);
        stringBuilder0.append(", len: ");
        stringBuilder0.append(v2);
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + stringBuilder0.toString(), throwable0);
    }

    public zzlk(Throwable throwable0) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", throwable0);
    }
}

