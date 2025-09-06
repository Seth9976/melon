package ud;

import android.os.Bundle;
import androidx.fragment.app.I;
import com.iloen.melon.fragments.MelonBottomSheetBaseFragment;
import com.iloen.melon.fragments.comments.CmtListFragment.Param;
import com.iloen.melon.utils.system.ScreenUtils;
import kotlin.jvm.internal.q;

public final class j extends MelonBottomSheetBaseFragment {
    public final I a;
    public final Param b;

    public j(I i0, Param cmtListFragment$Param0) {
        this.a = i0;
        this.b = cmtListFragment$Param0;
    }

    @Override  // com.iloen.melon.fragments.MelonBottomSheetBaseFragment
    public final int getPeekHeight() {
        return ScreenUtils.dipToPixel(this.getContext(), 469.0f);
    }

    @Override  // com.iloen.melon.fragments.MelonBottomSheetBaseFragment
    public final int getTitleBarHeight() {
        return ScreenUtils.dipToPixel(this.getContext(), 57.0f);
    }

    @Override  // com.iloen.melon.fragments.MelonBottomSheetBaseFragment
    public final I newFragment() {
        q.g(this.a, "f");
        I i0 = new i(this.a);
        Bundle bundle0 = new Bundle();
        bundle0.putSerializable("argCmtParam", this.b);
        i0.setArguments(bundle0);
        return i0;
    }
}

