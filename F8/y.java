package F8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import kotlin.jvm.internal.q;

public final class y extends T {
    public final String g;
    public final RequestManager h;
    public final boolean i;

    public y(String s, RequestManager requestManager0, boolean z) {
        this.g = s;
        this.h = requestManager0;
        this.i = z;
    }

    @Override  // F8.o
    public final View c(Context context0) {
        View view0 = LayoutInflater.from(context0).inflate(0x7F0D088A, null);  // layout:titlebar_right_cash_friends_button
        ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A00ED);  // id:banner
        RequestManager requestManager0 = this.h;
        if(requestManager0 != null) {
            RequestBuilder requestBuilder0 = requestManager0.load(this.g);
            if(requestBuilder0 != null) {
                requestBuilder0.into(imageView0);
            }
        }
        imageView0.setColorFilter(ColorUtils.getColor(context0, 0x7F06016D));  // color:gray900s
        ViewUtils.showWhen(view0.findViewById(0x7F0A09D5), this.i);  // id:red_dot
        return view0;
    }

    @Override  // F8.o
    public final View d(View view0) {
        q.g(view0, "newView");
        return view0;
    }

    @Override  // F8.o
    public final String e(Context context0) {
        q.f("캐시 프렌즈 열기", "getString(...)");
        return "캐시 프렌즈 열기";
    }

    @Override  // F8.T
    public final int i() {
        return 3;
    }
}

