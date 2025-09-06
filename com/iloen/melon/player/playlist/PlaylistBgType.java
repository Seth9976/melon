package com.iloen.melon.player.playlist;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import pe.a;
import pe.b;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/player/playlist/PlaylistBgType;", "", "Default", "DjMalrang", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
enum PlaylistBgType {
    Default,
    DjMalrang;

    public static final PlaylistBgType[] a;
    public static final b b;

    static {
        PlaylistBgType.a = arr_playlistBgType;
        q.g(arr_playlistBgType, "entries");
        PlaylistBgType.b = new b(arr_playlistBgType);
    }

    @NotNull
    public static a getEntries() {
        return PlaylistBgType.b;
    }
}

