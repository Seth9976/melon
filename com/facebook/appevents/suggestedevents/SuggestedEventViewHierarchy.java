package com.facebook.appevents.suggestedevents;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TimePicker;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import e.k;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001F\u0010\b\u001A\u00020\u00072\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\n\u001A\u00020\u0007H\u0007¢\u0006\u0004\b\f\u0010\rJ\u001D\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00040\u000E2\u0006\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u000F\u0010\u0010J\u0017\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0011\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u001F\u0010\u0015\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000E2\u0006\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0010R\"\u0010\u0017\u001A\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00160\u000E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/facebook/appevents/suggestedevents/SuggestedEventViewHierarchy;", "", "<init>", "()V", "Landroid/view/View;", "view", "clickedView", "Lorg/json/JSONObject;", "getDictionaryOfView", "(Landroid/view/View;Landroid/view/View;)Lorg/json/JSONObject;", "json", "Lie/H;", "updateBasicInfo", "(Landroid/view/View;Lorg/json/JSONObject;)V", "", "getAllClickableViews", "(Landroid/view/View;)Ljava/util/List;", "hostView", "", "getTextOfViewRecursively", "(Landroid/view/View;)Ljava/lang/String;", "getTextOfChildren", "Ljava/lang/Class;", "blacklistedViews", "Ljava/util/List;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class SuggestedEventViewHierarchy {
    @NotNull
    public static final SuggestedEventViewHierarchy INSTANCE;
    @NotNull
    private static final List blacklistedViews;

    static {
        SuggestedEventViewHierarchy.INSTANCE = new SuggestedEventViewHierarchy();
        SuggestedEventViewHierarchy.blacklistedViews = k.A(new Class[]{Switch.class, Spinner.class, DatePicker.class, TimePicker.class, RadioGroup.class, RatingBar.class, EditText.class, AdapterView.class});
    }

    @NotNull
    public static final List getAllClickableViews(@NotNull View view0) {
        Class class0 = SuggestedEventViewHierarchy.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(view0, "view");
            List list0 = new ArrayList();
            for(Object object0: SuggestedEventViewHierarchy.blacklistedViews) {
                if(((Class)object0).isInstance(view0)) {
                    return list0;
                }
                if(false) {
                    break;
                }
            }
            if(view0.isClickable()) {
                list0.add(view0);
            }
            for(Object object1: ViewHierarchy.getChildrenOfView(view0)) {
                list0.addAll(SuggestedEventViewHierarchy.getAllClickableViews(((View)object1)));
            }
            return list0;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
        return null;
    }

    @NotNull
    public static final JSONObject getDictionaryOfView(@NotNull View view0, @NotNull View view1) {
        JSONObject jSONObject0;
        Class class0 = SuggestedEventViewHierarchy.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(view0, "view");
            q.g(view1, "clickedView");
            jSONObject0 = new JSONObject();
            if(view0 == view1) {
                try {
                    jSONObject0.put("is_interacted", true);
                label_8:
                    SuggestedEventViewHierarchy.updateBasicInfo(view0, jSONObject0);
                    JSONArray jSONArray0 = new JSONArray();
                    for(Object object0: ViewHierarchy.getChildrenOfView(view0)) {
                        jSONArray0.put(SuggestedEventViewHierarchy.getDictionaryOfView(((View)object0), view1));
                    }
                    jSONObject0.put("childviews", jSONArray0);
                    return jSONObject0;
                }
                catch(JSONException unused_ex) {
                }
                return jSONObject0;
            }
            goto label_8;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    private final List getTextOfChildren(View view0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            List list0 = new ArrayList();
            for(Object object0: ViewHierarchy.getChildrenOfView(view0)) {
                String s = ViewHierarchy.getTextOfView(((View)object0));
                if(s.length() > 0) {
                    list0.add(s);
                }
                list0.addAll(this.getTextOfChildren(((View)object0)));
            }
            return list0;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return null;
    }

    @NotNull
    public static final String getTextOfViewRecursively(@NotNull View view0) {
        Class class0 = SuggestedEventViewHierarchy.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(view0, "hostView");
            String s = ViewHierarchy.getTextOfView(view0);
            if(s.length() > 0) {
                return s;
            }
            String s1 = TextUtils.join(" ", SuggestedEventViewHierarchy.INSTANCE.getTextOfChildren(view0));
            q.f(s1, "join(\" \", childrenText)");
            return s1;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    public static final void updateBasicInfo(@NotNull View view0, @NotNull JSONObject jSONObject0) {
        Class class0 = SuggestedEventViewHierarchy.class;
        if(!CrashShieldHandler.isObjectCrashing(class0)) {
            try {
                q.g(view0, "view");
                q.g(jSONObject0, "json");
                try {
                    String s = ViewHierarchy.getTextOfView(view0);
                    String s1 = ViewHierarchy.getHintOfView(view0);
                    jSONObject0.put("classname", view0.getClass().getSimpleName());
                    jSONObject0.put("classtypebitmask", ViewHierarchy.getClassTypeBitmask(view0));
                    if(s.length() > 0) {
                        jSONObject0.put("text", s);
                    }
                    if(s1.length() > 0) {
                        jSONObject0.put("hint", s1);
                    }
                    if(view0 instanceof EditText) {
                        jSONObject0.put("inputtype", ((EditText)view0).getInputType());
                    }
                }
                catch(JSONException unused_ex) {
                }
            }
            catch(Throwable throwable0) {
                CrashShieldHandler.handleThrowable(throwable0, class0);
            }
        }
    }
}

