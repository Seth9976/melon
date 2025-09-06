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

public final class h2 implements a {
    public final LinearLayout a;
    public final ImageView b;
    public final ImageView c;
    public final LinearLayout d;
    public final RelativeLayout e;
    public final ImageView f;
    public final RelativeLayout g;
    public final f3 h;
    public final LinearLayout i;
    public final MelonTextView j;
    public final MelonTextView k;
    public final MelonTextView l;
    public final MelonTextView m;
    public final MelonTextView n;
    public final View o;
    public final LinearLayout p;
    public final RelativeLayout q;

    public h2(LinearLayout linearLayout0, ImageView imageView0, ImageView imageView1, LinearLayout linearLayout1, RelativeLayout relativeLayout0, ImageView imageView2, RelativeLayout relativeLayout1, f3 f30, LinearLayout linearLayout2, MelonTextView melonTextView0, MelonTextView melonTextView1, MelonTextView melonTextView2, MelonTextView melonTextView3, MelonTextView melonTextView4, View view0, LinearLayout linearLayout3, RelativeLayout relativeLayout2) {
        this.a = linearLayout0;
        this.b = imageView0;
        this.c = imageView1;
        this.d = linearLayout1;
        this.e = relativeLayout0;
        this.f = imageView2;
        this.g = relativeLayout1;
        this.h = f30;
        this.i = linearLayout2;
        this.j = melonTextView0;
        this.k = melonTextView1;
        this.l = melonTextView2;
        this.m = melonTextView3;
        this.n = melonTextView4;
        this.o = view0;
        this.p = linearLayout3;
        this.q = relativeLayout2;
    }

    public static h2 a(LayoutInflater layoutInflater0, ViewGroup viewGroup0) {
        View view0 = layoutInflater0.inflate(0x7F0D04AE, viewGroup0, false);  // layout:listitem_song_new
        int v = 0x7F0A00B7;  // id:artist_layout
        if(((LinearLayout)I.C(view0, 0x7F0A00B7)) != null) {  // id:artist_layout
            v = 0x7F0A0169;  // id:btn_info
            View view1 = I.C(view0, 0x7F0A0169);  // id:btn_info
            if(((ImageView)view1) != null) {
                v = 0x7F0A0182;  // id:btn_play
                View view2 = I.C(view0, 0x7F0A0182);  // id:btn_play
                if(((ImageView)view2) != null) {
                    v = 0x7F0A0184;  // id:btn_play_container
                    View view3 = I.C(view0, 0x7F0A0184);  // id:btn_play_container
                    if(((LinearLayout)view3) != null) {
                        v = 0x7F0A024B;  // id:chart_layout
                        View view4 = I.C(view0, 0x7F0A024B);  // id:chart_layout
                        if(((RelativeLayout)view4) != null) {
                            v = 0x7F0A0610;  // id:iv_check
                            View view5 = I.C(view0, 0x7F0A0610);  // id:iv_check
                            if(((ImageView)view5) != null && ((ImageView)I.C(view0, 0x7F0A061D)) != null && (((ImageView)I.C(view0, 0x7F0A062F)) != null && ((ImageView)I.C(view0, 0x7F0A0651)) != null) && (((ImageView)I.C(view0, 0x7F0A0680)) != null && ((FrameLayout)I.C(view0, 0x7F0A075A)) != null && ((RelativeLayout)I.C(view0, 0x7F0A0807)) != null)) {  // id:iv_delete
                                v = 0x7F0A08EA;  // id:origin_song_layout
                                View view6 = I.C(view0, 0x7F0A08EA);  // id:origin_song_layout
                                if(((RelativeLayout)view6) != null && ((FrameLayout)I.C(view0, 0x7F0A09FA)) != null) {  // id:right_layout
                                    v = 0x7F0A0B72;  // id:thumb_container
                                    View view7 = I.C(view0, 0x7F0A0B72);  // id:thumb_container
                                    if(view7 != null) {
                                        f3 f30 = f3.a(view7);
                                        v = 0x7F0A0B96;  // id:title_container
                                        if(((LinearLayout)I.C(view0, 0x7F0A0B96)) != null) {  // id:title_container
                                            v = 0x7F0A0B9E;  // id:title_layout
                                            View view8 = I.C(view0, 0x7F0A0B9E);  // id:title_layout
                                            if(((LinearLayout)view8) != null) {
                                                v = 0x7F0A0C12;  // id:tv_artist
                                                View view9 = I.C(view0, 0x7F0A0C12);  // id:tv_artist
                                                if(((MelonTextView)view9) != null && ((MelonTextView)I.C(view0, 0x7F0A0C81)) != null) {  // id:tv_foru_recom
                                                    v = 0x7F0A0C9C;  // id:tv_list_change
                                                    View view10 = I.C(view0, 0x7F0A0C9C);  // id:tv_list_change
                                                    if(((MelonTextView)view10) != null) {
                                                        v = 0x7F0A0CA3;  // id:tv_list_ranking
                                                        View view11 = I.C(view0, 0x7F0A0CA3);  // id:tv_list_ranking
                                                        if(((MelonTextView)view11) != null && ((MelonTextView)I.C(view0, 0x7F0A0CA4)) != null) {  // id:tv_listen_count
                                                            v = 0x7F0A0CF5;  // id:tv_ranking
                                                            View view12 = I.C(view0, 0x7F0A0CF5);  // id:tv_ranking
                                                            if(((MelonTextView)view12) != null && ((MelonTextView)I.C(view0, 0x7F0A0D32)) != null) {  // id:tv_timestamp
                                                                v = 0x7F0A0D34;  // id:tv_title
                                                                View view13 = I.C(view0, 0x7F0A0D34);  // id:tv_title
                                                                if(((MelonTextView)view13) != null) {
                                                                    v = 0x7F0A0D6B;  // id:underline
                                                                    View view14 = I.C(view0, 0x7F0A0D6B);  // id:underline
                                                                    if(view14 != null) {
                                                                        v = 0x7F0A0D79;  // id:updown_layout
                                                                        View view15 = I.C(view0, 0x7F0A0D79);  // id:updown_layout
                                                                        if(((LinearLayout)view15) != null) {
                                                                            v = 0x7F0A0DF5;  // id:wrapper_layout
                                                                            View view16 = I.C(view0, 0x7F0A0DF5);  // id:wrapper_layout
                                                                            if(((RelativeLayout)view16) != null) {
                                                                                return new h2(((LinearLayout)view0), ((ImageView)view1), ((ImageView)view2), ((LinearLayout)view3), ((RelativeLayout)view4), ((ImageView)view5), ((RelativeLayout)view6), f30, ((LinearLayout)view8), ((MelonTextView)view9), ((MelonTextView)view10), ((MelonTextView)view11), ((MelonTextView)view12), ((MelonTextView)view13), view14, ((LinearLayout)view15), ((RelativeLayout)view16));
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

