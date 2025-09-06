package com.iloen.melon.popup;

import De.I;
import J8.c3;
import Ma.m;
import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.firebase.b;
import com.iloen.melon.custom.CheckableImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.fragments.settings.w;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import k8.o;
import kc.d3;
import kc.s2;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import va.e0;
import we.k;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001\u0015B#\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0012\u0010\b\u001A\u000E\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\f\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001A\u00020\u00072\u0006\u0010\u000F\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0012\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0014\u001A\u00020\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/popup/SmartPlayerSettingPopup;", "Lcom/iloen/melon/popup/MelonBaseLifecyclePopup;", "Lcom/iloen/melon/popup/ForegroundPopup;", "Landroid/content/Context;", "context", "Lkotlin/Function1;", "", "Lie/H;", "clickListener", "<init>", "(Landroid/content/Context;Lwe/k;)V", "", "useEnterExitSlideAnimation", "()Z", "Landroid/view/ViewGroup;", "parent", "inflateContentView", "(Landroid/view/ViewGroup;)V", "onViewCreated", "()V", "dismiss", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SmartPlayerSettingPopup extends MelonBaseLifecyclePopup implements ForegroundPopup {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001A\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/popup/SmartPlayerSettingPopup$Companion;", "", "", "CLICK_TYPE_EQ", "I", "CLICK_TYPE_DEVICE_CONNECTED", "CLICK_TYPE_SP_CHANGED", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    public static final int CLICK_TYPE_DEVICE_CONNECTED = 1;
    public static final int CLICK_TYPE_EQ = 0;
    public static final int CLICK_TYPE_SP_CHANGED = 2;
    @NotNull
    public static final Companion Companion;
    public c3 d;
    public k e;

    static {
        SmartPlayerSettingPopup.Companion = new Companion(null);
        SmartPlayerSettingPopup.$stable = 8;
    }

    public SmartPlayerSettingPopup(@NotNull Context context0, @NotNull k k0) {
        q.g(context0, "context");
        q.g(k0, "clickListener");
        super(context0);
        this.e = k0;
    }

    @Override  // com.iloen.melon.popup.MelonBaseLifecyclePopup
    public void dismiss() {
        super.dismiss();
        this.e = null;
    }

    @Override  // com.iloen.melon.popup.MelonBaseLifecyclePopup
    public void inflateContentView(@NotNull ViewGroup viewGroup0) {
        q.g(viewGroup0, "parent");
        View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D085E, viewGroup0, false);  // layout:sp_player_list_popup_layout
        viewGroup0.addView(view0);
        int v = 0x7F0A013D;  // id:btn_alarm
        View view1 = I.C(view0, 0x7F0A013D);  // id:btn_alarm
        if(((FrameLayout)view1) != null) {
            v = 0x7F0A0144;  // id:btn_bg_auto_play
            View view2 = I.C(view0, 0x7F0A0144);  // id:btn_bg_auto_play
            if(((FrameLayout)view2) != null) {
                v = 0x7F0A0159;  // id:btn_device_connected
                View view3 = I.C(view0, 0x7F0A0159);  // id:btn_device_connected
                if(((FrameLayout)view3) != null) {
                    v = 0x7F0A015E;  // id:btn_eq
                    View view4 = I.C(view0, 0x7F0A015E);  // id:btn_eq
                    if(((ConstraintLayout)view4) != null) {
                        v = 0x7F0A018E;  // id:btn_playlist_setting
                        View view5 = I.C(view0, 0x7F0A018E);  // id:btn_playlist_setting
                        if(((FrameLayout)view5) != null) {
                            v = 0x7F0A01A1;  // id:btn_reservation_suspend
                            View view6 = I.C(view0, 0x7F0A01A1);  // id:btn_reservation_suspend
                            if(((FrameLayout)view6) != null) {
                                v = 0x7F0A01B4;  // id:btn_setting_offline
                                View view7 = I.C(view0, 0x7F0A01B4);  // id:btn_setting_offline
                                if(((FrameLayout)view7) != null) {
                                    v = 0x7F0A01B5;  // id:btn_setting_quality
                                    View view8 = I.C(view0, 0x7F0A01B5);  // id:btn_setting_quality
                                    if(((FrameLayout)view8) != null) {
                                        v = 0x7F0A01BF;  // id:btn_toggle_sp_used
                                        View view9 = I.C(view0, 0x7F0A01BF);  // id:btn_toggle_sp_used
                                        if(((FrameLayout)view9) != null) {
                                            v = 0x7F0A0315;  // id:connected_playlist_desc
                                            View view10 = I.C(view0, 0x7F0A0315);  // id:connected_playlist_desc
                                            if(((MelonTextView)view10) != null && ((MelonTextView)I.C(view0, 0x7F0A0316)) != null) {  // id:connected_playlist_title
                                                v = 0x7F0A0328;  // id:container_cpp_toggle
                                                View view11 = I.C(view0, 0x7F0A0328);  // id:container_cpp_toggle
                                                if(((ConstraintLayout)view11) != null) {
                                                    v = 0x7F0A0654;  // id:iv_new_eq
                                                    View view12 = I.C(view0, 0x7F0A0654);  // id:iv_new_eq
                                                    if(((ImageView)view12) != null && ((MelonTextView)I.C(view0, 0x7F0A0C63)) != null && ((MelonTextView)I.C(view0, 0x7F0A0C6F)) != null) {  // id:tv_device_connected
                                                        v = 0x7F0A0CC7;  // id:tv_my_eq
                                                        View view13 = I.C(view0, 0x7F0A0CC7);  // id:tv_my_eq
                                                        if(((TextView)view13) != null) {
                                                            v = 0x7F0A0DCD;  // id:view_toggle_sp_used
                                                            View view14 = I.C(view0, 0x7F0A0DCD);  // id:view_toggle_sp_used
                                                            if(((CheckableImageView)view14) != null) {
                                                                this.d = new c3(((LinearLayout)view0), ((FrameLayout)view1), ((FrameLayout)view2), ((FrameLayout)view3), ((ConstraintLayout)view4), ((FrameLayout)view5), ((FrameLayout)view6), ((FrameLayout)view7), ((FrameLayout)view8), ((FrameLayout)view9), ((MelonTextView)view10), ((ConstraintLayout)view11), ((ImageView)view12), ((TextView)view13), ((CheckableImageView)view14));
                                                                return;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // com.iloen.melon.popup.MelonBaseLifecyclePopup
    public void onViewCreated() {
        Context context0 = this.getContext();
        q.f(context0, "getContext(...)");
        Context context1 = context0.getApplicationContext();
        q.d(context1);
        d3 d30 = (d3)(((s2)((o)(((m)b.B(context1, m.class)))).w.get()));
        Boolean boolean0 = d30.m();
        int v = 0;
        boolean z = boolean0 == null ? false : boolean0.booleanValue();
        boolean z1 = ((e0)va.o.a()).m() && d30.j() != null;
        c3 c30 = this.d;
        if(c30 != null) {
            ConstraintLayout constraintLayout0 = c30.l;
            if(!z1) {
                v = 8;
            }
            constraintLayout0.setVisibility(v);
            c3 c31 = this.d;
            if(c31 != null) {
                FrameLayout frameLayout0 = c31.j;
                if(c31 != null) {
                    c31.o.setChecked(z);
                    c3 c32 = this.d;
                    if(c32 != null) {
                        ColorStateList colorStateList0 = c32.o.a ? ColorUtils.getColorStateList(this.getContext(), 0x7F06017C) : null;  // color:green500s_support_high_contrast
                        c32.o.setImageTintList(colorStateList0);
                        c3 c33 = this.d;
                        if(c33 != null) {
                            c33.o.setContentDescription((z ? "스마트 재생목록, 켜짐, 스위치" : "스마트 재생목록, 꺼짐, 스위치"));
                            frameLayout0.setOnClickListener(new w(this, z));
                            c3 c34 = this.d;
                            if(c34 != null) {
                                c34.k.setText((z ? "OFF시, 현재 단말에 있는 재생목록 기준으로 전환됩니다.\n스마트 재생목록은 서버에 저장되어 있으니 언제든 ON 해보세요." : "재생목록이 서버에 저장되어 언제 어디서든 동일한 목록을 관리하고 재생하는 기능입니다. 사용하려면 ON 해주세요."));
                                c3 c35 = this.d;
                                if(c35 != null) {
                                    ViewUtils.setContentDescriptionWithButtonClassName(c35.f, "재생목록 설정");
                                    c3 c36 = this.d;
                                    if(c36 != null) {
                                        P p0 = new P(this, 0);
                                        c36.f.setOnClickListener(p0);
                                        c3 c37 = this.d;
                                        if(c37 != null) {
                                            ViewUtils.setContentDescriptionWithButtonClassName(c37.i, "곡 음질 설정");
                                            c3 c38 = this.d;
                                            if(c38 != null) {
                                                P p1 = new P(this, 1);
                                                c38.i.setOnClickListener(p1);
                                                c3 c39 = this.d;
                                                if(c39 != null) {
                                                    ViewUtils.setContentDescriptionWithButtonClassName(c39.h, "오프라인 재생 설정");
                                                    c3 c310 = this.d;
                                                    if(c310 != null) {
                                                        P p2 = new P(this, 2);
                                                        c310.h.setOnClickListener(p2);
                                                        c3 c311 = this.d;
                                                        if(c311 != null) {
                                                            ViewUtils.setContentDescriptionWithButtonClassName(c311.c, "배경미디어 자동 재생 설정");
                                                            c3 c312 = this.d;
                                                            if(c312 != null) {
                                                                P p3 = new P(this, 3);
                                                                c312.c.setOnClickListener(p3);
                                                                c3 c313 = this.d;
                                                                if(c313 != null) {
                                                                    ViewUtils.setContentDescriptionWithButtonClassName(c313.e, "EQ 설정");
                                                                    if(MelonSettingInfo.isEqualizerStatusOn()) {
                                                                        c3 c314 = this.d;
                                                                        if(c314 != null) {
                                                                            y8.k k0 = e1.b.F();
                                                                            c314.n.setText(k0.d);
                                                                            goto label_70;
                                                                        }
                                                                        q.m("binding");
                                                                        throw null;
                                                                    }
                                                                label_70:
                                                                    c3 c315 = this.d;
                                                                    if(c315 != null) {
                                                                        ColorStateList colorStateList1 = ColorUtils.getColorStateList(this.getContext(), 0x7F06017C);  // color:green500s_support_high_contrast
                                                                        c315.m.setImageTintList(colorStateList1);
                                                                        c3 c316 = this.d;
                                                                        if(c316 != null) {
                                                                            P p4 = new P(this, 4);
                                                                            c316.e.setOnClickListener(p4);
                                                                            c3 c317 = this.d;
                                                                            if(c317 != null) {
                                                                                ViewUtils.setContentDescriptionWithButtonClassName(c317.d, "기기연결");
                                                                                c3 c318 = this.d;
                                                                                if(c318 != null) {
                                                                                    P p5 = new P(this, 5);
                                                                                    c318.d.setOnClickListener(p5);
                                                                                    c3 c319 = this.d;
                                                                                    if(c319 != null) {
                                                                                        ViewUtils.setContentDescriptionWithButtonClassName(c319.g, "예약 정지");
                                                                                        c3 c320 = this.d;
                                                                                        if(c320 != null) {
                                                                                            P p6 = new P(this, 6);
                                                                                            c320.g.setOnClickListener(p6);
                                                                                            c3 c321 = this.d;
                                                                                            if(c321 != null) {
                                                                                                ViewUtils.setContentDescriptionWithButtonClassName(c321.b, "알람");
                                                                                                c3 c322 = this.d;
                                                                                                if(c322 != null) {
                                                                                                    P p7 = new P(this, 7);
                                                                                                    c322.b.setOnClickListener(p7);
                                                                                                    return;
                                                                                                }
                                                                                                q.m("binding");
                                                                                                throw null;
                                                                                            }
                                                                                            q.m("binding");
                                                                                            throw null;
                                                                                        }
                                                                                        q.m("binding");
                                                                                        throw null;
                                                                                    }
                                                                                    q.m("binding");
                                                                                    throw null;
                                                                                }
                                                                                q.m("binding");
                                                                                throw null;
                                                                            }
                                                                            q.m("binding");
                                                                            throw null;
                                                                        }
                                                                        q.m("binding");
                                                                        throw null;
                                                                    }
                                                                    q.m("binding");
                                                                    throw null;
                                                                }
                                                                q.m("binding");
                                                                throw null;
                                                            }
                                                            q.m("binding");
                                                            throw null;
                                                        }
                                                        q.m("binding");
                                                        throw null;
                                                    }
                                                    q.m("binding");
                                                    throw null;
                                                }
                                                q.m("binding");
                                                throw null;
                                            }
                                            q.m("binding");
                                            throw null;
                                        }
                                        q.m("binding");
                                        throw null;
                                    }
                                    q.m("binding");
                                    throw null;
                                }
                                q.m("binding");
                                throw null;
                            }
                            q.m("binding");
                            throw null;
                        }
                        q.m("binding");
                        throw null;
                    }
                    q.m("binding");
                    throw null;
                }
                q.m("binding");
                throw null;
            }
            q.m("binding");
            throw null;
        }
        q.m("binding");
        throw null;
    }

    @Override  // com.iloen.melon.popup.MelonBaseLifecyclePopup
    public boolean useEnterExitSlideAnimation() {
        return true;
    }
}

