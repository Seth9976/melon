package Ic;

import Cb.j;
import E9.h;
import Na.f;
import com.iloen.melon.net.v4x.response.AlbumSetGradeRes.RESPONSE;
import com.iloen.melon.net.v4x.response.AlbumSetGradeRes;
import com.kakao.tiara.data.ActionKind;
import com.melon.ui.K4;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import ne.a;
import oe.i;
import we.n;

public final class z0 extends i implements n {
    public final float B;
    public int r;
    public final A0 w;

    public z0(A0 a00, float f, Continuation continuation0) {
        this.w = a00;
        this.B = f;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new z0(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((z0)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        A0 a00 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                String s = a00.p();
                this.r = 1;
                object0 = a00.h.O(s, this.B, this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        AlbumSetGradeRes albumSetGradeRes0 = (AlbumSetGradeRes)h.H(((f)object0));
        if(albumSetGradeRes0 != null) {
            j.b(albumSetGradeRes0.notification, false, 3);
            if(j.d(albumSetGradeRes0)) {
                RESPONSE albumSetGradeRes$RESPONSE0 = albumSetGradeRes0.response;
                if(albumSetGradeRes$RESPONSE0 != null) {
                    MutableStateFlow mutableStateFlow0 = a00.v;
                    while(true) {
                        Object object1 = mutableStateFlow0.getValue();
                        K4 k40 = (K4)object1;
                        String s1 = albumSetGradeRes$RESPONSE0.totAvrgScore;
                        String s2 = "";
                        if(s1 == null) {
                            s1 = "";
                        }
                        String s3 = albumSetGradeRes$RESPONSE0.ptcPnmPrco;
                        if(s3 != null) {
                            s2 = s3;
                        }
                        if(mutableStateFlow0.compareAndSet(object1, new y(s1, s2))) {
                            break;
                        }
                    }
                }
                p8.f f0 = a00.h();
                if(f0 != null) {
                    f0.a = a00.b.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                    f0.d = ActionKind.ClickContent;
                    f0.y = a00.b.a(0x7F130DD8);  // string:tiara_common_layer1_album_info "앨범정보"
                    f0.F = a00.b.a(0x7F130D87);  // string:tiara_click_copy_rating "평점주기"
                    f0.o = a00.p();
                    f0.p = a00.b.a(0x7F130EF0);  // string:tiara_meta_type_album "앨범"
                    f0.q = a00.r();
                    f0.a().track();
                }
            }
        }
        return H.a;
    }
}

