package org.gagravarr.ogg.audio;

import org.gagravarr.ogg.OggStreamIdentifier.OggStreamType;

public interface OggAudioHeaders {
    OggAudioInfoHeader getInfo();

    OggAudioSetupHeader getSetup();

    int getSid();

    OggAudioTagsHeader getTags();

    OggStreamType getType();
}

