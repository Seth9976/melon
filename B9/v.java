package B9;

import android.content.Context;
import android.content.res.Resources;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.custom.tablayout.ScrollableAlyacFilter;

public final class v extends O0 {
    public final ScrollableAlyacFilter a;
    public static final int b;

    public v(ScrollableAlyacFilter scrollableAlyacFilter0) {
        super(scrollableAlyacFilter0);
        int v;
        this.a = scrollableAlyacFilter0;
        Context context0 = this.itemView.getContext();
        if(context0 == null) {
            v = 0;
        }
        else {
            Resources resources0 = context0.getResources();
            v = resources0 == null ? 0 : ((int)resources0.getDimension(0x7F0700E3));  // dimen:detail_list_padding_left_right
        }
        scrollableAlyacFilter0.setPadding(v);
    }
}

