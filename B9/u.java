package B9;

import J8.J0;
import J8.Q1;
import Tf.v;
import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.O0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.iloen.melon.custom.CheckableImageView;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.net.v4x.common.ArtistPlayListInfoBase;
import com.iloen.melon.net.v6x.common.DjPlayListRankingInfo;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.net.res.common.DjPlayListInfoBase;
import kotlin.jvm.internal.q;

public final class u extends O0 {
    public final J0 a;
    public static final int b;

    public u(J0 j00, r r0) {
        super(((RelativeLayout)j00.b));
        this.a = j00;
        Context context0 = ((RelativeLayout)j00.b).getContext();
        int v = ScreenUtils.dipToPixel(context0, r0.a);
        int v1 = ScreenUtils.dipToPixel(context0, r0.b);
        int v2 = ((RelativeLayout)j00.b).getPaddingLeft();
        int v3 = ((RelativeLayout)j00.b).getPaddingRight();
        ((RelativeLayout)j00.b).setPadding(v2, v, v3, v1);
    }

    public final void a(DjPlayListInfoBase djPlayListInfoBase0, boolean z) {
        String s1;
        ((RelativeLayout)this.a.g).setVisibility(8);
        this.a.c.setVisibility(8);
        ((ImageView)this.a.e).setVisibility(8);
        ((CheckableImageView)this.a.d).setVisibility(8);
        ImageView imageView0 = ((Q1)this.a.f).f;
        imageView0.setVisibility(0);
        ((Q1)this.a.f).k.setVisibility(8);
        ((Q1)this.a.f).j.setVisibility(8);
        ((Q1)this.a.f).g.setVisibility(8);
        ((Q1)this.a.f).e.setVisibility(8);
        String s = null;
        ViewUtils.setOnLongClickListener(this.itemView, null);
        ViewUtils.setOnClickListener(this.itemView, null);
        ViewUtils.setOnClickListener(imageView0, null);
        ViewUtils.setOnClickListener(((Q1)this.a.f).d.b, null);
        Q1 q10 = (Q1)this.a.f;
        LinearLayout linearLayout0 = q10.h;
        MelonTextView melonTextView0 = q10.m;
        MelonImageView melonImageView0 = q10.d.b;
        MelonTextView melonTextView1 = q10.b;
        RequestManager requestManager0 = Glide.with(melonImageView0.getContext());
        if(djPlayListInfoBase0 == null) {
            s1 = "";
        }
        else {
            s1 = djPlayListInfoBase0.thumbimg;
            if(s1 == null) {
                s1 = "";
            }
        }
        requestManager0.load(s1).into(melonImageView0);
        q10.l.setText((djPlayListInfoBase0 == null ? null : djPlayListInfoBase0.plylsttitle));
        melonTextView1.setText(StringUtils.getTrimmed((djPlayListInfoBase0 == null ? null : djPlayListInfoBase0.ownernickname), 13));
        melonTextView1.requestLayout();
        MelonTextView melonTextView2 = q10.e;
        if(z) {
            melonTextView2.setVisibility(0);
            if(djPlayListInfoBase0 != null) {
                String s2 = djPlayListInfoBase0.likecnt;
                if(s2 != null) {
                    s = v.p0(s2, ",", "");
                }
            }
            melonTextView2.setText(StringUtils.getCountString(s, 0x98967F));
        }
        if(djPlayListInfoBase0 instanceof DjPlayListRankingInfo) {
            linearLayout0.setVisibility(0);
            q10.i.setText(((DjPlayListRankingInfo)djPlayListInfoBase0).currentRank);
            String s3 = ((DjPlayListRankingInfo)djPlayListInfoBase0).rankType;
            if(s3 != null) {
                switch(s3) {
                    case "DOWN": {
                        melonTextView0.setCompoundDrawablesWithIntrinsicBounds(0x7F0803D7, 0, 0, 0);  // drawable:ic_common_arrow_down
                        melonTextView0.setTextColor(ColorUtils.getColor(melonTextView0.getContext(), 0x7F060046));  // color:blue400s_support_high_contrast
                        melonTextView0.setText(((DjPlayListRankingInfo)djPlayListInfoBase0).rankGap);
                        melonTextView0.setTextSize(1, 12.0f);
                        return;
                    }
                    case "NEW": {
                        melonTextView0.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                        melonTextView0.setTextColor(ColorUtils.getColor(melonTextView0.getContext(), 0x7F060459));  // color:rank_new_color
                        melonTextView0.setText("NEW");
                        melonTextView0.setTextSize(1, 10.0f);
                        return;
                    }
                    case "NONE": {
                        melonTextView0.setCompoundDrawablesWithIntrinsicBounds(0x7F0803DB, 0, 0, 0);  // drawable:ic_common_arrow_equal_tint
                        melonTextView0.setText("");
                        return;
                    }
                    case "UP": {
                        melonTextView0.setCompoundDrawablesWithIntrinsicBounds(0x7F0803DC, 0, 0, 0);  // drawable:ic_common_arrow_up
                        melonTextView0.setTextColor(ColorUtils.getColor(melonTextView0.getContext(), 0x7F06045A));  // color:rank_up_color
                        melonTextView0.setText(((DjPlayListRankingInfo)djPlayListInfoBase0).rankGap);
                        melonTextView0.setTextSize(1, 12.0f);
                        break;
                    }
                    default: {
                        return;
                    }
                }
            }
            return;
        }
        linearLayout0.setVisibility(8);
    }

    public final void b(ArtistPlayListInfoBase artistPlayListInfoBase0, int v, s s0) {
        this.a(artistPlayListInfoBase0, true);
        ImageView imageView0 = ((Q1)this.a.f).f;
        MelonImageView melonImageView0 = ((Q1)this.a.f).d.b;
        ViewUtils.showWhen(((Q1)this.a.f).g, q.b((artistPlayListInfoBase0 == null ? null : artistPlayListInfoBase0.openyn), "N"));
        if(s0 != null) {
            n n0 = new n(s0, artistPlayListInfoBase0, v, 1);
            ViewUtils.setOnLongClickListener(this.itemView, n0);
            p p0 = new p(s0, artistPlayListInfoBase0, v, 0);
            ViewUtils.setOnClickListener(this.itemView, p0);
            ViewUtils.setOnClickListener(imageView0, new p(s0, artistPlayListInfoBase0, v, 1));
            ViewUtils.setOnClickListener(melonImageView0, new p(s0, artistPlayListInfoBase0, v, 2));
        }
    }

    public final void c(DjPlayListInfoBase djPlayListInfoBase0, int v, t t0, boolean z) {
        this.a(djPlayListInfoBase0, z);
        ImageView imageView0 = ((Q1)this.a.f).f;
        MelonImageView melonImageView0 = ((Q1)this.a.f).d.b;
        if(t0 != null) {
            n n0 = new n(t0, djPlayListInfoBase0, v, 0);
            ViewUtils.setOnLongClickListener(this.itemView, n0);
            o o0 = new o(t0, djPlayListInfoBase0, v, 0);
            ViewUtils.setOnClickListener(this.itemView, o0);
            ViewUtils.setOnClickListener(imageView0, new o(t0, djPlayListInfoBase0, v, 1));
            ViewUtils.setOnClickListener(melonImageView0, new o(t0, djPlayListInfoBase0, v, 2));
        }
    }
}

