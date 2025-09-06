package com.melon.net;

import U4.x;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u000F\u0010\u0011\u0012B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001A\u0004\u0018\u00010\u0005X¦\u0004¢\u0006\u0006\u001A\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001A\u00020\tX¦\u0004¢\u0006\u0006\u001A\u0004\b\n\u0010\u000BR\u0014\u0010\f\u001A\u0004\u0018\u00010\u0001X¦\u0004¢\u0006\u0006\u001A\u0004\b\r\u0010\u000E\u0082\u0001\u0004\u0013\u0014\u0015\u0016¨\u0006\u0017"}, d2 = {"Lcom/melon/net/MelonThrowable;", "", "<init>", "()V", "code", "", "getCode", "()Ljava/lang/Integer;", "message", "", "getMessage", "()Ljava/lang/String;", "cause", "getCause", "()Ljava/lang/Throwable;", "NetworkError", "AuthFailureError", "ClientError", "ServerError", "Lcom/melon/net/MelonThrowable$AuthFailureError;", "Lcom/melon/net/MelonThrowable$ClientError;", "Lcom/melon/net/MelonThrowable$NetworkError;", "Lcom/melon/net/MelonThrowable$ServerError;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class MelonThrowable extends Throwable {
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0015\u001A\u00020\u0003HÆ\u0003J\u0010\u0010\u0016\u001A\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0017\u001A\u00020\u0007HÆ\u0003J.\u0010\u0018\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001A\u001A\u00020\u001B2\b\u0010\u001C\u001A\u0004\u0018\u00010\u001DHÖ\u0003J\t\u0010\u001E\u001A\u00020\u0005HÖ\u0001J\t\u0010\u001F\u001A\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0018\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001A\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0016\u0010\u0011\u001A\u0004\u0018\u00010\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/melon/net/MelonThrowable$AuthFailureError;", "Lcom/melon/net/MelonThrowable;", "response", "Lokhttp3/Response;", "code", "", "message", "", "<init>", "(Lokhttp3/Response;Ljava/lang/Integer;Ljava/lang/String;)V", "getResponse", "()Lokhttp3/Response;", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessage", "()Ljava/lang/String;", "cause", "", "getCause", "()Ljava/lang/Throwable;", "component1", "component2", "component3", "copy", "(Lokhttp3/Response;Ljava/lang/Integer;Ljava/lang/String;)Lcom/melon/net/MelonThrowable$AuthFailureError;", "equals", "", "other", "", "hashCode", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class AuthFailureError extends MelonThrowable {
        public static final int $stable = 8;
        @Nullable
        private final Throwable cause;
        @Nullable
        private final Integer code;
        @NotNull
        private final String message;
        @NotNull
        private final Response response;

        public AuthFailureError(@NotNull Response response0, @Nullable Integer integer0, @NotNull String s) {
            q.g(response0, "response");
            q.g(s, "message");
            super(null);
            this.response = response0;
            this.code = integer0;
            this.message = s;
        }

        public AuthFailureError(Response response0, Integer integer0, String s, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 4) != 0) {
                s = ApiResultKt.fromResourceMessage(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
            }
            this(response0, integer0, s);
        }

        @NotNull
        public final Response component1() {
            return this.response;
        }

        @Nullable
        public final Integer component2() {
            return this.code;
        }

        @NotNull
        public final String component3() {
            return this.message;
        }

        @NotNull
        public final AuthFailureError copy(@NotNull Response response0, @Nullable Integer integer0, @NotNull String s) {
            q.g(response0, "response");
            q.g(s, "message");
            return new AuthFailureError(response0, integer0, s);
        }

        public static AuthFailureError copy$default(AuthFailureError melonThrowable$AuthFailureError0, Response response0, Integer integer0, String s, int v, Object object0) {
            if((v & 1) != 0) {
                response0 = melonThrowable$AuthFailureError0.response;
            }
            if((v & 2) != 0) {
                integer0 = melonThrowable$AuthFailureError0.code;
            }
            if((v & 4) != 0) {
                s = melonThrowable$AuthFailureError0.message;
            }
            return melonThrowable$AuthFailureError0.copy(response0, integer0, s);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof AuthFailureError)) {
                return false;
            }
            if(!q.b(this.response, ((AuthFailureError)object0).response)) {
                return false;
            }
            return q.b(this.code, ((AuthFailureError)object0).code) ? q.b(this.message, ((AuthFailureError)object0).message) : false;
        }

        @Override  // com.melon.net.MelonThrowable
        @Nullable
        public Throwable getCause() {
            return this.cause;
        }

        @Override  // com.melon.net.MelonThrowable
        @Nullable
        public Integer getCode() {
            return this.code;
        }

        @Override  // com.melon.net.MelonThrowable
        @NotNull
        public String getMessage() {
            return this.message;
        }

        @NotNull
        public final Response getResponse() {
            return this.response;
        }

        @Override
        public int hashCode() {
            int v = this.response.hashCode();
            return this.code == null ? this.message.hashCode() + v * 961 : this.message.hashCode() + (v * 0x1F + this.code.hashCode()) * 0x1F;
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = new StringBuilder("AuthFailureError(response=");
            stringBuilder0.append(this.response);
            stringBuilder0.append(", code=");
            stringBuilder0.append(this.code);
            stringBuilder0.append(", message=");
            return x.m(stringBuilder0, this.message, ")");
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0015\u001A\u00020\u0003HÆ\u0003J\u0010\u0010\u0016\u001A\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0017\u001A\u00020\u0007HÆ\u0003J.\u0010\u0018\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001A\u001A\u00020\u001B2\b\u0010\u001C\u001A\u0004\u0018\u00010\u001DHÖ\u0003J\t\u0010\u001E\u001A\u00020\u0005HÖ\u0001J\t\u0010\u001F\u001A\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0018\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001A\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0016\u0010\u0011\u001A\u0004\u0018\u00010\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/melon/net/MelonThrowable$ClientError;", "Lcom/melon/net/MelonThrowable;", "response", "Lokhttp3/Response;", "code", "", "message", "", "<init>", "(Lokhttp3/Response;Ljava/lang/Integer;Ljava/lang/String;)V", "getResponse", "()Lokhttp3/Response;", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessage", "()Ljava/lang/String;", "cause", "", "getCause", "()Ljava/lang/Throwable;", "component1", "component2", "component3", "copy", "(Lokhttp3/Response;Ljava/lang/Integer;Ljava/lang/String;)Lcom/melon/net/MelonThrowable$ClientError;", "equals", "", "other", "", "hashCode", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ClientError extends MelonThrowable {
        public static final int $stable = 8;
        @Nullable
        private final Throwable cause;
        @Nullable
        private final Integer code;
        @NotNull
        private final String message;
        @NotNull
        private final Response response;

        public ClientError(@NotNull Response response0, @Nullable Integer integer0, @NotNull String s) {
            q.g(response0, "response");
            q.g(s, "message");
            super(null);
            this.response = response0;
            this.code = integer0;
            this.message = s;
        }

        public ClientError(Response response0, Integer integer0, String s, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 4) != 0) {
                s = ApiResultKt.fromResourceMessage(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
            }
            this(response0, integer0, s);
        }

        @NotNull
        public final Response component1() {
            return this.response;
        }

        @Nullable
        public final Integer component2() {
            return this.code;
        }

        @NotNull
        public final String component3() {
            return this.message;
        }

        @NotNull
        public final ClientError copy(@NotNull Response response0, @Nullable Integer integer0, @NotNull String s) {
            q.g(response0, "response");
            q.g(s, "message");
            return new ClientError(response0, integer0, s);
        }

        public static ClientError copy$default(ClientError melonThrowable$ClientError0, Response response0, Integer integer0, String s, int v, Object object0) {
            if((v & 1) != 0) {
                response0 = melonThrowable$ClientError0.response;
            }
            if((v & 2) != 0) {
                integer0 = melonThrowable$ClientError0.code;
            }
            if((v & 4) != 0) {
                s = melonThrowable$ClientError0.message;
            }
            return melonThrowable$ClientError0.copy(response0, integer0, s);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof ClientError)) {
                return false;
            }
            if(!q.b(this.response, ((ClientError)object0).response)) {
                return false;
            }
            return q.b(this.code, ((ClientError)object0).code) ? q.b(this.message, ((ClientError)object0).message) : false;
        }

        @Override  // com.melon.net.MelonThrowable
        @Nullable
        public Throwable getCause() {
            return this.cause;
        }

        @Override  // com.melon.net.MelonThrowable
        @Nullable
        public Integer getCode() {
            return this.code;
        }

        @Override  // com.melon.net.MelonThrowable
        @NotNull
        public String getMessage() {
            return this.message;
        }

        @NotNull
        public final Response getResponse() {
            return this.response;
        }

        @Override
        public int hashCode() {
            int v = this.response.hashCode();
            return this.code == null ? this.message.hashCode() + v * 961 : this.message.hashCode() + (v * 0x1F + this.code.hashCode()) * 0x1F;
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = new StringBuilder("ClientError(response=");
            stringBuilder0.append(this.response);
            stringBuilder0.append(", code=");
            stringBuilder0.append(this.code);
            stringBuilder0.append(", message=");
            return x.m(stringBuilder0, this.message, ")");
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u000F\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0011\u001A\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000BJ\u000B\u0010\u0012\u001A\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0013\u001A\u00020\u0007HÆ\u0003J0\u0010\u0014\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001A\u00020\u00172\b\u0010\u0018\u001A\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001A\u001A\u00020\u0003HÖ\u0001J\t\u0010\u001B\u001A\u00020\u0007HÖ\u0001R\u0018\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001A\u0004\b\n\u0010\u000BR\u0016\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000ER\u0014\u0010\u0006\u001A\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u001C"}, d2 = {"Lcom/melon/net/MelonThrowable$NetworkError;", "Lcom/melon/net/MelonThrowable;", "code", "", "cause", "", "message", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/Throwable;Ljava/lang/String;)V", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCause", "()Ljava/lang/Throwable;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Throwable;Ljava/lang/String;)Lcom/melon/net/MelonThrowable$NetworkError;", "equals", "", "other", "", "hashCode", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class NetworkError extends MelonThrowable {
        public static final int $stable = 8;
        @Nullable
        private final Throwable cause;
        @Nullable
        private final Integer code;
        @NotNull
        private final String message;

        public NetworkError(@Nullable Integer integer0, @Nullable Throwable throwable0, @NotNull String s) {
            q.g(s, "message");
            super(null);
            this.code = integer0;
            this.cause = throwable0;
            this.message = s;
        }

        public NetworkError(Integer integer0, Throwable throwable0, String s, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 4) != 0) {
                s = ApiResultKt.fromResourceMessage(0x7F1303D9);  // string:error_network_connectivity "해당 페이지의 접속이 지연되고 있습니다.\n네트워크 연결 상태를 확인하거나,\n잠시 
                                                                  // 후 다시 이용해주세요."
            }
            this(integer0, throwable0, s);
        }

        @Nullable
        public final Integer component1() {
            return this.code;
        }

        @Nullable
        public final Throwable component2() {
            return this.cause;
        }

        @NotNull
        public final String component3() {
            return this.message;
        }

        @NotNull
        public final NetworkError copy(@Nullable Integer integer0, @Nullable Throwable throwable0, @NotNull String s) {
            q.g(s, "message");
            return new NetworkError(integer0, throwable0, s);
        }

        public static NetworkError copy$default(NetworkError melonThrowable$NetworkError0, Integer integer0, Throwable throwable0, String s, int v, Object object0) {
            if((v & 1) != 0) {
                integer0 = melonThrowable$NetworkError0.code;
            }
            if((v & 2) != 0) {
                throwable0 = melonThrowable$NetworkError0.cause;
            }
            if((v & 4) != 0) {
                s = melonThrowable$NetworkError0.message;
            }
            return melonThrowable$NetworkError0.copy(integer0, throwable0, s);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof NetworkError)) {
                return false;
            }
            if(!q.b(this.code, ((NetworkError)object0).code)) {
                return false;
            }
            return q.b(this.cause, ((NetworkError)object0).cause) ? q.b(this.message, ((NetworkError)object0).message) : false;
        }

        @Override  // com.melon.net.MelonThrowable
        @Nullable
        public Throwable getCause() {
            return this.cause;
        }

        @Override  // com.melon.net.MelonThrowable
        @Nullable
        public Integer getCode() {
            return this.code;
        }

        @Override  // com.melon.net.MelonThrowable
        @NotNull
        public String getMessage() {
            return this.message;
        }

        @Override
        public int hashCode() {
            int v = 0;
            int v1 = this.code == null ? 0 : this.code.hashCode();
            Throwable throwable0 = this.cause;
            if(throwable0 != null) {
                v = throwable0.hashCode();
            }
            return this.message.hashCode() + (v1 * 0x1F + v) * 0x1F;
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = new StringBuilder("NetworkError(code=");
            stringBuilder0.append(this.code);
            stringBuilder0.append(", cause=");
            stringBuilder0.append(this.cause);
            stringBuilder0.append(", message=");
            return x.m(stringBuilder0, this.message, ")");
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0002\b\n\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0015\u001A\u00020\u0003HÆ\u0003J\u0010\u0010\u0016\u001A\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0017\u001A\u00020\u0007HÆ\u0003J.\u0010\u0018\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001A\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001A\u001A\u00020\u001B2\b\u0010\u001C\u001A\u0004\u0018\u00010\u001DHÖ\u0003J\t\u0010\u001E\u001A\u00020\u0005HÖ\u0001J\t\u0010\u001F\u001A\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0018\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\n\n\u0002\u0010\u000E\u001A\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001A\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u000F\u0010\u0010R\u0016\u0010\u0011\u001A\u0004\u0018\u00010\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/melon/net/MelonThrowable$ServerError;", "Lcom/melon/net/MelonThrowable;", "response", "Lokhttp3/Response;", "code", "", "message", "", "<init>", "(Lokhttp3/Response;Ljava/lang/Integer;Ljava/lang/String;)V", "getResponse", "()Lokhttp3/Response;", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessage", "()Ljava/lang/String;", "cause", "", "getCause", "()Ljava/lang/Throwable;", "component1", "component2", "component3", "copy", "(Lokhttp3/Response;Ljava/lang/Integer;Ljava/lang/String;)Lcom/melon/net/MelonThrowable$ServerError;", "equals", "", "other", "", "hashCode", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ServerError extends MelonThrowable {
        public static final int $stable = 8;
        @Nullable
        private final Throwable cause;
        @Nullable
        private final Integer code;
        @NotNull
        private final String message;
        @NotNull
        private final Response response;

        public ServerError(@NotNull Response response0, @Nullable Integer integer0, @NotNull String s) {
            q.g(response0, "response");
            q.g(s, "message");
            super(null);
            this.response = response0;
            this.code = integer0;
            this.message = s;
        }

        public ServerError(Response response0, Integer integer0, String s, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 4) != 0) {
                s = ApiResultKt.fromResourceMessage(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
            }
            this(response0, integer0, s);
        }

        @NotNull
        public final Response component1() {
            return this.response;
        }

        @Nullable
        public final Integer component2() {
            return this.code;
        }

        @NotNull
        public final String component3() {
            return this.message;
        }

        @NotNull
        public final ServerError copy(@NotNull Response response0, @Nullable Integer integer0, @NotNull String s) {
            q.g(response0, "response");
            q.g(s, "message");
            return new ServerError(response0, integer0, s);
        }

        public static ServerError copy$default(ServerError melonThrowable$ServerError0, Response response0, Integer integer0, String s, int v, Object object0) {
            if((v & 1) != 0) {
                response0 = melonThrowable$ServerError0.response;
            }
            if((v & 2) != 0) {
                integer0 = melonThrowable$ServerError0.code;
            }
            if((v & 4) != 0) {
                s = melonThrowable$ServerError0.message;
            }
            return melonThrowable$ServerError0.copy(response0, integer0, s);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof ServerError)) {
                return false;
            }
            if(!q.b(this.response, ((ServerError)object0).response)) {
                return false;
            }
            return q.b(this.code, ((ServerError)object0).code) ? q.b(this.message, ((ServerError)object0).message) : false;
        }

        @Override  // com.melon.net.MelonThrowable
        @Nullable
        public Throwable getCause() {
            return this.cause;
        }

        @Override  // com.melon.net.MelonThrowable
        @Nullable
        public Integer getCode() {
            return this.code;
        }

        @Override  // com.melon.net.MelonThrowable
        @NotNull
        public String getMessage() {
            return this.message;
        }

        @NotNull
        public final Response getResponse() {
            return this.response;
        }

        @Override
        public int hashCode() {
            int v = this.response.hashCode();
            return this.code == null ? this.message.hashCode() + v * 961 : this.message.hashCode() + (v * 0x1F + this.code.hashCode()) * 0x1F;
        }

        @Override
        @NotNull
        public String toString() {
            StringBuilder stringBuilder0 = new StringBuilder("ServerError(response=");
            stringBuilder0.append(this.response);
            stringBuilder0.append(", code=");
            stringBuilder0.append(this.code);
            stringBuilder0.append(", message=");
            return x.m(stringBuilder0, this.message, ")");
        }
    }

    public static final int $stable = 8;

    private MelonThrowable() {
    }

    public MelonThrowable(DefaultConstructorMarker defaultConstructorMarker0) {
    }

    @Override
    @Nullable
    public abstract Throwable getCause();

    @Nullable
    public abstract Integer getCode();

    @Override
    @NotNull
    public abstract String getMessage();
}

