package com.iloen.melon.mediastore;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.IntentFilter;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteQueryBuilder;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Binder;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.text.TextUtils;
import androidx.appcompat.app.z;
import com.iloen.melon.drm.AbsDcfController;
import com.iloen.melon.drm.downloadable.DownloadableDcfController;
import com.iloen.melon.utils.FileUtils;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.player.MusicUtils;
import e1.m;
import i9.d;
import i9.e;
import i9.h;
import i9.j;
import i9.k;
import i9.l;
import i9.n;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.text.Collator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import u9.c;
import x9.a;

public class MelonMediaProvider extends ContentProvider {
    public static final String B;
    public static final a D;
    public final HashMap a;
    public final z b;
    public final HashSet c;
    public final Stack d;
    public final Uri e;
    public Handler f;
    public String g;
    public static final String h;
    public static final File i;
    public static final String j;
    public static final String k;
    public static final UriMatcher l;
    public static final Uri m;
    public static final Uri n;
    public static final String[] o;
    public static final HashMap r;
    public static final HashMap w;

    static {
        String s = FileUtils.getSafetyPath(c.c()) + "/";
        MelonMediaProvider.h = s;
        File file0 = new File(c.c(), "db");
        MelonMediaProvider.i = file0;
        String s1 = FileUtils.getSafetyPath(file0) + "/";
        MelonMediaProvider.j = s1 + "melon.db";
        MelonMediaProvider.k = s1 + "meloninternal.db";
        MelonMediaProvider.m = n.a;
        MelonMediaProvider.n = n.b;
        UriMatcher uriMatcher0 = new UriMatcher(-1);
        MelonMediaProvider.l = uriMatcher0;
        uriMatcher0.addURI("com.iloen.melon.provider.melondcf", "patches/fixJbStoragePath", 11000);
        uriMatcher0.addURI("com.iloen.melon.provider.melondcf", "*/audio/media", 100);
        uriMatcher0.addURI("com.iloen.melon.provider.melondcf", "*/audio/media/#", 101);
        uriMatcher0.addURI("com.iloen.melon.provider.melondcf", "*/audio/media/#/genres", 102);
        uriMatcher0.addURI("com.iloen.melon.provider.melondcf", "*/audio/media/#/genres/#", 103);
        uriMatcher0.addURI("com.iloen.melon.provider.melondcf", "*/audio/media/#/playlists", 104);
        uriMatcher0.addURI("com.iloen.melon.provider.melondcf", "*/audio/media/#/playlists/#", 105);
        uriMatcher0.addURI("com.iloen.melon.provider.melondcf", "*/audio/genres", 106);
        uriMatcher0.addURI("com.iloen.melon.provider.melondcf", "*/audio/genres/#", 107);
        uriMatcher0.addURI("com.iloen.melon.provider.melondcf", "*/audio/genres/#/members", 108);
        uriMatcher0.addURI("com.iloen.melon.provider.melondcf", "*/audio/genres/#/members/#", 109);
        uriMatcher0.addURI("com.iloen.melon.provider.melondcf", "*/audio/genres/all/members", 110);
        uriMatcher0.addURI("com.iloen.melon.provider.melondcf", "*/audio/playlists", 130);
        uriMatcher0.addURI("com.iloen.melon.provider.melondcf", "*/audio/playlists/#", 0x83);
        uriMatcher0.addURI("com.iloen.melon.provider.melondcf", "*/audio/playlists/#/members", 0x84);
        uriMatcher0.addURI("com.iloen.melon.provider.melondcf", "*/audio/playlists/#/members/#", 0x85);
        uriMatcher0.addURI("com.iloen.melon.provider.melondcf", "*/audio/playlists/members", 0x87);
        uriMatcher0.addURI("com.iloen.melon.provider.melondcf", "*/audio/play_playlists", 0x86);
        uriMatcher0.addURI("com.iloen.melon.provider.melondcf", "*/audio/artists", 0x9A);
        uriMatcher0.addURI("com.iloen.melon.provider.melondcf", "*/audio/artists/#", 0x9B);
        uriMatcher0.addURI("com.iloen.melon.provider.melondcf", "*/audio/artists/#/albums", 0x9E);
        uriMatcher0.addURI("com.iloen.melon.provider.melondcf", "*/audio/albums", 0x9C);
        uriMatcher0.addURI("com.iloen.melon.provider.melondcf", "*/audio/albums/#", 0x9D);
        uriMatcher0.addURI("com.iloen.melon.provider.melondcf", "*/audio/albumart", 0x9F);
        uriMatcher0.addURI("com.iloen.melon.provider.melondcf", "*/audio/albumart/#", 0xA0);
        uriMatcher0.addURI("com.iloen.melon.provider.melondcf", "*/audio/media/#/albumart", 0xA1);
        uriMatcher0.addURI("com.iloen.melon.provider.melondcf", "*", 301);
        uriMatcher0.addURI("com.iloen.melon.provider.melondcf", null, 300);
        uriMatcher0.addURI("com.iloen.melon.provider.melondcf", "*/media_scanner", 500);
        uriMatcher0.addURI("com.iloen.melon.provider.melondcf", "*/audio/search/fancy", 402);
        uriMatcher0.addURI("com.iloen.melon.provider.melondcf", "*/audio/search/fancy/*", 402);
        uriMatcher0.addURI("com.iloen.melon.provider.melondcf", "*/audio/playstreaming", 9000);
        MelonMediaProvider.o = new String[]{"_id", "mime_type"};
        MelonMediaProvider.r = new HashMap();
        MelonMediaProvider.w = new HashMap();
        MelonMediaProvider.B = s + "albumthumbs";
        MelonMediaProvider.D = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public MelonMediaProvider() {
        this.a = new HashMap();
        this.b = new z(this, 7);
        this.c = new HashSet();
        this.d = new Stack();
        this.e = Uri.parse("content://com.iloen.melon.provider.melondcf/external/audio/albumart");
    }

    public final Uri a(String s) {
        d d0;
        LogU.d("MelonMediaProvider", "attachVolume = " + s);
        if(Binder.getCallingPid() != Process.myPid()) {
            throw new SecurityException("Opening and closing databases not allowed.");
        }
        synchronized(this.a) {
            if(this.a.get(s) == null) {
                if("internal".equals(s)) {
                    d0 = new d(this.getContext(), MelonMediaProvider.k, true);
                }
                else {
                    if(!"external".equals(s)) {
                        throw new IllegalArgumentException("There is no volume named " + s);
                    }
                    d0 = new d(this.getContext(), MelonMediaProvider.j, false);
                }
                this.a.put(s, d0);
                if(!d0.h) {
                    File[] arr_file = new File(Environment.getExternalStorageDirectory(), MelonMediaProvider.B).listFiles();
                    HashSet hashSet0 = new HashSet();
                    for(int v = 0; arr_file != null && v < arr_file.length; ++v) {
                        hashSet0.add(arr_file[v].getPath());
                    }
                    Cursor cursor0 = this.query(h.a, new String[]{"album_art"}, null, null, null);
                    while(cursor0 != null) {
                        try {
                            if(!cursor0.moveToNext()) {
                                break;
                            }
                            hashSet0.remove(cursor0.getString(0));
                        }
                        catch(Throwable throwable1) {
                            cursor0.close();
                            throw throwable1;
                        }
                    }
                    if(cursor0 != null) {
                        cursor0.close();
                    }
                    Iterator iterator0 = hashSet0.iterator();
                    while(true) {
                        if(!iterator0.hasNext()) {
                            break;
                        }
                        Object object0 = iterator0.next();
                        LogU.v("MelonMediaProvider", "deleting obsolete album art " + ((String)object0));
                        new File(((String)object0)).delete();
                    }
                }
                LogU.v("MelonMediaProvider", "Attached volume: " + s);
                return Uri.parse(("content://com.iloen.melon.provider.melondcf/" + s));
            }
            return Uri.parse(("content://com.iloen.melon.provider.melondcf/" + s));
        }
        LogU.v("MelonMediaProvider", "Attached volume: " + s);
        return Uri.parse(("content://com.iloen.melon.provider.melondcf/" + s));
    }

    public final void b(Uri uri0) {
        if(Binder.getCallingPid() != Process.myPid()) {
            throw new SecurityException("Opening and closing databases not allowed.");
        }
        String s = (String)uri0.getPathSegments().get(0);
        if("internal".equals(s)) {
            throw new UnsupportedOperationException("Deleting the internal volume is not allowed");
        }
        if(!"external".equals(s)) {
            throw new IllegalArgumentException("There is no volume named " + s);
        }
        synchronized(this.a) {
            d d0 = (d)this.a.get(s);
            if(d0 == null) {
                return;
            }
            try {
                new File(d0.a().getPath()).setLastModified(System.currentTimeMillis());
            }
            catch(Exception exception0) {
                LogU.e("MelonMediaProvider", "Can\'t touch database file", exception0);
            }
            this.a.remove(s);
            synchronized(d0) {
                if(d0.e) {
                    throw new IllegalStateException("Closed during initialization");
                }
                if(d0.d != null && d0.d.isOpen()) {
                    d0.d.close();
                    d0.d = null;
                }
            }
        }
        this.n(uri0);
        LogU.v("MelonMediaProvider", "Detached volume: " + s);
    }

    public static ContentValues c(String s, ContentValues contentValues0) {
        String s1 = contentValues0.getAsString("_data");
        if(TextUtils.isEmpty(s1)) {
            Long long0 = contentValues0.getAsLong("album_id");
            s1 = long0 == null ? MelonMediaProvider.e(-1L, s) : MelonMediaProvider.e(((long)long0), s);
            ContentValues contentValues1 = new ContentValues(contentValues0);
            contentValues1.put("_data", s1);
            contentValues0 = contentValues1;
        }
        if(!MelonMediaProvider.d(s1)) {
            throw new IllegalStateException("Unable to create new file: " + s1);
        }
        return contentValues0;
    }

    public static boolean d(String s) {
        File file0 = new File(s);
        if(file0.exists()) {
            return true;
        }
        int v = s.indexOf(0x2F, 1);
        if(v < 1 || !new File(s.substring(0, v)).exists()) {
            return false;
        }
        file0.getParentFile().mkdirs();
        try {
            return file0.createNewFile();
        }
        catch(IOException iOException0) {
            LogU.e("MelonMediaProvider", "File creation failed", iOException0);
            return false;
        }
    }

    @Override  // android.content.ContentProvider
    public final int delete(Uri uri0, String s, String[] arr_s) {
        int v2;
        LogU.d("MelonMediaProvider", "delete " + uri0 + ", " + s);
        int v = MelonMediaProvider.l.match(uri0);
        if(v == 500) {
            if(this.g == null) {
                return 0;
            }
            this.g = null;
            return 1;
        }
        if(v != 301) {
            d d0 = this.g(v);
            if(d0 != null) {
                SQLiteDatabase sQLiteDatabase0 = d0.b();
                if(sQLiteDatabase0 == null) {
                    return 0;
                }
                a a0 = MelonMediaProvider.D;
                synchronized(a0) {
                    MelonMediaProvider.i(uri0, v, s, a0);
                    switch(v) {
                        case 100: 
                        case 101: {
                            v2 = sQLiteDatabase0.delete("audio_meta", ((String)a0.b), arr_s);
                            break;
                        }
                        case 9000: {
                            v2 = sQLiteDatabase0.delete("playstreaming", ((String)a0.b), null);
                            break;
                        }
                        default: {
                            v2 = sQLiteDatabase0.delete(((String)a0.a), ((String)a0.b), arr_s);
                            if(((String)a0.a).equals("audio_playlists_map")) {
                                this.getContext().getContentResolver().notifyChange(uri0, null);
                                return v2;
                            }
                        }
                    }
                    this.n(uri0);
                    return v2;
                }
            }
            throw new UnsupportedOperationException("Unknown URI: " + uri0);
        }
        this.b(uri0);
        return 1;
    }

    // 去混淆评级： 低(20)
    public static String e(long v, String s) {
        return Long.compare(v, 0L) < 0 ? s + "/" + "1757129489582" + "" : s + "/" + (v + "") + "";
    }

    public final Uri f(SQLiteDatabase sQLiteDatabase0, long v, Uri uri0) {
        Uri uri2;
        Throwable throwable1;
        Cursor cursor0;
        Uri uri1 = null;
        if(uri0 != null) {
            try {
                cursor0 = this.query(uri0, new String[]{"_data"}, null, null, null);
            }
            catch(Throwable throwable0) {
                throwable1 = throwable0;
                goto label_18;
            }
            try {
                if(cursor0.moveToFirst()) {
                    if(MelonMediaProvider.d(cursor0.getString(0))) {
                        uri1 = uri0;
                    }
                    uri2 = uri1;
                    uri1 = uri0;
                }
                else {
                    uri2 = null;
                }
                goto label_21;
            }
            catch(Throwable throwable2) {
                throwable1 = throwable2;
                uri1 = cursor0;
            }
        label_18:
            if(uri1 != null) {
                ((Cursor)uri1).close();
            }
            throw throwable1;
        label_21:
            cursor0.close();
            uri0 = uri1;
            uri1 = uri2;
        }
        if(uri0 == null) {
            ContentValues contentValues0 = new ContentValues();
            contentValues0.put("album_id", v);
            try {
                long v1 = sQLiteDatabase0.insert("album_art", "_data", MelonMediaProvider.c(MelonMediaProvider.B, contentValues0));
                if(v1 > 0L) {
                    return ContentUris.withAppendedId(MelonMediaProvider.n, v1);
                }
            }
            catch(IllegalStateException unused_ex) {
                LogU.e("MelonMediaProvider", "error creating album thumb file");
            }
        }
        return uri1;
    }

    public final d g(int v) {
        synchronized(this.a) {
            if(v >= 130 && v <= 0x87 || v == 9000) {
                return (d)this.a.get("internal");
            }
        }
        return (d)this.a.get("external");
    }

    @Override  // android.content.ContentProvider
    public final String getType(Uri uri0) {
        switch(MelonMediaProvider.l.match(uri0)) {
            case 102: 
            case 106: {
                return "vnd.com.iloen.melon.cursor.dir/genre";
            }
            case 103: 
            case 107: {
                return "vnd.com.iloen.melon.cursor.item/genre";
            }
            case 104: 
            case 130: {
                return "vnd.com.iloen.melon.cursor.dir/playlist";
            }
            case 105: 
            case 0x83: {
                return "vnd.com.iloen.melon.cursor.item/playlist";
            }
            case 100: 
            case 108: 
            case 0x84: {
                return "vnd.com.iloen.melon.cursor.dir/audio";
            }
            case 101: 
            case 109: 
            case 0x85: {
                try(Cursor cursor0 = this.query(uri0, MelonMediaProvider.o, null, null, null)) {
                    if(cursor0 != null && cursor0.getCount() == 1) {
                        cursor0.moveToFirst();
                        String s = cursor0.getString(1);
                        cursor0.deactivate();
                        return s;
                    }
                }
                break;
            }
            case 0xA0: {
                return "image/jpeg";
            }
            case 9000: {
                return "vnd.com.iloen.melon.cursor.dir/PlayStreaming";
            }
        }
        throw new IllegalStateException("Unknown URL");
    }

    public final long h(SQLiteDatabase sQLiteDatabase0, String s, String s1, String s2, String s3, String s4, String s5, int v, String s6, HashMap hashMap0, Uri uri0) {
        long v2;
        long v1 = -1L;
        if(s3 != null && s3.length() != 0) {
            String s7 = m.w(s3);
            if(s7 != null) {
                boolean z = s.equals("albums");
                boolean z1 = "<unknown>".equals(s3);
                if(z) {
                    s7 = s7 + v;
                    if(z1) {
                        s7 = s7 + s6;
                    }
                }
                try(Cursor cursor0 = sQLiteDatabase0.query(s, null, s1 + "=?", new String[]{s7}, null, null, null)) {
                    try {
                        switch(cursor0.getCount()) {
                            case 0: {
                                ContentValues contentValues0 = new ContentValues();
                                contentValues0.put(s1, s7);
                                contentValues0.put(s2, s3);
                                v2 = sQLiteDatabase0.insert(s, "duration", contentValues0);
                                if(s5 != null && z && !z1) {
                                    this.l(sQLiteDatabase0, s5, v2);
                                }
                                if(v2 > 0L) {
                                    this.n(Uri.parse(("content://com.iloen.melon.provider.melondcf/" + uri0.toString().substring(19, 27) + "/audio/" + s + "/" + v2)));
                                }
                                break;
                            }
                            case 1: {
                                cursor0.moveToFirst();
                                v2 = cursor0.getLong(0);
                                String s8 = cursor0.getString(2);
                                String s9 = MelonMediaProvider.k(s3, s8);
                                if(!s9.equals(s8)) {
                                    ContentValues contentValues1 = new ContentValues();
                                    contentValues1.put(s2, s9);
                                    sQLiteDatabase0.update(s, contentValues1, "rowid=" + Integer.toString(((int)v2)), null);
                                    this.n(Uri.parse(("content://com.iloen.melon.provider.melondcf/" + uri0.toString().substring(19, 27) + "/audio/" + s + "/" + v2)));
                                }
                                break;
                            }
                            default: {
                                LogU.e("MelonMediaProvider", "Multiple entries in table " + s + " for key " + s7);
                                goto label_52;
                            }
                        }
                        v1 = v2;
                        goto label_52;
                    }
                    catch(Exception exception0) {
                    }
                    LogU.e("MelonMediaProvider", exception0.toString());
                    exception0.printStackTrace();
                }
                return cursor0 != null ? -1L : -1L;
            label_52:
                if(hashMap0 != null && !z1) {
                    hashMap0.put(s4, v1);
                }
                return v1;
            }
        }
        return -1L;
    }

    public static void i(Uri uri0, int v, String s, a a0) {
        String s1;
        switch(v) {
            case 100: {
                a0.a = "audio";
                s1 = null;
                break;
            }
            case 101: {
                a0.a = "audio";
                s1 = "_id=" + ((String)uri0.getPathSegments().get(3));
                break;
            }
            case 102: {
                a0.a = "audio_genres";
                s1 = "audio_id=" + ((String)uri0.getPathSegments().get(3));
                break;
            }
            case 103: {
                a0.a = "audio_genres";
                s1 = "audio_id=" + ((String)uri0.getPathSegments().get(3)) + " AND genre_id=" + ((String)uri0.getPathSegments().get(5));
                break;
            }
            case 104: {
                a0.a = "audio_playlists";
                s1 = "audio_id=" + ((String)uri0.getPathSegments().get(3));
                break;
            }
            case 105: {
                a0.a = "audio_playlists";
                s1 = "audio_id=" + ((String)uri0.getPathSegments().get(3)) + " AND playlists_id=" + ((String)uri0.getPathSegments().get(5));
                break;
            }
            case 106: {
                a0.a = "audio_genres";
                s1 = null;
                break;
            }
            case 107: {
                a0.a = "audio_genres";
                s1 = "_id=" + ((String)uri0.getPathSegments().get(3));
                break;
            }
            case 108: {
                a0.a = "audio_genres";
                s1 = "genre_id=" + ((String)uri0.getPathSegments().get(3));
                break;
            }
            case 109: {
                a0.a = "audio_genres";
                s1 = "genre_id=" + ((String)uri0.getPathSegments().get(3)) + " AND audio_id =" + ((String)uri0.getPathSegments().get(5));
                break;
            }
            case 130: {
                a0.a = "audio_playlists";
                s1 = null;
                break;
            }
            case 0x83: {
                a0.a = "audio_playlists";
                s1 = "_id=" + ((String)uri0.getPathSegments().get(3));
                break;
            }
            case 0x84: {
                a0.a = "audio_playlists_map";
                s1 = "playlist_id=" + ((String)uri0.getPathSegments().get(3));
                break;
            }
            case 0x85: {
                a0.a = "audio_playlists_map";
                s1 = "playlist_id=" + ((String)uri0.getPathSegments().get(3)) + " AND _id=" + ((String)uri0.getPathSegments().get(5));
                break;
            }
            case 0x86: {
                a0.a = "audio_play_playlists_map";
                s1 = null;
                break;
            }
            case 0x87: {
                a0.a = "audio_playlists_map";
                s1 = null;
                break;
            }
            case 0xA0: {
                a0.a = "album_art";
                s1 = "album_id=" + ((String)uri0.getPathSegments().get(3));
                break;
            }
            case 9000: {
                a0.a = "playstreaming";
                s1 = null;
                break;
            }
            default: {
                throw new UnsupportedOperationException("Unknown or unsupported URL: " + uri0.toString());
            }
        }
        if(!TextUtils.isEmpty(s)) {
            if(!TextUtils.isEmpty(s1)) {
                a0.b = s1 + " AND (" + s + ")";
                return;
            }
            a0.b = s;
            return;
        }
        a0.b = s1;
    }

    @Override  // android.content.ContentProvider
    public final Uri insert(Uri uri0, ContentValues contentValues0) {
        HashMap hashMap2;
        long v10;
        ContentValues contentValues5;
        long v9;
        Long long2;
        int v6;
        int v8;
        ContentValues contentValues4;
        long v5;
        SQLiteDatabase sQLiteDatabase1;
        Uri uri1;
        int v = MelonMediaProvider.l.match(uri0);
        if(v == 500) {
            this.g = contentValues0.getAsString("volume");
            uri1 = Uri.parse("content://com.iloen.melon.provider.melondcf/none/media_scanner");
        }
        else {
            d d0 = this.g(v);
            Uri uri2 = null;
            if(d0 != null || v == 300) {
                SQLiteDatabase sQLiteDatabase0 = v == 300 ? null : d0.b();
                if(contentValues0 == null) {
                    contentValues0 = new ContentValues();
                }
                switch(v) {
                    case 100: {
                        if(sQLiteDatabase0 == null) {
                            uri1 = null;
                        }
                        else {
                            ContentValues contentValues3 = new ContentValues(contentValues0);
                            contentValues3.remove("album_artist");
                            Object object0 = contentValues3.get("artist");
                            String s = object0 == null ? "" : object0.toString();
                            contentValues3.remove("artist");
                            HashMap hashMap0 = d0.i;
                            String s1 = contentValues3.getAsString("_data");
                            synchronized(hashMap0) {
                                Long long1 = (Long)hashMap0.get(s);
                                if(long1 == null) {
                                    sQLiteDatabase1 = sQLiteDatabase0;
                                    v5 = this.h(sQLiteDatabase1, "artists", "artist_key", "artist", s, s, s1, 0, null, hashMap0, uri0);
                                    contentValues4 = contentValues3;
                                }
                                else {
                                    contentValues4 = contentValues3;
                                    sQLiteDatabase1 = sQLiteDatabase0;
                                    v5 = (long)long1;
                                }
                            }
                            Object object1 = contentValues4.get("album");
                            String s2 = object1 == null ? "" : object1.toString();
                            contentValues4.remove("album");
                            HashMap hashMap1 = d0.j;
                            __monitor_enter(hashMap1);
                            try {
                                if(TextUtils.isEmpty(s)) {
                                    int v7 = s1.lastIndexOf(0x2F);
                                    try {
                                        v6 = s1.substring(v7 + 1, s1.indexOf(45)).hashCode();
                                    }
                                    catch(IndexOutOfBoundsException unused_ex) {
                                        v8 = 0;
                                        goto label_84;
                                    }
                                }
                                else {
                                    v6 = s.hashCode();
                                }
                                v8 = v6;
                            label_84:
                                String s3 = s2 + v8;
                                long2 = (Long)hashMap1.get(s3);
                                if(long2 == null) {
                                    v9 = v5;
                                    contentValues5 = contentValues4;
                                    v10 = this.h(sQLiteDatabase1, "albums", "album_key", "album", s2, s3, s1, v8, s, hashMap1, uri0);
                                    hashMap2 = hashMap1;
                                }
                                else {
                                    goto label_95;
                                }
                                goto label_99;
                            }
                            catch(Throwable throwable0) {
                                hashMap2 = hashMap1;
                                goto label_102;
                            }
                            try {
                            label_95:
                                contentValues5 = contentValues4;
                                v9 = v5;
                                hashMap2 = hashMap1;
                                v10 = (long)long2;
                            label_99:
                                __monitor_exit(hashMap2);
                                goto label_104;
                            label_102:
                                __monitor_exit(hashMap2);
                            }
                            catch(Throwable throwable0) {
                                goto label_102;
                            }
                            throw throwable0;
                        label_104:
                            contentValues5.put("artist_id", Integer.toString(((int)v9)));
                            contentValues5.put("album_id", Integer.toString(((int)v10)));
                            String s4 = contentValues5.getAsString("title");
                            String s5 = s4 == null ? "" : s4.toString();
                            contentValues5.put("title_key", m.w(s5));
                            contentValues5.remove("title");
                            contentValues5.put("title", s5.trim());
                            String s6 = contentValues5.getAsString("_data");
                            String s7 = s6 == null ? "" : s6.toString();
                            int v11 = s7.lastIndexOf(0x2F);
                            if(v11 >= 0) {
                                s7 = s7.substring(v11 + 1);
                            }
                            contentValues5.put("_display_name", s7);
                            contentValues5.put("date_added", ((long)(System.currentTimeMillis() / 1000L)));
                            long v12 = sQLiteDatabase1.insert("audio_meta", "duration", contentValues5);
                            if(v12 > 0L) {
                                uri2 = ContentUris.withAppendedId(k.a(((String)uri0.getPathSegments().get(0))), v12);
                            }
                            uri1 = uri2;
                        }
                        break;
                    }
                    case 102: {
                        if(sQLiteDatabase0 == null) {
                            uri1 = null;
                        }
                        else {
                            Long long3 = Long.parseLong(((String)uri0.getPathSegments().get(2)));
                            ContentValues contentValues6 = new ContentValues(contentValues0);
                            contentValues6.put("audio_id", long3);
                            long v13 = sQLiteDatabase0.insert("audio_genres_map", "genre_id", contentValues6);
                            uri1 = v13 > 0L ? ContentUris.withAppendedId(uri0, v13) : null;
                        }
                        break;
                    }
                    case 104: {
                        if(sQLiteDatabase0 == null) {
                            uri1 = null;
                        }
                        else {
                            Long long4 = Long.parseLong(((String)uri0.getPathSegments().get(2)));
                            ContentValues contentValues7 = new ContentValues(contentValues0);
                            contentValues7.put("_data", long4);
                            long v14 = sQLiteDatabase0.insert("audio_playlists_map", "playlist_id", contentValues7);
                            uri1 = v14 > 0L ? ContentUris.withAppendedId(uri0, v14) : null;
                        }
                        break;
                    }
                    case 106: {
                        if(sQLiteDatabase0 == null) {
                            uri1 = null;
                        }
                        else {
                            long v15 = sQLiteDatabase0.insert("audio_genres", "audio_id", contentValues0);
                            uri1 = v15 > 0L ? ContentUris.withAppendedId(j.a(((String)uri0.getPathSegments().get(0))), v15) : null;
                        }
                        break;
                    }
                    case 108: {
                        if(sQLiteDatabase0 == null) {
                            uri1 = null;
                        }
                        else {
                            Long long5 = Long.parseLong(((String)uri0.getPathSegments().get(3)));
                            ContentValues contentValues8 = new ContentValues(contentValues0);
                            contentValues8.put("genre_id", long5);
                            String[] arr_s = {((Long)contentValues8.get("audio_id")) + ""};
                            Cursor cursor0 = sQLiteDatabase0.query("audio_genres_map", null, "audio_id=?", arr_s, null, null, null);
                            if(cursor0 != null && cursor0.getCount() > 0) {
                                sQLiteDatabase0.delete("audio_genres_map", "audio_id=?", arr_s);
                            }
                            if(cursor0 != null) {
                                cursor0.close();
                            }
                            long v16 = sQLiteDatabase0.insert("audio_genres_map", "genre_id", contentValues8);
                            uri1 = v16 > 0L ? ContentUris.withAppendedId(uri0, v16) : null;
                        }
                        break;
                    }
                    case 0x86: {
                        if(sQLiteDatabase0 != null) {
                            ContentValues contentValues9 = new ContentValues(contentValues0);
                            String s8 = StringUtils.replacePathString(((String)contentValues9.get("_data")));
                            Cursor cursor1 = sQLiteDatabase0.query("audio_play_playlists_map", new String[]{"play_count"}, "_data=?", new String[]{s8}, null, null, null);
                            if(cursor1 == null || cursor1.getCount() == 0) {
                                contentValues9.put("play_count", 1);
                                if(cursor1 != null) {
                                    cursor1.close();
                                }
                                sQLiteDatabase0.insert("audio_play_playlists_map", "_data", contentValues9);
                            }
                            else {
                                cursor1.moveToFirst();
                                contentValues9.put("play_count", ((int)(cursor1.getInt(0) + 1)));
                                cursor1.close();
                                sQLiteDatabase0.update("audio_play_playlists_map", contentValues9, "_data=?", new String[]{s8});
                            }
                        }
                        uri1 = null;
                        break;
                    }
                    case 0x9F: {
                        if(sQLiteDatabase0 == null) {
                            uri1 = null;
                        }
                        else {
                            if(d0.h) {
                                throw new UnsupportedOperationException("no internal album art allowed");
                            }
                            try {
                                contentValues0 = MelonMediaProvider.c(MelonMediaProvider.B, contentValues0);
                            }
                            catch(IllegalStateException unused_ex) {
                            }
                            long v17 = sQLiteDatabase0.insert("album_art", "_data", contentValues0);
                            if(v17 > 0L) {
                                uri2 = ContentUris.withAppendedId(uri0, v17);
                            }
                            uri1 = uri2;
                            break;
                        }
                        break;
                    }
                    case 300: {
                        uri1 = this.a(contentValues0.getAsString("name"));
                        break;
                    }
                    default: {
                        if(v != 9000) {
                            switch(v) {
                                case 130: {
                                    if(sQLiteDatabase0 == null) {
                                        uri1 = null;
                                    }
                                    else {
                                        ContentValues contentValues1 = new ContentValues(contentValues0);
                                        contentValues1.put("date_added", ((long)(System.currentTimeMillis() / 1000L)));
                                        long v1 = sQLiteDatabase0.insert("audio_playlists", "name", contentValues1);
                                        if(v1 > 0L) {
                                            uri1 = ContentUris.withAppendedId(l.a(((String)uri0.getPathSegments().get(0))), v1);
                                        }
                                        else {
                                            uri1 = null;
                                            break;
                                        }
                                    }
                                    break;
                                }
                                case 0x83: 
                                case 0x84: {
                                    if(sQLiteDatabase0 == null) {
                                        uri1 = null;
                                    }
                                    else {
                                        Long long0 = Long.parseLong(((String)uri0.getPathSegments().get(3)));
                                        ContentValues contentValues2 = new ContentValues(contentValues0);
                                        contentValues2.put("playlist_id", long0);
                                        long v2 = sQLiteDatabase0.insert("audio_playlists_map", "playlist_id", contentValues2);
                                        uri1 = v2 > 0L ? ContentUris.withAppendedId(uri0, v2) : null;
                                    }
                                    break;
                                }
                                default: {
                                    throw new UnsupportedOperationException("Invalid URI " + uri0);
                                }
                            }
                        }
                        else if(sQLiteDatabase0 == null) {
                            uri1 = null;
                        }
                        else {
                            long v3 = sQLiteDatabase0.insert("playstreaming", null, contentValues0);
                            uri1 = v3 > 0L ? ContentUris.withAppendedId(uri0, v3) : null;
                        }
                    }
                }
            }
            else {
                LogU.e("MelonMediaProvider", "Something Wrong! - database is null, uri: " + uri0);
                uri1 = null;
            }
        }
        if(uri1 != null) {
            if(MelonMediaProvider.l.match(uri0) == 130) {
                this.n(uri1);
                LogU.d("MelonMediaProvider", "insert uri audio playlist call");
                return uri1;
            }
            this.n(uri0);
        }
        return uri1;
    }

    public final void j() {
        LogU.d("MelonActivityManager", "MelonMediaProvider onCreate");
        MelonMediaProvider.r.put("_id", "audio.album_id AS _id");
        MelonMediaProvider.r.put("album", "album");
        MelonMediaProvider.r.put("album_key", "album_key");
        MelonMediaProvider.r.put("minyear", "MIN(year) AS minyear");
        MelonMediaProvider.r.put("maxyear", "MAX(year) AS maxyear");
        MelonMediaProvider.r.put("artist", "artist");
        MelonMediaProvider.r.put("artist_id", "artist");
        MelonMediaProvider.r.put("artist_key", "artist_key");
        MelonMediaProvider.r.put("numsongs", "count(*) AS numsongs");
        MelonMediaProvider.r.put("album_art", "album_art._data AS album_art");
        File file0 = new File(MelonMediaProvider.B);
        if(!file0.exists()) {
            file0.mkdirs();
        }
        File file1 = MelonMediaProvider.i;
        if(!file1.exists()) {
            file1.mkdirs();
        }
        this.a("internal");
        IntentFilter intentFilter0 = new IntentFilter("android.intent.action.MEDIA_EJECT");
        intentFilter0.addDataScheme("file");
        this.getContext().registerReceiver(this.b, intentFilter0, "com.iloen.melon.permission.SIG_PERMISSION", null);
        String s = Environment.getExternalStorageState();
        if(!"mounted".equals(s) && !"mounted_ro".equals(s)) {
            return;
        }
        this.a("external");
        HandlerThread handlerThread0 = new HandlerThread("thumbs thread", 10);
        handlerThread0.start();
        this.f = new i9.c(this, handlerThread0.getLooper(), 1);
    }

    // 去混淆评级： 低(20)
    public static String k(String s, String s1) {
        if(s.length() <= s1.length() && s.toLowerCase().compareTo(s1.toLowerCase()) <= 0) {
            s = s1;
        }
        return s.endsWith(", the") || s.endsWith(",the") || s.endsWith(", an") || s.endsWith(",an") || s.endsWith(", a") || s.endsWith(",a") ? s.substring(s.lastIndexOf(44) + 1).trim() + " " + s.substring(0, s.lastIndexOf(44)) : s;
    }

    public final void l(SQLiteDatabase sQLiteDatabase0, String s, long v) {
        synchronized(this.c) {
            if(this.c.contains(v)) {
                return;
            }
            this.c.add(v);
        }
        e e0 = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
        e0.a = sQLiteDatabase0;
        e0.b = s;
        e0.c = v;
        e0.d = ContentUris.withAppendedId(this.e, v);
        synchronized(this.d) {
            this.d.push(e0);
        }
        Handler handler0 = this.f;
        if(handler0 != null) {
            handler0.obtainMessage(1).sendToTarget();
        }
    }

    public final ParcelFileDescriptor m(e e0) {
        ParcelFileDescriptor parcelFileDescriptor0;
        Bitmap.Config bitmap$Config0;
        Bitmap bitmap0;
        boolean z;
        byte[] arr_b;
        synchronized(this) {
            if(e0 == null) {
                LogU.e("MelonMediaProvider", "makeThumbInternal - thumbdata is null");
                return null;
            }
            Context context0 = this.getContext();
            AbsDcfController absDcfController0 = R8.m.a(context0, R8.m.a);
            try {
                if(absDcfController0 instanceof DownloadableDcfController) {
                    String s = e0.b;
                    arr_b = s == null ? null : ((DownloadableDcfController)absDcfController0).i(s);
                }
                else {
                    arr_b = null;
                }
            }
            catch(Throwable throwable0) {
                R8.m.b(context0);
                throw throwable0;
            }
            R8.m.b(context0);
            if(arr_b == null) {
                LogU.w("MelonMediaProvider", "thumb image buffer is null");
                return null;
            }
            try {
                z = true;
                BitmapFactory.Options bitmapFactory$Options0 = new BitmapFactory.Options();
                bitmapFactory$Options0.inJustDecodeBounds = true;
                bitmapFactory$Options0.inSampleSize = 1;
                BitmapFactory.decodeByteArray(arr_b, 0, arr_b.length, bitmapFactory$Options0);
                if(bitmapFactory$Options0.inSampleSize == 1) {
                    bitmap0 = null;
                    z = false;
                }
                else {
                    bitmapFactory$Options0.inJustDecodeBounds = false;
                    bitmap$Config0 = Bitmap.Config.RGB_565;
                    bitmapFactory$Options0.inPreferredConfig = bitmap$Config0;
                    bitmap0 = BitmapFactory.decodeByteArray(arr_b, 0, arr_b.length, bitmapFactory$Options0);
                    goto label_45;
                }
                goto label_54;
            }
            catch(Exception exception0) {
                bitmap0 = null;
                goto label_53;
            }
        label_45:
            if(bitmap0 != null) {
                try {
                    if(bitmap0.getConfig() == null) {
                        Bitmap bitmap1 = bitmap0.copy(bitmap$Config0, false);
                        if(bitmap1 != null && bitmap1 != bitmap0) {
                            bitmap0.recycle();
                            bitmap0 = bitmap1;
                        }
                    }
                    goto label_54;
                }
                catch(Exception exception0) {
                }
            label_53:
                LogU.e("MelonMediaProvider", "error on create bitmap from bytearray: " + exception0.toString());
            }
        label_54:
            if(z && bitmap0 == null) {
                return null;
            }
            SQLiteDatabase sQLiteDatabase0 = e0.a;
            sQLiteDatabase0.beginTransaction();
            try {
                try {
                    Uri uri0 = this.f(sQLiteDatabase0, e0.c, e0.d);
                    if(uri0 == null) {
                        goto label_95;
                    }
                    this.p(z, uri0, arr_b, bitmap0);
                    this.n(MelonMediaProvider.m);
                    parcelFileDescriptor0 = this.openFileHelper(uri0, "r");
                    sQLiteDatabase0.setTransactionSuccessful();
                    goto label_90;
                }
                catch(FileNotFoundException fileNotFoundException0) {
                }
                catch(UnsupportedOperationException unsupportedOperationException0) {
                    goto label_73;
                }
                catch(Exception exception1) {
                    goto label_79;
                }
                LogU.e("MelonMediaProvider", fileNotFoundException0.toString());
            }
            catch(Throwable throwable1) {
                goto label_85;
            }
            sQLiteDatabase0.endTransaction();
            if(bitmap0 != null) {
                bitmap0.recycle();
                return null;
                try {
                label_73:
                    LogU.e("MelonMediaProvider", unsupportedOperationException0.toString());
                }
                catch(Throwable throwable1) {
                    goto label_85;
                }
                sQLiteDatabase0.endTransaction();
                if(bitmap0 != null) {
                    bitmap0.recycle();
                    return null;
                    try {
                    label_79:
                        LogU.e("MelonMediaProvider", exception1.toString());
                    }
                    catch(Throwable throwable1) {
                        goto label_85;
                    }
                    sQLiteDatabase0.endTransaction();
                    if(bitmap0 != null) {
                        bitmap0.recycle();
                        return null;
                    label_85:
                        sQLiteDatabase0.endTransaction();
                        if(bitmap0 != null) {
                            bitmap0.recycle();
                        }
                        throw throwable1;
                    label_90:
                        sQLiteDatabase0.endTransaction();
                        if(bitmap0 != null) {
                            bitmap0.recycle();
                        }
                        return parcelFileDescriptor0;
                    label_95:
                        sQLiteDatabase0.endTransaction();
                        if(bitmap0 != null) {
                            bitmap0.recycle();
                        }
                    }
                }
            }
            return null;
        }
    }

    public final void n(Uri uri0) {
        Uri uri1 = Uri.parse(uri0.toString().replaceAll("com.iloen.melon.provider.melondcf", "media"));
        this.getContext().getContentResolver().notifyChange(uri1, null);
        LogU.d("NOTIFY", "notify = " + uri1);
    }

    public final void o() {
        try {
            this.b(Uri.parse("content://com.iloen.melon.provider.melondcf/external"));
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
        }
        try {
            this.b(Uri.parse("content://com.iloen.melon.provider.melondcf/internal"));
        }
        catch(Exception exception1) {
            exception1.printStackTrace();
        }
    }

    @Override  // android.content.ContentProvider
    public final boolean onCreate() {
        LogU.d("MelonActivityManager", "MelonMediaProvider onCreate");
        if(Environment.isExternalStorageLegacy()) {
            MelonMediaProvider.r.put("_id", "audio.album_id AS _id");
            MelonMediaProvider.r.put("album", "album");
            MelonMediaProvider.r.put("album_key", "album_key");
            MelonMediaProvider.r.put("minyear", "MIN(year) AS minyear");
            MelonMediaProvider.r.put("maxyear", "MAX(year) AS maxyear");
            MelonMediaProvider.r.put("artist", "artist");
            MelonMediaProvider.r.put("artist_id", "artist");
            MelonMediaProvider.r.put("artist_key", "artist_key");
            MelonMediaProvider.r.put("numsongs", "count(*) AS numsongs");
            MelonMediaProvider.r.put("album_art", "album_art._data AS album_art");
            File file0 = new File(MelonMediaProvider.B);
            if(!file0.exists()) {
                file0.mkdirs();
            }
            File file1 = MelonMediaProvider.i;
            if(!file1.exists()) {
                file1.mkdirs();
            }
            this.a("internal");
            IntentFilter intentFilter0 = new IntentFilter("android.intent.action.MEDIA_EJECT");
            intentFilter0.addDataScheme("file");
            this.getContext().registerReceiver(this.b, intentFilter0, "com.iloen.melon.permission.SIG_PERMISSION", null);
            String s = Environment.getExternalStorageState();
            if("mounted".equals(s) || "mounted_ro".equals(s)) {
                this.a("external");
                HandlerThread handlerThread0 = new HandlerThread("thumbs thread", 10);
                handlerThread0.start();
                this.f = new i9.c(this, handlerThread0.getLooper(), 0);
                return true;
            }
        }
        return false;
    }

    @Override  // android.content.ContentProvider
    public final ParcelFileDescriptor openFile(Uri uri0, String s) {
        d d1;
        d d0;
        UriMatcher uriMatcher0 = MelonMediaProvider.l;
        ParcelFileDescriptor parcelFileDescriptor0 = null;
        if(uriMatcher0.match(uri0) == 0xA1) {
            synchronized(this.a) {
                d0 = this.g(uriMatcher0.match(uri0));
            }
            if(d0 == null) {
                throw new IllegalStateException("Couldn\'t open database for " + uri0);
            }
            SQLiteDatabase sQLiteDatabase0 = d0.a();
            if(sQLiteDatabase0 != null) {
                SQLiteQueryBuilder sQLiteQueryBuilder0 = new SQLiteQueryBuilder();
                int v1 = Integer.parseInt(((String)uri0.getPathSegments().get(3)));
                sQLiteQueryBuilder0.setTables("audio_meta");
                sQLiteQueryBuilder0.appendWhere("_id=" + v1);
                Cursor cursor0 = sQLiteQueryBuilder0.query(sQLiteDatabase0, new String[]{"_data", "album_id"}, null, null, null, null, null);
                if(cursor0.moveToFirst()) {
                    String s1 = cursor0.getString(0);
                    int v2 = cursor0.getInt(1);
                    Uri uri1 = ContentUris.withAppendedId(MelonMediaProvider.n, ((long)v2));
                    try {
                        parcelFileDescriptor0 = this.openFile(uri1, s);
                    }
                    catch(FileNotFoundException unused_ex) {
                        e e0 = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
                        e0.a = sQLiteDatabase0;
                        e0.b = s1;
                        e0.c = (long)v2;
                        e0.d = null;
                        parcelFileDescriptor0 = this.m(e0);
                    }
                }
                cursor0.close();
            }
            return parcelFileDescriptor0;
        }
        try {
            return this.openFileHelper(uri0, s);
        }
        catch(FileNotFoundException fileNotFoundException0) {
            if(s.contains("w")) {
                throw fileNotFoundException0;
            }
            if(uriMatcher0.match(uri0) == 0xA0) {
                synchronized(this.a) {
                    d1 = this.g(uriMatcher0.match(uri0));
                }
                if(d1 == null) {
                    throw fileNotFoundException0;
                }
                SQLiteDatabase sQLiteDatabase1 = d1.a();
                if(sQLiteDatabase1 != null) {
                    SQLiteQueryBuilder sQLiteQueryBuilder1 = new SQLiteQueryBuilder();
                    int v4 = Integer.parseInt(((String)uri0.getPathSegments().get(3)));
                    sQLiteQueryBuilder1.setTables("audio_meta");
                    sQLiteQueryBuilder1.appendWhere("album_id=" + v4);
                    Cursor cursor1 = sQLiteQueryBuilder1.query(sQLiteDatabase1, new String[]{"_data"}, null, null, null, null, null);
                    if(cursor1.moveToFirst()) {
                        while(true) {
                            String s2 = cursor1.getString(0);
                            e e1 = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
                            e1.a = sQLiteDatabase1;
                            e1.b = s2;
                            e1.c = (long)v4;
                            e1.d = uri0;
                            parcelFileDescriptor0 = this.m(e1);
                            if(parcelFileDescriptor0 != null || !cursor1.moveToNext()) {
                                break;
                            }
                        }
                    }
                    cursor1.close();
                }
            }
            if(parcelFileDescriptor0 == null) {
                throw fileNotFoundException0;
            }
            return parcelFileDescriptor0;
        }
    }

    public final void p(boolean z, Uri uri0, byte[] arr_b, Bitmap bitmap0) {
        boolean z2;
        try {
            boolean z1 = false;
            OutputStream outputStream0 = this.getContext().getContentResolver().openOutputStream(uri0);
            if(z) {
                z2 = bitmap0.compress(Bitmap.CompressFormat.JPEG, 75, outputStream0);
            }
            else {
                outputStream0.write(arr_b);
                z2 = true;
            }
            z1 = z2;
            outputStream0.close();
            goto label_16;
        }
        catch(FileNotFoundException fileNotFoundException0) {
        }
        catch(IOException iOException0) {
            goto label_15;
        }
        LogU.e("MelonMediaProvider", "error creating file", fileNotFoundException0);
        goto label_16;
    label_15:
        LogU.e("MelonMediaProvider", "error creating file", iOException0);
    label_16:
        if(!z1) {
            this.getContext().getContentResolver().delete(uri0, null, null);
        }
    }

    @Override  // android.content.ContentProvider
    public final Cursor query(Uri uri0, String[] arr_s, String s, String[] arr_s1, String s1) {
        String s6;
        int v = MelonMediaProvider.l.match(uri0);
        if(v == 500) {
            if(this.g == null) {
                return null;
            }
            Cursor cursor0 = new MatrixCursor(new String[]{"volume"});
            ((MatrixCursor)cursor0).addRow(new String[]{this.g});
            return cursor0;
        }
        d d0 = this.g(v);
        if(d0 == null) {
            return null;
        }
        SQLiteDatabase sQLiteDatabase0 = d0.a();
        SQLiteQueryBuilder sQLiteQueryBuilder0 = new SQLiteQueryBuilder();
        String s2 = uri0.getQueryParameter("limit");
        switch(v) {
            case 100: {
                if(arr_s == null || arr_s.length != 1 || arr_s1 != null || s != null && !s.equalsIgnoreCase("is_music=1") && !s.equalsIgnoreCase("is_podcast=1") || !arr_s[0].equalsIgnoreCase("count(*)")) {
                    sQLiteQueryBuilder0.setTables("audio");
                }
                else {
                    sQLiteQueryBuilder0.setTables("audio_meta");
                }
                s6 = null;
                break;
            }
            case 101: {
                sQLiteQueryBuilder0.setTables("audio");
                sQLiteQueryBuilder0.appendWhere("_id=" + ((String)uri0.getPathSegments().get(3)));
                s6 = null;
                break;
            }
            case 102: {
                sQLiteQueryBuilder0.setTables("audio_genres");
                sQLiteQueryBuilder0.appendWhere("_id IN (SELECT genre_id FROM audio_genres_map WHERE audio_id = " + ((String)uri0.getPathSegments().get(3)) + ")");
                s6 = null;
                break;
            }
            case 103: {
                sQLiteQueryBuilder0.setTables("audio_genres");
                sQLiteQueryBuilder0.appendWhere("_id=" + ((String)uri0.getPathSegments().get(5)));
                s6 = null;
                break;
            }
            case 104: {
                sQLiteQueryBuilder0.setTables("audio_playlists");
                sQLiteQueryBuilder0.appendWhere("_id IN (SELECT playlist_id FROM audio_playlists_map WHERE audio_id = " + ((String)uri0.getPathSegments().get(3)) + ")");
                s6 = null;
                break;
            }
            case 105: {
                sQLiteQueryBuilder0.setTables("audio_playlists");
                sQLiteQueryBuilder0.appendWhere("_id=" + ((String)uri0.getPathSegments().get(5)));
                s6 = null;
                break;
            }
            case 106: {
                sQLiteQueryBuilder0.setTables("audio_genres");
                s6 = null;
                break;
            }
            case 107: {
                sQLiteQueryBuilder0.setTables("audio_genres");
                sQLiteQueryBuilder0.appendWhere("_id=" + ((String)uri0.getPathSegments().get(3)));
                s6 = null;
                break;
            }
            case 108: {
                sQLiteQueryBuilder0.setTables("audio");
                sQLiteQueryBuilder0.appendWhere("_id IN (SELECT audio_id FROM audio_genres_map WHERE genre_id = " + ((String)uri0.getPathSegments().get(3)) + ")");
                s6 = null;
                break;
            }
            case 109: {
                sQLiteQueryBuilder0.setTables("audio");
                sQLiteQueryBuilder0.appendWhere("_id=" + ((String)uri0.getPathSegments().get(5)));
                s6 = null;
                break;
            }
            case 110: {
                sQLiteQueryBuilder0.setTables("audio LEFT OUTER JOIN audio_genres_map ON audio._id = audio_genres_map.audio_id LEFT OUTER JOIN audio_genres ON audio_genres._id= audio_genres_map.genre_id");
                s6 = null;
                break;
            }
            case 130: {
                sQLiteQueryBuilder0.setTables("audio_playlists");
                s6 = null;
                break;
            }
            case 0x83: {
                sQLiteQueryBuilder0.setTables("audio_playlists");
                sQLiteQueryBuilder0.appendWhere("_id=" + ((String)uri0.getPathSegments().get(3)));
                s6 = null;
                break;
            }
            case 0x84: {
                sQLiteQueryBuilder0.setTables("audio_playlists_map");
                sQLiteQueryBuilder0.appendWhere("playlist_id=" + ((String)uri0.getPathSegments().get(3)));
                s6 = null;
                break;
            }
            case 0x85: {
                sQLiteQueryBuilder0.setTables("audio");
                sQLiteQueryBuilder0.appendWhere("_id=" + ((String)uri0.getPathSegments().get(5)));
                s6 = null;
                break;
            }
            case 0x86: {
                sQLiteQueryBuilder0.setTables("audio_play_playlists_map");
                s6 = null;
                break;
            }
            case 0x87: {
                sQLiteQueryBuilder0.setTables("audio_playlists_map");
                s6 = null;
                break;
            }
            case 0x9A: {
                if(arr_s == null || arr_s.length != 1 || arr_s1 != null || s != null && s.length() != 0 || !arr_s[0].equalsIgnoreCase("count(*)")) {
                    sQLiteQueryBuilder0.setTables("artist_info");
                }
                else {
                    sQLiteQueryBuilder0.setTables("audio_meta");
                    arr_s[0] = "count(distinct artist_id)";
                    sQLiteQueryBuilder0.appendWhere("is_music=1");
                }
                s6 = null;
                break;
            }
            case 0x9B: {
                sQLiteQueryBuilder0.setTables("artist_info");
                sQLiteQueryBuilder0.appendWhere("_id=" + ((String)uri0.getPathSegments().get(3)));
                s6 = null;
                break;
            }
            case 0x9C: {
                if(arr_s == null || arr_s.length != 1 || arr_s1 != null || s != null && s.length() != 0 || !arr_s[0].equalsIgnoreCase("count(*)")) {
                    sQLiteQueryBuilder0.setTables("album_info");
                }
                else {
                    sQLiteQueryBuilder0.setTables("audio_meta");
                    arr_s[0] = "count(distinct album_id)";
                    sQLiteQueryBuilder0.appendWhere("is_music=1");
                }
                s6 = null;
                break;
            }
            case 0x9D: {
                sQLiteQueryBuilder0.setTables("album_info");
                sQLiteQueryBuilder0.appendWhere("_id=" + ((String)uri0.getPathSegments().get(3)));
                s6 = null;
                break;
            }
            case 0x9E: {
                String s7 = (String)uri0.getPathSegments().get(3);
                sQLiteQueryBuilder0.setTables("audio LEFT OUTER JOIN album_art ON audio.album_id=album_art.album_id");
                sQLiteQueryBuilder0.appendWhere("is_music=1 AND audio.album_id IN (SELECT album_id FROM artists_albums_map WHERE artist_id = " + s7 + ")");
                MelonMediaProvider.r.put("numsongs_by_artist", "count(CASE WHEN artist_id==" + s7 + " THEN \'foo\' ELSE NULL END) AS numsongs_by_artist");
                sQLiteQueryBuilder0.setProjectionMap(MelonMediaProvider.r);
                s6 = "audio.album_id";
                break;
            }
            case 0xA0: {
                sQLiteQueryBuilder0.setTables("album_art");
                sQLiteQueryBuilder0.appendWhere("album_id=" + ((String)uri0.getPathSegments().get(3)));
                s6 = null;
                break;
            }
            case 402: {
                String s3 = (uri0.getPath().endsWith("/") ? "" : uri0.getLastPathSegment()).replaceAll("  ", " ").trim().toLowerCase();
                String[] arr_s2 = s3.length() <= 0 ? new String[0] : s3.split(" ");
                String[] arr_s3 = new String[arr_s2.length];
                Collator.getInstance().setStrength(0);
                for(int v1 = 0; true; ++v1) {
                    String s4 = "%";
                    if(v1 >= arr_s2.length) {
                        break;
                    }
                    if(!arr_s2[v1].equals("a") && !arr_s2[v1].equals("an") && !arr_s2[v1].equals("the")) {
                        s4 = "%" + m.w(arr_s2[v1]) + '%';
                    }
                    arr_s3[v1] = s4;
                }
                String s5 = "";
                for(int v2 = 0; v2 < arr_s2.length; ++v2) {
                    s5 = v2 == 0 ? "match LIKE ?" : s5 + " AND match LIKE ?";
                }
                sQLiteQueryBuilder0.setTables("search");
                return sQLiteQueryBuilder0.query(sQLiteDatabase0, new String[]{"_id", "mime_type", "artist", "album", "title", "data1", "data2"}, s5, arr_s3, null, null, null, s2);
            }
            case 9000: {
                sQLiteQueryBuilder0.setTables("playstreaming");
                s6 = null;
                break;
            }
            default: {
                throw new IllegalStateException("Unknown URL: " + uri0.toString());
            }
        }
        try {
            Cursor cursor1 = sQLiteQueryBuilder0.query(sQLiteDatabase0, arr_s, s, arr_s1, s6, null, s1, s2);
            if(cursor1 != null) {
                cursor1.setNotificationUri(this.getContext().getContentResolver(), uri0);
                return cursor1;
            }
        }
        catch(Exception exception0) {
            exception0.printStackTrace();
            LogU.e("MelonMediaProvider", exception0.toString());
        }
        return null;
    }

    @Override  // android.content.ContentProvider
    public final int update(Uri uri0, ContentValues contentValues0, String s, String[] arr_s) {
        int v10;
        int v16;
        int v20;
        long v27;
        ContentValues contentValues6;
        int v25;
        int v23;
        d d1;
        ContentValues contentValues5;
        long v22;
        SQLiteDatabase sQLiteDatabase3;
        int v1;
        int v = MelonMediaProvider.l.match(uri0);
        if(v == 11000) {
            String s1 = FileUtils.getSecondaryExternalStorage();
            Pattern pattern0 = s1 == null ? Pattern.compile(".*/melon/(.*)") : Pattern.compile(("^(?!" + s1 + ").*/melon/(.*)"));
            new StringBuilder();
            String s2 = MelonMediaProvider.h;
            SQLiteDatabase sQLiteDatabase0 = ((d)this.a.get("internal")).b();
            if(sQLiteDatabase0 == null) {
                v1 = 0;
            }
            else {
                v1 = 0;
                sQLiteDatabase0.beginTransaction();
                Cursor cursor0 = sQLiteDatabase0.rawQuery("select _id, _data from playstreaming where _data not like ?", new String[]{s2 + "%"});
                if(cursor0 != null) {
                    if(cursor0.moveToFirst()) {
                        while(true) {
                            int v2 = cursor0.getInt(0);
                            String s3 = cursor0.getString(1);
                            if(!TextUtils.isEmpty(s3)) {
                                Matcher matcher0 = pattern0.matcher(s3);
                                if(matcher0.matches()) {
                                    String s4 = matcher0.replaceFirst("null$1");
                                    ContentValues contentValues1 = new ContentValues();
                                    contentValues1.put("_data", s4);
                                    try {
                                        v1 += sQLiteDatabase0.update("playstreaming", contentValues1, "_id =" + v2, null);
                                    }
                                    catch(SQLiteException sQLiteException0) {
                                        LogU.e("MelonMediaProvider", "update() playstreaming: " + sQLiteException0.toString());
                                    }
                                }
                            }
                            if(!cursor0.moveToNext()) {
                                break;
                            }
                        }
                    }
                    cursor0.close();
                }
                Cursor cursor1 = sQLiteDatabase0.rawQuery("select _id, _data from audio_playlists_map", null);
                if(cursor1 != null) {
                    if(cursor1.moveToFirst()) {
                        while(true) {
                            int v3 = cursor1.getInt(0);
                            String s5 = cursor1.getString(1);
                            if(!TextUtils.isEmpty(s5)) {
                                ContentValues contentValues2 = new ContentValues();
                                Matcher matcher1 = pattern0.matcher(s5);
                                if(matcher1.matches()) {
                                    s5 = matcher1.replaceFirst("null$1");
                                }
                                contentValues2.put("_data", s5);
                                Cursor cursor2 = MusicUtils.fetchMediaStoreAudioCursor(this.getContext(), new String[]{s5});
                                if(cursor2 != null) {
                                    if(cursor2.moveToFirst()) {
                                        int v4 = cursor2.getColumnIndex("_id");
                                        int v5 = cursor2.getColumnIndex("_id2");
                                        int v6 = cursor2.getColumnIndex("album_id");
                                        int v7 = cursor2.getColumnIndex("artist_id");
                                        if(v4 != -1) {
                                            contentValues2.put("audio_id1", cursor2.getInt(v4));
                                        }
                                        if(v5 != -1) {
                                            contentValues2.put("audio_id2", cursor2.getInt(v5));
                                        }
                                        if(v6 != -1) {
                                            contentValues2.put("album_id", cursor2.getInt(v6));
                                        }
                                        if(v7 != -1) {
                                            contentValues2.put("artist_id", cursor2.getInt(v7));
                                        }
                                    }
                                    cursor2.close();
                                }
                                try {
                                    v1 += sQLiteDatabase0.update("audio_playlists_map", contentValues2, "_id =" + v3, null);
                                }
                                catch(SQLiteException sQLiteException1) {
                                    LogU.e("MelonMediaProvider", "update() audio_playlists_map: " + sQLiteException1.toString());
                                }
                            }
                            if(!cursor1.moveToNext()) {
                                break;
                            }
                        }
                    }
                    cursor1.close();
                }
                sQLiteDatabase0.setTransactionSuccessful();
                sQLiteDatabase0.endTransaction();
            }
            SQLiteDatabase sQLiteDatabase1 = ((d)this.a.get("external")).b();
            if(sQLiteDatabase1 != null) {
                sQLiteDatabase1.beginTransaction();
                Cursor cursor3 = sQLiteDatabase1.rawQuery("select _id, _data from audio_meta where _data not like ?", new String[]{"null%"});
                if(cursor3 != null) {
                    if(cursor3.moveToFirst()) {
                        while(true) {
                            int v8 = cursor3.getInt(0);
                            String s6 = cursor3.getString(1);
                            if(!TextUtils.isEmpty(s6)) {
                                Matcher matcher2 = pattern0.matcher(s6);
                                if(matcher2.matches()) {
                                    String s7 = matcher2.replaceFirst("null$1");
                                    ContentValues contentValues3 = new ContentValues();
                                    contentValues3.put("_data", s7);
                                    try {
                                        v1 += sQLiteDatabase1.update("audio_meta", contentValues3, "_id =" + v8, null);
                                    }
                                    catch(SQLiteException sQLiteException2) {
                                        LogU.e("MelonMediaProvider", "update() audio_meta: " + sQLiteException2);
                                    }
                                }
                            }
                            if(!cursor3.moveToNext()) {
                                break;
                            }
                        }
                    }
                    cursor3.close();
                }
                sQLiteDatabase1.setTransactionSuccessful();
                sQLiteDatabase1.endTransaction();
            }
            return v1;
        }
        d d0 = this.g(v);
        if(d0 == null) {
            throw new UnsupportedOperationException("Unknown URI: " + uri0);
        }
        SQLiteDatabase sQLiteDatabase2 = d0.b();
        switch(v) {
            case 100: 
            case 101: {
                if(sQLiteDatabase2 == null) {
                    v10 = 0;
                }
                else {
                    ContentValues contentValues4 = new ContentValues(contentValues0);
                    contentValues4.remove("album_artist");
                    String s8 = contentValues4.getAsString("artist");
                    contentValues4.remove("artist");
                    if(s8 == null) {
                        d1 = d0;
                        sQLiteDatabase3 = sQLiteDatabase2;
                        contentValues5 = contentValues4;
                    }
                    else {
                        HashMap hashMap0 = d0.i;
                        synchronized(hashMap0) {
                            Long long0 = (Long)hashMap0.get(s8);
                            if(long0 == null) {
                                sQLiteDatabase3 = sQLiteDatabase2;
                                v22 = this.h(sQLiteDatabase3, "artists", "artist_key", "artist", s8, s8, null, 0, null, hashMap0, uri0);
                                contentValues5 = contentValues4;
                                d1 = d0;
                            }
                            else {
                                d1 = d0;
                                sQLiteDatabase3 = sQLiteDatabase2;
                                contentValues5 = contentValues4;
                                v22 = (long)long0;
                            }
                        }
                        contentValues5.put("artist_id", Integer.toString(((int)v22)));
                    }
                    String s9 = contentValues5.getAsString("album");
                    contentValues5.remove("album");
                    if(s9 == null) {
                        contentValues6 = contentValues5;
                    }
                    else {
                        String s10 = contentValues5.getAsString("_data");
                        if(!TextUtils.isEmpty(s8)) {
                            v23 = s8.hashCode();
                        }
                        else if(s10 == null) {
                            LogU.w("MelonMediaProvider", "Update without specified path.");
                            v23 = 0;
                        }
                        else {
                            int v24 = s10.lastIndexOf(0x2F);
                            try {
                                v25 = s10.substring(v24 + 1, s10.indexOf(45)).hashCode();
                            }
                            catch(IndexOutOfBoundsException unused_ex) {
                                v23 = 0;
                                goto label_215;
                            }
                            v23 = v25;
                        }
                    label_215:
                        String s11 = s9.toString();
                        HashMap hashMap1 = d1.j;
                        synchronized(hashMap1) {
                            String s12 = s11 + v23;
                            Long long1 = (Long)hashMap1.get(s12);
                            if(long1 == null) {
                                contentValues6 = contentValues5;
                                v27 = this.h(sQLiteDatabase3, "albums", "album_key", "album", s11, s12, s10, v23, s8, hashMap1, uri0);
                            }
                            else {
                                contentValues6 = contentValues5;
                                v27 = (long)long1;
                            }
                        }
                        contentValues6.put("album_id", Integer.toString(((int)v27)));
                    }
                    contentValues6.remove("title_key");
                    String s13 = contentValues6.getAsString("title");
                    if(s13 != null) {
                        String s14 = s13.toString();
                        contentValues6.put("title_key", m.w(s14));
                        contentValues6.remove("title");
                        contentValues6.put("title", s14.trim());
                    }
                    synchronized(MelonMediaProvider.D) {
                        MelonMediaProvider.i(uri0, v, s, MelonMediaProvider.D);
                        v10 = sQLiteDatabase3.update("audio_meta", contentValues6, ((String)MelonMediaProvider.D.b), arr_s);
                    }
                }
                break;
            }
            case 0x83: {
                if(sQLiteDatabase2 == null || uri0.getQueryParameter("move") == null) {
                    v10 = 0;
                    break;
                }
                if(!contentValues0.containsKey("sort_order")) {
                    throw new IllegalArgumentException("Need to specify sort_order when using \'move\' parameter");
                }
                int v17 = (int)contentValues0.getAsInteger("sort_order");
                int v18 = (int)Integer.valueOf(((String)uri0.getPathSegments().get(3)));
                if(v18 != v17) {
                    sQLiteDatabase2.beginTransaction();
                    try {
                        sQLiteDatabase2.execSQL("UPDATE audio_playlists SET sort_order=-1 WHERE sort_order=" + v18);
                        if(v18 < v17) {
                            sQLiteDatabase2.execSQL("UPDATE audio_playlists SET sort_order=sort_order-1 WHERE sort_order<=" + v17 + " AND sort_order>" + v18);
                            v20 = v17 - v18;
                        }
                        else {
                            sQLiteDatabase2.execSQL("UPDATE audio_playlists SET sort_order=sort_order+1 WHERE sort_order>=" + v17 + " AND sort_order<" + v18);
                            v20 = v18 - v17;
                        }
                        sQLiteDatabase2.execSQL("UPDATE audio_playlists SET sort_order=" + v17 + " WHERE sort_order=-1");
                        sQLiteDatabase2.setTransactionSuccessful();
                        this.n(l.a.buildUpon().build());
                        return v20 + 1;
                    }
                    finally {
                        sQLiteDatabase2.endTransaction();
                    }
                }
                return 0;
            }
            case 0x85: {
                if(sQLiteDatabase2 == null || uri0.getQueryParameter("move") == null) {
                    v10 = 0;
                    break;
                }
                if(contentValues0.containsKey("play_order")) {
                    int v12 = (int)contentValues0.getAsInteger("play_order");
                    List list0 = uri0.getPathSegments();
                    long v13 = (long)Long.valueOf(((String)list0.get(3)));
                    int v14 = (int)Integer.valueOf(((String)list0.get(5)));
                    if(v14 == v12) {
                        return 0;
                    }
                    sQLiteDatabase2.beginTransaction();
                    try {
                        sQLiteDatabase2.execSQL("UPDATE audio_playlists_map SET play_order=-1 WHERE play_order=" + v14 + " AND playlist_id=" + v13);
                        if(v14 < v12) {
                            sQLiteDatabase2.execSQL("UPDATE audio_playlists_map SET play_order=play_order-1 WHERE play_order<=" + v12 + " AND play_order>" + v14 + " AND playlist_id=" + v13);
                            v16 = v12 - v14;
                        }
                        else {
                            sQLiteDatabase2.execSQL("UPDATE audio_playlists_map SET play_order=play_order+1 WHERE play_order>=" + v12 + " AND play_order<" + v14 + " AND playlist_id=" + v13);
                            v16 = v14 - v12;
                        }
                        sQLiteDatabase2.execSQL("UPDATE audio_playlists_map SET play_order=" + v12 + " WHERE play_order=-1 AND playlist_id=" + v13);
                        sQLiteDatabase2.setTransactionSuccessful();
                        this.n(l.a.buildUpon().appendEncodedPath(String.valueOf(v13)).build());
                        return v16 + 1;
                    }
                    finally {
                        sQLiteDatabase2.endTransaction();
                    }
                }
                throw new IllegalArgumentException("Need to specify play_order when using \'move\' parameter");
            }
            case 0x87: {
                if(sQLiteDatabase2 == null) {
                    return 0;
                }
                sQLiteDatabase2.beginTransaction();
                sQLiteDatabase2.execSQL("UPDATE audio_playlists_map SET play_order = play_order - 1 WHERE " + s);
                sQLiteDatabase2.setTransactionSuccessful();
                this.n(uri0);
                sQLiteDatabase2.endTransaction();
                return 0;
            }
            case 9000: {
                if(sQLiteDatabase2 == null) {
                    v10 = 0;
                    break;
                }
                else {
                    sQLiteDatabase2.beginTransaction();
                    synchronized(MelonMediaProvider.D) {
                        MelonMediaProvider.i(uri0, 9000, s, MelonMediaProvider.D);
                        v10 = sQLiteDatabase2.update(((String)MelonMediaProvider.D.a), contentValues0, ((String)MelonMediaProvider.D.b), arr_s);
                    }
                    sQLiteDatabase2.setTransactionSuccessful();
                    sQLiteDatabase2.endTransaction();
                }
                break;
            }
            default: {
                if(sQLiteDatabase2 == null) {
                    v10 = 0;
                    break;
                }
                else {
                    a a0 = MelonMediaProvider.D;
                    synchronized(a0) {
                        MelonMediaProvider.i(uri0, v, s, a0);
                        v10 = sQLiteDatabase2.update(((String)a0.a), contentValues0, ((String)a0.b), arr_s);
                        if(((String)a0.a).equals("audio_playlists_map")) {
                            this.getContext().getContentResolver().notifyChange(uri0, null);
                            return v10;
                        }
                    }
                }
            }
        }
        if(v10 > 0) {
            this.n(uri0);
        }
        return v10;
    }
}

