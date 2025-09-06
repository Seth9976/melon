package com.iloen.melon.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.iloen.melon.utils.system.ScreenUtils;
import k8.t1;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0003\u000B\u0010\u0013B\'\b\u0007\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000E\u001A\u00020\r2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0002¢\u0006\u0004\b\u000E\u0010\u000FJ\u0017\u0010\u0011\u001A\u00020\r2\b\u0010\f\u001A\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/custom/MelonCoverflow;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lcom/iloen/melon/custom/l0;", "listener", "Lie/H;", "setCoverflowItemClickListener", "(Lcom/iloen/melon/custom/l0;)V", "Lcom/iloen/melon/custom/m0;", "setCoverflowItemErrorListener", "(Lcom/iloen/melon/custom/m0;)V", "CoverflowItem", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonCoverflow extends FrameLayout implements View.OnClickListener {
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/iloen/melon/custom/MelonCoverflow$CoverflowItem;", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class CoverflowItem {
        @Override
        public final boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof CoverflowItem)) {
                return false;
            }
            ((CoverflowItem)object0).getClass();
            return true;
        }

        @Override
        public final int hashCode() {
            throw null;
        }

        @Override
        public final String toString() {
            return "CoverflowItem(key=null, fKey=null, text1=null, text2=null, imageLink=null, playTime=null, adultGrade=null, isLiveStreaming=false)";
        }
    }

    public final View a;

    static {
    }

    public MelonCoverflow(@NotNull Context context0) {
        q.g(context0, "context");
        this(context0, null, 6, 0);
    }

    public MelonCoverflow(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        q.g(context0, "context");
        this(context0, attributeSet0, 4, 0);
    }

    public MelonCoverflow(@NotNull Context context0, @Nullable AttributeSet attributeSet0, int v) {
        q.g(context0, "context");
        super(context0, attributeSet0, v);
        if(!this.isInEditMode()) {
            TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, t1.s);
            q.f(typedArray0, "obtainStyledAttributes(...)");
            TextUtils.isEmpty(typedArray0.getString(7));
            typedArray0.getResourceId(4, 0x7F080930);  // drawable:thumbnail_background_image_round
            int v1 = typedArray0.getResourceId(2, 0x7F0D0561);  // layout:mv_coverflow_layout
            typedArray0.getResourceId(0, 0x7F0D0562);  // layout:mvcoverflow_item
            typedArray0.getDimension(1, ((float)ScreenUtils.dipToPixel(context0, 12.0f)));
            boolean z = typedArray0.getBoolean(6, false);
            typedArray0.recycle();
            Object object0 = this.getContext().getSystemService("layout_inflater");
            q.e(object0, "null cannot be cast to non-null type android.view.LayoutInflater");
            View view0 = ((LayoutInflater)object0).inflate(v1, this, true);
            View view1 = view0.findViewById(0x7F0A0356);  // id:coverflow_container
            q.e(view1, "null cannot be cast to non-null type android.widget.HorizontalScrollView");
            View view2 = ((HorizontalScrollView)view1).findViewById(0x7F0A0358);  // id:coverflow_item_container
            q.e(view2, "null cannot be cast to non-null type android.widget.LinearLayout");
            LinearLayout linearLayout0 = (LinearLayout)view2;
            ((HorizontalScrollView)view1).setHorizontalFadingEdgeEnabled(false);
            ((HorizontalScrollView)view1).setHorizontalScrollBarEnabled(z);
            ((HorizontalScrollView)view1).setOverScrollMode(2);
            this.a = view0.findViewById(0x7F0A0359);  // id:coverflow_progress_bar
        }
    }

    public MelonCoverflow(Context context0, AttributeSet attributeSet0, int v, int v1) {
        if((v & 2) != 0) {
            attributeSet0 = null;
        }
        this(context0, attributeSet0, 0);
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        q.g(view0, "v");
        view0.getTag();
    }

    private final void setCoverflowItemClickListener(l0 l00) {
    }

    public final void setCoverflowItemErrorListener(@Nullable m0 m00) {
    }
}

