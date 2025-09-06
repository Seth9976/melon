package androidx.car.app;

import android.os.RemoteException;
import android.util.Log;
import java.security.InvalidParameterException;
import java.util.Objects;
import y.e;

public final class FailureResponse {
    public static final int BUNDLER_EXCEPTION = 1;
    public static final int ILLEGAL_STATE_EXCEPTION = 2;
    public static final int INVALID_PARAMETER_EXCEPTION = 3;
    public static final int REMOTE_EXCEPTION = 6;
    public static final int RUNTIME_EXCEPTION = 5;
    public static final int SECURITY_EXCEPTION = 4;
    public static final int UNKNOWN_ERROR;
    private final int mErrorType;
    private final String mStackTrace;

    private FailureResponse() {
        this.mStackTrace = null;
        this.mErrorType = 0;
    }

    public FailureResponse(Throwable throwable0) {
        Objects.requireNonNull(throwable0);
        this.mStackTrace = Log.getStackTraceString(throwable0);
        if(throwable0 instanceof e) {
            this.mErrorType = 1;
            return;
        }
        if(throwable0 instanceof IllegalStateException) {
            this.mErrorType = 2;
            return;
        }
        if(throwable0 instanceof InvalidParameterException) {
            this.mErrorType = 3;
            return;
        }
        if(throwable0 instanceof SecurityException) {
            this.mErrorType = 4;
            return;
        }
        if(throwable0 instanceof RuntimeException) {
            this.mErrorType = 5;
            return;
        }
        if(throwable0 instanceof RemoteException) {
            this.mErrorType = 6;
            return;
        }
        this.mErrorType = 0;
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof FailureResponse ? this.mErrorType == ((FailureResponse)object0).mErrorType && Objects.equals(this.mStackTrace, ((FailureResponse)object0).mStackTrace) : false;
    }

    public int getErrorType() {
        return this.mErrorType;
    }

    public String getStackTrace() {
        Objects.requireNonNull(this.mStackTrace);
        return this.mStackTrace;
    }

    @Override
    public int hashCode() {
        return Objects.hash(new Object[]{this.mErrorType, this.mStackTrace});
    }
}

