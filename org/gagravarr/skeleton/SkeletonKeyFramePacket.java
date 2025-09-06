package org.gagravarr.skeleton;

import org.gagravarr.ogg.OggPacket;
import org.gagravarr.ogg.OggStreamAudioData;

public class SkeletonKeyFramePacket extends OggStreamAudioData implements SkeletonPacket {
    public SkeletonKeyFramePacket(OggPacket oggPacket0) {
        super(oggPacket0);
    }

    public SkeletonKeyFramePacket(byte[] arr_b) {
        super(arr_b);
    }
}

