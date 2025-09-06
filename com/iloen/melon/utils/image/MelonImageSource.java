package com.iloen.melon.utils.image;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import pe.a;
import pe.b;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/utils/image/MelonImageSource;", "", "INTERNAL", "MELONDCF", "NETWORK", "PREMIUM", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public enum MelonImageSource {
    INTERNAL,
    MELONDCF,
    NETWORK,
    PREMIUM;

    public static final MelonImageSource[] a;
    public static final b b;

    static {
        MelonImageSource.a = arr_melonImageSource;
        q.g(arr_melonImageSource, "entries");
        MelonImageSource.b = new b(arr_melonImageSource);
    }

    @NotNull
    public static a getEntries() {
        return MelonImageSource.b;
    }
}

