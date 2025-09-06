package J8;

import De.I;
import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.iloen.melon.custom.MelonTextView;

public final class x1 implements a {
    public final FrameLayout a;
    public final MelonTextView b;
    public final f3 c;
    public final RelativeLayout d;
    public final ImageView e;
    public final MelonTextView f;

    public x1(FrameLayout frameLayout0, MelonTextView melonTextView0, f3 f30, RelativeLayout relativeLayout0, ImageView imageView0, MelonTextView melonTextView1) {
        this.a = frameLayout0;
        this.b = melonTextView0;
        this.c = f30;
        this.d = relativeLayout0;
        this.e = imageView0;
        this.f = melonTextView1;
    }

    public static x1 a(LayoutInflater layoutInflater0, ViewGroup viewGroup0) {
        View view0 = layoutInflater0.inflate(0x7F0D0457, viewGroup0, false);  // layout:listitem_artist_artist_note
        int v = 0x7F0A03B2;  // id:description_tv
        View view1 = I.C(view0, 0x7F0A03B2);  // id:description_tv
        if(((MelonTextView)view1) != null) {
            v = 0x7F0A056B;  // id:include_thumbnail_layout
            View view2 = I.C(view0, 0x7F0A056B);  // id:include_thumbnail_layout
            if(view2 != null) {
                f3 f30 = f3.a(view2);
                v = 0x7F0A05B7;  // id:item_layout
                View view3 = I.C(view0, 0x7F0A05B7);  // id:item_layout
                if(((RelativeLayout)view3) != null) {
                    v = 0x7F0A091E;  // id:play_iv
                    View view4 = I.C(view0, 0x7F0A091E);  // id:play_iv
                    if(((ImageView)view4) != null) {
                        v = 0x7F0A0BAA;  // id:title_tv
                        View view5 = I.C(view0, 0x7F0A0BAA);  // id:title_tv
                        if(((MelonTextView)view5) != null) {
                            return new x1(((FrameLayout)view0), ((MelonTextView)view1), f30, ((RelativeLayout)view3), ((ImageView)view4), ((MelonTextView)view5));
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

