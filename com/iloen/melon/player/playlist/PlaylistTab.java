package com.iloen.melon.player.playlist;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pe.a;
import pe.b;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0007\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001A\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000B¨\u0006\f"}, d2 = {"Lcom/iloen/melon/player/playlist/PlaylistTab;", "", "", "a", "I", "getIndex", "()I", "index", "Companion", "MUSIC", "DRAWER", "MIX_UP", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public enum PlaylistTab {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/player/playlist/PlaylistTab$Companion;", "", "", "index", "Lcom/iloen/melon/player/playlist/PlaylistTab;", "fromIndex", "(I)Lcom/iloen/melon/player/playlist/PlaylistTab;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @Nullable
        public final PlaylistTab fromIndex(int v) {
            for(Object object0: PlaylistTab.getEntries()) {
                if(((PlaylistTab)object0).getIndex() == v) {
                    return (PlaylistTab)object0;
                }
                if(false) {
                    break;
                }
            }
            return null;
        }
    }

    MUSIC(0),
    DRAWER(1),
    MIX_UP(2);

    @NotNull
    public static final Companion Companion;
    public final int a;
    public static final PlaylistTab[] b;
    public static final b c;

    static {
        PlaylistTab.b = arr_playlistTab;
        q.g(arr_playlistTab, "entries");
        PlaylistTab.c = new b(arr_playlistTab);
        PlaylistTab.Companion = new Companion(null);
    }

    public PlaylistTab(int v1) {
        this.a = v1;
    }

    @NotNull
    public static a getEntries() {
        return PlaylistTab.c;
    }

    public final int getIndex() {
        return this.a;
    }
}

