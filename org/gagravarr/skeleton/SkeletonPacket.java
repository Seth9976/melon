package org.gagravarr.skeleton;

import org.gagravarr.ogg.OggStreamPacket;

public interface SkeletonPacket extends OggStreamPacket {
    public static final byte[] MAGIC_FISBONE_BYTES = null;
    public static final String MAGIC_FISBONE_STR = "fisbone\u0000";
    public static final byte[] MAGIC_FISHEAD_BYTES = null;
    public static final String MAGIC_FISHEAD_STR = "fishead\u0000";

    static {
        SkeletonPacket.MAGIC_FISHEAD_BYTES = new byte[]{102, 105, 0x73, 104, 101, 97, 100, 0};
        SkeletonPacket.MAGIC_FISBONE_BYTES = new byte[]{102, 105, 0x73, 98, 0x6F, 110, 101, 0};
    }
}

