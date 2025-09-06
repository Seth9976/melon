package J8;

import De.I;
import Q4.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.iloen.melon.custom.MelonTextView;

public final class g2 implements a {
    public final int a;
    public final MelonTextView b;
    public final MelonTextView c;
    public final ViewGroup d;
    public final ImageView e;
    public final Object f;

    public g2(ViewGroup viewGroup0, ImageView imageView0, View view0, MelonTextView melonTextView0, MelonTextView melonTextView1, int v) {
        this.a = v;
        this.d = viewGroup0;
        this.e = imageView0;
        this.f = view0;
        this.b = melonTextView0;
        this.c = melonTextView1;
        super();
    }

    public g2(ConstraintLayout constraintLayout0, MelonTextView melonTextView0, LottieAnimationView lottieAnimationView0, b b0, MelonTextView melonTextView1) {
        this.a = 0;
        super();
        this.d = constraintLayout0;
        this.b = melonTextView0;
        this.e = lottieAnimationView0;
        this.f = b0;
        this.c = melonTextView1;
    }

    public static g2 a(LayoutInflater layoutInflater0, ViewGroup viewGroup0) {
        View view0 = layoutInflater0.inflate(0x7F0D05AB, viewGroup0, false);  // layout:popup_listitem
        int v = 0x7F0A0546;  // id:icon
        View view1 = I.C(view0, 0x7F0A0546);  // id:icon
        if(((ImageView)view1) != null && ((ImageView)I.C(view0, 0x7F0A054F)) != null) {  // id:icon_right
            v = 0x7F0A0B49;  // id:text
            View view2 = I.C(view0, 0x7F0A0B49);  // id:text
            if(((MelonTextView)view2) != null) {
                v = 0x7F0A0CCA;  // id:tv_new
                View view3 = I.C(view0, 0x7F0A0CCA);  // id:tv_new
                if(((MelonTextView)view3) != null) {
                    return new g2(((RelativeLayout)view0), ((ImageView)view1), ((RelativeLayout)view0), ((MelonTextView)view2), ((MelonTextView)view3), 1);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // Q4.a
    public final View getRoot() {
        switch(this.a) {
            case 0: {
                return (ConstraintLayout)this.d;
            }
            case 1: {
                return (RelativeLayout)this.d;
            }
            case 2: {
                return (ConstraintLayout)this.d;
            }
            default: {
                return (CardView)this.d;
            }
        }
    }
}

