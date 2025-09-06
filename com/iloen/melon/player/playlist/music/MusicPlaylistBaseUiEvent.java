package com.iloen.melon.player.playlist.music;

import com.melon.ui.I4;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUiEvent;", "Lcom/melon/ui/I4;", "SortOrderListPopupEvent", "ShowContextMenuAddToPopup", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUiEvent$ShowContextMenuAddToPopup;", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUiEvent$SortOrderListPopupEvent;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class MusicPlaylistBaseUiEvent implements I4 {
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u001D\u0012\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001A\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000B\u001A\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u000B\u0010\fJ*\u0010\r\u001A\u00020\u00002\u000E\b\u0002\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001A\u00020\u0005HÆ\u0001¢\u0006\u0004\b\r\u0010\u000EJ\u0010\u0010\u000F\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000F\u0010\fJ\u0010\u0010\u0011\u001A\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001A\u0010\u0016\u001A\u00020\u00152\b\u0010\u0014\u001A\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001D\u0010\u0004\u001A\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001A\u0004\b\u001A\u0010\nR\u0017\u0010\u0006\u001A\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u001D\u0010\f¨\u0006\u001E"}, d2 = {"Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUiEvent$ShowContextMenuAddToPopup;", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUiEvent;", "", "Lcom/iloen/melon/playback/Playable;", "playables", "", "from", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "component1", "()Ljava/util/List;", "component2", "()Ljava/lang/String;", "copy", "(Ljava/util/List;Ljava/lang/String;)Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUiEvent$ShowContextMenuAddToPopup;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/util/List;", "getPlayables", "b", "Ljava/lang/String;", "getFrom", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ShowContextMenuAddToPopup extends MusicPlaylistBaseUiEvent {
        public static final int $stable = 8;
        public final List a;
        public final String b;

        public ShowContextMenuAddToPopup(@NotNull List list0, @NotNull String s) {
            q.g(list0, "playables");
            q.g(s, "from");
            super(null);
            this.a = list0;
            this.b = s;
        }

        @NotNull
        public final List component1() {
            return this.a;
        }

        @NotNull
        public final String component2() {
            return this.b;
        }

        @NotNull
        public final ShowContextMenuAddToPopup copy(@NotNull List list0, @NotNull String s) {
            q.g(list0, "playables");
            q.g(s, "from");
            return new ShowContextMenuAddToPopup(list0, s);
        }

        public static ShowContextMenuAddToPopup copy$default(ShowContextMenuAddToPopup musicPlaylistBaseUiEvent$ShowContextMenuAddToPopup0, List list0, String s, int v, Object object0) {
            if((v & 1) != 0) {
                list0 = musicPlaylistBaseUiEvent$ShowContextMenuAddToPopup0.a;
            }
            if((v & 2) != 0) {
                s = musicPlaylistBaseUiEvent$ShowContextMenuAddToPopup0.b;
            }
            return musicPlaylistBaseUiEvent$ShowContextMenuAddToPopup0.copy(list0, s);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof ShowContextMenuAddToPopup)) {
                return false;
            }
            return q.b(this.a, ((ShowContextMenuAddToPopup)object0).a) ? q.b(this.b, ((ShowContextMenuAddToPopup)object0).b) : false;
        }

        @NotNull
        public final String getFrom() {
            return this.b;
        }

        @NotNull
        public final List getPlayables() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return this.b.hashCode() + this.a.hashCode() * 0x1F;
        }

        @Override
        @NotNull
        public String toString() {
            return "ShowContextMenuAddToPopup(playables=" + this.a + ", from=" + this.b + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUiEvent$SortOrderListPopupEvent;", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUiEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class SortOrderListPopupEvent extends MusicPlaylistBaseUiEvent {
        public static final int $stable;
        @NotNull
        public static final SortOrderListPopupEvent INSTANCE;

        static {
            SortOrderListPopupEvent.INSTANCE = new SortOrderListPopupEvent(null);  // 初始化器: Lcom/iloen/melon/player/playlist/music/MusicPlaylistBaseUiEvent;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof SortOrderListPopupEvent;
        }

        @Override
        public int hashCode() {
            return -2092010971;
        }

        @Override
        @NotNull
        public String toString() {
            return "SortOrderListPopupEvent";
        }
    }

    public static final int $stable;

    public MusicPlaylistBaseUiEvent(DefaultConstructorMarker defaultConstructorMarker0) {
    }
}

