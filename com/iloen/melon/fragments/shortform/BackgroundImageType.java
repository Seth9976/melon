package com.iloen.melon.fragments.shortform;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import pe.a;
import pe.b;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/fragments/shortform/BackgroundImageType;", "", "<init>", "(Ljava/lang/String;I)V", "M", "N", "D", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public enum BackgroundImageType {
    M,
    N,
    D;

    private static final a $ENTRIES;
    private static final BackgroundImageType[] $VALUES;

    private static final BackgroundImageType[] $values() [...] // Inlined contents

    static {
        BackgroundImageType.$VALUES = arr_backgroundImageType;
        q.g(arr_backgroundImageType, "entries");
        BackgroundImageType.$ENTRIES = new b(arr_backgroundImageType);
    }

    @NotNull
    public static a getEntries() {
        return BackgroundImageType.$ENTRIES;
    }
}

