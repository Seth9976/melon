package com.iloen.melon.custom.title;

import Ad.s;
import F8.B;
import F8.C;
import F8.J;
import F8.N;
import F8.T;
import F8.b;
import F8.c;
import F8.k;
import F8.m;
import F8.n;
import F8.o;
import F8.p;
import F8.w;
import F8.z;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.iloen.melon.utils.system.ScreenUtils;
import java.util.ArrayList;
import java.util.Iterator;
import je.t;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import x1.a;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0003\t-\u000EB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u0015\u0010\f\u001A\u00020\u000B2\u0006\u0010\n\u001A\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0010\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u000E¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001A\u00020\u000B2\b\u0010\u0013\u001A\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001A\u00020\u000B2\u0006\u0010\u0017\u001A\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001C\u001A\u00020\u000B2\u0006\u0010\u001B\u001A\u00020\u001A¢\u0006\u0004\b\u001C\u0010\u001DJ\u0015\u0010 \u001A\u00020\u000B2\u0006\u0010\u001F\u001A\u00020\u001E¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001A\u00020\u000B2\u0006\u0010\u001F\u001A\u00020\u001EH\u0016¢\u0006\u0004\b\"\u0010!J\u0015\u0010#\u001A\u00020\u000B2\u0006\u0010\u001F\u001A\u00020\u001E¢\u0006\u0004\b#\u0010!J\u0015\u0010&\u001A\u00020\u000B2\u0006\u0010%\u001A\u00020$¢\u0006\u0004\b&\u0010\'J\u0015\u0010)\u001A\u00020\u000B2\u0006\u0010(\u001A\u00020\u001A¢\u0006\u0004\b)\u0010\u001DJ\u000F\u0010+\u001A\u0004\u0018\u00010*¢\u0006\u0004\b+\u0010,¨\u0006."}, d2 = {"Lcom/iloen/melon/custom/title/TitleBar;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attributeSet", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "LF8/b;", "onCommonButtonEventListener", "Lie/H;", "setCommonButtonEventListener", "(LF8/b;)V", "LF8/a;", "listener", "setOnBuildEventListener", "(LF8/a;)V", "", "title", "setTitle", "(Ljava/lang/String;)V", "", "sizeDp", "setTitleSize", "(F)V", "", "isShow", "setTitleVisibility", "(Z)V", "", "color", "setTitleColor", "(I)V", "setBackgroundColor", "setDimColor", "Lp8/s;", "melonTiaraProperty", "setTiaraProperty", "(Lp8/s;)V", "clickable", "setContainerClickable", "Landroid/view/View;", "getFirstButtonView", "()Landroid/view/View;", "F8/c", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TitleBar extends RelativeLayout {
    public View a;
    public View b;
    public RelativeLayout c;
    public LinearLayout d;
    public LinearLayout e;
    public View f;
    public View g;
    public View h;
    public o i;
    public TextView j;
    public String k;
    public boolean l;
    public b m;
    public static final int n;

    public TitleBar(@NotNull Context context0) {
        q.g(context0, "context");
        super(context0);
        this.d(context0);
    }

    public TitleBar(@NotNull Context context0, @NotNull AttributeSet attributeSet0) {
        q.g(context0, "context");
        q.g(attributeSet0, "attributeSet");
        super(context0, attributeSet0);
        this.d(context0);
    }

    public final void a(o o0) {
        q.g(o0, "titleItem");
        this.b(o0, false);
    }

    public final void b(o o0, boolean z) {
        if(!z) {
            this.i = o0;
        }
        RelativeLayout relativeLayout0 = this.c;
        if(relativeLayout0 != null) {
            if(relativeLayout0.getChildCount() > 0) {
                RelativeLayout relativeLayout1 = this.c;
                if(relativeLayout1 != null) {
                    relativeLayout1.removeAllViews();
                    goto label_11;
                }
                q.m("layoutCenterContainer");
                throw null;
            }
        label_11:
            LinearLayout linearLayout0 = this.d;
            if(linearLayout0 != null) {
                if(linearLayout0.getChildCount() > 0) {
                    LinearLayout linearLayout1 = this.d;
                    if(linearLayout1 != null) {
                        linearLayout1.removeAllViews();
                        goto label_20;
                    }
                    q.m("layoutLeftContainer");
                    throw null;
                }
            label_20:
                LinearLayout linearLayout2 = this.e;
                if(linearLayout2 != null) {
                    if(linearLayout2.getChildCount() > 0) {
                        LinearLayout linearLayout3 = this.e;
                        if(linearLayout3 != null) {
                            linearLayout3.removeAllViews();
                            goto label_29;
                        }
                        q.m("layoutRightContainer");
                        throw null;
                    }
                label_29:
                    ArrayList arrayList0 = new ArrayList();
                    ArrayList arrayList1 = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    while(o0 != null) {
                        if(o0 instanceof n) {
                            arrayList2.add(o0);
                        }
                        else if(o0 instanceof w) {
                            arrayList0.add(o0);
                        }
                        else if(o0 instanceof T) {
                            arrayList1.add(o0);
                        }
                        o0 = o0.a;
                    }
                    t.R(arrayList0);
                    t.R(arrayList1);
                    Iterator iterator0 = arrayList0.iterator();
                    q.f(iterator0, "iterator(...)");
                    while(iterator0.hasNext()) {
                        Object object0 = iterator0.next();
                        q.f(object0, "next(...)");
                        Context context0 = this.getContext();
                        q.f(context0, "getContext(...)");
                        View view0 = ((w)object0).a(context0);
                        LinearLayout linearLayout4 = this.d;
                        if(linearLayout4 != null) {
                            linearLayout4.addView(view0);
                            if(this.h == null) {
                                this.h = view0;
                            }
                            a.N(((w)object0).b, new s(3, ((w)object0), this));
                            continue;
                        }
                        q.m("layoutLeftContainer");
                        throw null;
                    }
                    Iterator iterator1 = arrayList2.iterator();
                    q.f(iterator1, "iterator(...)");
                    while(iterator1.hasNext()) {
                        Object object1 = iterator1.next();
                        q.f(object1, "next(...)");
                        Context context1 = this.getContext();
                        q.f(context1, "getContext(...)");
                        View view1 = ((n)object1).a(context1);
                        RelativeLayout relativeLayout2 = this.c;
                        if(relativeLayout2 != null) {
                            relativeLayout2.addView(view1);
                            if(this.h == null) {
                                this.h = view1;
                            }
                            if(((n)object1) instanceof m) {
                                TextView textView0 = (TextView)view1.findViewById(0x7F0A0D41);  // id:tv_titlebar_title
                                this.j = textView0;
                                if(textView0 != null) {
                                    textView0.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                                }
                            }
                            a.N(((n)object1).b, new s(4, ((n)object1), this));
                            continue;
                        }
                        q.m("layoutCenterContainer");
                        throw null;
                    }
                    Iterator iterator2 = arrayList1.iterator();
                    q.f(iterator2, "iterator(...)");
                    while(iterator2.hasNext()) {
                        Object object2 = iterator2.next();
                        q.f(object2, "next(...)");
                        Context context2 = this.getContext();
                        q.f(context2, "getContext(...)");
                        View view2 = ((T)object2).a(context2);
                        LinearLayout linearLayout5 = this.e;
                        if(linearLayout5 != null) {
                            linearLayout5.addView(view2);
                            if(this.h == null) {
                                this.h = view2;
                            }
                            a.N(((T)object2).b, new s(5, ((T)object2), this));
                            continue;
                        }
                        q.m("layoutRightContainer");
                        throw null;
                    }
                    LinearLayout linearLayout6 = this.d;
                    if(linearLayout6 != null) {
                        linearLayout6.measure(0, 0);
                        LinearLayout linearLayout7 = this.e;
                        if(linearLayout7 != null) {
                            linearLayout7.measure(0, 0);
                            LinearLayout linearLayout8 = this.d;
                            if(linearLayout8 != null) {
                                int v = linearLayout8.getMeasuredWidth();
                                LinearLayout linearLayout9 = this.e;
                                if(linearLayout9 != null) {
                                    if(linearLayout9.getMeasuredWidth() > v) {
                                        LinearLayout linearLayout10 = this.e;
                                        if(linearLayout10 != null) {
                                            v = linearLayout10.getMeasuredWidth();
                                            goto label_119;
                                        }
                                        q.m("layoutRightContainer");
                                        throw null;
                                    }
                                label_119:
                                    RelativeLayout relativeLayout3 = this.c;
                                    if(relativeLayout3 != null) {
                                        relativeLayout3.setPadding(v, 0, v, 0);
                                        return;
                                    }
                                    q.m("layoutCenterContainer");
                                    throw null;
                                }
                                q.m("layoutRightContainer");
                                throw null;
                            }
                            q.m("layoutLeftContainer");
                            throw null;
                        }
                        q.m("layoutRightContainer");
                        throw null;
                    }
                    q.m("layoutLeftContainer");
                    throw null;
                }
                q.m("layoutRightContainer");
                throw null;
            }
            q.m("layoutLeftContainer");
            throw null;
        }
        q.m("layoutCenterContainer");
        throw null;
    }

    public final void c(float f) {
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.getLayoutParams();
        viewGroup$LayoutParams0.height = ScreenUtils.dipToPixel(this.getContext(), f);
        View view0 = this.a;
        if(view0 != null) {
            ViewGroup.LayoutParams viewGroup$LayoutParams1 = view0.getLayoutParams();
            viewGroup$LayoutParams1.height = ScreenUtils.dipToPixel(this.getContext(), f);
            this.requestLayout();
            return;
        }
        q.m("titlebarContainer");
        throw null;
    }

    public final void d(Context context0) {
        View view0 = View.inflate(context0, 0x7F0D0883, this);  // layout:titlebar_layout
        View view1 = view0.findViewById(0x7F0A0BAE);  // id:titlebar_container
        q.f(view1, "findViewById(...)");
        this.a = view1;
        View view2 = view0.findViewById(0x7F0A0D93);  // id:v_background
        q.f(view2, "findViewById(...)");
        this.b = view2;
        View view3 = view0.findViewById(0x7F0A0706);  // id:layout_center_container
        q.f(view3, "findViewById(...)");
        this.c = (RelativeLayout)view3;
        View view4 = view0.findViewById(0x7F0A0721);  // id:layout_left_container
        q.f(view4, "findViewById(...)");
        this.d = (LinearLayout)view4;
        View view5 = view0.findViewById(0x7F0A073B);  // id:layout_right_container
        q.f(view5, "findViewById(...)");
        this.e = (LinearLayout)view5;
        View view6 = view0.findViewById(0x7F0A05F7);  // id:iv_background_dim
        q.f(view6, "findViewById(...)");
        this.f = view6;
        View view7 = view0.findViewById(0x7F0A0BAB);  // id:title_underline
        q.f(view7, "findViewById(...)");
        this.g = view7;
    }

    public final void e(o o0) {
        b b0 = this.m;
        if(b0 != null) {
            if(o0 instanceof N) {
                b0.onClick(1, o0);
                return;
            }
            if(o0 instanceof J) {
                b0.onClick(3, o0);
                return;
            }
            if(o0 instanceof B) {
                b0.onClick(4, o0);
                return;
            }
            if(o0 instanceof z) {
                b0.onClick(5, o0);
                return;
            }
            if(o0 instanceof k) {
                b0.onClick(6, o0);
                return;
            }
            if(o0 instanceof p || o0 instanceof F8.q) {
                b0.onClick(7, o0);
            }
        }
    }

    public final void f(boolean z) {
        View view0 = this.g;
        if(view0 != null) {
            view0.setVisibility((z ? 0 : 4));
            return;
        }
        q.m("titleUnderline");
        throw null;
    }

    public final void g(String s, o o0, boolean z, c c0) {
        q.g(o0, "editModeTitleItem");
        q.g(c0, "editDoenClickListener");
        View view0 = this.g;
        if(view0 != null) {
            this.l = view0.getVisibility() == 0;
            this.b(o0, true);
            TextView textView0 = this.j;
            if(textView0 != null) {
                if(s == null) {
                    s = "";
                }
                textView0.setText(s);
            }
            this.f(z);
            while(o0 != null) {
                if(o0 instanceof B || o0 instanceof C) {
                    ((T)o0).c = new s(6, c0, this);
                }
                o0 = o0.a;
            }
            return;
        }
        q.m("titleUnderline");
        throw null;
    }

    @Nullable
    public final View getFirstButtonView() {
        return this.h;
    }

    public final void h() {
        this.f(this.l);
        o o0 = this.i;
        if(o0 != null) {
            this.b(o0, true);
            this.setTitle((this.k == null ? "" : this.k));
        }
    }

    @Override  // android.view.View
    public void setBackgroundColor(int v) {
        View view0 = this.b;
        if(view0 != null) {
            view0.setBackgroundColor(v);
            return;
        }
        q.m("backgroundView");
        throw null;
    }

    public final void setCommonButtonEventListener(@NotNull b b0) {
        q.g(b0, "onCommonButtonEventListener");
        this.m = b0;
    }

    public final void setContainerClickable(boolean z) {
        View view0 = this.a;
        if(view0 != null) {
            view0.setClickable(z);
            return;
        }
        q.m("titlebarContainer");
        throw null;
    }

    public final void setDimColor(int v) {
        View view0 = this.f;
        if(view0 != null) {
            view0.setBackgroundColor(v);
            return;
        }
        q.m("ivBackgroundDim");
        throw null;
    }

    public final void setOnBuildEventListener(@NotNull F8.a a0) {
        q.g(a0, "listener");
    }

    public final void setTiaraProperty(@NotNull p8.s s0) {
        q.g(s0, "melonTiaraProperty");
        o o0 = this.i;
        if(o0 != null) {
            while(o0 != null) {
                o0.f = s0;
                o0 = o0.a;
            }
        }
    }

    public final void setTitle(@Nullable String s) {
        TextView textView0 = this.j;
        if(textView0 != null) {
            textView0.setText((s == null ? "" : s));
            this.k = s;
            B0.q.v(textView0);
        }
    }

    public final void setTitleColor(int v) {
        TextView textView0 = this.j;
        if(textView0 != null) {
            textView0.setTextColor(v);
        }
    }

    public final void setTitleSize(float f) {
        TextView textView0 = this.j;
        if(textView0 != null) {
            textView0.setTextSize(1, f);
        }
    }

    public final void setTitleVisibility(boolean z) {
        TextView textView0 = this.j;
        if(textView0 != null) {
            textView0.setVisibility((z ? 0 : 4));
        }
    }
}

