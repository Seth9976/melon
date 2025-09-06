package com.kakao.emoticon.util;

import Tf.v;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000B\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u001F\u0010\u0007\u001A\u00020\u00062\u000E\u0010\u0007\u001A\n\u0018\u00010\tj\u0004\u0018\u0001`\nH\u0007¢\u0006\u0004\b\u0007\u0010\u000BJ)\u0010\u0007\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u00042\u000E\u0010\u0007\u001A\n\u0018\u00010\tj\u0004\u0018\u0001`\nH\u0007¢\u0006\u0004\b\u0007\u0010\fJ\u0019\u0010\r\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\r\u0010\bJ\u001F\u0010\r\u001A\u00020\u00062\u000E\u0010\u0007\u001A\n\u0018\u00010\tj\u0004\u0018\u0001`\nH\u0007¢\u0006\u0004\b\r\u0010\u000BJ\u0019\u0010\u000E\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u000E\u0010\bJ\u0019\u0010\u000F\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u000F\u0010\bJ\u0019\u0010\u0010\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0010\u0010\bJ\u0019\u0010\u0011\u001A\u00020\u00042\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001A\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/kakao/emoticon/util/Logger;", "", "<init>", "()V", "", "message", "Lie/H;", "e", "(Ljava/lang/String;)V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/Exception;)V", "(Ljava/lang/String;Ljava/lang/Exception;)V", "w", "i", "d", "v", "buildLogMsg", "(Ljava/lang/String;)Ljava/lang/String;", "TAG", "Ljava/lang/String;", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public final class Logger {
    public static final Logger INSTANCE = null;
    private static final String TAG = "EmoticonSDK";

    static {
        Logger.INSTANCE = new Logger();
    }

    private final String buildLogMsg(String s) {
        Thread thread0 = Thread.currentThread();
        q.f(thread0, "Thread.currentThread()");
        StackTraceElement stackTraceElement0 = thread0.getStackTrace()[4];
        q.f(stackTraceElement0, "ste");
        String s1 = stackTraceElement0.getFileName();
        q.f(s1, "ste.fileName");
        String s2 = "[" + v.p0(s1, ".java", "") + "::" + stackTraceElement0.getMethodName() + "]" + s;
        q.f(s2, "sb.toString()");
        return s2;
    }

    public static final void d(@Nullable String s) {
    }

    public static final void e(@Nullable Exception exception0) {
    }

    public static final void e(@Nullable String s) {
    }

    public static final void e(@Nullable String s, @Nullable Exception exception0) {
    }

    public static final void i(@Nullable String s) {
    }

    public static final void v(@Nullable String s) {
    }

    public static final void w(@Nullable Exception exception0) {
    }

    public static final void w(@Nullable String s) {
    }
}

