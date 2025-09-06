package com.google.firebase.messaging;

import R3.e;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.collection.f;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.Map;

@Class(creator = "RemoteMessageCreator")
@Reserved({1})
public final class RemoteMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public final Bundle a;
    public f b;

    static {
        RemoteMessage.CREATOR = new e(8);
    }

    public RemoteMessage(Bundle bundle0) {
        this.a = bundle0;
    }

    public final Map getData() {
        if(this.b == null) {
            f f0 = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
            Bundle bundle0 = this.a;
            for(Object object0: bundle0.keySet()) {
                String s = (String)object0;
                Object object1 = bundle0.get(s);
                if(object1 instanceof String && !s.startsWith("google.") && !s.startsWith("gcm.") && !s.equals("from") && !s.equals("message_type") && !s.equals("collapse_key")) {
                    f0.put(s, ((String)object1));
                }
            }
            this.b = f0;
        }
        return this.b;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeBundle(parcel0, 2, this.a, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

