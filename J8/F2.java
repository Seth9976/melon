package J8;

import De.I;
import Q4.a;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.iloen.melon.custom.MelonTextView;

public final class f2 implements a {
    public final LinearLayout a;
    public final ImageView b;
    public final ImageView c;
    public final b d;
    public final f3 e;
    public final LinearLayout f;
    public final MelonTextView g;
    public final MelonTextView h;
    public final View i;
    public final RelativeLayout j;

    public f2(LinearLayout linearLayout0, ImageView imageView0, ImageView imageView1, b b0, f3 f30, LinearLayout linearLayout1, MelonTextView melonTextView0, MelonTextView melonTextView1, View view0, RelativeLayout relativeLayout0) {
        this.a = linearLayout0;
        this.b = imageView0;
        this.c = imageView1;
        this.d = b0;
        this.e = f30;
        this.f = linearLayout1;
        this.g = melonTextView0;
        this.h = melonTextView1;
        this.i = view0;
        this.j = relativeLayout0;
    }

    public static f2 a(View view0) {
        int v = 0x7F0A00B7;  // id:artist_layout
        if(((LinearLayout)I.C(view0, 0x7F0A00B7)) != null) {  // id:artist_layout
            v = 0x7F0A0169;  // id:btn_info
            View view1 = I.C(view0, 0x7F0A0169);  // id:btn_info
            if(((ImageView)view1) != null) {
                v = 0x7F0A0182;  // id:btn_play
                View view2 = I.C(view0, 0x7F0A0182);  // id:btn_play
                if(((ImageView)view2) != null && ((LinearLayout)I.C(view0, 0x7F0A0184)) != null && ((RelativeLayout)I.C(view0, 0x7F0A024B)) != null) {  // id:btn_play_container
                    v = 0x7F0A0569;  // id:include_btn_edit
                    View view3 = I.C(view0, 0x7F0A0569);  // id:include_btn_edit
                    if(view3 != null) {
                        b b0 = new b(((MelonTextView)view3), ((MelonTextView)view3), 3);
                        v = 0x7F0A0610;  // id:iv_check
                        if(((ImageView)I.C(view0, 0x7F0A0610)) != null && ((ImageView)I.C(view0, 0x7F0A061D)) != null && (((ImageView)I.C(view0, 0x7F0A062F)) != null && ((ImageView)I.C(view0, 0x7F0A0651)) != null) && (((ImageView)I.C(view0, 0x7F0A0680)) != null && ((FrameLayout)I.C(view0, 0x7F0A075A)) != null && (((RelativeLayout)I.C(view0, 0x7F0A0807)) != null && ((RelativeLayout)I.C(view0, 0x7F0A08EA)) != null)) && ((FrameLayout)I.C(view0, 0x7F0A09FA)) != null) {  // id:iv_check
                            v = 0x7F0A0B72;  // id:thumb_container
                            View view4 = I.C(view0, 0x7F0A0B72);  // id:thumb_container
                            if(view4 != null) {
                                f3 f30 = f3.a(view4);
                                v = 0x7F0A0B96;  // id:title_container
                                if(((LinearLayout)I.C(view0, 0x7F0A0B96)) != null) {  // id:title_container
                                    v = 0x7F0A0B9E;  // id:title_layout
                                    View view5 = I.C(view0, 0x7F0A0B9E);  // id:title_layout
                                    if(((LinearLayout)view5) != null) {
                                        v = 0x7F0A0C12;  // id:tv_artist
                                        View view6 = I.C(view0, 0x7F0A0C12);  // id:tv_artist
                                        if(((MelonTextView)view6) != null && ((MelonTextView)I.C(view0, 0x7F0A0C81)) != null && (((MelonTextView)I.C(view0, 0x7F0A0C9C)) != null && ((MelonTextView)I.C(view0, 0x7F0A0CA3)) != null) && (((MelonTextView)I.C(view0, 0x7F0A0CA4)) != null && ((MelonTextView)I.C(view0, 0x7F0A0CF5)) != null && ((MelonTextView)I.C(view0, 0x7F0A0D32)) != null)) {  // id:tv_foru_recom
                                            v = 0x7F0A0D34;  // id:tv_title
                                            View view7 = I.C(view0, 0x7F0A0D34);  // id:tv_title
                                            if(((MelonTextView)view7) != null) {
                                                v = 0x7F0A0D6B;  // id:underline
                                                View view8 = I.C(view0, 0x7F0A0D6B);  // id:underline
                                                if(view8 != null && ((LinearLayout)I.C(view0, 0x7F0A0D79)) != null) {  // id:updown_layout
                                                    v = 0x7F0A0DF5;  // id:wrapper_layout
                                                    View view9 = I.C(view0, 0x7F0A0DF5);  // id:wrapper_layout
                                                    if(((RelativeLayout)view9) != null) {
                                                        return new f2(((LinearLayout)view0), ((ImageView)view1), ((ImageView)view2), b0, f30, ((LinearLayout)view5), ((MelonTextView)view6), ((MelonTextView)view7), view8, ((RelativeLayout)view9));
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

