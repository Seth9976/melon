package org.gagravarr.theora;

import org.gagravarr.ogg.HighLevelOggStreamPacket;
import org.gagravarr.ogg.IOUtils;
import org.gagravarr.ogg.OggPacket;

public class TheoraPacketFactory extends HighLevelOggStreamPacket {
    public static TheoraPacket create(OggPacket oggPacket0) {
        int v = oggPacket0.getData()[0];
        if(TheoraPacketFactory.isTheoraSpecial(oggPacket0)) {
            switch(v) {
                case 0xFFFFFF80: {
                    return new TheoraInfo(oggPacket0);
                }
                case 0xFFFFFF81: {
                    return new TheoraComments(oggPacket0);
                }
                case 0xFFFFFF82: {
                    return new TheoraSetup(oggPacket0);
                }
                default: {
                    return new TheoraVideoData(oggPacket0);
                }
            }
        }
        return new TheoraVideoData(oggPacket0);
    }

    public static boolean isTheoraSpecial(OggPacket oggPacket0) {
        byte[] arr_b = oggPacket0.getData();
        if(arr_b.length < 16) {
            return false;
        }
        switch(arr_b[0]) {
            case 0xFFFFFF80: 
            case 0xFFFFFF81: 
            case 0xFFFFFF82: {
                return arr_b[1] == 0x74 && arr_b[2] == 104 && arr_b[3] == 101 && arr_b[4] == 0x6F && arr_b[5] == 0x72 && arr_b[6] == 97;
            }
            default: {
                return false;
            }
        }
    }

    public static boolean isTheoraStream(OggPacket oggPacket0) {
        return oggPacket0.isBeginningOfStream() ? TheoraPacketFactory.isTheoraSpecial(oggPacket0) : false;
    }

    public static void populateMetadataHeader(byte[] arr_b, int v, int v1) {
        arr_b[0] = IOUtils.fromInt(v);
        arr_b[1] = 0x74;
        arr_b[2] = 104;
        arr_b[3] = 101;
        arr_b[4] = 0x6F;
        arr_b[5] = 0x72;
        arr_b[6] = 97;
    }
}

