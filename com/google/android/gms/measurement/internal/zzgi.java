package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import com.google.android.gms.internal.measurement.zzby;
import java.util.Objects;

final class zzgi extends zzby {
    final zzgk zza;

    public zzgi(zzgk zzgk0, Context context0, String s) {
        Objects.requireNonNull(zzgk0);
        this.zza = zzgk0;
        super(context0, "google_app_measurement_local.db", null, 1);
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() {
        try {
            return super.getWritableDatabase();
        }
        catch(SQLiteDatabaseLockedException sQLiteDatabaseLockedException0) {
            throw sQLiteDatabaseLockedException0;
        }
        catch(SQLiteException unused_ex) {
            zzib zzib0 = this.zza.zzu;
            zzib0.zzaV().zzb().zza("Opening the local database failed, dropping and recreating it");
            if(!zzib0.zzaY().getDatabasePath("google_app_measurement_local.db").delete()) {
                zzib0.zzaV().zzb().zzb("Failed to delete corrupted local db file", "google_app_measurement_local.db");
            }
            try {
                return super.getWritableDatabase();
            }
            catch(SQLiteException sQLiteException0) {
                this.zza.zzu.zzaV().zzb().zzb("Failed to open local database. Events will bypass local storage", sQLiteException0);
                return null;
            }
        }
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase0) {
        zzaw.zzb(this.zza.zzu.zzaV(), sQLiteDatabase0);
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase0, int v, int v1) {
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase0) {
        zzaw.zza(this.zza.zzu.zzaV(), sQLiteDatabase0, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", zzgk.zzr());
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase0, int v, int v1) {
    }
}

