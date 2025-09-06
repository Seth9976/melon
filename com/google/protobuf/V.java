package com.google.protobuf;

import java.io.IOException;
import k8.Y;

public final class v extends IOException {
    private static final long serialVersionUID = 0x9F95917C52CE6E25L;

    public v(int v, int v1, int v2, IndexOutOfBoundsException indexOutOfBoundsException0) {
        StringBuilder stringBuilder0 = Y.o(v, "Pos: ", ", limit: ");
        stringBuilder0.append(((long)v1));
        stringBuilder0.append(", len: ");
        stringBuilder0.append(v2);
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + stringBuilder0.toString(), indexOutOfBoundsException0);
    }

    public v(IndexOutOfBoundsException indexOutOfBoundsException0) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", indexOutOfBoundsException0);
    }
}

