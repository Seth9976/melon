package org.gagravarr.speex;

import org.gagravarr.ogg.OggPacket;
import org.gagravarr.ogg.OggStreamAudioData;

public class SpeexAudioData extends OggStreamAudioData implements SpeexPacket {
    public SpeexAudioData(OggPacket oggPacket0) {
        super(oggPacket0);
    }

    public SpeexAudioData(byte[] arr_b) {
        super(arr_b);
    }
}

