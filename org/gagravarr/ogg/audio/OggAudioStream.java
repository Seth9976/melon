package org.gagravarr.ogg.audio;

import org.gagravarr.ogg.OggStreamAudioData;

public interface OggAudioStream {
    OggStreamAudioData getNextAudioPacket();

    void skipToGranule(long arg1);
}

