package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import android.os.Parcel;
import com.google.android.gms.internal.location.zzek;
import java.util.ArrayList;
import java.util.List;

public class GeofencingEvent {
    private final int zza;
    @GeofenceTransition
    private final int zzb;
    private final List zzc;
    private final Location zzd;

    private GeofencingEvent(int v, @GeofenceTransition int v1, List list0, Location location0) {
        this.zza = v;
        this.zzb = v1;
        this.zzc = list0;
        this.zzd = location0;
    }

    public static GeofencingEvent fromIntent(Intent intent0) {
        if(intent0 != null) {
            int v = intent0.getIntExtra("gms_error_code", -1);
            int v1 = intent0.getIntExtra("com.google.android.location.intent.extra.transition", -1);
            if(v1 == -1) {
                v1 = -1;
            }
            else {
                switch(v1) {
                    case 1: 
                    case 2: {
                        break;
                    }
                    case 4: {
                        v1 = 4;
                        break;
                    }
                    default: {
                        v1 = -1;
                    }
                }
            }
            ArrayList arrayList0 = (ArrayList)intent0.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
            if(arrayList0 == null) {
                return v == -1 ? null : new GeofencingEvent(v, v1, null, ((Location)intent0.getParcelableExtra("com.google.android.location.intent.extra.triggering_location")));
            }
            ArrayList arrayList1 = new ArrayList(arrayList0.size());
            int v2 = arrayList0.size();
            for(int v3 = 0; v3 < v2; ++v3) {
                byte[] arr_b = (byte[])arrayList0.get(v3);
                Parcel parcel0 = Parcel.obtain();
                parcel0.unmarshall(arr_b, 0, arr_b.length);
                parcel0.setDataPosition(0);
                zzek zzek0 = (zzek)zzek.CREATOR.createFromParcel(parcel0);
                parcel0.recycle();
                arrayList1.add(zzek0);
            }
            return arrayList1 != null || v != -1 ? new GeofencingEvent(v, v1, arrayList1, ((Location)intent0.getParcelableExtra("com.google.android.location.intent.extra.triggering_location"))) : null;
        }
        return null;
    }

    public int getErrorCode() {
        return this.zza;
    }

    @GeofenceTransition
    public int getGeofenceTransition() {
        return this.zzb;
    }

    public List getTriggeringGeofences() {
        return this.zzc;
    }

    public Location getTriggeringLocation() {
        return this.zzd;
    }

    public boolean hasError() {
        return this.zza != -1;
    }
}

