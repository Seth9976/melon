package com.iloen.melon.player.playlist.mixup;

import Pc.e;
import com.iloen.melon.playback.Playable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/player/playlist/mixup/MixUpPlaylistEvent;", "LPc/e;", "ClickSongItem", "ClickAlbumThumbnail", "ClickOtherRecommend", "PlayOtherRecommendInDjMalrang", "Lcom/iloen/melon/player/playlist/mixup/MixUpPlaylistEvent$ClickAlbumThumbnail;", "Lcom/iloen/melon/player/playlist/mixup/MixUpPlaylistEvent$ClickOtherRecommend;", "Lcom/iloen/melon/player/playlist/mixup/MixUpPlaylistEvent$ClickSongItem;", "Lcom/iloen/melon/player/playlist/mixup/MixUpPlaylistEvent$PlayOtherRecommendInDjMalrang;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class MixUpPlaylistEvent implements e {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000BJ$\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000F\u001A\u00020\u000EHÖ\u0001¢\u0006\u0004\b\u000F\u0010\u0010J\u0010\u0010\u0011\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\tJ\u001A\u0010\u0015\u001A\u00020\u00142\b\u0010\u0013\u001A\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0019\u0010\tR\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001A\u0010\u001B\u001A\u0004\b\u001C\u0010\u000B¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/player/playlist/mixup/MixUpPlaylistEvent$ClickAlbumThumbnail;", "Lcom/iloen/melon/player/playlist/mixup/MixUpPlaylistEvent;", "", "position", "Lcom/iloen/melon/playback/Playable;", "playable", "<init>", "(ILcom/iloen/melon/playback/Playable;)V", "component1", "()I", "component2", "()Lcom/iloen/melon/playback/Playable;", "copy", "(ILcom/iloen/melon/playback/Playable;)Lcom/iloen/melon/player/playlist/mixup/MixUpPlaylistEvent$ClickAlbumThumbnail;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "getPosition", "b", "Lcom/iloen/melon/playback/Playable;", "getPlayable", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ClickAlbumThumbnail extends MixUpPlaylistEvent {
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

        public static ClickAlbumThumbnail copy$default(ClickAlbumThumbnail mixUpPlaylistEvent$ClickAlbumThumbnail0, int v, Playable playable0, int v1, Object object0) {
            if((v1 & 1) != 0) {
                v = mixUpPlaylistEvent$ClickAlbumThumbnail0.a;
            }
            if((v1 & 2) != 0) {
                playable0 = mixUpPlaylistEvent$ClickAlbumThumbnail0.b;
            }
            return mixUpPlaylistEvent$ClickAlbumThumbnail0.copy(v, playable0);
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
            return "ClickAlbumThumbnail(position=" + this.a + ", playable=" + this.b + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/player/playlist/mixup/MixUpPlaylistEvent$ClickOtherRecommend;", "Lcom/iloen/melon/player/playlist/mixup/MixUpPlaylistEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ClickOtherRecommend extends MixUpPlaylistEvent {
        public static final int $stable;
        @NotNull
        public static final ClickOtherRecommend INSTANCE;

        static {
            ClickOtherRecommend.INSTANCE = new ClickOtherRecommend(null);  // 初始化器: Lcom/iloen/melon/player/playlist/mixup/MixUpPlaylistEvent;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof ClickOtherRecommend;
        }

        @Override
        public int hashCode() {
            return 0xC83F325E;
        }

        @Override
        @NotNull
        public String toString() {
            return "ClickOtherRecommend";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000BJ$\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000F\u001A\u00020\u000EHÖ\u0001¢\u0006\u0004\b\u000F\u0010\u0010J\u0010\u0010\u0011\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\tJ\u001A\u0010\u0015\u001A\u00020\u00142\b\u0010\u0013\u001A\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0019\u0010\tR\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001A\u0010\u001B\u001A\u0004\b\u001C\u0010\u000B¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/player/playlist/mixup/MixUpPlaylistEvent$ClickSongItem;", "Lcom/iloen/melon/player/playlist/mixup/MixUpPlaylistEvent;", "", "position", "Lcom/iloen/melon/playback/Playable;", "playable", "<init>", "(ILcom/iloen/melon/playback/Playable;)V", "component1", "()I", "component2", "()Lcom/iloen/melon/playback/Playable;", "copy", "(ILcom/iloen/melon/playback/Playable;)Lcom/iloen/melon/player/playlist/mixup/MixUpPlaylistEvent$ClickSongItem;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "getPosition", "b", "Lcom/iloen/melon/playback/Playable;", "getPlayable", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ClickSongItem extends MixUpPlaylistEvent {
        public static final int $stable = 8;
        public final int a;
        public final Playable b;

        public ClickSongItem(int v, @NotNull Playable playable0) {
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
        public final ClickSongItem copy(int v, @NotNull Playable playable0) {
            q.g(playable0, "playable");
            return new ClickSongItem(v, playable0);
        }

        public static ClickSongItem copy$default(ClickSongItem mixUpPlaylistEvent$ClickSongItem0, int v, Playable playable0, int v1, Object object0) {
            if((v1 & 1) != 0) {
                v = mixUpPlaylistEvent$ClickSongItem0.a;
            }
            if((v1 & 2) != 0) {
                playable0 = mixUpPlaylistEvent$ClickSongItem0.b;
            }
            return mixUpPlaylistEvent$ClickSongItem0.copy(v, playable0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof ClickSongItem)) {
                return false;
            }
            return this.a == ((ClickSongItem)object0).a ? q.b(this.b, ((ClickSongItem)object0).b) : false;
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
            return "ClickSongItem(position=" + this.a + ", playable=" + this.b + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/player/playlist/mixup/MixUpPlaylistEvent$PlayOtherRecommendInDjMalrang;", "Lcom/iloen/melon/player/playlist/mixup/MixUpPlaylistEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class PlayOtherRecommendInDjMalrang extends MixUpPlaylistEvent {
        public static final int $stable;
        @NotNull
        public static final PlayOtherRecommendInDjMalrang INSTANCE;

        static {
            PlayOtherRecommendInDjMalrang.INSTANCE = new PlayOtherRecommendInDjMalrang(null);  // 初始化器: Lcom/iloen/melon/player/playlist/mixup/MixUpPlaylistEvent;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof PlayOtherRecommendInDjMalrang;
        }

        @Override
        public int hashCode() {
            return 0x3003A51F;
        }

        @Override
        @NotNull
        public String toString() {
            return "PlayOtherRecommendInDjMalrang";
        }
    }

    public static final int $stable;

    public MixUpPlaylistEvent(DefaultConstructorMarker defaultConstructorMarker0) {
    }
}

