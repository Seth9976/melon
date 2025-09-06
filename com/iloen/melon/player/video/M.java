package com.iloen.melon.player.video;

import ie.H;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.q;
import q8.a;
import q8.c;
import we.k;

public final class m implements k {
    public final int a;
    public final String b;
    public final VideoChatFragment c;

    public m(VideoChatFragment videoChatFragment0, String s) {
        this.a = 0;
        super();
        this.c = videoChatFragment0;
        this.b = s;
    }

    public m(String s, VideoChatFragment videoChatFragment0) {
        this.a = 1;
        super();
        this.b = s;
        this.c = videoChatFragment0;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        VideoChatFragment videoChatFragment0 = this.c;
        String s = this.b;
        if(this.a != 0) {
            q.g(((c)object0), "$this$customProps");
            ((c)object0).a(new d(videoChatFragment0, 2));
            LinkedHashMap linkedHashMap0 = ((c)object0).a;
            linkedHashMap0.put("Player Type", videoChatFragment0.f0().getPlayerType());
            if(s != null) {
                linkedHashMap0.put("liketype", s);
            }
            return h0;
        }
        q.g(((a)object0), "$this$click");
        ((a)object0).a = videoChatFragment0.getString(0x7F130DEB);  // string:tiara_common_layer1_chat "채팅창"
        ((a)object0).g = s;
        return h0;
    }
}

