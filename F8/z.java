package F8;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import kotlin.jvm.internal.q;

public final class z extends T {
    public final int g;

    public z(int v) {
        this.g = v;
    }

    @Override  // F8.o
    public final View c(Context context0) {
        View view0 = new ImageView(context0);
        LinearLayout.LayoutParams linearLayout$LayoutParams0 = new LinearLayout.LayoutParams(-2, -2);
        linearLayout$LayoutParams0.rightMargin = ScreenUtils.dipToPixel(context0, 16.0f);
        view0.setLayoutParams(linearLayout$LayoutParams0);
        view0.setTag("CloseButton");
        switch(this.g) {
            case 0: {
                ((ImageView)view0).setImageResource(0x7F0801D1);  // drawable:btn_gnb_close_w
                return view0;
            }
            case 1: {
                ((ImageView)view0).setImageResource(0x7F0801CF);  // drawable:btn_gnb_close
                return view0;
            }
            case 2: {
                ((ImageView)view0).setImageResource(0x7F080279);  // drawable:btn_title_trans
                return view0;
            }
            case 3: {
                ((ImageView)view0).setImageResource(0x7F0801CF);  // drawable:btn_gnb_close
                ((ImageView)view0).setImageTintList(ColorUtils.getColorStateList(context0, 0x7F06016D));  // color:gray900s
                return view0;
            }
            case 4: {
                ((ImageView)view0).setImageResource(0x7F0801E2);  // drawable:btn_gnb_web_ca_close
                return view0;
            }
            default: {
                return view0;
            }
        }
    }

    @Override  // F8.o
    public final View d(View view0) {
        q.g(view0, "newView");
        return view0;
    }

    @Override  // F8.o
    public final String e(Context context0) {
        q.f("닫기", "getString(...)");
        return "닫기";
    }

    @Override  // F8.T
    public final int i() {
        return 9;
    }
}

