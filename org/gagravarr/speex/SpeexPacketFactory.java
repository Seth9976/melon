package org.gagravarr.speex;

import org.gagravarr.ogg.HighLevelOggStreamPacket;
import org.gagravarr.ogg.IOUtils;
import org.gagravarr.ogg.OggPacket;

public class SpeexPacketFactory extends HighLevelOggStreamPacket {
    public static SpeexPacket create(OggPacket oggPacket0) {
        if(SpeexPacketFactory.isSpeexSpecial(oggPacket0)) {
            return new SpeexInfo(oggPacket0);
        }
        return oggPacket0.getSequenceNumber() == 1 && oggPacket0.getGranulePosition() == 0L ? new SpeexTags(oggPacket0) : new SpeexAudioData(oggPacket0);
    }

    public static boolean isSpeexSpecial(OggPacket oggPacket0) {
        byte[] arr_b = oggPacket0.getData();
        return arr_b.length >= 72 ? IOUtils.byteRangeMatches(SpeexPacket.MAGIC_HEADER_BYTES, arr_b, 0) : false;
    }

    public static boolean isSpeexStream(OggPacket oggPacket0) {
        return oggPacket0.isBeginningOfStream() ? SpeexPacketFactory.isSpeexSpecial(oggPacket0) : false;
    }
}

