package com.google.android.exoplayer2.mediacodec;

import A7.d;
import android.annotation.TargetApi;
import android.graphics.Point;
import android.media.MediaCodecInfo.AudioCapabilities;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.util.Pair;
import b3.Z;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;

public final class MediaCodecInfo {
    public static final int MAX_SUPPORTED_INSTANCES_UNKNOWN = -1;
    public static final String TAG = "MediaCodecInfo";
    public final boolean adaptive;
    public final MediaCodecInfo.CodecCapabilities capabilities;
    public final String codecMimeType;
    public final boolean hardwareAccelerated;
    private final boolean isVideo;
    public final String mimeType;
    public final String name;
    public final boolean passthrough;
    public final boolean secure;
    public final boolean softwareOnly;
    public final boolean tunneling;
    public final boolean vendor;

    private MediaCodecInfo(String s, String s1, String s2, MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities0, boolean z, boolean z1, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.name = (String)Assertions.checkNotNull(s);
        this.mimeType = s1;
        this.codecMimeType = s2;
        this.capabilities = mediaCodecInfo$CodecCapabilities0;
        this.passthrough = z;
        this.hardwareAccelerated = z1;
        this.softwareOnly = z2;
        this.vendor = z3;
        boolean z6 = false;
        this.adaptive = !z4 && mediaCodecInfo$CodecCapabilities0 != null && MediaCodecInfo.isAdaptive(mediaCodecInfo$CodecCapabilities0);
        this.tunneling = mediaCodecInfo$CodecCapabilities0 != null && MediaCodecInfo.isTunneling(mediaCodecInfo$CodecCapabilities0);
        if(z5 || mediaCodecInfo$CodecCapabilities0 != null && MediaCodecInfo.isSecure(mediaCodecInfo$CodecCapabilities0)) {
            z6 = true;
        }
        this.secure = z6;
        this.isVideo = MimeTypes.isVideo(s1);
    }

    private static int adjustMaxInputChannelCount(String s, String s1, int v) {
        int v1;
        if(v <= 1 && (Util.SDK_INT < 26 || v <= 0) && !"audio/mpeg".equals(s1) && !"audio/3gpp".equals(s1) && !"audio/amr-wb".equals(s1) && !"audio/mp4a-latm".equals(s1) && !"audio/vorbis".equals(s1) && !"audio/opus".equals(s1) && !"audio/raw".equals(s1) && !"audio/flac".equals(s1) && !"audio/g711-alaw".equals(s1) && !"audio/g711-mlaw".equals(s1) && !"audio/gsm".equals(s1)) {
            if("audio/ac3".equals(s1)) {
                v1 = 6;
            }
            else {
                v1 = "audio/eac3".equals(s1) ? 16 : 30;
            }
            Log.w("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + s + ", [" + v + " to " + v1 + "]");
            return v1;
        }
        return v;
    }

    @TargetApi(21)
    private static Point alignVideoSizeV21(MediaCodecInfo.VideoCapabilities mediaCodecInfo$VideoCapabilities0, int v, int v1) {
        int v2 = mediaCodecInfo$VideoCapabilities0.getWidthAlignment();
        int v3 = mediaCodecInfo$VideoCapabilities0.getHeightAlignment();
        return new Point((v + v2 - 1) / v2 * v2, (v1 + v3 - 1) / v3 * v3);
    }

    @TargetApi(21)
    public Point alignVideoSizeV21(int v, int v1) {
        MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities0 = this.capabilities;
        if(mediaCodecInfo$CodecCapabilities0 == null) {
            return null;
        }
        MediaCodecInfo.VideoCapabilities mediaCodecInfo$VideoCapabilities0 = mediaCodecInfo$CodecCapabilities0.getVideoCapabilities();
        return mediaCodecInfo$VideoCapabilities0 == null ? null : MediaCodecInfo.alignVideoSizeV21(mediaCodecInfo$VideoCapabilities0, v, v1);
    }

    @TargetApi(21)
    private static boolean areSizeAndRateSupportedV21(MediaCodecInfo.VideoCapabilities mediaCodecInfo$VideoCapabilities0, int v, int v1, double f) {
        Point point0 = MediaCodecInfo.alignVideoSizeV21(mediaCodecInfo$VideoCapabilities0, v, v1);
        int v2 = point0.x;
        int v3 = point0.y;
        return f == -1.0 || f < 1.0 ? mediaCodecInfo$VideoCapabilities0.isSizeSupported(v2, v3) : mediaCodecInfo$VideoCapabilities0.areSizeAndRateSupported(v2, v3, Math.floor(f));
    }

    // 去混淆评级： 低(20)
    private static final boolean enableRotatedVerticalResolutionWorkaround(String s) {
        return !"OMX.MTK.VIDEO.DECODER.HEVC".equals(s) || !"mcv5a".equals(Util.DEVICE);
    }

    public int getMaxSupportedInstances() {
        if(Util.SDK_INT >= 23) {
            return this.capabilities == null ? -1 : MediaCodecInfo.getMaxSupportedInstancesV23(this.capabilities);
        }
        return -1;
    }

    @TargetApi(23)
    private static int getMaxSupportedInstancesV23(MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities0) {
        return mediaCodecInfo$CodecCapabilities0.getMaxSupportedInstances();
    }

    public MediaCodecInfo.CodecProfileLevel[] getProfileLevels() {
        MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities0 = this.capabilities;
        if(mediaCodecInfo$CodecCapabilities0 != null) {
            return mediaCodecInfo$CodecCapabilities0.profileLevels == null ? new MediaCodecInfo.CodecProfileLevel[0] : mediaCodecInfo$CodecCapabilities0.profileLevels;
        }
        return new MediaCodecInfo.CodecProfileLevel[0];
    }

    private static boolean isAdaptive(MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities0) {
        return Util.SDK_INT >= 19 && MediaCodecInfo.isAdaptiveV19(mediaCodecInfo$CodecCapabilities0);
    }

    @TargetApi(19)
    private static boolean isAdaptiveV19(MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities0) {
        return mediaCodecInfo$CodecCapabilities0.isFeatureSupported("adaptive-playback");
    }

    @TargetApi(21)
    public boolean isAudioChannelCountSupportedV21(int v) {
        MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities0 = this.capabilities;
        if(mediaCodecInfo$CodecCapabilities0 == null) {
            this.logNoSupport("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities mediaCodecInfo$AudioCapabilities0 = mediaCodecInfo$CodecCapabilities0.getAudioCapabilities();
        if(mediaCodecInfo$AudioCapabilities0 == null) {
            this.logNoSupport("channelCount.aCaps");
            return false;
        }
        int v1 = mediaCodecInfo$AudioCapabilities0.getMaxInputChannelCount();
        if(MediaCodecInfo.adjustMaxInputChannelCount(this.name, this.mimeType, v1) < v) {
            this.logNoSupport("channelCount.support, " + v);
            return false;
        }
        return true;
    }

    @TargetApi(21)
    public boolean isAudioSampleRateSupportedV21(int v) {
        MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities0 = this.capabilities;
        if(mediaCodecInfo$CodecCapabilities0 == null) {
            this.logNoSupport("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities mediaCodecInfo$AudioCapabilities0 = mediaCodecInfo$CodecCapabilities0.getAudioCapabilities();
        if(mediaCodecInfo$AudioCapabilities0 == null) {
            this.logNoSupport("sampleRate.aCaps");
            return false;
        }
        if(!mediaCodecInfo$AudioCapabilities0.isSampleRateSupported(v)) {
            this.logNoSupport("sampleRate.support, " + v);
            return false;
        }
        return true;
    }

    public boolean isCodecSupported(Format format0) {
        String s = format0.codecs;
        if(s != null && this.mimeType != null) {
            String s1 = MimeTypes.getMediaMimeType(s);
            if(s1 == null) {
                return true;
            }
            if(!this.mimeType.equals(s1)) {
                this.logNoSupport("codec.mime " + format0.codecs + ", " + s1);
                return false;
            }
            Pair pair0 = MediaCodecUtil.getCodecProfileAndLevel(format0);
            if(pair0 == null) {
                return true;
            }
            int v = (int)(((Integer)pair0.first));
            int v1 = (int)(((Integer)pair0.second));
            if(!this.isVideo && v != 42) {
                return true;
            }
            MediaCodecInfo.CodecProfileLevel[] arr_mediaCodecInfo$CodecProfileLevel = this.getProfileLevels();
            for(int v2 = 0; v2 < arr_mediaCodecInfo$CodecProfileLevel.length; ++v2) {
                MediaCodecInfo.CodecProfileLevel mediaCodecInfo$CodecProfileLevel0 = arr_mediaCodecInfo$CodecProfileLevel[v2];
                if(mediaCodecInfo$CodecProfileLevel0.profile == v && mediaCodecInfo$CodecProfileLevel0.level >= v1) {
                    return true;
                }
            }
            this.logNoSupport("codec.profileLevel, " + format0.codecs + ", " + s1);
            return false;
        }
        return true;
    }

    public boolean isFormatSupported(Format format0) {
        if(!this.isCodecSupported(format0)) {
            return false;
        }
        if(this.isVideo) {
            int v = format0.width;
            if(v > 0) {
                int v1 = format0.height;
                if(v1 > 0) {
                    if(Util.SDK_INT >= 21) {
                        return this.isVideoSizeAndRateSupportedV21(v, v1, ((double)format0.frameRate));
                    }
                    if(v * v1 <= MediaCodecUtil.maxH264DecodableFrameSize()) {
                        return true;
                    }
                    this.logNoSupport("legacyFrameSize, " + format0.width + "x" + format0.height);
                    return false;
                }
            }
            return true;
        }
        return Util.SDK_INT < 21 || (format0.sampleRate == -1 || this.isAudioSampleRateSupportedV21(format0.sampleRate)) && (format0.channelCount == -1 || this.isAudioChannelCountSupportedV21(format0.channelCount));
    }

    public boolean isHdr10PlusOutOfBandMetadataSupported() {
        if(Util.SDK_INT >= 29 && "video/x-vnd.on2.vp9".equals(this.mimeType)) {
            MediaCodecInfo.CodecProfileLevel[] arr_mediaCodecInfo$CodecProfileLevel = this.getProfileLevels();
            for(int v = 0; v < arr_mediaCodecInfo$CodecProfileLevel.length; ++v) {
                if(arr_mediaCodecInfo$CodecProfileLevel[v].profile == 0x4000) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSeamlessAdaptationSupported(Format format0) {
        if(this.isVideo) {
            return this.adaptive;
        }
        Pair pair0 = MediaCodecUtil.getCodecProfileAndLevel(format0);
        return pair0 != null && ((int)(((Integer)pair0.first))) == 42;
    }

    public boolean isSeamlessAdaptationSupported(Format format0, Format format1, boolean z) {
        if(this.isVideo) {
            return format0.sampleMimeType.equals(format1.sampleMimeType) && format0.rotationDegrees == format1.rotationDegrees && (this.adaptive || format0.width == format1.width && format0.height == format1.height) && (!z && format1.colorInfo == null || Util.areEqual(format0.colorInfo, format1.colorInfo));
        }
        if("audio/mp4a-latm".equals(this.mimeType) && format0.sampleMimeType.equals(format1.sampleMimeType) && format0.channelCount == format1.channelCount && format0.sampleRate == format1.sampleRate) {
            Pair pair0 = MediaCodecUtil.getCodecProfileAndLevel(format0);
            Pair pair1 = MediaCodecUtil.getCodecProfileAndLevel(format1);
            return pair0 != null && pair1 != null && (((int)(((Integer)pair0.first))) == 42 && ((int)(((Integer)pair1.first))) == 42);
        }
        return false;
    }

    private static boolean isSecure(MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities0) {
        return Util.SDK_INT >= 21 && MediaCodecInfo.isSecureV21(mediaCodecInfo$CodecCapabilities0);
    }

    @TargetApi(21)
    private static boolean isSecureV21(MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities0) {
        return mediaCodecInfo$CodecCapabilities0.isFeatureSupported("secure-playback");
    }

    private static boolean isTunneling(MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities0) {
        return Util.SDK_INT >= 21 && MediaCodecInfo.isTunnelingV21(mediaCodecInfo$CodecCapabilities0);
    }

    @TargetApi(21)
    private static boolean isTunnelingV21(MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities0) {
        return mediaCodecInfo$CodecCapabilities0.isFeatureSupported("tunneled-playback");
    }

    @TargetApi(21)
    public boolean isVideoSizeAndRateSupportedV21(int v, int v1, double f) {
        MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities0 = this.capabilities;
        if(mediaCodecInfo$CodecCapabilities0 == null) {
            this.logNoSupport("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities mediaCodecInfo$VideoCapabilities0 = mediaCodecInfo$CodecCapabilities0.getVideoCapabilities();
        if(mediaCodecInfo$VideoCapabilities0 == null) {
            this.logNoSupport("sizeAndRate.vCaps");
            return false;
        }
        if(!MediaCodecInfo.areSizeAndRateSupportedV21(mediaCodecInfo$VideoCapabilities0, v, v1, f)) {
            if(v < v1 && MediaCodecInfo.enableRotatedVerticalResolutionWorkaround(this.name) && MediaCodecInfo.areSizeAndRateSupportedV21(mediaCodecInfo$VideoCapabilities0, v1, v, f)) {
                this.logAssumedSupport("sizeAndRate.rotated, " + v + "x" + v1 + "x" + f);
                return true;
            }
            this.logNoSupport("sizeAndRate.support, " + v + "x" + v1 + "x" + f);
            return false;
        }
        return true;
    }

    private void logAssumedSupport(String s) {
        StringBuilder stringBuilder0 = Z.o(Z.e(Z.e(Z.e(Z.e(25, s), this.name), this.mimeType), Util.DEVICE_DEBUG_INFO), "AssumedSupport [", s, "] [", this.name);
        d.u(stringBuilder0, ", ", this.mimeType, "] [", Util.DEVICE_DEBUG_INFO);
        stringBuilder0.append("]");
        Log.d("MediaCodecInfo", stringBuilder0.toString());
    }

    private void logNoSupport(String s) {
        StringBuilder stringBuilder0 = Z.o(Z.e(Z.e(Z.e(Z.e(20, s), this.name), this.mimeType), Util.DEVICE_DEBUG_INFO), "NoSupport [", s, "] [", this.name);
        d.u(stringBuilder0, ", ", this.mimeType, "] [", Util.DEVICE_DEBUG_INFO);
        stringBuilder0.append("]");
        Log.d("MediaCodecInfo", stringBuilder0.toString());
    }

    public static MediaCodecInfo newInstance(String s, String s1, String s2, MediaCodecInfo.CodecCapabilities mediaCodecInfo$CodecCapabilities0, boolean z, boolean z1, boolean z2, boolean z3, boolean z4) {
        return new MediaCodecInfo(s, s1, s2, mediaCodecInfo$CodecCapabilities0, false, z, z1, z2, z3, z4);
    }

    public static MediaCodecInfo newPassthroughInstance(String s) {
        return new MediaCodecInfo(s, null, null, null, true, false, true, false, false, false);
    }

    @Override
    public String toString() {
        return this.name;
    }
}

