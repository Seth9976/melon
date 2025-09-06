package com.iloen.melon.player.playlist.music;

import Pc.e;
import com.iloen.melon.playback.Playable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import oc.y0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\r\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000B\f\r\u000E\u0082\u0001\r\u000F\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001A\u001B¨\u0006\u001C"}, d2 = {"Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent;", "LPc/e;", "ClickSongItem", "ClickAlbumThumbnail", "ClickCheckBoxSongItem", "ClickGroupTitle", "MoveSongItem", "OnTouchDownMoveIconWhenSelectRepeatOn", "ClickAllSelectUserEvent", "ClickSortOrderUserEvent", "ClickSortTypeInPopupUserEvent", "ToolBarClickReplayUserEvent", "ToolBarClickPutUserEvent", "ToolBarClickRemoveUserEvent", "ClickPutInMorePopupUserEvent", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent$ClickAlbumThumbnail;", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent$ClickAllSelectUserEvent;", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent$ClickCheckBoxSongItem;", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent$ClickGroupTitle;", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent$ClickPutInMorePopupUserEvent;", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent$ClickSongItem;", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent$ClickSortOrderUserEvent;", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent$ClickSortTypeInPopupUserEvent;", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent$MoveSongItem;", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent$OnTouchDownMoveIconWhenSelectRepeatOn;", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent$ToolBarClickPutUserEvent;", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent$ToolBarClickRemoveUserEvent;", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent$ToolBarClickReplayUserEvent;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class MusicPlaylistBaseUserEvent implements e {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\b\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000B\u001A\u00020\nHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\r\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0007J\u001A\u0010\u0011\u001A\u00020\u00102\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u0015\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent$ClickAlbumThumbnail;", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent;", "", "position", "<init>", "(I)V", "component1", "()I", "copy", "(I)Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent$ClickAlbumThumbnail;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "getPosition", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ClickAlbumThumbnail extends MusicPlaylistBaseUserEvent {
        public static final int $stable;
        public final int a;

        public ClickAlbumThumbnail(int v) {
            super(null);
            this.a = v;
        }

        public final int component1() {
            return this.a;
        }

        @NotNull
        public final ClickAlbumThumbnail copy(int v) {
            return new ClickAlbumThumbnail(v);
        }

        public static ClickAlbumThumbnail copy$default(ClickAlbumThumbnail musicPlaylistBaseUserEvent$ClickAlbumThumbnail0, int v, int v1, Object object0) {
            if((v1 & 1) != 0) {
                v = musicPlaylistBaseUserEvent$ClickAlbumThumbnail0.a;
            }
            return musicPlaylistBaseUserEvent$ClickAlbumThumbnail0.copy(v);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof ClickAlbumThumbnail ? this.a == ((ClickAlbumThumbnail)object0).a : false;
        }

        public final int getPosition() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return this.a;
        }

        @Override
        @NotNull
        public String toString() {
            return "ClickAlbumThumbnail(position=" + this.a + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent$ClickAllSelectUserEvent;", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ClickAllSelectUserEvent extends MusicPlaylistBaseUserEvent {
        public static final int $stable;
        @NotNull
        public static final ClickAllSelectUserEvent INSTANCE;

        static {
            ClickAllSelectUserEvent.INSTANCE = new ClickAllSelectUserEvent(null);  // 初始化器: Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof ClickAllSelectUserEvent;
        }

        @Override
        public int hashCode() {
            return 0xBA180ECC;
        }

        @Override
        @NotNull
        public String toString() {
            return "ClickAllSelectUserEvent";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\b\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000B\u001A\u00020\nHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\r\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0007J\u001A\u0010\u0011\u001A\u00020\u00102\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u0015\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent$ClickCheckBoxSongItem;", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent;", "", "position", "<init>", "(I)V", "component1", "()I", "copy", "(I)Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent$ClickCheckBoxSongItem;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "getPosition", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ClickCheckBoxSongItem extends MusicPlaylistBaseUserEvent {
        public static final int $stable;
        public final int a;

        public ClickCheckBoxSongItem(int v) {
            super(null);
            this.a = v;
        }

        public final int component1() {
            return this.a;
        }

        @NotNull
        public final ClickCheckBoxSongItem copy(int v) {
            return new ClickCheckBoxSongItem(v);
        }

        public static ClickCheckBoxSongItem copy$default(ClickCheckBoxSongItem musicPlaylistBaseUserEvent$ClickCheckBoxSongItem0, int v, int v1, Object object0) {
            if((v1 & 1) != 0) {
                v = musicPlaylistBaseUserEvent$ClickCheckBoxSongItem0.a;
            }
            return musicPlaylistBaseUserEvent$ClickCheckBoxSongItem0.copy(v);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof ClickCheckBoxSongItem ? this.a == ((ClickCheckBoxSongItem)object0).a : false;
        }

        public final int getPosition() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return this.a;
        }

        @Override
        @NotNull
        public String toString() {
            return "ClickCheckBoxSongItem(position=" + this.a + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ$\u0010\n\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0004\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000BJ\u0010\u0010\r\u001A\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000EJ\u0010\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000F\u0010\bJ\u001A\u0010\u0013\u001A\u00020\u00122\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\bR\u0017\u0010\u0004\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0016\u001A\u0004\b\u0019\u0010\b¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent$ClickGroupTitle;", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent;", "", "groupItemStartIndex", "count", "<init>", "(II)V", "component1", "()I", "component2", "copy", "(II)Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent$ClickGroupTitle;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "getGroupItemStartIndex", "b", "getCount", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ClickGroupTitle extends MusicPlaylistBaseUserEvent {
        public static final int $stable;
        public final int a;
        public final int b;

        public ClickGroupTitle(int v, int v1) {
            super(null);
            this.a = v;
            this.b = v1;
        }

        public final int component1() {
            return this.a;
        }

        public final int component2() {
            return this.b;
        }

        @NotNull
        public final ClickGroupTitle copy(int v, int v1) {
            return new ClickGroupTitle(v, v1);
        }

        public static ClickGroupTitle copy$default(ClickGroupTitle musicPlaylistBaseUserEvent$ClickGroupTitle0, int v, int v1, int v2, Object object0) {
            if((v2 & 1) != 0) {
                v = musicPlaylistBaseUserEvent$ClickGroupTitle0.a;
            }
            if((v2 & 2) != 0) {
                v1 = musicPlaylistBaseUserEvent$ClickGroupTitle0.b;
            }
            return musicPlaylistBaseUserEvent$ClickGroupTitle0.copy(v, v1);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof ClickGroupTitle)) {
                return false;
            }
            return this.a == ((ClickGroupTitle)object0).a ? this.b == ((ClickGroupTitle)object0).b : false;
        }

        public final int getCount() {
            return this.b;
        }

        public final int getGroupItemStartIndex() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return this.b + this.a * 0x1F;
        }

        @Override
        @NotNull
        public String toString() {
            return "ClickGroupTitle(groupItemStartIndex=" + this.a + ", count=" + this.b + ")";
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\b\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000B\u001A\u00020\nHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\u000E\u001A\u00020\rHÖ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u001A\u0010\u0013\u001A\u00020\u00122\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent$ClickPutInMorePopupUserEvent;", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent;", "Lcom/iloen/melon/playback/Playable;", "playable", "<init>", "(Lcom/iloen/melon/playback/Playable;)V", "component1", "()Lcom/iloen/melon/playback/Playable;", "copy", "(Lcom/iloen/melon/playback/Playable;)Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent$ClickPutInMorePopupUserEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lcom/iloen/melon/playback/Playable;", "getPlayable", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ClickPutInMorePopupUserEvent extends MusicPlaylistBaseUserEvent {
        public static final int $stable = 8;
        public final Playable a;

        public ClickPutInMorePopupUserEvent(@NotNull Playable playable0) {
            q.g(playable0, "playable");
            super(null);
            this.a = playable0;
        }

        @NotNull
        public final Playable component1() {
            return this.a;
        }

        @NotNull
        public final ClickPutInMorePopupUserEvent copy(@NotNull Playable playable0) {
            q.g(playable0, "playable");
            return new ClickPutInMorePopupUserEvent(playable0);
        }

        public static ClickPutInMorePopupUserEvent copy$default(ClickPutInMorePopupUserEvent musicPlaylistBaseUserEvent$ClickPutInMorePopupUserEvent0, Playable playable0, int v, Object object0) {
            if((v & 1) != 0) {
                playable0 = musicPlaylistBaseUserEvent$ClickPutInMorePopupUserEvent0.a;
            }
            return musicPlaylistBaseUserEvent$ClickPutInMorePopupUserEvent0.copy(playable0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof ClickPutInMorePopupUserEvent ? q.b(this.a, ((ClickPutInMorePopupUserEvent)object0).a) : false;
        }

        @NotNull
        public final Playable getPlayable() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return this.a.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "ClickPutInMorePopupUserEvent(playable=" + this.a + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\b\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000B\u001A\u00020\nHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\r\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0007J\u001A\u0010\u0011\u001A\u00020\u00102\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u0015\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent$ClickSongItem;", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent;", "", "position", "<init>", "(I)V", "component1", "()I", "copy", "(I)Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent$ClickSongItem;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "getPosition", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ClickSongItem extends MusicPlaylistBaseUserEvent {
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

        public static ClickSongItem copy$default(ClickSongItem musicPlaylistBaseUserEvent$ClickSongItem0, int v, int v1, Object object0) {
            if((v1 & 1) != 0) {
                v = musicPlaylistBaseUserEvent$ClickSongItem0.a;
            }
            return musicPlaylistBaseUserEvent$ClickSongItem0.copy(v);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof ClickSongItem ? this.a == ((ClickSongItem)object0).a : false;
        }

        public final int getPosition() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return this.a;
        }

        @Override
        @NotNull
        public String toString() {
            return "ClickSongItem(position=" + this.a + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent$ClickSortOrderUserEvent;", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ClickSortOrderUserEvent extends MusicPlaylistBaseUserEvent {
        public static final int $stable;
        @NotNull
        public static final ClickSortOrderUserEvent INSTANCE;

        static {
            ClickSortOrderUserEvent.INSTANCE = new ClickSortOrderUserEvent(null);  // 初始化器: Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof ClickSortOrderUserEvent;
        }

        @Override
        public int hashCode() {
            return 0xC49325D9;
        }

        @Override
        @NotNull
        public String toString() {
            return "ClickSortOrderUserEvent";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000BJ$\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000E\u001A\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000E\u0010\u000BJ\u0010\u0010\u0010\u001A\u00020\u000FHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001A\u0010\u0015\u001A\u00020\u00142\b\u0010\u0013\u001A\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0019\u0010\tR\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001A\u0010\u001B\u001A\u0004\b\u001C\u0010\u000B¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent$ClickSortTypeInPopupUserEvent;", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent;", "Loc/y0;", "sortType", "", "sortTypeString", "<init>", "(Loc/y0;Ljava/lang/String;)V", "component1", "()Loc/y0;", "component2", "()Ljava/lang/String;", "copy", "(Loc/y0;Ljava/lang/String;)Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent$ClickSortTypeInPopupUserEvent;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Loc/y0;", "getSortType", "b", "Ljava/lang/String;", "getSortTypeString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ClickSortTypeInPopupUserEvent extends MusicPlaylistBaseUserEvent {
        public static final int $stable;
        public final y0 a;
        public final String b;

        public ClickSortTypeInPopupUserEvent(@NotNull y0 y00, @NotNull String s) {
            q.g(y00, "sortType");
            q.g(s, "sortTypeString");
            super(null);
            this.a = y00;
            this.b = s;
        }

        @NotNull
        public final y0 component1() {
            return this.a;
        }

        @NotNull
        public final String component2() {
            return this.b;
        }

        @NotNull
        public final ClickSortTypeInPopupUserEvent copy(@NotNull y0 y00, @NotNull String s) {
            q.g(y00, "sortType");
            q.g(s, "sortTypeString");
            return new ClickSortTypeInPopupUserEvent(y00, s);
        }

        public static ClickSortTypeInPopupUserEvent copy$default(ClickSortTypeInPopupUserEvent musicPlaylistBaseUserEvent$ClickSortTypeInPopupUserEvent0, y0 y00, String s, int v, Object object0) {
            if((v & 1) != 0) {
                y00 = musicPlaylistBaseUserEvent$ClickSortTypeInPopupUserEvent0.a;
            }
            if((v & 2) != 0) {
                s = musicPlaylistBaseUserEvent$ClickSortTypeInPopupUserEvent0.b;
            }
            return musicPlaylistBaseUserEvent$ClickSortTypeInPopupUserEvent0.copy(y00, s);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof ClickSortTypeInPopupUserEvent)) {
                return false;
            }
            return q.b(this.a, ((ClickSortTypeInPopupUserEvent)object0).a) ? q.b(this.b, ((ClickSortTypeInPopupUserEvent)object0).b) : false;
        }

        @NotNull
        public final y0 getSortType() {
            return this.a;
        }

        @NotNull
        public final String getSortTypeString() {
            return this.b;
        }

        @Override
        public int hashCode() {
            return this.b.hashCode() + this.a.hashCode() * 0x1F;
        }

        @Override
        @NotNull
        public String toString() {
            return "ClickSortTypeInPopupUserEvent(sortType=" + this.a + ", sortTypeString=" + this.b + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ$\u0010\n\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0004\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000BJ\u0010\u0010\r\u001A\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000EJ\u0010\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000F\u0010\bJ\u001A\u0010\u0013\u001A\u00020\u00122\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\bR\u0017\u0010\u0004\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0016\u001A\u0004\b\u0019\u0010\b¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent$MoveSongItem;", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent;", "", "from", "to", "<init>", "(II)V", "component1", "()I", "component2", "copy", "(II)Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent$MoveSongItem;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "getFrom", "b", "getTo", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class MoveSongItem extends MusicPlaylistBaseUserEvent {
        public static final int $stable;
        public final int a;
        public final int b;

        public MoveSongItem(int v, int v1) {
            super(null);
            this.a = v;
            this.b = v1;
        }

        public final int component1() {
            return this.a;
        }

        public final int component2() {
            return this.b;
        }

        @NotNull
        public final MoveSongItem copy(int v, int v1) {
            return new MoveSongItem(v, v1);
        }

        public static MoveSongItem copy$default(MoveSongItem musicPlaylistBaseUserEvent$MoveSongItem0, int v, int v1, int v2, Object object0) {
            if((v2 & 1) != 0) {
                v = musicPlaylistBaseUserEvent$MoveSongItem0.a;
            }
            if((v2 & 2) != 0) {
                v1 = musicPlaylistBaseUserEvent$MoveSongItem0.b;
            }
            return musicPlaylistBaseUserEvent$MoveSongItem0.copy(v, v1);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof MoveSongItem)) {
                return false;
            }
            return this.a == ((MoveSongItem)object0).a ? this.b == ((MoveSongItem)object0).b : false;
        }

        public final int getFrom() {
            return this.a;
        }

        public final int getTo() {
            return this.b;
        }

        @Override
        public int hashCode() {
            return this.b + this.a * 0x1F;
        }

        @Override
        @NotNull
        public String toString() {
            return "MoveSongItem(from=" + this.a + ", to=" + this.b + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent$OnTouchDownMoveIconWhenSelectRepeatOn;", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class OnTouchDownMoveIconWhenSelectRepeatOn extends MusicPlaylistBaseUserEvent {
        public static final int $stable;
        @NotNull
        public static final OnTouchDownMoveIconWhenSelectRepeatOn INSTANCE;

        static {
            OnTouchDownMoveIconWhenSelectRepeatOn.INSTANCE = new OnTouchDownMoveIconWhenSelectRepeatOn(null);  // 初始化器: Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof OnTouchDownMoveIconWhenSelectRepeatOn;
        }

        @Override
        public int hashCode() {
            return 0x326C83EE;
        }

        @Override
        @NotNull
        public String toString() {
            return "OnTouchDownMoveIconWhenSelectRepeatOn";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent$ToolBarClickPutUserEvent;", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ToolBarClickPutUserEvent extends MusicPlaylistBaseUserEvent {
        public static final int $stable;
        @NotNull
        public static final ToolBarClickPutUserEvent INSTANCE;

        static {
            ToolBarClickPutUserEvent.INSTANCE = new ToolBarClickPutUserEvent(null);  // 初始化器: Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof ToolBarClickPutUserEvent;
        }

        @Override
        public int hashCode() {
            return 0x9DF9D5FB;
        }

        @Override
        @NotNull
        public String toString() {
            return "ToolBarClickPutUserEvent";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent$ToolBarClickRemoveUserEvent;", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ToolBarClickRemoveUserEvent extends MusicPlaylistBaseUserEvent {
        public static final int $stable;
        @NotNull
        public static final ToolBarClickRemoveUserEvent INSTANCE;

        static {
            ToolBarClickRemoveUserEvent.INSTANCE = new ToolBarClickRemoveUserEvent(null);  // 初始化器: Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof ToolBarClickRemoveUserEvent;
        }

        @Override
        public int hashCode() {
            return 0xDB0550D0;
        }

        @Override
        @NotNull
        public String toString() {
            return "ToolBarClickRemoveUserEvent";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent$ToolBarClickReplayUserEvent;", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ToolBarClickReplayUserEvent extends MusicPlaylistBaseUserEvent {
        public static final int $stable;
        @NotNull
        public static final ToolBarClickReplayUserEvent INSTANCE;

        static {
            ToolBarClickReplayUserEvent.INSTANCE = new ToolBarClickReplayUserEvent(null);  // 初始化器: Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUserEvent;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof ToolBarClickReplayUserEvent;
        }

        @Override
        public int hashCode() {
            return 0x6E73A0CD;
        }

        @Override
        @NotNull
        public String toString() {
            return "ToolBarClickReplayUserEvent";
        }
    }

    public static final int $stable;

    public MusicPlaylistBaseUserEvent(DefaultConstructorMarker defaultConstructorMarker0) {
    }
}

