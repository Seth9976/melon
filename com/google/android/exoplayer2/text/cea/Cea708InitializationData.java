package com.google.android.exoplayer2.text.cea;

import java.util.Collections;
import java.util.List;

public final class Cea708InitializationData {
    public final boolean isWideAspectRatio;

    private Cea708InitializationData(List list0) {
        this.isWideAspectRatio = ((byte[])list0.get(0))[0] != 0;
    }

    public static List buildData(boolean z) {
        return Collections.singletonList(new byte[]{((byte)z)});
    }

    public static Cea708InitializationData fromData(List list0) {
        return new Cea708InitializationData(list0);
    }
}

