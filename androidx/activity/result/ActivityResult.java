package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import com.iloen.melon.sns.model.e;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@SuppressLint({"BanParcelableUsage"})
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Landroidx/activity/result/ActivityResult;", "Landroid/os/Parcelable;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ActivityResult implements Parcelable {
    @NotNull
    public static final Parcelable.Creator CREATOR;
    public final int a;
    public final Intent b;

    static {
        ActivityResult.CREATOR = new e(14);
    }

    public ActivityResult(int v, Intent intent0) {
        this.a = v;
        this.b = intent0;
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override
    public final String toString() {
        String s;
        StringBuilder stringBuilder0 = new StringBuilder("ActivityResult{resultCode=");
        int v = this.a;
        switch(v) {
            case -1: {
                s = "RESULT_OK";
                break;
            }
            case 0: {
                s = "RESULT_CANCELED";
                break;
            }
            default: {
                s = String.valueOf(v);
            }
        }
        stringBuilder0.append(s);
        stringBuilder0.append(", data=");
        stringBuilder0.append(this.b);
        stringBuilder0.append('}');
        return stringBuilder0.toString();
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        parcel0.writeInt(this.a);
        Intent intent0 = this.b;
        parcel0.writeInt((intent0 == null ? 0 : 1));
        if(intent0 != null) {
            intent0.writeToParcel(parcel0, v);
        }
    }
}

