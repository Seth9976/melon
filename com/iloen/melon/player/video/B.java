package com.iloen.melon.player.video;

import A9.f;
import A9.g;
import J9.e;
import b3.Z;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v6x.response.LiveTimedMetaSongRes.RESPONSE;
import com.iloen.melon.player.video.chat.ChatUi.ChatView;
import com.iloen.melon.player.video.chat.ChatUi.ErrorView;
import com.iloen.melon.player.video.chat.ChatUi.Type;
import we.q;

public final class b implements q {
    public final int a;

    public b(int v) {
        this.a = v;
        super();
    }

    @Override  // we.q
    public final Object invoke(Object object0, Object object1, Object object2, Object object3, Object object4) {
        boolean z = true;
        switch(this.a) {
            case 0: {
                if(((Boolean)object4).booleanValue() || !((Boolean)object0).booleanValue() || !((Boolean)object1).booleanValue() || ((Boolean)object2).booleanValue() || ((Boolean)object3).booleanValue()) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
            case 1: {
                kotlin.jvm.internal.q.g(((VideoStatus)object0), "videoStatus");
                if(((VideoStatus)object0) == VideoStatus.FullScreen && !((Boolean)object1).booleanValue() && !((Boolean)object2).booleanValue() && !((Boolean)object3).booleanValue() && !((Boolean)object4).booleanValue()) {
                    RESPONSE liveTimedMetaSongRes$RESPONSE0 = (RESPONSE)f.h.getValue();
                    return (liveTimedMetaSongRes$RESPONSE0 == null ? null : g.a(liveTimedMetaSongRes$RESPONSE0)) == null ? false : true;
                }
                return false;
            }
            case 2: {
                kotlin.jvm.internal.q.g(((VideoStatus)object1), "videoStatus");
                if(((VideoStatus)object1) != VideoStatus.FullScreen || !((Boolean)object0).booleanValue() || ((Boolean)object2).booleanValue() || ((Boolean)object3).booleanValue() || ((Boolean)object4).booleanValue()) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
            default: {
                boolean z1 = ((Boolean)object0).booleanValue();
                boolean z2 = ((Boolean)object1).booleanValue();
                boolean z3 = ((Boolean)object3).booleanValue();
                kotlin.jvm.internal.q.g(((String)object2), "_chatState");
                kotlin.jvm.internal.q.g(((e)object4), "_freezeType");
                if(((String)object2).equals("FAILED")) {
                    String s = Z.m(MelonAppBase.Companion, 0x7F13061F, "getString(...)");  // string:melon_tv_live_chat_network_error "일시적인 서비스 장애로 채팅 연결이 불가합니다.\n잠시 후 재진입해주세요."
                    kotlin.jvm.internal.q.f("일시적인 서비스 장애로 채팅 연결이 불가합니다.", "getString(...)");
                    return new ErrorView(Type.CONNECTION_FAILED, s, "일시적인 서비스 장애로 채팅 연결이 불가합니다.");
                }
                if(!z1) {
                    String s1 = Z.m(MelonAppBase.Companion, 0x7F130621, "getString(...)");  // string:melon_tv_live_chat_not_avail "채팅이 지원되지 않는 라이브입니다."
                    return new ErrorView(Type.NO_CHAT, s1, null, 4, null);
                }
                if(!z2) {
                    return new ChatView(Type.UNAUTHORIZED_USER, false);
                }
                if(z3) {
                    return new ChatView(Type.BAN, false);
                }
                return ((e)object4) == e.a ? new ChatView(Type.FREEZING, false) : new ChatView(Type.NONE, true);
            }
        }
    }
}

