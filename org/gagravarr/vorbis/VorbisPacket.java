package org.gagravarr.vorbis;

import org.gagravarr.ogg.OggStreamPacket;

public interface VorbisPacket extends OggStreamPacket {
    public static final int HEADER_LENGTH_AUDIO = 0;
    public static final int HEADER_LENGTH_METADATA = 7;
    public static final int TYPE_COMMENTS = 3;
    public static final int TYPE_INFO = 1;
    public static final int TYPE_SETUP = 5;

    int getHeaderSize();

    void populateMetadataHeader(byte[] arg1, int arg2);
}

