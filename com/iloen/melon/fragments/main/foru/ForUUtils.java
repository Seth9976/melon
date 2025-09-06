package com.iloen.melon.fragments.main.foru;

import android.content.Context;
import android.text.TextUtils;
import com.iloen.melon.net.v6x.response.ForUMixInfoBase;
import com.iloen.melon.responsecache.a;
import com.iloen.melon.utils.StringUtils;
import java.util.ArrayList;

public class ForUUtils {
    public static final String FORU_MIX_COVER_CACHE_KEY = "FORU_MIX_COVER_CACHE_KEY";
    public static final int NICKNAME_MAX_SIZE = 6;

    public static String convertToShortNickname(String s, int v) {
        return StringUtils.getTrimmed(s, v + 1);
    }

    public static String getFirstUrlInList(ArrayList arrayList0) {
        return arrayList0 == null || arrayList0.size() <= 0 ? null : ((String)arrayList0.get(0));
    }

    public static String replaceNicknameWithMarkup(String s, String s1, String s2) [...] // 潜在的解密器

    public static String replaceNicknameWithMarkup(String s, String s1, String s2, int v) {
        if(!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1)) {
            return TextUtils.isEmpty(s2) ? s.replace(s1, "") : s.replace(s1, ForUUtils.convertToShortNickname(s2, v));
        }
        return "";
    }

    public static String saveTemplateCoverToCache(Context context0, ForUMixInfoBase forUMixInfoBase0) {
        if(context0 != null && forUMixInfoBase0 != null) {
            a.a(context0, forUMixInfoBase0, "FORU_MIX_COVER_CACHE_KEY");
            return "FORU_MIX_COVER_CACHE_KEY";
        }
        return null;
    }
}

