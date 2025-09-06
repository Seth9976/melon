package com.iloen.melon.fragments.melonchart;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.l0;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.ToolBar;
import com.iloen.melon.fragments.DetailMetaContentBaseFragment;
import com.iloen.melon.utils.preference.MelonPrefs;
import com.melon.ui.popup.b;
import je.w;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vd.f;

@Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\'\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0004¢\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0006\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0003J\u0011\u0010\b\u001A\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\b\u0010\t¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/MelonChartBaseFragment;", "Lcom/iloen/melon/fragments/DetailMetaContentBaseFragment;", "<init>", "()V", "Lie/H;", "checkAndShowBanPopup", "onPause", "Lcom/iloen/melon/custom/ToolBar;", "buildToolBar", "()Lcom/iloen/melon/custom/ToolBar;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class MelonChartBaseFragment extends DetailMetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/MelonChartBaseFragment$Companion;", "", "<init>", "()V", "TEXT_SIZE_10", "", "TEXT_SIZE_12", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    public static final float TEXT_SIZE_10 = 10.0f;
    public static final float TEXT_SIZE_12 = 12.0f;

    static {
        MelonChartBaseFragment.Companion = new Companion(null);
        MelonChartBaseFragment.$stable = 8;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public ToolBar buildToolBar() {
        View view0 = this.findViewById(0x7F0A0BC6);  // id:toolbar_layout
        q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.ToolBar");
        return ToolBar.f(((ToolBar)view0), 1000);
    }

    public final void checkAndShowBanPopup() {
        if(MelonPrefs.getInstance().getBoolean("chartBanPopupShownBefore", false)) {
            return;
        }
        FragmentActivity fragmentActivity0 = this.getActivity();
        if(fragmentActivity0 != null) {
            l0 l00 = fragmentActivity0.getSupportFragmentManager();
            if(l00 != null && !Y.z(MelonAppBase.Companion) && !l00.T() && !l00.K) {
                l00.C();
                if(b.b(l00, "showChartInfoPopup", null, null, 12) == null) {
                    f f0 = new f();
                    f0.e = "재생목록 담지 않기 안내";
                    f0.f = "차트에서 듣고 싶지 않은 아티스트/장르가 있다면 재생목록에 담기지 않도록 설정할 수 있습니다.\n\n방법: 설정 > 제외 콘텐츠 관리 > 아티스트/장르 선택";
                    f0.h = w.a;
                    f0.g = null;
                    f0.show(l00, "showChartInfoPopup");
                }
            }
        }
        MelonPrefs.getInstance().setBoolean("chartBanPopupShownBefore", true);
    }

    @Override  // com.iloen.melon.fragments.DetailMetaContentBaseFragment
    public void onPause() {
        this.setSelectAllWithToolbar(false);
        super.onPause();
    }
}

