package F8;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import kotlin.jvm.internal.q;

public final class k extends n {
    @Override  // F8.o
    public final View c(Context context0) {
        View view0 = new ImageView(context0);
        ((ImageView)view0).setImageResource(0x7F08082D);  // drawable:selector_img_gnb_melon_bi
        view0.setContentDescription("멜론 로고");
        return view0;
    }

    @Override  // F8.o
    public final View d(View view0) {
        q.g(view0, "newView");
        return view0;
    }

    @Override  // F8.o
    public final String e(Context context0) {
        q.f("멜론 로고", "getString(...)");
        return "멜론 로고";
    }
}

