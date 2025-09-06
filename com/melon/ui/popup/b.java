package com.melon.ui.popup;

import Ac.Y1;
import Ac.b0;
import Ad.l;
import Cc.n;
import Cc.u1;
import Nb.i;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.I;
import androidx.fragment.app.l0;
import androidx.fragment.app.w;
import com.airbnb.lottie.LottieAnimationView;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.melon.playlist.mixup.DjMalrangInfo;
import com.melon.ui.common.composable.PlayBgColorData;
import com.melon.ui.popup.context.more.MelonBottomSheetComposeDialogFragment;
import e3.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jd.e3;
import jd.v;
import k8.Y;
import kotlin.jvm.internal.q;
import r8.f;
import sd.g;
import sd.j;
import vd.E;
import vd.G;
import vd.L;
import vd.O;
import vd.T;
import vd.z;
import we.a;
import we.k;
import xd.c;
import zd.Q;
import zd.o;
import zd.w0;

public final class b {
    public static final b a;

    static {
        b.a = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static w a(l0 l00, String s, E e0, k k0) {
        E e1 = E.a;
        String s1 = e0 == e1 ? s : e0.name();
        Companion logU$Companion0 = LogU.Companion;
        Y.w("findFragmentByTagAndGroup tag : ", s1, logU$Companion0, "MelonPopupHelper");
        I i0 = l00.E(s1);
        if(i0 != null) {
            boolean z = k0 == null ? true : ((Boolean)k0.invoke(i0)).booleanValue();
            logU$Companion0.d("MelonPopupHelper", "tagCondition : " + z + ", fragment : " + i0 + " tagString = " + s);
            if(z && i0 instanceof w) {
                return (w)i0;
            }
            if(i0 instanceof w && e0 != e1) {
                ((w)i0).dismissAllowingStateLoss();
            }
        }
        return null;
    }

    public static w b(l0 l00, String s, E e0, k k0, int v) {
        if((v & 4) != 0) {
            e0 = E.a;
        }
        if((v & 8) != 0) {
            k0 = null;
        }
        return b.a(l00, s, e0, k0);
    }

    public final void c(l0 l00, String s, String s1) {
        b.d(this, l00, s, s1, false, false, false, null, null, null, null, null, 2040);
    }

    public static void d(b b0, l0 l00, String s, String s1, boolean z, boolean z1, boolean z2, String s2, E e0, a a0, a a1, a a2, int v) {
        E e1 = (v & 0x80) == 0 ? e0 : E.a;
        if(l00 != null && !Y.z(MelonAppBase.Companion) && !l00.T() && !l00.K) {
            l00.C();
            if(b.a(l00, "showAlertPopup", e1, new i(s, s1, 9)) == null) {
                String s3 = "showAlertPopup";
                vd.i i0 = h.t(s, s1, null, false, ((v & 0x400) == 0 ? a2 : null), ((v & 0x40) == 0 ? s2 : null), new u1(17, ((v & 0x100) == 0 ? a0 : null)), new u1(18, ((v & 0x200) == 0 ? a1 : null)), ((v & 8) == 0 ? z : true), ((v & 16) == 0 ? z1 : false), null, ((v & 0x20) == 0 ? z2 : false), null, 0xD84C);
                if(e1 != E.a) {
                    s3 = e1.name();
                }
                i0.show(l00, s3);
            }
        }
    }

    public static void e(l0 l00, String s, List list0, int v, String s1, k k0) {
        q.g(s, "title");
        if(l00 != null && !Y.z(MelonAppBase.Companion) && !l00.T() && !l00.K) {
            l00.C();
            com.melon.ui.popup.context.more.a a0 = new com.melon.ui.popup.context.more.a(s, list0, s1);
            if(b.b(l00, "ArtistMultiPopupDialogFragment", null, new j(11), 4) == null) {
                c c0 = new c();
                Bundle bundle0 = new Bundle();
                bundle0.putString("KEY_TITLE", s);
                bundle0.putInt("KEY_TYPE_CONTEXT_MENU", v);
                bundle0.putSerializable("KEY_POPUP_TYPE", a0);
                c0.setArguments(bundle0);
                c0.o = k0;
                c0.show(l00, "ArtistMultiPopupDialogFragment");
            }
        }
    }

    public static void f(Context context0, l0 l00, String s) {
        if(l00 != null && !l00.T() && !l00.K && context0 != null && !Y.z(MelonAppBase.Companion)) {
            l00.C();
            if(b.b(l00, "showCommentWriteInfoPopup", null, null, 12) == null) {
                h.t(s, null, null, false, null, "확인", new j(13), null, false, false, vd.h.e, false, null, 0xD75E).show(l00, "showCommentWriteInfoPopup");
            }
        }
    }

    public static void g(l0 l00, String s, boolean z, int v, List list0, k k0) {
        q.g(list0, "listItems");
        if(l00 != null && !Y.z(MelonAppBase.Companion) && !l00.T() && !l00.K) {
            l00.C();
            if(b.b(l00, "CommonTextListPopupDialogFragment", null, new j(8), 4) == null) {
                z z1 = new z();
                z1.j = list0;
                z1.k = s;
                z1.l = z;
                z1.m = v;
                z1.n = k0;
                z1.show(l00, "CommonTextListPopupDialogFragment");
            }
        }
    }

    public static void h(l0 l00, String s, Ad.w w0, k k0) {
        q.g(s, "title");
        if(l00 != null && !Y.z(MelonAppBase.Companion)) {
            l00.C();
            if(!l00.T() && !l00.K && b.b(l00, "ContextTextListPopupDialogFragment", null, new g(s, 6), 4) == null) {
                l l0 = new l();
                Bundle bundle0 = new Bundle();
                bundle0.putString("KEY_TITLE", s);
                bundle0.putSerializable("KEY_TYPE", w0);
                l0.setArguments(bundle0);
                l0.j = k0;
                l0.show(l00, "ContextTextListPopupDialogFragment");
            }
        }
    }

    public static void i(Context context0, l0 l00, DjMalrangInfo djMalrangInfo0, PlayBgColorData playBgColorData0, String s) {
        q.g(djMalrangInfo0, "currentDjMalrangInfo");
        if(l00 != null && !Y.z(MelonAppBase.Companion) && !l00.T() && !l00.K && context0 != null) {
            l00.C();
            if(b.b(l00, s, null, null, 12) == null) {
                Bd.g g0 = new Bd.g();
                Bundle bundle0 = new Bundle();
                bundle0.putParcelable("KEY_CURRENT_DJ_MALRANG_INFO", djMalrangInfo0);
                bundle0.putParcelable("KEY_PLAY_BG_COLOR_DATA", playBgColorData0);
                g0.setArguments(bundle0);
                g0.show(l00, s);
            }
        }
    }

    public static void j(l0 l00, String s, String s1, String s2, int v, k k0) {
        if(l00 != null && !Y.z(MelonAppBase.Companion) && !l00.T() && !l00.K) {
            l00.C();
            if(b.b(l00, "showEditPopup", null, null, 12) == null) {
                List list0 = e.k.A(new Object[]{s2, v, s1});
                h.t(s, null, null, true, null, null, new Y1(11, k0), null, false, true, vd.h.g, false, list0, 29044).show(l00, "showEditPopup");
            }
        }
    }

    public static void k(Context context0, l0 l00, int v) {
        if(context0 != null && l00 != null && !Y.z(MelonAppBase.Companion) && !l00.T() && !l00.K) {
            l00.C();
            if(b.b(l00, "AnimationPopupDialogFragment", null, null, 12) == null) {
                float f = (float)ScreenUtils.getScreenHeight(context0);
                DisplayPosition animationPopupDialogFragment$DisplayPosition0 = new DisplayPosition(((int)(0.36f * f)), ((int)(f * 0.19f)));
                AnimationPopupDialogFragment animationPopupDialogFragment0 = new AnimationPopupDialogFragment();
                Bundle bundle0 = new Bundle();
                bundle0.putString("KEY_ANIMATION_RESOURCE", ((v & 4) == 0 ? "animation/fan_motion.json" : "animation/like_motion.json"));
                bundle0.putInt("KEY_ALTERNATIVE_IMAGE_RESOURCE", ((v & 8) == 0 ? 0x7F080375 : 0x7F08069D));  // drawable:fan_motion_single_img
                bundle0.putInt("KEY_REPEAT_COUNT", 0);
                bundle0.putParcelable("KEY_DISPLAY_POSITION", animationPopupDialogFragment$DisplayPosition0);
                animationPopupDialogFragment0.setArguments(bundle0);
                animationPopupDialogFragment0.show(l00, "AnimationPopupDialogFragment");
            }
        }
    }

    public static void l(Context context0, l0 l00, v v0, int v1) {
        Uri uri0 = f.f;
        e3 e30 = (v1 & 8) == 0 ? v0 : new e3(uri0, 24);
        q.g(uri0, "returnUri");
        if(l00 != null && !Y.z(MelonAppBase.Companion) && !l00.T() && !l00.K && context0 != null) {
            l00.C();
            if(b.b(l00, "showNeedLoginTwoBtnPopup", null, new n(context0, 15), 4) == null) {
                DevLog.Companion.get("Account").put("login require service");
                h.t("안내", "로그인이 필요한 서비스입니다.\n로그인하시겠습니까?", null, true, null, null, new u1(14, e30), null, false, false, null, false, null, 0xFF74).show(l00, "showNeedLoginTwoBtnPopup");
            }
        }
    }

    public static void m(l0 l00, O o0, String s, String s1) {
        if(l00 != null && !Y.z(MelonAppBase.Companion) && !l00.T() && !l00.K) {
            l00.C();
            hd.i i0 = new hd.i(o0, 28);
            if(b.a(l00, o0.a, E.b, i0) == null) {
                L l0 = new L();
                l0.e = o0;
                l0.f = s;
                l0.g = s1;
                l0.h = true;
                l0.setShouldRetain(false);
                l0.setDismissOnBackPressed(true);
                l0.setDismissOnConfigurationChanged(false);
                l0.show(l00, "PLAYER_DIALOG");
            }
        }
    }

    public static final void n(l0 l00, Q q0, a a0, E e0, k k0) {
        q.g(q0, "popupType");
        q.g(e0, "group");
        if(l00 != null && !Y.z(MelonAppBase.Companion) && !l00.T() && !l00.K) {
            l00.C();
            if(b.a(l00, "showPopupTypeBottomSheetDialog", e0, new G(q0, 5)) == null) {
                MelonBottomSheetComposeDialogFragment melonBottomSheetComposeDialogFragment0 = new MelonBottomSheetComposeDialogFragment();
                Bundle bundle0 = new Bundle();
                bundle0.putSerializable("KEY_POPUP_TYPE", q0);
                melonBottomSheetComposeDialogFragment0.setArguments(bundle0);
                melonBottomSheetComposeDialogFragment0.f = k0;
                melonBottomSheetComposeDialogFragment0.r = a0;
                melonBottomSheetComposeDialogFragment0.show(l00, "showPopupTypeBottomSheetDialog");
            }
        }
    }

    public static void o(l0 l00, Q q0, k k0, int v) {
        b.n(l00, q0, null, E.a, k0);
    }

    public static void p(Context context0, l0 l00, boolean z, a a0) {
        if(l00 != null && !Y.z(MelonAppBase.Companion) && !l00.T() && !l00.K && context0 != null) {
            l00.C();
            if(b.b(l00, "showPushAgreePopup", null, null, 12) == null) {
                String s = context0.getString((z ? 0x7F13002C : 0x7F1308C4));  // string:agree "동의"
                q.d(s);
                q.f("광고성 알림 수신%1$s", "getString(...)");
                String s1 = String.format("광고성 알림 수신%1$s", Arrays.copyOf(new Object[]{s}, 1));
                List list0 = e.k.z(Boolean.valueOf(z));
                h.t(s1, null, null, false, null, "확인", null, new u1(16, a0), false, false, vd.h.d, false, list0, 5342).show(l00, "showPushAgreePopup");
            }
        }
    }

    public static void q(l0 l00, String s, List list0, String s1) {
        q.g(s, "title");
        if(l00 != null && !Y.z(MelonAppBase.Companion) && !l00.T() && !l00.K) {
            l00.C();
            w0 w00 = new w0(s, list0);
            if(b.b(l00, "showRecommendContentPopup", null, new j(10), 4) == null) {
                if(s1 == null) {
                    s1 = "";
                }
                T t0 = new T();  // 初始化器: Lcom/melon/ui/Y;-><init>()V
                Bundle bundle0 = new Bundle();
                bundle0.putSerializable("KEY_POPUP_TYPE", w00);
                bundle0.putString("KEY_MENU_ID", s1);
                t0.setArguments(bundle0);
                t0.show(l00, "showRecommendContentPopup");
            }
        }
    }

    public static final void r(LottieAnimationView lottieAnimationView0, boolean z) {
        if(lottieAnimationView0 == null) {
            return;
        }
        if(z) {
            lottieAnimationView0.setAnimation("animation/btn_player_connect.json");
            lottieAnimationView0.playAnimation();
            return;
        }
        lottieAnimationView0.clearAnimation();
    }

    public static void s(Context context0, l0 l00, a a0, v v0) {
        if(l00 != null && !Y.z(MelonAppBase.Companion) && !l00.T() && !l00.K && context0 != null) {
            l00.C();
            if(b.b(l00, "showSectionRepeatInterruptDialog", null, new n(context0, 16), 4) == null) {
                h.t("안내", "반복재생 중입니다.\n\n반복재생 모드를 해제하시고 요청 작업을 진행하시겠습니까?", "취소", true, v0, "확인", new u1(15, a0), null, false, false, vd.h.a, false, null, 0xF740).show(l00, "showSectionRepeatInterruptDialog");
            }
        }
    }

    public static void t(l0 l00, ArrayList arrayList0, k k0) {
        E e0 = E.a;
        if(l00 != null && !Y.z(MelonAppBase.Companion) && !l00.T() && !l00.K) {
            l00.C();
            if(b.a(l00, "showSimpleTypeBottomSheetDialog", e0, new b0(23, arrayList0)) == null) {
                zd.n n0 = new zd.n(arrayList0);
                MelonBottomSheetComposeDialogFragment melonBottomSheetComposeDialogFragment0 = new MelonBottomSheetComposeDialogFragment();
                Bundle bundle0 = new Bundle();
                bundle0.putSerializable("KEY_POPUP_TYPE", n0);
                melonBottomSheetComposeDialogFragment0.setArguments(bundle0);
                melonBottomSheetComposeDialogFragment0.f = k0;
                melonBottomSheetComposeDialogFragment0.r = null;
                melonBottomSheetComposeDialogFragment0.show(l00, "showSimpleTypeBottomSheetDialog");
            }
        }
    }

    public static final void u(l0 l00, String s, ArrayList arrayList0, k k0) {
        E e0 = E.a;
        q.g(s, "title");
        if(l00 != null && !Y.z(MelonAppBase.Companion) && !l00.T() && !l00.K) {
            l00.C();
            if(b.a(l00, "showTitleTypeBottomSheetDialog", e0, new m9.l(19, s, arrayList0)) == null) {
                o o0 = new o(s, arrayList0);
                MelonBottomSheetComposeDialogFragment melonBottomSheetComposeDialogFragment0 = new MelonBottomSheetComposeDialogFragment();
                Bundle bundle0 = new Bundle();
                bundle0.putSerializable("KEY_POPUP_TYPE", o0);
                melonBottomSheetComposeDialogFragment0.setArguments(bundle0);
                melonBottomSheetComposeDialogFragment0.f = k0;
                melonBottomSheetComposeDialogFragment0.r = null;
                melonBottomSheetComposeDialogFragment0.show(l00, "showTitleTypeBottomSheetDialog");
            }
        }
    }

    public static void v(l0 l00, String s, String s1, boolean z, String s2, String s3, a a0, a a1) {
        b.x(l00, s, s1, true, z, s2, s3, a0, a1, null, null, 0x800);
    }

    public static void w(l0 l00, String s, String s1, boolean z, boolean z1, boolean z2, String s2, String s3, a a0, a a1, a a2, E e0) {
        q.g(e0, "group");
        if(l00 != null && !Y.z(MelonAppBase.Companion) && !l00.T() && !l00.K) {
            l00.C();
            String s4 = "showTwoBtnAlertPopup";
            if(b.a(l00, "showTwoBtnAlertPopup", e0, new i(s, s1, 10)) == null) {
                vd.i i0 = h.t(s, s1, s2, true, a1, s3, new u1(19, a0), new u1(20, a2), z, z1, null, z2, null, 0xD840);
                if(e0 != E.a) {
                    s4 = e0.name();
                }
                i0.show(l00, s4);
            }
        }
    }

    public static void x(l0 l00, String s, String s1, boolean z, boolean z1, String s2, String s3, a a0, a a1, a a2, E e0, int v) {
        b.w(l00, s, s1, ((v & 8) == 0 ? z : true), ((v & 16) == 0 ? z1 : false), false, ((v & 0x40) == 0 ? s2 : null), ((v & 0x80) == 0 ? s3 : null), ((v & 0x100) == 0 ? a0 : null), ((v & 0x200) == 0 ? a1 : null), ((v & 0x400) == 0 ? a2 : null), ((v & 0x800) == 0 ? e0 : E.a));
    }
}

