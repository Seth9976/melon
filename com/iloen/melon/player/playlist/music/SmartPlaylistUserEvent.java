package com.iloen.melon.player.playlist.music;

import Pc.e;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0001\u0002\u0082\u0001\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/iloen/melon/player/playlist/music/SmartPlaylistUserEvent;", "LPc/e;", "ClickGetFromNormalPlaylist", "Lcom/iloen/melon/player/playlist/music/SmartPlaylistUserEvent$ClickGetFromNormalPlaylist;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class SmartPlaylistUserEvent implements e {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/player/playlist/music/SmartPlaylistUserEvent$ClickGetFromNormalPlaylist;", "Lcom/iloen/melon/player/playlist/music/SmartPlaylistUserEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ClickGetFromNormalPlaylist extends SmartPlaylistUserEvent {
        public static final int $stable;
        @NotNull
        public static final ClickGetFromNormalPlaylist INSTANCE;

        static {
            ClickGetFromNormalPlaylist.INSTANCE = new ClickGetFromNormalPlaylist(null);  // 初始化器: Lcom/iloen/melon/player/playlist/music/SmartPlaylistUserEvent;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof ClickGetFromNormalPlaylist;
        }

        @Override
        public int hashCode() {
            return 138003794;
        }

        @Override
        @NotNull
        public String toString() {
            return "ClickGetFromNormalPlaylist";
        }
    }

    public static final int $stable;

    public SmartPlaylistUserEvent(DefaultConstructorMarker defaultConstructorMarker0) {
    }
}

