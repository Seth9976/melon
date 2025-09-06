package J8;

import De.I;
import Q4.a;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.iloen.melon.custom.MelonImageView;

public final class f3 implements a {
    public final FrameLayout a;
    public final MelonImageView b;
    public final ImageView c;
    public final ImageView d;

    public f3(FrameLayout frameLayout0, MelonImageView melonImageView0, ImageView imageView0, ImageView imageView1) {
        this.a = frameLayout0;
        this.b = melonImageView0;
        this.c = imageView0;
        this.d = imageView1;
    }

    public static f3 a(View view0) {
        int v = 0x7F0A069A;  // id:iv_thumb
        MelonImageView melonImageView0 = (MelonImageView)I.C(view0, 0x7F0A069A);  // id:iv_thumb
        if(melonImageView0 != null) {
            v = 0x7F0A069E;  // id:iv_thumb_default
            ImageView imageView0 = (ImageView)I.C(view0, 0x7F0A069E);  // id:iv_thumb_default
            if(imageView0 != null) {
                v = 0x7F0A06A4;  // id:iv_thumb_stroke
                ImageView imageView1 = (ImageView)I.C(view0, 0x7F0A06A4);  // id:iv_thumb_stroke
                if(imageView1 != null) {
                    return new f3(((FrameLayout)view0), melonImageView0, imageView0, imageView1);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

