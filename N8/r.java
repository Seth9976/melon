package n8;

import android.os.BaseBundle;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.I;
import com.iloen.melon.fragments.MelonBaseFragment;
import com.iloen.melon.utils.log.LogU;
import java.util.ArrayList;

public final class r extends q {
    @Override  // androidx.fragment.app.N0
    public final void restoreState(Parcelable parcelable0, ClassLoader classLoader0) {
        if(parcelable0 != null) {
            int v = ((Bundle)parcelable0).getInt("pages");
            if(v > 0) {
                ArrayList arrayList0 = this.a;
                if(v == arrayList0.size()) {
                    for(int v1 = 0; v1 < v; ++v1) {
                        int v2 = ((Bundle)parcelable0).getInt("pageIndex:" + v1);
                        I i0 = this.b.K(((Bundle)parcelable0), "page:" + v2);
                        if(i0 instanceof MelonBaseFragment) {
                            arrayList0.set(v2, ((MelonBaseFragment)i0));
                        }
                    }
                }
            }
            super.restoreState(((Bundle)parcelable0).getParcelable("superState"), classLoader0);
        }
    }

    @Override  // androidx.fragment.app.N0
    public final Parcelable saveState() {
        LogU.v("TabPagerCacheAdapter", "saveState()");
        Parcelable parcelable0 = super.saveState();
        Parcelable parcelable1 = new Bundle();
        ((Bundle)parcelable1).putParcelable("superState", parcelable0);
        ArrayList arrayList0 = this.a;
        ((BaseBundle)parcelable1).putInt("pages", arrayList0.size());
        if(arrayList0.size() > 0) {
            for(int v = 0; v < arrayList0.size(); ++v) {
                ((BaseBundle)parcelable1).putInt("pageIndex:" + v, v);
                I i0 = (I)arrayList0.get(v);
                if(i0 != null && i0.getActivity() != null && !i0.getActivity().isFinishing() && i0.isAdded()) {
                    this.b.a0(((Bundle)parcelable1), "page:" + v, i0);
                }
            }
        }
        return parcelable1;
    }
}

