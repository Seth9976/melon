package com.iloen.melon.player.playlist.drawernew.composable;

import A7.d;
import U4.x;
import Ud.a;
import Ud.h;
import android.net.Uri;
import com.melon.ui.K4;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pb.b;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u001D\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0083\u0001\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0004\u0012\u0006\u0010\b\u001A\u00020\u0004\u0012\b\u0010\n\u001A\u0004\u0018\u00010\t\u0012\u0006\u0010\f\u001A\u00020\u000B\u0012\u0006\u0010\r\u001A\u00020\u000B\u0012\u0006\u0010\u000E\u001A\u00020\u000B\u0012\u0006\u0010\u000F\u001A\u00020\u000B\u0012\u0006\u0010\u0010\u001A\u00020\u000B\u0012\u0006\u0010\u0011\u001A\u00020\u000B\u0012\u0006\u0010\u0012\u001A\u00020\u000B\u0012\u0006\u0010\u0013\u001A\u00020\u000B\u0012\u0006\u0010\u0014\u001A\u00020\u000B\u0012\b\u0010\u0016\u001A\u0004\u0018\u00010\u0015\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001A\u00020\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0010\u0010\u001B\u001A\u00020\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u001B\u0010\u001AJ\u0010\u0010\u001C\u001A\u00020\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u001C\u0010\u001AJ\u0010\u0010\u001D\u001A\u00020\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u001D\u0010\u001AJ\u0012\u0010\u001E\u001A\u0004\u0018\u00010\tH\u00C6\u0003\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u0010\u0010 \u001A\u00020\u000BH\u00C6\u0003\u00A2\u0006\u0004\b \u0010!J\u0010\u0010\"\u001A\u00020\u000BH\u00C6\u0003\u00A2\u0006\u0004\b\"\u0010!J\u0010\u0010#\u001A\u00020\u000BH\u00C6\u0003\u00A2\u0006\u0004\b#\u0010!J\u0010\u0010$\u001A\u00020\u000BH\u00C6\u0003\u00A2\u0006\u0004\b$\u0010!J\u0010\u0010%\u001A\u00020\u000BH\u00C6\u0003\u00A2\u0006\u0004\b%\u0010!J\u0010\u0010&\u001A\u00020\u000BH\u00C6\u0003\u00A2\u0006\u0004\b&\u0010!J\u0010\u0010\'\u001A\u00020\u000BH\u00C6\u0003\u00A2\u0006\u0004\b\'\u0010!J\u0010\u0010(\u001A\u00020\u000BH\u00C6\u0003\u00A2\u0006\u0004\b(\u0010!J\u0010\u0010)\u001A\u00020\u000BH\u00C6\u0003\u00A2\u0006\u0004\b)\u0010!J\u0012\u0010*\u001A\u0004\u0018\u00010\u0015H\u00C6\u0003\u00A2\u0006\u0004\b*\u0010+J\u00AA\u0001\u0010,\u001A\u00020\u00002\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0006\u001A\u00020\u00042\b\b\u0002\u0010\u0007\u001A\u00020\u00042\b\b\u0002\u0010\b\u001A\u00020\u00042\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\t2\b\b\u0002\u0010\f\u001A\u00020\u000B2\b\b\u0002\u0010\r\u001A\u00020\u000B2\b\b\u0002\u0010\u000E\u001A\u00020\u000B2\b\b\u0002\u0010\u000F\u001A\u00020\u000B2\b\b\u0002\u0010\u0010\u001A\u00020\u000B2\b\b\u0002\u0010\u0011\u001A\u00020\u000B2\b\b\u0002\u0010\u0012\u001A\u00020\u000B2\b\b\u0002\u0010\u0013\u001A\u00020\u000B2\b\b\u0002\u0010\u0014\u001A\u00020\u000B2\n\b\u0002\u0010\u0016\u001A\u0004\u0018\u00010\u0015H\u00C6\u0001\u00A2\u0006\u0004\b,\u0010-J\u0010\u0010.\u001A\u00020\u0004H\u00D6\u0001\u00A2\u0006\u0004\b.\u0010\u001AJ\u0010\u00100\u001A\u00020/H\u00D6\u0001\u00A2\u0006\u0004\b0\u00101J\u001A\u00104\u001A\u00020\u000B2\b\u00103\u001A\u0004\u0018\u000102H\u00D6\u0003\u00A2\u0006\u0004\b4\u00105R\u0017\u0010\u0005\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\b6\u00107\u001A\u0004\b8\u0010\u001AR\u0017\u0010\u0006\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\b9\u00107\u001A\u0004\b:\u0010\u001AR\u0017\u0010\u0007\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\b;\u00107\u001A\u0004\b<\u0010\u001AR\u0017\u0010\b\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\b=\u00107\u001A\u0004\b>\u0010\u001AR\u0019\u0010\n\u001A\u0004\u0018\u00010\t8\u0006\u00A2\u0006\f\n\u0004\b?\u0010@\u001A\u0004\bA\u0010\u001FR\u0017\u0010\f\u001A\u00020\u000B8\u0006\u00A2\u0006\f\n\u0004\bB\u0010C\u001A\u0004\b\f\u0010!R\u001A\u0010\r\u001A\u00020\u000B8\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\bD\u0010C\u001A\u0004\b\r\u0010!R\u001A\u0010\u000E\u001A\u00020\u000B8\u0016X\u0096\u0004\u00A2\u0006\f\n\u0004\bE\u0010C\u001A\u0004\b\u000E\u0010!R\u0017\u0010\u000F\u001A\u00020\u000B8\u0006\u00A2\u0006\f\n\u0004\bF\u0010C\u001A\u0004\b\u000F\u0010!R\u0017\u0010\u0010\u001A\u00020\u000B8\u0006\u00A2\u0006\f\n\u0004\bG\u0010C\u001A\u0004\b\u0010\u0010!R\u0017\u0010\u0011\u001A\u00020\u000B8\u0006\u00A2\u0006\f\n\u0004\bH\u0010C\u001A\u0004\b\u0011\u0010!R\u0017\u0010\u0012\u001A\u00020\u000B8\u0006\u00A2\u0006\f\n\u0004\bI\u0010C\u001A\u0004\b\u0012\u0010!R\u0017\u0010\u0013\u001A\u00020\u000B8\u0006\u00A2\u0006\f\n\u0004\bJ\u0010C\u001A\u0004\b\u0013\u0010!R\u0017\u0010\u0014\u001A\u00020\u000B8\u0006\u00A2\u0006\f\n\u0004\bK\u0010C\u001A\u0004\b\u0014\u0010!R\u0019\u0010\u0016\u001A\u0004\u0018\u00010\u00158\u0006\u00A2\u0006\f\n\u0004\bL\u0010M\u001A\u0004\bN\u0010+\u00A8\u0006O"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/composable/DrawerSongListItemData;", "Lcom/melon/ui/K4;", "LUd/h;", "LUd/a;", "", "trackId", "contentId", "title", "subTitle", "Landroid/net/Uri;", "thumbImgUrl", "", "isPlaying", "isSelected", "isMarquee", "isAdult", "isOfflineContents", "isViewMode", "isCurrent", "isOwnerThenMovable", "isSelectedForSelectRepeat", "Lpb/b;", "fileType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;ZZZZZZZZZLpb/b;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "()Landroid/net/Uri;", "component6", "()Z", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "()Lpb/b;", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;ZZZZZZZZZLpb/b;)Lcom/iloen/melon/player/playlist/drawernew/composable/DrawerSongListItemData;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getTrackId", "b", "getContentId", "c", "getTitle", "d", "getSubTitle", "e", "Landroid/net/Uri;", "getThumbImgUrl", "f", "Z", "g", "h", "i", "j", "k", "l", "m", "n", "o", "Lpb/b;", "getFileType", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DrawerSongListItemData implements a, h, K4 {
    public static final int $stable = 8;
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final Uri e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    public final b o;

    public DrawerSongListItemData(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @Nullable Uri uri0, boolean z, boolean z1, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, @Nullable b b0) {
        q.g(s, "trackId");
        q.g(s1, "contentId");
        q.g(s2, "title");
        q.g(s3, "subTitle");
        super();
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = s3;
        this.e = uri0;
        this.f = z;
        this.g = z1;
        this.h = z2;
        this.i = z3;
        this.j = z4;
        this.k = z5;
        this.l = z6;
        this.m = z7;
        this.n = z8;
        this.o = b0;
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

    public final boolean component14() {
        return this.n;
    }

    @Nullable
    public final b component15() {
        return this.o;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final String component3() {
        return this.c;
    }

    @NotNull
    public final String component4() {
        return this.d;
    }

    @Nullable
    public final Uri component5() {
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
    public final DrawerSongListItemData copy(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3, @Nullable Uri uri0, boolean z, boolean z1, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, @Nullable b b0) {
        q.g(s, "trackId");
        q.g(s1, "contentId");
        q.g(s2, "title");
        q.g(s3, "subTitle");
        return new DrawerSongListItemData(s, s1, s2, s3, uri0, z, z1, z2, z3, z4, z5, z6, z7, z8, b0);
    }

    public static DrawerSongListItemData copy$default(DrawerSongListItemData drawerSongListItemData0, String s, String s1, String s2, String s3, Uri uri0, boolean z, boolean z1, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, b b0, int v, Object object0) {
        String s4 = (v & 1) == 0 ? s : drawerSongListItemData0.a;
        String s5 = (v & 2) == 0 ? s1 : drawerSongListItemData0.b;
        String s6 = (v & 4) == 0 ? s2 : drawerSongListItemData0.c;
        String s7 = (v & 8) == 0 ? s3 : drawerSongListItemData0.d;
        Uri uri1 = (v & 16) == 0 ? uri0 : drawerSongListItemData0.e;
        boolean z9 = (v & 0x20) == 0 ? z : drawerSongListItemData0.f;
        boolean z10 = (v & 0x40) == 0 ? z1 : drawerSongListItemData0.g;
        boolean z11 = (v & 0x80) == 0 ? z2 : drawerSongListItemData0.h;
        boolean z12 = (v & 0x100) == 0 ? z3 : drawerSongListItemData0.i;
        boolean z13 = (v & 0x200) == 0 ? z4 : drawerSongListItemData0.j;
        boolean z14 = (v & 0x400) == 0 ? z5 : drawerSongListItemData0.k;
        boolean z15 = (v & 0x800) == 0 ? z6 : drawerSongListItemData0.l;
        boolean z16 = (v & 0x1000) == 0 ? z7 : drawerSongListItemData0.m;
        boolean z17 = (v & 0x2000) == 0 ? z8 : drawerSongListItemData0.n;
        return (v & 0x4000) == 0 ? drawerSongListItemData0.copy(s4, s5, s6, s7, uri1, z9, z10, z11, z12, z13, z14, z15, z16, z17, b0) : drawerSongListItemData0.copy(s4, s5, s6, s7, uri1, z9, z10, z11, z12, z13, z14, z15, z16, z17, drawerSongListItemData0.o);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof DrawerSongListItemData)) {
            return false;
        }
        if(!q.b(this.a, ((DrawerSongListItemData)object0).a)) {
            return false;
        }
        if(!q.b(this.b, ((DrawerSongListItemData)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((DrawerSongListItemData)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((DrawerSongListItemData)object0).d)) {
            return false;
        }
        if(!q.b(this.e, ((DrawerSongListItemData)object0).e)) {
            return false;
        }
        if(this.f != ((DrawerSongListItemData)object0).f) {
            return false;
        }
        if(this.g != ((DrawerSongListItemData)object0).g) {
            return false;
        }
        if(this.h != ((DrawerSongListItemData)object0).h) {
            return false;
        }
        if(this.i != ((DrawerSongListItemData)object0).i) {
            return false;
        }
        if(this.j != ((DrawerSongListItemData)object0).j) {
            return false;
        }
        if(this.k != ((DrawerSongListItemData)object0).k) {
            return false;
        }
        if(this.l != ((DrawerSongListItemData)object0).l) {
            return false;
        }
        if(this.m != ((DrawerSongListItemData)object0).m) {
            return false;
        }
        return this.n == ((DrawerSongListItemData)object0).n ? this.o == ((DrawerSongListItemData)object0).o : false;
    }

    @NotNull
    public final String getContentId() {
        return this.b;
    }

    @Nullable
    public final b getFileType() {
        return this.o;
    }

    @NotNull
    public final String getSubTitle() {
        return this.d;
    }

    @Nullable
    public final Uri getThumbImgUrl() {
        return this.e;
    }

    @NotNull
    public final String getTitle() {
        return this.c;
    }

    @NotNull
    public final String getTrackId() {
        return this.a;
    }

    @Override
    public int hashCode() {
        int v = 0;
        int v1 = d.e(d.e(d.e(d.e(d.e(d.e(d.e(d.e(d.e((x.b(x.b(x.b(this.a.hashCode() * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d) + (this.e == null ? 0 : this.e.hashCode())) * 0x1F, 0x1F, this.f), 0x1F, this.g), 0x1F, this.h), 0x1F, this.i), 0x1F, this.j), 0x1F, this.k), 0x1F, this.l), 0x1F, this.m), 0x1F, this.n);
        b b0 = this.o;
        if(b0 != null) {
            v = b0.hashCode();
        }
        return v1 + v;
    }

    public final boolean isAdult() {
        return this.i;
    }

    public final boolean isCurrent() {
        return this.l;
    }

    @Override  // Ud.a
    public boolean isMarquee() {
        return this.h;
    }

    public final boolean isOfflineContents() {
        return this.j;
    }

    public final boolean isOwnerThenMovable() {
        return this.m;
    }

    public final boolean isPlaying() {
        return this.f;
    }

    @Override  // Ud.h
    public boolean isSelected() {
        return this.g;
    }

    public final boolean isSelectedForSelectRepeat() {
        return this.n;
    }

    public final boolean isViewMode() {
        return this.k;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = d.o("DrawerSongListItemData(trackId=", this.a, ", contentId=", this.b, ", title=");
        d.u(stringBuilder0, this.c, ", subTitle=", this.d, ", thumbImgUrl=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", isPlaying=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(", isSelected=");
        x.y(stringBuilder0, this.g, ", isMarquee=", this.h, ", isAdult=");
        x.y(stringBuilder0, this.i, ", isOfflineContents=", this.j, ", isViewMode=");
        x.y(stringBuilder0, this.k, ", isCurrent=", this.l, ", isOwnerThenMovable=");
        x.y(stringBuilder0, this.m, ", isSelectedForSelectRepeat=", this.n, ", fileType=");
        stringBuilder0.append(this.o);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

