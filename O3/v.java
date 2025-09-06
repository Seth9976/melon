package o3;

import I6.Q;
import I6.V;
import I6.p0;
import Q0.D;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo;
import android.util.Pair;
import androidx.media3.common.b;
import b3.H;
import b3.i;
import com.iloen.melon.utils.a;
import e3.c;
import i.n.i.b.a.s.e.Ab;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;

public abstract class v {
    public static final HashMap a;

    static {
        v.a = new HashMap();
    }

    public static void a(String s, ArrayList arrayList0) {
        if("audio/raw".equals(s)) {
            Collections.sort(arrayList0, new D(new h(), 4));  // 初始化器: Ljava/lang/Object;-><init>()V
        }
    }

    public static String b(b b0) {
        String s = b0.n;
        if("audio/eac3-joc".equals(b0.n)) {
            return "audio/eac3";
        }
        if("video/dolby-vision".equals(s)) {
            Pair pair0 = v.d(b0);
            if(pair0 != null) {
                switch(((int)(((Integer)pair0.first)))) {
                    case 16: 
                    case 0x100: {
                        return "video/hevc";
                    }
                    case 0x200: {
                        return "video/avc";
                    }
                    case 0x400: {
                        return "video/av01";
                    }
                    default: {
                        return "video/mv-hevc".equals(s) ? "video/hevc" : null;
                    }
                }
            }
        }
        return "video/mv-hevc".equals(s) ? "video/hevc" : null;
    }

    public static String c(MediaCodecInfo mediaCodecInfo0, String s, String s1) {
        String[] arr_s = mediaCodecInfo0.getSupportedTypes();
        for(int v = 0; v < arr_s.length; ++v) {
            String s2 = arr_s[v];
            if(s2.equalsIgnoreCase(s1)) {
                return s2;
            }
        }
        if(s1.equals("video/dolby-vision")) {
            if("OMX.MS.HEVCDV.Decoder".equals(s)) {
                return "video/hevcdv";
            }
            return !"OMX.RTK.video.decoder".equals(s) && !"OMX.realtek.video.decoder.tunneled".equals(s) ? null : "video/dv_hevc";
        }
        if(s1.equals("video/mv-hevc")) {
            return "c2.qti.mvhevc.decoder".equals(s) ? "video/x-mvhevc" : null;
        }
        if(s1.equals("audio/alac") && "OMX.lge.alac.decoder".equals(s)) {
            return "audio/x-lg-alac";
        }
        if(s1.equals("audio/flac") && "OMX.lge.flac.decoder".equals(s)) {
            return "audio/x-lg-flac";
        }
        return !s1.equals("audio/ac3") || !"OMX.lge.ac3.decoder".equals(s) ? null : "audio/lg-ac3";
    }

    public static Pair d(b b0) {
        int v14;
        int v13;
        int v12;
        int v9;
        int v8;
        int v7;
        int v6;
        int v5;
        int v4;
        int v3;
        int v1;
        Integer integer1;
        Integer integer0 = 1;
        String s = b0.k;
        i i0 = b0.B;
        if(s != null) {
            String[] arr_s = s.split("\\.");
            int v = 16;
            if("video/dolby-vision".equals(b0.n)) {
                if(arr_s.length < 3) {
                    a.w("Ignoring malformed Dolby Vision codec string: ", s, "CodecSpecificDataUtil");
                    return null;
                }
                Matcher matcher0 = c.c.matcher(arr_s[1]);
                if(!matcher0.matches()) {
                    a.w("Ignoring malformed Dolby Vision codec string: ", s, "CodecSpecificDataUtil");
                    return null;
                }
                String s1 = matcher0.group(1);
                if(s1 == null) {
                    integer1 = null;
                label_42:
                    if(integer1 == null) {
                        a.w("Unknown Dolby Vision profile string: ", s1, "CodecSpecificDataUtil");
                        return null;
                    }
                }
                else {
                    switch(s1) {
                        case "00": {
                            integer1 = 1;
                            goto label_42;
                        }
                        case "01": {
                            integer1 = 2;
                            break;
                        }
                        case "02": {
                            integer1 = 4;
                            break;
                        }
                        case "03": {
                            integer1 = 8;
                            break;
                        }
                        case "04": {
                            integer1 = 16;
                            break;
                        }
                        case "05": {
                            integer1 = 0x20;
                            break;
                        }
                        case "06": {
                            integer1 = 0x40;
                            break;
                        }
                        case "07": {
                            integer1 = 0x80;
                            break;
                        }
                        case "08": {
                            integer1 = 0x100;
                            break;
                        }
                        case "09": {
                            integer1 = 0x200;
                            break;
                        }
                        case "10": {
                            integer1 = 0x400;
                            break;
                        }
                        default: {
                            integer1 = null;
                            goto label_42;
                        }
                    }
                }
                String s2 = arr_s[2];
                if(s2 == null) {
                    integer0 = null;
                }
                else {
                    switch(s2) {
                        case "01": {
                            break;
                        }
                        case "02": {
                            integer0 = 2;
                            break;
                        }
                        case "03": {
                            return new Pair(integer1, 4);
                        }
                        case "04": {
                            return new Pair(integer1, 8);
                        }
                        case "05": {
                            return new Pair(integer1, 16);
                        }
                        case "06": {
                            return new Pair(integer1, 0x20);
                        }
                        case "07": {
                            return new Pair(integer1, 0x40);
                        }
                        case "08": {
                            return new Pair(integer1, 0x80);
                        }
                        case "09": {
                            return new Pair(integer1, 0x100);
                        }
                        case "10": {
                            return new Pair(integer1, 0x200);
                        }
                        case "11": {
                            return new Pair(integer1, 0x400);
                        }
                        case "12": {
                            return new Pair(integer1, 0x800);
                        }
                        case "13": {
                            return new Pair(integer1, 0x1000);
                        }
                        default: {
                            integer0 = null;
                            break;
                        }
                    }
                }
                if(integer0 == null) {
                    a.w("Unknown Dolby Vision level string: ", s2, "CodecSpecificDataUtil");
                    return null;
                }
                return new Pair(integer1, integer0);
            }
            String s3 = arr_s[0];
            s3.getClass();
            switch(s3) {
                case "av01": {
                    v1 = 0;
                    break;
                }
                case "avc1": {
                    v1 = 1;
                    break;
                }
                case "avc2": {
                    v1 = 2;
                    break;
                }
                case "hev1": {
                    v1 = 3;
                    break;
                }
                case "hvc1": {
                    v1 = 4;
                    break;
                }
                case "mp4a": {
                    v1 = 5;
                    break;
                }
                case "s263": {
                    v1 = 6;
                    break;
                }
                case "vp09": {
                    v1 = 7;
                    break;
                }
                default: {
                    v1 = -1;
                }
            }
            int v2 = 0x4000;
            switch(v1) {
                case 0: {
                    if(arr_s.length < 4) {
                        a.w("Ignoring malformed AV1 codec string: ", s, "CodecSpecificDataUtil");
                        return null;
                    }
                    try {
                        v3 = Integer.parseInt(arr_s[1]);
                        v4 = Integer.parseInt(arr_s[2].substring(0, 2));
                        v5 = Integer.parseInt(arr_s[3]);
                    }
                    catch(NumberFormatException unused_ex) {
                        a.w("Ignoring malformed AV1 codec string: ", s, "CodecSpecificDataUtil");
                        return null;
                    }
                    if(v3 != 0) {
                        a.r(v3, "Unknown AV1 profile: ", "CodecSpecificDataUtil");
                        return null;
                    }
                    if(v5 != 8 && v5 != 10) {
                        a.r(v5, "Unknown AV1 bit depth: ", "CodecSpecificDataUtil");
                        return null;
                    }
                    if(v5 == 8) {
                        v6 = 1;
                    }
                    else {
                        v6 = i0 == null || i0.d == null && (i0.c != 6 && i0.c != 7) ? 2 : 0x1000;
                    }
                    switch(v4) {
                        case 0: {
                            v2 = 1;
                            break;
                        }
                        case 1: {
                            v2 = 2;
                            break;
                        }
                        case 2: {
                            v2 = 4;
                            break;
                        }
                        case 3: {
                            v2 = 8;
                            break;
                        }
                        case 4: {
                            v2 = 16;
                            break;
                        }
                        case 5: {
                            v2 = 0x20;
                            break;
                        }
                        case 6: {
                            v2 = 0x40;
                            break;
                        }
                        case 7: {
                            v2 = 0x80;
                            break;
                        }
                        case 8: {
                            v2 = 0x100;
                            break;
                        }
                        case 9: {
                            v2 = 0x200;
                            break;
                        }
                        case 10: {
                            v2 = 0x400;
                            break;
                        }
                        case 11: {
                            v2 = 0x800;
                            break;
                        }
                        case 12: {
                            v2 = 0x1000;
                            break;
                        }
                        case 13: {
                            v2 = 0x2000;
                            break;
                        }
                        case 14: {
                            break;
                        }
                        case 15: {
                            v2 = 0x8000;
                            break;
                        }
                        case 16: {
                            v2 = 0x10000;
                            break;
                        }
                        case 17: {
                            v2 = 0x20000;
                            break;
                        }
                        case 18: {
                            v2 = 0x40000;
                            break;
                        }
                        case 19: {
                            v2 = 0x80000;
                            break;
                        }
                        case 20: {
                            v2 = 0x100000;
                            break;
                        }
                        case 21: {
                            v2 = 0x200000;
                            break;
                        }
                        case 22: {
                            v2 = 0x400000;
                            break;
                        }
                        case 23: {
                            v2 = 0x800000;
                            break;
                        }
                        default: {
                            v2 = -1;
                        }
                    }
                    if(v2 == -1) {
                        a.r(v4, "Unknown AV1 level: ", "CodecSpecificDataUtil");
                        return null;
                    }
                    return new Pair(v6, v2);
                }
                case 1: 
                case 2: {
                    if(arr_s.length < 2) {
                        a.w("Ignoring malformed AVC codec string: ", s, "CodecSpecificDataUtil");
                        return null;
                    }
                    try {
                        if(arr_s[1].length() == 6) {
                            v7 = Integer.parseInt(arr_s[1].substring(0, 2), 16);
                            v8 = Integer.parseInt(arr_s[1].substring(4), 16);
                        }
                        else {
                            if(arr_s.length < 3) {
                                e3.b.D("CodecSpecificDataUtil", "Ignoring malformed AVC codec string: " + s);
                                return null;
                            }
                            v7 = Integer.parseInt(arr_s[1]);
                            v8 = Integer.parseInt(arr_s[2]);
                        }
                    }
                    catch(NumberFormatException unused_ex) {
                        a.w("Ignoring malformed AVC codec string: ", s, "CodecSpecificDataUtil");
                        return null;
                    }
                    switch(v7) {
                        case 66: {
                            v9 = 1;
                            break;
                        }
                        case 77: {
                            v9 = 2;
                            break;
                        }
                        case 88: {
                            v9 = 4;
                            break;
                        }
                        case 100: {
                            v9 = 8;
                            break;
                        }
                        case 110: {
                            v9 = 16;
                            break;
                        }
                        case 0x7A: {
                            v9 = 0x20;
                            break;
                        }
                        case 0xF4: {
                            v9 = 0x40;
                            break;
                        }
                        default: {
                            v9 = -1;
                        }
                    }
                    if(v9 == -1) {
                        a.r(v7, "Unknown AVC profile: ", "CodecSpecificDataUtil");
                        return null;
                    }
                    switch(v8) {
                        case 10: {
                            v2 = 1;
                            break;
                        }
                        case 11: {
                            v2 = 4;
                            break;
                        }
                        case 12: {
                            v2 = 8;
                            break;
                        }
                        case 13: {
                            v2 = 16;
                            break;
                        }
                        case 20: {
                            v2 = 0x20;
                            break;
                        }
                        case 21: {
                            v2 = 0x40;
                            break;
                        }
                        case 22: {
                            v2 = 0x80;
                            break;
                        }
                        case 30: {
                            v2 = 0x100;
                            break;
                        }
                        case 0x1F: {
                            v2 = 0x200;
                            break;
                        }
                        case 0x20: {
                            v2 = 0x400;
                            break;
                        }
                        case 40: {
                            v2 = 0x800;
                            break;
                        }
                        case 41: {
                            v2 = 0x1000;
                            break;
                        }
                        case 42: {
                            v2 = 0x2000;
                            break;
                        }
                        case 50: {
                            break;
                        }
                        case 51: {
                            v2 = 0x8000;
                            break;
                        }
                        case 52: {
                            v2 = 0x10000;
                            break;
                        }
                        default: {
                            v2 = -1;
                        }
                    }
                    if(v2 == -1) {
                        a.r(v8, "Unknown AVC level: ", "CodecSpecificDataUtil");
                        return null;
                    }
                    return new Pair(v9, v2);
                }
                case 3: 
                case 4: {
                    return c.b(s, arr_s, i0);
                }
                case 5: {
                    if(arr_s.length != 3) {
                        a.w("Ignoring malformed MP4A codec string: ", s, "CodecSpecificDataUtil");
                        return null;
                    }
                    try {
                        if("audio/mp4a-latm".equals(H.d(Integer.parseInt(arr_s[1], 16)))) {
                            int v10 = Integer.parseInt(arr_s[2]);
                            int v11 = 17;
                            switch(v10) {
                                case 20: {
                                    v11 = 20;
                                    break;
                                }
                                case 17: 
                                case 23: {
                                    break;
                                }
                                default: {
                                    if(v10 != 29 && v10 != 39) {
                                        v11 = 42;
                                        if(v10 != 42) {
                                            switch(v10) {
                                                case 1: {
                                                    v11 = 1;
                                                    break;
                                                }
                                                case 2: {
                                                    v11 = 2;
                                                    break;
                                                }
                                                case 3: {
                                                    v11 = 3;
                                                    break;
                                                }
                                                case 4: {
                                                    v11 = 4;
                                                    break;
                                                }
                                                case 5: {
                                                    v11 = 5;
                                                    break;
                                                }
                                                case 6: {
                                                    v11 = 6;
                                                    break;
                                                }
                                                default: {
                                                    v11 = -1;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            return v11 == -1 ? null : new Pair(v11, 0);
                        }
                    }
                    catch(NumberFormatException unused_ex) {
                        a.w("Ignoring malformed MP4A codec string: ", s, "CodecSpecificDataUtil");
                    }
                    return null;
                }
                case 6: {
                    Pair pair0 = new Pair(1, 1);
                    if(arr_s.length < 3) {
                        a.w("Ignoring malformed H263 codec string: ", s, "CodecSpecificDataUtil");
                        return pair0;
                    }
                    try {
                        return new Pair(Integer.parseInt(arr_s[1]), Integer.parseInt(arr_s[2]));
                    }
                    catch(NumberFormatException unused_ex) {
                        a.w("Ignoring malformed H263 codec string: ", s, "CodecSpecificDataUtil");
                        return pair0;
                    }
                }
                case 7: {
                    if(arr_s.length < 3) {
                        a.w("Ignoring malformed VP9 codec string: ", s, "CodecSpecificDataUtil");
                        return null;
                    }
                    try {
                        v12 = Integer.parseInt(arr_s[1]);
                        v13 = Integer.parseInt(arr_s[2]);
                        switch(v12) {
                            case 0: {
                                v14 = 1;
                                goto label_290;
                            }
                            case 1: {
                                v14 = 2;
                                goto label_290;
                            }
                            case 2: {
                                v14 = 4;
                                goto label_290;
                            }
                            case 3: {
                                goto label_289;
                            }
                        }
                    }
                    catch(NumberFormatException unused_ex) {
                        a.w("Ignoring malformed VP9 codec string: ", s, "CodecSpecificDataUtil");
                        return null;
                    }
                    v14 = -1;
                    goto label_290;
                label_289:
                    v14 = 8;
                label_290:
                    if(v14 == -1) {
                        a.r(v12, "Unknown VP9 profile: ", "CodecSpecificDataUtil");
                        return null;
                    }
                    if(v13 == 10) {
                        v = 1;
                    }
                    else {
                        switch(v13) {
                            case 11: {
                                v = 2;
                                break;
                            }
                            case 20: {
                                v = 4;
                                break;
                            }
                            case 21: {
                                v = 8;
                                break;
                            }
                            case 30: {
                                break;
                            }
                            case 0x1F: {
                                v = 0x20;
                                break;
                            }
                            case 40: {
                                v = 0x40;
                                break;
                            }
                            case 41: {
                                v = 0x80;
                                break;
                            }
                            case 50: {
                                v = 0x100;
                                break;
                            }
                            case 51: {
                                v = 0x200;
                                break;
                            }
                            case 60: {
                                v = 0x800;
                                break;
                            }
                            case 61: {
                                v = 0x1000;
                                break;
                            }
                            case 62: {
                                v = 0x2000;
                                break;
                            }
                            default: {
                                v = -1;
                            }
                        }
                    }
                    if(v == -1) {
                        a.r(v13, "Unknown VP9 level: ", "CodecSpecificDataUtil");
                        return null;
                    }
                    return new Pair(v14, v);
                }
                default: {
                    return null;
                }
            }
        }
        return null;
    }

    public static List e(String s, boolean z, boolean z1) {
        synchronized(v.class) {
            r r0 = new r(s, z, z1);
            HashMap hashMap0 = v.a;
            List list0 = (List)hashMap0.get(r0);
            if(list0 != null) {
                return list0;
            }
            ArrayList arrayList0 = v.f(r0, new Ab(z, z1, 1));
            boolean z2 = !z || !arrayList0.isEmpty();
            v.a(s, arrayList0);
            List list1 = V.p(arrayList0);
            hashMap0.put(r0, list1);
            return list1;
        }
    }

    public static ArrayList f(r r0, t t0) {
        String s5;
        m m0;
        String s4;
        String s3;
        boolean z5;
        MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities0;
        String s2;
        String s1;
        MediaCodecInfo mediaCodecInfo0;
        int v1;
        String s;
        ArrayList arrayList0;
        try {
            boolean z = r0.b;
            arrayList0 = new ArrayList();
            s = r0.a;
            int v = t0.getCodecCount();
            boolean z1 = t0.secureDecodersExplicit();
            for(v1 = 0; true; ++v1) {
            label_6:
                if(v1 >= v) {
                    return arrayList0;
                }
                mediaCodecInfo0 = t0.getCodecInfoAt(v1);
                if(!mediaCodecInfo0.isAlias()) {
                    s1 = mediaCodecInfo0.getName();
                    if(v.h(mediaCodecInfo0, s1, z1, s)) {
                        s2 = v.c(mediaCodecInfo0, s1, s);
                        if(s2 != null) {
                            break;
                        }
                    }
                }
            }
        }
        catch(Exception exception0) {
            throw new s("Failed to query underlying media codecs", exception0);  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
        }
        try {
            mediaCodecInfo$CodecCapabilities0 = mediaCodecInfo0.getCapabilitiesForType(s2);
            boolean z2 = t0.isFeatureSupported("tunneled-playback", s2, mediaCodecInfo$CodecCapabilities0);
            boolean z3 = t0.d("tunneled-playback", mediaCodecInfo$CodecCapabilities0);
            if((r0.c || !z3) && (!r0.c || z2)) {
                boolean z4 = t0.isFeatureSupported("secure-playback", s2, mediaCodecInfo$CodecCapabilities0);
                if((z || !t0.d("secure-playback", mediaCodecInfo$CodecCapabilities0)) && (!z || z4)) {
                    z5 = mediaCodecInfo0.isHardwareAccelerated();
                    v.i(mediaCodecInfo0, s);
                    mediaCodecInfo0.isVendor();
                    goto label_28;
                }
            }
            ++v1;
            goto label_6;
        }
        catch(Exception exception1) {
            s3 = s2;
            s4 = s1;
            goto label_45;
        }
    label_28:
        if((!z1 || z != z4) && (z1 || z)) {
            goto label_36;
            try {
            label_38:
                s3 = s2;
                arrayList0.add(m.h((s4 + ".secure"), s, s3, mediaCodecInfo$CodecCapabilities0, z5, true));
                return arrayList0;
            }
            catch(Exception exception1) {
                try {
                    goto label_45;
                }
                catch(Exception exception1) {
                }
            }
        label_44:
            s3 = s5;
            try {
            label_45:
                e3.b.p("MediaCodecUtil", "Failed to query codec " + s4 + " (" + s3 + ")");
                throw exception1;
            }
            catch(Exception exception0) {
            }
            throw new s("Failed to query underlying media codecs", exception0);  // 初始化器: Ljava/lang/Exception;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V
        }
        else {
            try {
                s3 = s2;
                s4 = s1;
                m0 = m.h(s1, s, s3, mediaCodecInfo$CodecCapabilities0, z5, false);
                s4 = s1;
                s5 = s3;
            }
            catch(Exception exception1) {
                goto label_45;
            }
            try {
                arrayList0.add(m0);
                ++v1;
                goto label_6;
            label_36:
                s4 = s1;
                if(!z1 && z4) {
                    goto label_38;
                }
            }
            catch(Exception exception1) {
                goto label_44;
            }
        }
        ++v1;
        goto label_6;
    }

    public static p0 g(h h0, b b0, boolean z, boolean z1) {
        List list1;
        h0.getClass();
        List list0 = v.e(b0.n, z, z1);
        String s = v.b(b0);
        if(s == null) {
            list1 = p0.e;
        }
        else {
            h0.getClass();
            list1 = v.e(s, z, z1);
        }
        Q q0 = V.o();
        q0.d(list0);
        q0.d(list1);
        return q0.g();
    }

    // 去混淆评级： 低(30)
    public static boolean h(MediaCodecInfo mediaCodecInfo0, String s, boolean z, String s1) {
        return !mediaCodecInfo0.isEncoder() && (z || !s.endsWith(".secure"));
    }

    public static boolean i(MediaCodecInfo mediaCodecInfo0, String s) {
        return com.iloen.melon.utils.player.a.v(mediaCodecInfo0);
    }
}

