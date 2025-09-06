package com.iloen.melon.player.playlist;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import nc.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0006\u001A\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001C\u0010\b\u001A\u00020\u00002\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000B\u001A\u00020\nHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\u000E\u001A\u00020\rHÖ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u001A\u0010\u0012\u001A\u00020\u00112\b\u0010\u0010\u001A\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001A\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0016\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/iloen/melon/player/playlist/DrawerPlaylistTabInfo;", "", "Lnc/a;", "playlist", "<init>", "(Lnc/a;)V", "component1", "()Lnc/a;", "copy", "(Lnc/a;)Lcom/iloen/melon/player/playlist/DrawerPlaylistTabInfo;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lnc/a;", "getPlaylist", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DrawerPlaylistTabInfo {
    public static final int $stable = 8;
    public final a a;

    public DrawerPlaylistTabInfo() {
        this(null, 1, null);
    }

    public DrawerPlaylistTabInfo(@Nullable a a0) {
        this.a = a0;
    }

    public DrawerPlaylistTabInfo(a a0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            a0 = null;
        }
        this(a0);
    }

    @Nullable
    public final a component1() {
        return this.a;
    }

    @NotNull
    public final DrawerPlaylistTabInfo copy(@Nullable a a0) {
        return new DrawerPlaylistTabInfo(a0);
    }

    public static DrawerPlaylistTabInfo copy$default(DrawerPlaylistTabInfo drawerPlaylistTabInfo0, a a0, int v, Object object0) {
        if((v & 1) != 0) {
            a0 = drawerPlaylistTabInfo0.a;
        }
        return drawerPlaylistTabInfo0.copy(a0);
    }

    @Override
    public boolean equals(@Nullable Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof DrawerPlaylistTabInfo ? q.b(this.a, ((DrawerPlaylistTabInfo)object0).a) : false;
    }

    @Nullable
    public final a getPlaylist() {
        return this.a;
    }

    @Override
    public int hashCode() {
        return this.a == null ? 0 : this.a.hashCode();
    }

    @Override
    @NotNull
    public String toString() {
        return "DrawerPlaylistTabInfo(playlist=" + this.a + ")";
    }
}

