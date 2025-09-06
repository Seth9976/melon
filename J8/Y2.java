package J8;

import De.I;
import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public final class y2 implements a {
    public final RelativeLayout a;
    public final ImageView b;
    public final e3 c;

    public y2(RelativeLayout relativeLayout0, ImageView imageView0, e3 e30) {
        this.a = relativeLayout0;
        this.b = imageView0;
        this.c = e30;
    }

    public static y2 a(LayoutInflater layoutInflater0, ViewGroup viewGroup0) {
        View view0 = layoutInflater0.inflate(0x7F0D0511, viewGroup0, false);  // layout:member_profile_thumb
        int v = 0x7F0A060E;  // id:iv_camera
        ImageView imageView0 = (ImageView)I.C(view0, 0x7F0A060E);  // id:iv_camera
        if(imageView0 != null) {
            v = 0x7F0A0B79;  // id:thumb_layout
            View view1 = I.C(view0, 0x7F0A0B79);  // id:thumb_layout
            if(view1 != null) {
                return new y2(((RelativeLayout)view0), imageView0, e3.a(view1));
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // Q4.a
    public final View getRoot() {
        return this.a;
    }
}

