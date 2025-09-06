package com.melon.ui.detail.holder;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import com.melon.ui.K4;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import y.a;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"com/melon/ui/detail/holder/DetailHolderUiState$CreditItemUiState", "Lcom/melon/ui/K4;", "Landroid/os/Parcelable;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DetailHolderUiState.CreditItemUiState implements Parcelable, K4 {
    @NotNull
    public static final Parcelable.Creator CREATOR;
    public final String a;
    public final String b;

    static {
        DetailHolderUiState.CreditItemUiState.CREATOR = new a(5);
    }

    public DetailHolderUiState.CreditItemUiState(String s, String s1) {
        this.a = s;
        this.b = s1;
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
        if(!(object0 instanceof DetailHolderUiState.CreditItemUiState)) {
            return false;
        }
        return q.b(this.a, ((DetailHolderUiState.CreditItemUiState)object0).a) ? q.b(this.b, ((DetailHolderUiState.CreditItemUiState)object0).b) : false;
    }

    @Override
    public final int hashCode() {
        int v = 0;
        int v1 = this.a == null ? 0 : this.a.hashCode();
        String s = this.b;
        if(s != null) {
            v = s.hashCode();
        }
        return v1 * 0x1F + v;
    }

    @Override
    public final String toString() {
        return "CreditItemUiState(roleName=" + this.a + ", artistName=" + this.b + ")";
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        q.g(parcel0, "dest");
        parcel0.writeString(this.a);
        parcel0.writeString(this.b);
    }
}

