package com.iloen.melon.player.playlist.drawernew.model;

import A7.d;
import U4.x;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import com.melon.ui.K4;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\u001D\b\u0087\b\u0018\u00002\u00020\u0001Bs\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0006\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0004\u0012\f\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00040\b\u0012\b\b\u0002\u0010\u000B\u001A\u00020\n\u0012\b\b\u0002\u0010\f\u001A\u00020\n\u0012\b\b\u0002\u0010\r\u001A\u00020\n\u0012\u0006\u0010\u000E\u001A\u00020\n\u0012\u0006\u0010\u000F\u001A\u00020\n\u0012\u0006\u0010\u0010\u001A\u00020\u0004\u0012\u0006\u0010\u0012\u001A\u00020\u0011\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001A\u00020\u0002H\u00C6\u0003\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001A\u00020\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001A\u00020\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u0019\u0010\u0018J\u0010\u0010\u001A\u001A\u00020\u0004H\u00C6\u0003\u00A2\u0006\u0004\b\u001A\u0010\u0018J\u0016\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u00040\bH\u00C6\u0003\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u0010\u0010\u001D\u001A\u00020\nH\u00C6\u0003\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0010\u0010\u001F\u001A\u00020\nH\u00C6\u0003\u00A2\u0006\u0004\b\u001F\u0010\u001EJ\u0010\u0010 \u001A\u00020\nH\u00C6\u0003\u00A2\u0006\u0004\b \u0010\u001EJ\u0010\u0010!\u001A\u00020\nH\u00C6\u0003\u00A2\u0006\u0004\b!\u0010\u001EJ\u0010\u0010\"\u001A\u00020\nH\u00C6\u0003\u00A2\u0006\u0004\b\"\u0010\u001EJ\u0010\u0010#\u001A\u00020\u0004H\u00C6\u0003\u00A2\u0006\u0004\b#\u0010\u0018J\u0010\u0010$\u001A\u00020\u0011H\u00C6\u0003\u00A2\u0006\u0004\b$\u0010%J\u008E\u0001\u0010&\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00042\b\b\u0002\u0010\u0006\u001A\u00020\u00042\b\b\u0002\u0010\u0007\u001A\u00020\u00042\u000E\b\u0002\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00040\b2\b\b\u0002\u0010\u000B\u001A\u00020\n2\b\b\u0002\u0010\f\u001A\u00020\n2\b\b\u0002\u0010\r\u001A\u00020\n2\b\b\u0002\u0010\u000E\u001A\u00020\n2\b\b\u0002\u0010\u000F\u001A\u00020\n2\b\b\u0002\u0010\u0010\u001A\u00020\u00042\b\b\u0002\u0010\u0012\u001A\u00020\u0011H\u00C6\u0001\u00A2\u0006\u0004\b&\u0010\'J\u0010\u0010(\u001A\u00020\u0004H\u00D6\u0001\u00A2\u0006\u0004\b(\u0010\u0018J\u0010\u0010)\u001A\u00020\u0002H\u00D6\u0001\u00A2\u0006\u0004\b)\u0010\u0016J\u001A\u0010,\u001A\u00020\n2\b\u0010+\u001A\u0004\u0018\u00010*H\u00D6\u0003\u00A2\u0006\u0004\b,\u0010-R\u0017\u0010\u0003\u001A\u00020\u00028\u0006\u00A2\u0006\f\n\u0004\b.\u0010/\u001A\u0004\b0\u0010\u0016R\u0017\u0010\u0005\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\b1\u00102\u001A\u0004\b3\u0010\u0018R\u0017\u0010\u0006\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\b4\u00102\u001A\u0004\b5\u0010\u0018R\u0017\u0010\u0007\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\b6\u00102\u001A\u0004\b7\u0010\u0018R\u001D\u0010\t\u001A\b\u0012\u0004\u0012\u00020\u00040\b8\u0006\u00A2\u0006\f\n\u0004\b8\u00109\u001A\u0004\b:\u0010\u001CR\u0017\u0010\u000B\u001A\u00020\n8\u0006\u00A2\u0006\f\n\u0004\b;\u0010<\u001A\u0004\b\u000B\u0010\u001ER\u0017\u0010\f\u001A\u00020\n8\u0006\u00A2\u0006\f\n\u0004\b=\u0010<\u001A\u0004\b>\u0010\u001ER\u0017\u0010\r\u001A\u00020\n8\u0006\u00A2\u0006\f\n\u0004\b?\u0010<\u001A\u0004\b\r\u0010\u001ER\u0017\u0010\u000E\u001A\u00020\n8\u0006\u00A2\u0006\f\n\u0004\b@\u0010<\u001A\u0004\b\u000E\u0010\u001ER\u0017\u0010\u000F\u001A\u00020\n8\u0006\u00A2\u0006\f\n\u0004\bA\u0010<\u001A\u0004\b\u000F\u0010\u001ER\u0017\u0010\u0010\u001A\u00020\u00048\u0006\u00A2\u0006\f\n\u0004\bB\u00102\u001A\u0004\bC\u0010\u0018R\u0017\u0010\u0012\u001A\u00020\u00118\u0006\u00A2\u0006\f\n\u0004\bD\u0010E\u001A\u0004\bF\u0010%\u00A8\u0006G"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/model/DrawerPlytWrapper;", "Lcom/melon/ui/K4;", "", "thumbType", "", "titleForGrid", "titleForList", "desc", "", "thumbImageList", "", "isOpen", "showMelonLogo", "isPlaying", "isSelect", "isOfflineMode", "drawerPlytType", "Lcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo;", "drawerPlaylistInfo", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZZZZZLjava/lang/String;Lcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo;)V", "component1", "()I", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "()Ljava/util/List;", "component6", "()Z", "component7", "component8", "component9", "component10", "component11", "component12", "()Lcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo;", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZZZZZLjava/lang/String;Lcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo;)Lcom/iloen/melon/player/playlist/drawernew/model/DrawerPlytWrapper;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "a", "I", "getThumbType", "b", "Ljava/lang/String;", "getTitleForGrid", "c", "getTitleForList", "d", "getDesc", "e", "Ljava/util/List;", "getThumbImageList", "f", "Z", "g", "getShowMelonLogo", "h", "i", "j", "k", "getDrawerPlytType", "l", "Lcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo;", "getDrawerPlaylistInfo", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DrawerPlytWrapper implements K4 {
    public static final int $stable = 8;
    public final int a;
    public final String b;
    public final String c;
    public final String d;
    public final List e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final String k;
    public final DrawerPlaylistInfo l;

    public DrawerPlytWrapper(int v, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull List list0, boolean z, boolean z1, boolean z2, boolean z3, boolean z4, @NotNull String s3, @NotNull DrawerPlaylistInfo drawerPlaylistInfo0) {
        q.g(s, "titleForGrid");
        q.g(s1, "titleForList");
        q.g(s2, "desc");
        q.g(list0, "thumbImageList");
        q.g(s3, "drawerPlytType");
        q.g(drawerPlaylistInfo0, "drawerPlaylistInfo");
        super();
        this.a = v;
        this.b = s;
        this.c = s1;
        this.d = s2;
        this.e = list0;
        this.f = z;
        this.g = z1;
        this.h = z2;
        this.i = z3;
        this.j = z4;
        this.k = s3;
        this.l = drawerPlaylistInfo0;
    }

    public DrawerPlytWrapper(int v, String s, String s1, String s2, List list0, boolean z, boolean z1, boolean z2, boolean z3, boolean z4, String s3, DrawerPlaylistInfo drawerPlaylistInfo0, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        this(v, s, s1, s2, list0, ((v1 & 0x20) == 0 ? z : true), ((v1 & 0x40) == 0 ? z1 : false), ((v1 & 0x80) == 0 ? z2 : false), z3, z4, s3, drawerPlaylistInfo0);
    }

    public final int component1() {
        return this.a;
    }

    public final boolean component10() {
        return this.j;
    }

    @NotNull
    public final String component11() {
        return this.k;
    }

    @NotNull
    public final DrawerPlaylistInfo component12() {
        return this.l;
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

    @NotNull
    public final List component5() {
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
    public final DrawerPlytWrapper copy(int v, @NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull List list0, boolean z, boolean z1, boolean z2, boolean z3, boolean z4, @NotNull String s3, @NotNull DrawerPlaylistInfo drawerPlaylistInfo0) {
        q.g(s, "titleForGrid");
        q.g(s1, "titleForList");
        q.g(s2, "desc");
        q.g(list0, "thumbImageList");
        q.g(s3, "drawerPlytType");
        q.g(drawerPlaylistInfo0, "drawerPlaylistInfo");
        return new DrawerPlytWrapper(v, s, s1, s2, list0, z, z1, z2, z3, z4, s3, drawerPlaylistInfo0);
    }

    public static DrawerPlytWrapper copy$default(DrawerPlytWrapper drawerPlytWrapper0, int v, String s, String s1, String s2, List list0, boolean z, boolean z1, boolean z2, boolean z3, boolean z4, String s3, DrawerPlaylistInfo drawerPlaylistInfo0, int v1, Object object0) {
        if((v1 & 1) != 0) {
            v = drawerPlytWrapper0.a;
        }
        if((v1 & 2) != 0) {
            s = drawerPlytWrapper0.b;
        }
        if((v1 & 4) != 0) {
            s1 = drawerPlytWrapper0.c;
        }
        if((v1 & 8) != 0) {
            s2 = drawerPlytWrapper0.d;
        }
        if((v1 & 16) != 0) {
            list0 = drawerPlytWrapper0.e;
        }
        if((v1 & 0x20) != 0) {
            z = drawerPlytWrapper0.f;
        }
        if((v1 & 0x40) != 0) {
            z1 = drawerPlytWrapper0.g;
        }
        if((v1 & 0x80) != 0) {
            z2 = drawerPlytWrapper0.h;
        }
        if((v1 & 0x100) != 0) {
            z3 = drawerPlytWrapper0.i;
        }
        if((v1 & 0x200) != 0) {
            z4 = drawerPlytWrapper0.j;
        }
        if((v1 & 0x400) != 0) {
            s3 = drawerPlytWrapper0.k;
        }
        if((v1 & 0x800) != 0) {
            drawerPlaylistInfo0 = drawerPlytWrapper0.l;
        }
        return drawerPlytWrapper0.copy(v, s, s1, s2, list0, z, z1, z2, z3, z4, s3, drawerPlaylistInfo0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof DrawerPlytWrapper)) {
            return false;
        }
        if(this.a != ((DrawerPlytWrapper)object0).a) {
            return false;
        }
        if(!q.b(this.b, ((DrawerPlytWrapper)object0).b)) {
            return false;
        }
        if(!q.b(this.c, ((DrawerPlytWrapper)object0).c)) {
            return false;
        }
        if(!q.b(this.d, ((DrawerPlytWrapper)object0).d)) {
            return false;
        }
        if(!q.b(this.e, ((DrawerPlytWrapper)object0).e)) {
            return false;
        }
        if(this.f != ((DrawerPlytWrapper)object0).f) {
            return false;
        }
        if(this.g != ((DrawerPlytWrapper)object0).g) {
            return false;
        }
        if(this.h != ((DrawerPlytWrapper)object0).h) {
            return false;
        }
        if(this.i != ((DrawerPlytWrapper)object0).i) {
            return false;
        }
        if(this.j != ((DrawerPlytWrapper)object0).j) {
            return false;
        }
        return q.b(this.k, ((DrawerPlytWrapper)object0).k) ? q.b(this.l, ((DrawerPlytWrapper)object0).l) : false;
    }

    @NotNull
    public final String getDesc() {
        return this.d;
    }

    @NotNull
    public final DrawerPlaylistInfo getDrawerPlaylistInfo() {
        return this.l;
    }

    @NotNull
    public final String getDrawerPlytType() {
        return this.k;
    }

    public final boolean getShowMelonLogo() {
        return this.g;
    }

    @NotNull
    public final List getThumbImageList() {
        return this.e;
    }

    public final int getThumbType() {
        return this.a;
    }

    @NotNull
    public final String getTitleForGrid() {
        return this.b;
    }

    @NotNull
    public final String getTitleForList() {
        return this.c;
    }

    @Override
    public int hashCode() {
        return this.l.hashCode() + x.b(d.e(d.e(d.e(d.e(d.e(d.d(x.b(x.b(x.b(this.a * 0x1F, 0x1F, this.b), 0x1F, this.c), 0x1F, this.d), 0x1F, this.e), 0x1F, this.f), 0x1F, this.g), 0x1F, this.h), 0x1F, this.i), 0x1F, this.j), 0x1F, this.k);
    }

    public final boolean isOfflineMode() {
        return this.j;
    }

    public final boolean isOpen() {
        return this.f;
    }

    public final boolean isPlaying() {
        return this.h;
    }

    public final boolean isSelect() {
        return this.i;
    }

    @Override
    @NotNull
    public String toString() {
        StringBuilder stringBuilder0 = x.o(this.a, "DrawerPlytWrapper(thumbType=", ", titleForGrid=", this.b, ", titleForList=");
        d.u(stringBuilder0, this.c, ", desc=", this.d, ", thumbImageList=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", isOpen=");
        stringBuilder0.append(this.f);
        stringBuilder0.append(", showMelonLogo=");
        x.y(stringBuilder0, this.g, ", isPlaying=", this.h, ", isSelect=");
        x.y(stringBuilder0, this.i, ", isOfflineMode=", this.j, ", drawerPlytType=");
        stringBuilder0.append(this.k);
        stringBuilder0.append(", drawerPlaylistInfo=");
        stringBuilder0.append(this.l);
        stringBuilder0.append(")");
        return stringBuilder0.toString();
    }
}

