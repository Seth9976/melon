package A6;

import A8.M;
import Ad.l;
import F8.m;
import Fc.k;
import Fc.t;
import Fd.D;
import H0.e;
import J8.E2;
import J8.d;
import Jc.I;
import Jc.N;
import Jc.V;
import Jc.W;
import Jc.c0;
import Kc.d0;
import Mc.g;
import Q1.c;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.method.PasswordTransformationMethod;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.mediarouter.app.MediaRouteChooserDialog;
import com.facebook.internal.WebDialog;
import com.facebook.login.DeviceAuthDialog;
import com.facebook.login.widget.ToolTipPopup;
import com.google.android.material.datepicker.s;
import com.google.android.material.sidesheet.SideSheetDialog;
import com.google.android.material.textfield.h;
import com.google.android.material.textfield.r;
import com.iloen.melon.analytics.ClickLog;
import com.iloen.melon.custom.ControllerVideoListView;
import com.iloen.melon.custom.MelonChartAwardView;
import com.iloen.melon.fragments.detail.viewholder.DetailCommentItemHolder;
import com.iloen.melon.fragments.detail.viewholder.DetailSongHolder;
import com.iloen.melon.net.v5x.response.MainMusicRes.RESPONSE.FOOTER;
import com.iloen.melon.utils.Navigator.UrlOpenInto.OpenType;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.LogU;
import com.kakao.emoticon.ui.widget.EmoticonView;
import com.kakaoent.trevi.ad.ui.fragment.CashFriendsWebViewFragment;
import com.melon.playback.FloatingLyricService;
import kotlin.jvm.internal.q;

public final class b implements View.OnClickListener {
    public final int a;
    public final Object b;

    public b(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        int v = 0;
        Object object0 = this.b;
        switch(this.a) {
            case 0: {
                if(((SideSheetDialog)object0).i && ((SideSheetDialog)object0).isShowing()) {
                    if(!((SideSheetDialog)object0).k) {
                        TypedArray typedArray0 = ((SideSheetDialog)object0).getContext().obtainStyledAttributes(new int[]{0x101035B});
                        ((SideSheetDialog)object0).j = typedArray0.getBoolean(0, true);
                        typedArray0.recycle();
                        ((SideSheetDialog)object0).k = true;
                    }
                    if(((SideSheetDialog)object0).j) {
                        ((SideSheetDialog)object0).cancel();
                    }
                }
                return;
            }
            case 1: {
                if(!((EmoticonView)object0).isAnimating()) {
                    ((EmoticonView)object0).startAnimation();
                }
                return;
            }
            case 2: {
                ((l)object0).dismiss();
                return;
            }
            case 3: {
                View.OnClickListener view$OnClickListener0 = ((m)object0).l;
                if(view$OnClickListener0 != null) {
                    ImageView imageView0 = ((m)object0).h;
                    if(imageView0 != null) {
                        view$OnClickListener0.onClick(imageView0);
                        return;
                    }
                    q.m("subButtonView");
                    throw null;
                }
                return;
            }
            case 4: {
                e.w(((k)object0));
                return;
            }
            case 5: {
                e.w(((t)object0));
                return;
            }
            case 6: {
                e.w(((D)object0));
                return;
            }
            case 7: {
                if(((d)object0).k.getVisibility() == 0) {
                    RelativeLayout relativeLayout0 = ((d)object0).h;
                    q.f(relativeLayout0, "descContainer");
                    if(relativeLayout0.getLayoutParams() instanceof LayoutParams) {
                        ViewGroup.LayoutParams viewGroup$LayoutParams0 = relativeLayout0.getLayoutParams();
                        if(viewGroup$LayoutParams0 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                        }
                        ((LayoutParams)viewGroup$LayoutParams0).Q = 0x7FFFFFFF;
                    }
                    ((d)object0).m.setVisibility(8);
                    ((d)object0).j.setVisibility(0);
                }
                return;
            }
            case 8: {
                ((I)object0).b.invoke();
                return;
            }
            case 9: {
                we.k k0 = ((N)object0).h;
                if(k0 != null) {
                    k0.invoke(((N)object0));
                }
                return;
            }
            case 10: {
                ((V)object0).a.invoke();
                return;
            }
            case 11: {
                we.k k1 = ((W)object0).d;
                if(k1 != null) {
                    k1.invoke(Boolean.valueOf(!((W)object0).c));
                }
                return;
            }
            case 12: {
                we.k k2 = ((c0)object0).g;
                if(k2 != null) {
                    k2.invoke(((c0)object0));
                }
                return;
            }
            case 13: {
                ((E2)object0).n.setVisibility(0);
                ((E2)object0).k.setVisibility(8);
                ((E2)object0).n.sendAccessibilityEvent(8);
                return;
            }
            case 14: {
                ((d0)object0).dismiss();
                return;
            }
            case 15: {
                ((g)object0).q();
                return;
            }
            case 16: {
                Intent intent0 = new Intent();
                c.Y(intent0, "com.iloen.melon.intent.action.setting.floatinglyric", true);
                intent0.addFlags(0x8000);
                PendingIntent pendingIntent0 = PendingIntent.getActivity(((FloatingLyricService)object0), 1, intent0, 0xC000000);
                try {
                    pendingIntent0.send();
                }
                catch(Exception exception0) {
                    LogU.Companion.e("FloatingLyricService", "ivSetting.onClick() error", exception0);
                }
                return;
            }
            case 17: {
                CashFriendsWebViewFragment.m(((CashFriendsWebViewFragment)object0), view0);
                return;
            }
            case 18: {
                ((MediaRouteChooserDialog)object0).dismiss();
                return;
            }
            case 19: {
                WebDialog.createCrossImage$lambda$5(((WebDialog)object0), view0);
                return;
            }
            case 20: {
                DeviceAuthDialog.o(((DeviceAuthDialog)object0), view0);
                return;
            }
            case 21: {
                ToolTipPopup.b(((ToolTipPopup)object0), view0);
                return;
            }
            case 22: {
                ((s)object0).V.setEnabled(((s)object0).m().X());
                ((s)object0).S.toggle();
                if(((s)object0).n != 1) {
                    v = 1;
                }
                ((s)object0).n = v;
                ((s)object0).q(((s)object0).S);
                ((s)object0).p();
                return;
            }
            case 23: {
                EditText editText0 = ((com.google.android.material.textfield.c)object0).i;
                if(editText0 != null) {
                    Editable editable0 = editText0.getText();
                    if(editable0 != null) {
                        editable0.clear();
                    }
                    ((com.google.android.material.textfield.c)object0).q();
                }
                return;
            }
            case 24: {
                ((h)object0).u();
                return;
            }
            case 25: {
                EditText editText1 = ((r)object0).f;
                if(editText1 != null) {
                    int v1 = editText1.getSelectionEnd();
                    EditText editText2 = ((r)object0).f;
                    if(editText2 == null || !(editText2.getTransformationMethod() instanceof PasswordTransformationMethod)) {
                        ((r)object0).f.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    }
                    else {
                        ((r)object0).f.setTransformationMethod(null);
                    }
                    if(v1 >= 0) {
                        ((r)object0).f.setSelection(v1);
                    }
                    ((r)object0).q();
                }
                return;
            }
            case 26: {
                com.iloen.melon.custom.q q0 = ((ControllerVideoListView)object0).f;
                if(q0 != null) {
                    q0.doCollapse();
                }
                return;
            }
            case 27: {
                Navigator.openUrl(M.G, OpenType.FullScreenWithBackButton);
                String s = ((MelonChartAwardView)object0).k;
                if(s != null) {
                    d5.s s1 = d3.g.K(s, "R15", "V2");
                    s1.f = "R07";
                    new ClickLog(s1).a();
                    p8.g g0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
                    String s2 = ((MelonChartAwardView)object0).k;
                    if(s2 != null) {
                        g0.I = s2;
                        g0.a = "페이지이동";
                        g0.b = ((MelonChartAwardView)object0).l;
                        g0.c = ((MelonChartAwardView)object0).m;
                        g0.y = "Pagemenu";
                        g0.z = "페이지이동";
                        g0.F = "주간인기상투표";
                        g0.a().track();
                        return;
                    }
                    q.m("mMenuId");
                    throw null;
                }
                q.m("mMenuId");
                throw null;
            }
            case 28: {
                DetailCommentItemHolder.b(((DetailCommentItemHolder)object0), view0);
                return;
            }
            default: {
                DetailSongHolder.a(((FOOTER)object0), view0);
            }
        }
    }
}

