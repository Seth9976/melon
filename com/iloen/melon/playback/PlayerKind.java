package com.iloen.melon.playback;

import java.util.HashMap;
import java.util.Map;

@Deprecated(since = "Media3 이후 InstantPlayer, OemMusicPlayer 사용")
public enum PlayerKind {
    Unknown(-1),
    Default(0),
    ExoMusicPlayer(1),
    LeonVideoPlayer(3),
    GoogleCastPlayer(4),
    DlnaPlayer(6),
    OemMusicPlayer(7),
    InstantPlayer(9);

    private static Map map;
    private int value;

    private static PlayerKind[] $values() [...] // Inlined contents

    static {
        PlayerKind.map = new HashMap();
        PlayerKind[] arr_playerKind = (PlayerKind[])PlayerKind.$VALUES.clone();
        for(int v = 0; v < arr_playerKind.length; ++v) {
            PlayerKind playerKind0 = arr_playerKind[v];
            PlayerKind.map.put(playerKind0.value, playerKind0);
        }
    }

    private PlayerKind(int v1) {
        this.value = v1;
    }

    public int getValue() {
        return this.value;
    }

    public static PlayerKind valueOf(int v) {
        return (PlayerKind)PlayerKind.map.get(v);
    }
}

