package com.google.android.gms.measurement.internal;

import A7.d;
import U4.x;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import b3.Z;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfc;
import com.google.android.gms.internal.measurement.zzfd;
import com.google.android.gms.internal.measurement.zzfe;
import com.google.android.gms.internal.measurement.zzff;
import com.google.android.gms.internal.measurement.zzfg;
import com.google.android.gms.internal.measurement.zzfh;
import com.google.android.gms.internal.measurement.zzfm;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zzhr;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzhw;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zzib;
import com.google.android.gms.internal.measurement.zzic;
import com.google.android.gms.internal.measurement.zzid;
import com.google.android.gms.internal.measurement.zzpn;
import com.google.android.gms.internal.measurement.zzql;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import jeb.synthetic.TWR;
import k8.Y;

final class zzav extends zzor {
    static final String[] zza;
    private static final String[] zzb;
    private static final String[] zzc;
    private static final String[] zzd;
    private static final String[] zze;
    private static final String[] zzf;
    private static final String[] zzh;
    private static final String[] zzi;
    private static final String[] zzj;
    private static final String[] zzk;
    private static final String[] zzl;
    private final zzau zzm;
    private final zzof zzn;

    static {
        zzav.zzb = new String[]{"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
        zzav.zza = new String[]{"associated_row_id", "ALTER TABLE upload_queue ADD COLUMN associated_row_id INTEGER;", "last_upload_timestamp", "ALTER TABLE upload_queue ADD COLUMN last_upload_timestamp INTEGER;"};
        zzav.zzc = new String[]{"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
        zzav.zzd = new String[]{"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;", "dma_consent_state", "ALTER TABLE apps ADD COLUMN dma_consent_state INTEGER;", "daily_realtime_dcu_count", "ALTER TABLE apps ADD COLUMN daily_realtime_dcu_count INTEGER;", "bundle_delivery_index", "ALTER TABLE apps ADD COLUMN bundle_delivery_index INTEGER;", "serialized_npa_metadata", "ALTER TABLE apps ADD COLUMN serialized_npa_metadata TEXT;", "unmatched_pfo", "ALTER TABLE apps ADD COLUMN unmatched_pfo INTEGER;", "unmatched_uwa", "ALTER TABLE apps ADD COLUMN unmatched_uwa INTEGER;", "ad_campaign_info", "ALTER TABLE apps ADD COLUMN ad_campaign_info BLOB;", "daily_registered_triggers_count", "ALTER TABLE apps ADD COLUMN daily_registered_triggers_count INTEGER;", "client_upload_eligibility", "ALTER TABLE apps ADD COLUMN client_upload_eligibility INTEGER;", "gmp_version_for_remote_config", "ALTER TABLE apps ADD COLUMN gmp_version_for_remote_config INTEGER;"};
        zzav.zze = new String[]{"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
        zzav.zzf = new String[]{"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
        zzav.zzh = new String[]{"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
        zzav.zzi = new String[]{"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
        zzav.zzj = new String[]{"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
        zzav.zzk = new String[]{"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;", "storage_consent_at_bundling", "ALTER TABLE consent_settings ADD COLUMN storage_consent_at_bundling TEXT;"};
        zzav.zzl = new String[]{"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};
    }

    public zzav(zzpf zzpf0) {
        super(zzpf0);
        this.zzn = new zzof(this.zzu.zzaZ());
        this.zzm = new zzau(this, this.zzu.zzaY(), "google_app_measurement.db");
    }

    public final long zzA(String s, zzib zzib0, String s1, Map map0, zzlr zzlr0, Long long0) {
        this.zzg();
        this.zzay();
        Preconditions.checkNotNull(zzib0);
        Preconditions.checkNotEmpty(s);
        this.zzg();
        this.zzay();
        if(this.zzai()) {
            zzpf zzpf0 = this.zzg;
            long v = zzpf0.zzq().zzb.zza();
            com.google.android.gms.measurement.internal.zzib zzib1 = this.zzu;
            long v1 = zzib1.zzaZ().elapsedRealtime();
            if(Math.abs(v1 - v) > zzal.zzJ()) {
                zzpf0.zzq().zzb.zzb(v1);
                this.zzg();
                this.zzay();
                if(this.zzai()) {
                    int v2 = this.zze().delete("upload_queue", this.zzaI(), new String[0]);
                    if(v2 > 0) {
                        zzib1.zzaV().zzk().zzb("Deleted stale MeasurementBatch rows from upload_queue. rowsDeleted", v2);
                    }
                }
                Preconditions.checkNotEmpty(s);
                this.zzg();
                this.zzay();
                try {
                    int v3 = zzib1.zzc().zzm(s, zzfx.zzz);
                    if(v3 > 0) {
                        this.zze().delete("upload_queue", "rowid in (SELECT rowid FROM upload_queue WHERE app_id=? ORDER BY rowid DESC LIMIT -1 OFFSET ?)", new String[]{s, String.valueOf(v3)});
                    }
                }
                catch(SQLiteException sQLiteException0) {
                    this.zzu.zzaV().zzb().zzc("Error deleting over the limit queued batches. appId", zzgt.zzl(s), sQLiteException0);
                }
            }
        }
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: map0.entrySet()) {
            arrayList0.add(((String)((Map.Entry)object0).getKey()) + "=" + ((String)((Map.Entry)object0).getValue()));
        }
        byte[] arr_b = zzib0.zzcc();
        ContentValues contentValues0 = new ContentValues();
        contentValues0.put("app_id", s);
        contentValues0.put("measurement_batch", arr_b);
        contentValues0.put("upload_uri", s1);
        contentValues0.put("upload_headers", String.join("\r\n", arrayList0));
        contentValues0.put("upload_type", zzlr0.zza());
        com.google.android.gms.measurement.internal.zzib zzib2 = this.zzu;
        contentValues0.put("creation_timestamp", zzib2.zzaZ().currentTimeMillis());
        contentValues0.put("retry_count", 0);
        if(long0 != null) {
            contentValues0.put("associated_row_id", long0);
        }
        try {
            long v4 = this.zze().insert("upload_queue", null, contentValues0);
            if(v4 == -1L) {
                zzib2.zzaV().zzb().zzb("Failed to insert MeasurementBatch (got -1) to upload_queue. appId", s);
                return -1L;
            }
            return v4;
        }
        catch(SQLiteException sQLiteException1) {
            this.zzu.zzaV().zzb().zzc("Error storing MeasurementBatch to upload_queue. appId", s, sQLiteException1);
            return -1L;
        }
    }

    public final zzpi zzB(long v) {
        zzpi zzpi0;
        Cursor cursor0;
        this.zzg();
        this.zzay();
        try {
            cursor0 = null;
            cursor0 = this.zze().query("upload_queue", new String[]{"rowId", "app_id", "measurement_batch", "upload_uri", "upload_headers", "upload_type", "retry_count", "creation_timestamp", "associated_row_id", "last_upload_timestamp"}, "rowId=?", new String[]{String.valueOf(v)}, null, null, null, "1");
            goto label_8;
        }
        catch(SQLiteException sQLiteException0) {
            goto label_12;
        }
        catch(Throwable throwable0) {
        }
        TWR.safeClose$NT(null, throwable0);
        throw throwable0;
        try {
            try {
            label_8:
                if(cursor0.moveToFirst()) {
                    zzpi0 = this.zzaH(((String)Preconditions.checkNotNull(cursor0.getString(1))), v, cursor0.getBlob(2), cursor0.getString(3), cursor0.getString(4), cursor0.getInt(5), cursor0.getInt(6), cursor0.getLong(7), cursor0.getLong(8), cursor0.getLong(9));
                    goto label_17;
                }
            }
            catch(SQLiteException sQLiteException0) {
            label_12:
                this.zzu.zzaV().zzb().zzc("Error to querying MeasurementBatch from upload_queue. rowId", v, sQLiteException0);
            }
            goto label_19;
        }
        catch(Throwable throwable0) {
            TWR.safeClose$NT(cursor0, throwable0);
            throw throwable0;
        }
    label_17:
        cursor0.close();
        return zzpi0;
    label_19:
        if(cursor0 != null) {
            cursor0.close();
        }
        return null;
    }

    public final List zzC(String s, zzon zzon0, int v) {
        List list0;
        Preconditions.checkNotEmpty(s);
        this.zzg();
        this.zzay();
        Cursor cursor0 = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabase0 = this.zze();
                String s1 = zzav.zzaJ(zzon0.zza);
                String s2 = this.zzaI();
                cursor0 = sQLiteDatabase0.query("upload_queue", new String[]{"rowId", "app_id", "measurement_batch", "upload_uri", "upload_headers", "upload_type", "retry_count", "creation_timestamp", "associated_row_id", "last_upload_timestamp"}, "app_id=?" + s1 + " AND NOT " + s2, new String[]{s}, null, null, "creation_timestamp ASC", (v <= 0 ? null : String.valueOf(v)));
                list0 = new ArrayList();
                while(cursor0.moveToNext()) {
                    zzpi zzpi0 = this.zzaH(s, cursor0.getLong(0), cursor0.getBlob(2), cursor0.getString(3), cursor0.getString(4), cursor0.getInt(5), cursor0.getInt(6), cursor0.getLong(7), cursor0.getLong(8), cursor0.getLong(9));
                    if(zzpi0 != null) {
                        ((ArrayList)list0).add(zzpi0);
                    }
                }
            }
            catch(SQLiteException sQLiteException0) {
                this.zzu.zzaV().zzb().zzc("Error to querying MeasurementBatch from upload_queue. appId", s, sQLiteException0);
                list0 = Collections.EMPTY_LIST;
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

    public final boolean zzD(String s) {
        ArrayList arrayList0 = new ArrayList(1);
        arrayList0.add(zzlr.zzb.zza());
        String s1 = zzav.zzaJ(arrayList0);
        String s2 = this.zzaI();
        return this.zzaA(d.n(new StringBuilder(String.valueOf(s1).length() + 61 + s2.length()), "SELECT COUNT(1) > 0 FROM upload_queue WHERE app_id=?", s1, " AND NOT ", s2), new String[]{s}) != 0L;
    }

    public final void zzE(Long long0) {
        this.zzg();
        this.zzay();
        Preconditions.checkNotNull(long0);
        SQLiteDatabase sQLiteDatabase0 = this.zze();
        String[] arr_s = {long0.toString()};
        try {
            if(sQLiteDatabase0.delete("upload_queue", "rowid=?", arr_s) != 1) {
                this.zzu.zzaV().zze().zza("Deleted fewer rows from upload_queue than expected");
            }
        }
        catch(SQLiteException sQLiteException0) {
            this.zzu.zzaV().zzb().zzb("Failed to delete a MeasurementBatch in a upload_queue table", sQLiteException0);
            throw sQLiteException0;
        }
    }

    public final String zzF() {
        String s;
        SQLiteException sQLiteException1;
        Cursor cursor0;
        SQLiteDatabase sQLiteDatabase0 = this.zze();
        try {
            cursor0 = sQLiteDatabase0.rawQuery("select app_id from queue order by has_realtime desc, rowid asc limit 1;", null);
        }
        catch(SQLiteException sQLiteException0) {
            sQLiteException1 = sQLiteException0;
            cursor0 = null;
            goto label_14;
        }
        catch(Throwable throwable0) {
            TWR.safeClose$NT(null, throwable0);
            throw throwable0;
        }
        try {
            try {
                if(cursor0.moveToFirst()) {
                    s = cursor0.getString(0);
                    goto label_19;
                }
                goto label_21;
            }
            catch(SQLiteException sQLiteException1) {
            }
        label_14:
            this.zzu.zzaV().zzb().zzb("Database error getting next bundle app id", sQLiteException1);
            goto label_21;
        }
        catch(Throwable throwable1) {
            TWR.safeClose$NT(cursor0, throwable1);
            throw throwable1;
        }
    label_19:
        cursor0.close();
        return s;
    label_21:
        if(cursor0 != null) {
            cursor0.close();
        }
        return null;
    }

    public final boolean zzG() {
        return this.zzaA("select count(1) > 0 from queue where has_realtime = 1", null) != 0L;
    }

    public final void zzH(long v) {
        this.zzg();
        this.zzay();
        SQLiteDatabase sQLiteDatabase0 = this.zze();
        try {
            if(sQLiteDatabase0.delete("queue", "rowid=?", new String[]{String.valueOf(v)}) != 1) {
                throw new SQLiteException("Deleted fewer rows from queue than expected");
            }
        }
        catch(SQLiteException sQLiteException0) {
            this.zzu.zzaV().zzb().zzb("Failed to delete a bundle in a queue table", sQLiteException0);
            throw sQLiteException0;
        }
    }

    public final void zzI() {
        this.zzg();
        this.zzay();
        if(this.zzai()) {
            zzpf zzpf0 = this.zzg;
            long v = zzpf0.zzq().zza.zza();
            com.google.android.gms.measurement.internal.zzib zzib0 = this.zzu;
            long v1 = zzib0.zzaZ().elapsedRealtime();
            if(Math.abs(v1 - v) > zzal.zzJ()) {
                zzpf0.zzq().zza.zzb(v1);
                this.zzg();
                this.zzay();
                if(this.zzai()) {
                    int v2 = this.zze().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzib0.zzaZ().currentTimeMillis()), "518400000"});
                    if(v2 > 0) {
                        zzib0.zzaV().zzk().zzb("Deleted stale rows. rowsDeleted", v2);
                    }
                }
            }
        }
    }

    public final void zzJ(List list0) {
        this.zzg();
        this.zzay();
        Preconditions.checkNotNull(list0);
        Preconditions.checkNotZero(list0.size());
        if(!this.zzai()) {
            return;
        }
        String s = TextUtils.join(",", list0);
        String s1 = Y.l(new StringBuilder(String.valueOf(s).length() + 2), "(", s, ")");
        if(this.zzaA(Y.l(new StringBuilder(s1.length() + 80), "SELECT COUNT(1) FROM queue WHERE rowid IN ", s1, " AND retry_count =  2147483647 LIMIT 1"), null) > 0L) {
            Z.A(this.zzu, "The number of upload retries exceeds the limit. Will remain unchanged.");
        }
        try {
            this.zze().execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + s1 + " AND (retry_count IS NULL OR retry_count < 2147483647)");
        }
        catch(SQLiteException sQLiteException0) {
            this.zzu.zzaV().zzb().zzb("Error incrementing retry count. error", sQLiteException0);
        }
    }

    public final void zzK(Long long0) {
        this.zzg();
        this.zzay();
        Preconditions.checkNotNull(long0);
        if(!this.zzai()) {
            return;
        }
        if(this.zzaA("SELECT COUNT(1) FROM upload_queue WHERE rowid = " + long0 + " AND retry_count =  2147483647 LIMIT 1", null) > 0L) {
            Z.A(this.zzu, "The number of upload retries exceeds the limit. Will remain unchanged.");
        }
        try {
            this.zze().execSQL("UPDATE upload_queue" + (" SET retry_count = retry_count + 1, last_upload_timestamp = " + this.zzu.zzaZ().currentTimeMillis()) + " WHERE rowid = " + long0 + " AND retry_count < 2147483647");
        }
        catch(SQLiteException sQLiteException0) {
            this.zzu.zzaV().zzb().zzb("Error incrementing retry count. error", sQLiteException0);
        }
    }

    public final Object zzL(Cursor cursor0, int v) {
        int v1 = cursor0.getType(v);
        switch(v1) {
            case 0: {
                Z.u(this.zzu, "Loaded invalid null value from database");
                return null;
            }
            case 1: {
                return cursor0.getLong(v);
            }
            case 2: {
                return cursor0.getDouble(v);
            }
            case 3: {
                return cursor0.getString(v);
            }
            case 4: {
                Z.u(this.zzu, "Loaded invalid blob type value, ignoring it");
                return null;
            }
            default: {
                this.zzu.zzaV().zzb().zzb("Loaded invalid unknown value type, ignoring it", v1);
                return null;
            }
        }
    }

    public final long zzM() {
        return this.zzaB("select max(bundle_end_timestamp) from queue", null, 0L);
    }

    public final long zzN(String s, String s1) {
        long v3;
        long v2;
        Preconditions.checkNotEmpty(s);
        new String("first_open_count");
        this.zzg();
        this.zzay();
        SQLiteDatabase sQLiteDatabase0 = this.zze();
        sQLiteDatabase0.beginTransaction();
        long v = 0L;
        try {
            v2 = -1L;
            v3 = this.zzaB("select first_open_count from app2 where app_id=?", new String[]{s}, -1L);
            if(Long.compare(v3, -1L) == 0) {
                ContentValues contentValues0 = new ContentValues();
                contentValues0.put("app_id", s);
                contentValues0.put("first_open_count", 0);
                contentValues0.put("previous_install_count", 0);
                if(sQLiteDatabase0.insertWithOnConflict("app2", null, contentValues0, 5) == -1L) {
                    this.zzu.zzaV().zzb().zzc("Failed to insert column (got -1). appId", zzgt.zzl(s), "first_open_count");
                }
                else {
                    v3 = 0L;
                    goto label_22;
                }
            }
            else {
                goto label_22;
            }
            return v2;
        }
        catch(SQLiteException sQLiteException0) {
            this.zzu.zzaV().zzb().zzd("Error inserting column. appId", zzgt.zzl(s), "first_open_count", sQLiteException0);
            return v;
        }
        finally {
            sQLiteDatabase0.endTransaction();
        }
        try {
        label_22:
            ContentValues contentValues1 = new ContentValues();
            contentValues1.put("app_id", s);
            contentValues1.put("first_open_count", ((long)(v3 + 1L)));
            if(((long)sQLiteDatabase0.update("app2", contentValues1, "app_id = ?", new String[]{s})) == 0L) {
                this.zzu.zzaV().zzb().zzc("Failed to update column (got 0). appId", zzgt.zzl(s), "first_open_count");
            }
            else {
                sQLiteDatabase0.setTransactionSuccessful();
                return v3;
            }
            return v2;
        }
        catch(SQLiteException sQLiteException0) {
            v = v3;
        }
        this.zzu.zzaV().zzb().zzd("Error inserting column. appId", zzgt.zzl(s), "first_open_count", sQLiteException0);
        return v;
    }

    public final long zzO() {
        return this.zzaB("select max(timestamp) from raw_events", null, 0L);
    }

    public final boolean zzP() {
        return this.zzaA("select count(1) > 0 from raw_events", null) != 0L;
    }

    public final boolean zzQ(String s, String s1) {
        return this.zzaA("select count(1) from raw_events where app_id = ? and name = ?", new String[]{s, s1}) > 0L;
    }

    public final boolean zzR() {
        return this.zzaA("select count(1) > 0 from raw_events where realtime = 1", null) != 0L;
    }

    public final void zzS(List list0) {
        Preconditions.checkNotNull(list0);
        this.zzg();
        this.zzay();
        StringBuilder stringBuilder0 = new StringBuilder("rowid in (");
        for(int v = 0; v < list0.size(); ++v) {
            if(v != 0) {
                stringBuilder0.append(",");
            }
            stringBuilder0.append(((long)(((Long)list0.get(v)))));
        }
        stringBuilder0.append(")");
        int v1 = this.zze().delete("raw_events", stringBuilder0.toString(), null);
        if(v1 != list0.size()) {
            this.zzu.zzaV().zzb().zzc("Deleted fewer rows from raw events table than expected", v1, list0.size());
        }
    }

    public final void zzT(String s) {
        SQLiteDatabase sQLiteDatabase0 = this.zze();
        try {
            sQLiteDatabase0.execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{s, s});
        }
        catch(SQLiteException sQLiteException0) {
            this.zzu.zzaV().zzb().zzc("Failed to remove unused event metadata. appId", zzgt.zzl(s), sQLiteException0);
        }
    }

    public final long zzU(String s) {
        Preconditions.checkNotEmpty(s);
        return this.zzaB("select count(1) from events where app_id=? and name not like \'!_%\' escape \'!\'", new String[]{s}, 0L);
    }

    public final boolean zzV(String s, Long long0, long v, zzhs zzhs0) {
        this.zzg();
        this.zzay();
        Preconditions.checkNotNull(zzhs0);
        Preconditions.checkNotEmpty(s);
        Preconditions.checkNotNull(long0);
        com.google.android.gms.measurement.internal.zzib zzib0 = this.zzu;
        byte[] arr_b = zzhs0.zzcc();
        zzib0.zzaV().zzk().zzc("Saving complex main event, appId, data size", zzib0.zzl().zza(s), ((int)arr_b.length));
        ContentValues contentValues0 = new ContentValues();
        contentValues0.put("app_id", s);
        contentValues0.put("event_id", long0);
        contentValues0.put("children_to_process", v);
        contentValues0.put("main_event", arr_b);
        try {
            if(this.zze().insertWithOnConflict("main_event_params", null, contentValues0, 5) == -1L) {
                zzib0.zzaV().zzb().zzb("Failed to insert complex main event (got -1). appId", zzgt.zzl(s));
                return false;
            }
            return true;
        }
        catch(SQLiteException sQLiteException0) {
            this.zzu.zzaV().zzb().zzc("Error storing complex main event. appId", zzgt.zzl(s), sQLiteException0);
            return false;
        }
    }

    public final Bundle zzW(String s) {
        Bundle bundle0;
        zzhs zzhs0;
        Cursor cursor0;
        this.zzg();
        this.zzay();
        try {
            cursor0 = null;
            cursor0 = this.zze().rawQuery("select parameters from default_event_params where app_id=?", new String[]{s});
            goto label_8;
        }
        catch(SQLiteException sQLiteException0) {
            goto label_21;
        }
        catch(Throwable throwable0) {
        }
        TWR.safeClose$NT(null, throwable0);
        throw throwable0;
        try {
            try {
            label_8:
                if(!cursor0.moveToFirst()) {
                    this.zzu.zzaV().zzk().zza("Default event parameters not found");
                    goto label_22;
                }
                byte[] arr_b = cursor0.getBlob(0);
                try {
                    zzhs0 = (zzhs)((zzhr)zzpj.zzw(zzhs.zzk(), arr_b)).zzbc();
                }
                catch(IOException iOException0) {
                    this.zzu.zzaV().zzb().zzc("Failed to retrieve default event parameters. appId", zzgt.zzl(s), iOException0);
                    goto label_22;
                }
                this.zzg.zzp();
                bundle0 = zzpj.zzE(zzhs0.zza());
                goto label_28;
            }
            catch(SQLiteException sQLiteException0) {
            label_21:
                this.zzu.zzaV().zzb().zzb("Error selecting default event parameters", sQLiteException0);
            }
        }
        catch(Throwable throwable0) {
            goto label_26;
        }
    label_22:
        if(cursor0 != null) {
            cursor0.close();
        }
        return null;
    label_26:
        TWR.safeClose$NT(cursor0, throwable0);
        throw throwable0;
    label_28:
        cursor0.close();
        return bundle0;
    }

    public final boolean zzX(String s, long v) {
        try {
            if(this.zzaB("select count(*) from raw_events where app_id=? and timestamp >= ? and name not like \'!_%\' escape \'!\' limit 1;", new String[]{s, String.valueOf(v)}, 0L) > 0L) {
                return false;
            }
            if(this.zzaB("select count(*) from raw_events where app_id=? and timestamp >= ? and name like \'!_%\' escape \'!\' limit 1;", new String[]{s, String.valueOf(v)}, 0L) > 0L) {
                return true;
            }
        }
        catch(SQLiteException sQLiteException0) {
            this.zzu.zzaV().zzb().zzb("Error checking backfill conditions", sQLiteException0);
        }
        return false;
    }

    public final void zzY(String s, Long long0, String s1, Bundle bundle0) {
        Bundle bundle3;
        zzid zzid0;
        Cursor cursor1;
        Cursor cursor0;
        Preconditions.checkNotNull(bundle0);
        this.zzg();
        this.zzay();
        zzat zzat0 = long0 == null ? new zzat(this, s) : new zzat(this, s, ((long)long0));
        while(true) {
            List list0 = zzat0.zza();
            if(list0.isEmpty()) {
                break;
            }
            Iterator iterator0 = list0.iterator();
        label_7:
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                zzas zzas0 = (zzas)object0;
                if(!TextUtils.isEmpty(s1)) {
                    try {
                        cursor0 = null;
                        cursor1 = this.zze().query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{s, Long.toString(zzas0.zzb)}, null, null, "rowid", "2");
                        goto label_17;
                    }
                    catch(SQLiteException sQLiteException0) {
                        zzid0 = null;
                        goto label_36;
                        try {
                        label_17:
                            if(cursor1.moveToFirst()) {
                                byte[] arr_b = cursor1.getBlob(0);
                                try {
                                    zzid0 = (zzid)((zzic)zzpj.zzw(zzid.zzaE(), arr_b)).zzbc();
                                    goto label_30;
                                }
                                catch(IOException iOException0) {
                                    this.zzu.zzaV().zzb().zzc("Data loss. Failed to merge raw event metadata. appId", zzgt.zzl(s), iOException0);
                                    goto label_25;
                                }
                            }
                            else {
                                this.zzu.zzaV().zzb().zzb("Raw event metadata record is missing. appId", zzgt.zzl(s));
                                goto label_25;
                            }
                            goto label_49;
                        }
                        catch(SQLiteException sQLiteException0) {
                            goto label_28;
                        }
                        catch(Throwable throwable0) {
                            goto label_45;
                        }
                    label_25:
                        cursor1.close();
                        goto label_49;
                    label_28:
                        zzid0 = null;
                        goto label_35;
                        try {
                        label_30:
                            if(cursor1.moveToNext()) {
                                this.zzu.zzaV().zze().zzb("Get multiple raw event metadata records, expected one. appId", zzgt.zzl(s));
                            }
                            cursor1.close();
                            goto label_47;
                        }
                        catch(SQLiteException sQLiteException0) {
                        }
                        catch(Throwable throwable0) {
                            goto label_45;
                        }
                    label_35:
                        cursor0 = cursor1;
                        try {
                        label_36:
                            this.zzu.zzaV().zzb().zzc("Data loss. Error selecting raw event. appId", zzgt.zzl(s), sQLiteException0);
                            goto label_41;
                        }
                        catch(Throwable throwable0) {
                        }
                        goto label_39;
                    }
                    catch(Throwable throwable0) {
                    label_39:
                        TWR.safeClose$NT(cursor0, throwable0);
                        throw throwable0;
                    }
                label_41:
                    if(cursor0 != null) {
                        cursor0.close();
                        goto label_48;
                    label_45:
                        TWR.safeClose$NT(cursor1, throwable0);
                        throw throwable0;
                    label_47:
                        cursor1.close();
                    }
                label_48:
                    cursor0 = zzid0;
                label_49:
                    if(cursor0 != null) {
                        Iterator iterator1 = ((zzid)cursor0).zzf().iterator();
                        while(iterator1.hasNext()) {
                            iterator1.next();
                            if("".equals(s1)) {
                                continue label_7;
                            }
                            if(false) {
                                break;
                            }
                        }
                    }
                }
                zzpf zzpf0 = this.zzg;
                zzpj zzpj0 = zzpf0.zzp();
                zzhs zzhs0 = zzas0.zzd;
                Bundle bundle1 = new Bundle();
                for(Object object1: zzhs0.zza()) {
                    zzhw zzhw0 = (zzhw)object1;
                    if(zzhw0.zzi()) {
                        bundle1.putDouble("", zzhw0.zzj());
                    }
                    else if(zzhw0.zzg()) {
                        bundle1.putFloat("", zzhw0.zzh());
                    }
                    else if(zzhw0.zze()) {
                        bundle1.putLong("", zzhw0.zzf());
                    }
                    else if(zzhw0.zzc()) {
                        bundle1.putString("", "");
                    }
                    else if(zzhw0.zzk().isEmpty()) {
                        zzpj0.zzu.zzaV().zzb().zzb("Unexpected parameter type for parameter", zzhw0);
                    }
                    else {
                        bundle1.putParcelableArray("", zzpj.zzy(zzhw0.zzk()));
                    }
                }
                String s2 = bundle1.getString("_o");
                bundle1.remove("_o");
                if(s2 == null) {
                    s2 = "";
                }
                zzgu zzgu0 = new zzgu("", s2, bundle1, zzhs0.zzf());
                com.google.android.gms.measurement.internal.zzib zzib0 = this.zzu;
                Bundle bundle2 = zzgu0.zzd;
                zzpo zzpo0 = zzib0.zzk();
                if(zzgu0.zza.equals("_cmp")) {
                    bundle3 = new Bundle(bundle0);
                    for(Object object2: bundle0.keySet()) {
                        String s3 = (String)object2;
                        if(s3.startsWith("gad_")) {
                            bundle3.remove(s3);
                        }
                    }
                }
                else {
                    bundle3 = bundle0;
                }
                zzpo0.zzI(bundle2, bundle3);
                zzbb zzbb0 = new zzbb(this.zzu, zzgu0.zzb, s, "", zzhs0.zzf(), zzhs0.zzh(), bundle2);
                this.zzg();
                this.zzay();
                Preconditions.checkNotNull(zzbb0);
                String s4 = zzbb0.zza;
                Preconditions.checkNotEmpty(s4);
                byte[] arr_b1 = zzpf0.zzp().zzh(zzbb0).zzcc();
                ContentValues contentValues0 = new ContentValues();
                contentValues0.put("app_id", s4);
                contentValues0.put("name", zzbb0.zzb);
                contentValues0.put("timestamp", zzbb0.zzd);
                contentValues0.put("metadata_fingerprint", zzas0.zzb);
                contentValues0.put("data", arr_b1);
                contentValues0.put("realtime", ((int)zzas0.zzc));
                try {
                    long v = (long)this.zze().update("raw_events", contentValues0, "rowid = ?", new String[]{String.valueOf(zzas0.zza)});
                    if(v == 1L) {
                        continue;
                    }
                    zzib0.zzaV().zzb().zzc("Failed to update raw event. appId, updatedRows", zzgt.zzl(s4), v);
                }
                catch(SQLiteException sQLiteException1) {
                    this.zzu.zzaV().zzb().zzc("Error updating raw event. appId", zzgt.zzl(zzbb0.zza), sQLiteException1);
                }
            }
        }
    }

    public final zzjk zzZ(String s) {
        Throwable throwable1;
        SQLiteException sQLiteException1;
        Cursor cursor0;
        Preconditions.checkNotNull(s);
        this.zzg();
        this.zzay();
        zzjk zzjk0 = null;
        try {
            cursor0 = this.zze().rawQuery("select consent_state, consent_source from consent_settings where app_id=? limit 1;", new String[]{s});
        }
        catch(SQLiteException sQLiteException0) {
            sQLiteException1 = sQLiteException0;
            cursor0 = null;
            goto label_19;
        }
        catch(Throwable throwable0) {
            throwable1 = throwable0;
            goto label_24;
        }
        try {
            try {
                if(cursor0.moveToFirst()) {
                    zzjk0 = zzjk.zzf(cursor0.getString(0), cursor0.getInt(1));
                }
                else {
                    this.zzu.zzaV().zzk().zza("No data found");
                }
                goto label_27;
            }
            catch(SQLiteException sQLiteException1) {
            }
        label_19:
            this.zzu.zzaV().zzb().zzb("Error querying database.", sQLiteException1);
            if(cursor0 == null) {
                return zzjk.zza;
            }
            goto label_27;
        }
        catch(Throwable throwable1) {
            zzjk0 = cursor0;
        }
    label_24:
        if(zzjk0 != null) {
            ((Cursor)zzjk0).close();
        }
        throw throwable1;
    label_27:
        cursor0.close();
        return zzjk0 == null ? zzjk.zza : zzjk0;
    }

    private final long zzaA(String s, String[] arr_s) {
        long v;
        SQLiteDatabase sQLiteDatabase0 = this.zze();
        Cursor cursor0 = null;
        try {
            try {
                cursor0 = sQLiteDatabase0.rawQuery(s, arr_s);
                if(!cursor0.moveToFirst()) {
                    throw new SQLiteException("Database returned empty set");
                }
                v = cursor0.getLong(0);
            }
            catch(SQLiteException sQLiteException0) {
                this.zzu.zzaV().zzb().zzc("Database error", s, sQLiteException0);
                throw sQLiteException0;
            }
        }
        catch(Throwable throwable0) {
            TWR.safeClose$NT(cursor0, throwable0);
            throw throwable0;
        }
        cursor0.close();
        return v;
    }

    private final long zzaB(String s, String[] arr_s, long v) {
        SQLiteDatabase sQLiteDatabase0 = this.zze();
        Cursor cursor0 = null;
        try {
            try {
                cursor0 = sQLiteDatabase0.rawQuery(s, arr_s);
                if(cursor0.moveToFirst()) {
                    v = cursor0.getLong(0);
                }
            }
            catch(SQLiteException sQLiteException0) {
                this.zzu.zzaV().zzb().zzc("Database error", s, sQLiteException0);
                throw sQLiteException0;
            }
        }
        catch(Throwable throwable0) {
            TWR.safeClose$NT(cursor0, throwable0);
            throw throwable0;
        }
        cursor0.close();
        return v;
    }

    private final String zzaC(String s, String[] arr_s, String s1) {
        String s2;
        SQLiteDatabase sQLiteDatabase0 = this.zze();
        Cursor cursor0 = null;
        try {
            try {
                cursor0 = sQLiteDatabase0.rawQuery(s, arr_s);
                if(cursor0.moveToFirst()) {
                    s2 = cursor0.getString(0);
                    goto label_12;
                }
                goto label_14;
            }
            catch(SQLiteException sQLiteException0) {
                this.zzu.zzaV().zzb().zzc("Database error", s, sQLiteException0);
                throw sQLiteException0;
            }
        }
        catch(Throwable throwable0) {
            TWR.safeClose$NT(cursor0, throwable0);
            throw throwable0;
        }
    label_12:
        cursor0.close();
        return s2;
    label_14:
        cursor0.close();
        return "";
    }

    private final void zzaD(String s, String s1, ContentValues contentValues0) {
        try {
            SQLiteDatabase sQLiteDatabase0 = this.zze();
            String s2 = contentValues0.getAsString("app_id");
            if(s2 == null) {
                this.zzu.zzaV().zzd().zzb("Value of the primary key is not set.", zzgt.zzl("app_id"));
                return;
            }
            if(((long)sQLiteDatabase0.update("consent_settings", contentValues0, "app_id = ?", new String[]{s2})) == 0L && sQLiteDatabase0.insertWithOnConflict("consent_settings", null, contentValues0, 5) == -1L) {
                this.zzu.zzaV().zzb().zzc("Failed to insert/update table (got -1). key", zzgt.zzl("consent_settings"), zzgt.zzl("app_id"));
            }
            return;
        }
        catch(SQLiteException sQLiteException0) {
        }
        this.zzu.zzaV().zzb().zzd("Error storing into table. key", zzgt.zzl("consent_settings"), zzgt.zzl("app_id"), sQLiteException0);
    }

    private final zzbc zzaE(String s, String s1, String s2) {
        zzbc zzbc0;
        Boolean boolean0;
        Cursor cursor0;
        boolean z;
        Preconditions.checkNotEmpty(s1);
        Preconditions.checkNotEmpty(s2);
        this.zzg();
        this.zzay();
        ArrayList arrayList0 = new ArrayList(Arrays.asList(new String[]{"lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_bundled_day", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling", "current_session_count"}));
        try {
            z = false;
            cursor0 = null;
            cursor0 = this.zze().query(s, ((String[])arrayList0.toArray(new String[0])), "app_id=? and name=?", new String[]{s1, s2}, null, null, null);
            goto label_12;
        }
        catch(SQLiteException sQLiteException0) {
            goto label_34;
        }
        catch(Throwable throwable0) {
        }
        TWR.safeClose$NT(null, throwable0);
        throw throwable0;
        try {
            try {
            label_12:
                if(cursor0.moveToFirst()) {
                    long v = cursor0.getLong(0);
                    long v1 = cursor0.getLong(1);
                    long v2 = cursor0.getLong(2);
                    long v3 = 0L;
                    long v4 = cursor0.isNull(3) ? 0L : cursor0.getLong(3);
                    Long long0 = cursor0.isNull(4) ? null : cursor0.getLong(4);
                    Long long1 = cursor0.isNull(5) ? null : cursor0.getLong(5);
                    Long long2 = cursor0.isNull(6) ? null : cursor0.getLong(6);
                    if(cursor0.isNull(7)) {
                        boolean0 = null;
                    }
                    else {
                        if(cursor0.getLong(7) == 1L) {
                            z = true;
                        }
                        boolean0 = Boolean.valueOf(z);
                    }
                    if(!cursor0.isNull(8)) {
                        v3 = cursor0.getLong(8);
                    }
                    zzbc0 = new zzbc(s1, s2, v, v1, v3, v2, v4, long0, long1, long2, boolean0);
                    if(cursor0.moveToNext()) {
                        this.zzu.zzaV().zzb().zzb("Got multiple records for event aggregates, expected one. appId", zzgt.zzl(s1));
                    }
                    goto label_39;
                }
            }
            catch(SQLiteException sQLiteException0) {
            label_34:
                this.zzu.zzaV().zzb().zzd("Error querying events. appId", zzgt.zzl(s1), this.zzu.zzl().zza(s2), sQLiteException0);
            }
            goto label_41;
        }
        catch(Throwable throwable0) {
            TWR.safeClose$NT(cursor0, throwable0);
            throw throwable0;
        }
    label_39:
        cursor0.close();
        return zzbc0;
    label_41:
        if(cursor0 != null) {
            cursor0.close();
        }
        return null;
    }

    private final void zzaF(String s, zzbc zzbc0) {
        Preconditions.checkNotNull(zzbc0);
        this.zzg();
        this.zzay();
        ContentValues contentValues0 = new ContentValues();
        String s1 = zzbc0.zza;
        contentValues0.put("app_id", s1);
        contentValues0.put("name", zzbc0.zzb);
        contentValues0.put("lifetime_count", zzbc0.zzc);
        contentValues0.put("current_bundle_count", zzbc0.zzd);
        contentValues0.put("last_fire_timestamp", zzbc0.zzf);
        contentValues0.put("last_bundled_timestamp", zzbc0.zzg);
        contentValues0.put("last_bundled_day", zzbc0.zzh);
        contentValues0.put("last_sampled_complex_event_id", zzbc0.zzi);
        contentValues0.put("last_sampling_rate", zzbc0.zzj);
        contentValues0.put("current_session_count", zzbc0.zze);
        contentValues0.put("last_exempt_from_sampling", (zzbc0.zzk == null || !zzbc0.zzk.booleanValue() ? null : 1L));
        try {
            if(this.zze().insertWithOnConflict(s, null, contentValues0, 5) == -1L) {
                this.zzu.zzaV().zzb().zzb("Failed to insert/update event aggregates (got -1). appId", zzgt.zzl(s1));
            }
        }
        catch(SQLiteException sQLiteException0) {
            this.zzu.zzaV().zzb().zzc("Error storing event aggregates. appId", zzgt.zzl(zzbc0.zza), sQLiteException0);
        }
    }

    private final void zzaG(String s, String s1) {
        Preconditions.checkNotEmpty(s1);
        this.zzg();
        this.zzay();
        try {
            this.zze().delete(s, "app_id=?", new String[]{s1});
        }
        catch(SQLiteException sQLiteException0) {
            this.zzu.zzaV().zzb().zzc("Error deleting snapshot. appId", zzgt.zzl(s1), sQLiteException0);
        }
    }

    private final zzpi zzaH(String s, long v, byte[] arr_b, String s1, String s2, int v1, int v2, long v3, long v4, long v5) {
        if(TextUtils.isEmpty(s1)) {
            this.zzu.zzaV().zzj().zza("Upload uri is null or empty. Destination is unknown. Dropping batch. ");
            return null;
        }
        try {
            zzhz zzhz0 = (zzhz)zzpj.zzw(zzib.zzh(), arr_b);
            zzlr zzlr0 = zzlr.zzb(v1);
            if(zzlr0 != zzlr.zzb && zzlr0 != zzlr.zze && v2 > 0) {
                ArrayList arrayList0 = new ArrayList();
                for(Object object0: zzhz0.zza()) {
                    zzic zzic0 = (zzic)((zzid)object0).zzcl();
                    zzic0.zzao(v2);
                    arrayList0.add(((zzid)zzic0.zzbc()));
                }
                zzhz0.zzg();
                zzhz0.zzf(arrayList0);
            }
            HashMap hashMap0 = new HashMap();
            if(s2 != null) {
                String[] arr_s = s2.split("\r\n");
                for(int v6 = 0; v6 < arr_s.length; ++v6) {
                    String s3 = arr_s[v6];
                    if(s3.isEmpty()) {
                        break;
                    }
                    String[] arr_s1 = s3.split("=", 2);
                    if(arr_s1.length != 2) {
                        this.zzu.zzaV().zzb().zzb("Invalid upload header: ", s3);
                        break;
                    }
                    hashMap0.put(arr_s1[0], arr_s1[1]);
                }
            }
            zzph zzph0 = new zzph();
            zzph0.zzb(v);
            zzph0.zzc(((zzib)zzhz0.zzbc()));
            zzph0.zzd(s1);
            zzph0.zze(hashMap0);
            zzph0.zzf(zzlr0);
            zzph0.zzg(v3);
            zzph0.zzh(v4);
            zzph0.zzi(v5);
            zzph0.zzj(v2);
            return zzph0.zza();
        }
        catch(IOException iOException0) {
        }
        this.zzu.zzaV().zzb().zzc("Failed to queued MeasurementBatch from upload_queue. appId", s, iOException0);
        return null;
    }

    private final String zzaI() {
        long v = this.zzu.zzaZ().currentTimeMillis();
        Long long0 = (Long)zzfx.zzS.zzb(null);
        long0.longValue();
        String s = "(upload_type = " + zzlr.zzb.zza() + " AND ABS(creation_timestamp - " + v + ") > " + long0 + ")";
        long v1 = zzal.zzI();
        StringBuilder stringBuilder0 = Z.n(zzlr.zzb.zza(), "(upload_type != ", " AND ABS(creation_timestamp - ", v);
        stringBuilder0.append(") > ");
        stringBuilder0.append(v1);
        stringBuilder0.append(")");
        String s1 = stringBuilder0.toString();
        StringBuilder stringBuilder1 = new StringBuilder(s.length() + 5 + s1.length() + 1);
        d.u(stringBuilder1, "(", s, " OR ", s1);
        stringBuilder1.append(")");
        return stringBuilder1.toString();
    }

    // 去混淆评级： 低(20)
    private static final String zzaJ(List list0) {
        return list0.isEmpty() ? "" : x.k(" AND (upload_type IN (", TextUtils.join(", ", list0), "))");
    }

    public final boolean zzaa(String s, zzog zzog0) {
        this.zzg();
        this.zzay();
        Preconditions.checkNotNull(zzog0);
        Preconditions.checkNotEmpty(s);
        com.google.android.gms.measurement.internal.zzib zzib0 = this.zzu;
        long v = zzib0.zzaZ().currentTimeMillis();
        long v1 = (long)(((Long)zzfx.zzav.zzb(null)));
        long v2 = zzog0.zzb;
        if(v2 < v - v1 || v2 > ((long)(((Long)zzfx.zzav.zzb(null)))) + v) {
            zzib0.zzaV().zze().zzd("Storing trigger URI outside of the max retention time span. appId, now, timestamp", zzgt.zzl(s), v, v2);
        }
        zzib0.zzaV().zzk().zza("Saving trigger URI");
        ContentValues contentValues0 = new ContentValues();
        contentValues0.put("app_id", s);
        contentValues0.put("trigger_uri", zzog0.zza);
        contentValues0.put("source", zzog0.zzc);
        contentValues0.put("timestamp_millis", v2);
        try {
            if(this.zze().insert("trigger_uris", null, contentValues0) == -1L) {
                zzib0.zzaV().zzb().zzb("Failed to insert trigger URI (got -1). appId", zzgt.zzl(s));
                return false;
            }
            return true;
        }
        catch(SQLiteException sQLiteException0) {
            this.zzu.zzaV().zzb().zzc("Error storing trigger URI. appId", zzgt.zzl(s), sQLiteException0);
            return false;
        }
    }

    public final void zzab(String s, zzjk zzjk0) {
        Preconditions.checkNotNull(s);
        Preconditions.checkNotNull(zzjk0);
        this.zzg();
        this.zzay();
        ContentValues contentValues0 = new ContentValues();
        contentValues0.put("app_id", s);
        contentValues0.put("consent_state", zzjk0.zzl());
        contentValues0.put("consent_source", zzjk0.zzb());
        this.zzaD("consent_settings", "app_id", contentValues0);
    }

    public final zzaz zzac(String s) {
        Preconditions.checkNotNull(s);
        this.zzg();
        this.zzay();
        return zzaz.zzg(this.zzaC("select dma_consent_settings from consent_settings where app_id=? limit 1;", new String[]{s}, ""));
    }

    public final void zzad(String s, zzaz zzaz0) {
        Preconditions.checkNotNull(s);
        Preconditions.checkNotNull(zzaz0);
        this.zzg();
        this.zzay();
        zzjk zzjk0 = this.zzZ(s);
        zzjk zzjk1 = zzjk.zza;
        if(zzjk0 == zzjk1) {
            this.zzab(s, zzjk1);
        }
        ContentValues contentValues0 = new ContentValues();
        contentValues0.put("app_id", s);
        contentValues0.put("dma_consent_settings", zzaz0.zze());
        this.zzaD("consent_settings", "app_id", contentValues0);
    }

    public final void zzae(String s, zzjk zzjk0) {
        Preconditions.checkNotNull(s);
        Preconditions.checkNotNull(zzjk0);
        this.zzg();
        this.zzay();
        this.zzab(s, this.zzZ(s));
        ContentValues contentValues0 = new ContentValues();
        contentValues0.put("app_id", s);
        contentValues0.put("storage_consent_at_bundling", zzjk0.zzl());
        this.zzaD("consent_settings", "app_id", contentValues0);
    }

    public final zzjk zzaf(String s) {
        Preconditions.checkNotNull(s);
        this.zzg();
        this.zzay();
        return zzjk.zzf(this.zzaC("select storage_consent_at_bundling from consent_settings where app_id=? limit 1;", new String[]{s}, ""), 100);
    }

    public final void zzag(String s, List list0) {
        SQLiteDatabase sQLiteDatabase2;
        int v4;
        zzfd zzfd0;
        boolean z;
        Preconditions.checkNotNull(list0);
        for(int v = 0; v < list0.size(); ++v) {
            zzfc zzfc0 = (zzfc)((zzfd)list0.get(v)).zzcl();
            if(zzfc0.zzd() != 0) {
                for(int v1 = 0; v1 < zzfc0.zzd(); ++v1) {
                    zzfe zzfe0 = (zzfe)zzfc0.zze(v1).zzcl();
                    zzfe zzfe1 = (zzfe)zzfe0.zzba();
                    String s1 = zzjl.zzb(zzfe0.zza());
                    if(s1 == null) {
                        z = false;
                    }
                    else {
                        zzfe1.zzb(s1);
                        z = true;
                    }
                    for(int v2 = 0; v2 < zzfe0.zzc(); ++v2) {
                        zzfh zzfh0 = zzfe0.zzd(v2);
                        String s2 = zzls.zzc("", zzjm.zza, zzjm.zzb);
                        if(s2 != null) {
                            zzfg zzfg0 = (zzfg)zzfh0.zzcl();
                            zzfg0.zza(s2);
                            zzfe1.zze(v2, ((zzfh)zzfg0.zzbc()));
                            z = true;
                        }
                    }
                    if(z) {
                        zzfc0.zzf(v1, zzfe1);
                        list0.set(v, ((zzfd)zzfc0.zzbc()));
                    }
                }
            }
            if(zzfc0.zza() != 0) {
                for(int v3 = 0; v3 < zzfc0.zza(); ++v3) {
                    zzfn zzfn0 = zzfc0.zzb(v3);
                    String s3 = zzls.zzc("", zzjn.zza, zzjn.zzb);
                    if(s3 != null) {
                        zzfm zzfm0 = (zzfm)zzfn0.zzcl();
                        zzfm0.zza(s3);
                        zzfc0.zzc(v3, zzfm0);
                        list0.set(v, ((zzfd)zzfc0.zzbc()));
                    }
                }
            }
        }
        this.zzay();
        this.zzg();
        Preconditions.checkNotEmpty(s);
        Preconditions.checkNotNull(list0);
        SQLiteDatabase sQLiteDatabase0 = this.zze();
        sQLiteDatabase0.beginTransaction();
        try {
            this.zzay();
            this.zzg();
            Preconditions.checkNotEmpty(s);
            SQLiteDatabase sQLiteDatabase1 = this.zze();
            sQLiteDatabase1.delete("property_filters", "app_id=?", new String[]{s});
            sQLiteDatabase1.delete("event_filters", "app_id=?", new String[]{s});
            Iterator iterator0 = list0.iterator();
        alab1:
            while(true) {
            label_58:
                if(!iterator0.hasNext()) {
                    goto label_115;
                }
                Object object0 = iterator0.next();
                zzfd0 = (zzfd)object0;
                this.zzay();
                this.zzg();
                Preconditions.checkNotEmpty(s);
                Preconditions.checkNotNull(zzfd0);
                if(zzfd0.zza()) {
                    v4 = zzfd0.zzb();
                    for(Object object1: zzfd0.zzf()) {
                        if(!((zzff)object1).zza()) {
                            this.zzu.zzaV().zze().zzc("Event filter with no ID. Audience definition ignored. appId, audienceId", zzgt.zzl(s), v4);
                            continue alab1;
                        }
                        if(false) {
                            break;
                        }
                    }
                    for(Object object2: zzfd0.zzc()) {
                        if(!((zzfn)object2).zza()) {
                            this.zzu.zzaV().zze().zzc("Property filter with no ID. Audience definition ignored. appId, audienceId", zzgt.zzl(s), v4);
                            continue alab1;
                        }
                        if(false) {
                            break;
                        }
                    }
                    Iterator iterator3 = zzfd0.zzf().iterator();
                    if(iterator3.hasNext()) {
                        Object object3 = iterator3.next();
                        zzff zzff0 = (zzff)object3;
                        this.zzay();
                        this.zzg();
                        Preconditions.checkNotEmpty(s);
                        Preconditions.checkNotNull(zzff0);
                        this.zzu.zzaV().zze().zzd("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzgt.zzl(s), v4, String.valueOf((zzff0.zza() ? zzff0.zzb() : null)));
                        sQLiteDatabase2 = sQLiteDatabase0;
                        goto label_102;
                    }
                    break;
                }
                goto label_110;
            }
        }
        catch(Throwable throwable0) {
            sQLiteDatabase2 = sQLiteDatabase0;
            sQLiteDatabase2.endTransaction();
            throw throwable0;
        }
        try {
            sQLiteDatabase2 = sQLiteDatabase0;
            Iterator iterator4 = zzfd0.zzc().iterator();
            if(iterator4.hasNext()) {
                Object object4 = iterator4.next();
                zzfn zzfn1 = (zzfn)object4;
                this.zzay();
                this.zzg();
                Preconditions.checkNotEmpty(s);
                Preconditions.checkNotNull(zzfn1);
                this.zzu.zzaV().zze().zzd("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzgt.zzl(s), v4, String.valueOf((zzfn1.zza() ? zzfn1.zzb() : null)));
            label_102:
                this.zzay();
                this.zzg();
                Preconditions.checkNotEmpty(s);
                SQLiteDatabase sQLiteDatabase3 = this.zze();
                sQLiteDatabase3.delete("property_filters", "app_id=? and audience_id=?", new String[]{s, String.valueOf(v4)});
                sQLiteDatabase3.delete("event_filters", "app_id=? and audience_id=?", new String[]{s, String.valueOf(v4)});
            }
            sQLiteDatabase0 = sQLiteDatabase2;
            goto label_58;
        }
        catch(Throwable throwable0) {
            sQLiteDatabase2.endTransaction();
            throw throwable0;
        }
        try {
        label_110:
            this.zzu.zzaV().zze().zzb("Audience with no ID. appId", zzgt.zzl(s));
            goto label_58;
        }
        catch(Throwable throwable0) {
            sQLiteDatabase2 = sQLiteDatabase0;
            sQLiteDatabase2.endTransaction();
            throw throwable0;
        }
        try {
        label_115:
            sQLiteDatabase2 = sQLiteDatabase0;
            ArrayList arrayList0 = new ArrayList();
            for(Object object5: list0) {
                zzfd zzfd1 = (zzfd)object5;
                arrayList0.add((zzfd1.zza() ? zzfd1.zzb() : null));
            }
            Preconditions.checkNotEmpty(s);
            this.zzay();
            this.zzg();
            SQLiteDatabase sQLiteDatabase4 = this.zze();
            try {
                long v5 = this.zzaA("select count(1) from audience_filter_values where app_id=?", new String[]{s});
            }
            catch(SQLiteException sQLiteException0) {
                this.zzu.zzaV().zzb().zzc("Database error querying filters. appId", zzgt.zzl(s), sQLiteException0);
                sQLiteDatabase2.setTransactionSuccessful();
                goto label_149;
            }
            int v7 = Math.max(0, Math.min(2000, this.zzu.zzc().zzm(s, zzfx.zzU)));
            if(v5 > ((long)v7)) {
                ArrayList arrayList1 = new ArrayList();
                for(int v6 = 0; true; ++v6) {
                    if(v6 >= arrayList0.size()) {
                        sQLiteDatabase4.delete("audience_filter_values", "audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in " + ("(" + TextUtils.join(",", arrayList1) + ")") + " order by rowid desc limit -1 offset ?)", new String[]{s, Integer.toString(v7)});
                        break;
                    }
                    Integer integer0 = (Integer)arrayList0.get(v6);
                    if(integer0 == null) {
                        break;
                    }
                    arrayList1.add(Integer.toString(((int)integer0)));
                }
            }
            sQLiteDatabase2.setTransactionSuccessful();
        }
        catch(Throwable throwable0) {
            sQLiteDatabase2.endTransaction();
            throw throwable0;
        }
    label_149:
        sQLiteDatabase2.endTransaction();
    }

    public final zzbc zzah(String s, zzhs zzhs0, String s1) {
        zzbc zzbc0 = this.zzaE("events", s, "");
        if(zzbc0 == null) {
            this.zzu.zzaV().zze().zzc("Event aggregate wasn\'t created during raw event logging. appId, event", zzgt.zzl(s), this.zzu.zzl().zza(s1));
            return new zzbc(s, "", 1L, 1L, 1L, zzhs0.zzf(), 0L, null, null, null, null);
        }
        return new zzbc(zzbc0.zza, zzbc0.zzb, zzbc0.zzc + 1L, zzbc0.zzd + 1L, zzbc0.zze + 1L, zzbc0.zzf, zzbc0.zzg, zzbc0.zzh, zzbc0.zzi, zzbc0.zzj, zzbc0.zzk);
    }

    public final boolean zzai() {
        return this.zzu.zzaY().getDatabasePath("google_app_measurement.db").exists();
    }

    public final long zzaj(String s, String[] arr_s, long v) {
        return this.zzaB("select rowid from raw_events where app_id = ? and timestamp < ? order by rowid desc limit 1", arr_s, -1L);
    }

    public static String[] zzak() {
        return zzav.zzb;
    }

    public static String[] zzal() {
        return zzav.zzc;
    }

    public static String[] zzam() {
        return zzav.zzd;
    }

    public static String[] zzan() {
        return zzav.zze;
    }

    public static String[] zzao() {
        return zzav.zzf;
    }

    public static String[] zzap() {
        return zzav.zzh;
    }

    public static String[] zzaq() {
        return zzav.zzi;
    }

    public static String[] zzar() {
        return zzav.zzj;
    }

    public static String[] zzas() {
        return zzav.zzk;
    }

    public static String[] zzat() {
        return zzav.zzl;
    }

    public final zzof zzau() {
        return this.zzn;
    }

    public final void zzav(String s, long v, long v1, zzpb zzpb0) {
        zzhr zzhr0;
        String[] arr_s2;
        String s4;
        zzid zzid0;
        String s3;
        String s2;
        SQLiteDatabase sQLiteDatabase0;
        String s1;
        Preconditions.checkNotNull(zzpb0);
        this.zzg();
        this.zzay();
        Cursor cursor0 = null;
        try {
            try {
                s1 = "";
                sQLiteDatabase0 = this.zze();
                if(TextUtils.isEmpty(s)) {
                    int v2 = Long.compare(v1, -1L);
                    String[] arr_s = v2 == 0 ? new String[]{String.valueOf(v)} : new String[]{String.valueOf(v1), String.valueOf(v)};
                    if(v2 != 0) {
                        s1 = "rowid <= ? and ";
                    }
                    cursor0 = sQLiteDatabase0.rawQuery("select app_id, metadata_fingerprint from raw_events where " + s1 + "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;", arr_s);
                    goto label_12;
                }
                else {
                    goto label_21;
                }
                goto label_77;
            }
            catch(SQLiteException sQLiteException0) {
                goto label_32;
            }
            try {
            label_12:
                if(cursor0.moveToFirst()) {
                    s2 = cursor0.getString(0);
                    goto label_18;
                }
                goto label_77;
            }
            catch(SQLiteException sQLiteException0) {
                s2 = s;
                goto label_72;
            }
            try {
            label_18:
                s3 = cursor0.getString(1);
                cursor0.close();
                goto label_34;
            }
            catch(SQLiteException sQLiteException0) {
                goto label_72;
            }
            try {
            label_21:
                int v3 = Long.compare(v1, -1L);
                String[] arr_s1 = v3 == 0 ? new String[]{s} : new String[]{s, String.valueOf(v1)};
                if(v3 != 0) {
                    s1 = " and rowid <= ?";
                }
                cursor0 = sQLiteDatabase0.rawQuery("select metadata_fingerprint from raw_events where app_id = ?" + s1 + " order by rowid limit 1;", arr_s1);
                if(cursor0.moveToFirst()) {
                    s3 = cursor0.getString(0);
                    cursor0.close();
                    s2 = s;
                    goto label_34;
                }
                goto label_77;
            }
            catch(SQLiteException sQLiteException0) {
            }
        }
        catch(Throwable throwable0) {
            goto label_75;
        }
    label_32:
        s2 = s;
        goto label_72;
        try {
        label_34:
            cursor0 = sQLiteDatabase0.query("raw_events_metadata", new String[]{"metadata"}, "app_id = ? and metadata_fingerprint = ?", new String[]{s2, s3}, null, null, "rowid", "2");
            if(cursor0.moveToFirst()) {
                byte[] arr_b = cursor0.getBlob(0);
                try {
                    zzid0 = (zzid)((zzic)zzpj.zzw(zzid.zzaE(), arr_b)).zzbc();
                }
                catch(IOException iOException0) {
                    this.zzu.zzaV().zzb().zzc("Data loss. Failed to merge raw event metadata. appId", zzgt.zzl(s2), iOException0);
                    goto label_77;
                }
                if(cursor0.moveToNext()) {
                    this.zzu.zzaV().zze().zzb("Get multiple raw event metadata records, expected one. appId", zzgt.zzl(s2));
                }
                cursor0.close();
                Preconditions.checkNotNull(zzid0);
                zzpb0.zza = zzid0;
                if(v1 == -1L) {
                    s4 = "app_id = ? and metadata_fingerprint = ?";
                    arr_s2 = new String[]{s2, s3};
                }
                else {
                    s4 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?";
                    arr_s2 = new String[]{s2, s3, String.valueOf(v1)};
                }
                cursor0 = sQLiteDatabase0.query("raw_events", new String[]{"rowid", "name", "timestamp", "data"}, s4, arr_s2, null, null, "rowid", null);
                if(cursor0.moveToFirst()) {
                    do {
                        long v4 = cursor0.getLong(0);
                        byte[] arr_b1 = cursor0.getBlob(3);
                        try {
                            zzhr0 = (zzhr)zzpj.zzw(zzhs.zzk(), arr_b1);
                        }
                        catch(IOException iOException1) {
                            this.zzu.zzaV().zzb().zzc("Data loss. Failed to merge raw event. appId", zzgt.zzl(s2), iOException1);
                            continue;
                        }
                        zzhr0.zzl(cursor0.getString(1));
                        zzhr0.zzo(cursor0.getLong(2));
                        if(!zzpb0.zza(v4, ((zzhs)zzhr0.zzbc()))) {
                            break;
                        }
                    }
                    while(cursor0.moveToNext());
                }
                else {
                    this.zzu.zzaV().zze().zzb("Raw event data disappeared while in transaction. appId", zzgt.zzl(s2));
                }
            }
            else {
                this.zzu.zzaV().zzb().zzb("Raw event metadata record is missing. appId", zzgt.zzl(s2));
            }
        }
        catch(SQLiteException sQLiteException0) {
            try {
            label_72:
                this.zzu.zzaV().zzb().zzc("Data loss. Error selecting raw event. appId", zzgt.zzl(s2), sQLiteException0);
                goto label_77;
            }
            catch(Throwable throwable0) {
            }
            goto label_75;
        }
        catch(Throwable throwable0) {
        label_75:
            TWR.safeClose$NT(cursor0, throwable0);
            throw throwable0;
        }
    label_77:
        if(cursor0 != null) {
            cursor0.close();
        }
    }

    public static final void zzaw(ContentValues contentValues0, String s, Object object0) {
        new String("value");
        Preconditions.checkNotNull(object0);
        if(object0 instanceof String) {
            contentValues0.put("value", ((String)object0));
            return;
        }
        if(object0 instanceof Long) {
            contentValues0.put("value", ((Long)object0));
            return;
        }
        if(!(object0 instanceof Double)) {
            throw new IllegalArgumentException("Invalid value type");
        }
        contentValues0.put("value", ((Double)object0));
    }

    public final void zzb() {
        this.zzay();
        this.zze().beginTransaction();
    }

    @Override  // com.google.android.gms.measurement.internal.zzor
    public final boolean zzbb() {
        return false;
    }

    public final void zzc() {
        this.zzay();
        this.zze().setTransactionSuccessful();
    }

    public final void zzd() {
        this.zzay();
        this.zze().endTransaction();
    }

    public final SQLiteDatabase zze() {
        this.zzg();
        try {
            return this.zzm.getWritableDatabase();
        }
        catch(SQLiteException sQLiteException0) {
            this.zzu.zzaV().zze().zzb("Error opening database", sQLiteException0);
            throw sQLiteException0;
        }
    }

    public final zzbc zzf(String s, String s1) {
        return this.zzaE("events", s, s1);
    }

    public final void zzh(zzbc zzbc0) {
        this.zzaF("events", zzbc0);
    }

    public final void zzi(String s) {
        Throwable throwable1;
        this.zzaG("events_snapshot", s);
        List list0 = Collections.singletonList("name");
        Cursor cursor0 = null;
        try {
            cursor0 = this.zze().query("events", ((String[])list0.toArray(new String[0])), "app_id=?", new String[]{s}, null, null, null);
            if(cursor0.moveToFirst()) {
                do {
                    String s1 = cursor0.getString(0);
                    if(s1 != null) {
                        zzbc zzbc0 = this.zzaE("events", s, s1);
                        if(zzbc0 != null) {
                            this.zzaF("events_snapshot", zzbc0);
                        }
                    }
                }
                while(cursor0.moveToNext());
            }
            goto label_21;
        }
        catch(SQLiteException sQLiteException0) {
            goto label_16;
        }
        catch(Throwable throwable0) {
        }
        try {
            try {
                throwable1 = throwable0;
                goto label_18;
            }
            catch(SQLiteException sQLiteException0) {
            }
        label_16:
            this.zzu.zzaV().zzb().zzc("Error creating snapshot. appId", zzgt.zzl(s), sQLiteException0);
            goto label_21;
        }
        catch(Throwable throwable0) {
            throwable1 = throwable0;
        }
    label_18:
        if(cursor0 != null) {
            cursor0.close();
        }
        throw throwable1;
    label_21:
        if(cursor0 != null) {
            cursor0.close();
        }
    }

    public final void zzj(String s) {
        boolean z;
        ArrayList arrayList0 = new ArrayList(Arrays.asList(new String[]{"name", "lifetime_count"}));
        zzbc zzbc0 = this.zzaE("events", s, "_f");
        zzbc zzbc1 = this.zzaE("events", s, "_v");
        this.zzaG("events", s);
        Cursor cursor0 = null;
        int v = 0;
        try {
            cursor0 = this.zze().query("events_snapshot", ((String[])arrayList0.toArray(new String[0])), "app_id=?", new String[]{s}, null, null, null);
            if(cursor0.moveToFirst()) {
                goto label_22;
            }
            else {
                goto label_15;
            }
            goto label_63;
        }
        catch(SQLiteException sQLiteException0) {
            z = false;
            goto label_41;
        }
        catch(Throwable throwable0) {
            z = false;
            goto label_47;
        }
    label_15:
        cursor0.close();
        if(zzbc0 != null) {
            this.zzaF("events", zzbc0);
            goto label_63;
        label_22:
            int v1 = 0;
            z = false;
            try {
                do {
                    String s1 = cursor0.getString(0);
                    if(cursor0.getLong(1) >= 1L) {
                        if("_f".equals(s1)) {
                            v1 = 1;
                        }
                        else if("_v".equals(s1)) {
                            z = true;
                        }
                    }
                    if(s1 != null) {
                        zzbc zzbc2 = this.zzaE("events_snapshot", s, s1);
                        if(zzbc2 != null) {
                            this.zzaF("events", zzbc2);
                        }
                    }
                }
                while(cursor0.moveToNext());
                goto label_56;
            }
            catch(SQLiteException sQLiteException0) {
                v = v1;
            }
            catch(Throwable throwable0) {
                goto label_46;
            }
            try {
            label_41:
                this.zzu.zzaV().zzb().zzc("Error querying snapshot. appId", zzgt.zzl(s), sQLiteException0);
                v1 = v;
                goto label_56;
            }
            catch(Throwable throwable0) {
                goto label_47;
            }
        label_46:
            v = v1;
        label_47:
            if(cursor0 != null) {
                cursor0.close();
            }
            if(v == 0 && zzbc0 != null) {
                this.zzaF("events", zzbc0);
            }
            else if(!z && zzbc1 != null) {
                this.zzaF("events", zzbc1);
            }
            this.zzaG("events_snapshot", s);
            throw throwable0;
        label_56:
            if(cursor0 != null) {
                cursor0.close();
            }
            if(v1 == 0 && zzbc0 != null) {
                this.zzaF("events", zzbc0);
            }
            else if(!z && zzbc1 != null) {
                this.zzaF("events", zzbc1);
            }
        }
        else if(zzbc1 != null) {
            this.zzaF("events", zzbc1);
        }
    label_63:
        this.zzaG("events_snapshot", s);
    }

    public final void zzk(String s, String s1) {
        Preconditions.checkNotEmpty(s);
        Preconditions.checkNotEmpty(s1);
        this.zzg();
        this.zzay();
        try {
            this.zze().delete("user_attributes", "app_id=? and name=?", new String[]{s, s1});
        }
        catch(SQLiteException sQLiteException0) {
            this.zzu.zzaV().zzb().zzd("Error deleting user property. appId", zzgt.zzl(s), this.zzu.zzl().zzc(s1), sQLiteException0);
        }
    }

    public final boolean zzl(zzpm zzpm0) {
        Preconditions.checkNotNull(zzpm0);
        this.zzg();
        this.zzay();
        String s = zzpm0.zza;
        String s1 = zzpm0.zzc;
        if(this.zzm(s, s1) == null) {
            if(zzpo.zzh(s1)) {
                if(this.zzaA("select count(1) from user_attributes where app_id=? and name not like \'!_%\' escape \'!\'", new String[]{s}) >= ((long)this.zzu.zzc().zzn(s, zzfx.zzV, 25, 100))) {
                    return false;
                }
            }
            else if(!"_npa".equals(s1) && this.zzaA("select count(1) from user_attributes where app_id=? and origin=? AND name like \'!_%\' escape \'!\'", new String[]{s, zzpm0.zzb}) >= 25L) {
                return false;
            }
        }
        ContentValues contentValues0 = new ContentValues();
        contentValues0.put("app_id", s);
        contentValues0.put("origin", zzpm0.zzb);
        contentValues0.put("name", s1);
        contentValues0.put("set_timestamp", zzpm0.zzd);
        zzav.zzaw(contentValues0, "value", zzpm0.zze);
        try {
            if(this.zze().insertWithOnConflict("user_attributes", null, contentValues0, 5) == -1L) {
                this.zzu.zzaV().zzb().zzb("Failed to insert/update user property (got -1). appId", zzgt.zzl(s));
                return true;
            }
        }
        catch(SQLiteException sQLiteException0) {
            this.zzu.zzaV().zzb().zzc("Error storing user property. appId", zzgt.zzl(zzpm0.zza), sQLiteException0);
        }
        return true;
    }

    public final zzpm zzm(String s, String s1) {
        zzpm zzpm0;
        Throwable throwable1;
        SQLiteException sQLiteException1;
        Cursor cursor1;
        Preconditions.checkNotEmpty(s);
        Preconditions.checkNotEmpty(s1);
        this.zzg();
        this.zzay();
        Cursor cursor0 = null;
        try {
            cursor1 = this.zze().query("user_attributes", new String[]{"set_timestamp", "value", "origin"}, "app_id=? and name=?", new String[]{s, s1}, null, null, null);
        }
        catch(SQLiteException sQLiteException0) {
            sQLiteException1 = sQLiteException0;
            cursor1 = null;
            goto label_24;
        }
        catch(Throwable throwable0) {
            throwable1 = throwable0;
            goto label_29;
        }
        try {
            try {
                if(cursor1.moveToFirst()) {
                    long v = cursor1.getLong(0);
                    Object object0 = this.zzL(cursor1, 1);
                    if(object0 != null) {
                        zzpm0 = new zzpm(s, cursor1.getString(2), s1, v, object0);
                        if(cursor1.moveToNext()) {
                            this.zzu.zzaV().zzb().zzb("Got multiple records for user property, expected one. appId", zzgt.zzl(s));
                        }
                        goto label_32;
                    }
                }
                goto label_34;
            }
            catch(SQLiteException sQLiteException2) {
                sQLiteException1 = sQLiteException2;
            }
        label_24:
            this.zzu.zzaV().zzb().zzd("Error querying user property. appId", zzgt.zzl(s), this.zzu.zzl().zzc(s1), sQLiteException1);
            goto label_34;
        }
        catch(Throwable throwable2) {
            throwable1 = throwable2;
            cursor0 = cursor1;
        }
    label_29:
        if(cursor0 != null) {
            cursor0.close();
        }
        throw throwable1;
    label_32:
        cursor1.close();
        return zzpm0;
    label_34:
        if(cursor1 != null) {
            cursor1.close();
        }
        return null;
    }

    public final List zzn(String s) {
        Throwable throwable1;
        Preconditions.checkNotEmpty(s);
        this.zzg();
        this.zzay();
        List list0 = new ArrayList();
        Cursor cursor0 = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabase0 = this.zze();
                com.google.android.gms.measurement.internal.zzib zzib0 = this.zzu;
                cursor0 = sQLiteDatabase0.query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{s}, null, null, "rowid", "1000");
                if(cursor0.moveToFirst()) {
                    while(true) {
                        String s1 = cursor0.getString(0);
                        String s2 = cursor0.getString(1);
                        if(s2 == null) {
                            s2 = "";
                        }
                        long v = cursor0.getLong(2);
                        Object object0 = this.zzL(cursor0, 3);
                        if(object0 == null) {
                            zzib0.zzaV().zzb().zzb("Read invalid user property value, ignoring it. appId", zzgt.zzl(s));
                        }
                        else {
                            ((ArrayList)list0).add(new zzpm(s, s2, s1, v, object0));
                        }
                        if(!cursor0.moveToNext()) {
                            break;
                        }
                    }
                }
            }
            catch(SQLiteException sQLiteException0) {
                this.zzu.zzaV().zzb().zzc("Error querying user properties. appId", zzgt.zzl(s), sQLiteException0);
                list0 = Collections.EMPTY_LIST;
            }
            goto label_31;
        }
        catch(Throwable throwable0) {
            throwable1 = throwable0;
        }
        if(cursor0 != null) {
            cursor0.close();
        }
        throw throwable1;
    label_31:
        if(cursor0 != null) {
            cursor0.close();
        }
        return list0;
    }

    public final List zzo(String s, String s1, String s2) {
        String s6;
        String s5;
        Object object0;
        long v;
        String s4;
        Cursor cursor0;
        com.google.android.gms.measurement.internal.zzib zzib0;
        StringBuilder stringBuilder0;
        ArrayList arrayList0;
        Preconditions.checkNotEmpty(s);
        this.zzg();
        this.zzay();
        List list0 = new ArrayList();
        try {
            arrayList0 = new ArrayList(3);
            arrayList0.add(s);
            stringBuilder0 = new StringBuilder("app_id=?");
            if(TextUtils.isEmpty(s1)) {
                goto label_16;
            }
            else {
                goto label_12;
            }
            goto label_17;
        }
        catch(SQLiteException sQLiteException0) {
        }
        catch(Throwable throwable0) {
            goto label_26;
        }
        String s3 = s1;
        goto label_28;
        try {
        label_12:
            s3 = s1;
            arrayList0.add(s3);
            stringBuilder0.append(" and origin=?");
            goto label_17;
        label_16:
            s3 = s1;
        label_17:
            if(!TextUtils.isEmpty(s2)) {
                arrayList0.add(s2 + "*");
                stringBuilder0.append(" and name glob ?");
            }
            String[] arr_s = (String[])arrayList0.toArray(new String[arrayList0.size()]);
            SQLiteDatabase sQLiteDatabase0 = this.zze();
            zzib0 = this.zzu;
            cursor0 = sQLiteDatabase0.query("user_attributes", new String[]{"name", "set_timestamp", "value", "origin"}, stringBuilder0.toString(), arr_s, null, null, "rowid", "1001");
            goto label_32;
        label_26:
            goto label_30;
        }
        catch(SQLiteException sQLiteException0) {
        }
        catch(Throwable throwable0) {
            goto label_26;
        }
    label_28:
        Cursor cursor1 = null;
        goto label_61;
    label_30:
        cursor1 = null;
        goto label_69;
        try {
            try {
            label_32:
                if(cursor0.moveToFirst()) {
                    while(true) {
                    label_33:
                        if(((ArrayList)list0).size() >= 1000) {
                            zzib0.zzaV().zzb().zzb("Read more than the max allowed user properties, ignoring excess", 1000);
                            break;
                        }
                        s4 = cursor0.getString(0);
                        v = cursor0.getLong(1);
                        object0 = this.zzL(cursor0, 2);
                        s5 = cursor0.getString(3);
                        if(object0 == null) {
                            goto label_41;
                        }
                        else {
                            goto label_47;
                        }
                        goto label_49;
                    }
                }
                goto label_72;
            }
            catch(SQLiteException sQLiteException0) {
                goto label_60;
            }
            try {
            label_41:
                zzib0.zzaV().zzb().zzd("(2)Read invalid user property value, ignoring it", zzgt.zzl(s), s5, s2);
                s6 = s5;
                goto label_49;
            label_45:
                s6 = s5;
                goto label_52;
            }
            catch(SQLiteException sQLiteException0) {
                goto label_45;
            }
            try {
            label_47:
                s6 = s5;
                ((ArrayList)list0).add(new zzpm(s, s6, s4, v, object0));
            label_49:
                if(!cursor0.moveToNext()) {
                    goto label_72;
                }
                goto label_55;
            }
            catch(SQLiteException sQLiteException0) {
            }
        label_52:
            cursor1 = cursor0;
            s3 = s6;
            goto label_61;
            try {
            label_55:
                s3 = s6;
                goto label_33;
            label_58:
                goto label_68;
            }
            catch(SQLiteException sQLiteException0) {
            }
            catch(Throwable throwable0) {
                goto label_58;
            }
        }
        catch(Throwable throwable0) {
            goto label_58;
        }
    label_60:
        cursor1 = cursor0;
        try {
        label_61:
            this.zzu.zzaV().zzb().zzd("(2)Error querying user properties", zzgt.zzl(s), s3, sQLiteException0);
            list0 = Collections.EMPTY_LIST;
            cursor0 = cursor1;
            goto label_72;
        }
        catch(Throwable throwable0) {
            TWR.safeClose$NT(cursor1, throwable0);
            throw throwable0;
        }
    label_68:
        cursor1 = cursor0;
    label_69:
        if(cursor1 != null) {
            cursor1.close();
        }
        throw throwable0;
    label_72:
        if(cursor0 != null) {
            cursor0.close();
        }
        return list0;
    }

    public final boolean zzp(zzah zzah0) {
        Preconditions.checkNotNull(zzah0);
        this.zzg();
        this.zzay();
        String s = zzah0.zza;
        Preconditions.checkNotNull(s);
        if(this.zzm(s, zzah0.zzc.zzb) == null && this.zzaA("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{s}) >= 1000L) {
            return false;
        }
        ContentValues contentValues0 = new ContentValues();
        contentValues0.put("app_id", s);
        contentValues0.put("origin", zzah0.zzb);
        contentValues0.put("name", zzah0.zzc.zzb);
        zzav.zzaw(contentValues0, "value", Preconditions.checkNotNull(zzah0.zzc.zza()));
        contentValues0.put("active", Boolean.valueOf(zzah0.zze));
        contentValues0.put("trigger_event_name", zzah0.zzf);
        contentValues0.put("trigger_timeout", zzah0.zzh);
        com.google.android.gms.measurement.internal.zzib zzib0 = this.zzu;
        contentValues0.put("timed_out_event", zzib0.zzk().zzae(zzah0.zzg));
        contentValues0.put("creation_timestamp", zzah0.zzd);
        contentValues0.put("triggered_event", zzib0.zzk().zzae(zzah0.zzi));
        contentValues0.put("triggered_timestamp", zzah0.zzc.zzc);
        contentValues0.put("time_to_live", zzah0.zzj);
        contentValues0.put("expired_event", zzib0.zzk().zzae(zzah0.zzk));
        try {
            if(this.zze().insertWithOnConflict("conditional_properties", null, contentValues0, 5) == -1L) {
                zzib0.zzaV().zzb().zzb("Failed to insert/update conditional user property (got -1)", zzgt.zzl(s));
                return true;
            }
        }
        catch(SQLiteException sQLiteException0) {
            this.zzu.zzaV().zzb().zzc("Error storing conditional user property", zzgt.zzl(s), sQLiteException0);
        }
        return true;
    }

    public final zzah zzq(String s, String s1) {
        zzah zzah0;
        Cursor cursor0;
        Preconditions.checkNotEmpty(s);
        Preconditions.checkNotEmpty(s1);
        this.zzg();
        this.zzay();
        try {
            cursor0 = null;
            cursor0 = this.zze().query("conditional_properties", new String[]{"origin", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, "app_id=? and name=?", new String[]{s, s1}, null, null, null);
            goto label_10;
        }
        catch(SQLiteException sQLiteException0) {
            goto label_29;
        }
        catch(Throwable throwable0) {
        }
        TWR.safeClose$NT(null, throwable0);
        throw throwable0;
        try {
            try {
            label_10:
                if(cursor0.moveToFirst()) {
                    String s2 = cursor0.getString(0);
                    if(s2 == null) {
                        s2 = "";
                    }
                    Object object0 = this.zzL(cursor0, 1);
                    boolean z = cursor0.getInt(2) != 0;
                    String s3 = cursor0.getString(3);
                    long v = cursor0.getLong(4);
                    zzbg zzbg0 = (zzbg)this.zzg.zzp().zzl(cursor0.getBlob(5), zzbg.CREATOR);
                    long v1 = cursor0.getLong(6);
                    zzbg zzbg1 = (zzbg)this.zzg.zzp().zzl(cursor0.getBlob(7), zzbg.CREATOR);
                    long v2 = cursor0.getLong(8);
                    long v3 = cursor0.getLong(9);
                    zzbg zzbg2 = (zzbg)this.zzg.zzp().zzl(cursor0.getBlob(10), zzbg.CREATOR);
                    zzah0 = new zzah(s, s2, new zzpk(s1, v2, object0, s2), v1, z, s3, zzbg0, v, zzbg1, v3, zzbg2);
                    if(cursor0.moveToNext()) {
                        this.zzu.zzaV().zzb().zzc("Got multiple records for conditional property, expected one", zzgt.zzl(s), this.zzu.zzl().zzc(s1));
                    }
                    goto label_34;
                }
            }
            catch(SQLiteException sQLiteException0) {
            label_29:
                this.zzu.zzaV().zzb().zzd("Error querying conditional property", zzgt.zzl(s), this.zzu.zzl().zzc(s1), sQLiteException0);
            }
            goto label_36;
        }
        catch(Throwable throwable0) {
            TWR.safeClose$NT(cursor0, throwable0);
            throw throwable0;
        }
    label_34:
        cursor0.close();
        return zzah0;
    label_36:
        if(cursor0 != null) {
            cursor0.close();
        }
        return null;
    }

    public final int zzr(String s, String s1) {
        Preconditions.checkNotEmpty(s);
        Preconditions.checkNotEmpty(s1);
        this.zzg();
        this.zzay();
        try {
            return this.zze().delete("conditional_properties", "app_id=? and name=?", new String[]{s, s1});
        }
        catch(SQLiteException sQLiteException0) {
            this.zzu.zzaV().zzb().zzd("Error deleting conditional property", zzgt.zzl(s), this.zzu.zzl().zzc(s1), sQLiteException0);
            return 0;
        }
    }

    public final List zzs(String s, String s1, String s2) {
        Preconditions.checkNotEmpty(s);
        this.zzg();
        this.zzay();
        ArrayList arrayList0 = new ArrayList(3);
        arrayList0.add(s);
        StringBuilder stringBuilder0 = new StringBuilder("app_id=?");
        if(!TextUtils.isEmpty(s1)) {
            arrayList0.add(s1);
            stringBuilder0.append(" and origin=?");
        }
        if(!TextUtils.isEmpty(s2)) {
            arrayList0.add(s2 + "*");
            stringBuilder0.append(" and name glob ?");
        }
        return this.zzt(stringBuilder0.toString(), ((String[])arrayList0.toArray(new String[arrayList0.size()])));
    }

    public final List zzt(String s, String[] arr_s) {
        this.zzg();
        this.zzay();
        List list0 = new ArrayList();
        Cursor cursor0 = null;
        try {
            SQLiteDatabase sQLiteDatabase0 = this.zze();
            com.google.android.gms.measurement.internal.zzib zzib0 = this.zzu;
            cursor0 = sQLiteDatabase0.query("conditional_properties", new String[]{"app_id", "origin", "name", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, s, arr_s, null, null, "rowid", "1001");
            if(cursor0.moveToFirst()) {
                while(true) {
                label_8:
                    if(((ArrayList)list0).size() >= 1000) {
                        zzib0.zzaV().zzb().zzb("Read more than the max allowed conditional properties, ignoring extra", 1000);
                        break;
                    }
                    String s1 = cursor0.getString(0);
                    String s2 = cursor0.getString(1);
                    String s3 = cursor0.getString(2);
                    Object object0 = this.zzL(cursor0, 3);
                    boolean z = cursor0.getInt(4) != 0;
                    String s4 = cursor0.getString(5);
                    long v = cursor0.getLong(6);
                    Parcelable parcelable0 = this.zzg.zzp().zzl(cursor0.getBlob(7), zzbg.CREATOR);
                    long v1 = cursor0.getLong(8);
                    Parcelable parcelable1 = this.zzg.zzp().zzl(cursor0.getBlob(9), zzbg.CREATOR);
                    long v2 = cursor0.getLong(10);
                    long v3 = cursor0.getLong(11);
                    Parcelable parcelable2 = this.zzg.zzp().zzl(cursor0.getBlob(12), zzbg.CREATOR);
                    ((ArrayList)list0).add(new zzah(s1, s2, new zzpk(s3, v2, object0, s2), v1, z, s4, ((zzbg)parcelable0), v, ((zzbg)parcelable1), v3, ((zzbg)parcelable2)));
                    if(!cursor0.moveToNext()) {
                        break;
                    }
                }
            }
            goto label_35;
        }
        catch(SQLiteException sQLiteException0) {
            try {
                try {
                }
                catch(SQLiteException sQLiteException0) {
                }
                this.zzu.zzaV().zzb().zzb("Error querying conditional user property value", sQLiteException0);
                list0 = Collections.EMPTY_LIST;
                goto label_35;
            }
            catch(Throwable throwable0) {
            }
            goto label_32;
        }
        catch(Throwable throwable0) {
        label_32:
            TWR.safeClose$NT(cursor0, throwable0);
            throw throwable0;
        }
        goto label_8;
    label_35:
        if(cursor0 != null) {
            cursor0.close();
        }
        return list0;
    }

    public final zzh zzu(String s) {
        Boolean boolean0;
        zzh zzh0;
        Cursor cursor0;
        Preconditions.checkNotEmpty(s);
        this.zzg();
        this.zzay();
        try {
            cursor0 = null;
            cursor0 = this.zze().query("apps", new String[]{"app_instance_id", "gmp_app_id", "resettable_device_id_hash", "last_bundle_index", "last_bundle_start_timestamp", "last_bundle_end_timestamp", "app_version", "app_store", "gmp_version", "dev_cert_hash", "measurement_enabled", "day", "daily_public_events_count", "daily_events_count", "daily_conversions_count", "config_fetched_time", "failed_config_fetch_time", "app_version_int", "firebase_instance_id", "daily_error_events_count", "daily_realtime_events_count", "health_monitor_sample", "android_id", "adid_reporting_enabled", "admob_app_id", "dynamite_version", "safelisted_events", "ga_app_id", "session_stitching_token", "sgtm_upload_enabled", "target_os_version", "session_stitching_token_hash", "ad_services_version", "unmatched_first_open_without_ad_id", "npa_metadata_value", "attribution_eligibility_status", "sgtm_preview_key", "dma_consent_state", "daily_realtime_dcu_count", "bundle_delivery_index", "serialized_npa_metadata", "unmatched_pfo", "unmatched_uwa", "ad_campaign_info", "client_upload_eligibility"}, "app_id=?", new String[]{s}, null, null, null);
            goto label_9;
        }
        catch(SQLiteException sQLiteException0) {
            goto label_78;
        }
        catch(Throwable throwable0) {
        }
        TWR.safeClose$NT(null, throwable0);
        throw throwable0;
        try {
            try {
            label_9:
                if(cursor0.moveToFirst()) {
                    zzpf zzpf0 = this.zzg;
                    zzh0 = new zzh(zzpf0.zzaf(), s);
                    zzjk zzjk0 = zzpf0.zzB(s);
                    zzjj zzjj0 = zzjj.zzb;
                    boolean z = false;
                    if(zzjk0.zzo(zzjj0)) {
                        zzh0.zze(cursor0.getString(0));
                    }
                    zzh0.zzg(cursor0.getString(1));
                    if(zzpf0.zzB(s).zzo(zzjj.zza)) {
                        zzh0.zzk(cursor0.getString(2));
                    }
                    zzh0.zzF(cursor0.getLong(3));
                    zzh0.zzo(cursor0.getLong(4));
                    zzh0.zzq(cursor0.getLong(5));
                    zzh0.zzs(cursor0.getString(6));
                    zzh0.zzw(cursor0.getString(7));
                    zzh0.zzy(cursor0.getLong(8));
                    zzh0.zzA(cursor0.getLong(9));
                    zzh0.zzE(cursor0.isNull(10) || cursor0.getInt(10) != 0);
                    zzh0.zzO(cursor0.getLong(11));
                    zzh0.zzQ(cursor0.getLong(12));
                    zzh0.zzS(cursor0.getLong(13));
                    zzh0.zzU(cursor0.getLong(14));
                    zzh0.zzI(cursor0.getLong(15));
                    zzh0.zzK(cursor0.getLong(16));
                    zzh0.zzu((cursor0.isNull(17) ? 0xFFFFFFFF80000000L : ((long)cursor0.getInt(17))));
                    zzh0.zzm(cursor0.getString(18));
                    zzh0.zzY(cursor0.getLong(19));
                    zzh0.zzW(cursor0.getLong(20));
                    zzh0.zzab(cursor0.getString(21));
                    zzh0.zzad(cursor0.isNull(23) || cursor0.getInt(23) != 0);
                    zzh0.zzC((cursor0.isNull(25) ? 0L : cursor0.getLong(25)));
                    if(!cursor0.isNull(26)) {
                        zzh0.zzah(Arrays.asList(cursor0.getString(26).split(",", -1)));
                    }
                    if(zzpf0.zzB(s).zzo(zzjj0)) {
                        zzh0.zzi(cursor0.getString(28));
                    }
                    zzh0.zzaj(!cursor0.isNull(29) && cursor0.getInt(29) != 0);
                    zzh0.zzaE(cursor0.getLong(39));
                    zzh0.zzaz(cursor0.getString(36));
                    zzh0.zzal(cursor0.getLong(30));
                    zzh0.zzan(cursor0.getLong(0x1F));
                    zzql.zza();
                    com.google.android.gms.measurement.internal.zzib zzib0 = this.zzu;
                    if(zzib0.zzc().zzp(s, zzfx.zzaP)) {
                        zzh0.zzap(cursor0.getInt(0x20));
                        zzh0.zzax(cursor0.getLong(35));
                    }
                    zzh0.zzar(!cursor0.isNull(33) && cursor0.getInt(33) != 0);
                    if(cursor0.isNull(34)) {
                        boolean0 = null;
                    }
                    else {
                        if(cursor0.getInt(34) != 0) {
                            z = true;
                        }
                        boolean0 = Boolean.valueOf(z);
                    }
                    zzh0.zzaf(boolean0);
                    zzh0.zzaB(cursor0.getInt(37));
                    zzh0.zzaD(cursor0.getInt(38));
                    zzh0.zzaG((cursor0.isNull(40) ? "" : ((String)Preconditions.checkNotNull(cursor0.getString(40)))));
                    if(!cursor0.isNull(41)) {
                        zzh0.zzat(cursor0.getLong(41));
                    }
                    if(!cursor0.isNull(42)) {
                        zzh0.zzav(cursor0.getLong(42));
                    }
                    zzh0.zzaI(cursor0.getBlob(43));
                    if(!cursor0.isNull(44)) {
                        zzh0.zzaK(cursor0.getInt(44));
                    }
                    zzh0.zzb();
                    if(cursor0.moveToNext()) {
                        zzib0.zzaV().zzb().zzb("Got multiple records for app, expected one. appId", zzgt.zzl(s));
                    }
                    goto label_83;
                }
            }
            catch(SQLiteException sQLiteException0) {
            label_78:
                this.zzu.zzaV().zzb().zzc("Error querying app. appId", zzgt.zzl(s), sQLiteException0);
            }
            goto label_85;
        }
        catch(Throwable throwable0) {
            TWR.safeClose$NT(cursor0, throwable0);
            throw throwable0;
        }
    label_83:
        cursor0.close();
        return zzh0;
    label_85:
        if(cursor0 != null) {
            cursor0.close();
        }
        return null;
    }

    public final void zzv(zzh zzh0, boolean z, boolean z1) {
        Preconditions.checkNotNull(zzh0);
        this.zzg();
        this.zzay();
        String s = zzh0.zzc();
        Preconditions.checkNotNull(s);
        ContentValues contentValues0 = new ContentValues();
        contentValues0.put("app_id", s);
        if(z) {
            contentValues0.put("app_instance_id", null);
        }
        else if(this.zzg.zzB(s).zzo(zzjj.zzb)) {
            contentValues0.put("app_instance_id", zzh0.zzd());
        }
        contentValues0.put("gmp_app_id", zzh0.zzf());
        zzpf zzpf0 = this.zzg;
        if(zzpf0.zzB(s).zzo(zzjj.zza)) {
            contentValues0.put("resettable_device_id_hash", zzh0.zzj());
        }
        contentValues0.put("last_bundle_index", zzh0.zzG());
        contentValues0.put("last_bundle_start_timestamp", zzh0.zzn());
        contentValues0.put("last_bundle_end_timestamp", zzh0.zzp());
        contentValues0.put("app_version", zzh0.zzr());
        contentValues0.put("app_store", zzh0.zzv());
        contentValues0.put("gmp_version", zzh0.zzx());
        contentValues0.put("dev_cert_hash", zzh0.zzz());
        contentValues0.put("measurement_enabled", Boolean.valueOf(zzh0.zzD()));
        contentValues0.put("day", zzh0.zzN());
        contentValues0.put("daily_public_events_count", zzh0.zzP());
        contentValues0.put("daily_events_count", zzh0.zzR());
        contentValues0.put("daily_conversions_count", zzh0.zzT());
        contentValues0.put("config_fetched_time", zzh0.zzH());
        contentValues0.put("failed_config_fetch_time", zzh0.zzJ());
        contentValues0.put("app_version_int", zzh0.zzt());
        contentValues0.put("firebase_instance_id", zzh0.zzl());
        contentValues0.put("daily_error_events_count", zzh0.zzX());
        contentValues0.put("daily_realtime_events_count", zzh0.zzV());
        contentValues0.put("health_monitor_sample", zzh0.zzZ());
        contentValues0.put("android_id", 0L);
        contentValues0.put("adid_reporting_enabled", Boolean.valueOf(zzh0.zzac()));
        contentValues0.put("dynamite_version", zzh0.zzB());
        if(zzpf0.zzB(s).zzo(zzjj.zzb)) {
            contentValues0.put("session_stitching_token", zzh0.zzh());
        }
        contentValues0.put("sgtm_upload_enabled", Boolean.valueOf(zzh0.zzai()));
        contentValues0.put("target_os_version", zzh0.zzak());
        contentValues0.put("session_stitching_token_hash", zzh0.zzam());
        zzql.zza();
        com.google.android.gms.measurement.internal.zzib zzib0 = this.zzu;
        if(zzib0.zzc().zzp(s, zzfx.zzaP)) {
            contentValues0.put("ad_services_version", zzh0.zzao());
            contentValues0.put("attribution_eligibility_status", zzh0.zzaw());
        }
        contentValues0.put("unmatched_first_open_without_ad_id", Boolean.valueOf(zzh0.zzaq()));
        contentValues0.put("npa_metadata_value", zzh0.zzae());
        contentValues0.put("bundle_delivery_index", zzh0.zzaF());
        contentValues0.put("sgtm_preview_key", zzh0.zzay());
        contentValues0.put("dma_consent_state", zzh0.zzaA());
        contentValues0.put("daily_realtime_dcu_count", zzh0.zzaC());
        contentValues0.put("serialized_npa_metadata", zzh0.zzaH());
        contentValues0.put("client_upload_eligibility", zzh0.zzaL());
        List list0 = zzh0.zzag();
        if(list0 != null) {
            if(list0.isEmpty()) {
                zzib0.zzaV().zze().zzb("Safelisted events should not be an empty list. appId", s);
            }
            else {
                contentValues0.put("safelisted_events", TextUtils.join(",", list0));
            }
        }
        zzpn.zza();
        if(zzib0.zzc().zzp(null, zzfx.zzaK) && !contentValues0.containsKey("safelisted_events")) {
            contentValues0.put("safelisted_events", null);
        }
        contentValues0.put("unmatched_pfo", zzh0.zzas());
        contentValues0.put("unmatched_uwa", zzh0.zzau());
        contentValues0.put("ad_campaign_info", zzh0.zzaJ());
        try {
            SQLiteDatabase sQLiteDatabase0 = this.zze();
            if(((long)sQLiteDatabase0.update("apps", contentValues0, "app_id = ?", new String[]{s})) == 0L && sQLiteDatabase0.insertWithOnConflict("apps", null, contentValues0, 5) == -1L) {
                zzib0.zzaV().zzb().zzb("Failed to insert/update app (got -1). appId", zzgt.zzl(s));
            }
        }
        catch(SQLiteException sQLiteException0) {
            this.zzu.zzaV().zzb().zzc("Error storing app. appId", zzgt.zzl(s), sQLiteException0);
        }
    }

    public final zzar zzw(long v, String s, boolean z, boolean z1, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        return this.zzx(v, s, 1L, false, false, z2, false, z4, z5, z6);
    }

    public final zzar zzx(long v, String s, long v1, boolean z, boolean z1, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        SQLiteException sQLiteException1;
        Throwable throwable1;
        Preconditions.checkNotEmpty(s);
        this.zzg();
        this.zzay();
        String[] arr_s = {s};
        zzar zzar0 = new zzar();
        Cursor cursor0 = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabase0 = this.zze();
                cursor0 = sQLiteDatabase0.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count", "daily_realtime_dcu_count", "daily_registered_triggers_count"}, "app_id=?", new String[]{s}, null, null, null);
                if(cursor0.moveToFirst()) {
                    if(cursor0.getLong(0) == v) {
                        zzar0.zzb = cursor0.getLong(1);
                        zzar0.zza = cursor0.getLong(2);
                        zzar0.zzc = cursor0.getLong(3);
                        zzar0.zzd = cursor0.getLong(4);
                        zzar0.zze = cursor0.getLong(5);
                        zzar0.zzf = cursor0.getLong(6);
                        zzar0.zzg = cursor0.getLong(7);
                    }
                    if(z) {
                        zzar0.zzb += v1;
                    }
                    if(z1) {
                        zzar0.zza += v1;
                    }
                    if(z2) {
                        zzar0.zzc += v1;
                    }
                    if(z3) {
                        zzar0.zzd += v1;
                    }
                    if(z4) {
                        zzar0.zze += v1;
                    }
                    if(z5) {
                        zzar0.zzf += v1;
                    }
                    if(z6) {
                        zzar0.zzg += v1;
                    }
                    ContentValues contentValues0 = new ContentValues();
                    contentValues0.put("day", v);
                    contentValues0.put("daily_public_events_count", zzar0.zza);
                    contentValues0.put("daily_events_count", zzar0.zzb);
                    contentValues0.put("daily_conversions_count", zzar0.zzc);
                    contentValues0.put("daily_error_events_count", zzar0.zzd);
                    contentValues0.put("daily_realtime_events_count", zzar0.zze);
                    contentValues0.put("daily_realtime_dcu_count", zzar0.zzf);
                    contentValues0.put("daily_registered_triggers_count", zzar0.zzg);
                    sQLiteDatabase0.update("apps", contentValues0, "app_id=?", arr_s);
                }
                else {
                    this.zzu.zzaV().zze().zzb("Not updating daily counts, app is not known. appId", zzgt.zzl(s));
                }
                goto label_54;
            }
            catch(SQLiteException sQLiteException0) {
                sQLiteException1 = sQLiteException0;
            }
            this.zzu.zzaV().zzb().zzc("Error updating daily counts. appId", zzgt.zzl(s), sQLiteException1);
            goto label_54;
        }
        catch(Throwable throwable0) {
            throwable1 = throwable0;
        }
        if(cursor0 != null) {
            cursor0.close();
        }
        throw throwable1;
    label_54:
        if(cursor0 != null) {
            cursor0.close();
        }
        return zzar0;
    }

    public final zzaq zzy(String s) {
        zzaq zzaq0;
        String s2;
        String s1;
        byte[] arr_b;
        Cursor cursor1;
        Preconditions.checkNotEmpty(s);
        this.zzg();
        this.zzay();
        Cursor cursor0 = null;
        try {
            cursor1 = null;
            cursor1 = this.zze().query("apps", new String[]{"remote_config", "config_last_modified_time", "e_tag"}, "app_id=?", new String[]{s}, null, null, null);
            goto label_10;
        }
        catch(SQLiteException sQLiteException0) {
            goto label_23;
        }
        catch(Throwable throwable0) {
        }
        Throwable throwable1 = throwable0;
        goto label_26;
        try {
        label_10:
            if(cursor1.moveToFirst()) {
                arr_b = cursor1.getBlob(0);
                s1 = cursor1.getString(1);
                s2 = cursor1.getString(2);
                if(cursor1.moveToNext()) {
                    this.zzu.zzaV().zzb().zzb("Got multiple records for app config, expected one. appId", zzgt.zzl(s));
                }
                goto label_16;
            }
            goto label_31;
        }
        catch(SQLiteException sQLiteException0) {
            goto label_23;
        }
        catch(Throwable throwable2) {
            goto label_20;
        }
    label_16:
        if(arr_b != null) {
            try {
                try {
                    zzaq0 = new zzaq(arr_b, s1, s2);
                    goto label_29;
                label_20:
                    throwable1 = throwable2;
                }
                catch(SQLiteException sQLiteException0) {
                label_23:
                    this.zzu.zzaV().zzb().zzc("Error querying remote config. appId", zzgt.zzl(s), sQLiteException0);
                    goto label_31;
                }
            }
            catch(Throwable throwable2) {
                goto label_20;
            }
            cursor0 = cursor1;
        label_26:
            if(cursor0 != null) {
                cursor0.close();
            }
            throw throwable1;
        label_29:
            cursor1.close();
            return zzaq0;
        }
    label_31:
        if(cursor1 != null) {
            cursor1.close();
        }
        return null;
    }

    public final boolean zzz(zzid zzid0, boolean z) {
        byte[] arr_b1;
        this.zzg();
        this.zzay();
        Preconditions.checkNotNull(zzid0);
        Preconditions.checkNotEmpty("");
        Preconditions.checkState(zzid0.zzn());
        this.zzI();
        com.google.android.gms.measurement.internal.zzib zzib0 = this.zzu;
        long v = zzib0.zzaZ().currentTimeMillis();
        if(zzid0.zzo() < v - zzal.zzI() || zzid0.zzo() > zzal.zzI() + v) {
            zzib0.zzaV().zze().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzgt.zzl(""), v, zzid0.zzo());
        }
        byte[] arr_b = zzid0.zzcc();
        try {
            arr_b1 = this.zzg.zzp().zzv(arr_b);
        }
        catch(IOException iOException0) {
            this.zzu.zzaV().zzb().zzc("Data loss. Failed to serialize bundle. appId", zzgt.zzl(""), iOException0);
            return false;
        }
        com.google.android.gms.measurement.internal.zzib zzib1 = this.zzu;
        zzib1.zzaV().zzk().zzb("Saving bundle, size", ((int)arr_b1.length));
        ContentValues contentValues0 = new ContentValues();
        contentValues0.put("app_id", "");
        contentValues0.put("bundle_end_timestamp", zzid0.zzo());
        contentValues0.put("data", arr_b1);
        contentValues0.put("has_realtime", ((int)z));
        if(zzid0.zzaa()) {
            contentValues0.put("retry_count", zzid0.zzab());
        }
        try {
            if(this.zze().insert("queue", null, contentValues0) == -1L) {
                zzib1.zzaV().zzb().zzb("Failed to insert bundle (got -1). appId", zzgt.zzl(""));
                return false;
            }
            return true;
        }
        catch(SQLiteException sQLiteException0) {
            this.zzu.zzaV().zzb().zzc("Error storing bundle. appId", zzgt.zzl(""), sQLiteException0);
            return false;
        }
    }
}

