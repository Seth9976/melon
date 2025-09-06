package org.chromium.support_lib_boundary;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.jspecify.annotations.NullMarked;

@NullMarked
public interface PrefetchOperationCallbackBoundaryInterface {
    @Retention(RetentionPolicy.SOURCE)
    public @interface PrefetchExceptionTypeBoundaryInterface {
        public static final int DUPLICATE = 2;
        public static final int GENERIC = 0;
        public static final int NETWORK = 1;

    }

    void onFailure(int arg1, String arg2, int arg3);

    void onSuccess();
}

