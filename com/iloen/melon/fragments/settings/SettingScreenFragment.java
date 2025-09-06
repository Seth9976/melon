package com.iloen.melon.fragments.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.iloen.melon.custom.RadioGroup;
import com.iloen.melon.custom.SettingItemView;
import com.iloen.melon.fragments.musicmessage.e;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.MelonThemeUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0007\u001A\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\n\u001A\u00020\t2\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\b\u0010\u000E\u001A\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001A\u00020\u00042\u0006\u0010\u0012\u001A\u00020\u000F2\b\u0010\u000E\u001A\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingScreenFragment;", "Lcom/iloen/melon/fragments/settings/SettingBaseFragment;", "<init>", "()V", "Lie/H;", "initViews", "", "getTitleResId", "()I", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SettingScreenFragment extends SettingBaseFragment {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001A\u00020\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingScreenFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/settings/SettingScreenFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final SettingScreenFragment newInstance() {
            return new SettingScreenFragment();
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "SettingScreenFragment";

    static {
        SettingScreenFragment.Companion = new Companion(null);
        SettingScreenFragment.$stable = 8;
    }

    public static void K(RadioGroup radioGroup0, int v) {
        SettingScreenFragment.initViews$lambda$0(radioGroup0, v);
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public int getTitleResId() {
        return 0x7F1309F6;  // string:setting_title_screen "화면 설정"
    }

    private final void initViews() {
        View view0 = this.findViewById(0x7F0A0A26);  // id:screen_radio_group
        q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.RadioGroup");
        ViewUtils.showWhen(this.findViewById(0x7F0A03D5), true);  // id:divider
        ViewUtils.showWhen(this.findViewById(0x7F0A0A27), true);  // id:screen_system_radio_button
        int v = MelonThemeUtils.getCurrentTheme();
        switch(v) {
            case 0: {
                ((RadioGroup)view0).a(0x7F0A0A28);  // id:screen_white_radio_button
                break;
            }
            case 1: {
                ((RadioGroup)view0).a(0x7F0A0A25);  // id:screen_black_radio_button
                break;
            }
            default: {
                if(v == 2) {
                    ((RadioGroup)view0).a(0x7F0A0A27);  // id:screen_system_radio_button
                }
            }
        }
        ((RadioGroup)view0).setOnCheckedChangeListener(new e(18));
        View view1 = this.findViewById(0x7F0A0D81);  // id:use_high_contrast_mode
        q.e(view1, "null cannot be cast to non-null type com.iloen.melon.custom.SettingItemView");
        ((SettingItemView)view1).setViewType(12);
        ((SettingItemView)view1).setRadioOnOff(MelonSettingInfo.isUseHighContrastMode());
        ((SettingItemView)view1).setRadioBtnClickListener(new s(this, 4));
    }

    private static final void initViews$lambda$0(RadioGroup radioGroup0, int v) {
        int v1 = 1;
        switch(v) {
            case 0x7F0A0A27: {  // id:screen_system_radio_button
                v1 = 2;
                break;
            }
            case 0x7F0A0A28: {  // id:screen_white_radio_button
                v1 = 0;
            }
        }
        MelonThemeUtils.saveTheme(v1);
        MelonThemeUtils.setTheme(v1);
    }

    private static final void initViews$lambda$1(SettingScreenFragment settingScreenFragment0, boolean z) {
        ToastManager.show((z ? 0x7F130497 : 0x7F130496));  // string:high_contrast_mode_setting_on "고대비 모드를 활성화 합니다."
        MelonSettingInfo.setUseHighContrastMode(z);
        FragmentActivity fragmentActivity0 = settingScreenFragment0.getActivity();
        if(fragmentActivity0 != null) {
            fragmentActivity0.recreate();
        }
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D083A, viewGroup0, false);  // layout:setting_screen
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.initViews();
    }
}

