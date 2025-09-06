package com.iloen.melon.player.playlist;

import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.playback.Playable;
import ie.H;
import k8.Y;
import kotlin.jvm.internal.q;
import q8.f;
import we.k;

public final class m implements k {
    public final int a;
    public final Playable b;

    public m(int v, Playable playable0) {
        this.a = v;
        this.b = playable0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        H h0 = H.a;
        Playable playable0 = this.b;
        String s = null;
        switch(this.a) {
            case 0: {
                q.g(((f)object0), "$this$eventMeta");
                ((f)object0).a = playable0 == null ? null : "";
                ((f)object0).b = Y.i(ContsTypeCode.SONG, "code(...)");
                if(playable0 != null) {
                    s = "";
                }
                ((f)object0).c = s;
                return h0;
            }
            case 1: {
                q.g(((f)object0), "$this$pageMeta");
                ((f)object0).a = playable0 == null ? null : "";
                ((f)object0).b = Y.i(ContsTypeCode.SONG, "code(...)");
                if(playable0 != null) {
                    s = "";
                }
                ((f)object0).c = s;
                return h0;
            }
            case 2: {
                q.g(((f)object0), "$this$eventMeta");
                ((f)object0).a = playable0 == null ? null : "";
                ((f)object0).b = Y.i(ContsTypeCode.SONG, "code(...)");
                if(playable0 != null) {
                    s = "";
                }
                ((f)object0).c = s;
                return h0;
            }
            default: {
                q.g(((f)object0), "$this$pageMeta");
                ((f)object0).a = playable0 == null ? null : "";
                ((f)object0).b = Y.i(ContsTypeCode.SONG, "code(...)");
                if(playable0 != null) {
                    s = "";
                }
                ((f)object0).c = s;
                return h0;
            }
        }
    }
}

