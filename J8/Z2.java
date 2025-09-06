package J8;

import De.I;
import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.iloen.melon.custom.CoverView;
import com.iloen.melon.custom.MelonTextView;

public final class z2 implements a {
    public final ConstraintLayout a;

    public z2(ConstraintLayout constraintLayout0) {
        this.a = constraintLayout0;
    }

    public static z2 a(LayoutInflater layoutInflater0) {
        View view0 = layoutInflater0.inflate(0x7F0D051C, null, false);  // layout:mix_maker_playlist_detail_header
        if(((CoverView)I.C(view0, 0x7F0A0355)) == null || ((ConstraintLayout)I.C(view0, 0x7F0A0371)) == null || (((ImageView)I.C(view0, 0x7F0A065E)) == null || ((FrameLayout)I.C(view0, 0x7F0A0939)) == null) || (((MelonTextView)I.C(view0, 0x7F0A0CDB)) == null || ((MelonTextView)I.C(view0, 0x7F0A0CDC)) == null || ((MelonTextView)I.C(view0, 0x7F0A0CE3)) == null)) {  // id:cover_view
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(0x7F0A0355));  // id:cover_view
        }
        return new z2(((ConstraintLayout)view0));
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

