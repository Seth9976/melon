package com.facebook.appevents.codeless.internal;

import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0002J\u0010\u0010\u0007\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0002J\u0010\u0010\b\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0002J\u0010\u0010\t\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0002J\u0010\u0010\n\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0002J\u0010\u0010\u000B\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0002J\u0012\u0010\f\u001A\u00020\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\rH\u0007¨\u0006\u000E"}, d2 = {"Lcom/facebook/appevents/codeless/internal/SensitiveUserDataUtils;", "", "()V", "isCreditCard", "", "view", "Landroid/widget/TextView;", "isEmail", "isPassword", "isPersonName", "isPhoneNumber", "isPostalAddress", "isSensitiveUserData", "Landroid/view/View;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class SensitiveUserDataUtils {
    @NotNull
    public static final SensitiveUserDataUtils INSTANCE;

    static {
        SensitiveUserDataUtils.INSTANCE = new SensitiveUserDataUtils();
    }

    private final boolean isCreditCard(TextView textView0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            String s = ViewHierarchy.getTextOfView(textView0);
            Pattern pattern0 = Pattern.compile("\\s");
            q.f(pattern0, "compile(...)");
            q.g(s, "input");
            String s1 = pattern0.matcher(s).replaceAll("");
            q.f(s1, "replaceAll(...)");
            int v = s1.length();
            if(v >= 12 && v <= 19) {
                int v1 = v - 1;
                int v2 = 0;
                int v3 = 0;
                while(-1 < v1) {
                    int v4 = s1.charAt(v1);
                    if(!Character.isDigit(((char)v4))) {
                        return false;
                    }
                    int v5 = Character.digit(v4, 10);
                    if(v5 < 0) {
                        throw new IllegalArgumentException("Char " + ((char)v4) + " is not a decimal digit");
                    }
                    if(v3 != 0) {
                        v5 *= 2;
                        if(v5 > 9) {
                            v5 = v5 % 10 + 1;
                        }
                    }
                    v2 += v5;
                    v3 ^= 1;
                    --v1;
                }
                return v2 % 10 == 0;
            }
            return false;
        }
        catch(Throwable throwable0) {
        }
        CrashShieldHandler.handleThrowable(throwable0, this);
        return false;
    }

    private final boolean isEmail(TextView textView0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            if(textView0.getInputType() == 0x20) {
                return true;
            }
            String s = ViewHierarchy.getTextOfView(textView0);
            return s == null || s.length() == 0 ? false : Patterns.EMAIL_ADDRESS.matcher(s).matches();
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return false;
        }
    }

    private final boolean isPassword(TextView textView0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return textView0.getInputType() == 0x80 ? true : textView0.getTransformationMethod() instanceof PasswordTransformationMethod;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
            return false;
        }
    }

    private final boolean isPersonName(TextView textView0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            if(textView0.getInputType() == 0x60) {
                return true;
            }
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
        return false;
    }

    private final boolean isPhoneNumber(TextView textView0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            if(textView0.getInputType() == 3) {
                return true;
            }
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
        return false;
    }

    private final boolean isPostalAddress(TextView textView0) {
        if(CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            if(textView0.getInputType() == 0x70) {
                return true;
            }
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, this);
        }
        return false;
    }

    public static final boolean isSensitiveUserData(@Nullable View view0) {
        Class class0 = SensitiveUserDataUtils.class;
        if(CrashShieldHandler.isObjectCrashing(class0)) {
            return false;
        }
        try {
            return !(view0 instanceof TextView) || !SensitiveUserDataUtils.INSTANCE.isPassword(((TextView)view0)) && !SensitiveUserDataUtils.INSTANCE.isCreditCard(((TextView)view0)) && !SensitiveUserDataUtils.INSTANCE.isPersonName(((TextView)view0)) && !SensitiveUserDataUtils.INSTANCE.isPostalAddress(((TextView)view0)) && !SensitiveUserDataUtils.INSTANCE.isPhoneNumber(((TextView)view0)) && !SensitiveUserDataUtils.INSTANCE.isEmail(((TextView)view0)) ? false : true;
        }
        catch(Throwable throwable0) {
            CrashShieldHandler.handleThrowable(throwable0, class0);
            return false;
        }
    }
}

