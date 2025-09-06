package com.facebook.appevents.codeless.internal;

import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.util.Log;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u000B\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00C7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u001B\u0010\u0007\u001A\u0004\u0018\u00010\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\b\u0007\u0010\bJ\u001F\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00040\t2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\b\n\u0010\u000BJ\u001F\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\r\u001A\u00020\fH\u0007\u00A2\u0006\u0004\b\u000F\u0010\u0010J\'\u0010\u0013\u001A\u00020\u000E2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\u0011H\u0007\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0005\u001A\u00020\u0004H\u0007\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001B\u001A\u00020\u001A2\u0006\u0010\u0005\u001A\u00020\u0004H\u0003\u00A2\u0006\u0004\b\u001B\u0010\u001CJ\u0019\u0010\u001E\u001A\u00020\u001D2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\b\u001E\u0010\u001FJ\u0019\u0010 \u001A\u00020\u001D2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\b \u0010\u001FJ\u0017\u0010!\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b!\u0010\u0016J\u001B\u0010#\u001A\u0004\u0018\u00010\"2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\b#\u0010$J!\u0010&\u001A\u00020\u000E2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010%\u001A\u0004\u0018\u00010\"H\u0007\u00A2\u0006\u0004\b&\u0010\'J\u001B\u0010)\u001A\u0004\u0018\u00010(2\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\b)\u0010*J%\u0010.\u001A\u0004\u0018\u00010\u00042\b\u0010,\u001A\u0004\u0018\u00010+2\b\u0010-\u001A\u0004\u0018\u00010\u0004H\u0002\u00A2\u0006\u0004\b.\u0010/J\u0017\u00100\u001A\u00020\u001A2\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b0\u0010\u001CJ\u001B\u00101\u001A\u0004\u0018\u00010\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\b1\u00102J\u0017\u00103\u001A\u00020+2\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b3\u00104J\u000F\u00105\u001A\u00020\u000EH\u0002\u00A2\u0006\u0004\b5\u0010\u0003J\u001D\u00108\u001A\b\u0012\u0002\b\u0003\u0018\u0001072\u0006\u00106\u001A\u00020\u001DH\u0002\u00A2\u0006\u0004\b8\u00109J\u001F\u0010:\u001A\u00020\u001A2\u0006\u0010\u0005\u001A\u00020\u00042\b\u0010-\u001A\u0004\u0018\u00010\u0004\u00A2\u0006\u0004\b:\u0010;R\u001C\u0010=\u001A\n <*\u0004\u0018\u00010\u001D0\u001D8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010?\u001A\u00020\u001D8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b?\u0010>R\u0014\u0010@\u001A\u00020\u001D8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b@\u0010>R\u0014\u0010A\u001A\u00020\u001D8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bA\u0010>R\u0014\u0010B\u001A\u00020\u001D8\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bB\u0010>R\u0014\u0010C\u001A\u00020\u00178\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\bC\u0010DR\u001E\u0010F\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040E8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010I\u001A\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bI\u0010J\u00A8\u0006K"}, d2 = {"Lcom/facebook/appevents/codeless/internal/ViewHierarchy;", "", "<init>", "()V", "Landroid/view/View;", "view", "Landroid/view/ViewGroup;", "getParentOfView", "(Landroid/view/View;)Landroid/view/ViewGroup;", "", "getChildrenOfView", "(Landroid/view/View;)Ljava/util/List;", "Lorg/json/JSONObject;", "json", "Lie/H;", "updateBasicInfoOfView", "(Landroid/view/View;Lorg/json/JSONObject;)V", "", "displayDensity", "updateAppearanceOfView", "(Landroid/view/View;Lorg/json/JSONObject;F)V", "getDictionaryOfView", "(Landroid/view/View;)Lorg/json/JSONObject;", "", "getClassTypeBitmask", "(Landroid/view/View;)I", "", "isAdapterViewItem", "(Landroid/view/View;)Z", "", "getTextOfView", "(Landroid/view/View;)Ljava/lang/String;", "getHintOfView", "getDimensionOfView", "Landroid/view/View$OnClickListener;", "getExistingOnClickListener", "(Landroid/view/View;)Landroid/view/View$OnClickListener;", "newListener", "setOnClickListener", "(Landroid/view/View;Landroid/view/View$OnClickListener;)V", "Landroid/view/View$OnTouchListener;", "getExistingOnTouchListener", "(Landroid/view/View;)Landroid/view/View$OnTouchListener;", "", "location", "RCTRootView", "getTouchReactView", "([FLandroid/view/View;)Landroid/view/View;", "isRCTRootView", "findRCTRootView", "(Landroid/view/View;)Landroid/view/View;", "getViewLocationOnScreen", "(Landroid/view/View;)[F", "initTouchTargetHelperMethods", "className", "Ljava/lang/Class;", "getExistingClass", "(Ljava/lang/String;)Ljava/lang/Class;", "isRCTButton", "(Landroid/view/View;Landroid/view/View;)Z", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "CLASS_RCTROOTVIEW", "CLASS_RCTVIEWGROUP", "CLASS_TOUCHTARGETHELPER", "METHOD_FIND_TOUCHTARGET_VIEW", "ICON_MAX_EDGE_LENGTH", "I", "Ljava/lang/ref/WeakReference;", "RCTRootViewReference", "Ljava/lang/ref/WeakReference;", "Ljava/lang/reflect/Method;", "methodFindTouchTargetView", "Ljava/lang/reflect/Method;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class ViewHierarchy {
    @NotNull
    private static final String CLASS_RCTROOTVIEW = "com.facebook.react.ReactRootView";
    @NotNull
    private static final String CLASS_RCTVIEWGROUP = "com.facebook.react.views.view.ReactViewGroup";
    @NotNull
    private static final String CLASS_TOUCHTARGETHELPER = "com.facebook.react.uimanager.TouchTargetHelper";
    private static final int ICON_MAX_EDGE_LENGTH = 44;
    @NotNull
    public static final ViewHierarchy INSTANCE = null;
    @NotNull
    private static final String METHOD_FIND_TOUCHTARGET_VIEW = "findTouchTargetView";
    @NotNull
    private static WeakReference RCTRootViewReference;
    private static final String TAG;
    @Nullable
    private static Method methodFindTouchTargetView;

    static {
        ViewHierarchy.INSTANCE = new ViewHierarchy();
        ViewHierarchy.TAG = ViewHierarchy.class.getCanonicalName();
        ViewHierarchy.RCTRootViewReference = new WeakReference(null);
    }

    @Nullable
    public static final View findRCTRootView(@Nullable View view0) {
        Class class0 = ViewHierarchy.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        while(view0 != null) {
            try {
                if(ViewHierarchy.INSTANCE.isRCTRootView(view0)) {
                    return view0;
                }
                ViewParent viewParent0 = view0.getParent();
                if(!(viewParent0 instanceof View)) {
                    break;
                }
                view0 = (View)viewParent0;
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, class0);
                if(true) {
                    break;
                }
            }
        }
        return null;
    }

    @NotNull
    public static final List getChildrenOfView(@Nullable View view0) {
        Class class0 = ViewHierarchy.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            List list0 = new ArrayList();
            if(view0 instanceof ViewGroup) {
                int v = ((ViewGroup)view0).getChildCount();
                for(int v1 = 0; v1 < v; ++v1) {
                    ((ArrayList)list0).add(((ViewGroup)view0).getChildAt(v1));
                }
            }
            return list0;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    public static final int getClassTypeBitmask(@NotNull View view0) {
        Class class0 = ViewHierarchy.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return 0;
        }
        try {
            q.g(view0, "view");
            int v = view0 instanceof ImageView ? 2 : 0;
            if(view0.isClickable()) {
                v |= 0x20;
            }
            if(ViewHierarchy.isAdapterViewItem(view0)) {
                v |= 0x200;
            }
            if(view0 instanceof TextView) {
                int v1 = v | 0x401;
                if(view0 instanceof Button) {
                    v1 = v | 0x405;
                    if(view0 instanceof Switch) {
                        v1 = v | 0x2405;
                        return view0 instanceof EditText ? v1 | 0x800 : v1;
                    }
                    if(view0 instanceof CheckBox) {
                        v1 = 0x8405 | v;
                        return view0 instanceof EditText ? v1 | 0x800 : v1;
                    }
                }
                return view0 instanceof EditText ? v1 | 0x800 : v1;
            }
            if(view0 instanceof Spinner || view0 instanceof DatePicker) {
                return v | 0x1000;
            }
            if(view0 instanceof RatingBar) {
                return 0x10000 | v;
            }
            if(view0 instanceof RadioGroup) {
                return v | 0x4000;
            }
            if(!(view0 instanceof ViewGroup)) {
                return v;
            }
            View view1 = (View)ViewHierarchy.RCTRootViewReference.get();
            return !ViewHierarchy.INSTANCE.isRCTButton(view0, view1) ? v : v | 0x40;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return 0;
        }
    }

    @NotNull
    public static final JSONObject getDictionaryOfView(@NotNull View view0) {
        Class class0 = ViewHierarchy.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(view0, "view");
            if(view0.getClass().getName().equals("com.facebook.react.ReactRootView")) {
                ViewHierarchy.RCTRootViewReference = new WeakReference(view0);
            }
            JSONObject jSONObject0 = new JSONObject();
            try {
                ViewHierarchy.updateBasicInfoOfView(view0, jSONObject0);
                JSONArray jSONArray0 = new JSONArray();
                List list0 = ViewHierarchy.getChildrenOfView(view0);
                int v = list0.size();
                for(int v1 = 0; v1 < v; ++v1) {
                    jSONArray0.put(ViewHierarchy.getDictionaryOfView(((View)list0.get(v1))));
                }
                jSONObject0.put("childviews", jSONArray0);
                return jSONObject0;
            }
            catch(JSONException jSONException0) {
            }
            Log.e(ViewHierarchy.TAG, "Failed to create JSONObject for view.", jSONException0);
            return jSONObject0;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
        return null;
    }

    private final JSONObject getDimensionOfView(View view0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            JSONObject jSONObject0 = new JSONObject();
            try {
                jSONObject0.put("top", view0.getTop());
                jSONObject0.put("left", view0.getLeft());
                jSONObject0.put("width", view0.getWidth());
                jSONObject0.put("height", view0.getHeight());
                jSONObject0.put("scrollx", view0.getScrollX());
                jSONObject0.put("scrolly", view0.getScrollY());
                jSONObject0.put("visibility", view0.getVisibility());
            }
            catch(JSONException jSONException0) {
                Log.e(ViewHierarchy.TAG, "Failed to create JSONObject for dimension.", jSONException0);
            }
            return jSONObject0;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    private final Class getExistingClass(String s) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return Class.forName(s);
        }
        catch(ClassNotFoundException throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
        catch(Throwable unused_ex) {
        }
        return null;
    }

    @Nullable
    public static final View.OnClickListener getExistingOnClickListener(@Nullable View view0) {
        Class class0 = ViewHierarchy.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            Field field0 = View.class.getDeclaredField("mListenerInfo");
            if(field0 != null) {
                field0.setAccessible(true);
            }
            Object object0 = field0.get(view0);
            if(object0 == null) {
                return null;
            }
            Field field1 = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
            if(field1 != null) {
                field1.setAccessible(true);
                Object object1 = field1.get(object0);
                q.e(object1, "null cannot be cast to non-null type android.view.View.OnClickListener");
                return (View.OnClickListener)object1;
            }
            return null;
        }
        catch(NoSuchFieldException | ClassNotFoundException | IllegalAccessException unused_ex) {
            return null;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
        return null;
    }

    @Nullable
    public static final View.OnTouchListener getExistingOnTouchListener(@Nullable View view0) {
        Class class0 = ViewHierarchy.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            try {
                Field field0 = View.class.getDeclaredField("mListenerInfo");
                if(field0 != null) {
                    field0.setAccessible(true);
                }
                Object object0 = field0.get(view0);
                if(object0 == null) {
                    return null;
                }
                Field field1 = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnTouchListener");
                if(field1 != null) {
                    field1.setAccessible(true);
                    Object object1 = field1.get(object0);
                    q.e(object1, "null cannot be cast to non-null type android.view.View.OnTouchListener");
                    return (View.OnTouchListener)object1;
                }
                return null;
            }
            catch(NoSuchFieldException noSuchFieldException0) {
            }
            catch(ClassNotFoundException classNotFoundException0) {
                Utility.logd(ViewHierarchy.TAG, classNotFoundException0);
                return null;
            }
            catch(IllegalAccessException illegalAccessException0) {
                Utility.logd(ViewHierarchy.TAG, illegalAccessException0);
                return null;
            }
            Utility.logd(ViewHierarchy.TAG, noSuchFieldException0);
            return null;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
        return null;
    }

    @NotNull
    public static final String getHintOfView(@Nullable View view0) {
        CharSequence charSequence0;
        Class class0 = ViewHierarchy.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            if(view0 instanceof EditText) {
                charSequence0 = ((EditText)view0).getHint();
            }
            else {
                charSequence0 = view0 instanceof TextView ? ((TextView)view0).getHint() : null;
            }
            if(charSequence0 != null) {
                String s = charSequence0.toString();
                return s == null ? "" : s;
            }
            return "";
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
        return null;
    }

    @Nullable
    public static final ViewGroup getParentOfView(@Nullable View view0) {
        Class class0 = ViewHierarchy.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        if(view0 == null) {
            return null;
        }
        try {
            ViewParent viewParent0 = view0.getParent();
            return viewParent0 instanceof ViewGroup ? ((ViewGroup)viewParent0) : null;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    @NotNull
    public static final String getTextOfView(@Nullable View view0) {
        CharSequence charSequence0 = null;
        Class class0 = ViewHierarchy.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            if(view0 instanceof TextView) {
                charSequence0 = ((TextView)view0).getText();
                if(view0 instanceof Switch) {
                    charSequence0 = ((Switch)view0).isChecked() ? "1" : "0";
                }
            }
            else if(!(view0 instanceof Spinner)) {
                if(view0 instanceof DatePicker) {
                    charSequence0 = String.format("%04d-%02d-%02d", Arrays.copyOf(new Object[]{((DatePicker)view0).getYear(), ((DatePicker)view0).getMonth(), ((DatePicker)view0).getDayOfMonth()}, 3));
                }
                else if(view0 instanceof TimePicker) {
                    Integer integer0 = ((TimePicker)view0).getCurrentHour();
                    q.f(integer0, "view.currentHour");
                    Integer integer1 = ((TimePicker)view0).getCurrentMinute();
                    q.f(integer1, "view.currentMinute");
                    charSequence0 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{integer0.intValue(), integer1.intValue()}, 2));
                }
                else if(view0 instanceof RadioGroup) {
                    int v = ((RadioGroup)view0).getCheckedRadioButtonId();
                    int v1 = ((RadioGroup)view0).getChildCount();
                    for(int v2 = 0; v2 < v1; ++v2) {
                        View view1 = ((RadioGroup)view0).getChildAt(v2);
                        if(view1.getId() == v && view1 instanceof RadioButton) {
                            charSequence0 = ((RadioButton)view1).getText();
                            break;
                        }
                    }
                }
                else if(view0 instanceof RatingBar) {
                    charSequence0 = String.valueOf(((RatingBar)view0).getRating());
                }
            }
            else if(((Spinner)view0).getCount() > 0) {
                Object object0 = ((Spinner)view0).getSelectedItem();
                if(object0 != null) {
                    charSequence0 = object0.toString();
                }
            }
            if(charSequence0 != null) {
                String s = charSequence0.toString();
                return s == null ? "" : s;
            }
            return "";
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
        return null;
    }

    private final View getTouchReactView(float[] arr_f, View view0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            this.initTouchTargetHelperMethods();
            Method method0 = ViewHierarchy.methodFindTouchTargetView;
            if(method0 != null && view0 != null) {
                try {
                    if(method0 == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    Object object0 = method0.invoke(null, arr_f, view0);
                    q.e(object0, "null cannot be cast to non-null type android.view.View");
                    if(((View)object0).getId() > 0) {
                        ViewParent viewParent0 = ((View)object0).getParent();
                        q.e(viewParent0, "null cannot be cast to non-null type android.view.View");
                        return (View)viewParent0;
                    }
                    return null;
                }
                catch(IllegalAccessException illegalAccessException0) {
                }
                catch(InvocationTargetException invocationTargetException0) {
                    Utility.logd(ViewHierarchy.TAG, invocationTargetException0);
                    return null;
                }
                Utility.logd(ViewHierarchy.TAG, illegalAccessException0);
                return null;
            }
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
        return null;
    }

    private final float[] getViewLocationOnScreen(View view0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            int[] arr_v = new int[2];
            view0.getLocationOnScreen(arr_v);
            return new float[]{((float)arr_v[0]), ((float)arr_v[1])};
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return null;
        }
    }

    private final void initTouchTargetHelperMethods() {
        if(!CrashShieldHandler.isObjectCrashing(this) && ViewHierarchy.methodFindTouchTargetView == null) {
            try {
                try {
                    Method method0 = Class.forName("com.facebook.react.uimanager.TouchTargetHelper").getDeclaredMethod("findTouchTargetView", float[].class, ViewGroup.class);
                    ViewHierarchy.methodFindTouchTargetView = method0;
                    if(method0 == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    method0.setAccessible(true);
                    return;
                }
                catch(ClassNotFoundException classNotFoundException0) {
                }
                catch(NoSuchMethodException noSuchMethodException0) {
                    Utility.logd(ViewHierarchy.TAG, noSuchMethodException0);
                    return;
                }
                Utility.logd(ViewHierarchy.TAG, classNotFoundException0);
                return;
            }
            catch(Throwable throwable0) {
            }
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
    }

    private static final boolean isAdapterViewItem(View view0) {
        Class class0 = ViewHierarchy.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return false;
        }
        try {
            ViewParent viewParent0 = view0.getParent();
            if(viewParent0 instanceof AdapterView) {
                return true;
            }
            ViewHierarchy viewHierarchy0 = ViewHierarchy.INSTANCE;
            Class class1 = viewHierarchy0.getExistingClass("android.support.v4.view.NestedScrollingChild");
            if(class1 != null && class1.isInstance(viewParent0)) {
                return true;
            }
            Class class2 = viewHierarchy0.getExistingClass("androidx.core.view.NestedScrollingChild");
            return class2 != null && class2.isInstance(viewParent0);
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
        return false;
    }

    public final boolean isRCTButton(@NotNull View view0, @Nullable View view1) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            q.g(view0, "view");
            if(!view0.getClass().getName().equals("com.facebook.react.views.view.ReactViewGroup")) {
                return false;
            }
            View view2 = this.getTouchReactView(this.getViewLocationOnScreen(view0), view1);
            return view2 == null || view2.getId() != view0.getId() ? false : true;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return false;
        }
    }

    private final boolean isRCTRootView(View view0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return view0.getClass().getName().equals("com.facebook.react.ReactRootView");
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return false;
        }
    }

    public static final void setOnClickListener(@NotNull View view0, @Nullable View.OnClickListener view$OnClickListener0) {
        Field field1;
        Field field0;
        Object object0;
        Class class0 = ViewHierarchy.class;
        if(!CrashShieldHandler.isObjectCrashing(class0)) {
            try {
                q.g(view0, "view");
                object0 = null;
                try {
                    field0 = View.class.getDeclaredField("mListenerInfo");
                    field1 = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
                    goto label_11;
                }
                catch(ClassNotFoundException | NoSuchFieldException unused_ex) {
                }
                catch(Exception unused_ex) {
                    return;
                }
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, class0);
                return;
            }
            field0 = null;
            goto label_10;
            try {
                field1 = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
                goto label_11;
            }
            catch(ClassNotFoundException | NoSuchFieldException unused_ex) {
            }
            catch(Exception unused_ex) {
                return;
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, class0);
                return;
            }
        label_10:
            field1 = null;
            try {
            label_11:
                if(field0 == null || field1 == null) {
                    view0.setOnClickListener(view$OnClickListener0);
                    return;
                }
                field0.setAccessible(true);
                field1.setAccessible(true);
                try {
                    field0.setAccessible(true);
                    object0 = field0.get(view0);
                }
                catch(IllegalAccessException unused_ex) {
                }
                if(object0 == null) {
                    view0.setOnClickListener(view$OnClickListener0);
                    return;
                }
                field1.set(object0, view$OnClickListener0);
                return;
            }
            catch(Exception unused_ex) {
                return;
            }
            catch(Throwable throwable0) {
            }
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public static final void updateAppearanceOfView(@NotNull View view0, @NotNull JSONObject jSONObject0, float f) {
        Class class0 = ViewHierarchy.class;
        if(!CrashShieldHandler.isObjectCrashing(class0)) {
            try {
                q.g(view0, "view");
                q.g(jSONObject0, "json");
                try {
                    JSONObject jSONObject1 = new JSONObject();
                    if(view0 instanceof TextView) {
                        Typeface typeface0 = ((TextView)view0).getTypeface();
                        if(typeface0 != null) {
                            jSONObject1.put("font_size", ((double)((TextView)view0).getTextSize()));
                            jSONObject1.put("is_bold", typeface0.isBold());
                            jSONObject1.put("is_italic", typeface0.isItalic());
                            jSONObject0.put("text_style", jSONObject1);
                        }
                    }
                }
                catch(JSONException jSONException0) {
                    Utility.logd(ViewHierarchy.TAG, jSONException0);
                    return;
                }
                if(view0 instanceof ImageView) {
                    try {
                        Drawable drawable0 = ((ImageView)view0).getDrawable();
                        if(drawable0 instanceof BitmapDrawable && ((float)view0.getHeight()) / f <= 44.0f && ((float)view0.getWidth()) / f <= 44.0f) {
                            Bitmap bitmap0 = ((BitmapDrawable)drawable0).getBitmap();
                            if(bitmap0 != null) {
                                ByteArrayOutputStream byteArrayOutputStream0 = new ByteArrayOutputStream();
                                bitmap0.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream0);
                                jSONObject0.put("icon_image", Base64.encodeToString(byteArrayOutputStream0.toByteArray(), 0));
                                return;
                            }
                        }
                        return;
                    }
                    catch(JSONException jSONException0) {
                    }
                    Utility.logd(ViewHierarchy.TAG, jSONException0);
                    return;
                }
                return;
            }
            catch(Throwable throwable0) {
            }
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }

    public static final void updateBasicInfoOfView(@NotNull View view0, @NotNull JSONObject jSONObject0) {
        Class class0 = ViewHierarchy.class;
        if(!CrashShieldHandler.isObjectCrashing(class0)) {
            try {
                q.g(view0, "view");
                q.g(jSONObject0, "json");
                try {
                    String s = ViewHierarchy.getTextOfView(view0);
                    String s1 = ViewHierarchy.getHintOfView(view0);
                    Object object0 = view0.getTag();
                    CharSequence charSequence0 = view0.getContentDescription();
                    jSONObject0.put("classname", view0.getClass().getCanonicalName());
                    jSONObject0.put("classtypebitmask", ViewHierarchy.getClassTypeBitmask(view0));
                    jSONObject0.put("id", view0.getId());
                    if(SensitiveUserDataUtils.isSensitiveUserData(view0)) {
                        jSONObject0.put("text", "");
                        jSONObject0.put("is_user_input", true);
                    }
                    else {
                        jSONObject0.put("text", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(s), ""));
                    }
                    jSONObject0.put("hint", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(s1), ""));
                    if(object0 != null) {
                        jSONObject0.put("tag", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(object0.toString()), ""));
                    }
                    if(charSequence0 != null) {
                        jSONObject0.put("description", Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(charSequence0.toString()), ""));
                    }
                    jSONObject0.put("dimension", ViewHierarchy.INSTANCE.getDimensionOfView(view0));
                    return;
                }
                catch(JSONException jSONException0) {
                }
                Utility.logd(ViewHierarchy.TAG, jSONException0);
                return;
            }
            catch(Throwable throwable0) {
            }
            CrashShieldHandler.handleThrowable(throwable0, class0);
        }
    }
}

