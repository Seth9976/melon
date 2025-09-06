package com.iloen.melon.fragments.settings;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iloen.melon.custom.RadioGroup;
import com.iloen.melon.utils.network.ServerPhase;
import com.iloen.melon.utils.system.AppUtils;
import com.melon.ui.popup.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0007\u001A\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\n\u001A\u00020\t2\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\b\u0010\u000E\u001A\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0013\u001A\u00020\u00042\u0006\u0010\u0012\u001A\u00020\u000F2\b\u0010\u000E\u001A\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingServerPhaseFragment;", "Lcom/iloen/melon/fragments/settings/SettingBaseFragment;", "<init>", "()V", "Lie/H;", "initView", "", "getTitleResId", "()I", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SettingServerPhaseFragment extends SettingBaseFragment {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001A\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingServerPhaseFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/settings/SettingServerPhaseFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final SettingServerPhaseFragment newInstance() {
            return new SettingServerPhaseFragment();
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;

    static {
        SettingServerPhaseFragment.Companion = new Companion(null);
        SettingServerPhaseFragment.$stable = 8;
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public int getTitleResId() {
        return 0x7F1309CD;  // string:setting_server_phase_title "도메인 설정"
    }

    private final void initView() {
        View view0 = this.findViewById(0x7F0A09A8);  // id:radiogroup_server_phase
        q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.RadioGroup");
        String s = ServerPhase.INSTANCE.getDomainPrefix();
        if("rel-".equals(s)) {
            ((RadioGroup)view0).a(0x7F0A09DD);  // id:rel_layout
        }
        else if("cbt-".equals(s)) {
            ((RadioGroup)view0).a(0x7F0A0236);  // id:cbt_layout
        }
        else if("sandbox-".equals(s)) {
            ((RadioGroup)view0).a(0x7F0A0A1D);  // id:sandbox_layout
        }
        else {
            ((RadioGroup)view0).a(0x7F0A0967);  // id:prod_layout
        }
        ((RadioGroup)view0).setOnCheckedChangeListener(new s(this, 5));
    }

    private static final void initView$lambda$1(SettingServerPhaseFragment settingServerPhaseFragment0, RadioGroup radioGroup0, int v) {
        int v1;
        H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
        h0.a = "prod-";
        switch(v) {
            case 0x7F0A0236: {  // id:cbt_layout
                h0.a = "cbt-";
                v1 = 0x7F1309C7;  // string:setting_server_phase_cbt_domain "CBT 서버"
                break;
            }
            case 0x7F0A09DD: {  // id:rel_layout
                h0.a = "rel-";
                v1 = 0x7F1309CA;  // string:setting_server_phase_rel_domain "REL 서버"
                break;
            }
            case 0x7F0A0A1D: {  // id:sandbox_layout
                h0.a = "sandbox-";
                v1 = 0x7F1309CB;  // string:setting_server_phase_sandbox_domain "SANDBOX 서버"
                break;
            }
            default: {
                v1 = 0x7F1309C9;  // string:setting_server_phase_prod_domain "상용 서버"
            }
        }
        b.x(settingServerPhaseFragment0.getChildFragmentManager(), settingServerPhaseFragment0.getString(0x7F130227), settingServerPhaseFragment0.getString(0x7F1309CC, new Object[]{settingServerPhaseFragment0.getString(v1)}), false, false, null, null, new j(1, h0, settingServerPhaseFragment0), null, null, null, 0xEF8);  // string:confirm "확인"
    }

    private static final ie.H initView$lambda$1$lambda$0(H h0, SettingServerPhaseFragment settingServerPhaseFragment0) {
        ServerPhase.INSTANCE.setDomainPrefix(((String)h0.a));
        Context context0 = settingServerPhaseFragment0.requireContext();
        q.f(context0, "requireContext(...)");
        AppUtils.restart(context0);
        return ie.H.a;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D083B, viewGroup0, false);  // layout:setting_server_phase
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.initView();
    }
}

