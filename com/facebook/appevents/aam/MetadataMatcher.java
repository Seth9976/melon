package com.facebook.appevents.aam;

import Tf.o;
import android.content.res.Resources.NotFoundException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import e.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0007\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001A\u00020\tH\u0007J\u0016\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001A\u00020\tH\u0007J\u0016\u0010\u000B\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001A\u00020\tH\u0002J\u001E\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u00072\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J$\u0010\f\u001A\u00020\r2\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007J\u0018\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0012\u001A\u00020\u00072\u0006\u0010\u0013\u001A\u00020\u0007H\u0007R\u000E\u0010\u0003\u001A\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/facebook/appevents/aam/MetadataMatcher;", "", "()V", "MAX_INDICATOR_LENGTH", "", "getAroundViewIndicators", "", "", "view", "Landroid/view/View;", "getCurrentViewIndicators", "getTextIndicators", "matchIndicator", "", "indicator", "keys", "indicators", "matchValue", "text", "rule", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class MetadataMatcher {
    @NotNull
    public static final MetadataMatcher INSTANCE = null;
    private static final int MAX_INDICATOR_LENGTH = 100;

    static {
        MetadataMatcher.INSTANCE = new MetadataMatcher();
    }

    @NotNull
    public static final List getAroundViewIndicators(@NotNull View view0) {
        Class class0 = MetadataMatcher.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(view0, "view");
            List list0 = new ArrayList();
            ViewGroup viewGroup0 = ViewHierarchy.getParentOfView(view0);
            if(viewGroup0 != null) {
                for(Object object0: ViewHierarchy.getChildrenOfView(viewGroup0)) {
                    View view1 = (View)object0;
                    if(view0 != view1) {
                        list0.addAll(MetadataMatcher.INSTANCE.getTextIndicators(view1));
                    }
                }
            }
            return list0;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return null;
        }
    }

    @NotNull
    public static final List getCurrentViewIndicators(@NotNull View view0) {
        List list0;
        Class class0 = MetadataMatcher.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return null;
        }
        try {
            q.g(view0, "view");
            ArrayList arrayList0 = new ArrayList();
            arrayList0.add(ViewHierarchy.getHintOfView(view0));
            Object object0 = view0.getTag();
            if(object0 != null) {
                arrayList0.add(object0.toString());
            }
            CharSequence charSequence0 = view0.getContentDescription();
            if(charSequence0 != null) {
                arrayList0.add(charSequence0.toString());
            }
            try {
                if(view0.getId() != -1) {
                    String s = view0.getResources().getResourceName(view0.getId());
                    q.f(s, "resourceName");
                    Pattern pattern0 = Pattern.compile("/");
                    q.f(pattern0, "compile(...)");
                    o.P0(0);
                    Matcher matcher0 = pattern0.matcher(s);
                    if(matcher0.find()) {
                        ArrayList arrayList1 = new ArrayList(10);
                        int v = 0;
                        do {
                            arrayList1.add(s.subSequence(v, matcher0.start()).toString());
                            v = matcher0.end();
                        }
                        while(matcher0.find());
                        arrayList1.add(s.subSequence(v, s.length()).toString());
                        list0 = arrayList1;
                    }
                    else {
                        list0 = k.z(s.toString());
                    }
                    String[] arr_s = (String[])list0.toArray(new String[0]);
                    if(arr_s.length == 2) {
                        arrayList0.add(arr_s[1]);
                    }
                }
            }
            catch(Resources.NotFoundException unused_ex) {
            }
            List list1 = new ArrayList();
            for(Object object1: arrayList0) {
                String s1 = (String)object1;
                if(s1.length() > 0 && s1.length() <= 100) {
                    String s2 = s1.toLowerCase();
                    q.f(s2, "this as java.lang.String).toLowerCase()");
                    ((ArrayList)list1).add(s2);
                }
            }
            return list1;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, class0);
        return null;
    }

    private final List getTextIndicators(View view0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            List list0 = new ArrayList();
            if(view0 instanceof EditText) {
                return list0;
            }
            if(view0 instanceof TextView) {
                String s = ((TextView)view0).getText().toString();
                if(s.length() <= 0) {
                    return list0;
                }
                if(s.length() < 100) {
                    String s1 = s.toLowerCase();
                    q.f(s1, "this as java.lang.String).toLowerCase()");
                    list0.add(s1);
                    return list0;
                }
            }
            else {
                for(Object object0: ViewHierarchy.getChildrenOfView(view0)) {
                    list0.addAll(this.getTextIndicators(((View)object0)));
                }
            }
            return list0;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return null;
    }

    private final boolean matchIndicator(String s, List list0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        else {
            try {
                for(Object object0: list0) {
                    if(o.v0(s, ((String)object0), false)) {
                        return true;
                    }
                    if(false) {
                        break;
                    }
                }
                return false;
            }
            catch(Throwable throwable0) {
            }
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return false;
    }

    public static final boolean matchIndicator(@NotNull List list0, @NotNull List list1) {
        Class class0 = MetadataMatcher.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return false;
        }
        try {
            q.g(list0, "indicators");
            q.g(list1, "keys");
            Iterator iterator0 = list0.iterator();
            do {
                if(!iterator0.hasNext()) {
                    return false;
                }
                Object object0 = iterator0.next();
            }
            while(!MetadataMatcher.INSTANCE.matchIndicator(((String)object0), list1));
            return true;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return false;
        }
    }

    public static final boolean matchValue(@NotNull String s, @NotNull String s1) {
        Class class0 = MetadataMatcher.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return false;
        }
        try {
            q.g(s, "text");
            q.g(s1, "rule");
            Pattern pattern0 = Pattern.compile(s1);
            q.f(pattern0, "compile(...)");
            return pattern0.matcher(s).matches();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return false;
        }
    }
}

