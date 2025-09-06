package com.google.android.exoplayer2.util;

import android.text.TextUtils;
import java.util.ArrayList;

public final class MimeTypes {
    static final class CustomMimeType {
        public final String codecPrefix;
        public final String mimeType;
        public final int trackType;

        public CustomMimeType(String s, String s1, int v) {
            this.mimeType = s;
            this.codecPrefix = s1;
            this.trackType = v;
        }
    }

    public static final String APPLICATION_CAMERA_MOTION = "application/x-camera-motion";
    public static final String APPLICATION_CEA608 = "application/cea-608";
    public static final String APPLICATION_CEA708 = "application/cea-708";
    public static final String APPLICATION_DVBSUBS = "application/dvbsubs";
    public static final String APPLICATION_EMSG = "application/x-emsg";
    public static final String APPLICATION_EXIF = "application/x-exif";
    public static final String APPLICATION_ICY = "application/x-icy";
    public static final String APPLICATION_ID3 = "application/id3";
    public static final String APPLICATION_M3U8 = "application/x-mpegURL";
    public static final String APPLICATION_MP4 = "application/mp4";
    public static final String APPLICATION_MP4CEA608 = "application/x-mp4-cea-608";
    public static final String APPLICATION_MP4VTT = "application/x-mp4-vtt";
    public static final String APPLICATION_MPD = "application/dash+xml";
    public static final String APPLICATION_PGS = "application/pgs";
    public static final String APPLICATION_RAWCC = "application/x-rawcc";
    public static final String APPLICATION_SCTE35 = "application/x-scte35";
    public static final String APPLICATION_SS = "application/vnd.ms-sstr+xml";
    public static final String APPLICATION_SUBRIP = "application/x-subrip";
    public static final String APPLICATION_TTML = "application/ttml+xml";
    public static final String APPLICATION_TX3G = "application/x-quicktime-tx3g";
    public static final String APPLICATION_VOBSUB = "application/vobsub";
    public static final String APPLICATION_WEBM = "application/webm";
    public static final String AUDIO_AAC = "audio/mp4a-latm";
    public static final String AUDIO_AC3 = "audio/ac3";
    public static final String AUDIO_AC4 = "audio/ac4";
    public static final String AUDIO_ALAC = "audio/alac";
    public static final String AUDIO_ALAW = "audio/g711-alaw";
    public static final String AUDIO_AMR_NB = "audio/3gpp";
    public static final String AUDIO_AMR_WB = "audio/amr-wb";
    public static final String AUDIO_DTS = "audio/vnd.dts";
    public static final String AUDIO_DTS_EXPRESS = "audio/vnd.dts.hd;profile=lbr";
    public static final String AUDIO_DTS_HD = "audio/vnd.dts.hd";
    public static final String AUDIO_E_AC3 = "audio/eac3";
    public static final String AUDIO_E_AC3_JOC = "audio/eac3-joc";
    public static final String AUDIO_FLAC = "audio/flac";
    public static final String AUDIO_MLAW = "audio/g711-mlaw";
    public static final String AUDIO_MP4 = "audio/mp4";
    public static final String AUDIO_MPEG = "audio/mpeg";
    public static final String AUDIO_MPEG_L1 = "audio/mpeg-L1";
    public static final String AUDIO_MPEG_L2 = "audio/mpeg-L2";
    public static final String AUDIO_MSGSM = "audio/gsm";
    public static final String AUDIO_OPUS = "audio/opus";
    public static final String AUDIO_RAW = "audio/raw";
    public static final String AUDIO_TRUEHD = "audio/true-hd";
    public static final String AUDIO_UNKNOWN = "audio/x-unknown";
    public static final String AUDIO_VORBIS = "audio/vorbis";
    public static final String AUDIO_WEBM = "audio/webm";
    public static final String BASE_TYPE_APPLICATION = "application";
    public static final String BASE_TYPE_AUDIO = "audio";
    public static final String BASE_TYPE_TEXT = "text";
    public static final String BASE_TYPE_VIDEO = "video";
    public static final String TEXT_SSA = "text/x-ssa";
    public static final String TEXT_VTT = "text/vtt";
    public static final String VIDEO_AV1 = "video/av01";
    public static final String VIDEO_DIVX = "video/divx";
    public static final String VIDEO_DOLBY_VISION = "video/dolby-vision";
    public static final String VIDEO_H263 = "video/3gpp";
    public static final String VIDEO_H264 = "video/avc";
    public static final String VIDEO_H265 = "video/hevc";
    public static final String VIDEO_MP4 = "video/mp4";
    public static final String VIDEO_MP4V = "video/mp4v-es";
    public static final String VIDEO_MPEG = "video/mpeg";
    public static final String VIDEO_MPEG2 = "video/mpeg2";
    public static final String VIDEO_UNKNOWN = "video/x-unknown";
    public static final String VIDEO_VC1 = "video/wvc1";
    public static final String VIDEO_VP8 = "video/x-vnd.on2.vp8";
    public static final String VIDEO_VP9 = "video/x-vnd.on2.vp9";
    public static final String VIDEO_WEBM = "video/webm";
    private static final ArrayList customMimeTypes;

    static {
        MimeTypes.customMimeTypes = new ArrayList();
    }

    // 去混淆评级： 低(22)
    public static boolean allSamplesAreSyncSamples(String s) {
        if(s == null) {
            return false;
        }
        switch(s) {
            case "audio/ac3": 
            case "audio/eac3": 
            case "audio/eac3-joc": 
            case "audio/flac": 
            case "audio/g711-alaw": 
            case "audio/g711-mlaw": 
            case "audio/mpeg": 
            case "audio/mpeg-L1": 
            case "audio/mpeg-L2": 
            case "audio/opus": 
            case "audio/raw": {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    public static String getAudioMediaMimeType(String s) {
        if(s == null) {
            return null;
        }
        String[] arr_s = Util.splitCodecs(s);
        for(int v = 0; v < arr_s.length; ++v) {
            String s1 = MimeTypes.getMediaMimeType(arr_s[v]);
            if(s1 != null && MimeTypes.isAudio(s1)) {
                return s1;
            }
        }
        return null;
    }

    private static String getCustomMimeTypeForCodec(String s) {
        int v = MimeTypes.customMimeTypes.size();
        for(int v1 = 0; v1 < v; ++v1) {
            CustomMimeType mimeTypes$CustomMimeType0 = (CustomMimeType)MimeTypes.customMimeTypes.get(v1);
            if(s.startsWith(mimeTypes$CustomMimeType0.codecPrefix)) {
                return mimeTypes$CustomMimeType0.mimeType;
            }
        }
        return null;
    }

    public static int getEncoding(String s) {
        s.getClass();
        switch(s) {
            case "audio/ac3": {
                return 5;
            }
            case "audio/ac4": {
                return 17;
            }
            case "audio/eac3": {
                return 6;
            }
            case "audio/eac3-joc": {
                return 18;
            }
            case "audio/mpeg": {
                return 9;
            }
            case "audio/true-hd": {
                return 14;
            }
            case "audio/vnd.dts": {
                return 7;
            }
            case "audio/vnd.dts.hd": {
                return 8;
            }
            default: {
                return 0;
            }
        }
    }

    public static String getMediaMimeType(String s) {
        String s1 = null;
        if(s == null) {
            return null;
        }
        String s2 = Util.toLowerInvariant(s.trim());
        if(!s2.startsWith("avc1") && !s2.startsWith("avc3")) {
            if(!s2.startsWith("hev1") && !s2.startsWith("hvc1")) {
                if(!s2.startsWith("dvav") && !s2.startsWith("dva1") && !s2.startsWith("dvhe") && !s2.startsWith("dvh1")) {
                    if(s2.startsWith("av01")) {
                        return "video/av01";
                    }
                    if(!s2.startsWith("vp9") && !s2.startsWith("vp09")) {
                        if(!s2.startsWith("vp8") && !s2.startsWith("vp08")) {
                            if(s2.startsWith("mp4a")) {
                                if(s2.startsWith("mp4a.")) {
                                    String s3 = s2.substring(5);
                                    if(s3.length() >= 2) {
                                        try {
                                            s1 = MimeTypes.getMimeTypeFromMp4ObjectType(Integer.parseInt(Util.toUpperInvariant(s3.substring(0, 2)), 16));
                                        }
                                        catch(NumberFormatException unused_ex) {
                                        }
                                    }
                                }
                                return s1 == null ? "audio/mp4a-latm" : s1;
                            }
                            if(!s2.startsWith("ac-3") && !s2.startsWith("dac3")) {
                                if(!s2.startsWith("ec-3") && !s2.startsWith("dec3")) {
                                    if(s2.startsWith("ec+3")) {
                                        return "audio/eac3-joc";
                                    }
                                    if(!s2.startsWith("ac-4") && !s2.startsWith("dac4")) {
                                        if(!s2.startsWith("dtsc") && !s2.startsWith("dtse")) {
                                            if(!s2.startsWith("dtsh") && !s2.startsWith("dtsl")) {
                                                if(s2.startsWith("opus")) {
                                                    return "audio/opus";
                                                }
                                                if(s2.startsWith("vorbis")) {
                                                    return "audio/vorbis";
                                                }
                                                if(s2.startsWith("flac")) {
                                                    return "audio/flac";
                                                }
                                                if(s2.startsWith("stpp")) {
                                                    return "application/ttml+xml";
                                                }
                                                return s2.startsWith("wvtt") ? "text/vtt" : MimeTypes.getCustomMimeTypeForCodec(s2);
                                            }
                                            return "audio/vnd.dts.hd";
                                        }
                                        return "audio/vnd.dts";
                                    }
                                    return "audio/ac4";
                                }
                                return "audio/eac3";
                            }
                            return "audio/ac3";
                        }
                        return "video/x-vnd.on2.vp8";
                    }
                    return "video/x-vnd.on2.vp9";
                }
                return "video/dolby-vision";
            }
            return "video/hevc";
        }
        return "video/avc";
    }

    public static String getMimeTypeFromMp4ObjectType(int v) {
        switch(v) {
            case 0x20: {
                return "video/mp4v-es";
            }
            case 33: {
                return "video/avc";
            }
            case 35: {
                return "video/hevc";
            }
            case 0x60: 
            case 97: 
            case 98: 
            case 99: 
            case 100: 
            case 101: {
                return "video/mpeg2";
            }
            case 0x40: 
            case 102: 
            case 103: 
            case 104: {
                return "audio/mp4a-latm";
            }
            case 106: {
                return "video/mpeg";
            }
            case 105: 
            case 107: {
                return "audio/mpeg";
            }
            case 0xA3: {
                return "video/wvc1";
            }
            case 0xA5: {
                return "audio/ac3";
            }
            case 0xA6: {
                return "audio/eac3";
            }
            case 170: 
            case 0xAB: {
                return "audio/vnd.dts.hd";
            }
            case 0xA9: 
            case 0xAC: {
                return "audio/vnd.dts";
            }
            case 0xAD: {
                return "audio/opus";
            }
            case 0xAE: {
                return "audio/ac4";
            }
            case 0xB1: {
                return "video/x-vnd.on2.vp9";
            }
            default: {
                return null;
            }
        }
    }

    private static String getTopLevelType(String s) {
        if(s == null) {
            return null;
        }
        int v = s.indexOf(0x2F);
        return v == -1 ? null : s.substring(0, v);
    }

    public static int getTrackType(String s) {
        if(TextUtils.isEmpty(s)) {
            return -1;
        }
        if(MimeTypes.isAudio(s)) {
            return 1;
        }
        if(MimeTypes.isVideo(s)) {
            return 2;
        }
        if(!MimeTypes.isText(s) && !"application/cea-608".equals(s) && !"application/cea-708".equals(s) && !"application/x-mp4-cea-608".equals(s) && !"application/x-subrip".equals(s) && !"application/ttml+xml".equals(s) && !"application/x-quicktime-tx3g".equals(s) && !"application/x-mp4-vtt".equals(s) && !"application/x-rawcc".equals(s) && !"application/vobsub".equals(s) && !"application/pgs".equals(s) && !"application/dvbsubs".equals(s)) {
            if(!"application/id3".equals(s) && !"application/x-emsg".equals(s) && !"application/x-scte35".equals(s)) {
                return "application/x-camera-motion".equals(s) ? 5 : MimeTypes.getTrackTypeForCustomMimeType(s);
            }
            return 4;
        }
        return 3;
    }

    private static int getTrackTypeForCustomMimeType(String s) {
        int v = MimeTypes.customMimeTypes.size();
        for(int v1 = 0; v1 < v; ++v1) {
            CustomMimeType mimeTypes$CustomMimeType0 = (CustomMimeType)MimeTypes.customMimeTypes.get(v1);
            if(s.equals(mimeTypes$CustomMimeType0.mimeType)) {
                return mimeTypes$CustomMimeType0.trackType;
            }
        }
        return -1;
    }

    public static int getTrackTypeOfCodec(String s) {
        return MimeTypes.getTrackType(MimeTypes.getMediaMimeType(s));
    }

    public static String getVideoMediaMimeType(String s) {
        if(s == null) {
            return null;
        }
        String[] arr_s = Util.splitCodecs(s);
        for(int v = 0; v < arr_s.length; ++v) {
            String s1 = MimeTypes.getMediaMimeType(arr_s[v]);
            if(s1 != null && MimeTypes.isVideo(s1)) {
                return s1;
            }
        }
        return null;
    }

    public static boolean isApplication(String s) {
        return "application".equals(MimeTypes.getTopLevelType(s));
    }

    public static boolean isAudio(String s) {
        return "audio".equals(MimeTypes.getTopLevelType(s));
    }

    public static boolean isText(String s) {
        return "text".equals(MimeTypes.getTopLevelType(s));
    }

    public static boolean isVideo(String s) {
        return "video".equals(MimeTypes.getTopLevelType(s));
    }

    public static void registerCustomMimeType(String s, String s1, int v) {
        CustomMimeType mimeTypes$CustomMimeType0 = new CustomMimeType(s, s1, v);
        int v1 = MimeTypes.customMimeTypes.size();
        for(int v2 = 0; v2 < v1; ++v2) {
            ArrayList arrayList0 = MimeTypes.customMimeTypes;
            if(s.equals(((CustomMimeType)arrayList0.get(v2)).mimeType)) {
                arrayList0.remove(v2);
                break;
            }
        }
        MimeTypes.customMimeTypes.add(mimeTypes$CustomMimeType0);
    }
}

