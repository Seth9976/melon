package com.iloen.melon.fragments.main.foru;

import Tf.o;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.fragments.main.common.TagCollectionView;
import com.iloen.melon.net.v6x.response.ForuMixMakerMainRes.RESPONSE.ARTISTTAGLIST;
import com.iloen.melon.net.v6x.response.ForuMixMakerMainRes.RESPONSE.TAGLIST;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u0015*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u0015B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001B\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0004\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001A\u00020\u000B¢\u0006\u0004\b\u0005\u0010\fJ\'\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001A\u00028\u0000H\u0015¢\u0006\u0002\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/MixMakerTagCollectionView;", "T", "Lcom/iloen/melon/fragments/main/common/TagCollectionView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onCreateChildView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "item", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Ljava/lang/Object;)Landroid/view/View;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MixMakerTagCollectionView extends TagCollectionView {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/iloen/melon/fragments/main/foru/MixMakerTagCollectionView$Companion;", "", "<init>", "()V", "TAG", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "MixMakerTagCollectionView";

    static {
        MixMakerTagCollectionView.Companion = new Companion(null);
        MixMakerTagCollectionView.$stable = 8;
    }

    public MixMakerTagCollectionView(@NotNull Context context0) {
        q.g(context0, "context");
        super(context0);
    }

    public MixMakerTagCollectionView(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        super(context0, attributeSet0);
    }

    public MixMakerTagCollectionView(@NotNull Context context0, @Nullable AttributeSet attributeSet0, int v) {
        q.g(context0, "context");
        super(context0, attributeSet0, v);
    }

    @Override  // com.iloen.melon.fragments.main.common.TagCollectionView
    @SuppressLint({"ClickableViewAccessibility"})
    @NotNull
    public View onCreateChildView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, Object object0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(this.getItemLayoutRes(), viewGroup0, false);
        q.e(view0, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
        View view1 = ((ConstraintLayout)view0).findViewById(0x7F0A0D25);  // id:tv_text
        q.d(((TextView)view1));
        ViewUtilsKt.setAccessibilityButtonClassName(((TextView)view1));
        if(object0 instanceof TAGLIST) {
            String s = ((TAGLIST)object0).emoji;
            ((TextView)view1).setText((s == null || o.H0(s) ? ((TAGLIST)object0).tagName : e.c(((TAGLIST)object0).emoji, " ", ((TAGLIST)object0).tagName)));
            if(((TAGLIST)object0).isSaved) {
                ((ConstraintLayout)view0).setBackgroundResource(0x7F0808E4);  // drawable:shape_rectangle_gray900s_round100
                ((TextView)view1).setTextColor(ColorUtils.getColor(this.getContext(), 0x7F060141));  // color:gray001s
            }
        }
        else if(object0 instanceof ARTISTTAGLIST) {
            View view2 = ((ConstraintLayout)view0).findViewById(0x7F0A0B6B);  // id:thumb_artist
            ((TextView)view1).setText(((ARTISTTAGLIST)object0).tagName);
            view2.setVisibility(0);
            int v = ScreenUtils.dipToPixel(this.getContext(), 36.0f);
            ViewUtils.setDefaultImage(((ImageView)((ConstraintLayout)view0).findViewById(0x7F0A069C)), v, true);  // id:iv_thumb_circle_default
            Glide.with(this.getContext()).load(((ARTISTTAGLIST)object0).imgUrl).apply(RequestOptions.circleCropTransform()).into(((ImageView)((ConstraintLayout)view0).findViewById(0x7F0A069B)));  // id:iv_thumb_circle
            if(((ARTISTTAGLIST)object0).isSaved) {
                ((ConstraintLayout)view0).setBackgroundResource(0x7F0808E4);  // drawable:shape_rectangle_gray900s_round100
                ((TextView)view1).setTextColor(ColorUtils.getColor(this.getContext(), 0x7F060141));  // color:gray001s
            }
            ((TextView)view1).setMaxWidth(ScreenUtils.dipToPixel(this.getContext(), 102.0f));
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = ((TextView)view1).getLayoutParams();
            q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ((LayoutParams)viewGroup$LayoutParams0).setMarginEnd(ScreenUtils.dipToPixel(this.getContext(), 13.0f));
            ((ConstraintLayout)view0).setMaxWidth(ScreenUtils.dipToPixel(this.getContext(), 162.0f));
        }
        ColorStateList colorStateList0 = ((TextView)view1).getTextColors();
        ((ConstraintLayout)view0).setOnTouchListener(new w(((ConstraintLayout)view0), ((TextView)view1), this, ((ConstraintLayout)view0).getBackground(), colorStateList0));
        return (ConstraintLayout)view0;
    }

    private static final boolean onCreateChildView$lambda$0(ConstraintLayout constraintLayout0, TextView textView0, MixMakerTagCollectionView mixMakerTagCollectionView0, Drawable drawable0, ColorStateList colorStateList0, View view0, MotionEvent motionEvent0) {
        int v = motionEvent0.getAction();
        switch(v) {
            case 0: {
                constraintLayout0.setBackgroundResource(0x7F0808E6);  // drawable:shape_rectangle_green500e_round100
                textView0.setTextColor(ColorUtils.getColor(mixMakerTagCollectionView0.getContext(), 0x7F0604B4));  // color:white500e_support_high_contrast
                return true;
            }
            case 1: {
                constraintLayout0.setBackground(drawable0);
                textView0.setTextColor(colorStateList0);
                view0.performClick();
                return true;
            }
            default: {
                if(v != 2) {
                    constraintLayout0.setBackground(drawable0);
                    textView0.setTextColor(colorStateList0);
                }
                return false;
            }
        }
    }
}

