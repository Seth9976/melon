package com.iloen.melon.player.playlist.drawernew;

import com.melon.ui.K4;
import com.melon.ui.V0;
import com.melon.ui.e3;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bq\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUiState;", "Lcom/melon/ui/K4;", "Idle", "Error", "Notification", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUiState$Error;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUiState$Idle;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUiState$Notification;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface DrawerSongUiState extends K4 {
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\b\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000B\u001A\u00020\nHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\u000E\u001A\u00020\rHÖ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u001A\u0010\u0013\u001A\u00020\u00122\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUiState$Error;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUiState;", "Lcom/melon/ui/V0;", "errorUiState", "<init>", "(Lcom/melon/ui/V0;)V", "component1", "()Lcom/melon/ui/V0;", "copy", "(Lcom/melon/ui/V0;)Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUiState$Error;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lcom/melon/ui/V0;", "getErrorUiState", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Error implements DrawerSongUiState {
        public static final int $stable;
        public final V0 a;

        public Error(@NotNull V0 v00) {
            q.g(v00, "errorUiState");
            super();
            this.a = v00;
        }

        @NotNull
        public final V0 component1() {
            return this.a;
        }

        @NotNull
        public final Error copy(@NotNull V0 v00) {
            q.g(v00, "errorUiState");
            return new Error(v00);
        }

        public static Error copy$default(Error drawerSongUiState$Error0, V0 v00, int v, Object object0) {
            if((v & 1) != 0) {
                v00 = drawerSongUiState$Error0.a;
            }
            return drawerSongUiState$Error0.copy(v00);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof Error ? q.b(this.a, ((Error)object0).a) : false;
        }

        @NotNull
        public final V0 getErrorUiState() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return this.a.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "Error(errorUiState=" + this.a + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUiState$Idle;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUiState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Idle implements DrawerSongUiState {
        public static final int $stable;
        @NotNull
        public static final Idle INSTANCE;

        static {
            Idle.INSTANCE = new Idle();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof Idle;
        }

        @Override
        public int hashCode() {
            return 1758719290;
        }

        @Override
        @NotNull
        public String toString() {
            return "Idle";
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\b\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000B\u001A\u00020\nHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\u000E\u001A\u00020\rHÖ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u001A\u0010\u0013\u001A\u00020\u00122\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUiState$Notification;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUiState;", "Lcom/melon/ui/e3;", "notificationUiState", "<init>", "(Lcom/melon/ui/e3;)V", "component1", "()Lcom/melon/ui/e3;", "copy", "(Lcom/melon/ui/e3;)Lcom/iloen/melon/player/playlist/drawernew/DrawerSongUiState$Notification;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lcom/melon/ui/e3;", "getNotificationUiState", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Notification implements DrawerSongUiState {
        public static final int $stable;
        public final e3 a;

        public Notification(@NotNull e3 e30) {
            q.g(e30, "notificationUiState");
            super();
            this.a = e30;
        }

        @NotNull
        public final e3 component1() {
            return this.a;
        }

        @NotNull
        public final Notification copy(@NotNull e3 e30) {
            q.g(e30, "notificationUiState");
            return new Notification(e30);
        }

        public static Notification copy$default(Notification drawerSongUiState$Notification0, e3 e30, int v, Object object0) {
            if((v & 1) != 0) {
                e30 = drawerSongUiState$Notification0.a;
            }
            return drawerSongUiState$Notification0.copy(e30);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof Notification ? q.b(this.a, ((Notification)object0).a) : false;
        }

        @NotNull
        public final e3 getNotificationUiState() {
            return this.a;
        }

        @Override
        public int hashCode() {
            return this.a.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "Notification(notificationUiState=" + this.a + ")";
        }
    }

}

