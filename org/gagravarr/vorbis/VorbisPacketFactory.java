package org.gagravarr.vorbis;

import org.gagravarr.ogg.IOUtils;
import org.gagravarr.ogg.OggPacket;

public class VorbisPacketFactory {
    public static VorbisPacket create(OggPacket oggPacket0) {
        if(VorbisPacketFactory.isVorbisSpecial(oggPacket0)) {
            switch(oggPacket0.getData()[0]) {
                case 1: {
                    return new VorbisInfo(oggPacket0);
                }
                case 3: {
                    return new VorbisComments(oggPacket0);
                }
                case 5: {
                    return new VorbisSetup(oggPacket0);
                }
                default: {
                    return new VorbisAudioData(oggPacket0);
                }
            }
        }
        return new VorbisAudioData(oggPacket0);
    }

    public static boolean isVorbisSpecial(OggPacket oggPacket0) {
        byte[] arr_b = oggPacket0.getData();
        if(arr_b.length < 16) {
            return false;
        }
        switch(arr_b[0]) {
            case 1: 
            case 3: 
            case 5: {
                return arr_b[1] == 0x76 && arr_b[2] == 0x6F && arr_b[3] == 0x72 && arr_b[4] == 98 && arr_b[5] == 105 && arr_b[6] == 0x73;
            }
            default: {
                return false;
            }
        }
    }

    public static boolean isVorbisStream(OggPacket oggPacket0) {
        return oggPacket0.isBeginningOfStream() ? VorbisPacketFactory.isVorbisSpecial(oggPacket0) : false;
    }

    public static void populateMetadataHeader(byte[] arr_b, int v, int v1) {
        arr_b[0] = IOUtils.fromInt(v);
        arr_b[1] = 0x76;
        arr_b[2] = 0x6F;
        arr_b[3] = 0x72;
        arr_b[4] = 98;
        arr_b[5] = 105;
        arr_b[6] = 0x73;
    }
}

