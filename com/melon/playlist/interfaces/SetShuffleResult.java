package com.melon.playlist.interfaces;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/melon/playlist/interfaces/SetShuffleResult;", "Landroid/os/Parcelable;", "Success", "Failure", "Lcom/melon/playlist/interfaces/SetShuffleResult$Failure;", "Lcom/melon/playlist/interfaces/SetShuffleResult$Success;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface SetShuffleResult extends Parcelable {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/melon/playlist/interfaces/SetShuffleResult$Failure;", "Lcom/melon/playlist/interfaces/SetShuffleResult;", "SelectRepeatOn", "Failure", "Lcom/melon/playlist/interfaces/SetShuffleResult$Failure$Failure;", "Lcom/melon/playlist/interfaces/SetShuffleResult$Failure$SelectRepeatOn;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface Failure extends SetShuffleResult {
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/melon/playlist/interfaces/SetShuffleResult$Failure$Failure;", "Lcom/melon/playlist/interfaces/SetShuffleResult$Failure;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.melon.playlist.interfaces.SetShuffleResult.Failure.Failure implements Failure {
            @NotNull
            public static final Parcelable.Creator CREATOR;
            public final String a;

            static {
                com.melon.playlist.interfaces.SetShuffleResult.Failure.Failure.CREATOR = new d();  // 初始化器: Ljava/lang/Object;-><init>()V
            }

            public com.melon.playlist.interfaces.SetShuffleResult.Failure.Failure(String s) {
                q.g(s, "reason");
                super();
                this.a = s;
            }

            @Override  // android.os.Parcelable
            public final int describeContents() {
                return 0;
            }

            @Override
            public final boolean equals(Object object0) {
                if(this == object0) {
                    return true;
                }
                return object0 instanceof com.melon.playlist.interfaces.SetShuffleResult.Failure.Failure ? q.b(this.a, ((com.melon.playlist.interfaces.SetShuffleResult.Failure.Failure)object0).a) : false;
            }

            @Override
            public final int hashCode() {
                return this.a.hashCode();
            }

            @Override
            public final String toString() {
                return "Failure(reason=" + this.a + ")";
            }

            @Override  // android.os.Parcelable
            public final void writeToParcel(Parcel parcel0, int v) {
                q.g(parcel0, "dest");
                parcel0.writeString(this.a);
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/melon/playlist/interfaces/SetShuffleResult$Failure$SelectRepeatOn;", "Lcom/melon/playlist/interfaces/SetShuffleResult$Failure;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class SelectRepeatOn implements Failure {
            @NotNull
            public static final Parcelable.Creator CREATOR;
            public static final SelectRepeatOn a;

            static {
                SelectRepeatOn.a = new SelectRepeatOn();  // 初始化器: Ljava/lang/Object;-><init>()V
                SelectRepeatOn.CREATOR = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
            }

            @Override  // android.os.Parcelable
            public final int describeContents() {
                return 0;
            }

            // 去混淆评级： 低(20)
            @Override
            public final boolean equals(Object object0) {
                return this == object0 ? true : object0 instanceof SelectRepeatOn;
            }

            @Override
            public final int hashCode() {
                return 0x960B5B14;
            }

            @Override
            public final String toString() {
                return "SelectRepeatOn";
            }

            @Override  // android.os.Parcelable
            public final void writeToParcel(Parcel parcel0, int v) {
                q.g(parcel0, "dest");
                parcel0.writeInt(1);
            }
        }

    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/melon/playlist/interfaces/SetShuffleResult$Success;", "Lcom/melon/playlist/interfaces/SetShuffleResult;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Success implements SetShuffleResult {
        @NotNull
        public static final Parcelable.Creator CREATOR;
        public final boolean a;

        static {
            Success.CREATOR = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public Success(boolean z) {
            this.a = z;
        }

        @Override  // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override
        public final boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof Success ? this.a == ((Success)object0).a : false;
        }

        @Override
        public final int hashCode() {
            return Boolean.hashCode(this.a);
        }

        @Override
        public final String toString() {
            return "Success(isShuffle=" + this.a + ")";
        }

        @Override  // android.os.Parcelable
        public final void writeToParcel(Parcel parcel0, int v) {
            q.g(parcel0, "dest");
            parcel0.writeInt(((int)this.a));
        }
    }

}

