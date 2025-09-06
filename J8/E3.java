package J8;

import De.I;
import Q4.a;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.iloen.melon.custom.BorderImageView;

public final class e3 implements a {
    public final FrameLayout a;
    public final BorderImageView b;
    public final ImageView c;

    public e3(FrameLayout frameLayout0, BorderImageView borderImageView0, ImageView imageView0) {
        this.a = frameLayout0;
        this.b = borderImageView0;
        this.c = imageView0;
    }

    public static e3 a(View view0) {
        int v = 0x7F0A069B;  // id:iv_thumb_circle
        BorderImageView borderImageView0 = (BorderImageView)I.C(view0, 0x7F0A069B);  // id:iv_thumb_circle
        if(borderImageView0 != null) {
            v = 0x7F0A069C;  // id:iv_thumb_circle_default
            ImageView imageView0 = (ImageView)I.C(view0, 0x7F0A069C);  // id:iv_thumb_circle_default
            if(imageView0 != null && ((ImageView)I.C(view0, 0x7F0A069D)) != null) {  // id:iv_thumb_circle_default_bg
                return new e3(((FrameLayout)view0), borderImageView0, imageView0);
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

