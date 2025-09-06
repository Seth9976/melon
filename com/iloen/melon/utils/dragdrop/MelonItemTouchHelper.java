package com.iloen.melon.utils.dragdrop;

import Cb.i;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.P;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.w0;
import androidx.recyclerview.widget.z0;
import com.iloen.melon.utils.dragdrop.scroll.ScrollStrategyBase.ScrollSpeed;
import com.iloen.melon.utils.system.ScreenUtils;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import ne.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 62\u00020\u0001:\u00046789B\u0013\b\u0016\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001B\b\u0016\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\u0004\u0010\bJ\u001F\u0010\f\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\u00022\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001F\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\t\u001A\u00020\u00022\u0006\u0010\u000B\u001A\u00020\nH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\u0017\u0010\u0012\u001A\u00020\u000E2\u0006\u0010\u0011\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001A\u00020\u000E2\b\u0010\u0015\u001A\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001A\u00020\u000E2\b\u0010\u0015\u001A\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0019\u0010\u001AJ\u0015\u0010\u001D\u001A\u00020\u000E2\u0006\u0010\u001C\u001A\u00020\u001B¢\u0006\u0004\b\u001D\u0010\u001EJ\u0015\u0010!\u001A\u00020\u000E2\u0006\u0010 \u001A\u00020\u001F¢\u0006\u0004\b!\u0010\"J\u0015\u0010$\u001A\u00020\u000E2\u0006\u0010#\u001A\u00020\u001B¢\u0006\u0004\b$\u0010\u001EJ\u0015\u0010&\u001A\u00020\u000E2\u0006\u0010%\u001A\u00020\u001F¢\u0006\u0004\b&\u0010\"J\u0017\u0010)\u001A\u00020\u000E2\b\u0010(\u001A\u0004\u0018\u00010\'¢\u0006\u0004\b)\u0010*J\u001D\u0010/\u001A\u00020\u000E2\u0006\u0010,\u001A\u00020+2\u0006\u0010.\u001A\u00020-¢\u0006\u0004\b/\u00100J\u0015\u00102\u001A\u00020\u000E2\u0006\u00101\u001A\u00020+¢\u0006\u0004\b2\u00103J\r\u00104\u001A\u00020\u000E¢\u0006\u0004\b4\u00105¨\u0006:"}, d2 = {"Lcom/iloen/melon/utils/dragdrop/MelonItemTouchHelper;", "Landroidx/recyclerview/widget/z0;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;)V", "", "isLongPressEnabled", "(Landroidx/recyclerview/widget/RecyclerView;Z)V", "rv", "Landroid/view/MotionEvent;", "e", "onInterceptTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)Z", "Lie/H;", "onTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)V", "disallowIntercept", "onRequestDisallowInterceptTouchEvent", "(Z)V", "Lcom/iloen/melon/utils/dragdrop/MelonItemTouchHelper$ItemMoveListener;", "listener", "setOnItemMovedListener", "(Lcom/iloen/melon/utils/dragdrop/MelonItemTouchHelper$ItemMoveListener;)V", "Lcom/iloen/melon/utils/dragdrop/MelonItemTouchHelper$CustomSelectorListener;", "setOnCustomSelectorListener", "(Lcom/iloen/melon/utils/dragdrop/MelonItemTouchHelper$CustomSelectorListener;)V", "", "handleId", "setViewHandleId", "(I)V", "", "alpha", "setFloatingAlpha", "(F)V", "color", "setFloatingBgColor", "windowSizeRate", "setAutoScrollWindow", "Lcom/iloen/melon/utils/dragdrop/scroll/ScrollStrategyBase$ScrollSpeed;", "speed", "setAutoScrollSpeed", "(Lcom/iloen/melon/utils/dragdrop/scroll/ScrollStrategyBase$ScrollSpeed;)V", "", "time", "Landroidx/lifecycle/D;", "viewLifecycleOwner", "setHandlePressTime", "(JLandroidx/lifecycle/D;)V", "millis", "setLongPressTime", "(J)V", "cancel", "()V", "Companion", "ItemMoveListener", "CustomSelectorListener", "LongPressDetector", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonItemTouchHelper implements z0 {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001A\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/iloen/melon/utils/dragdrop/MelonItemTouchHelper$Companion;", "", "", "TAG", "Ljava/lang/String;", "", "EVENT_LONG_PRESS", "I", "LONG_PRESS_TIME_DEFAULT", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/utils/dragdrop/MelonItemTouchHelper$CustomSelectorListener;", "", "", "isSelected", "Landroid/view/View;", "selectedView", "Lie/H;", "onItemSelectStateChanged", "(ZLandroid/view/View;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface CustomSelectorListener {
        void onItemSelectStateChanged(boolean arg1, @Nullable View arg2);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001F\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0004\u001A\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000B¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/utils/dragdrop/MelonItemTouchHelper$ItemMoveListener;", "", "", "fromPosition", "toPosition", "Lie/H;", "onItemMoved", "(II)V", "position", "", "onItemCheckEnable", "(I)Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface ItemMoveListener {
        boolean onItemCheckEnable(int arg1);

        void onItemMoved(int arg1, int arg2);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0080\u0004\u0018\u00002\u00020\u0001:\u0001\u0011B\u0011\u0012\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001D\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\u000B\u0010\fJ\u0015\u0010\u000F\u001A\u00020\n2\u0006\u0010\u000E\u001A\u00020\r¢\u0006\u0004\b\u000F\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/utils/dragdrop/MelonItemTouchHelper$LongPressDetector;", "", "Landroid/content/Context;", "context", "<init>", "(Lcom/iloen/melon/utils/dragdrop/MelonItemTouchHelper;Landroid/content/Context;)V", "Landroid/view/MotionEvent;", "e", "", "itemPos", "Lie/H;", "onCustomLongPressCalc", "(Landroid/view/MotionEvent;I)V", "", "pressCheckTime", "setPressCheckTime", "(J)V", "LongPressHandler", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public final class LongPressDetector {
        @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/iloen/melon/utils/dragdrop/MelonItemTouchHelper$LongPressDetector$LongPressHandler;", "Landroid/os/Handler;", "<init>", "(Lcom/iloen/melon/utils/dragdrop/MelonItemTouchHelper$LongPressDetector;)V", "Landroid/os/Message;", "msg", "Lie/H;", "handleMessage", "(Landroid/os/Message;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class LongPressHandler extends Handler {
            public final LongPressDetector a;

            public LongPressHandler() {
                super(Looper.getMainLooper());
            }

            @Override  // android.os.Handler
            public void handleMessage(@NotNull Message message0) {
                q.g(message0, "msg");
                if(message0.what == 0) {
                    Object object0 = message0.obj;
                    q.e(object0, "null cannot be cast to non-null type kotlin.Int");
                    int v = (int)(((Integer)object0));
                    LongPressDetector melonItemTouchHelper$LongPressDetector0 = LongPressDetector.this;
                    ItemMoveListener melonItemTouchHelper$ItemMoveListener0 = MelonItemTouchHelper.this.o;
                    if(melonItemTouchHelper$ItemMoveListener0 != null && melonItemTouchHelper$ItemMoveListener0.onItemCheckEnable(v)) {
                        RecyclerView recyclerView0 = MelonItemTouchHelper.this.a;
                        O0 o00 = recyclerView0 == null ? null : recyclerView0.findViewHolderForAdapterPosition(v);
                        if(o00 != null) {
                            P p0 = MelonItemTouchHelper.this.c;
                            if(p0 != null) {
                                p0.n(o00);
                            }
                        }
                    }
                    LongPressDetector.access$clearData(melonItemTouchHelper$LongPressDetector0);
                }
            }
        }

        public final double a;
        public float b;
        public float c;
        public boolean d;
        public long e;
        public final LongPressHandler f;
        public final MelonItemTouchHelper g;

        public LongPressDetector(@Nullable Context context0) {
            this.e = 1000L;
            double f = Math.pow(ScreenUtils.getScreenWidth(context0), 2.0);
            this.a = Math.sqrt(Math.pow(ScreenUtils.getScreenHeight(context0), 2.0) + f) * 0.01;
            this.f = new LongPressHandler(this);
        }

        public static final void access$clearData(LongPressDetector melonItemTouchHelper$LongPressDetector0) {
            melonItemTouchHelper$LongPressDetector0.f.removeMessages(0);
            melonItemTouchHelper$LongPressDetector0.d = false;
            melonItemTouchHelper$LongPressDetector0.b = 0.0f;
            melonItemTouchHelper$LongPressDetector0.c = 0.0f;
        }

        public final void onCustomLongPressCalc(@NotNull MotionEvent motionEvent0, int v) {
            q.g(motionEvent0, "e");
            double f = this.a;
            if(f > 0.0) {
                int v1 = motionEvent0.getAction();
                LongPressHandler melonItemTouchHelper$LongPressDetector$LongPressHandler0 = this.f;
                if(v1 == 0) {
                    this.b = motionEvent0.getX();
                    this.c = motionEvent0.getY();
                    this.d = true;
                    melonItemTouchHelper$LongPressDetector$LongPressHandler0.sendMessageDelayed(melonItemTouchHelper$LongPressDetector$LongPressHandler0.obtainMessage(0, v), this.e);
                    return;
                }
                if(motionEvent0.getAction() != 2) {
                    goto label_20;
                }
                if(this.d) {
                    float f1 = motionEvent0.getX() - this.b;
                    if(Math.sqrt(Math.pow(motionEvent0.getY() - this.c, 2.0) + Math.pow(f1, 2.0)) > f) {
                        melonItemTouchHelper$LongPressDetector$LongPressHandler0.removeMessages(0);
                        this.d = false;
                        this.b = 0.0f;
                        this.c = 0.0f;
                        return;
                    label_20:
                        melonItemTouchHelper$LongPressDetector$LongPressHandler0.removeMessages(0);
                        this.d = false;
                        this.b = 0.0f;
                        this.c = 0.0f;
                    }
                }
            }
        }

        public final void setPressCheckTime(long v) {
            this.e = v;
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public final RecyclerView a;
    public D b;
    public final P c;
    public int d;
    public long e;
    public boolean f;
    public int g;
    public int h;
    public float i;
    public int j;
    public float k;
    public int l;
    public View m;
    public final MelonItemTouchHelperCallback n;
    public ItemMoveListener o;
    public CustomSelectorListener p;
    public final LongPressDetector q;
    public Job r;
    public final double s;
    public float t;
    public float u;

    static {
        MelonItemTouchHelper.Companion = new Companion(null);
        MelonItemTouchHelper.$stable = 8;
    }

    public MelonItemTouchHelper(@Nullable RecyclerView recyclerView0) {
        this(recyclerView0, true);
    }

    public MelonItemTouchHelper(@Nullable RecyclerView recyclerView0, boolean z) {
        this.d = -1;
        this.g = -1;
        this.h = -1;
        this.i = 0.5f;
        this.a = recyclerView0;
        Context context0 = recyclerView0 == null ? null : recyclerView0.getContext();
        double f = Math.pow(ScreenUtils.getScreenWidth(context0), 2.0);
        this.s = Math.sqrt(Math.pow(ScreenUtils.getScreenHeight(context0), 2.0) + f) * 0.01;
        if(recyclerView0 != null) {
            j0 j00 = recyclerView0.getAdapter();
            if(j00 != null) {
                j00.registerAdapterDataObserver(new MelonItemTouchHelper.initItemTouchHelper.1.1(this));
            }
            if(z) {
                this.q = new LongPressDetector(this, recyclerView0.getContext());
            }
            w0 w00 = recyclerView0.getLayoutManager();
            MelonItemTouchHelperCallback melonItemTouchHelperCallback0 = new MelonItemTouchHelperCallback(new MelonItemTouchHelper.initItemTouchHelper.1.2(this, recyclerView0), w00 instanceof LinearLayoutManager && ((LinearLayoutManager)w00).getOrientation() == 0);
            this.n = melonItemTouchHelperCallback0;
            P p0 = new P(melonItemTouchHelperCallback0);  // 初始化器: Landroidx/recyclerview/widget/O;-><init>(Landroidx/recyclerview/widget/L;)V
            this.c = p0;
            p0.c(recyclerView0);
            recyclerView0.addOnItemTouchListener(this);
        }
    }

    public static final void access$changeViewAlpha(MelonItemTouchHelper melonItemTouchHelper0, float f) {
        View view0 = melonItemTouchHelper0.m;
        if(view0 != null) {
            view0.setAlpha(f);
        }
    }

    public static final void access$changeViewBackground(MelonItemTouchHelper melonItemTouchHelper0, int v) {
        View view0 = melonItemTouchHelper0.m;
        if(view0 != null) {
            view0.setBackgroundColor(v);
        }
    }

    public static final int access$getBeginPos$p(MelonItemTouchHelper melonItemTouchHelper0) {
        return melonItemTouchHelper0.g;
    }

    public static final int access$getBgColor$p(MelonItemTouchHelper melonItemTouchHelper0) {
        return melonItemTouchHelper0.j;
    }

    public static final CustomSelectorListener access$getCustomSelectorListener$p(MelonItemTouchHelper melonItemTouchHelper0) {
        return melonItemTouchHelper0.p;
    }

    public static final int access$getEndPos$p(MelonItemTouchHelper melonItemTouchHelper0) {
        return melonItemTouchHelper0.h;
    }

    public static final float access$getFloatAlpha$p(MelonItemTouchHelper melonItemTouchHelper0) {
        return melonItemTouchHelper0.i;
    }

    public static final View access$getLastSelectedItemView$p(MelonItemTouchHelper melonItemTouchHelper0) {
        return melonItemTouchHelper0.m;
    }

    public static final float access$getSavedAlpha$p(MelonItemTouchHelper melonItemTouchHelper0) {
        return melonItemTouchHelper0.k;
    }

    public static final int access$getSavedBgColor$p(MelonItemTouchHelper melonItemTouchHelper0) {
        return melonItemTouchHelper0.l;
    }

    public static final void access$setBeginPos$p(MelonItemTouchHelper melonItemTouchHelper0, int v) {
        melonItemTouchHelper0.g = v;
    }

    public static final void access$setEndPos$p(MelonItemTouchHelper melonItemTouchHelper0, int v) {
        melonItemTouchHelper0.h = v;
    }

    public static final void access$setSavedAlpha$p(MelonItemTouchHelper melonItemTouchHelper0, float f) {
        melonItemTouchHelper0.k = f;
    }

    public static final void access$setSavedBgColor$p(MelonItemTouchHelper melonItemTouchHelper0, int v) {
        melonItemTouchHelper0.l = v;
    }

    public final void cancel() {
        P p0 = this.c;
        if(p0 != null) {
            p0.m(null, 0);
        }
    }

    @Override  // androidx.recyclerview.widget.z0
    public boolean onInterceptTouchEvent(@NotNull RecyclerView recyclerView0, @NotNull MotionEvent motionEvent0) {
        q.g(recyclerView0, "rv");
        q.g(motionEvent0, "e");
        View view0 = recyclerView0.findChildViewUnder(motionEvent0.getX(), motionEvent0.getY());
        this.m = view0;
        if(view0 != null) {
            int v = recyclerView0.getChildAdapterPosition(view0);
            Job job0 = null;
            if(motionEvent0.getAction() == 0) {
                j0 j00 = recyclerView0.getAdapter();
                if(!(j00 instanceof DragSortHeaderFooterAdapter) || (!((DragSortHeaderFooterAdapter)j00).hasDragSortHeaderView() || ((DragSortHeaderFooterAdapter)j00).getDragSortHeaderViewPosition() != v) && (!((DragSortHeaderFooterAdapter)j00).hasDragSortFooterView() || ((DragSortHeaderFooterAdapter)j00).getDragSortFooterViewPosition() != v)) {
                    int v1 = this.d;
                    if(v1 >= 0) {
                        View view1 = view0.findViewById(v1);
                        if(view1 == null) {
                            goto label_58;
                        }
                        else {
                            this.t = motionEvent0.getX();
                            this.u = motionEvent0.getY();
                            int[] arr_v = new int[2];
                            view0.getLocationInWindow(arr_v);
                            int[] arr_v1 = new int[2];
                            view1.getLocationInWindow(arr_v1);
                            int v2 = arr_v1[0] - arr_v[0];
                            int v3 = arr_v1[1] - arr_v[1];
                            int v4 = view0.getLeft();
                            int v5 = view0.getTop();
                            int v6 = view0.getLeft();
                            int v7 = view1.getWidth();
                            int v8 = view0.getTop();
                            if(!new Rect(v4 + v2, v5 + v3, v7 + (v6 + v2), view1.getHeight() + (v8 + v3)).contains(((int)motionEvent0.getX()), ((int)motionEvent0.getY())) || (this.o == null || !this.o.onItemCheckEnable(v))) {
                                goto label_58;
                            }
                            else {
                                O0 o00 = recyclerView0.findViewHolderForAdapterPosition(v);
                                if(o00 == null) {
                                    goto label_58;
                                }
                                else {
                                    if(i.l(this.b)) {
                                        D d0 = this.b;
                                        if(d0 != null) {
                                            job0 = BuildersKt__Builders_commonKt.launch$default(f0.f(d0), Dispatchers.getIO(), null, new n(o00, null) {
                                                public final O0 B;
                                                public int r;
                                                public final MelonItemTouchHelper w;

                                                {
                                                    this.w = melonItemTouchHelper0;
                                                    this.B = o00;
                                                    super(2, continuation0);
                                                }

                                                @Override  // oe.a
                                                public final Continuation create(Object object0, Continuation continuation0) {
                                                    return new com.iloen.melon.utils.dragdrop.MelonItemTouchHelper.onInterceptTouchEvent.1.1(this.w, this.B, continuation0);
                                                }

                                                @Override  // we.n
                                                public Object invoke(Object object0, Object object1) {
                                                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                }

                                                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                    return ((com.iloen.melon.utils.dragdrop.MelonItemTouchHelper.onInterceptTouchEvent.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                }

                                                @Override  // oe.a
                                                public final Object invokeSuspend(Object object0) {
                                                    a a0 = a.a;
                                                    MelonItemTouchHelper melonItemTouchHelper0 = this.w;
                                                    switch(this.r) {
                                                        case 0: {
                                                            d5.n.D(object0);
                                                            melonItemTouchHelper0.f = true;
                                                            this.r = 1;
                                                            if(DelayKt.delay(melonItemTouchHelper0.e, this) == a0) {
                                                                return a0;
                                                            }
                                                            break;
                                                        }
                                                        case 1: {
                                                            d5.n.D(object0);
                                                            break;
                                                        }
                                                        case 2: {
                                                            d5.n.D(object0);
                                                            return H.a;
                                                        }
                                                        default: {
                                                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                        }
                                                    }
                                                    com.iloen.melon.utils.dragdrop.MelonItemTouchHelper.onInterceptTouchEvent.1.1.1 melonItemTouchHelper$onInterceptTouchEvent$1$1$10 = new n(this.B, null) {
                                                        public final MelonItemTouchHelper r;
                                                        public final O0 w;

                                                        {
                                                            this.r = melonItemTouchHelper0;
                                                            this.w = o00;
                                                            super(2, continuation0);
                                                        }

                                                        @Override  // oe.a
                                                        public final Continuation create(Object object0, Continuation continuation0) {
                                                            return new com.iloen.melon.utils.dragdrop.MelonItemTouchHelper.onInterceptTouchEvent.1.1.1(this.r, this.w, continuation0);
                                                        }

                                                        @Override  // we.n
                                                        public Object invoke(Object object0, Object object1) {
                                                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                        }

                                                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                            return ((com.iloen.melon.utils.dragdrop.MelonItemTouchHelper.onInterceptTouchEvent.1.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                        }

                                                        @Override  // oe.a
                                                        public final Object invokeSuspend(Object object0) {
                                                            d5.n.D(object0);
                                                            MelonItemTouchHelper melonItemTouchHelper0 = this.r;
                                                            P p0 = melonItemTouchHelper0.c;
                                                            if(p0 != null) {
                                                                p0.n(this.w);
                                                            }
                                                            melonItemTouchHelper0.f = false;
                                                            return H.a;
                                                        }
                                                    };
                                                    this.r = 2;
                                                    return BuildersKt.withContext(Dispatchers.getMain(), melonItemTouchHelper$onInterceptTouchEvent$1$1$10, this) == a0 ? a0 : H.a;
                                                }
                                            }, 2, null);
                                        }
                                        this.r = job0;
                                        return false;
                                    }
                                    P p0 = this.c;
                                    if(p0 != null) {
                                        p0.n(o00);
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                    else {
                        goto label_58;
                    }
                }
            }
            else {
                switch(motionEvent0.getAction()) {
                    case 1: {
                        if(this.f) {
                            this.f = false;
                            Job job1 = this.r;
                            if(job1 != null) {
                                DefaultImpls.cancel$default(job1, null, 1, null);
                            }
                            P p1 = this.c;
                            if(p1 != null) {
                                p1.m(null, 0);
                            }
                        }
                        break;
                    }
                    case 2: {
                        if(this.f) {
                            float f = motionEvent0.getX() - this.t;
                            if(Math.sqrt(Math.pow(motionEvent0.getY() - this.u, 2.0) + Math.pow(f, 2.0)) > this.s) {
                                this.f = false;
                                Job job2 = this.r;
                                if(job2 != null) {
                                    DefaultImpls.cancel$default(job2, null, 1, null);
                                }
                            }
                        }
                    }
                }
            label_58:
                LongPressDetector melonItemTouchHelper$LongPressDetector0 = this.q;
                if(melonItemTouchHelper$LongPressDetector0 != null) {
                    melonItemTouchHelper$LongPressDetector0.onCustomLongPressCalc(motionEvent0, v);
                }
            }
        }
        return false;
    }

    @Override  // androidx.recyclerview.widget.z0
    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    @Override  // androidx.recyclerview.widget.z0
    public void onTouchEvent(@NotNull RecyclerView recyclerView0, @NotNull MotionEvent motionEvent0) {
        q.g(recyclerView0, "rv");
        q.g(motionEvent0, "e");
    }

    public final void setAutoScrollSpeed(@Nullable ScrollSpeed scrollStrategyBase$ScrollSpeed0) {
        MelonItemTouchHelperCallback melonItemTouchHelperCallback0 = this.n;
        if(melonItemTouchHelperCallback0 != null) {
            melonItemTouchHelperCallback0.setScrollSpeed(scrollStrategyBase$ScrollSpeed0);
        }
    }

    public final void setAutoScrollWindow(float f) {
        MelonItemTouchHelperCallback melonItemTouchHelperCallback0 = this.n;
        if(melonItemTouchHelperCallback0 != null) {
            melonItemTouchHelperCallback0.setAutoScrollWindow(f);
        }
    }

    public final void setFloatingAlpha(float f) {
        this.i = f;
    }

    public final void setFloatingBgColor(int v) {
        this.j = v;
    }

    public final void setHandlePressTime(long v, @NotNull D d0) {
        q.g(d0, "viewLifecycleOwner");
        this.e = v;
        this.b = d0;
    }

    public final void setLongPressTime(long v) {
        LongPressDetector melonItemTouchHelper$LongPressDetector0 = this.q;
        if(melonItemTouchHelper$LongPressDetector0 != null) {
            melonItemTouchHelper$LongPressDetector0.setPressCheckTime(v);
        }
    }

    public final void setOnCustomSelectorListener(@Nullable CustomSelectorListener melonItemTouchHelper$CustomSelectorListener0) {
        this.p = melonItemTouchHelper$CustomSelectorListener0;
    }

    public final void setOnItemMovedListener(@Nullable ItemMoveListener melonItemTouchHelper$ItemMoveListener0) {
        this.o = melonItemTouchHelper$ItemMoveListener0;
    }

    public final void setViewHandleId(int v) {
        this.d = v;
    }
}

