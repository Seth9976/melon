package E9;

import A3.l;
import A7.d;
import H0.b;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.SurfaceHolder;
import com.inisoft.media.MediaPlayer.TrackInfo;
import com.kakaoent.leonplayer.core.a;
import i.n.i.b.a.s.e.B4;
import i.n.i.b.a.s.e.Bc;
import i.n.i.b.a.s.e.Gd;
import i.n.i.b.a.s.e.K7;
import i.n.i.b.a.s.e.L7;
import i.n.i.b.a.s.e.M5;
import i.n.i.b.a.s.e.Vb;
import i.n.i.b.a.s.e.b4;
import i.n.i.b.a.s.e.be;
import i.n.i.b.a.s.e.h;
import i.n.i.b.a.s.e.x6;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.regex.PatternSyntaxException;
import x9.c;

public final class n {
    public SurfaceHolder a;
    public final m b;
    public final u c;
    public final Vb d;
    public Context e;
    public a f;
    public a g;
    public a h;
    public a i;
    public a j;
    public a k;
    public a l;
    public a m;
    public String n;
    public int o;
    public long p;
    public long q;
    public final HashSet r;
    public c s;
    public y5.a[] t;

    static {
        Log.i("INI-MEDIA", "BUILDPROP : 2.14.0.2022-09-27T17:52.77f5116c");
        String s = Build.BOARD;
        String s1 = Build.BRAND;
        String s2 = Build.DEVICE;
        int v = Build.VERSION.SDK_INT;
        String s3 = Build.VERSION.RELEASE;
        StringBuilder stringBuilder0 = d.o("PRODUCT=", Build.PRODUCT, ", MODEL=", Build.MODEL, ", ABI=");
        d.u(stringBuilder0, L7.b, ", BOARD=", s, ", BRAND=");
        d.u(stringBuilder0, s1, ", DEVICE=", s2, ", SDK=");
        stringBuilder0.append(v);
        stringBuilder0.append(", RELEASE=");
        stringBuilder0.append(s3);
        Log.i("INI-MEDIA", stringBuilder0.toString());
        Log.i("INI-MEDIA", "FINGER=google/sunfish/sunfish:13/TQ2A.230405.003/9719927:user/release-keys");
    }

    public n() {
        this.p = 0x8000000000000001L;
        this.q = 0L;
        new A0.c(this, 9);
        HashSet hashSet0 = new HashSet();
        this.r = hashSet0;
        this.s = new c(1);
        this.t = new y5.a[0];
        this.a("new", new Object[0]);
        Looper looper0 = Looper.myLooper();
        if(looper0 == null) {
            looper0 = Looper.getMainLooper();
        }
        m m0 = new m(this, this, looper0);
        this.b = m0;
        this.o = 0;
        u u0 = new u();  // 初始化器: Ljava/lang/Object;-><init>()V
        u0.a = new Object();
        u0.f = new l(u0, 3);
        new WeakReference(this);
        u0.c = new ArrayList();
        u0.d = new ArrayList();
        u0.e = new ArrayList();
        this.c = u0;
        Vb vb0 = new Vb(m0);
        new i(this);
        new j(this);
        new k(this);
        new E9.l(this);
        for(Object object0: hashSet0) {
            s s0 = (s)object0;
            vb0.W.add(s0);
            Bc bc0 = vb0.a;
            if(bc0 != null) {
                s0.getClass();
                bc0.k.getClass();
                com.iloen.melon.sns.model.a a0 = bc0.k.e;
                if(!a0.a) {
                    ((CopyOnWriteArraySet)a0.e).add(new K7(s0));
                }
            }
        }
        this.d = vb0;
    }

    public final void a(String s, Object[] arr_object) {
        String s1;
        boolean z = true;
        if(arr_object.length == 0) {
            s1 = "";
        }
        else if(arr_object.length == 1) {
            s1 = String.valueOf(arr_object[0]);
        }
        else {
            StringBuilder stringBuilder0 = new StringBuilder();
            for(int v = 0; v < arr_object.length; ++v) {
                Object object0 = arr_object[v];
                if(z) {
                    z = false;
                }
                else {
                    stringBuilder0.append(", ");
                }
                stringBuilder0.append(object0);
            }
            s1 = stringBuilder0.toString();
        }
        Log.d("MediaPlayer", "mp@" + Integer.toHexString(this.hashCode()) + "." + s + "(" + s1 + ")");
    }

    public final void b(boolean z) {
        SurfaceHolder surfaceHolder0 = this.a;
        if(surfaceHolder0 != null) {
            surfaceHolder0.setKeepScreenOn(false);
        }
    }

    public final MediaPlayer.TrackInfo[] c() {
        ArrayList arrayList0 = new ArrayList();
        arrayList0.addAll(Arrays.asList(this.d(2)));
        arrayList0.addAll(Arrays.asList(this.d(1)));
        arrayList0.addAll(Arrays.asList(this.d(3)));
        arrayList0.addAll(Arrays.asList(this.d(5)));
        return (MediaPlayer.TrackInfo[])arrayList0.toArray(new MediaPlayer.TrackInfo[0]);
    }

    public final MediaPlayer.TrackInfo[] d(int v) {
        String s4;
        String s2;
        int v3;
        int v2;
        Vb vb0 = this.d;
        int v1 = vb0.k(v);
        if(v1 == -1) {
            return new MediaPlayer.TrackInfo[0];
        }
        if(v1 >= 0) {
            B4 b40 = vb0.v.a.c;
            if(b40 == null) {
                Log.w("TrackSelectionHelper", "No mapped track");
                v2 = 0;
            }
            else {
                v2 = b40.b[v1].a;
            }
        }
        else {
            v2 = 0;
        }
        if(v == 0) {
            v3 = 1;
        }
        else {
            switch(v) {
                case 1: {
                    v3 = 2;
                    break;
                }
                case 2: {
                    v3 = 1;
                    break;
                }
                default: {
                    v3 = v == 3 || v == 5 ? 3 : 0;
                }
            }
        }
        MediaPlayer.TrackInfo[] arr_mediaPlayer$TrackInfo = new MediaPlayer.TrackInfo[v2];
        for(int v4 = 0; v4 < v2; ++v4) {
            i.n.i.b.a.s.e.u[] arr_u = vb0.m(v1, v4);
            String s = this.n;
            i.n.i.b.a.s.e.u u0 = null;
            for(int v5 = 0; v5 < arr_u.length; ++v5) {
                i.n.i.b.a.s.e.u u1 = arr_u[v5];
                if(u0 == null || u1.h > u0.h) {
                    u0 = u1;
                }
            }
            if(u0 == null) {
                s2 = "";
            }
            else {
                String s1 = u0.l;
                if(s1 != null) {
                    s2 = s1;
                }
            }
            if(u0 == null) {
                s4 = "und";
            }
            else {
                String s3 = u0.c;
                s4 = s3 == null ? "und" : s3;
            }
            arr_mediaPlayer$TrackInfo[v4] = new MediaPlayer.TrackInfo(v1, v4, v3, u0, s2, s4, arr_u, null, s);
        }
        return arr_mediaPlayer$TrackInfo;
    }

    public final void e() {
        if(this.d == null) {
            throw new IllegalStateException("Player is in an invalid state.");
        }
    }

    public final void f(int v) {
        this.a("deselectTrack", new Object[]{v});
        this.e();
        MediaPlayer.TrackInfo[] arr_mediaPlayer$TrackInfo = this.c();
        u u0 = this.c;
        ArrayList arrayList0 = u0.p();
        if(v >= arr_mediaPlayer$TrackInfo.length && v - arr_mediaPlayer$TrackInfo.length >= arrayList0.size() || v < 0) {
            throw new IllegalArgumentException("Invalid select index : " + v);
        }
        if(v < arr_mediaPlayer$TrackInfo.length) {
            MediaPlayer.TrackInfo mediaPlayer$TrackInfo0 = arr_mediaPlayer$TrackInfo[v];
            this.d.v.a(true, mediaPlayer$TrackInfo0.a, mediaPlayer$TrackInfo0.b, null, false);
            return;
        }
        u0.l(v - arr_mediaPlayer$TrackInfo.length, false);
    }

    @Override
    public final void finalize() {
    }

    public final int g() {
        Vb vb0 = this.d;
        if(vb0 != null) {
            long v = vb0.q();
            return v == 0x8000000000000001L ? -1 : ((int)v);
        }
        return -1;
    }

    public final int h() {
        Vb vb0 = this.d;
        if(vb0.j(new int[]{4, 5, 6, 8})) {
            if(vb0.a == null) {
                Log.w("IbisPlayer", "Player state is invalid : " + vb0.r());
                return 0;
            }
            if(vb0.M != null) {
                h h0 = vb0.p();
                long v = b4.b(h0.q);
                long v1 = b4.b(vb0.M.q);
                long v2 = b4.b(h0.n) + (v - v1) - vb0.O;
                return v2 == 0x8000000000000001L ? 0 : ((int)v2);
            }
        }
        return 0;
    }

    public final MediaPlayer.TrackInfo[] i() {
        this.e();
        ArrayList arrayList0 = new ArrayList(Arrays.asList(this.c()));
        ArrayList arrayList1 = this.c.p();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(arrayList0);
        arrayList2.addAll(arrayList1);
        return (MediaPlayer.TrackInfo[])arrayList2.toArray(new MediaPlayer.TrackInfo[0]);
    }

    public final boolean j() {
        this.e();
        Vb vb0 = this.d;
        synchronized(vb0.J) {
            if(!vb0.j(new int[]{10})) {
                return vb0.I == 5 && (vb0.a != null && vb0.a.r1());
            }
        }
        throw new IllegalStateException(vb0.n("isPlaying"));
    }

    // This method was un-flattened
    public final void k(int v, p p0) {
        double f;
        String[] arr_s;
        Map map0;
        Vb vb0 = this.d;
        Integer integer0 = v;
        HashMap hashMap0 = new HashMap();
        try {
            p.a();
        }
        catch(IllegalAccessException unused_ex) {
            hashMap0.put("Failed", "Failed");
            map0 = Collections.unmodifiableMap(hashMap0);
            goto label_21;
        }
        for(Object object0: p0.a.entrySet()) {
            Map.Entry map$Entry0 = (Map.Entry)object0;
            String s = (String)map$Entry0.getKey();
            Object object1 = map$Entry0.getKey();
            String s1 = p.b.contains(object1) ? "<suppressed>" : map$Entry0.getValue();
            hashMap0.put(s, s1);
        }
        map0 = Collections.unmodifiableMap(hashMap0);
    label_21:
        this.a("prepareAsync", new Object[]{integer0, map0});
        this.e();
        if(this.e == null) {
            throw new IllegalStateException("Context must be set before.");
        }
        Gd gd0 = new Gd();
        HashMap hashMap1 = p0.a;
        gd0.c();
        for(Object object2: hashMap1.keySet()) {
            String s2 = (String)object2;
            try {
                switch(s2) {
                    case "ABR_ENABLED": {
                        gd0.h = p0.c(s2);
                        goto label_186;
                    }
                    case "ALLOW_GZIP_ENCODING": {
                        gd0.D = p0.c(s2);
                        goto label_186;
                    }
                    case "ALLOW_RESOLUTION_EXCEEDING_VIEWPORT": {
                        gd0.w = p0.c(s2);
                        goto label_186;
                    }
                    case "CUSTOM_PLAYER_CONFIGURATION1": {
                        goto label_186;
                    }
                    case "CUSTOM_PLAYER_CONFIGURATION2": {
                        goto label_186;
                    }
                    case "CUSTOM_PLAYER_CONFIGURATION3": {
                        goto label_186;
                    }
                    case "CUSTOM_PLAYER_CONFIGURATION4": {
                        goto label_186;
                    }
                    case "DISABLE_ABORT_AND_SWITCH_DOWN_FOR_TIMEOUT": {
                        p0.c(s2);
                        goto label_186;
                    }
                    case "DISABLE_SSL_HOST_VERIFICATION": {
                        gd0.f0 = p0.c(s2);
                        goto label_186;
                    }
                    case "DISABLE_VIDEO": {
                        gd0.y = p0.c(s2);
                        goto label_186;
                    }
                    case "DRM_AES_SERVER_HEADER": {
                        gd0.P = p0.e(s2);
                        goto label_186;
                    }
                    case "DRM_OFFLINE_KEY_STORAGE_NAME": {
                        gd0.Q = p0.e(s2);
                        goto label_186;
                    }
                    case "DRM_PLAYREADY_CUSTOMDATA": {
                        gd0.K = p0.e(s2);
                        goto label_186;
                    }
                    case "DRM_PLAYREADY_SERVER_HEADER": {
                        gd0.J = p0.e(s2);
                        goto label_186;
                    }
                    case "DRM_PLAYREADY_SERVER_URL": {
                        gd0.I = p0.e(s2);
                        goto label_186;
                    }
                    case "DRM_SCHEMES_PRIORITY": {
                        String s3 = p0.e(s2);
                        if(TextUtils.isEmpty(s3)) {
                            arr_s = new String[0];
                        }
                        else {
                            try {
                                arr_s = s3.split(",");
                                for(int v1 = 0; v1 < arr_s.length; ++v1) {
                                    arr_s[v1] = arr_s[v1].trim();
                                }
                            }
                            catch(PatternSyntaxException unused_ex) {
                                arr_s = new String[0];
                                gd0.O = arr_s;
                                goto label_186;
                            }
                        }
                        gd0.O = arr_s;
                        goto label_186;
                    }
                    case "DRM_WIDEVINE_CUSTOMDATA": {
                        gd0.N = p0.e(s2);
                        goto label_186;
                    }
                    case "DRM_WIDEVINE_SECURITY_LEVEL": {
                        gd0.R = p0.e(s2);
                        goto label_186;
                    }
                    case "DRM_WIDEVINE_SERVER_HEADER": {
                        gd0.M = p0.e(s2);
                        goto label_186;
                    }
                    case "DRM_WIDEVINE_SERVER_URL": {
                        gd0.L = p0.e(s2);
                        goto label_186;
                    }
                    case "ENABLE_AWS_MEDIA_ANALYTICS": {
                        gd0.e0 = p0.c(s2);
                        goto label_186;
                    }
                    case "ENABLE_CODEC_WORKAROUND_FOR_ABORT_AND_SWITCH_DOWN": {
                        gd0.Y = p0.c(s2);
                        goto label_186;
                    }
                    case "ENABLE_HLS_VIDEO_RENDITION_GROUP": {
                        gd0.b0 = p0.c(s2);
                        goto label_186;
                    }
                    case "ENABLE_LOW_BITRATE_BUFFER_CONFIG": {
                        gd0.U = p0.c(s2);
                        goto label_186;
                    }
                    case "ENABLE_ONLY_VIDEO": {
                        gd0.Z = p0.c(s2);
                        goto label_186;
                    }
                    case "ENABLE_RANGE_REQUEST_FOR_ENCRYPTED_CHUNK": {
                        gd0.C = p0.c(s2);
                        goto label_186;
                    }
                    case "ENABLE_SMOOTH_TRACK_CHANGE": {
                        gd0.c0 = p0.c(s2);
                        goto label_186;
                    }
                    case "ENABLE_THREADED_VIDEO_CODEC": {
                        gd0.x = p0.c(s2);
                        goto label_186;
                    }
                    case "EXPERIMENTAL_USE_CRONET": {
                        gd0.E = p0.c(s2);
                        goto label_186;
                    }
                    case "EY_BANDWIDTH_FRACTION_ADJUST_FOR_LOW_BUFFER": {
                        Object object6 = hashMap1.get(s2);
                        p.b(7, object6, s2);
                        gd0.X = (float)(((double)(((Double)object6))));
                        goto label_186;
                    }
                    case "HLS_OPTIMIZATION_FOR_ALIGNED_SEGMENTS": {
                        gd0.G = p0.c(s2);
                        goto label_186;
                    }
                    case "INITIAL_VIDEO_TRACK_INDEX": {
                        gd0.i = p0.d(s2);
                        goto label_186;
                    }
                    case "KEY_BANDWIDTH_ESTIMATION_FRACTION": {
                        try {
                            Object object4 = hashMap1.get(s2);
                            p.b(7, object4, s2);
                            f = (double)(((Double)object4));
                        }
                        catch(IllegalStateException unused_ex) {
                            Object object5 = hashMap1.get(s2);
                            p.b(7, object5, s2);
                            f = (double)(((Double)object5));
                        }
                        gd0.p = (float)f;
                        goto label_186;
                    }
                    case "KEY_FRAME_ONLY_MODE_CONSECUTIVE_DROPS": {
                        gd0.s = p0.d(s2);
                        goto label_186;
                    }
                    case "KEY_FRAME_ONLY_MODE_ENABLED": {
                        gd0.q = p0.c(s2);
                        goto label_186;
                    }
                    case "KEY_FRAME_ONLY_MODE_SYNC_THRESHOLD": {
                        gd0.r = p0.d(s2) * 1000;
                        goto label_186;
                    }
                    case "KEY_MIN_STARTUP_BANDWIDTH": {
                        gd0.c = p0.d(s2);
                        goto label_186;
                    }
                    case "KEY_QUALITY_DECREASE_BUFFER": {
                        gd0.o = p0.d(s2);
                        goto label_186;
                    }
                    case "KEY_QUALITY_INCREASE_BUFFER": {
                        gd0.n = p0.d(s2);
                        goto label_186;
                    }
                    case "KEY_SEGMENT_START_INDEX": {
                        int v2 = p0.d(s2);
                        gd0.A = v2;
                        if(v2 < 1) {
                            gd0.A = 3;
                        }
                        goto label_186;
                    }
                    case "KEY_USE_MULTIVIEW_TIME_SYNC": {
                        gd0.a0 = p0.c(s2);
                        goto label_186;
                    }
                    case "LIVE_PRESENTATION_DELAY": {
                        gd0.m = p0.d(s2) * 1000;
                        goto label_186;
                    }
                    case "LIVE_START_FROM_LIVE_POSITION": {
                        gd0.F = p0.c(s2);
                        goto label_186;
                    }
                    case "LOCAL_FILE_ENCRYPTION_DIRECTORY": {
                        gd0.T = p0.e(s2);
                        goto label_186;
                    }
                    case "LOCAL_FILE_ENCRYPTION_KEY": {
                        Object object3 = hashMap1.get(s2);
                        p.b(0, object3, s2);
                        gd0.S = object3;
                        goto label_186;
                    }
                    case "LOW_BITRATE_BUFFER_CONFIG_THRESHOLD": {
                        gd0.V = p0.d(s2);
                        goto label_186;
                    }
                    case "MAX_BANDWIDTH": {
                        gd0.d = p0.d(s2);
                        goto label_186;
                    }
                    case "MAX_BUFFER_DURATION_FOR_LOW_BITRATE": {
                        gd0.W = p0.d(s2);
                        goto label_186;
                    }
                    case "MAX_BUFFER_DURATION_MS": {
                        gd0.j = p0.d(s2);
                        goto label_186;
                    }
                    case "MAX_VIDEO_HEIGHT": {
                        gd0.g = p0.d(s2);
                        goto label_186;
                    }
                    case "MAX_VIDEO_WIDTH": {
                        gd0.f = p0.d(s2);
                        goto label_186;
                    }
                    case "MIN_BANDWIDTH": {
                        gd0.e = p0.d(s2);
                        goto label_186;
                    }
                    case "MULTI_ANGLE_MAX_THUMBNAIL_AREA_SIZE": {
                        gd0.d0 = p0.d(s2);
                        goto label_186;
                    }
                    case "NON_IDR_FRAMES_ALLOWED": {
                        gd0.v = p0.c(s2);
                        goto label_186;
                    }
                    case "OFFLINE_PLAYBACK_ONLY": {
                        p0.c(s2);
                        goto label_186;
                    }
                    case "PLAYBACK_BUFFER_DURATION": {
                        gd0.k = p0.d(s2);
                        goto label_186;
                    }
                    case "REBUFFER_DURATION": {
                        gd0.l = p0.d(s2);
                        goto label_186;
                    }
                    case "SHOW_MULTI_ANGLE_DEBUG_INFO": {
                        p0.c(s2);
                        goto label_186;
                    }
                    case "STARTUP_BANDWIDTH": {
                        gd0.b = p0.d(s2);
                        goto label_186;
                    }
                    case "STARTUP_MUTE_DURATION": {
                        int v4 = p0.d(s2);
                        if(v4 < 0) {
                            v4 = 0;
                        }
                        gd0.z = v4;
                        goto label_186;
                    }
                    case "USE_SECURE_SCREEN": {
                        p0.c(s2);
                        goto label_186;
                    }
                    case "VIDEO_LAGGING_COUNT": {
                        gd0.u = p0.d(s2);
                        goto label_186;
                    }
                    case "VIDEO_LAGGING_DELAY": {
                        int v3 = p0.d(s2);
                        if(v3 >= 0) {
                            v3 *= 1000;
                        }
                        gd0.t = v3;
                        goto label_186;
                    }
                    default: {
                        goto label_186;
                    }
                }
            }
            catch(ClassCastException classCastException0) {
            }
            throw new IllegalArgumentException("invalid class type for " + s2, classCastException0);
        label_186:
            Gd.a(gd0.b, "startupBandwidth", 0, 0x7FFFFFFF, new Integer[]{-1});
            Gd.a(gd0.c, "minStartupBandwidth", 0, 0x7FFFFFFF, new Integer[]{-1});
            Gd.a(gd0.d, "maxBandwidth", 0, 0x7FFFFFFF, new Integer[]{-1});
            Gd.a(gd0.e, "minBandwidth", 0, 0x7FFFFFFF, new Integer[]{-1});
            Gd.a(gd0.f, "maxVideoWidth", 0, 0x7FFFFFFF, new Integer[]{-1});
            Gd.a(gd0.g, "maxVideoHeight", 0, 0x7FFFFFFF, new Integer[]{-1});
            Gd.a(gd0.i, "initialVideoTrackIndex", 0, 0x7FFFFFFF, new Integer[]{-1});
            Gd.a(gd0.j, "maxBufferDurationMs", 0, 0x7FFFFFFF, null);
            Gd.a(gd0.k, "playbackBufferDurationMs", 0, 0x7FFFFFFF, null);
            Gd.a(gd0.l, "rebufferDurationMs", 0, 0x7FFFFFFF, null);
            Gd.a(gd0.p, "bandwidthFraction", 0.1f, 1.0f, null);
            Gd.a(gd0.m, "livePresentationDelayMs", 0, 0x7FFFFFFF, null);
            Gd.a(gd0.r, "keyFrameOnlyModeSyncThresholdUs", 0, 0x7FFFFFFF, null);
            Gd.a(gd0.s, "keyFrameOnlyModeConsecutiveDrops", 0, 0x7FFFFFFF, null);
            Gd.a(gd0.t, "videoLaggingDelayUs", 0, 0x7FFFFFFF, null);
            Gd.a(gd0.u, "videoLaggingCount", 0, 0x7FFFFFFF, null);
            Gd.a(gd0.z, "startupMuteDurationMs", 0, 3000, null);
            Gd.a(gd0.d0, "multiAngleMaxThumbnailAreaSize", 0, 0x7FFFFFFF, new Integer[]{-1});
            if(gd0.O.length == 0) {
                throw new IllegalArgumentException("drmSchemePriority is empty");
            }
            String s4 = gd0.R;
            int v5 = 0;
        label_207:
            if(v5 >= 4) {
                throw new IllegalArgumentException("widevineSecurityLevel " + s4 + " not allowed");
            }
            String s5 = new String[]{0, "L1", "L2", "L3"}[v5];
            if(s5 == null) {
                if(s4 == null) {
                    Gd.a(gd0.V, "lowBitrateBufferConfigThreshold", 0, 0x7FFFFFFF, new Integer[]{-1});
                    Gd.a(gd0.W, "maxBufferDurationForLowBitrateMs", 0, 0x7FFFFFFF, null);
                    Gd.a(gd0.X, "bandwidthFractionAdjustForLowBuffer", 0.0f, 1.0f, null);
                    continue;
                }
                else {
                    ++v5;
                    goto label_207;
                }
                goto label_212;
            }
            else {
            label_212:
                if(s5.equals(s4)) {
                    Gd.a(gd0.V, "lowBitrateBufferConfigThreshold", 0, 0x7FFFFFFF, new Integer[]{-1});
                    Gd.a(gd0.W, "maxBufferDurationForLowBitrateMs", 0, 0x7FFFFFFF, null);
                    Gd.a(gd0.X, "bandwidthFractionAdjustForLowBuffer", 0.0f, 1.0f, null);
                    continue;
                }
                ++v5;
                goto label_207;
            }
            Gd.a(gd0.V, "lowBitrateBufferConfigThreshold", 0, 0x7FFFFFFF, new Integer[]{-1});
            Gd.a(gd0.W, "maxBufferDurationForLowBitrateMs", 0, 0x7FFFFFFF, null);
            Gd.a(gd0.X, "bandwidthFractionAdjustForLowBuffer", 0.0f, 1.0f, null);
        }
        vb0.z = gd0;
        c c0 = this.s;
        c0.b = gd0;
        vb0.r = c0;
        be be0 = vb0.m;
        if(be0 != null) {
            synchronized(be0) {
                be0.c = c0;
            }
        }
        vb0.s = this.t;
        u u0 = this.c;
        Context context0 = this.e;
        Looper looper0 = Looper.myLooper();
        if(looper0 == null) {
            looper0 = Looper.getMainLooper();
        }
        Gd gd1 = vb0.z;
        String s6 = M5.a(this.e);
        u0.getClass();
        Vb.e(context0, s6, null, gd1, false, true);
        u0.b = new Handler(looper0);
        vb0.l(((long)v));
    }

    public final void l(int v) {
        this.a("seekTo", new Object[]{v});
        this.e();
        long v1 = (long)v;
        Vb vb0 = this.d;
        if(Long.compare(vb0.q(), 0x8000000000000001L) != 0) {
            v1 = (long)Math.min(Math.max(0, v), this.g());
        }
        vb0.h(v1, false);
        u u0 = this.c;
        Iterator iterator0 = ((ArrayList)u0.c).iterator();
        if(iterator0.hasNext()) {
            throw b.b(iterator0);
        }
        l l0 = (l)u0.f;
        Handler handler0 = (Handler)u0.b;
        if(handler0 == null) {
            return;
        }
        handler0.post(l0);
    }

    public final void m(int[] arr_v, int v, boolean z) {
        int[] arr_v2;
        this.a("selectTrack", new Object[]{v, Arrays.toString(arr_v), Boolean.valueOf(z)});
        this.e();
        MediaPlayer.TrackInfo[] arr_mediaPlayer$TrackInfo = this.c();
        u u0 = this.c;
        ArrayList arrayList0 = u0.p();
        if(v >= arr_mediaPlayer$TrackInfo.length && v - arr_mediaPlayer$TrackInfo.length >= arrayList0.size() || v < 0) {
            throw new IllegalArgumentException("Invalid track selection index " + v);
        }
        Vb vb0 = this.d;
        if(v < arr_mediaPlayer$TrackInfo.length) {
            if(arr_v == null) {
                int v2 = arr_mediaPlayer$TrackInfo[v].g.length;
                int[] arr_v1 = new int[v2];
                for(int v3 = 0; v3 < v2; ++v3) {
                    arr_v1[v3] = v3;
                }
                arr_v2 = arr_v1;
            }
            else {
                arr_v2 = arr_v;
            }
            if(arrayList0.size() > 0 && arr_mediaPlayer$TrackInfo[v].c == 3) {
                u0.l(0, false);
            }
            MediaPlayer.TrackInfo mediaPlayer$TrackInfo0 = arr_mediaPlayer$TrackInfo[v];
            vb0.v.a(false, mediaPlayer$TrackInfo0.a, mediaPlayer$TrackInfo0.b, arr_v2, z);
            return;
        }
        for(int v1 = 0; v1 < arr_mediaPlayer$TrackInfo.length; ++v1) {
            MediaPlayer.TrackInfo mediaPlayer$TrackInfo1 = arr_mediaPlayer$TrackInfo[v1];
            if(mediaPlayer$TrackInfo1.c == 3) {
                vb0.v.a(true, mediaPlayer$TrackInfo1.a, mediaPlayer$TrackInfo1.b, null, false);
            }
        }
        u0.l(v - arr_mediaPlayer$TrackInfo.length, true);
    }

    public final void n(SurfaceHolder surfaceHolder0) {
        this.a("setDisplay", new Object[]{surfaceHolder0});
        this.e();
        this.a = surfaceHolder0;
        Vb vb0 = this.d;
        vb0.f = null;
        Bc bc0 = vb0.a;
        if(bc0 == null) {
            vb0.f = surfaceHolder0;
        }
        else {
            bc0.E1(surfaceHolder0);
        }
        SurfaceHolder surfaceHolder1 = this.a;
        if(surfaceHolder1 != null) {
            surfaceHolder1.setKeepScreenOn(false);
        }
    }

    public final void o(int v) {
        this.a("setSpeed", new Object[]{v});
        this.e();
        Vb vb0 = this.d;
        synchronized(vb0.J) {
            if(!vb0.j(new int[]{4, 5, 6, 8})) {
                return;
            }
            Bc bc0 = vb0.a;
            if(bc0 != null) {
                bc0.A1(new x6(((float)v) / 100.0f, 1.0f));
                return;
            }
        }
        throw new IllegalStateException("Player is invalid : " + vb0.r());
    }

    public final void p(float f) {
        this.a("setVolume", new Object[]{f});
        Vb vb0 = this.d;
        if(vb0 != null) {
            synchronized(vb0.J) {
                if(vb0.j(new int[]{1, 2, 4, 3, 5, 6, 7, 8})) {
                    Bc bc0 = vb0.a;
                    if(bc0 != null) {
                        bc0.w1(f);
                        return;
                    }
                    vb0.i = f;
                    vb0.h = f;
                    return;
                }
            }
            throw new IllegalStateException(vb0.n("setVolume"));
        }
    }
}

