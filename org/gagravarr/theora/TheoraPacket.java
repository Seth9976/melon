package org.gagravarr.theora;

import org.gagravarr.ogg.OggStreamPacket;

public interface TheoraPacket extends OggStreamPacket {
    public static final int TYPE_COMMENTS = 0x81;
    public static final int TYPE_IDENTIFICATION = 0x80;
    public static final int TYPE_SETUP = 130;

}

