package J8;

import De.I;
import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.iloen.melon.custom.MelonTextView;

public final class r implements a {
    public final LinearLayout a;
    public final ImageView b;
    public final f3 c;
    public final MelonTextView d;
    public final MelonTextView e;
    public final RelativeLayout f;

    public r(LinearLayout linearLayout0, ImageView imageView0, f3 f30, MelonTextView melonTextView0, MelonTextView melonTextView1, RelativeLayout relativeLayout0) {
        this.a = linearLayout0;
        this.b = imageView0;
        this.c = f30;
        this.d = melonTextView0;
        this.e = melonTextView1;
        this.f = relativeLayout0;
    }

    public static r a(LayoutInflater layoutInflater0, ViewGroup viewGroup0) {
        View view0 = layoutInflater0.inflate(0x7F0D0132, viewGroup0, false);  // layout:cast_program_bottom_listitem
        int v = 0x7F0A0658;  // id:iv_now_playing
        View view1 = I.C(view0, 0x7F0A0658);  // id:iv_now_playing
        if(((ImageView)view1) != null && ((FrameLayout)I.C(view0, 0x7F0A075A)) != null && ((RelativeLayout)I.C(view0, 0x7F0A0807)) != null) {  // id:left_layout
            v = 0x7F0A0B72;  // id:thumb_container
            View view2 = I.C(view0, 0x7F0A0B72);  // id:thumb_container
            if(view2 != null) {
                f3 f30 = f3.a(view2);
                v = 0x7F0A0B96;  // id:title_container
                if(((LinearLayout)I.C(view0, 0x7F0A0B96)) != null) {  // id:title_container
                    v = 0x7F0A0C59;  // id:tv_date
                    View view3 = I.C(view0, 0x7F0A0C59);  // id:tv_date
                    if(((MelonTextView)view3) != null) {
                        v = 0x7F0A0D34;  // id:tv_title
                        View view4 = I.C(view0, 0x7F0A0D34);  // id:tv_title
                        if(((MelonTextView)view4) != null) {
                            v = 0x7F0A0DF5;  // id:wrapper_layout
                            View view5 = I.C(view0, 0x7F0A0DF5);  // id:wrapper_layout
                            if(((RelativeLayout)view5) != null) {
                                return new r(((LinearLayout)view0), ((ImageView)view1), f30, ((MelonTextView)view3), ((MelonTextView)view4), ((RelativeLayout)view5));
                            }
                        }
                    }
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

