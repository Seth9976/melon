package com.iloen.melon.fragments.mymusic.dna;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.A0;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.w0;
import com.iloen.melon.utils.system.ScreenUtils;
import java.util.LinkedHashSet;
import je.p;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001A\u00020\u00068\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001A\u00020\u00068\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\t\u0010\bR\"\u0010\u000B\u001A\u00020\n8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u000B\u0010\f\u001A\u0004\b\u000B\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0011\u001A\u00020\u00108\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/dna/PositionedHorizontalRecyclerView;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "", "state", "I", "deltaX", "", "isSmallItem", "Z", "()Z", "setSmallItem", "(Z)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class PositionedHorizontalRecyclerView extends O0 {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0006\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/dna/PositionedHorizontalRecyclerView$Companion;", "", "<init>", "()V", "TAG", "", "MAX_PERCENTAGE", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final double MAX_PERCENTAGE = 0.5;
    @NotNull
    private static final String TAG = "PositionedHorizontalRecyclerView";
    private int deltaX;
    private boolean isSmallItem;
    @NotNull
    private final RecyclerView recyclerView;
    private int state;

    static {
        PositionedHorizontalRecyclerView.Companion = new Companion(null);
        PositionedHorizontalRecyclerView.$stable = 8;
    }

    public PositionedHorizontalRecyclerView(@NotNull View view0) {
        q.g(view0, "view");
        super(view0);
        this.isSmallItem = true;
        View view1 = view0.findViewById(0x7F0A09CF);  // id:recycler_horizontal
        q.f(view1, "findViewById(...)");
        this.recyclerView = (RecyclerView)view1;
        Context context0 = view0.getContext();
        q.f(context0, "getContext(...)");
        ((RecyclerView)view1).setLayoutManager(new SmoothScrollLinearLayoutManager(context0));
        ((RecyclerView)view1).setHasFixedSize(true);
        ((RecyclerView)view1).addOnScrollListener(new A0() {
            private final double getVisibleWidthPercentage(View view0) {
                Rect rect0 = new Rect();
                return view0.getLocalVisibleRect(rect0) ? ((double)rect0.width()) / ((double)view0.getMeasuredWidth()) : 0.0;
            }

            @Override  // androidx.recyclerview.widget.A0
            public void onScrollStateChanged(RecyclerView recyclerView0, int v) {
                q.g(recyclerView0, "recyclerView");
                if(((RecyclerView)view1).deltaX != 0) {
                    int v1 = ((RecyclerView)view1).state;
                    ((RecyclerView)view1).state = v;
                    if(v1 == 2 && v == 0 || v1 == 1 && v == 0) {
                        w0 w00 = recyclerView0.getLayoutManager();
                        q.e(w00, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.dna.SmoothScrollLinearLayoutManager");
                        int v2 = ((SmoothScrollLinearLayoutManager)w00).findFirstVisibleItemPosition();
                        int v3 = ((SmoothScrollLinearLayoutManager)w00).findLastVisibleItemPosition();
                        recyclerView0.getGlobalVisibleRect(new Rect());
                        LinkedHashSet linkedHashSet0 = new LinkedHashSet();
                        if(v2 <= v3) {
                            while(true) {
                                View view0 = ((SmoothScrollLinearLayoutManager)w00).findViewByPosition(v2);
                                if(view0 != null && this.getVisibleWidthPercentage(view0) > 0.5) {
                                    linkedHashSet0.add(v2);
                                }
                                if(v2 == v3) {
                                    break;
                                }
                                ++v2;
                            }
                        }
                        int v4 = ((SmoothScrollLinearLayoutManager)w00).getItemCount();
                        Integer integer0 = (Integer)p.v0(linkedHashSet0);
                        int v5 = integer0 == null ? 0 : ((int)integer0);
                        Integer integer1 = (Integer)p.u0(linkedHashSet0);
                        int v6 = integer1 == null ? 0 : ((int)integer1);
                        if(((RecyclerView)view1).isSmallItem()) {
                            Integer integer2 = (Integer)p.v0(linkedHashSet0);
                            v5 = integer2 == null ? 0 : ((int)integer2);
                        }
                        else if(((RecyclerView)view1).deltaX <= 0) {
                            v5 = v5 == 0 ? 0 : v6;
                        }
                        else if(v4 - 1 == v6) {
                            v5 = v6;
                        }
                        ((SmoothScrollLinearLayoutManager)w00).setOffset((v5 == 0 ? 0 : ScreenUtils.dipToPixel(this.$this_apply.getContext(), 8.0f)));
                        this.$this_apply.smoothScrollToPosition(v5);
                        ((RecyclerView)view1).deltaX = 0;
                    }
                }
            }

            @Override  // androidx.recyclerview.widget.A0
            public void onScrolled(RecyclerView recyclerView0, int v, int v1) {
                q.g(recyclerView0, "recyclerView");
                PositionedHorizontalRecyclerView.access$setDeltaX$p(((RecyclerView)view1), v);
            }
        });
    }

    @NotNull
    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    public final boolean isSmallItem() {
        return this.isSmallItem;
    }

    public final void setSmallItem(boolean z) {
        this.isSmallItem = z;
    }
}

