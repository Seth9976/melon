package F8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.iloen.melon.utils.system.ScreenUtils;
import kotlin.jvm.internal.q;

public final class r extends w {
    public final int g;

    public r(int v) {
        this.g = v;
        super();
    }

    @Override  // F8.o
    public boolean b() {
        return this.g == 1 ? false : super.b();
    }

    @Override  // F8.o
    public final View c(Context context0) {
        if(this.g != 0) {
            View view0 = new ImageView(context0);
            ((ImageView)view0).setImageResource(0x7F08063D);  // drawable:img_gnb_music_melonlogo
            view0.setPadding(ScreenUtils.dipToPixel(context0, 20.0f), 0, 0, 0);
            view0.setImportantForAccessibility(2);
            return view0;
        }
        View view1 = LayoutInflater.from(context0).inflate(0x7F0D0885, null);  // layout:titlebar_left_cancel_button
        q.f(view1, "inflate(...)");
        return view1;
    }

    @Override  // F8.o
    public final View d(View view0) {
        if(this.g != 0) {
            q.g(view0, "newView");
            return view0;
        }
        q.g(view0, "newView");
        return view0.findViewById(0x7F0A0143);  // id:btn_bg
    }

    @Override  // F8.o
    public final String e(Context context0) {
        if(this.g != 0) {
            return "";
        }
        q.f("취소", "getString(...)");
        return "취소";
    }

    @Override  // F8.w
    public String f(Context context0) {
        return this.g == 1 ? "멜론홈" : super.f(context0);
    }

    @Override  // F8.w
    public final int i() {
        return this.g == 0 ? 5 : 0;
    }
}

