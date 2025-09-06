package com.iloen.melon.userstore;

import U4.x;
import U8.K;
import U8.L;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.text.TextUtils;
import b3.Z;
import com.iloen.melon.utils.log.LogU;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jeb.synthetic.TWR;
import kotlin.jvm.internal.q;

@Deprecated
public class MelonDb extends SQLiteOpenHelper implements BaseColumns {
    private static final String ALBUM_COLUMNS_DEF_STMT = "album_id TEXT NOT NULL, album_img_path TEXT, album_name TEXT NOT NULL, artist_id TEXT NOT NULL, artist_name TEXT NOT NULL, ctype TEXT, is_service INTEGER, issue_date TEXT, like_count INTEGER, song_count INTEGER";
    private static final String COMMON_COLUMNS_DEF_STMT = "menu_id TEXT NOT NULL, curr_rank TEXT, past_rank TEXT, rank_gap TEXT, rank_type TEXT";
    private static final String CREATE_T_FLOATING_BANNER_POPUP = "CREATE TABLE IF NOT EXISTS floating_banner_popup (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, member_key TEXT NOT NULL, BANERSEQ TEXT NOT NULL, BANON TEXT NOT NULL);";
    private static final String CREATE_T_LAYER_POPUP = "CREATE TABLE IF NOT EXISTS layer_popup (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, member_key TEXT NOT NULL, BANERSEQ TEXT NOT NULL, BANON TEXT NOT NULL);";
    private static final String CREATE_T_NOTICE_POPUP = "CREATE TABLE IF NOT EXISTS notice_popup (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, MEMBER_KEY TEXT NOT NULL, BANERSEQ TEXT NOT NULL, BANON TEXT NOT NULL);";
    private static final String CREATE_T_PLAYBACK_LOG = "CREATE TABLE IF NOT EXISTS playbacklog (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, data TEXT NOT NULL,ctype TEXT NOT NULL,cid TEXT NOT NULL,mcode TEXT NOT NULL,lcode TEXT NOT NULL,played_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP);";
    private static final String CREATE_T_PREMIUM_OFFPLAY_LOG = "CREATE TABLE IF NOT EXISTS premium_offplay_log (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, cid TEXT NOT NULL,ctype TEXT NOT NULL,pstime TEXT NOT NULL,meta_type TEXT NOT NULL,bitrate TEXT NOT NULL,binfo TEXT NOT NULL,free_yn TEXT NOT NULL,memberkey TEXT NOT NULL,played_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP);";
    private static final String CREATE_T_PROMOTION_POPUP = "CREATE TABLE IF NOT EXISTS promotion_popup (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, member_key TEXT NOT NULL, id TEXT NOT NULL, query TEXT NOT NULL);";
    private static final String CREATE_T_RESPONSE_CACHE = "CREATE TABLE IF NOT EXISTS response_cache (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, key TEXT NOT NULL, type INTEGER DEFAULT 0, contents TEXT NOT NULL, has_more INTEGER DEFAULT 0, modified_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP);";
    private static final String CREATE_T_SEARCH_HIST = "CREATE TABLE IF NOT EXISTS search_hist (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, menu_id TEXT NOT NULL, curr_rank TEXT, past_rank TEXT, rank_gap TEXT, rank_type TEXT, album_id TEXT NOT NULL, album_img_path TEXT, album_name TEXT NOT NULL, artist_id TEXT NOT NULL, artist_name TEXT NOT NULL, ctype TEXT, is_service INTEGER, issue_date TEXT, like_count INTEGER, song_count INTEGER, is_adult INTEGER, is_free INTEGER, is_hit_song INTEGER, is_holdback INTEGER, is_mv INTEGER, is_title_song INTEGER, is_recomm_song INTEGER, play_time TEXT, song_id TEXT NOT NULL, song_title TEXT NOT NULL);";
    public static final String CREATE_T_USER_EQUALIZER = "CREATE TABLE IF NOT EXISTS user_equalizer (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, type INTEGER DEFAULT 0, name TEXT NOT NULL, eq_values TEXT NOT NULL, eq_lefts TEXT, eq_rights TEXT, range TEXT NOT NULL);";
    private static final int DATABASE_VERSION = 38;
    public static final String DBNAME = "melon.db";
    private static final String SONG_COLUMNS_DEF_STMT = "is_adult INTEGER, is_free INTEGER, is_hit_song INTEGER, is_holdback INTEGER, is_mv INTEGER, is_title_song INTEGER, is_recomm_song INTEGER, play_time TEXT, song_id TEXT NOT NULL, song_title TEXT NOT NULL";
    private static final String TAG = "MelonDb";
    @Deprecated
    public static final String T_CACHED_LIST_SYNC = "cached_list_sync";
    @Deprecated
    public static final String T_CHART_AGE_LIST = "chart_age_list";
    @Deprecated
    public static final String T_CHART_AGE_TEMP_LIST = "chart_age_temp_list";
    @Deprecated
    public static final String T_CHART_ALBUM_LIST = "chart_album_list";
    @Deprecated
    public static final String T_CHART_NOW_SONG_LIST = "chart_now_song_list";
    @Deprecated
    public static final String T_CHART_POP_SONG_LIST = "chart_weekly_song_list";
    @Deprecated
    public static final String T_CHART_YEAR_SONG_LIST = "chart_year_song_list";
    @Deprecated
    public static final String T_CHART_YEAR_SONG_TEMP_LIST = "chart_year_song_temp_list";
    @Deprecated
    private static final String T_DCF_PLAYING_LOG = "dcf_playback_logs";
    public static final String T_FLOATING_BANNER_POPUP = "floating_banner_popup";
    public static final String T_LAYER_POPUP = "layer_popup";
    @Deprecated
    public static final String T_MUSIC_GENRE_CLASSIC_NEW_ALBUM_LIST = "music_genre_classic_new_album_list";
    @Deprecated
    public static final String T_MUSIC_GENRE_CLASSIC_SUB_GENRE_ALBUM_LIST = "music_genre_classic_sub_genre_album_list";
    @Deprecated
    public static final String T_MUSIC_GENRE_CLASSIC_TOP100_ALBUM_LIST = "music_genre_classic_top100_album_list";
    @Deprecated
    public static final String T_MUSIC_GENRE_NEW_SONG_LIST = "music_genre_new_song_list";
    @Deprecated
    public static final String T_MUSIC_GENRE_PERIOID_LIST = "music_genre_period_list";
    @Deprecated
    public static final String T_MUSIC_GENRE_SUB_GENRE_LIST = "music_genre_sub_genre_list";
    @Deprecated
    public static final String T_MUSIC_GENRE_SUB_GENRE_SONG_LIST = "music_genre_sub_genre_song_list";
    @Deprecated
    public static final String T_MUSIC_GENRE_TOP100_SONG_LIST = "music_genre_top100_song_list";
    @Deprecated
    public static final String T_MUSIC_GENRE_TOP_GENRE_LIST = "music_genre_top_genre_list";
    @Deprecated
    public static final String T_MY_MUSIC_ALBUM = "my_music_album";
    @Deprecated
    public static final String T_MY_MUSIC_FRIEND_OTHERS_ALBUM = "my_music_friend_others_album";
    @Deprecated
    public static final String T_MY_MUSIC_FRIEND_OTHERS_ALBUM_INFO = "my_music_friend_others_album_lnfo";
    @Deprecated
    public static final String T_MY_MUSIC_FRIEND_OTHERS_ALBUM_SONG = "my_music_friend_others_album_song";
    @Deprecated
    public static final String T_MY_MUSIC_INTEREST_ARTIST = "my_music_interest_artist";
    @Deprecated
    public static final String T_MY_MUSIC_LIKE_PLAYLIST = "my_music_list_playlist";
    @Deprecated
    public static final String T_MY_MUSIC_RECOMM_SONG = "my_music_recomm_song";
    @Deprecated
    public static final String T_MY_MUSIC_SONG = "my_music_song";
    @Deprecated
    public static final String T_NEW_MUSIC_ALBUM_LIST = "new_music_album_list";
    @Deprecated
    public static final String T_NEW_MUSIC_GENRE_SONG_LIST = "new_music_genre_song_list";
    @Deprecated
    public static final String T_NEW_MUSIC_SONG_LIST = "new_music_song_list";
    public static final String T_NOTICE_POPUP = "notice_popup";
    @Deprecated
    public static final String T_OTHER_MUSIC_LIKE_PLAYLIST = "other_music_list_playlist";
    public static final String T_PLAYBACK_LOG = "playbacklog";
    public static final String T_PREMIUM_OFFPLAY_LOG = "premium_offplay_log";
    public static final String T_PROMOTION_POPUP = "promotion_popup";
    public static final String T_RESPONSE_CACHE = "response_cache";
    public static final String T_SEARCH_HIST = "search_hist";
    @Deprecated
    public static final String T_SMART_RADIO_GENRE = "smart_radio_genre_year";
    public static final String T_USER_EQUALIZER = "user_equalizer";
    private boolean mIsClosing;

    public MelonDb(Context context0) {
        super(context0, "melon.db", null, 38);
    }

    public long addUserEqualizer(String s, float[] arr_f) {
        SQLiteDatabase sQLiteDatabase0 = this.getDb();
        long v = -1L;
        if(sQLiteDatabase0 == null) {
            LogU.w("MelonDb", "addUserEqualizer() - invalid database");
            return -1L;
        }
        ContentValues contentValues0 = new ContentValues();
        try {
            try {
                sQLiteDatabase0.beginTransaction();
                contentValues0.put("eq_type", 6);
                contentValues0.put("name", s);
                contentValues0.put("eq_values", L.b(arr_f));
                contentValues0.put("range", "");
                v = this.insert("user_equalizer", contentValues0);
                sQLiteDatabase0.setTransactionSuccessful();
                goto label_20;
            }
            catch(Exception exception0) {
            }
            LogU.w("MelonDb", "addUserEqualizer() Exception : " + exception0.toString());
        }
        catch(Throwable throwable0) {
            try {
                sQLiteDatabase0.endTransaction();
            }
            catch(IllegalStateException unused_ex) {
            }
            throw throwable0;
        }
        try {
        label_20:
            sQLiteDatabase0.endTransaction();
        }
        catch(IllegalStateException unused_ex) {
        }
        return v;
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public void close() {
        synchronized(this) {
            this.mIsClosing = true;
            super.close();
            this.mIsClosing = false;
        }
    }

    private void createDbObjects(SQLiteDatabase sQLiteDatabase0) {
        x.v(sQLiteDatabase0, "CREATE TABLE IF NOT EXISTS playbacklog (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, data TEXT NOT NULL,ctype TEXT NOT NULL,cid TEXT NOT NULL,mcode TEXT NOT NULL,lcode TEXT NOT NULL,played_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP);", "CREATE TABLE IF NOT EXISTS premium_offplay_log (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, cid TEXT NOT NULL,ctype TEXT NOT NULL,pstime TEXT NOT NULL,meta_type TEXT NOT NULL,bitrate TEXT NOT NULL,binfo TEXT NOT NULL,free_yn TEXT NOT NULL,memberkey TEXT NOT NULL,played_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP);", "CREATE TABLE IF NOT EXISTS user_equalizer (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, type INTEGER DEFAULT 0, name TEXT NOT NULL, eq_values TEXT NOT NULL, eq_lefts TEXT, eq_rights TEXT, range TEXT NOT NULL);", "CREATE TABLE IF NOT EXISTS search_hist (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, timestamp TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, menu_id TEXT NOT NULL, curr_rank TEXT, past_rank TEXT, rank_gap TEXT, rank_type TEXT, album_id TEXT NOT NULL, album_img_path TEXT, album_name TEXT NOT NULL, artist_id TEXT NOT NULL, artist_name TEXT NOT NULL, ctype TEXT, is_service INTEGER, issue_date TEXT, like_count INTEGER, song_count INTEGER, is_adult INTEGER, is_free INTEGER, is_hit_song INTEGER, is_holdback INTEGER, is_mv INTEGER, is_title_song INTEGER, is_recomm_song INTEGER, play_time TEXT, song_id TEXT NOT NULL, song_title TEXT NOT NULL);");
        x.v(sQLiteDatabase0, "CREATE TABLE IF NOT EXISTS response_cache (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, key TEXT NOT NULL, type INTEGER DEFAULT 0, contents TEXT NOT NULL, has_more INTEGER DEFAULT 0, modified_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP);", "CREATE TABLE IF NOT EXISTS promotion_popup (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, member_key TEXT NOT NULL, id TEXT NOT NULL, query TEXT NOT NULL);", "CREATE TABLE IF NOT EXISTS layer_popup (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, member_key TEXT NOT NULL, BANERSEQ TEXT NOT NULL, BANON TEXT NOT NULL);", "CREATE TABLE IF NOT EXISTS notice_popup (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, MEMBER_KEY TEXT NOT NULL, BANERSEQ TEXT NOT NULL, BANON TEXT NOT NULL);");
        sQLiteDatabase0.execSQL("CREATE TABLE IF NOT EXISTS floating_banner_popup (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, member_key TEXT NOT NULL, BANERSEQ TEXT NOT NULL, BANON TEXT NOT NULL);");
    }

    public int deleteAllResponseCache() {
        SQLiteDatabase sQLiteDatabase0 = this.getDb();
        if(sQLiteDatabase0 == null) {
            LogU.w("MelonDb", "deleteAllResponseCache() invalid database");
            return 0;
        }
        return sQLiteDatabase0.delete("response_cache", null, null);
    }

    public int deleteLikeKeyResponseCache(String s) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("MelonDb", "deleteLikeKeyResponseCache() - invalid key");
            return 0;
        }
        SQLiteDatabase sQLiteDatabase0 = this.getDb();
        if(sQLiteDatabase0 == null) {
            LogU.w("MelonDb", "deleteLikeKeyResponseCache() invalid database");
            return 0;
        }
        LogU.w("MelonDb", "deleteLikeKeyResponseCache() key: " + s);
        return sQLiteDatabase0.delete("response_cache", "key LIKE ?", new String[]{"%" + s + "%"});
    }

    public int deleteResponseCache(int v) {
        SQLiteDatabase sQLiteDatabase0 = this.getDb();
        if(sQLiteDatabase0 == null) {
            LogU.w("MelonDb", "deleteResponseCache() invalid database");
            return 0;
        }
        LogU.d("MelonDb", "deleteResponseCache() id:" + v);
        return sQLiteDatabase0.delete("response_cache", "_id=?", new String[]{String.valueOf(v)});
    }

    public int deleteResponseCache(String s, boolean z) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("MelonDb", "deleteResponseCache() - invalid key");
            return 0;
        }
        SQLiteDatabase sQLiteDatabase0 = this.getDb();
        if(sQLiteDatabase0 == null) {
            LogU.w("MelonDb", "deleteResponseCache() invalid database");
            return 0;
        }
        Z.w("deleteResponseCache() key: ", s, "MelonDb");
        return sQLiteDatabase0.delete("response_cache", "key=?", new String[]{s});
    }

    public int deleteUserEqualizer(int v) {
        SQLiteDatabase sQLiteDatabase0 = this.getDb();
        if(sQLiteDatabase0 == null) {
            LogU.w("MelonDb", "deleteUserEqualizer() - invalid database");
            return 0;
        }
        return sQLiteDatabase0.delete("user_equalizer", "_id=?", new String[]{String.valueOf(v)});
    }

    private void dropAllDbObjects(SQLiteDatabase sQLiteDatabase0) {
        x.v(sQLiteDatabase0, "drop table if exists cached_list_sync", "drop table if exists chart_album_list", "drop table if exists chart_age_list", "drop table if exists chart_age_temp_list");
        x.v(sQLiteDatabase0, "drop table if exists chart_year_song_list", "drop table if exists chart_year_song_temp_list", "drop table if exists chart_now_song_list", "drop table if exists chart_weekly_song_list");
        x.v(sQLiteDatabase0, "drop table if exists new_music_song_list", "drop table if exists new_music_album_list", "drop table if exists new_music_genre_song_list", "drop table if exists music_genre_new_song_list");
        x.v(sQLiteDatabase0, "drop table if exists music_genre_top100_song_list", "drop table if exists music_genre_top_genre_list", "drop table if exists music_genre_sub_genre_list", "drop table if exists music_genre_sub_genre_song_list");
        x.v(sQLiteDatabase0, "drop table if exists music_genre_classic_new_album_list", "drop table if exists music_genre_classic_top100_album_list", "drop table if exists music_genre_classic_sub_genre_album_list", "drop table if exists music_genre_period_list");
        x.v(sQLiteDatabase0, "drop table if exists my_music_song", "drop table if exists my_music_album", "drop table if exists my_music_recomm_song", "drop table if exists my_music_list_playlist");
        x.v(sQLiteDatabase0, "drop table if exists my_music_interest_artist", "drop table if exists my_music_friend_others_album_lnfo", "drop table if exists my_music_friend_others_album", "drop table if exists my_music_friend_others_album_song");
        sQLiteDatabase0.execSQL("drop table if exists other_music_list_playlist");
        sQLiteDatabase0.execSQL("drop table if exists smart_radio_genre_year");
        sQLiteDatabase0.execSQL("drop table if exists dcf_playback_logs");
    }

    public List fetchUserEqualizer() {
        Cursor cursor0 = null;
        if(this.getDb() == null) {
            LogU.w("MelonDb", "fetchUserEqualizer() - invalid database");
            return null;
        }
        List list0 = new ArrayList();
        try {
            cursor0 = this.rawQuery("SELECT * FROM user_equalizer WHERE eq_type=\"5\" OR eq_type=\"6\" ORDER BY _id DESC");
            if(cursor0 != null && cursor0.moveToFirst()) {
                do {
                    K k0 = new K();
                    k0.b = cursor0.getInt(cursor0.getColumnIndexOrThrow("_id"));
                    k0.c = cursor0.getInt(cursor0.getColumnIndexOrThrow("eq_type"));
                    String s = cursor0.getString(cursor0.getColumnIndexOrThrow("name"));
                    q.g(s, "<set-?>");
                    k0.d = s;
                    k0.e = L.a(cursor0.getString(cursor0.getColumnIndexOrThrow("eq_values")));
                    ((ArrayList)list0).add(k0);
                }
                while(cursor0.moveToNext());
            }
        }
        catch(Exception exception0) {
            try {
                LogU.w("MelonDb", "fetchUserEqualizer() - Exception : " + exception0.toString());
                if(cursor0 != null) {
                    goto label_20;
                }
                return list0;
            }
            catch(Throwable throwable0) {
                goto label_23;
            }
        label_20:
            cursor0.close();
            return list0;
        }
        catch(Throwable throwable0) {
        label_23:
            TWR.safeClose$NT(cursor0, throwable0);
            throw throwable0;
        }
        if(cursor0 != null) {
            cursor0.close();
            return list0;
        }
        return list0;
    }

    private SQLiteDatabase getDb() {
        try {
            return this.getWritableDatabase();
        }
        catch(SQLiteException sQLiteException0) {
            LogU.e("MelonDb", "getDb() SQLiteException " + sQLiteException0);
            return null;
        }
        catch(Exception exception0) {
            LogU.e("MelonDb", "getDb() Exception " + exception0);
            return null;
        }
    }

    private long insert(String s, ContentValues contentValues0) {
        SQLiteDatabase sQLiteDatabase0 = this.getDb();
        if(sQLiteDatabase0 != null) {
            try {
                return sQLiteDatabase0.insertOrThrow(s, null, contentValues0);
            }
            catch(SQLiteConstraintException sQLiteConstraintException0) {
                LogU.e("MelonDb", sQLiteConstraintException0.toString());
            }
        }
        return -1L;
    }

    private void insertOrUpdate(String s, String s1, ContentValues contentValues0) {
        synchronized(this) {
            SQLiteDatabase sQLiteDatabase0 = this.getDb();
            if(sQLiteDatabase0 != null) {
                if(sQLiteDatabase0.update(s, contentValues0, s1 + "=?", new String[]{String.valueOf(contentValues0.get(s1))}) > 0) {
                    LogU.d("MelonDb", "--UPDATE : ");
                }
                else {
                    this.insert(s, contentValues0);
                    LogU.d("MelonDb", "--INSERT : ");
                }
            }
        }
    }

    private void insertOrUpdate(String s, String s1, String s2, ContentValues contentValues0) {
        synchronized(this) {
            SQLiteDatabase sQLiteDatabase0 = this.getDb();
            if(sQLiteDatabase0 != null) {
                if(sQLiteDatabase0.update(s, contentValues0, s1 + "=? AND " + s2 + "=?", new String[]{String.valueOf(contentValues0.get(s1)), String.valueOf(contentValues0.get(s2))}) > 0) {
                    LogU.d("MelonDb", "--UPDATE : ");
                }
                else {
                    this.insert(s, contentValues0);
                    LogU.d("MelonDb", "--INSERT : ");
                }
            }
        }
    }

    public int insertResponseCache(String s, int v, String s1, boolean z, boolean z1) {
        synchronized(this) {
            LogU.d("MelonDb", "insertResponseCache() key, type, contents, hasMore, reset");
            int v2 = 0;
            if(TextUtils.isEmpty(s)) {
                LogU.w("MelonDb", "insertResponseCache() - invalid key");
                return 0;
            }
            if(TextUtils.isEmpty(s1)) {
                LogU.w("MelonDb", "insertResponseCache() - invalid contents");
                return 0;
            }
            SQLiteDatabase sQLiteDatabase0 = this.getDb();
            if(sQLiteDatabase0 == null) {
                LogU.w("MelonDb", "insertResponseCache() - invalid database");
                return 0;
            }
            try {
                sQLiteDatabase0.beginTransaction();
                if(z1) {
                    this.deleteResponseCache(s, false);
                }
                ContentValues contentValues0 = new ContentValues();
                contentValues0.put("key", s);
                contentValues0.put("cache_type", v);
                contentValues0.put("has_more", ((int)z));
                contentValues0.put("contents", s1);
                contentValues0.put("timestamp", System.currentTimeMillis());
                if(this.insert("response_cache", contentValues0) != -1L) {
                    v2 = 1;
                }
                if(this.mIsClosing) {
                    LogU.w("MelonDb", "db is closing. stop transaction!");
                    goto label_32;
                }
                goto label_35;
            }
            catch(Exception exception0) {
                goto label_40;
            }
            catch(Throwable throwable0) {
                goto label_42;
            }
            try {
            label_32:
                sQLiteDatabase0.endTransaction();
            }
            catch(IllegalStateException | SQLiteFullException unused_ex) {
            }
            return v2;
            try {
                try {
                label_35:
                    sQLiteDatabase0.setTransactionSuccessful();
                    goto label_45;
                }
                catch(Exception exception0) {
                }
            label_40:
                LogU.w("MelonDb", "insertResponseCache() " + exception0.toString());
                goto label_45;
            }
            catch(Throwable throwable0) {
            }
            try {
            label_42:
                sQLiteDatabase0.endTransaction();
            }
            catch(IllegalStateException | SQLiteFullException unused_ex) {
            }
            throw throwable0;
            try {
            label_45:
                sQLiteDatabase0.endTransaction();
            }
            catch(IllegalStateException | SQLiteFullException unused_ex) {
            }
            LogU.d("MelonDb", "insertResponseCache() - rowsAdded : " + v2);
            return v2;
        }
    }

    public int insertResponseCache(String s, List list0, boolean z) {
        LogU.d("MelonDb", "insertResponseCache() key, values, reset");
        int v = 0;
        if(TextUtils.isEmpty(s)) {
            LogU.w("MelonDb", "insertResponseCache() - invalid key");
            return 0;
        }
        if(list0 != null && !list0.isEmpty()) {
            SQLiteDatabase sQLiteDatabase0 = this.getDb();
            if(sQLiteDatabase0 == null) {
                LogU.w("MelonDb", "insertResponseCache() - invalid database");
                return 0;
            }
            try {
                sQLiteDatabase0.beginTransaction();
                if(z) {
                    this.deleteResponseCache(s, false);
                }
                Iterator iterator0 = list0.iterator();
                while(true) {
                    if(!iterator0.hasNext()) {
                        goto label_23;
                    }
                    Object object0 = iterator0.next();
                    if(this.insert("response_cache", ((ContentValues)object0)) != -1L) {
                        ++v;
                    }
                    if(this.mIsClosing) {
                        LogU.w("MelonDb", "db is closing. stop transaction!");
                        break;
                    }
                }
            }
            catch(Exception exception0) {
                goto label_28;
            }
            catch(Throwable throwable0) {
                goto label_30;
            }
            try {
                sQLiteDatabase0.endTransaction();
            }
            catch(IllegalStateException | SQLiteFullException unused_ex) {
            }
            return v;
            try {
                try {
                label_23:
                    sQLiteDatabase0.setTransactionSuccessful();
                    goto label_32;
                }
                catch(Exception exception0) {
                }
            label_28:
                LogU.w("MelonDb", "insertResponseCache() " + exception0.toString());
                goto label_32;
            }
            catch(Throwable throwable0) {
            }
            try {
            label_30:
                sQLiteDatabase0.endTransaction();
            }
            catch(IllegalStateException | SQLiteFullException unused_ex) {
            }
            throw throwable0;
            try {
            label_32:
                sQLiteDatabase0.endTransaction();
            }
            catch(IllegalStateException | SQLiteFullException unused_ex) {
            }
            Z.r(v, "insertResponseCache() - rowsAdded : ", "MelonDb");
            return v;
        }
        LogU.w("MelonDb", "insertResponseCache() - invalid contents");
        return 0;
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase0) {
        LogU.v("MelonDb", "onCreate");
        this.createDbObjects(sQLiteDatabase0);
    }

    @Override  // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase0, int v, int v1) {
        LogU.i("MelonDb", "Upgrading database from version " + v + " to " + v1);
        switch(v) {
            case 4: {
                this.createDbObjects(sQLiteDatabase0);
                return;
            }
            case 34: {
                break;
            }
            default: {
                this.dropAllDbObjects(sQLiteDatabase0);
                this.createDbObjects(sQLiteDatabase0);
                break;
            }
        }
    }

    public Cursor queryResponseCache(String s) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("MelonDb", "queryResponseCache() - invalid key");
            return null;
        }
        if(this.getDb() == null) {
            LogU.w("MelonDb", "queryResponseCache() - invalid database");
            return null;
        }
        Z.w("queryResponseCache() key : ", s, "MelonDb");
        try {
            Cursor cursor0 = this.rawQuery(String.format("SELECT * FROM %1$s WHERE %2$s=\"%3$s\"", "response_cache", "key", s));
            if(cursor0 != null) {
                cursor0.moveToFirst();
                return cursor0;
            }
        }
        catch(Exception exception0) {
            Z.v(exception0, new StringBuilder("queryResponseCache() - Exception : "), "MelonDb");
        }
        return null;
    }

    public long queryResponseCacheModifiedTime(String s) {
        Cursor cursor0;
        long v = 0L;
        if(TextUtils.isEmpty(s)) {
            LogU.w("MelonDb", "queryResponseCacheModifiedTime() - invalid key");
            return 0L;
        }
        if(this.getDb() == null) {
            LogU.w("MelonDb", "queryResponseCacheModifiedTime() - invalid database");
            return 0L;
        }
        try {
            try {
                cursor0 = null;
                cursor0 = this.rawQuery(String.format("SELECT %1$s FROM %2$s WHERE %3$s=\"%4$s\"", "timestamp", "response_cache", "key", s));
                if(cursor0 != null && cursor0.moveToFirst()) {
                    String s1 = cursor0.getString(cursor0.getColumnIndex("timestamp"));
                    if(!TextUtils.isEmpty(s1)) {
                        v = Long.parseLong(s1);
                    }
                }
                goto label_22;
            }
            catch(Exception exception0) {
            }
            LogU.w("MelonDb", "queryResponseCacheModifiedTime() - Exception : " + exception0.toString());
            if(cursor0 != null) {
                goto label_17;
            }
            return 0L;
        }
        catch(Throwable throwable0) {
            goto label_20;
        }
    label_17:
        cursor0.close();
        return 0L;
    label_20:
        TWR.safeClose$NT(cursor0, throwable0);
        throw throwable0;
    label_22:
        if(cursor0 != null) {
            cursor0.close();
        }
        return v;
    }

    private Cursor rawQuery(String s) {
        SQLiteDatabase sQLiteDatabase0 = this.getDb();
        if(sQLiteDatabase0 == null) {
            return null;
        }
        Z.w("rawQuery::sql = ", s, "MelonDb");
        return sQLiteDatabase0.rawQuery(s, null);
    }

    public void updateOrAddUserEqualizer(int v, String s, float[] arr_f) {
        SQLiteDatabase sQLiteDatabase0 = this.getDb();
        if(sQLiteDatabase0 == null) {
            LogU.w("MelonDb", "addOrUpdateUserEqualizer() - invalid database");
            return;
        }
        ContentValues contentValues0 = new ContentValues();
        try {
            try {
                sQLiteDatabase0.beginTransaction();
                contentValues0.put("eq_type", 6);
                contentValues0.put("name", s);
                contentValues0.put("eq_values", L.b(arr_f));
                contentValues0.put("range", "");
                if(v > 0) {
                    contentValues0.put("_id", v);
                    this.insertOrUpdate("user_equalizer", "_id", contentValues0);
                }
                else {
                    this.insertOrUpdate("user_equalizer", "eq_type", "name", contentValues0);
                }
                sQLiteDatabase0.setTransactionSuccessful();
                goto label_25;
            }
            catch(Exception exception0) {
            }
            LogU.w("MelonDb", "addOrUpdateUserEqualizer() Exception : " + exception0.toString());
        }
        catch(Throwable throwable0) {
            goto label_23;
        }
        try {
            sQLiteDatabase0.endTransaction();
        }
        catch(IllegalStateException unused_ex) {
        }
        return;
        try {
        label_23:
            sQLiteDatabase0.endTransaction();
        }
        catch(IllegalStateException unused_ex) {
        }
        throw throwable0;
        try {
        label_25:
            sQLiteDatabase0.endTransaction();
        }
        catch(IllegalStateException unused_ex) {
        }
    }
}

