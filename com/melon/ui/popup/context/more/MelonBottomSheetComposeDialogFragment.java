package com.melon.ui.popup.context.more;

import Cb.i;
import E9.w;
import J8.Q0;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import com.iloen.melon.constants.AddPosition;
import com.iloen.melon.net.v4x.response.AlbumSuggestedContentsRes.RESPONSE.RECMLIST;
import com.iloen.melon.net.v4x.response.AlbumSuggestedContentsRes.RESPONSE;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.CompatUtils;
import com.melon.net.res.common.DjPlayListInfoBase;
import com.melon.ui.A1;
import com.melon.ui.B1;
import com.melon.ui.C1;
import com.melon.ui.D1;
import com.melon.ui.E1;
import com.melon.ui.F1;
import com.melon.ui.G1;
import com.melon.ui.G4;
import com.melon.ui.H1;
import com.melon.ui.I4;
import com.melon.ui.J1;
import com.melon.ui.K1;
import com.melon.ui.K4;
import com.melon.ui.L1;
import com.melon.ui.M1;
import com.melon.ui.N1;
import com.melon.ui.O1;
import com.melon.ui.P1;
import com.melon.ui.Q1;
import com.melon.ui.R1;
import com.melon.ui.S1;
import com.melon.ui.T1;
import com.melon.ui.U1;
import com.melon.ui.V1;
import com.melon.ui.W1;
import com.melon.ui.a2;
import com.melon.ui.e2;
import com.melon.ui.f2;
import com.melon.ui.h2;
import com.melon.ui.i2;
import com.melon.ui.j2;
import com.melon.ui.popup.b;
import com.melon.ui.s4;
import com.melon.ui.w1;
import com.melon.ui.x1;
import com.melon.ui.y1;
import com.melon.ui.z1;
import java.util.ArrayList;
import java.util.List;
import kc.s2;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import vd.P;
import we.a;
import we.k;
import zd.H;
import zd.I;
import zd.J;
import zd.L;
import zd.M;
import zd.O;
import zd.Q;
import zd.c0;
import zd.c;
import zd.g0;
import zd.h0;
import zd.i0;
import zd.j0;
import zd.k0;
import zd.l0;
import zd.m0;
import zd.o0;
import zd.r;
import zd.s;
import zd.u0;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/melon/ui/popup/context/more/MelonBottomSheetComposeDialogFragment;", "Lzd/h;", "Lzd/c0;", "LJ8/Q0;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonBottomSheetComposeDialogFragment extends r {
    public final LogU n;
    public s2 o;
    public a r;
    public final com.melon.ui.popup.context.more.MelonBottomSheetComposeDialogFragment.broadcastReceiver.1 w;

    public MelonBottomSheetComposeDialogFragment() {
        LogU logU0 = new LogU("MelonBottomSheetComposeDialogFragment");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        this.n = logU0;
        this.w = new BroadcastReceiver() {
            @Override  // android.content.BroadcastReceiver
            public final void onReceive(Context context0, Intent intent0) {
                String s = intent0 == null ? null : intent0.getAction();
                if("android.appwidget.action.APPWIDGET_UPDATE".equals(s)) {
                    s = intent0 == null ? "" : intent0.getStringExtra("com.iloen.melon.intent.action");
                }
                MelonBottomSheetComposeDialogFragment melonBottomSheetComposeDialogFragment0 = this.a;
                LogU.debug$default(melonBottomSheetComposeDialogFragment0.n, "onReceive() - action : " + s, null, false, 6, null);
                if("com.iloen.melon.response_like_content".equals(s) && ((c0)melonBottomSheetComposeDialogFragment0.getViewModel()).i instanceof o0) {
                    Q q0 = ((c0)melonBottomSheetComposeDialogFragment0.getViewModel()).i;
                    q.e(q0, "null cannot be cast to non-null type com.melon.ui.popup.context.more.MorePopupPlayableType");
                    Playable playable0 = ((o0)q0).y();
                    D d0 = melonBottomSheetComposeDialogFragment0.getViewLifecycleOwner();
                    q.f(d0, "getViewLifecycleOwner(...)");
                    BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new s(melonBottomSheetComposeDialogFragment0, playable0, null), 3, null);
                }
            }
        };
    }

    @Override  // com.melon.ui.w0
    public final Q4.a getViewBinding(LayoutInflater layoutInflater0) {
        q.g(layoutInflater0, "inflater");
        return Q0.a(layoutInflater0, null);
    }

    @Override  // com.melon.ui.w0
    public final Class getViewModelClass() {
        return c0.class;
    }

    @Override  // com.melon.ui.w0
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        Bundle bundle1 = this.getArguments();
        if(bundle1 != null) {
            c0 c00 = (c0)this.getViewModel();
            c00.i = (Q)CompatUtils.getSerializable(bundle1, "KEY_POPUP_TYPE", Q.class);
        }
        this.setStyle(0, 0x7F140188);  // style:MelonBottomSheetDialog
        IntentFilter intentFilter0 = new IntentFilter();
        intentFilter0.addAction("com.iloen.melon.response_like_content");
        intentFilter0.addAction("android.appwidget.action.APPWIDGET_UPDATE");
        Context context0 = this.getContext();
        if(context0 != null) {
            w.S(context0, this.w, intentFilter0, "com.iloen.melon.permission.SIG_PERMISSION");
        }
    }

    @Override  // com.melon.ui.Y
    public final void onDestroy() {
        super.onDestroy();
        Context context0 = this.getContext();
        if(context0 != null) {
            context0.unregisterReceiver(this.w);
        }
    }

    @Override  // com.melon.ui.w0
    public final void onUiEvent(I4 i40) {
        AddPosition addPosition0;
        String s3;
        q.g(i40, "event");
        Playable playable0 = null;
        if(i40 instanceof s4) {
            b.l(this.getContext(), this.getParentFragmentManager(), null, 12);
            this.dismiss();
            return;
        }
        if(i40 instanceof G4) {
            b.k(this.getContext(), this.getParentFragmentManager(), 28);
            return;
        }
        String s = "";
        List list0 = je.w.a;
        if(i40 instanceof l0) {
            RESPONSE albumSuggestedContentsRes$RESPONSE0 = ((l0)i40).a;
            ArrayList arrayList0 = albumSuggestedContentsRes$RESPONSE0.recmList;
            if(arrayList0 != null) {
                list0 = new ArrayList(je.q.Q(10, arrayList0));
                for(Object object0: arrayList0) {
                    ((ArrayList)list0).add(new P(((RECMLIST)object0).relatTitle, ((RECMLIST)object0).recmTypeCode, ((RECMLIST)object0).contsTypeCode, ((RECMLIST)object0).contsId, ((RECMLIST)object0).contsName, ((RECMLIST)object0).contsImg, ((RECMLIST)object0).chnllSeq, ((RECMLIST)object0).link, ((RECMLIST)object0).playTime));
                }
            }
            androidx.fragment.app.l0 l00 = this.getChildFragmentManager();
            String s1 = TextUtils.isEmpty(albumSuggestedContentsRes$RESPONSE0.popupTitle) ? "이 앨범을 좋아하신 다면!" : albumSuggestedContentsRes$RESPONSE0.popupTitle;
            q.d(s1);
            b.q(l00, s1, list0, albumSuggestedContentsRes$RESPONSE0.menuId);
            return;
        }
        if(i40 instanceof m0) {
            k k0 = this.f;
            if(k0 != null) {
                k0.invoke(new j2(((m0)i40).a, ((m0)i40).b, ((m0)i40).c));
            }
            return;
        }
        if(i40 instanceof i0) {
            if(((i0)i40).a) {
                Q q0 = ((c0)this.getViewModel()).i;
                if(q0 instanceof o0) {
                    list0 = e.k.z(((o0)q0).y());
                }
                k k1 = this.f;
                if(k1 != null) {
                    if(q0 != null) {
                        String s2 = q0.p();
                        if(s2 != null) {
                            s = s2;
                        }
                    }
                    k1.invoke(new V1(list0, s));
                }
                this.dismiss();
                return;
            }
            Q q1 = ((c0)this.getViewModel()).i;
            if(q1 instanceof o0) {
                k k2 = this.f;
                if(k2 != null) {
                    k2.invoke(new U1(((o0)q1).y(), ""));
                }
            }
            this.dismiss();
            return;
        }
        if(i40 instanceof zd.f0) {
            this.sendUserEvent(new L(new zd.a(((zd.f0)i40).b)));
            return;
        }
        if(i40 instanceof g0) {
            int v = ((g0)i40).a;
            MelonBottomSheetItem melonBottomSheetItem0 = ((g0)i40).b;
            Q q2 = ((g0)i40).c;
            ExtraProperties extraProperties0 = melonBottomSheetItem0.f;
            int v1 = melonBottomSheetItem0.a.ordinal();
            switch(v1) {
                case 5: {
                    Q q3 = ((c0)this.getViewModel()).i;
                    if(q3 instanceof o0) {
                        k k4 = this.f;
                        if(k4 != null) {
                            k4.invoke(new E1(((o0)q3).y()));
                        }
                    }
                    else {
                        k k5 = this.f;
                        if(k5 != null) {
                            k5.invoke(new K1(v, melonBottomSheetItem0));
                        }
                    }
                    this.dismiss();
                    return;
                }
                case 6: {
                    Q q4 = ((c0)this.getViewModel()).i;
                    k k6 = this.f;
                    if(k6 != null) {
                        if(q4 == null) {
                            s3 = "";
                        }
                        else {
                            s3 = q4.a();
                            if(s3 == null) {
                                s3 = "";
                            }
                        }
                        if(q4 != null) {
                            String s4 = q4.p();
                            if(s4 != null) {
                                s = s4;
                            }
                        }
                        k6.invoke(new F1(s3, s));
                    }
                    this.dismiss();
                    return;
                }
                case 7: {
                    Q q5 = ((c0)this.getViewModel()).i;
                    if(q5 instanceof o0) {
                        k k7 = this.f;
                        if(k7 != null) {
                            k7.invoke(new U1(((o0)q5).y(), ""));
                        }
                    }
                    else if(q5 instanceof c) {
                        k k8 = this.f;
                        if(k8 != null) {
                            k8.invoke(new K1(v, melonBottomSheetItem0));
                        }
                    }
                    else {
                        LogU.Companion.d("MelonBottomSheetComposeDialogFragment", "this popupType can\'t put = " + q5);
                    }
                    this.dismiss();
                    return;
                }
                case 8: {
                    Q q6 = ((c0)this.getViewModel()).i;
                    if(q6 instanceof o0) {
                        list0 = e.k.z(((o0)q6).y());
                    }
                    k k9 = this.f;
                    if(k9 != null) {
                        if(q6 != null) {
                            String s5 = q6.p();
                            if(s5 != null) {
                                s = s5;
                            }
                        }
                        k9.invoke(new V1(list0, s));
                    }
                    this.dismiss();
                    return;
                }
                case 9: {
                    if(q2 instanceof o0) {
                        k k10 = this.f;
                        if(k10 != null) {
                            k10.invoke(new f2(((o0)q2).y(), ""));
                        }
                    }
                    this.dismiss();
                    return;
                }
                case 10: {
                    if(q2 instanceof o0) {
                        k k11 = this.f;
                        if(k11 != null) {
                            k11.invoke(new w1(((o0)q2).y()));
                        }
                    }
                    this.dismiss();
                    return;
                }
                case 11: {
                    if(q2 instanceof o0) {
                        k k12 = this.f;
                        if(k12 != null) {
                            k12.invoke(new x1(((o0)q2).y(), null, 2));
                        }
                    }
                    else {
                        k k13 = this.f;
                        if(k13 != null) {
                            k13.invoke(new x1(null, q2.a(), 1));
                        }
                    }
                    this.dismiss();
                    return;
                }
                case 13: {
                    k k14 = this.f;
                    if(k14 != null) {
                        k14.invoke(A1.a);
                    }
                    this.dismiss();
                    return;
                }
                case 14: {
                    k k15 = this.f;
                    if(k15 != null) {
                        k15.invoke(new D1(q2.a()));
                    }
                    this.dismiss();
                    return;
                }
                case 15: {
                    k k16 = this.f;
                    if(k16 != null) {
                        k16.invoke(new S1(q2.a()));
                    }
                    this.dismiss();
                    return;
                }
                case 16: {
                    if(q2 instanceof o0) {
                        k k17 = this.f;
                        if(k17 != null) {
                            k17.invoke(new N1(((o0)q2).y()));
                        }
                    }
                    this.dismiss();
                    return;
                }
                case 17: {
                    k k18 = this.f;
                    if(k18 != null) {
                        k18.invoke(new J1(q2.a(), q2.b()));
                    }
                    this.dismiss();
                    return;
                }
                case 18: {
                    k k19 = this.f;
                    if(k19 != null) {
                        Q q7 = ((c0)this.getViewModel()).i;
                        if(q7 != null) {
                            playable0 = q7.a();
                        }
                        k19.invoke(new e2(((String)playable0)));
                    }
                    this.dismiss();
                    return;
                }
                case 22: {
                    if(q2 instanceof o0) {
                        playable0 = ((o0)q2).y();
                    }
                    k k20 = this.f;
                    if(k20 != null) {
                        k20.invoke(new B1(playable0));
                    }
                    this.dismiss();
                    return;
                }
                case 23: {
                    Q q8 = ((c0)this.getViewModel()).i;
                    if(q8 instanceof o0) {
                        k k21 = this.f;
                        if(k21 != null) {
                            k21.invoke(new L1(((o0)q8).y()));
                        }
                    }
                    this.dismiss();
                    return;
                }
                case 37: {
                    if(extraProperties0 instanceof Link) {
                        playable0 = (Link)extraProperties0;
                    }
                    if(playable0 != null) {
                        k k22 = this.f;
                        if(k22 != null) {
                            String s6 = playable0.a == null ? "" : playable0.a;
                            String s7 = playable0.b;
                            if(s7 != null) {
                                s = s7;
                            }
                            k22.invoke(new i2(s6, s));
                        }
                    }
                    this.dismiss();
                    return;
                }
                case 57: {
                    if(q2 instanceof zd.q) {
                        k k23 = this.f;
                        if(k23 != null) {
                            k23.invoke(new z1(((zd.q)q2).d, ((zd.q)q2).h));
                        }
                    }
                    else if(q2 instanceof u0) {
                        k k24 = this.f;
                        if(k24 != null) {
                            DjPlayListInfoBase djPlayListInfoBase0 = ((u0)q2).a;
                            String s8 = djPlayListInfoBase0.ownermemberkey;
                            if(s8 != null) {
                                s = s8;
                            }
                            k24.invoke(new z1(s, djPlayListInfoBase0.withdrawyn));
                        }
                    }
                    this.dismiss();
                    return;
                }
                case 76: {
                    k k25 = this.f;
                    if(k25 != null) {
                        Q q9 = ((c0)this.getViewModel()).i;
                        String s9 = q9 == null ? null : q9.a();
                        Q q10 = ((c0)this.getViewModel()).i;
                        String s10 = q10 == null ? null : q10.r();
                        Q q11 = ((c0)this.getViewModel()).i;
                        if(q11 != null) {
                            playable0 = q11.p();
                        }
                        k25.invoke(new H1(s9, s10, ((String)playable0)));
                    }
                    this.dismiss();
                    return;
                }
                case 77: {
                    k k26 = this.f;
                    if(k26 != null) {
                        k26.invoke(new h2(q2.a()));
                    }
                    this.dismiss();
                    return;
                }
                case 78: {
                    k k27 = this.f;
                    if(k27 != null) {
                        k27.invoke(new y1(q2.a()));
                    }
                    this.dismiss();
                    return;
                }
                case 81: {
                    k k28 = this.f;
                    if(k28 != null) {
                        k28.invoke(new G1(q2.a()));
                    }
                    this.dismiss();
                    return;
                }
                case 82: {
                    k k29 = this.f;
                    if(k29 != null) {
                        k29.invoke(new C1(q2.a(), q2.r()));
                    }
                    this.dismiss();
                    return;
                }
                case 83: {
                    k k30 = this.f;
                    if(k30 != null) {
                        k30.invoke(W1.a);
                    }
                    this.dismiss();
                    return;
                }
                case 88: {
                    k k31 = this.f;
                    if(k31 != null) {
                        k31.invoke(new T1(q2.a()));
                    }
                    this.dismiss();
                    return;
                }
                case 89: {
                    if(q2 instanceof o0) {
                        k k32 = this.f;
                        if(k32 != null) {
                            String s11 = q2.r();
                            String s12 = ((o0)q2).y().getArtistid();
                            q.f(s12, "getArtistid(...)");
                            k32.invoke(new M1("", s11, s12, ""));
                        }
                    }
                    this.dismiss();
                    return;
                }
                case 90: {
                    k k33 = this.f;
                    if(k33 != null) {
                        k33.invoke(new O1(q2.a()));
                    }
                    this.dismiss();
                    return;
                }
                case 91: {
                    k k34 = this.f;
                    if(k34 != null) {
                        k34.invoke(new P1(q2.a()));
                    }
                    this.dismiss();
                    return;
                }
                case 0x6F: {
                    k k35 = this.f;
                    if(k35 != null) {
                        k35.invoke(new Q1(q2.a()));
                    }
                    this.dismiss();
                    return;
                }
                default: {
                    if(v1 != 98 && v1 != 99 && v1 != 100) {
                        k k3 = this.f;
                        if(k3 != null) {
                            k3.invoke(new K1(v, melonBottomSheetItem0));
                        }
                        this.dismiss();
                        return;
                    }
                    if(extraProperties0 instanceof AddPositionInfo) {
                        playable0 = (AddPositionInfo)extraProperties0;
                    }
                    M m0 = melonBottomSheetItem0.a;
                    if(playable0 == null) {
                        addPosition0 = AddPosition.b;
                    }
                    else {
                        addPosition0 = playable0.a;
                        if(addPosition0 == null) {
                            addPosition0 = AddPosition.b;
                        }
                    }
                    this.sendUserEvent(new J(q2, m0, addPosition0));
                    return;
                }
            }
        }
        if(i40 instanceof j0) {
            k k36 = this.f;
            if(k36 != null) {
                k36.invoke(((j0)i40).a);
            }
            this.dismiss();
            return;
        }
        if(i40 instanceof k0) {
            k k37 = this.f;
            if(k37 != null) {
                k37.invoke(a2.a);
            }
            this.dismiss();
            return;
        }
        if(i40 instanceof h0) {
            k k38 = this.f;
            if(k38 != null) {
                k38.invoke(R1.a);
            }
            this.dismiss();
            return;
        }
        super.onUiEvent(i40);
    }

    @Override  // com.melon.ui.w0
    public final void onViewCreated(View view0, Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        Dialog dialog0 = this.getDialog();
        if(dialog0 != null) {
            Window window0 = dialog0.getWindow();
            if(window0 != null) {
                window0.setBackgroundDrawable(new ColorDrawable(0));
            }
        }
        this.sendUserEvent(H.a);
        this.sendUserEvent(I.a);
    }

    @Override  // com.melon.ui.w0
    public final void renderUi(K4 k40) {
        q.g(k40, "uiState");
        String s = "renderUi() uiState: " + i.o(k40);
        LogU.info$default(this.n, s, null, false, 6, null);
        Q0 q00 = (Q0)this.getBinding();
        if(q00 != null) {
            zd.P p0 = k40 instanceof zd.P ? ((zd.P)k40) : null;
            if(p0 != null && p0 instanceof O) {
                m0.b b0 = new m0.b(0xA7D9E308, new xc.q(5, this, p0), true);
                q00.b.setContent(b0);
            }
        }
    }
}

