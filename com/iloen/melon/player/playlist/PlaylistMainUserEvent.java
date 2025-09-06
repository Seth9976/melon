package com.iloen.melon.player.playlist;

import Pc.e;
import b3.Z;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0006\u0002\u0003\u0004\u0005\u0006\u0007\u0082\u0001\u0006\b\t\n\u000B\f\r¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/player/playlist/PlaylistMainUserEvent;", "LPc/e;", "ClickPlayPauseButton", "ClickPrevButton", "ClickNextButton", "LongClickPrevButton", "LongClickNextButton", "ClickAlbumArtButton", "Lcom/iloen/melon/player/playlist/PlaylistMainUserEvent$ClickAlbumArtButton;", "Lcom/iloen/melon/player/playlist/PlaylistMainUserEvent$ClickNextButton;", "Lcom/iloen/melon/player/playlist/PlaylistMainUserEvent$ClickPlayPauseButton;", "Lcom/iloen/melon/player/playlist/PlaylistMainUserEvent$ClickPrevButton;", "Lcom/iloen/melon/player/playlist/PlaylistMainUserEvent$LongClickNextButton;", "Lcom/iloen/melon/player/playlist/PlaylistMainUserEvent$LongClickPrevButton;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class PlaylistMainUserEvent implements e {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/player/playlist/PlaylistMainUserEvent$ClickAlbumArtButton;", "Lcom/iloen/melon/player/playlist/PlaylistMainUserEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ClickAlbumArtButton extends PlaylistMainUserEvent {
        public static final int $stable;
        @NotNull
        public static final ClickAlbumArtButton INSTANCE;

        static {
            ClickAlbumArtButton.INSTANCE = new ClickAlbumArtButton(null);  // 初始化器: Lcom/iloen/melon/player/playlist/PlaylistMainUserEvent;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof ClickAlbumArtButton;
        }

        @Override
        public int hashCode() {
            return 0xC8A09FB4;
        }

        @Override
        @NotNull
        public String toString() {
            return "ClickAlbumArtButton";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/player/playlist/PlaylistMainUserEvent$ClickNextButton;", "Lcom/iloen/melon/player/playlist/PlaylistMainUserEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ClickNextButton extends PlaylistMainUserEvent {
        public static final int $stable;
        @NotNull
        public static final ClickNextButton INSTANCE;

        static {
            ClickNextButton.INSTANCE = new ClickNextButton(null);  // 初始化器: Lcom/iloen/melon/player/playlist/PlaylistMainUserEvent;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof ClickNextButton;
        }

        @Override
        public int hashCode() {
            return 0x3A0FBCF3;
        }

        @Override
        @NotNull
        public String toString() {
            return "ClickNextButton";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/player/playlist/PlaylistMainUserEvent$ClickPlayPauseButton;", "Lcom/iloen/melon/player/playlist/PlaylistMainUserEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ClickPlayPauseButton extends PlaylistMainUserEvent {
        public static final int $stable;
        @NotNull
        public static final ClickPlayPauseButton INSTANCE;

        static {
            ClickPlayPauseButton.INSTANCE = new ClickPlayPauseButton(null);  // 初始化器: Lcom/iloen/melon/player/playlist/PlaylistMainUserEvent;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof ClickPlayPauseButton;
        }

        @Override
        public int hashCode() {
            return 0xA44540C6;
        }

        @Override
        @NotNull
        public String toString() {
            return "ClickPlayPauseButton";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/player/playlist/PlaylistMainUserEvent$ClickPrevButton;", "Lcom/iloen/melon/player/playlist/PlaylistMainUserEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ClickPrevButton extends PlaylistMainUserEvent {
        public static final int $stable;
        @NotNull
        public static final ClickPrevButton INSTANCE;

        static {
            ClickPrevButton.INSTANCE = new ClickPrevButton(null);  // 初始化器: Lcom/iloen/melon/player/playlist/PlaylistMainUserEvent;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof ClickPrevButton;
        }

        @Override
        public int hashCode() {
            return 1580360755;
        }

        @Override
        @NotNull
        public String toString() {
            return "ClickPrevButton";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000BJ$\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000F\u001A\u00020\u000EHÖ\u0001¢\u0006\u0004\b\u000F\u0010\u0010J\u0010\u0010\u0011\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\tJ\u001A\u0010\u0015\u001A\u00020\u00142\b\u0010\u0013\u001A\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0019\u0010\tR\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001A\u0010\u001B\u001A\u0004\b\u001C\u0010\u000B¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/player/playlist/PlaylistMainUserEvent$LongClickNextButton;", "Lcom/iloen/melon/player/playlist/PlaylistMainUserEvent;", "", "repCnt", "", "howLong", "<init>", "(IJ)V", "component1", "()I", "component2", "()J", "copy", "(IJ)Lcom/iloen/melon/player/playlist/PlaylistMainUserEvent$LongClickNextButton;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "getRepCnt", "b", "J", "getHowLong", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class LongClickNextButton extends PlaylistMainUserEvent {
        public static final int $stable;
        public final int a;
        public final long b;

        public LongClickNextButton(int v, long v1) {
            super(null);
            this.a = v;
            this.b = v1;
        }

        public final int component1() {
            return this.a;
        }

        public final long component2() {
            return this.b;
        }

        @NotNull
        public final LongClickNextButton copy(int v, long v1) {
            return new LongClickNextButton(v, v1);
        }

        public static LongClickNextButton copy$default(LongClickNextButton playlistMainUserEvent$LongClickNextButton0, int v, long v1, int v2, Object object0) {
            if((v2 & 1) != 0) {
                v = playlistMainUserEvent$LongClickNextButton0.a;
            }
            if((v2 & 2) != 0) {
                v1 = playlistMainUserEvent$LongClickNextButton0.b;
            }
            return playlistMainUserEvent$LongClickNextButton0.copy(v, v1);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof LongClickNextButton)) {
                return false;
            }
            return this.a == ((LongClickNextButton)object0).a ? this.b == ((LongClickNextButton)object0).b : false;
        }

        public final long getHowLong() {
            return this.b;
        }

        public final int getRepCnt() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return Long.hashCode(this.b) + this.a * 0x1F;
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = Z.n(this.a, "LongClickNextButton(repCnt=", ", howLong=", this.b);
            stringBuilder0.append(")");
            return stringBuilder0.toString();
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000BJ$\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000F\u001A\u00020\u000EHÖ\u0001¢\u0006\u0004\b\u000F\u0010\u0010J\u0010\u0010\u0011\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\tJ\u001A\u0010\u0015\u001A\u00020\u00142\b\u0010\u0013\u001A\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0019\u0010\tR\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001A\u0010\u001B\u001A\u0004\b\u001C\u0010\u000B¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/player/playlist/PlaylistMainUserEvent$LongClickPrevButton;", "Lcom/iloen/melon/player/playlist/PlaylistMainUserEvent;", "", "repCnt", "", "howLong", "<init>", "(IJ)V", "component1", "()I", "component2", "()J", "copy", "(IJ)Lcom/iloen/melon/player/playlist/PlaylistMainUserEvent$LongClickPrevButton;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "getRepCnt", "b", "J", "getHowLong", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class LongClickPrevButton extends PlaylistMainUserEvent {
        public static final int $stable;
        public final int a;
        public final long b;

        public LongClickPrevButton(int v, long v1) {
            super(null);
            this.a = v;
            this.b = v1;
        }

        public final int component1() {
            return this.a;
        }

        public final long component2() {
            return this.b;
        }

        @NotNull
        public final LongClickPrevButton copy(int v, long v1) {
            return new LongClickPrevButton(v, v1);
        }

        public static LongClickPrevButton copy$default(LongClickPrevButton playlistMainUserEvent$LongClickPrevButton0, int v, long v1, int v2, Object object0) {
            if((v2 & 1) != 0) {
                v = playlistMainUserEvent$LongClickPrevButton0.a;
            }
            if((v2 & 2) != 0) {
                v1 = playlistMainUserEvent$LongClickPrevButton0.b;
            }
            return playlistMainUserEvent$LongClickPrevButton0.copy(v, v1);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof LongClickPrevButton)) {
                return false;
            }
            return this.a == ((LongClickPrevButton)object0).a ? this.b == ((LongClickPrevButton)object0).b : false;
        }

        public final long getHowLong() {
            return this.b;
        }

        public final int getRepCnt() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return Long.hashCode(this.b) + this.a * 0x1F;
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = Z.n(this.a, "LongClickPrevButton(repCnt=", ", howLong=", this.b);
            stringBuilder0.append(")");
            return stringBuilder0.toString();
        }
    }

    public static final int $stable;

    public PlaylistMainUserEvent(DefaultConstructorMarker defaultConstructorMarker0) {
    }
}

