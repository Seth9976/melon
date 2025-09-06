package com.kakaoent.trevi.ad.data;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import pe.a;
import pe.b;

@Keep
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/kakaoent/trevi/ad/data/UiMode;", "", "(Ljava/lang/String;I)V", "LIGHT", "DARK", "SYSTEM", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public enum UiMode {
    LIGHT,
    DARK,
    SYSTEM;

    private static final a $ENTRIES;
    private static final UiMode[] $VALUES;

    private static final UiMode[] $values() [...] // Inlined contents

    static {
        UiMode.$VALUES = arr_uiMode;
        q.g(arr_uiMode, "entries");
        UiMode.$ENTRIES = new b(arr_uiMode);
    }

    @NotNull
    public static a getEntries() {
        return UiMode.$ENTRIES;
    }
}

