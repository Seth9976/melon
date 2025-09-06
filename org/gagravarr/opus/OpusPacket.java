package org.gagravarr.opus;

import org.gagravarr.ogg.OggStreamPacket;

public interface OpusPacket extends OggStreamPacket {
    public static final byte[] MAGIC_HEADER_BYTES = null;
    public static final String MAGIC_HEADER_STR = "OpusHead";
    public static final byte[] MAGIC_TAGS_BYTES = null;
    public static final String MAGIC_TAGS_STR = "OpusTags";

    static {
        OpusPacket.MAGIC_HEADER_BYTES = new byte[]{0x4F, 0x70, 0x75, 0x73, 72, 101, 97, 100};
        OpusPacket.MAGIC_TAGS_BYTES = new byte[]{0x4F, 0x70, 0x75, 0x73, 84, 97, 103, 0x73};
    }
}

