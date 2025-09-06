package com.iloen.melon.player.playlist.drawernew;

import Pc.e;
import com.iloen.melon.playback.playlist.smartplaylist.DrawerPlaylistInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerPlytUserEvent;", "LPc/e;", "OnToggleViewMode", "OnClickAlyac", "OnClickPlay", "OnClickItem", "Lcom/iloen/melon/player/playlist/drawernew/DrawerPlytUserEvent$OnClickAlyac;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerPlytUserEvent$OnClickItem;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerPlytUserEvent$OnClickPlay;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerPlytUserEvent$OnToggleViewMode;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class DrawerPlytUserEvent implements e {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\b\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0007J\u0010\u0010\f\u001A\u00020\u000BHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001A\u0010\u0011\u001A\u00020\u00102\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u0015\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerPlytUserEvent$OnClickAlyac;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerPlytUserEvent;", "", "alyac", "<init>", "(Ljava/lang/String;)V", "component1", "()Ljava/lang/String;", "copy", "(Ljava/lang/String;)Lcom/iloen/melon/player/playlist/drawernew/DrawerPlytUserEvent$OnClickAlyac;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getAlyac", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class OnClickAlyac extends DrawerPlytUserEvent {
        public static final int $stable;
        public final String a;

        public OnClickAlyac(@NotNull String s) {
            q.g(s, "alyac");
            super(null);
            this.a = s;
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final OnClickAlyac copy(@NotNull String s) {
            q.g(s, "alyac");
            return new OnClickAlyac(s);
        }

        public static OnClickAlyac copy$default(OnClickAlyac drawerPlytUserEvent$OnClickAlyac0, String s, int v, Object object0) {
            if((v & 1) != 0) {
                s = drawerPlytUserEvent$OnClickAlyac0.a;
            }
            return drawerPlytUserEvent$OnClickAlyac0.copy(s);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof OnClickAlyac ? q.b(this.a, ((OnClickAlyac)object0).a) : false;
        }

        @NotNull
        public final String getAlyac() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return this.a.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "OnClickAlyac(alyac=" + this.a + ")";
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\b\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000B\u001A\u00020\nHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\u000E\u001A\u00020\rHÖ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u001A\u0010\u0013\u001A\u00020\u00122\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerPlytUserEvent$OnClickItem;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerPlytUserEvent;", "Lcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo;", "drawerPlaylistInfo", "<init>", "(Lcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo;)V", "component1", "()Lcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo;", "copy", "(Lcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo;)Lcom/iloen/melon/player/playlist/drawernew/DrawerPlytUserEvent$OnClickItem;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo;", "getDrawerPlaylistInfo", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class OnClickItem extends DrawerPlytUserEvent {
        public static final int $stable = 8;
        public final DrawerPlaylistInfo a;

        public OnClickItem(@NotNull DrawerPlaylistInfo drawerPlaylistInfo0) {
            q.g(drawerPlaylistInfo0, "drawerPlaylistInfo");
            super(null);
            this.a = drawerPlaylistInfo0;
        }

        @NotNull
        public final DrawerPlaylistInfo component1() {
            return this.a;
        }

        @NotNull
        public final OnClickItem copy(@NotNull DrawerPlaylistInfo drawerPlaylistInfo0) {
            q.g(drawerPlaylistInfo0, "drawerPlaylistInfo");
            return new OnClickItem(drawerPlaylistInfo0);
        }

        public static OnClickItem copy$default(OnClickItem drawerPlytUserEvent$OnClickItem0, DrawerPlaylistInfo drawerPlaylistInfo0, int v, Object object0) {
            if((v & 1) != 0) {
                drawerPlaylistInfo0 = drawerPlytUserEvent$OnClickItem0.a;
            }
            return drawerPlytUserEvent$OnClickItem0.copy(drawerPlaylistInfo0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof OnClickItem ? q.b(this.a, ((OnClickItem)object0).a) : false;
        }

        @NotNull
        public final DrawerPlaylistInfo getDrawerPlaylistInfo() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return this.a.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "OnClickItem(drawerPlaylistInfo=" + this.a + ")";
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\b\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000B\u001A\u00020\nHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\u000E\u001A\u00020\rHÖ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u001A\u0010\u0013\u001A\u00020\u00122\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerPlytUserEvent$OnClickPlay;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerPlytUserEvent;", "Lcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo;", "drawerPlaylistInfo", "<init>", "(Lcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo;)V", "component1", "()Lcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo;", "copy", "(Lcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo;)Lcom/iloen/melon/player/playlist/drawernew/DrawerPlytUserEvent$OnClickPlay;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lcom/iloen/melon/playback/playlist/smartplaylist/DrawerPlaylistInfo;", "getDrawerPlaylistInfo", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class OnClickPlay extends DrawerPlytUserEvent {
        public static final int $stable = 8;
        public final DrawerPlaylistInfo a;

        public OnClickPlay(@NotNull DrawerPlaylistInfo drawerPlaylistInfo0) {
            q.g(drawerPlaylistInfo0, "drawerPlaylistInfo");
            super(null);
            this.a = drawerPlaylistInfo0;
        }

        @NotNull
        public final DrawerPlaylistInfo component1() {
            return this.a;
        }

        @NotNull
        public final OnClickPlay copy(@NotNull DrawerPlaylistInfo drawerPlaylistInfo0) {
            q.g(drawerPlaylistInfo0, "drawerPlaylistInfo");
            return new OnClickPlay(drawerPlaylistInfo0);
        }

        public static OnClickPlay copy$default(OnClickPlay drawerPlytUserEvent$OnClickPlay0, DrawerPlaylistInfo drawerPlaylistInfo0, int v, Object object0) {
            if((v & 1) != 0) {
                drawerPlaylistInfo0 = drawerPlytUserEvent$OnClickPlay0.a;
            }
            return drawerPlytUserEvent$OnClickPlay0.copy(drawerPlaylistInfo0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof OnClickPlay ? q.b(this.a, ((OnClickPlay)object0).a) : false;
        }

        @NotNull
        public final DrawerPlaylistInfo getDrawerPlaylistInfo() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return this.a.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "OnClickPlay(drawerPlaylistInfo=" + this.a + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerPlytUserEvent$OnToggleViewMode;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerPlytUserEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class OnToggleViewMode extends DrawerPlytUserEvent {
        public static final int $stable;
        @NotNull
        public static final OnToggleViewMode INSTANCE;

        static {
            OnToggleViewMode.INSTANCE = new OnToggleViewMode(null);  // 初始化器: Lcom/iloen/melon/player/playlist/drawernew/DrawerPlytUserEvent;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof OnToggleViewMode;
        }

        @Override
        public int hashCode() {
            return 0x549AADD1;
        }

        @Override
        @NotNull
        public String toString() {
            return "OnToggleViewMode";
        }
    }

    public static final int $stable;

    public DrawerPlytUserEvent(DefaultConstructorMarker defaultConstructorMarker0) {
    }
}

