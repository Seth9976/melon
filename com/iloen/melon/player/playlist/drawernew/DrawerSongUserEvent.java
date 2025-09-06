package com.iloen.melon.player.playlist.drawernew;

import Pc.e;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import oc.c0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u000B\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000B\f\u0082\u0001\u000B\r\u000E\u000F\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent;", "LPc/e;", "OnClickHeader", "ClickAllSelectUserEvent", "ToolBarClickReplayUserEvent", "ToolBarClickRemoveUserEvent", "OnSwapSongPosition", "OnTouchDownMoveIconWhenSelectRepeatOn", "OnCheckSong", "OnClickSong", "OnClickThumb", "OnLongClickSong", "OnClickSongMore", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent$ClickAllSelectUserEvent;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent$OnCheckSong;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent$OnClickHeader;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent$OnClickSong;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent$OnClickSongMore;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent$OnClickThumb;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent$OnLongClickSong;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent$OnSwapSongPosition;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent$OnTouchDownMoveIconWhenSelectRepeatOn;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent$ToolBarClickRemoveUserEvent;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent$ToolBarClickReplayUserEvent;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class DrawerSongUserEvent implements e {
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent$ClickAllSelectUserEvent;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ClickAllSelectUserEvent extends DrawerSongUserEvent {
        public static final int $stable;
        @NotNull
        public static final ClickAllSelectUserEvent INSTANCE;

        static {
            ClickAllSelectUserEvent.INSTANCE = new ClickAllSelectUserEvent(null);  // 初始化器: Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof ClickAllSelectUserEvent;
        }

        @Override
        public int hashCode() {
            return 0xAA80C706;
        }

        @Override
        @NotNull
        public String toString() {
            return "ClickAllSelectUserEvent";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000BJ$\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000F\u001A\u00020\u000EHÖ\u0001¢\u0006\u0004\b\u000F\u0010\u0010J\u0010\u0010\u0011\u001A\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000BJ\u001A\u0010\u0015\u001A\u00020\u00142\b\u0010\u0013\u001A\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001A\u0004\b\u0019\u0010\tR\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001A\u0010\u001B\u001A\u0004\b\u001C\u0010\u000B¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent$OnCheckSong;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent;", "Loc/c0;", "sectionSelectState", "", "index", "<init>", "(Loc/c0;I)V", "component1", "()Loc/c0;", "component2", "()I", "copy", "(Loc/c0;I)Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent$OnCheckSong;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Loc/c0;", "getSectionSelectState", "b", "I", "getIndex", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class OnCheckSong extends DrawerSongUserEvent {
        public static final int $stable;
        public final c0 a;
        public final int b;

        public OnCheckSong(@NotNull c0 c00, int v) {
            q.g(c00, "sectionSelectState");
            super(null);
            this.a = c00;
            this.b = v;
        }

        @NotNull
        public final c0 component1() {
            return this.a;
        }

        public final int component2() {
            return this.b;
        }

        @NotNull
        public final OnCheckSong copy(@NotNull c0 c00, int v) {
            q.g(c00, "sectionSelectState");
            return new OnCheckSong(c00, v);
        }

        public static OnCheckSong copy$default(OnCheckSong drawerSongUserEvent$OnCheckSong0, c0 c00, int v, int v1, Object object0) {
            if((v1 & 1) != 0) {
                c00 = drawerSongUserEvent$OnCheckSong0.a;
            }
            if((v1 & 2) != 0) {
                v = drawerSongUserEvent$OnCheckSong0.b;
            }
            return drawerSongUserEvent$OnCheckSong0.copy(c00, v);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof OnCheckSong)) {
                return false;
            }
            return this.a == ((OnCheckSong)object0).a ? this.b == ((OnCheckSong)object0).b : false;
        }

        public final int getIndex() {
            return this.b;
        }

        @NotNull
        public final c0 getSectionSelectState() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return this.b + this.a.hashCode() * 0x1F;
        }

        @Override
        @NotNull
        public String toString() {
            return "OnCheckSong(sectionSelectState=" + this.a + ", index=" + this.b + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent$OnClickHeader;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class OnClickHeader extends DrawerSongUserEvent {
        public static final int $stable;
        @NotNull
        public static final OnClickHeader INSTANCE;

        static {
            OnClickHeader.INSTANCE = new OnClickHeader(null);  // 初始化器: Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof OnClickHeader;
        }

        @Override
        public int hashCode() {
            return 0x309F3122;
        }

        @Override
        @NotNull
        public String toString() {
            return "OnClickHeader";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\b\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000B\u001A\u00020\nHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\r\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0007J\u001A\u0010\u0011\u001A\u00020\u00102\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u0015\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent$OnClickSong;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent;", "", "index", "<init>", "(I)V", "component1", "()I", "copy", "(I)Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent$OnClickSong;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "getIndex", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class OnClickSong extends DrawerSongUserEvent {
        public static final int $stable;
        public final int a;

        public OnClickSong(int v) {
            super(null);
            this.a = v;
        }

        public final int component1() {
            return this.a;
        }

        @NotNull
        public final OnClickSong copy(int v) {
            return new OnClickSong(v);
        }

        public static OnClickSong copy$default(OnClickSong drawerSongUserEvent$OnClickSong0, int v, int v1, Object object0) {
            if((v1 & 1) != 0) {
                v = drawerSongUserEvent$OnClickSong0.a;
            }
            return drawerSongUserEvent$OnClickSong0.copy(v);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof OnClickSong ? this.a == ((OnClickSong)object0).a : false;
        }

        public final int getIndex() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return this.a;
        }

        @Override
        @NotNull
        public String toString() {
            return "OnClickSong(index=" + this.a + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\b\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000B\u001A\u00020\nHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\r\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0007J\u001A\u0010\u0011\u001A\u00020\u00102\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u0015\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent$OnClickSongMore;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent;", "", "index", "<init>", "(I)V", "component1", "()I", "copy", "(I)Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent$OnClickSongMore;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "getIndex", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class OnClickSongMore extends DrawerSongUserEvent {
        public static final int $stable;
        public final int a;

        public OnClickSongMore(int v) {
            super(null);
            this.a = v;
        }

        public final int component1() {
            return this.a;
        }

        @NotNull
        public final OnClickSongMore copy(int v) {
            return new OnClickSongMore(v);
        }

        public static OnClickSongMore copy$default(OnClickSongMore drawerSongUserEvent$OnClickSongMore0, int v, int v1, Object object0) {
            if((v1 & 1) != 0) {
                v = drawerSongUserEvent$OnClickSongMore0.a;
            }
            return drawerSongUserEvent$OnClickSongMore0.copy(v);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof OnClickSongMore ? this.a == ((OnClickSongMore)object0).a : false;
        }

        public final int getIndex() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return this.a;
        }

        @Override
        @NotNull
        public String toString() {
            return "OnClickSongMore(index=" + this.a + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\b\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000B\u001A\u00020\nHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\r\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0007J\u001A\u0010\u0011\u001A\u00020\u00102\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u0015\u0010\u0007¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent$OnClickThumb;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent;", "", "index", "<init>", "(I)V", "component1", "()I", "copy", "(I)Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent$OnClickThumb;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "getIndex", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class OnClickThumb extends DrawerSongUserEvent {
        public static final int $stable;
        public final int a;

        public OnClickThumb(int v) {
            super(null);
            this.a = v;
        }

        public final int component1() {
            return this.a;
        }

        @NotNull
        public final OnClickThumb copy(int v) {
            return new OnClickThumb(v);
        }

        public static OnClickThumb copy$default(OnClickThumb drawerSongUserEvent$OnClickThumb0, int v, int v1, Object object0) {
            if((v1 & 1) != 0) {
                v = drawerSongUserEvent$OnClickThumb0.a;
            }
            return drawerSongUserEvent$OnClickThumb0.copy(v);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof OnClickThumb ? this.a == ((OnClickThumb)object0).a : false;
        }

        public final int getIndex() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return this.a;
        }

        @Override
        @NotNull
        public String toString() {
            return "OnClickThumb(index=" + this.a + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001A\u00020\u0004HÆ\u0003¢\u0006\u0004\b\n\u0010\u000BJ$\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0004HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000F\u001A\u00020\u000EHÖ\u0001¢\u0006\u0004\b\u000F\u0010\u0010J\u0010\u0010\u0011\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\tJ\u001A\u0010\u0014\u001A\u00020\u00042\b\u0010\u0013\u001A\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\tR\u0017\u0010\u0005\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u0005\u0010\u000B¨\u0006\u001B"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent$OnLongClickSong;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent;", "", "index", "", "isOwner", "<init>", "(IZ)V", "component1", "()I", "component2", "()Z", "copy", "(IZ)Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent$OnLongClickSong;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "a", "I", "getIndex", "b", "Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class OnLongClickSong extends DrawerSongUserEvent {
        public static final int $stable;
        public final int a;
        public final boolean b;

        public OnLongClickSong(int v, boolean z) {
            super(null);
            this.a = v;
            this.b = z;
        }

        public final int component1() {
            return this.a;
        }

        public final boolean component2() {
            return this.b;
        }

        @NotNull
        public final OnLongClickSong copy(int v, boolean z) {
            return new OnLongClickSong(v, z);
        }

        public static OnLongClickSong copy$default(OnLongClickSong drawerSongUserEvent$OnLongClickSong0, int v, boolean z, int v1, Object object0) {
            if((v1 & 1) != 0) {
                v = drawerSongUserEvent$OnLongClickSong0.a;
            }
            if((v1 & 2) != 0) {
                z = drawerSongUserEvent$OnLongClickSong0.b;
            }
            return drawerSongUserEvent$OnLongClickSong0.copy(v, z);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof OnLongClickSong)) {
                return false;
            }
            return this.a == ((OnLongClickSong)object0).a ? this.b == ((OnLongClickSong)object0).b : false;
        }

        public final int getIndex() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return Boolean.hashCode(this.b) + this.a * 0x1F;
        }

        public final boolean isOwner() {
            return this.b;
        }

        @Override
        @NotNull
        public String toString() {
            return "OnLongClickSong(index=" + this.a + ", isOwner=" + this.b + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0004\u001A\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ$\u0010\n\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0004\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000BJ\u0010\u0010\r\u001A\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000EJ\u0010\u0010\u000F\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000F\u0010\bJ\u001A\u0010\u0013\u001A\u00020\u00122\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\bR\u0017\u0010\u0004\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0016\u001A\u0004\b\u0019\u0010\b¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent$OnSwapSongPosition;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent;", "", "start", "end", "<init>", "(II)V", "component1", "()I", "component2", "copy", "(II)Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent$OnSwapSongPosition;", "", "toString", "()Ljava/lang/String;", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "I", "getStart", "b", "getEnd", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class OnSwapSongPosition extends DrawerSongUserEvent {
        public static final int $stable;
        public final int a;
        public final int b;

        public OnSwapSongPosition(int v, int v1) {
            super(null);
            this.a = v;
            this.b = v1;
        }

        public final int component1() {
            return this.a;
        }

        public final int component2() {
            return this.b;
        }

        @NotNull
        public final OnSwapSongPosition copy(int v, int v1) {
            return new OnSwapSongPosition(v, v1);
        }

        public static OnSwapSongPosition copy$default(OnSwapSongPosition drawerSongUserEvent$OnSwapSongPosition0, int v, int v1, int v2, Object object0) {
            if((v2 & 1) != 0) {
                v = drawerSongUserEvent$OnSwapSongPosition0.a;
            }
            if((v2 & 2) != 0) {
                v1 = drawerSongUserEvent$OnSwapSongPosition0.b;
            }
            return drawerSongUserEvent$OnSwapSongPosition0.copy(v, v1);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof OnSwapSongPosition)) {
                return false;
            }
            return this.a == ((OnSwapSongPosition)object0).a ? this.b == ((OnSwapSongPosition)object0).b : false;
        }

        public final int getEnd() {
            return this.b;
        }

        public final int getStart() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return this.b + this.a * 0x1F;
        }

        @Override
        @NotNull
        public String toString() {
            return "OnSwapSongPosition(start=" + this.a + ", end=" + this.b + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent$OnTouchDownMoveIconWhenSelectRepeatOn;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class OnTouchDownMoveIconWhenSelectRepeatOn extends DrawerSongUserEvent {
        public static final int $stable;
        @NotNull
        public static final OnTouchDownMoveIconWhenSelectRepeatOn INSTANCE;

        static {
            OnTouchDownMoveIconWhenSelectRepeatOn.INSTANCE = new OnTouchDownMoveIconWhenSelectRepeatOn(null);  // 初始化器: Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof OnTouchDownMoveIconWhenSelectRepeatOn;
        }

        @Override
        public int hashCode() {
            return 0x5CE94EA8;
        }

        @Override
        @NotNull
        public String toString() {
            return "OnTouchDownMoveIconWhenSelectRepeatOn";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent$ToolBarClickRemoveUserEvent;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ToolBarClickRemoveUserEvent extends DrawerSongUserEvent {
        public static final int $stable;
        @NotNull
        public static final ToolBarClickRemoveUserEvent INSTANCE;

        static {
            ToolBarClickRemoveUserEvent.INSTANCE = new ToolBarClickRemoveUserEvent(null);  // 初始化器: Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof ToolBarClickRemoveUserEvent;
        }

        @Override
        public int hashCode() {
            return 2072206346;
        }

        @Override
        @NotNull
        public String toString() {
            return "ToolBarClickRemoveUserEvent";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent$ToolBarClickReplayUserEvent;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ToolBarClickReplayUserEvent extends DrawerSongUserEvent {
        public static final int $stable;
        @NotNull
        public static final ToolBarClickReplayUserEvent INSTANCE;

        static {
            ToolBarClickReplayUserEvent.INSTANCE = new ToolBarClickReplayUserEvent(null);  // 初始化器: Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUserEvent;-><init>(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof ToolBarClickReplayUserEvent;
        }

        @Override
        public int hashCode() {
            return 0xEF1AC07;
        }

        @Override
        @NotNull
        public String toString() {
            return "ToolBarClickReplayUserEvent";
        }
    }

    public static final int $stable;

    public DrawerSongUserEvent(DefaultConstructorMarker defaultConstructorMarker0) {
    }
}

