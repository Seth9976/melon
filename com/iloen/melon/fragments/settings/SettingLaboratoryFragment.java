package com.iloen.melon.fragments.settings;

import G8.i;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.android.volley.VolleyError;
import com.iloen.melon.custom.SettingItemView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.musicmessage.e;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.PvLogDummyReq;
import com.iloen.melon.net.v5x.request.LaboratoryPreListenEditStatusReq;
import com.iloen.melon.net.v5x.response.ResponseV5Res;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.StorageUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.AppUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.ui.popup.b;
import ie.H;
import javax.inject.Inject;
import kc.s2;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 32\u00020\u0001:\u00013B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000E\u001A\u0004\u0018\u00010\r2\u0006\u0010\b\u001A\u00020\u00072\b\u0010\n\u001A\u0004\u0018\u00010\t2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0016\u00A2\u0006\u0004\b\u000E\u0010\u000FJ!\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0010\u001A\u00020\r2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0015\u001A\u00020\u0014H\u0014\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u000F\u0010\u0017\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0003J\u000F\u0010\u0018\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0003J\u000F\u0010\u0019\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b\u0019\u0010\u0003J\u000F\u0010\u001A\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b\u001A\u0010\u0003J\u000F\u0010\u001C\u001A\u00020\u001BH\u0016\u00A2\u0006\u0004\b\u001C\u0010\u001DJ\u0017\u0010\u001F\u001A\u00020\u00112\u0006\u0010\u001E\u001A\u00020\u001BH\u0004\u00A2\u0006\u0004\b\u001F\u0010 J\u000F\u0010!\u001A\u00020\u0011H\u0002\u00A2\u0006\u0004\b!\u0010\u0003J\u000F\u0010\"\u001A\u00020\u0011H\u0002\u00A2\u0006\u0004\b\"\u0010\u0003J\u000F\u0010#\u001A\u00020\u0011H\u0002\u00A2\u0006\u0004\b#\u0010\u0003J\u000F\u0010$\u001A\u00020\u0011H\u0002\u00A2\u0006\u0004\b$\u0010\u0003J\u000F\u0010%\u001A\u00020\u0011H\u0002\u00A2\u0006\u0004\b%\u0010\u0003J\u000F\u0010&\u001A\u00020\u0011H\u0002\u00A2\u0006\u0004\b&\u0010\u0003J\u000F\u0010\'\u001A\u00020\u0011H\u0002\u00A2\u0006\u0004\b\'\u0010\u0003J\u000F\u0010(\u001A\u00020\u0011H\u0002\u00A2\u0006\u0004\b(\u0010\u0003R\u0018\u0010*\u001A\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b*\u0010+R\"\u0010-\u001A\u00020,8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\b-\u0010.\u001A\u0004\b/\u00100\"\u0004\b1\u00102\u00A8\u00064"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingLaboratoryFragment;", "Lcom/iloen/melon/fragments/settings/SettingBaseFragment;", "<init>", "()V", "", "getTitleResId", "()I", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lie/H;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "getPvDummyLogRequest", "()Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "onStart", "onStop", "onResume", "onPause", "", "onBackPressed", "()Z", "onOff", "toastMessageDisplay", "(Z)V", "initUI", "initLowMemoryMode", "initInstantPlay", "initErrorReport", "initExportLog4User", "initExportLog4Dev", "initUseAutoPlayByExternal", "initLocalPlayListRestore", "Lcom/iloen/melon/custom/SettingItemView;", "mErrorReportRadioContainer", "Lcom/iloen/melon/custom/SettingItemView;", "Lkc/s2;", "playlistManager", "Lkc/s2;", "getPlaylistManager", "()Lkc/s2;", "setPlaylistManager", "(Lkc/s2;)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SettingLaboratoryFragment extends Hilt_SettingLaboratoryFragment {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001A\u00020\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingLaboratoryFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/settings/SettingLaboratoryFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final SettingLaboratoryFragment newInstance() {
            return new SettingLaboratoryFragment();
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "SettingLaboratoryFragment";
    @Nullable
    private SettingItemView mErrorReportRadioContainer;
    @Inject
    public s2 playlistManager;

    static {
        SettingLaboratoryFragment.Companion = new Companion(null);
        SettingLaboratoryFragment.$stable = 8;
    }

    public static H L(SettingItemView settingItemView0, SettingLaboratoryFragment settingLaboratoryFragment0, boolean z) {
        return SettingLaboratoryFragment.initLowMemoryMode$lambda$1$lambda$0(settingItemView0, z, settingLaboratoryFragment0);
    }

    public static void P(VolleyError volleyError0) {
    }

    public static void Q(ResponseV5Res responseV5Res0) {
    }

    @NotNull
    public final s2 getPlaylistManager() {
        s2 s20 = this.playlistManager;
        if(s20 != null) {
            return s20;
        }
        q.m("playlistManager");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    @NotNull
    public PvLogDummyReq getPvDummyLogRequest() {
        return new PvLogDummyReq(this.getContext(), "labMenu");
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public int getTitleResId() {
        return 0x7F130995;  // string:setting_laboratory "실험실"
    }

    private final void initErrorReport() {
        View view0 = this.findViewById(0x7F0A0D80);  // id:use_error_report
        q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.SettingItemView");
        this.mErrorReportRadioContainer = (SettingItemView)view0;
        ((SettingItemView)view0).setTextSize(ScreenUtils.dipToPixel(this.getContext(), 18.0f));
        SettingItemView settingItemView0 = this.mErrorReportRadioContainer;
        q.d(settingItemView0);
        settingItemView0.setViewType(12);
        SettingItemView settingItemView1 = this.mErrorReportRadioContainer;
        q.d(settingItemView1);
        settingItemView1.setRadioBtnClickListener(new v(this, 0));
    }

    private static final void initErrorReport$lambda$5(SettingLaboratoryFragment settingLaboratoryFragment0, boolean z) {
        MelonSettingInfo.setUseErrorReport(z);
        settingLaboratoryFragment0.toastMessageDisplay(z);
    }

    private final void initExportLog4Dev() {
        ViewUtils.showWhen(this.findViewById(0x7F0A0718), false);  // id:layout_export_log_dev
    }

    private static final void initExportLog4Dev$lambda$7(SettingLaboratoryFragment settingLaboratoryFragment0, View view0) {
        settingLaboratoryFragment0.exportAppLogFile4Dev();
    }

    private final void initExportLog4User() {
        View view0 = this.findViewById(0x7F0A0481);  // id:export_log_user
        q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.SettingItemView");
        ((SettingItemView)view0).setTextSize(ScreenUtils.dipToPixel(this.getContext(), 18.0f));
        ((SettingItemView)view0).setOnClickListener(new c(this, 3));
    }

    private static final void initExportLog4User$lambda$6(SettingLaboratoryFragment settingLaboratoryFragment0, View view0) {
        settingLaboratoryFragment0.exportAppLogFile4User();
    }

    private final void initInstantPlay() {
        boolean z = MelonSettingInfo.isUseInstantPlay();
        View view0 = this.findViewById(0x7F0A0D82);  // id:use_instant_play
        q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.SettingItemView");
        ((SettingItemView)view0).setTextSize(ScreenUtils.dipToPixel(this.getContext(), 18.0f));
        ((SettingItemView)view0).setRadioOnOff(z);
        ((SettingItemView)view0).setViewType(12);
        ((SettingItemView)view0).setRadioBtnClickListener(new v(this, 1));
    }

    private static final void initInstantPlay$lambda$4(SettingLaboratoryFragment settingLaboratoryFragment0, boolean z) {
        MelonSettingInfo.setUseInstantPlay(z);
        settingLaboratoryFragment0.toastMessageDisplay(z);
        RequestBuilder.newInstance(new LaboratoryPreListenEditStatusReq(settingLaboratoryFragment0.getContext(), z)).tag("SettingLaboratoryFragment").listener(new e(11)).errorListener(new e(12)).request();
    }

    private static final void initInstantPlay$lambda$4$lambda$2(ResponseV5Res responseV5Res0) {
    }

    private static final void initInstantPlay$lambda$4$lambda$3(VolleyError volleyError0) {
    }

    private final void initLocalPlayListRestore() {
        boolean z;
        if(StorageUtils.getNeedsLocalPlaylistMig()) {
            i.a.f();
            if(i.e() > 0) {
                LogU.Companion.d("LegacyLocalPlaylistMigHelper", "private local playlist already exist");
                z = false;
            }
            else {
                LogU.Companion.d("LegacyLocalPlaylistMigHelper", "private local playlist doesn\'t exist");
                z = true;
            }
        }
        else {
            z = false;
        }
        View view0 = this.findViewById(0x7F0A07A2);  // id:local_playlist_restore
        q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.SettingItemView");
        ((SettingItemView)view0).setTextSize(ScreenUtils.dipToPixel(this.getContext(), 18.0f));
        ((SettingItemView)view0).setOnClickListener(new w(z, this, 0));
    }

    private static final void initLocalPlayListRestore$lambda$9(boolean z, SettingLaboratoryFragment settingLaboratoryFragment0, View view0) {
        if(z) {
            FragmentActivity fragmentActivity0 = settingLaboratoryFragment0.requireActivity();
            q.f(fragmentActivity0, "requireActivity(...)");
            G8.e.b(fragmentActivity0, false);
            return;
        }
        ToastManager.show(0x7F130502);  // string:local_playlist_restore_not_toast "로컬플레이리스트 복원 대상자가 아닙니다."
    }

    private final void initLowMemoryMode() {
        boolean z = MelonSettingInfo.isLowMemoryMode();
        View view0 = this.findViewById(0x7F0A07B6);  // id:low_memory_mode
        q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.SettingItemView");
        ((SettingItemView)view0).setTextSize(ScreenUtils.dipToPixel(this.getContext(), 18.0f));
        ((SettingItemView)view0).setRadioOnOff(z);
        ((SettingItemView)view0).setViewType(12);
        ((SettingItemView)view0).setRadioBtnClickListener(new x(((SettingItemView)view0), this, 1));
    }

    private static final void initLowMemoryMode$lambda$1(SettingItemView settingItemView0, SettingLaboratoryFragment settingLaboratoryFragment0, boolean z) {
        settingItemView0.setRadioOnOff(!z);
        b.x(settingLaboratoryFragment0.getChildFragmentManager(), settingLaboratoryFragment0.getString(0x7F13099A), (z ? settingLaboratoryFragment0.getString(0x7F13099D) : settingLaboratoryFragment0.getString(0x7F13099C)), false, false, null, null, new y(settingItemView0, settingLaboratoryFragment0, z), null, null, null, 0xEF8);  // string:setting_laboratory_low_memory_mode "저사양 단말 모드"
    }

    private static final H initLowMemoryMode$lambda$1$lambda$0(SettingItemView settingItemView0, boolean z, SettingLaboratoryFragment settingLaboratoryFragment0) {
        settingItemView0.setRadioOnOff(z);
        MelonSettingInfo.setLowMemoryMode(z);
        Context context0 = settingLaboratoryFragment0.requireContext();
        q.f(context0, "requireContext(...)");
        AppUtils.restart(context0);
        return H.a;
    }

    private final void initUI() {
        this.initLowMemoryMode();
        this.initInstantPlay();
        this.initErrorReport();
        this.initExportLog4User();
        this.initExportLog4Dev();
        this.initUseAutoPlayByExternal();
        this.initLocalPlayListRestore();
    }

    private final void initUseAutoPlayByExternal() {
        boolean z = MelonSettingInfo.getUseAutoPlayByExternal();
        View view0 = this.findViewById(0x7F0A0D7F);  // id:use_auto_play
        q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.SettingItemView");
        ((SettingItemView)view0).setTextSize(ScreenUtils.dipToPixel(this.getContext(), 18.0f));
        ((SettingItemView)view0).setRadioOnOff(z);
        ((SettingItemView)view0).setViewType(12);
        ((SettingItemView)view0).setRadioBtnClickListener(new x(((SettingItemView)view0), this, 0));
    }

    private static final void initUseAutoPlayByExternal$lambda$8(SettingItemView settingItemView0, SettingLaboratoryFragment settingLaboratoryFragment0, boolean z) {
        settingItemView0.setRadioOnOff(z);
        MelonSettingInfo.setUseAutoPlayByExternal(z);
        settingLaboratoryFragment0.toastMessageDisplay(z);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean onBackPressed() {
        return false;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D0832, viewGroup0, false);  // layout:setting_laboratory
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onPause() {
        super.onPause();
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onResume() {
        super.onResume();
        boolean z = MelonSettingInfo.isUseErrorReport();
        l1.B("isUseErrorReport : ", z, LogU.Companion, "SettingLaboratoryFragment");
        SettingItemView settingItemView0 = this.mErrorReportRadioContainer;
        q.d(settingItemView0);
        settingItemView0.setRadioOnOff(z);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onStart() {
        super.onStart();
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onStop() {
        super.onStop();
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.initUI();
    }

    public final void setPlaylistManager(@NotNull s2 s20) {
        q.g(s20, "<set-?>");
        this.playlistManager = s20;
    }

    public final void toastMessageDisplay(boolean z) {
        ToastManager.show((z ? 0x7F1309A2 : 0x7F1309A1));  // string:setting_laboratory_toast_on "On 설정되었습니다."
    }
}

