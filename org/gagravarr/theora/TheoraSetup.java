package org.gagravarr.theora;

import org.gagravarr.ogg.HighLevelOggStreamPacket;
import org.gagravarr.ogg.OggPacket;

public class TheoraSetup extends HighLevelOggStreamPacket implements TheoraPacket {
    public TheoraSetup() {
    }

    public TheoraSetup(OggPacket oggPacket0) {
        super(oggPacket0);
    }
}

