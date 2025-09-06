package com.iloen.melon.player.playlist.common;

import A7.d;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.melon.ui.I4;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/player/playlist/common/PlaylistDeleteUiEvent;", "Lcom/melon/ui/I4;", "CannotEditServerPlaylistUiEvent", "SelectRepeatInterruptUiEvent", "DeleteConfirmAlertUiEvent", "Lcom/iloen/melon/player/playlist/common/PlaylistDeleteUiEvent$CannotEditServerPlaylistUiEvent;", "Lcom/iloen/melon/player/playlist/common/PlaylistDeleteUiEvent$DeleteConfirmAlertUiEvent;", "Lcom/iloen/melon/player/playlist/common/PlaylistDeleteUiEvent$SelectRepeatInterruptUiEvent;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class PlaylistDeleteUiEvent implements I4 {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/player/playlist/common/PlaylistDeleteUiEvent$CannotEditServerPlaylistUiEvent;", "Lcom/iloen/melon/player/playlist/common/PlaylistDeleteUiEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class CannotEditServerPlaylistUiEvent extends PlaylistDeleteUiEvent {
        public static final int $stable;
        @NotNull
        public static final CannotEditServerPlaylistUiEvent INSTANCE;

        static {
            CannotEditServerPlaylistUiEvent.INSTANCE = new CannotEditServerPlaylistUiEvent(null);  // 初始化器: Lcom/iloen/melon/player/playlist/common/PlaylistDeleteUiEvent;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof CannotEditServerPlaylistUiEvent;
        }

        @Override
        public int hashCode() {
            return 0x95D13C0C;
        }

        @Override
        @NotNull
        public String toString() {
            return "CannotEditServerPlaylistUiEvent";
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u000BJ\u0010\u0010\f\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000E\u001A\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u000E\u0010\u000FJ.\u0010\u0010\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0007\u001A\u00020\u0006HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001A\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001A\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0015\u0010\rJ\u001A\u0010\u0019\u001A\u00020\u00182\b\u0010\u0017\u001A\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001AR\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u001D\u0010\u000BR\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001E\u0010\u001F\u001A\u0004\b \u0010\rR\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001A\u0004\b#\u0010\u000F¨\u0006$"}, d2 = {"Lcom/iloen/melon/player/playlist/common/PlaylistDeleteUiEvent$DeleteConfirmAlertUiEvent;", "Lcom/iloen/melon/player/playlist/common/PlaylistDeleteUiEvent;", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "playlistId", "", "songCount", "Lcom/iloen/melon/player/playlist/common/PlaylistDeleteUserEvent;", "userEvent", "<init>", "(Lcom/iloen/melon/playback/playlist/PlaylistId;ILcom/iloen/melon/player/playlist/common/PlaylistDeleteUserEvent;)V", "component1", "()Lcom/iloen/melon/playback/playlist/PlaylistId;", "component2", "()I", "component3", "()Lcom/iloen/melon/player/playlist/common/PlaylistDeleteUserEvent;", "copy", "(Lcom/iloen/melon/playback/playlist/PlaylistId;ILcom/iloen/melon/player/playlist/common/PlaylistDeleteUserEvent;)Lcom/iloen/melon/player/playlist/common/PlaylistDeleteUiEvent$DeleteConfirmAlertUiEvent;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "getPlaylistId", "b", "I", "getSongCount", "c", "Lcom/iloen/melon/player/playlist/common/PlaylistDeleteUserEvent;", "getUserEvent", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class DeleteConfirmAlertUiEvent extends PlaylistDeleteUiEvent {
        public static final int $stable = 8;
        public final PlaylistId a;
        public final int b;
        public final PlaylistDeleteUserEvent c;

        public DeleteConfirmAlertUiEvent(@NotNull PlaylistId playlistId0, int v, @NotNull PlaylistDeleteUserEvent playlistDeleteUserEvent0) {
            q.g(playlistId0, "playlistId");
            q.g(playlistDeleteUserEvent0, "userEvent");
            super(null);
            this.a = playlistId0;
            this.b = v;
            this.c = playlistDeleteUserEvent0;
        }

        @NotNull
        public final PlaylistId component1() {
            return this.a;
        }

        public final int component2() {
            return this.b;
        }

        @NotNull
        public final PlaylistDeleteUserEvent component3() {
            return this.c;
        }

        @NotNull
        public final DeleteConfirmAlertUiEvent copy(@NotNull PlaylistId playlistId0, int v, @NotNull PlaylistDeleteUserEvent playlistDeleteUserEvent0) {
            q.g(playlistId0, "playlistId");
            q.g(playlistDeleteUserEvent0, "userEvent");
            return new DeleteConfirmAlertUiEvent(playlistId0, v, playlistDeleteUserEvent0);
        }

        public static DeleteConfirmAlertUiEvent copy$default(DeleteConfirmAlertUiEvent playlistDeleteUiEvent$DeleteConfirmAlertUiEvent0, PlaylistId playlistId0, int v, PlaylistDeleteUserEvent playlistDeleteUserEvent0, int v1, Object object0) {
            if((v1 & 1) != 0) {
                playlistId0 = playlistDeleteUiEvent$DeleteConfirmAlertUiEvent0.a;
            }
            if((v1 & 2) != 0) {
                v = playlistDeleteUiEvent$DeleteConfirmAlertUiEvent0.b;
            }
            if((v1 & 4) != 0) {
                playlistDeleteUserEvent0 = playlistDeleteUiEvent$DeleteConfirmAlertUiEvent0.c;
            }
            return playlistDeleteUiEvent$DeleteConfirmAlertUiEvent0.copy(playlistId0, v, playlistDeleteUserEvent0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof DeleteConfirmAlertUiEvent)) {
                return false;
            }
            if(this.a != ((DeleteConfirmAlertUiEvent)object0).a) {
                return false;
            }
            return this.b == ((DeleteConfirmAlertUiEvent)object0).b ? q.b(this.c, ((DeleteConfirmAlertUiEvent)object0).c) : false;
        }

        @NotNull
        public final PlaylistId getPlaylistId() {
            return this.a;
        }

        public final int getSongCount() {
            return this.b;
        }

        @NotNull
        public final PlaylistDeleteUserEvent getUserEvent() {
            return this.c;
        }

        @Override
        public int hashCode() {
            return this.c.hashCode() + d.b(this.b, this.a.hashCode() * 0x1F, 0x1F);
        }

        @Override
        @NotNull
        public String toString() {
            return "DeleteConfirmAlertUiEvent(playlistId=" + this.a + ", songCount=" + this.b + ", userEvent=" + this.c + ")";
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\b\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000B\u001A\u00020\nHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\u000E\u001A\u00020\rHÖ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u001A\u0010\u0013\u001A\u00020\u00122\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/player/playlist/common/PlaylistDeleteUiEvent$SelectRepeatInterruptUiEvent;", "Lcom/iloen/melon/player/playlist/common/PlaylistDeleteUiEvent;", "Lcom/iloen/melon/player/playlist/common/PlaylistDeleteUserEvent;", "userEvent", "<init>", "(Lcom/iloen/melon/player/playlist/common/PlaylistDeleteUserEvent;)V", "component1", "()Lcom/iloen/melon/player/playlist/common/PlaylistDeleteUserEvent;", "copy", "(Lcom/iloen/melon/player/playlist/common/PlaylistDeleteUserEvent;)Lcom/iloen/melon/player/playlist/common/PlaylistDeleteUiEvent$SelectRepeatInterruptUiEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lcom/iloen/melon/player/playlist/common/PlaylistDeleteUserEvent;", "getUserEvent", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class SelectRepeatInterruptUiEvent extends PlaylistDeleteUiEvent {
        public static final int $stable = 8;
        public final PlaylistDeleteUserEvent a;

        public SelectRepeatInterruptUiEvent(@NotNull PlaylistDeleteUserEvent playlistDeleteUserEvent0) {
            q.g(playlistDeleteUserEvent0, "userEvent");
            super(null);
            this.a = playlistDeleteUserEvent0;
        }

        @NotNull
        public final PlaylistDeleteUserEvent component1() {
            return this.a;
        }

        @NotNull
        public final SelectRepeatInterruptUiEvent copy(@NotNull PlaylistDeleteUserEvent playlistDeleteUserEvent0) {
            q.g(playlistDeleteUserEvent0, "userEvent");
            return new SelectRepeatInterruptUiEvent(playlistDeleteUserEvent0);
        }

        public static SelectRepeatInterruptUiEvent copy$default(SelectRepeatInterruptUiEvent playlistDeleteUiEvent$SelectRepeatInterruptUiEvent0, PlaylistDeleteUserEvent playlistDeleteUserEvent0, int v, Object object0) {
            if((v & 1) != 0) {
                playlistDeleteUserEvent0 = playlistDeleteUiEvent$SelectRepeatInterruptUiEvent0.a;
            }
            return playlistDeleteUiEvent$SelectRepeatInterruptUiEvent0.copy(playlistDeleteUserEvent0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof SelectRepeatInterruptUiEvent ? q.b(this.a, ((SelectRepeatInterruptUiEvent)object0).a) : false;
        }

        @NotNull
        public final PlaylistDeleteUserEvent getUserEvent() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return this.a.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "SelectRepeatInterruptUiEvent(userEvent=" + this.a + ")";
        }
    }

    public static final int $stable;

    public PlaylistDeleteUiEvent(DefaultConstructorMarker defaultConstructorMarker0) {
    }
}

