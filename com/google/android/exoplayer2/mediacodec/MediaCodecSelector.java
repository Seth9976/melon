package com.google.android.exoplayer2.mediacodec;

import java.util.List;

public interface MediaCodecSelector {
    public static final MediaCodecSelector DEFAULT;

    static {
        MediaCodecSelector.DEFAULT = new MediaCodecSelector() {
            @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecSelector
            public List getDecoderInfos(String s, boolean z, boolean z1) {
                return MediaCodecUtil.getDecoderInfos(s, z, z1);
            }

            @Override  // com.google.android.exoplayer2.mediacodec.MediaCodecSelector
            public MediaCodecInfo getPassthroughDecoderInfo() {
                return MediaCodecUtil.getPassthroughDecoderInfo();
            }
        };
    }

    List getDecoderInfos(String arg1, boolean arg2, boolean arg3);

    MediaCodecInfo getPassthroughDecoderInfo();
}

