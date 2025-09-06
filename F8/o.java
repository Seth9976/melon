package F8;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.iloen.melon.utils.system.ScreenUtils;
import kotlin.jvm.internal.q;

public final class O extends T {
    public final float g;

    public O(float f) {
        this.g = f;
    }

    @Override  // F8.o
    public final View c(Context context0) {
        View view0 = new ImageView(context0);
        view0.setPadding(0, 0, ScreenUtils.dipToPixel(context0, this.g), 0);
        ((ImageView)view0).setImageResource(0x7F080112);  // drawable:btn_comment_reload
        return view0;
    }

    @Override  // F8.o
    public final View d(View view0) {
        q.g(view0, "newView");
        return view0;
    }

    @Override  // F8.o
    public final String e(Context context0) {
        q.f("새로고침", "getString(...)");
        return "새로고침";
    }

    @Override  // F8.T
    public final int i() {
        return 0;
    }
}

