package com.iloen.melon.utils.ui;

import DigiCAP.SKT.DRM.DrmInitException;
import DigiCAP.SKT.DRM.MelonDRMMetaInterface;
import R8.r;
import S8.b;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore.Audio.Media;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.playback.PlayableComparators;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.player.MusicUtils;
import java.io.UnsupportedEncodingException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import jeb.synthetic.TWR;

public class CursorUtil {
    static class IntegerComparator implements Comparator {
        public final int a;

        public IntegerComparator(int v) {
            this.a = v;
        }

        @Override
        public int compare(Object object0, Object object1) {
            return this.compare(((ArrayList)object0), ((ArrayList)object1));
        }

        public int compare(ArrayList arrayList0, ArrayList arrayList1) {
            return ((int)(((Integer)arrayList0.get(this.a)))) - ((int)(((Integer)arrayList1.get(this.a))));
        }
    }

    static class IntegerDescComparator implements Comparator {
        public final int a;

        public IntegerDescComparator(int v) {
            this.a = v;
        }

        @Override
        public int compare(Object object0, Object object1) {
            return this.compare(((ArrayList)object0), ((ArrayList)object1));
        }

        public int compare(ArrayList arrayList0, ArrayList arrayList1) {
            int v = (int)(((Integer)arrayList0.get(this.a)));
            return ((int)(((Integer)arrayList1.get(this.a)))) - v;
        }
    }

    static class LongComparator implements Comparator {
        public final int a;

        public LongComparator(int v) {
            this.a = v;
        }

        @Override
        public int compare(Object object0, Object object1) {
            return this.compare(((ArrayList)object0), ((ArrayList)object1));
        }

        public int compare(ArrayList arrayList0, ArrayList arrayList1) {
            return (int)(((long)(((Long)arrayList0.get(this.a)))) - ((long)(((Long)arrayList1.get(this.a)))));
        }
    }

    static class LongDescComparator implements Comparator {
        public final int a;

        public LongDescComparator(int v) {
            this.a = v;
        }

        @Override
        public int compare(Object object0, Object object1) {
            return this.compare(((ArrayList)object0), ((ArrayList)object1));
        }

        public int compare(ArrayList arrayList0, ArrayList arrayList1) {
            return (int)(((long)(((Long)arrayList0.get(this.a)))) - ((long)(((Long)arrayList1.get(this.a)))));
        }
    }

    static class MultiComparator implements Comparator {
        public final Collator a;
        public final int b;
        public final int[] c;

        public MultiComparator(int[] arr_v) {
            this.a = Collator.getInstance();
            this.c = arr_v;
            this.b = arr_v.length;
        }

        @Override
        public int compare(Object object0, Object object1) {
            return this.compare(((ArrayList)object0), ((ArrayList)object1));
        }

        public int compare(ArrayList arrayList0, ArrayList arrayList1) {
            int v2;
            for(int v = 0; v < this.b; ++v) {
                int[] arr_v = this.c;
                int v1 = arr_v[v];
                if(v1 != -1) {
                    Object object0 = arrayList0.get(v1);
                    Object object1 = arrayList1.get(arr_v[v]);
                    if(object0 instanceof String) {
                        v2 = this.a.compare(object0, object1);
                    }
                    else {
                        v2 = object0 instanceof Long ? ((int)(((long)(((Long)object0))) - ((long)(((Long)object1))))) : ((int)(((Integer)object0))) - ((int)(((Integer)object1)));
                    }
                    if(v2 != 0) {
                        return v2;
                    }
                }
            }
            return 0;
        }
    }

    static class StringComparator implements Comparator {
        public final Collator a;
        public final int b;

        public StringComparator(int v) {
            this.a = Collator.getInstance();
            this.b = v;
        }

        @Override
        public int compare(Object object0, Object object1) {
            return this.compare(((ArrayList)object0), ((ArrayList)object1));
        }

        public int compare(ArrayList arrayList0, ArrayList arrayList1) {
            String s = (String)arrayList0.get(this.b);
            String s1 = (String)arrayList1.get(this.b);
            try {
                return PlayableComparators.INSTANCE.compareString(s, s1);
            }
            catch(Exception unused_ex) {
                return this.a.compare(s, s1);
            }
        }
    }

    public static String[] ALBUM_COLUMNS = null;
    public static String[] ARTIST_COLUMNS = null;
    public static final String[] SONG_COLUMNS = null;
    public static final String _ID2 = "_id2";

    static {
        CursorUtil.SONG_COLUMNS = new String[]{"menu_id", "song_id", "song_title", "album_id", "album_name", "album_img_path", "artist_id", "artist_name", "is_adult", "is_free", "is_hit_song", "is_holdback", "is_mv", "is_title_song", "is_service", "issue_date", "play_time"};
        CursorUtil.ALBUM_COLUMNS = new String[]{"menu_id", "album_id", "album_name", "album_img_path", "artist_id", "artist_name", "issue_date", "is_service", "like_count", "song_count"};
        CursorUtil.ARTIST_COLUMNS = new String[]{"menu_id", "artist_id", "artist_name", "artist_img_path", "nationality", "genre", "act_type", "gender", "fan_count"};
    }

    public static Object a(Cursor cursor0, int v, Class class0) {
        Class class1 = String.class;
        Class class2 = Long.class;
        if(v < 0) {
            if(class0.equals(class2)) {
                return -1;
            }
            if(class0.equals(class1)) {
                return "";
            }
        }
        if(class0.equals(class2)) {
            return cursor0.getLong(v);
        }
        if(class0.equals(class1)) {
            return cursor0.getString(v);
        }
        return class0.equals(Integer.class) ? cursor0.getInt(v) : null;
    }

    public static void b(ArrayList arrayList0, String[] arr_s, String s) {
        if(s != null && !s.equals("")) {
            String[] arr_s1 = s.split(",");
            int[] arr_v = new int[arr_s1.length];
            for(int v = 0; v < arr_s1.length; ++v) {
                arr_v[v] = -1;
            }
            for(int v1 = 0; v1 < arr_s1.length; ++v1) {
                for(int v2 = 0; v2 < arr_s.length; ++v2) {
                    if(arr_s[v2].equals(arr_s1[v1].trim())) {
                        arr_v[v1] = v2;
                        break;
                    }
                }
            }
            if(arrayList0.size() != 0) {
                ArrayList arrayList1 = (ArrayList)arrayList0.get(0);
                if(arr_s1.length == 1) {
                    int v3 = arr_v[0];
                    if(v3 >= 0) {
                        Object object0 = arrayList1.get(v3);
                        if(object0 instanceof String) {
                            Collections.sort(arrayList0, new StringComparator(arr_v[0]));
                            return;
                        }
                        if(object0 instanceof Integer) {
                            IntegerDescComparator cursorUtil$IntegerDescComparator0 = s == "date_added" ? new IntegerDescComparator(arr_v[0]) : new IntegerComparator(arr_v[0]);
                            Collections.sort(arrayList0, cursorUtil$IntegerDescComparator0);
                            return;
                        }
                        if(object0 instanceof Long) {
                            LongDescComparator cursorUtil$LongDescComparator0 = s == "date_added" ? new LongDescComparator(arr_v[0]) : new LongComparator(arr_v[0]);
                            Collections.sort(arrayList0, cursorUtil$LongDescComparator0);
                        }
                    }
                    else {
                        goto label_42;
                    }
                }
                else {
                label_42:
                    if(arr_s1.length > 1) {
                        Collections.sort(arrayList0, new MultiComparator(arr_v));
                    }
                }
            }
        }
    }

    @Deprecated
    public static void dcfMetaInspect(Context context0, String s) {
        String s4;
        String s3;
        byte[] arr_b;
        b b0;
        try {
            b0 = b.b("scanner");
            long v = MelonDRMMetaInterface.DRMMetaSetClientID(r.a(MelonAppBase.instance.getDeviceData().h()));
            if(Long.compare(v, 0L) < 0) {
                LogU.w("CursorUtil", "Failure, setClientId, result = " + v);
                return;
            }
        }
        catch(DrmInitException drmInitException0) {
            drmInitException0.printStackTrace();
            return;
        }
        try {
            LogU.d("CursorUtil", "dcfMetaInspect " + s);
            try {
                arr_b = s.getBytes("euc-kr");
            }
            catch(UnsupportedEncodingException unsupportedEncodingException0) {
                LogU.d("CursorUtil", unsupportedEncodingException0.toString());
                return;
            }
            int v2 = b.c(arr_b);
            if(v2 > 0) {
                byte[] arr_b1 = MelonDRMMetaInterface.DRMMetaGetUnsupportedValue(((short)v2), ((short)"Title"));
                if(arr_b1 == null) {
                    LogU.d("CursorUtil", "Failure, get title.");
                    return;
                }
                String s1 = "";
                String s2 = new String(arr_b1, "euc-kr");
                byte[] arr_b2 = MelonDRMMetaInterface.DRMMetaGetUnsupportedValue(((short)v2), ((short)"X-Artist"));
                if(arr_b2 == null) {
                    LogU.d("CursorUtil", "Failure, get artist.");
                    s3 = "";
                }
                else {
                    s3 = new String(arr_b2, "euc-kr");
                }
                byte[] arr_b3 = MelonDRMMetaInterface.DRMMetaGetUnsupportedValue(((short)v2), ((short)"X-Album"));
                if(arr_b3 == null) {
                    LogU.d("CursorUtil", "Failure, get album.");
                    s4 = "";
                }
                else {
                    s4 = new String(arr_b3, "euc-kr");
                }
                byte[] arr_b4 = MelonDRMMetaInterface.DRMMetaGetUnsupportedValue(((short)v2), ((short)"X-Genre"));
                if(arr_b4 == null) {
                    LogU.d("CursorUtil", "Failure, get genre.");
                }
                else {
                    s1 = new String(arr_b4, "euc-kr");
                }
                LogU.d("CursorUtil", "title : " + s2);
                LogU.d("CursorUtil", "artistName : " + s3);
                LogU.d("CursorUtil", "album : " + s4);
                LogU.d("CursorUtil", "genre : " + s1);
                MelonDRMMetaInterface.DRMMetaClose(((short)v2));
                return;
            }
            LogU.d("CursorUtil", "Failure, load content, fd = " + v2);
        }
        catch(Exception exception0) {
            LogU.d("CursorUtil", "ee = " + exception0.toString());
        }
        finally {
            b0.e();
        }
    }

    public static Uri getAudioContentUri(long v) {
        return ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, v);
    }

    public static String getDisplayName(Context context0, Uri uri0) {
        Cursor cursor0;
        String s = "";
        if(context0 != null && uri0 != null) {
            try {
                cursor0 = null;
                cursor0 = context0.getContentResolver().query(uri0, new String[]{"_display_name"}, null, null, null);
                if(cursor0 != null && cursor0.moveToFirst()) {
                    s = cursor0.getString(cursor0.getColumnIndex("_display_name"));
                }
            }
            catch(Exception unused_ex) {
                if(cursor0 != null) {
                    cursor0.close();
                }
                return "";
            }
            catch(Throwable throwable0) {
                TWR.safeClose$NT(cursor0, throwable0);
                throw throwable0;
            }
            if(cursor0 != null) {
                cursor0.close();
            }
            return s;
        }
        return "";
    }

    @Deprecated
    public static Cursor mergeAlbumCursor(Context context0, ContentResolver contentResolver0, Cursor cursor0, Cursor cursor1, String[] arr_s, Class[] arr_class, String s, String[] arr_s1, String s1, boolean z, boolean z1) {
        int v4;
        if(arr_s != null && arr_class != null) {
            ArrayList arrayList0 = new ArrayList();
            HashMap hashMap0 = new HashMap();
            int[] arr_v = new int[arr_s.length];
            if(cursor0 != null) {
                try {
                    if(cursor0.getCount() > 0) {
                        for(int v = 0; v < arr_s.length; ++v) {
                            arr_v[v] = v < 2 ? v : cursor0.getColumnIndex(arr_s[v]);
                        }
                        if(cursor0.moveToFirst()) {
                            for(int v1 = cursor0.getColumnIndex(s); true; v1 = v4) {
                                int v2 = MusicUtils.getAlbumCount(context0, cursor0.getLong(0), -1L, z, z1);
                                if(v2 == 0) {
                                    v4 = v1;
                                }
                                else {
                                    Object object0 = CursorUtil.a(cursor0, arr_v[v1], arr_class[v1]);
                                    ArrayList arrayList1 = new ArrayList();
                                    for(int v3 = 0; v3 < arr_s.length; ++v3) {
                                        arrayList1.add(CursorUtil.a(cursor0, arr_v[v3], arr_class[v3]));
                                    }
                                    v4 = v1;
                                    arrayList1.set(1, -1);
                                    arrayList1.set(8, v2);
                                    hashMap0.put(((String)object0), arrayList1);
                                    arrayList0.add(arrayList1);
                                }
                                if(!cursor0.moveToNext()) {
                                    break;
                                }
                            }
                        }
                    }
                }
                catch(Throwable throwable0) {
                    TWR.safeClose$NT(cursor0, throwable0);
                    throw throwable0;
                }
            }
            if(cursor0 != null) {
                cursor0.close();
            }
            cursor1 = TWR.getResource$NT(cursor1);
            TWR.declareResource(cursor1);
            if(cursor1 != null) {
                try {
                    TWR.useResource$NT(cursor1);
                    if(cursor1.getCount() > 0) {
                        TWR.useResource$NT(cursor1);
                        for(int v5 = 0; true; ++v5) {
                            TWR.useResource$NT(cursor1);
                            if(v5 >= arr_s.length) {
                                break;
                            }
                            TWR.useResource$NT(cursor1);
                            if(v5 < 2) {
                                TWR.useResource$NT(cursor1);
                                arr_v[v5] = v5;
                            }
                            else {
                                TWR.useResource$NT(cursor1);
                                arr_v[v5] = cursor1.getColumnIndex(arr_s[v5]);
                            }
                            TWR.useResource$NT(cursor1);
                        }
                        TWR.useResource$NT(cursor1);
                        if(cursor1.moveToFirst()) {
                            TWR.useResource$NT(cursor1);
                            int[] arr_v1 = new int[arr_s1.length];
                            for(int v6 = 0; true; ++v6) {
                                TWR.useResource$NT(cursor1);
                                if(v6 >= arr_s1.length) {
                                    break;
                                }
                                TWR.useResource$NT(cursor1);
                                arr_v1[v6] = -1;
                                for(int v7 = 0; true; ++v7) {
                                    TWR.useResource$NT(cursor1);
                                    if(v7 >= arr_s.length) {
                                        break;
                                    }
                                    TWR.useResource$NT(cursor1);
                                    if(arr_s1[v6].equals(arr_s[v7])) {
                                        TWR.useResource$NT(cursor1);
                                        arr_v1[v6] = v7;
                                        break;
                                    }
                                    TWR.useResource$NT(cursor1);
                                }
                                TWR.useResource$NT(cursor1);
                            }
                            TWR.useResource$NT(cursor1);
                            int v8 = cursor1.getColumnIndex(s);
                            while(true) {
                                TWR.useResource$NT(cursor1);
                                int v9 = MusicUtils.getAlbumCount(context0, -1L, cursor1.getLong(1), z, z1);
                                if(v9 != 0) {
                                    TWR.useResource$NT(cursor1);
                                    ArrayList arrayList2 = (ArrayList)hashMap0.get(CursorUtil.a(cursor1, arr_v[v8], arr_class[v8]));
                                    if(arrayList2 == null) {
                                        TWR.useResource$NT(cursor1);
                                        ArrayList arrayList3 = new ArrayList();
                                        for(int v14 = 0; true; ++v14) {
                                            TWR.useResource$NT(cursor1);
                                            if(v14 >= arr_s.length) {
                                                break;
                                            }
                                            TWR.useResource$NT(cursor1);
                                            arrayList3.add(CursorUtil.a(cursor1, arr_v[v14], arr_class[v14]));
                                        }
                                        TWR.useResource$NT(cursor1);
                                        arrayList3.set(0, -1);
                                        arrayList3.set(8, v9);
                                        arrayList0.add(arrayList3);
                                    }
                                    else {
                                        TWR.useResource$NT(cursor1);
                                        arrayList2.set(1, CursorUtil.a(cursor1, arr_v[1], arr_class[1]));
                                        for(int v10 = 0; true; ++v10) {
                                            TWR.useResource$NT(cursor1);
                                            if(v10 >= arr_s1.length) {
                                                break;
                                            }
                                            TWR.useResource$NT(cursor1);
                                            int v11 = arr_v1[v10];
                                            if(v11 >= 0) {
                                                TWR.useResource$NT(cursor1);
                                                int v12 = (int)(((Integer)arrayList2.get(v11)));
                                                int v13 = arr_v1[v10];
                                                arrayList2.set(v13, ((int)(v12 + ((int)(((Integer)CursorUtil.a(cursor1, arr_v[v13], arr_class[v13])))))));
                                            }
                                            TWR.useResource$NT(cursor1);
                                        }
                                        TWR.useResource$NT(cursor1);
                                        arrayList2.set(8, ((int)(((int)(((Integer)arrayList2.get(8)))) + v9)));
                                    }
                                }
                                TWR.useResource$NT(cursor1);
                                if(!cursor1.moveToNext()) {
                                    break;
                                }
                            }
                        }
                    }
                    TWR.useResource$NT(cursor1);
                    cursor1.close();
                }
                catch(Throwable throwable1) {
                    TWR.moot$NT();
                    throw throwable1;
                }
            }
            hashMap0.clear();
            String[] arr_s2 = (String[])arr_s.clone();
            arr_s2[1] = "_id2";
            CursorUtil.b(arrayList0, arr_s2, s1);
            Cursor cursor2 = new ArrayListCursor(arr_s2, arrayList0);
            ((AbstractCursor)cursor2).setNotificationUri(contentResolver0, Uri.parse("content://media"));
            return cursor2;
        }
        return null;
    }

    @Deprecated
    public static Cursor mergeArtistCursor(Context context0, ContentResolver contentResolver0, Cursor cursor0, Cursor cursor1, String[] arr_s, Class[] arr_class, String s, String[] arr_s1, String s1, boolean z, boolean z1) {
        int v4;
        if(arr_s != null && arr_class != null) {
            ArrayList arrayList0 = new ArrayList();
            HashMap hashMap0 = new HashMap();
            int[] arr_v = new int[arr_s.length];
            if(cursor0 != null) {
                try {
                    if(cursor0.getCount() > 0) {
                        for(int v = 0; v < arr_s.length; ++v) {
                            arr_v[v] = v < 2 ? v : cursor0.getColumnIndex(arr_s[v]);
                        }
                        if(cursor0.moveToFirst()) {
                            for(int v1 = cursor0.getColumnIndex(s); true; v1 = v4) {
                                int v2 = MusicUtils.getArtistCount(context0, cursor0.getLong(0), -1L, z, z1);
                                if(v2 == 0) {
                                    v4 = v1;
                                }
                                else {
                                    Object object0 = CursorUtil.a(cursor0, arr_v[v1], arr_class[v1]);
                                    ArrayList arrayList1 = new ArrayList();
                                    for(int v3 = 0; v3 < arr_s.length; ++v3) {
                                        arrayList1.add(CursorUtil.a(cursor0, arr_v[v3], arr_class[v3]));
                                    }
                                    v4 = v1;
                                    arrayList1.set(1, -1);
                                    arrayList1.set(5, v2);
                                    hashMap0.put(((String)object0), arrayList1);
                                    arrayList0.add(arrayList1);
                                }
                                if(!cursor0.moveToNext()) {
                                    break;
                                }
                            }
                        }
                    }
                }
                catch(Throwable throwable0) {
                    TWR.safeClose$NT(cursor0, throwable0);
                    throw throwable0;
                }
            }
            if(cursor0 != null) {
                cursor0.close();
            }
            cursor1 = TWR.getResource$NT(cursor1);
            TWR.declareResource(cursor1);
            if(cursor1 != null) {
                try {
                    TWR.useResource$NT(cursor1);
                    if(cursor1.getCount() > 0) {
                        TWR.useResource$NT(cursor1);
                        for(int v5 = 0; true; ++v5) {
                            TWR.useResource$NT(cursor1);
                            if(v5 >= arr_s.length) {
                                break;
                            }
                            TWR.useResource$NT(cursor1);
                            if(v5 < 2) {
                                TWR.useResource$NT(cursor1);
                                arr_v[v5] = v5;
                            }
                            else {
                                TWR.useResource$NT(cursor1);
                                arr_v[v5] = cursor1.getColumnIndex(arr_s[v5]);
                            }
                            TWR.useResource$NT(cursor1);
                        }
                        TWR.useResource$NT(cursor1);
                        if(cursor1.moveToFirst()) {
                            TWR.useResource$NT(cursor1);
                            int[] arr_v1 = new int[arr_s1.length];
                            for(int v6 = 0; true; ++v6) {
                                TWR.useResource$NT(cursor1);
                                if(v6 >= arr_s1.length) {
                                    break;
                                }
                                TWR.useResource$NT(cursor1);
                                arr_v1[v6] = -1;
                                for(int v7 = 0; true; ++v7) {
                                    TWR.useResource$NT(cursor1);
                                    if(v7 >= arr_s.length) {
                                        break;
                                    }
                                    TWR.useResource$NT(cursor1);
                                    if(arr_s1[v6].equals(arr_s[v7])) {
                                        TWR.useResource$NT(cursor1);
                                        arr_v1[v6] = v7;
                                        break;
                                    }
                                    TWR.useResource$NT(cursor1);
                                }
                                TWR.useResource$NT(cursor1);
                            }
                            TWR.useResource$NT(cursor1);
                            int v8 = cursor1.getColumnIndex(s);
                            do {
                                TWR.useResource$NT(cursor1);
                                int v9 = MusicUtils.getArtistCount(context0, -1L, cursor1.getLong(1), z, z1);
                                if(v9 != 0) {
                                    TWR.useResource$NT(cursor1);
                                    ArrayList arrayList2 = (ArrayList)hashMap0.get(CursorUtil.a(cursor1, arr_v[v8], arr_class[v8]));
                                    if(arrayList2 == null) {
                                        TWR.useResource$NT(cursor1);
                                        ArrayList arrayList3 = new ArrayList();
                                        for(int v14 = 0; true; ++v14) {
                                            TWR.useResource$NT(cursor1);
                                            if(v14 >= arr_s.length) {
                                                break;
                                            }
                                            TWR.useResource$NT(cursor1);
                                            arrayList3.add(CursorUtil.a(cursor1, arr_v[v14], arr_class[v14]));
                                        }
                                        TWR.useResource$NT(cursor1);
                                        arrayList3.set(0, -1);
                                        arrayList3.set(5, v9);
                                        arrayList0.add(arrayList3);
                                    }
                                    else {
                                        TWR.useResource$NT(cursor1);
                                        arrayList2.set(1, CursorUtil.a(cursor1, arr_v[1], arr_class[1]));
                                        for(int v10 = 0; true; ++v10) {
                                            TWR.useResource$NT(cursor1);
                                            if(v10 >= arr_s1.length) {
                                                break;
                                            }
                                            TWR.useResource$NT(cursor1);
                                            int v11 = arr_v1[v10];
                                            if(v11 >= 0) {
                                                TWR.useResource$NT(cursor1);
                                                int v12 = (int)(((Integer)arrayList2.get(v11)));
                                                int v13 = arr_v1[v10];
                                                arrayList2.set(v13, ((int)(v12 + ((int)(((Integer)CursorUtil.a(cursor1, arr_v[v13], arr_class[v13])))))));
                                            }
                                            TWR.useResource$NT(cursor1);
                                        }
                                        TWR.useResource$NT(cursor1);
                                        arrayList2.set(5, ((int)(((int)(((Integer)arrayList2.get(5)))) + v9)));
                                    }
                                }
                                TWR.useResource$NT(cursor1);
                            }
                            while(cursor1.moveToNext());
                        }
                    }
                }
                catch(Throwable throwable1) {
                    TWR.moot$NT();
                    throw throwable1;
                }
            }
            hashMap0.clear();
            String[] arr_s2 = (String[])arr_s.clone();
            arr_s2[1] = "_id2";
            CursorUtil.b(arrayList0, arr_s2, s1);
            Cursor cursor2 = new ArrayListCursor(arr_s2, arrayList0);
            ((AbstractCursor)cursor2).setNotificationUri(contentResolver0, Uri.parse("content://media"));
            return cursor2;
        }
        return null;
    }

    @Deprecated
    public static Cursor mergeGenreCursor(Context context0, ContentResolver contentResolver0, Cursor cursor0, Cursor cursor1, String[] arr_s, Class[] arr_class, String s, String s1, boolean z, boolean z1) {
        int v9;
        int v3;
        if(arr_s != null && arr_class != null) {
            ArrayList arrayList0 = new ArrayList();
            HashMap hashMap0 = new HashMap();
            int[] arr_v = new int[arr_s.length];
            if(cursor0 != null) {
                try {
                    if(cursor0.getCount() > 0) {
                        for(int v = 0; v < arr_s.length; ++v) {
                            arr_v[v] = v < 2 ? v : cursor0.getColumnIndex(arr_s[v]);
                        }
                        if(cursor0.moveToFirst()) {
                            int v1 = cursor0.getColumnIndex(s);
                            do {
                                long v2 = cursor0.getLong(0);
                                if(z1) {
                                    int v4 = MusicUtils.getGenreCount(context0, v2, -1L, z);
                                    if(v4 != 0) {
                                        v3 = v4;
                                    label_23:
                                        Object object0 = CursorUtil.a(cursor0, arr_v[v1], arr_class[v1]);
                                        ArrayList arrayList1 = new ArrayList();
                                        for(int v5 = 0; v5 < arr_s.length; ++v5) {
                                            arrayList1.add(CursorUtil.a(cursor0, arr_v[v5], arr_class[v5]));
                                        }
                                        arrayList1.set(1, -1);
                                        arrayList1.set(3, v3);
                                        hashMap0.put(((String)object0), arrayList1);
                                        arrayList0.add(arrayList1);
                                    }
                                }
                                else {
                                    v3 = 0;
                                    goto label_23;
                                }
                            }
                            while(cursor0.moveToNext());
                        }
                    }
                }
                catch(Throwable throwable0) {
                    TWR.safeClose$NT(cursor0, throwable0);
                    throw throwable0;
                }
            }
            if(cursor0 != null) {
                cursor0.close();
            }
            cursor1 = TWR.getResource$NT(cursor1);
            TWR.declareResource(cursor1);
            if(cursor1 != null) {
                try {
                    TWR.useResource$NT(cursor1);
                    if(cursor1.getCount() > 0) {
                        TWR.useResource$NT(cursor1);
                        for(int v6 = 0; true; ++v6) {
                            TWR.useResource$NT(cursor1);
                            if(v6 >= arr_s.length) {
                                break;
                            }
                            TWR.useResource$NT(cursor1);
                            if(v6 < 2) {
                                TWR.useResource$NT(cursor1);
                                arr_v[v6] = v6;
                            }
                            else {
                                TWR.useResource$NT(cursor1);
                                arr_v[v6] = cursor1.getColumnIndex(arr_s[v6]);
                            }
                            TWR.useResource$NT(cursor1);
                        }
                        TWR.useResource$NT(cursor1);
                        if(cursor1.moveToFirst()) {
                            TWR.useResource$NT(cursor1);
                            int v7 = cursor1.getColumnIndex(s);
                            do {
                                TWR.useResource$NT(cursor1);
                                long v8 = cursor1.getLong(1);
                                if(z1) {
                                    TWR.useResource$NT(cursor1);
                                    int v10 = MusicUtils.getGenreCount(context0, -1L, v8, z);
                                    if(v10 != 0) {
                                        v9 = v10;
                                    label_74:
                                        TWR.useResource$NT(cursor1);
                                        ArrayList arrayList2 = (ArrayList)hashMap0.get(CursorUtil.a(cursor1, arr_v[v7], arr_class[v7]));
                                        if(arrayList2 == null) {
                                            TWR.useResource$NT(cursor1);
                                            ArrayList arrayList3 = new ArrayList();
                                            for(int v11 = 0; true; ++v11) {
                                                TWR.useResource$NT(cursor1);
                                                if(v11 >= arr_s.length) {
                                                    break;
                                                }
                                                TWR.useResource$NT(cursor1);
                                                arrayList3.add(CursorUtil.a(cursor1, arr_v[v11], arr_class[v11]));
                                            }
                                            TWR.useResource$NT(cursor1);
                                            arrayList3.set(0, -1);
                                            arrayList3.set(3, v9);
                                            arrayList0.add(arrayList3);
                                        }
                                        else {
                                            TWR.useResource$NT(cursor1);
                                            arrayList2.set(1, CursorUtil.a(cursor1, arr_v[0], arr_class[0]));
                                            arrayList2.set(3, ((int)(((int)(((Integer)arrayList2.get(3)))) + v9)));
                                        }
                                    }
                                }
                                else {
                                    TWR.useResource$NT(cursor1);
                                    v9 = 0;
                                    goto label_74;
                                }
                                TWR.useResource$NT(cursor1);
                            }
                            while(cursor1.moveToNext());
                        }
                    }
                }
                catch(Throwable throwable1) {
                    TWR.moot$NT();
                    throw throwable1;
                }
            }
            hashMap0.clear();
            String[] arr_s1 = (String[])arr_s.clone();
            arr_s1[1] = "_id2";
            CursorUtil.b(arrayList0, arr_s1, s1);
            Cursor cursor2 = new ArrayListCursor(arr_s1, arrayList0);
            ((AbstractCursor)cursor2).setNotificationUri(contentResolver0, Uri.parse("content://media"));
            return cursor2;
        }
        return null;
    }

    @Deprecated
    public static Cursor mergeNowplayingCursor(ContentResolver contentResolver0, Cursor cursor0, Cursor cursor1, String[] arr_s, Class[] arr_class, String[] arr_s1) {
        int v = -1;
        if(arr_s != null && arr_class != null) {
            ArrayList arrayList0 = new ArrayList();
            int[] arr_v = new int[arr_s.length];
            if(cursor0 != null) {
                if(cursor0.getCount() > 0) {
                    for(int v1 = 0; v1 < arr_s.length; ++v1) {
                        arr_v[v1] = v1 < 2 ? v1 : cursor0.getColumnIndex(arr_s[v1]);
                    }
                    if(cursor0.moveToFirst()) {
                        while(true) {
                            ArrayList arrayList1 = new ArrayList();
                            for(int v2 = 0; v2 < arr_s.length; ++v2) {
                                arrayList1.add(CursorUtil.a(cursor0, arr_v[v2], arr_class[v2]));
                            }
                            arrayList1.set(1, -1);
                            arrayList0.add(arrayList1);
                            if(!cursor0.moveToNext()) {
                                break;
                            }
                        }
                    }
                }
                cursor0.close();
            }
            if(cursor1 != null) {
                if(cursor1.getCount() > 0) {
                    for(int v3 = 0; v3 < arr_s.length; ++v3) {
                        arr_v[v3] = v3 < 2 ? v3 : cursor1.getColumnIndex(arr_s[v3]);
                    }
                    if(cursor1.moveToFirst()) {
                        while(true) {
                            ArrayList arrayList2 = new ArrayList();
                            for(int v4 = 0; v4 < arr_s.length; ++v4) {
                                arrayList2.add(CursorUtil.a(cursor1, arr_v[v4], arr_class[v4]));
                            }
                            arrayList2.set(0, -1);
                            arrayList0.add(arrayList2);
                            if(!cursor1.moveToNext()) {
                                break;
                            }
                        }
                    }
                }
                cursor1.close();
            }
            String[] arr_s2 = (String[])arr_s.clone();
            arr_s2[1] = "_id2";
            for(int v5 = 0; v5 < arr_s2.length; ++v5) {
                if(arr_s2[v5].equals("_data")) {
                    v = v5;
                    break;
                }
            }
            if(v >= 0) {
                ArrayList arrayList3 = new ArrayList();
                for(int v6 = 0; v6 < arr_s1.length; ++v6) {
                    for(int v7 = 0; v7 < arrayList0.size(); ++v7) {
                        ArrayList arrayList4 = (ArrayList)arrayList0.get(v7);
                        if(arr_s1[v6].equals(arrayList4.get(v))) {
                            arrayList3.add(arrayList4);
                            break;
                        }
                    }
                }
                arrayList0 = arrayList3;
            }
            Cursor cursor2 = new ArrayListCursor(arr_s2, arrayList0);
            ((AbstractCursor)cursor2).setNotificationUri(contentResolver0, Uri.parse("content://media"));
            return cursor2;
        }
        return null;
    }

    public static Cursor mergeTrackCursor(ContentResolver contentResolver0, Cursor cursor0, Cursor cursor1, String[] arr_s, Class[] arr_class, String s) {
        if(arr_s != null && arr_class != null) {
            ArrayList arrayList0 = new ArrayList();
            int[] arr_v = new int[arr_s.length];
            if(cursor0 != null) {
                try {
                    if(cursor0.getCount() > 0) {
                        for(int v = 0; v < arr_s.length; ++v) {
                            arr_v[v] = v < 2 ? v : cursor0.getColumnIndex(arr_s[v]);
                        }
                        if(cursor0.moveToFirst()) {
                            do {
                                ArrayList arrayList1 = new ArrayList();
                                for(int v1 = 0; v1 < arr_s.length; ++v1) {
                                    arrayList1.add(CursorUtil.a(cursor0, arr_v[v1], arr_class[v1]));
                                }
                                arrayList1.set(1, -1);
                                arrayList0.add(arrayList1);
                            }
                            while(cursor0.moveToNext());
                        }
                    }
                }
                catch(Throwable throwable0) {
                    TWR.safeClose$NT(cursor0, throwable0);
                    throw throwable0;
                }
            }
            if(cursor0 != null) {
                cursor0.close();
            }
            cursor1 = TWR.getResource$NT(cursor1);
            TWR.declareResource(cursor1);
            if(cursor1 != null) {
                try {
                    TWR.useResource$NT(cursor1);
                    if(cursor1.getCount() > 0) {
                        TWR.useResource$NT(cursor1);
                        for(int v2 = 0; true; ++v2) {
                            TWR.useResource$NT(cursor1);
                            if(v2 >= arr_s.length) {
                                break;
                            }
                            TWR.useResource$NT(cursor1);
                            if(v2 < 2) {
                                TWR.useResource$NT(cursor1);
                                arr_v[v2] = v2;
                            }
                            else {
                                TWR.useResource$NT(cursor1);
                                arr_v[v2] = cursor1.getColumnIndex(arr_s[v2]);
                            }
                            TWR.useResource$NT(cursor1);
                        }
                        TWR.useResource$NT(cursor1);
                        if(cursor1.moveToFirst()) {
                            do {
                                TWR.useResource$NT(cursor1);
                                ArrayList arrayList2 = new ArrayList();
                                for(int v3 = 0; true; ++v3) {
                                    TWR.useResource$NT(cursor1);
                                    if(v3 >= arr_s.length) {
                                        break;
                                    }
                                    TWR.useResource$NT(cursor1);
                                    arrayList2.add(CursorUtil.a(cursor1, arr_v[v3], arr_class[v3]));
                                }
                                TWR.useResource$NT(cursor1);
                                arrayList2.set(0, -1);
                                arrayList0.add(arrayList2);
                            }
                            while(cursor1.moveToNext());
                        }
                    }
                }
                catch(Throwable throwable1) {
                    TWR.moot$NT();
                    throw throwable1;
                }
            }
            String[] arr_s1 = (String[])arr_s.clone();
            arr_s1[1] = "_id2";
            CursorUtil.b(arrayList0, arr_s1, s);
            Cursor cursor2 = new ArrayListCursor(arr_s1, arrayList0);
            ((AbstractCursor)cursor2).setNotificationUri(contentResolver0, Uri.parse("content://media"));
            return cursor2;
        }
        return null;
    }
}

