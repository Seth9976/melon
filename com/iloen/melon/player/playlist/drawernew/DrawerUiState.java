package com.iloen.melon.player.playlist.drawernew;

import com.melon.ui.K4;
import com.melon.ui.c3;
import com.melon.ui.e3;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bq\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u0082\u0001\u0005\u0007\b\t\n\u000B¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerUiState;", "Lcom/melon/ui/K4;", "Idle", "Loading", "NeedLogin", "Error", "Notification", "Lcom/iloen/melon/player/playlist/drawernew/DrawerUiState$Error;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerUiState$Idle;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerUiState$Loading;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerUiState$NeedLogin;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerUiState$Notification;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface DrawerUiState extends K4 {
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\b\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000B\u001A\u00020\nHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\u000E\u001A\u00020\rHÖ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u001A\u0010\u0013\u001A\u00020\u00122\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerUiState$Error;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerUiState;", "Lcom/melon/ui/c3;", "errorUiState", "<init>", "(Lcom/melon/ui/c3;)V", "component1", "()Lcom/melon/ui/c3;", "copy", "(Lcom/melon/ui/c3;)Lcom/iloen/melon/player/playlist/drawernew/DrawerUiState$Error;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lcom/melon/ui/c3;", "getErrorUiState", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Error implements DrawerUiState {
        public static final int $stable;
        public final c3 a;

        public Error(@NotNull c3 c30) {
            q.g(c30, "errorUiState");
            super();
            this.a = c30;
        }

        @NotNull
        public final c3 component1() {
            return this.a;
        }

        @NotNull
        public final Error copy(@NotNull c3 c30) {
            q.g(c30, "errorUiState");
            return new Error(c30);
        }

        public static Error copy$default(Error drawerUiState$Error0, c3 c30, int v, Object object0) {
            if((v & 1) != 0) {
                c30 = drawerUiState$Error0.a;
            }
            return drawerUiState$Error0.copy(c30);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof Error ? q.b(this.a, ((Error)object0).a) : false;
        }

        @NotNull
        public final c3 getErrorUiState() {
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

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerUiState$Idle;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerUiState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Idle implements DrawerUiState {
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
            return 0x2D22EB85;
        }

        @Override
        @NotNull
        public String toString() {
            return "Idle";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerUiState$Loading;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerUiState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Loading implements DrawerUiState {
        public static final int $stable;
        @NotNull
        public static final Loading INSTANCE;

        static {
            Loading.INSTANCE = new Loading();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof Loading;
        }

        @Override
        public int hashCode() {
            return 0x438BCBEB;
        }

        @Override
        @NotNull
        public String toString() {
            return "Loading";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\bÇ\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001A\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001A\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerUiState$NeedLogin;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerUiState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class NeedLogin implements DrawerUiState {
        public static final int $stable;
        @NotNull
        public static final NeedLogin INSTANCE;

        static {
            NeedLogin.INSTANCE = new NeedLogin();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof NeedLogin;
        }

        @Override
        public int hashCode() {
            return 2072403810;
        }

        @Override
        @NotNull
        public String toString() {
            return "NeedLogin";
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\b\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000B\u001A\u00020\nHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\u000E\u001A\u00020\rHÖ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u001A\u0010\u0013\u001A\u00020\u00122\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001A\u0004\b\u0017\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/player/playlist/drawernew/DrawerUiState$Notification;", "Lcom/iloen/melon/player/playlist/drawernew/DrawerUiState;", "Lcom/melon/ui/e3;", "notificationUiState", "<init>", "(Lcom/melon/ui/e3;)V", "component1", "()Lcom/melon/ui/e3;", "copy", "(Lcom/melon/ui/e3;)Lcom/iloen/melon/player/playlist/drawernew/DrawerUiState$Notification;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lcom/melon/ui/e3;", "getNotificationUiState", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Notification implements DrawerUiState {
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

        public static Notification copy$default(Notification drawerUiState$Notification0, e3 e30, int v, Object object0) {
            if((v & 1) != 0) {
                e30 = drawerUiState$Notification0.a;
            }
            return drawerUiState$Notification0.copy(e30);
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

