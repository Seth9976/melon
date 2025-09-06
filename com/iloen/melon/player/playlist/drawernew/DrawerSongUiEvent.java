package com.iloen.melon.player.playlist.drawernew;

import com.iloen.melon.playback.playlist.PlaylistId;
import com.melon.ui.I4;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUiEvent;", "Lcom/melon/ui/I4;", "OpenDrawerBottomSheet", "OnChangeLandingPlaylist", "OnShowMorePopup", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUiEvent$OnChangeLandingPlaylist;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUiEvent$OnShowMorePopup;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUiEvent$OpenDrawerBottomSheet;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class DrawerSongUiEvent implements I4 {
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\b\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000B\u001A\u00020\nHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\u000E\u001A\u00020\rHÖ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u001A\u0010\u0013\u001A\u00020\u00122\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUiEvent$OnChangeLandingPlaylist;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUiEvent;", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "landingPlaylistId", "<init>", "(Lcom/iloen/melon/playback/playlist/PlaylistId;)V", "component1", "()Lcom/iloen/melon/playback/playlist/PlaylistId;", "copy", "(Lcom/iloen/melon/playback/playlist/PlaylistId;)Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUiEvent$OnChangeLandingPlaylist;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "getLandingPlaylistId", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class OnChangeLandingPlaylist extends DrawerSongUiEvent {
        public static final int $stable;
        public final PlaylistId a;

        public OnChangeLandingPlaylist(@NotNull PlaylistId playlistId0) {
            q.g(playlistId0, "landingPlaylistId");
            super(null);
            this.a = playlistId0;
        }

        @NotNull
        public final PlaylistId component1() {
            return this.a;
        }

        @NotNull
        public final OnChangeLandingPlaylist copy(@NotNull PlaylistId playlistId0) {
            q.g(playlistId0, "landingPlaylistId");
            return new OnChangeLandingPlaylist(playlistId0);
        }

        public static OnChangeLandingPlaylist copy$default(OnChangeLandingPlaylist drawerSongUiEvent$OnChangeLandingPlaylist0, PlaylistId playlistId0, int v, Object object0) {
            if((v & 1) != 0) {
                playlistId0 = drawerSongUiEvent$OnChangeLandingPlaylist0.a;
            }
            return drawerSongUiEvent$OnChangeLandingPlaylist0.copy(playlistId0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof OnChangeLandingPlaylist ? this.a == ((OnChangeLandingPlaylist)object0).a : false;
        }

        @NotNull
        public final PlaylistId getLandingPlaylistId() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return this.a.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "OnChangeLandingPlaylist(landingPlaylistId=" + this.a + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000BJ$\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000F\u001A\u00020\u000EHÖ\u0001¢\u0006\u0004\b\u000F\u0010\u0010J\u0010\u0010\u0011\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\tJ\u001A\u0010\u0014\u001A\u00020\u00042\b\u0010\u0013\u001A\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\tR\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u0005\u0010\u000B¨\u0006\u001B"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUiEvent$OnShowMorePopup;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUiEvent;", "", "index", "", "isOwner", "<init>", "(IZ)V", "component1", "()I", "component2", "()Z", "copy", "(IZ)Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUiEvent$OnShowMorePopup;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "a", "I", "getIndex", "b", "Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class OnShowMorePopup extends DrawerSongUiEvent {
        public static final int $stable;
        public final int a;
        public final boolean b;

        public OnShowMorePopup(int v, boolean z) {
            super(null);
            this.a = v;
            this.b = z;
        }

        public final int component1() {
            return this.a;
        }

        public final boolean component2() {
            return this.b;
        }

        @NotNull
        public final OnShowMorePopup copy(int v, boolean z) {
            return new OnShowMorePopup(v, z);
        }

        public static OnShowMorePopup copy$default(OnShowMorePopup drawerSongUiEvent$OnShowMorePopup0, int v, boolean z, int v1, Object object0) {
            if((v1 & 1) != 0) {
                v = drawerSongUiEvent$OnShowMorePopup0.a;
            }
            if((v1 & 2) != 0) {
                z = drawerSongUiEvent$OnShowMorePopup0.b;
            }
            return drawerSongUiEvent$OnShowMorePopup0.copy(v, z);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof OnShowMorePopup)) {
                return false;
            }
            return this.a == ((OnShowMorePopup)object0).a ? this.b == ((OnShowMorePopup)object0).b : false;
        }

        public final int getIndex() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return Boolean.hashCode(this.b) + this.a * 0x1F;
        }

        public final boolean isOwner() {
            return this.b;
        }

        @Override
        @NotNull
        public String toString() {
            return "OnShowMorePopup(index=" + this.a + ", isOwner=" + this.b + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUiEvent$OpenDrawerBottomSheet;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUiEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class OpenDrawerBottomSheet extends DrawerSongUiEvent {
        public static final int $stable;
        @NotNull
        public static final OpenDrawerBottomSheet INSTANCE;

        static {
            OpenDrawerBottomSheet.INSTANCE = new OpenDrawerBottomSheet(null);  // 初始化器: Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUiEvent;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof OpenDrawerBottomSheet;
        }

        @Override
        public int hashCode() {
            return 0x1204A7BC;
        }

        @Override
        @NotNull
        public String toString() {
            return "OpenDrawerBottomSheet";
        }
    }

    public static final int $stable;

    public DrawerSongUiEvent(DefaultConstructorMarker defaultConstructorMarker0) {
    }
}

