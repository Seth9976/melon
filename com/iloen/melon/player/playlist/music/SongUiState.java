package com.iloen.melon.player.playlist.music;

import A7.d;
import U4.x;
import Ud.a;
import Ud.h;
import android.net.Uri;
import com.iloen.melon.playback.Playable;
import com.melon.ui.K4;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pb.b;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0019\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B_\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\b\u0010\t\u001A\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001A\u00020\u0004\u0012\u0006\u0010\u000B\u001A\u00020\u0004\u0012\b\b\u0002\u0010\r\u001A\u00020\f\u0012\b\b\u0002\u0010\u000E\u001A\u00020\f\u0012\u0006\u0010\u000F\u001A\u00020\f\u0012\u0006\u0010\u0010\u001A\u00020\f\u0012\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001A\u00020\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001A\u00020\u0006H\u00C6\u0003\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001A\u0004\u0018\u00010\bH\u00C6\u0003\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0010\u0010\u001B\u001A\u00020\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u001B\u0010\u0016J\u0010\u0010\u001C\u001A\u00020\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u001C\u0010\u0016J\u0010\u0010\u001D\u001A\u00020\fH\u00C6\u0003\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0010\u0010\u001F\u001A\u00020\fH\u00C6\u0003\u00A2\u0006\u0004\b\u001F\u0010\u001EJ\u0010\u0010 \u001A\u00020\fH\u00C6\u0003\u00A2\u0006\u0004\b \u0010\u001EJ\u0010\u0010!\u001A\u00020\fH\u00C6\u0003\u00A2\u0006\u0004\b!\u0010\u001EJ\u0012\u0010\"\u001A\u0004\u0018\u00010\u0011H\u00C6\u0003\u00A2\u0006\u0004\b\"\u0010#Jx\u0010$\u001A\u00020\u00002\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0007\u001A\u00020\u00062\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\b2\b\b\u0002\u0010\n\u001A\u00020\u00042\b\b\u0002\u0010\u000B\u001A\u00020\u00042\b\b\u0002\u0010\r\u001A\u00020\f2\b\b\u0002\u0010\u000E\u001A\u00020\f2\b\b\u0002\u0010\u000F\u001A\u00020\f2\b\b\u0002\u0010\u0010\u001A\u00020\f2\n\b\u0002\u0010\u0012\u001A\u0004\u0018\u00010\u0011H\u00C6\u0001\u00A2\u0006\u0004\b$\u0010%J\u0010\u0010&\u001A\u00020\u0004H\u00D6\u0001\u00A2\u0006\u0004\b&\u0010\u0016J\u0010\u0010(\u001A\u00020\'H\u00D6\u0001\u00A2\u0006\u0004\b(\u0010)J\u001A\u0010,\u001A\u00020\f2\b\u0010+\u001A\u0004\u0018\u00010*H\u00D6\u0003\u00A2\u0006\u0004\b,\u0010-R\u0017\u0010\u0005\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\b.\u0010/\u001A\u0004\b0\u0010\u0016R\u0017\u0010\u0007\u001A\u00020\u00068\u0006\u00A2\u0006\f\n\u0004\b1\u00102\u001A\u0004\b3\u0010\u0018R\u0019\u0010\t\u001A\u0004\u0018\u00010\b8\u0006\u00A2\u0006\f\n\u0004\b4\u00105\u001A\u0004\b6\u0010\u001AR\u0017\u0010\n\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\b7\u0010/\u001A\u0004\b8\u0010\u0016R\u0017\u0010\u000B\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\b9\u0010/\u001A\u0004\b:\u0010\u0016R\u001A\u0010\r\u001A\u00020\f8\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b;\u0010<\u001A\u0004\b\r\u0010\u001ER\u001A\u0010\u000E\u001A\u00020\f8\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\b=\u0010<\u001A\u0004\b\u000E\u0010\u001ER\u0017\u0010\u000F\u001A\u00020\f8\u0006\u00A2\u0006\f\n\u0004\b>\u0010<\u001A\u0004\b\u000F\u0010\u001ER\u0017\u0010\u0010\u001A\u00020\f8\u0006\u00A2\u0006\f\n\u0004\b?\u0010<\u001A\u0004\b\u0010\u0010\u001ER\u0019\u0010\u0012\u001A\u0004\u0018\u00010\u00118\u0006\u00A2\u0006\f\n\u0004\b@\u0010A\u001A\u0004\bB\u0010#\u00A8\u0006C"}, d2 = {"Lcom/iloen/melon/player/playlist/music/SongUiState;", "Lcom/melon/ui/K4;", "LUd/h;", "LUd/a;", "", "trackId", "Lcom/iloen/melon/playback/Playable;", "playable", "Landroid/net/Uri;", "thumbnailUri", "songName", "artistName", "", "isSelected", "isMarquee", "isAdult", "isOfflineSong", "Lpb/b;", "fileType", "<init>", "(Ljava/lang/String;Lcom/iloen/melon/playback/Playable;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;ZZZZLpb/b;)V", "component1", "()Ljava/lang/String;", "component2", "()Lcom/iloen/melon/playback/Playable;", "component3", "()Landroid/net/Uri;", "component4", "component5", "component6", "()Z", "component7", "component8", "component9", "component10", "()Lpb/b;", "copy", "(Ljava/lang/String;Lcom/iloen/melon/playback/Playable;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;ZZZZLpb/b;)Lcom/iloen/melon/player/playlist/music/SongUiState;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getTrackId", "b", "Lcom/iloen/melon/playback/Playable;", "getPlayable", "c", "Landroid/net/Uri;", "getThumbnailUri", "d", "getSongName", "e", "getArtistName", "f", "Z", "g", "h", "i", "j", "Lpb/b;", "getFileType", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SongUiState implements a, h, K4 {
    public static final int $stable = 8;
    public final String a;
    public final Playable b;
    public final Uri c;
    public final String d;
    public final String e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final b j;

    public SongUiState(@NotNull String s, @NotNull Playable playable0, @Nullable Uri uri0, @NotNull String s1, @NotNull String s2, boolean z, boolean z1, boolean z2, boolean z3, @Nullable b b0) {
        q.g(s, "trackId");
        q.g(playable0, "playable");
        q.g(s1, "songName");
        q.g(s2, "artistName");
        super();
        this.a = s;
        this.b = playable0;
        this.c = uri0;
        this.d = s1;
        this.e = s2;
        this.f = z;
        this.g = z1;
        this.h = z2;
        this.i = z3;
        this.j = b0;
    }

    public SongUiState(String s, Playable playable0, Uri uri0, String s1, String s2, boolean z, boolean z1, boolean z2, boolean z3, b b0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 0x20) != 0) {
            z = false;
        }
        this(s, playable0, uri0, s1, s2, z, ((v & 0x40) == 0 ? z1 : false), z2, z3, b0);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @Nullable
    public final b component10() {
        return this.j;
    }

    @NotNull
    public final Playable component2() {
        return this.b;
    }

    @Nullable
    public final Uri component3() {
        return this.c;
    }

    @NotNull
    public final String component4() {
        return this.d;
    }

    @NotNull
    public final String component5() {
        return this.e;
    }

    public final boolean component6() {
        return this.f;
    }

    public final boolean component7() {
        return this.g;
    }

    public final boolean component8() {
        return this.h;
    }

    public final boolean component9() {
        return this.i;
    }

    @NotNull
    public final SongUiState copy(@NotNull String s, @NotNull Playable playable0, @Nullable Uri uri0, @NotNull String s1, @NotNull String s2, boolean z, boolean z1, boolean z2, boolean z3, @Nullable b b0) {
        q.g(s, "trackId");
        q.g(playable0, "playable");
        q.g(s1, "songName");
        q.g(s2, "artistName");
        return new SongUiState(s, playable0, uri0, s1, s2, z, z1, z2, z3, b0);
    }

    public static SongUiState copy$default(SongUiState songUiState0, String s, Playable playable0, Uri uri0, String s1, String s2, boolean z, boolean z1, boolean z2, boolean z3, b b0, int v, Object object0) {
        if((v & 1) != 0) {
            s = songUiState0.a;
        }
        if((v & 2) != 0) {
            playable0 = songUiState0.b;
        }
        if((v & 4) != 0) {
            uri0 = songUiState0.c;
        }
        if((v & 8) != 0) {
            s1 = songUiState0.d;
        }
        if((v & 16) != 0) {
            s2 = songUiState0.e;
        }
        if((v & 0x20) != 0) {
            z = songUiState0.f;
        }
        if((v & 0x40) != 0) {
            z1 = songUiState0.g;
        }
        if((v & 0x80) != 0) {
            z2 = songUiState0.h;
        }
        if((v & 0x100) != 0) {
            z3 = songUiState0.i;
        }
        if((v & 0x200) != 0) {
            b0 = songUiState0.j;
        }
        return songUiState0.copy(s, playable0, uri0, s1, s2, z, z1, z2, z3, b0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof SongUiState)) {
            return false;
        }
        if(!q.b(this.a, ((SongUiState)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((SongUiState)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((SongUiState)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((SongUiState)object0).d)) {
            return false;
        }
        if(!q.b(this.e, ((SongUiState)object0).e)) {
            return false;
        }
        if(this.f != ((SongUiState)object0).f) {
            return false;
        }
        if(this.g != ((SongUiState)object0).g) {
            return false;
        }
        if(this.h != ((SongUiState)object0).h) {
            return false;
        }
        return this.i == ((SongUiState)object0).i ? this.j == ((SongUiState)object0).j : false;
    }

    @NotNull
    public final String getArtistName() {
        return this.e;
    }

    @Nullable
    public final b getFileType() {
        return this.j;
    }

    @NotNull
    public final Playable getPlayable() {
        return this.b;
    }

    @NotNull
    public final String getSongName() {
        return this.d;
    }

    @Nullable
    public final Uri getThumbnailUri() {
        return this.c;
    }

    @NotNull
    public final String getTrackId() {
        return this.a;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = d.e(d.e(d.e(d.e(x.b(x.b(((this.b.hashCode() + this.a.hashCode() * 0x1F) * 0x1F + (this.c == null ? 0 : this.c.hashCode())) * 0x1F, 0x1F, this.d), 0x1F, this.e), 0x1F, this.f), 0x1F, this.g), 0x1F, this.h), 0x1F, this.i);
        b b0 = this.j;
        if(b0 != null) {
            v = b0.hashCode();
        }
        return v1 + v;
    }

    public final boolean isAdult() {
        return this.h;
    }

    @Override  // Ud.a
    public boolean isMarquee() {
        return this.g;
    }

    public final boolean isOfflineSong() {
        return this.i;
    }

    @Override  // Ud.h
    public boolean isSelected() {
        return this.f;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("SongUiState(trackId=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", playable=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", thumbnailUri=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", songName=");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", artistName=");
        Y.x(stringBuilder0, this.e, ", isSelected=", this.f, ", isMarquee=");
        x.y(stringBuilder0, this.g, ", isAdult=", this.h, ", isOfflineSong=");
        stringBuilder0.append(this.i);
        stringBuilder0.append(", fileType=");
        stringBuilder0.append(this.j);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

