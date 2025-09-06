package com.iloen.melon.player.video.chat;

import Tf.n;
import Tf.v;
import com.iloen.melon.net.v6x.response.LiveChatRes.Response.CHATSDKINFO.USER;
import com.iloen.melon.player.playlist.common.h;
import com.kakaoent.leonchat.data.messages.ArtistMessageEntity;
import com.kakaoent.leonchat.data.messages.UserMessageEntity;
import e1.u;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e0;
import va.o;

@Metadata(d1 = {"\u0000\u001A\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001A\n\u0010\u0000\u001A\u00020\u0001*\u00020\u0001\u001A\n\u0010\u0002\u001A\u00020\u0003*\u00020\u0001\u001A\f\u0010\u0004\u001A\u00020\u0001*\u0004\u0018\u00010\u0001\u001A\n\u0010\u0005\u001A\u00020\u0003*\u00020\u0006\u001A\n\u0010\u0005\u001A\u00020\u0003*\u00020\u0007¨\u0006\b"}, d2 = {"executeBlindWord", "", "isIncludeBlockWord", "", "replaceSpaceToNbsp", "isMyMessage", "Lcom/kakaoent/leonchat/data/messages/UserMessageEntity;", "Lcom/kakaoent/leonchat/data/messages/ArtistMessageEntity;", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class VideoChatHelperKt {
    @NotNull
    public static final String executeBlindWord(@NotNull String s) {
        q.g(s, "<this>");
        return new n("<blind>(.+?)</blind>").d(s, new h(18));
    }

    public static final boolean isIncludeBlockWord(@NotNull String s) {
        q.g(s, "<this>");
        Pattern pattern0 = Pattern.compile("<block>(.+?)</block>");
        q.f(pattern0, "compile(...)");
        return pattern0.matcher(s).find();
    }

    public static final boolean isMyMessage(@NotNull ArtistMessageEntity artistMessageEntity0) {
        q.g(artistMessageEntity0, "<this>");
        Map map0 = artistMessageEntity0.e().a();
        String s = null;
        Object object0 = map0 == null ? null : map0.get("melonUser");
        USER liveChatRes$Response$CHATSDKINFO$USER0 = (USER)new com.google.gson.n().e(new com.google.gson.n().k(object0), USER.class);
        if(liveChatRes$Response$CHATSDKINFO$USER0 != null) {
            s = liveChatRes$Response$CHATSDKINFO$USER0.memberkey;
        }
        return q.b(s, u.v(((e0)o.a()).j()));
    }

    public static final boolean isMyMessage(@NotNull UserMessageEntity userMessageEntity0) {
        q.g(userMessageEntity0, "<this>");
        Map map0 = userMessageEntity0.e().a();
        String s = null;
        Object object0 = map0 == null ? null : map0.get("melonUser");
        USER liveChatRes$Response$CHATSDKINFO$USER0 = (USER)new com.google.gson.n().e(new com.google.gson.n().k(object0), USER.class);
        if(liveChatRes$Response$CHATSDKINFO$USER0 != null) {
            s = liveChatRes$Response$CHATSDKINFO$USER0.memberkey;
        }
        return q.b(s, u.v(((e0)o.a()).j()));
    }

    @NotNull
    public static final String replaceSpaceToNbsp(@Nullable String s) {
        return s == null ? "" : v.p0(s, " ", " ");
    }
}

