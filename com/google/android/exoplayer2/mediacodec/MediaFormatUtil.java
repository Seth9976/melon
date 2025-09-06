package com.google.android.exoplayer2.mediacodec;

import android.media.MediaFormat;
import com.google.android.exoplayer2.video.ColorInfo;
import java.nio.ByteBuffer;
import java.util.List;

public final class MediaFormatUtil {
    public static void maybeSetByteBuffer(MediaFormat mediaFormat0, String s, byte[] arr_b) {
        if(arr_b != null) {
            mediaFormat0.setByteBuffer(s, ByteBuffer.wrap(arr_b));
        }
    }

    public static void maybeSetColorInfo(MediaFormat mediaFormat0, ColorInfo colorInfo0) {
        if(colorInfo0 != null) {
            MediaFormatUtil.maybeSetInteger(mediaFormat0, "color-transfer", colorInfo0.colorTransfer);
            MediaFormatUtil.maybeSetInteger(mediaFormat0, "color-standard", colorInfo0.colorSpace);
            MediaFormatUtil.maybeSetInteger(mediaFormat0, "color-range", colorInfo0.colorRange);
            MediaFormatUtil.maybeSetByteBuffer(mediaFormat0, "hdr-static-info", colorInfo0.hdrStaticInfo);
        }
    }

    public static void maybeSetFloat(MediaFormat mediaFormat0, String s, float f) {
        if(f != -1.0f) {
            mediaFormat0.setFloat(s, f);
        }
    }

    public static void maybeSetInteger(MediaFormat mediaFormat0, String s, int v) {
        if(v != -1) {
            mediaFormat0.setInteger(s, v);
        }
    }

    public static void setCsdBuffers(MediaFormat mediaFormat0, List list0) {
        for(int v = 0; v < list0.size(); ++v) {
            mediaFormat0.setByteBuffer("csd-" + v, ByteBuffer.wrap(((byte[])list0.get(v))));
        }
    }

    public static void setString(MediaFormat mediaFormat0, String s, String s1) {
        mediaFormat0.setString(s, s1);
    }
}

