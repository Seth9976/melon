package com.iloen.melon.constants;

import android.text.TextUtils;
import com.iloen.melon.utils.log.LogU;
import java.io.Serializable;
import java.util.HashMap;

public class CType implements Serializable {
    public static final CType ALBUM = null;
    @Deprecated
    public static final CType ALBUM2 = null;
    public static final CType ARTIST = null;
    public static final CType CHART_TOP100 = null;
    public static final CType DJ_MALRANG = null;
    public static final CType DRAWER_PLAYLIST = null;
    public static final CType EDU = null;
    public static final CType LIVE = null;
    public static final CType MIX_UP_PLAYLIST = null;
    public static final CType MUSIC_WAVE = null;
    public static final CType MV = null;
    public static final CType PLAYLIST = null;
    public static final CType SERVICE_SCHEME = null;
    public static final CType SONG = null;
    public static final CType STATION = null;
    private static final String TAG = "CType";
    public static final CType THANKSMSG = null;
    public static final CType UNKNOWN = null;
    public static final CType VOICE = null;
    private final boolean isServerType;
    private static HashMap sTypeMap = null;
    private static final long serialVersionUID = 0xC1110E9C9C111F89L;
    private final String value;

    static {
        CType.sTypeMap = new HashMap();
        CType.SONG = new CType("1", true);
        CType.ALBUM = new CType("2", true);
        CType.EDU = new CType("4", true);
        CType.MV = new CType("21", true);
        CType.THANKSMSG = new CType("98", true);
        CType.VOICE = new CType("99", true);
        CType.ALBUM2 = new CType("alb", false);
        CType.ARTIST = new CType("art", false);
        CType.PLAYLIST = new CType("ply", false);
        CType.CHART_TOP100 = new CType("chart_top100", false);
        CType.SERVICE_SCHEME = new CType("service_scheme", false);
        CType.STATION = new CType("station", false);
        CType.LIVE = new CType("live", false);
        CType.DRAWER_PLAYLIST = new CType("ply_smartplylst", false);
        CType.MIX_UP_PLAYLIST = new CType("mixup", false);
        CType.MUSIC_WAVE = new CType("music_wave", false);
        CType.DJ_MALRANG = new CType("simplemode", false);
        CType.UNKNOWN = new CType("", false);
    }

    private CType(String s, boolean z) {
        this.value = s;
        this.isServerType = z;
        CType.sTypeMap.put(s, this);
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(object0 == null) {
            return false;
        }
        if(this.getClass() != object0.getClass()) {
            return false;
        }
        return this.value == null ? ((CType)object0).value == null : this.value.equals(((CType)object0).value);
    }

    public static CType get(String s) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("CType", "get() - invalid value");
            return CType.UNKNOWN;
        }
        CType cType0 = (CType)CType.sTypeMap.get(s);
        return cType0 == null ? CType.UNKNOWN : cType0;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public int hashCode() {
        return this.value == null ? 0x1F : this.value.hashCode() + 0x1F;
    }

    // 去混淆评级： 低(40)
    public static boolean isMusic(CType cType0) {
        return CType.SONG.equals(cType0) || CType.ALBUM.equals(cType0) || CType.EDU.equals(cType0) || CType.PLAYLIST.equals(cType0);
    }

    public boolean isServerType() {
        return this.isServerType;
    }

    public static boolean isValid(CType cType0) {
        return cType0 != null && !cType0.equals(CType.UNKNOWN);
    }

    @Override
    public String toString() {
        return this.value;
    }
}

