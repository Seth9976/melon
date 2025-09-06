package com.iloen.melon.playback;

import com.iloen.melon.MelonAppBase;
import java.io.Serializable;

public class PlayerPOCHelper {
    public static final class POCValue implements Serializable {
        public final String cpId;
        public final String cpKey;
        private static final long serialVersionUID = 0xBE88F2AC43DDDFB5L;

        public POCValue(String s, String s1) {
            this.cpId = s;
            this.cpKey = s1;
        }
    }

    public static final POCValue getPOCValue(PlayerKind playerKind0) {
        synchronized(PlayerPOCHelper.class) {
            if(PlayerKind.GoogleCastPlayer.equals(playerKind0)) {
                return new POCValue(MelonAppBase.instance.getMelonCpId(), "CHRMCAST");
            }
            return PlayerKind.DlnaPlayer.equals(playerKind0) ? new POCValue(MelonAppBase.instance.getMelonCpId(), "DLNA") : new POCValue(MelonAppBase.instance.getMelonCpId(), MelonAppBase.instance.getMelonCpKey());
        }
    }
}

