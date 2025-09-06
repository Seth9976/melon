package com.iloen.melon.fragments.main.common;

import De.I;
import J8.m2;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.BaseRequestOptions;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.net.res.common.LinkInfoBase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000F\n\u0002\u0010\u000B\n\u0002\b\u000E\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0017\u0018\u00002\u00020\u0001:\u0002BCB\'\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001A\u00020\u0006\u00A2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001A\u00020\f2\b\u0010\u000B\u001A\u0004\u0018\u00010\n\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0015\u0010\u0011\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\u000F\u00A2\u0006\u0004\b\u0011\u0010\u0012J/\u0010\r\u001A\u00020\f2\u0006\u0010\u0013\u001A\u00020\n2\u0006\u0010\u0014\u001A\u00020\n2\u0006\u0010\u0015\u001A\u00020\n2\b\b\u0002\u0010\u0016\u001A\u00020\u0006\u00A2\u0006\u0004\b\r\u0010\u0017J1\u0010\u0018\u001A\u00020\f2\u0006\u0010\u0013\u001A\u00020\n2\u0006\u0010\u0014\u001A\u00020\n2\b\b\u0002\u0010\u0015\u001A\u00020\n2\b\b\u0002\u0010\u0016\u001A\u00020\u0006\u00A2\u0006\u0004\b\u0018\u0010\u0017J\u0017\u0010\u001A\u001A\u00020\f2\b\b\u0001\u0010\u0019\u001A\u00020\u0006\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u0017\u0010\u001A\u001A\u00020\f2\b\u0010\u001C\u001A\u0004\u0018\u00010\n\u00A2\u0006\u0004\b\u001A\u0010\u000EJ\u0015\u0010\u001E\u001A\u00020\f2\u0006\u0010\u001D\u001A\u00020\u000F\u00A2\u0006\u0004\b\u001E\u0010\u0012J\u0015\u0010!\u001A\u00020\f2\u0006\u0010 \u001A\u00020\u001F\u00A2\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001A\u00020\f2\b\b\u0001\u0010\u0019\u001A\u00020\u0006\u00A2\u0006\u0004\b#\u0010\u001BJ)\u0010\'\u001A\u00020\f2\u0006\u0010$\u001A\u00020\n2\b\b\u0002\u0010%\u001A\u00020\u00062\b\b\u0002\u0010&\u001A\u00020\u0006\u00A2\u0006\u0004\b\'\u0010(J\u0017\u0010)\u001A\u00020\f2\b\b\u0001\u0010\u0019\u001A\u00020\u0006\u00A2\u0006\u0004\b)\u0010\u001BJ\u0017\u0010*\u001A\u00020\f2\b\b\u0001\u0010\u0019\u001A\u00020\u0006\u00A2\u0006\u0004\b*\u0010\u001BJ\u0017\u0010+\u001A\u00020\f2\b\b\u0001\u0010\u0019\u001A\u00020\u0006\u00A2\u0006\u0004\b+\u0010\u001BJ\u0015\u0010-\u001A\u00020\f2\u0006\u0010,\u001A\u00020\u001F\u00A2\u0006\u0004\b-\u0010\"J\u0017\u0010-\u001A\u00020\f2\b\u0010/\u001A\u0004\u0018\u00010.\u00A2\u0006\u0004\b-\u00100J\r\u00101\u001A\u00020\f\u00A2\u0006\u0004\b1\u00102J\u0015\u00105\u001A\u00020\f2\u0006\u00104\u001A\u000203\u00A2\u0006\u0004\b5\u00106R\"\u00108\u001A\u0002078\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b8\u00109\u001A\u0004\b:\u0010;\"\u0004\b<\u0010=R$\u00104\u001A\u0004\u0018\u0001038\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b4\u0010>\u001A\u0004\b?\u0010@\"\u0004\bA\u00106\u00A8\u0006D"}, d2 = {"Lcom/iloen/melon/fragments/main/common/MainTabTitleView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "title", "Lie/H;", "setTitle", "(Ljava/lang/String;)V", "", "textSize", "setTitleTextSize", "(F)V", "fullText", "replaceText", "replaceTextKey", "maxLine", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "setHighlightedSubTitle", "resid", "setViewAllText", "(I)V", "text", "marginDp", "setTitleRightMargin", "", "visible", "setVisibleNewDot", "(Z)V", "setIconRes", "imageUrl", "width", "height", "setTitleIcon", "(Ljava/lang/String;II)V", "setIconContentDescription", "setRightmostIconRes", "setRightmostIconContentDescription", "isClickable", "setTitleClickable", "Lcom/melon/net/res/common/LinkInfoBase;", "linkInfoBase", "(Lcom/melon/net/res/common/LinkInfoBase;)V", "updateContentDescription", "()V", "Lcom/iloen/melon/fragments/main/common/MainTabTitleView$EventListener;", "listener", "setOnEventListener", "(Lcom/iloen/melon/fragments/main/common/MainTabTitleView$EventListener;)V", "LJ8/m2;", "binding", "LJ8/m2;", "getBinding", "()LJ8/m2;", "setBinding", "(LJ8/m2;)V", "Lcom/iloen/melon/fragments/main/common/MainTabTitleView$EventListener;", "getListener", "()Lcom/iloen/melon/fragments/main/common/MainTabTitleView$EventListener;", "setListener", "EventListener", "SimpleEventListener", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class MainTabTitleView extends LinearLayout {
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\t\u0010\u0006¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/fragments/main/common/MainTabTitleView$EventListener;", "", "Landroid/view/View;", "view", "Lie/H;", "onViewAllButtonClick", "(Landroid/view/View;)V", "onTitleIconClick", "onRightmostIconClick", "onTitleClick", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface EventListener {
        void onRightmostIconClick(@NotNull View arg1);

        void onTitleClick(@NotNull View arg1);

        void onTitleIconClick(@NotNull View arg1);

        void onViewAllButtonClick(@NotNull View arg1);
    }

    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\u000B\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u000B\u0010\b¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/main/common/MainTabTitleView$SimpleEventListener;", "Lcom/iloen/melon/fragments/main/common/MainTabTitleView$EventListener;", "<init>", "()V", "Landroid/view/View;", "view", "Lie/H;", "onViewAllButtonClick", "(Landroid/view/View;)V", "onTitleIconClick", "onRightmostIconClick", "onTitleClick", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static class SimpleEventListener implements EventListener {
        public static final int $stable;

        @Override  // com.iloen.melon.fragments.main.common.MainTabTitleView$EventListener
        public void onRightmostIconClick(@NotNull View view0) {
            q.g(view0, "view");
        }

        @Override  // com.iloen.melon.fragments.main.common.MainTabTitleView$EventListener
        public void onTitleClick(@NotNull View view0) {
            q.g(view0, "view");
        }

        @Override  // com.iloen.melon.fragments.main.common.MainTabTitleView$EventListener
        public void onTitleIconClick(@NotNull View view0) {
            q.g(view0, "view");
        }

        @Override  // com.iloen.melon.fragments.main.common.MainTabTitleView$EventListener
        public void onViewAllButtonClick(@NotNull View view0) {
            q.g(view0, "view");
        }
    }

    public static final int $stable = 8;
    @NotNull
    private m2 binding;
    @Nullable
    private EventListener listener;

    public MainTabTitleView(@NotNull Context context0) {
        q.g(context0, "context");
        this(context0, null, 0, 6, null);
    }

    public MainTabTitleView(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        this(context0, attributeSet0, 0, 4, null);
    }

    public MainTabTitleView(@NotNull Context context0, @Nullable AttributeSet attributeSet0, int v) {
        q.g(context0, "context");
        super(context0, attributeSet0, v);
        View view0 = LayoutInflater.from(context0).inflate(0x7F0D04C9, this, false);  // layout:main_tab_title
        this.addView(view0);
        int v1 = 0x7F0A08AD;  // id:new_dot
        View view1 = I.C(view0, 0x7F0A08AD);  // id:new_dot
        if(view1 != null) {
            v1 = 0x7F0A09FE;  // id:rightmost_icon
            View view2 = I.C(view0, 0x7F0A09FE);  // id:rightmost_icon
            if(((ImageView)view2) != null) {
                v1 = 0x7F0A0AFD;  // id:sub_title
                View view3 = I.C(view0, 0x7F0A0AFD);  // id:sub_title
                if(((MelonTextView)view3) != null) {
                    v1 = 0x7F0A0B8D;  // id:title
                    View view4 = I.C(view0, 0x7F0A0B8D);  // id:title
                    if(((MelonTextView)view4) != null) {
                        v1 = 0x7F0A0B9C;  // id:title_icon
                        View view5 = I.C(view0, 0x7F0A0B9C);  // id:title_icon
                        if(((ImageView)view5) != null) {
                            v1 = 0x7F0A0B9E;  // id:title_layout
                            View view6 = I.C(view0, 0x7F0A0B9E);  // id:title_layout
                            if(((LinearLayout)view6) != null) {
                                v1 = 0x7F0A0DBB;  // id:view_all
                                View view7 = I.C(view0, 0x7F0A0DBB);  // id:view_all
                                if(((MelonTextView)view7) != null) {
                                    this.binding = new m2(((LinearLayout)view0), view1, ((ImageView)view2), ((MelonTextView)view3), ((MelonTextView)view4), ((ImageView)view5), ((LinearLayout)view6), ((MelonTextView)view7));
                                    ((MelonTextView)view4).addTextChangedListener(new TextWatcher() {
                                        @Override  // android.text.TextWatcher
                                        public void afterTextChanged(Editable editable0) {
                                            MainTabTitleView.this.updateContentDescription();
                                        }

                                        @Override  // android.text.TextWatcher
                                        public void beforeTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
                                        }

                                        @Override  // android.text.TextWatcher
                                        public void onTextChanged(CharSequence charSequence0, int v, int v1, int v2) {
                                        }
                                    });
                                    this.binding.h.setOnClickListener(new a(this, 0));
                                    this.binding.f.setOnClickListener(new a(this, 1));
                                    this.binding.c.setOnClickListener(new a(this, 2));
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v1));
    }

    public MainTabTitleView(Context context0, AttributeSet attributeSet0, int v, int v1, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v1 & 2) != 0) {
            attributeSet0 = null;
        }
        if((v1 & 4) != 0) {
            v = 0;
        }
        this(context0, attributeSet0, v);
    }

    private static final void _init_$lambda$1(MainTabTitleView mainTabTitleView0, View view0) {
        EventListener mainTabTitleView$EventListener0 = mainTabTitleView0.listener;
        if(mainTabTitleView$EventListener0 != null) {
            q.d(view0);
            mainTabTitleView$EventListener0.onViewAllButtonClick(view0);
        }
    }

    private static final void _init_$lambda$2(MainTabTitleView mainTabTitleView0, View view0) {
        EventListener mainTabTitleView$EventListener0 = mainTabTitleView0.listener;
        if(mainTabTitleView$EventListener0 != null) {
            q.d(view0);
            mainTabTitleView$EventListener0.onTitleIconClick(view0);
        }
    }

    private static final void _init_$lambda$3(MainTabTitleView mainTabTitleView0, View view0) {
        EventListener mainTabTitleView$EventListener0 = mainTabTitleView0.listener;
        if(mainTabTitleView$EventListener0 != null) {
            q.d(view0);
            mainTabTitleView$EventListener0.onRightmostIconClick(view0);
        }
    }

    @NotNull
    public final m2 getBinding() {
        return this.binding;
    }

    @Nullable
    public final EventListener getListener() {
        return this.listener;
    }

    public final void setBinding(@NotNull m2 m20) {
        q.g(m20, "<set-?>");
        this.binding = m20;
    }

    public final void setHighlightedSubTitle(@NotNull String s, @NotNull String s1, @NotNull String s2, int v) {
        q.g(s, "fullText");
        q.g(s1, "replaceText");
        q.g(s2, "replaceTextKey");
        a.a.N(this.binding.d, s, s1, (s1.length() <= 0 || s2.length() != 0 ? s2 : s1), v, true);
    }

    public static void setHighlightedSubTitle$default(MainTabTitleView mainTabTitleView0, String s, String s1, String s2, int v, int v1, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setHighlightedSubTitle");
        }
        if((v1 & 4) != 0) {
            s2 = "";
        }
        if((v1 & 8) != 0) {
            v = 1;
        }
        mainTabTitleView0.setHighlightedSubTitle(s, s1, s2, v);
    }

    public final void setIconContentDescription(int v) {
        this.binding.f.setContentDescription(this.getContext().getString(v));
    }

    public final void setIconRes(int v) {
        this.binding.f.setImageResource(v);
        ViewUtils.showWhen(this.binding.f, true);
    }

    public final void setListener(@Nullable EventListener mainTabTitleView$EventListener0) {
        this.listener = mainTabTitleView$EventListener0;
    }

    public final void setOnEventListener(@NotNull EventListener mainTabTitleView$EventListener0) {
        q.g(mainTabTitleView$EventListener0, "listener");
        this.listener = mainTabTitleView$EventListener0;
    }

    public final void setRightmostIconContentDescription(int v) {
        this.binding.c.setContentDescription(this.getContext().getString(v));
    }

    public final void setRightmostIconRes(int v) {
        this.binding.c.setImageResource(v);
        ViewUtils.showWhen(this.binding.c, true);
    }

    public final void setTitle(@Nullable String s) {
        this.binding.e.setText(s);
    }

    public final void setTitle(@NotNull String s, @NotNull String s1, @NotNull String s2, int v) {
        q.g(s, "fullText");
        q.g(s1, "replaceText");
        q.g(s2, "replaceTextKey");
        a.a.N(this.binding.e, s, s1, s2, v, false);
    }

    public static void setTitle$default(MainTabTitleView mainTabTitleView0, String s, String s1, String s2, int v, int v1, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTitle");
        }
        if((v1 & 8) != 0) {
            v = 1;
        }
        mainTabTitleView0.setTitle(s, s1, s2, v);
    }

    public final void setTitleClickable(@Nullable LinkInfoBase linkInfoBase0) {
        boolean z;
        MelonTextView melonTextView0 = this.binding.h;
        String s = null;
        String s1 = linkInfoBase0 == null ? null : linkInfoBase0.linktype;
        if(s1 == null || s1.length() == 0) {
            z = false;
        }
        else {
            if(linkInfoBase0 != null) {
                s = linkInfoBase0.linktype;
            }
            z = q.b(s, "NN") ? false : true;
        }
        ViewUtils.showWhen(melonTextView0, z);
    }

    public final void setTitleClickable(boolean z) {
        ViewUtils.showWhen(this.binding.h, z);
        if(z) {
            this.binding.e.setOnClickListener(new a(this, 3));
        }
    }

    private static final void setTitleClickable$lambda$4(MainTabTitleView mainTabTitleView0, View view0) {
        EventListener mainTabTitleView$EventListener0 = mainTabTitleView0.listener;
        if(mainTabTitleView$EventListener0 != null) {
            q.d(view0);
            mainTabTitleView$EventListener0.onTitleClick(view0);
        }
    }

    public final void setTitleIcon(@NotNull String s, int v, int v1) {
        q.g(s, "imageUrl");
        BaseRequestOptions baseRequestOptions0 = Glide.with(this.getContext()).load(s).sizeMultiplier(1.0f);
        q.f(baseRequestOptions0, "sizeMultiplier(...)");
        if(v > 0 && v1 > 0) {
            ((RequestBuilder)baseRequestOptions0).override(v, v1);
        }
        ((RequestBuilder)baseRequestOptions0).into(this.binding.f);
        this.binding.f.setVisibility(0);
    }

    public static void setTitleIcon$default(MainTabTitleView mainTabTitleView0, String s, int v, int v1, int v2, Object object0) {
        if(object0 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTitleIcon");
        }
        if((v2 & 2) != 0) {
            v = 0;
        }
        if((v2 & 4) != 0) {
            v1 = 0;
        }
        mainTabTitleView0.setTitleIcon(s, v, v1);
    }

    public final void setTitleRightMargin(float f) {
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.binding.e.getLayoutParams();
        q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).rightMargin = ScreenUtils.dipToPixel(this.getContext(), f);
        this.binding.e.setLayoutParams(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0));
    }

    public final void setTitleTextSize(float f) {
        this.binding.e.setTextSize(1, f);
    }

    public final void setViewAllText(int v) {
        this.binding.h.setText(v);
    }

    public final void setViewAllText(@Nullable String s) {
        this.binding.h.setText(s);
    }

    public final void setVisibleNewDot(boolean z) {
        ViewUtils.showWhen(this.binding.b, z);
    }

    public final void updateContentDescription() {
        ViewUtils.setContentDescriptionWithButtonClassName(this.binding.h, "전체보기", this.binding.e.getText());
    }
}

