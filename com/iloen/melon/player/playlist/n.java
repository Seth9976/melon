package com.iloen.melon.player.playlist;

import ie.H;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.q;
import p8.s;
import q8.b;
import q8.c;
import we.k;

public final class n implements k {
    public final int a;
    public final s b;

    public n(s s0, int v) {
        this.a = v;
        this.b = s0;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        String s7;
        switch(this.a) {
            case 0: {
                q.g(((b)object0), "$this$common");
                String s2 = null;
                s s3 = this.b;
                ((b)object0).a = s3 == null ? null : s3.a;
                if(s3 != null) {
                    s2 = s3.b;
                }
                ((b)object0).b = s2;
                return H.a;
            }
            case 1: {
                q.g(((b)object0), "$this$common");
                String s4 = null;
                s s5 = this.b;
                ((b)object0).a = s5 == null ? null : s5.a;
                if(s5 != null) {
                    s4 = s5.b;
                }
                ((b)object0).b = s4;
                return H.a;
            }
            case 2: {
                q.g(((c)object0), "$this$customProps");
                LinkedHashMap linkedHashMap0 = ((c)object0).a;
                s s6 = this.b;
                if(s6 == null) {
                    s7 = "";
                }
                else {
                    s7 = s6.c;
                    if(s7 == null) {
                        s7 = "";
                    }
                }
                linkedHashMap0.put("menuid", s7);
                return H.a;
            }
            default: {
                q.g(((b)object0), "$this$common");
                String s = null;
                s s1 = this.b;
                ((b)object0).a = s1 == null ? null : s1.a;
                if(s1 != null) {
                    s = s1.b;
                }
                ((b)object0).b = s;
                return H.a;
            }
        }
    }
}

