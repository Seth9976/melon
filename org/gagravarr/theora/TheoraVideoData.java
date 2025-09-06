package org.gagravarr.theora;

import org.gagravarr.ogg.OggPacket;
import org.gagravarr.ogg.OggStreamVideoData;

public class TheoraVideoData extends OggStreamVideoData implements TheoraPacket {
    public TheoraVideoData(OggPacket oggPacket0) {
        super(oggPacket0);
    }

    public TheoraVideoData(byte[] arr_b) {
        super(arr_b);
    }
}

