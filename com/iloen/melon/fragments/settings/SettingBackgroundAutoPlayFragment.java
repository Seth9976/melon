package com.iloen.melon.fragments.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iloen.melon.custom.SettingItemView;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.system.ToastManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001D2\u00020\u0001:\u0001\u001DB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000F\u0010\u000B\u001A\u00020\nH\u0014¢\u0006\u0004\b\u000B\u0010\fJ-\u0010\u0014\u001A\u0004\u0018\u00010\u00132\u0006\u0010\u000E\u001A\u00020\r2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0017\u001A\u00020\u00042\u0006\u0010\u0016\u001A\u00020\u00132\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001A\u001A\u00020\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001A\u0010\u001BR\u0016\u0010\u001C\u001A\u00020\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001C\u0010\u001B¨\u0006\u001E"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingBackgroundAutoPlayFragment;", "Lcom/iloen/melon/fragments/settings/SettingBaseFragment;", "<init>", "()V", "Lie/H;", "initViews", "", "onOff", "toastMessageDisplay", "(Z)V", "", "getTitleResId", "()I", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/iloen/melon/custom/SettingItemView;", "useDataOptions", "Lcom/iloen/melon/custom/SettingItemView;", "useWifiOptions", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SettingBackgroundAutoPlayFragment extends SettingBaseFragment {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001A\u00020\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingBackgroundAutoPlayFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/settings/SettingBackgroundAutoPlayFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final SettingBackgroundAutoPlayFragment newInstance() {
            return new SettingBackgroundAutoPlayFragment();
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "SettingBackgroundAutoPlayFragment";
    private SettingItemView useDataOptions;
    private SettingItemView useWifiOptions;

    static {
        SettingBackgroundAutoPlayFragment.Companion = new Companion(null);
        SettingBackgroundAutoPlayFragment.$stable = 8;
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public int getTitleResId() {
        return 0x7F13104F;  // string:title_setting_bg_autoplay "배경미디어 자동 재생 설정"
    }

    private final void initViews() {
        View view0 = this.findViewById(0x7F0A099F);  // id:radio_use_network
        q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.SettingItemView");
        this.useDataOptions = (SettingItemView)view0;
        View view1 = this.findViewById(0x7F0A09A1);  // id:radio_use_wifi
        q.e(view1, "null cannot be cast to non-null type com.iloen.melon.custom.SettingItemView");
        this.useWifiOptions = (SettingItemView)view1;
        SettingItemView settingItemView0 = this.useDataOptions;
        if(settingItemView0 != null) {
            boolean z = false;
            settingItemView0.setViewType(12);
            SettingItemView settingItemView1 = this.useDataOptions;
            if(settingItemView1 != null) {
                settingItemView1.setRadioOnOff(!MelonSettingInfo.isLowMemoryMode() && MelonSettingInfo.getUseDataForBgAutoPlay());
                SettingItemView settingItemView2 = this.useDataOptions;
                if(settingItemView2 != null) {
                    settingItemView2.setRadioBtnClickListener(new g(this, 0));
                    SettingItemView settingItemView3 = this.useWifiOptions;
                    if(settingItemView3 != null) {
                        settingItemView3.setViewType(12);
                        SettingItemView settingItemView4 = this.useWifiOptions;
                        if(settingItemView4 != null) {
                            if(!MelonSettingInfo.isLowMemoryMode() && MelonSettingInfo.getUseWifiForBgAutoPlay()) {
                                z = true;
                            }
                            settingItemView4.setRadioOnOff(z);
                            SettingItemView settingItemView5 = this.useWifiOptions;
                            if(settingItemView5 != null) {
                                settingItemView5.setRadioBtnClickListener(new g(this, 1));
                                return;
                            }
                            q.m("useWifiOptions");
                            throw null;
                        }
                        q.m("useWifiOptions");
                        throw null;
                    }
                    q.m("useWifiOptions");
                    throw null;
                }
                q.m("useDataOptions");
                throw null;
            }
            q.m("useDataOptions");
            throw null;
        }
        q.m("useDataOptions");
        throw null;
    }

    private static final void initViews$lambda$0(SettingBackgroundAutoPlayFragment settingBackgroundAutoPlayFragment0, boolean z) {
        if(MelonSettingInfo.isLowMemoryMode()) {
            SettingItemView settingItemView0 = settingBackgroundAutoPlayFragment0.useDataOptions;
            if(settingItemView0 != null) {
                settingItemView0.setRadioOnOff(false);
                ToastManager.show(0x7F13099E);  // string:setting_laboratory_low_memory_toast "저사양 단말 모드가 실행중입니다."
                return;
            }
            q.m("useDataOptions");
            throw null;
        }
        MelonSettingInfo.setUseDataForBgAutoPlay(z);
        SettingItemView settingItemView1 = settingBackgroundAutoPlayFragment0.useDataOptions;
        if(settingItemView1 != null) {
            settingItemView1.setRadioOnOff(z);
            settingBackgroundAutoPlayFragment0.toastMessageDisplay(z);
            return;
        }
        q.m("useDataOptions");
        throw null;
    }

    private static final void initViews$lambda$1(SettingBackgroundAutoPlayFragment settingBackgroundAutoPlayFragment0, boolean z) {
        if(MelonSettingInfo.isLowMemoryMode()) {
            SettingItemView settingItemView0 = settingBackgroundAutoPlayFragment0.useWifiOptions;
            if(settingItemView0 != null) {
                settingItemView0.setRadioOnOff(false);
                ToastManager.show(0x7F13099E);  // string:setting_laboratory_low_memory_toast "저사양 단말 모드가 실행중입니다."
                return;
            }
            q.m("useWifiOptions");
            throw null;
        }
        MelonSettingInfo.setUseWifiForBgAutoPlay(z);
        SettingItemView settingItemView1 = settingBackgroundAutoPlayFragment0.useWifiOptions;
        if(settingItemView1 != null) {
            settingItemView1.setRadioOnOff(z);
            settingBackgroundAutoPlayFragment0.toastMessageDisplay(z);
            return;
        }
        q.m("useWifiOptions");
        throw null;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D0823, viewGroup0, false);  // layout:setting_background_autoplay
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.initViews();
    }

    private final void toastMessageDisplay(boolean z) {
        ToastManager.show((z ? 0x7F1309A2 : 0x7F1309A1));  // string:setting_laboratory_toast_on "On 설정되었습니다."
    }
}

