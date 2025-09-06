package com.iloen.melon.fragments.settings;

import Q8.d;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import b3.Z;
import com.android.volley.VolleyError;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.SettingItemView;
import com.iloen.melon.fragments.musicmessage.e;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.StreamingDeviceInfoReq;
import com.iloen.melon.net.v4x.response.StreamingDeviceInfoRes.RESPONSE.Mine;
import com.iloen.melon.net.v4x.response.StreamingDeviceInfoRes.RESPONSE;
import com.iloen.melon.net.v4x.response.StreamingDeviceInfoRes;
import com.iloen.melon.utils.FileUtils;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import ie.H;
import k9.b;
import k9.h;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.i;
import va.e0;
import va.o;
import x8.f;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0006\b\u0007\u0018\u0000 #2\u00020\u0001:\u0002#$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000F\u001A\u00020\u000EH\u0014¢\u0006\u0004\b\u000F\u0010\u0010J-\u0010\u0018\u001A\u0004\u0018\u00010\u00172\u0006\u0010\u0012\u001A\u00020\u00112\b\u0010\u0014\u001A\u0004\u0018\u00010\u00132\b\u0010\u0016\u001A\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J!\u0010\u001B\u001A\u00020\u000B2\u0006\u0010\u001A\u001A\u00020\u00172\b\u0010\u0016\u001A\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u001B\u0010\u001CJ-\u0010!\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u00042\b\u0010\u001E\u001A\u0004\u0018\u00010\u001D2\b\u0010 \u001A\u0004\u0018\u00010\u001FH\u0014¢\u0006\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingOfflinePlayback;", "Lcom/iloen/melon/fragments/settings/SettingBaseFragment;", "<init>", "()V", "Lv9/i;", "type", "", "requestGetPremiumDevices", "(Lv9/i;)Z", "Lcom/iloen/melon/net/v4x/response/StreamingDeviceInfoRes$RESPONSE;", "response", "Lie/H;", "applyResponse", "(Lcom/iloen/melon/net/v4x/response/StreamingDeviceInfoRes$RESPONSE;)V", "", "getTitleResId", "()I", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lv9/h;", "param", "", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Companion", "DeleteFileAsyncTask", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SettingOfflinePlayback extends SettingBaseFragment {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001A\u00020\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingOfflinePlayback$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/settings/SettingOfflinePlayback;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final SettingOfflinePlayback newInstance() {
            return new SettingOfflinePlayback();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001A\u0010\u0007\u001A\u00020\u00032\b\u0010\u0006\u001A\u0004\u0018\u00010\u0002H\u0096@¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\n\u001A\u00020\u00032\b\u0010\t\u001A\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingOfflinePlayback$DeleteFileAsyncTask;", "Lx8/f;", "Ljava/lang/Void;", "Lie/H;", "<init>", "()V", "param", "backgroundWork", "(Ljava/lang/Void;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "result", "postTask", "(Lie/H;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class DeleteFileAsyncTask extends f {
        @Override  // x8.f
        public Object backgroundWork(Object object0, Continuation continuation0) {
            return this.backgroundWork(((Void)object0), continuation0);
        }

        @Nullable
        public Object backgroundWork(@Nullable Void void0, @NotNull Continuation continuation0) {
            LogU.d("OfflineContentsManager", "deleteStorage()");
            d.a.d();
            h.j();
            b.a.g();
            Context context0 = MelonAppBase.instance.getContext();
            FileUtils.deleteSubFiles(u9.f.g.b(context0, "offline").f, true);
            return H.a;
        }

        public void postTask(@Nullable H h0) {
            ToastManager.show(0x7F1307C4);  // string:offline_playback_manage_storage_delete_completion "오프라인 파일이 삭제되었습니다."
        }

        @Override  // x8.f
        public void postTask(Object object0) {
            this.postTask(((H)object0));
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "SettingOfflinePlayback";

    static {
        SettingOfflinePlayback.Companion = new Companion(null);
        SettingOfflinePlayback.$stable = 8;
    }

    public static void K() {
        SettingOfflinePlayback.onViewCreated$lambda$3$lambda$2();
    }

    public static void M(SettingOfflinePlayback settingOfflinePlayback0, i i0, StreamingDeviceInfoRes streamingDeviceInfoRes0) {
        SettingOfflinePlayback.requestGetPremiumDevices$lambda$4(settingOfflinePlayback0, i0, streamingDeviceInfoRes0);
    }

    public static void N(boolean z) {
        SettingOfflinePlayback.onViewCreated$lambda$1$lambda$0(z);
    }

    private final void applyResponse(RESPONSE streamingDeviceInfoRes$RESPONSE0) {
        if(streamingDeviceInfoRes$RESPONSE0.deviceList.isEmpty()) {
            return;
        }
        View view0 = this.findViewById(0x7F0A03C0);  // id:device_layout
        q.e(view0, "null cannot be cast to non-null type android.view.View");
        view0.setVisibility(0);
        View view1 = this.findViewById(0x7F0A0891);  // id:my_device
        q.e(view1, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView)view1).setText(((Mine)streamingDeviceInfoRes$RESPONSE0.deviceList.get(0)).modelName);
        View view2 = this.findViewById(0x7F0A09DB);  // id:registration_date
        q.e(view2, "null cannot be cast to non-null type android.widget.TextView");
        String s = this.getString(0x7F1307C9);  // string:offline_playback_registration_device_date "%1$s 등록"
        q.f(s, "getString(...)");
        Z.y(new Object[]{((Mine)streamingDeviceInfoRes$RESPONSE0.deviceList.get(0)).dpDate}, 1, s, ((TextView)view2));
        View view3 = this.findViewById(0x7F0A03C1);  // id:device_max_cnt
        q.e(view3, "null cannot be cast to non-null type android.widget.TextView");
        String s1 = this.getString(0x7F1307CA);  // string:offline_playback_registration_device_desc "오프라인 재생을 위한 기기 인증은 1대 입니다.\n1달에 
                                                 // %1$d번 변경이 가능합니다."
        q.f(s1, "getString(...)");
        Z.y(new Object[]{streamingDeviceInfoRes$RESPONSE0.maxCnt}, 1, s1, ((TextView)view3));
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public int getTitleResId() {
        return 0x7F1307CC;  // string:offline_playback_title "오프라인 재생 설정"
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D0837, viewGroup0, false);  // layout:setting_offline_playback
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable v9.h h0, @Nullable String s) {
        return this.requestGetPremiumDevices(i0);
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        View view1 = view0.findViewById(0x7F0A03EE);  // id:download_only_wifi
        q.e(view1, "null cannot be cast to non-null type com.iloen.melon.custom.SettingItemView");
        ((SettingItemView)view1).setViewType(12);
        ((SettingItemView)view1).setRadioOnOff(MelonSettingInfo.getPremiumOfflineDownloadOnlyWiFi());
        ((SettingItemView)view1).setRadioBtnClickListener(new e(16));
        View view2 = view0.findViewById(0x7F0A039E);  // id:delete_storage
        q.e(view2, "null cannot be cast to non-null type com.iloen.melon.custom.SettingItemView");
        ((SettingItemView)view2).setViewType(11);
        ((SettingItemView)view2).setButtonClickListener(new e(17));
        this.calculateScrollView(this.findViewById(0x7F0A0A78));  // id:setting_scrollview
    }

    private static final void onViewCreated$lambda$1$lambda$0(boolean z) {
        MelonSettingInfo.setPremiumOfflineDownloadOnlyWiFi(z);
        ToastManager.show((z ? 0x7F1307BC : 0x7F1307BB));  // string:offline_playback_manage_download_only_wifi_on "Wi-Fi에서만 오프라인 파일을 저장합니다."
    }

    private static final void onViewCreated$lambda$3$lambda$2() {
        f.execute$default(new DeleteFileAsyncTask(), null, 1, null);
    }

    private final boolean requestGetPremiumDevices(i i0) {
        if(!((e0)o.a()).m()) {
            return false;
        }
        RequestBuilder.newInstance(new StreamingDeviceInfoReq(this.getContext())).tag("SettingOfflinePlayback").listener(new F(this, i0, 2)).errorListener(new s(this, 3)).request();
        return true;
    }

    private static final void requestGetPremiumDevices$lambda$4(SettingOfflinePlayback settingOfflinePlayback0, i i0, StreamingDeviceInfoRes streamingDeviceInfoRes0) {
        if(!settingOfflinePlayback0.prepareFetchComplete(streamingDeviceInfoRes0)) {
            return;
        }
        RESPONSE streamingDeviceInfoRes$RESPONSE0 = streamingDeviceInfoRes0.response;
        q.f(streamingDeviceInfoRes$RESPONSE0, "response");
        settingOfflinePlayback0.applyResponse(streamingDeviceInfoRes$RESPONSE0);
        settingOfflinePlayback0.performFetchComplete(i0, streamingDeviceInfoRes0);
    }

    private static final void requestGetPremiumDevices$lambda$5(SettingOfflinePlayback settingOfflinePlayback0, VolleyError volleyError0) {
        settingOfflinePlayback0.showProgress(false);
    }
}

