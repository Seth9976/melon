package com.google.android.exoplayer2.mediacodec;

import U4.x;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseIntArray;
import b3.Z;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.ColorInfo;
import com.iloen.melon.utils.player.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

@SuppressLint({"InlinedApi"})
public final class MediaCodecUtil {
    static final class CodecKey {
        public final String mimeType;
        public final boolean secure;
        public final boolean tunneling;

        public CodecKey(String s, boolean z, boolean z1) {
            this.mimeType = s;
            this.secure = z;
            this.tunneling = z1;
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(Object object0) {
            return this == object0 ? true : object0 != null && object0.getClass() == CodecKey.class && TextUtils.equals(this.mimeType, ((CodecKey)object0).mimeType) && this.secure == ((CodecKey)object0).secure && this.tunneling == ((CodecKey)object0).tunneling;
        }

        @Override
        public int hashCode() {
            int v = x.b(0x1F, 0x1F, this.mimeType);
            int v1 = 0x4D5;
            int v2 = this.secure ? 0x4CF : 0x4D5;
            if(this.tunneling) {
                v1 = 0x4CF;
            }
            return (v + v2) * 0x1F + v1;
        }
    }

    public static class DecoderQueryException extends Exception {
        private DecoderQueryException(Throwable throwable0) {
            super("Failed to query underlying media codecs", throwable0);
        }

        public DecoderQueryException(Throwable throwable0, com.google.android.exoplayer2.mediacodec.MediaCodecUtil.1 mediaCodecUtil$10) {
            this(throwable0);
        }
    }

    interface MediaCodecListCompat {
        int getCodecCount();

        MediaCodecInfo getCodecInfoAt(int arg1);

        boolean isFeatureRequired(String arg1, String arg2, MediaCodecInfo.CodecCapabilities arg3);

        boolean isFeatureSupported(String arg1, String arg2, MediaCodecInfo.CodecCapabilities arg3);

        boolean secureDecodersExplicit();
    }

    static final class MediaCodecListCompatV16 implements MediaCodecListCompat {
        private MediaCodecListCompatV16() {
        }

        public MediaCodecListCompatV16(com.google.android.exoplayer2.mediacodec.MediaCodecUtil.1 mediaCodecUtil$10) {
        }

        @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecUtil$MediaCodecListCompat
        public int getCodecCount() {
            return MediaCodecList.getCodecCount();
        }

        @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecUtil$MediaCodecListCompat
        public MediaCodecInfo getCodecInfoAt(int v) {
            return MediaCodecList.getCodecInfoAt(v);
        }

        @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecUtil$MediaCodecListCompat
        public boolean isFeatureRequired(String s, String s1, MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities0) {
            return false;
        }

        // 去混淆评级： 低(20)
        @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecUtil$MediaCodecListCompat
        public boolean isFeatureSupported(String s, String s1, MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities0) {
            return "secure-playback".equals(s) && "video/avc".equals(s1);
        }

        @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecUtil$MediaCodecListCompat
        public boolean secureDecodersExplicit() {
            return false;
        }
    }

    @TargetApi(21)
    static final class MediaCodecListCompatV21 implements MediaCodecListCompat {
        private final int codecKind;
        private MediaCodecInfo[] mediaCodecInfos;

        public MediaCodecListCompatV21(boolean z, boolean z1) {
            this.codecKind = z || z1 ? 1 : 0;
        }

        @EnsuresNonNull({"mediaCodecInfos"})
        private void ensureMediaCodecInfosInitialized() {
            if(this.mediaCodecInfos == null) {
                this.mediaCodecInfos = new MediaCodecList(this.codecKind).getCodecInfos();
            }
        }

        @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecUtil$MediaCodecListCompat
        public int getCodecCount() {
            this.ensureMediaCodecInfosInitialized();
            return this.mediaCodecInfos.length;
        }

        @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecUtil$MediaCodecListCompat
        public MediaCodecInfo getCodecInfoAt(int v) {
            this.ensureMediaCodecInfosInitialized();
            return this.mediaCodecInfos[v];
        }

        @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecUtil$MediaCodecListCompat
        public boolean isFeatureRequired(String s, String s1, MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities0) {
            return mediaCodecInfo$CodecCapabilities0.isFeatureRequired(s);
        }

        @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecUtil$MediaCodecListCompat
        public boolean isFeatureSupported(String s, String s1, MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities0) {
            return mediaCodecInfo$CodecCapabilities0.isFeatureSupported(s);
        }

        @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecUtil$MediaCodecListCompat
        public boolean secureDecodersExplicit() {
            return true;
        }
    }

    interface ScoreProvider {
        int getScore(Object arg1);
    }

    private static final SparseIntArray AV1_LEVEL_NUMBER_TO_CONST = null;
    private static final SparseIntArray AVC_LEVEL_NUMBER_TO_CONST = null;
    private static final SparseIntArray AVC_PROFILE_NUMBER_TO_CONST = null;
    private static final String CODEC_ID_AV01 = "av01";
    private static final String CODEC_ID_AVC1 = "avc1";
    private static final String CODEC_ID_AVC2 = "avc2";
    private static final String CODEC_ID_HEV1 = "hev1";
    private static final String CODEC_ID_HVC1 = "hvc1";
    private static final String CODEC_ID_MP4A = "mp4a";
    private static final String CODEC_ID_VP09 = "vp09";
    private static final Map DOLBY_VISION_STRING_TO_LEVEL = null;
    private static final Map DOLBY_VISION_STRING_TO_PROFILE = null;
    private static final Map HEVC_CODEC_STRING_TO_PROFILE_LEVEL = null;
    private static final SparseIntArray MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE = null;
    private static final Pattern PROFILE_PATTERN = null;
    private static final String TAG = "MediaCodecUtil";
    private static final SparseIntArray VP9_LEVEL_NUMBER_TO_CONST;
    private static final SparseIntArray VP9_PROFILE_NUMBER_TO_CONST;
    private static final HashMap decoderInfosCache;
    private static int maxH264DecodableFrameSize;

    static {
        MediaCodecUtil.PROFILE_PATTERN = Pattern.compile("^\\D?(\\d+)$");
        MediaCodecUtil.decoderInfosCache = new HashMap();
        MediaCodecUtil.maxH264DecodableFrameSize = -1;
        SparseIntArray sparseIntArray0 = new SparseIntArray();
        MediaCodecUtil.AVC_PROFILE_NUMBER_TO_CONST = sparseIntArray0;
        sparseIntArray0.put(66, 1);
        sparseIntArray0.put(77, 2);
        sparseIntArray0.put(88, 4);
        sparseIntArray0.put(100, 8);
        sparseIntArray0.put(110, 16);
        sparseIntArray0.put(0x7A, 0x20);
        sparseIntArray0.put(0xF4, 0x40);
        SparseIntArray sparseIntArray1 = new SparseIntArray();
        MediaCodecUtil.AVC_LEVEL_NUMBER_TO_CONST = sparseIntArray1;
        sparseIntArray1.put(10, 1);
        sparseIntArray1.put(11, 4);
        sparseIntArray1.put(12, 8);
        sparseIntArray1.put(13, 16);
        sparseIntArray1.put(20, 0x20);
        sparseIntArray1.put(21, 0x40);
        sparseIntArray1.put(22, 0x80);
        sparseIntArray1.put(30, 0x100);
        sparseIntArray1.put(0x1F, 0x200);
        sparseIntArray1.put(0x20, 0x400);
        sparseIntArray1.put(40, 0x800);
        sparseIntArray1.put(41, 0x1000);
        sparseIntArray1.put(42, 0x2000);
        sparseIntArray1.put(50, 0x4000);
        sparseIntArray1.put(51, 0x8000);
        sparseIntArray1.put(52, 0x10000);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        MediaCodecUtil.VP9_PROFILE_NUMBER_TO_CONST = sparseIntArray2;
        sparseIntArray2.put(0, 1);
        sparseIntArray2.put(1, 2);
        sparseIntArray2.put(2, 4);
        sparseIntArray2.put(3, 8);
        SparseIntArray sparseIntArray3 = new SparseIntArray();
        MediaCodecUtil.VP9_LEVEL_NUMBER_TO_CONST = sparseIntArray3;
        sparseIntArray3.put(10, 1);
        sparseIntArray3.put(11, 2);
        sparseIntArray3.put(20, 4);
        sparseIntArray3.put(21, 8);
        sparseIntArray3.put(30, 16);
        sparseIntArray3.put(0x1F, 0x20);
        sparseIntArray3.put(40, 0x40);
        sparseIntArray3.put(41, 0x80);
        sparseIntArray3.put(50, 0x100);
        sparseIntArray3.put(51, 0x200);
        sparseIntArray3.put(60, 0x800);
        sparseIntArray3.put(61, 0x1000);
        sparseIntArray3.put(62, 0x2000);
        HashMap hashMap0 = new HashMap();
        MediaCodecUtil.HEVC_CODEC_STRING_TO_PROFILE_LEVEL = hashMap0;
        hashMap0.put("L30", 1);
        hashMap0.put("L60", 4);
        hashMap0.put("L63", 16);
        hashMap0.put("L90", 0x40);
        hashMap0.put("L93", 0x100);
        hashMap0.put("L120", 0x400);
        Z.t(0x1000, hashMap0, "L123", 0x4000, "L150");
        Z.t(0x10000, hashMap0, "L153", 0x40000, "L156");
        Z.t(0x100000, hashMap0, "L180", 0x400000, "L183");
        hashMap0.put("L186", 0x1000000);
        hashMap0.put("H30", 2);
        hashMap0.put("H60", 8);
        hashMap0.put("H63", 0x20);
        hashMap0.put("H90", 0x80);
        hashMap0.put("H93", 0x200);
        hashMap0.put("H120", 0x800);
        Z.t(0x2000, hashMap0, "H123", 0x8000, "H150");
        Z.t(0x20000, hashMap0, "H153", 0x80000, "H156");
        Z.t(0x200000, hashMap0, "H180", 0x800000, "H183");
        hashMap0.put("H186", 0x2000000);
        HashMap hashMap1 = new HashMap();
        MediaCodecUtil.DOLBY_VISION_STRING_TO_PROFILE = hashMap1;
        hashMap1.put("00", 1);
        hashMap1.put("01", 2);
        hashMap1.put("02", 4);
        hashMap1.put("03", 8);
        hashMap1.put("04", 16);
        hashMap1.put("05", 0x20);
        hashMap1.put("06", 0x40);
        hashMap1.put("07", 0x80);
        hashMap1.put("08", 0x100);
        hashMap1.put("09", 0x200);
        HashMap hashMap2 = new HashMap();
        MediaCodecUtil.DOLBY_VISION_STRING_TO_LEVEL = hashMap2;
        hashMap2.put("01", 1);
        hashMap2.put("02", 2);
        hashMap2.put("03", 4);
        hashMap2.put("04", 8);
        hashMap2.put("05", 16);
        hashMap2.put("06", 0x20);
        hashMap2.put("07", 0x40);
        hashMap2.put("08", 0x80);
        hashMap2.put("09", 0x100);
        SparseIntArray sparseIntArray4 = new SparseIntArray();
        MediaCodecUtil.AV1_LEVEL_NUMBER_TO_CONST = sparseIntArray4;
        sparseIntArray4.put(0, 1);
        sparseIntArray4.put(1, 2);
        sparseIntArray4.put(2, 4);
        sparseIntArray4.put(3, 8);
        sparseIntArray4.put(4, 16);
        sparseIntArray4.put(5, 0x20);
        sparseIntArray4.put(6, 0x40);
        sparseIntArray4.put(7, 0x80);
        sparseIntArray4.put(8, 0x100);
        sparseIntArray4.put(9, 0x200);
        sparseIntArray4.put(10, 0x400);
        sparseIntArray4.put(11, 0x800);
        sparseIntArray4.put(12, 0x1000);
        sparseIntArray4.put(13, 0x2000);
        sparseIntArray4.put(14, 0x4000);
        sparseIntArray4.put(15, 0x8000);
        sparseIntArray4.put(16, 0x10000);
        sparseIntArray4.put(17, 0x20000);
        sparseIntArray4.put(18, 0x40000);
        sparseIntArray4.put(19, 0x80000);
        sparseIntArray4.put(20, 0x100000);
        sparseIntArray4.put(21, 0x200000);
        sparseIntArray4.put(22, 0x400000);
        sparseIntArray4.put(23, 0x800000);
        SparseIntArray sparseIntArray5 = new SparseIntArray();
        MediaCodecUtil.MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE = sparseIntArray5;
        sparseIntArray5.put(1, 1);
        sparseIntArray5.put(2, 2);
        sparseIntArray5.put(3, 3);
        sparseIntArray5.put(4, 4);
        sparseIntArray5.put(5, 5);
        sparseIntArray5.put(6, 6);
        sparseIntArray5.put(17, 17);
        sparseIntArray5.put(20, 20);
        sparseIntArray5.put(23, 23);
        sparseIntArray5.put(29, 29);
        sparseIntArray5.put(39, 39);
        sparseIntArray5.put(42, 42);
    }

    private static void applyWorkarounds(String s, List list0) {
        if("audio/raw".equals(s)) {
            if(Util.SDK_INT < 26 && Util.DEVICE.equals("R9") && list0.size() == 1 && ((com.google.android.exoplayer2.mediacodec.MediaCodecInfo)list0.get(0)).name.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                list0.add(com.google.android.exoplayer2.mediacodec.MediaCodecInfo.newInstance("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, true, false, false, false));
            }
            MediaCodecUtil.sortByScore(list0, new b(0));
        }
        int v = Util.SDK_INT;
        if(v < 21 && list0.size() > 1) {
            String s1 = ((com.google.android.exoplayer2.mediacodec.MediaCodecInfo)list0.get(0)).name;
            if("OMX.SEC.mp3.dec".equals(s1) || "OMX.SEC.MP3.Decoder".equals(s1) || "OMX.brcm.audio.mp3.decoder".equals(s1)) {
                MediaCodecUtil.sortByScore(list0, new b(1));
            }
        }
        if(v < 30 && list0.size() > 1 && "OMX.qti.audio.decoder.flac".equals(((com.google.android.exoplayer2.mediacodec.MediaCodecInfo)list0.get(0)).name)) {
            list0.add(((com.google.android.exoplayer2.mediacodec.MediaCodecInfo)list0.remove(0)));
        }
    }

    private static int avcLevelToMaxFrameSize(int v) {
        if(v != 1 && v != 2) {
            switch(v) {
                case 8: 
                case 16: 
                case 0x20: {
                    return 0x18C00;
                }
                case 0x40: {
                    return 0x31800;
                }
                case 0x80: 
                case 0x100: {
                    return 0x65400;
                }
                case 0x200: {
                    return 0xE1000;
                }
                case 0x400: {
                    return 0x140000;
                }
                case 0x800: 
                case 0x1000: {
                    return 0x200000;
                }
                case 0x2000: {
                    return 0x220000;
                }
                case 0x4000: {
                    return 0x564000;
                }
                case 0x8000: 
                case 0x10000: {
                    return 0x900000;
                }
                default: {
                    return -1;
                }
            }
        }
        return 0x6300;
    }

    // 去混淆评级： 低(40)
    private static boolean codecNeedsDisableAdaptationWorkaround(String s) {
        return Util.SDK_INT <= 22 && (("ODROID-XU3".equals(Util.MODEL) || "Nexus 10".equals(Util.MODEL)) && ("OMX.Exynos.AVC.Decoder".equals(s) || "OMX.Exynos.AVC.Decoder.secure".equals(s)));
    }

    private static Pair getAacCodecProfileAndLevel(String s, String[] arr_s) {
        if(arr_s.length != 3) {
            String s1 = String.valueOf(s);
            Log.w("MediaCodecUtil", (s1.length() == 0 ? new String("Ignoring malformed MP4A codec string: ") : "Ignoring malformed MP4A codec string: " + s1));
            return null;
        }
        try {
            if("audio/mp4a-latm".equals(MimeTypes.getMimeTypeFromMp4ObjectType(Integer.parseInt(arr_s[1], 16)))) {
                int v = Integer.parseInt(arr_s[2]);
                int v1 = MediaCodecUtil.MP4A_AUDIO_OBJECT_TYPE_TO_PROFILE.get(v, -1);
                if(v1 != -1) {
                    return new Pair(v1, 0);
                }
            }
        }
        catch(NumberFormatException unused_ex) {
            String s2 = String.valueOf(s);
            Log.w("MediaCodecUtil", (s2.length() == 0 ? new String("Ignoring malformed MP4A codec string: ") : "Ignoring malformed MP4A codec string: " + s2));
        }
        return null;
    }

    private static Pair getAv1ProfileAndLevel(String s, String[] arr_s, ColorInfo colorInfo0) {
        int v3;
        int v2;
        int v1;
        int v;
        if(arr_s.length < 4) {
            String s1 = String.valueOf(s);
            Log.w("MediaCodecUtil", (s1.length() == 0 ? new String("Ignoring malformed AV1 codec string: ") : "Ignoring malformed AV1 codec string: " + s1));
            return null;
        }
        try {
            v = 1;
            v1 = Integer.parseInt(arr_s[1]);
            v2 = Integer.parseInt(arr_s[2].substring(0, 2));
            v3 = Integer.parseInt(arr_s[3]);
        }
        catch(NumberFormatException unused_ex) {
            String s2 = String.valueOf(s);
            Log.w("MediaCodecUtil", (s2.length() == 0 ? new String("Ignoring malformed AV1 codec string: ") : "Ignoring malformed AV1 codec string: " + s2));
            return null;
        }
        if(v1 != 0) {
            Z.q(0x20, v1, "Unknown AV1 profile: ", "MediaCodecUtil");
            return null;
        }
        if(v3 != 8 && v3 != 10) {
            Z.q(34, v3, "Unknown AV1 bit depth: ", "MediaCodecUtil");
            return null;
        }
        if(v3 != 8) {
            v = colorInfo0 == null || colorInfo0.hdrStaticInfo == null && (colorInfo0.colorTransfer != 6 && colorInfo0.colorTransfer != 7) ? 2 : 0x1000;
        }
        int v4 = MediaCodecUtil.AV1_LEVEL_NUMBER_TO_CONST.get(v2, -1);
        if(v4 == -1) {
            Z.q(30, v2, "Unknown AV1 level: ", "MediaCodecUtil");
            return null;
        }
        return new Pair(v, v4);
    }

    private static Pair getAvcProfileAndLevel(String s, String[] arr_s) {
        int v2;
        int v1;
        if(arr_s.length < 2) {
            String s1 = String.valueOf(s);
            Log.w("MediaCodecUtil", (s1.length() == 0 ? new String("Ignoring malformed AVC codec string: ") : "Ignoring malformed AVC codec string: " + s1));
            return null;
        }
        try {
            if(arr_s[1].length() == 6) {
                v2 = Integer.parseInt(arr_s[1].substring(0, 2), 16);
                v1 = Integer.parseInt(arr_s[1].substring(4), 16);
            }
            else {
                if(arr_s.length < 3) {
                    String s2 = String.valueOf(s);
                    Log.w("MediaCodecUtil", (s2.length() == 0 ? new String("Ignoring malformed AVC codec string: ") : "Ignoring malformed AVC codec string: " + s2));
                    return null;
                }
                int v = Integer.parseInt(arr_s[1]);
                v1 = Integer.parseInt(arr_s[2]);
                v2 = v;
            }
        }
        catch(NumberFormatException unused_ex) {
            String s3 = String.valueOf(s);
            Log.w("MediaCodecUtil", (s3.length() == 0 ? new String("Ignoring malformed AVC codec string: ") : "Ignoring malformed AVC codec string: " + s3));
            return null;
        }
        int v3 = MediaCodecUtil.AVC_PROFILE_NUMBER_TO_CONST.get(v2, -1);
        if(v3 == -1) {
            Z.q(0x20, v2, "Unknown AVC profile: ", "MediaCodecUtil");
            return null;
        }
        int v4 = MediaCodecUtil.AVC_LEVEL_NUMBER_TO_CONST.get(v1, -1);
        if(v4 == -1) {
            Z.q(30, v1, "Unknown AVC level: ", "MediaCodecUtil");
            return null;
        }
        return new Pair(v3, v4);
    }

    private static String getCodecMimeType(MediaCodecInfo mediaCodecInfo0, String s, String s1) {
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
        if(s1.equals("audio/alac") && "OMX.lge.alac.decoder".equals(s)) {
            return "audio/x-lg-alac";
        }
        return !s1.equals("audio/flac") || !"OMX.lge.flac.decoder".equals(s) ? null : "audio/x-lg-flac";
    }

    public static Pair getCodecProfileAndLevel(Format format0) {
        String s = format0.codecs;
        if(s == null) {
            return null;
        }
        String[] arr_s = s.split("\\.");
        if("video/dolby-vision".equals(format0.sampleMimeType)) {
            return MediaCodecUtil.getDolbyVisionProfileAndLevel(format0.codecs, arr_s);
        }
        String s1 = arr_s[0];
        s1.getClass();
        switch(s1) {
            case "av01": {
                return MediaCodecUtil.getAv1ProfileAndLevel(format0.codecs, arr_s, format0.colorInfo);
            }
            case "avc1": {
                return MediaCodecUtil.getAvcProfileAndLevel(format0.codecs, arr_s);
            }
            case "avc2": {
                return MediaCodecUtil.getAvcProfileAndLevel(format0.codecs, arr_s);
            }
            case "hev1": {
                return MediaCodecUtil.getHevcProfileAndLevel(format0.codecs, arr_s);
            }
            case "hvc1": {
                return MediaCodecUtil.getHevcProfileAndLevel(format0.codecs, arr_s);
            }
            case "mp4a": {
                return MediaCodecUtil.getAacCodecProfileAndLevel(format0.codecs, arr_s);
            }
            case "vp09": {
                return MediaCodecUtil.getVp9ProfileAndLevel(format0.codecs, arr_s);
            }
            default: {
                return null;
            }
        }
    }

    public static com.google.android.exoplayer2.mediacodec.MediaCodecInfo getDecoderInfo(String s, boolean z, boolean z1) {
        List list0 = MediaCodecUtil.getDecoderInfos(s, z, z1);
        return list0.isEmpty() ? null : ((com.google.android.exoplayer2.mediacodec.MediaCodecInfo)list0.get(0));
    }

    public static List getDecoderInfos(String s, boolean z, boolean z1) {
        synchronized(MediaCodecUtil.class) {
            CodecKey mediaCodecUtil$CodecKey0 = new CodecKey(s, z, z1);
            HashMap hashMap0 = MediaCodecUtil.decoderInfosCache;
            List list0 = (List)hashMap0.get(mediaCodecUtil$CodecKey0);
            if(list0 != null) {
                return list0;
            }
            int v1 = Util.SDK_INT;
            MediaCodecListCompatV21 mediaCodecUtil$MediaCodecListCompatV210 = v1 >= 21 ? new MediaCodecListCompatV21(z, z1) : new MediaCodecListCompatV16(null);
            ArrayList arrayList0 = MediaCodecUtil.getDecoderInfosInternal(mediaCodecUtil$CodecKey0, mediaCodecUtil$MediaCodecListCompatV210);
            if(z && arrayList0.isEmpty() && 21 <= v1 && v1 <= 23) {
                arrayList0 = MediaCodecUtil.getDecoderInfosInternal(mediaCodecUtil$CodecKey0, new MediaCodecListCompatV16(null));
                if(!arrayList0.isEmpty()) {
                    Log.w("MediaCodecUtil", "MediaCodecList API didn\'t list secure decoder for: " + s + ". Assuming: " + ((com.google.android.exoplayer2.mediacodec.MediaCodecInfo)arrayList0.get(0)).name);
                }
            }
            MediaCodecUtil.applyWorkarounds(s, arrayList0);
            List list1 = Collections.unmodifiableList(arrayList0);
            hashMap0.put(mediaCodecUtil$CodecKey0, list1);
            return list1;
        }
    }

    private static ArrayList getDecoderInfosInternal(CodecKey mediaCodecUtil$CodecKey0, MediaCodecListCompat mediaCodecUtil$MediaCodecListCompat0) {
        boolean z9;
        boolean z8;
        boolean z7;
        boolean z6;
        String s3;
        boolean z5;
        int v2;
        try {
            ArrayList arrayList0 = new ArrayList();
            String s = mediaCodecUtil$CodecKey0.mimeType;
            int v = mediaCodecUtil$MediaCodecListCompat0.getCodecCount();
            boolean z = mediaCodecUtil$MediaCodecListCompat0.secureDecodersExplicit();
            int v1 = 0;
            while(true) {
                if(v1 >= v) {
                    return arrayList0;
                }
                MediaCodecInfo mediaCodecInfo0 = mediaCodecUtil$MediaCodecListCompat0.getCodecInfoAt(v1);
                if(MediaCodecUtil.isAlias(mediaCodecInfo0)) {
                    v2 = v1;
                }
                else {
                    String s1 = mediaCodecInfo0.getName();
                    if(MediaCodecUtil.isCodecUsableDecoder(mediaCodecInfo0, s1, z, s)) {
                        String s2 = MediaCodecUtil.getCodecMimeType(mediaCodecInfo0, s1, s);
                        if(s2 == null) {
                            v2 = v1;
                        }
                        else {
                            try {
                                MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities0 = mediaCodecInfo0.getCapabilitiesForType(s2);
                                boolean z1 = mediaCodecUtil$MediaCodecListCompat0.isFeatureSupported("tunneled-playback", s2, mediaCodecInfo$CodecCapabilities0);
                                boolean z2 = mediaCodecUtil$MediaCodecListCompat0.isFeatureRequired("tunneled-playback", s2, mediaCodecInfo$CodecCapabilities0);
                                if((mediaCodecUtil$CodecKey0.tunneling || !z2) && (!mediaCodecUtil$CodecKey0.tunneling || z1)) {
                                    boolean z3 = mediaCodecUtil$MediaCodecListCompat0.isFeatureSupported("secure-playback", s2, mediaCodecInfo$CodecCapabilities0);
                                    boolean z4 = mediaCodecUtil$MediaCodecListCompat0.isFeatureRequired("secure-playback", s2, mediaCodecInfo$CodecCapabilities0);
                                    if(!mediaCodecUtil$CodecKey0.secure && z4 || mediaCodecUtil$CodecKey0.secure && !z3) {
                                        v2 = v1;
                                    }
                                    else {
                                        try {
                                            z5 = MediaCodecUtil.isHardwareAccelerated(mediaCodecInfo0);
                                        }
                                        catch(Exception exception1) {
                                            s3 = s1;
                                            v2 = v1;
                                            goto label_74;
                                        }
                                        try {
                                            z6 = MediaCodecUtil.isSoftwareOnly(mediaCodecInfo0);
                                            z7 = MediaCodecUtil.isVendor(mediaCodecInfo0);
                                        }
                                        catch(Exception exception1) {
                                            s3 = s1;
                                            v2 = v1;
                                            goto label_74;
                                        }
                                        try {
                                            z8 = MediaCodecUtil.codecNeedsDisableAdaptationWorkaround(s1);
                                        }
                                        catch(Exception exception1) {
                                            s3 = s1;
                                            v2 = v1;
                                            goto label_74;
                                        }
                                        if(z) {
                                            z9 = z7;
                                            if(mediaCodecUtil$CodecKey0.secure == z3) {
                                                try {
                                                    v2 = v1;
                                                    arrayList0.add(com.google.android.exoplayer2.mediacodec.MediaCodecInfo.newInstance(s1, s, s2, mediaCodecInfo$CodecCapabilities0, z5, z6, z9, z8, false));
                                                    goto label_78;
                                                label_53:
                                                    z9 = z7;
                                                label_54:
                                                    if(z || mediaCodecUtil$CodecKey0.secure) {
                                                        v2 = v1;
                                                        if(!z && z3) {
                                                            s3 = s1;
                                                            goto label_65;
                                                        }
                                                    }
                                                    else {
                                                        v2 = v1;
                                                        arrayList0.add(com.google.android.exoplayer2.mediacodec.MediaCodecInfo.newInstance(s1, s, s2, mediaCodecInfo$CodecCapabilities0, z5, z6, z9, z8, false));
                                                    }
                                                    goto label_78;
                                                }
                                                catch(Exception exception1) {
                                                    s3 = s1;
                                                    goto label_74;
                                                }
                                            }
                                        }
                                        else {
                                            goto label_53;
                                        }
                                        goto label_54;
                                        try {
                                        label_65:
                                            arrayList0.add(com.google.android.exoplayer2.mediacodec.MediaCodecInfo.newInstance((s1 + ".secure"), s, s2, mediaCodecInfo$CodecCapabilities0, z5, z6, z9, z8, true));
                                            return arrayList0;
                                        }
                                        catch(Exception exception1) {
                                            goto label_74;
                                        }
                                    }
                                }
                                else {
                                    v2 = v1;
                                }
                                goto label_78;
                            }
                            catch(Exception exception1) {
                                s3 = s1;
                                v2 = v1;
                            }
                        label_74:
                            if(Util.SDK_INT > 23 || arrayList0.isEmpty()) {
                                Log.e("MediaCodecUtil", "Failed to query codec " + s3 + " (" + s2 + ")");
                                throw exception1;
                            }
                            Log.e("MediaCodecUtil", "Skipping codec " + s3 + " (failed to query capabilities)");
                        }
                    }
                    else {
                        v2 = v1;
                    }
                }
            label_78:
                v1 = v2 + 1;
            }
        }
        catch(Exception exception0) {
            throw new DecoderQueryException(exception0, null);
        }
    }

    public static List getDecoderInfosSortedByFormatSupport(List list0, Format format0) {
        List list1 = new ArrayList(list0);
        MediaCodecUtil.sortByScore(list1, (com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo0) -> try {
            return mediaCodecInfo0.isFormatSupported(format0);
        }
        catch(DecoderQueryException unused_ex) {
            return -1;
        });
        return list1;
    }

    private static Pair getDolbyVisionProfileAndLevel(String s, String[] arr_s) {
        if(arr_s.length < 3) {
            String s1 = String.valueOf(s);
            Log.w("MediaCodecUtil", (s1.length() == 0 ? new String("Ignoring malformed Dolby Vision codec string: ") : "Ignoring malformed Dolby Vision codec string: " + s1));
            return null;
        }
        Matcher matcher0 = MediaCodecUtil.PROFILE_PATTERN.matcher(arr_s[1]);
        if(!matcher0.matches()) {
            String s2 = String.valueOf(s);
            Log.w("MediaCodecUtil", (s2.length() == 0 ? new String("Ignoring malformed Dolby Vision codec string: ") : "Ignoring malformed Dolby Vision codec string: " + s2));
            return null;
        }
        String s3 = matcher0.group(1);
        Integer integer0 = (Integer)MediaCodecUtil.DOLBY_VISION_STRING_TO_PROFILE.get(s3);
        if(integer0 == null) {
            String s4 = String.valueOf(s3);
            Log.w("MediaCodecUtil", (s4.length() == 0 ? new String("Unknown Dolby Vision profile string: ") : "Unknown Dolby Vision profile string: " + s4));
            return null;
        }
        String s5 = arr_s[2];
        Integer integer1 = (Integer)MediaCodecUtil.DOLBY_VISION_STRING_TO_LEVEL.get(s5);
        if(integer1 == null) {
            String s6 = String.valueOf(s5);
            Log.w("MediaCodecUtil", (s6.length() == 0 ? new String("Unknown Dolby Vision level string: ") : "Unknown Dolby Vision level string: " + s6));
            return null;
        }
        return new Pair(integer0, integer1);
    }

    private static Pair getHevcProfileAndLevel(String s, String[] arr_s) {
        if(arr_s.length < 4) {
            String s1 = String.valueOf(s);
            Log.w("MediaCodecUtil", (s1.length() == 0 ? new String("Ignoring malformed HEVC codec string: ") : "Ignoring malformed HEVC codec string: " + s1));
            return null;
        }
        int v = 1;
        Matcher matcher0 = MediaCodecUtil.PROFILE_PATTERN.matcher(arr_s[1]);
        if(!matcher0.matches()) {
            String s2 = String.valueOf(s);
            Log.w("MediaCodecUtil", (s2.length() == 0 ? new String("Ignoring malformed HEVC codec string: ") : "Ignoring malformed HEVC codec string: " + s2));
            return null;
        }
        String s3 = matcher0.group(1);
        if(!"1".equals(s3)) {
            if("2".equals(s3)) {
                v = 2;
                goto label_18;
            }
            String s4 = String.valueOf(s3);
            Log.w("MediaCodecUtil", (s4.length() == 0 ? new String("Unknown HEVC profile string: ") : "Unknown HEVC profile string: " + s4));
            return null;
        }
    label_18:
        String s5 = arr_s[3];
        Integer integer0 = (Integer)MediaCodecUtil.HEVC_CODEC_STRING_TO_PROFILE_LEVEL.get(s5);
        if(integer0 == null) {
            String s6 = String.valueOf(s5);
            Log.w("MediaCodecUtil", (s6.length() == 0 ? new String("Unknown HEVC level string: ") : "Unknown HEVC level string: " + s6));
            return null;
        }
        return new Pair(v, integer0);
    }

    public static com.google.android.exoplayer2.mediacodec.MediaCodecInfo getPassthroughDecoderInfo() {
        com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo0 = MediaCodecUtil.getDecoderInfo("audio/raw", false, false);
        return mediaCodecInfo0 == null ? null : com.google.android.exoplayer2.mediacodec.MediaCodecInfo.newPassthroughInstance(mediaCodecInfo0.name);
    }

    private static Pair getVp9ProfileAndLevel(String s, String[] arr_s) {
        int v1;
        int v;
        if(arr_s.length < 3) {
            String s1 = String.valueOf(s);
            Log.w("MediaCodecUtil", (s1.length() == 0 ? new String("Ignoring malformed VP9 codec string: ") : "Ignoring malformed VP9 codec string: " + s1));
            return null;
        }
        try {
            v = Integer.parseInt(arr_s[1]);
            v1 = Integer.parseInt(arr_s[2]);
        }
        catch(NumberFormatException unused_ex) {
            String s2 = String.valueOf(s);
            Log.w("MediaCodecUtil", (s2.length() == 0 ? new String("Ignoring malformed VP9 codec string: ") : "Ignoring malformed VP9 codec string: " + s2));
            return null;
        }
        int v2 = MediaCodecUtil.VP9_PROFILE_NUMBER_TO_CONST.get(v, -1);
        if(v2 == -1) {
            Z.q(0x20, v, "Unknown VP9 profile: ", "MediaCodecUtil");
            return null;
        }
        int v3 = MediaCodecUtil.VP9_LEVEL_NUMBER_TO_CONST.get(v1, -1);
        if(v3 == -1) {
            Z.q(30, v1, "Unknown VP9 level: ", "MediaCodecUtil");
            return null;
        }
        return new Pair(v2, v3);
    }

    private static boolean isAlias(MediaCodecInfo mediaCodecInfo0) {
        return Util.SDK_INT >= 29 && MediaCodecUtil.isAliasV29(mediaCodecInfo0);
    }

    private static boolean isAliasV29(MediaCodecInfo mediaCodecInfo0) {
        return mediaCodecInfo0.isAlias();
    }

    // 去混淆评级： 低(33)
    private static boolean isCodecUsableDecoder(MediaCodecInfo mediaCodecInfo0, String s, boolean z, String s1) {
        if(!mediaCodecInfo0.isEncoder() && (z || !s.endsWith(".secure"))) {
            int v = Util.SDK_INT;
            if(v < 21 && ("CIPAACDecoder".equals(s) || "CIPMP3Decoder".equals(s) || "CIPVorbisDecoder".equals(s) || "CIPAMRNBDecoder".equals(s) || "AACDecoder".equals(s) || "MP3Decoder".equals(s))) {
                return false;
            }
            if(v < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(s) && ("a70".equals(Util.DEVICE) || "Xiaomi".equals(Util.MANUFACTURER) && Util.DEVICE.startsWith("HM"))) {
                return false;
            }
            if(v == 16 && "OMX.qcom.audio.decoder.mp3".equals(s) && ("dlxu".equals(Util.DEVICE) || "protou".equals(Util.DEVICE) || "ville".equals(Util.DEVICE) || "villeplus".equals(Util.DEVICE) || "villec2".equals(Util.DEVICE) || Util.DEVICE.startsWith("gee") || "C6602".equals(Util.DEVICE) || "C6603".equals(Util.DEVICE) || "C6606".equals(Util.DEVICE) || "C6616".equals(Util.DEVICE) || "L36h".equals(Util.DEVICE) || "SO-02E".equals(Util.DEVICE))) {
                return false;
            }
            if(v == 16 && "OMX.qcom.audio.decoder.aac".equals(s) && ("C1504".equals(Util.DEVICE) || "C1505".equals(Util.DEVICE) || "C1604".equals(Util.DEVICE) || "C1605".equals(Util.DEVICE))) {
                return false;
            }
            if(v < 24 && ("OMX.SEC.aac.dec".equals(s) || "OMX.Exynos.AAC.Decoder".equals(s)) && "samsung".equals(Util.MANUFACTURER) && (Util.DEVICE.startsWith("zeroflte") || Util.DEVICE.startsWith("zerolte") || Util.DEVICE.startsWith("zenlte") || "SC-05G".equals(Util.DEVICE) || "marinelteatt".equals(Util.DEVICE) || "404SC".equals(Util.DEVICE) || "SC-04G".equals(Util.DEVICE) || "SCV31".equals(Util.DEVICE))) {
                return false;
            }
            if(v <= 19 && "OMX.SEC.vp8.dec".equals(s) && "samsung".equals(Util.MANUFACTURER) && (Util.DEVICE.startsWith("d2") || Util.DEVICE.startsWith("serrano") || Util.DEVICE.startsWith("jflte") || Util.DEVICE.startsWith("santos") || Util.DEVICE.startsWith("t0"))) {
                return false;
            }
            return v > 19 || !Util.DEVICE.startsWith("jflte") || !"OMX.qcom.video.decoder.vp8".equals(s) ? !"audio/eac3-joc".equals(s1) || !"OMX.MTK.AUDIO.DECODER.DSPAC3".equals(s) : false;
        }
        return false;
    }

    private static boolean isHardwareAccelerated(MediaCodecInfo mediaCodecInfo0) {
        return Util.SDK_INT < 29 ? !MediaCodecUtil.isSoftwareOnly(mediaCodecInfo0) : MediaCodecUtil.isHardwareAcceleratedV29(mediaCodecInfo0);
    }

    @TargetApi(29)
    private static boolean isHardwareAcceleratedV29(MediaCodecInfo mediaCodecInfo0) {
        return mediaCodecInfo0.isHardwareAccelerated();
    }

    // 去混淆评级： 低(27)
    private static boolean isSoftwareOnly(MediaCodecInfo mediaCodecInfo0) {
        if(Util.SDK_INT >= 29) {
            return MediaCodecUtil.isSoftwareOnlyV29(mediaCodecInfo0);
        }
        String s = Util.toLowerInvariant(mediaCodecInfo0.getName());
        return s.startsWith("arc.") ? false : s.startsWith("omx.google.") || s.startsWith("omx.ffmpeg.") || s.startsWith("omx.sec.") && s.contains(".sw.") || s.equals("omx.qcom.video.decoder.hevcswvdec") || s.startsWith("c2.android.") || s.startsWith("c2.google.") || !s.startsWith("omx.") && !s.startsWith("c2.");
    }

    @TargetApi(29)
    private static boolean isSoftwareOnlyV29(MediaCodecInfo mediaCodecInfo0) {
        return a.v(mediaCodecInfo0);
    }

    private static boolean isVendor(MediaCodecInfo mediaCodecInfo0) {
        if(Util.SDK_INT >= 29) {
            return MediaCodecUtil.isVendorV29(mediaCodecInfo0);
        }
        String s = Util.toLowerInvariant(mediaCodecInfo0.getName());
        return !s.startsWith("omx.google.") && !s.startsWith("c2.android.") && !s.startsWith("c2.google.");
    }

    @TargetApi(29)
    private static boolean isVendorV29(MediaCodecInfo mediaCodecInfo0) {
        return mediaCodecInfo0.isVendor();
    }

    private static int lambda$applyWorkarounds$1(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo0) {
        String s = mediaCodecInfo0.name;
        if(!s.startsWith("OMX.google") && !s.startsWith("c2.android")) {
            return Util.SDK_INT >= 26 || !s.equals("OMX.MTK.AUDIO.DECODER.RAW") ? 0 : -1;
        }
        return 1;
    }

    private static int lambda$applyWorkarounds$2(com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo0) {
        return mediaCodecInfo0.name.startsWith("OMX.google");
    }

    // 检测为 Lambda 实现
    private static int lambda$getDecoderInfosSortedByFormatSupport$0(Format format0, com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo0) [...]

    // 检测为 Lambda 实现
    private static int lambda$sortByScore$3(ScoreProvider mediaCodecUtil$ScoreProvider0, Object object0, Object object1) [...]

    public static int maxH264DecodableFrameSize() {
        if(MediaCodecUtil.maxH264DecodableFrameSize == -1) {
            int v = 0;
            com.google.android.exoplayer2.mediacodec.MediaCodecInfo mediaCodecInfo0 = MediaCodecUtil.getDecoderInfo("video/avc", false, false);
            if(mediaCodecInfo0 != null) {
                MediaCodecInfo.CodecProfileLevel[] arr_mediaCodecInfo$CodecProfileLevel = mediaCodecInfo0.getProfileLevels();
                int v1 = 0;
                while(v < arr_mediaCodecInfo$CodecProfileLevel.length) {
                    v1 = Math.max(MediaCodecUtil.avcLevelToMaxFrameSize(arr_mediaCodecInfo$CodecProfileLevel[v].level), v1);
                    ++v;
                }
                v = Math.max(v1, (Util.SDK_INT < 21 ? 0x2A300 : 0x54600));
            }
            MediaCodecUtil.maxH264DecodableFrameSize = v;
        }
        return MediaCodecUtil.maxH264DecodableFrameSize;
    }

    private static void sortByScore(List list0, ScoreProvider mediaCodecUtil$ScoreProvider0) {
        Collections.sort(list0, (Object object0, Object object1) -> mediaCodecUtil$ScoreProvider0.getScore(object1) - mediaCodecUtil$ScoreProvider0.getScore(object0));
    }

    public static void warmDecoderInfoCache(String s, boolean z, boolean z1) {
        try {
            MediaCodecUtil.getDecoderInfos(s, z, z1);
        }
        catch(DecoderQueryException mediaCodecUtil$DecoderQueryException0) {
            Log.e("MediaCodecUtil", "Codec warming failed", mediaCodecUtil$DecoderQueryException0);
        }
    }

    class com.google.android.exoplayer2.mediacodec.MediaCodecUtil.1 {
    }

}

