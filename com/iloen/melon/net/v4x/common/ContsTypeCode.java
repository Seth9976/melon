package com.iloen.melon.net.v4x.common;

import android.text.TextUtils;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.log.LogU;
import java.util.LinkedHashMap;
import java.util.Map;

public class ContsTypeCode {
    public static final ContsTypeCode ALBUM = null;
    public static final ContsTypeCode ALBUM_MIXUP = null;
    public static final ContsTypeCode ARTIST = null;
    public static final ContsTypeCode ARTIST_MIXUP = null;
    public static final ContsTypeCode ARTIST_PICK = null;
    public static final ContsTypeCode ARTIST_PLAYLIST = null;
    public static final ContsTypeCode ARTIST_PLAYLIST_TAB = null;
    public static final ContsTypeCode AZTALK = null;
    public static final ContsTypeCode BANNER = null;
    public static final ContsTypeCode BRANDDJ = null;
    public static final ContsTypeCode CHART_AGE = null;
    public static final ContsTypeCode COMING_SOON = null;
    public static final ContsTypeCode COMMENT = null;
    public static final ContsTypeCode CONCERT = null;
    public static final ContsTypeCode DJ_MAGINE = null;
    public static final ContsTypeCode DJ_MALRANG = null;
    public static final ContsTypeCode DJ_MELGUN = null;
    public static final ContsTypeCode DJ_PLAYLIST = null;
    public static final ContsTypeCode DJ_PLAYLIST_MIXUP = null;
    public static final ContsTypeCode EVENT = null;
    public static final ContsTypeCode GENRE = null;
    public static final ContsTypeCode GENRE_MIXUP = null;
    public static final ContsTypeCode GOODS = null;
    public static final ContsTypeCode HASHTAG = null;
    public static final ContsTypeCode JUST_SONG = null;
    public static final ContsTypeCode KIDS_THEME_CHARACTER = null;
    public static final ContsTypeCode KIDS_THEME_SONG = null;
    public static final ContsTypeCode KIDS_THEME_VIDEO = null;
    public static final ContsTypeCode LIVE = null;
    public static final ContsTypeCode LYRIC = null;
    public static final ContsTypeCode MAESTRO = null;
    public static final ContsTypeCode MELGUN_PICK = null;
    public static final ContsTypeCode MELON_DJ_BRAND_UPLOAD = null;
    public static final ContsTypeCode MELON_DJ_BRAND_YOUTUBE = null;
    public static final ContsTypeCode MELON_DJ_PAGE_OPEN = null;
    public static final ContsTypeCode MELON_DJ_SERIES = null;
    public static final ContsTypeCode MELON_MAGAZINE = null;
    public static final ContsTypeCode MELON_MAGAZINE_CATEGORY = null;
    public static final ContsTypeCode MELON_RADIO = null;
    public static final ContsTypeCode MIX = null;
    public static final ContsTypeCode MIXMAKER_MIXUP = null;
    public static final ContsTypeCode MIX_PLAYLIST_MIXUP = null;
    public static final ContsTypeCode MUSIC365_ARTIST_RADIO = null;
    public static final ContsTypeCode MUSIC365_GENRE_RADIO = null;
    public static final ContsTypeCode MUSIC_WAVE = null;
    public static final ContsTypeCode MY_MUSIC = null;
    public static final ContsTypeCode NEWS = null;
    public static final ContsTypeCode NOW_PLAYING = null;
    public static final ContsTypeCode OFFERING = null;
    public static final ContsTypeCode PHOTO = null;
    public static final ContsTypeCode PICK_SONG = null;
    public static final ContsTypeCode PLAYLIST = null;
    public static final ContsTypeCode PLAYLIST_MIXUP = null;
    public static final ContsTypeCode RADIO_CAST = null;
    public static final ContsTypeCode RADIO_GENRE = null;
    public static final ContsTypeCode RADIO_LIVE = null;
    public static final ContsTypeCode RADIO_PROGRAM = null;
    public static final ContsTypeCode RADIO_VOICE = null;
    public static final ContsTypeCode SET_LIST = null;
    public static final ContsTypeCode SHORTCUT = null;
    public static final ContsTypeCode SHOWING_VIDEO = null;
    public static final ContsTypeCode SONG = null;
    public static final ContsTypeCode SONGS_MIXUP = null;
    public static final ContsTypeCode SONG_MIXUP = null;
    public static final ContsTypeCode STEADY_SELLER = null;
    public static final ContsTypeCode STORY = null;
    private static final String TAG = "ContsTypeCode";
    public static final ContsTypeCode TEXT;
    public static final ContsTypeCode THANKS_MESSAGE;
    public static final ContsTypeCode THEME;
    public static final ContsTypeCode TICKET;
    public static final ContsTypeCode TOC;
    public static final ContsTypeCode TOPIC;
    public static final ContsTypeCode TRACK_ZERO;
    public static final ContsTypeCode TV_LIVE;
    public static final ContsTypeCode TV_PROGRAM;
    public static final ContsTypeCode TV_THEME;
    public static final ContsTypeCode UNKNOWN;
    public static final ContsTypeCode URL;
    public static final ContsTypeCode USER;
    public static final ContsTypeCode VIDEO;
    public static final ContsTypeCode WAGEURWAGEUL;
    public static final ContsTypeCode WEEKLY_POPULAR_AWARDS;
    private final String mCode;
    private static Map sTypeMap;

    static {
        ContsTypeCode.sTypeMap = new LinkedHashMap();
        ContsTypeCode.UNKNOWN = new ContsTypeCode("");
        ContsTypeCode.SONG = new ContsTypeCode("N10001");
        ContsTypeCode.ALBUM = new ContsTypeCode("N10002");
        ContsTypeCode.VIDEO = new ContsTypeCode("N10003");
        ContsTypeCode.PHOTO = new ContsTypeCode("N10004");
        ContsTypeCode.PLAYLIST = new ContsTypeCode("N10005");
        ContsTypeCode.ARTIST = new ContsTypeCode("N10006");
        ContsTypeCode.MELON_MAGAZINE = new ContsTypeCode("N10007");
        ContsTypeCode.COMING_SOON = new ContsTypeCode("N10008");
        ContsTypeCode.DJ_PLAYLIST = new ContsTypeCode("N10009");
        ContsTypeCode.DJ_MAGINE = new ContsTypeCode("N10010");
        ContsTypeCode.CONCERT = new ContsTypeCode("N10011");
        ContsTypeCode.TOPIC = new ContsTypeCode("N10012");
        ContsTypeCode.TOC = new ContsTypeCode("N10013");
        ContsTypeCode.GOODS = new ContsTypeCode("N10014");
        ContsTypeCode.NEWS = new ContsTypeCode("N10015");
        ContsTypeCode.ARTIST_PLAYLIST = new ContsTypeCode("N10016");
        ContsTypeCode.TV_THEME = new ContsTypeCode("N10017");
        ContsTypeCode.USER = new ContsTypeCode("N10018");
        ContsTypeCode.COMMENT = new ContsTypeCode("N10019");
        ContsTypeCode.MELON_MAGAZINE_CATEGORY = new ContsTypeCode("N10020");
        ContsTypeCode.MELGUN_PICK = new ContsTypeCode("N10021");
        ContsTypeCode.DJ_MELGUN = new ContsTypeCode("N10022");
        ContsTypeCode.MY_MUSIC = new ContsTypeCode("N10023");
        ContsTypeCode.THANKS_MESSAGE = new ContsTypeCode("N10024");
        ContsTypeCode.MELON_RADIO = new ContsTypeCode("N10025");
        ContsTypeCode.AZTALK = new ContsTypeCode("N10026");
        ContsTypeCode.THEME = new ContsTypeCode("N10027");
        ContsTypeCode.SHOWING_VIDEO = new ContsTypeCode("N10028");
        ContsTypeCode.NOW_PLAYING = new ContsTypeCode("N10029");
        ContsTypeCode.HASHTAG = new ContsTypeCode("N10030");
        ContsTypeCode.STORY = new ContsTypeCode("N10031");
        ContsTypeCode.EVENT = new ContsTypeCode("N10032");
        ContsTypeCode.MUSIC365_ARTIST_RADIO = new ContsTypeCode("N10033");
        ContsTypeCode.MUSIC365_GENRE_RADIO = new ContsTypeCode("N10034");
        ContsTypeCode.TICKET = new ContsTypeCode("N10035");
        ContsTypeCode.WEEKLY_POPULAR_AWARDS = new ContsTypeCode("N10036");
        ContsTypeCode.MAESTRO = new ContsTypeCode("N10037");
        ContsTypeCode.STEADY_SELLER = new ContsTypeCode("N10038");
        ContsTypeCode.CHART_AGE = new ContsTypeCode("N10039");
        ContsTypeCode.ARTIST_PLAYLIST_TAB = new ContsTypeCode("N10040");
        ContsTypeCode.LYRIC = new ContsTypeCode("N10041");
        ContsTypeCode.RADIO_VOICE = new ContsTypeCode("N10042");
        ContsTypeCode.TV_LIVE = new ContsTypeCode("N10043");
        ContsTypeCode.TV_PROGRAM = new ContsTypeCode("N10044");
        ContsTypeCode.PICK_SONG = new ContsTypeCode("N10045");
        ContsTypeCode.GENRE = new ContsTypeCode("N10046");
        ContsTypeCode.SET_LIST = new ContsTypeCode("N10052");
        ContsTypeCode.RADIO_GENRE = new ContsTypeCode("N10057");
        ContsTypeCode.JUST_SONG = new ContsTypeCode("N10059");
        ContsTypeCode.KIDS_THEME_CHARACTER = new ContsTypeCode("N10064");
        ContsTypeCode.KIDS_THEME_SONG = new ContsTypeCode("N10065");
        ContsTypeCode.KIDS_THEME_VIDEO = new ContsTypeCode("N10066");
        ContsTypeCode.MELON_DJ_SERIES = new ContsTypeCode("N10074");
        ContsTypeCode.BANNER = new ContsTypeCode("N10075");
        ContsTypeCode.MELON_DJ_BRAND_YOUTUBE = new ContsTypeCode("N10076");
        ContsTypeCode.MELON_DJ_BRAND_UPLOAD = new ContsTypeCode("N10077");
        ContsTypeCode.MIX = new ContsTypeCode("N10078");
        ContsTypeCode.BRANDDJ = new ContsTypeCode("N10080");
        ContsTypeCode.RADIO_LIVE = new ContsTypeCode("N10081");
        ContsTypeCode.RADIO_CAST = new ContsTypeCode("N10082");
        ContsTypeCode.RADIO_PROGRAM = new ContsTypeCode("N10083");
        ContsTypeCode.TRACK_ZERO = new ContsTypeCode("N10087");
        ContsTypeCode.ARTIST_PICK = new ContsTypeCode("N10091");
        ContsTypeCode.LIVE = new ContsTypeCode("N10094");
        ContsTypeCode.MUSIC_WAVE = new ContsTypeCode("N10096");
        ContsTypeCode.WAGEURWAGEUL = new ContsTypeCode("N10098");
        ContsTypeCode.SONG_MIXUP = new ContsTypeCode("N10099");
        ContsTypeCode.ALBUM_MIXUP = new ContsTypeCode("N10100");
        ContsTypeCode.ARTIST_MIXUP = new ContsTypeCode("N10101");
        ContsTypeCode.GENRE_MIXUP = new ContsTypeCode("N10102");
        ContsTypeCode.DJ_PLAYLIST_MIXUP = new ContsTypeCode("N10103");
        ContsTypeCode.MIX_PLAYLIST_MIXUP = new ContsTypeCode("N10104");
        ContsTypeCode.MIXMAKER_MIXUP = new ContsTypeCode("N10105");
        ContsTypeCode.SONGS_MIXUP = new ContsTypeCode("N10106");
        ContsTypeCode.PLAYLIST_MIXUP = new ContsTypeCode("N10113");
        ContsTypeCode.MELON_DJ_PAGE_OPEN = new ContsTypeCode("M40001");
        ContsTypeCode.DJ_MALRANG = new ContsTypeCode("N10110");
        ContsTypeCode.TEXT = new ContsTypeCode("TEXT");
        ContsTypeCode.SHORTCUT = new ContsTypeCode("SHORTCUT");
        ContsTypeCode.OFFERING = new ContsTypeCode("OFFERING");
        ContsTypeCode.URL = new ContsTypeCode("URL");
    }

    public ContsTypeCode(String s) {
        this.mCode = s;
        ContsTypeCode.sTypeMap.put(s, this);
    }

    public String code() {
        return this.mCode;
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(!(object0 instanceof ContsTypeCode)) {
            return false;
        }
        String s = ((ContsTypeCode)object0).mCode;
        return s != null && s.equals(this.mCode);
    }

    // 去混淆评级： 低(27)
    public static String getAccessibilityName(String s) {
        MelonAppBase.instance.getContext();
        if(!"N10001".equals(s) && !"N10099".equals(s)) {
            if(!"N10002".equals(s) && !"N10100".equals(s)) {
                if(!"N10003".equals(s) && !"N10028".equals(s)) {
                    if("N10004".equals(s)) {
                        return "포토";
                    }
                    if(!"N10005".equals(s) && !"N10009".equals(s) && !"N10016".equals(s) && !"N10113".equals(s)) {
                        ContsTypeCode contsTypeCode0 = ContsTypeCode.MIX_PLAYLIST_MIXUP;
                        if(!"N10104".equals(s) && !"N10103".equals(s)) {
                            if(!"N10006".equals(s) && !"N10101".equals(s)) {
                                if("N10007".equals(s)) {
                                    return "매거진";
                                }
                                if(!"N10082".equals(s) && !"N10083".equals(s)) {
                                    if("N10011".equals(s)) {
                                        return "콘서트";
                                    }
                                    return "N10078".equals(s) || contsTypeCode0.code().equals(s) ? "믹스" : "";
                                }
                                return "스테이션";
                            }
                            return "아티스트";
                        }
                    }
                    return "플레이리스트";
                }
                return "비디오";
            }
            return "앨범";
        }
        return "곡";
    }

    @Override
    public int hashCode() {
        return this.mCode == null ? 0x20F : this.mCode.hashCode() + 0x20F;
    }

    @Override
    public String toString() {
        return this.mCode;
    }

    public static ContsTypeCode valueOf(int v) {
        if(v <= 0) {
            LogU.w("ContsTypeCode", "valueOf() invalid int code");
            return ContsTypeCode.UNKNOWN;
        }
        String s = String.format("%03s", v);
        for(Object object0: ContsTypeCode.sTypeMap.values()) {
            ContsTypeCode contsTypeCode0 = (ContsTypeCode)object0;
            if(contsTypeCode0.mCode.endsWith(s)) {
                return contsTypeCode0;
            }
            if(false) {
                break;
            }
        }
        return ContsTypeCode.UNKNOWN;
    }

    public static ContsTypeCode valueOf(String s) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("ContsTypeCode", "valueOf() invalid string code");
            return ContsTypeCode.UNKNOWN;
        }
        ContsTypeCode contsTypeCode0 = (ContsTypeCode)ContsTypeCode.sTypeMap.get(s);
        return contsTypeCode0 == null ? ContsTypeCode.UNKNOWN : contsTypeCode0;
    }
}

