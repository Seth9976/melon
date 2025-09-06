package com.iloen.melon.net.v4x.common;

import H0.b;
import android.content.Context;
import android.text.TextUtils;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.l1;
import com.iloen.melon.types.StringIds;
import com.iloen.melon.utils.log.LogU;
import com.melon.net.res.common.ArtistsInfoBase;
import com.melon.net.res.common.SongInfoBase;
import java.util.LinkedHashMap;
import java.util.List;

public class ProtocolUtils {
    private static final String TAG = "ProtocolUtils";

    // 去混淆评级： 低(20)
    public static String convertStatusToWithdrawYn(String s) {
        return "1".equalsIgnoreCase(s) ? "Y" : "N";
    }

    public static String findArtistImg(List list0, String s) {
        if(list0 != null && !list0.isEmpty() && list0.size() != 0 && s != null) {
            for(Object object0: list0) {
                ArtistsInfoBase artistsInfoBase0 = (ArtistsInfoBase)object0;
                if(artistsInfoBase0.getArtistId().equals(s)) {
                    return artistsInfoBase0.getArtistImg();
                }
                if(false) {
                    break;
                }
            }
            return null;
        }
        LogU.e("ProtocolUtils", "findArtistImg() invalid parameter");
        return null;
    }

    public static String findArtistName(List list0, String s) {
        if(list0 != null && !list0.isEmpty() && list0.size() != 0 && s != null) {
            for(Object object0: list0) {
                ArtistsInfoBase artistsInfoBase0 = (ArtistsInfoBase)object0;
                if(artistsInfoBase0.getArtistId().equals(s)) {
                    return list0.size() == 1 ? artistsInfoBase0.getArtistName() : MelonAppBase.instance.getContext().getString(0x7F1307B5, new Object[]{artistsInfoBase0.getArtistName(), ((int)(list0.size() - 1))});  // string:number_of_except_one_format2 "%1$s 외 %2$d명"
                }
                if(false) {
                    break;
                }
            }
            return null;
        }
        LogU.e("ProtocolUtils", "findArtistName() invalid parameter");
        return null;
    }

    public static String getAmOrPmTime(Context context0, String s) {
        if(!TextUtils.isEmpty(s) && s.length() >= 4) {
            int v = Integer.parseInt(s);
            String s1 = v < 1200 || v >= 2400 ? "오전" : "오후";
            if(TextUtils.equals(s1, "오후") && v >= 1300) {
                s = String.valueOf(Integer.parseInt(s) - 1200);
            }
            else if(TextUtils.equals(s1, "오후") && v >= 1200 && v < 1300) {
                s = String.valueOf(Integer.parseInt(s));
            }
            else if(v == 2400) {
                s = String.valueOf(Integer.parseInt(s) - 2400);
            }
            int v1 = s.length();
            StringBuilder stringBuilder0 = new StringBuilder(s);
            if(TextUtils.isEmpty(s) || v1 < 4) {
                for(int v2 = 0; v2 < 4 - v1; ++v2) {
                    stringBuilder0.insert(v2, "0");
                }
            }
            stringBuilder0.insert(stringBuilder0.length() - 2, ":").insert(0, s1).insert(2, " ");
            return stringBuilder0.toString();
        }
        return "";
    }

    public static StringIds getArtistIds(List list0) {
        if(list0 != null && !list0.isEmpty()) {
            StringIds stringIds0 = new StringIds(list0.size());  // 初始化器: Ljava/util/ArrayList;-><init>(I)V
            for(Object object0: list0) {
                String s = ((ArtistsInfoBase)object0).getArtistId();
                if(s == null) {
                    stringIds0.add("");
                }
                else {
                    stringIds0.add(s);
                }
            }
            return stringIds0;
        }
        LogU.e("ProtocolUtils", "getArtistIds() invalid parameter");
        return StringIds.a;
    }

    public static String getArtistNames(List list0) {
        if(list0 != null && !list0.isEmpty()) {
            if(list0.size() == 1) {
                return ((ArtistsInfoBase)list0.get(0)).getArtistName();
            }
            StringBuilder stringBuilder0 = new StringBuilder();
            for(Object object0: list0) {
                stringBuilder0.append(((ArtistsInfoBase)object0).getArtistName());
                stringBuilder0.append(", ");
            }
            return l1.q(stringBuilder0, 2, 0);
        }
        LogU.e("ProtocolUtils", "getArtistNames() invalid parameter");
        return null;
    }

    public static String getFirstArtistId(List list0) {
        if(list0 != null && !list0.isEmpty() && list0.size() != 0) {
            return ((ArtistsInfoBase)list0.get(0)).getArtistId();
        }
        LogU.e("ProtocolUtils", "getFirstArtistId() invalid parameter");
        return null;
    }

    public static String getFirstArtistImg(List list0) {
        if(list0 != null && !list0.isEmpty() && list0.size() != 0) {
            return ((ArtistsInfoBase)list0.get(0)).getArtistImg();
        }
        LogU.e("ProtocolUtils", "getFirstArtistImg() invalid parameter");
        return null;
    }

    public static String getFirstArtistName(List list0) {
        if(list0 != null && !list0.isEmpty() && list0.size() != 0) {
            return ((ArtistsInfoBase)list0.get(0)).getArtistName();
        }
        LogU.e("ProtocolUtils", "getFirstArtistName() invalid parameter");
        return null;
    }

    public static String getGenreNames(List list0) {
        if(list0 != null && !list0.isEmpty()) {
            if(list0.size() == 1) {
                return ((GenreInfoBase)list0.get(0)).genreName;
            }
            StringBuilder stringBuilder0 = new StringBuilder();
            for(Object object0: list0) {
                stringBuilder0.append(((GenreInfoBase)object0).genreName);
                stringBuilder0.append(", ");
            }
            return l1.q(stringBuilder0, 2, 0);
        }
        LogU.e("ProtocolUtils", "getGenreNames() invalid parameter");
        return null;
    }

    public static String getGenreNamesToSlash(List list0) {
        if(list0 != null && !list0.isEmpty()) {
            if(list0.size() == 1) {
                return ((GenreInfoBase)list0.get(0)).genreName;
            }
            StringBuilder stringBuilder0 = new StringBuilder();
            for(Object object0: list0) {
                stringBuilder0.append(((GenreInfoBase)object0).genreName);
                stringBuilder0.append("/");
            }
            return l1.q(stringBuilder0, 1, 0);
        }
        LogU.e("ProtocolUtils", "getGenreNames() invalid parameter");
        return null;
    }

    public static String getGenrecode(List list0) {
        if(list0 != null && !list0.isEmpty()) {
            if(list0.size() == 1) {
                return ((GenreInfoBase)list0.get(0)).genreCode;
            }
            StringBuilder stringBuilder0 = new StringBuilder();
            for(Object object0: list0) {
                stringBuilder0.append(((GenreInfoBase)object0).genreCode);
                stringBuilder0.append(",");
            }
            return l1.q(stringBuilder0, 1, 0);
        }
        LogU.e("ProtocolUtils", "getGenrecode() invalid parameter");
        return null;
    }

    public static String getSongIds(List list0) {
        if(list0 != null && !list0.isEmpty()) {
            StringBuilder stringBuilder0 = new StringBuilder();
            for(Object object0: list0) {
                SongInfoBase songInfoBase0 = (SongInfoBase)object0;
                if(stringBuilder0.length() >= 1) {
                    stringBuilder0.append(",");
                }
                stringBuilder0.append(songInfoBase0.songId);
            }
            return stringBuilder0.toString();
        }
        LogU.e("ProtocolUtils", "getSongIds() invalid parameter");
        return null;
    }

    public static String getStyleNames(List list0) {
        if(list0 != null && !list0.isEmpty()) {
            if(list0.size() == 1) {
                return ((StyleInfoBase)list0.get(0)).styleName;
            }
            StringBuilder stringBuilder0 = new StringBuilder();
            for(Object object0: list0) {
                stringBuilder0.append(((StyleInfoBase)object0).styleName);
                stringBuilder0.append(", ");
            }
            return l1.q(stringBuilder0, 2, 0);
        }
        LogU.e("ProtocolUtils", "getStyleNames() invalid parameter");
        return null;
    }

    public static LinkedHashMap makeArtistMap(List list0) {
        LinkedHashMap linkedHashMap0 = new LinkedHashMap();
        if(list0 != null) {
            for(Object object0: list0) {
                linkedHashMap0.put(((ArtistsInfoBase)object0).getArtistId(), ((ArtistsInfoBase)object0).getArtistName());
            }
        }
        return linkedHashMap0;
    }

    // 去混淆评级： 低(30)
    public static boolean parseBoolean(String s) {
        return "Y".equalsIgnoreCase(s) || "true".equalsIgnoreCase(s) || "1".equalsIgnoreCase(s);
    }

    public static float parseFloat(String s, long v) {
        try {
            return Float.parseFloat(s.replaceAll(",", ""));
        }
        catch(Exception unused_ex) {
            return (float)v;
        }
    }

    public static int parseInt(String s, int v) {
        try {
            return Integer.parseInt(s.replaceAll(",", ""));
        }
        catch(Exception unused_ex) {
            return v;
        }
    }

    public static long parseLong(String s, long v) {
        try {
            return Long.parseLong(s.replaceAll(",", ""));
        }
        catch(Exception unused_ex) {
            return v;
        }
    }

    public static long parseLongFromPlayTime(String s) {
        try {
            if(TextUtils.isEmpty(s)) {
                s = "0";
            }
            return ((long)Integer.parseInt(s)) * 1000L;
        }
        catch(Exception exception0) {
            b.v(exception0, new StringBuilder("getPlayTime() - e:"), "ProtocolUtils");
            return 0L;
        }
    }
}

