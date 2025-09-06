package J8;

import De.I;
import Q4.a;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.compose.ui.platform.ComposeView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.iloen.melon.custom.CheckableImageView;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;

public final class r1 implements a {
    public final FrameLayout a;
    public final View b;
    public final ImageView c;
    public final CheckableImageView d;
    public final MelonTextView e;
    public final ImageView f;
    public final MelonImageView g;
    public final ConstraintLayout h;
    public final FrameLayout i;
    public final ComposeView j;
    public final ConstraintLayout k;
    public final MelonTextView l;
    public final View m;
    public final MelonTextView n;
    public final MelonTextView o;
    public final MelonTextView p;

    public r1(FrameLayout frameLayout0, View view0, ImageView imageView0, CheckableImageView checkableImageView0, MelonTextView melonTextView0, ImageView imageView1, MelonImageView melonImageView0, ConstraintLayout constraintLayout0, FrameLayout frameLayout1, ComposeView composeView0, ConstraintLayout constraintLayout1, MelonTextView melonTextView1, View view1, MelonTextView melonTextView2, MelonTextView melonTextView3, MelonTextView melonTextView4) {
        this.a = frameLayout0;
        this.b = view0;
        this.c = imageView0;
        this.d = checkableImageView0;
        this.e = melonTextView0;
        this.f = imageView1;
        this.g = melonImageView0;
        this.h = constraintLayout0;
        this.i = frameLayout1;
        this.j = composeView0;
        this.k = constraintLayout1;
        this.l = melonTextView1;
        this.m = view1;
        this.n = melonTextView2;
        this.o = melonTextView3;
        this.p = melonTextView4;
    }

    public static r1 a(View view0) {
        int v = 0x7F0A0119;  // id:bottom_dim
        View view1 = I.C(view0, 0x7F0A0119);  // id:bottom_dim
        if(view1 != null) {
            v = 0x7F0A014E;  // id:btn_comment
            View view2 = I.C(view0, 0x7F0A014E);  // id:btn_comment
            if(((ImageView)view2) != null) {
                v = 0x7F0A0170;  // id:btn_liked
                View view3 = I.C(view0, 0x7F0A0170);  // id:btn_liked
                if(((CheckableImageView)view3) != null) {
                    v = 0x7F0A02F6;  // id:comment_cnt
                    View view4 = I.C(view0, 0x7F0A02F6);  // id:comment_cnt
                    if(((MelonTextView)view4) != null && ((ImageView)I.C(view0, 0x7F0A05F1)) != null) {  // id:iv_arrow
                        v = 0x7F0A05F8;  // id:iv_badge
                        View view5 = I.C(view0, 0x7F0A05F8);  // id:iv_badge
                        if(((ImageView)view5) != null) {
                            v = 0x7F0A05FD;  // id:iv_banner_thumb
                            View view6 = I.C(view0, 0x7F0A05FD);  // id:iv_banner_thumb
                            if(((MelonImageView)view6) != null && ((ConstraintLayout)I.C(view0, 0x7F0A06FD)) != null && ((CardView)I.C(view0, 0x7F0A06FF)) != null) {  // id:layout_back
                                v = 0x7F0A0700;  // id:layout_banner_info
                                View view7 = I.C(view0, 0x7F0A0700);  // id:layout_banner_info
                                if(((ConstraintLayout)view7) != null) {
                                    v = 0x7F0A0701;  // id:layout_banner_thumb
                                    View view8 = I.C(view0, 0x7F0A0701);  // id:layout_banner_thumb
                                    if(((FrameLayout)view8) != null) {
                                        v = 0x7F0A071A;  // id:layout_extra_info
                                        View view9 = I.C(view0, 0x7F0A071A);  // id:layout_extra_info
                                        if(((ComposeView)view9) != null && ((ConstraintLayout)I.C(view0, 0x7F0A071F)) != null) {  // id:layout_info
                                            v = 0x7F0A0739;  // id:layout_reaction
                                            View view10 = I.C(view0, 0x7F0A0739);  // id:layout_reaction
                                            if(((ConstraintLayout)view10) != null && ((ConstraintLayout)I.C(view0, 0x7F0A0744)) != null) {  // id:layout_song_info
                                                v = 0x7F0A076B;  // id:liked_cnt
                                                View view11 = I.C(view0, 0x7F0A076B);  // id:liked_cnt
                                                if(((MelonTextView)view11) != null) {
                                                    v = 0x7F0A0BCF;  // id:top_gradient
                                                    View view12 = I.C(view0, 0x7F0A0BCF);  // id:top_gradient
                                                    if(view12 != null) {
                                                        v = 0x7F0A0C22;  // id:tv_banner_info
                                                        View view13 = I.C(view0, 0x7F0A0C22);  // id:tv_banner_info
                                                        if(((MelonTextView)view13) != null) {
                                                            v = 0x7F0A0CAD;  // id:tv_main_title
                                                            View view14 = I.C(view0, 0x7F0A0CAD);  // id:tv_main_title
                                                            if(((MelonTextView)view14) != null) {
                                                                v = 0x7F0A0D1E;  // id:tv_sub_title
                                                                View view15 = I.C(view0, 0x7F0A0D1E);  // id:tv_sub_title
                                                                if(((MelonTextView)view15) != null) {
                                                                    return new r1(((FrameLayout)view0), view1, ((ImageView)view2), ((CheckableImageView)view3), ((MelonTextView)view4), ((ImageView)view5), ((MelonImageView)view6), ((ConstraintLayout)view7), ((FrameLayout)view8), ((ComposeView)view9), ((ConstraintLayout)view10), ((MelonTextView)view11), view12, ((MelonTextView)view13), ((MelonTextView)view14), ((MelonTextView)view15));
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
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

