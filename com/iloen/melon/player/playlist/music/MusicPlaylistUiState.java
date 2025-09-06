package com.iloen.melon.player.playlist.music;

import A7.d;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.melon.ui.K4;
import java.util.List;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import oc.c0;
import oc.y0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/player/playlist/music/MusicPlaylistUiState;", "Lcom/melon/ui/K4;", "Loading", "Success", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistUiState$Loading;", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistUiState$Success;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class MusicPlaylistUiState implements K4 {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/player/playlist/music/MusicPlaylistUiState$Loading;", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistUiState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Loading extends MusicPlaylistUiState {
        public static final int $stable;
        @NotNull
        public static final Loading INSTANCE;

        static {
            Loading.INSTANCE = new Loading(null);  // 初始化器: Lcom/iloen/melon/player/playlist/music/MusicPlaylistUiState;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof Loading;
        }

        @Override
        public int hashCode() {
            return -35493011;
        }

        @Override
        @NotNull
        public String toString() {
            return "Loading";
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0018\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0004\u0012\u0006\u0010\b\u001A\u00020\u0007\u0012\f\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000E\b\u0002\u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0\t\u0012\u0006\u0010\u000E\u001A\u00020\n\u0012\b\b\u0002\u0010\u0010\u001A\u00020\u000F\u00A2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001A\u00020\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001A\u00020\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u0017\u0010\u0016J\u0010\u0010\u0018\u001A\u00020\u0007H\u00C6\u0003\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u0016\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\n0\tH\u00C6\u0003\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0016\u0010\u001C\u001A\b\u0012\u0004\u0012\u00020\f0\tH\u00C6\u0003\u00A2\u0006\u0004\b\u001C\u0010\u001BJ\u0010\u0010\u001D\u001A\u00020\nH\u00C6\u0003\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0010\u0010\u001F\u001A\u00020\u000FH\u00C6\u0003\u00A2\u0006\u0004\b\u001F\u0010 Jl\u0010!\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0006\u001A\u00020\u00042\b\b\u0002\u0010\b\u001A\u00020\u00072\u000E\b\u0002\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\n0\t2\u000E\b\u0002\u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0\t2\b\b\u0002\u0010\u000E\u001A\u00020\n2\b\b\u0002\u0010\u0010\u001A\u00020\u000FH\u00C6\u0001\u00A2\u0006\u0004\b!\u0010\"J\u0010\u0010$\u001A\u00020#H\u00D6\u0001\u00A2\u0006\u0004\b$\u0010%J\u0010\u0010&\u001A\u00020\nH\u00D6\u0001\u00A2\u0006\u0004\b&\u0010\u001EJ\u001A\u0010)\u001A\u00020\u00042\b\u0010(\u001A\u0004\u0018\u00010\'H\u00D6\u0003\u00A2\u0006\u0004\b)\u0010*R\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b+\u0010,\u001A\u0004\b-\u0010\u0014R\u0017\u0010\u0005\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\b.\u0010/\u001A\u0004\b\u0005\u0010\u0016R\u0017\u0010\u0006\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\b0\u0010/\u001A\u0004\b\u0006\u0010\u0016R\u0017\u0010\b\u001A\u00020\u00078\u0006\u00A2\u0006\f\n\u0004\b1\u00102\u001A\u0004\b3\u0010\u0019R\u001D\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00A2\u0006\f\n\u0004\b4\u00105\u001A\u0004\b6\u0010\u001BR\u001D\u0010\r\u001A\b\u0012\u0004\u0012\u00020\f0\t8\u0006\u00A2\u0006\f\n\u0004\b7\u00105\u001A\u0004\b8\u0010\u001BR\u0017\u0010\u000E\u001A\u00020\n8\u0006\u00A2\u0006\f\n\u0004\b9\u0010:\u001A\u0004\b;\u0010\u001ER\u0017\u0010\u0010\u001A\u00020\u000F8\u0006\u00A2\u0006\f\n\u0004\b<\u0010=\u001A\u0004\b>\u0010 \u00A8\u0006?"}, d2 = {"Lcom/iloen/melon/player/playlist/music/MusicPlaylistUiState$Success;", "Lcom/iloen/melon/player/playlist/music/MusicPlaylistUiState;", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "playlistId", "", "isCurrentPlaylist", "isPlaying", "Loc/y0;", "sortType", "", "", "selectRepeatIndices", "Lcom/iloen/melon/player/playlist/music/SongUiState;", "songList", "currentIndex", "Loc/c0;", "sectionSelectState", "<init>", "(Lcom/iloen/melon/playback/playlist/PlaylistId;ZZLoc/y0;Ljava/util/List;Ljava/util/List;ILoc/c0;)V", "component1", "()Lcom/iloen/melon/playback/playlist/PlaylistId;", "component2", "()Z", "component3", "component4", "()Loc/y0;", "component5", "()Ljava/util/List;", "component6", "component7", "()I", "component8", "()Loc/c0;", "copy", "(Lcom/iloen/melon/playback/playlist/PlaylistId;ZZLoc/y0;Ljava/util/List;Ljava/util/List;ILoc/c0;)Lcom/iloen/melon/player/playlist/music/MusicPlaylistUiState$Success;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Lcom/iloen/melon/playback/playlist/PlaylistId;", "getPlaylistId", "b", "Z", "c", "d", "Loc/y0;", "getSortType", "e", "Ljava/util/List;", "getSelectRepeatIndices", "f", "getSongList", "g", "I", "getCurrentIndex", "h", "Loc/c0;", "getSectionSelectState", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Success extends MusicPlaylistUiState {
        public static final int $stable = 8;
        public final PlaylistId a;
        public final boolean b;
        public final boolean c;
        public final y0 d;
        public final List e;
        public final List f;
        public final int g;
        public final c0 h;

        public Success(@NotNull PlaylistId playlistId0, boolean z, boolean z1, @NotNull y0 y00, @NotNull List list0, @NotNull List list1, int v, @NotNull c0 c00) {
            q.g(playlistId0, "playlistId");
            q.g(y00, "sortType");
            q.g(list0, "selectRepeatIndices");
            q.g(list1, "songList");
            q.g(c00, "sectionSelectState");
            super(null);
            this.a = playlistId0;
            this.b = z;
            this.c = z1;
            this.d = y00;
            this.e = list0;
            this.f = list1;
            this.g = v;
            this.h = c00;
        }

        public Success(PlaylistId playlistId0, boolean z, boolean z1, y0 y00, List list0, List list1, int v, c0 c00, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
            List list2 = (v1 & 0x20) == 0 ? list1 : w.a;
            this(playlistId0, z, z1, y00, list0, list2, v, ((v1 & 0x80) == 0 ? c00 : c0.b));
        }

        @NotNull
        public final PlaylistId component1() {
            return this.a;
        }

        public final boolean component2() {
            return this.b;
        }

        public final boolean component3() {
            return this.c;
        }

        @NotNull
        public final y0 component4() {
            return this.d;
        }

        @NotNull
        public final List component5() {
            return this.e;
        }

        @NotNull
        public final List component6() {
            return this.f;
        }

        public final int component7() {
            return this.g;
        }

        @NotNull
        public final c0 component8() {
            return this.h;
        }

        @NotNull
        public final Success copy(@NotNull PlaylistId playlistId0, boolean z, boolean z1, @NotNull y0 y00, @NotNull List list0, @NotNull List list1, int v, @NotNull c0 c00) {
            q.g(playlistId0, "playlistId");
            q.g(y00, "sortType");
            q.g(list0, "selectRepeatIndices");
            q.g(list1, "songList");
            q.g(c00, "sectionSelectState");
            return new Success(playlistId0, z, z1, y00, list0, list1, v, c00);
        }

        public static Success copy$default(Success musicPlaylistUiState$Success0, PlaylistId playlistId0, boolean z, boolean z1, y0 y00, List list0, List list1, int v, c0 c00, int v1, Object object0) {
            if((v1 & 1) != 0) {
                playlistId0 = musicPlaylistUiState$Success0.a;
            }
            if((v1 & 2) != 0) {
                z = musicPlaylistUiState$Success0.b;
            }
            if((v1 & 4) != 0) {
                z1 = musicPlaylistUiState$Success0.c;
            }
            if((v1 & 8) != 0) {
                y00 = musicPlaylistUiState$Success0.d;
            }
            if((v1 & 16) != 0) {
                list0 = musicPlaylistUiState$Success0.e;
            }
            if((v1 & 0x20) != 0) {
                list1 = musicPlaylistUiState$Success0.f;
            }
            if((v1 & 0x40) != 0) {
                v = musicPlaylistUiState$Success0.g;
            }
            if((v1 & 0x80) != 0) {
                c00 = musicPlaylistUiState$Success0.h;
            }
            return musicPlaylistUiState$Success0.copy(playlistId0, z, z1, y00, list0, list1, v, c00);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof Success)) {
                return false;
            }
            if(this.a != ((Success)object0).a) {
                return false;
            }
            if(this.b != ((Success)object0).b) {
                return false;
            }
            if(this.c != ((Success)object0).c) {
                return false;
            }
            if(!q.b(this.d, ((Success)object0).d)) {
                return false;
            }
            if(!q.b(this.e, ((Success)object0).e)) {
                return false;
            }
            if(!q.b(this.f, ((Success)object0).f)) {
                return false;
            }
            return this.g == ((Success)object0).g ? this.h == ((Success)object0).h : false;
        }

        public final int getCurrentIndex() {
            return this.g;
        }

        @NotNull
        public final PlaylistId getPlaylistId() {
            return this.a;
        }

        @NotNull
        public final c0 getSectionSelectState() {
            return this.h;
        }

        @NotNull
        public final List getSelectRepeatIndices() {
            return this.e;
        }

        @NotNull
        public final List getSongList() {
            return this.f;
        }

        @NotNull
        public final y0 getSortType() {
            return this.d;
        }

        @Override
        public int hashCode() {
            return this.h.hashCode() + d.b(this.g, d.d(d.d((this.d.hashCode() + d.e(d.e(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c)) * 0x1F, 0x1F, this.e), 0x1F, this.f), 0x1F);
        }

        public final boolean isCurrentPlaylist() {
            return this.b;
        }

        public final boolean isPlaying() {
            return this.c;
        }

        @Override
        @NotNull
        public String toString() {
            return "Success(playlistId=" + this.a + ", isCurrentPlaylist=" + this.b + ", isPlaying=" + this.c + ", sortType=" + this.d + ", selectRepeatIndices=" + this.e + ", songList=" + this.f + ", currentIndex=" + this.g + ", sectionSelectState=" + this.h + ")";
        }
    }

    public static final int $stable;

    public MusicPlaylistUiState(DefaultConstructorMarker defaultConstructorMarker0) {
    }
}

