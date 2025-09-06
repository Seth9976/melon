package J8;

import De.I;
import Q4.a;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.iloen.melon.custom.BorderImageView;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;

public final class x implements a {
    public final int a;
    public final ViewGroup b;
    public final Object c;
    public final Object d;

    public x(ViewGroup viewGroup0, View view0, Object object0, int v) {
        this.a = v;
        this.b = viewGroup0;
        this.d = view0;
        this.c = object0;
        super();
    }

    public x(ViewGroup viewGroup0, Object object0, Object object1, int v) {
        this.a = v;
        this.b = viewGroup0;
        this.c = object0;
        this.d = object1;
        super();
    }

    public static x a(View view0) {
        int v = 0x7F0A0638;  // id:iv_info
        ImageView imageView0 = (ImageView)I.C(view0, 0x7F0A0638);  // id:iv_info
        if(imageView0 != null) {
            v = 0x7F0A0D34;  // id:tv_title
            MelonTextView melonTextView0 = (MelonTextView)I.C(view0, 0x7F0A0D34);  // id:tv_title
            if(melonTextView0 != null) {
                return new x(((RelativeLayout)view0), imageView0, melonTextView0, 3);
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    public static x b(View view0) {
        int v = 0x7F0A069B;  // id:iv_thumb_circle
        BorderImageView borderImageView0 = (BorderImageView)I.C(view0, 0x7F0A069B);  // id:iv_thumb_circle
        if(borderImageView0 != null) {
            v = 0x7F0A069C;  // id:iv_thumb_circle_default
            ImageView imageView0 = (ImageView)I.C(view0, 0x7F0A069C);  // id:iv_thumb_circle_default
            if(imageView0 != null && ((ImageView)I.C(view0, 0x7F0A069D)) != null) {  // id:iv_thumb_circle_default_bg
                return new x(((FrameLayout)view0), borderImageView0, imageView0, 6);
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    public static x c(View view0) {
        int v = 0x7F0A011C;  // id:bottom_gradation
        View view1 = I.C(view0, 0x7F0A011C);  // id:bottom_gradation
        if(view1 != null && ((ImageView)I.C(view0, 0x7F0A0559)) != null) {  // id:imageView2
            v = 0x7F0A069A;  // id:iv_thumb
            MelonImageView melonImageView0 = (MelonImageView)I.C(view0, 0x7F0A069A);  // id:iv_thumb
            if(melonImageView0 != null && ((ImageView)I.C(view0, 0x7F0A069E)) != null) {  // id:iv_thumb_default
                return new x(((ConstraintLayout)view0), view1, melonImageView0, 7);
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // Q4.a
    public final View getRoot() {
        switch(this.a) {
            case 0: {
                return (ConstraintLayout)this.b;
            }
            case 1: {
                return (RelativeLayout)this.b;
            }
            case 2: {
                return (LinearLayoutCompat)this.b;
            }
            case 3: {
                return (RelativeLayout)this.b;
            }
            case 4: {
                return (LinearLayout)this.b;
            }
            case 5: {
                return (LinearLayoutCompat)this.b;
            }
            case 6: {
                return (FrameLayout)this.b;
            }
            case 7: {
                return (ConstraintLayout)this.b;
            }
            case 8: {
                return (CardView)this.b;
            }
            case 9: {
                return (ConstraintLayout)this.b;
            }
            default: {
                return (RelativeLayout)this.b;
            }
        }
    }
}

