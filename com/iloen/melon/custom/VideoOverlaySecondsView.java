package com.iloen.melon.custom;

import Vb.i;
import Wf.a;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import b3.Z;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001EB\u0019\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\"\u0010\u000B\u001A\u00020\b8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\t\u0010\n\u001A\u0004\b\u000B\u0010\f\"\u0004\b\r\u0010\u000ER*\u0010\u0017\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u000F8\u0006@FX\u0086\u000E¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u0018\u001A\u00020\b2\u0006\u0010\u0010\u001A\u00020\b8\u0006@FX\u0086\u000E¢\u0006\u0012\n\u0004\b\u0012\u0010\n\u001A\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000ER\u0011\u0010\u001D\u001A\u00020\u001A8F¢\u0006\u0006\u001A\u0004\b\u001B\u0010\u001C¨\u0006\u001F"}, d2 = {"Lcom/iloen/melon/custom/VideoOverlaySecondsView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "o", "Z", "isAnimated", "()Z", "setAnimated", "(Z)V", "", "value", "G", "I", "getSeconds", "()I", "setSeconds", "(I)V", "seconds", "isForward", "setForward", "Landroid/widget/TextView;", "getTextView", "()Landroid/widget/TextView;", "textView", "com/iloen/melon/custom/D1", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoOverlaySecondsView extends ConstraintLayout {
    public final ImageView B;
    public final ImageView D;
    public final ImageView E;
    public int G;
    public boolean I;
    public final D1 M;
    public final D1 N;
    public final D1 S;
    public final D1 T;
    public final D1 V;
    public final D1 W;
    public static final int b0;
    public boolean o;
    public final LinearLayout r;
    public final TextView w;

    public VideoOverlaySecondsView(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        super(context0, attributeSet0);
        LayoutInflater.from(context0).inflate(0x7F0D08EE, this, true);  // layout:video_overlay_seconds_view_layout
        View view0 = this.findViewById(0x7F0A0795);  // id:ll_icon_container
        q.f(view0, "findViewById(...)");
        this.r = (LinearLayout)view0;
        View view1 = this.findViewById(0x7F0A0D05);  // id:tv_seconds
        q.f(view1, "findViewById(...)");
        this.w = (TextView)view1;
        View view2 = this.findViewById(0x7F0A062E);  // id:iv_first_icon
        q.f(view2, "findViewById(...)");
        this.B = (ImageView)view2;
        View view3 = this.findViewById(0x7F0A0686);  // id:iv_second_icon
        q.f(view3, "findViewById(...)");
        this.D = (ImageView)view3;
        View view4 = this.findViewById(0x7F0A0699);  // id:iv_third_icon
        q.f(view4, "findViewById(...)");
        this.E = (ImageView)view4;
        this.I = true;
        this.M = new D1(this, ((ImageView)view2), 0.0f, 0.9f, 0L, new a(24), new B1(0), new A1(this, 0));
        this.N = new D1(this, ((ImageView)view2), 0.9f, 0.0f, 100L, new a(25), new Uc.a(25), new i(20));
        this.S = new D1(this, ((ImageView)view3), 0.0f, 0.9f, 200L, new a(26), new Uc.a(26), new A1(this, 1));
        this.T = new D1(this, ((ImageView)view3), 0.9f, 0.0f, 100L, new a(27), new Uc.a(27), new i(20));
        this.V = new D1(this, ((ImageView)view4), 0.0f, 0.9f, 400L, new a(28), new Uc.a(28), new A1(this, 2));
        this.W = new D1(this, ((ImageView)view4), 0.9f, 0.0f, 100L, new a(29), new Uc.a(29), new A1(this, 3));
    }

    public final void c() {
        this.o = true;
        this.M.cancel();
        this.N.cancel();
        this.S.cancel();
        this.T.cancel();
        this.V.cancel();
        this.W.cancel();
        this.B.setAlpha(0.0f);
        this.D.setAlpha(0.0f);
        this.E.setAlpha(0.0f);
    }

    public final int getSeconds() {
        return this.G;
    }

    @NotNull
    public final TextView getTextView() {
        return this.w;
    }

    public final void setAnimated(boolean z) {
        this.o = z;
    }

    public final void setForward(boolean z) {
        this.r.setRotation((z ? 0.0f : 180.0f));
        this.I = z;
    }

    public final void setSeconds(int v) {
        q.f("%s 초", "getString(...)");
        Z.y(new Object[]{v}, 1, "%s 초", this.w);
        this.G = v;
    }
}

