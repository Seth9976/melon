package b9;

import A8.k;
import A8.l;
import Cb.j;
import R6.c;
import androidx.fragment.app.I;
import androidx.fragment.app.W;
import androidx.fragment.app.l0;
import com.iloen.melon.LoginUser;
import com.iloen.melon.net.HttpResponse.Notification;
import com.iloen.melon.net.v4x.response.KakaoConnIdCheckRes;
import com.iloen.melon.utils.log.LogU;
import com.kakao.emoticon.interfaces.EmoticonClickListener;
import com.kakao.emoticon.ui.PopupEmoticonFragment;
import ie.H;
import ie.o;
import ie.p;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import mb.f;
import ne.a;
import oe.i;
import va.e0;
import va.e;
import we.n;

public final class b extends i implements n {
    public final EmoticonClickListener B;
    public int r;
    public final d w;

    public b(d d0, EmoticonClickListener emoticonClickListener0, Continuation continuation0) {
        this.w = d0;
        this.B = emoticonClickListener0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new b(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((b)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Object object1;
        Object object2;
        d d0 = this.w;
        f f0 = d0.c;
        a a0 = a.a;
        H h0 = H.a;
        Notification httpResponse$Notification0 = null;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                LoginUser loginUser0 = ((e0)d0.b).j();
                l l0 = f0.a.c();
                this.r = 1;
                object2 = d0.d.c(k.a, loginUser0, l0, this);
                if(object2 != a0) {
                label_23:
                    d0.g = true;
                    if(((Na.f)object2) instanceof Na.d) {
                        LogU.error$default(d0.a, e.b("checkConnect failed with error: ", ((Na.d)(((Na.f)object2))).a.getMessage()), null, false, 6, null);
                        return h0;
                    }
                    Na.e e0 = ((Na.f)object2) instanceof Na.e ? ((Na.e)(((Na.f)object2))) : null;
                    KakaoConnIdCheckRes kakaoConnIdCheckRes0 = e0 == null ? null : ((KakaoConnIdCheckRes)e0.a);
                    if(kakaoConnIdCheckRes0 == null || !j.d(kakaoConnIdCheckRes0)) {
                        if(kakaoConnIdCheckRes0 != null) {
                            httpResponse$Notification0 = kakaoConnIdCheckRes0.notification;
                        }
                        j.b(httpResponse$Notification0, false, 3);
                        this.r = 2;
                        if(f0.d(this) != a0) {
                            return h0;
                        }
                    }
                    else {
                        this.r = 3;
                        object1 = f0.a(this);
                        if(object1 != a0) {
                        label_33:
                            if(!(object1 instanceof o)) {
                                if(d0.f != null && d0.f.isVisible()) {
                                    return h0;
                                }
                                x9.a a1 = new x9.a(this.B, d0);
                                c c0 = new c(21);
                                d0.f = PopupEmoticonFragment.Companion.newInstance(a1, c0);
                                I i0 = d0.e;
                                if(i0 == null) {
                                    return h0;
                                }
                                l0 l00 = i0.getChildFragmentManager();
                                if(l00 == null) {
                                    return h0;
                                }
                                b9.c c1 = new b9.c();  // 初始化器: Ljava/lang/Object;-><init>()V
                                l00.p.getClass();
                                W w0 = new W(c1);
                                ((CopyOnWriteArrayList)l00.p.b).add(w0);
                                PopupEmoticonFragment popupEmoticonFragment0 = d0.f;
                                if(popupEmoticonFragment0 == null) {
                                    return h0;
                                }
                                popupEmoticonFragment0.show(l00, "KakaoEmoticonPopupManager");
                                return h0;
                            }
                            this.r = 4;
                            if(f0.d(this) != a0) {
                            label_52:
                                l0 l01 = d0.e == null ? null : d0.e.getChildFragmentManager();
                                String s = d0.e == null ? null : d0.e.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
                                I i1 = d0.e;
                                if(i1 != null) {
                                    httpResponse$Notification0 = i1.getString(0x7F1301E3);  // string:cmt_kakao_account_expire_popup_message "비밀번호 변경, 로그인 유효 기간만료 등으로 인해 로그아웃되었습니다.\n보안을 
                                                                                            // 위해 다시 로그인해주세요."
                                }
                                b9.a a2 = new b9.a(d0, 0);
                                com.melon.ui.popup.b.d(com.melon.ui.popup.b.a, l01, s, ((String)httpResponse$Notification0), false, false, false, null, null, null, a2, null, 0x5F8);
                                return h0;
                            }
                        }
                    }
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                object2 = object0;
                goto label_23;
            }
            case 2: {
                d5.n.D(object0);
                return h0;
            }
            case 3: {
                d5.n.D(object0);
                object1 = ((p)object0).a;
                goto label_33;
            }
            case 4: {
                d5.n.D(object0);
                goto label_52;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return a0;
    }
}

