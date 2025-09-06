package com.iloen.melon.player.playlist.drawernew.model;

import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ$\u0010\n\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0004\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000BJ\u0010\u0010\f\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\bJ\u0010\u0010\u000E\u001A\u00020\rHÖ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u001A\u0010\u0012\u001A\u00020\u00112\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0016\u0010\bR\u0017\u0010\u0004\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0015\u001A\u0004\b\u0018\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/model/DrawerAlyac;", "", "", "title", "key", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", "component2", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/iloen/melon/player/playlist/drawernew/model/DrawerAlyac;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getTitle", "b", "getKey", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DrawerAlyac {
    public static final int $stable;
    public final String a;
    public final String b;

    public DrawerAlyac(@NotNull String s, @NotNull String s1) {
        q.g(s, "title");
        q.g(s1, "key");
        super();
        this.a = s;
        this.b = s1;
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final DrawerAlyac copy(@NotNull String s, @NotNull String s1) {
        q.g(s, "title");
        q.g(s1, "key");
        return new DrawerAlyac(s, s1);
    }

    public static DrawerAlyac copy$default(DrawerAlyac drawerAlyac0, String s, String s1, int v, Object object0) {
        if((v & 1) != 0) {
            s = drawerAlyac0.a;
        }
        if((v & 2) != 0) {
            s1 = drawerAlyac0.b;
        }
        return drawerAlyac0.copy(s, s1);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof DrawerAlyac)) {
            return false;
        }
        return q.b(this.a, ((DrawerAlyac)object0).a) ? q.b(this.b, ((DrawerAlyac)object0).b) : false;
    }

    @NotNull
    public final String getKey() {
        return this.b;
    }

    @NotNull
    public final String getTitle() {
        return this.a;
    }

    @Override
    public int hashCode() {
        return this.b.hashCode() + this.a.hashCode() * 0x1F;
    }

    @Override
    @NotNull
    public String toString() {
        return "DrawerAlyac(title=" + this.a + ", key=" + this.b + ")";
    }
}

