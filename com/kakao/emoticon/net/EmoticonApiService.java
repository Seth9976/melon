package com.kakao.emoticon.net;

import com.kakao.emoticon.controller.EmoticonManager;
import com.kakao.emoticon.net.response.EmoticonConfig;
import com.kakao.emoticon.net.response.EmoticonResourceAuth;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vg.c;
import vg.e;
import vg.f;
import vg.o;
import vg.s;
import vg.t;
import vg.u;
import vg.y;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001D\u0010\u0005\u001A\u00020\u00042\b\b\u0001\u0010\u0003\u001A\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\b\u001A\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001D\u0010\f\u001A\u00020\u000B2\b\b\u0001\u0010\n\u001A\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0006J\u001D\u0010\u000F\u001A\u00020\u000E2\b\b\u0001\u0010\r\u001A\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u000F\u0010\u0006J\u001D\u0010\u0012\u001A\u00020\u00112\b\b\u0001\u0010\u0010\u001A\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0006J5\u0010\u0015\u001A\u00020\u00112\b\b\u0001\u0010\u0010\u001A\u00020\u00022\u0016\b\u0003\u0010\u0014\u001A\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0013H§@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/kakao/emoticon/net/EmoticonApiService;", "", "", "include", "Lcom/kakao/emoticon/net/response/MyItems;", "getMyItem", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/kakao/emoticon/net/response/EmoticonConfig;", "getConfig", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logs", "Lie/H;", "sendEmoticonLog", "itemId", "Lcom/kakao/emoticon/net/response/EmoticonInfo;", "getEmoticonInfo", "url", "Lokhttp3/ResponseBody;", "downloadFileWithDynamicUrl", "", "authQuery", "downloadEmoticonResource", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public interface EmoticonApiService {
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static Object downloadEmoticonResource$default(EmoticonApiService emoticonApiService0, String s, Map map0, Continuation continuation0, int v, Object object0) {
            if(object0 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: downloadEmoticonResource");
            }
            if((v & 2) != 0) {
                EmoticonConfig emoticonConfig0 = EmoticonManager.INSTANCE.getEmoticonConfig();
                if(emoticonConfig0 != null) {
                    EmoticonResourceAuth emoticonResourceAuth0 = emoticonConfig0.getResourceAuth();
                    if(emoticonResourceAuth0 != null) {
                        return emoticonApiService0.downloadEmoticonResource(s, emoticonResourceAuth0.getToQueryMap(), continuation0);
                    }
                }
                map0 = null;
            }
            return emoticonApiService0.downloadEmoticonResource(s, map0, continuation0);
        }
    }

    @Nullable
    @f
    Object downloadEmoticonResource(@NotNull @y String arg1, @Nullable @u Map arg2, @NotNull Continuation arg3);

    @Nullable
    @f
    Object downloadFileWithDynamicUrl(@NotNull @y String arg1, @NotNull Continuation arg2);

    @NeedAuth
    @Nullable
    @f("api/sdk/config")
    Object getConfig(@NotNull Continuation arg1);

    @NeedAuth
    @Nullable
    @f("api/sdk/store/items/{itemId}")
    Object getEmoticonInfo(@NotNull @s("itemId") String arg1, @NotNull Continuation arg2);

    @NeedAuth
    @Nullable
    @f("api/sdk/items")
    Object getMyItem(@NotNull @t("include") String arg1, @NotNull Continuation arg2);

    @NeedAuth
    @Nullable
    @e
    @o("api/sdk/logs")
    Object sendEmoticonLog(@NotNull @c("logs") String arg1, @NotNull Continuation arg2);
}

