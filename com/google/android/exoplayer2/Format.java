package com.google.android.exoplayer2;

import A7.d;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import b3.Z;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.ColorInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Format implements Parcelable {
    public static final Parcelable.Creator CREATOR = null;
    public static final int NO_VALUE = -1;
    public static final long OFFSET_SAMPLE_RELATIVE = 0x7FFFFFFFFFFFFFFFL;
    public final int accessibilityChannel;
    public final int bitrate;
    public final int channelCount;
    public final String codecs;
    public final ColorInfo colorInfo;
    public final String containerMimeType;
    public final DrmInitData drmInitData;
    public final int encoderDelay;
    public final int encoderPadding;
    public final Class exoMediaCryptoType;
    public final float frameRate;
    private int hashCode;
    public final int height;
    public final String id;
    public final List initializationData;
    public final String label;
    public final String language;
    public final int maxInputSize;
    public final Metadata metadata;
    public final int pcmEncoding;
    public final float pixelWidthHeightRatio;
    public final byte[] projectionData;
    public final int roleFlags;
    public final int rotationDegrees;
    public final String sampleMimeType;
    public final int sampleRate;
    public final int selectionFlags;
    public final int stereoMode;
    public final long subsampleOffsetUs;
    public final int width;

    static {
        Format.CREATOR = new Parcelable.Creator() {
            public Format createFromParcel(Parcel parcel0) {
                return new Format(parcel0);
            }

            @Override  // android.os.Parcelable$Creator
            public Object createFromParcel(Parcel parcel0) {
                return this.createFromParcel(parcel0);
            }

            public Format[] newArray(int v) {
                return new Format[v];
            }

            @Override  // android.os.Parcelable$Creator
            public Object[] newArray(int v) {
                return this.newArray(v);
            }
        };
    }

    public Format(Parcel parcel0) {
        this.id = parcel0.readString();
        this.label = parcel0.readString();
        this.selectionFlags = parcel0.readInt();
        this.roleFlags = parcel0.readInt();
        this.bitrate = parcel0.readInt();
        this.codecs = parcel0.readString();
        this.metadata = (Metadata)parcel0.readParcelable(Metadata.class.getClassLoader());
        this.containerMimeType = parcel0.readString();
        this.sampleMimeType = parcel0.readString();
        this.maxInputSize = parcel0.readInt();
        int v = parcel0.readInt();
        this.initializationData = new ArrayList(v);
        for(int v1 = 0; v1 < v; ++v1) {
            byte[] arr_b = parcel0.createByteArray();
            this.initializationData.add(arr_b);
        }
        this.drmInitData = (DrmInitData)parcel0.readParcelable(DrmInitData.class.getClassLoader());
        this.subsampleOffsetUs = parcel0.readLong();
        this.width = parcel0.readInt();
        this.height = parcel0.readInt();
        this.frameRate = parcel0.readFloat();
        this.rotationDegrees = parcel0.readInt();
        this.pixelWidthHeightRatio = parcel0.readFloat();
        this.projectionData = Util.readBoolean(parcel0) ? parcel0.createByteArray() : null;
        this.stereoMode = parcel0.readInt();
        this.colorInfo = (ColorInfo)parcel0.readParcelable(ColorInfo.class.getClassLoader());
        this.channelCount = parcel0.readInt();
        this.sampleRate = parcel0.readInt();
        this.pcmEncoding = parcel0.readInt();
        this.encoderDelay = parcel0.readInt();
        this.encoderPadding = parcel0.readInt();
        this.language = parcel0.readString();
        this.accessibilityChannel = parcel0.readInt();
        this.exoMediaCryptoType = null;
    }

    public Format(String s, String s1, int v, int v1, int v2, String s2, Metadata metadata0, String s3, String s4, int v3, List list0, DrmInitData drmInitData0, long v4, int v5, int v6, float f, int v7, float f1, byte[] arr_b, int v8, ColorInfo colorInfo0, int v9, int v10, int v11, int v12, int v13, String s5, int v14, Class class0) {
        this.id = s;
        this.label = s1;
        this.selectionFlags = v;
        this.roleFlags = v1;
        this.bitrate = v2;
        this.codecs = s2;
        this.metadata = metadata0;
        this.containerMimeType = s3;
        this.sampleMimeType = s4;
        this.maxInputSize = v3;
        if(list0 == null) {
            list0 = Collections.EMPTY_LIST;
        }
        this.initializationData = list0;
        this.drmInitData = drmInitData0;
        this.subsampleOffsetUs = v4;
        this.width = v5;
        this.height = v6;
        this.frameRate = f;
        int v15 = 0;
        this.rotationDegrees = v7 == -1 ? 0 : v7;
        this.pixelWidthHeightRatio = f1 == -1.0f ? 1.0f : f1;
        this.projectionData = arr_b;
        this.stereoMode = v8;
        this.colorInfo = colorInfo0;
        this.channelCount = v9;
        this.sampleRate = v10;
        this.pcmEncoding = v11;
        this.encoderDelay = v12 == -1 ? 0 : v12;
        if(v13 != -1) {
            v15 = v13;
        }
        this.encoderPadding = v15;
        this.language = Util.normalizeLanguageCode(s5);
        this.accessibilityChannel = v14;
        this.exoMediaCryptoType = class0;
    }

    public Format copyWithAdjustments(DrmInitData drmInitData0, Metadata metadata0) {
        return drmInitData0 != this.drmInitData || metadata0 != this.metadata ? new Format(this.id, this.label, this.selectionFlags, this.roleFlags, this.bitrate, this.codecs, metadata0, this.containerMimeType, this.sampleMimeType, this.maxInputSize, this.initializationData, drmInitData0, this.subsampleOffsetUs, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.language, this.accessibilityChannel, this.exoMediaCryptoType) : this;
    }

    public Format copyWithBitrate(int v) {
        return new Format(this.id, this.label, this.selectionFlags, this.roleFlags, v, this.codecs, this.metadata, this.containerMimeType, this.sampleMimeType, this.maxInputSize, this.initializationData, this.drmInitData, this.subsampleOffsetUs, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.language, this.accessibilityChannel, this.exoMediaCryptoType);
    }

    public Format copyWithContainerInfo(String s, String s1, String s2, String s3, Metadata metadata0, int v, int v1, int v2, int v3, int v4, String s4) {
        Metadata metadata1 = this.metadata;
        if(metadata1 != null) {
            Metadata metadata2 = metadata1.copyWithAppendedEntriesFrom(metadata0);
            return new Format(s, s1, v4, this.roleFlags, v, s3, metadata2, this.containerMimeType, s2, this.maxInputSize, this.initializationData, this.drmInitData, this.subsampleOffsetUs, v1, v2, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, v3, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, s4, this.accessibilityChannel, this.exoMediaCryptoType);
        }
        return new Format(s, s1, v4, this.roleFlags, v, s3, metadata0, this.containerMimeType, s2, this.maxInputSize, this.initializationData, this.drmInitData, this.subsampleOffsetUs, v1, v2, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, v3, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, s4, this.accessibilityChannel, this.exoMediaCryptoType);
    }

    public Format copyWithDrmInitData(DrmInitData drmInitData0) {
        return this.copyWithAdjustments(drmInitData0, this.metadata);
    }

    public Format copyWithExoMediaCryptoType(Class class0) {
        return new Format(this.id, this.label, this.selectionFlags, this.roleFlags, this.bitrate, this.codecs, this.metadata, this.containerMimeType, this.sampleMimeType, this.maxInputSize, this.initializationData, this.drmInitData, this.subsampleOffsetUs, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.language, this.accessibilityChannel, class0);
    }

    public Format copyWithFrameRate(float f) {
        return new Format(this.id, this.label, this.selectionFlags, this.roleFlags, this.bitrate, this.codecs, this.metadata, this.containerMimeType, this.sampleMimeType, this.maxInputSize, this.initializationData, this.drmInitData, this.subsampleOffsetUs, this.width, this.height, f, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.language, this.accessibilityChannel, this.exoMediaCryptoType);
    }

    public Format copyWithGaplessInfo(int v, int v1) {
        return new Format(this.id, this.label, this.selectionFlags, this.roleFlags, this.bitrate, this.codecs, this.metadata, this.containerMimeType, this.sampleMimeType, this.maxInputSize, this.initializationData, this.drmInitData, this.subsampleOffsetUs, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, v, v1, this.language, this.accessibilityChannel, this.exoMediaCryptoType);
    }

    public Format copyWithLabel(String s) {
        return new Format(this.id, s, this.selectionFlags, this.roleFlags, this.bitrate, this.codecs, this.metadata, this.containerMimeType, this.sampleMimeType, this.maxInputSize, this.initializationData, this.drmInitData, this.subsampleOffsetUs, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.language, this.accessibilityChannel, this.exoMediaCryptoType);
    }

    public Format copyWithManifestFormatInfo(Format format0) {
        String s7;
        String s4;
        if(this == format0) {
            return this;
        }
        int v = MimeTypes.getTrackType(this.sampleMimeType);
        String s = format0.id;
        String s1 = format0.label == null ? this.label : format0.label;
        String s2 = this.language;
        if(v != 1 && v != 3) {
            s4 = s2;
        }
        else {
            String s3 = format0.language;
            s4 = s3 == null ? s2 : s3;
        }
        int v1 = this.bitrate == -1 ? format0.bitrate : this.bitrate;
        String s5 = this.codecs;
        if(s5 == null) {
            String s6 = Util.getCodecsOfType(format0.codecs, v);
            s7 = Util.splitCodecs(s6).length == 1 ? s6 : null;
        }
        else {
            s7 = s5;
        }
        Metadata metadata0 = this.metadata == null ? format0.metadata : this.metadata.copyWithAppendedEntriesFrom(format0.metadata);
        DrmInitData drmInitData0 = DrmInitData.createSessionCreationData(format0.drmInitData, this.drmInitData);
        return new Format(s, s1, this.selectionFlags | format0.selectionFlags, this.roleFlags | format0.roleFlags, v1, s7, metadata0, this.containerMimeType, this.sampleMimeType, this.maxInputSize, this.initializationData, drmInitData0, this.subsampleOffsetUs, this.width, this.height, (this.frameRate != -1.0f || v != 2 ? this.frameRate : format0.frameRate), this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, s4, this.accessibilityChannel, this.exoMediaCryptoType);
    }

    public Format copyWithMaxInputSize(int v) {
        return new Format(this.id, this.label, this.selectionFlags, this.roleFlags, this.bitrate, this.codecs, this.metadata, this.containerMimeType, this.sampleMimeType, v, this.initializationData, this.drmInitData, this.subsampleOffsetUs, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.language, this.accessibilityChannel, this.exoMediaCryptoType);
    }

    public Format copyWithMetadata(Metadata metadata0) {
        return this.copyWithAdjustments(this.drmInitData, metadata0);
    }

    public Format copyWithRotationDegrees(int v) {
        return new Format(this.id, this.label, this.selectionFlags, this.roleFlags, this.bitrate, this.codecs, this.metadata, this.containerMimeType, this.sampleMimeType, this.maxInputSize, this.initializationData, this.drmInitData, this.subsampleOffsetUs, this.width, this.height, this.frameRate, v, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.language, this.accessibilityChannel, this.exoMediaCryptoType);
    }

    public Format copyWithSubsampleOffsetUs(long v) {
        return new Format(this.id, this.label, this.selectionFlags, this.roleFlags, this.bitrate, this.codecs, this.metadata, this.containerMimeType, this.sampleMimeType, this.maxInputSize, this.initializationData, this.drmInitData, v, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.language, this.accessibilityChannel, this.exoMediaCryptoType);
    }

    public Format copyWithVideoSize(int v, int v1) {
        return new Format(this.id, this.label, this.selectionFlags, this.roleFlags, this.bitrate, this.codecs, this.metadata, this.containerMimeType, this.sampleMimeType, this.maxInputSize, this.initializationData, this.drmInitData, this.subsampleOffsetUs, v, v1, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.language, this.accessibilityChannel, this.exoMediaCryptoType);
    }

    @Deprecated
    public static Format createAudioContainerFormat(String s, String s1, String s2, String s3, int v, int v1, int v2, List list0, int v3, String s4) {
        return Format.createAudioContainerFormat(s, null, s1, s2, s3, null, v, v1, v2, list0, v3, 0, s4);
    }

    public static Format createAudioContainerFormat(String s, String s1, String s2, String s3, String s4, Metadata metadata0, int v, int v1, int v2, List list0, int v3, int v4, String s5) {
        return new Format(s, s1, v3, v4, v, s4, metadata0, s2, s3, -1, list0, null, 0x7FFFFFFFFFFFFFFFL, -1, -1, -1.0f, -1, -1.0f, null, -1, null, v1, v2, -1, -1, -1, s5, -1, null);
    }

    public static Format createAudioSampleFormat(String s, String s1, String s2, int v, int v1, int v2, int v3, int v4, int v5, int v6, List list0, DrmInitData drmInitData0, int v7, String s3, Metadata metadata0) {
        return new Format(s, null, v7, 0, v, s2, metadata0, null, s1, v1, list0, drmInitData0, 0x7FFFFFFFFFFFFFFFL, -1, -1, -1.0f, -1, -1.0f, null, -1, null, v2, v3, v4, v5, v6, s3, -1, null);
    }

    public static Format createAudioSampleFormat(String s, String s1, String s2, int v, int v1, int v2, int v3, int v4, List list0, DrmInitData drmInitData0, int v5, String s3) {
        return Format.createAudioSampleFormat(s, s1, s2, v, v1, v2, v3, v4, -1, -1, list0, drmInitData0, v5, s3, null);
    }

    public static Format createAudioSampleFormat(String s, String s1, String s2, int v, int v1, int v2, int v3, List list0, DrmInitData drmInitData0, int v4, String s3) {
        return Format.createAudioSampleFormat(s, s1, s2, v, v1, v2, v3, -1, list0, drmInitData0, v4, s3);
    }

    @Deprecated
    public static Format createContainerFormat(String s, String s1, String s2, String s3, int v, int v1, String s4) {
        return Format.createContainerFormat(s, null, s1, s2, s3, v, v1, 0, s4);
    }

    public static Format createContainerFormat(String s, String s1, String s2, String s3, String s4, int v, int v1, int v2, String s5) {
        return new Format(s, s1, v1, v2, v, s4, null, s2, s3, -1, null, null, 0x7FFFFFFFFFFFFFFFL, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, s5, -1, null);
    }

    public static Format createImageSampleFormat(String s, String s1, String s2, int v, int v1, List list0, String s3, DrmInitData drmInitData0) {
        return new Format(s, null, v1, 0, v, s2, null, null, s1, -1, list0, drmInitData0, 0x7FFFFFFFFFFFFFFFL, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, s3, -1, null);
    }

    public static Format createSampleFormat(String s, String s1, long v) {
        return new Format(s, null, 0, 0, -1, null, null, null, s1, -1, null, null, v, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, null, -1, null);
    }

    public static Format createSampleFormat(String s, String s1, String s2, int v, DrmInitData drmInitData0) {
        return new Format(s, null, 0, 0, v, s2, null, null, s1, -1, null, drmInitData0, 0x7FFFFFFFFFFFFFFFL, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, null, -1, null);
    }

    public static Format createTextContainerFormat(String s, String s1, String s2, String s3, String s4, int v, int v1, int v2, String s5) {
        return Format.createTextContainerFormat(s, s1, s2, s3, s4, v, v1, v2, s5, -1);
    }

    public static Format createTextContainerFormat(String s, String s1, String s2, String s3, String s4, int v, int v1, int v2, String s5, int v3) {
        return new Format(s, s1, v1, v2, v, s4, null, s2, s3, -1, null, null, 0x7FFFFFFFFFFFFFFFL, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, s5, v3, null);
    }

    public static Format createTextSampleFormat(String s, String s1, int v, String s2) {
        return Format.createTextSampleFormat(s, s1, v, s2, null);
    }

    public static Format createTextSampleFormat(String s, String s1, int v, String s2, DrmInitData drmInitData0) {
        return Format.createTextSampleFormat(s, s1, null, -1, v, s2, -1, drmInitData0, 0x7FFFFFFFFFFFFFFFL, Collections.EMPTY_LIST);
    }

    public static Format createTextSampleFormat(String s, String s1, String s2, int v, int v1, String s3, int v2, DrmInitData drmInitData0) {
        return Format.createTextSampleFormat(s, s1, s2, v, v1, s3, v2, drmInitData0, 0x7FFFFFFFFFFFFFFFL, Collections.EMPTY_LIST);
    }

    public static Format createTextSampleFormat(String s, String s1, String s2, int v, int v1, String s3, int v2, DrmInitData drmInitData0, long v3, List list0) {
        return new Format(s, null, v1, 0, v, s2, null, null, s1, -1, list0, drmInitData0, v3, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, s3, v2, null);
    }

    public static Format createTextSampleFormat(String s, String s1, String s2, int v, int v1, String s3, DrmInitData drmInitData0, long v2) {
        return Format.createTextSampleFormat(s, s1, s2, v, v1, s3, -1, drmInitData0, v2, Collections.EMPTY_LIST);
    }

    @Deprecated
    public static Format createVideoContainerFormat(String s, String s1, String s2, String s3, int v, int v1, int v2, float f, List list0, int v3) {
        return Format.createVideoContainerFormat(s, null, s1, s2, s3, null, v, v1, v2, f, list0, v3, 0);
    }

    public static Format createVideoContainerFormat(String s, String s1, String s2, String s3, String s4, Metadata metadata0, int v, int v1, int v2, float f, List list0, int v3, int v4) {
        return new Format(s, s1, v3, v4, v, s4, metadata0, s2, s3, -1, list0, null, 0x7FFFFFFFFFFFFFFFL, v1, v2, f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, null, -1, null);
    }

    public static Format createVideoSampleFormat(String s, String s1, String s2, int v, int v1, int v2, int v3, float f, List list0, int v4, float f1, DrmInitData drmInitData0) {
        return Format.createVideoSampleFormat(s, s1, s2, v, v1, v2, v3, f, list0, v4, f1, null, -1, null, drmInitData0);
    }

    public static Format createVideoSampleFormat(String s, String s1, String s2, int v, int v1, int v2, int v3, float f, List list0, int v4, float f1, byte[] arr_b, int v5, ColorInfo colorInfo0, DrmInitData drmInitData0) {
        return new Format(s, null, 0, 0, v, s2, null, null, s1, v1, list0, drmInitData0, 0x7FFFFFFFFFFFFFFFL, v2, v3, f, v4, f1, arr_b, v5, colorInfo0, -1, -1, -1, -1, -1, null, -1, null);
    }

    public static Format createVideoSampleFormat(String s, String s1, String s2, int v, int v1, int v2, int v3, float f, List list0, DrmInitData drmInitData0) {
        return Format.createVideoSampleFormat(s, s1, s2, v, v1, v2, v3, f, list0, -1, -1.0f, drmInitData0);
    }

    @Override  // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 != null) {
            Class class0 = object0.getClass();
            if(Format.class == class0) {
                Format format0 = (Format)object0;
                return this.hashCode == 0 || (format0.hashCode == 0 || this.hashCode == format0.hashCode) ? this.selectionFlags == format0.selectionFlags && this.roleFlags == format0.roleFlags && this.bitrate == format0.bitrate && this.maxInputSize == format0.maxInputSize && this.subsampleOffsetUs == format0.subsampleOffsetUs && this.width == format0.width && this.height == format0.height && this.rotationDegrees == format0.rotationDegrees && this.stereoMode == format0.stereoMode && this.channelCount == format0.channelCount && this.sampleRate == format0.sampleRate && this.pcmEncoding == format0.pcmEncoding && this.encoderDelay == format0.encoderDelay && this.encoderPadding == format0.encoderPadding && this.accessibilityChannel == format0.accessibilityChannel && Float.compare(this.frameRate, format0.frameRate) == 0 && Float.compare(this.pixelWidthHeightRatio, format0.pixelWidthHeightRatio) == 0 && Util.areEqual(this.exoMediaCryptoType, format0.exoMediaCryptoType) && Util.areEqual(this.id, format0.id) && Util.areEqual(this.label, format0.label) && Util.areEqual(this.codecs, format0.codecs) && Util.areEqual(this.containerMimeType, format0.containerMimeType) && Util.areEqual(this.sampleMimeType, format0.sampleMimeType) && Util.areEqual(this.language, format0.language) && Arrays.equals(this.projectionData, format0.projectionData) && Util.areEqual(this.metadata, format0.metadata) && Util.areEqual(this.colorInfo, format0.colorInfo) && Util.areEqual(this.drmInitData, format0.drmInitData) && this.initializationDataEquals(format0) : false;
            }
        }
        return false;
    }

    public int getPixelCount() {
        int v = this.width;
        if(v != -1) {
            return this.height == -1 ? -1 : v * this.height;
        }
        return -1;
    }

    @Override
    public int hashCode() {
        if(this.hashCode == 0) {
            int v = 0;
            int v1 = (((((((((Float.floatToIntBits(this.pixelWidthHeightRatio) + ((Float.floatToIntBits(this.frameRate) + ((((((((((((((this.id == null ? 0 : this.id.hashCode()) + 0x20F) * 0x1F + (this.label == null ? 0 : this.label.hashCode())) * 0x1F + this.selectionFlags) * 0x1F + this.roleFlags) * 0x1F + this.bitrate) * 0x1F + (this.codecs == null ? 0 : this.codecs.hashCode())) * 0x1F + (this.metadata == null ? 0 : this.metadata.hashCode())) * 0x1F + (this.containerMimeType == null ? 0 : this.containerMimeType.hashCode())) * 0x1F + (this.sampleMimeType == null ? 0 : this.sampleMimeType.hashCode())) * 0x1F + this.maxInputSize) * 0x1F + ((int)this.subsampleOffsetUs)) * 0x1F + this.width) * 0x1F + this.height) * 0x1F) * 0x1F + this.rotationDegrees) * 0x1F) * 0x1F + this.stereoMode) * 0x1F + this.channelCount) * 0x1F + this.sampleRate) * 0x1F + this.pcmEncoding) * 0x1F + this.encoderDelay) * 0x1F + this.encoderPadding) * 0x1F + (this.language == null ? 0 : this.language.hashCode())) * 0x1F + this.accessibilityChannel) * 0x1F;
            Class class0 = this.exoMediaCryptoType;
            if(class0 != null) {
                v = class0.hashCode();
            }
            this.hashCode = v1 + v;
        }
        return this.hashCode;
    }

    public boolean initializationDataEquals(Format format0) {
        if(this.initializationData.size() != format0.initializationData.size()) {
            return false;
        }
        for(int v = 0; v < this.initializationData.size(); ++v) {
            if(!Arrays.equals(((byte[])this.initializationData.get(v)), ((byte[])format0.initializationData.get(v)))) {
                return false;
            }
        }
        return true;
    }

    public static String toLogString(Format format0) {
        if(format0 == null) {
            return "null";
        }
        StringBuilder stringBuilder0 = new StringBuilder("id=");
        stringBuilder0.append(format0.id);
        stringBuilder0.append(", mimeType=");
        stringBuilder0.append(format0.sampleMimeType);
        if(format0.bitrate != -1) {
            stringBuilder0.append(", bitrate=");
            stringBuilder0.append(format0.bitrate);
        }
        if(format0.codecs != null) {
            stringBuilder0.append(", codecs=");
            stringBuilder0.append(format0.codecs);
        }
        if(format0.width != -1 && format0.height != -1) {
            stringBuilder0.append(", res=");
            stringBuilder0.append(format0.width);
            stringBuilder0.append("x");
            stringBuilder0.append(format0.height);
        }
        if(format0.frameRate != -1.0f) {
            stringBuilder0.append(", fps=");
            stringBuilder0.append(format0.frameRate);
        }
        if(format0.channelCount != -1) {
            stringBuilder0.append(", channels=");
            stringBuilder0.append(format0.channelCount);
        }
        if(format0.sampleRate != -1) {
            stringBuilder0.append(", sample_rate=");
            stringBuilder0.append(format0.sampleRate);
        }
        if(format0.language != null) {
            stringBuilder0.append(", language=");
            stringBuilder0.append(format0.language);
        }
        if(format0.label != null) {
            stringBuilder0.append(", label=");
            stringBuilder0.append(format0.label);
        }
        return stringBuilder0.toString();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = Z.o(Z.e(Z.e(Z.e(Z.e(Z.e(Z.e(104, this.id), this.label), this.containerMimeType), this.sampleMimeType), this.codecs), this.language), "Format(", this.id, ", ", this.label);
        d.u(stringBuilder0, ", ", this.containerMimeType, ", ", this.sampleMimeType);
        stringBuilder0.append(", ");
        stringBuilder0.append(this.codecs);
        stringBuilder0.append(", ");
        stringBuilder0.append(this.bitrate);
        stringBuilder0.append(", ");
        stringBuilder0.append(this.language);
        stringBuilder0.append(", [");
        stringBuilder0.append(this.width);
        stringBuilder0.append(", ");
        stringBuilder0.append(this.height);
        stringBuilder0.append(", ");
        stringBuilder0.append(this.frameRate);
        stringBuilder0.append("], [");
        stringBuilder0.append(this.channelCount);
        stringBuilder0.append(", ");
        stringBuilder0.append(this.sampleRate);
        stringBuilder0.append("])");
        return stringBuilder0.toString();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeString(this.id);
        parcel0.writeString(this.label);
        parcel0.writeInt(this.selectionFlags);
        parcel0.writeInt(this.roleFlags);
        parcel0.writeInt(this.bitrate);
        parcel0.writeString(this.codecs);
        boolean z = false;
        parcel0.writeParcelable(this.metadata, 0);
        parcel0.writeString(this.containerMimeType);
        parcel0.writeString(this.sampleMimeType);
        parcel0.writeInt(this.maxInputSize);
        int v1 = this.initializationData.size();
        parcel0.writeInt(v1);
        for(int v2 = 0; v2 < v1; ++v2) {
            parcel0.writeByteArray(((byte[])this.initializationData.get(v2)));
        }
        parcel0.writeParcelable(this.drmInitData, 0);
        parcel0.writeLong(this.subsampleOffsetUs);
        parcel0.writeInt(this.width);
        parcel0.writeInt(this.height);
        parcel0.writeFloat(this.frameRate);
        parcel0.writeInt(this.rotationDegrees);
        parcel0.writeFloat(this.pixelWidthHeightRatio);
        if(this.projectionData != null) {
            z = true;
        }
        Util.writeBoolean(parcel0, z);
        byte[] arr_b = this.projectionData;
        if(arr_b != null) {
            parcel0.writeByteArray(arr_b);
        }
        parcel0.writeInt(this.stereoMode);
        parcel0.writeParcelable(this.colorInfo, v);
        parcel0.writeInt(this.channelCount);
        parcel0.writeInt(this.sampleRate);
        parcel0.writeInt(this.pcmEncoding);
        parcel0.writeInt(this.encoderDelay);
        parcel0.writeInt(this.encoderPadding);
        parcel0.writeString(this.language);
        parcel0.writeInt(this.accessibilityChannel);
    }
}

