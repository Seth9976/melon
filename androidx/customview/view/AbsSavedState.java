package androidx.customview.view;

import C6.a;
import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
public abstract class AbsSavedState implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    public final Parcelable a;
    public static final AbsSavedState b;

    static {
        AbsSavedState.b = new AbsSavedState() {  // 初始化器: Landroidx/customview/view/AbsSavedState;-><init>()V
        };
        AbsSavedState.CREATOR = new a(1);
    }

    public AbsSavedState() {
        this.a = null;
    }

    public AbsSavedState(Parcel parcel0, ClassLoader classLoader0) {
        Parcelable parcelable0 = parcel0.readParcelable(classLoader0);
        if(parcelable0 == null) {
            parcelable0 = AbsSavedState.b;
        }
        this.a = parcelable0;
    }

    public AbsSavedState(Parcelable parcelable0) {
        if(parcelable0 == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        if(parcelable0 == AbsSavedState.b) {
            parcelable0 = null;
        }
        this.a = parcelable0;
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeParcelable(this.a, v);
    }
}

