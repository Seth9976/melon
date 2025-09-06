package org.gagravarr.skeleton;

import org.gagravarr.ogg.HighLevelOggStreamPacket;
import org.gagravarr.ogg.IOUtils;
import org.gagravarr.ogg.OggPacket;

public class SkeletonPacketFactory extends HighLevelOggStreamPacket {
    public static SkeletonPacket create(OggPacket oggPacket0) {
        if(SkeletonPacketFactory.isSkeletonSpecial(oggPacket0)) {
            switch(oggPacket0.getData()[3]) {
                case 98: {
                    return new SkeletonFisbone(oggPacket0);
                }
                case 104: {
                    return new SkeletonFishead(oggPacket0);
                }
                default: {
                    return new SkeletonKeyFramePacket(oggPacket0);
                }
            }
        }
        return new SkeletonKeyFramePacket(oggPacket0);
    }

    public static boolean isSkeletonSpecial(OggPacket oggPacket0) {
        byte[] arr_b = oggPacket0.getData();
        if(arr_b.length < 52) {
            return false;
        }
        return IOUtils.byteRangeMatches(SkeletonPacket.MAGIC_FISHEAD_BYTES, arr_b, 0) ? true : IOUtils.byteRangeMatches(SkeletonPacket.MAGIC_FISBONE_BYTES, arr_b, 0);
    }

    public static boolean isSkeletonStream(OggPacket oggPacket0) {
        return oggPacket0.isBeginningOfStream() ? SkeletonPacketFactory.isSkeletonSpecial(oggPacket0) : false;
    }
}

