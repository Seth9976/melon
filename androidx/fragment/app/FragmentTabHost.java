package androidx.fragment.app;

import U4.x;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View.BaseSavedState;
import android.view.View;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost;
import androidx.appcompat.app.o;
import java.util.ArrayList;

@Deprecated
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {
    static class DummyTabFactory implements TabHost.TabContentFactory {
        public final Context a;

        public DummyTabFactory(Context context0) {
            this.a = context0;
        }

        @Override  // android.widget.TabHost$TabContentFactory
        public final View createTabContent(String s) {
            View view0 = new View(this.a);
            view0.setMinimumWidth(0);
            view0.setMinimumHeight(0);
            return view0;
        }
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator CREATOR;
        public String a;

        static {
            SavedState.CREATOR = new w0();  // 初始化器: Ljava/lang/Object;-><init>()V
        }

        @Override
        public final String toString() {
            StringBuilder stringBuilder0 = new StringBuilder("FragmentTabHost.SavedState{");
            stringBuilder0.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder0.append(" curTab=");
            return x.m(stringBuilder0, this.a, "}");
        }

        @Override  // android.view.View$BaseSavedState
        public final void writeToParcel(Parcel parcel0, int v) {
            super.writeToParcel(parcel0, v);
            parcel0.writeString(this.a);
        }
    }

    public final ArrayList a;
    public TabHost.OnTabChangeListener b;
    public boolean c;

    @Deprecated
    public FragmentTabHost(Context context0) {
        super(context0, null);
        this.a = new ArrayList();
        TypedArray typedArray0 = context0.obtainStyledAttributes(null, new int[]{0x10100F3}, 0, 0);
        typedArray0.getResourceId(0, 0);
        typedArray0.recycle();
        super.setOnTabChangedListener(this);
    }

    @Deprecated
    public FragmentTabHost(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        this.a = new ArrayList();
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, new int[]{0x10100F3}, 0, 0);
        typedArray0.getResourceId(0, 0);
        typedArray0.recycle();
        super.setOnTabChangedListener(this);
    }

    @Override  // android.view.ViewGroup
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.getCurrentTabTag();
        ArrayList arrayList0 = this.a;
        if(arrayList0.size() > 0) {
            throw o.g(0, arrayList0);
        }
        this.c = true;
        if(arrayList0.size() > 0) {
            throw o.g(0, arrayList0);
        }
    }

    @Override  // android.view.ViewGroup
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.c = false;
    }

    @Override  // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable0) {
        if(!(parcelable0 instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable0);
            return;
        }
        super.onRestoreInstanceState(((SavedState)parcelable0).getSuperState());
        this.setCurrentTabByTag(((SavedState)parcelable0).a);
    }

    @Override  // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelable0 = new SavedState(super.onSaveInstanceState());  // 初始化器: Landroid/view/View$BaseSavedState;-><init>(Landroid/os/Parcelable;)V
        parcelable0.a = this.getCurrentTabTag();
        return parcelable0;
    }

    @Override  // android.widget.TabHost$OnTabChangeListener
    public final void onTabChanged(String s) {
        if(this.c) {
            ArrayList arrayList0 = this.a;
            if(arrayList0.size() > 0) {
                throw o.g(0, arrayList0);
            }
        }
        TabHost.OnTabChangeListener tabHost$OnTabChangeListener0 = this.b;
        if(tabHost$OnTabChangeListener0 != null) {
            tabHost$OnTabChangeListener0.onTabChanged(s);
        }
    }

    @Override  // android.widget.TabHost
    @Deprecated
    public void setOnTabChangedListener(TabHost.OnTabChangeListener tabHost$OnTabChangeListener0) {
        this.b = tabHost$OnTabChangeListener0;
    }

    @Override  // android.widget.TabHost
    public final void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }
}

