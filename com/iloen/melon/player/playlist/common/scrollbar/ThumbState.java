package com.iloen.melon.player.playlist.common.scrollbar;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import pe.a;
import pe.b;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/player/playlist/common/scrollbar/ThumbState;", "", "Active", "Inactive", "Dormant", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
enum ThumbState {
    Active,
    Inactive,
    Dormant;

    public static final ThumbState[] a;
    public static final b b;

    static {
        ThumbState.a = arr_thumbState;
        q.g(arr_thumbState, "entries");
        ThumbState.b = new b(arr_thumbState);
    }

    @NotNull
    public static a getEntries() {
        return ThumbState.b;
    }
}

