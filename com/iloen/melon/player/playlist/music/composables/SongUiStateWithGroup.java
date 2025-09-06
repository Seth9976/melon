package com.iloen.melon.player.playlist.music.composables;

import A7.d;
import U4.x;
import android.net.Uri;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b:\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u0012\u0006\u0010\b\u001A\u00020\u0006\u0012\b\u0010\n\u001A\u0004\u0018\u00010\t\u0012\u0006\u0010\u000B\u001A\u00020\u0002\u0012\u0006\u0010\f\u001A\u00020\u0002\u0012\u0006\u0010\r\u001A\u00020\u0006\u0012\u0006\u0010\u000E\u001A\u00020\u0006\u0012\u0006\u0010\u000F\u001A\u00020\u0006\u0012\u0006\u0010\u0010\u001A\u00020\u0006\u0012\u0006\u0010\u0011\u001A\u00020\u0006\u0012\u0006\u0010\u0012\u001A\u00020\u0006\u0012\b\u0010\u0014\u001A\u0004\u0018\u00010\u0013\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001A\u0004\u0018\u00010\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0010\u0010\u001B\u001A\u00020\u0006H\u00C6\u0003\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u0010\u0010\u001D\u001A\u00020\u0006H\u00C6\u0003\u00A2\u0006\u0004\b\u001D\u0010\u001CJ\u0012\u0010\u001E\u001A\u0004\u0018\u00010\tH\u00C6\u0003\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u0010\u0010 \u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b \u0010\u0018J\u0010\u0010!\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b!\u0010\u0018J\u0010\u0010\"\u001A\u00020\u0006H\u00C6\u0003\u00A2\u0006\u0004\b\"\u0010\u001CJ\u0010\u0010#\u001A\u00020\u0006H\u00C6\u0003\u00A2\u0006\u0004\b#\u0010\u001CJ\u0010\u0010$\u001A\u00020\u0006H\u00C6\u0003\u00A2\u0006\u0004\b$\u0010\u001CJ\u0010\u0010%\u001A\u00020\u0006H\u00C6\u0003\u00A2\u0006\u0004\b%\u0010\u001CJ\u0010\u0010&\u001A\u00020\u0006H\u00C6\u0003\u00A2\u0006\u0004\b&\u0010\u001CJ\u0010\u0010\'\u001A\u00020\u0006H\u00C6\u0003\u00A2\u0006\u0004\b\'\u0010\u001CJ\u0012\u0010(\u001A\u0004\u0018\u00010\u0013H\u00C6\u0003\u00A2\u0006\u0004\b(\u0010)J\u00A2\u0001\u0010*\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001A\u00020\u00062\b\b\u0002\u0010\b\u001A\u00020\u00062\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000B\u001A\u00020\u00022\b\b\u0002\u0010\f\u001A\u00020\u00022\b\b\u0002\u0010\r\u001A\u00020\u00062\b\b\u0002\u0010\u000E\u001A\u00020\u00062\b\b\u0002\u0010\u000F\u001A\u00020\u00062\b\b\u0002\u0010\u0010\u001A\u00020\u00062\b\b\u0002\u0010\u0011\u001A\u00020\u00062\b\b\u0002\u0010\u0012\u001A\u00020\u00062\n\b\u0002\u0010\u0014\u001A\u0004\u0018\u00010\u0013H\u00C6\u0001\u00A2\u0006\u0004\b*\u0010+J\u0010\u0010,\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b,\u0010\u0018J\u0010\u0010-\u001A\u00020\u0013H\u00D6\u0001\u00A2\u0006\u0004\b-\u0010.J\u001A\u00100\u001A\u00020\u00062\b\u0010/\u001A\u0004\u0018\u00010\u0001H\u00D6\u0003\u00A2\u0006\u0004\b0\u00101R\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b2\u00103\u001A\u0004\b4\u0010\u0018R\u0019\u0010\u0005\u001A\u0004\u0018\u00010\u00048\u0006\u00A2\u0006\f\n\u0004\b5\u00106\u001A\u0004\b7\u0010\u001AR\u0017\u0010\u0007\u001A\u00020\u00068\u0006\u00A2\u0006\f\n\u0004\b8\u00109\u001A\u0004\b\u0007\u0010\u001CR\u0017\u0010\b\u001A\u00020\u00068\u0006\u00A2\u0006\f\n\u0004\b:\u00109\u001A\u0004\b\b\u0010\u001CR\u0019\u0010\n\u001A\u0004\u0018\u00010\t8\u0006\u00A2\u0006\f\n\u0004\b;\u0010<\u001A\u0004\b=\u0010\u001FR\u0017\u0010\u000B\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b>\u00103\u001A\u0004\b?\u0010\u0018R\u0017\u0010\f\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b@\u00103\u001A\u0004\bA\u0010\u0018R\u0017\u0010\r\u001A\u00020\u00068\u0006\u00A2\u0006\f\n\u0004\bB\u00109\u001A\u0004\bC\u0010\u001CR\u0017\u0010\u000E\u001A\u00020\u00068\u0006\u00A2\u0006\f\n\u0004\bD\u00109\u001A\u0004\b\u000E\u0010\u001CR\u0017\u0010\u000F\u001A\u00020\u00068\u0006\u00A2\u0006\f\n\u0004\bE\u00109\u001A\u0004\b\u000F\u0010\u001CR\u0017\u0010\u0010\u001A\u00020\u00068\u0006\u00A2\u0006\f\n\u0004\bF\u00109\u001A\u0004\b\u0010\u0010\u001CR\u0017\u0010\u0011\u001A\u00020\u00068\u0006\u00A2\u0006\f\n\u0004\bG\u00109\u001A\u0004\b\u0011\u0010\u001CR\u0017\u0010\u0012\u001A\u00020\u00068\u0006\u00A2\u0006\f\n\u0004\bH\u00109\u001A\u0004\bI\u0010\u001CR\u0019\u0010\u0014\u001A\u0004\u0018\u00010\u00138\u0006\u00A2\u0006\f\n\u0004\bJ\u0010K\u001A\u0004\bL\u0010)\u00A8\u0006M"}, d2 = {"Lcom/iloen/melon/player/playlist/music/composables/SongUiStateWithGroup;", "", "", "trackId", "Lcom/iloen/melon/player/playlist/music/composables/GroupTitleState;", "groupTitleState", "", "isChecked", "isSelectedForSelectRepeat", "Landroid/net/Uri;", "thumbnailUrl", "songName", "artistName", "hasFocus", "isShowAnimation", "isPlayingAnimation", "isAdult", "isMarquee", "showOfflineIcon", "", "fileTypeDrawableResId", "<init>", "(Ljava/lang/String;Lcom/iloen/melon/player/playlist/music/composables/GroupTitleState;ZZLandroid/net/Uri;Ljava/lang/String;Ljava/lang/String;ZZZZZZLjava/lang/Integer;)V", "component1", "()Ljava/lang/String;", "component2", "()Lcom/iloen/melon/player/playlist/music/composables/GroupTitleState;", "component3", "()Z", "component4", "component5", "()Landroid/net/Uri;", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "()Ljava/lang/Integer;", "copy", "(Ljava/lang/String;Lcom/iloen/melon/player/playlist/music/composables/GroupTitleState;ZZLandroid/net/Uri;Ljava/lang/String;Ljava/lang/String;ZZZZZZLjava/lang/Integer;)Lcom/iloen/melon/player/playlist/music/composables/SongUiStateWithGroup;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getTrackId", "b", "Lcom/iloen/melon/player/playlist/music/composables/GroupTitleState;", "getGroupTitleState", "c", "Z", "d", "e", "Landroid/net/Uri;", "getThumbnailUrl", "f", "getSongName", "g", "getArtistName", "h", "getHasFocus", "i", "j", "k", "l", "m", "getShowOfflineIcon", "n", "Ljava/lang/Integer;", "getFileTypeDrawableResId", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SongUiStateWithGroup {
    public static final int $stable = 8;
    public final String a;
    public final GroupTitleState b;
    public final boolean c;
    public final boolean d;
    public final Uri e;
    public final String f;
    public final String g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final Integer n;

    public SongUiStateWithGroup(@NotNull String s, @Nullable GroupTitleState groupTitleState0, boolean z, boolean z1, @Nullable Uri uri0, @NotNull String s1, @NotNull String s2, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, @Nullable Integer integer0) {
        q.g(s, "trackId");
        q.g(s1, "songName");
        q.g(s2, "artistName");
        super();
        this.a = s;
        this.b = groupTitleState0;
        this.c = z;
        this.d = z1;
        this.e = uri0;
        this.f = s1;
        this.g = s2;
        this.h = z2;
        this.i = z3;
        this.j = z4;
        this.k = z5;
        this.l = z6;
        this.m = z7;
        this.n = integer0;
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    public final boolean component10() {
        return this.j;
    }

    public final boolean component11() {
        return this.k;
    }

    public final boolean component12() {
        return this.l;
    }

    public final boolean component13() {
        return this.m;
    }

    @Nullable
    public final Integer component14() {
        return this.n;
    }

    @Nullable
    public final GroupTitleState component2() {
        return this.b;
    }

    public final boolean component3() {
        return this.c;
    }

    public final boolean component4() {
        return this.d;
    }

    @Nullable
    public final Uri component5() {
        return this.e;
    }

    @NotNull
    public final String component6() {
        return this.f;
    }

    @NotNull
    public final String component7() {
        return this.g;
    }

    public final boolean component8() {
        return this.h;
    }

    public final boolean component9() {
        return this.i;
    }

    @NotNull
    public final SongUiStateWithGroup copy(@NotNull String s, @Nullable GroupTitleState groupTitleState0, boolean z, boolean z1, @Nullable Uri uri0, @NotNull String s1, @NotNull String s2, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, @Nullable Integer integer0) {
        q.g(s, "trackId");
        q.g(s1, "songName");
        q.g(s2, "artistName");
        return new SongUiStateWithGroup(s, groupTitleState0, z, z1, uri0, s1, s2, z2, z3, z4, z5, z6, z7, integer0);
    }

    public static SongUiStateWithGroup copy$default(SongUiStateWithGroup songUiStateWithGroup0, String s, GroupTitleState groupTitleState0, boolean z, boolean z1, Uri uri0, String s1, String s2, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, Integer integer0, int v, Object object0) {
        String s3 = (v & 1) == 0 ? s : songUiStateWithGroup0.a;
        GroupTitleState groupTitleState1 = (v & 2) == 0 ? groupTitleState0 : songUiStateWithGroup0.b;
        boolean z8 = (v & 4) == 0 ? z : songUiStateWithGroup0.c;
        boolean z9 = (v & 8) == 0 ? z1 : songUiStateWithGroup0.d;
        Uri uri1 = (v & 16) == 0 ? uri0 : songUiStateWithGroup0.e;
        String s4 = (v & 0x20) == 0 ? s1 : songUiStateWithGroup0.f;
        String s5 = (v & 0x40) == 0 ? s2 : songUiStateWithGroup0.g;
        boolean z10 = (v & 0x80) == 0 ? z2 : songUiStateWithGroup0.h;
        boolean z11 = (v & 0x100) == 0 ? z3 : songUiStateWithGroup0.i;
        boolean z12 = (v & 0x200) == 0 ? z4 : songUiStateWithGroup0.j;
        boolean z13 = (v & 0x400) == 0 ? z5 : songUiStateWithGroup0.k;
        boolean z14 = (v & 0x800) == 0 ? z6 : songUiStateWithGroup0.l;
        boolean z15 = (v & 0x1000) == 0 ? z7 : songUiStateWithGroup0.m;
        return (v & 0x2000) == 0 ? songUiStateWithGroup0.copy(s3, groupTitleState1, z8, z9, uri1, s4, s5, z10, z11, z12, z13, z14, z15, integer0) : songUiStateWithGroup0.copy(s3, groupTitleState1, z8, z9, uri1, s4, s5, z10, z11, z12, z13, z14, z15, songUiStateWithGroup0.n);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof SongUiStateWithGroup)) {
            return false;
        }
        if(!q.b(this.a, ((SongUiStateWithGroup)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((SongUiStateWithGroup)object0).b)) {
            return false;
        }
        if(this.c != ((SongUiStateWithGroup)object0).c) {
            return false;
        }
        if(this.d != ((SongUiStateWithGroup)object0).d) {
            return false;
        }
        if(!q.b(this.e, ((SongUiStateWithGroup)object0).e)) {
            return false;
        }
        if(!q.b(this.f, ((SongUiStateWithGroup)object0).f)) {
            return false;
        }
        if(!q.b(this.g, ((SongUiStateWithGroup)object0).g)) {
            return false;
        }
        if(this.h != ((SongUiStateWithGroup)object0).h) {
            return false;
        }
        if(this.i != ((SongUiStateWithGroup)object0).i) {
            return false;
        }
        if(this.j != ((SongUiStateWithGroup)object0).j) {
            return false;
        }
        if(this.k != ((SongUiStateWithGroup)object0).k) {
            return false;
        }
        if(this.l != ((SongUiStateWithGroup)object0).l) {
            return false;
        }
        return this.m == ((SongUiStateWithGroup)object0).m ? q.b(this.n, ((SongUiStateWithGroup)object0).n) : false;
    }

    @NotNull
    public final String getArtistName() {
        return this.g;
    }

    @Nullable
    public final Integer getFileTypeDrawableResId() {
        return this.n;
    }

    @Nullable
    public final GroupTitleState getGroupTitleState() {
        return this.b;
    }

    public final boolean getHasFocus() {
        return this.h;
    }

    public final boolean getShowOfflineIcon() {
        return this.m;
    }

    @NotNull
    public final String getSongName() {
        return this.f;
    }

    @Nullable
    public final Uri getThumbnailUrl() {
        return this.e;
    }

    @NotNull
    public final String getTrackId() {
        return this.a;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = d.e(d.e(d.e(d.e(d.e(d.e(x.b(x.b((d.e(d.e((this.a.hashCode() * 0x1F + (this.b == null ? 0 : this.b.hashCode())) * 0x1F, 0x1F, this.c), 0x1F, this.d) + (this.e == null ? 0 : this.e.hashCode())) * 0x1F, 0x1F, this.f), 0x1F, this.g), 0x1F, this.h), 0x1F, this.i), 0x1F, this.j), 0x1F, this.k), 0x1F, this.l), 0x1F, this.m);
        Integer integer0 = this.n;
        if(integer0 != null) {
            v = integer0.hashCode();
        }
        return v1 + v;
    }

    public final boolean isAdult() {
        return this.k;
    }

    public final boolean isChecked() {
        return this.c;
    }

    public final boolean isMarquee() {
        return this.l;
    }

    public final boolean isPlayingAnimation() {
        return this.j;
    }

    public final boolean isSelectedForSelectRepeat() {
        return this.d;
    }

    public final boolean isShowAnimation() {
        return this.i;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("SongUiStateWithGroup(trackId=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", groupTitleState=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", isChecked=");
        x.y(stringBuilder0, this.c, ", isSelectedForSelectRepeat=", this.d, ", thumbnailUrl=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", songName=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(", artistName=");
        Y.x(stringBuilder0, this.g, ", hasFocus=", this.h, ", isShowAnimation=");
        x.y(stringBuilder0, this.i, ", isPlayingAnimation=", this.j, ", isAdult=");
        x.y(stringBuilder0, this.k, ", isMarquee=", this.l, ", showOfflineIcon=");
        stringBuilder0.append(this.m);
        stringBuilder0.append(", fileTypeDrawableResId=");
        stringBuilder0.append(this.n);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

