package com.melon.playlist;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/melon/playlist/SetSmartPlaylistUseResult;", "Landroid/os/Parcelable;", "Success", "Failure", "Lcom/melon/playlist/SetSmartPlaylistUseResult$Failure;", "Lcom/melon/playlist/SetSmartPlaylistUseResult$Success;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class SetSmartPlaylistUseResult implements Parcelable {
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/melon/playlist/SetSmartPlaylistUseResult$Failure;", "Lcom/melon/playlist/SetSmartPlaylistUseResult;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Failure extends SetSmartPlaylistUseResult {
        @NotNull
        public static final Parcelable.Creator CREATOR;
        public final String a;

        static {
            Failure.CREATOR = new c();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public Failure(String s) {
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
            return object0 instanceof Failure ? q.b(this.a, ((Failure)object0).a) : false;
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

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/melon/playlist/SetSmartPlaylistUseResult$Success;", "Lcom/melon/playlist/SetSmartPlaylistUseResult;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Success extends SetSmartPlaylistUseResult {
        @NotNull
        public static final Parcelable.Creator CREATOR;
        public final boolean a;

        static {
            Success.CREATOR = new d();  // 初始化器: Ljava/lang/Object;-><init>()V
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
            return "Success(isCurPlaylistStateChanged=" + this.a + ")";
        }

        @Override  // android.os.Parcelable
        public final void writeToParcel(Parcel parcel0, int v) {
            q.g(parcel0, "dest");
            parcel0.writeInt(((int)this.a));
        }
    }

}

