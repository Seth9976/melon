package com.iloen.melon.custom;

import De.I;
import J8.x3;
import P1.c;
import Rc.f0;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import com.bumptech.glide.Glide;
import com.iloen.melon.player.video.VideoStatus;
import com.iloen.melon.player.video.VideoViewModel;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import com.melon.playlist.interfaces.PlayableData;
import k8.t1;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002\f\u0011B!\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\b\u0010\nB\u001B\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\u000BJ\u0015\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\f¢\u0006\u0004\b\u000F\u0010\u0010J\u0015\u0010\u0013\u001A\u00020\u000E2\u0006\u0010\u0012\u001A\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/iloen/melon/custom/VideoEndingView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/iloen/melon/custom/y1;", "listener", "Lie/H;", "setBtnClickListener", "(Lcom/iloen/melon/custom/y1;)V", "Lcom/iloen/melon/custom/x1;", "data", "setData", "(Lcom/iloen/melon/custom/x1;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoEndingView extends ConstraintLayout {
    public y1 B;
    public PlayableData D;
    public VideoViewModel E;
    public f0 G;
    public static final int I;
    public final LogU o;
    public final x3 r;
    public long w;

    public VideoEndingView(@NotNull Context context0) {
        q.g(context0, "context");
        this(context0, null);
    }

    public VideoEndingView(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        this(context0, attributeSet0, 0);
    }

    public VideoEndingView(@NotNull Context context0, @Nullable AttributeSet attributeSet0, int v) {
        q.g(context0, "context");
        super(context0, attributeSet0, v);
        this.o = new LogU("VideoEndingView");
        View view0 = LayoutInflater.from(context0).inflate(0x7F0D08D7, this, false);  // layout:video_ending_item_normal
        this.addView(view0);
        int v1 = 0x7F0A011C;  // id:bottom_gradation
        View view1 = I.C(view0, 0x7F0A011C);  // id:bottom_gradation
        if(view1 != null) {
            v1 = 0x7F0A0146;  // id:btn_cancel
            View view2 = I.C(view0, 0x7F0A0146);  // id:btn_cancel
            if(((MelonTextView)view2) != null) {
                v1 = 0x7F0A0182;  // id:btn_play
                View view3 = I.C(view0, 0x7F0A0182);  // id:btn_play
                if(((MelonTextView)view3) != null && ((Guideline)I.C(view0, 0x7F0A023B)) != null && ((ImageView)I.C(view0, 0x7F0A05FE)) != null) {  // id:center_guideline
                    v1 = 0x7F0A0633;  // id:iv_grade
                    View view4 = I.C(view0, 0x7F0A0633);  // id:iv_grade
                    if(((ImageView)view4) != null) {
                        v1 = 0x7F0A069A;  // id:iv_thumb
                        View view5 = I.C(view0, 0x7F0A069A);  // id:iv_thumb
                        if(((MelonImageView)view5) != null) {
                            v1 = 0x7F0A069E;  // id:iv_thumb_default
                            View view6 = I.C(view0, 0x7F0A069E);  // id:iv_thumb_default
                            if(((ImageView)view6) != null) {
                                v1 = 0x7F0A0AEF;  // id:stroke
                                View view7 = I.C(view0, 0x7F0A0AEF);  // id:stroke
                                if(((ImageView)view7) != null && ((ConstraintLayout)I.C(view0, 0x7F0A0B7D)) != null && ((RelativeLayout)I.C(view0, 0x7F0A0B96)) != null) {  // id:thumb_layout_container
                                    v1 = 0x7F0A0C12;  // id:tv_artist
                                    View view8 = I.C(view0, 0x7F0A0C12);  // id:tv_artist
                                    if(((MelonTextView)view8) != null) {
                                        v1 = 0x7F0A0C50;  // id:tv_count
                                        View view9 = I.C(view0, 0x7F0A0C50);  // id:tv_count
                                        if(((MelonTextView)view9) != null) {
                                            v1 = 0x7F0A0CDF;  // id:tv_play_time
                                            View view10 = I.C(view0, 0x7F0A0CDF);  // id:tv_play_time
                                            if(((MelonTextView)view10) != null && ((MelonTextView)I.C(view0, 0x7F0A0D29)) != null) {  // id:tv_text_count
                                                v1 = 0x7F0A0D50;  // id:tv_video_title
                                                View view11 = I.C(view0, 0x7F0A0D50);  // id:tv_video_title
                                                if(((MelonTextView)view11) != null) {
                                                    v1 = 0x7F0A0D9C;  // id:v_dim
                                                    View view12 = I.C(view0, 0x7F0A0D9C);  // id:v_dim
                                                    if(view12 != null) {
                                                        this.r = new x3(((ConstraintLayout)view0), view1, ((MelonTextView)view2), ((MelonTextView)view3), ((ImageView)view4), ((MelonImageView)view5), ((ImageView)view6), ((ImageView)view7), ((MelonTextView)view8), ((MelonTextView)view9), ((MelonTextView)view10), ((MelonTextView)view11), view12);
                                                        this.w = 1000L;
                                                        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, t1.M, v, 0);
                                                        q.f(typedArray0, "obtainStyledAttributes(...)");
                                                        typedArray0.getBoolean(0, false);
                                                        return;
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
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v1));
    }

    public final void c() {
        LogU.debug$default(this.o, "closeTimer()", null, false, 6, null);
        f0 f00 = this.G;
        if(f00 != null) {
            f00.cancel();
        }
        this.G = null;
    }

    public final void d() {
        LogU.debug$default(this.o, "updateView()", null, false, 6, null);
        VideoViewModel videoViewModel0 = this.E;
        x3 x30 = this.r;
        if(videoViewModel0 != null) {
            int v = !videoViewModel0.isFullScreen() || !((Boolean)videoViewModel0.isOrientationPortrait().getValue()).booleanValue() ? 24 : 84;
            ViewUtilsKt.setMarginToDp$default(x30.c, null, null, null, ((float)v), 7, null);
            ViewUtilsKt.setMarginToDp$default(x30.j, null, ((float)v), null, null, 13, null);
        }
        ImageView imageView0 = x30.h;
        ImageView imageView1 = x30.g;
        MelonTextView melonTextView0 = x30.l;
        MelonTextView melonTextView1 = x30.i;
        MelonTextView melonTextView2 = x30.k;
        ImageView imageView2 = x30.e;
        MelonImageView melonImageView0 = x30.f;
        w1 w10 = new w1(this, 0);
        x30.d.setOnClickListener(w10);
        w1 w11 = new w1(this, 1);
        x30.c.setOnClickListener(w11);
        VideoViewModel videoViewModel1 = this.E;
        if(videoViewModel1 != null) {
            if(videoViewModel1.getVideoStatus().getValue() == VideoStatus.FullScreen) {
                imageView1.setBackground(c.getDrawable(this.getContext(), 0x7F080933));  // drawable:thumbnail_background_image_round_w
                imageView1.setImageResource(0x7F08078A);  // drawable:noimage_logo_medium_w
                imageView0.setBackground(c.getDrawable(this.getContext(), 0x7F0808FD));  // drawable:shape_rectangle_stroke_0_5dp_white120e_radius4
            }
            else {
                imageView1.setBackground(c.getDrawable(this.getContext(), 0x7F080930));  // drawable:thumbnail_background_image_round
                imageView1.setImageResource(0x7F080788);  // drawable:noimage_logo_medium
                imageView0.setBackground(c.getDrawable(this.getContext(), 0x7F080939));  // drawable:thumbnail_frame_round
            }
        }
        PlayableData playableData0 = this.D;
        if(playableData0 != null) {
            melonTextView0.setText("");
            melonTextView1.setText("");
            long v1 = playableData0.a.getOriginalDuration();
            int v2 = 8;
            melonTextView2.setVisibility((Long.compare(v1, 0L) <= 0 ? 8 : 0));
            melonTextView2.setText(StringUtils.INSTANCE.formatPlayerDurationTime(v1));
            if(playableData0.a.isAdult()) {
                v2 = 0;
            }
            imageView2.setVisibility(v2);
            Glide.with(this.getContext()).load(playableData0.m).into(melonImageView0);
        }
    }

    @Override  // android.view.View
    public final void onConfigurationChanged(Configuration configuration0) {
        super.onConfigurationChanged(configuration0);
        this.d();
    }

    public final void setBtnClickListener(@NotNull y1 y10) {
        q.g(y10, "listener");
        this.B = y10;
    }

    public final void setData(@NotNull x1 x10) {
        q.g(x10, "data");
        this.D = x10.a;
        this.w = 6000L;
        this.E = x10.b;
        this.d();
        this.c();
        this.G = new f0(this, this.w);
        LogU.debug$default(this.o, "countDownTimer start()", null, false, 6, null);
        f0 f00 = this.G;
        if(f00 != null) {
            f00.start();
        }
    }
}

