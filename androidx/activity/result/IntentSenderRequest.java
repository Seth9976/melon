package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import com.iloen.melon.sns.model.e;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@SuppressLint({"BanParcelableUsage"})
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Landroidx/activity/result/IntentSenderRequest;", "Landroid/os/Parcelable;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class IntentSenderRequest implements Parcelable {
    @NotNull
    public static final Parcelable.Creator CREATOR;
    public final IntentSender a;
    public final Intent b;
    public final int c;
    public final int d;

    static {
        IntentSenderRequest.CREATOR = new e(15);
    }

    public IntentSenderRequest(IntentSender intentSender0, Intent intent0, int v, int v1) {
        q.g(intentSender0, "intentSender");
        super();
        this.a = intentSender0;
        this.b = intent0;
        this.c = v;
        this.d = v1;
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        parcel0.writeParcelable(this.a, v);
        parcel0.writeParcelable(this.b, v);
        parcel0.writeInt(this.c);
        parcel0.writeInt(this.d);
    }
}

