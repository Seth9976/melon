package com.melon.playback.command;

import Pb.p;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0003\u0004\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"com/melon/playback/command/SetABRangeRepeatResult$SetRangeBResult", "LPb/p;", "Landroid/os/Parcelable;", "Success", "Failure", "Lcom/melon/playback/command/SetABRangeRepeatResult$SetRangeBResult$Failure;", "Lcom/melon/playback/command/SetABRangeRepeatResult$SetRangeBResult$Success;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface SetABRangeRepeatResult.SetRangeBResult extends p, Parcelable {
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/melon/playback/command/SetABRangeRepeatResult$SetRangeBResult$Failure;", "Lcom/melon/playback/command/SetABRangeRepeatResult$SetRangeBResult;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Failure implements SetABRangeRepeatResult.SetRangeBResult {
        @NotNull
        public static final Parcelable.Creator CREATOR;
        public final String a;

        static {
            Failure.CREATOR = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
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

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/melon/playback/command/SetABRangeRepeatResult$SetRangeBResult$Success;", "Lcom/melon/playback/command/SetABRangeRepeatResult$SetRangeBResult;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Success implements SetABRangeRepeatResult.SetRangeBResult {
        @NotNull
        public static final Parcelable.Creator CREATOR;
        public static final Success a;

        static {
            Success.a = new Success();  // 初始化器: Ljava/lang/Object;-><init>()V
            Success.CREATOR = new g();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        @Override  // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        // 去混淆评级： 低(20)
        @Override
        public final boolean equals(Object object0) {
            return this == object0 ? true : object0 instanceof Success;
        }

        @Override
        public final int hashCode() {
            return 0x27E3ACAB;
        }

        @Override
        public final String toString() {
            return "Success";
        }

        @Override  // android.os.Parcelable
        public final void writeToParcel(Parcel parcel0, int v) {
            q.g(parcel0, "dest");
            parcel0.writeInt(1);
        }
    }

}

