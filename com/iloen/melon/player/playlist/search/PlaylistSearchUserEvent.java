package com.iloen.melon.player.playlist.search;

import Pc.e;
import com.iloen.melon.playback.Playable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import oc.H;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/player/playlist/search/PlaylistSearchUserEvent;", "LPc/e;", "ClickSongItem", "ClickAlbumThumbnail", "OnChangeDrawerPlaylistInfo", "TalkBackActionGoToAlbum", "Lcom/iloen/melon/player/playlist/search/PlaylistSearchUserEvent$ClickAlbumThumbnail;", "Lcom/iloen/melon/player/playlist/search/PlaylistSearchUserEvent$ClickSongItem;", "Lcom/iloen/melon/player/playlist/search/PlaylistSearchUserEvent$OnChangeDrawerPlaylistInfo;", "Lcom/iloen/melon/player/playlist/search/PlaylistSearchUserEvent$TalkBackActionGoToAlbum;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class PlaylistSearchUserEvent implements e {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000BJ$\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000F\u001A\u00020\u000EHÖ\u0001¢\u0006\u0004\b\u000F\u0010\u0010J\u0010\u0010\u0011\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\tJ\u001A\u0010\u0015\u001A\u00020\u00142\b\u0010\u0013\u001A\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0019\u0010\tR\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001A\u0010\u001B\u001A\u0004\b\u001C\u0010\u000B¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/player/playlist/search/PlaylistSearchUserEvent$ClickAlbumThumbnail;", "Lcom/iloen/melon/player/playlist/search/PlaylistSearchUserEvent;", "", "indexInPlaylist", "Lcom/iloen/melon/playback/Playable;", "playable", "<init>", "(ILcom/iloen/melon/playback/Playable;)V", "component1", "()I", "component2", "()Lcom/iloen/melon/playback/Playable;", "copy", "(ILcom/iloen/melon/playback/Playable;)Lcom/iloen/melon/player/playlist/search/PlaylistSearchUserEvent$ClickAlbumThumbnail;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "getIndexInPlaylist", "b", "Lcom/iloen/melon/playback/Playable;", "getPlayable", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ClickAlbumThumbnail extends PlaylistSearchUserEvent {
        public static final int $stable = 8;
        public final int a;
        public final Playable b;

        public ClickAlbumThumbnail(int v, @NotNull Playable playable0) {
            q.g(playable0, "playable");
            super(null);
            this.a = v;
            this.b = playable0;
        }

        public final int component1() {
            return this.a;
        }

        @NotNull
        public final Playable component2() {
            return this.b;
        }

        @NotNull
        public final ClickAlbumThumbnail copy(int v, @NotNull Playable playable0) {
            q.g(playable0, "playable");
            return new ClickAlbumThumbnail(v, playable0);
        }

        public static ClickAlbumThumbnail copy$default(ClickAlbumThumbnail playlistSearchUserEvent$ClickAlbumThumbnail0, int v, Playable playable0, int v1, Object object0) {
            if((v1 & 1) != 0) {
                v = playlistSearchUserEvent$ClickAlbumThumbnail0.a;
            }
            if((v1 & 2) != 0) {
                playable0 = playlistSearchUserEvent$ClickAlbumThumbnail0.b;
            }
            return playlistSearchUserEvent$ClickAlbumThumbnail0.copy(v, playable0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof ClickAlbumThumbnail)) {
                return false;
            }
            return this.a == ((ClickAlbumThumbnail)object0).a ? q.b(this.b, ((ClickAlbumThumbnail)object0).b) : false;
        }

        public final int getIndexInPlaylist() {
            return this.a;
        }

        @NotNull
        public final Playable getPlayable() {
            return this.b;
        }

        @Override
        public int hashCode() {
            return this.b.hashCode() + this.a * 0x1F;
        }

        @Override
        @NotNull
        public String toString() {
            return "ClickAlbumThumbnail(indexInPlaylist=" + this.a + ", playable=" + this.b + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\b\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000B\u001A\u00020\nHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\r\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0007J\u001A\u0010\u0011\u001A\u00020\u00102\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u0015\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/player/playlist/search/PlaylistSearchUserEvent$ClickSongItem;", "Lcom/iloen/melon/player/playlist/search/PlaylistSearchUserEvent;", "", "indexInPlaylist", "<init>", "(I)V", "component1", "()I", "copy", "(I)Lcom/iloen/melon/player/playlist/search/PlaylistSearchUserEvent$ClickSongItem;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "getIndexInPlaylist", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ClickSongItem extends PlaylistSearchUserEvent {
        public static final int $stable;
        public final int a;

        public ClickSongItem(int v) {
            super(null);
            this.a = v;
        }

        public final int component1() {
            return this.a;
        }

        @NotNull
        public final ClickSongItem copy(int v) {
            return new ClickSongItem(v);
        }

        public static ClickSongItem copy$default(ClickSongItem playlistSearchUserEvent$ClickSongItem0, int v, int v1, Object object0) {
            if((v1 & 1) != 0) {
                v = playlistSearchUserEvent$ClickSongItem0.a;
            }
            return playlistSearchUserEvent$ClickSongItem0.copy(v);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof ClickSongItem ? this.a == ((ClickSongItem)object0).a : false;
        }

        public final int getIndexInPlaylist() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return this.a;
        }

        @Override
        @NotNull
        public String toString() {
            return "ClickSongItem(indexInPlaylist=" + this.a + ")";
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\u0010\u0004\u001A\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001A\u0010\u0007\u001A\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ$\u0010\t\u001A\u00020\u00002\u0012\b\u0002\u0010\u0004\u001A\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001A\u00020\u000BHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000F\u001A\u00020\u000EHÖ\u0001¢\u0006\u0004\b\u000F\u0010\u0010J\u001A\u0010\u0014\u001A\u00020\u00132\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R!\u0010\u0004\u001A\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/iloen/melon/player/playlist/search/PlaylistSearchUserEvent$OnChangeDrawerPlaylistInfo;", "Lcom/iloen/melon/player/playlist/search/PlaylistSearchUserEvent;", "Loc/H;", "Loc/Q;", "playlist", "<init>", "(Loc/H;)V", "component1", "()Loc/H;", "copy", "(Loc/H;)Lcom/iloen/melon/player/playlist/search/PlaylistSearchUserEvent$OnChangeDrawerPlaylistInfo;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Loc/H;", "getPlaylist", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class OnChangeDrawerPlaylistInfo extends PlaylistSearchUserEvent {
        public static final int $stable = 8;
        public final H a;

        public OnChangeDrawerPlaylistInfo(@Nullable H h0) {
            super(null);
            this.a = h0;
        }

        @Nullable
        public final H component1() {
            return this.a;
        }

        @NotNull
        public final OnChangeDrawerPlaylistInfo copy(@Nullable H h0) {
            return new OnChangeDrawerPlaylistInfo(h0);
        }

        public static OnChangeDrawerPlaylistInfo copy$default(OnChangeDrawerPlaylistInfo playlistSearchUserEvent$OnChangeDrawerPlaylistInfo0, H h0, int v, Object object0) {
            if((v & 1) != 0) {
                h0 = playlistSearchUserEvent$OnChangeDrawerPlaylistInfo0.a;
            }
            return playlistSearchUserEvent$OnChangeDrawerPlaylistInfo0.copy(h0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof OnChangeDrawerPlaylistInfo ? q.b(this.a, ((OnChangeDrawerPlaylistInfo)object0).a) : false;
        }

        @Nullable
        public final H getPlaylist() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return this.a == null ? 0 : this.a.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "OnChangeDrawerPlaylistInfo(playlist=" + this.a + ")";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000BJ$\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000F\u001A\u00020\u000EHÖ\u0001¢\u0006\u0004\b\u000F\u0010\u0010J\u0010\u0010\u0011\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\tJ\u001A\u0010\u0015\u001A\u00020\u00142\b\u0010\u0013\u001A\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0019\u0010\tR\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001A\u0010\u001B\u001A\u0004\b\u001C\u0010\u000B¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/player/playlist/search/PlaylistSearchUserEvent$TalkBackActionGoToAlbum;", "Lcom/iloen/melon/player/playlist/search/PlaylistSearchUserEvent;", "", "position", "Lcom/iloen/melon/playback/Playable;", "playable", "<init>", "(ILcom/iloen/melon/playback/Playable;)V", "component1", "()I", "component2", "()Lcom/iloen/melon/playback/Playable;", "copy", "(ILcom/iloen/melon/playback/Playable;)Lcom/iloen/melon/player/playlist/search/PlaylistSearchUserEvent$TalkBackActionGoToAlbum;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "getPosition", "b", "Lcom/iloen/melon/playback/Playable;", "getPlayable", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class TalkBackActionGoToAlbum extends PlaylistSearchUserEvent {
        public static final int $stable = 8;
        public final int a;
        public final Playable b;

        public TalkBackActionGoToAlbum(int v, @NotNull Playable playable0) {
            q.g(playable0, "playable");
            super(null);
            this.a = v;
            this.b = playable0;
        }

        public final int component1() {
            return this.a;
        }

        @NotNull
        public final Playable component2() {
            return this.b;
        }

        @NotNull
        public final TalkBackActionGoToAlbum copy(int v, @NotNull Playable playable0) {
            q.g(playable0, "playable");
            return new TalkBackActionGoToAlbum(v, playable0);
        }

        public static TalkBackActionGoToAlbum copy$default(TalkBackActionGoToAlbum playlistSearchUserEvent$TalkBackActionGoToAlbum0, int v, Playable playable0, int v1, Object object0) {
            if((v1 & 1) != 0) {
                v = playlistSearchUserEvent$TalkBackActionGoToAlbum0.a;
            }
            if((v1 & 2) != 0) {
                playable0 = playlistSearchUserEvent$TalkBackActionGoToAlbum0.b;
            }
            return playlistSearchUserEvent$TalkBackActionGoToAlbum0.copy(v, playable0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof TalkBackActionGoToAlbum)) {
                return false;
            }
            return this.a == ((TalkBackActionGoToAlbum)object0).a ? q.b(this.b, ((TalkBackActionGoToAlbum)object0).b) : false;
        }

        @NotNull
        public final Playable getPlayable() {
            return this.b;
        }

        public final int getPosition() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return this.b.hashCode() + this.a * 0x1F;
        }

        @Override
        @NotNull
        public String toString() {
            return "TalkBackActionGoToAlbum(position=" + this.a + ", playable=" + this.b + ")";
        }
    }

    public static final int $stable;

    public PlaylistSearchUserEvent(DefaultConstructorMarker defaultConstructorMarker0) {
    }
}

