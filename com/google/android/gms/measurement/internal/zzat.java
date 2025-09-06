package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzhr;
import com.google.android.gms.internal.measurement.zzhs;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import jeb.synthetic.TWR;

public final class zzat {
    final zzav zza;
    private final String zzb;
    private long zzc;

    public zzat(zzav zzav0, String s) {
        Objects.requireNonNull(zzav0);
        this.zza = zzav0;
        super();
        Preconditions.checkNotEmpty(s);
        this.zzb = s;
        this.zzc = -1L;
    }

    public zzat(zzav zzav0, String s, long v) {
        Objects.requireNonNull(zzav0);
        this.zza = zzav0;
        super();
        Preconditions.checkNotEmpty(s);
        this.zzb = s;
        this.zzc = zzav0.zzaj("select rowid from raw_events where app_id = ? and timestamp < ? order by rowid desc limit 1", new String[]{s, String.valueOf(v)}, -1L);
    }

    public final List zza() {
        zzhr zzhr0;
        List list0 = new ArrayList();
        String[] arr_s = {this.zzb, String.valueOf(this.zzc)};
        Cursor cursor0 = null;
        try {
            try {
                cursor0 = this.zza.zze().query("raw_events", new String[]{"rowid", "name", "timestamp", "metadata_fingerprint", "data", "realtime"}, "app_id = ? and rowid > ?", arr_s, null, null, "rowid", "1000");
                if(cursor0.moveToFirst()) {
                    do {
                        boolean z = false;
                        long v = cursor0.getLong(0);
                        long v1 = cursor0.getLong(3);
                        if(Long.compare(cursor0.getLong(5), 1L) == 0) {
                            z = true;
                        }
                        byte[] arr_b = cursor0.getBlob(4);
                        if(v > this.zzc) {
                            this.zzc = v;
                        }
                        try {
                            zzhr0 = (zzhr)zzpj.zzw(zzhs.zzk(), arr_b);
                        }
                        catch(IOException iOException0) {
                            this.zza.zzu.zzaV().zzb().zzc("Data loss. Failed to merge raw event. appId", zzgt.zzl(this.zzb), iOException0);
                            continue;
                        }
                        String s = cursor0.getString(1);
                        if(s == null) {
                            s = "";
                        }
                        zzhr0.zzl(s);
                        zzhr0.zzo(cursor0.getLong(2));
                        ((ArrayList)list0).add(new zzas(v, v1, z, ((zzhs)zzhr0.zzbc())));
                    }
                    while(cursor0.moveToNext());
                }
                else {
                    list0 = Collections.EMPTY_LIST;
                }
            }
            catch(SQLiteException sQLiteException0) {
                this.zza.zzu.zzaV().zzb().zzc("Data loss. Error querying raw events batch. appId", zzgt.zzl(this.zzb), sQLiteException0);
            }
        }
        catch(Throwable throwable0) {
            TWR.safeClose$NT(cursor0, throwable0);
            throw throwable0;
        }
        if(cursor0 != null) {
            cursor0.close();
        }
        return list0;
    }
}

