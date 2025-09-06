package com.melon.net;

import com.melon.net.exception.MelonNetworkError;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0002\u0003\u0004\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/melon/net/ApiResult;", "T", "", "Success", "Failure", "Lcom/melon/net/ApiResult$Failure;", "Lcom/melon/net/ApiResult$Success;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface ApiResult {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fJ\b\u0010\u000B\u001A\u00020\bH\u0016R\u0014\u0010\u0003\u001A\u0004\u0018\u00010\u0004X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001A\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001A\u0004\b\t\u0010\n\u0082\u0001\u0001\r¨\u0006\u000EÀ\u0006\u0003"}, d2 = {"Lcom/melon/net/ApiResult$Failure;", "Lcom/melon/net/ApiResult;", "", "message", "", "getMessage", "()Ljava/lang/String;", "cause", "", "getCause", "()Ljava/lang/Throwable;", "throwCommonException", "MelonFailure", "Lcom/melon/net/ApiResult$Failure$MelonFailure;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface Failure extends ApiResult {
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        public static final class DefaultImpls {
            @Deprecated
            @NotNull
            public static Throwable throwCommonException(@NotNull Failure apiResult$Failure0) {
                return apiResult$Failure0.super.throwCommonException();
            }
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0003\n\u0002\b\n\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001A\u00020\u0003HÆ\u0003J\u000B\u0010\r\u001A\u0004\u0018\u00010\u0005HÆ\u0003J\u001F\u0010\u000E\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000F\u001A\u00020\u00102\b\u0010\u0011\u001A\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001A\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001A\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001A\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000B¨\u0006\u0016"}, d2 = {"Lcom/melon/net/ApiResult$Failure$MelonFailure;", "Lcom/melon/net/ApiResult$Failure;", "message", "", "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "getMessage", "()Ljava/lang/String;", "getCause", "()Ljava/lang/Throwable;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class MelonFailure implements Failure {
            public static final int $stable = 8;
            @Nullable
            private final Throwable cause;
            @NotNull
            private final String message;

            public MelonFailure(@NotNull String s, @Nullable Throwable throwable0) {
                q.g(s, "message");
                super();
                this.message = s;
                this.cause = throwable0;
            }

            @NotNull
            public final String component1() {
                return this.message;
            }

            @Nullable
            public final Throwable component2() {
                return this.cause;
            }

            @NotNull
            public final MelonFailure copy(@NotNull String s, @Nullable Throwable throwable0) {
                q.g(s, "message");
                return new MelonFailure(s, throwable0);
            }

            public static MelonFailure copy$default(MelonFailure apiResult$Failure$MelonFailure0, String s, Throwable throwable0, int v, Object object0) {
                if((v & 1) != 0) {
                    s = apiResult$Failure$MelonFailure0.message;
                }
                if((v & 2) != 0) {
                    throwable0 = apiResult$Failure$MelonFailure0.cause;
                }
                return apiResult$Failure$MelonFailure0.copy(s, throwable0);
            }

            @Override
            public boolean equals(@Nullable Object object0) {
                if(this == object0) {
                    return true;
                }
                if(!(object0 instanceof MelonFailure)) {
                    return false;
                }
                return q.b(this.message, ((MelonFailure)object0).message) ? q.b(this.cause, ((MelonFailure)object0).cause) : false;
            }

            @Override  // com.melon.net.ApiResult$Failure
            @Nullable
            public Throwable getCause() {
                return this.cause;
            }

            @Override  // com.melon.net.ApiResult$Failure
            @NotNull
            public String getMessage() {
                return this.message;
            }

            @Override
            public int hashCode() {
                int v = this.message.hashCode();
                return this.cause == null ? v * 0x1F : v * 0x1F + this.cause.hashCode();
            }

            @Override  // com.melon.net.ApiResult$Failure
            @NotNull
            public Throwable throwCommonException() {
                return Failure.super.throwCommonException();
            }

            @Override
            @NotNull
            public String toString() {
                return "MelonFailure(message=" + this.message + ", cause=" + this.cause + ")";
            }
        }

        @Nullable
        Throwable getCause();

        @Nullable
        String getMessage();

        @NotNull
        default Throwable throwCommonException() {
            return new MelonNetworkError(this.getMessage(), this.getCause());
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0087\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000F\u0012\u0006\u0010\u0003\u001A\u00028\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u000E\u0010\t\u001A\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001E\u0010\n\u001A\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001A\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\u000BJ\u0013\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000FHÖ\u0003J\t\u0010\u0010\u001A\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001A\u00020\u0013HÖ\u0001R\u0013\u0010\u0003\u001A\u00028\u0001¢\u0006\n\n\u0002\u0010\b\u001A\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/melon/net/ApiResult$Success;", "T", "Lcom/melon/net/ApiResult;", "data", "<init>", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/melon/net/ApiResult$Success;", "equals", "", "other", "", "hashCode", "", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Success implements ApiResult {
        public static final int $stable;
        private final Object data;

        public Success(Object object0) {
            this.data = object0;
        }

        public final Object component1() {
            return this.data;
        }

        @NotNull
        public final Success copy(Object object0) {
            return new Success(object0);
        }

        public static Success copy$default(Success apiResult$Success0, Object object0, int v, Object object1) {
            if((v & 1) != 0) {
                object0 = apiResult$Success0.data;
            }
            return apiResult$Success0.copy(object0);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            return object0 instanceof Success ? q.b(this.data, ((Success)object0).data) : false;
        }

        public final Object getData() {
            return this.data;
        }

        @Override
        public int hashCode() {
            return this.data == null ? 0 : this.data.hashCode();
        }

        @Override
        @NotNull
        public String toString() {
            return "Success(data=" + this.data + ")";
        }
    }

}

