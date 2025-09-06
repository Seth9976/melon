package com.iloen.melon.utils.player;

import C9.d;
import C9.e;
import C9.f;
import Cc.h0;
import E9.w;
import Fc.c;
import G8.g;
import H8.n;
import H8.s;
import H8.t;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Audio.Genres.Members;
import android.provider.MediaStore.Audio.Genres;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Video.Media;
import android.text.TextUtils;
import b3.Z;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.database.core.LocalContentDatabase_Impl;
import com.iloen.melon.database.core.LocalPlaylistDatabase_Impl;
import com.iloen.melon.lyric.LyricsInfo;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.GetWebLyricReq;
import com.iloen.melon.net.v4x.response.GetWebLyricRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.DateUtils;
import com.iloen.melon.utils.FileUtils;
import com.iloen.melon.utils.FilenameUtils;
import com.iloen.melon.utils.StorageUtils;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.network.NetUtils;
import com.iloen.melon.utils.system.VolumeUtils;
import com.iloen.melon.utils.ui.CursorUtil;
import d5.l;
import e9.b;
import i9.i;
import i9.j;
import i9.k;
import i9.m;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import je.p;
import jeb.synthetic.TWR;
import k8.Y;
import k8.o;
import kc.d3;
import kc.s2;
import kotlin.jvm.internal.q;
import okhttp3.OkHttpClient;
import org.gagravarr.flac.FlacNativeFile;
import org.gagravarr.flac.FlacTags;
import r2.a;

public class MusicUtils {
    public static final String EDU_GENRE_NAME = "어학";
    public static final int MAX_LYRIC_FILE_COUNT = 5000;
    public static final String ORDER_DOWN = "DOWN";
    public static final String ORDER_UP = "UP";

    static {
    }

    public static void a(Context context0) {
        Cursor cursor2;
        Throwable throwable1;
        StringBuilder stringBuilder0;
        LogU.d("MusicUtils", "cleanupJunkData start!");
        ContentResolver contentResolver0 = context0.getContentResolver();
        Cursor cursor0 = null;
        Cursor cursor1 = contentResolver0.query(m.a, new String[]{"_id", "_data"}, null, null, null);
        if(cursor1 != null) {
            try {
                if(cursor1.moveToFirst()) {
                    stringBuilder0 = new StringBuilder();
                    while(true) {
                        int v = cursor1.getInt(0);
                        String s = cursor1.getString(1);
                        if(TextUtils.isEmpty(s) || !new File(s).exists()) {
                            stringBuilder0.append(v);
                            stringBuilder0.append(",");
                        }
                        if(cursor1.moveToNext()) {
                            continue;
                        }
                        goto label_13;
                    }
                }
                goto label_26;
            }
            catch(Exception exception0) {
                goto label_22;
            }
            catch(Throwable throwable0) {
                goto label_19;
            }
        label_13:
            if(stringBuilder0.length() > 0) {
                try {
                    try {
                        stringBuilder0.setLength(stringBuilder0.length() - 1);
                        LogU.w("PlayStreaming", "cleanup not existing files on PlayStreaming database: " + stringBuilder0);
                        LogU.d("PlayStreaming", "nDeleted: " + contentResolver0.delete(m.a, "_id IN (" + stringBuilder0.toString() + ")", null));
                        goto label_26;
                    label_19:
                        throwable1 = throwable0;
                        goto label_24;
                    }
                    catch(Exception exception0) {
                    }
                label_22:
                    LogU.d("PlayStreaming", "cleanupJunkData() " + exception0.toString());
                    goto label_26;
                }
                catch(Throwable throwable0) {
                    goto label_19;
                }
            label_24:
                cursor1.close();
                throw throwable1;
            }
        label_26:
            cursor1.close();
        }
        ContentResolver contentResolver1 = context0.getContentResolver();
        try {
            try {
                cursor2 = contentResolver1.query(k.a, new String[]{"_data"}, null, null, "title_key");
            }
            catch(Exception exception1) {
                LogU.d("MusicUtils", "cleanupJunkData() " + exception1.toString());
                goto label_54;
            }
        }
        catch(Throwable throwable2) {
            goto label_52;
        }
        if(cursor2 == null) {
        label_60:
            if(cursor2 != null) {
                cursor2.close();
            }
        }
        else {
            try {
                if(cursor2.moveToFirst()) {
                    ArrayList arrayList0 = new ArrayList();
                    do {
                        String s1 = cursor2.getString(0);
                        if(TextUtils.isEmpty(s1) || !new File(s1).exists()) {
                            arrayList0.add(s1);
                        }
                    }
                    while(cursor2.moveToNext());
                    if(arrayList0.size() > 0) {
                        b b0 = new b(MelonAppBase.instance.getContext(), new MusicUtils.2());  // 初始化器: Ljava/lang/Object;-><init>()V
                        Object[] arr_object = arrayList0.toArray();
                        String[] arr_s = (String[])Arrays.copyOf(arr_object, arr_object.length, String[].class);
                        b0.d = 7;
                        b0.a(arr_s, null);
                        goto label_60;
                    label_48:
                        cursor0 = cursor2;
                        goto label_49;
                    }
                    else {
                        goto label_60;
                    }
                }
                else {
                    goto label_60;
                }
                goto label_62;
            }
            catch(Exception exception1) {
                goto label_48;
            }
            catch(Throwable throwable2) {
                goto label_58;
            }
            try {
            label_49:
                LogU.d("MusicUtils", "cleanupJunkData() " + exception1.toString());
            }
            catch(Throwable throwable2) {
            label_52:
                TWR.safeClose$NT(cursor0, throwable2);
                throw throwable2;
            }
        label_54:
            if(cursor0 != null) {
                cursor0.close();
                goto label_62;
            label_58:
                TWR.safeClose$NT(cursor2, throwable2);
                throw throwable2;
            }
        }
    label_62:
        LogU.d("MusicUtils", "cleanupJunkData end!");
    }

    @Deprecated
    public static int addToPlaylist(Context context0, Cursor cursor0, ArrayList arrayList0, long v) {
        ContentResolver contentResolver0 = context0.getContentResolver();
        Uri uri0 = i.b(v);
        Cursor cursor1 = contentResolver0.query(uri0, new String[]{"count(*)"}, null, null, null);
        cursor1.moveToFirst();
        int v1 = 0;
        int v2 = cursor1.getInt(0);
        cursor1.close();
        ArrayList arrayList1 = new ArrayList();
        if(arrayList0 == null) {
            if(cursor0.getCount() + v2 > 500) {
                return -1;
            }
            cursor0.moveToFirst();
            while(v1 < cursor0.getCount()) {
                ContentValues contentValues1 = MusicUtils.e(cursor0);
                contentValues1.put("play_order", ((int)(v2 + v1)));
                arrayList1.add(contentValues1);
                cursor0.moveToNext();
                ++v1;
            }
        }
        else {
            int v3 = arrayList0.size();
            if(v2 + v3 > 500) {
                return -1;
            }
            while(v1 < v3) {
                cursor0.moveToPosition(((int)(((Integer)arrayList0.get(v1)))));
                ContentValues contentValues0 = MusicUtils.e(cursor0);
                contentValues0.put("play_order", ((int)(v2 + v1)));
                arrayList1.add(contentValues0);
                ++v1;
            }
        }
        ContentValues[] arr_contentValues = new ContentValues[arrayList1.size()];
        arrayList1.toArray(arr_contentValues);
        contentResolver0.bulkInsert(uri0, arr_contentValues);
        return arrayList1.size();
    }

    public static int addToPlaylist(ArrayList arrayList0, long v) {
        G8.i.a.f();
        List list0 = (List)w.N(((LocalPlaylistDatabase_Impl)G8.i.a().a), true, false, new h0(v, 8));
        int v1 = list0.isEmpty() ? 0 : ((int)(((Integer)list0.get(0)))) + 1;
        int v2 = arrayList0.size();
        if(list0.size() + v2 > 500) {
            return -1;
        }
        ArrayList arrayList1 = new ArrayList();
        for(int v3 = 0; v3 < v2; ++v3) {
            Playable playable0 = (Playable)arrayList0.get(v3);
            t t0 = new t();
            q.g("", "<set-?>");
            t0.g = "";
            q.g("", "<set-?>");
            t0.d = "";
            q.g("", "<set-?>");
            t0.e = "";
            q.g("", "<set-?>");
            t0.i = "";
            String s = String.valueOf(playable0.getMediaStoreAlbumId());
            q.g(s, "<set-?>");
            t0.h = s;
            q.g("", "<set-?>");
            t0.j = "";
            q.g("", "<set-?>");
            t0.k = "";
            t0.n = (int)playable0.getDuration();
            t0.b = ProtocolUtils.parseLong("", 0L);
            q.g("", "<set-?>");
            t0.c = "";
            t0.m = v1 + v3;
            t0.l = v;
            q.g("", "<set-?>");
            t0.f = "";
            arrayList1.add(t0);
        }
        H8.q q0 = G8.i.a();
        q0.getClass();
        w.N(((LocalPlaylistDatabase_Impl)q0.a), false, true, new n(q0, arrayList1, 0));
        return arrayList1.size();
    }

    public static void b(Context context0, String[] arr_s) {
        a a0;
        int v = 0;
        if(arr_s != null && arr_s.length != 0) {
            if(StorageUtils.isScopedStorage()) {
                int v1 = 0;
                while(v1 < arr_s.length) {
                    String s = arr_s[v1];
                    Uri uri0 = Uri.parse(s);
                    if(uri0 == null) {
                        return;
                    }
                    try {
                        try {
                            if(DocumentsContract.isDocumentUri(context0, uri0)) {
                                a0 = a.d(context0, uri0);
                                if(a0.c()) {
                                    goto label_11;
                                }
                            }
                            else {
                                goto label_16;
                            }
                            goto label_32;
                        }
                        catch(Exception exception0) {
                            LogU.e("MusicUtils", "remove file error = " + exception0.toString());
                            goto label_22;
                        }
                        try {
                        label_11:
                            boolean z = false;
                            z = DocumentsContract.deleteDocument(a0.b.getContentResolver(), a0.c);
                        }
                        catch(Exception unused_ex) {
                        }
                        if(!z) {
                            try {
                                LogU.e("MusicUtils", "Failed to delete file " + s);
                                goto label_32;
                            label_16:
                                context0.getContentResolver().delete(uri0, null, null);
                                goto label_32;
                            }
                            catch(Exception exception0) {
                            }
                            LogU.e("MusicUtils", "remove file error = " + exception0.toString());
                            goto label_22;
                        }
                        goto label_32;
                    }
                    catch(Throwable throwable0) {
                        goto label_27;
                    }
                label_22:
                    File file0 = SongMetaParser.getLyricFile(uri0);
                    if(file0 != null && file0.exists()) {
                        file0.delete();
                    }
                    pb.q q0 = new pb.q(MusicUtils.c(context0));
                    goto label_36;
                label_27:
                    File file1 = SongMetaParser.getLyricFile(uri0);
                    if(file1 != null && file1.exists()) {
                        file1.delete();
                    }
                    new pb.q(MusicUtils.c(context0)).b(s);
                    throw throwable0;
                label_32:
                    File file2 = SongMetaParser.getLyricFile(uri0);
                    if(file2 != null && file2.exists()) {
                        file2.delete();
                    }
                    q0 = new pb.q(MusicUtils.c(context0));
                label_36:
                    q0.b(s);
                    ++v1;
                }
            }
            else {
                while(v < arr_s.length) {
                    try {
                        File file3 = new File(arr_s[v]);
                        String s1 = file3.getPath();
                        File file4 = SongMetaParser.getLyricFile(s1);
                        if(file4 != null && file4.exists()) {
                            file4.delete();
                        }
                        new pb.q(MusicUtils.c(context0)).b(s1);
                        if(!file3.delete()) {
                            LogU.e("MusicUtils", "Failed to delete file " + arr_s[v]);
                        }
                        goto label_56;
                    }
                    catch(SecurityException securityException0) {
                    }
                    catch(Exception exception1) {
                        goto label_55;
                    }
                    LogU.e("MusicUtils", "remove file error = " + securityException0.toString());
                    goto label_56;
                label_55:
                    H0.b.v(exception1, new StringBuilder("remove file error = "), "MusicUtils");
                label_56:
                    ++v;
                }
            }
        }
    }

    public static s2 c(Context context0) {
        q.g(context0, "context");
        Context context1 = context0.getApplicationContext();
        q.d(context1);
        return (s2)((o)(((Ma.m)com.google.firebase.b.B(context1, Ma.m.class)))).w.get();
    }

    public static boolean checkStreamingLyricsExist(String s, String s1) {
        File[] arr_file = new File(s1).listFiles();
        if(arr_file == null) {
            return false;
        }
        for(int v = 0; v < arr_file.length; ++v) {
            if(s.equals(arr_file[v].getName())) {
                return true;
            }
        }
        return false;
    }

    public static void cleanupJunkDataSafety(Context context0) {
        try {
            MusicUtils.a(context0);
        }
        catch(Exception unused_ex) {
        }
    }

    public static String d(Context context0, Uri uri0, String s, String s1, String[] arr_s) {
        Exception exception1;
        Throwable throwable1;
        ContentResolver contentResolver0 = context0.getContentResolver();
        StringBuilder stringBuilder0 = new StringBuilder();
        Cursor cursor0 = null;
        try {
            try {
                cursor0 = contentResolver0.query(uri0, null, s1, arr_s, null);
                if(cursor0 != null) {
                    while(cursor0.moveToNext()) {
                        String s2 = String.valueOf(cursor0.getLong(cursor0.getColumnIndex(s)));
                        if(!TextUtils.isEmpty(s2)) {
                            if(stringBuilder0.length() > 0) {
                                stringBuilder0.append(", ");
                            }
                            stringBuilder0.append(s2);
                        }
                    }
                    DatabaseUtils.dumpCursor(cursor0);
                }
                goto label_25;
            }
            catch(Exception exception0) {
                exception1 = exception0;
            }
            LogU.e("MusicUtils", "getRawId() - error : " + exception1.getMessage());
            if(cursor0 == null) {
                return stringBuilder0.toString();
            }
            goto label_26;
        }
        catch(Throwable throwable0) {
            throwable1 = throwable0;
            goto label_22;
        }
        return stringBuilder0.toString();
    label_22:
        if(cursor0 != null) {
            cursor0.close();
        }
        throw throwable1;
    label_25:
        if(cursor0 != null) {
        label_26:
            cursor0.close();
            return stringBuilder0.toString();
        }
        return stringBuilder0.toString();
    }

    public static ArrayList decodeDcfLyrics(Context context0, Playable playable0) {
        LogU.d("MusicUtils", "decodeDcfLyrics - path:  - uri: ");
        try {
            return R8.m.a(context0, R8.m.a).c(playable0);
        }
        catch(Exception unused_ex) {
            return null;
        }
        finally {
            R8.m.b(context0);
        }
    }

    public static ArrayList decodeFlacLyricsFromFlacTag(String s) {
        ArrayList arrayList0 = null;
        try {
            FlacTags flacTags0 = new FlacNativeFile(new File(s)).getTags();
            if(flacTags0 != null) {
                Map map0 = flacTags0.getAllComments();
                for(Object object0: map0.keySet()) {
                    String s1 = (String)object0;
                    if("lyrics".equals(s1)) {
                        List list0 = (List)map0.get(s1);
                        if(list0 == null || list0.isEmpty()) {
                            LogU.i("MusicUtils", "there is no lyrics tag");
                        }
                        else {
                            ArrayList arrayList1 = new ArrayList();
                            try {
                                int v = 0;
                                for(Object object1: list0) {
                                    String s2 = (String)object1;
                                    if(!TextUtils.isEmpty(s2)) {
                                        arrayList1.add(new LyricsInfo(((long)v), s2));
                                        ++v;
                                    }
                                }
                                arrayList0 = arrayList1;
                            }
                            catch(IllegalArgumentException illegalArgumentException0) {
                                arrayList0 = arrayList1;
                                goto label_40;
                            }
                            catch(FileNotFoundException fileNotFoundException0) {
                                arrayList0 = arrayList1;
                                goto label_43;
                            }
                            catch(IOException iOException0) {
                                arrayList0 = arrayList1;
                                goto label_46;
                            }
                            catch(Exception exception0) {
                                arrayList0 = arrayList1;
                                goto label_49;
                            }
                        }
                        LogU.i("MusicUtils", "add lyrics from flac - success");
                        break;
                    }
                }
            }
            return arrayList0;
        }
        catch(IllegalArgumentException illegalArgumentException0) {
        label_40:
            LogU.e("MusicUtils", illegalArgumentException0.toString());
            return arrayList0;
        }
        catch(FileNotFoundException fileNotFoundException0) {
        label_43:
            LogU.e("MusicUtils", fileNotFoundException0.toString());
            return arrayList0;
        }
        catch(IOException iOException0) {
        label_46:
            LogU.e("MusicUtils", iOException0.toString());
            return arrayList0;
        }
        catch(Exception exception0) {
        }
    label_49:
        LogU.e("MusicUtils", exception0.toString());
        return arrayList0;
    }

    public static ArrayList decodeMp3LyricsFromId3Tag(String s) {
        ArrayList arrayList0;
        e e0;
        l l0;
        byte[] arr_b9;
        int v30;
        int v28;
        d d0;
        int v21;
        String s1;
        int v15;
        byte[] arr_b8;
        int v13;
        long v11;
        ByteArrayInputStream byteArrayInputStream0;
        byte[] arr_b5;
        ByteArrayOutputStream byteArrayOutputStream0;
        f f0;
        byte[] arr_b4;
        int v3;
        BufferedInputStream bufferedInputStream1;
        FileInputStream fileInputStream1;
        int v1;
        BufferedInputStream bufferedInputStream0;
        FileInputStream fileInputStream0;
        byte[] arr_b;
        long v;
        LogU.d("MusicUtils", "decodeMp3LyricsFromId3Tag - path: " + s);
        if(FilenameUtils.isMp3(s)) {
            File file0 = new File(s);
            LogU.i("MusicUtils", "add lyrics from mp3 - try");
            try {
                if(!file0.exists()) {
                    l0 = null;
                }
                else if(file0.exists()) {
                    if(file0.exists()) {
                        v = file0.length();
                        if(10L > v) {
                            arr_b = null;
                        }
                        else {
                            goto label_13;
                        }
                    }
                    else {
                        arr_b = null;
                    }
                    goto label_52;
                }
                else {
                    l0 = null;
                }
                goto label_383;
            }
            catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                LogU.e("decodingNonDRMLyrics : ", arrayIndexOutOfBoundsException0.toString());
                return null;
            }
            catch(IOException iOException0) {
                LogU.e("decodingNonDRMLyrics : ", iOException0.toString());
                return null;
            }
            arr_b = null;
            goto label_52;
            try {
            label_13:
                fileInputStream0 = new FileInputStream(file0);
            }
            catch(Throwable throwable0) {
                fileInputStream0 = null;
                goto label_39;
            }
            try {
                bufferedInputStream0 = new BufferedInputStream(fileInputStream0, 0x2000);
            }
            catch(Throwable throwable0) {
                goto label_39;
            }
            try {
                bufferedInputStream0.skip(v - 10L);
                byte[] arr_b1 = ye.a.T(bufferedInputStream0, 10);
                if(arr_b1[2] != 51) {
                    goto label_50;
                }
                else if(arr_b1[1] == 68 && arr_b1[0] == 73) {
                    v1 = f.d(6, arr_b1);
                    if(v1 > 0x200000) {
                        LogU.e("MyID3", "ID3v2 header size is too big:" + v1);
                        goto label_44;
                    }
                    else if(((long)(v1 + 10)) <= v) {
                        bufferedInputStream0.close();
                        goto label_25;
                    }
                    else {
                        goto label_44;
                    }
                }
                else {
                    goto label_47;
                }
                goto label_52;
            }
            catch(Throwable throwable0) {
                goto label_38;
            }
            try {
            label_25:
                fileInputStream0 = new FileInputStream(file0);
            }
            catch(Throwable throwable0) {
                fileInputStream0 = null;
                goto label_39;
            }
            try {
                bufferedInputStream0 = new BufferedInputStream(fileInputStream0, 0x2000);
            }
            catch(Throwable throwable0) {
                goto label_39;
            }
            try {
                bufferedInputStream0.skip(v - 10L - ((long)v1) - 10L);
                arr_b = ye.a.T(bufferedInputStream0, v1 + 20);
                goto label_42;
            }
            catch(Throwable throwable0) {
            label_38:
                fileInputStream0 = bufferedInputStream0;
            }
        label_39:
            if(fileInputStream0 != null) {
                try {
                    fileInputStream0.close();
                }
                catch(IOException unused_ex) {
                }
                catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                    LogU.e("decodingNonDRMLyrics : ", arrayIndexOutOfBoundsException0.toString());
                    return null;
                }
            }
            try {
                throw throwable0;
            }
            catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                LogU.e("decodingNonDRMLyrics : ", arrayIndexOutOfBoundsException0.toString());
                return null;
            }
            catch(IOException iOException0) {
                LogU.e("decodingNonDRMLyrics : ", iOException0.toString());
                return null;
            }
            try {
            label_42:
                bufferedInputStream0.close();
                goto label_52;
            label_44:
                bufferedInputStream0.close();
                arr_b = null;
                goto label_52;
            label_47:
                bufferedInputStream0.close();
                arr_b = null;
                goto label_52;
            label_50:
                bufferedInputStream0.close();
                arr_b = null;
                goto label_52;
            }
            catch(IOException unused_ex) {
                try {
                label_52:
                    if(arr_b == null) {
                        if(file0.exists()) {
                            long v2 = file0.length();
                            if(v2 >= 10L) {
                                goto label_56;
                            }
                            else {
                                goto label_87;
                            }
                        }
                        else {
                            goto label_87;
                        }
                    }
                    goto label_88;
                }
                catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                    LogU.e("decodingNonDRMLyrics : ", arrayIndexOutOfBoundsException0.toString());
                    return null;
                }
                catch(IOException iOException0) {
                    LogU.e("decodingNonDRMLyrics : ", iOException0.toString());
                    return null;
                }
                try {
                label_56:
                    fileInputStream1 = null;
                    fileInputStream1 = new FileInputStream(file0);
                    bufferedInputStream1 = new BufferedInputStream(fileInputStream1, 0x2000);
                }
                catch(Throwable throwable1) {
                    goto label_83;
                }
                try {
                    byte[] arr_b2 = ye.a.T(bufferedInputStream1, 10);
                    if(arr_b2[0] != 73 || (arr_b2[1] != 68 || arr_b2[2] != 51)) {
                        goto label_86;
                    }
                    else {
                        boolean z = (arr_b2[5] & 16) > 0;
                        v3 = f.d(6, arr_b2);
                        if(v3 <= 0x200000) {
                            if(z) {
                                v3 += 10;
                            }
                            if(((long)(v3 + 10)) <= v2) {
                                byte[] arr_b3 = ye.a.T(bufferedInputStream1, v3);
                                arr_b4 = new byte[arr_b2.length + arr_b3.length];
                                System.arraycopy(arr_b2, 0, arr_b4, 0, arr_b2.length);
                                System.arraycopy(arr_b3, 0, arr_b4, arr_b2.length, arr_b3.length);
                                goto label_74;
                            }
                            else {
                                goto label_77;
                            }
                        }
                        else {
                            goto label_79;
                        }
                    }
                    goto label_88;
                }
                catch(Throwable throwable1) {
                    goto label_82;
                }
                try {
                label_74:
                    bufferedInputStream1.close();
                }
                catch(IOException unused_ex) {
                }
                catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                    LogU.e("decodingNonDRMLyrics : ", arrayIndexOutOfBoundsException0.toString());
                    return null;
                }
                arr_b = arr_b4;
                goto label_88;
                try {
                label_77:
                    bufferedInputStream1.close();
                    goto label_87;
                }
                catch(IOException unused_ex) {
                    goto label_87;
                }
                catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                    LogU.e("decodingNonDRMLyrics : ", arrayIndexOutOfBoundsException0.toString());
                    return null;
                }
                try {
                label_79:
                    LogU.e("MyID3", "ID3v2 header size is too big:" + v3);
                    goto label_86;
                }
                catch(Throwable throwable1) {
                label_82:
                    fileInputStream1 = bufferedInputStream1;
                }
            label_83:
                if(fileInputStream1 != null) {
                    try {
                        fileInputStream1.close();
                    }
                    catch(IOException unused_ex) {
                    }
                    catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                        LogU.e("decodingNonDRMLyrics : ", arrayIndexOutOfBoundsException0.toString());
                        return null;
                    }
                }
                try {
                    throw throwable1;
                }
                catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                    LogU.e("decodingNonDRMLyrics : ", arrayIndexOutOfBoundsException0.toString());
                    return null;
                }
                catch(IOException iOException0) {
                    LogU.e("decodingNonDRMLyrics : ", iOException0.toString());
                    return null;
                }
                try {
                label_86:
                    bufferedInputStream1.close();
                }
                catch(IOException unused_ex) {
                }
                catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                    LogU.e("decodingNonDRMLyrics : ", arrayIndexOutOfBoundsException0.toString());
                    return null;
                }
                try {
                label_87:
                    arr_b = null;
                label_88:
                    if(arr_b == null) {
                        l0 = null;
                    }
                    else {
                        f0 = new f(new ByteArrayInputStream(arr_b));
                        while(true) {
                        label_90:
                            if(f0.a()) {
                                goto label_359;
                            }
                            byteArrayOutputStream0 = f0.o;
                            if(f0.a()) {
                                continue;
                            }
                            arr_b5 = f0.r;
                            byteArrayInputStream0 = f0.a;
                            goto label_95;
                        }
                    }
                    goto label_383;
                }
                catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                    LogU.e("decodingNonDRMLyrics : ", arrayIndexOutOfBoundsException0.toString());
                    return null;
                }
                catch(IOException iOException0) {
                    LogU.e("decodingNonDRMLyrics : ", iOException0.toString());
                    return null;
                }
                try {
                label_95:
                    if(byteArrayInputStream0.available() < 0) {
                        f0.e = true;
                    }
                    else if(byteArrayInputStream0.available() < 1) {
                        f0.e = true;
                    }
                    else {
                        if(byteArrayInputStream0.available() < 1) {
                            goto label_90;
                        }
                        int v4 = byteArrayInputStream0.read(arr_b5);
                        if(v4 < 1) {
                            f0.f("unexpected stream closed");
                        }
                        else {
                            byteArrayOutputStream0.write(arr_b5, 0, v4);
                            f0.p += (long)v4;
                        }
                    }
                    goto label_111;
                }
                catch(IOException iOException1) {
                }
                catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                    LogU.e("decodingNonDRMLyrics : ", arrayIndexOutOfBoundsException0.toString());
                    return null;
                }
                try {
                    f0.f(iOException1.getMessage());
                label_111:
                    if(f0.a()) {
                        goto label_90;
                    }
                    if(!f0.f) {
                        if(f0.p >= 10L) {
                            byte[] arr_b6 = byteArrayOutputStream0.toByteArray();
                            if(arr_b6.length >= 10) {
                                int v5 = f0.h;
                                int v6 = v5 + 1;
                                f0.h = v6;
                                if(arr_b6[v5] == 73) {
                                    f0.h = v5 + 2;
                                    if(arr_b6[v6] == 68) {
                                        f0.h = v5 + 3;
                                        if(arr_b6[v5 + 2] != 51) {
                                            f0.d = true;
                                        }
                                    }
                                    else {
                                        f0.d = true;
                                    }
                                }
                                else {
                                    f0.d = true;
                                }
                                if(!f0.c && !f0.d) {
                                    int v7 = f0.h;
                                    f0.h = v7 + 1;
                                    byte b = arr_b6[v7];
                                    f0.j = b;
                                    int v8 = v7 + 2;
                                    f0.h = v8;
                                    int v9 = arr_b6[v7 + 1];
                                    if(b < 2 || b > 4) {
                                        f0.f("Unknown id3v2 Major Version: " + ((int)f0.j));
                                    }
                                    else {
                                        f0.h = v7 + 3;
                                        long v10 = (long)arr_b6[v8];
                                        if(b == 2) {
                                            if((v10 & 0x80L) > 0L) {
                                                f0.k = true;
                                                v11 = v10 ^ 0x80L;
                                            }
                                            else {
                                                v11 = v10;
                                            }
                                            if((v11 & 0x40L) > 0L) {
                                                v11 ^= 0x40L;
                                            }
                                        }
                                        else {
                                            switch(b) {
                                                case 3: {
                                                    if((v10 & 0x80L) > 0L) {
                                                        f0.k = true;
                                                        v11 = v10 ^ 0x80L;
                                                    }
                                                    else {
                                                        v11 = v10;
                                                    }
                                                    if((v11 & 0x40L) > 0L) {
                                                        f0.l = true;
                                                        v11 ^= 0x40L;
                                                    }
                                                    if((v11 & 0x20L) > 0L) {
                                                        v11 ^= 0x20L;
                                                    }
                                                    if((v11 & 16L) > 0L) {
                                                        v11 ^= 16L;
                                                        break;
                                                    }
                                                    break;
                                                }
                                                case 4: {
                                                    if((v10 & 0x80L) > 0L) {
                                                        f0.k = true;
                                                        v11 = v10 ^ 0x80L;
                                                    }
                                                    else {
                                                        v11 = v10;
                                                    }
                                                    if((v11 & 0x40L) > 0L) {
                                                        f0.l = true;
                                                        v11 ^= 0x40L;
                                                    }
                                                    if((v11 & 0x20L) > 0L) {
                                                        v11 ^= 0x20L;
                                                    }
                                                    if((v11 & 16L) > 0L) {
                                                        f0.m = true;
                                                        v11 ^= 16L;
                                                    }
                                                    break;
                                                }
                                                default: {
                                                    f0.f("Unknown id3v2 Major Version: " + ((int)f0.j));
                                                    goto label_196;
                                                }
                                            }
                                        }
                                        if(v11 <= 0L) {
                                            int v12 = f0.e(arr_b6, false);
                                            f0.q = v12 + 10;
                                            f0.i = v12 + 10;
                                            if(f0.m) {
                                                f0.q = v12 + 20;
                                            }
                                            f0.f = true;
                                            if(f0.h != 10) {
                                                f0.f("index!=kHEADER_SIZE");
                                            }
                                        }
                                        else {
                                            f0.f("Unknown id3v2 tag flags(id3v2 version: " + ((int)f0.j) + "): " + Long.toHexString(v10));
                                        }
                                    }
                                }
                            }
                            else {
                                f0.f("missing header");
                            }
                        }
                        else {
                            if(!f0.e) {
                                goto label_90;
                            }
                            f0.c = true;
                            goto label_90;
                        }
                    }
                label_196:
                    if(f0.g) {
                        goto label_90;
                    }
                    if(f0.p >= ((long)f0.q)) {
                        byte[] arr_b7 = byteArrayOutputStream0.toByteArray();
                        if(arr_b7.length >= f0.q) {
                            if(f0.k) {
                                arr_b7 = f.g(arr_b7);
                            }
                            if(f0.l) {
                                f0.h += 4;
                            }
                            v13 = 0;
                        alab1:
                            while(true) {
                            label_205:
                                int v14 = f0.h;
                                if(v14 + 7 >= f0.i || f0.c || v14 + 7 >= f0.i) {
                                    f0.g = true;
                                    f0.b = true;
                                    goto label_90;
                                }
                                if(f0.j >= 3) {
                                    arr_b8 = new byte[4];
                                    f0.h = v14 + 1;
                                    arr_b8[0] = arr_b7[v14];
                                    f0.h = v14 + 2;
                                    arr_b8[1] = arr_b7[v14 + 1];
                                    f0.h = v14 + 3;
                                    arr_b8[2] = arr_b7[v14 + 2];
                                    f0.h = v14 + 4;
                                    arr_b8[3] = arr_b7[v14 + 3];
                                }
                                else {
                                    arr_b8 = new byte[3];
                                    f0.h = v14 + 1;
                                    arr_b8[0] = arr_b7[v14];
                                    f0.h = v14 + 2;
                                    arr_b8[1] = arr_b7[v14 + 1];
                                    f0.h = v14 + 3;
                                    arr_b8[2] = arr_b7[v14 + 2];
                                }
                                v15 = 0;
                            label_226:
                                if(v15 >= arr_b8.length) {
                                    f0.g = true;
                                    f0.b = true;
                                    goto label_90;
                                }
                                if((arr_b8[v15] & 0xFF) <= 0) {
                                    ++v15;
                                    goto label_226;
                                }
                                int v16 = 0;
                                while(v16 < arr_b8.length) {
                                    int v17 = arr_b8[v16] & 0xFF;
                                    if("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".indexOf(((int)(((char)v17)))) >= 0) {
                                        ++v16;
                                        continue;
                                    }
                                    f0.f("invalid id3v2 frame id byte: " + Integer.toHexString(v17));
                                    s1 = null;
                                    goto label_238;
                                }
                                s1 = new String(arr_b8);
                            label_238:
                                if(s1 != null) {
                                    int v18 = f0.j;
                                    if(v18 < 4) {
                                        if(v18 >= 3) {
                                            int v19 = f0.h;
                                            int v20 = v19 + 3;
                                            if(v20 >= f0.q) {
                                            }
                                            else if(v20 >= arr_b7.length) {
                                                f0.f("readInt(index: " + f0.h + ", bytes.length: " + arr_b7.length);
                                                goto label_265;
                                            }
                                            else {
                                                f0.h = v19 + 4;
                                                new int[]{arr_b7[v19] & 0xFF, arr_b7[v19 + 1] & 0xFF, arr_b7[v19 + 2] & 0xFF, arr_b7[v20] & 0xFF};
                                                v21 = arr_b7[v20] & 0xFF | ((arr_b7[v19] & 0xFF) << 24 | (arr_b7[v19 + 1] & 0xFF) << 16 | (arr_b7[v19 + 2] & 0xFF) << 8);
                                                goto label_268;
                                            }
                                            f0.f("readInt(index: " + f0.h + ", tagLength: " + f0.q);
                                        }
                                        else {
                                            int v22 = f0.h;
                                            int v23 = v22 + 2;
                                            if(v23 < f0.q) {
                                                if(v22 + 3 >= arr_b7.length) {
                                                    f0.f("readInt3(index: " + f0.h + ", bytes.length: " + arr_b7.length);
                                                    goto label_265;
                                                }
                                                else {
                                                    f0.h = v22 + 3;
                                                    new int[]{arr_b7[v22] & 0xFF, arr_b7[v22 + 1] & 0xFF, arr_b7[v23] & 0xFF};
                                                    v21 = arr_b7[v23] & 0xFF | ((arr_b7[v22] & 0xFF) << 16 | (arr_b7[v22 + 1] & 0xFF) << 8);
                                                    goto label_268;
                                                }
                                                goto label_264;
                                            }
                                            else {
                                            label_264:
                                                f0.f("readInt3(index: " + f0.h + ", tagLength: " + f0.q);
                                            }
                                        }
                                    label_265:
                                        v21 = -1;
                                    }
                                    else {
                                        v21 = f0.e(arr_b7, true);
                                    }
                                label_268:
                                    int v24 = f0.q;
                                    int v25 = v24 - f0.h;
                                    int v26 = f0.j;
                                    int v27 = f0.h;
                                    if(v26 >= 3) {
                                        v25 += 2;
                                    }
                                    if(v21 != 0) {
                                        if(v21 <= v25 && v21 >= 0) {
                                            switch(v26) {
                                                case 2: {
                                                    d0 = new d();
                                                    break;
                                                }
                                                case 3: 
                                                case 4: {
                                                    if(v27 + 1 >= v24 || v27 + 1 >= arr_b7.length) {
                                                        f0.f("readShort(index: " + f0.h + ", tagLength: " + f0.q + ", bytes.length: " + arr_b7.length);
                                                        v28 = -1;
                                                    }
                                                    else {
                                                        f0.h = v27 + 2;
                                                        new byte[]{arr_b7[v27], arr_b7[v27 + 1]};
                                                        v28 = arr_b7[v27] << 8 | arr_b7[v27 + 1];
                                                    }
                                                    d0 = new d();
                                                    int v29 = f0.j;
                                                    if(v29 == 3) {
                                                        v30 = (v28 & 0x8000) <= 0 ? v28 : 0x8000 ^ v28;
                                                        if((v30 & 0x4000) > 0) {
                                                            v30 ^= 0x4000;
                                                        }
                                                        if((v30 & 0x2000) > 0) {
                                                            v30 ^= 0x2000;
                                                        }
                                                        if((v30 & 0x20) > 0) {
                                                            v30 ^= 0x20;
                                                        }
                                                        if((v30 & 0x80) > 0) {
                                                            v30 ^= 0x80;
                                                        }
                                                        if((v30 & 0x40) > 0) {
                                                            v30 ^= 0x40;
                                                        }
                                                    }
                                                    else if(v29 == 4) {
                                                        v30 = (v28 & 0x4000) <= 0 ? v28 : v28 ^ 0x4000;
                                                        if((v30 & 0x2000) > 0) {
                                                            v30 ^= 0x2000;
                                                        }
                                                        if((v30 & 0x1000) > 0) {
                                                            v30 ^= 0x1000;
                                                        }
                                                        if((v30 & 0x40) > 0) {
                                                            v30 ^= 0x40;
                                                        }
                                                        if((v30 & 8) > 0) {
                                                            v30 ^= 8;
                                                        }
                                                        if((v30 & 4) > 0) {
                                                            v30 ^= 4;
                                                        }
                                                        if((v30 & 2) > 0) {
                                                            d0.a = true;
                                                            v30 ^= 2;
                                                        }
                                                        if((v30 & 1) > 0) {
                                                            d0.b = true;
                                                            v30 ^= 1;
                                                        }
                                                    }
                                                    else {
                                                        v30 = v28;
                                                    }
                                                    if(v30 <= 0) {
                                                        break;
                                                    }
                                                    goto label_346;
                                                }
                                                default: {
                                                    f0.f("Unknown ID3v2 version: " + ((int)f0.j));
                                                    break alab1;
                                                }
                                            }
                                            if(v21 > 0) {
                                                if(d0.b) {
                                                    f0.e(arr_b7, true);
                                                    v21 -= 4;
                                                }
                                                arr_b9 = new byte[v21];
                                                System.arraycopy(arr_b7, f0.h, arr_b9, 0, v21);
                                                f0.h += v21;
                                                if(d0.a) {
                                                    arr_b9 = f.g(arr_b9);
                                                }
                                                LogU.v("MyID3v2Read", "length = " + arr_b9.length + "frameIDString = " + s1);
                                                goto label_337;
                                            }
                                            ++v13;
                                            continue;
                                        }
                                        else {
                                            f0.f("bad frame length(" + v13 + ": " + s1 + "): " + v21 + " (" + new String(arr_b8));
                                            f0.g = true;
                                            f0.b = true;
                                            goto label_90;
                                        }
                                        ++v15;
                                        goto label_226;
                                    }
                                }
                                f0.g = true;
                                f0.b = true;
                                goto label_90;
                            }
                        }
                        else {
                            goto label_353;
                        }
                        f0.b = true;
                        goto label_90;
                    }
                    goto label_356;
                }
                catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                    LogU.e("decodingNonDRMLyrics : ", arrayIndexOutOfBoundsException0.toString());
                    return null;
                }
                catch(IOException iOException0) {
                    LogU.e("decodingNonDRMLyrics : ", iOException0.toString());
                    return null;
                }
                try {
                label_337:
                    "USLT".equals(s1);
                    if(arr_b8[0] != 84) {
                        f0.b(v21, s1, arr_b9);
                    }
                    ++v13;
                    goto label_205;
                }
                catch(IOException iOException2) {
                }
                catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                    LogU.e("decodingNonDRMLyrics : ", arrayIndexOutOfBoundsException0.toString());
                    return null;
                }
                try {
                    f0.f(iOException2.getMessage());
                    f0.b = true;
                    goto label_90;
                label_346:
                    f0.f("Unknown id3v2 frame flags(id3v2 version: " + ((int)f0.j) + "): " + Long.toHexString(v28));
                    f0.b = true;
                    goto label_90;
                label_353:
                    f0.f("missing tag");
                    f0.b = true;
                    goto label_90;
                label_356:
                    if(!f0.e) {
                        goto label_90;
                    }
                    f0.c = true;
                    goto label_90;
                label_359:
                    if(f0.c || (!f0.b || f0.d)) {
                        l0 = null;
                        goto label_383;
                    }
                }
                catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                    LogU.e("decodingNonDRMLyrics : ", arrayIndexOutOfBoundsException0.toString());
                    return null;
                }
                catch(IOException iOException0) {
                    LogU.e("decodingNonDRMLyrics : ", iOException0.toString());
                    return null;
                }
                HashMap hashMap0 = f0.n;
                if(hashMap0 == null) {
                    e0 = null;
                }
                else {
                    try {
                        e0 = new e();
                        for(int v31 = 0; v31 < hashMap0.size(); ++v31) {
                            hashMap0.get(v31);
                        }
                    }
                    catch(Throwable unused_ex) {
                        e0 = null;
                    }
                }
                try {
                    l0 = new l(1, e0, hashMap0);
                    goto label_383;
                }
                catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                    LogU.e("decodingNonDRMLyrics : ", arrayIndexOutOfBoundsException0.toString());
                    return null;
                }
                catch(IOException iOException0) {
                }
            }
            catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                LogU.e("decodingNonDRMLyrics : ", arrayIndexOutOfBoundsException0.toString());
                return null;
            }
            LogU.e("decodingNonDRMLyrics : ", iOException0.toString());
            return null;
        label_383:
            if(l0 != null) {
                Map map0 = (Map)l0.c;
                if(map0 != null && map0.size() > 0) {
                    String s2 = (String)map0.get("USLT");
                    if(TextUtils.isEmpty(s2)) {
                        LogU.i("MusicUtils", "there is no lyrics tag");
                        arrayList0 = null;
                    }
                    else {
                        arrayList0 = new ArrayList();
                        arrayList0.add(new LyricsInfo(0L, ""));
                        String[] arr_s = s2.split("\n");
                        for(int v32 = 0; v32 < arr_s.length; ++v32) {
                            String s3 = arr_s[v32];
                            if(s3 != null && !s3.equals("")) {
                                arrayList0.add(new LyricsInfo(((long)(v32 + 1)), arr_s[v32]));
                            }
                        }
                    }
                    LogU.i("MusicUtils", "add lyrics from mp3 - success");
                    return arrayList0;
                }
            }
        }
        return null;
    }

    public static ArrayList decodeSlfLyrics(String s) {
        e e0;
        l l0;
        byte[] arr_b8;
        int v31;
        int v29;
        d d0;
        int v19;
        String s1;
        int v15;
        byte[] arr_b7;
        int v13;
        long v11;
        ByteArrayInputStream byteArrayInputStream0;
        byte[] arr_b4;
        ByteArrayOutputStream byteArrayOutputStream0;
        f f0;
        int v3;
        BufferedInputStream bufferedInputStream2;
        FileInputStream fileInputStream1;
        BufferedInputStream bufferedInputStream1;
        int v1;
        BufferedInputStream bufferedInputStream0;
        FileInputStream fileInputStream0;
        byte[] arr_b;
        long v;
        LogU.d("MusicUtils", "decodeSlfLyrics - path: " + s);
        if(FilenameUtils.isMusic(s, true)) {
            Context context0 = MelonAppBase.instance.getContext();
            File file0 = new File(u9.f.g.b(context0, "lyric").a(), va.e.h(FilenameUtils.getBasename(s), ".slf"));
            LogU.d("MusicUtils", "decode slf file... " + file0);
            if(!file0.exists()) {
                LogU.w("MusicUtils", "decodeSlfLyrics - lyric file does not exist: " + file0);
                return null;
            }
            try {
                if(!file0.exists()) {
                    l0 = null;
                }
                else if(file0.exists()) {
                    if(file0.exists()) {
                        v = file0.length();
                        if(10L > v) {
                            arr_b = null;
                            goto label_56;
                        }
                        goto label_17;
                    }
                    else {
                        arr_b = null;
                    }
                    goto label_56;
                }
                else {
                    l0 = null;
                }
                goto label_387;
            }
            catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                LogU.e("MusicUtils", "decodingNonDRMLyrics: " + arrayIndexOutOfBoundsException0);
                return null;
            }
            catch(IOException iOException0) {
                LogU.e("MusicUtils", "decodingNonDRMLyrics: " + iOException0);
                return null;
            }
            try {
            label_17:
                fileInputStream0 = new FileInputStream(file0);
            }
            catch(Throwable throwable0) {
                fileInputStream0 = null;
                goto label_46;
            }
            try {
                bufferedInputStream0 = new BufferedInputStream(fileInputStream0, 0x2000);
            }
            catch(Throwable throwable0) {
                goto label_46;
            }
            try {
                bufferedInputStream0.skip(v - 10L);
                byte[] arr_b1 = ye.a.T(bufferedInputStream0, 10);
                if(arr_b1[2] != 51 || (arr_b1[1] != 68 || arr_b1[0] != 73)) {
                    goto label_54;
                }
                else {
                    v1 = f.d(6, arr_b1);
                    if(v1 > 0x200000) {
                        LogU.e("MyID3", "ID3v2 header size is too big:" + v1);
                        goto label_54;
                    }
                    else if(((long)(v1 + 10)) <= v) {
                        bufferedInputStream0.close();
                        goto label_32;
                    }
                    else {
                        goto label_51;
                    }
                }
                goto label_56;
            }
            catch(Throwable throwable0) {
                fileInputStream0 = bufferedInputStream0;
                goto label_46;
            }
            try {
            label_32:
                fileInputStream0 = new FileInputStream(file0);
            }
            catch(Throwable throwable0) {
                fileInputStream0 = null;
                goto label_46;
            }
            try {
                bufferedInputStream1 = new BufferedInputStream(fileInputStream0, 0x2000);
            }
            catch(Throwable throwable0) {
                goto label_46;
            }
            try {
                bufferedInputStream1.skip(v - 10L - ((long)v1) - 10L);
                arr_b = ye.a.T(bufferedInputStream1, v1 + 20);
                goto label_49;
            }
            catch(Throwable throwable0) {
                fileInputStream0 = bufferedInputStream1;
            }
        label_46:
            if(fileInputStream0 != null) {
                try {
                    fileInputStream0.close();
                }
                catch(IOException unused_ex) {
                }
                catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                    LogU.e("MusicUtils", "decodingNonDRMLyrics: " + arrayIndexOutOfBoundsException0);
                    return null;
                }
            }
            try {
                throw throwable0;
            }
            catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                LogU.e("MusicUtils", "decodingNonDRMLyrics: " + arrayIndexOutOfBoundsException0);
                return null;
            }
            catch(IOException iOException0) {
                LogU.e("MusicUtils", "decodingNonDRMLyrics: " + iOException0);
                return null;
            }
            try {
            label_49:
                bufferedInputStream1.close();
                goto label_56;
            label_51:
                bufferedInputStream0.close();
                arr_b = null;
                goto label_56;
            label_54:
                bufferedInputStream0.close();
                arr_b = null;
                goto label_56;
            }
            catch(IOException unused_ex) {
                try {
                label_56:
                    if(arr_b == null) {
                        if(file0.exists()) {
                            long v2 = file0.length();
                            if(v2 >= 10L) {
                                goto label_60;
                            }
                            else {
                                goto label_90;
                            }
                        }
                        else {
                            goto label_90;
                        }
                    }
                    goto label_91;
                }
                catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                    LogU.e("MusicUtils", "decodingNonDRMLyrics: " + arrayIndexOutOfBoundsException0);
                    return null;
                }
                catch(IOException iOException0) {
                    LogU.e("MusicUtils", "decodingNonDRMLyrics: " + iOException0);
                    return null;
                }
                try {
                label_60:
                    fileInputStream1 = null;
                    fileInputStream1 = new FileInputStream(file0);
                    bufferedInputStream2 = new BufferedInputStream(fileInputStream1, 0x2000);
                }
                catch(Throwable throwable1) {
                    goto label_86;
                }
                try {
                    byte[] arr_b2 = ye.a.T(bufferedInputStream2, 10);
                    if(arr_b2[0] != 73 || (arr_b2[1] != 68 || arr_b2[2] != 51)) {
                        goto label_89;
                    }
                    else {
                        boolean z = (arr_b2[5] & 16) > 0;
                        v3 = f.d(6, arr_b2);
                        if(v3 <= 0x200000) {
                            if(z) {
                                v3 += 10;
                            }
                            if(((long)(v3 + 10)) <= v2) {
                                byte[] arr_b3 = ye.a.T(bufferedInputStream2, v3);
                                arr_b = new byte[arr_b2.length + arr_b3.length];
                                System.arraycopy(arr_b2, 0, arr_b, 0, arr_b2.length);
                                System.arraycopy(arr_b3, 0, arr_b, arr_b2.length, arr_b3.length);
                                goto label_78;
                            }
                            else {
                                goto label_80;
                            }
                        }
                        else {
                            goto label_82;
                        }
                    }
                    goto label_91;
                }
                catch(Throwable throwable1) {
                    goto label_85;
                }
                try {
                    try {
                    label_78:
                        bufferedInputStream2.close();
                    }
                    catch(IOException unused_ex) {
                    }
                    goto label_91;
                    try {
                    label_80:
                        bufferedInputStream2.close();
                    }
                    catch(IOException unused_ex) {
                    }
                    goto label_90;
                }
                catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                    LogU.e("MusicUtils", "decodingNonDRMLyrics: " + arrayIndexOutOfBoundsException0);
                    return null;
                }
                try {
                label_82:
                    LogU.e("MyID3", "ID3v2 header size is too big:" + v3);
                    goto label_89;
                }
                catch(Throwable throwable1) {
                label_85:
                    fileInputStream1 = bufferedInputStream2;
                }
            label_86:
                if(fileInputStream1 != null) {
                    try {
                        fileInputStream1.close();
                    }
                    catch(IOException unused_ex) {
                    }
                    catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                        LogU.e("MusicUtils", "decodingNonDRMLyrics: " + arrayIndexOutOfBoundsException0);
                        return null;
                    }
                }
                try {
                    throw throwable1;
                }
                catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                    LogU.e("MusicUtils", "decodingNonDRMLyrics: " + arrayIndexOutOfBoundsException0);
                    return null;
                }
                catch(IOException iOException0) {
                    LogU.e("MusicUtils", "decodingNonDRMLyrics: " + iOException0);
                    return null;
                }
                try {
                label_89:
                    bufferedInputStream2.close();
                }
                catch(IOException unused_ex) {
                }
                catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                    LogU.e("MusicUtils", "decodingNonDRMLyrics: " + arrayIndexOutOfBoundsException0);
                    return null;
                }
                try {
                label_90:
                    arr_b = null;
                label_91:
                    if(arr_b == null) {
                        l0 = null;
                    }
                    else {
                        f0 = new f(new ByteArrayInputStream(arr_b));
                        while(true) {
                        label_93:
                            if(f0.a()) {
                                goto label_363;
                            }
                            byteArrayOutputStream0 = f0.o;
                            if(f0.a()) {
                                continue;
                            }
                            arr_b4 = f0.r;
                            byteArrayInputStream0 = f0.a;
                            goto label_98;
                        }
                    }
                    goto label_387;
                }
                catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                    LogU.e("MusicUtils", "decodingNonDRMLyrics: " + arrayIndexOutOfBoundsException0);
                    return null;
                }
                catch(IOException iOException0) {
                    LogU.e("MusicUtils", "decodingNonDRMLyrics: " + iOException0);
                    return null;
                }
                try {
                label_98:
                    if(byteArrayInputStream0.available() < 0) {
                        f0.e = true;
                    }
                    else if(byteArrayInputStream0.available() < 1) {
                        f0.e = true;
                    }
                    else {
                        if(byteArrayInputStream0.available() < 1) {
                            goto label_93;
                        }
                        int v4 = byteArrayInputStream0.read(arr_b4);
                        if(v4 < 1) {
                            f0.f("unexpected stream closed");
                        }
                        else {
                            byteArrayOutputStream0.write(arr_b4, 0, v4);
                            f0.p += (long)v4;
                        }
                    }
                    goto label_114;
                }
                catch(IOException iOException1) {
                }
                catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                    LogU.e("MusicUtils", "decodingNonDRMLyrics: " + arrayIndexOutOfBoundsException0);
                    return null;
                }
                try {
                    f0.f(iOException1.getMessage());
                label_114:
                    if(f0.a()) {
                        goto label_93;
                    }
                    if(!f0.f) {
                        if(f0.p >= 10L) {
                            byte[] arr_b5 = byteArrayOutputStream0.toByteArray();
                            if(arr_b5.length >= 10) {
                                int v5 = f0.h;
                                int v6 = v5 + 1;
                                f0.h = v6;
                                if(arr_b5[v5] == 73) {
                                    f0.h = v5 + 2;
                                    if(arr_b5[v6] == 68) {
                                        f0.h = v5 + 3;
                                        if(arr_b5[v5 + 2] != 51) {
                                            f0.d = true;
                                        }
                                    }
                                    else {
                                        f0.d = true;
                                    }
                                }
                                else {
                                    f0.d = true;
                                }
                                if(!f0.c && !f0.d) {
                                    int v7 = f0.h;
                                    f0.h = v7 + 1;
                                    byte b = arr_b5[v7];
                                    f0.j = b;
                                    int v8 = v7 + 2;
                                    f0.h = v8;
                                    int v9 = arr_b5[v7 + 1];
                                    if(b < 2 || b > 4) {
                                        f0.f("Unknown id3v2 Major Version: " + ((int)f0.j));
                                    }
                                    else {
                                        f0.h = v7 + 3;
                                        long v10 = (long)arr_b5[v8];
                                        if(b == 2) {
                                            if((v10 & 0x80L) > 0L) {
                                                f0.k = true;
                                                v11 = v10 ^ 0x80L;
                                            }
                                            else {
                                                v11 = v10;
                                            }
                                            if((v11 & 0x40L) > 0L) {
                                                v11 ^= 0x40L;
                                            }
                                        }
                                        else {
                                            switch(b) {
                                                case 3: {
                                                    if((v10 & 0x80L) > 0L) {
                                                        f0.k = true;
                                                        v11 = v10 ^ 0x80L;
                                                    }
                                                    else {
                                                        v11 = v10;
                                                    }
                                                    if((v11 & 0x40L) > 0L) {
                                                        f0.l = true;
                                                        v11 ^= 0x40L;
                                                    }
                                                    if((v11 & 0x20L) > 0L) {
                                                        v11 ^= 0x20L;
                                                    }
                                                    if((v11 & 16L) > 0L) {
                                                        v11 ^= 16L;
                                                        break;
                                                    }
                                                    break;
                                                }
                                                case 4: {
                                                    if((v10 & 0x80L) > 0L) {
                                                        f0.k = true;
                                                        v11 = v10 ^ 0x80L;
                                                    }
                                                    else {
                                                        v11 = v10;
                                                    }
                                                    if((v11 & 0x40L) > 0L) {
                                                        f0.l = true;
                                                        v11 ^= 0x40L;
                                                    }
                                                    if((v11 & 0x20L) > 0L) {
                                                        v11 ^= 0x20L;
                                                    }
                                                    if((v11 & 16L) > 0L) {
                                                        f0.m = true;
                                                        v11 ^= 16L;
                                                    }
                                                    break;
                                                }
                                                default: {
                                                    f0.f("Unknown id3v2 Major Version: " + ((int)f0.j));
                                                    goto label_199;
                                                }
                                            }
                                        }
                                        if(v11 <= 0L) {
                                            int v12 = f0.e(arr_b5, false);
                                            f0.q = v12 + 10;
                                            f0.i = v12 + 10;
                                            if(f0.m) {
                                                f0.q = v12 + 20;
                                            }
                                            f0.f = true;
                                            if(f0.h != 10) {
                                                f0.f("index!=kHEADER_SIZE");
                                            }
                                        }
                                        else {
                                            f0.f("Unknown id3v2 tag flags(id3v2 version: " + ((int)f0.j) + "): " + Long.toHexString(v10));
                                        }
                                    }
                                }
                            }
                            else {
                                f0.f("missing header");
                            }
                        }
                        else {
                            if(!f0.e) {
                                goto label_93;
                            }
                            f0.c = true;
                            goto label_93;
                        }
                    }
                label_199:
                    if(f0.g) {
                        goto label_93;
                    }
                    if(f0.p >= ((long)f0.q)) {
                        byte[] arr_b6 = byteArrayOutputStream0.toByteArray();
                        if(arr_b6.length >= f0.q) {
                            if(f0.k) {
                                arr_b6 = f.g(arr_b6);
                            }
                            if(f0.l) {
                                f0.h += 4;
                            }
                            v13 = 0;
                        alab1:
                            while(true) {
                            label_208:
                                int v14 = f0.h;
                                if(v14 + 7 >= f0.i || f0.c || v14 + 7 >= f0.i) {
                                    f0.g = true;
                                    f0.b = true;
                                    goto label_93;
                                }
                                if(f0.j >= 3) {
                                    arr_b7 = new byte[4];
                                    f0.h = v14 + 1;
                                    arr_b7[0] = arr_b6[v14];
                                    f0.h = v14 + 2;
                                    arr_b7[1] = arr_b6[v14 + 1];
                                    f0.h = v14 + 3;
                                    arr_b7[2] = arr_b6[v14 + 2];
                                    f0.h = v14 + 4;
                                    arr_b7[3] = arr_b6[v14 + 3];
                                }
                                else {
                                    arr_b7 = new byte[3];
                                    f0.h = v14 + 1;
                                    arr_b7[0] = arr_b6[v14];
                                    f0.h = v14 + 2;
                                    arr_b7[1] = arr_b6[v14 + 1];
                                    f0.h = v14 + 3;
                                    arr_b7[2] = arr_b6[v14 + 2];
                                }
                                v15 = 0;
                            label_229:
                                if(v15 >= arr_b7.length) {
                                    f0.g = true;
                                    f0.b = true;
                                    goto label_93;
                                }
                                if((arr_b7[v15] & 0xFF) <= 0) {
                                    ++v15;
                                    goto label_229;
                                }
                                int v16 = 0;
                                while(v16 < arr_b7.length) {
                                    int v17 = arr_b7[v16] & 0xFF;
                                    if("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".indexOf(((int)(((char)v17)))) >= 0) {
                                        ++v16;
                                        continue;
                                    }
                                    f0.f("invalid id3v2 frame id byte: " + Integer.toHexString(v17));
                                    s1 = null;
                                    goto label_241;
                                }
                                s1 = new String(arr_b7);
                            label_241:
                                if(s1 != null) {
                                    int v18 = f0.j;
                                    if(v18 >= 4) {
                                        v19 = f0.e(arr_b6, true);
                                    }
                                    else {
                                        if(v18 >= 3) {
                                            int v20 = f0.h;
                                            int v21 = v20 + 3;
                                            if(v21 >= f0.q) {
                                            }
                                            else if(v21 < arr_b6.length) {
                                                f0.h = v20 + 1;
                                                int v22 = arr_b6[v20];
                                                f0.h = v20 + 4;
                                                new int[]{v22 & 0xFF, arr_b6[v20 + 1] & 0xFF, arr_b6[v20 + 2] & 0xFF, arr_b6[v21] & 0xFF};
                                                v19 = arr_b6[v21] & 0xFF | ((v22 & 0xFF) << 24 | (arr_b6[v20 + 1] & 0xFF) << 16 | (arr_b6[v20 + 2] & 0xFF) << 8);
                                                goto label_273;
                                            }
                                            else {
                                                f0.f("readInt(index: " + f0.h + ", bytes.length: " + arr_b6.length);
                                                goto label_272;
                                            }
                                            f0.f("readInt(index: " + f0.h + ", tagLength: " + f0.q);
                                        }
                                        else {
                                            int v23 = f0.h;
                                            int v24 = v23 + 2;
                                            if(v24 < f0.q) {
                                                if(v23 + 3 < arr_b6.length) {
                                                    f0.h = v23 + 3;
                                                    new int[]{arr_b6[v23] & 0xFF, arr_b6[v23 + 1] & 0xFF, arr_b6[v24] & 0xFF};
                                                    v19 = arr_b6[v24] & 0xFF | ((arr_b6[v23] & 0xFF) << 16 | (arr_b6[v23 + 1] & 0xFF) << 8);
                                                    goto label_273;
                                                }
                                                else {
                                                    f0.f("readInt3(index: " + f0.h + ", bytes.length: " + arr_b6.length);
                                                    goto label_272;
                                                }
                                                goto label_271;
                                            }
                                            else {
                                            label_271:
                                                f0.f("readInt3(index: " + f0.h + ", tagLength: " + f0.q);
                                            }
                                        }
                                    label_272:
                                        v19 = -1;
                                    }
                                label_273:
                                    int v25 = f0.q;
                                    int v26 = v25 - f0.h;
                                    int v27 = f0.j;
                                    int v28 = f0.h;
                                    if(v27 >= 3) {
                                        v26 += 2;
                                    }
                                    if(v19 != 0) {
                                        if(v19 <= v26 && v19 >= 0) {
                                            switch(v27) {
                                                case 2: {
                                                    d0 = new d();
                                                    break;
                                                }
                                                case 3: 
                                                case 4: {
                                                    if(v28 + 1 >= v25 || v28 + 1 >= arr_b6.length) {
                                                        f0.f("readShort(index: " + f0.h + ", tagLength: " + f0.q + ", bytes.length: " + arr_b6.length);
                                                        v29 = -1;
                                                    }
                                                    else {
                                                        f0.h = v28 + 2;
                                                        new byte[]{arr_b6[v28], arr_b6[v28 + 1]};
                                                        v29 = arr_b6[v28] << 8 | arr_b6[v28 + 1];
                                                    }
                                                    d d1 = new d();
                                                    int v30 = f0.j;
                                                    if(v30 == 3) {
                                                        v31 = (v29 & 0x8000) <= 0 ? v29 : 0x8000 ^ v29;
                                                        if((v31 & 0x4000) > 0) {
                                                            v31 ^= 0x4000;
                                                        }
                                                        if((v31 & 0x2000) > 0) {
                                                            v31 ^= 0x2000;
                                                        }
                                                        if((v31 & 0x20) > 0) {
                                                            v31 ^= 0x20;
                                                        }
                                                        if((v31 & 0x80) > 0) {
                                                            v31 ^= 0x80;
                                                        }
                                                        if((v31 & 0x40) > 0) {
                                                            v31 ^= 0x40;
                                                        }
                                                    }
                                                    else if(v30 == 4) {
                                                        v31 = (v29 & 0x4000) <= 0 ? v29 : v29 ^ 0x4000;
                                                        if((v31 & 0x2000) > 0) {
                                                            v31 ^= 0x2000;
                                                        }
                                                        if((v31 & 0x1000) > 0) {
                                                            v31 ^= 0x1000;
                                                        }
                                                        if((v31 & 0x40) > 0) {
                                                            v31 ^= 0x40;
                                                        }
                                                        if((v31 & 8) > 0) {
                                                            v31 ^= 8;
                                                        }
                                                        if((v31 & 4) > 0) {
                                                            v31 ^= 4;
                                                        }
                                                        if((v31 & 2) > 0) {
                                                            d1.a = true;
                                                            v31 ^= 2;
                                                        }
                                                        if((v31 & 1) > 0) {
                                                            d1.b = true;
                                                            v31 ^= 1;
                                                        }
                                                    }
                                                    else {
                                                        v31 = v29;
                                                    }
                                                    if(v31 <= 0) {
                                                        d0 = d1;
                                                    }
                                                    else {
                                                        goto label_351;
                                                    }
                                                    break;
                                                }
                                                default: {
                                                    f0.f("Unknown ID3v2 version: " + ((int)f0.j));
                                                    break alab1;
                                                }
                                            }
                                            if(v19 > 0) {
                                                if(d0.b) {
                                                    f0.e(arr_b6, true);
                                                    v19 -= 4;
                                                }
                                                arr_b8 = new byte[v19];
                                                System.arraycopy(arr_b6, f0.h, arr_b8, 0, v19);
                                                f0.h += v19;
                                                if(d0.a) {
                                                    arr_b8 = f.g(arr_b8);
                                                }
                                                LogU.v("MyID3v2Read", "length = " + arr_b8.length + "frameIDString = " + s1);
                                                goto label_342;
                                            }
                                            ++v13;
                                            continue;
                                        }
                                        else {
                                            f0.f("bad frame length(" + v13 + ": " + s1 + "): " + v19 + " (" + new String(arr_b7));
                                            f0.g = true;
                                            f0.b = true;
                                            goto label_93;
                                        }
                                        ++v15;
                                        goto label_229;
                                    }
                                }
                                f0.g = true;
                                f0.b = true;
                                goto label_93;
                            }
                        }
                        else {
                            goto label_357;
                        }
                        f0.b = true;
                        goto label_93;
                    }
                    goto label_360;
                }
                catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                    LogU.e("MusicUtils", "decodingNonDRMLyrics: " + arrayIndexOutOfBoundsException0);
                    return null;
                }
                catch(IOException iOException0) {
                    LogU.e("MusicUtils", "decodingNonDRMLyrics: " + iOException0);
                    return null;
                }
                try {
                label_342:
                    "USLT".equals(s1);
                    if(arr_b7[0] != 84) {
                        f0.b(v19, s1, arr_b8);
                    }
                    ++v13;
                    goto label_208;
                }
                catch(IOException iOException2) {
                }
                catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                    LogU.e("MusicUtils", "decodingNonDRMLyrics: " + arrayIndexOutOfBoundsException0);
                    return null;
                }
                try {
                    f0.f(iOException2.getMessage());
                    f0.b = true;
                    goto label_93;
                label_351:
                    f0.f("Unknown id3v2 frame flags(id3v2 version: " + ((int)f0.j) + "): " + Long.toHexString(v29));
                    f0.b = true;
                    goto label_93;
                label_357:
                    f0.f("missing tag");
                    f0.b = true;
                    goto label_93;
                label_360:
                    if(!f0.e) {
                        goto label_93;
                    }
                    f0.c = true;
                    goto label_93;
                label_363:
                    if(f0.c || (!f0.b || f0.d)) {
                        l0 = null;
                        goto label_387;
                    }
                }
                catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                    LogU.e("MusicUtils", "decodingNonDRMLyrics: " + arrayIndexOutOfBoundsException0);
                    return null;
                }
                catch(IOException iOException0) {
                    LogU.e("MusicUtils", "decodingNonDRMLyrics: " + iOException0);
                    return null;
                }
                HashMap hashMap0 = f0.n;
                if(hashMap0 == null) {
                    e0 = null;
                }
                else {
                    try {
                        e0 = new e();
                        for(int v32 = 0; v32 < hashMap0.size(); ++v32) {
                            hashMap0.get(v32);
                        }
                    }
                    catch(Throwable unused_ex) {
                        e0 = null;
                    }
                }
                try {
                    l0 = new l(1, e0, hashMap0);
                    goto label_387;
                }
                catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                    LogU.e("MusicUtils", "decodingNonDRMLyrics: " + arrayIndexOutOfBoundsException0);
                    return null;
                }
                catch(IOException iOException0) {
                }
            }
            catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                LogU.e("MusicUtils", "decodingNonDRMLyrics: " + arrayIndexOutOfBoundsException0);
                return null;
            }
            LogU.e("MusicUtils", "decodingNonDRMLyrics: " + iOException0);
            return null;
        label_387:
            LogU.i("MusicUtils", "add lyrics from slf - try: " + file0);
            if(l0 != null) {
                Map map0 = (Map)l0.c;
                if(map0 != null && map0.size() > 0) {
                    ArrayList arrayList0 = (ArrayList)map0.get("XSYL");
                    LogU.d("MusicUtils", "add lyrics from slf - success");
                    return arrayList0;
                }
            }
        }
        else {
            LogU.e("MusicUtils", "not supported audio file: " + s);
        }
        LogU.w("MusicUtils", "decodeSlfLyrics failed");
        return null;
    }

    public static ArrayList decodeStreamLyrics(Context context0, String s, String s1) {
        return MusicUtils.decodingStreamLyrics(context0, s, s1, null);
    }

    public static ArrayList decodingStreamLyrics(Context context0, String s, String s1, String s2) {
        e e0;
        l l0;
        byte[] arr_b9;
        int v31;
        int v29;
        int v22;
        String s5;
        int v16;
        byte[] arr_b8;
        int v14;
        long v12;
        long v11;
        byte[] arr_b6;
        ByteArrayInputStream byteArrayInputStream0;
        byte[] arr_b5;
        ByteArrayOutputStream byteArrayOutputStream0;
        f f0;
        byte[] arr_b4;
        int v4;
        BufferedInputStream bufferedInputStream2;
        FileInputStream fileInputStream1;
        BufferedInputStream bufferedInputStream1;
        int v2;
        BufferedInputStream bufferedInputStream0;
        FileInputStream fileInputStream0;
        byte[] arr_b;
        long v1;
        String s3 = u9.f.g.b(context0, "streamlyric").f;
        String s4 = TextUtils.isEmpty(s2) ? s1 + ".slf" : s2;
        MusicUtils.maintainStreamingLyricsFiles(s3);
        MusicUtils.checkStreamingLyricsExist(s4, s3);
        synchronized(s4) {
            File file0 = new File(s3 + s4);
            try {
                if(!file0.exists()) {
                    l0 = null;
                }
                else if(file0.exists()) {
                    if(file0.exists()) {
                        v1 = file0.length();
                        if(10L > v1) {
                            arr_b = null;
                            goto label_56;
                        }
                        goto label_16;
                    }
                    else {
                        arr_b = null;
                    }
                    goto label_56;
                }
                else {
                    l0 = null;
                }
                goto label_391;
            }
            catch(IOException iOException0) {
                goto label_382;
            }
            catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                LogU.e("MusicUtils", "MyId3 read error ", arrayIndexOutOfBoundsException0);
                return null;
            }
            try {
            label_16:
                fileInputStream0 = new FileInputStream(file0);
            }
            catch(Throwable throwable0) {
                fileInputStream0 = null;
                goto label_45;
            }
            try {
                bufferedInputStream0 = new BufferedInputStream(fileInputStream0, 0x2000);
            }
            catch(Throwable throwable0) {
                goto label_45;
            }
            try {
                bufferedInputStream0.skip(v1 - 10L);
                byte[] arr_b1 = ye.a.T(bufferedInputStream0, 10);
                if(arr_b1[2] != 51 || (arr_b1[1] != 68 || arr_b1[0] != 73)) {
                    goto label_54;
                }
                else {
                    v2 = f.d(6, arr_b1);
                    if(v2 > 0x200000) {
                        LogU.e("MyID3", "ID3v2 header size is too big:" + v2);
                        goto label_54;
                    }
                    else if(((long)(v2 + 10)) <= v1) {
                        bufferedInputStream0.close();
                        goto label_30;
                    }
                    else {
                        goto label_51;
                    }
                }
                goto label_56;
            }
            catch(Throwable throwable0) {
                fileInputStream0 = bufferedInputStream0;
                goto label_45;
            }
            try {
            label_30:
                bufferedInputStream0 = new FileInputStream(file0);
            }
            catch(Throwable throwable0) {
                fileInputStream0 = null;
                goto label_45;
            }
            try {
                bufferedInputStream1 = new BufferedInputStream(bufferedInputStream0, 0x2000);
            }
            catch(Throwable throwable0) {
                fileInputStream0 = bufferedInputStream0;
                goto label_45;
            }
            try {
                bufferedInputStream1.skip(v1 - 10L - ((long)v2) - 10L);
                arr_b = ye.a.T(bufferedInputStream1, v2 + 20);
                goto label_49;
            }
            catch(Throwable throwable0) {
                fileInputStream0 = bufferedInputStream1;
            }
        label_45:
            if(fileInputStream0 != null) {
                try {
                    try {
                        fileInputStream0.close();
                    }
                    catch(IOException unused_ex) {
                    }
                    try {
                        throw throwable0;
                    }
                    catch(IOException iOException0) {
                        goto label_382;
                    }
                    try {
                    label_49:
                        bufferedInputStream1.close();
                        goto label_56;
                    label_51:
                        bufferedInputStream0.close();
                        arr_b = null;
                        goto label_56;
                    label_54:
                        bufferedInputStream0.close();
                        arr_b = null;
                    }
                    catch(IOException unused_ex) {
                    }
                    try {
                    label_56:
                        if(arr_b == null) {
                            if(file0.exists()) {
                                long v3 = file0.length();
                                if(v3 >= 10L) {
                                    goto label_60;
                                }
                                else {
                                    goto label_92;
                                }
                            }
                            else {
                                goto label_92;
                            }
                        }
                        goto label_93;
                    }
                    catch(IOException iOException0) {
                        goto label_382;
                    }
                }
                catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                    LogU.e("MusicUtils", "MyId3 read error ", arrayIndexOutOfBoundsException0);
                    return null;
                }
            }
            throw throwable0;
            try {
            label_60:
                fileInputStream1 = null;
                fileInputStream1 = new FileInputStream(file0);
                bufferedInputStream2 = new BufferedInputStream(fileInputStream1, 0x2000);
            }
            catch(Throwable throwable1) {
                goto label_87;
            }
            try {
                byte[] arr_b2 = ye.a.T(bufferedInputStream2, 10);
                if(arr_b2[0] != 73 || (arr_b2[1] != 68 || arr_b2[2] != 51)) {
                    goto label_91;
                }
                else {
                    boolean z = (arr_b2[5] & 16) > 0;
                    v4 = f.d(6, arr_b2);
                    if(v4 <= 0x200000) {
                        if(z) {
                            v4 += 10;
                        }
                        if(((long)(v4 + 10)) <= v3) {
                            byte[] arr_b3 = ye.a.T(bufferedInputStream2, v4);
                            arr_b4 = new byte[arr_b2.length + arr_b3.length];
                            System.arraycopy(arr_b2, 0, arr_b4, 0, arr_b2.length);
                            System.arraycopy(arr_b3, 0, arr_b4, arr_b2.length, arr_b3.length);
                            goto label_78;
                        }
                        else {
                            goto label_81;
                        }
                    }
                    else {
                        goto label_83;
                    }
                }
                goto label_93;
            }
            catch(Throwable throwable1) {
                goto label_86;
            }
            try {
            label_78:
                bufferedInputStream2.close();
                arr_b = arr_b4;
                goto label_93;
            }
            catch(IOException unused_ex) {
                arr_b = arr_b4;
                goto label_93;
                try {
                label_81:
                    bufferedInputStream2.close();
                    goto label_92;
                }
                catch(IOException unused_ex) {
                    goto label_92;
                }
                catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                    LogU.e("MusicUtils", "MyId3 read error ", arrayIndexOutOfBoundsException0);
                    return null;
                }
                try {
                label_83:
                    LogU.e("MyID3", "ID3v2 header size is too big:" + v4);
                    goto label_91;
                }
                catch(Throwable throwable1) {
                label_86:
                    fileInputStream1 = bufferedInputStream2;
                }
            label_87:
                if(fileInputStream1 != null) {
                    try {
                        try {
                            fileInputStream1.close();
                        }
                        catch(IOException unused_ex) {
                        }
                        try {
                            throw throwable1;
                        }
                        catch(IOException iOException0) {
                            goto label_382;
                        }
                        try {
                        label_91:
                            bufferedInputStream2.close();
                        }
                        catch(IOException unused_ex) {
                        }
                        try {
                        label_92:
                            arr_b = null;
                        label_93:
                            if(arr_b == null) {
                                l0 = null;
                            }
                            else {
                                f0 = new f(new ByteArrayInputStream(arr_b));
                                while(true) {
                                label_95:
                                    if(f0.a()) {
                                        goto label_363;
                                    }
                                    byteArrayOutputStream0 = f0.o;
                                    if(f0.a()) {
                                        continue;
                                    }
                                    arr_b5 = f0.r;
                                    byteArrayInputStream0 = f0.a;
                                    goto label_100;
                                }
                            }
                            goto label_391;
                        }
                        catch(IOException iOException0) {
                            goto label_382;
                        }
                        try {
                        label_100:
                            if(byteArrayInputStream0.available() < 0) {
                                f0.e = true;
                            }
                            else if(byteArrayInputStream0.available() < 1) {
                                f0.e = true;
                            }
                            else {
                                if(byteArrayInputStream0.available() < 1) {
                                    goto label_95;
                                }
                                int v5 = byteArrayInputStream0.read(arr_b5);
                                if(v5 < 1) {
                                    f0.f("unexpected stream closed");
                                }
                                else {
                                    byteArrayOutputStream0.write(arr_b5, 0, v5);
                                    f0.p += (long)v5;
                                }
                            }
                            goto label_116;
                        }
                        catch(IOException iOException1) {
                        }
                        try {
                            f0.f(iOException1.getMessage());
                        label_116:
                            if(f0.a()) {
                                goto label_95;
                            }
                            if(!f0.f) {
                                if(f0.p >= 10L) {
                                    arr_b6 = byteArrayOutputStream0.toByteArray();
                                    if(arr_b6.length >= 10) {
                                        int v6 = f0.h;
                                        int v7 = v6 + 1;
                                        f0.h = v7;
                                        if(arr_b6[v6] == 73) {
                                            f0.h = v6 + 2;
                                            if(arr_b6[v7] == 68) {
                                                f0.h = v6 + 3;
                                                if(arr_b6[v6 + 2] != 51) {
                                                    f0.d = true;
                                                }
                                            }
                                            else {
                                                f0.d = true;
                                            }
                                        }
                                        else {
                                            f0.d = true;
                                        }
                                        if(!f0.c && !f0.d) {
                                            int v8 = f0.h;
                                            f0.h = v8 + 1;
                                            byte b = arr_b6[v8];
                                            f0.j = b;
                                            int v9 = v8 + 2;
                                            f0.h = v9;
                                            int v10 = arr_b6[v8 + 1];
                                            if(b < 2 || b > 4) {
                                                goto label_194;
                                            }
                                            else {
                                                f0.h = v8 + 3;
                                                v11 = (long)arr_b6[v9];
                                                if(b == 2) {
                                                    if((v11 & 0x80L) > 0L) {
                                                        f0.k = true;
                                                        v12 = v11 ^ 0x80L;
                                                    }
                                                    else {
                                                        v12 = v11;
                                                    }
                                                    if((v12 & 0x40L) > 0L) {
                                                        v12 ^= 0x40L;
                                                    }
                                                }
                                                else {
                                                    switch(b) {
                                                        case 3: {
                                                            goto label_157;
                                                        }
                                                        case 4: {
                                                            goto label_169;
                                                        }
                                                    }
                                                    f0.f("Unknown id3v2 Major Version: " + ((int)f0.j));
                                                    goto label_201;
                                                label_157:
                                                    if((v11 & 0x80L) > 0L) {
                                                        f0.k = true;
                                                        v12 = v11 ^ 0x80L;
                                                    }
                                                    else {
                                                        v12 = v11;
                                                    }
                                                    if((v12 & 0x40L) > 0L) {
                                                        f0.l = true;
                                                        v12 ^= 0x40L;
                                                    }
                                                    if((v12 & 0x20L) > 0L) {
                                                        v12 ^= 0x20L;
                                                    }
                                                    if((v12 & 16L) > 0L) {
                                                        goto label_181;
                                                    }
                                                }
                                                goto label_182;
                                            }
                                        }
                                    }
                                    else {
                                        goto label_196;
                                    }
                                }
                                else {
                                    goto label_198;
                                }
                            }
                            goto label_201;
                        }
                        catch(IOException iOException0) {
                            goto label_382;
                        }
                        goto label_181;
                        try {
                        label_169:
                            if((v11 & 0x80L) > 0L) {
                                f0.k = true;
                                v12 = v11 ^ 0x80L;
                            }
                            else {
                                v12 = v11;
                            }
                            if((v12 & 0x40L) > 0L) {
                                f0.l = true;
                                v12 ^= 0x40L;
                            }
                            if((v12 & 0x20L) > 0L) {
                                v12 ^= 0x20L;
                            }
                            if((v12 & 16L) > 0L) {
                                f0.m = true;
                            label_181:
                                v12 ^= 16L;
                            }
                        label_182:
                            if(v12 <= 0L) {
                                int v13 = f0.e(arr_b6, ((boolean)0));
                                f0.q = v13 + 10;
                                f0.i = v13 + 10;
                                if(f0.m) {
                                    f0.q = v13 + 20;
                                }
                                f0.f = true;
                                if(f0.h != 10) {
                                    f0.f("index!=kHEADER_SIZE");
                                }
                            }
                            else {
                                f0.f("Unknown id3v2 tag flags(id3v2 version: " + ((int)f0.j) + "): " + Long.toHexString(v11));
                                goto label_201;
                            label_194:
                                f0.f("Unknown id3v2 Major Version: " + ((int)f0.j));
                                goto label_201;
                            label_196:
                                f0.f("missing header");
                                goto label_201;
                            label_198:
                                if(!f0.e) {
                                    goto label_95;
                                }
                                f0.c = true;
                                goto label_95;
                            }
                        label_201:
                            if(f0.g) {
                                goto label_95;
                            }
                            if(f0.p >= ((long)f0.q)) {
                                byte[] arr_b7 = byteArrayOutputStream0.toByteArray();
                                if(arr_b7.length >= f0.q) {
                                    if(f0.k) {
                                        arr_b7 = f.g(arr_b7);
                                    }
                                    if(f0.l) {
                                        f0.h += 4;
                                    }
                                    v14 = 0;
                                    while(true) {
                                    label_210:
                                        int v15 = f0.h;
                                        if(v15 + 7 >= f0.i || f0.c || v15 + 7 >= f0.i) {
                                            f0.g = true;
                                            f0.b = true;
                                            goto label_95;
                                        }
                                        if(f0.j >= 3) {
                                            arr_b8 = new byte[4];
                                            f0.h = v15 + 1;
                                            arr_b8[0] = arr_b7[v15];
                                            f0.h = v15 + 2;
                                            arr_b8[1] = arr_b7[v15 + 1];
                                            f0.h = v15 + 3;
                                            arr_b8[2] = arr_b7[v15 + 2];
                                            f0.h = v15 + 4;
                                            arr_b8[3] = arr_b7[v15 + 3];
                                        }
                                        else {
                                            arr_b8 = new byte[3];
                                            f0.h = v15 + 1;
                                            arr_b8[0] = arr_b7[v15];
                                            f0.h = v15 + 2;
                                            arr_b8[1] = arr_b7[v15 + 1];
                                            f0.h = v15 + 3;
                                            arr_b8[2] = arr_b7[v15 + 2];
                                        }
                                        v16 = 0;
                                    label_231:
                                        if(v16 >= arr_b8.length) {
                                            f0.g = true;
                                            f0.b = true;
                                            goto label_95;
                                        }
                                        if((arr_b8[v16] & 0xFF) <= 0) {
                                            ++v16;
                                            goto label_231;
                                        }
                                        int v17 = 0;
                                        while(v17 < arr_b8.length) {
                                            int v18 = arr_b8[v17] & 0xFF;
                                            if("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".indexOf(((int)(((char)v18)))) >= 0) {
                                                ++v17;
                                                continue;
                                            }
                                            f0.f("invalid id3v2 frame id byte: " + Integer.toHexString(v18));
                                            s5 = null;
                                            goto label_243;
                                        }
                                        s5 = new String(arr_b8);
                                    label_243:
                                        if(s5 != null) {
                                            int v19 = f0.j;
                                            if(v19 < 4) {
                                                if(v19 >= 3) {
                                                    int v20 = f0.h;
                                                    int v21 = v20 + 3;
                                                    if(v21 >= f0.q) {
                                                    }
                                                    else if(v21 >= arr_b7.length) {
                                                        f0.f("readInt(index: " + f0.h + ", bytes.length: " + arr_b7.length);
                                                        goto label_270;
                                                    }
                                                    else {
                                                        f0.h = v20 + 4;
                                                        new int[]{arr_b7[v20] & 0xFF, arr_b7[v20 + 1] & 0xFF, arr_b7[v20 + 2] & 0xFF, arr_b7[v21] & 0xFF};
                                                        v22 = arr_b7[v21] & 0xFF | ((arr_b7[v20] & 0xFF) << 24 | (arr_b7[v20 + 1] & 0xFF) << 16 | (arr_b7[v20 + 2] & 0xFF) << 8);
                                                        goto label_273;
                                                    }
                                                    f0.f("readInt(index: " + f0.h + ", tagLength: " + f0.q);
                                                }
                                                else {
                                                    int v23 = f0.h;
                                                    int v24 = v23 + 2;
                                                    if(v24 < f0.q) {
                                                        if(v23 + 3 >= arr_b7.length) {
                                                            f0.f("readInt3(index: " + f0.h + ", bytes.length: " + arr_b7.length);
                                                            goto label_270;
                                                        }
                                                        else {
                                                            f0.h = v23 + 3;
                                                            new int[]{arr_b7[v23] & 0xFF, arr_b7[v23 + 1] & 0xFF, arr_b7[v24] & 0xFF};
                                                            v22 = arr_b7[v24] & 0xFF | ((arr_b7[v23] & 0xFF) << 16 | (arr_b7[v23 + 1] & 0xFF) << 8);
                                                            goto label_273;
                                                        }
                                                        goto label_269;
                                                    }
                                                    else {
                                                    label_269:
                                                        f0.f("readInt3(index: " + f0.h + ", tagLength: " + f0.q);
                                                    }
                                                }
                                            label_270:
                                                v22 = -1;
                                            }
                                            else {
                                                v22 = f0.e(arr_b7, true);
                                            }
                                        label_273:
                                            int v25 = f0.q;
                                            int v26 = f0.h;
                                            int v27 = v25 - v26;
                                            int v28 = f0.j;
                                            if(v28 >= 3) {
                                                v27 += 2;
                                            }
                                            if(v22 != 0) {
                                                if(v22 <= v27 && v22 >= 0) {
                                                    switch(v28) {
                                                        case 2: {
                                                            goto label_286;
                                                        }
                                                        case 3: 
                                                        case 4: {
                                                            goto label_288;
                                                        }
                                                    }
                                                    f0.f("Unknown ID3v2 version: " + ((int)f0.j));
                                                    break;
                                                label_286:
                                                    d d0 = new d();
                                                    goto label_332;
                                                label_288:
                                                    if(v26 + 1 >= v25 || v26 + 1 >= arr_b7.length) {
                                                        f0.f("readShort(index: " + f0.h + ", tagLength: " + f0.q + ", bytes.length: " + arr_b7.length);
                                                        v29 = -1;
                                                    }
                                                    else {
                                                        f0.h = v26 + 2;
                                                        new byte[]{arr_b7[v26], arr_b7[v26 + 1]};
                                                        v29 = arr_b7[v26] << 8 | arr_b7[v26 + 1];
                                                    }
                                                    d d1 = new d();
                                                    int v30 = f0.j;
                                                    if(v30 == 3) {
                                                        v31 = (v29 & 0x8000) <= 0 ? v29 : 0x8000 ^ v29;
                                                        if((v31 & 0x4000) > 0) {
                                                            v31 ^= 0x4000;
                                                        }
                                                        if((v31 & 0x2000) > 0) {
                                                            v31 ^= 0x2000;
                                                        }
                                                        if((v31 & 0x20) > 0) {
                                                            v31 ^= 0x20;
                                                        }
                                                        if((v31 & 0x80) > 0) {
                                                            v31 ^= 0x80;
                                                        }
                                                        if((v31 & 0x40) > 0) {
                                                            v31 ^= 0x40;
                                                        }
                                                    }
                                                    else if(v30 == 4) {
                                                        v31 = (v29 & 0x4000) <= 0 ? v29 : v29 ^ 0x4000;
                                                        if((v31 & 0x2000) > 0) {
                                                            v31 ^= 0x2000;
                                                        }
                                                        if((v31 & 0x1000) > 0) {
                                                            v31 ^= 0x1000;
                                                        }
                                                        if((v31 & 0x40) > 0) {
                                                            v31 ^= 0x40;
                                                        }
                                                        if((v31 & 8) > 0) {
                                                            v31 ^= 8;
                                                        }
                                                        if((v31 & 4) > 0) {
                                                            v31 ^= 4;
                                                        }
                                                        if((v31 & 2) > 0) {
                                                            d1.a = true;
                                                            v31 ^= 2;
                                                        }
                                                        if((v31 & 1) > 0) {
                                                            d1.b = true;
                                                            v31 ^= 1;
                                                        }
                                                    }
                                                    else {
                                                        v31 = v29;
                                                    }
                                                    if(v31 <= 0) {
                                                        d0 = d1;
                                                    }
                                                    else {
                                                        goto label_351;
                                                    }
                                                label_332:
                                                    if(v22 > 0) {
                                                        if(d0.b) {
                                                            f0.e(arr_b7, true);
                                                            v22 -= 4;
                                                        }
                                                        arr_b9 = new byte[v22];
                                                        System.arraycopy(arr_b7, f0.h, arr_b9, 0, v22);
                                                        f0.h += v22;
                                                        if(d0.a) {
                                                            arr_b9 = f.g(arr_b9);
                                                        }
                                                        LogU.v("MyID3v2Read", "length = " + arr_b9.length + "frameIDString = " + s5);
                                                        goto label_342;
                                                    }
                                                    ++v14;
                                                    continue;
                                                }
                                                else {
                                                    f0.f("bad frame length(" + v14 + ": " + s5 + "): " + v22 + " (" + new String(arr_b8));
                                                    f0.g = true;
                                                    f0.b = true;
                                                    goto label_95;
                                                }
                                                ++v16;
                                                goto label_231;
                                            }
                                        }
                                        f0.g = true;
                                        f0.b = true;
                                        goto label_95;
                                    }
                                }
                                else {
                                    goto label_357;
                                }
                                f0.b = true;
                                goto label_95;
                            }
                            goto label_360;
                        }
                        catch(IOException iOException0) {
                            goto label_382;
                        }
                        try {
                        label_342:
                            "USLT".equals(s5);
                            if(arr_b8[0] != 84) {
                                f0.b(v22, s5, arr_b9);
                            }
                            ++v14;
                            goto label_210;
                        }
                        catch(IOException iOException2) {
                            try {
                                f0.f(iOException2.getMessage());
                                f0.b = true;
                                goto label_95;
                            label_351:
                                f0.f("Unknown id3v2 frame flags(id3v2 version: " + ((int)f0.j) + "): " + Long.toHexString(v29));
                                f0.b = true;
                                goto label_95;
                            label_357:
                                f0.f("missing tag");
                                f0.b = true;
                                goto label_95;
                            label_360:
                                if(!f0.e) {
                                    goto label_95;
                                }
                                f0.c = true;
                                goto label_95;
                            label_363:
                                if(f0.c || (!f0.b || f0.d)) {
                                    l0 = null;
                                    goto label_391;
                                }
                                goto label_366;
                            }
                            catch(IOException iOException0) {
                                goto label_382;
                            }
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                        LogU.e("MusicUtils", "MyId3 read error ", arrayIndexOutOfBoundsException0);
                        return null;
                    }
                }
                throw throwable1;
            label_366:
                HashMap hashMap0 = f0.n;
                if(hashMap0 == null) {
                    e0 = null;
                }
                else {
                    try {
                        e0 = new e();
                        for(int v32 = 0; v32 < hashMap0.size(); ++v32) {
                            hashMap0.get(v32);
                        }
                    }
                    catch(Throwable unused_ex) {
                        e0 = null;
                    }
                }
                try {
                    l0 = new l(1, e0, hashMap0);
                    goto label_391;
                }
                catch(IOException iOException0) {
                }
                catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                    LogU.e("MusicUtils", "MyId3 read error ", arrayIndexOutOfBoundsException0);
                    return null;
                }
            label_382:
                LogU.e("MusicUtils", "MyId3 read error ", iOException0);
                return null;
            }
            catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException0) {
                LogU.e("MusicUtils", "MyId3 read error ", arrayIndexOutOfBoundsException0);
                return null;
            }
        label_391:
            if(l0 != null) {
                Map map0 = (Map)l0.c;
                if(map0 != null && map0.size() > 0) {
                    return (ArrayList)((Map)l0.c).get("XSYL");
                }
            }
            return null;
        }
    }

    public static void deleteEmptyGenre(Context context0) {
        Cursor cursor0 = MusicUtils.query(context0, MediaStore.Audio.Genres.EXTERNAL_CONTENT_URI, new String[]{"_id"}, null, null, "name");
        if(cursor0 != null) {
            String[] arr_s = {"_id"};
            ContentResolver contentResolver0 = context0.getContentResolver();
            for(int v = cursor0.getCount() - 1; v >= 0; --v) {
                cursor0.moveToPosition(v);
                String s = va.e.b("_ID = ", cursor0.getString(cursor0.getColumnIndexOrThrow(arr_s[0])));
                Cursor cursor1 = MusicUtils.query(context0, MediaStore.Audio.Genres.Members.getContentUri("external", cursor0.getLong(cursor0.getColumnIndexOrThrow("_id"))), arr_s, "title != \'\' AND is_music=1", null, null);
                if(cursor1 == null || cursor1.getCount() == 0) {
                    try {
                        contentResolver0.delete(MediaStore.Audio.Genres.EXTERNAL_CONTENT_URI, s, null);
                    }
                    catch(SQLiteException sQLiteException0) {
                        LogU.e("MusicUtils", "deleteEmptyGenre() " + sQLiteException0.toString());
                    }
                }
                if(cursor1 != null) {
                    cursor1.close();
                }
            }
            cursor0.close();
        }
        if(R8.q.a.c()) {
            Cursor cursor2 = MusicUtils.query(context0, j.a, new String[]{"_id"}, null, null, "name");
            if(cursor2 != null) {
                String[] arr_s1 = {"_id"};
                ContentResolver contentResolver1 = context0.getContentResolver();
                for(int v1 = cursor2.getCount() - 1; v1 >= 0; --v1) {
                    cursor2.moveToPosition(v1);
                    String s1 = va.e.b("_ID = ", cursor2.getString(cursor2.getColumnIndexOrThrow(arr_s1[0])));
                    Cursor cursor3 = MusicUtils.query(context0, i.a(cursor2.getLong(cursor2.getColumnIndexOrThrow("_id"))), arr_s1, "title != \'\' AND is_music=1", null, null);
                    if(cursor3 == null || cursor3.getCount() == 0) {
                        contentResolver1.delete(j.a, s1, null);
                    }
                    if(cursor3 != null) {
                        cursor3.close();
                    }
                }
                cursor2.close();
            }
        }
    }

    public static void deleteMV(Context context0, String[] arr_s) {
        if(StorageUtils.isScopedStorage()) {
            for(int v = 0; v < arr_s.length; ++v) {
                Uri uri0 = Uri.parse(arr_s[v]);
                if(uri0 == null) {
                    return;
                }
                try {
                    context0.getContentResolver().delete(uri0, null, null);
                }
                catch(Exception exception0) {
                    H0.b.v(exception0, new StringBuilder("remove file error = "), "MusicUtils");
                }
            }
        }
        else {
            StringBuilder stringBuilder0 = new StringBuilder();
            for(int v1 = 0; v1 < arr_s.length; ++v1) {
                if(!O8.d.e(context0, 2097152.0, false)) {
                    File file0 = new File(arr_s[v1]);
                    if(file0.exists()) {
                        file0.delete();
                    }
                }
                if(v1 > 0) {
                    stringBuilder0.append(" OR ");
                }
                stringBuilder0.append("_data = \'");
                stringBuilder0.append(StringUtils.replacePathString(arr_s[v1]));
                stringBuilder0.append("\'");
            }
            try {
                LogU.d("MusicUtils", "where=" + stringBuilder0);
                Uri uri1 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                Cursor cursor0 = MusicUtils.query(context0, uri1, new String[]{"_id", "_data"}, stringBuilder0.toString(), null, null);
                LogU.d("MusicUtils", "query=" + cursor0);
                if(cursor0 != null) {
                    LogU.i("deletemv", "delete1");
                    LogU.i("deletemv", "delete2 = " + context0.getContentResolver().delete(uri1, stringBuilder0.toString(), null));
                    int v2 = cursor0.getColumnIndexOrThrow("_data");
                    cursor0.moveToFirst();
                    while(!cursor0.isAfterLast()) {
                        File file1 = new File(cursor0.getString(v2));
                        if(file1.exists()) {
                            file1.delete();
                        }
                        cursor0.moveToNext();
                    }
                }
            }
            catch(Exception exception1) {
                LogU.e("MusicUtils", exception1.toString());
            }
        }
    }

    public static void deletePlaylistTracks(List list0, long v) {
        LogU.v("MusicUtils", "MusicUtils / deletePlaylistTracks");
        ArrayList arrayList0 = new ArrayList();
        int v1 = list0.size();
        for(int v3 = 0; v3 < v1; ++v3) {
            arrayList0.add("");
        }
        G8.i.a.f();
        H8.q q0 = G8.i.a();
        q0.getClass();
        StringBuilder stringBuilder0 = Y.p("DELETE FROM local_playlists_map WHERE playlist_id = ? AND _id in (");
        a.a.k(arrayList0.size(), stringBuilder0);
        stringBuilder0.append(")");
        w.N(((LocalPlaylistDatabase_Impl)q0.a), false, true, new c(1, v, stringBuilder0.toString(), arrayList0));
        List list1 = (List)w.N(((LocalPlaylistDatabase_Impl)G8.i.a().a), true, false, new h0(v, 6));
        int v4 = list1.size();
        for(int v2 = 0; v2 < v4; ++v2) {
            ((t)list1.get(v2)).m = v2;
        }
        G8.i.f(list1);
    }

    public static int deleteTracks(Context context0, String[] arr_s) {
        return MusicUtils.deleteTracks(context0, arr_s, false);
    }

    public static int deleteTracks(Context context0, String[] arr_s, boolean z) {
        ArrayList arrayList0;
        boolean z1 = O8.d.e(context0, 2097152.0, false);
        if(((d3)MusicUtils.c(context0)).f() == null) {
            LogU.d("MusicUtils", "something wrong! - currentPlayable is null");
        }
        if(!z1) {
            if(!z) {
                MusicUtils.b(context0, arr_s);
            }
            LogU.d("MusicUtils", "Device space1 = " + O8.d.e(context0, 2097152.0, false));
        }
        LogU.v("MusicUtils", "MusicUtils / deleteTracks");
        G8.i.a.f();
        boolean z2 = StorageUtils.isScopedStorage();
        if(z2) {
            List list0 = Arrays.asList(arr_s);
            q.g(list0, "uriList");
            arrayList0 = new ArrayList();
            ArrayList arrayList1 = p.Q0(list0);
            while(!arrayList1.isEmpty()) {
                List list1 = A7.d.p(arrayList1, 500, arrayList1);
                arrayList1.removeAll(list1);
                H8.q q0 = G8.i.a();
                q0.getClass();
                StringBuilder stringBuilder0 = Y.p("SELECT * FROM local_playlists_map WHERE uri in(");
                a.a.k(list1.size(), stringBuilder0);
                stringBuilder0.append(") ORDER BY uri");
                arrayList0.addAll(((List)w.N(((LocalPlaylistDatabase_Impl)q0.a), true, false, new H8.c(stringBuilder0.toString(), 12, list1))));
            }
        }
        else {
            List list2 = Arrays.asList(arr_s);
            q.g(list2, "pathList");
            arrayList0 = new ArrayList();
            ArrayList arrayList2 = p.Q0(list2);
            while(!arrayList2.isEmpty()) {
                List list3 = A7.d.p(arrayList2, 500, arrayList2);
                arrayList2.removeAll(list3);
                H8.q q1 = G8.i.a();
                q1.getClass();
                StringBuilder stringBuilder1 = Y.p("SELECT * FROM local_playlists_map WHERE data in(");
                a.a.k(list3.size(), stringBuilder1);
                stringBuilder1.append(") ORDER BY data");
                arrayList0.addAll(((List)w.N(((LocalPlaylistDatabase_Impl)q1.a), true, false, new H8.c(stringBuilder1.toString(), 11, list3))));
            }
        }
        H8.q q2 = G8.i.a();
        q2.getClass();
        w.N(((LocalPlaylistDatabase_Impl)q2.a), false, true, new n(q2, arrayList0, 1));
        if(!z2) {
            try {
                MusicUtils.deleteEmptyGenre(context0);
            }
            catch(Exception exception0) {
                LogU.e("MusicUtils", exception0.toString());
            }
        }
        z6.f f0 = g.a;
        if(z2) {
            f0.m();
            List list4 = Arrays.asList(arr_s);
            q.g(list4, "list");
            ArrayList arrayList3 = p.Q0(list4);
            while(!arrayList3.isEmpty()) {
                List list5 = A7.d.p(arrayList3, 500, arrayList3);
                arrayList3.removeAll(list5);
                H8.i i0 = g.g();
                i0.getClass();
                StringBuilder stringBuilder2 = Y.p("DELETE FROM local_contents WHERE uri in (");
                a.a.k(list5.size(), stringBuilder2);
                stringBuilder2.append(")");
                w.N(((LocalContentDatabase_Impl)i0.b), false, true, new H8.c(stringBuilder2.toString(), 10, list5));
            }
        }
        else {
            f0.m();
            g.a(Arrays.asList(arr_s));
        }
        LogU.d("MusicUtils", "Device space2 = " + O8.d.e(context0, 2097152.0, false));
        if(z1 && !z) {
            MusicUtils.b(context0, arr_s);
        }
        LogU.d("MusicUtils", "Device space3 = " + O8.d.e(context0, 2097152.0, false));
        return 0;
    }

    public static int downloadLyrics(Context context0, String s, String s1) {
        return MusicUtils.downloadLyrics(context0, new O8.f(MelonAppBase.instance.getMelonProtocolUserAgent()).a, s, s1, null);
    }

    public static int downloadLyrics(Context context0, String s, String s1, String s2) {
        return MusicUtils.downloadLyrics(context0, new O8.f(MelonAppBase.instance.getMelonProtocolUserAgent()).a, s, s1, s2);
    }

    public static int downloadLyrics(Context context0, OkHttpClient okHttpClient0, String s, String s1, String s2) {
        if(context0 == null) {
            return 0;
        }
        else {
            try {
                if(NetUtils.isConnected()) {
                    File file0 = TextUtils.isEmpty(s2) ? u9.f.g.b(context0, "lyric").a() : new File(s2);
                    if(!file0.exists()) {
                        file0.mkdirs();
                        LogU.d("MusicUtils", "directory created : " + file0.getPath());
                    }
                    if((TextUtils.isEmpty(s1) ? -1 : s1.indexOf(0x3F)) >= 0 && O8.d.c(okHttpClient0, s1, new File(file0.getPath() + "/" + s).getCanonicalPath())) {
                        return 1;
                    }
                }
                return 0;
            }
            catch(Exception exception0) {
            }
        }
        LogU.e("MusicUtils", "file downloadLyric error ", exception0);
        return 0;
    }

    public static void dumpCursor(Cursor cursor0, Uri uri0, String[] arr_s, String s, String[] arr_s1) {
    }

    public static void dumpCursor(Cursor cursor0, String s) {
    }

    public static ContentValues e(Cursor cursor0) {
        ContentValues contentValues0 = new ContentValues();
        contentValues0.put("title", cursor0.getString(cursor0.getColumnIndex("title")));
        contentValues0.put("_data", cursor0.getString(cursor0.getColumnIndex("_data")));
        contentValues0.put("album", cursor0.getString(cursor0.getColumnIndex("album")));
        contentValues0.put("album_id", cursor0.getString(cursor0.getColumnIndex("album_id")));
        contentValues0.put("artist", cursor0.getString(cursor0.getColumnIndex("artist")));
        contentValues0.put("artist_id", cursor0.getString(cursor0.getColumnIndex("artist_id")));
        contentValues0.put("duration", cursor0.getLong(cursor0.getColumnIndex("duration")));
        try {
            int v = cursor0.getColumnIndexOrThrow("audio_id1");
            int v1 = cursor0.getColumnIndexOrThrow("audio_id2");
            contentValues0.put("audio_id1", cursor0.getLong(v));
            contentValues0.put("audio_id2", cursor0.getLong(v1));
        }
        catch(IllegalArgumentException unused_ex) {
            int v2 = cursor0.getColumnIndexOrThrow("_id");
            int v3 = cursor0.getColumnIndex("_id2");
            if(v3 < 0) {
                v3 = 0;
            }
            contentValues0.put("audio_id1", cursor0.getLong(v2));
            contentValues0.put("audio_id2", cursor0.getLong(v3));
        }
        contentValues0.put("mime_type", cursor0.getString(cursor0.getColumnIndex("mime_type")));
        return contentValues0;
    }

    public static String f(String s, String s1, String s2) [...] // 潜在的解密器

    public static Cursor fetchMediaStoreAudioCursor(Context context0, String[] arr_s) {
        String[] arr_s1 = {"_id", "_id", "title", "title_key", "_data", "album", "album_id", "artist", "artist_id", "duration", "_display_name", "is_music", "is_ringtone", "track", "mime_type", "date_added"};
        Class[] arr_class = {Long.class, Long.class, String.class, String.class, String.class, String.class, Long.class, String.class, Long.class, Integer.class, String.class, Integer.class, Integer.class, Integer.class, String.class, Integer.class};
        StringBuilder stringBuilder0 = Y.p("_data IN (");
        if(arr_s != null && arr_s.length > 0) {
            for(int v = 0; v < arr_s.length; ++v) {
                DatabaseUtils.appendEscapedSQLString(stringBuilder0, arr_s[v]);
                stringBuilder0.append(",");
            }
            stringBuilder0.setLength(stringBuilder0.length() - 1);
        }
        stringBuilder0.append(")");
        Cursor cursor0 = MusicUtils.query(context0, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, arr_s1, stringBuilder0.toString(), null, "title_key");
        Cursor cursor1 = R8.q.a.c() ? MusicUtils.query(context0, k.a, arr_s1, stringBuilder0.toString(), null, "title_key") : null;
        return cursor1 == null || cursor1.getCount() <= 0 ? cursor0 : CursorUtil.mergeTrackCursor(context0.getContentResolver(), cursor0, cursor1, arr_s1, arr_class, "title_key");
    }

    public static String g(String s, String s1) [...] // 潜在的解密器

    @Deprecated
    public static int getAlbumCount(Context context0, long v, long v1, boolean z, boolean z1) {
        Cursor cursor1;
        String[] arr_s = {"_id", "_id", "is_music", "mime_type", "album_id"};
        StringBuilder stringBuilder0 = Y.o(v, "getAlbumCount id1:", ", id2:");
        stringBuilder0.append(v1);
        LogU.v("MusicUtils", stringBuilder0.toString());
        Cursor cursor0 = null;
        int v2 = 0;
        if(Long.compare(v, 0L) >= 0) {
            StringBuilder stringBuilder1 = new StringBuilder("title != \'\' AND is_music=1 AND mime_type");
            stringBuilder1.append((z ? "=" : "!="));
            stringBuilder1.append("\'audio/flac\' AND ");
            H0.b.t(v, MusicUtils.makeQueryCheckEduOrMusicForOS11(context0, z1), " AND album_id=", stringBuilder1);
            try {
                cursor1 = null;
                cursor1 = MusicUtils.query(context0, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, arr_s, stringBuilder1.toString(), null, "title_key");
                goto label_17;
            }
            catch(Exception exception0) {
                goto label_21;
            }
            catch(Throwable throwable0) {
            }
            TWR.safeClose$NT(null, throwable0);
            throw throwable0;
        label_17:
            if(cursor1 == null) {
            label_28:
                if(cursor1 != null) {
                    cursor1.close();
                }
            }
            else {
                try {
                    try {
                        v2 = cursor1.getCount();
                        goto label_28;
                    }
                    catch(Exception exception0) {
                    }
                label_21:
                    LogU.w("MusicUtils", "getAlbumCount() " + exception0.toString());
                    if(cursor1 != null) {
                        goto label_23;
                    }
                    goto label_30;
                }
                catch(Throwable throwable0) {
                    goto label_26;
                }
            label_23:
                cursor1.close();
                goto label_30;
            label_26:
                TWR.safeClose$NT(cursor1, throwable0);
                throw throwable0;
            }
        }
    label_30:
        if(R8.q.a.c() && v1 > 0L) {
            StringBuilder stringBuilder2 = new StringBuilder("title != \'\' AND is_music=1 AND mime_type");
            stringBuilder2.append((z ? "=" : "!="));
            stringBuilder2.append("\'audio/flac\' AND ");
            stringBuilder2.append(MusicUtils.makeQueryCheckEduOrMusic(z1));
            stringBuilder2.append(" AND album_id=");
            stringBuilder2.append(v1);
            try {
                try {
                    cursor0 = MusicUtils.query(context0, k.a, arr_s, stringBuilder2.toString(), null, "title_key");
                    if(cursor0 != null) {
                        v2 += cursor0.getCount();
                    }
                }
                catch(Exception exception1) {
                    LogU.w("MusicUtils", "getAlbumCount() " + exception1.toString());
                    if(cursor0 != null) {
                        goto label_49;
                    }
                    return v2;
                }
            }
            catch(Throwable throwable1) {
                TWR.safeClose$NT(cursor0, throwable1);
                throw throwable1;
            }
            if(cursor0 != null) {
            label_49:
                cursor0.close();
                return v2;
            }
        }
        return v2;
    }

    @Deprecated
    public static int getArtistCount(Context context0, long v, long v1, boolean z, boolean z1) {
        Cursor cursor1;
        String[] arr_s = {"_id", "_id", "is_music", "mime_type", "artist_id"};
        StringBuilder stringBuilder0 = Y.o(v, "getArtistCount id1:", ", id2:");
        stringBuilder0.append(v1);
        LogU.v("MusicUtils", stringBuilder0.toString());
        Cursor cursor0 = null;
        int v2 = 0;
        if(Long.compare(v, 0L) >= 0) {
            StringBuilder stringBuilder1 = new StringBuilder("title != \'\' AND is_music=1 AND mime_type");
            stringBuilder1.append((z ? "=" : "!="));
            stringBuilder1.append("\'audio/flac\' AND ");
            H0.b.t(v, MusicUtils.makeQueryCheckEduOrMusicForOS11(context0, z1), " AND artist_id=", stringBuilder1);
            try {
                cursor1 = null;
                cursor1 = MusicUtils.query(context0, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, arr_s, stringBuilder1.toString(), null, "title_key");
                goto label_17;
            }
            catch(Exception exception0) {
                goto label_21;
            }
            catch(Throwable throwable0) {
            }
            TWR.safeClose$NT(null, throwable0);
            throw throwable0;
        label_17:
            if(cursor1 == null) {
            label_28:
                if(cursor1 != null) {
                    cursor1.close();
                }
            }
            else {
                try {
                    try {
                        v2 = cursor1.getCount();
                        goto label_28;
                    }
                    catch(Exception exception0) {
                    }
                label_21:
                    LogU.w("MusicUtils", "getArtistCount() " + exception0.toString());
                    if(cursor1 != null) {
                        goto label_23;
                    }
                    goto label_30;
                }
                catch(Throwable throwable0) {
                    goto label_26;
                }
            label_23:
                cursor1.close();
                goto label_30;
            label_26:
                TWR.safeClose$NT(cursor1, throwable0);
                throw throwable0;
            }
        }
    label_30:
        if(R8.q.a.c() && v1 >= 0L) {
            StringBuilder stringBuilder2 = new StringBuilder("title != \'\' AND is_music=1 AND mime_type");
            stringBuilder2.append((z ? "=" : "!="));
            stringBuilder2.append("\'audio/flac\' AND ");
            stringBuilder2.append(MusicUtils.makeQueryCheckEduOrMusic(z1));
            stringBuilder2.append(" AND artist_id=");
            stringBuilder2.append(v1);
            try {
                try {
                    cursor0 = MusicUtils.query(context0, k.a, arr_s, stringBuilder2.toString(), null, "title_key");
                    if(cursor0 != null) {
                        v2 += cursor0.getCount();
                    }
                }
                catch(Exception exception1) {
                    LogU.w("MusicUtils", "getArtistCount() " + exception1.toString());
                    if(cursor0 != null) {
                        goto label_49;
                    }
                    return v2;
                }
            }
            catch(Throwable throwable1) {
                TWR.safeClose$NT(cursor0, throwable1);
                throw throwable1;
            }
            if(cursor0 != null) {
            label_49:
                cursor0.close();
                return v2;
            }
        }
        return v2;
    }

    @Deprecated
    public static int getGenreCount(Context context0, long v, long v1, boolean z) {
        String[] arr_s = {"_id"};
        StringBuilder stringBuilder0 = new StringBuilder("title != \'\' AND is_music=1");
        stringBuilder0.append(" AND ");
        stringBuilder0.append(MusicUtils.makeFlacQueryFromMediaStore(context0, "_id", z));
        Cursor cursor0 = null;
        int v2 = 0;
        if(Long.compare(v, 0L) >= 0) {
            try {
                try {
                    cursor0 = MusicUtils.query(context0, MediaStore.Audio.Genres.Members.getContentUri("external", v), arr_s, stringBuilder0.toString(), null, "title_key");
                    if(cursor0 != null) {
                        v2 = cursor0.getCount();
                    }
                    goto label_19;
                }
                catch(Exception exception0) {
                }
                LogU.w("MusicUtils", "getGenreCount() " + exception0.toString());
                if(cursor0 != null) {
                    goto label_14;
                }
                goto label_21;
            }
            catch(Throwable throwable0) {
                goto label_17;
            }
        label_14:
            cursor0.close();
            goto label_21;
        label_17:
            TWR.safeClose$NT(cursor0, throwable0);
            throw throwable0;
        label_19:
            if(cursor0 != null) {
                cursor0.close();
            }
        }
    label_21:
        if(R8.q.a.c() && v1 > 0L) {
            try {
                try {
                    cursor0 = MusicUtils.query(context0, i.a(v1), arr_s, stringBuilder0.toString(), null, "title_key");
                    if(cursor0 != null) {
                        v2 += cursor0.getCount();
                    }
                }
                catch(Exception exception1) {
                    LogU.w("MusicUtils", "getGenreCount() " + exception1.toString());
                    if(cursor0 != null) {
                        goto label_34;
                    }
                    return v2;
                }
            }
            catch(Throwable throwable1) {
                TWR.safeClose$NT(cursor0, throwable1);
                throw throwable1;
            }
            if(cursor0 != null) {
            label_34:
                cursor0.close();
                return v2;
            }
        }
        return v2;
    }

    @Deprecated
    public static int getMaxVolume(Context context0) {
        return VolumeUtils.getMaxVolume(context0, null);
    }

    public static String getPlaylistNameById(long v) {
        G8.i.a.f();
        return (String)w.N(((LocalPlaylistDatabase_Impl)G8.i.a().a), true, false, new h0(v, 7));
    }

    @Deprecated
    public static int getVolume(Context context0) {
        return VolumeUtils.getVolume(context0, "MusicUtils", null);
    }

    public static ArrayList getWebLyrics(Context context0, String s) {
        ArrayList arrayList1;
        String s1;
        ArrayList arrayList0 = null;
        if(context0 == null) {
            return null;
        }
        RequestFuture requestFuture0 = RequestFuture.newFuture();
        GetWebLyricReq getWebLyricReq0 = new GetWebLyricReq(context0, s);
        try {
            GetWebLyricRes getWebLyricRes0 = (GetWebLyricRes)RequestBuilder.newInstance(getWebLyricReq0).tag("MusicUtils").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
            if(!getWebLyricRes0.isSuccessful(false)) {
                return null;
            }
            s1 = getWebLyricRes0.getLyric();
            if(s1 == null || s1.equals("")) {
                return null;
            }
            arrayList1 = new ArrayList();
        }
        catch(VolleyError volleyError0) {
            volleyError0.printStackTrace();
            return arrayList0;
        }
        try {
            String[] arr_s = s1.replaceAll("<(/|)(?i)br>|\\t\\n|\\r|\\n", "<br>").split("<br>");
            for(int v = 0; v < arr_s.length; ++v) {
                if(!TextUtils.isEmpty(arr_s[v])) {
                    arrayList1.add(new LyricsInfo(((long)(v + 1)), arr_s[v]));
                }
            }
            return arrayList1;
        }
        catch(VolleyError volleyError0) {
            arrayList0 = arrayList1;
        }
        volleyError0.printStackTrace();
        return arrayList0;
    }

    public static ArrayList getWebLyrics(Context context0, String s, String s1) {
        ArrayList arrayList1;
        String s2;
        ArrayList arrayList0 = null;
        if(context0 != null && !TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1)) {
            RequestFuture requestFuture0 = RequestFuture.newFuture();
            GetWebLyricReq getWebLyricReq0 = new GetWebLyricReq(context0, s, s1);
            try {
                GetWebLyricRes getWebLyricRes0 = (GetWebLyricRes)RequestBuilder.newInstance(getWebLyricReq0).tag("MusicUtils").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                if(!getWebLyricRes0.isSuccessful(false)) {
                    return null;
                }
                s2 = getWebLyricRes0.getLyric();
                if(s2 == null || s2.equals("")) {
                    return null;
                }
                arrayList1 = new ArrayList();
            }
            catch(VolleyError volleyError0) {
                volleyError0.printStackTrace();
                return arrayList0;
            }
            try {
                String[] arr_s = s2.replaceAll("<(/|)(?i)br>|\\t\\n|\\r|\\n", "<br>").split("<br>");
                for(int v = 0; v < arr_s.length; ++v) {
                    if(!TextUtils.isEmpty(arr_s[v])) {
                        arrayList1.add(new LyricsInfo(((long)(v + 1)), arr_s[v]));
                    }
                }
                return arrayList1;
            }
            catch(VolleyError volleyError0) {
                arrayList0 = arrayList1;
            }
            volleyError0.printStackTrace();
        }
        return arrayList0;
    }

    public static String h(String s) [...] // 潜在的解密器

    // 去混淆评级： 低(20)
    public static boolean hasNewLyric(String s, String s1) {
        return "00000000000000".equalsIgnoreCase(s1) ? false : FileUtils.getLastModifiedTime(s) < DateUtils.convertString2Long(s1);
    }

    public static boolean isEducationContents(Uri uri0) {
        g.a.m();
        H8.k k0 = g.j(uri0);
        if(k0 != null && "어학".equals(k0.r)) {
            LogU.d("MusicUtils", "isEducationContent - true");
            return true;
        }
        LogU.v("MusicUtils", "isEducationContent - false");
        return false;
    }

    public static boolean isEducationContents(String s) {
        g.a.m();
        H8.k k0 = g.k(s);
        if(k0 != null && "어학".equals(k0.r)) {
            LogU.d("MusicUtils", "isEducationContent - true");
            return true;
        }
        LogU.v("MusicUtils", "isEducationContent - false");
        return false;
    }

    // 去混淆评级： 低(20)
    @Deprecated
    public static boolean isMelonDCFContents(String s) {
        return FilenameUtils.isDcf(s) && R8.q.a.c();
    }

    public static void maintainStreamingLyricsFiles(String s) {
        File file0 = new File(s);
        if(!file0.exists()) {
            file0.mkdirs();
        }
        com.iloen.melon.utils.player.MusicUtils.1 musicUtils$10 = new FileFilter() {  // 初始化器: Ljava/lang/Object;-><init>()V
            // 去混淆评级： 低(20)
            @Override
            public boolean accept(File file0) {
                return file0.isFile() && StringUtils.endsWithIgnoreCase(file0.getName(), ".slf");
            }
        };
        File[] arr_file = new File(s).listFiles(musicUtils$10);
        if(arr_file != null && arr_file.length > 5000) {
            while(arr_file.length > 2500) {
                StringBuilder stringBuilder0 = new StringBuilder("cFileList size = ");
                Z.s(arr_file.length, "MusicUtils", stringBuilder0);
                int v = arr_file.length;
                String s1 = "";
                long v2 = 0L;
                for(int v1 = 0; v1 < v; ++v1) {
                    File file1 = arr_file[v1];
                    long v3 = file1.lastModified();
                    if(v2 == 0L) {
                        s1 = file1.getName();
                        v2 = v3;
                    }
                    else if(v3 <= v2) {
                        s1 = file1.getName();
                        v2 = v3;
                    }
                }
                File file2 = new File(s + s1);
                if(file2.exists() && file2.isFile()) {
                    file2.delete();
                    LogU.d("MusicUtils", "DETETE FILE : " + s1 + ",MODIFY DATE : " + new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").format(v2));
                    arr_file = new File(s).listFiles(musicUtils$10);
                }
            }
        }
    }

    public static String makeFlacQuery(String s, boolean z) {
        String s1 = MusicUtils.f(s, "audio", "mime_type=\'audio/flac\'");
        return z ? MusicUtils.g("_id", s1) : MusicUtils.h(s1);
    }

    @Deprecated
    public static String makeFlacQueryFromMediaStore(Context context0, String s, boolean z) {
        Exception exception1;
        Throwable throwable1;
        ContentResolver contentResolver0 = context0.getContentResolver();
        StringBuilder stringBuilder0 = new StringBuilder();
        Cursor cursor0 = null;
        try {
            try {
                cursor0 = contentResolver0.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[]{s}, "mime_type=\'audio/flac\'", null, null);
                if(cursor0 != null) {
                    for(boolean z1 = false; cursor0.moveToNext(); z1 = true) {
                        long v = cursor0.getLong(0);
                        if(z1) {
                            stringBuilder0.append(", ");
                        }
                        stringBuilder0.append(v);
                    }
                    DatabaseUtils.dumpCursor(cursor0);
                }
                goto label_28;
            }
            catch(Exception exception0) {
                exception1 = exception0;
            }
            LogU.e("MusicUtils", "makeFlacQueryFromMediaStore() - error : " + exception1.getMessage());
            stringBuilder0 = new StringBuilder();
            if(cursor0 != null) {
                goto label_23;
            }
            goto label_30;
        }
        catch(Throwable throwable0) {
            throwable1 = throwable0;
            goto label_25;
        }
    label_23:
        cursor0.close();
        goto label_30;
    label_25:
        if(cursor0 != null) {
            cursor0.close();
        }
        throw throwable1;
    label_28:
        if(cursor0 != null) {
            cursor0.close();
        }
    label_30:
        String s1 = stringBuilder0.toString();
        return z ? MusicUtils.g("_id", s1) : MusicUtils.h(s1);
    }

    // 去混淆评级： 高(200)
    public static String makeQueryCheckEduOrMusic(boolean z) {
        return z ? "(_id IN (SELECT audio_id FROM audio_genres_map WHERE genre_id IN (SELECT _id FROM audio_genres WHERE name = \'어학\')))" : "(_id NOT IN (SELECT audio_id FROM audio_genres_map WHERE genre_id IN (SELECT _id FROM audio_genres WHERE name = \'어학\')))";
    }

    public static String makeQueryCheckEduOrMusicForOS11(Context context0, boolean z) {
        String s = MusicUtils.d(context0, MediaStore.Audio.Genres.getContentUri("external"), "_id", "name =? ", new String[]{"어학"});
        StringBuilder stringBuilder0 = new StringBuilder();
        String[] arr_s = s.split(", ");
        for(int v = 0; v < arr_s.length; ++v) {
            String s1 = arr_s[v];
            if(!TextUtils.isEmpty(s1)) {
                String s2 = MusicUtils.d(context0, MediaStore.Audio.Genres.Members.getContentUri("external", Long.parseLong(s1)), "audio_id", "genre_id IN (" + s + ")", null);
                if(stringBuilder0.length() > 0) {
                    stringBuilder0.append(", ");
                }
                stringBuilder0.append(s2);
            }
        }
        String s3 = stringBuilder0.toString();
        return z ? MusicUtils.g("_id", s3) : MusicUtils.h(s3);
    }

    public static void moveLocalPlaylist(String s, int v, int v1) {
        w7.d d0 = G8.i.a;
        if("UP".equals(s)) {
            d0.f();
            List list0 = (List)w.N(((LocalPlaylistDatabase_Impl)G8.i.a().a), true, false, new H8.o(v, v1, 0));
            for(Object object0: list0) {
                s s1 = (s)object0;
                int v2 = s1.e;
                s1.e = v2 == v ? v1 : v2 - 1;
            }
            H8.q q0 = G8.i.a();
            q0.getClass();
            w.N(((LocalPlaylistDatabase_Impl)q0.a), false, true, new H8.m(q0, list0, 1));
            return;
        }
        if("DOWN".equals(s)) {
            d0.f();
            List list1 = (List)w.N(((LocalPlaylistDatabase_Impl)G8.i.a().a), true, false, new H8.o(v1, v, 0));
            for(Object object1: list1) {
                s s2 = (s)object1;
                int v3 = s2.e;
                s2.e = v3 == v ? v1 : v3 + 1;
            }
            H8.q q1 = G8.i.a();
            q1.getClass();
            w.N(((LocalPlaylistDatabase_Impl)q1.a), false, true, new H8.m(q1, list1, 1));
        }
    }

    public static void movePlaylist(String s, Long long0, int v, int v1) {
        w7.d d0 = G8.i.a;
        if("UP".equals(s)) {
            d0.f();
            List list0 = (List)w.N(((LocalPlaylistDatabase_Impl)G8.i.a().a), true, false, new H8.p(v, v1, ((long)long0)));
            for(Object object0: list0) {
                t t0 = (t)object0;
                int v2 = t0.m;
                t0.m = v2 == v ? v1 : v2 - 1;
            }
            G8.i.f(list0);
            return;
        }
        if("DOWN".equals(s)) {
            d0.f();
            List list1 = (List)w.N(((LocalPlaylistDatabase_Impl)G8.i.a().a), true, false, new H8.p(v1, v, ((long)long0)));
            for(Object object1: list1) {
                t t1 = (t)object1;
                int v3 = t1.m;
                t1.m = v3 == v ? v1 : v3 + 1;
            }
            G8.i.f(list1);
        }
    }

    public static Cursor query(Context context0, Uri uri0, String[] arr_s, String s, String[] arr_s1, String s1) {
        try {
            LogU.v("MusicUtils", "query: " + uri0);
            ContentResolver contentResolver0 = context0.getContentResolver();
            return contentResolver0 == null ? null : contentResolver0.query(uri0, arr_s, s, arr_s1, s1);
        }
        catch(Exception unused_ex) {
        }
        return null;
    }

    public static Cursor queryBundle(Context context0, Uri uri0, String[] arr_s, Bundle bundle0) {
        try {
            LogU.v("MusicUtils", "query: " + uri0);
            ContentResolver contentResolver0 = context0.getContentResolver();
            if(contentResolver0 != null) {
                bundle0.getString("android:query-arg-sql-selection", null);
                bundle0.getStringArray("android:query-arg-sql-selection-args");
                return contentResolver0.query(uri0, arr_s, bundle0, null);
            }
        }
        catch(Exception unused_ex) {
        }
        return null;
    }

    public static void removeLocalPlayList(String s) {
        LogU.d("MusicUtils", "removeLocalPlayList - playlistId: " + s);
        int v = ProtocolUtils.parseInt(s, -1);
        if(v != -1) {
            G8.i.a.f();
            w.N(((LocalPlaylistDatabase_Impl)G8.i.a().a), false, true, new h0(((long)v), 5));
            w.N(((LocalPlaylistDatabase_Impl)G8.i.a().a), false, true, new h0(((long)v), 4));
            return;
        }
        LogU.e("MusicUtils", "removeLocalPlayList - invalid playlistId: " + s);
    }

    public static boolean renamePlaylist(Context context0, long v, String s) {
        if(!TextUtils.isEmpty(s)) {
            G8.i.a.f();
            q.g(s, "name");
            return ((int)(((Integer)w.N(((LocalPlaylistDatabase_Impl)G8.i.a().a), false, true, new Eb.d(s, v, 3))))) > 0;
        }
        return false;
    }

    @Deprecated
    public static void setVolume(Context context0, int v) {
    }

    @Deprecated
    public static void volumeDown(Context context0) {
    }

    @Deprecated
    public static void volumeUp(Context context0) {
    }
}

