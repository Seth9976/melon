package org.gagravarr.opus;

import org.gagravarr.ogg.OggPacket;
import org.gagravarr.ogg.OggStreamAudioData;

public class OpusAudioData extends OggStreamAudioData implements OpusPacket {
    public OpusAudioData(OggPacket oggPacket0) {
        super(oggPacket0);
    }

    public OpusAudioData(byte[] arr_b) {
        super(arr_b);
    }
}

