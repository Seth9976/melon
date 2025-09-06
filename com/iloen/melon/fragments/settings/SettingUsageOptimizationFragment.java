package com.iloen.melon.fragments.settings;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iloen.melon.custom.SettingItemView;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.SystemSettingUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\b\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0007\u001A\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\n\u001A\u00020\t2\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\b\u0010\u000E\u001A\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001A\u00020\u00042\u0006\u0010\u0012\u001A\u00020\u000F2\b\u0010\u000E\u001A\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0015\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u0003R\u0018\u0010\u0017\u001A\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001A\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0018\u0010\u001A\u001A\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001A\u0010\u0018R\u0018\u0010\u001B\u001A\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001B\u0010\u0018R\u0018\u0010\u001C\u001A\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001C\u0010\u0018R\u0014\u0010\u001E\u001A\u00020\u001D8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\u001E\u0010\u001FR\u0014\u0010 \u001A\u00020\u001D8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b \u0010\u001FR\u0014\u0010!\u001A\u00020\u001D8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b!\u0010\u001FR\u0014\u0010\"\u001A\u00020\u001D8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b\"\u0010\u001FR\u0014\u0010#\u001A\u00020\u001D8BX\u0082\u0004¢\u0006\u0006\u001A\u0004\b#\u0010\u001F¨\u0006%"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingUsageOptimizationFragment;", "Lcom/iloen/melon/fragments/settings/SettingBaseFragment;", "<init>", "()V", "Lie/H;", "refreshValue", "", "getTitleResId", "()I", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "Lcom/iloen/melon/custom/SettingItemView;", "excludedBatteryOptimization", "Lcom/iloen/melon/custom/SettingItemView;", "restrictBackgroundActivity", "restrictBackgroundData", "appNotification", "powerSafeMode", "", "isOffPowerSaveMode", "()Z", "isOnIgnoringBatteryOptimizations", "isOffBackgroundRestricted", "isOnAvailableBackgroundData", "isOnNotificationsEnabled", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SettingUsageOptimizationFragment extends SettingBaseFragment {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001A\u00020\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingUsageOptimizationFragment$Companion;", "", "<init>", "()V", "PACKAGE_PREFIX", "", "newInstance", "Lcom/iloen/melon/fragments/settings/SettingUsageOptimizationFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final SettingUsageOptimizationFragment newInstance() {
            return new SettingUsageOptimizationFragment();
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String PACKAGE_PREFIX = "package:";
    @Nullable
    private SettingItemView appNotification;
    @Nullable
    private SettingItemView excludedBatteryOptimization;
    @Nullable
    private SettingItemView powerSafeMode;
    @Nullable
    private SettingItemView restrictBackgroundActivity;
    @Nullable
    private SettingItemView restrictBackgroundData;

    static {
        SettingUsageOptimizationFragment.Companion = new Companion(null);
        SettingUsageOptimizationFragment.$stable = 8;
    }

    public static void K(SettingUsageOptimizationFragment settingUsageOptimizationFragment0, View view0) {
        SettingUsageOptimizationFragment.onViewCreated$lambda$9$lambda$8(settingUsageOptimizationFragment0, view0);
    }

    public static void L(SettingUsageOptimizationFragment settingUsageOptimizationFragment0, View view0) {
        SettingUsageOptimizationFragment.onViewCreated$lambda$3$lambda$2(settingUsageOptimizationFragment0, view0);
    }

    public static void M(SettingUsageOptimizationFragment settingUsageOptimizationFragment0, View view0) {
        SettingUsageOptimizationFragment.onViewCreated$lambda$7$lambda$6(settingUsageOptimizationFragment0, view0);
    }

    public static void N(SettingUsageOptimizationFragment settingUsageOptimizationFragment0, View view0) {
        SettingUsageOptimizationFragment.onViewCreated$lambda$1$lambda$0(settingUsageOptimizationFragment0, view0);
    }

    public static void O(SettingUsageOptimizationFragment settingUsageOptimizationFragment0, View view0) {
        SettingUsageOptimizationFragment.onViewCreated$lambda$5$lambda$4(settingUsageOptimizationFragment0, view0);
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public int getTitleResId() {
        return 0x7F1310E7;  // string:usage_optimization_title "앱 사용 최적화 설정"
    }

    private final boolean isOffBackgroundRestricted() {
        return !SystemSettingUtils.isBackgroundRestricted(this.getContext());
    }

    private final boolean isOffPowerSaveMode() {
        return !SystemSettingUtils.isPowerSaveMode(this.getContext());
    }

    private final boolean isOnAvailableBackgroundData() {
        return SystemSettingUtils.isAvailableBackgroundData(this.getContext());
    }

    private final boolean isOnIgnoringBatteryOptimizations() {
        return SystemSettingUtils.isIgnoringBatteryOptimizations(this.getContext());
    }

    private final boolean isOnNotificationsEnabled() {
        return SystemSettingUtils.areNotificationsEnabled(this.getContext());
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D083F, viewGroup0, false);  // layout:setting_usage_optimization
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onResume() {
        super.onResume();
        this.refreshValue();
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        int v = ScreenUtils.dipToPixel(this.getContext(), 18.0f);
        View view1 = view0.findViewById(0x7F0A095D);  // id:power_safe_mode
        q.e(view1, "null cannot be cast to non-null type com.iloen.melon.custom.SettingItemView");
        ((SettingItemView)view1).setTextSize(v);
        ((SettingItemView)view1).setViewType(10);
        ((SettingItemView)view1).setOnClickListener(new G(this, 0));
        this.powerSafeMode = (SettingItemView)view1;
        View view2 = view0.findViewById(0x7F0A0456);  // id:excluded_battery_optimization
        q.e(view2, "null cannot be cast to non-null type com.iloen.melon.custom.SettingItemView");
        ((SettingItemView)view2).setTextSize(v);
        ((SettingItemView)view2).setViewType(10);
        ((SettingItemView)view2).setOnClickListener(new G(this, 1));
        this.excludedBatteryOptimization = (SettingItemView)view2;
        View view3 = view0.findViewById(0x7F0A09EC);  // id:restrict_background_activity
        q.e(view3, "null cannot be cast to non-null type com.iloen.melon.custom.SettingItemView");
        ((SettingItemView)view3).setTextSize(v);
        ((SettingItemView)view3).setViewType(10);
        ((SettingItemView)view3).setOnClickListener(new G(this, 2));
        this.restrictBackgroundActivity = (SettingItemView)view3;
        View view4 = view0.findViewById(0x7F0A09EE);  // id:restrict_background_data
        q.e(view4, "null cannot be cast to non-null type com.iloen.melon.custom.SettingItemView");
        ((SettingItemView)view4).setTextSize(v);
        ((SettingItemView)view4).setViewType(10);
        ((SettingItemView)view4).setOnClickListener(new G(this, 3));
        this.restrictBackgroundData = (SettingItemView)view4;
        View view5 = view0.findViewById(0x7F0A00A9);  // id:app_notification
        q.e(view5, "null cannot be cast to non-null type com.iloen.melon.custom.SettingItemView");
        ((SettingItemView)view5).setTextSize(v);
        ((SettingItemView)view5).setViewType(10);
        ((SettingItemView)view5).setOnClickListener(new G(this, 4));
        this.appNotification = (SettingItemView)view5;
        ViewUtils.showWhen(view0.findViewById(0x7F0A09ED), true);  // id:restrict_background_activity_item
        if(!this.isOnIgnoringBatteryOptimizations()) {
            SystemSettingUtils.openBatteryOptimizationsInSetting(this.getActivity());
        }
    }

    private static final void onViewCreated$lambda$1$lambda$0(SettingUsageOptimizationFragment settingUsageOptimizationFragment0, View view0) {
        if(settingUsageOptimizationFragment0.isOffPowerSaveMode()) {
            ToastManager.show(0x7F1307CE);  // string:optimization_already_on_toast "정상적으로 처리되었습니다."
            return;
        }
        settingUsageOptimizationFragment0.startActivity(new Intent("android.settings.BATTERY_SAVER_SETTINGS"));
    }

    private static final void onViewCreated$lambda$3$lambda$2(SettingUsageOptimizationFragment settingUsageOptimizationFragment0, View view0) {
        if(settingUsageOptimizationFragment0.isOnIgnoringBatteryOptimizations()) {
            ToastManager.show(0x7F1307CE);  // string:optimization_already_on_toast "정상적으로 처리되었습니다."
            return;
        }
        SystemSettingUtils.openBatteryOptimizationsInSetting(settingUsageOptimizationFragment0.getActivity());
    }

    private static final void onViewCreated$lambda$5$lambda$4(SettingUsageOptimizationFragment settingUsageOptimizationFragment0, View view0) {
        if(settingUsageOptimizationFragment0.isOffBackgroundRestricted()) {
            ToastManager.show(0x7F1307CE);  // string:optimization_already_on_toast "정상적으로 처리되었습니다."
            return;
        }
        settingUsageOptimizationFragment0.startActivity(SystemSettingUtils.getLaunchAppInfoIntent("com.iloen.melon"));
    }

    private static final void onViewCreated$lambda$7$lambda$6(SettingUsageOptimizationFragment settingUsageOptimizationFragment0, View view0) {
        if(settingUsageOptimizationFragment0.isOnAvailableBackgroundData()) {
            ToastManager.show(0x7F1307CE);  // string:optimization_already_on_toast "정상적으로 처리되었습니다."
            return;
        }
        settingUsageOptimizationFragment0.startActivity(new Intent("android.settings.IGNORE_BACKGROUND_DATA_RESTRICTIONS_SETTINGS", Uri.parse("package:com.iloen.melon")));
    }

    private static final void onViewCreated$lambda$9$lambda$8(SettingUsageOptimizationFragment settingUsageOptimizationFragment0, View view0) {
        if(settingUsageOptimizationFragment0.isOnNotificationsEnabled()) {
            ToastManager.show(0x7F1307CE);  // string:optimization_already_on_toast "정상적으로 처리되었습니다."
            return;
        }
        settingUsageOptimizationFragment0.startActivity(new Intent("android.settings.APP_NOTIFICATION_SETTINGS").putExtra("android.provider.extra.APP_PACKAGE", "com.iloen.melon"));
    }

    private final void refreshValue() {
        SettingItemView settingItemView0 = this.powerSafeMode;
        if(settingItemView0 != null) {
            settingItemView0.setSubTextOnOff(this.isOffPowerSaveMode());
        }
        SettingItemView settingItemView1 = this.excludedBatteryOptimization;
        if(settingItemView1 != null) {
            settingItemView1.setSubTextOnOff(this.isOnIgnoringBatteryOptimizations());
        }
        SettingItemView settingItemView2 = this.restrictBackgroundActivity;
        if(settingItemView2 != null) {
            settingItemView2.setSubTextOnOff(this.isOffBackgroundRestricted());
        }
        SettingItemView settingItemView3 = this.restrictBackgroundData;
        if(settingItemView3 != null) {
            settingItemView3.setSubTextOnOff(this.isOnAvailableBackgroundData());
        }
        SettingItemView settingItemView4 = this.appNotification;
        if(settingItemView4 != null) {
            settingItemView4.setSubTextOnOff(this.isOnNotificationsEnabled());
        }
    }
}

