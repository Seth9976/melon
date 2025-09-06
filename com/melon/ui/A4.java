package com.melon.ui;

import Cb.j;
import E9.h;
import Na.f;
import com.iloen.melon.custom.ToReceiverView.Receiver;
import com.iloen.melon.fragments.musicmessage.MusicMessageEditorFragment;
import com.iloen.melon.net.v6x.response.MusicMessageInsertMusicMsgRes;
import com.melon.ui.interfaces.StringProviderImpl;
import ie.H;
import java.util.ArrayList;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.k;
import we.n;

public final class a4 extends i implements n {
    public final kotlin.jvm.internal.n B;
    public final n4 D;
    public final boolean E;
    public int r;
    public final N3 w;

    public a4(N3 n30, k k0, n4 n40, boolean z, Continuation continuation0) {
        this.w = n30;
        this.B = (kotlin.jvm.internal.n)k0;
        this.D = n40;
        this.E = z;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new a4(this.w, ((k)this.B), this.D, this.E, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((a4)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Object object1;
        n4 n40 = this.D;
        StringProviderImpl stringProviderImpl0 = n40.c;
        a a0 = a.a;
        kotlin.jvm.internal.n n0 = this.B;
        H h0 = H.a;
        N3 n30 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                ArrayList arrayList0 = ((B3)n30).a;
                if(arrayList0 == null) {
                    return h0;
                }
                if(arrayList0.isEmpty()) {
                    ((k)n0).invoke(new q4(28, stringProviderImpl0.a(0x7F1300D0), stringProviderImpl0.a(0x7F13087E), null, null));  // string:alert_dlg_title_info "안내"
                    return h0;
                }
                if(Receiver.e(((B3)n30).a)) {
                    ((k)n0).invoke(new q4(28, stringProviderImpl0.a(0x7F1300D0), stringProviderImpl0.a(0x7F130472), null, null));  // string:alert_dlg_title_info "안내"
                    return h0;
                }
                if(((B3)n30).b == null) {
                    return h0;
                }
                String s = Receiver.b(((B3)n30).a);
                q.f(s, "getMemberKeys(...)");
                String s1 = ((B3)n30).b.getContsTypeCode().code();
                q.f(s1, "code(...)");
                String s2 = ((B3)n30).b.getContentId();
                q.f(s2, "getContentId(...)");
                this.r = 1;
                object1 = n40.a.d(s, s1, s2, this);
                if(object1 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                object1 = object0;
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        MusicMessageInsertMusicMsgRes musicMessageInsertMusicMsgRes0 = (MusicMessageInsertMusicMsgRes)h.H(((f)object1));
        if(musicMessageInsertMusicMsgRes0 != null) {
            j.b(musicMessageInsertMusicMsgRes0.notification, false, 3);
            if(j.d(musicMessageInsertMusicMsgRes0) && musicMessageInsertMusicMsgRes0.response != null) {
                if(!this.E) {
                    ((k)n0).invoke(s4.a);
                    return h0;
                }
                MusicMessageEditorFragment.Companion.newInstance(((B3)n30).a, null, null).open();
            }
            return h0;
        }
        ((k)n0).invoke(new t4(stringProviderImpl0.a(0x7F1303C6)));  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
        return h0;
    }
}

