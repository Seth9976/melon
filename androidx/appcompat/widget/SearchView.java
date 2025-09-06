package androidx.appcompat.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent.DispatcherState;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import androidx.appcompat.app.o;
import androidx.customview.view.AbsSavedState;
import androidx.media3.session.legacy.V;
import c2.W;
import d5.m;
import h2.a;
import j.c;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView extends LinearLayoutCompat implements c {
    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator CREATOR;
        public boolean c;

        static {
            SavedState.CREATOR = new U0();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        public SavedState(Parcel parcel0, ClassLoader classLoader0) {
            super(parcel0, classLoader0);
            this.c = ((Boolean)parcel0.readValue(null)).booleanValue();
        }

        @Override
        public final String toString() {
            StringBuilder stringBuilder0 = new StringBuilder("SearchView.SavedState{");
            stringBuilder0.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder0.append(" isIconified=");
            return o.s(stringBuilder0, this.c, "}");
        }

        @Override  // androidx.customview.view.AbsSavedState
        public final void writeToParcel(Parcel parcel0, int v) {
            super.writeToParcel(parcel0, v);
            parcel0.writeValue(Boolean.valueOf(this.c));
        }
    }

    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {
        public int e;
        public SearchView f;
        public boolean g;
        public final V0 h;

        public SearchAutoComplete(Context context0) {
            this(context0, null);
        }

        public SearchAutoComplete(Context context0, AttributeSet attributeSet0) {
            this(context0, attributeSet0, 0x7F040055);  // attr:autoCompleteTextViewStyle
        }

        public SearchAutoComplete(Context context0, AttributeSet attributeSet0, int v) {
            super(context0, attributeSet0, v);
            this.h = new V0(this);
            this.e = this.getThreshold();
        }

        public final void a() {
            if(Build.VERSION.SDK_INT >= 29) {
                Q0.b(this, 1);
                if(this.enoughToFilter()) {
                    this.showDropDown();
                }
            }
            else {
                SearchView.C0.getClass();
                V.s();
                Method method0 = (Method)SearchView.C0.c;
                if(method0 != null) {
                    try {
                        method0.invoke(this, Boolean.TRUE);
                    }
                    catch(Exception unused_ex) {
                    }
                }
            }
        }

        @Override  // android.widget.AutoCompleteTextView
        public final boolean enoughToFilter() {
            return this.e <= 0 || super.enoughToFilter();
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration0 = this.getResources().getConfiguration();
            int v = configuration0.screenWidthDp;
            int v1 = configuration0.screenHeightDp;
            if(v >= 960 && v1 >= 720 && configuration0.orientation == 2) {
                return 0x100;
            }
            return v >= 600 || v >= 640 && v1 >= 480 ? 0xC0 : 0xA0;
        }

        @Override  // androidx.appcompat.widget.AppCompatAutoCompleteTextView
        public final InputConnection onCreateInputConnection(EditorInfo editorInfo0) {
            InputConnection inputConnection0 = super.onCreateInputConnection(editorInfo0);
            if(this.g) {
                this.removeCallbacks(this.h);
                this.post(this.h);
            }
            return inputConnection0;
        }

        @Override  // android.view.View
        public final void onFinishInflate() {
            super.onFinishInflate();
            DisplayMetrics displayMetrics0 = this.getResources().getDisplayMetrics();
            this.setMinWidth(((int)TypedValue.applyDimension(1, ((float)this.getSearchViewTextMinWidthDp()), displayMetrics0)));
        }

        @Override  // android.widget.AutoCompleteTextView
        public final void onFocusChanged(boolean z, int v, Rect rect0) {
            super.onFocusChanged(z, v, rect0);
            SearchView searchView0 = this.f;
            searchView0.w(searchView0.m0);
            searchView0.post(searchView0.z0);
            if(searchView0.r.hasFocus()) {
                searchView0.l();
            }
        }

        @Override  // android.widget.AutoCompleteTextView
        public final boolean onKeyPreIme(int v, KeyEvent keyEvent0) {
            if(v == 4) {
                if(keyEvent0.getAction() == 0 && keyEvent0.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyEvent$DispatcherState0 = this.getKeyDispatcherState();
                    if(keyEvent$DispatcherState0 != null) {
                        keyEvent$DispatcherState0.startTracking(keyEvent0, this);
                    }
                    return true;
                }
                if(keyEvent0.getAction() == 1) {
                    KeyEvent.DispatcherState keyEvent$DispatcherState1 = this.getKeyDispatcherState();
                    if(keyEvent$DispatcherState1 != null) {
                        keyEvent$DispatcherState1.handleUpEvent(keyEvent0);
                    }
                    if(keyEvent0.isTracking() && !keyEvent0.isCanceled()) {
                        this.f.clearFocus();
                        this.setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(v, keyEvent0);
        }

        @Override  // android.widget.AutoCompleteTextView
        public final void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if(z && this.f.hasFocus() && this.getVisibility() == 0) {
                this.g = true;
                if(this.getContext().getResources().getConfiguration().orientation == 2) {
                    this.a();
                }
            }
        }

        @Override  // android.widget.AutoCompleteTextView
        public final void performCompletion() {
        }

        @Override  // android.widget.AutoCompleteTextView
        public final void replaceText(CharSequence charSequence0) {
        }

        public void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager0 = (InputMethodManager)this.getContext().getSystemService("input_method");
            V0 v00 = this.h;
            if(!z) {
                this.g = false;
                this.removeCallbacks(v00);
                inputMethodManager0.hideSoftInputFromWindow(this.getWindowToken(), 0);
                return;
            }
            if(inputMethodManager0.isActive(this)) {
                this.g = false;
                this.removeCallbacks(v00);
                inputMethodManager0.showSoftInput(this, 0);
                return;
            }
            this.g = true;
        }

        public void setSearchView(SearchView searchView0) {
            this.f = searchView0;
        }

        @Override  // android.widget.AutoCompleteTextView
        public void setThreshold(int v) {
            super.setThreshold(v);
            this.e = v;
        }
    }

    public final K0 A0;
    public final View B;
    public final WeakHashMap B0;
    public static final V C0;
    public final View D;
    public final ImageView E;
    public final ImageView G;
    public final ImageView I;
    public final ImageView M;
    public final View N;
    public W0 S;
    public final Rect T;
    public final Rect V;
    public final int[] W;
    public final int[] b0;
    public final ImageView c0;
    public final Drawable d0;
    public final int e0;
    public final int f0;
    public final Intent g0;
    public final Intent h0;
    public final CharSequence i0;
    public View.OnFocusChangeListener j0;
    public View.OnClickListener k0;
    public boolean l0;
    public boolean m0;
    public a n0;
    public boolean o0;
    public CharSequence p0;
    public boolean q0;
    public final SearchAutoComplete r;
    public boolean r0;
    public int s0;
    public boolean t0;
    public CharSequence u0;
    public boolean v0;
    public final View w;
    public int w0;
    public SearchableInfo x0;
    public Bundle y0;
    public final K0 z0;

    static {
        V v0 = null;
        if(Build.VERSION.SDK_INT < 29) {
            Class class0 = AutoCompleteTextView.class;
            V v1 = new V();  // 初始化器: Ljava/lang/Object;-><init>()V
            v1.a = null;
            v1.b = null;
            v1.c = null;
            V.s();
            try {
                Method method0 = class0.getDeclaredMethod("doBeforeTextChanged", null);
                v1.a = method0;
                method0.setAccessible(true);
            }
            catch(NoSuchMethodException unused_ex) {
            }
            try {
                Method method1 = class0.getDeclaredMethod("doAfterTextChanged", null);
                v1.b = method1;
                method1.setAccessible(true);
            }
            catch(NoSuchMethodException unused_ex) {
            }
            try {
                Method method2 = class0.getMethod("ensureImeVisible", Boolean.TYPE);
                v1.c = method2;
                method2.setAccessible(true);
            }
            catch(NoSuchMethodException unused_ex) {
            }
            v0 = v1;
        }
        SearchView.C0 = v0;
    }

    public SearchView(Context context0) {
        this(context0, null);
    }

    public SearchView(Context context0, AttributeSet attributeSet0) {
        this(context0, attributeSet0, 0x7F040532);  // attr:searchViewStyle
    }

    public SearchView(Context context0, AttributeSet attributeSet0, int v) {
        super(context0, attributeSet0, v);
        this.T = new Rect();
        this.V = new Rect();
        this.W = new int[2];
        this.b0 = new int[2];
        this.z0 = new K0(this, 0);
        this.A0 = new K0(this, 1);
        this.B0 = new WeakHashMap();
        N0 n00 = new N0(this);
        O0 o00 = new O0(this);
        P0 p00 = new P0(this);
        I i0 = new I(this, 1);
        s0 s00 = new s0(this, 1);
        J0 j00 = new J0(this);
        m m0 = m.r(context0, attributeSet0, g.a.w, v);
        W.n(this, context0, g.a.w, attributeSet0, ((TypedArray)m0.c), v);
        LayoutInflater layoutInflater0 = LayoutInflater.from(context0);
        TypedArray typedArray0 = (TypedArray)m0.c;
        layoutInflater0.inflate(typedArray0.getResourceId(19, 0x7F0D0019), this, true);  // layout:abc_search_view
        SearchAutoComplete searchView$SearchAutoComplete0 = (SearchAutoComplete)this.findViewById(0x7F0A0A49);  // id:search_src_text
        this.r = searchView$SearchAutoComplete0;
        searchView$SearchAutoComplete0.setSearchView(this);
        this.w = this.findViewById(0x7F0A0A3D);  // id:search_edit_frame
        View view0 = this.findViewById(0x7F0A0A46);  // id:search_plate
        this.B = view0;
        View view1 = this.findViewById(0x7F0A0B01);  // id:submit_area
        this.D = view1;
        ImageView imageView0 = (ImageView)this.findViewById(0x7F0A0A3A);  // id:search_button
        this.E = imageView0;
        ImageView imageView1 = (ImageView)this.findViewById(0x7F0A0A3F);  // id:search_go_btn
        this.G = imageView1;
        ImageView imageView2 = (ImageView)this.findViewById(0x7F0A0A3B);  // id:search_close_btn
        this.I = imageView2;
        ImageView imageView3 = (ImageView)this.findViewById(0x7F0A0A4A);  // id:search_voice_btn
        this.M = imageView3;
        ImageView imageView4 = (ImageView)this.findViewById(0x7F0A0A43);  // id:search_mag_icon
        this.c0 = imageView4;
        view0.setBackground(m0.k(20));
        view1.setBackground(m0.k(25));
        imageView0.setImageDrawable(m0.k(23));
        imageView1.setImageDrawable(m0.k(15));
        imageView2.setImageDrawable(m0.k(12));
        imageView3.setImageDrawable(m0.k(28));
        imageView4.setImageDrawable(m0.k(23));
        this.d0 = m0.k(22);
        l1.a(imageView0, "Search");
        this.e0 = typedArray0.getResourceId(26, 0x7F0D0018);  // layout:abc_search_dropdown_item_icons_2line
        this.f0 = typedArray0.getResourceId(13, 0);
        imageView0.setOnClickListener(n00);
        imageView2.setOnClickListener(n00);
        imageView1.setOnClickListener(n00);
        imageView3.setOnClickListener(n00);
        searchView$SearchAutoComplete0.setOnClickListener(n00);
        searchView$SearchAutoComplete0.addTextChangedListener(j00);
        searchView$SearchAutoComplete0.setOnEditorActionListener(p00);
        searchView$SearchAutoComplete0.setOnItemClickListener(i0);
        searchView$SearchAutoComplete0.setOnItemSelectedListener(s00);
        searchView$SearchAutoComplete0.setOnKeyListener(o00);
        searchView$SearchAutoComplete0.setOnFocusChangeListener(new L0(this));
        this.setIconifiedByDefault(typedArray0.getBoolean(18, true));
        int v1 = typedArray0.getDimensionPixelSize(2, -1);
        if(v1 != -1) {
            this.setMaxWidth(v1);
        }
        this.i0 = typedArray0.getText(14);
        this.p0 = typedArray0.getText(21);
        int v2 = typedArray0.getInt(6, -1);
        if(v2 != -1) {
            this.setImeOptions(v2);
        }
        int v3 = typedArray0.getInt(5, -1);
        if(v3 != -1) {
            this.setInputType(v3);
        }
        this.setFocusable(typedArray0.getBoolean(1, true));
        m0.t();
        Intent intent0 = new Intent("android.speech.action.WEB_SEARCH");
        this.g0 = intent0;
        intent0.addFlags(0x10000000);
        intent0.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent1 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.h0 = intent1;
        intent1.addFlags(0x10000000);
        View view2 = this.findViewById(searchView$SearchAutoComplete0.getDropDownAnchor());
        this.N = view2;
        if(view2 != null) {
            view2.addOnLayoutChangeListener(new M0(this));
        }
        this.w(this.l0);
        this.t();
    }

    @Override  // android.view.ViewGroup
    public final void clearFocus() {
        this.r0 = true;
        super.clearFocus();
        this.r.clearFocus();
        this.r.setImeVisibility(false);
        this.r0 = false;
    }

    public int getImeOptions() {
        return this.r.getImeOptions();
    }

    public int getInputType() {
        return this.r.getInputType();
    }

    public int getMaxWidth() {
        return this.s0;
    }

    private int getPreferredHeight() {
        return this.getContext().getResources().getDimensionPixelSize(0x7F070036);  // dimen:abc_search_view_preferred_height
    }

    private int getPreferredWidth() {
        return this.getContext().getResources().getDimensionPixelSize(0x7F070037);  // dimen:abc_search_view_preferred_width
    }

    public CharSequence getQuery() {
        return this.r.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence0 = this.p0;
        if(charSequence0 != null) {
            return charSequence0;
        }
        return this.x0 == null || this.x0.getHintId() == 0 ? this.i0 : this.getContext().getText(this.x0.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return this.f0;
    }

    public int getSuggestionRowLayout() {
        return this.e0;
    }

    public a getSuggestionsAdapter() {
        return this.n0;
    }

    public final Intent j(Uri uri0, String s, String s1, String s2) {
        Intent intent0 = new Intent(s);
        intent0.addFlags(0x10000000);
        if(uri0 != null) {
            intent0.setData(uri0);
        }
        intent0.putExtra("user_query", this.u0);
        if(s2 != null) {
            intent0.putExtra("query", s2);
        }
        if(s1 != null) {
            intent0.putExtra("intent_extra_data_key", s1);
        }
        Bundle bundle0 = this.y0;
        if(bundle0 != null) {
            intent0.putExtra("app_data", bundle0);
        }
        intent0.setComponent(this.x0.getSearchActivity());
        return intent0;
    }

    public final Intent k(Intent intent0, SearchableInfo searchableInfo0) {
        ComponentName componentName0 = searchableInfo0.getSearchActivity();
        Intent intent1 = new Intent("android.intent.action.SEARCH");
        intent1.setComponent(componentName0);
        PendingIntent pendingIntent0 = PendingIntent.getActivity(this.getContext(), 0, intent1, 0x42000000);
        Bundle bundle0 = new Bundle();
        Bundle bundle1 = this.y0;
        if(bundle1 != null) {
            bundle0.putParcelable("app_data", bundle1);
        }
        Intent intent2 = new Intent(intent0);
        Resources resources0 = this.getResources();
        String s = searchableInfo0.getVoiceLanguageModeId() == 0 ? "free_form" : resources0.getString(searchableInfo0.getVoiceLanguageModeId());
        String s1 = null;
        String s2 = searchableInfo0.getVoicePromptTextId() == 0 ? null : resources0.getString(searchableInfo0.getVoicePromptTextId());
        String s3 = searchableInfo0.getVoiceLanguageId() == 0 ? null : resources0.getString(searchableInfo0.getVoiceLanguageId());
        int v = searchableInfo0.getVoiceMaxResults() == 0 ? 1 : searchableInfo0.getVoiceMaxResults();
        intent2.putExtra("android.speech.extra.LANGUAGE_MODEL", s);
        intent2.putExtra("android.speech.extra.PROMPT", s2);
        intent2.putExtra("android.speech.extra.LANGUAGE", s3);
        intent2.putExtra("android.speech.extra.MAX_RESULTS", v);
        if(componentName0 != null) {
            s1 = componentName0.flattenToShortString();
        }
        intent2.putExtra("calling_package", s1);
        intent2.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", pendingIntent0);
        intent2.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle0);
        return intent2;
    }

    public final void l() {
        SearchAutoComplete searchView$SearchAutoComplete0 = this.r;
        if(Build.VERSION.SDK_INT >= 29) {
            Q0.a(searchView$SearchAutoComplete0);
            return;
        }
        V v0 = SearchView.C0;
        v0.getClass();
        V.s();
        Method method0 = (Method)v0.a;
        if(method0 != null) {
            try {
                method0.invoke(searchView$SearchAutoComplete0, null);
            }
            catch(Exception unused_ex) {
            }
        }
        v0.getClass();
        V.s();
        Method method1 = (Method)v0.b;
        if(method1 != null) {
            try {
                method1.invoke(searchView$SearchAutoComplete0, null);
            }
            catch(Exception unused_ex) {
            }
        }
    }

    public final void m() {
        SearchAutoComplete searchView$SearchAutoComplete0 = this.r;
        if(TextUtils.isEmpty(searchView$SearchAutoComplete0.getText())) {
            if(this.l0) {
                this.clearFocus();
                this.w(true);
            }
            return;
        }
        searchView$SearchAutoComplete0.setText("");
        searchView$SearchAutoComplete0.requestFocus();
        searchView$SearchAutoComplete0.setImeVisibility(true);
    }

    public final void n(int v) {
        int v1;
        Intent intent0;
        Cursor cursor0 = this.n0.c;
        if(cursor0 != null && cursor0.moveToPosition(v)) {
            try {
                intent0 = null;
                String s = Y0.h(cursor0, cursor0.getColumnIndex("suggest_intent_action"));
                if(s == null) {
                    s = this.x0.getSuggestIntentAction();
                }
                if(s == null) {
                    s = "android.intent.action.SEARCH";
                }
                String s1 = Y0.h(cursor0, cursor0.getColumnIndex("suggest_intent_data"));
                if(s1 == null) {
                    s1 = this.x0.getSuggestIntentData();
                }
                if(s1 != null) {
                    String s2 = Y0.h(cursor0, cursor0.getColumnIndex("suggest_intent_data_id"));
                    if(s2 != null) {
                        s1 = s1 + "/" + Uri.encode(s2);
                    }
                }
                Uri uri0 = s1 == null ? null : Uri.parse(s1);
                String s3 = Y0.h(cursor0, cursor0.getColumnIndex("suggest_intent_query"));
                intent0 = this.j(uri0, s, Y0.h(cursor0, cursor0.getColumnIndex("suggest_intent_extra_data")), s3);
                goto label_23;
            }
            catch(RuntimeException runtimeException0) {
            }
            try {
                v1 = -1;
                v1 = cursor0.getPosition();
            }
            catch(RuntimeException unused_ex) {
            }
            Log.w("SearchView", "Search suggestions cursor at row " + v1 + " returned exception.", runtimeException0);
        label_23:
            if(intent0 != null) {
                try {
                    this.getContext().startActivity(intent0);
                }
                catch(RuntimeException runtimeException1) {
                    Log.e("SearchView", "Failed launch activity: " + intent0, runtimeException1);
                }
            }
        }
        this.r.setImeVisibility(false);
        this.r.dismissDropDown();
    }

    public final void o(int v) {
        Editable editable0 = this.r.getText();
        Cursor cursor0 = this.n0.c;
        if(cursor0 != null) {
            if(cursor0.moveToPosition(v)) {
                String s = this.n0.c(cursor0);
                if(s != null) {
                    this.setQuery(s);
                    return;
                }
                this.setQuery(editable0);
                return;
            }
            this.setQuery(editable0);
        }
    }

    @Override  // j.c
    public final void onActionViewCollapsed() {
        this.r.setText("");
        int v = this.r.length();
        this.r.setSelection(v);
        this.u0 = "";
        this.clearFocus();
        this.w(true);
        this.r.setImeOptions(this.w0);
        this.v0 = false;
    }

    @Override  // j.c
    public final void onActionViewExpanded() {
        if(this.v0) {
            return;
        }
        this.v0 = true;
        int v = this.r.getImeOptions();
        this.w0 = v;
        this.r.setImeOptions(v | 0x2000000);
        this.r.setText("");
        this.setIconified(false);
    }

    @Override  // android.view.ViewGroup
    public final void onDetachedFromWindow() {
        this.removeCallbacks(this.z0);
        this.post(this.A0);
        super.onDetachedFromWindow();
    }

    @Override  // androidx.appcompat.widget.LinearLayoutCompat
    public final void onLayout(boolean z, int v, int v1, int v2, int v3) {
        super.onLayout(z, v, v1, v2, v3);
        if(z) {
            SearchAutoComplete searchView$SearchAutoComplete0 = this.r;
            searchView$SearchAutoComplete0.getLocationInWindow(this.W);
            this.getLocationInWindow(this.b0);
            int v4 = this.W[1] - this.b0[1];
            int v5 = this.W[0] - this.b0[0];
            int v6 = searchView$SearchAutoComplete0.getWidth();
            int v7 = searchView$SearchAutoComplete0.getHeight();
            Rect rect0 = this.T;
            rect0.set(v5, v4, v6 + v5, v7 + v4);
            Rect rect1 = this.V;
            rect1.set(rect0.left, 0, rect0.right, v3 - v1);
            W0 w00 = this.S;
            if(w00 == null) {
                W0 w01 = new W0(searchView$SearchAutoComplete0, rect1, rect0);
                this.S = w01;
                this.setTouchDelegate(w01);
                return;
            }
            w00.b.set(rect1);
            w00.d.set(rect1);
            int v8 = -w00.e;
            w00.d.inset(v8, v8);
            w00.c.set(rect0);
        }
    }

    @Override  // androidx.appcompat.widget.LinearLayoutCompat
    public final void onMeasure(int v, int v1) {
        if(this.m0) {
            super.onMeasure(v, v1);
            return;
        }
        int v2 = View.MeasureSpec.getMode(v);
        int v3 = View.MeasureSpec.getSize(v);
        switch(v2) {
            case 0x80000000: {
                int v4 = this.s0;
                v3 = v4 <= 0 ? Math.min(this.getPreferredWidth(), v3) : Math.min(v4, v3);
                break;
            }
            case 0: {
                v3 = this.s0;
                if(v3 <= 0) {
                    v3 = this.getPreferredWidth();
                }
                break;
            }
            case 0x40000000: {
                int v5 = this.s0;
                if(v5 > 0) {
                    v3 = Math.min(v5, v3);
                }
            }
        }
        int v6 = View.MeasureSpec.getMode(v1);
        int v7 = View.MeasureSpec.getSize(v1);
        switch(v6) {
            case 0x80000000: {
                v7 = Math.min(this.getPreferredHeight(), v7);
                break;
            }
            case 0: {
                v7 = this.getPreferredHeight();
            }
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(v3, 0x40000000), View.MeasureSpec.makeMeasureSpec(v7, 0x40000000));
    }

    @Override  // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable0) {
        if(!(parcelable0 instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable0);
            return;
        }
        super.onRestoreInstanceState(((SavedState)parcelable0).a);
        this.w(((SavedState)parcelable0).c);
        this.requestLayout();
    }

    @Override  // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelable0 = new SavedState(super.onSaveInstanceState());  // 初始化器: Landroidx/customview/view/AbsSavedState;-><init>(Landroid/os/Parcelable;)V
        parcelable0.c = this.m0;
        return parcelable0;
    }

    @Override  // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.post(this.z0);
    }

    public final void p(CharSequence charSequence0) {
        this.setQuery(charSequence0);
    }

    public final void q() {
        SearchAutoComplete searchView$SearchAutoComplete0 = this.r;
        Editable editable0 = searchView$SearchAutoComplete0.getText();
        if(editable0 != null && TextUtils.getTrimmedLength(editable0) > 0) {
            if(this.x0 != null) {
                Intent intent0 = this.j(null, "android.intent.action.SEARCH", null, editable0.toString());
                this.getContext().startActivity(intent0);
            }
            searchView$SearchAutoComplete0.setImeVisibility(false);
            searchView$SearchAutoComplete0.dismissDropDown();
        }
    }

    public final void r() {
        boolean z = TextUtils.isEmpty(this.r.getText());
        this.I.setVisibility((!z || this.l0 && !this.v0 ? 0 : 8));
        Drawable drawable0 = this.I.getDrawable();
        if(drawable0 != null) {
            drawable0.setState((z ? ViewGroup.EMPTY_STATE_SET : ViewGroup.ENABLED_STATE_SET));
        }
    }

    @Override  // android.view.ViewGroup
    public final boolean requestFocus(int v, Rect rect0) {
        if(this.r0 || !this.isFocusable()) {
            return false;
        }
        if(!this.m0) {
            boolean z = this.r.requestFocus(v, rect0);
            if(z) {
                this.w(false);
            }
            return z;
        }
        return super.requestFocus(v, rect0);
    }

    public final void s() {
        int[] arr_v = this.r.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable drawable0 = this.B.getBackground();
        if(drawable0 != null) {
            drawable0.setState(arr_v);
        }
        Drawable drawable1 = this.D.getBackground();
        if(drawable1 != null) {
            drawable1.setState(arr_v);
        }
        this.invalidate();
    }

    public void setAppSearchData(Bundle bundle0) {
        this.y0 = bundle0;
    }

    public void setIconified(boolean z) {
        if(z) {
            this.m();
            return;
        }
        this.w(false);
        this.r.requestFocus();
        this.r.setImeVisibility(true);
        View.OnClickListener view$OnClickListener0 = this.k0;
        if(view$OnClickListener0 != null) {
            view$OnClickListener0.onClick(this);
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if(this.l0 == z) {
            return;
        }
        this.l0 = z;
        this.w(z);
        this.t();
    }

    public void setImeOptions(int v) {
        this.r.setImeOptions(v);
    }

    public void setInputType(int v) {
        this.r.setInputType(v);
    }

    public void setMaxWidth(int v) {
        this.s0 = v;
        this.requestLayout();
    }

    public void setOnCloseListener(R0 r00) {
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener view$OnFocusChangeListener0) {
        this.j0 = view$OnFocusChangeListener0;
    }

    public void setOnQueryTextListener(S0 s00) {
    }

    public void setOnSearchClickListener(View.OnClickListener view$OnClickListener0) {
        this.k0 = view$OnClickListener0;
    }

    public void setOnSuggestionListener(T0 t00) {
    }

    private void setQuery(CharSequence charSequence0) {
        this.r.setText(charSequence0);
        int v = TextUtils.isEmpty(charSequence0) ? 0 : charSequence0.length();
        this.r.setSelection(v);
    }

    public void setQueryHint(CharSequence charSequence0) {
        this.p0 = charSequence0;
        this.t();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.q0 = z;
        a a0 = this.n0;
        if(a0 instanceof Y0) {
            ((Y0)a0).r = z ? 2 : 1;
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo0) {
        this.x0 = searchableInfo0;
        Intent intent0 = null;
        boolean z = true;
        SearchAutoComplete searchView$SearchAutoComplete0 = this.r;
        if(searchableInfo0 != null) {
            searchView$SearchAutoComplete0.setThreshold(searchableInfo0.getSuggestThreshold());
            searchView$SearchAutoComplete0.setImeOptions(this.x0.getImeOptions());
            int v = this.x0.getInputType();
            if((v & 15) == 1) {
                v &= 0xFFFEFFFF;
                if(this.x0.getSuggestAuthority() != null) {
                    v |= 0x90000;
                }
            }
            searchView$SearchAutoComplete0.setInputType(v);
            a a0 = this.n0;
            if(a0 != null) {
                a0.b(null);
            }
            if(this.x0.getSuggestAuthority() != null) {
                Y0 y00 = new Y0(this.getContext(), this, this.x0, this.B0);
                this.n0 = y00;
                searchView$SearchAutoComplete0.setAdapter(y00);
                ((Y0)this.n0).r = this.q0 ? 2 : 1;
            }
            this.t();
        }
        if(this.x0 == null || !this.x0.getVoiceSearchEnabled()) {
            z = false;
        }
        else {
            if(this.x0.getVoiceSearchLaunchWebSearch()) {
                intent0 = this.g0;
            }
            else if(this.x0.getVoiceSearchLaunchRecognizer()) {
                intent0 = this.h0;
            }
            if(intent0 == null || this.getContext().getPackageManager().resolveActivity(intent0, 0x10000) == null) {
                z = false;
            }
        }
        this.t0 = z;
        if(z) {
            searchView$SearchAutoComplete0.setPrivateImeOptions("nm");
        }
        this.w(this.m0);
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.o0 = z;
        this.w(this.m0);
    }

    public void setSuggestionsAdapter(a a0) {
        this.n0 = a0;
        this.r.setAdapter(a0);
    }

    public final void t() {
        CharSequence charSequence0 = this.getQueryHint();
        if(charSequence0 == null) {
            charSequence0 = "";
        }
        SearchAutoComplete searchView$SearchAutoComplete0 = this.r;
        if(this.l0) {
            Drawable drawable0 = this.d0;
            if(drawable0 != null) {
                int v = (int)(((double)searchView$SearchAutoComplete0.getTextSize()) * 1.25);
                drawable0.setBounds(0, 0, v, v);
                SpannableStringBuilder spannableStringBuilder0 = new SpannableStringBuilder("   ");
                spannableStringBuilder0.setSpan(new ImageSpan(drawable0), 1, 2, 33);
                spannableStringBuilder0.append(charSequence0);
                charSequence0 = spannableStringBuilder0;
            }
        }
        searchView$SearchAutoComplete0.setHint(charSequence0);
    }

    public final void u() {
        int v = !this.o0 && !this.t0 || this.m0 || this.G.getVisibility() != 0 && this.M.getVisibility() != 0 ? 8 : 0;
        this.D.setVisibility(v);
    }

    // 去混淆评级： 低(23)
    public final void v(boolean z) {
        int v = !this.o0 || this.m0 || !this.hasFocus() || !z && this.t0 ? 8 : 0;
        this.G.setVisibility(v);
    }

    public final void w(boolean z) {
        this.m0 = z;
        int v = 8;
        boolean z1 = TextUtils.isEmpty(this.r.getText());
        this.E.setVisibility((z ? 0 : 8));
        this.v(!z1);
        this.w.setVisibility((z ? 8 : 0));
        int v1 = this.c0.getDrawable() == null || this.l0 ? 8 : 0;
        this.c0.setVisibility(v1);
        this.r();
        if(this.t0 && !this.m0 && z1) {
            this.G.setVisibility(8);
            v = 0;
        }
        this.M.setVisibility(v);
        this.u();
    }
}

