package com.iloen.melon.custom;

import Ad.n;
import Cb.k;
import De.I;
import J8.J0;
import U4.x;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.j0;
import com.bumptech.glide.Glide;
import com.iloen.melon.utils.log.LogU;
import com.melon.net.res.common.MvInfoBase;
import java.util.ArrayList;
import kotlin.jvm.internal.q;

public final class r extends j0 {
    public final Context a;
    public final ArrayList b;
    public final ControllerVideoListView c;

    public r(ControllerVideoListView controllerVideoListView0, Context context0) {
        this.c = controllerVideoListView0;
        super();
        this.a = context0;
        this.b = new ArrayList();
    }

    @Override  // androidx.recyclerview.widget.j0
    public final int getItemCount() {
        LogU.debug$default(this.c.getLog(), x.e(this.b.size(), "getItemCount = "), null, false, 6, null);
        return this.b.size();
    }

    @Override  // androidx.recyclerview.widget.j0
    public final void onBindViewHolder(O0 o00, int v) {
        q.g(o00, "holder");
        if(o00 instanceof s) {
            Object object0 = this.b.get(v);
            q.f(object0, "get(...)");
            J0 j00 = ((s)o00).a;
            ControllerVideoListView controllerVideoListView0 = ((s)o00).b;
            Context context0 = controllerVideoListView0.getContext();
            if(context0 != null) {
                Glide.with(context0).load(((MvInfoBase)object0).mv169Img).into(((MelonImageView)j00.d));
            }
            MelonTextView melonTextView0 = (MelonTextView)j00.g;
            String s = ((MvInfoBase)object0).playTime;
            if(s == null) {
                s = "";
            }
            melonTextView0.setText(k.f(s));
            ((MelonTextView)j00.b).setText(((MvInfoBase)object0).mvName);
            String s1 = ((MvInfoBase)object0).getArtistNames();
            ((MelonTextView)j00.f).setText(s1);
            j00.c.setVisibility((((MvInfoBase)object0).isAdult ? 0 : 8));
            n n0 = new n(controllerVideoListView0, ((MvInfoBase)object0), v, 5);
            ((s)o00).itemView.setOnClickListener(n0);
        }
    }

    @Override  // androidx.recyclerview.widget.j0
    public final O0 onCreateViewHolder(ViewGroup viewGroup0, int v) {
        q.g(viewGroup0, "parent");
        View view0 = LayoutInflater.from(this.a).inflate(0x7F0D08F9, viewGroup0, false);  // layout:video_player_video_item
        int v1 = 0x7F0A0212;  // id:cardview
        if(((CardView)I.C(view0, 0x7F0A0212)) != null) {  // id:cardview
            v1 = 0x7F0A05F9;  // id:iv_badge_19
            View view1 = I.C(view0, 0x7F0A05F9);  // id:iv_badge_19
            if(((ImageView)view1) != null && ((MelonImageView)I.C(view0, 0x7F0A061B)) != null) {  // id:iv_default_thumb
                v1 = 0x7F0A069A;  // id:iv_thumb
                View view2 = I.C(view0, 0x7F0A069A);  // id:iv_thumb
                if(((MelonImageView)view2) != null && ((ConstraintLayout)I.C(view0, 0x7F0A0B72)) != null) {  // id:thumb_container
                    v1 = 0x7F0A0C12;  // id:tv_artist
                    View view3 = I.C(view0, 0x7F0A0C12);  // id:tv_artist
                    if(((MelonTextView)view3) != null) {
                        v1 = 0x7F0A0CE5;  // id:tv_playtime
                        View view4 = I.C(view0, 0x7F0A0CE5);  // id:tv_playtime
                        if(((MelonTextView)view4) != null) {
                            v1 = 0x7F0A0D50;  // id:tv_video_title
                            View view5 = I.C(view0, 0x7F0A0D50);  // id:tv_video_title
                            if(((MelonTextView)view5) != null) {
                                J0 j00 = new J0(((ConstraintLayout)view0), ((ImageView)view1), ((MelonImageView)view2), ((MelonTextView)view3), ((MelonTextView)view4), ((MelonTextView)view5));
                                return new s(this.c, j00);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v1));
    }
}

