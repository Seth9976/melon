package com.iloen.melon.fragments.settings;

import De.I;
import J8.T2;
import Ma.m;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.gaudiolab.sol.android.SolMusicOne.LoudnessType;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.RadioButton;
import com.iloen.melon.custom.RadioGroup;
import com.iloen.melon.custom.SettingItemView;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.musicmessage.e;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import k8.Y;
import k8.o;
import kc.b3;
import kc.d3;
import kc.s2;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.guava.ListenableFutureKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y8.f;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001F2\u00020\u0001:\u0001\u001FB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000F\u0010\t\u001A\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\nJ-\u0010\u0012\u001A\u0004\u0018\u00010\u00112\u0006\u0010\f\u001A\u00020\u000B2\b\u0010\u000E\u001A\u0004\u0018\u00010\r2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0014\u001A\u00020\u00112\b\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0018\u001A\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0003R\u0018\u0010\u001A\u001A\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001A\u0010\u001BR\u0014\u0010\u001E\u001A\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001C\u0010\u001D¨\u0006 "}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingLoudnessNormalizationFragment;", "Lcom/iloen/melon/fragments/settings/SettingBaseFragment;", "<init>", "()V", "", "volume", "", "getPositionByVolume", "(F)I", "getTitleResId", "()I", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lie/H;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "LJ8/T2;", "_binding", "LJ8/T2;", "getBinding", "()LJ8/T2;", "binding", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SettingLoudnessNormalizationFragment extends SettingBaseFragment {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001A\u00020\u0007H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingLoudnessNormalizationFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/settings/SettingLoudnessNormalizationFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final SettingLoudnessNormalizationFragment newInstance() {
            return new SettingLoudnessNormalizationFragment();
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "SettingLoudnessNormalizationFragment";
    @Nullable
    private T2 _binding;

    static {
        SettingLoudnessNormalizationFragment.Companion = new Companion(null);
        SettingLoudnessNormalizationFragment.$stable = 8;
    }

    public static void K(RadioGroup radioGroup0, int v) {
        SettingLoudnessNormalizationFragment.onViewCreated$lambda$3(radioGroup0, v);
    }

    public static void M(boolean z) {
        SettingLoudnessNormalizationFragment.onViewCreated$lambda$5$lambda$4(z);
    }

    private final T2 getBinding() {
        T2 t20 = this._binding;
        q.d(t20);
        return t20;
    }

    private final int getPositionByVolume(float f) {
        if(f < -14.0f) {
            return 0x7F0A0B39;  // id:target_volume_low
        }
        return f > -14.0f ? 0x7F0A0B38 : 0x7F0A0B3A;  // id:target_volume_high
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public int getTitleResId() {
        return 0x7F1309EE;  // string:setting_title_loudness_normalization "음량 최적화"
    }

    @NotNull
    public static final SettingLoudnessNormalizationFragment newInstance() {
        return SettingLoudnessNormalizationFragment.Companion.newInstance();
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D0834, viewGroup0, false);  // layout:setting_loudness_normalization
        int v = 0x7F0A05BC;  // id:item_loudness_normalization
        View view1 = I.C(view0, 0x7F0A05BC);  // id:item_loudness_normalization
        if(((SettingItemView)view1) != null) {
            v = 0x7F0A05BD;  // id:item_loudness_normalization_type
            View view2 = I.C(view0, 0x7F0A05BD);  // id:item_loudness_normalization_type
            if(((SettingItemView)view2) != null && ((MelonTextView)I.C(view0, 0x7F0A07B4)) != null) {  // id:loudness_normalization_target_volume
                v = 0x7F0A07B5;  // id:loudness_normalization_target_volume_container
                View view3 = I.C(view0, 0x7F0A07B5);  // id:loudness_normalization_target_volume_container
                if(((LinearLayout)view3) != null && ((ScrollView)I.C(view0, 0x7F0A0A78)) != null && (((RadioButton)I.C(view0, 0x7F0A0B38)) != null && ((RadioButton)I.C(view0, 0x7F0A0B39)) != null) && ((RadioButton)I.C(view0, 0x7F0A0B3A)) != null) {  // id:setting_scrollview
                    v = 0x7F0A0B3B;  // id:target_volume_radiogroup
                    View view4 = I.C(view0, 0x7F0A0B3B);  // id:target_volume_radiogroup
                    if(((RadioGroup)view4) != null) {
                        this._binding = new T2(((LinearLayout)view0), ((SettingItemView)view1), ((SettingItemView)view2), ((LinearLayout)view3), ((RadioGroup)view4));
                        return this.getBinding().a;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public void onDestroyView() {
        super.onDestroyView();
        this._binding = null;
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        boolean z = false;
        if(titleBar0 != null) {
            titleBar0.f(false);
        }
        SettingItemView settingItemView0 = this.getBinding().b;
        settingItemView0.setViewType(12);
        settingItemView0.setRadioOnOff(MelonSettingInfo.getAudioLoudnessType() != LoudnessType.kOff.ordinal());
        settingItemView0.setRadioBtnClickListener(new s(this, 2));
        settingItemView0.setTextSize(ScreenUtils.dipToPixel(settingItemView0.getContext(), 18.0f));
        ViewUtils.setEnable(this.getBinding().d, MelonSettingInfo.getAudioLoudnessType() != LoudnessType.kOff.ordinal());
        this.getBinding().e.setClickable(MelonSettingInfo.getAudioLoudnessType() != LoudnessType.kOff.ordinal());
        SettingItemView settingItemView1 = this.getBinding().c;
        if(MelonSettingInfo.getAudioLoudnessType() != LoudnessType.kOff.ordinal()) {
            z = true;
        }
        settingItemView1.setRadioClickable(z);
        int v = this.getPositionByVolume(MelonSettingInfo.getAudioTargetLoudness());
        this.getBinding().e.a(v);
        T2 t20 = this.getBinding();
        e e0 = new e(13);
        t20.e.setOnCheckedChangeListener(e0);
        T2 t21 = this.getBinding();
        t21.c.setViewType(12);
        boolean z1 = MelonSettingInfo.isAudioLoudnessTransparentMode();
        t21.c.setRadioOnOff(z1);
        e e1 = new e(14);
        t21.c.setRadioBtnClickListener(e1);
        int v1 = ScreenUtils.dipToPixel(t21.c.getContext(), 15.0f);
        t21.c.setTextSize(v1);
    }

    private static final void onViewCreated$lambda$2$lambda$1(SettingLoudnessNormalizationFragment settingLoudnessNormalizationFragment0, boolean z) {
        LoudnessType solMusicOne$LoudnessType0;
        if(!z) {
            solMusicOne$LoudnessType0 = LoudnessType.kOff;
        }
        else if(MelonSettingInfo.isAudioLoudnessTransparentMode()) {
            solMusicOne$LoudnessType0 = LoudnessType.kLSC_Transparent;
        }
        else {
            solMusicOne$LoudnessType0 = LoudnessType.kLSC_QualitySecure;
        }
        q.g(solMusicOne$LoudnessType0, "type");
        MelonSettingInfo.setAudioLoudnessType(solMusicOne$LoudnessType0.ordinal());
        f.g(solMusicOne$LoudnessType0);
        if(z) {
            d3 d30 = (d3)(((s2)((o)(((m)Y.g(MelonAppBase.Companion, "context", m.class)))).w.get()));
            b3 b30 = new b3(d30, null);
            ListenableFutureKt.future$default(d30.b, null, null, b30, 3, null);
        }
        ViewUtils.setEnable(settingLoudnessNormalizationFragment0.getBinding().d, z);
        settingLoudnessNormalizationFragment0.getBinding().e.setClickable(z);
        settingLoudnessNormalizationFragment0.getBinding().c.setRadioClickable(z);
    }

    private static final void onViewCreated$lambda$3(RadioGroup radioGroup0, int v) {
        float f = -14.0f;
        switch(v) {
            case 0x7F0A0B38: {  // id:target_volume_high
                f = -11.0f;
                break;
            }
            case 0x7F0A0B39: {  // id:target_volume_low
                f = -16.0f;
            }
        }
        MelonSettingInfo.setAudioTargetLoudness(f);
        f.b().c.targetLoudness = f;
        f.b().d.compareAndSet(false, true);
    }

    private static final void onViewCreated$lambda$5$lambda$4(boolean z) {
        q.g((z ? LoudnessType.kLSC_Transparent : LoudnessType.kLSC_QualitySecure), "type");
        MelonSettingInfo.setAudioLoudnessType((z ? LoudnessType.kLSC_Transparent : LoudnessType.kLSC_QualitySecure).ordinal());
        f.g((z ? LoudnessType.kLSC_Transparent : LoudnessType.kLSC_QualitySecure));
        MelonSettingInfo.setAudioLoudnessTransparentMode(z);
    }
}

