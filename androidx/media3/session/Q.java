package androidx.media3.session;

import I6.G0;
import I6.V;
import I6.b0;
import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap;
import android.media.AudioAttributes.Builder;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.media3.common.c;
import androidx.media3.session.legacy.L;
import androidx.media3.session.legacy.MediaBrowserCompat.MediaItem;
import androidx.media3.session.legacy.MediaDescriptionCompat;
import androidx.media3.session.legacy.MediaMetadataCompat;
import androidx.media3.session.legacy.PlaybackStateCompat;
import androidx.media3.session.legacy.RatingCompat;
import b3.B;
import b3.E;
import b3.G;
import b3.J;
import b3.K;
import b3.T;
import b3.d;
import b3.j0;
import b3.k0;
import b3.p;
import b3.t;
import b3.v;
import b3.y;
import d5.m;
import e3.b;
import e3.x;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class q {
    public static final b0 a;

    static {
        q.a = b0.r("android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.DURATION", "android.media.metadata.ALBUM", "android.media.metadata.AUTHOR", "android.media.metadata.WRITER", new String[]{"android.media.metadata.COMPOSER", "android.media.metadata.COMPILATION", "android.media.metadata.DATE", "android.media.metadata.YEAR", "android.media.metadata.GENRE", "android.media.metadata.TRACK_NUMBER", "android.media.metadata.NUM_TRACKS", "android.media.metadata.DISC_NUMBER", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.ART", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART", "android.media.metadata.ALBUM_ART_URI", "android.media.metadata.USER_RATING", "android.media.metadata.RATING", "android.media.metadata.DISPLAY_TITLE", "android.media.metadata.DISPLAY_SUBTITLE", "android.media.metadata.DISPLAY_DESCRIPTION", "android.media.metadata.DISPLAY_ICON", "android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.MEDIA_ID", "android.media.metadata.MEDIA_URI", "android.media.metadata.BT_FOLDER_TYPE", "android.media.metadata.ADVERTISEMENT", "android.media.metadata.DOWNLOAD_STATUS", "androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT"});
    }

    public static MediaBrowserCompat.MediaItem a(E e0, Bitmap bitmap0) {
        MediaDescriptionCompat mediaDescriptionCompat0 = q.j(e0, bitmap0);
        int v = e0.d.q == null || !e0.d.q.booleanValue() ? 0 : 1;
        if(e0.d.r != null && e0.d.r.booleanValue()) {
            v |= 2;
        }
        return new MediaBrowserCompat.MediaItem(mediaDescriptionCompat0, v);
    }

    public static long b(PlaybackStateCompat playbackStateCompat0, MediaMetadataCompat mediaMetadataCompat0, long v) {
        long v1 = playbackStateCompat0 == null ? 0L : playbackStateCompat0.c;
        long v2 = q.d(playbackStateCompat0, mediaMetadataCompat0, v);
        long v3 = q.e(mediaMetadataCompat0);
        return v3 == 0x8000000000000001L ? Math.max(v2, v1) : x.i(v1, v2, v3);
    }

    public static byte[] c(Bitmap bitmap0) {
        try(ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream()) {
            bitmap0.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream0);
            return byteArrayOutputStream0.toByteArray();
        }
    }

    public static long d(PlaybackStateCompat playbackStateCompat0, MediaMetadataCompat mediaMetadataCompat0, long v) {
        if(playbackStateCompat0 == null) {
            return 0L;
        }
        long v1 = playbackStateCompat0.b;
        if(playbackStateCompat0.a == 3) {
            Long long0 = v == 0x8000000000000001L ? null : v;
            long v2 = long0 == null ? SystemClock.elapsedRealtime() - playbackStateCompat0.h : ((long)long0);
            v1 = Math.max(0L, v1 + ((long)(playbackStateCompat0.d * ((float)v2))));
        }
        long v3 = q.e(mediaMetadataCompat0);
        return v3 == 0x8000000000000001L ? Math.max(0L, v1) : x.i(v1, 0L, v3);
    }

    public static long e(MediaMetadataCompat mediaMetadataCompat0) {
        if(mediaMetadataCompat0 != null && mediaMetadataCompat0.a.containsKey("android.media.metadata.DURATION")) {
            long v = mediaMetadataCompat0.a("android.media.metadata.DURATION");
            return v > 0L ? v : 0x8000000000000001L;
        }
        return 0x8000000000000001L;
    }

    public static long f(int v) {
        switch(v) {
            case 0: {
                return 0L;
            }
            case 1: {
                return 1L;
            }
            case 2: {
                return 2L;
            }
            case 3: {
                return 3L;
            }
            case 4: {
                return 4L;
            }
            case 5: {
                return 5L;
            }
            case 6: {
                return 6L;
            }
            default: {
                throw new IllegalArgumentException("Unrecognized FolderType: " + v);
            }
        }
    }

    public static int g(long v) {
        if(Long.compare(v, 0L) == 0) {
            return 0;
        }
        if(v == 1L) {
            return 1;
        }
        if(v == 2L) {
            return 2;
        }
        if(v == 3L) {
            return 3;
        }
        if(v == 4L) {
            return 4;
        }
        if(v == 5L) {
            return 5;
        }
        return v == 6L ? 6 : 0;
    }

    public static int h(int v) {
        switch(v) {
            case -110: {
                return 8;
            }
            case -109: {
                return 11;
            }
            case -107: {
                return 9;
            }
            case -106: {
                return 7;
            }
            case -105: {
                return 6;
            }
            case -104: {
                return 5;
            }
            case -103: {
                return 4;
            }
            case -102: {
                return 3;
            }
            case -6: {
                return 2;
            }
            case -2: {
                return 1;
            }
            case 1: {
                return 10;
            }
            default: {
                return 0;
            }
        }
    }

    public static d0 i(Context context0, Bundle bundle0) {
        if(bundle0 == null) {
            return null;
        }
        try {
            bundle0.setClassLoader(context0.getClassLoader());
            int v = bundle0.getInt("androidx.media.MediaBrowserCompat.Extras.KEY_ROOT_CHILDREN_SUPPORTED_FLAGS", -1);
            if(v >= 0) {
                bundle0.remove("androidx.media.MediaBrowserCompat.Extras.KEY_ROOT_CHILDREN_SUPPORTED_FLAGS");
                bundle0.putBoolean("androidx.media3.session.LibraryParams.Extras.KEY_ROOT_CHILDREN_BROWSABLE_ONLY", v == 1);
            }
            return new d0(bundle0, bundle0.getBoolean("android.service.media.extra.RECENT"), bundle0.getBoolean("android.service.media.extra.OFFLINE"), bundle0.getBoolean("android.service.media.extra.SUGGESTED"));
        }
        catch(Exception unused_ex) {
            return new d0(bundle0, false, false, false);
        }
    }

    public static MediaDescriptionCompat j(E e0, Bitmap bitmap0) {
        CharSequence charSequence4;
        String s = e0.a.equals("") ? null : e0.a;
        G g0 = e0.d;
        Bitmap bitmap1 = bitmap0 == null ? null : bitmap0;
        Bundle bundle0 = g0.I;
        CharSequence charSequence0 = g0.a;
        V v0 = g0.J;
        Integer integer0 = g0.H;
        Integer integer1 = g0.p;
        if(bundle0 != null) {
            bundle0 = new Bundle(bundle0);
        }
        boolean z = integer1 != null && ((int)integer1) != -1;
        if(z || integer0 != null) {
            if(bundle0 == null) {
                bundle0 = new Bundle();
            }
            if(z) {
                integer1.getClass();
                bundle0.putLong("android.media.extra.BT_FOLDER_TYPE", q.f(((int)integer1)));
            }
            if(integer0 != null) {
                integer0.getClass();
                bundle0.putLong("androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT", ((long)(((int)integer0))));
            }
        }
        if(!v0.isEmpty()) {
            if(bundle0 == null) {
                bundle0 = new Bundle();
            }
            bundle0.putStringArrayList("androidx.media.utils.extras.CUSTOM_BROWSER_ACTION_ID_LIST", new ArrayList(v0));
        }
        CharSequence charSequence1 = g0.e;
        if(charSequence1 != null) {
            CharSequence charSequence2 = g0.f;
            CharSequence charSequence3 = g0.g;
            if(bundle0 == null) {
                bundle0 = new Bundle();
            }
            bundle0.putCharSequence("androidx.media3.mediadescriptioncompat.title", charSequence0);
            return new MediaDescriptionCompat(s, charSequence1, charSequence2, charSequence3, bitmap1, g0.m, bundle0, e0.f.a);
        }
        CharSequence[] arr_charSequence = new CharSequence[3];
        int v2 = 0;
        for(int v1 = 0; v2 < 3; ++v1) {
            String[] arr_s = MediaMetadataCompat.d;
            if(v1 >= arr_s.length) {
                break;
            }
            String s1 = arr_s[v1];
            s1.getClass();
            switch(s1) {
                case "android.media.metadata.ALBUM": {
                    charSequence4 = g0.c;
                    break;
                }
                case "android.media.metadata.ALBUM_ARTIST": {
                    charSequence4 = g0.d;
                    break;
                }
                case "android.media.metadata.ARTIST": {
                    charSequence4 = g0.b;
                    break;
                }
                case "android.media.metadata.COMPOSER": {
                    charSequence4 = g0.A;
                    break;
                }
                case "android.media.metadata.TITLE": {
                    charSequence4 = charSequence0;
                    break;
                }
                case "android.media.metadata.WRITER": {
                    charSequence4 = g0.z;
                    break;
                }
                default: {
                    charSequence4 = null;
                }
            }
            if(!TextUtils.isEmpty(charSequence4)) {
                arr_charSequence[v2] = charSequence4;
                ++v2;
            }
        }
        return new MediaDescriptionCompat(s, arr_charSequence[0], arr_charSequence[1], arr_charSequence[2], bitmap1, g0.m, bundle0, e0.f.a);
    }

    public static E k(MediaDescriptionCompat mediaDescriptionCompat0) {
        mediaDescriptionCompat0.getClass();
        String s = mediaDescriptionCompat0.a;
        t t0 = new t();
        b3.x x0 = new b3.x();
        if(s == null) {
            s = "";
        }
        m m0 = new m(9, false);
        m0.b = mediaDescriptionCompat0.h;
        B b0 = new B(m0);
        G g0 = q.m(mediaDescriptionCompat0, 0);
        v v0 = new v(t0);  // 初始化器: Lb3/u;-><init>(Lb3/t;)V
        y y0 = new y(x0);
        return g0 == null ? new E(s, v0, null, y0, G.K, b0) : new E(s, v0, null, y0, g0, b0);
    }

    public static E l(String s, MediaMetadataCompat mediaMetadataCompat0, int v) {
        B b1;
        t t0 = new t();
        b3.x x0 = new b3.x();
        B b0 = B.d;
        String s1 = null;
        if(s == null) {
            s = null;
        }
        CharSequence charSequence0 = mediaMetadataCompat0.a.getCharSequence("android.media.metadata.MEDIA_URI");
        if(charSequence0 != null) {
            s1 = charSequence0.toString();
        }
        if(s1 == null) {
            b1 = b0;
        }
        else {
            m m0 = new m(9, false);
            m0.b = Uri.parse(s1);
            b1 = new B(m0);
        }
        G g0 = q.n(mediaMetadataCompat0, v);
        if(s == null) {
            s = "";
        }
        v v1 = new v(t0);  // 初始化器: Lb3/u;-><init>(Lb3/t;)V
        y y0 = new y(x0);
        return g0 == null ? new E(s, v1, null, y0, G.K, b1) : new E(s, v1, null, y0, g0, b1);
    }

    public static G m(MediaDescriptionCompat mediaDescriptionCompat0, int v) {
        byte[] arr_b;
        RatingCompat ratingCompat0;
        if(mediaDescriptionCompat0 == null) {
            return G.K;
        }
        CharSequence charSequence0 = mediaDescriptionCompat0.b;
        c c0 = new c();
        c0.f = mediaDescriptionCompat0.c;
        c0.g = mediaDescriptionCompat0.d;
        c0.m = mediaDescriptionCompat0.f;
        Bundle bundle0 = null;
        switch(v) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: {
                ratingCompat0 = new RatingCompat(v, -1.0f);
                break;
            }
            default: {
                ratingCompat0 = null;
            }
        }
        c0.i = q.r(ratingCompat0);
        Bitmap bitmap0 = mediaDescriptionCompat0.e;
        if(bitmap0 != null) {
            try {
                arr_b = q.c(bitmap0);
            }
            catch(IOException iOException0) {
                b.E("LegacyConversions", "Failed to convert iconBitmap to artworkData", iOException0);
                arr_b = null;
            }
            c0.c(arr_b, 3);
        }
        Bundle bundle1 = mediaDescriptionCompat0.g;
        if(bundle1 != null) {
            bundle0 = new Bundle(bundle1);
        }
        if(bundle0 != null && bundle0.containsKey("android.media.extra.BT_FOLDER_TYPE")) {
            c0.p = q.g(bundle0.getLong("android.media.extra.BT_FOLDER_TYPE"));
            bundle0.remove("android.media.extra.BT_FOLDER_TYPE");
        }
        c0.q = Boolean.FALSE;
        if(bundle0 != null && bundle0.containsKey("androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT")) {
            c0.G = (int)bundle0.getLong("androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT");
            bundle0.remove("androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT");
        }
        if(bundle0 != null && bundle0.containsKey("androidx.media.utils.extras.CUSTOM_BROWSER_ACTION_ID_LIST")) {
            ArrayList arrayList0 = bundle0.getStringArrayList("androidx.media.utils.extras.CUSTOM_BROWSER_ACTION_ID_LIST");
            arrayList0.getClass();
            c0.I = V.p(V.p(arrayList0));
        }
        if(bundle0 == null || !bundle0.containsKey("androidx.media3.mediadescriptioncompat.title")) {
            c0.a = charSequence0;
        }
        else {
            c0.a = bundle0.getCharSequence("androidx.media3.mediadescriptioncompat.title");
            c0.e = charSequence0;
            bundle0.remove("androidx.media3.mediadescriptioncompat.title");
        }
        if(bundle0 != null && !bundle0.isEmpty()) {
            c0.H = bundle0;
        }
        c0.r = Boolean.TRUE;
        return new G(c0);
    }

    public static G n(MediaMetadataCompat mediaMetadataCompat0, int v) {
        String s1;
        RatingCompat ratingCompat2;
        RatingCompat ratingCompat1;
        RatingCompat ratingCompat0;
        if(mediaMetadataCompat0 == null) {
            return G.K;
        }
        Bundle bundle0 = mediaMetadataCompat0.a;
        c c0 = new c();
        CharSequence charSequence0 = bundle0.getCharSequence("android.media.metadata.TITLE");
        CharSequence charSequence1 = bundle0.getCharSequence("android.media.metadata.DISPLAY_TITLE");
        c0.a = charSequence0 == null ? charSequence1 : charSequence0;
        Bitmap bitmap0 = null;
        if(charSequence0 == null) {
            charSequence1 = null;
        }
        c0.e = charSequence1;
        c0.f = bundle0.getCharSequence("android.media.metadata.DISPLAY_SUBTITLE");
        c0.g = bundle0.getCharSequence("android.media.metadata.DISPLAY_DESCRIPTION");
        c0.b = bundle0.getCharSequence("android.media.metadata.ARTIST");
        c0.c = bundle0.getCharSequence("android.media.metadata.ALBUM");
        c0.d = bundle0.getCharSequence("android.media.metadata.ALBUM_ARTIST");
        try {
            ratingCompat0 = RatingCompat.a(bundle0.getParcelable("android.media.metadata.RATING"));
        }
        catch(Exception exception0) {
            Log.w("MediaMetadata", "Failed to retrieve a key as Rating.", exception0);
            ratingCompat0 = null;
        }
        c0.j = q.r(ratingCompat0);
        if(bundle0.containsKey("android.media.metadata.DURATION")) {
            long v1 = mediaMetadataCompat0.a("android.media.metadata.DURATION");
            if(v1 >= 0L) {
                c0.d(v1);
            }
        }
        try {
            ratingCompat1 = RatingCompat.a(bundle0.getParcelable("android.media.metadata.USER_RATING"));
        }
        catch(Exception exception1) {
            Log.w("MediaMetadata", "Failed to retrieve a key as Rating.", exception1);
            ratingCompat1 = null;
        }
        T t0 = q.r(ratingCompat1);
        if(t0 == null) {
            switch(v) {
                case 1: 
                case 2: 
                case 3: 
                case 4: 
                case 5: 
                case 6: {
                    ratingCompat2 = new RatingCompat(v, -1.0f);
                    break;
                }
                default: {
                    ratingCompat2 = null;
                }
            }
            c0.i = q.r(ratingCompat2);
        }
        else {
            c0.i = t0;
        }
        if(bundle0.containsKey("android.media.metadata.YEAR")) {
            c0.s = (int)mediaMetadataCompat0.a("android.media.metadata.YEAR");
        }
        int v3 = 0;
        while(true) {
            if(v3 < 3) {
                String s = new String[]{"android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ALBUM_ART_URI", "android.media.metadata.ART_URI"}[v3];
                if(bundle0.containsKey(s)) {
                    CharSequence charSequence2 = bundle0.getCharSequence(s);
                    if(charSequence2 != null) {
                        s1 = charSequence2.toString();
                        break;
                    }
                }
                else {
                    ++v3;
                    continue;
                }
            }
            s1 = null;
            break;
        }
        if(s1 != null) {
            c0.m = Uri.parse(s1);
        }
        for(int v2 = 0; v2 < 3; ++v2) {
            String s2 = new String[]{"android.media.metadata.DISPLAY_ICON", "android.media.metadata.ALBUM_ART", "android.media.metadata.ART"}[v2];
            if(bundle0.containsKey(s2)) {
                try {
                    bitmap0 = (Bitmap)bundle0.getParcelable(s2);
                }
                catch(Exception exception2) {
                    Log.w("MediaMetadata", "Failed to retrieve a key as Bitmap.", exception2);
                }
                break;
            }
        }
        if(bitmap0 != null) {
            try {
                c0.c(q.c(bitmap0), 3);
            }
            catch(IOException iOException0) {
                b.E("LegacyConversions", "Failed to convert artworkBitmap to artworkData", iOException0);
            }
        }
        boolean z = bundle0.containsKey("android.media.metadata.BT_FOLDER_TYPE");
        c0.q = Boolean.valueOf(z);
        if(z) {
            c0.p = q.g(mediaMetadataCompat0.a("android.media.metadata.BT_FOLDER_TYPE"));
        }
        if(bundle0.containsKey("androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT")) {
            c0.G = (int)mediaMetadataCompat0.a("androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT");
        }
        c0.r = Boolean.TRUE;
        Bundle bundle1 = new Bundle(bundle0);
        G0 g00 = q.a.k();
        while(g00.hasNext()) {
            Object object0 = g00.next();
            bundle1.remove(((String)object0));
        }
        if(!bundle1.isEmpty()) {
            c0.H = bundle1;
        }
        return new G(c0);
    }

    public static MediaMetadataCompat o(G g0, String s, Uri uri0, long v, Bitmap bitmap0) {
        L l0 = new L();
        l0.k("android.media.metadata.MEDIA_ID", s);
        CharSequence charSequence0 = g0.a;
        Bundle bundle0 = g0.I;
        Integer integer0 = g0.p;
        Uri uri1 = g0.m;
        if(charSequence0 != null) {
            l0.l(charSequence0, "android.media.metadata.TITLE");
        }
        CharSequence charSequence1 = g0.e;
        if(charSequence1 != null) {
            l0.l(charSequence1, "android.media.metadata.DISPLAY_TITLE");
        }
        CharSequence charSequence2 = g0.f;
        if(charSequence2 != null) {
            l0.l(charSequence2, "android.media.metadata.DISPLAY_SUBTITLE");
        }
        CharSequence charSequence3 = g0.g;
        if(charSequence3 != null) {
            l0.l(charSequence3, "android.media.metadata.DISPLAY_DESCRIPTION");
        }
        CharSequence charSequence4 = g0.b;
        if(charSequence4 != null) {
            l0.l(charSequence4, "android.media.metadata.ARTIST");
        }
        CharSequence charSequence5 = g0.c;
        if(charSequence5 != null) {
            l0.l(charSequence5, "android.media.metadata.ALBUM");
        }
        CharSequence charSequence6 = g0.d;
        if(charSequence6 != null) {
            l0.l(charSequence6, "android.media.metadata.ALBUM_ARTIST");
        }
        Integer integer1 = g0.t;
        if(integer1 != null) {
            l0.i(((long)(((int)integer1))), "android.media.metadata.YEAR");
        }
        if(uri0 != null) {
            l0.k("android.media.metadata.MEDIA_URI", uri0.toString());
        }
        if(uri1 != null) {
            l0.k("android.media.metadata.DISPLAY_ICON_URI", uri1.toString());
            l0.k("android.media.metadata.ALBUM_ART_URI", uri1.toString());
            l0.k("android.media.metadata.ART_URI", uri1.toString());
        }
        if(bitmap0 != null) {
            l0.h("android.media.metadata.DISPLAY_ICON", bitmap0);
            l0.h("android.media.metadata.ALBUM_ART", bitmap0);
        }
        if(integer0 != null && ((int)integer0) != -1) {
            l0.i(q.f(((int)integer0)), "android.media.metadata.BT_FOLDER_TYPE");
        }
        if(v == 0x8000000000000001L) {
            Long long0 = g0.h;
            if(long0 != null) {
                v = (long)long0;
            }
        }
        if(v != 0x8000000000000001L) {
            l0.i(v, "android.media.metadata.DURATION");
        }
        RatingCompat ratingCompat0 = q.s(g0.i);
        if(ratingCompat0 != null) {
            l0.j("android.media.metadata.USER_RATING", ratingCompat0);
        }
        RatingCompat ratingCompat1 = q.s(g0.j);
        if(ratingCompat1 != null) {
            l0.j("android.media.metadata.RATING", ratingCompat1);
        }
        Integer integer2 = g0.H;
        if(integer2 != null) {
            l0.i(((long)(((int)integer2))), "androidx.media3.session.EXTRAS_KEY_MEDIA_TYPE_COMPAT");
        }
        if(bundle0 != null) {
            for(Object object0: bundle0.keySet()) {
                String s1 = (String)object0;
                Object object1 = bundle0.get(s1);
                if(object1 == null || object1 instanceof CharSequence) {
                    l0.l(((CharSequence)object1), s1);
                }
                else if(object1 instanceof Byte || object1 instanceof Short || object1 instanceof Integer || object1 instanceof Long) {
                    l0.i(((Number)object1).longValue(), s1);
                }
            }
        }
        return new MediaMetadataCompat(l0.a);
    }

    public static K p(PlaybackStateCompat playbackStateCompat0) {
        String s = null;
        if(playbackStateCompat0 != null && playbackStateCompat0.a == 7) {
            CharSequence charSequence0 = playbackStateCompat0.g;
            Bundle bundle0 = playbackStateCompat0.k;
            if(charSequence0 != null) {
                s = charSequence0.toString();
            }
            int v = q.u(playbackStateCompat0.f);
            switch(v) {
                case -5: {
                    return bundle0 == null ? new K(s, null, 2000, Bundle.EMPTY, SystemClock.elapsedRealtime()) : new K(s, null, 2000, bundle0, SystemClock.elapsedRealtime());
                }
                case -1: {
                    return bundle0 == null ? new K(s, null, 1000, Bundle.EMPTY, SystemClock.elapsedRealtime()) : new K(s, null, 1000, bundle0, SystemClock.elapsedRealtime());
                }
                default: {
                    return bundle0 == null ? new K(s, null, v, Bundle.EMPTY, SystemClock.elapsedRealtime()) : new K(s, null, v, bundle0, SystemClock.elapsedRealtime());
                }
            }
        }
        return null;
    }

    public static int q(int v) {
        switch(v) {
            case 0: {
                return 0;
            label_3:
                if(v != 2) {
                    b.D("LegacyConversions", "Unrecognized RepeatMode: " + v + " was converted to `PlaybackStateCompat.REPEAT_MODE_NONE`");
                    return 0;
                }
                break;
            }
            case 1: {
                break;
            }
            default: {
                goto label_3;
            }
        }
        return 1;
    }

    public static T r(RatingCompat ratingCompat0) {
        if(ratingCompat0 != null) {
            float f = ratingCompat0.b;
            switch(ratingCompat0.a) {
                case 1: {
                    if(ratingCompat0.e()) {
                        return f == 1.0f ? new p(true) : new p(false);
                    }
                    return new p();
                }
                case 2: {
                    if(ratingCompat0.e()) {
                        return f == 1.0f ? new k0(true) : new k0(false);
                    }
                    return new k0();
                }
                case 3: {
                    return ratingCompat0.e() ? new j0(3, ratingCompat0.d()) : new j0(3);
                }
                case 4: {
                    return ratingCompat0.e() ? new j0(4, ratingCompat0.d()) : new j0(4);
                }
                case 5: {
                    return ratingCompat0.e() ? new j0(5, ratingCompat0.d()) : new j0(5);
                }
                case 6: {
                    if(ratingCompat0.e()) {
                        if(!ratingCompat0.e()) {
                            f = -1.0f;
                        }
                        return new J(f);
                    }
                    return new J();
                }
                default: {
                    return null;
                }
            }
        }
        return null;
    }

    public static RatingCompat s(T t0) {
        if(t0 != null) {
            int v = q.y(t0);
            if(!t0.b()) {
                switch(v) {
                    case 1: 
                    case 2: 
                    case 3: 
                    case 4: 
                    case 5: 
                    case 6: {
                        return new RatingCompat(v, -1.0f);
                    }
                    default: {
                        return null;
                    }
                }
            }
            float f = 0.0f;
            switch(v) {
                case 1: {
                    if(((p)t0).c) {
                        f = 1.0f;
                    }
                    return new RatingCompat(1, f);
                }
                case 2: {
                    if(((k0)t0).c) {
                        f = 1.0f;
                    }
                    return new RatingCompat(2, f);
                }
                case 3: 
                case 4: 
                case 5: {
                    return RatingCompat.j(((j0)t0).c, v);
                }
                case 6: {
                    return RatingCompat.h(((J)t0).b);
                }
                default: {
                    return null;
                }
            }
        }
        return null;
    }

    public static int t(int v) {
        switch(v) {
            case -1: 
            case 0: {
                return 0;
            label_3:
                if(v != 2 && v != 3) {
                    b.D("LegacyConversions", "Unrecognized PlaybackStateCompat.RepeatMode: " + v + " was converted to `Player.REPEAT_MODE_OFF`");
                    return 0;
                }
                break;
            }
            case 1: {
                break;
            }
            default: {
                goto label_3;
            }
        }
        return 1;
    }

    public static int u(int v) {
        switch(v) {
            case 1: {
                return -2;
            }
            case 2: {
                return -6;
            }
            case 3: {
                return -102;
            }
            case 4: {
                return -103;
            }
            case 5: {
                return -104;
            }
            case 6: {
                return -105;
            }
            case 7: {
                return -106;
            }
            case 8: {
                return -110;
            }
            case 9: {
                return -107;
            }
            case 10: {
                return 1;
            }
            case 11: {
                return -109;
            }
            default: {
                return -1;
            }
        }
    }

    public static boolean v(int v) {
        if(v != -1 && v != 0) {
            if(v != 1 && v != 2) {
                throw new IllegalArgumentException("Unrecognized ShuffleMode: " + v);
            }
            return true;
        }
        return false;
    }

    public static void w(M6.B b0) {
        long v = SystemClock.elapsedRealtime();
        boolean z = false;
        long v1 = 3000L;
        try {
            while(true) {
                try {
                    b0.get(v1, TimeUnit.MILLISECONDS);
                    break;
                }
                catch(InterruptedException unused_ex) {
                    z = true;
                    long v2 = SystemClock.elapsedRealtime() - v;
                    if(v2 >= 3000L) {
                        throw new TimeoutException();
                    }
                    v1 = 3000L - v2;
                }
            }
        }
        catch(Throwable throwable0) {
            if(z) {
                Thread.currentThread().interrupt();
            }
            throw throwable0;
        }
        if(z) {
            Thread.currentThread().interrupt();
        }
    }

    public static int x(d d0) {
        AudioAttributes.Builder audioAttributes$Builder0 = new AudioAttributes.Builder();
        audioAttributes$Builder0.setContentType(d0.a);
        audioAttributes$Builder0.setFlags(d0.b);
        audioAttributes$Builder0.setUsage(d0.c);
        AudioAttributes audioAttributes0 = audioAttributes$Builder0.build();
        audioAttributes0.getClass();
        int v = audioAttributes0.getFlags();
        int v1 = audioAttributes0.getUsage();
        if((v & 1) == 1) {
            return 7;
        }
        if((v & 4) == 4) {
            return 6;
        }
        switch(v1) {
            case 2: {
                return 0;
            }
            case 3: {
                return 8;
            }
            case 4: {
                return 4;
            }
            case 6: {
                return 2;
            }
            case 5: 
            case 7: 
            case 8: 
            case 9: 
            case 10: {
                return 5;
            }
            case 11: {
                return 10;
            }
            case 13: {
                return 1;
            }
            default: {
                return 3;
            }
        }
    }

    public static int y(T t0) {
        if(t0 instanceof p) {
            return 1;
        }
        if(t0 instanceof k0) {
            return 2;
        }
        if(t0 instanceof j0) {
            int v = ((j0)t0).b;
            return v != 3 && v != 4 && v != 5 ? 0 : 3;
        }
        return t0 instanceof J ? 6 : 0;
    }

    public static boolean z(long v, long v1) {
        return (v & v1) != 0L;
    }
}

