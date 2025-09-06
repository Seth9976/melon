package org.gagravarr.speex;

import org.gagravarr.ogg.OggStreamPacket;

public interface SpeexPacket extends OggStreamPacket {
    public static final byte[] MAGIC_HEADER_BYTES = null;
    public static final String MAGIC_HEADER_STR = "Speex   ";

    static {
        SpeexPacket.MAGIC_HEADER_BYTES = new byte[]{83, 0x70, 101, 101, 120, 0x20, 0x20, 0x20};
    }
}

