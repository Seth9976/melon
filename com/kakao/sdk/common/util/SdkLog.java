package com.kakao.sdk.common.util;

import Tf.p;
import com.kakao.sdk.common.KakaoSdk;
import d3.g;
import ie.j;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.r;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e;
import we.a;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0011\u0012\b\b\u0002\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\n\u001A\u00020\t2\b\u0010\u0006\u001A\u0004\u0018\u00010\u00012\u0006\u0010\b\u001A\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000BR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\fR\u001C\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u000E0\r8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u000F\u0010\u0010R\u001B\u0010\u0016\u001A\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001A\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/kakao/sdk/common/util/SdkLog;", "", "", "enabled", "<init>", "(Z)V", "logged", "Lcom/kakao/sdk/common/util/SdkLogLevel;", "logLevel", "Lie/H;", "log", "(Ljava/lang/Object;Lcom/kakao/sdk/common/util/SdkLogLevel;)V", "Z", "Ljava/util/LinkedList;", "", "logs", "Ljava/util/LinkedList;", "Ljava/text/SimpleDateFormat;", "dateFormat$delegate", "Lie/j;", "getDateFormat", "()Ljava/text/SimpleDateFormat;", "dateFormat", "Companion", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class SdkLog {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001A\u00020\b2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0001¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000B\u001A\u00020\b2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u000B\u0010\nJ\u0017\u0010\f\u001A\u00020\b2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0001¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\r\u001A\u00020\b2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0001¢\u0006\u0004\b\r\u0010\nJ\u0017\u0010\u000E\u001A\u00020\b2\b\u0010\u0007\u001A\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u000E\u0010\nJ\r\u0010\u000F\u001A\u00020\b¢\u0006\u0004\b\u000F\u0010\u0003R!\u0010\u0016\u001A\u00020\u00108FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0015\u0010\u0003\u001A\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001A\u00020\u00178\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001A"}, d2 = {"Lcom/kakao/sdk/common/util/SdkLog$Companion;", "", "<init>", "()V", "", "log", "()Ljava/lang/String;", "logged", "Lie/H;", "v", "(Ljava/lang/Object;)V", "d", "i", "w", "e", "clear", "Lcom/kakao/sdk/common/util/SdkLog;", "instance$delegate", "Lie/j;", "getInstance", "()Lcom/kakao/sdk/common/util/SdkLog;", "getInstance$annotations", "instance", "", "MAX_SIZE", "I", "common_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public final void clear() {
            this.getInstance().logs.clear();
        }

        public final void d(@Nullable Object object0) {
            this.getInstance().log(object0, SdkLogLevel.D);
        }

        public final void e(@Nullable Object object0) {
            this.getInstance().log(object0, SdkLogLevel.E);
        }

        @NotNull
        public final SdkLog getInstance() {
            return (SdkLog)SdkLog.instance$delegate.getValue();
        }

        public static void getInstance$annotations() {
        }

        public final void i(@Nullable Object object0) {
            this.getInstance().log(object0, SdkLogLevel.I);
        }

        @NotNull
        public final String log() {
            return e.h(p.c0(("\n                ==== sdk version: 2.21.4\n                ==== app version: " + KakaoSdk.INSTANCE.getApplicationContextInfo().getAppVer() + "\n            ")), je.p.q0(this.getInstance().logs, "\n", "\n", null, null, 60));
        }

        public final void v(@Nullable Object object0) {
            this.getInstance().log(object0, SdkLogLevel.V);
        }

        public final void w(@Nullable Object object0) {
            this.getInstance().log(object0, SdkLogLevel.W);
        }
    }

    @NotNull
    public static final Companion Companion = null;
    public static final int MAX_SIZE = 100;
    @NotNull
    private final j dateFormat$delegate;
    private final boolean enabled;
    @NotNull
    private static final j instance$delegate;
    @NotNull
    private LinkedList logs;

    static {
        SdkLog.Companion = new Companion(null);
        SdkLog.instance$delegate = g.Q(SdkLog.Companion.instance.2.INSTANCE);
    }

    public SdkLog() {
        this(false, 1, null);
    }

    public SdkLog(boolean z) {
        this.enabled = z;
        this.logs = new LinkedList();
        this.dateFormat$delegate = g.Q(com.kakao.sdk.common.util.SdkLog.dateFormat.2.INSTANCE);

        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001A\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/text/SimpleDateFormat;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 0x30)
        final class com.kakao.sdk.common.util.SdkLog.dateFormat.2 extends r implements a {
            public static final com.kakao.sdk.common.util.SdkLog.dateFormat.2 INSTANCE;

            static {
                com.kakao.sdk.common.util.SdkLog.dateFormat.2.INSTANCE = new com.kakao.sdk.common.util.SdkLog.dateFormat.2();
            }

            public com.kakao.sdk.common.util.SdkLog.dateFormat.2() {
                super(0);
            }

            @Override  // we.a
            public Object invoke() {
                return this.invoke();
            }

            @NotNull
            public final SimpleDateFormat invoke() {
                return new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
            }
        }

    }

    public SdkLog(boolean z, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 1) != 0) {
            z = false;
        }
        this(z);
    }

    private final SimpleDateFormat getDateFormat() {
        return (SimpleDateFormat)this.dateFormat$delegate.getValue();
    }

    @NotNull
    public static final SdkLog getInstance() {
        return SdkLog.Companion.getInstance();
    }

    @NotNull
    public static final String log() {
        return SdkLog.Companion.log();
    }

    private final void log(Object object0, SdkLogLevel sdkLogLevel0) {
        String s = sdkLogLevel0.getSymbol() + " " + object0;
        if(this.enabled && sdkLogLevel0.compareTo(SdkLogLevel.I) >= 0) {
            this.logs.add(this.getDateFormat().format(new Date()) + " " + s);
            if(this.logs.size() > 100) {
                this.logs.poll();
            }
        }
    }
}

