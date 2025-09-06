package jd;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.I;
import b3.Z;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.iloen.melon.fragments.MelonBottomSheetBaseFragment;
import com.iloen.melon.net.v6x.response.EventPopupUiModel;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.system.ScreenUtils;
import kotlin.jvm.internal.q;

public final class h extends MelonBottomSheetBaseFragment {
    public final EventPopupUiModel a;

    public h(EventPopupUiModel eventPopupUiModel0) {
        q.g(eventPopupUiModel0, "event");
        super();
        this.a = eventPopupUiModel0;
        Z.g("EventBottomSheetFragment", true).setCategory(Category.UI);
    }

    @Override  // com.iloen.melon.fragments.MelonBottomSheetBaseFragment
    public final int getTitleBarHeight() {
        return (int)(((float)ScreenUtils.getScreenHeight(this.getContext())) * 0.43f);
    }

    @Override  // com.iloen.melon.fragments.MelonBottomSheetBaseFragment
    public final I newFragment() {
        q.g(this.a, "event");
        return new g(this.a);
    }

    @Override  // com.iloen.melon.fragments.MelonBottomSheetBaseFragment
    public final void onViewCreated(View view0, Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        Dialog dialog0 = this.getDialog();
        BottomSheetDialog bottomSheetDialog0 = dialog0 instanceof BottomSheetDialog ? ((BottomSheetDialog)dialog0) : null;
        if(bottomSheetDialog0 != null) {
            BottomSheetBehavior bottomSheetBehavior0 = bottomSheetDialog0.e();
            if(bottomSheetBehavior0 != null) {
                bottomSheetBehavior0.g0 = false;
            }
        }
    }

    @Override  // com.iloen.melon.fragments.MelonBottomSheetBaseFragment
    public final boolean useDirectExpand() {
        return true;
    }
}

