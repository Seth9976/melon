package J8;

import De.I;
import Q4.a;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.cardview.widget.CardView;
import com.google.android.exoplayer2.ui.PlayerView;
import com.iloen.melon.custom.MelonEditText;
import com.iloen.melon.custom.MelonTextView;

public final class u implements a {
    public final int a;
    public final View b;
    public final ViewGroup c;
    public final View d;
    public final View e;

    public u(ViewGroup viewGroup0, View view0, View view1, View view2, int v) {
        this.a = v;
        this.c = viewGroup0;
        this.d = view0;
        this.b = view1;
        this.e = view2;
        super();
    }

    public u(FrameLayout frameLayout0, MelonTextView melonTextView0, LinearLayout linearLayout0, MelonTextView melonTextView1) {
        this.a = 1;
        super();
        this.d = frameLayout0;
        this.b = melonTextView0;
        this.c = linearLayout0;
        this.e = melonTextView1;
    }

    public u(LinearLayout linearLayout0, MelonTextView melonTextView0, MelonTextView melonTextView1, View view0, RelativeLayout relativeLayout0) {
        this.a = 3;
        super();
        this.c = linearLayout0;
        this.b = melonTextView0;
        this.d = melonTextView1;
        this.e = view0;
    }

    public u(CardView cardView0, MelonTextView melonTextView0, MelonTextView melonTextView1, MelonTextView melonTextView2) {
        this.a = 5;
        super();
        this.c = cardView0;
        this.b = melonTextView0;
        this.d = melonTextView1;
        this.e = melonTextView2;
    }

    public static u a(View view0) {
        int v = 0x7F0A0412;  // id:edt_register
        View view1 = I.C(view0, 0x7F0A0412);  // id:edt_register
        if(((MelonEditText)view1) != null && ((RelativeLayout)I.C(view0, 0x7F0A09DA)) != null) {  // id:register_text_container
            v = 0x7F0A0C2D;  // id:tv_btn_register
            View view2 = I.C(view0, 0x7F0A0C2D);  // id:tv_btn_register
            if(((MelonTextView)view2) != null) {
                v = 0x7F0A0D6B;  // id:underline
                View view3 = I.C(view0, 0x7F0A0D6B);  // id:underline
                if(view3 != null) {
                    return new u(((LinearLayout)view0), ((MelonEditText)view1), ((MelonTextView)view2), view3, 0);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    public static u b(View view0) {
        int v = 0x7F0A0465;  // id:exo_player_view
        View view1 = I.C(view0, 0x7F0A0465);  // id:exo_player_view
        if(((PlayerView)view1) != null) {
            v = 0x7F0A055F;  // id:img_default
            View view2 = I.C(view0, 0x7F0A055F);  // id:img_default
            if(((ImageView)view2) != null) {
                v = 0x7F0A0565;  // id:img_still
                View view3 = I.C(view0, 0x7F0A0565);  // id:img_still
                if(((ImageView)view3) != null) {
                    return new u(((FrameLayout)view0), ((PlayerView)view1), ((ImageView)view2), ((ImageView)view3), 2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // Q4.a
    public final View getRoot() {
        switch(this.a) {
            case 0: {
                return (LinearLayout)this.c;
            }
            case 1: {
                return (FrameLayout)this.d;
            }
            case 2: {
                return (FrameLayout)this.c;
            }
            case 3: {
                return (LinearLayout)this.c;
            }
            case 4: {
                return (RelativeLayout)this.c;
            }
            default: {
                return (CardView)this.c;
            }
        }
    }
}

