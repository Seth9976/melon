package org.gagravarr.ogg.audio;

import org.gagravarr.ogg.OggStreamPacket;

public interface OggAudioInfoHeader extends OggStreamPacket {
    String getVersionString();
}

