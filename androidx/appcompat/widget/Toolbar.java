package androidx.appcompat.widget;

import Gf.l;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.text.TextUtils.TruncateAt;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.app.ActionBar.LayoutParams;
import androidx.appcompat.app.J;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.customview.view.AbsSavedState;
import androidx.fragment.app.a0;
import c2.W;
import c2.m;
import c2.o;
import c2.p;
import d5.w;
import g.a;
import java.util.ArrayList;

public class Toolbar extends ViewGroup implements m {
    public static class LayoutParams extends ActionBar.LayoutParams {
        public int b;

        public LayoutParams(Context context0, AttributeSet attributeSet0) {
            super(context0, attributeSet0);
            this.b = 0;
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator CREATOR;
        public int c;
        public boolean d;

        static {
            SavedState.CREATOR = new h1();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public SavedState(Parcel parcel0, ClassLoader classLoader0) {
            super(parcel0, classLoader0);
            this.c = parcel0.readInt();
            this.d = parcel0.readInt() != 0;
        }

        @Override  // androidx.customview.view.AbsSavedState
        public final void writeToParcel(Parcel parcel0, int v) {
            super.writeToParcel(parcel0, v);
            parcel0.writeInt(this.c);
            parcel0.writeInt(((int)this.d));
        }
    }

    public int B;
    public int D;
    public G0 E;
    public int G;
    public int I;
    public final int M;
    public CharSequence N;
    public CharSequence S;
    public ColorStateList T;
    public ColorStateList V;
    public boolean W;
    public ActionMenuView a;
    public AppCompatTextView b;
    public boolean b0;
    public AppCompatTextView c;
    public final ArrayList c0;
    public AppCompatImageButton d;
    public final ArrayList d0;
    public AppCompatImageView e;
    public final int[] e0;
    public final Drawable f;
    public final o f0;
    public final CharSequence g;
    public ArrayList g0;
    public AppCompatImageButton h;
    public g1 h0;
    public View i;
    public final d1 i0;
    public Context j;
    public k1 j0;
    public int k;
    public ActionMenuPresenter k0;
    public int l;
    public f1 l0;
    public int m;
    public l m0;
    public final int n;
    public J n0;
    public final int o;
    public boolean o0;
    public OnBackInvokedCallback p0;
    public OnBackInvokedDispatcher q0;
    public int r;
    public boolean r0;
    public final n0 s0;
    public int w;

    public Toolbar(Context context0) {
        this(context0, null);
    }

    public Toolbar(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F040663);  // attr:toolbarStyle
    }

    public Toolbar(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.M = 0x800013;
        this.c0 = new ArrayList();
        this.d0 = new ArrayList();
        this.e0 = new int[2];
        this.f0 = new o(new c1(this, 1));
        this.g0 = new ArrayList();
        this.i0 = new d1(this);
        this.s0 = new n0(this, 1);
        d5.m m0 = d5.m.r(this.getContext(), attributeSet0, a.A, v);
        W.n(this, context0, a.A, attributeSet0, ((TypedArray)m0.c), v);
        TypedArray typedArray0 = (TypedArray)m0.c;
        this.l = typedArray0.getResourceId(28, 0);
        this.m = typedArray0.getResourceId(19, 0);
        this.M = typedArray0.getInteger(0, 0x800013);
        this.n = typedArray0.getInteger(2, 0x30);
        int v1 = typedArray0.getDimensionPixelOffset(22, 0);
        if(typedArray0.hasValue(27)) {
            v1 = typedArray0.getDimensionPixelOffset(27, v1);
        }
        this.D = v1;
        this.B = v1;
        this.w = v1;
        this.r = v1;
        int v2 = typedArray0.getDimensionPixelOffset(25, -1);
        if(v2 >= 0) {
            this.r = v2;
        }
        int v3 = typedArray0.getDimensionPixelOffset(24, -1);
        if(v3 >= 0) {
            this.w = v3;
        }
        int v4 = typedArray0.getDimensionPixelOffset(26, -1);
        if(v4 >= 0) {
            this.B = v4;
        }
        int v5 = typedArray0.getDimensionPixelOffset(23, -1);
        if(v5 >= 0) {
            this.D = v5;
        }
        this.o = typedArray0.getDimensionPixelSize(13, -1);
        int v6 = typedArray0.getDimensionPixelOffset(9, 0x80000000);
        int v7 = typedArray0.getDimensionPixelOffset(5, 0x80000000);
        int v8 = typedArray0.getDimensionPixelSize(7, 0);
        int v9 = typedArray0.getDimensionPixelSize(8, 0);
        this.d();
        G0 g00 = this.E;
        g00.h = false;
        if(v8 != 0x80000000) {
            g00.e = v8;
            g00.a = v8;
        }
        if(v9 != 0x80000000) {
            g00.f = v9;
            g00.b = v9;
        }
        if(v6 != 0x80000000 || v7 != 0x80000000) {
            g00.a(v6, v7);
        }
        this.G = typedArray0.getDimensionPixelOffset(10, 0x80000000);
        this.I = typedArray0.getDimensionPixelOffset(6, 0x80000000);
        this.f = m0.k(4);
        this.g = typedArray0.getText(3);
        CharSequence charSequence0 = typedArray0.getText(21);
        if(!TextUtils.isEmpty(charSequence0)) {
            this.setTitle(charSequence0);
        }
        CharSequence charSequence1 = typedArray0.getText(18);
        if(!TextUtils.isEmpty(charSequence1)) {
            this.setSubtitle(charSequence1);
        }
        this.j = this.getContext();
        this.setPopupTheme(typedArray0.getResourceId(17, 0));
        Drawable drawable0 = m0.k(16);
        if(drawable0 != null) {
            this.setNavigationIcon(drawable0);
        }
        CharSequence charSequence2 = typedArray0.getText(15);
        if(!TextUtils.isEmpty(charSequence2)) {
            this.setNavigationContentDescription(charSequence2);
        }
        Drawable drawable1 = m0.k(11);
        if(drawable1 != null) {
            this.setLogo(drawable1);
        }
        CharSequence charSequence3 = typedArray0.getText(12);
        if(!TextUtils.isEmpty(charSequence3)) {
            this.setLogoDescription(charSequence3);
        }
        if(typedArray0.hasValue(29)) {
            this.setTitleTextColor(m0.j(29));
        }
        if(typedArray0.hasValue(20)) {
            this.setSubtitleTextColor(m0.j(20));
        }
        if(typedArray0.hasValue(14)) {
            this.m(typedArray0.getResourceId(14, 0));
        }
        m0.t();
    }

    public final void a(int v, ArrayList arrayList0) {
        boolean z = this.getLayoutDirection() == 1;
        int v2 = this.getChildCount();
        int v3 = Gravity.getAbsoluteGravity(v, this.getLayoutDirection());
        arrayList0.clear();
        if(z) {
            for(int v4 = v2 - 1; v4 >= 0; --v4) {
                View view0 = this.getChildAt(v4);
                LayoutParams toolbar$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
                if(toolbar$LayoutParams0.b == 0 && this.u(view0)) {
                    int v5 = toolbar$LayoutParams0.a;
                    int v6 = this.getLayoutDirection();
                    int v7 = Gravity.getAbsoluteGravity(v5, v6) & 7;
                    if(v7 != 1 && v7 != 3 && v7 != 5) {
                        v7 = v6 == 1 ? 5 : 3;
                    }
                    if(v7 == v3) {
                        arrayList0.add(view0);
                    }
                }
            }
            return;
        }
        for(int v1 = 0; v1 < v2; ++v1) {
            View view1 = this.getChildAt(v1);
            LayoutParams toolbar$LayoutParams1 = (LayoutParams)view1.getLayoutParams();
            if(toolbar$LayoutParams1.b == 0 && this.u(view1)) {
                int v8 = toolbar$LayoutParams1.a;
                int v9 = this.getLayoutDirection();
                int v10 = Gravity.getAbsoluteGravity(v8, v9) & 7;
                if(v10 != 1 && v10 != 3 && v10 != 5) {
                    v10 = v9 == 1 ? 5 : 3;
                }
                if(v10 == v3) {
                    arrayList0.add(view1);
                }
            }
        }
    }

    @Override  // c2.m
    public final void addMenuProvider(p p0) {
        this.f0.b.add(p0);
        this.f0.a.run();
    }

    public final void b(View view0, boolean z) {
        LayoutParams toolbar$LayoutParams0;
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
        if(viewGroup$LayoutParams0 == null) {
            toolbar$LayoutParams0 = Toolbar.h();
        }
        else {
            toolbar$LayoutParams0 = this.checkLayoutParams(viewGroup$LayoutParams0) ? ((LayoutParams)viewGroup$LayoutParams0) : Toolbar.i(viewGroup$LayoutParams0);
        }
        toolbar$LayoutParams0.b = 1;
        if(z && this.i != null) {
            view0.setLayoutParams(toolbar$LayoutParams0);
            this.d0.add(view0);
            return;
        }
        this.addView(view0, toolbar$LayoutParams0);
    }

    public final void c() {
        if(this.h == null) {
            AppCompatImageButton appCompatImageButton0 = new AppCompatImageButton(this.getContext(), null, 0x7F040662);  // attr:toolbarNavigationButtonStyle
            this.h = appCompatImageButton0;
            appCompatImageButton0.setImageDrawable(this.f);
            this.h.setContentDescription(this.g);
            LayoutParams toolbar$LayoutParams0 = Toolbar.h();
            toolbar$LayoutParams0.a = this.n & 0x70 | 0x800003;
            toolbar$LayoutParams0.b = 2;
            this.h.setLayoutParams(toolbar$LayoutParams0);
            this.h.setOnClickListener(new b(this, 1));
        }
    }

    // 去混淆评级： 低(20)
    @Override  // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return super.checkLayoutParams(viewGroup$LayoutParams0) && viewGroup$LayoutParams0 instanceof LayoutParams;
    }

    public final void d() {
        if(this.E == null) {
            G0 g00 = new G0();  // 初始化器: Ljava/lang/Object;-><init>()V
            g00.a = 0;
            g00.b = 0;
            g00.c = 0x80000000;
            g00.d = 0x80000000;
            g00.e = 0;
            g00.f = 0;
            g00.g = false;
            g00.h = false;
            this.E = g00;
        }
    }

    public final void e() {
        this.f();
        ActionMenuView actionMenuView0 = this.a;
        if(actionMenuView0.r == null) {
            MenuBuilder menuBuilder0 = (MenuBuilder)actionMenuView0.getMenu();
            if(this.l0 == null) {
                this.l0 = new f1(this);
            }
            this.a.setExpandedActionViewsExclusive(true);
            menuBuilder0.b(this.l0, this.j);
            this.w();
        }
    }

    public final void f() {
        if(this.a == null) {
            ActionMenuView actionMenuView0 = new ActionMenuView(this.getContext());
            this.a = actionMenuView0;
            actionMenuView0.setPopupTheme(this.k);
            this.a.setOnMenuItemClickListener(this.i0);
            ActionMenuView actionMenuView1 = this.a;
            l l0 = this.m0;
            d1 d10 = new d1(this);
            actionMenuView1.G = l0;
            actionMenuView1.I = d10;
            LayoutParams toolbar$LayoutParams0 = Toolbar.h();
            toolbar$LayoutParams0.a = this.n & 0x70 | 0x800005;
            this.a.setLayoutParams(toolbar$LayoutParams0);
            this.b(this.a, false);
        }
    }

    public final void g() {
        if(this.d == null) {
            this.d = new AppCompatImageButton(this.getContext(), null, 0x7F040662);  // attr:toolbarNavigationButtonStyle
            LayoutParams toolbar$LayoutParams0 = Toolbar.h();
            toolbar$LayoutParams0.a = this.n & 0x70 | 0x800003;
            this.d.setLayoutParams(toolbar$LayoutParams0);
        }
    }

    @Override  // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return Toolbar.h();
    }

    @Override  // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet0) {
        return new LayoutParams(this.getContext(), attributeSet0);
    }

    @Override  // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        return Toolbar.i(viewGroup$LayoutParams0);
    }

    public CharSequence getCollapseContentDescription() {
        return this.h == null ? null : this.h.getContentDescription();
    }

    public Drawable getCollapseIcon() {
        return this.h == null ? null : this.h.getDrawable();
    }

    public int getContentInsetEnd() {
        G0 g00 = this.E;
        if(g00 != null) {
            return g00.g ? g00.a : g00.b;
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        return this.I == 0x80000000 ? this.getContentInsetEnd() : this.I;
    }

    public int getContentInsetLeft() {
        return this.E == null ? 0 : this.E.a;
    }

    public int getContentInsetRight() {
        return this.E == null ? 0 : this.E.b;
    }

    public int getContentInsetStart() {
        G0 g00 = this.E;
        if(g00 != null) {
            return g00.g ? g00.b : g00.a;
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        return this.G == 0x80000000 ? this.getContentInsetStart() : this.G;
    }

    public int getCurrentContentInsetEnd() {
        return this.a == null || (this.a.r == null || !this.a.r.hasVisibleItems()) ? this.getContentInsetEnd() : Math.max(this.getContentInsetEnd(), Math.max(this.I, 0));
    }

    public int getCurrentContentInsetLeft() {
        return this.getLayoutDirection() == 1 ? this.getCurrentContentInsetEnd() : this.getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return this.getLayoutDirection() == 1 ? this.getCurrentContentInsetStart() : this.getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return this.getNavigationIcon() == null ? this.getContentInsetStart() : Math.max(this.getContentInsetStart(), Math.max(this.G, 0));
    }

    private ArrayList getCurrentMenuItems() {
        ArrayList arrayList0 = new ArrayList();
        Menu menu0 = this.getMenu();
        for(int v = 0; v < menu0.size(); ++v) {
            arrayList0.add(menu0.getItem(v));
        }
        return arrayList0;
    }

    public Drawable getLogo() {
        return this.e == null ? null : this.e.getDrawable();
    }

    public CharSequence getLogoDescription() {
        return this.e == null ? null : this.e.getContentDescription();
    }

    public Menu getMenu() {
        this.e();
        return this.a.getMenu();
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.getContext());
    }

    public View getNavButtonView() {
        return this.d;
    }

    public CharSequence getNavigationContentDescription() {
        return this.d == null ? null : this.d.getContentDescription();
    }

    public Drawable getNavigationIcon() {
        return this.d == null ? null : this.d.getDrawable();
    }

    public ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.k0;
    }

    public Drawable getOverflowIcon() {
        this.e();
        return this.a.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.j;
    }

    public int getPopupTheme() {
        return this.k;
    }

    public CharSequence getSubtitle() {
        return this.S;
    }

    public final TextView getSubtitleTextView() {
        return this.c;
    }

    public CharSequence getTitle() {
        return this.N;
    }

    public int getTitleMarginBottom() {
        return this.D;
    }

    public int getTitleMarginEnd() {
        return this.w;
    }

    public int getTitleMarginStart() {
        return this.r;
    }

    public int getTitleMarginTop() {
        return this.B;
    }

    public final TextView getTitleTextView() {
        return this.b;
    }

    public e0 getWrapper() {
        if(this.j0 == null) {
            this.j0 = new k1(this, true);
        }
        return this.j0;
    }

    public static LayoutParams h() {
        LayoutParams toolbar$LayoutParams0 = new LayoutParams(-2, -2);  // 初始化器: Landroid/view/ViewGroup$MarginLayoutParams;-><init>(II)V
        toolbar$LayoutParams0.b = 0;
        toolbar$LayoutParams0.a = 0x800013;
        return toolbar$LayoutParams0;
    }

    public static LayoutParams i(ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        if(viewGroup$LayoutParams0 instanceof LayoutParams) {
            LayoutParams toolbar$LayoutParams0 = new LayoutParams(((LayoutParams)viewGroup$LayoutParams0));  // 初始化器: Landroidx/appcompat/app/ActionBar$LayoutParams;-><init>(Landroidx/appcompat/app/ActionBar$LayoutParams;)V
            toolbar$LayoutParams0.b = ((LayoutParams)viewGroup$LayoutParams0).b;
            return toolbar$LayoutParams0;
        }
        if(viewGroup$LayoutParams0 instanceof ActionBar.LayoutParams) {
            LayoutParams toolbar$LayoutParams1 = new LayoutParams(((ActionBar.LayoutParams)viewGroup$LayoutParams0));  // 初始化器: Landroidx/appcompat/app/ActionBar$LayoutParams;-><init>(Landroidx/appcompat/app/ActionBar$LayoutParams;)V
            toolbar$LayoutParams1.b = 0;
            return toolbar$LayoutParams1;
        }
        if(viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams) {
            LayoutParams toolbar$LayoutParams2 = new LayoutParams(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0));  // 初始化器: Landroidx/appcompat/app/ActionBar$LayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V
            toolbar$LayoutParams2.b = 0;
            toolbar$LayoutParams2.leftMargin = ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).leftMargin;
            toolbar$LayoutParams2.topMargin = ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).topMargin;
            toolbar$LayoutParams2.rightMargin = ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).rightMargin;
            toolbar$LayoutParams2.bottomMargin = ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).bottomMargin;
            return toolbar$LayoutParams2;
        }
        LayoutParams toolbar$LayoutParams3 = new LayoutParams(viewGroup$LayoutParams0);  // 初始化器: Landroidx/appcompat/app/ActionBar$LayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V
        toolbar$LayoutParams3.b = 0;
        return toolbar$LayoutParams3;
    }

    public final int j(View view0, int v) {
        LayoutParams toolbar$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        int v1 = view0.getMeasuredHeight();
        int v2 = v <= 0 ? 0 : (v1 - v) / 2;
        int v3 = toolbar$LayoutParams0.a & 0x70;
        switch((v3 == 16 || v3 == 0x30 || v3 == 80 ? toolbar$LayoutParams0.a & 0x70 : this.M & 0x70)) {
            case 0x30: {
                return this.getPaddingTop() - v2;
            }
            case 80: {
                return this.getHeight() - this.getPaddingBottom() - v1 - toolbar$LayoutParams0.bottomMargin - v2;
            }
            default: {
                int v4 = this.getPaddingTop();
                int v5 = this.getPaddingBottom();
                int v6 = this.getHeight();
                int v7 = (v6 - v4 - v5 - v1) / 2;
                int v8 = toolbar$LayoutParams0.topMargin;
                if(v7 < v8) {
                    return v4 + v8;
                }
                int v9 = v6 - v5 - v1 - v7 - v4;
                int v10 = toolbar$LayoutParams0.bottomMargin;
                if(v9 < v10) {
                    v7 = Math.max(0, v7 - (v10 - v9));
                }
                return v4 + v7;
            }
        }
    }

    public static int k(View view0) {
        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)view0.getLayoutParams();
        int v = viewGroup$MarginLayoutParams0.getMarginStart();
        return viewGroup$MarginLayoutParams0.getMarginEnd() + v;
    }

    public static int l(View view0) {
        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)view0.getLayoutParams();
        return viewGroup$MarginLayoutParams0.topMargin + viewGroup$MarginLayoutParams0.bottomMargin;
    }

    public void m(int v) {
        this.getMenuInflater().inflate(v, this.getMenu());
    }

    public final void n() {
        for(Object object0: this.g0) {
            this.getMenu().removeItem(((MenuItem)object0).getItemId());
        }
        Menu menu0 = this.getMenu();
        ArrayList arrayList0 = this.getCurrentMenuItems();
        MenuInflater menuInflater0 = this.getMenuInflater();
        for(Object object1: this.f0.b) {
            ((a0)(((p)object1))).a.k(menu0, menuInflater0);
        }
        ArrayList arrayList1 = this.getCurrentMenuItems();
        arrayList1.removeAll(arrayList0);
        this.g0 = arrayList1;
    }

    public final boolean o(View view0) {
        return view0.getParent() == this || this.d0.contains(view0);
    }

    @Override  // android.view.ViewGroup
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.w();
    }

    @Override  // android.view.ViewGroup
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.removeCallbacks(this.s0);
        this.w();
    }

    @Override  // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent0) {
        int v = motionEvent0.getActionMasked();
        if(v == 9) {
            this.b0 = false;
        }
        if(!this.b0 && (v == 9 && !super.onHoverEvent(motionEvent0))) {
            this.b0 = true;
        }
        if(v != 3 && v != 10) {
            return true;
        }
        this.b0 = false;
        return true;
    }

    @Override  // android.view.ViewGroup
    public void onLayout(boolean z, int v, int v1, int v2, int v3) {
        int v35;
        int v31;
        int v43;
        int v39;
        int v27;
        int v21;
        int v15;
        int v14;
        int v4 = this.getLayoutDirection() == 1 ? 1 : 0;
        int v5 = this.getWidth();
        int v6 = this.getHeight();
        int v7 = this.getPaddingLeft();
        int v8 = this.getPaddingRight();
        int v9 = this.getPaddingTop();
        int v10 = this.getPaddingBottom();
        int v11 = v5 - v8;
        int[] arr_v = this.e0;
        arr_v[1] = 0;
        arr_v[0] = 0;
        int v12 = this.getMinimumHeight();
        int v13 = v12 < 0 ? 0 : Math.min(v12, v3 - v1);
        if(!this.u(this.d)) {
            v15 = v7;
            v14 = v11;
        }
        else if(v4 != 0) {
            v14 = this.r(this.d, v11, v13, arr_v);
            v15 = v7;
        }
        else {
            v15 = this.q(this.d, v7, v13, arr_v);
            v14 = v11;
        }
        if(this.u(this.h)) {
            if(v4 == 0) {
                v15 = this.q(this.h, v15, v13, arr_v);
            }
            else {
                v14 = this.r(this.h, v14, v13, arr_v);
            }
        }
        if(this.u(this.a)) {
            if(v4 == 0) {
                v14 = this.r(this.a, v14, v13, arr_v);
            }
            else {
                v15 = this.q(this.a, v15, v13, arr_v);
            }
        }
        int v16 = this.getCurrentContentInsetLeft();
        int v17 = this.getCurrentContentInsetRight();
        arr_v[0] = Math.max(0, v16 - v15);
        arr_v[1] = Math.max(0, v17 - (v11 - v14));
        int v18 = Math.max(v15, v16);
        int v19 = Math.min(v14, v11 - v17);
        if(this.u(this.i)) {
            if(v4 == 0) {
                v18 = this.q(this.i, v18, v13, arr_v);
            }
            else {
                v19 = this.r(this.i, v19, v13, arr_v);
            }
        }
        if(this.u(this.e)) {
            if(v4 == 0) {
                v18 = this.q(this.e, v18, v13, arr_v);
            }
            else {
                v19 = this.r(this.e, v19, v13, arr_v);
            }
        }
        boolean z1 = this.u(this.b);
        boolean z2 = this.u(this.c);
        if(z1) {
            LayoutParams toolbar$LayoutParams0 = (LayoutParams)this.b.getLayoutParams();
            int v20 = toolbar$LayoutParams0.topMargin;
            v21 = this.b.getMeasuredHeight() + v20 + toolbar$LayoutParams0.bottomMargin;
        }
        else {
            v21 = 0;
        }
        if(z2) {
            LayoutParams toolbar$LayoutParams1 = (LayoutParams)this.c.getLayoutParams();
            int v22 = toolbar$LayoutParams1.topMargin;
            v21 = this.c.getMeasuredHeight() + v22 + toolbar$LayoutParams1.bottomMargin + v21;
        }
        if(z1 || z2) {
            AppCompatTextView appCompatTextView0 = z2 ? this.c : this.b;
            LayoutParams toolbar$LayoutParams2 = (LayoutParams)(z1 ? this.b : this.c).getLayoutParams();
            LayoutParams toolbar$LayoutParams3 = (LayoutParams)appCompatTextView0.getLayoutParams();
            boolean z3 = z1 && this.b.getMeasuredWidth() > 0 || z2 && this.c.getMeasuredWidth() > 0;
            switch(this.M & 0x70) {
                case 0x30: {
                    v27 = this.getPaddingTop() + toolbar$LayoutParams2.topMargin + this.B;
                    break;
                }
                case 80: {
                    v27 = v6 - v10 - toolbar$LayoutParams3.bottomMargin - this.D - v21;
                    break;
                }
                default: {
                    int v23 = (v6 - v9 - v10 - v21) / 2;
                    int v24 = toolbar$LayoutParams2.topMargin + this.B;
                    if(v23 < v24) {
                        v23 = v24;
                    }
                    else {
                        int v25 = v6 - v10 - v21 - v23 - v9;
                        int v26 = this.D;
                        if(v25 < toolbar$LayoutParams2.bottomMargin + v26) {
                            v23 = Math.max(0, v23 - (toolbar$LayoutParams3.bottomMargin + v26 - v25));
                        }
                    }
                    v27 = v9 + v23;
                }
            }
            if(v4 == 0) {
                int v36 = (z3 ? this.r : 0) - arr_v[0];
                v18 = Math.max(0, v36) + v18;
                arr_v[0] = Math.max(0, -v36);
                if(z1) {
                    LayoutParams toolbar$LayoutParams5 = (LayoutParams)this.b.getLayoutParams();
                    int v37 = this.b.getMeasuredWidth() + v18;
                    int v38 = this.b.getMeasuredHeight() + v27;
                    this.b.layout(v18, v27, v37, v38);
                    v39 = v37 + this.w;
                    v27 = v38 + toolbar$LayoutParams5.bottomMargin;
                }
                else {
                    v39 = v18;
                }
                if(z2) {
                    int v40 = v27 + ((LayoutParams)this.c.getLayoutParams()).topMargin;
                    int v41 = this.c.getMeasuredWidth() + v18;
                    int v42 = this.c.getMeasuredHeight();
                    this.c.layout(v18, v40, v41, v42 + v40);
                    v43 = v41 + this.w;
                }
                else {
                    v43 = v18;
                }
                if(z3) {
                    v18 = Math.max(v39, v43);
                }
            }
            else {
                int v28 = (z3 ? this.r : 0) - arr_v[1];
                v19 -= Math.max(0, v28);
                arr_v[1] = Math.max(0, -v28);
                if(z1) {
                    LayoutParams toolbar$LayoutParams4 = (LayoutParams)this.b.getLayoutParams();
                    int v29 = v19 - this.b.getMeasuredWidth();
                    int v30 = this.b.getMeasuredHeight() + v27;
                    this.b.layout(v29, v27, v19, v30);
                    v31 = v29 - this.w;
                    v27 = v30 + toolbar$LayoutParams4.bottomMargin;
                }
                else {
                    v31 = v19;
                }
                if(z2) {
                    int v32 = v27 + ((LayoutParams)this.c.getLayoutParams()).topMargin;
                    int v33 = this.c.getMeasuredWidth();
                    int v34 = this.c.getMeasuredHeight();
                    this.c.layout(v19 - v33, v32, v19, v34 + v32);
                    v35 = v19 - this.w;
                }
                else {
                    v35 = v19;
                }
                if(z3) {
                    v19 = Math.min(v31, v35);
                }
            }
        }
        ArrayList arrayList0 = this.c0;
        this.a(3, arrayList0);
        int v44 = arrayList0.size();
        int v45 = v18;
        for(int v46 = 0; v46 < v44; ++v46) {
            v45 = this.q(((View)arrayList0.get(v46)), v45, v13, arr_v);
        }
        this.a(5, arrayList0);
        int v47 = arrayList0.size();
        for(int v48 = 0; v48 < v47; ++v48) {
            v19 = this.r(((View)arrayList0.get(v48)), v19, v13, arr_v);
        }
        this.a(1, arrayList0);
        int v49 = arr_v[0];
        int v50 = arr_v[1];
        int v51 = arrayList0.size();
        int v52 = v49;
        int v53 = 0;
        int v54 = 0;
        while(v53 < v51) {
            View view0 = (View)arrayList0.get(v53);
            LayoutParams toolbar$LayoutParams6 = (LayoutParams)view0.getLayoutParams();
            int v55 = toolbar$LayoutParams6.leftMargin - v52;
            int v56 = toolbar$LayoutParams6.rightMargin - v50;
            v54 += view0.getMeasuredWidth() + Math.max(0, v55) + Math.max(0, v56);
            ++v53;
            v52 = Math.max(0, -v55);
            v50 = Math.max(0, -v56);
        }
        int v58 = (v5 - v7 - v8) / 2 + v7 - v54 / 2;
        int v59 = v54 + v58;
        if(v58 >= v45) {
            v45 = v59 <= v19 ? v58 : v58 - (v59 - v19);
        }
        int v60 = arrayList0.size();
        for(int v57 = 0; v57 < v60; ++v57) {
            v45 = this.q(((View)arrayList0.get(v57)), v45, v13, arr_v);
        }
        arrayList0.clear();
    }

    @Override  // android.view.View
    public void onMeasure(int v, int v1) {
        int v32;
        int v31;
        int v30;
        int v15;
        int v9;
        int v8;
        int v6;
        int v4;
        int v3;
        int v2 = 0;
        if(this.getLayoutDirection() == 1) {
            v3 = 1;
            v4 = 0;
        }
        else {
            v4 = 1;
            v3 = 0;
        }
        if(this.u(this.d)) {
            this.t(this.d, v, 0, v1, this.o);
            int v5 = this.d.getMeasuredWidth();
            v6 = Toolbar.k(this.d) + v5;
            int v7 = this.d.getMeasuredHeight();
            v8 = Math.max(0, Toolbar.l(this.d) + v7);
            v9 = View.combineMeasuredStates(0, this.d.getMeasuredState());
        }
        else {
            v6 = 0;
            v8 = 0;
            v9 = 0;
        }
        if(this.u(this.h)) {
            this.t(this.h, v, 0, v1, this.o);
            int v10 = this.h.getMeasuredWidth();
            v6 = Toolbar.k(this.h) + v10;
            int v11 = this.h.getMeasuredHeight();
            v8 = Math.max(v8, Toolbar.l(this.h) + v11);
            v9 = View.combineMeasuredStates(v9, this.h.getMeasuredState());
        }
        int v12 = this.getCurrentContentInsetStart();
        int v13 = Math.max(v12, v6);
        int[] arr_v = this.e0;
        arr_v[v3] = Math.max(0, v12 - v6);
        if(this.u(this.a)) {
            this.t(this.a, v, v13, v1, this.o);
            int v14 = this.a.getMeasuredWidth();
            v15 = Toolbar.k(this.a) + v14;
            int v16 = this.a.getMeasuredHeight();
            v8 = Math.max(v8, Toolbar.l(this.a) + v16);
            v9 = View.combineMeasuredStates(v9, this.a.getMeasuredState());
        }
        else {
            v15 = 0;
        }
        int v17 = this.getCurrentContentInsetEnd();
        int v18 = v13 + Math.max(v17, v15);
        arr_v[v4] = Math.max(0, v17 - v15);
        if(this.u(this.i)) {
            v18 += this.s(this.i, v, v18, v1, 0, arr_v);
            int v19 = this.i.getMeasuredHeight();
            v8 = Math.max(v8, Toolbar.l(this.i) + v19);
            v9 = View.combineMeasuredStates(v9, this.i.getMeasuredState());
        }
        if(this.u(this.e)) {
            v18 += this.s(this.e, v, v18, v1, 0, arr_v);
            int v20 = this.e.getMeasuredHeight();
            v8 = Math.max(v8, Toolbar.l(this.e) + v20);
            v9 = View.combineMeasuredStates(v9, this.e.getMeasuredState());
        }
        int v21 = this.getChildCount();
        for(int v22 = 0; v22 < v21; ++v22) {
            View view0 = this.getChildAt(v22);
            if(((LayoutParams)view0.getLayoutParams()).b == 0 && this.u(view0)) {
                v18 += this.s(view0, v, v18, v1, 0, arr_v);
                int v23 = view0.getMeasuredHeight();
                int v24 = Math.max(v8, Toolbar.l(view0) + v23);
                v9 = View.combineMeasuredStates(v9, view0.getMeasuredState());
                v8 = v24;
            }
        }
        int v25 = this.B + this.D;
        int v26 = this.r + this.w;
        if(this.u(this.b)) {
            this.s(this.b, v, v18 + v26, v1, v25, arr_v);
            int v27 = this.b.getMeasuredWidth();
            int v28 = Toolbar.k(this.b);
            int v29 = this.b.getMeasuredHeight();
            v30 = Toolbar.l(this.b) + v29;
            v31 = View.combineMeasuredStates(v9, this.b.getMeasuredState());
            v32 = v28 + v27;
        }
        else {
            v30 = 0;
            v31 = v9;
            v32 = 0;
        }
        if(this.u(this.c)) {
            v32 = Math.max(v32, this.s(this.c, v, v18 + v26, v1, v25 + v30, arr_v));
            int v33 = this.c.getMeasuredHeight();
            v30 += Toolbar.l(this.c) + v33;
            v31 = View.combineMeasuredStates(v31, this.c.getMeasuredState());
        }
        int v34 = this.getPaddingLeft();
        int v35 = this.getPaddingRight();
        int v36 = this.getPaddingTop();
        int v37 = this.getPaddingBottom();
        int v38 = View.resolveSizeAndState(Math.max(v35 + v34 + (v18 + v32), this.getSuggestedMinimumWidth()), v, 0xFF000000 & v31);
        int v39 = View.resolveSizeAndState(Math.max(v37 + v36 + Math.max(v8, v30), this.getSuggestedMinimumHeight()), v1, v31 << 16);
        if(this.o0) {
            int v40 = this.getChildCount();
            for(int v41 = 0; v41 < v40; ++v41) {
                View view1 = this.getChildAt(v41);
                if(this.u(view1) && view1.getMeasuredWidth() > 0 && view1.getMeasuredHeight() > 0) {
                    v2 = v39;
                    this.setMeasuredDimension(v38, v2);
                    return;
                }
            }
        }
        else {
            v2 = v39;
        }
        this.setMeasuredDimension(v38, v2);
    }

    @Override  // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable0) {
        if(!(parcelable0 instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable0);
            return;
        }
        super.onRestoreInstanceState(((SavedState)parcelable0).a);
        MenuBuilder menuBuilder0 = this.a == null ? null : this.a.r;
        int v = ((SavedState)parcelable0).c;
        if(v != 0 && this.l0 != null && menuBuilder0 != null) {
            MenuItem menuItem0 = menuBuilder0.findItem(v);
            if(menuItem0 != null) {
                menuItem0.expandActionView();
            }
        }
        if(((SavedState)parcelable0).d) {
            this.removeCallbacks(this.s0);
            this.post(this.s0);
        }
    }

    @Override  // android.view.View
    public final void onRtlPropertiesChanged(int v) {
        super.onRtlPropertiesChanged(v);
        this.d();
        G0 g00 = this.E;
        if(v == 1 == g00.g) {
            return;
        }
        g00.g = v == 1;
        if(g00.h) {
            if(v == 1) {
                g00.a = g00.d == 0x80000000 ? g00.e : g00.d;
                g00.b = g00.c == 0x80000000 ? g00.f : g00.c;
                return;
            }
            g00.a = g00.c == 0x80000000 ? g00.e : g00.c;
            g00.b = g00.d == 0x80000000 ? g00.f : g00.d;
            return;
        }
        g00.a = g00.e;
        g00.b = g00.f;
    }

    @Override  // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelable0 = new SavedState(super.onSaveInstanceState());  // 初始化器: Landroidx/customview/view/AbsSavedState;-><init>(Landroid/os/Parcelable;)V
        f1 f10 = this.l0;
        if(f10 != null) {
            k.m m0 = f10.b;
            if(m0 != null) {
                parcelable0.c = m0.a;
            }
        }
        parcelable0.d = this.p();
        return parcelable0;
    }

    @Override  // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent0) {
        int v = motionEvent0.getActionMasked();
        if(v == 0) {
            this.W = false;
        }
        if(!this.W && (v == 0 && !super.onTouchEvent(motionEvent0))) {
            this.W = true;
        }
        if(v != 1 && v != 3) {
            return true;
        }
        this.W = false;
        return true;
    }

    public final boolean p() {
        return this.a != null && (this.a.E != null && this.a.E.m());
    }

    public final int q(View view0, int v, int v1, int[] arr_v) {
        LayoutParams toolbar$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        int v2 = toolbar$LayoutParams0.leftMargin - arr_v[0];
        int v3 = Math.max(0, v2) + v;
        arr_v[0] = Math.max(0, -v2);
        int v4 = this.j(view0, v1);
        int v5 = view0.getMeasuredWidth();
        view0.layout(v3, v4, v3 + v5, view0.getMeasuredHeight() + v4);
        return v5 + toolbar$LayoutParams0.rightMargin + v3;
    }

    public final int r(View view0, int v, int v1, int[] arr_v) {
        LayoutParams toolbar$LayoutParams0 = (LayoutParams)view0.getLayoutParams();
        int v2 = toolbar$LayoutParams0.rightMargin - arr_v[1];
        int v3 = v - Math.max(0, v2);
        arr_v[1] = Math.max(0, -v2);
        int v4 = this.j(view0, v1);
        int v5 = view0.getMeasuredWidth();
        view0.layout(v3 - v5, v4, v3, view0.getMeasuredHeight() + v4);
        return v3 - (v5 + toolbar$LayoutParams0.leftMargin);
    }

    @Override  // c2.m
    public final void removeMenuProvider(p p0) {
        this.f0.b(p0);
    }

    public final int s(View view0, int v, int v1, int v2, int v3, int[] arr_v) {
        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)view0.getLayoutParams();
        int v4 = viewGroup$MarginLayoutParams0.leftMargin - arr_v[0];
        int v5 = viewGroup$MarginLayoutParams0.rightMargin - arr_v[1];
        int v6 = Math.max(0, v5) + Math.max(0, v4);
        arr_v[0] = Math.max(0, -v4);
        arr_v[1] = Math.max(0, -v5);
        int v7 = this.getPaddingLeft();
        int v8 = ViewGroup.getChildMeasureSpec(v, this.getPaddingRight() + v7 + v6 + v1, viewGroup$MarginLayoutParams0.width);
        int v9 = this.getPaddingTop();
        view0.measure(v8, ViewGroup.getChildMeasureSpec(v2, this.getPaddingBottom() + v9 + viewGroup$MarginLayoutParams0.topMargin + viewGroup$MarginLayoutParams0.bottomMargin + v3, viewGroup$MarginLayoutParams0.height));
        return view0.getMeasuredWidth() + v6;
    }

    public void setBackInvokedCallbackEnabled(boolean z) {
        if(this.r0 != z) {
            this.r0 = z;
            this.w();
        }
    }

    public void setCollapseContentDescription(int v) {
        this.setCollapseContentDescription((v == 0 ? null : this.getContext().getText(v)));
    }

    public void setCollapseContentDescription(CharSequence charSequence0) {
        if(!TextUtils.isEmpty(charSequence0)) {
            this.c();
        }
        AppCompatImageButton appCompatImageButton0 = this.h;
        if(appCompatImageButton0 != null) {
            appCompatImageButton0.setContentDescription(charSequence0);
        }
    }

    public void setCollapseIcon(int v) {
        this.setCollapseIcon(w.B(this.getContext(), v));
    }

    public void setCollapseIcon(Drawable drawable0) {
        if(drawable0 != null) {
            this.c();
            this.h.setImageDrawable(drawable0);
            return;
        }
        AppCompatImageButton appCompatImageButton0 = this.h;
        if(appCompatImageButton0 != null) {
            appCompatImageButton0.setImageDrawable(this.f);
        }
    }

    public void setCollapsible(boolean z) {
        this.o0 = z;
        this.requestLayout();
    }

    public void setContentInsetEndWithActions(int v) {
        if(v < 0) {
            v = 0x80000000;
        }
        if(v != this.I) {
            this.I = v;
            if(this.getNavigationIcon() != null) {
                this.requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int v) {
        if(v < 0) {
            v = 0x80000000;
        }
        if(v != this.G) {
            this.G = v;
            if(this.getNavigationIcon() != null) {
                this.requestLayout();
            }
        }
    }

    public void setLogo(int v) {
        this.setLogo(w.B(this.getContext(), v));
    }

    public void setLogo(Drawable drawable0) {
        if(drawable0 != null) {
            if(this.e == null) {
                this.e = new AppCompatImageView(this.getContext());
            }
            if(!this.o(this.e)) {
                this.b(this.e, true);
            }
        }
        else if(this.e != null && this.o(this.e)) {
            this.removeView(this.e);
            this.d0.remove(this.e);
        }
        AppCompatImageView appCompatImageView0 = this.e;
        if(appCompatImageView0 != null) {
            appCompatImageView0.setImageDrawable(drawable0);
        }
    }

    public void setLogoDescription(int v) {
        this.setLogoDescription(this.getContext().getText(v));
    }

    public void setLogoDescription(CharSequence charSequence0) {
        if(!TextUtils.isEmpty(charSequence0) && this.e == null) {
            this.e = new AppCompatImageView(this.getContext());
        }
        AppCompatImageView appCompatImageView0 = this.e;
        if(appCompatImageView0 != null) {
            appCompatImageView0.setContentDescription(charSequence0);
        }
    }

    public void setNavigationContentDescription(int v) {
        this.setNavigationContentDescription((v == 0 ? null : this.getContext().getText(v)));
    }

    public void setNavigationContentDescription(CharSequence charSequence0) {
        if(!TextUtils.isEmpty(charSequence0)) {
            this.g();
        }
        AppCompatImageButton appCompatImageButton0 = this.d;
        if(appCompatImageButton0 != null) {
            appCompatImageButton0.setContentDescription(charSequence0);
            l1.a(this.d, charSequence0);
        }
    }

    public void setNavigationIcon(int v) {
        this.setNavigationIcon(w.B(this.getContext(), v));
    }

    public void setNavigationIcon(Drawable drawable0) {
        if(drawable0 != null) {
            this.g();
            if(!this.o(this.d)) {
                this.b(this.d, true);
            }
        }
        else if(this.d != null && this.o(this.d)) {
            this.removeView(this.d);
            this.d0.remove(this.d);
        }
        AppCompatImageButton appCompatImageButton0 = this.d;
        if(appCompatImageButton0 != null) {
            appCompatImageButton0.setImageDrawable(drawable0);
        }
    }

    public void setNavigationOnClickListener(View.OnClickListener view$OnClickListener0) {
        this.g();
        this.d.setOnClickListener(view$OnClickListener0);
    }

    public void setOnMenuItemClickListener(g1 g10) {
        this.h0 = g10;
    }

    public void setOverflowIcon(Drawable drawable0) {
        this.e();
        this.a.setOverflowIcon(drawable0);
    }

    public void setPopupTheme(int v) {
        if(this.k != v) {
            this.k = v;
            if(v == 0) {
                this.j = this.getContext();
                return;
            }
            this.j = new ContextThemeWrapper(this.getContext(), v);
        }
    }

    public void setSubtitle(int v) {
        this.setSubtitle(this.getContext().getText(v));
    }

    public void setSubtitle(CharSequence charSequence0) {
        if(!TextUtils.isEmpty(charSequence0)) {
            if(this.c == null) {
                Context context0 = this.getContext();
                AppCompatTextView appCompatTextView0 = new AppCompatTextView(context0);
                this.c = appCompatTextView0;
                appCompatTextView0.setSingleLine();
                this.c.setEllipsize(TextUtils.TruncateAt.END);
                int v = this.m;
                if(v != 0) {
                    this.c.setTextAppearance(context0, v);
                }
                ColorStateList colorStateList0 = this.V;
                if(colorStateList0 != null) {
                    this.c.setTextColor(colorStateList0);
                }
            }
            if(!this.o(this.c)) {
                this.b(this.c, true);
            }
        }
        else if(this.c != null && this.o(this.c)) {
            this.removeView(this.c);
            this.d0.remove(this.c);
        }
        AppCompatTextView appCompatTextView1 = this.c;
        if(appCompatTextView1 != null) {
            appCompatTextView1.setText(charSequence0);
        }
        this.S = charSequence0;
    }

    public void setSubtitleTextColor(int v) {
        this.setSubtitleTextColor(ColorStateList.valueOf(v));
    }

    public void setSubtitleTextColor(ColorStateList colorStateList0) {
        this.V = colorStateList0;
        AppCompatTextView appCompatTextView0 = this.c;
        if(appCompatTextView0 != null) {
            appCompatTextView0.setTextColor(colorStateList0);
        }
    }

    public void setTitle(int v) {
        this.setTitle(this.getContext().getText(v));
    }

    public void setTitle(CharSequence charSequence0) {
        if(!TextUtils.isEmpty(charSequence0)) {
            if(this.b == null) {
                Context context0 = this.getContext();
                AppCompatTextView appCompatTextView0 = new AppCompatTextView(context0);
                this.b = appCompatTextView0;
                appCompatTextView0.setSingleLine();
                this.b.setEllipsize(TextUtils.TruncateAt.END);
                int v = this.l;
                if(v != 0) {
                    this.b.setTextAppearance(context0, v);
                }
                ColorStateList colorStateList0 = this.T;
                if(colorStateList0 != null) {
                    this.b.setTextColor(colorStateList0);
                }
            }
            if(!this.o(this.b)) {
                this.b(this.b, true);
            }
        }
        else if(this.b != null && this.o(this.b)) {
            this.removeView(this.b);
            this.d0.remove(this.b);
        }
        AppCompatTextView appCompatTextView1 = this.b;
        if(appCompatTextView1 != null) {
            appCompatTextView1.setText(charSequence0);
        }
        this.N = charSequence0;
    }

    public void setTitleMarginBottom(int v) {
        this.D = v;
        this.requestLayout();
    }

    public void setTitleMarginEnd(int v) {
        this.w = v;
        this.requestLayout();
    }

    public void setTitleMarginStart(int v) {
        this.r = v;
        this.requestLayout();
    }

    public void setTitleMarginTop(int v) {
        this.B = v;
        this.requestLayout();
    }

    public void setTitleTextColor(int v) {
        this.setTitleTextColor(ColorStateList.valueOf(v));
    }

    public void setTitleTextColor(ColorStateList colorStateList0) {
        this.T = colorStateList0;
        AppCompatTextView appCompatTextView0 = this.b;
        if(appCompatTextView0 != null) {
            appCompatTextView0.setTextColor(colorStateList0);
        }
    }

    public final void t(View view0, int v, int v1, int v2, int v3) {
        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)view0.getLayoutParams();
        int v4 = this.getPaddingLeft();
        int v5 = ViewGroup.getChildMeasureSpec(v, this.getPaddingRight() + v4 + viewGroup$MarginLayoutParams0.leftMargin + viewGroup$MarginLayoutParams0.rightMargin + v1, viewGroup$MarginLayoutParams0.width);
        int v6 = this.getPaddingTop();
        int v7 = ViewGroup.getChildMeasureSpec(v2, this.getPaddingBottom() + v6 + viewGroup$MarginLayoutParams0.topMargin + viewGroup$MarginLayoutParams0.bottomMargin, viewGroup$MarginLayoutParams0.height);
        int v8 = View.MeasureSpec.getMode(v7);
        if(v8 != 0x40000000 && v3 >= 0) {
            if(v8 != 0) {
                v3 = Math.min(View.MeasureSpec.getSize(v7), v3);
            }
            v7 = View.MeasureSpec.makeMeasureSpec(v3, 0x40000000);
        }
        view0.measure(v5, v7);
    }

    public final boolean u(View view0) {
        return view0 != null && view0.getParent() == this && view0.getVisibility() != 8;
    }

    public final boolean v() {
        return this.a != null && (this.a.E != null && this.a.E.o());
    }

    public final void w() {
        if(Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcher0 = e1.a(this);
            boolean z = this.l0 != null && this.l0.b != null && onBackInvokedDispatcher0 != null && this.isAttachedToWindow() && this.r0;
            if(z && this.q0 == null) {
                if(this.p0 == null) {
                    this.p0 = e1.b(new c1(this, 0));
                }
                e1.c(onBackInvokedDispatcher0, this.p0);
                this.q0 = onBackInvokedDispatcher0;
                return;
            }
            if(!z) {
                OnBackInvokedDispatcher onBackInvokedDispatcher1 = this.q0;
                if(onBackInvokedDispatcher1 != null) {
                    e1.d(onBackInvokedDispatcher1, this.p0);
                    this.q0 = null;
                }
            }
        }
    }
}

