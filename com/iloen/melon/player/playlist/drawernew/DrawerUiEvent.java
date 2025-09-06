package com.iloen.melon.player.playlist.drawernew;

import com.iloen.melon.player.playlist.DrawerPlaylistTabInfo;
import com.melon.ui.I4;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerUiEvent;", "Lcom/melon/ui/I4;", "OnOpenDrawerSongPlaylist", "OnFailOpenDrawerSmartPlaylist", "Lcom/iloen/melon/player/playlist/drawernew/DrawerUiEvent$OnFailOpenDrawerSmartPlaylist;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerUiEvent$OnOpenDrawerSongPlaylist;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class DrawerUiEvent implements I4 {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerUiEvent$OnFailOpenDrawerSmartPlaylist;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerUiEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class OnFailOpenDrawerSmartPlaylist extends DrawerUiEvent {
        public static final int $stable;
        @NotNull
        public static final OnFailOpenDrawerSmartPlaylist INSTANCE;

        static {
            OnFailOpenDrawerSmartPlaylist.INSTANCE = new OnFailOpenDrawerSmartPlaylist(null);  // 初始化器: Lcom/iloen/melon/player/playlist/drawernew/DrawerUiEvent;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof OnFailOpenDrawerSmartPlaylist;
        }

        @Override
        public int hashCode() {
            return 0x7A76EDFB;
        }

        @Override
        @NotNull
        public String toString() {
            return "OnFailOpenDrawerSmartPlaylist";
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\b\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000B\u001A\u00020\nHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\u000E\u001A\u00020\rHÖ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u001A\u0010\u0013\u001A\u00020\u00122\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerUiEvent$OnOpenDrawerSongPlaylist;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerUiEvent;", "Lcom/iloen/melon/player/playlist/DrawerPlaylistTabInfo;", "playlistTabInfo", "<init>", "(Lcom/iloen/melon/player/playlist/DrawerPlaylistTabInfo;)V", "component1", "()Lcom/iloen/melon/player/playlist/DrawerPlaylistTabInfo;", "copy", "(Lcom/iloen/melon/player/playlist/DrawerPlaylistTabInfo;)Lcom/iloen/melon/player/playlist/drawernew/DrawerUiEvent$OnOpenDrawerSongPlaylist;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lcom/iloen/melon/player/playlist/DrawerPlaylistTabInfo;", "getPlaylistTabInfo", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class OnOpenDrawerSongPlaylist extends DrawerUiEvent {
        public static final int $stable = 8;
        public final DrawerPlaylistTabInfo a;

        public OnOpenDrawerSongPlaylist(@NotNull DrawerPlaylistTabInfo drawerPlaylistTabInfo0) {
            q.g(drawerPlaylistTabInfo0, "playlistTabInfo");
            super(null);
            this.a = drawerPlaylistTabInfo0;
        }

        @NotNull
        public final DrawerPlaylistTabInfo component1() {
            return this.a;
        }

        @NotNull
        public final OnOpenDrawerSongPlaylist copy(@NotNull DrawerPlaylistTabInfo drawerPlaylistTabInfo0) {
            q.g(drawerPlaylistTabInfo0, "playlistTabInfo");
            return new OnOpenDrawerSongPlaylist(drawerPlaylistTabInfo0);
        }

        public static OnOpenDrawerSongPlaylist copy$default(OnOpenDrawerSongPlaylist drawerUiEvent$OnOpenDrawerSongPlaylist0, DrawerPlaylistTabInfo drawerPlaylistTabInfo0, int v, Object object0) {
            if((v & 1) != 0) {
                drawerPlaylistTabInfo0 = drawerUiEvent$OnOpenDrawerSongPlaylist0.a;
            }
            return drawerUiEvent$OnOpenDrawerSongPlaylist0.copy(drawerPlaylistTabInfo0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof OnOpenDrawerSongPlaylist ? q.b(this.a, ((OnOpenDrawerSongPlaylist)object0).a) : false;
        }

        @NotNull
        public final DrawerPlaylistTabInfo getPlaylistTabInfo() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return this.a.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "OnOpenDrawerSongPlaylist(playlistTabInfo=" + this.a + ")";
        }
    }

    public static final int $stable;

    public DrawerUiEvent(DefaultConstructorMarker defaultConstructorMarker0) {
    }
}

