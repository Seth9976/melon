package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException;
import java.util.ArrayList;
import java.util.List;
import jeb.synthetic.TWR;

public final class zzgk extends zzg {
    private static final String[] zza;
    private final zzgi zzb;
    private boolean zzc;

    static {
        zzgk.zza = new String[]{"app_version", "ALTER TABLE messages ADD COLUMN app_version TEXT;", "app_version_int", "ALTER TABLE messages ADD COLUMN app_version_int INTEGER;"};
    }

    public zzgk(zzib zzib0) {
        super(zzib0);
        this.zzb = new zzgi(this, this.zzu.zzaY(), "google_app_measurement_local.db");
    }

    @Override  // com.google.android.gms.measurement.internal.zzg
    public final boolean zze() {
        return false;
    }

    public final void zzh() {
        this.zzg();
        try {
            SQLiteDatabase sQLiteDatabase0 = this.zzp();
            if(sQLiteDatabase0 != null) {
                int v = sQLiteDatabase0.delete("messages", null, null);
                if(v > 0) {
                    this.zzu.zzaV().zzk().zzb("Reset local analytics data. records", v);
                }
            }
        }
        catch(SQLiteException sQLiteException0) {
            this.zzu.zzaV().zzb().zzb("Error resetting local analytics data. error", sQLiteException0);
        }
    }

    public final boolean zzi(zzbg zzbg0) {
        Parcel parcel0 = Parcel.obtain();
        zzbh.zza(zzbg0, parcel0, 0);
        byte[] arr_b = parcel0.marshall();
        parcel0.recycle();
        if(arr_b.length > 0x20000) {
            this.zzu.zzaV().zzc().zza("Event is too long for local database. Sending event directly to service");
            return false;
        }
        return this.zzs(0, arr_b);
    }

    public final boolean zzj(zzpk zzpk0) {
        Parcel parcel0 = Parcel.obtain();
        zzpl.zza(zzpk0, parcel0, 0);
        byte[] arr_b = parcel0.marshall();
        parcel0.recycle();
        if(arr_b.length > 0x20000) {
            this.zzu.zzaV().zzc().zza("User property too long for local database. Sending directly to service");
            return false;
        }
        return this.zzs(1, arr_b);
    }

    public final boolean zzk(zzah zzah0) {
        zzib zzib0 = this.zzu;
        byte[] arr_b = zzib0.zzk().zzae(zzah0);
        if(arr_b.length > 0x20000) {
            zzib0.zzaV().zzc().zza("Conditional user property too long for local database. Sending directly to service");
            return false;
        }
        return this.zzs(2, arr_b);
    }

    public final boolean zzl(zzbe zzbe0) {
        zzib zzib0 = this.zzu;
        byte[] arr_b = zzib0.zzk().zzae(zzbe0);
        if(arr_b == null) {
            zzib0.zzaV().zzc().zza("Null default event parameters; not writing to database");
            return false;
        }
        if(arr_b.length > 0x20000) {
            zzib0.zzaV().zzc().zza("Default event parameters too long for local database. Sending directly to service");
            return false;
        }
        return this.zzs(4, arr_b);
    }

    public final List zzm(int v) {
        zzbg zzbg0;
        Parcel parcel3;
        zzpk zzpk0;
        Parcel parcel2;
        zzbe zzbe0;
        Parcel parcel1;
        zzah zzah0;
        Parcel parcel0;
        zzib zzib2;
        long v6;
        String s1;
        byte[] arr_b;
        Cursor cursor2;
        zzib zzib1;
        String[] arr_s;
        String s;
        long v4;
        Cursor cursor1;
        long v3;
        Cursor cursor0;
        SQLiteDatabase sQLiteDatabase0;
        this.zzg();
        if(this.zzc) {
            return null;
        }
        List list0 = new ArrayList();
        if(this.zzq()) {
            int v1 = 5;
            int v2 = 0;
            while(true) {
                try {
                    sQLiteDatabase0 = null;
                    sQLiteDatabase0 = this.zzp();
                    goto label_13;
                }
                catch(SQLiteFullException sQLiteFullException0) {
                    cursor2 = null;
                    goto label_149;
                }
                catch(SQLiteDatabaseLockedException unused_ex) {
                    cursor2 = null;
                    goto label_155;
                }
                catch(SQLiteException sQLiteException0) {
                    cursor2 = null;
                    goto label_163;
                }
                catch(Throwable throwable0) {
                }
                cursor0 = null;
                break;
            label_13:
                if(sQLiteDatabase0 == null) {
                    try {
                        this.zzc = true;
                        return null;
                    label_16:
                        sQLiteDatabase0.beginTransaction();
                        goto label_17;
                    }
                    catch(SQLiteFullException sQLiteFullException0) {
                        cursor2 = null;
                        goto label_149;
                    }
                    catch(SQLiteDatabaseLockedException unused_ex) {
                        cursor2 = null;
                        goto label_155;
                    }
                    catch(SQLiteException sQLiteException0) {
                        cursor2 = null;
                        goto label_163;
                    }
                    catch(Throwable throwable0) {
                        goto label_56;
                    }
                }
                goto label_16;
                try {
                label_17:
                    v3 = -1L;
                    cursor1 = null;
                    cursor1 = sQLiteDatabase0.query("messages", new String[]{"rowid"}, "type=?", new String[]{"3"}, null, null, "rowid desc", "1");
                    if(cursor1.moveToFirst()) {
                        v4 = cursor1.getLong(0);
                        goto label_27;
                    }
                    else {
                        goto label_29;
                    }
                    goto label_31;
                }
                catch(Throwable throwable1) {
                    try {
                        if(cursor1 != null) {
                            cursor1.close();
                        }
                        throw throwable1;
                    label_27:
                        cursor1.close();
                        goto label_31;
                    label_29:
                        cursor1.close();
                        v4 = -1L;
                    label_31:
                        if(v4 == -1L) {
                            s = null;
                            arr_s = null;
                        }
                        else {
                            s = "rowid<?";
                            arr_s = new String[]{String.valueOf(v4)};
                        }
                        String[] arr_s1 = {"rowid", "type", "entry"};
                        zzib zzib0 = this.zzu;
                        zzfw zzfw0 = zzfx.zzbc;
                        if(zzib0.zzc().zzp(null, zzfw0)) {
                            arr_s1 = new String[]{"rowid", "type", "entry", "app_version", "app_version_int"};
                        }
                        zzib1 = zzib0;
                        cursor2 = sQLiteDatabase0.query("messages", arr_s1, s, arr_s, null, null, "rowid asc", "100");
                        goto label_58;
                    }
                    catch(SQLiteFullException sQLiteFullException0) {
                        cursor2 = null;
                        goto label_149;
                    }
                    catch(SQLiteDatabaseLockedException unused_ex) {
                    }
                    catch(SQLiteException sQLiteException0) {
                        cursor2 = null;
                        goto label_163;
                    }
                    catch(Throwable throwable0) {
                        goto label_56;
                    }
                }
                cursor2 = null;
                goto label_155;
            label_56:
                cursor0 = null;
                break;
                while(true) {
                    try {
                    label_58:
                        if(!cursor2.moveToNext()) {
                            if(sQLiteDatabase0.delete("messages", "rowid <= ?", new String[]{Long.toString(v3)}) < ((ArrayList)list0).size()) {
                                this.zzu.zzaV().zzb().zza("Fewer entries removed from local database than expected");
                            }
                            sQLiteDatabase0.setTransactionSuccessful();
                            sQLiteDatabase0.endTransaction();
                            goto label_63;
                        }
                        goto label_66;
                    }
                    catch(SQLiteFullException sQLiteFullException0) {
                        break;
                    }
                    catch(SQLiteDatabaseLockedException unused_ex) {
                        goto label_155;
                    }
                    catch(SQLiteException sQLiteException0) {
                        goto label_163;
                    }
                    catch(Throwable throwable0) {
                        goto label_174;
                    }
                label_63:
                    cursor2.close();
                    sQLiteDatabase0.close();
                    return list0;
                    try {
                    label_66:
                        v3 = cursor2.getLong(0);
                        int v5 = cursor2.getInt(1);
                        arr_b = cursor2.getBlob(2);
                        if(zzib1.zzc().zzp(null, zzfw0)) {
                            s1 = cursor2.getString(3);
                            v6 = cursor2.getLong(4);
                        }
                        else {
                            v6 = 0L;
                            s1 = null;
                        }
                        if(v5 == 0) {
                            parcel3 = Parcel.obtain();
                            zzib2 = zzib1;
                            goto label_133;
                        }
                        else {
                            zzib2 = zzib1;
                            if(v5 == 1) {
                                parcel2 = Parcel.obtain();
                                goto label_116;
                            }
                            else {
                                switch(v5) {
                                    case 2: {
                                        parcel0 = Parcel.obtain();
                                        goto label_82;
                                    }
                                    case 3: {
                                        goto label_97;
                                    }
                                    case 4: {
                                        parcel1 = Parcel.obtain();
                                        goto label_100;
                                    }
                                    default: {
                                        this.zzu.zzaV().zzb().zza("Unknown record type in local database");
                                    }
                                }
                            }
                        }
                        goto label_146;
                    }
                    catch(SQLiteFullException sQLiteFullException0) {
                        break;
                    }
                    catch(SQLiteDatabaseLockedException unused_ex) {
                        goto label_155;
                    }
                    catch(SQLiteException sQLiteException0) {
                        goto label_163;
                    }
                    catch(Throwable throwable0) {
                        goto label_174;
                    }
                    try {
                        try {
                        label_82:
                            parcel0.unmarshall(arr_b, 0, arr_b.length);
                            parcel0.setDataPosition(0);
                            zzah0 = (zzah)zzah.CREATOR.createFromParcel(parcel0);
                            goto label_93;
                        }
                        catch(ParseException unused_ex) {
                        }
                        this.zzu.zzaV().zzb().zza("Failed to load conditional user property from local database");
                    }
                    catch(Throwable throwable2) {
                        goto label_91;
                    }
                    try {
                        parcel0.recycle();
                        zzah0 = null;
                        goto label_94;
                    label_91:
                        parcel0.recycle();
                        throw throwable2;
                    label_93:
                        parcel0.recycle();
                    label_94:
                        if(zzah0 != null) {
                            ((ArrayList)list0).add(new zzgj(zzah0, s1, v6));
                            goto label_146;
                        label_97:
                            this.zzu.zzaV().zzk().zza("Skipping app launch break");
                        }
                        goto label_146;
                    }
                    catch(SQLiteFullException sQLiteFullException0) {
                        break;
                    }
                    catch(SQLiteDatabaseLockedException unused_ex) {
                        goto label_155;
                    }
                    catch(SQLiteException sQLiteException0) {
                        goto label_163;
                    }
                    catch(Throwable throwable0) {
                        goto label_174;
                    }
                    try {
                        try {
                        label_100:
                            parcel1.unmarshall(arr_b, 0, arr_b.length);
                            parcel1.setDataPosition(0);
                            zzbe0 = (zzbe)zzbe.CREATOR.createFromParcel(parcel1);
                            goto label_111;
                        }
                        catch(ParseException unused_ex) {
                        }
                        this.zzu.zzaV().zzb().zza("Failed to load default event parameters from local database");
                    }
                    catch(Throwable throwable3) {
                        goto label_109;
                    }
                    try {
                        parcel1.recycle();
                        zzbe0 = null;
                        goto label_112;
                    label_109:
                        parcel1.recycle();
                        throw throwable3;
                    label_111:
                        parcel1.recycle();
                    label_112:
                        if(zzbe0 != null) {
                            ((ArrayList)list0).add(new zzgj(zzbe0, s1, v6));
                        }
                        goto label_146;
                    }
                    catch(SQLiteFullException sQLiteFullException0) {
                        break;
                    }
                    catch(SQLiteDatabaseLockedException unused_ex) {
                        goto label_155;
                    }
                    catch(SQLiteException sQLiteException0) {
                        goto label_163;
                    }
                    catch(Throwable throwable0) {
                        goto label_174;
                    }
                    try {
                        try {
                        label_116:
                            parcel2.unmarshall(arr_b, 0, arr_b.length);
                            parcel2.setDataPosition(0);
                            zzpk0 = (zzpk)zzpk.CREATOR.createFromParcel(parcel2);
                            goto label_127;
                        }
                        catch(ParseException unused_ex) {
                        }
                        this.zzu.zzaV().zzb().zza("Failed to load user property from local database");
                    }
                    catch(Throwable throwable4) {
                        goto label_125;
                    }
                    try {
                        parcel2.recycle();
                        zzpk0 = null;
                        goto label_128;
                    label_125:
                        parcel2.recycle();
                        throw throwable4;
                    label_127:
                        parcel2.recycle();
                    label_128:
                        if(zzpk0 != null) {
                            ((ArrayList)list0).add(new zzgj(zzpk0, s1, v6));
                        }
                        goto label_146;
                    }
                    catch(SQLiteFullException sQLiteFullException0) {
                        break;
                    }
                    catch(SQLiteDatabaseLockedException unused_ex) {
                        goto label_155;
                    }
                    catch(SQLiteException sQLiteException0) {
                        goto label_163;
                    }
                    catch(Throwable throwable0) {
                        goto label_174;
                    }
                    try {
                        try {
                        label_133:
                            parcel3.unmarshall(arr_b, 0, arr_b.length);
                            parcel3.setDataPosition(0);
                            zzbg0 = (zzbg)zzbg.CREATOR.createFromParcel(parcel3);
                            goto label_143;
                        }
                        catch(ParseException unused_ex) {
                        }
                        this.zzu.zzaV().zzb().zza("Failed to load event from local database");
                    }
                    catch(Throwable throwable5) {
                        goto label_141;
                    }
                    try {
                        parcel3.recycle();
                        goto label_146;
                    label_141:
                        parcel3.recycle();
                        throw throwable5;
                    label_143:
                        parcel3.recycle();
                        if(zzbg0 != null) {
                            ((ArrayList)list0).add(new zzgj(zzbg0, s1, v6));
                        }
                    label_146:
                        zzib1 = zzib2;
                    }
                    catch(SQLiteFullException sQLiteFullException0) {
                        break;
                    }
                    catch(SQLiteDatabaseLockedException unused_ex) {
                        goto label_155;
                    }
                    catch(SQLiteException sQLiteException0) {
                        goto label_163;
                    }
                    catch(Throwable throwable0) {
                        goto label_174;
                    }
                }
                try {
                label_149:
                    this.zzu.zzaV().zzb().zzb("Error reading entries from local database", sQLiteFullException0);
                    this.zzc = true;
                    if(cursor2 != null) {
                        goto label_152;
                    }
                    goto label_153;
                }
                catch(Throwable throwable0) {
                    goto label_174;
                }
            label_152:
                cursor2.close();
            label_153:
                if(sQLiteDatabase0 == null) {
                    ++v2;
                    sQLiteDatabase0 = null;
                    sQLiteDatabase0 = this.zzp();
                    goto label_13;
                    try {
                    label_155:
                        SystemClock.sleep(v1);
                        v1 += 20;
                        if(cursor2 != null) {
                            goto label_158;
                        }
                        goto label_159;
                    }
                    catch(Throwable throwable0) {
                        goto label_174;
                    }
                label_158:
                    cursor2.close();
                label_159:
                    if(sQLiteDatabase0 != null) {
                        goto label_160;
                    }
                }
                else {
                label_160:
                    sQLiteDatabase0.close();
                    ++v2;
                    sQLiteDatabase0 = null;
                    sQLiteDatabase0 = this.zzp();
                    goto label_13;
                    try {
                    label_163:
                        if(sQLiteDatabase0 != null && sQLiteDatabase0.inTransaction()) {
                            sQLiteDatabase0.endTransaction();
                        }
                        this.zzu.zzaV().zzb().zzb("Error reading entries from local database", sQLiteException0);
                        this.zzc = true;
                        if(cursor2 != null) {
                            goto label_168;
                        }
                        goto label_169;
                    }
                    catch(Throwable throwable0) {
                        goto label_174;
                    }
                label_168:
                    cursor2.close();
                label_169:
                    if(sQLiteDatabase0 != null) {
                        sQLiteDatabase0.close();
                    }
                }
                ++v2;
                sQLiteDatabase0 = null;
                sQLiteDatabase0 = this.zzp();
                goto label_13;
            label_174:
                cursor0 = cursor2;
                break;
            }
            if(cursor0 != null) {
                cursor0.close();
            }
            if(sQLiteDatabase0 != null) {
                sQLiteDatabase0.close();
            }
            throw throwable0;
        }
        return list0;
    }

    public final boolean zzn() {
        return this.zzs(3, new byte[0]);
    }

    public final boolean zzo() {
        SQLiteDatabase sQLiteDatabase0;
        this.zzg();
        if(!this.zzc && this.zzq()) {
            int v = 5;
            int v1 = 0;
            while(true) {
                try {
                    try {
                    label_4:
                        sQLiteDatabase0 = null;
                        sQLiteDatabase0 = this.zzp();
                        if(sQLiteDatabase0 == null) {
                            this.zzc = true;
                            return false;
                        }
                        sQLiteDatabase0.beginTransaction();
                        sQLiteDatabase0.delete("messages", "type == ?", new String[]{"3"});
                        sQLiteDatabase0.setTransactionSuccessful();
                        sQLiteDatabase0.endTransaction();
                        break;
                    }
                    catch(SQLiteFullException sQLiteFullException0) {
                    }
                    catch(SQLiteDatabaseLockedException unused_ex) {
                        goto label_20;
                    }
                    catch(SQLiteException sQLiteException0) {
                        goto label_26;
                    }
                    this.zzu.zzaV().zzb().zzb("Error deleting app launch break from local database", sQLiteFullException0);
                    this.zzc = true;
                    if(sQLiteDatabase0 != null) {
                        goto label_18;
                    }
                    goto label_32;
                }
                catch(Throwable throwable0) {
                    goto label_35;
                }
            label_18:
                sQLiteDatabase0.close();
                goto label_32;
                try {
                label_20:
                    SystemClock.sleep(v);
                    v += 20;
                    if(sQLiteDatabase0 != null) {
                        goto label_23;
                    }
                    goto label_32;
                }
                catch(Throwable throwable0) {
                    goto label_35;
                }
            label_23:
                sQLiteDatabase0.close();
                goto label_32;
                try {
                label_26:
                    if(sQLiteDatabase0 != null && sQLiteDatabase0.inTransaction()) {
                        sQLiteDatabase0.endTransaction();
                    }
                    this.zzu.zzaV().zzb().zzb("Error deleting app launch break from local database", sQLiteException0);
                    this.zzc = true;
                    if(sQLiteDatabase0 != null) {
                        goto label_31;
                    }
                    goto label_32;
                }
                catch(Throwable throwable0) {
                    goto label_35;
                }
            label_31:
                sQLiteDatabase0.close();
            label_32:
                ++v1;
                goto label_4;
            label_35:
                TWR.safeClose$NT(sQLiteDatabase0, throwable0);
                throw throwable0;
            }
            sQLiteDatabase0.close();
            return true;
        }
        return false;
    }

    public final SQLiteDatabase zzp() {
        if(this.zzc) {
            return null;
        }
        SQLiteDatabase sQLiteDatabase0 = this.zzb.getWritableDatabase();
        if(sQLiteDatabase0 == null) {
            this.zzc = true;
            return null;
        }
        return sQLiteDatabase0;
    }

    public final boolean zzq() {
        return this.zzu.zzaY().getDatabasePath("google_app_measurement_local.db").exists();
    }

    public static String[] zzr() {
        return zzgk.zza;
    }

    private final boolean zzs(int v, byte[] arr_b) {
        long v3;
        Cursor cursor1;
        int v2;
        int v1;
        ContentValues contentValues0;
        Cursor cursor0;
        zzib zzib0;
        this.zzg();
        if(!this.zzc) {
            zzib0 = this.zzu;
            cursor0 = null;
            zzr zzr0 = zzib0.zzc().zzp(null, zzfx.zzbc) ? this.zzu.zzv().zzh(null) : null;
            contentValues0 = new ContentValues();
            contentValues0.put("type", v);
            contentValues0.put("entry", arr_b);
            if(zzib0.zzc().zzp(null, zzfx.zzbc) && zzr0 != null) {
                contentValues0.put("app_version", zzr0.zzc);
                contentValues0.put("app_version_int", zzr0.zzj);
            }
            v1 = 5;
            v2 = 0;
            sQLiteDatabase0 = null;
            sQLiteDatabase0 = this.zzp();
            goto label_39;
        }
        try {
            return false;
        label_18:
            cursor1 = null;
        }
        catch(SQLiteFullException sQLiteFullException0) {
            cursor1 = null;
            goto label_65;
        }
        catch(SQLiteDatabaseLockedException unused_ex) {
            cursor1 = null;
            goto label_73;
        }
        catch(SQLiteException sQLiteException0) {
            goto label_18;
        }
        catch(Throwable throwable0) {
            goto label_91;
        }
    alab1:
        while(true) {
            try {
            label_19:
                if(sQLiteDatabase0 != null && sQLiteDatabase0.inTransaction()) {
                    sQLiteDatabase0.endTransaction();
                }
                this.zzu.zzaV().zzb().zzb("Error writing entry to local database", sQLiteException0);
                this.zzc = true;
                if(cursor1 != null) {
                    goto label_24;
                }
                goto label_25;
            }
            catch(Throwable throwable0) {
                break;
            }
        label_24:
            cursor1.close();
        label_25:
            if(sQLiteDatabase0 != null) {
                sQLiteDatabase0.close();
            }
            while(true) {
                ++v2;
                try {
                    sQLiteDatabase0 = null;
                    sQLiteDatabase0 = this.zzp();
                    goto label_39;
                }
                catch(SQLiteFullException sQLiteFullException0) {
                }
                catch(SQLiteDatabaseLockedException unused_ex) {
                    cursor1 = null;
                    goto label_73;
                }
                catch(SQLiteException sQLiteException0) {
                    cursor1 = null;
                    goto label_19;
                }
                catch(Throwable throwable0) {
                    goto label_91;
                }
                cursor1 = null;
                goto label_65;
            label_39:
                if(sQLiteDatabase0 == null) {
                    try {
                        this.zzc = true;
                        return false;
                    label_42:
                        v3 = 0L;
                        sQLiteDatabase0.beginTransaction();
                        cursor1 = sQLiteDatabase0.rawQuery("select count(1) from messages", null);
                        goto label_52;
                    }
                    catch(SQLiteFullException sQLiteFullException0) {
                        cursor1 = null;
                        goto label_65;
                    }
                    catch(SQLiteDatabaseLockedException unused_ex) {
                        cursor1 = null;
                        goto label_73;
                    }
                    catch(SQLiteException sQLiteException0) {
                        goto label_18;
                    }
                    catch(Throwable throwable0) {
                        goto label_91;
                    }
                }
                goto label_42;
            label_52:
                if(cursor1 != null) {
                    try {
                        if(cursor1.moveToFirst()) {
                            v3 = cursor1.getLong(0);
                        }
                    label_55:
                        if(Long.compare(v3, 100000L) >= 0) {
                            zzib0.zzaV().zzb().zza("Data loss, local db full");
                            long v4 = (long)sQLiteDatabase0.delete("messages", "rowid in (select rowid from messages order by rowid asc limit ?)", new String[]{Long.toString(100001L - v3)});
                            if(v4 != 100001L - v3) {
                                zzib0.zzaV().zzb().zzd("Different delete count than expected in local db. expected, received, difference", ((long)(100001L - v3)), v4, ((long)(100001L - v3 - v4)));
                            }
                        }
                        sQLiteDatabase0.insertOrThrow("messages", null, contentValues0);
                        sQLiteDatabase0.setTransactionSuccessful();
                        sQLiteDatabase0.endTransaction();
                        goto label_87;
                    }
                    catch(SQLiteFullException sQLiteFullException0) {
                        goto label_65;
                    }
                    catch(SQLiteDatabaseLockedException unused_ex) {
                        goto label_73;
                    }
                    catch(SQLiteException sQLiteException0) {
                        continue alab1;
                    }
                    catch(Throwable throwable0) {
                        break alab1;
                    }
                }
                goto label_55;
                try {
                label_65:
                    this.zzu.zzaV().zzb().zzb("Error writing entry; local database full", sQLiteFullException0);
                    this.zzc = true;
                    if(cursor1 != null) {
                        goto label_68;
                    }
                    goto label_69;
                }
                catch(Throwable throwable0) {
                    break alab1;
                }
            label_68:
                cursor1.close();
            label_69:
                if(sQLiteDatabase0 != null) {
                    sQLiteDatabase0.close();
                }
                ++v2;
                sQLiteDatabase0 = null;
                sQLiteDatabase0 = this.zzp();
                goto label_39;
                try {
                label_73:
                    SystemClock.sleep(v1);
                    v1 += 20;
                    if(cursor1 != null) {
                        goto label_76;
                    }
                    goto label_77;
                }
                catch(Throwable throwable0) {
                    break alab1;
                }
            label_76:
                cursor1.close();
            label_77:
                if(sQLiteDatabase0 == null) {
                    break;
                }
                sQLiteDatabase0.close();
            }
            ++v2;
            sQLiteDatabase0 = null;
            sQLiteDatabase0 = this.zzp();
            goto label_39;
        }
        cursor0 = cursor1;
        goto label_91;
    label_87:
        if(cursor1 != null) {
            cursor1.close();
        }
        sQLiteDatabase0.close();
        return true;
    label_91:
        if(cursor0 != null) {
            cursor0.close();
        }
        if(sQLiteDatabase0 != null) {
            sQLiteDatabase0.close();
        }
        throw throwable0;
    }
}

