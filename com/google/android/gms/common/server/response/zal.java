package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.util.ArrayList;
import java.util.Map;

@ShowFirstParty
@Class(creator = "FieldMappingDictionaryEntryCreator")
public final class zal extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @VersionField(id = 1)
    final int zaa;
    @Field(id = 2)
    final String zab;
    @Field(id = 3)
    final ArrayList zac;

    static {
        zal.CREATOR = new zap();
    }

    @Constructor
    public zal(@Param(id = 1) int v, @Param(id = 2) String s, @Param(id = 3) ArrayList arrayList0) {
        this.zaa = v;
        this.zab = s;
        this.zac = arrayList0;
    }

    public zal(String s, Map map0) {
        ArrayList arrayList0;
        this.zaa = 1;
        this.zab = s;
        if(map0 == null) {
            arrayList0 = null;
        }
        else {
            arrayList0 = new ArrayList();
            for(Object object0: map0.keySet()) {
                arrayList0.add(new zam(((String)object0), ((com.google.android.gms.common.server.response.FastJsonResponse.Field)map0.get(((String)object0)))));
            }
        }
        this.zac = arrayList0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.zaa);
        SafeParcelWriter.writeString(parcel0, 2, this.zab, false);
        SafeParcelWriter.writeTypedList(parcel0, 3, this.zac, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

