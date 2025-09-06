package i9;

import DigiCAP.SKT.DRM.DrmInitException;
import DigiCAP.SKT.DRM.MelonDRMMetaInterface;
import H8.k;
import R8.r;
import S8.b;
import U4.x;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.eventbus.EventAudioSync.Finish;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.mediastore.MelonMediaScanner;
import com.iloen.melon.types.Song;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.player.SongMetaParser;
import java.io.UnsupportedEncodingException;
import kotlin.jvm.internal.q;

public final class g {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public int f;
    public int g;
    public int h;
    public int i;
    public String j;
    public long k;
    public long l;
    public final MelonMediaScanner m;

    public g(MelonMediaScanner melonMediaScanner0) {
        this.m = melonMediaScanner0;
    }

    public static Uri a(g g0, String s, long v, long v1) {
        Uri uri4;
        Cursor cursor1;
        Cursor cursor0;
        Uri uri2;
        Uri uri1;
        int v13;
        int v9;
        byte[] arr_b;
        b b0;
        f f0;
        LogU.d("MelonMediaScanner", "doScanFile " + s);
        MelonMediaScanner melonMediaScanner0 = g0.m;
        int v2 = s.lastIndexOf(0x2F);
        if(v2 < 0 || v2 + 2 >= s.length() || !s.regionMatches(true, s.length() - 4, ".jpg", 0, 4)) {
        label_13:
            g0.e = null;
            g0.l = v1;
            int v4 = s.lastIndexOf(".");
            if((v4 >= 0 ? ((a)i9.b.a.get(s.substring(v4 + 1).toUpperCase())) : null) != null) {
                g0.f = 1;
                g0.e = "audio/x-mp3";
            }
            String s1 = melonMediaScanner0.g ? s.toLowerCase() : s;
            f f1 = (f)melonMediaScanner0.a.get(s1);
            if(f1 == null) {
                f1 = new f(0L, s, 0L);
                melonMediaScanner0.a.put(s1, f1);
            }
            f0 = f1;
            long v5 = v - f0.c;
            if(v5 > 1L || v5 < -1L) {
                f0.c = v;
                f0.d = true;
            }
            g0.a = null;
            g0.b = null;
            g0.c = null;
            g0.d = null;
            g0.g = 0;
            g0.h = 0;
            g0.i = 0;
            g0.j = s;
            g0.k = v;
        }
        else if(s.regionMatches(v2 + 1, "._", 0, 2)) {
        label_11:
            f0 = null;
        }
        else if(!s.regionMatches(true, v2 + 1, "AlbumArt_{", 0, 10) && !s.regionMatches(true, v2 + 1, "AlbumArt.", 0, 9)) {
            int v3 = s.length() - v2 - 1;
            if(v3 == 17 && s.regionMatches(true, v2 + 1, "AlbumArtSmall", 0, 13) || v3 == 10 && s.regionMatches(true, v2 + 1, "Folder", 0, 6)) {
                f0 = null;
            }
            else {
                goto label_13;
            }
        }
        else {
            goto label_11;
        }
        LogU.d("MelonMediaScanner", "beginFile, modified check = " + f0.d);
        if(s.toLowerCase().endsWith(".dcf") && (g0.f >= 1 && g0.f <= 1)) {
            try {
                b0 = b.b("scanner");
                long v6 = MelonDRMMetaInterface.DRMMetaSetClientID(r.a(MelonAppBase.instance.getDeviceData().h()));
                if(v6 < 0L) {
                    LogU.w("MelonMediaScanner", "Failure, setClientId, result = " + v6);
                    return null;
                }
            }
            catch(DrmInitException drmInitException0) {
                drmInitException0.printStackTrace();
                return null;
            }
            try {
                LogU.d("MelonMediaScanner", "processFile " + s);
                try {
                    arr_b = s.getBytes("utf-8");
                }
                catch(UnsupportedEncodingException unsupportedEncodingException0) {
                    LogU.d("MelonMediaScanner", unsupportedEncodingException0.toString());
                    return null;
                }
                int v8 = b.c(arr_b);
                if(v8 > 0) {
                    g0.c = MelonDRMMetaInterface.DRMMetaGetUnsupportedValueUTF8(v8, "Title");
                    g0.a = MelonDRMMetaInterface.DRMMetaGetUnsupportedValueUTF8(v8, "X-Artist");
                    g0.b = MelonDRMMetaInterface.DRMMetaGetUnsupportedValueUTF8(v8, "X-Album");
                    g0.d = MelonDRMMetaInterface.DRMMetaGetUnsupportedValueUTF8(v8, "X-Genre");
                    String s2 = MelonDRMMetaInterface.DRMMetaGetUnsupportedValueUTF8(v8, "X-TrackNum");
                    g0.g = TextUtils.isEmpty(s2) ? 0 : Integer.parseInt(s2);
                    byte[] arr_b1 = MelonDRMMetaInterface.DRMMetaGetMetaTextValueFromID3UTF8(v8, "TPOS");
                    if(arr_b1 == null) {
                        LogU.d("MelonMediaScanner", "Failure, get TPOS.");
                    }
                    else {
                        String s3 = new String(arr_b1, "euc-kr");
                        if(TextUtils.isEmpty(s3)) {
                            v9 = 0;
                        }
                        else {
                            LogU.e("MelonMediaScanner", "TPOS = " + s3);
                            v9 = Integer.parseInt(s3);
                        }
                        if(v9 > 0) {
                            g0.g = v9 * 1000 + g0.g;
                        }
                    }
                    byte[] arr_b2 = MelonDRMMetaInterface.DRMMetaGetMetaTextValueFromID3UTF8(v8, "TYER");
                    if(arr_b2 == null) {
                        LogU.d("MelonMediaScanner", "Failure, get TYER.");
                    }
                    else {
                        String s4 = new String(arr_b2, "euc-kr");
                        g0.h = TextUtils.isEmpty(s4) ? 0 : StringUtils.getNumberFromString(s4);
                    }
                    String s5 = MelonDRMMetaInterface.DRMMetaGetUnsupportedValueUTF8(v8, "Length");
                    if(!TextUtils.isEmpty(s5)) {
                        int v10 = s5.indexOf(":");
                        if(v10 > 0) {
                            int v11 = s5.indexOf(":", v10 + 1);
                            if(v11 > 0) {
                                int v12 = Integer.parseInt(s5.substring(0, v10));
                                v13 = Integer.parseInt(s5.substring(v10 + 1, v11)) * 60 + v12 * 3600 + Integer.parseInt(s5.substring(v11 + 1));
                            }
                            else {
                                v13 = 0;
                            }
                        }
                        else {
                            v13 = 0;
                        }
                        g0.i = v13 * 1000;
                    }
                    g0.j = s;
                    g0.k = v;
                    g0.l = v1;
                    LogU.i("MelonMediaScanner", "extracted: " + g0.toString());
                    MelonDRMMetaInterface.DRMMetaClose(((short)v8));
                    goto label_110;
                }
                LogU.d("MelonMediaScanner", "Failure, load content, fd = " + v8);
                return null;
            }
            catch(Exception exception0) {
                LogU.d("MelonMediaScanner", "ee = " + exception0.toString());
            }
            finally {
                b0.e();
            }
        label_110:
            if(g0.f < 1 || g0.f > 1) {
                uri2 = null;
            }
            else {
                Uri uri0 = melonMediaScanner0.d;
                Context context0 = melonMediaScanner0.c;
                if(g0.a == null || g0.a.length() == 0) {
                    g0.a = null;
                }
                ContentValues contentValues0 = new ContentValues();
                contentValues0.put("_data", g0.j);
                contentValues0.put("title", g0.c);
                contentValues0.put("date_modified", g0.k);
                contentValues0.put("_size", g0.l);
                contentValues0.put("mime_type", g0.e);
                if(g0.f >= 1 && g0.f <= 1) {
                    contentValues0.put("artist", (g0.a == null || g0.a.length() <= 0 ? "<unknown>" : g0.a));
                    contentValues0.put("album_artist", null);
                    contentValues0.put("album", (g0.b == null || g0.b.length() <= 0 ? "<unknown>" : g0.b));
                    contentValues0.put("composer", null);
                    int v14 = g0.h;
                    if(v14 == 0) {
                        contentValues0.put("year", "");
                    }
                    else {
                        contentValues0.put("year", v14);
                    }
                    contentValues0.put("track", g0.g);
                    contentValues0.put("duration", g0.i);
                    contentValues0.put("composer", "");
                    contentValues0.put("is_ringtone", 0);
                    contentValues0.put("is_alarm", 0);
                    contentValues0.put("is_notification", 0);
                }
                String s6 = contentValues0.getAsString("title");
                if(s6 == null || TextUtils.isEmpty(s6.trim())) {
                    String s7 = contentValues0.getAsString("_data");
                    int v15 = s7.lastIndexOf(0x2F);
                    if(v15 >= 0 && v15 + 1 < s7.length()) {
                        s7 = s7.substring(v15 + 1);
                    }
                    int v16 = s7.lastIndexOf(46);
                    if(v16 > 0) {
                        s7 = s7.substring(0, v16);
                    }
                    contentValues0.put("title", s7);
                }
                if("<unknown>".equals(contentValues0.getAsString("album"))) {
                    String s8 = contentValues0.getAsString("_data");
                    int v17 = s8.lastIndexOf(0x2F);
                    if(v17 >= 0) {
                        int v18;
                        for(v18 = 0; true; v18 = v19) {
                            int v19 = s8.indexOf(0x2F, v18 + 1);
                            if(v19 < 0 || v19 >= v17) {
                                break;
                            }
                        }
                        if(v18 != 0) {
                            contentValues0.put("album", s8.substring(v18 + 1, v17));
                        }
                    }
                }
                long v20 = f0.a;
                if(v20 == 0L) {
                    contentValues0.put("is_music", Boolean.TRUE);
                }
                if(v20 == 0L) {
                    uri1 = context0.getContentResolver().insert(uri0, contentValues0);
                    if(uri1 != null) {
                        v20 = ContentUris.parseId(uri1);
                        f0.a = v20;
                    }
                }
                else {
                    uri1 = ContentUris.withAppendedId(uri0, v20);
                    context0.getContentResolver().update(uri1, contentValues0, null, null);
                }
                uri2 = uri1;
                if(melonMediaScanner0.f) {
                    String s9 = g0.d;
                    if(s9 != null) {
                        Uri uri3 = (Uri)melonMediaScanner0.b.get(s9);
                        if(uri3 == null) {
                            try {
                                cursor0 = context0.getContentResolver().query(melonMediaScanner0.e, MelonMediaScanner.j, "name=?", new String[]{s9}, null);
                            }
                            catch(Throwable throwable0) {
                                cursor1 = null;
                                goto label_195;
                            }
                            if(cursor0 == null) {
                                goto label_186;
                            }
                            else {
                                try {
                                    if(cursor0.getCount() == 0) {
                                    label_186:
                                        contentValues0.clear();
                                        contentValues0.put("name", s9);
                                        uri4 = context0.getContentResolver().insert(melonMediaScanner0.e, contentValues0);
                                    }
                                    else {
                                        cursor0.moveToNext();
                                        uri4 = ContentUris.withAppendedId(melonMediaScanner0.e, cursor0.getLong(0));
                                    }
                                label_189:
                                    if(uri4 != null) {
                                        uri4 = Uri.withAppendedPath(uri4, "members");
                                        melonMediaScanner0.b.put(s9, uri4);
                                    }
                                    goto label_198;
                                }
                                catch(Throwable throwable0) {
                                    goto label_194;
                                }
                            }
                            goto label_189;
                        label_194:
                            cursor1 = cursor0;
                        label_195:
                            if(cursor1 != null) {
                                cursor1.close();
                            }
                            throw throwable0;
                        label_198:
                            if(cursor0 != null) {
                                cursor0.close();
                            }
                            uri3 = uri4;
                        }
                        if(uri3 != null) {
                            contentValues0.clear();
                            contentValues0.put("audio_id", v20);
                            context0.getContentResolver().insert(uri3, contentValues0);
                        }
                    }
                }
            }
            String s10 = g0.j == null ? "" : g0.j.toString();
            int v21 = s10.lastIndexOf(0x2F);
            if(v21 >= 0) {
                s10 = s10.substring(v21 + 1);
            }
            long v22 = System.currentTimeMillis();
            G8.g.a.m();
            k k0 = G8.g.k(g0.j);
            if(g0.c == null || TextUtils.isEmpty(g0.c.trim())) {
                int v23 = s10.lastIndexOf(46);
                g0.c = v23 <= 0 ? s10 : s10.substring(0, v23);
            }
            String s11 = g0.a == null || g0.a.length() <= 0 ? "<unknown>" : g0.a;
            String s12 = g0.b == null || g0.b.length() <= 0 ? "<unknown>" : g0.b;
            if(k0 == null) {
                k k1 = new k();
                String s13 = g0.j;
                q.g(s13, "<set-?>");
                k1.b = s13;
                q.g(s10, "<set-?>");
                k1.d = s10;
                k1.g = g0.l;
                String s14 = g0.e;
                q.g(s14, "<set-?>");
                k1.h = s14;
                k1.i = v22 / 1000L;
                k1.j = g0.k;
                String s15 = g0.c;
                q.g(s15, "<set-?>");
                k1.k = s15;
                k1.l = g0.i;
                q.g(s11, "<set-?>");
                k1.m = s11;
                q.g(s12, "<set-?>");
                k1.o = s12;
                String s16 = g0.d;
                q.g(s16, "<set-?>");
                k1.r = s16;
                k1.t = g0.g;
                k1.u = g0.h;
                Song song0 = SongMetaParser.parseMeta(g0.j, null, 2);
                if(song0 != null) {
                    String s17 = song0.b;
                    q.g(s17, "<set-?>");
                    k1.e = s17;
                    k1.f = song0.e;
                }
                G8.g.n(k1);
                m.a(k1, "MelonMediaScanner");
                EventBusHelper.post(new Finish(4, 1));
                return uri2;
            }
            String s18 = g0.j;
            q.g(s18, "<set-?>");
            k0.b = s18;
            k0.g = g0.l;
            String s19 = g0.e;
            q.g(s19, "<set-?>");
            k0.h = s19;
            String s20 = g0.c;
            q.g(s20, "<set-?>");
            k0.k = s20;
            k0.l = g0.i;
            q.g(s11, "<set-?>");
            k0.m = s11;
            q.g(s12, "<set-?>");
            k0.o = s12;
            k0.j = g0.k;
            k0.t = g0.g;
            k0.u = g0.h;
            G8.g.q(k0);
            return uri2;
        }
        return null;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("MelonMediaScannerClient {arti: ");
        stringBuilder0.append(this.a);
        stringBuilder0.append(",albumArti:null, album:");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", title:");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", composer:null, genre:");
        stringBuilder0.append(this.d);
        stringBuilder0.append(", mimetype:");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", filetype:");
        stringBuilder0.append(this.f);
        stringBuilder0.append(", track:");
        stringBuilder0.append(this.g);
        stringBuilder0.append(", year:");
        stringBuilder0.append(this.h);
        stringBuilder0.append(", duration:");
        stringBuilder0.append(this.i);
        stringBuilder0.append(", path:");
        stringBuilder0.append(this.j);
        stringBuilder0.append(", fileSize:");
        stringBuilder0.append(this.l);
        stringBuilder0.append(", lastmodi:");
        return x.h(this.k, "}", stringBuilder0);
    }
}

