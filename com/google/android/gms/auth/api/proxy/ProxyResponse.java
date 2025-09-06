package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;

@KeepForSdkWithMembers
@ShowFirstParty
@Class(creator = "ProxyResponseCreator")
public class ProxyResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR = null;
    public static final int STATUS_CODE_NO_CONNECTION = -1;
    @Field(id = 5)
    public final byte[] body;
    @Field(id = 1)
    public final int googlePlayServicesStatusCode;
    @Field(id = 2)
    public final PendingIntent recoveryAction;
    @Field(id = 3)
    public final int statusCode;
    @VersionField(id = 1000)
    final int zza;
    @Field(id = 4)
    final Bundle zzb;

    static {
        ProxyResponse.CREATOR = new zzb();
    }

    @Constructor
    public ProxyResponse(@Param(id = 1000) int v, @Param(id = 1) int v1, @Param(id = 2) PendingIntent pendingIntent0, @Param(id = 3) int v2, @Param(id = 4) Bundle bundle0, @Param(id = 5) byte[] arr_b) {
        this.zza = v;
        this.googlePlayServicesStatusCode = v1;
        this.statusCode = v2;
        this.zzb = bundle0;
        this.body = arr_b;
        this.recoveryAction = pendingIntent0;
    }

    public ProxyResponse(int v, PendingIntent pendingIntent0, int v1, Bundle bundle0, byte[] arr_b) {
        this(1, v, pendingIntent0, v1, bundle0, arr_b);
    }

    public ProxyResponse(int v, Map map0, byte[] arr_b) {
        this(1, 0, null, v, ProxyResponse.zza(map0), arr_b);
    }

    public static ProxyResponse createErrorProxyResponse(int v, PendingIntent pendingIntent0, int v1, Map map0, byte[] arr_b) {
        return new ProxyResponse(1, v, pendingIntent0, v1, ProxyResponse.zza(map0), arr_b);
    }

    public Map getHeaders() {
        if(this.zzb == null) {
            return Collections.EMPTY_MAP;
        }
        Map map0 = new HashMap();
        for(Object object0: this.zzb.keySet()) {
            ((HashMap)map0).put(((String)object0), this.zzb.getString(((String)object0)));
        }
        return map0;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.googlePlayServicesStatusCode);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.recoveryAction, v, false);
        SafeParcelWriter.writeInt(parcel0, 3, this.statusCode);
        SafeParcelWriter.writeBundle(parcel0, 4, this.zzb, false);
        SafeParcelWriter.writeByteArray(parcel0, 5, this.body, false);
        SafeParcelWriter.writeInt(parcel0, 1000, this.zza);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    private static Bundle zza(Map map0) {
        Bundle bundle0 = new Bundle();
        if(map0 != null) {
            for(Object object0: map0.entrySet()) {
                bundle0.putString(((String)((Map.Entry)object0).getKey()), ((String)((Map.Entry)object0).getValue()));
            }
        }
        return bundle0;
    }
}

