package o3;

import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo;

public interface t {
    boolean d(String arg1, MediaCodecInfo.CodecCapabilities arg2);

    int getCodecCount();

    MediaCodecInfo getCodecInfoAt(int arg1);

    boolean isFeatureSupported(String arg1, String arg2, MediaCodecInfo.CodecCapabilities arg3);

    boolean secureDecodersExplicit();
}

