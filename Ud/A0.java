package ud;

import androidx.fragment.app.I;
import com.iloen.melon.fragments.MelonBottomSheetBaseFragment;
import com.iloen.melon.utils.system.ScreenUtils;
import kotlin.Metadata;
import td.L;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lud/a0;", "Lcom/iloen/melon/fragments/MelonBottomSheetBaseFragment;", "<init>", "()V", "ud/Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class a0 extends MelonBottomSheetBaseFragment {
    public L a;

    @Override  // com.iloen.melon.fragments.MelonBottomSheetBaseFragment
    public final int getPeekHeight() {
        return ScreenUtils.dipToPixel(this.getContext(), 399.0f);
    }

    @Override  // com.iloen.melon.fragments.MelonBottomSheetBaseFragment
    public final int getTitleBarHeight() {
        return ScreenUtils.dipToPixel(this.getContext(), 56.0f);
    }

    @Override  // com.iloen.melon.fragments.MelonBottomSheetBaseFragment
    public final I newFragment() {
        return new Z(this.a);
    }
}

