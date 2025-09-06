package J8;

import De.I;
import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.iloen.melon.custom.CheckableTextView;
import com.iloen.melon.custom.MelonTextView;

public final class x0 implements a {
    public final ConstraintLayout a;
    public final CheckableTextView b;
    public final View c;
    public final RelativeLayout d;
    public final RelativeLayout e;
    public final View f;
    public final MelonTextView g;
    public final MelonTextView h;

    public x0(ConstraintLayout constraintLayout0, CheckableTextView checkableTextView0, View view0, RelativeLayout relativeLayout0, RelativeLayout relativeLayout1, View view1, MelonTextView melonTextView0, MelonTextView melonTextView1) {
        this.a = constraintLayout0;
        this.b = checkableTextView0;
        this.c = view0;
        this.d = relativeLayout0;
        this.e = relativeLayout1;
        this.f = view1;
        this.g = melonTextView0;
        this.h = melonTextView1;
    }

    public static x0 a(LayoutInflater layoutInflater0, ViewGroup viewGroup0) {
        View view0 = layoutInflater0.inflate(0x7F0D0236, viewGroup0, false);  // layout:detail_songlist_header
        int v = 0x7F0A01A9;  // id:btn_select_all
        View view1 = I.C(view0, 0x7F0A01A9);  // id:btn_select_all
        if(((CheckableTextView)view1) != null) {
            v = 0x7F0A0627;  // id:iv_dot
            View view2 = I.C(view0, 0x7F0A0627);  // id:iv_dot
            if(view2 != null) {
                v = 0x7F0A0758;  // id:left_container
                View view3 = I.C(view0, 0x7F0A0758);  // id:left_container
                if(((RelativeLayout)view3) != null) {
                    v = 0x7F0A09F7;  // id:right_container
                    View view4 = I.C(view0, 0x7F0A09F7);  // id:right_container
                    if(((RelativeLayout)view4) != null) {
                        v = 0x7F0A0AC5;  // id:space_view
                        View view5 = I.C(view0, 0x7F0A0AC5);  // id:space_view
                        if(view5 != null) {
                            v = 0x7F0A0C9D;  // id:tv_list_cnt
                            View view6 = I.C(view0, 0x7F0A0C9D);  // id:tv_list_cnt
                            if(((MelonTextView)view6) != null) {
                                v = 0x7F0A0CA2;  // id:tv_list_play_time
                                View view7 = I.C(view0, 0x7F0A0CA2);  // id:tv_list_play_time
                                if(((MelonTextView)view7) != null) {
                                    return new x0(((ConstraintLayout)view0), ((CheckableTextView)view1), view2, ((RelativeLayout)view3), ((RelativeLayout)view4), view5, ((MelonTextView)view6), ((MelonTextView)view7));
                                }
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

