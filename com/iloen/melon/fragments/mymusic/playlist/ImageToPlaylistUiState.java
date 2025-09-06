package com.iloen.melon.fragments.mymusic.playlist;

import A7.d;
import Cc.U3;
import com.melon.ui.K4;
import com.melon.ui.U0;
import com.melon.ui.V0;
import com.melon.ui.e3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000B\f\r¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistUiState;", "Lcom/melon/ui/K4;", "<init>", "()V", "Loading", "Error", "Empty", "NotificationScreen", "Success", "Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistUiState$Empty;", "Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistUiState$Error;", "Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistUiState$Loading;", "Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistUiState$NotificationScreen;", "Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistUiState$Success;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class ImageToPlaylistUiState implements K4 {
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\b\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000B\u001A\u00020\nHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\u000E\u001A\u00020\rHÖ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u001A\u0010\u0013\u001A\u00020\u00122\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001A\u0004\b\u0016\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistUiState$Empty;", "Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistUiState;", "Lcom/melon/ui/U0;", "emptyUiState", "<init>", "(Lcom/melon/ui/U0;)V", "component1", "()Lcom/melon/ui/U0;", "copy", "(Lcom/melon/ui/U0;)Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistUiState$Empty;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/melon/ui/U0;", "getEmptyUiState", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Empty extends ImageToPlaylistUiState {
        public static final int $stable;
        @NotNull
        private final U0 emptyUiState;

        public Empty(@NotNull U0 u00) {
            q.g(u00, "emptyUiState");
            super(null);
            this.emptyUiState = u00;
        }

        @NotNull
        public final U0 component1() {
            return this.emptyUiState;
        }

        @NotNull
        public final Empty copy(@NotNull U0 u00) {
            q.g(u00, "emptyUiState");
            return new Empty(u00);
        }

        public static Empty copy$default(Empty imageToPlaylistUiState$Empty0, U0 u00, int v, Object object0) {
            if((v & 1) != 0) {
                u00 = imageToPlaylistUiState$Empty0.emptyUiState;
            }
            return imageToPlaylistUiState$Empty0.copy(u00);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof Empty ? q.b(this.emptyUiState, ((Empty)object0).emptyUiState) : false;
        }

        @NotNull
        public final U0 getEmptyUiState() {
            return this.emptyUiState;
        }

        @Override
        public int hashCode() {
            return this.emptyUiState.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "Empty(emptyUiState=" + this.emptyUiState + ")";
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\b\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000B\u001A\u00020\nHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\u000E\u001A\u00020\rHÖ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u001A\u0010\u0013\u001A\u00020\u00122\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001A\u0004\b\u0016\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistUiState$Error;", "Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistUiState;", "Lcom/melon/ui/V0;", "errorUiState", "<init>", "(Lcom/melon/ui/V0;)V", "component1", "()Lcom/melon/ui/V0;", "copy", "(Lcom/melon/ui/V0;)Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistUiState$Error;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/melon/ui/V0;", "getErrorUiState", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Error extends ImageToPlaylistUiState {
        public static final int $stable = 8;
        @NotNull
        private final V0 errorUiState;

        public Error(@NotNull V0 v00) {
            q.g(v00, "errorUiState");
            super(null);
            this.errorUiState = v00;
        }

        @NotNull
        public final V0 component1() {
            return this.errorUiState;
        }

        @NotNull
        public final Error copy(@NotNull V0 v00) {
            q.g(v00, "errorUiState");
            return new Error(v00);
        }

        public static Error copy$default(Error imageToPlaylistUiState$Error0, V0 v00, int v, Object object0) {
            if((v & 1) != 0) {
                v00 = imageToPlaylistUiState$Error0.errorUiState;
            }
            return imageToPlaylistUiState$Error0.copy(v00);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof Error ? q.b(this.errorUiState, ((Error)object0).errorUiState) : false;
        }

        @NotNull
        public final V0 getErrorUiState() {
            return this.errorUiState;
        }

        @Override
        public int hashCode() {
            return this.errorUiState.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "Error(errorUiState=" + this.errorUiState + ")";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001A\u00020\tHÖ\u0001J\t\u0010\n\u001A\u00020\u000BHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistUiState$Loading;", "Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistUiState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Loading extends ImageToPlaylistUiState {
        public static final int $stable;
        @NotNull
        public static final Loading INSTANCE;

        static {
            Loading.INSTANCE = new Loading();
        }

        private Loading() {
            super(null);
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(@Nullable Object object0) {
            return this == object0 ? true : object0 instanceof Loading;
        }

        @Override
        public int hashCode() {
            return 0x45B80C7E;
        }

        @Override
        @NotNull
        public String toString() {
            return "Loading";
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001A\u0010\b\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000B\u001A\u00020\nHÖ\u0001¢\u0006\u0004\b\u000B\u0010\fJ\u0010\u0010\u000E\u001A\u00020\rHÖ\u0001¢\u0006\u0004\b\u000E\u0010\u000FJ\u001A\u0010\u0013\u001A\u00020\u00122\b\u0010\u0011\u001A\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001A\u0004\b\u0016\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistUiState$NotificationScreen;", "Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistUiState;", "Lcom/melon/ui/e3;", "notificationScreenUiState", "<init>", "(Lcom/melon/ui/e3;)V", "component1", "()Lcom/melon/ui/e3;", "copy", "(Lcom/melon/ui/e3;)Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistUiState$NotificationScreen;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/melon/ui/e3;", "getNotificationScreenUiState", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class NotificationScreen extends ImageToPlaylistUiState {
        public static final int $stable;
        @NotNull
        private final e3 notificationScreenUiState;

        public NotificationScreen(@NotNull e3 e30) {
            q.g(e30, "notificationScreenUiState");
            super(null);
            this.notificationScreenUiState = e30;
        }

        @NotNull
        public final e3 component1() {
            return this.notificationScreenUiState;
        }

        @NotNull
        public final NotificationScreen copy(@NotNull e3 e30) {
            q.g(e30, "notificationScreenUiState");
            return new NotificationScreen(e30);
        }

        public static NotificationScreen copy$default(NotificationScreen imageToPlaylistUiState$NotificationScreen0, e3 e30, int v, Object object0) {
            if((v & 1) != 0) {
                e30 = imageToPlaylistUiState$NotificationScreen0.notificationScreenUiState;
            }
            return imageToPlaylistUiState$NotificationScreen0.copy(e30);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof NotificationScreen ? q.b(this.notificationScreenUiState, ((NotificationScreen)object0).notificationScreenUiState) : false;
        }

        @NotNull
        public final e3 getNotificationScreenUiState() {
            return this.notificationScreenUiState;
        }

        @Override
        public int hashCode() {
            return this.notificationScreenUiState.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "NotificationScreen(notificationScreenUiState=" + this.notificationScreenUiState + ")";
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000B\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B\'\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0002\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000B\u001A\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u000B\u0010\fJ\u0016\u0010\r\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003¢\u0006\u0004\b\r\u0010\u000EJ\u0010\u0010\u000F\u001A\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u000F\u0010\u0010J4\u0010\u0011\u001A\u00020\u00002\b\b\u0002\u0010\u0003\u001A\u00020\u00022\u000E\b\u0002\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001A\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001A\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001A\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001A\u0010\u001B\u001A\u00020\u00022\b\u0010\u001A\u001A\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001B\u0010\u001CR\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001D\u001A\u0004\b\u001E\u0010\fR\u001D\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001F\u001A\u0004\b \u0010\u000ER\u0017\u0010\b\u001A\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010!\u001A\u0004\b\"\u0010\u0010¨\u0006#"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistUiState$Success;", "Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistUiState;", "", "checkAll", "", "LKd/g;", "list", "LCc/U3;", "toolBarUiState", "<init>", "(ZLjava/util/List;LCc/U3;)V", "component1", "()Z", "component2", "()Ljava/util/List;", "component3", "()LCc/U3;", "copy", "(ZLjava/util/List;LCc/U3;)Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistUiState$Success;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getCheckAll", "Ljava/util/List;", "getList", "LCc/U3;", "getToolBarUiState", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Success extends ImageToPlaylistUiState {
        public static final int $stable = 8;
        private final boolean checkAll;
        @NotNull
        private final List list;
        @NotNull
        private final U3 toolBarUiState;

        public Success(boolean z, @NotNull List list0, @NotNull U3 u30) {
            q.g(list0, "list");
            q.g(u30, "toolBarUiState");
            super(null);
            this.checkAll = z;
            this.list = list0;
            this.toolBarUiState = u30;
        }

        public Success(boolean z, List list0, U3 u30, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 1) != 0) {
                z = false;
            }
            this(z, list0, u30);
        }

        public final boolean component1() {
            return this.checkAll;
        }

        @NotNull
        public final List component2() {
            return this.list;
        }

        @NotNull
        public final U3 component3() {
            return this.toolBarUiState;
        }

        @NotNull
        public final Success copy(boolean z, @NotNull List list0, @NotNull U3 u30) {
            q.g(list0, "list");
            q.g(u30, "toolBarUiState");
            return new Success(z, list0, u30);
        }

        public static Success copy$default(Success imageToPlaylistUiState$Success0, boolean z, List list0, U3 u30, int v, Object object0) {
            if((v & 1) != 0) {
                z = imageToPlaylistUiState$Success0.checkAll;
            }
            if((v & 2) != 0) {
                list0 = imageToPlaylistUiState$Success0.list;
            }
            if((v & 4) != 0) {
                u30 = imageToPlaylistUiState$Success0.toolBarUiState;
            }
            return imageToPlaylistUiState$Success0.copy(z, list0, u30);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof Success)) {
                return false;
            }
            if(this.checkAll != ((Success)object0).checkAll) {
                return false;
            }
            return q.b(this.list, ((Success)object0).list) ? q.b(this.toolBarUiState, ((Success)object0).toolBarUiState) : false;
        }

        public final boolean getCheckAll() {
            return this.checkAll;
        }

        @NotNull
        public final List getList() {
            return this.list;
        }

        @NotNull
        public final U3 getToolBarUiState() {
            return this.toolBarUiState;
        }

        @Override
        public int hashCode() {
            return this.toolBarUiState.hashCode() + d.d(Boolean.hashCode(this.checkAll) * 0x1F, 0x1F, this.list);
        }

        @Override
        @NotNull
        public String toString() {
            return "Success(checkAll=" + this.checkAll + ", list=" + this.list + ", toolBarUiState=" + this.toolBarUiState + ")";
        }
    }

    public static final int $stable;

    private ImageToPlaylistUiState() {
    }

    public ImageToPlaylistUiState(DefaultConstructorMarker defaultConstructorMarker0) {
    }
}

