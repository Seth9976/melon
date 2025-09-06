package com.iloen.melon.custom;

import A6.b;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.A;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b3.Z;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0004\f!\"#B!\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\b\u0010\nB\u001B\b\u0016\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\u000BJ\u0015\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\f¢\u0006\u0004\b\u000F\u0010\u0010J%\u0010\u0015\u001A\u00020\u000E2\u0016\u0010\u0014\u001A\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0019\u001A\u00020\u000E2\u0006\u0010\u0018\u001A\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001AR\u0017\u0010 \u001A\u00020\u001B8\u0006¢\u0006\f\n\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u001E\u0010\u001F¨\u0006$"}, d2 = {"Lcom/iloen/melon/custom/ControllerVideoListView;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/iloen/melon/custom/q;", "listener", "Lie/H;", "setOnItemClickListener", "(Lcom/iloen/melon/custom/q;)V", "Ljava/util/ArrayList;", "Lcom/iloen/melon/net/v4x/response/MelonTvVdoRelateVdoListRes$RESPONSE$MVLIST;", "Lkotlin/collections/ArrayList;", "data", "setData", "(Ljava/util/ArrayList;)V", "", "isEnable", "setEnableScroll", "(Z)V", "Lcom/iloen/melon/utils/log/LogU;", "g", "Lcom/iloen/melon/utils/log/LogU;", "getLog", "()Lcom/iloen/melon/utils/log/LogU;", "log", "com/iloen/melon/custom/p", "com/iloen/melon/custom/r", "com/iloen/melon/custom/s", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ControllerVideoListView extends RelativeLayout {
    public final RecyclerView a;
    public final RelativeLayout b;
    public final ImageView c;
    public final MelonTextView d;
    public final r e;
    public q f;
    public final LogU g;

    public ControllerVideoListView(@NotNull Context context0) {
        kotlin.jvm.internal.q.g(context0, "context");
        this(context0, null);
    }

    public ControllerVideoListView(@NotNull Context context0, @Nullable AttributeSet attributeSet0) {
        kotlin.jvm.internal.q.g(context0, "context");
        this(context0, attributeSet0, 0);
    }

    public ControllerVideoListView(@NotNull Context context0, @Nullable AttributeSet attributeSet0, int v) {
        kotlin.jvm.internal.q.g(context0, "context");
        super(context0, attributeSet0, v);
        LogU logU0 = Z.g("ControllerVideoListView", true);
        logU0.setCategory(Category.UI);
        this.g = logU0;
        LayoutInflater.from(context0).inflate(0x7F0D01AC, this, true);  // layout:controller_video_list
        View view0 = this.findViewById(0x7F0A0526);  // id:header_container
        kotlin.jvm.internal.q.f(view0, "findViewById(...)");
        this.b = (RelativeLayout)view0;
        ((RelativeLayout)view0).setVisibility(8);
        View view1 = this.findViewById(0x7F0A0613);  // id:iv_close
        kotlin.jvm.internal.q.f(view1, "findViewById(...)");
        this.c = (ImageView)view1;
        View view2 = this.findViewById(0x7F0A0D34);  // id:tv_title
        kotlin.jvm.internal.q.f(view2, "findViewById(...)");
        this.d = (MelonTextView)view2;
        r r0 = new r(this, context0);
        this.e = r0;
        View view3 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        ((RecyclerView)view3).setLayoutManager(new LinearLayoutManager(0, false));
        ((RecyclerView)view3).setNestedScrollingEnabled(false);
        ((RecyclerView)view3).setHasFixedSize(true);
        ((RecyclerView)view3).addItemDecoration(new p(this, 0));
        ((RecyclerView)view3).setAdapter(r0);
        kotlin.jvm.internal.q.f(view3, "apply(...)");
        this.a = (RecyclerView)view3;
    }

    public final void a() {
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.a.getLayoutParams();
        kotlin.jvm.internal.q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).bottomMargin = ScreenUtils.dipToPixel(this.getContext(), (ScreenUtils.isLandscape(this.getContext()) ? 30.0f : 80.0f));
        this.a.setLayoutParams(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0));
        this.requestLayout();
    }

    public final void b(boolean z) {
        this.b.setVisibility((z ? 0 : 8));
    }

    @NotNull
    public final LogU getLog() {
        return this.g;
    }

    public final void setData(@NotNull ArrayList arrayList0) {
        kotlin.jvm.internal.q.g(arrayList0, "data");
        this.e.getClass();
        this.e.b.clear();
        this.e.b.addAll(arrayList0);
        this.e.notifyDataSetChanged();
        this.a();
        float f = ScreenUtils.isPortrait(this.getContext()) ? 20.0f : 24.0f;
        ViewUtilsKt.setMarginToDp$default(this.d, f, null, null, null, 14, null);
        A a0 = new A(this, 1);
        this.a.addOnScrollListener(a0);
        this.setEnableScroll(false);
        b b0 = new b(this, 26);
        this.c.setOnClickListener(b0);
        this.a.stopScroll();
        this.e.notifyDataSetChanged();
    }

    public final void setEnableScroll(boolean z) {
        this.a.suppressLayout(!z);
    }

    public final void setOnItemClickListener(@NotNull q q0) {
        kotlin.jvm.internal.q.g(q0, "listener");
        this.f = q0;
    }
}

