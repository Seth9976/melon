package com.iloen.melon.popup;

import De.I;
import J8.J0;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.iloen.melon.custom.CheckableImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventPlayback.VolumeChanged;
import com.iloen.melon.eventbus.EventRemotePlayer;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.ResourceUtilsKt;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.VolumeUtils;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import e1.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;
import p8.g;
import y8.k;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\u0011\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000B\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\u000B\u0010\fJ\u0019\u0010\u0010\u001A\u00020\u000F2\b\u0010\u000E\u001A\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0012\u001A\u00020\u000FH\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0014\u001A\u00020\u000FH\u0014¢\u0006\u0004\b\u0014\u0010\u0013J\u0019\u0010\u0017\u001A\u00020\u000F2\b\u0010\u0016\u001A\u0004\u0018\u00010\u0015H\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0017\u001A\u00020\u000F2\b\u0010\u0016\u001A\u0004\u0018\u00010\u0019H\u0007¢\u0006\u0004\b\u0017\u0010\u001AJ!\u0010\u001E\u001A\u00020\u000F2\u0012\u0010\u001D\u001A\u000E\u0012\u0004\u0012\u00020\u001C\u0012\u0004\u0012\u00020\u001C0\u001B¢\u0006\u0004\b\u001E\u0010\u001F¨\u0006!"}, d2 = {"Lcom/iloen/melon/popup/EqualizerSelectPopup;", "Lcom/iloen/melon/popup/MelonBaseListPopup;", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/app/Activity;)V", "", "getLayoutView", "()I", "Landroid/view/WindowManager$LayoutParams;", "wlp", "setWindowLayoutParams", "(Landroid/view/WindowManager$LayoutParams;)Landroid/view/WindowManager$LayoutParams;", "Landroid/os/Bundle;", "savedInstanceState", "Lie/H;", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "onStop", "Lcom/iloen/melon/eventbus/EventPlayback$VolumeChanged;", "event", "onEventMainThread", "(Lcom/iloen/melon/eventbus/EventPlayback$VolumeChanged;)V", "Lcom/iloen/melon/eventbus/EventRemotePlayer;", "(Lcom/iloen/melon/eventbus/EventRemotePlayer;)V", "Lkotlin/Function1;", "Lp8/f;", "action", "trackTiaraEventLog", "(Lwe/k;)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class EqualizerSelectPopup extends MelonBaseListPopup {
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/popup/EqualizerSelectPopup$Companion;", "", "", "TAG", "Ljava/lang/String;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public SeekBar a;
    public J0 b;

    static {
        EqualizerSelectPopup.Companion = new Companion(null);
        EqualizerSelectPopup.$stable = 8;
    }

    public EqualizerSelectPopup(@Nullable Activity activity0) {
        q.d(activity0);
        super(activity0);
    }

    public final void a(int v) {
        if(v <= 0) {
            J0 j00 = this.b;
            if(j00 != null) {
                j00.c.setImageResource(0x7F080197);  // drawable:btn_eq_volume_mute
                return;
            }
            q.m("binding");
            throw null;
        }
        J0 j01 = this.b;
        if(j01 != null) {
            j01.c.setImageResource(0x7F080196);  // drawable:btn_eq_volume_minus
            return;
        }
        q.m("binding");
        throw null;
    }

    public static final SeekBar access$getMVolumeSeekBar$p(EqualizerSelectPopup equalizerSelectPopup0) {
        return equalizerSelectPopup0.a;
    }

    public static final void access$setMuteIcon(EqualizerSelectPopup equalizerSelectPopup0, int v) {
        equalizerSelectPopup0.a(v);
    }

    public final void b() {
        if(this.a != null) {
            Context context0 = this.getContext();
            int v = com.iloen.melon.utils.system.VolumeUtils.Companion.getVolume$default(VolumeUtils.Companion, context0, "EqualizerSelectPopup syncVolume", null, 4, null);
            if(v >= 0) {
                SeekBar seekBar0 = this.a;
                q.d(seekBar0);
                if(seekBar0.getProgress() != v) {
                    SeekBar seekBar1 = this.a;
                    q.d(seekBar1);
                    seekBar1.setProgress(v);
                    this.a(v);
                    SeekBar seekBar2 = this.a;
                    q.d(seekBar2);
                    seekBar2.invalidate();
                }
            }
        }
    }

    @Override  // com.iloen.melon.popup.MelonBaseListPopup
    public int getLayoutView() {
        return 0x7F0D0259;  // layout:eq_selection_layout
    }

    @Override  // com.iloen.melon.popup.MelonBaseListPopup
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        View view0 = this.getRootView();
        int v = 0x7F0A00AE;  // id:arrow
        if(((ImageView)I.C(view0, 0x7F0A00AE)) != null) {  // id:arrow
            v = 0x7F0A043D;  // id:eq_close
            View view1 = I.C(view0, 0x7F0A043D);  // id:eq_close
            if(((MelonTextView)view1) != null && ((ImageView)I.C(view0, 0x7F0A043E)) != null) {  // id:eq_connect
                v = 0x7F0A043F;  // id:eq_on_off
                View view2 = I.C(view0, 0x7F0A043F);  // id:eq_on_off
                if(((CheckableImageView)view2) != null) {
                    v = 0x7F0A0441;  // id:eq_setting_container
                    View view3 = I.C(view0, 0x7F0A0441);  // id:eq_setting_container
                    if(((RelativeLayout)view3) != null) {
                        v = 0x7F0A0442;  // id:eq_setting_sub_title
                        View view4 = I.C(view0, 0x7F0A0442);  // id:eq_setting_sub_title
                        if(((MelonTextView)view4) != null && ((MelonTextView)I.C(view0, 0x7F0A0443)) != null && ((ConstraintLayout)I.C(view0, 0x7F0A0445)) != null) {  // id:eq_setting_title
                            int v1 = 0x7F0A0448;  // id:eq_volume_up
                            View view5 = I.C(view0, 0x7F0A0446);  // id:eq_volume_down
                            if(((ImageView)view5) == null || ((SeekBar)I.C(view0, 0x7F0A0447)) == null) {  // id:eq_volume_seekbar
                                v = 0x7F0A0446;  // id:eq_volume_down
                            }
                            else {
                                if(((ImageView)I.C(view0, 0x7F0A0448)) != null) {  // id:eq_volume_up
                                    v1 = 0x7F0A08AF;  // id:new_iv
                                    if(((ImageView)I.C(view0, 0x7F0A08AF)) != null) {  // id:new_iv
                                        this.b = new J0(((LinearLayout)view0), ((MelonTextView)view1), ((CheckableImageView)view2), ((RelativeLayout)view3), ((MelonTextView)view4), ((ImageView)view5));
                                        Window window0 = this.getWindow();
                                        if(window0 != null) {
                                            window0.setLayout(-1, -2);
                                            window0.setGravity(80);
                                            window0.getAttributes().windowAnimations = 0x7F140189;  // style:MelonDialogAnimation
                                        }
                                        boolean z = MelonSettingInfo.isEqualizerStatusOn();
                                        J0 j00 = this.b;
                                        if(j00 != null) {
                                            ((CheckableImageView)j00.d).setChecked(z);
                                            J0 j01 = this.b;
                                            if(j01 != null) {
                                                ((CheckableImageView)j01.d).setContentDescription("," + ResourceUtilsKt.getString((z ? 0x7F130B2A : 0x7F130B29), new Object[0]));  // string:talkback_feature_on "사용 중"
                                                J0 j02 = this.b;
                                                if(j02 != null) {
                                                    u u0 = new u(this, 0);
                                                    ((CheckableImageView)j02.d).setOnClickListener(u0);
                                                    J0 j03 = this.b;
                                                    if(j03 != null) {
                                                        v v2 = new v(this);
                                                        ((CheckableImageView)j03.d).setOnCheckedChangeListener(v2);
                                                        if(z) {
                                                            J0 j04 = this.b;
                                                            if(j04 != null) {
                                                                k k0 = b.F();
                                                                ((MelonTextView)j04.g).setText(k0.d);
                                                                goto label_51;
                                                            }
                                                            q.m("binding");
                                                            throw null;
                                                        }
                                                    label_51:
                                                        J0 j05 = this.b;
                                                        if(j05 != null) {
                                                            u u1 = new u(this, 1);
                                                            ((RelativeLayout)j05.b).setOnClickListener(u1);
                                                            J0 j06 = this.b;
                                                            if(j06 != null) {
                                                                ViewUtilsKt.setAccessibilityButtonClassName(((MelonTextView)j06.g));
                                                                View view6 = this.findViewById(0x7F0A0445);  // id:eq_volume_container
                                                                q.e(view6, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
                                                                ConstraintLayout constraintLayout0 = (ConstraintLayout)view6;
                                                                View view7 = this.findViewById(0x7F0A0447);  // id:eq_volume_seekbar
                                                                q.e(view7, "null cannot be cast to non-null type android.widget.SeekBar");
                                                                this.a = (SeekBar)view7;
                                                                ((SeekBar)view7).setOnSeekBarChangeListener(new EqualizerSelectPopup.initVolumeView.1(this));
                                                                Context context0 = this.getContext();
                                                                if(context0 != null) {
                                                                    int v3 = ScreenUtils.dipToPixel(context0, 5.5f);
                                                                    SeekBar seekBar0 = this.a;
                                                                    q.d(seekBar0);
                                                                    seekBar0.setPadding(v3, 0, v3, 0);
                                                                    SeekBar seekBar1 = this.a;
                                                                    q.d(seekBar1);
                                                                    seekBar1.setMax(com.iloen.melon.utils.system.VolumeUtils.Companion.getMaxVolume$default(VolumeUtils.Companion, context0, null, 2, null));
                                                                    int v4 = com.iloen.melon.utils.system.VolumeUtils.Companion.getVolume$default(VolumeUtils.Companion, context0, "EqualizerSelectPopup initVolumeView", null, 4, null);
                                                                    SeekBar seekBar2 = this.a;
                                                                    q.d(seekBar2);
                                                                    seekBar2.setProgress(v4);
                                                                    this.a(v4);
                                                                }
                                                                J0 j07 = this.b;
                                                                if(j07 != null) {
                                                                    u u2 = new u(this, 2);
                                                                    ((MelonTextView)j07.f).setOnClickListener(u2);
                                                                    J0 j08 = this.b;
                                                                    if(j08 != null) {
                                                                        ViewUtilsKt.setAccessibilityButtonClassName(((MelonTextView)j08.f));
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
                                }
                                v = v1;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@Nullable VolumeChanged eventPlayback$VolumeChanged0) {
        LogU.Companion.d("EqualizerSelectPopup", "volume event");
        this.b();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onEventMainThread(@Nullable EventRemotePlayer eventRemotePlayer0) {
        LogU.Companion.d("EqualizerSelectPopup", "volume event");
        new Handler().postDelayed(new J(this, 1), 500L);
    }

    @Override  // android.app.Dialog
    public void onStart() {
        super.onStart();
        EventBusHelper.register(this);
        this.b();
    }

    @Override  // android.app.Dialog
    public void onStop() {
        super.onStop();
        EventBusHelper.unregister(this);
    }

    @Override  // com.iloen.melon.popup.MelonBaseListPopup
    @NotNull
    public WindowManager.LayoutParams setWindowLayoutParams(@NotNull WindowManager.LayoutParams windowManager$LayoutParams0) {
        q.g(windowManager$LayoutParams0, "wlp");
        return windowManager$LayoutParams0;
    }

    public final void trackTiaraEventLog(@NotNull we.k k0) {
        q.g(k0, "action");
        g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
        g0.b = "";
        g0.c = "";
        g0.I = "1000000545";
        ((f)k0.invoke(g0)).a().track();
    }
}

