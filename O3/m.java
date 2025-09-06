package o3;

import B3.N;
import I6.Q;
import I6.V;
import I6.p0;
import android.graphics.Point;
import android.media.MediaCodecInfo.AudioCapabilities;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities.PerformancePoint;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.util.Pair;
import androidx.appcompat.app.o;
import androidx.media3.common.b;
import androidx.media3.exoplayer.g;
import b3.H;
import b3.i;
import com.iloen.melon.utils.player.a;
import e3.c;
import e3.x;
import f3.d;
import f3.j;
import java.util.List;
import java.util.Objects;

public final class m {
    public final String a;
    public final String b;
    public final String c;
    public final MediaCodecInfo.CodecCapabilities d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;

    public m(String s, String s1, String s2, MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities0, boolean z, boolean z1, boolean z2, boolean z3) {
        s.getClass();
        this.a = s;
        this.b = s1;
        this.c = s2;
        this.d = mediaCodecInfo$CodecCapabilities0;
        this.g = z;
        this.e = z1;
        this.f = z2;
        this.h = z3;
        this.i = H.k(s1);
    }

    public static boolean a(MediaCodecInfo.VideoCapabilities mediaCodecInfo$VideoCapabilities0, int v, int v1, double f) {
        int v2 = mediaCodecInfo$VideoCapabilities0.getWidthAlignment();
        int v3 = mediaCodecInfo$VideoCapabilities0.getHeightAlignment();
        Point point0 = new Point((v + v2 - 1) / v2 * v2, (v1 + v3 - 1) / v3 * v3);
        int v4 = point0.x;
        int v5 = point0.y;
        return f == -1.0 || f < 1.0 ? mediaCodecInfo$VideoCapabilities0.isSizeSupported(v4, v5) : mediaCodecInfo$VideoCapabilities0.areSizeAndRateSupported(v4, v5, Math.floor(f));
    }

    public final g b(b b0, b b1) {
        i i0 = b0.B;
        i i1 = b1.B;
        int v = Objects.equals(b0.n, b1.n) ? 0 : 8;
        if(this.i) {
            if(b0.x != b1.x) {
                v |= 0x400;
            }
            if(!this.e && (b0.u != b1.u || b0.v != b1.v)) {
                v |= 0x200;
            }
            if((!i.e(i0) || !i.e(i1)) && !Objects.equals(i0, i1)) {
                v |= 0x800;
            }
            if(x.d.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(this.a) && !b0.b(b1)) {
                v |= 2;
            }
            if(v == 0) {
                return b0.b(b1) ? new g(this.a, b0, b1, 3, 0) : new g(this.a, b0, b1, 2, 0);
            }
            return new g(this.a, b0, b1, 0, v);
        }
        if(b0.C != b1.C) {
            v |= 0x1000;
        }
        if(b0.D != b1.D) {
            v |= 0x2000;
        }
        if(b0.E != b1.E) {
            v |= 0x4000;
        }
        String s = this.b;
        if(v == 0 && "audio/mp4a-latm".equals(s)) {
            Pair pair0 = v.d(b0);
            Pair pair1 = v.d(b1);
            if(pair0 != null && pair1 != null && (((int)(((Integer)pair0.first))) == 42 && ((int)(((Integer)pair1.first))) == 42)) {
                return new g(this.a, b0, b1, 3, 0);
            }
        }
        if(!b0.b(b1)) {
            v |= 0x20;
        }
        if("audio/opus".equals(s)) {
            v |= 2;
        }
        return v == 0 ? new g(this.a, b0, b1, 1, 0) : new g(this.a, b0, b1, 0, v);
    }

    public final boolean c(b b0, boolean z) {
        String s3;
        MediaCodecInfo.CodecProfileLevel[] arr_mediaCodecInfo$CodecProfileLevel;
        Pair pair0 = v.d(b0);
        String s = b0.n;
        String s1 = this.c;
        if(s == null || !s.equals("video/mv-hevc")) {
        label_41:
            if(pair0 != null) {
                int v6 = (int)(((Integer)pair0.first));
                int v7 = (int)(((Integer)pair0.second));
                String s4 = this.b;
                if("video/dolby-vision".equals(s)) {
                    if("video/avc".equals(s4)) {
                        v6 = 8;
                        v7 = 0;
                    }
                    else if("video/hevc".equals(s4)) {
                        v6 = 2;
                        v7 = 0;
                    }
                }
                if(this.i || v6 == 42) {
                    MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities0 = this.d;
                    if(mediaCodecInfo$CodecCapabilities0 == null) {
                        arr_mediaCodecInfo$CodecProfileLevel = new MediaCodecInfo.CodecProfileLevel[0];
                    }
                    else {
                        arr_mediaCodecInfo$CodecProfileLevel = mediaCodecInfo$CodecCapabilities0.profileLevels;
                        if(arr_mediaCodecInfo$CodecProfileLevel == null) {
                            arr_mediaCodecInfo$CodecProfileLevel = new MediaCodecInfo.CodecProfileLevel[0];
                        }
                    }
                    for(int v8 = 0; v8 < arr_mediaCodecInfo$CodecProfileLevel.length; ++v8) {
                        MediaCodecInfo.CodecProfileLevel mediaCodecInfo$CodecProfileLevel0 = arr_mediaCodecInfo$CodecProfileLevel[v8];
                        if(mediaCodecInfo$CodecProfileLevel0.profile == v6 && (mediaCodecInfo$CodecProfileLevel0.level >= v7 || !z) && (!"video/hevc".equals(s4) || 2 != v6 || !"sailfish".equals(x.b) && !"marlin".equals(x.b))) {
                            return true;
                        }
                    }
                    this.g("codec.profileLevel, " + b0.k + ", " + s1);
                    return false;
                }
            }
        }
        else {
            String s2 = H.l(s1);
            if(!s2.equals("video/mv-hevc")) {
                if(s2.equals("video/hevc")) {
                    List list0 = b0.q;
                alab1:
                    for(int v = 0; true; ++v) {
                        s3 = null;
                        if(v >= list0.size()) {
                            break;
                        }
                        byte[] arr_b = (byte[])list0.get(v);
                        int v1 = arr_b.length;
                        if(v1 > 3) {
                            Q q0 = V.o();
                            for(int v2 = 0; v2 < arr_b.length; v2 = v3 + 3) {
                                int v3 = j.b(arr_b, v2, arr_b.length, new boolean[3]);
                                if(v3 != arr_b.length) {
                                    q0.a(v3);
                                }
                            }
                            p0 p00 = q0.g();
                            for(int v4 = 0; v4 < p00.d; ++v4) {
                                if(((int)(((Integer)p00.get(v4)))) + 3 < v1) {
                                    N n0 = new N(((int)(((Integer)p00.get(v4)))) + 3, v1, 3, arr_b);
                                    androidx.recyclerview.widget.p0 p01 = j.d(n0);
                                    if(p01.a == 33 && p01.b == 0) {
                                        n0.O(4);
                                        int v5 = n0.D(3);
                                        n0.N();
                                        d d0 = j.e(n0, true, v5, null);
                                        s3 = c.a(d0.a, d0.b, d0.c, d0.d, d0.e, d0.f);
                                        break alab1;
                                    }
                                }
                            }
                        }
                    }
                    pair0 = s3 == null ? null : c.b(s3, s3.trim().split("\\.", -1), b0.B);
                }
                goto label_41;
            }
        }
        return true;
    }

    public final boolean d(b b0) {
        int v4;
        String s = this.b;
        if(!s.equals(b0.n) && !s.equals(v.b(b0))) {
            return false;
        }
        if(!this.c(b0, true)) {
            return false;
        }
        if(this.i) {
            int v = b0.u;
            if(v > 0) {
                return b0.v <= 0 ? true : this.f(v, b0.v, ((double)b0.w));
            }
        }
        else {
            int v1 = b0.D;
            MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities0 = this.d;
            if(v1 != -1) {
                if(mediaCodecInfo$CodecCapabilities0 == null) {
                    this.g("sampleRate.caps");
                    return false;
                }
                MediaCodecInfo.AudioCapabilities mediaCodecInfo$AudioCapabilities0 = mediaCodecInfo$CodecCapabilities0.getAudioCapabilities();
                if(mediaCodecInfo$AudioCapabilities0 == null) {
                    this.g("sampleRate.aCaps");
                    return false;
                }
                if(!mediaCodecInfo$AudioCapabilities0.isSampleRateSupported(v1)) {
                    this.g("sampleRate.support, " + v1);
                    return false;
                }
            }
            int v2 = b0.C;
            if(v2 != -1) {
                if(mediaCodecInfo$CodecCapabilities0 == null) {
                    this.g("channelCount.caps");
                    return false;
                }
                MediaCodecInfo.AudioCapabilities mediaCodecInfo$AudioCapabilities1 = mediaCodecInfo$CodecCapabilities0.getAudioCapabilities();
                if(mediaCodecInfo$AudioCapabilities1 == null) {
                    this.g("channelCount.aCaps");
                    return false;
                }
                int v3 = mediaCodecInfo$AudioCapabilities1.getMaxInputChannelCount();
                if(v3 <= 1 && v3 <= 0 && !"audio/mpeg".equals(s) && !"audio/3gpp".equals(s) && !"audio/amr-wb".equals(s) && !"audio/mp4a-latm".equals(s) && !"audio/vorbis".equals(s) && !"audio/opus".equals(s) && !"audio/raw".equals(s) && !"audio/flac".equals(s) && !"audio/g711-alaw".equals(s) && !"audio/g711-mlaw".equals(s) && !"audio/gsm".equals(s)) {
                    if("audio/ac3".equals(s)) {
                        v4 = 6;
                    }
                    else {
                        v4 = "audio/eac3".equals(s) ? 16 : 30;
                    }
                    StringBuilder stringBuilder0 = o.u(v3, "AssumedMaxChannelAdjustment: ", this.a, ", [", " to ");
                    stringBuilder0.append(v4);
                    stringBuilder0.append("]");
                    e3.b.D("MediaCodecInfo", stringBuilder0.toString());
                    v3 = v4;
                }
                if(v3 < v2) {
                    this.g("channelCount.support, " + v2);
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean e(b b0) {
        if(this.i) {
            return this.e;
        }
        Pair pair0 = v.d(b0);
        return pair0 != null && ((int)(((Integer)pair0.first))) == 42;
    }

    public final boolean f(int v, int v1, double f) {
        boolean z;
        int v3;
        MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities0 = this.d;
        if(mediaCodecInfo$CodecCapabilities0 == null) {
            this.g("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities mediaCodecInfo$VideoCapabilities0 = mediaCodecInfo$CodecCapabilities0.getVideoCapabilities();
        if(mediaCodecInfo$VideoCapabilities0 == null) {
            this.g("sizeAndRate.vCaps");
            return false;
        }
        if(de.c.i != null && de.c.i.booleanValue()) {
            v3 = 0;
        }
        else {
            List list0 = a.i(mediaCodecInfo$VideoCapabilities0);
            if(list0 == null || list0.isEmpty()) {
                v3 = 0;
            }
            else {
                MediaCodecInfo.VideoCapabilities.PerformancePoint mediaCodecInfo$VideoCapabilities$PerformancePoint0 = a.f(v, v1, ((int)f));
                for(int v2 = 0; true; ++v2) {
                    v3 = 1;
                    if(v2 >= list0.size()) {
                        break;
                    }
                    if(a.u(a.g(list0.get(v2)), mediaCodecInfo$VideoCapabilities$PerformancePoint0)) {
                        v3 = 2;
                        break;
                    }
                }
                if(v3 == 1 && de.c.i == null) {
                    int v4 = d8.d.r(false);
                    int v5 = d8.d.r(true);
                    if(v4 == 0) {
                        z = true;
                    }
                    else if(v5 != 0) {
                        z = v4 != 2 || v5 != 2;
                    }
                    else if(v4 == 2) {
                        z = false;
                    }
                    else {
                        z = true;
                    }
                    de.c.i = Boolean.valueOf(z);
                    if(z) {
                        v3 = 0;
                    }
                }
            }
        }
        switch(v3) {
            case 1: {
                StringBuilder stringBuilder0 = o.t(v, v1, "sizeAndRate.cover, ", "x", "@");
                stringBuilder0.append(f);
                this.g(stringBuilder0.toString());
                return false;
            label_50:
                if(!m.a(mediaCodecInfo$VideoCapabilities0, v, v1, f)) {
                    if(v < v1) {
                        String s = this.a;
                        if((!"OMX.MTK.VIDEO.DECODER.HEVC".equals(s) || !"mcv5a".equals(x.b)) && m.a(mediaCodecInfo$VideoCapabilities0, v1, v, f)) {
                            StringBuilder stringBuilder1 = o.t(v, v1, "sizeAndRate.rotated, ", "x", "@");
                            stringBuilder1.append(f);
                            StringBuilder stringBuilder2 = A7.d.o("AssumedSupport [", stringBuilder1.toString(), "] [", s, ", ");
                            stringBuilder2.append(this.b);
                            stringBuilder2.append("] [");
                            stringBuilder2.append(x.e);
                            stringBuilder2.append("]");
                            e3.b.o("MediaCodecInfo", stringBuilder2.toString());
                            return true;
                        }
                    }
                    StringBuilder stringBuilder3 = o.t(v, v1, "sizeAndRate.support, ", "x", "@");
                    stringBuilder3.append(f);
                    this.g(stringBuilder3.toString());
                    return false;
                }
                break;
            }
            case 2: {
                break;
            }
            default: {
                goto label_50;
            }
        }
        return true;
    }

    public final void g(String s) {
        StringBuilder stringBuilder0 = com.iloen.melon.utils.a.n("NoSupport [", s, "] [");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", ");
        stringBuilder0.append(this.b);
        stringBuilder0.append("] [");
        stringBuilder0.append(x.e);
        stringBuilder0.append("]");
        e3.b.o("MediaCodecInfo", stringBuilder0.toString());
    }

    public static m h(String s, String s1, String s2, MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities0, boolean z, boolean z1) {
        boolean z2 = mediaCodecInfo$CodecCapabilities0 != null && mediaCodecInfo$CodecCapabilities0.isFeatureSupported("adaptive-playback");
        if(mediaCodecInfo$CodecCapabilities0 != null) {
            mediaCodecInfo$CodecCapabilities0.isFeatureSupported("tunneled-playback");
        }
        return z1 || mediaCodecInfo$CodecCapabilities0 != null && mediaCodecInfo$CodecCapabilities0.isFeatureSupported("secure-playback") ? new m(s, s1, s2, mediaCodecInfo$CodecCapabilities0, z, z2, true, false) : new m(s, s1, s2, mediaCodecInfo$CodecCapabilities0, z, z2, false, false);
    }

    @Override
    public final String toString() {
        return this.a;
    }
}

