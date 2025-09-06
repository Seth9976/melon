package i9;

import R8.q;
import R8.t;
import U4.x;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteClosable;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.provider.MediaStore.Audio.Media;
import com.iloen.melon.mediastore.MelonMediaProvider;
import com.iloen.melon.utils.FilenameUtils;
import com.iloen.melon.utils.log.LogU;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import u9.c;

public final class d {
    public final Context a;
    public final String b;
    public final int c;
    public SQLiteDatabase d;
    public boolean e;
    public final ReentrantLock f;
    public final Context g;
    public final boolean h;
    public final HashMap i;
    public final HashMap j;

    public d(Context context0, String s, boolean z) {
        this.f = new ReentrantLock(true);
        this.a = context0;
        this.b = s;
        this.c = 12;
        this.i = new HashMap();
        this.j = new HashMap();
        this.g = context0;
        this.h = z;
    }

    public final SQLiteDatabase a() {
        synchronized(this) {
            if(this.d != null && this.d.isOpen()) {
                return this.d;
            }
            if(!this.e) {
                try {
                    return this.b();
                }
                catch(SQLiteException sQLiteException0) {
                    if(this.b != null) {
                        LogU.e("MelonSQLiteOpenHelper", "Couldn\'t open " + this.b + " for writing (will try read-only):", sQLiteException0);
                        SQLiteDatabase sQLiteDatabase1 = null;
                        try {
                            this.e = true;
                            String s = this.a.getDatabasePath(this.b).getPath();
                            sQLiteDatabase1 = SQLiteDatabase.openDatabase(s, null, 1);
                            if(sQLiteDatabase1.getVersion() != this.c) {
                                throw new SQLiteException("Can\'t upgrade read-only database from version " + sQLiteDatabase1.getVersion() + " to " + this.c + ": " + s);
                            }
                            if(!this.h) {
                                new File(sQLiteDatabase1.getPath()).setLastModified(System.currentTimeMillis());
                            }
                            LogU.w("MelonSQLiteOpenHelper", "Opened " + this.b + " in read-only mode");
                            this.d = sQLiteDatabase1;
                            this.e = false;
                            return sQLiteDatabase1;
                        }
                        catch(Throwable throwable0) {
                            this.e = false;
                            if(sQLiteDatabase1 != null && sQLiteDatabase1 != this.d) {
                                sQLiteDatabase1.close();
                            }
                            throw throwable0;
                        }
                    }
                    throw sQLiteException0;
                }
            }
        }
        throw new IllegalStateException("getReadableDatabase called recursively");
    }

    public final SQLiteDatabase b() {
        int v1;
        SQLiteDatabase sQLiteDatabase0;
        SQLiteClosable sQLiteClosable0;
        synchronized(this) {
            if(this.d != null && this.d.isOpen() && !this.d.isReadOnly()) {
                return this.d;
            }
            if(!this.e) {
                if(this.d != null) {
                    this.f.lock();
                }
                try {
                    sQLiteClosable0 = null;
                    this.e = true;
                    String s = this.b;
                    if(s == null) {
                        sQLiteDatabase0 = SQLiteDatabase.create(null);
                    }
                    else {
                        try {
                            if(s.contains("melonplaylist.db")) {
                                sQLiteDatabase0 = this.a.openOrCreateDatabase(this.b, 0, null);
                            }
                            else {
                                sQLiteDatabase0 = this.b.indexOf(";") >= 0 || this.b.indexOf("") >= 0 ? SQLiteDatabase.openOrCreateDatabase(this.b, null) : this.a.openOrCreateDatabase(this.b, 0, null);
                            }
                            goto label_30;
                        }
                        catch(SQLiteException sQLiteException0) {
                        }
                        LogU.e("MelonSQLiteOpenHelper", "Couldn\'t open " + this.b + " for writing (will try read-only):", sQLiteException0);
                        this.e = false;
                        if(this.d != null) {
                            goto label_25;
                        }
                        return null;
                    }
                    goto label_30;
                }
                catch(Throwable throwable0) {
                    goto label_57;
                }
            label_25:
                this.f.unlock();
                return null;
            label_30:
                if(sQLiteDatabase0 == null) {
                    this.e = false;
                    if(this.d != null) {
                        this.f.unlock();
                    }
                    return null;
                }
                try {
                    v1 = sQLiteDatabase0.getVersion();
                    if(v1 != this.c) {
                        sQLiteDatabase0.beginTransaction();
                        if(v1 == 0) {
                            goto label_40;
                        }
                        else {
                            goto label_43;
                        }
                        goto label_44;
                    }
                    goto label_51;
                }
                catch(Throwable throwable1) {
                    goto label_55;
                }
                try {
                label_40:
                    LogU.i("MelonMediaProvider", "onCreate - db:" + sQLiteDatabase0);
                    d.d(this.g, sQLiteDatabase0, this.h, 0, 12);
                    goto label_44;
                label_43:
                    this.c(sQLiteDatabase0, v1, this.c);
                label_44:
                    sQLiteDatabase0.setVersion(this.c);
                    sQLiteDatabase0.setTransactionSuccessful();
                    goto label_50;
                }
                catch(Throwable throwable2) {
                    try {
                        sQLiteDatabase0.endTransaction();
                        throw throwable2;
                    label_50:
                        sQLiteDatabase0.endTransaction();
                    label_51:
                        if(!this.h) {
                            new File(sQLiteDatabase0.getPath()).setLastModified(System.currentTimeMillis());
                        }
                        goto label_64;
                    }
                    catch(Throwable throwable1) {
                    }
                }
            label_55:
                sQLiteClosable0 = sQLiteDatabase0;
                throwable0 = throwable1;
            label_57:
                this.e = false;
                if(this.d != null) {
                    this.f.unlock();
                }
                if(sQLiteClosable0 != null) {
                    sQLiteClosable0.close();
                }
                throw throwable0;
            label_64:
                this.e = false;
                SQLiteDatabase sQLiteDatabase1 = this.d;
                if(sQLiteDatabase1 != null) {
                    try {
                        sQLiteDatabase1.close();
                    }
                    catch(Exception unused_ex) {
                    }
                    this.f.unlock();
                }
                this.d = sQLiteDatabase0;
                return sQLiteDatabase0;
            }
        }
        throw new IllegalStateException("getWritableDatabase called recursively");
    }

    public final void c(SQLiteDatabase sQLiteDatabase0, int v, int v1) {
        LogU.i("MelonMediaProvider", "onUpgrade - db:" + sQLiteDatabase0 + ", oldVersion:" + v + ", newVersion:" + v1);
        d.d(this.g, sQLiteDatabase0, this.h, v, v1);
    }

    public static void d(Context context0, SQLiteDatabase sQLiteDatabase0, boolean z, int v, int v1) {
        HashMap hashMap1;
        ArrayList arrayList2;
        Uri uri0;
        String s = sQLiteDatabase0.getPath();
        LogU.i("MelonMediaProvider", "updateDatabse - path:" + s + ", isInternal:" + z + ", fromVersion:" + v + ", toVersion:" + v1);
        if(v1 == 12) {
            if(v > 12) {
                LogU.w("MelonMediaProvider", "DB DOWNGRADING... WILL REMOVE ALL EXISTING DATA..");
                if(MelonMediaProvider.j.equals(s)) {
                    x.v(sQLiteDatabase0, "DROP TABLE IF EXISTS audio_meta", "DROP TABLE IF EXISTS audio_genres_map", "DROP TABLE IF EXISTS artists", "DROP TABLE IF EXISTS albums");
                    x.v(sQLiteDatabase0, "DROP TABLE IF EXISTS album_art", "DROP TABLE IF EXISTS audio_genres", "DROP VIEW IF EXISTS artists_albums_map", "DROP VIEW IF EXISTS audio");
                    x.v(sQLiteDatabase0, "DROP VIEW IF EXISTS artist_info", "DROP VIEW IF EXISTS searchhelpertitle", "DROP VIEW IF EXISTS album_info", "DROP VIEW IF EXISTS search");
                }
                else {
                    x.v(sQLiteDatabase0, "DROP TABLE IF EXISTS audio_playlists", "DROP TABLE IF EXISTS audio_playlists_map", "DROP TABLE IF EXISTS audio_play_playlists_map", "DROP TABLE IF EXISTS playstreaming");
                    sQLiteDatabase0.execSQL("DROP INDEX IF EXISTS songid_idx");
                    sQLiteDatabase0.execSQL("DROP INDEX IF EXISTS _data_idx");
                }
                sQLiteDatabase0.setVersion(12);
            }
            if(MelonMediaProvider.j.equals(s)) {
                x.v(sQLiteDatabase0, "CREATE TABLE IF NOT EXISTS audio_meta (_id INTEGER PRIMARY KEY, _data TEXT UNIQUE NOT NULL, _display_name TEXT, _size INTEGER, mime_type TEXT, date_added INTEGER, date_modified INTEGER, title TEXT NOT NULL, title_key TEXT NOT NULL,duration INTEGER, artist_id INTEGER, composer TEXT, album_id INTEGER, track INTEGER, year INTEGER CHECK(year!=0), is_ringtone INTEGER, is_music INTEGER, is_alarm INTEGER, is_notification INTEGER);", "CREATE INDEX IF NOT EXISTS titlekey_index ON audio_meta(title_key);", "CREATE INDEX IF NOT EXISTS title_idx ON audio_meta(title);", "CREATE INDEX IF NOT EXISTS album_id_idx ON audio_meta(album_id);");
                x.v(sQLiteDatabase0, "CREATE VIEW IF NOT EXISTS artists_albums_map AS SELECT distinct artist_id, album_id FROM audio_meta;", "CREATE TABLE IF NOT EXISTS audio_genres_map (_id INTEGER PRIMARY KEY, audio_id INTEGER NOT NULL, genre_id INTEGER NOT NULL);", "CREATE TABLE IF NOT EXISTS artists (artist_id INTEGER PRIMARY KEY, artist_key TEXT NOT NULL unique, artist TEXT NOT NULL);", "CREATE INDEX IF NOT EXISTS artistkey_index ON artists(artist_key);");
                x.v(sQLiteDatabase0, "CREATE INDEX IF NOT EXISTS artist_idx ON artists(artist);", "CREATE INDEX IF NOT EXISTS artist_id_idx ON audio_meta(artist_id);", "CREATE TABLE IF NOT EXISTS albums (album_id INTEGER PRIMARY KEY, album_key TEXT NOT NULL unique, album TEXT NULL);", "CREATE INDEX IF NOT EXISTS album_idx ON albums(album);");
                x.v(sQLiteDatabase0, "CREATE INDEX IF NOT EXISTS albumkey_index ON albums(album_key);", "CREATE TABLE IF NOT EXISTS album_art (album_id INTEGER PRIMARY KEY, _data TEXT);", "CREATE TRIGGER IF NOT EXISTS albumart_cleanup1 DELETE ON albums BEGIN DELETE FROM album_art WHERE album_id=old.album_id; END", "CREATE TRIGGER IF NOT EXISTS albumart_cleanup2 DELETE ON album_art BEGIN SELECT _DELETE_FILE(old._data); END");
                x.v(sQLiteDatabase0, "CREATE VIEW IF NOT EXISTS audio AS SELECT * FROM audio_meta LEFT OUTER JOIN artists ON audio_meta.artist_id=artists.artist_id LEFT OUTER JOIN albums ON audio_meta.album_id=albums.album_id;", "CREATE TRIGGER IF NOT EXISTS audio_delete INSTEAD OF DELETE ON audio BEGIN DELETE FROM audio_meta WHERE _id=old._id;  DELETE FROM audio_genres_map WHERE audio_id=old._id; END", "CREATE VIEW IF NOT EXISTS artist_info AS SELECT artist_id AS _id, artist, artist_key, COUNT(DISTINCT album) AS number_of_albums, COUNT(*) AS number_of_tracks FROM audio WHERE is_music=1 GROUP BY artist_key;", "CREATE TABLE IF NOT EXISTS audio_genres (_id INTEGER PRIMARY KEY, name TEXT NOT NULL);");
                x.v(sQLiteDatabase0, "CREATE TRIGGER IF NOT EXISTS audio_genres_cleanup DELETE ON audio_genres BEGIN DELETE FROM audio_genres_map WHERE genre_id=old._id; END", "CREATE TRIGGER IF NOT EXISTS audio_meta_cleanup DELETE ON audio_meta BEGIN DELETE FROM audio_genres_map WHERE audio_id=old._id; END", "CREATE VIEW IF NOT EXISTS searchhelpertitle AS SELECT * FROM audio ORDER BY title_key;", "CREATE VIEW IF NOT EXISTS album_info AS SELECT audio.album_id AS _id, album, album_key, MIN(year) AS minyear, MAX(year) AS maxyear, artist, artist_id, artist_key, COUNT(*) AS numsongs, album_art._data AS album_art FROM audio LEFT OUTER JOIN album_art ON audio.album_id=album_art.album_id WHERE is_music=1 GROUP BY audio.album_id;");
                sQLiteDatabase0.execSQL("CREATE VIEW IF NOT EXISTS search AS SELECT _id, \'artist\' AS mime_type, artist, NULL AS album,NULL AS title, artist AS text1, NULL AS text2, number_of_albums AS data1, number_of_tracks AS data2,artist_key AS match, \'content://com.iloen.melon.provider.melondcf/external/audio/artists/\'||_id AS suggest_intent_data,1 AS grouporder FROM artist_info WHERE (artist!=\'<unknown>\') UNION ALL SELECT _id, \'album\' AS mime_type,artist, album, NULL AS title, album AS text1, artist AS text2, NULL AS data1, NULL AS data2,artist_key||\' \'||album_key AS match, \'content://com.iloen.melon.provider.melondcf/external/audio/albums/\'||_id AS suggest_intent_data,2 AS grouporder FROM album_info WHERE (album!=\'<unknown>\') UNION ALL SELECT searchhelpertitle._id AS _id,mime_type, artist, album, title, title AS text1, artist AS text2, NULL AS data1, NULL AS data2,artist_key||\' \'||album_key||\' \'||title_key AS match,\'content://com.iloen.melon.provider.melondcf/external/audio/com.iloen.melon.provider.melondcf/\'||searchhelpertitle._id AS suggest_intent_data, 3 AS grouporder FROM searchhelpertitle WHERE (title != \'\')");
            }
            else {
                sQLiteDatabase0.execSQL("CREATE TABLE IF NOT EXISTS audio_playlists (_id INTEGER PRIMARY KEY, _data TEXT, name TEXT NOT NULL, date_added INTEGER, date_modified INTEGER, sort_order INTEGER NOT NULL);");
                if(v >= 3 || v == 0) {
                    sQLiteDatabase0.execSQL("CREATE TABLE IF NOT EXISTS audio_playlists_map (_id INTEGER PRIMARY KEY, audio_id1 INTEGER, audio_id2 INTEGER, mime_type TEXT, _data TEXT NOT NULL, title TEXT NOT NULL, album_id INTEGER, album TEXT, artist TEXT, artist_id INTEGER, playlist_id INTEGER NOT NULL, play_order INTEGER NOT NULL, duration INTEGER);");
                }
                else {
                    sQLiteDatabase0.execSQL("ALTER TABLE audio_playlists_map ADD album_id INTEGER");
                    ContentResolver contentResolver0 = context0.getContentResolver();
                    Cursor cursor0 = sQLiteDatabase0.rawQuery("select _data from audio_playlists_map", null);
                    if(cursor0 != null) {
                        ArrayList arrayList0 = new ArrayList();
                        ArrayList arrayList1 = new ArrayList();
                        HashMap hashMap0 = new HashMap();
                        if(cursor0.getCount() > 0) {
                            cursor0.moveToFirst();
                            while(true) {
                                String s1 = cursor0.getString(0);
                                if(s1 != null) {
                                    if(FilenameUtils.isMusic(s1, true)) {
                                        arrayList0.add(s1);
                                    }
                                    else {
                                        arrayList1.add(s1);
                                    }
                                }
                                if(!cursor0.moveToNext()) {
                                    break;
                                }
                            }
                        }
                        cursor0.close();
                        int v2 = 0;
                        while(v2 < 2) {
                            if(v2 == 0) {
                                uri0 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                                arrayList2 = arrayList0;
                            }
                            else {
                                uri0 = q.a.c() ? k.a : MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                                arrayList2 = arrayList1;
                            }
                            if(arrayList2.size() > 0) {
                                int v3 = arrayList2.size();
                                String[] arr_s = new String[v3];
                                arrayList2.toArray(arr_s);
                                String s2 = "_data=\'" + arr_s[0].replaceAll("\'", "\'\'") + "\'";
                                for(int v4 = 1; v4 < v3; ++v4) {
                                    StringBuilder stringBuilder0 = x.p(s2, " OR _data=\'");
                                    stringBuilder0.append(arr_s[v4].replaceAll("\'", "\'\'"));
                                    stringBuilder0.append("\'");
                                    s2 = stringBuilder0.toString();
                                }
                                hashMap1 = hashMap0;
                                Cursor cursor1 = contentResolver0.query(uri0, new String[]{"_data", "album_id"}, s2, null, "title_key");
                                if(cursor1 != null) {
                                    if(cursor1.getCount() > 0) {
                                        cursor1.moveToFirst();
                                        while(true) {
                                            String s3 = cursor1.getString(0).replaceAll("\'", "\'\'");
                                            int v5 = cursor1.getInt(1);
                                            ContentValues contentValues0 = new ContentValues(1);
                                            contentValues0.put("album_id", v5);
                                            hashMap1.put(s3, contentValues0);
                                            if(!cursor1.moveToNext()) {
                                                break;
                                            }
                                        }
                                    }
                                    cursor1.close();
                                }
                            }
                            else {
                                hashMap1 = hashMap0;
                            }
                            ++v2;
                            hashMap0 = hashMap1;
                        }
                        if(hashMap0.size() > 0) {
                            Set set0 = hashMap0.keySet();
                            int v6 = set0.size();
                            String[] arr_s1 = new String[v6];
                            set0.toArray(arr_s1);
                            sQLiteDatabase0.beginTransaction();
                            for(int v7 = 0; v7 < v6; ++v7) {
                                sQLiteDatabase0.update("audio_playlists_map", ((ContentValues)hashMap0.get(arr_s1[v7])), x.m(new StringBuilder("_data=\'"), arr_s1[v7], "\'"), null);
                            }
                            sQLiteDatabase0.setTransactionSuccessful();
                            sQLiteDatabase0.endTransaction();
                        }
                    }
                }
                sQLiteDatabase0.execSQL("CREATE TABLE IF NOT EXISTS audio_play_playlists_map (_id INTEGER PRIMARY KEY, audio_id INTEGER, is_melondcf INTEGER NOT NULL, _data TEXT NOT NULL, title TEXT NOT NULL, album TEXT, artist TEXT, artist_id INTEGER, play_time INTEGER NOT NULL, play_count INTEGER, duration INTEGER);");
                sQLiteDatabase0.execSQL("CREATE TRIGGER IF NOT EXISTS audio_playlists_cleanup DELETE ON audio_playlists BEGIN DELETE FROM audio_playlists_map WHERE playlist_id=old._id; SELECT _DELETE_FILE(old._data); END");
                if(v == 9) {
                    sQLiteDatabase0.execSQL("DROP TABLE IF EXISTS playstreaming");
                }
                sQLiteDatabase0.execSQL("CREATE TABLE IF NOT EXISTS playstreaming (_id INTEGER PRIMARY KEY AUTOINCREMENT, songid TEXT, _data TEXT, bitrate TEXT, ismp3 TEXT, match_stat INTEGER NOT NULL DEFAULT 2, albumid TEXT, artistids TEXT, artistnames TEXT); ");
                sQLiteDatabase0.execSQL("CREATE INDEX IF NOT EXISTS songid_idx ON playstreaming(songid)");
                sQLiteDatabase0.execSQL("CREATE INDEX IF NOT EXISTS _data_idx ON playstreaming(_data)");
                Cursor cursor2 = sQLiteDatabase0.rawQuery("SELECT * FROM playstreaming LIMIT 1", null);
                if(cursor2 != null) {
                    if(cursor2.getColumnIndex("match_stat") == -1) {
                        sQLiteDatabase0.execSQL("ALTER TABLE playstreaming ADD match_stat INTEGER NOT NULL default 2");
                    }
                    if(cursor2.getColumnIndex("albumid") == -1) {
                        sQLiteDatabase0.execSQL("ALTER TABLE playstreaming ADD albumid TEXT");
                        sQLiteDatabase0.execSQL("ALTER TABLE playstreaming ADD artistids TEXT");
                        sQLiteDatabase0.execSQL("ALTER TABLE playstreaming ADD artistnames TEXT");
                    }
                    cursor2.close();
                }
                Cursor cursor3 = sQLiteDatabase0.rawQuery("SELECT * FROM audio_playlists LIMIT 1", null);
                if(cursor3 != null) {
                    if(cursor3.getColumnIndex("sort_order") == -1) {
                        sQLiteDatabase0.execSQL("ALTER TABLE audio_playlists ADD sort_order INTEGER NOT NULL default -1");
                        new t(2).execute(null);
                    }
                    cursor3.close();
                }
            }
            if(!z && v < 12 && v > 0) {
                Intent intent0 = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                intent0.setData(Uri.fromFile(c.c()));
                context0.sendBroadcast(intent0);
            }
            return;
        }
        String s4 = "Illegal update request. Got " + v1 + ", expected 12";
        LogU.e("MelonMediaProvider", s4);
        throw new IllegalArgumentException(s4);
    }
}

