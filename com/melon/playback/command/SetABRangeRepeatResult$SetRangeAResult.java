package com.melon.playback.command;

import Pb.p;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001C\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bw\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\u0003\u0004\u0005\u0082\u0001\u0003\u0006\u0007\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"com/melon/playback/command/SetABRangeRepeatResult$SetRangeAResult", "LPb/p;", "Landroid/os/Parcelable;", "Success", "Failure", "FailureDisabledStreamCache", "Lcom/melon/playback/command/SetABRangeRepeatResult$SetRangeAResult$Failure;", "Lcom/melon/playback/command/SetABRangeRepeatResult$SetRangeAResult$FailureDisabledStreamCache;", "Lcom/melon/playback/command/SetABRangeRepeatResult$SetRangeAResult$Success;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface SetABRangeRepeatResult.SetRangeAResult extends p, Parcelable {
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/melon/playback/command/SetABRangeRepeatResult$SetRangeAResult$Failure;", "Lcom/melon/playback/command/SetABRangeRepeatResult$SetRangeAResult;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Failure implements SetABRangeRepeatResult.SetRangeAResult {
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

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/melon/playback/command/SetABRangeRepeatResult$SetRangeAResult$FailureDisabledStreamCache;", "Lcom/melon/playback/command/SetABRangeRepeatResult$SetRangeAResult;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class FailureDisabledStreamCache implements SetABRangeRepeatResult.SetRangeAResult {
        @NotNull
        public static final Parcelable.Creator CREATOR;
        public static final FailureDisabledStreamCache a;

        static {
            FailureDisabledStreamCache.a = new FailureDisabledStreamCache();  // 初始化器: Ljava/lang/Object;-><init>()V
            FailureDisabledStreamCache.CREATOR = new d();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        @Override  // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        // 去混淆评级： 低(20)
        @Override
        public final boolean equals(Object object0) {
            return this == object0 ? true : object0 instanceof FailureDisabledStreamCache;
        }

        @Override
        public final int hashCode() {
            return 0x1349EC15;
        }

        @Override
        public final String toString() {
            return "FailureDisabledStreamCache";
        }

        @Override  // android.os.Parcelable
        public final void writeToParcel(Parcel parcel0, int v) {
            q.g(parcel0, "dest");
            parcel0.writeInt(1);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/melon/playback/command/SetABRangeRepeatResult$SetRangeAResult$Success;", "Lcom/melon/playback/command/SetABRangeRepeatResult$SetRangeAResult;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Success implements SetABRangeRepeatResult.SetRangeAResult {
        @NotNull
        public static final Parcelable.Creator CREATOR;
        public static final Success a;

        static {
            Success.a = new Success();  // 初始化器: Ljava/lang/Object;-><init>()V
            Success.CREATOR = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
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
            return 0xCE08426A;
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

