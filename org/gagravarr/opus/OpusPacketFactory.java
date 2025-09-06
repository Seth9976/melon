package org.gagravarr.opus;

import org.gagravarr.ogg.HighLevelOggStreamPacket;
import org.gagravarr.ogg.IOUtils;
import org.gagravarr.ogg.OggPacket;

public class OpusPacketFactory extends HighLevelOggStreamPacket {
    public static OpusPacket create(OggPacket oggPacket0) {
        if(OpusPacketFactory.isOpusSpecial(oggPacket0)) {
            switch(oggPacket0.getData()[4]) {
                case 72: {
                    return new OpusInfo(oggPacket0);
                }
                case 84: {
                    return new OpusTags(oggPacket0);
                }
                default: {
                    return new OpusAudioData(oggPacket0);
                }
            }
        }
        return new OpusAudioData(oggPacket0);
    }

    public static boolean isOpusSpecial(OggPacket oggPacket0) {
        byte[] arr_b = oggPacket0.getData();
        if(arr_b.length < 12) {
            return false;
        }
        return IOUtils.byteRangeMatches(OpusPacket.MAGIC_HEADER_BYTES, arr_b, 0) ? true : IOUtils.byteRangeMatches(OpusPacket.MAGIC_TAGS_BYTES, arr_b, 0);
    }

    public static boolean isOpusStream(OggPacket oggPacket0) {
        return oggPacket0.isBeginningOfStream() ? OpusPacketFactory.isOpusSpecial(oggPacket0) : false;
    }
}

