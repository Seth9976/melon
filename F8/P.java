package F8;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import kotlin.jvm.internal.q;

public final class p extends w {
    public final int g;
    public ImageView h;

    public p(int v) {
        this.g = v;
    }

    @Override  // F8.o
    public final View c(Context context0) {
        ImageView imageView0 = new ImageView(context0);
        this.h = imageView0;
        imageView0.setPadding(ScreenUtils.dipToPixel(context0, 16.0f), 0, 0, 0);
        ImageView imageView1 = this.h;
        if(imageView1 != null) {
            imageView1.setTag("BackButton");
            this.j(this.g);
            View view0 = this.h;
            if(view0 != null) {
                return view0;
            }
            q.m("imageView");
            throw null;
        }
        q.m("imageView");
        throw null;
    }

    @Override  // F8.o
    public final View d(View view0) {
        q.g(view0, "newView");
        return view0;
    }

    @Override  // F8.o
    public final String e(Context context0) {
        q.f("이전페이지 가기", "getString(...)");
        return "이전페이지 가기";
    }

    @Override  // F8.w
    public final String f(Context context0) {
        q.f("뒤로가기", "getString(...)");
        return "뒤로가기";
    }

    @Override  // F8.w
    public final int i() {
        return 2;
    }

    public final void j(int v) {
        switch(v) {
            case 0: {
                ImageView imageView0 = this.h;
                if(imageView0 != null) {
                    imageView0.setImageResource(0x7F0801CC);  // drawable:btn_gnb_back_w_old
                    ImageView imageView1 = this.h;
                    if(imageView1 != null) {
                        imageView1.setImageTintList(null);
                        return;
                    }
                    q.m("imageView");
                    throw null;
                }
                q.m("imageView");
                throw null;
            }
            case 1: {
                ImageView imageView2 = this.h;
                if(imageView2 != null) {
                    imageView2.setImageResource(0x7F0801CA);  // drawable:btn_gnb_back_old
                    ImageView imageView3 = this.h;
                    if(imageView3 != null) {
                        imageView3.setImageTintList(ColorUtils.getColorStateList(imageView3.getContext(), 0x7F06016D));  // color:gray900s
                        return;
                    }
                    q.m("imageView");
                    throw null;
                }
                q.m("imageView");
                throw null;
            }
            case 2: {
                ImageView imageView4 = this.h;
                if(imageView4 != null) {
                    imageView4.setImageResource(0x7F0801CA);  // drawable:btn_gnb_back_old
                    ImageView imageView5 = this.h;
                    if(imageView5 != null) {
                        imageView5.setImageTintList(null);
                        return;
                    }
                    q.m("imageView");
                    throw null;
                }
                q.m("imageView");
                throw null;
            }
            case 3: {
                ImageView imageView6 = this.h;
                if(imageView6 != null) {
                    imageView6.setImageResource(0x7F0801CA);  // drawable:btn_gnb_back_old
                    ImageView imageView7 = this.h;
                    if(imageView7 != null) {
                        imageView7.setImageTintList(ColorUtils.getColorStateList(imageView7.getContext(), 0x7F06016E));  // color:gray901s
                        return;
                    }
                    q.m("imageView");
                    throw null;
                }
                q.m("imageView");
                throw null;
            }
        }
    }
}

