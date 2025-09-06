package com.google.android.material.search;

import E9.w;
import Fd.C;
import W.m;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.g1;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.a;
import androidx.customview.view.AbsSavedState;
import androidx.media3.session.P0;
import androidx.media3.session.legacy.V;
import c2.B0;
import c2.M;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.B;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.TouchObserverFrameLayout;
import com.google.android.material.internal.t;
import e1.n;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import u6.b;

public class SearchView extends FrameLayout implements a, b {
    public static class Behavior extends androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior {
        public Behavior() {
        }

        public Behavior(Context context0, AttributeSet attributeSet0) {
            super(context0, attributeSet0);
        }

        @Override  // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
        public final boolean h(CoordinatorLayout coordinatorLayout0, View view0, View view1) {
            if(((SearchView)view0).E == null && view1 instanceof SearchBar) {
                ((SearchView)view0).setupWithSearchBar(((SearchBar)view1));
            }
            return false;
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator CREATOR;
        public String c;
        public int d;

        static {
            SavedState.CREATOR = new g();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public SavedState(Parcel parcel0, ClassLoader classLoader0) {
            super(parcel0, classLoader0);
            this.c = parcel0.readString();
            this.d = parcel0.readInt();
        }

        @Override  // androidx.customview.view.AbsSavedState
        public final void writeToParcel(Parcel parcel0, int v) {
            super.writeToParcel(parcel0, v);
            parcel0.writeString(this.c);
            parcel0.writeInt(this.d);
        }
    }

    public final ElevationOverlayProvider B;
    public final LinkedHashSet D;
    public SearchBar E;
    public int G;
    public boolean I;
    public boolean M;
    public boolean N;
    public final int S;
    public boolean T;
    public boolean V;
    public h W;
    public final View a;
    public final ClippableRoundedCornerLayout b;
    public HashMap b0;
    public final View c;
    public static final int c0;
    public final View d;
    public final FrameLayout e;
    public final FrameLayout f;
    public final MaterialToolbar g;
    public final Toolbar h;
    public final TextView i;
    public final EditText j;
    public final ImageButton k;
    public final View l;
    public final TouchObserverFrameLayout m;
    public final boolean n;
    public final l o;
    public final V r;
    public final boolean w;

    public SearchView(Context context0) {
        this(context0, null);
    }

    public SearchView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F040413);  // attr:materialSearchViewStyle
    }

    public SearchView(Context context0, AttributeSet attributeSet0, int v) {
        super(E6.a.a(context0, attributeSet0, v, 0x7F140453), attributeSet0, v);  // style:Widget.Material3.SearchView
        this.r = new V(this, this);
        this.D = new LinkedHashSet();
        this.G = 16;
        this.W = h.b;
        Context context1 = this.getContext();
        TypedArray typedArray0 = B.m(context1, attributeSet0, d6.a.W, v, 0x7F140453, new int[0]);  // style:Widget.Material3.SearchView
        this.S = typedArray0.getColor(11, 0);
        int v1 = typedArray0.getResourceId(16, -1);
        int v2 = typedArray0.getResourceId(0, -1);
        String s = typedArray0.getString(3);
        String s1 = typedArray0.getString(4);
        String s2 = typedArray0.getString(24);
        boolean z = typedArray0.getBoolean(27, false);
        this.I = typedArray0.getBoolean(8, true);
        this.M = typedArray0.getBoolean(7, true);
        boolean z1 = typedArray0.getBoolean(17, false);
        this.N = typedArray0.getBoolean(9, true);
        this.w = typedArray0.getBoolean(10, true);
        typedArray0.recycle();
        LayoutInflater.from(context1).inflate(0x7F0D054E, this);  // layout:mtrl_search_view
        this.n = true;
        this.a = this.findViewById(0x7F0A08E2);  // id:open_search_view_scrim
        ClippableRoundedCornerLayout clippableRoundedCornerLayout0 = (ClippableRoundedCornerLayout)this.findViewById(0x7F0A08E1);  // id:open_search_view_root
        this.b = clippableRoundedCornerLayout0;
        this.c = this.findViewById(0x7F0A08DA);  // id:open_search_view_background
        View view0 = this.findViewById(0x7F0A08E4);  // id:open_search_view_status_bar_spacer
        this.d = view0;
        this.e = (FrameLayout)this.findViewById(0x7F0A08E0);  // id:open_search_view_header_container
        this.f = (FrameLayout)this.findViewById(0x7F0A08E6);  // id:open_search_view_toolbar_container
        MaterialToolbar materialToolbar0 = (MaterialToolbar)this.findViewById(0x7F0A08E5);  // id:open_search_view_toolbar
        this.g = materialToolbar0;
        this.h = (Toolbar)this.findViewById(0x7F0A08DE);  // id:open_search_view_dummy_toolbar
        this.i = (TextView)this.findViewById(0x7F0A08E3);  // id:open_search_view_search_prefix
        EditText editText0 = (EditText)this.findViewById(0x7F0A08DF);  // id:open_search_view_edit_text
        this.j = editText0;
        ImageButton imageButton0 = (ImageButton)this.findViewById(0x7F0A08DB);  // id:open_search_view_clear_button
        this.k = imageButton0;
        View view1 = this.findViewById(0x7F0A08DD);  // id:open_search_view_divider
        this.l = view1;
        TouchObserverFrameLayout touchObserverFrameLayout0 = (TouchObserverFrameLayout)this.findViewById(0x7F0A08DC);  // id:open_search_view_content_container
        this.m = touchObserverFrameLayout0;
        this.o = new l(this);
        this.B = new ElevationOverlayProvider(context1);
        clippableRoundedCornerLayout0.setOnTouchListener(new e(0));
        this.setUpBackgroundViewElevationOverlay(this.getOverlayElevation());
        this.setUpHeaderLayout(v1);
        this.setSearchPrefixText(s2);
        if(v2 != -1) {
            editText0.setTextAppearance(v2);
        }
        editText0.setText(s);
        editText0.setHint(s1);
        if(z1) {
            materialToolbar0.setNavigationIcon(null);
        }
        else {
            materialToolbar0.setNavigationOnClickListener(new com.google.android.material.search.b(this, 2));
            if(z) {
                DrawerArrowDrawable drawerArrowDrawable0 = new DrawerArrowDrawable(this.getContext());
                int v3 = n.q(this, 0x7F040179);  // attr:colorOnSurface
                Paint paint0 = drawerArrowDrawable0.a;
                if(v3 != paint0.getColor()) {
                    paint0.setColor(v3);
                    drawerArrowDrawable0.invalidateSelf();
                }
                materialToolbar0.setNavigationIcon(drawerArrowDrawable0);
            }
        }
        imageButton0.setOnClickListener(new com.google.android.material.search.b(this, 0));
        editText0.addTextChangedListener(new C(this, 1));
        touchObserverFrameLayout0.setOnTouchListener(new f(this, 0));
        B.f(materialToolbar0, new d(this));
        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = (ViewGroup.MarginLayoutParams)view1.getLayoutParams();
        M.n(view1, new P0(viewGroup$MarginLayoutParams0, viewGroup$MarginLayoutParams0.leftMargin, viewGroup$MarginLayoutParams0.rightMargin));
        this.setUpStatusBarSpacer(this.getStatusBarHeight());
        M.n(view0, new d(this));
    }

    @Override  // u6.b
    public final void a(b.a a0) {
        if(!this.h() && this.E != null) {
            u6.g g0 = this.o.m;
            SearchBar searchBar0 = this.o.o;
            g0.f = a0;
            float f = a0.b;
            View view0 = g0.b;
            g0.j = new Rect(view0.getLeft(), view0.getTop(), view0.getRight(), view0.getBottom());
            if(searchBar0 != null) {
                g0.k = B.b(view0, searchBar0);
            }
            g0.i = f;
        }
    }

    @Override  // android.view.ViewGroup
    public final void addView(View view0, int v, ViewGroup.LayoutParams viewGroup$LayoutParams0) {
        if(this.n) {
            this.m.addView(view0, v, viewGroup$LayoutParams0);
            return;
        }
        super.addView(view0, v, viewGroup$LayoutParams0);
    }

    @Override  // u6.b
    public final void b() {
        if(!this.h() && this.E != null && Build.VERSION.SDK_INT >= 34) {
            l l0 = this.o;
            u6.g g0 = l0.m;
            SearchBar searchBar0 = l0.o;
            if(g0.a() != null) {
                AnimatorSet animatorSet0 = g0.b(searchBar0);
                View view0 = g0.b;
                if(view0 instanceof ClippableRoundedCornerLayout) {
                    ValueAnimator valueAnimator0 = ValueAnimator.ofFloat(new float[]{((ClippableRoundedCornerLayout)view0).getCornerRadius(), ((float)g0.c())});
                    valueAnimator0.addUpdateListener(new com.google.android.exoplayer2.ui.a(((ClippableRoundedCornerLayout)view0), 8));
                    animatorSet0.playTogether(new Animator[]{valueAnimator0});
                }
                animatorSet0.setDuration(((long)g0.e));
                animatorSet0.start();
                g0.i = 0.0f;
                g0.j = null;
                g0.k = null;
            }
            AnimatorSet animatorSet1 = l0.n;
            if(animatorSet1 != null) {
                animatorSet1.reverse();
            }
            l0.n = null;
        }
    }

    @Override  // u6.b
    public final void c(b.a a0) {
        if(!this.h() && this.E != null && Build.VERSION.SDK_INT >= 34) {
            l l0 = this.o;
            SearchView searchView0 = l0.a;
            float f = a0.c;
            if(f > 0.0f) {
                u6.g g0 = l0.m;
                SearchBar searchBar0 = l0.o;
                float f1 = searchBar0.getCornerSize();
                if(g0.f == null) {
                    Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
                }
                b.a a1 = g0.f;
                g0.f = a0;
                if(a1 != null) {
                    if(searchBar0.getVisibility() != 4) {
                        searchBar0.setVisibility(4);
                    }
                    boolean z = a0.d == 0;
                    float f2 = a0.b;
                    float f3 = g0.g;
                    float f4 = g0.a.getInterpolation(f);
                    View view0 = g0.b;
                    float f5 = (float)view0.getWidth();
                    float f6 = (float)view0.getHeight();
                    if(f5 > 0.0f && f6 > 0.0f) {
                        float f7 = e6.a.a(1.0f, 0.9f, f4);
                        float f8 = f2 - g0.i;
                        view0.setScaleX(f7);
                        view0.setScaleY(f7);
                        view0.setTranslationX(e6.a.a(0.0f, Math.max(0.0f, (f5 - 0.9f * f5) / 2.0f - f3), f4) * ((float)(z ? 1 : -1)));
                        view0.setTranslationY(e6.a.a(0.0f, Math.min(Math.max(0.0f, (f6 - f7 * f6) / 2.0f - f3), g0.h), Math.abs(f8) / f6) * Math.signum(f8));
                        if(view0 instanceof ClippableRoundedCornerLayout) {
                            float f9 = e6.a.a(g0.c(), f1, f4);
                            ((ClippableRoundedCornerLayout)view0).a(((float)((ClippableRoundedCornerLayout)view0).getLeft()), ((float)((ClippableRoundedCornerLayout)view0).getTop()), ((float)((ClippableRoundedCornerLayout)view0).getRight()), ((float)((ClippableRoundedCornerLayout)view0).getBottom()), f9);
                        }
                    }
                }
                AnimatorSet animatorSet0 = l0.n;
                if(animatorSet0 == null) {
                    if(searchView0.g()) {
                        searchView0.f();
                    }
                    if(searchView0.I) {
                        AnimatorSet animatorSet1 = new AnimatorSet();
                        l0.b(animatorSet1);
                        animatorSet1.setDuration(0xFAL);
                        animatorSet1.setInterpolator(t.a(false, e6.a.b));
                        l0.n = animatorSet1;
                        animatorSet1.start();
                        l0.n.pause();
                    }
                }
                else {
                    animatorSet0.setCurrentPlayTime(((long)(f * ((float)animatorSet0.getDuration()))));
                }
            }
        }
    }

    @Override  // u6.b
    public final void d() {
        if(!this.h()) {
            l l0 = this.o;
            b.a a0 = l0.m.f;
            l0.m.f = null;
            if(Build.VERSION.SDK_INT >= 34 && this.E != null && a0 != null) {
                long v = l0.j().getTotalDuration();
                AnimatorSet animatorSet0 = l0.m.b(l0.o);
                animatorSet0.setDuration(v);
                animatorSet0.start();
                l0.m.i = 0.0f;
                l0.m.j = null;
                l0.m.k = null;
                if(l0.n != null) {
                    l0.c(false).start();
                    l0.n.resume();
                }
                l0.n = null;
                return;
            }
            if(!this.W.equals(h.b) && !this.W.equals(h.a)) {
                l0.j();
            }
        }
    }

    public static void e(SearchView searchView0, B0 b00) {
        int v = b00.d();
        searchView0.setUpStatusBarSpacer(v);
        if(!searchView0.V) {
            searchView0.setStatusBarSpacerEnabledInternal(v > 0);
        }
    }

    public final void f() {
        c c0 = new c(this, 1);
        this.j.post(c0);
    }

    public final boolean g() {
        return this.G == 0x30;
    }

    private Window getActivityWindow() {
        for(Context context0 = this.getContext(); context0 instanceof ContextWrapper; context0 = ((ContextWrapper)context0).getBaseContext()) {
            if(context0 instanceof Activity) {
                Activity activity0 = (Activity)context0;
                return activity0 == null ? null : activity0.getWindow();
            }
        }
        throw new NullPointerException();
    }

    public u6.g getBackHelper() {
        return this.o.m;
    }

    @Override  // androidx.coordinatorlayout.widget.a
    public androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior getBehavior() {
        return new Behavior();
    }

    public h getCurrentTransitionState() {
        return this.W;
    }

    public int getDefaultNavigationIconResource() [...] // Inlined contents

    public EditText getEditText() {
        return this.j;
    }

    public CharSequence getHint() {
        return this.j.getHint();
    }

    private float getOverlayElevation() {
        SearchBar searchBar0 = this.E;
        return searchBar0 == null ? this.getResources().getDimension(0x7F07028B) : searchBar0.getCompatElevation();  // dimen:m3_searchview_elevation
    }

    public TextView getSearchPrefix() {
        return this.i;
    }

    public CharSequence getSearchPrefixText() {
        return this.i.getText();
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public int getSoftInputMode() {
        return this.G;
    }

    private int getStatusBarHeight() {
        int v = this.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return v <= 0 ? 0 : this.getResources().getDimensionPixelSize(v);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public Editable getText() {
        return this.j.getText();
    }

    public Toolbar getToolbar() {
        return this.g;
    }

    // 去混淆评级： 低(20)
    public final boolean h() {
        return this.W.equals(h.b) || this.W.equals(h.a);
    }

    public final void i() {
        if(this.N) {
            c c0 = new c(this, 0);
            this.j.postDelayed(c0, 100L);
        }
    }

    public final void j(h h0, boolean z) {
        if(this.W.equals(h0)) {
            return;
        }
        if(z) {
            if(h0 == h.d) {
                this.setModalForAccessibility(true);
            }
            else if(h0 == h.b) {
                this.setModalForAccessibility(false);
            }
        }
        this.W = h0;
        Iterator iterator0 = new LinkedHashSet(this.D).iterator();
        if(iterator0.hasNext()) {
            throw H0.b.b(iterator0);
        }
        this.m(h0);
    }

    public final void k() {
        if(!this.W.equals(h.d)) {
            h h0 = h.c;
            if(!this.W.equals(h0)) {
                l l0 = this.o;
                SearchView searchView0 = l0.a;
                ClippableRoundedCornerLayout clippableRoundedCornerLayout0 = l0.c;
                if(l0.o != null) {
                    EditText editText0 = l0.i;
                    if(searchView0.g()) {
                        searchView0.i();
                    }
                    searchView0.setTransitionState(h0);
                    Toolbar toolbar0 = l0.g;
                    Menu menu0 = toolbar0.getMenu();
                    if(menu0 != null) {
                        menu0.clear();
                    }
                    if(l0.o.getMenuResId() == -1 || !searchView0.M) {
                        toolbar0.setVisibility(8);
                    }
                    else {
                        toolbar0.m(l0.o.getMenuResId());
                        ActionMenuView actionMenuView0 = B.h(toolbar0);
                        if(actionMenuView0 != null) {
                            for(int v = 0; v < actionMenuView0.getChildCount(); ++v) {
                                View view0 = actionMenuView0.getChildAt(v);
                                view0.setClickable(false);
                                view0.setFocusable(false);
                                view0.setFocusableInTouchMode(false);
                            }
                        }
                        toolbar0.setVisibility(0);
                    }
                    editText0.setText(l0.o.getText());
                    editText0.setSelection(editText0.getText().length());
                    clippableRoundedCornerLayout0.setVisibility(4);
                    clippableRoundedCornerLayout0.post(new j(l0, 0));
                    return;
                }
                if(searchView0.g()) {
                    searchView0.postDelayed(new c(searchView0, 3), 150L);
                }
                clippableRoundedCornerLayout0.setVisibility(4);
                clippableRoundedCornerLayout0.post(new j(l0, 1));
            }
        }
    }

    public final void l(ViewGroup viewGroup0, boolean z) {
        for(int v = 0; v < viewGroup0.getChildCount(); ++v) {
            View view0 = viewGroup0.getChildAt(v);
            if(view0 != this) {
                if(view0.findViewById(this.b.getId()) != null) {
                    this.l(((ViewGroup)view0), z);
                }
                else if(z) {
                    this.b0.put(view0, view0.getImportantForAccessibility());
                    view0.setImportantForAccessibility(4);
                }
                else if(this.b0 != null && this.b0.containsKey(view0)) {
                    view0.setImportantForAccessibility(((int)(((Integer)this.b0.get(view0)))));
                }
            }
        }
    }

    public final void m(h h0) {
        if(this.E != null && this.w) {
            boolean z = h0.equals(h.d);
            V v0 = this.r;
            if(z) {
                v0.z(false);
                return;
            }
            if(h0.equals(h.b)) {
                v0.A();
            }
        }
    }

    public final void n() {
        ImageButton imageButton0 = B.j(this.g);
        if(imageButton0 != null) {
            int v = this.b.getVisibility() == 0 ? 1 : 0;
            Drawable drawable0 = w.V(imageButton0.getDrawable());
            if(drawable0 instanceof DrawerArrowDrawable && ((DrawerArrowDrawable)drawable0).i != ((float)v)) {
                ((DrawerArrowDrawable)drawable0).i = (float)v;
                ((DrawerArrowDrawable)drawable0).invalidateSelf();
            }
            if(drawable0 instanceof com.google.android.material.internal.e) {
                ((com.google.android.material.internal.e)drawable0).a(((float)v));
            }
        }
    }

    @Override  // android.view.ViewGroup
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        d5.n.B(this);
    }

    @Override  // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        Window window0 = this.getActivityWindow();
        if(window0 != null) {
            this.G = window0.getAttributes().softInputMode;
        }
    }

    @Override  // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable0) {
        if(!(parcelable0 instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable0);
            return;
        }
        super.onRestoreInstanceState(((SavedState)parcelable0).a);
        this.setText(((SavedState)parcelable0).c);
        this.setVisible(((SavedState)parcelable0).d == 0);
    }

    @Override  // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelable0 = new SavedState(super.onSaveInstanceState());  // 初始化器: Landroidx/customview/view/AbsSavedState;-><init>(Landroid/os/Parcelable;)V
        Editable editable0 = this.getText();
        parcelable0.c = editable0 == null ? null : editable0.toString();
        parcelable0.d = this.b.getVisibility();
        return parcelable0;
    }

    public void setAnimatedNavigationIcon(boolean z) {
        this.I = z;
    }

    public void setAutoShowKeyboard(boolean z) {
        this.N = z;
    }

    @Override  // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        this.setUpBackgroundViewElevationOverlay(f);
    }

    public void setHint(int v) {
        this.j.setHint(v);
    }

    public void setHint(CharSequence charSequence0) {
        this.j.setHint(charSequence0);
    }

    public void setMenuItemsAnimated(boolean z) {
        this.M = z;
    }

    public void setModalForAccessibility(boolean z) {
        ViewGroup viewGroup0 = (ViewGroup)this.getRootView();
        if(z) {
            this.b0 = new HashMap(viewGroup0.getChildCount());
        }
        this.l(viewGroup0, z);
        if(!z) {
            this.b0 = null;
        }
    }

    public void setOnMenuItemClickListener(g1 g10) {
        this.g.setOnMenuItemClickListener(g10);
    }

    public void setSearchPrefixText(CharSequence charSequence0) {
        this.i.setText(charSequence0);
        int v = TextUtils.isEmpty(charSequence0) ? 8 : 0;
        this.i.setVisibility(v);
    }

    public void setStatusBarSpacerEnabled(boolean z) {
        this.V = true;
        this.setStatusBarSpacerEnabledInternal(z);
    }

    private void setStatusBarSpacerEnabledInternal(boolean z) {
        this.d.setVisibility((z ? 0 : 8));
    }

    public void setText(int v) {
        this.j.setText(v);
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public void setText(CharSequence charSequence0) {
        this.j.setText(charSequence0);
    }

    public void setToolbarTouchscreenBlocksFocus(boolean z) {
        this.g.setTouchscreenBlocksFocus(z);
    }

    public void setTransitionState(h h0) {
        this.j(h0, true);
    }

    private void setUpBackgroundViewElevationOverlay(float f) {
        ElevationOverlayProvider elevationOverlayProvider0 = this.B;
        if(elevationOverlayProvider0 != null) {
            View view0 = this.c;
            if(view0 != null) {
                view0.setBackgroundColor(elevationOverlayProvider0.a(f, this.S));
            }
        }
    }

    private void setUpHeaderLayout(int v) {
        if(v != -1) {
            View view0 = LayoutInflater.from(this.getContext()).inflate(v, this.e, false);
            this.e.addView(view0);
            this.e.setVisibility(0);
        }
    }

    private void setUpStatusBarSpacer(int v) {
        View view0 = this.d;
        if(view0.getLayoutParams().height != v) {
            view0.getLayoutParams().height = v;
            view0.requestLayout();
        }
    }

    public void setUseWindowInsetsController(boolean z) {
        this.T = z;
    }

    public void setVisible(boolean z) {
        boolean z1 = true;
        boolean z2 = this.b.getVisibility() == 0;
        this.b.setVisibility((z ? 0 : 8));
        this.n();
        h h0 = z ? h.d : h.b;
        if(z2 == z) {
            z1 = false;
        }
        this.j(h0, z1);
    }

    public void setupWithSearchBar(SearchBar searchBar0) {
        this.E = searchBar0;
        this.o.o = searchBar0;
        if(searchBar0 != null) {
            searchBar0.setOnClickListener(new com.google.android.material.search.b(this, 1));
            if(Build.VERSION.SDK_INT >= 34) {
                try {
                    searchBar0.setHandwritingDelegatorCallback(new c(this, 2));
                    m.v(this.j);
                }
                catch(LinkageError unused_ex) {
                }
            }
        }
        MaterialToolbar materialToolbar0 = this.g;
        if(materialToolbar0 != null && !(w.V(materialToolbar0.getNavigationIcon()) instanceof DrawerArrowDrawable)) {
            if(this.E == null) {
                materialToolbar0.setNavigationIcon(0x7F0803B0);  // drawable:ic_arrow_back_black_24
            }
            else {
                Drawable drawable0 = d5.w.B(this.getContext(), 0x7F0803B0).mutate();  // drawable:ic_arrow_back_black_24
                if(materialToolbar0.getNavigationIconTint() != null) {
                    drawable0.setTint(((int)materialToolbar0.getNavigationIconTint()));
                }
                materialToolbar0.setNavigationIcon(new com.google.android.material.internal.e(this.E.getNavigationIcon(), drawable0));
                this.n();
            }
        }
        this.setUpBackgroundViewElevationOverlay(this.getOverlayElevation());
        this.m(this.getCurrentTransitionState());
    }
}

