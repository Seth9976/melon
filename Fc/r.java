package Fc;

import Ad.n;
import Dd.g2;
import De.I;
import J8.b;
import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.o;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.O0;
import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.c;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.utils.color.ColorUtils;
import com.melon.playlist.interfaces.PlayableData;
import dagger.hilt.android.internal.managers.ViewComponentManager.FragmentContextWrapper;
import kotlin.jvm.internal.q;

public final class r extends c {
    public final g2 a;
    public int b;
    public boolean c;

    public r(ViewComponentManager.FragmentContextWrapper viewComponentManager$FragmentContextWrapper0, g2 g20) {
        super(viewComponentManager$FragmentContextWrapper0, null);
        this.a = g20;
    }

    @Override  // com.iloen.melon.adapters.common.y
    public final void onBindViewHolder(O0 o00, int v, int v1) {
        q.g(((Fc.q)o00), "vh");
        q.g(((Fc.q)o00), "vh");
        PlayableData playableData0 = (PlayableData)this.getItem(v1);
        q.d(playableData0);
        boolean z = v1 == this.b;
        boolean z1 = this.c;
        Context context0 = ((Fc.q)o00).b;
        J8.g2 g20 = ((Fc.q)o00).a;
        g2 g21 = this.a;
        q.g(g21, "onEvent");
        if(z) {
            LottieAnimationView lottieAnimationView0 = (LottieAnimationView)g20.e;
            int v2 = ColorUtils.getColor(context0, 0x7F060179);  // color:green490e
            g20.c.setTextColor(v2);
            TextUtils.TruncateAt textUtils$TruncateAt0 = TextUtils.TruncateAt.MARQUEE;
            g20.c.setEllipsize(textUtils$TruncateAt0);
            g20.b.setEllipsize(textUtils$TruncateAt0);
            g20.c.setSelected(true);
            g20.b.setSelected(true);
            if(!z1) {
                lottieAnimationView0.cancelAnimation();
            }
            else if(!lottieAnimationView0.isAnimating()) {
                lottieAnimationView0.playAnimation();
            }
            lottieAnimationView0.setVisibility(0);
        }
        else {
            int v3 = ColorUtils.getColor(context0, 0x7F0604A1);  // color:white000e
            g20.c.setTextColor(v3);
            TextUtils.TruncateAt textUtils$TruncateAt1 = TextUtils.TruncateAt.END;
            g20.c.setEllipsize(textUtils$TruncateAt1);
            g20.b.setEllipsize(textUtils$TruncateAt1);
            ((LottieAnimationView)g20.e).cancelAnimation();
            ((LottieAnimationView)g20.e).setVisibility(8);
        }
        n n0 = new n(g21, playableData0, v1, 3);
        ((ConstraintLayout)g20.d).setOnClickListener(n0);
        g20.c.setText(playableData0.h);
        g20.b.setText(playableData0.i);
        Glide.with(context0).load(playableData0.m).into(((MelonImageView)((b)g20.f).c));
    }

    @Override  // androidx.recyclerview.widget.j0
    public final O0 onCreateViewHolder(ViewGroup viewGroup0, int v) {
        q.g(viewGroup0, "parent");
        View view0 = o.e(viewGroup0, 0x7F0D04AD, viewGroup0, false);  // layout:listitem_song_item_cover_screen
        int v1 = 0x7F0A00B1;  // id:artist
        View view1 = I.C(view0, 0x7F0A00B1);  // id:artist
        if(((MelonTextView)view1) != null) {
            v1 = 0x7F0A0658;  // id:iv_now_playing
            View view2 = I.C(view0, 0x7F0A0658);  // id:iv_now_playing
            if(((LottieAnimationView)view2) != null) {
                v1 = 0x7F0A0B72;  // id:thumb_container
                View view3 = I.C(view0, 0x7F0A0B72);  // id:thumb_container
                if(view3 != null) {
                    b b0 = b.b(view3);
                    v1 = 0x7F0A0B8D;  // id:title
                    View view4 = I.C(view0, 0x7F0A0B8D);  // id:title
                    if(((MelonTextView)view4) != null) {
                        J8.g2 g20 = new J8.g2(((ConstraintLayout)view0), ((MelonTextView)view1), ((LottieAnimationView)view2), b0, ((MelonTextView)view4));
                        Context context0 = viewGroup0.getContext();
                        q.f(context0, "getContext(...)");
                        return new Fc.q(g20, context0);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v1));
    }
}

