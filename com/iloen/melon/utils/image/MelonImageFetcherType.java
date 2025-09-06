package com.iloen.melon.utils.image;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import pe.a;
import pe.b;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/utils/image/MelonImageFetcherType;", "", "Small", "Large", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public enum MelonImageFetcherType {
    Small,
    Large;

    public static final MelonImageFetcherType[] a;
    public static final b b;

    static {
        MelonImageFetcherType.a = arr_melonImageFetcherType;
        q.g(arr_melonImageFetcherType, "entries");
        MelonImageFetcherType.b = new b(arr_melonImageFetcherType);
    }

    @NotNull
    public static a getEntries() {
        return MelonImageFetcherType.b;
    }
}

