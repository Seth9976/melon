package com.kakaoent.trevi.ad.util;

import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A,\u0010\u0000\u001A\u001E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001j\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00032\u0006\u0010\u0004\u001A\u00020\u0002H\u0000¨\u0006\u0005"}, d2 = {"jsonStringToHashMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "json", "trevi-ad-android-sdk_release"}, k = 2, mv = {1, 9, 0}, xi = 0x30)
public abstract class JsonUtilKt {
    @NotNull
    public static final HashMap jsonStringToHashMap(@NotNull String s) {
        q.g(s, "json");
        JSONObject jSONObject0 = new JSONObject(s);
        HashMap hashMap0 = new HashMap();
        Iterator iterator0 = jSONObject0.keys();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            String s1 = (String)object0;
            if(s1 != null) {
                String s2 = jSONObject0.optString(s1);
                q.f(s2, "optString(...)");
                hashMap0.put(s1, s2);
            }
        }
        return hashMap0;
    }
}

