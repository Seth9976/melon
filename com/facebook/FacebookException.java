package com.facebook;

import com.facebook.internal.FeatureManager.Feature;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.errorreport.ErrorReportHandler;
import java.util.Arrays;
import java.util.Random;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00112\u00060\u0001j\u0002`\u0002:\u0001\u0011B\u0007\b\u0016¢\u0006\u0002\u0010\u0003B\u0011\b\u0016\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B)\b\u0016\u0012\b\u0010\u0007\u001A\u0004\u0018\u00010\u0005\u0012\u0016\u0010\b\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000BB\u001B\b\u0016\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001A\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000EB\u0011\b\u0016\u0012\b\u0010\f\u001A\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000FJ\b\u0010\u0010\u001A\u00020\u0005H\u0016¨\u0006\u0012"}, d2 = {"Lcom/facebook/FacebookException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "()V", "message", "", "(Ljava/lang/String;)V", "format", "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "throwable", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "(Ljava/lang/Throwable;)V", "toString", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public class FacebookException extends RuntimeException {
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000E\u0010\u0003\u001A\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/FacebookException$Companion;", "", "()V", "serialVersionUID", "", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @NotNull
    public static final Companion Companion = null;
    public static final long serialVersionUID = 1L;

    static {
        FacebookException.Companion = new Companion(null);
    }

    public FacebookException() {
    }

    public FacebookException(@Nullable String s) {
        super(s);
        Random random0 = new Random();
        if(s != null && FacebookSdk.isInitialized() && random0.nextInt(100) > 50) {
            e e0 = new e(s);
            FeatureManager.checkFeature(Feature.ErrorReport, e0);
        }
    }

    public FacebookException(@Nullable String s, @Nullable Throwable throwable0) {
        super(s, throwable0);
    }

    public FacebookException(@Nullable String s, @NotNull Object[] arr_object) {
        q.g(arr_object, "args");
        String s1;
        if(s == null) {
            s1 = null;
        }
        else {
            Object[] arr_object1 = Arrays.copyOf(arr_object, arr_object.length);
            s1 = String.format(s, Arrays.copyOf(arr_object1, arr_object1.length));
        }
        this(s1);
    }

    public FacebookException(@Nullable Throwable throwable0) {
        super(throwable0);
    }

    private static final void _init_$lambda$0(String s, boolean z) {
        if(z) {
            try {
                ErrorReportHandler.save(s);
            }
            catch(Exception unused_ex) {
            }
        }
    }

    @Override
    @NotNull
    public String toString() [...] // 潜在的解密器
}

