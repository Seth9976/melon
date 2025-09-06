package com.facebook.internal;

import Tf.v;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 +2\u00020\u0001:\u0001+B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000B\u001A\u00020\u0004¢\u0006\u0004\b\u000B\u0010\fJ\r\u0010\u000E\u001A\u00020\r¢\u0006\u0004\b\u000E\u0010\u000FJ\u0015\u0010\u0011\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0016\u001A\u00020\r2\n\u0010\u0015\u001A\u00060\u0013j\u0002`\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0016\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0012J)\u0010\u0016\u001A\u00020\r2\u0006\u0010\u0018\u001A\u00020\u00042\u0012\u0010\u001A\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0019\"\u00020\u0001¢\u0006\u0004\b\u0016\u0010\u001BJ\u001D\u0010\u001E\u001A\u00020\r2\u0006\u0010\u001C\u001A\u00020\u00042\u0006\u0010\u001D\u001A\u00020\u0001¢\u0006\u0004\b\u001E\u0010\u001FR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010 R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010!R\u001A\u0010\"\u001A\u00060\u0013j\u0002`\u00148\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\"\u0010#R*\u0010%\u001A\u00020$2\u0006\u0010\u001D\u001A\u00020$8\u0006@FX\u0086\u000E¢\u0006\u0012\n\u0004\b%\u0010&\u001A\u0004\b\'\u0010(\"\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lcom/facebook/internal/Logger;", "", "Lcom/facebook/LoggingBehavior;", "behavior", "", "tag", "<init>", "(Lcom/facebook/LoggingBehavior;Ljava/lang/String;)V", "", "shouldLog", "()Z", "getContents", "()Ljava/lang/String;", "Lie/H;", "log", "()V", "string", "logString", "(Ljava/lang/String;)V", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "stringBuilder", "append", "(Ljava/lang/StringBuilder;)V", "format", "", "args", "(Ljava/lang/String;[Ljava/lang/Object;)V", "key", "value", "appendKeyValue", "(Ljava/lang/String;Ljava/lang/Object;)V", "Lcom/facebook/LoggingBehavior;", "Ljava/lang/String;", "contents", "Ljava/lang/StringBuilder;", "", "priority", "I", "getPriority", "()I", "setPriority", "(I)V", "Companion", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class Logger {
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001F\u0010\u000B\u001A\u00020\n2\u0006\u0010\b\u001A\u00020\u00042\u0006\u0010\t\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\u000E\u001A\u00020\n2\u0006\u0010\r\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u000E\u0010\u000FJ\'\u0010\u0013\u001A\u00020\n2\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J;\u0010\u0013\u001A\u00020\n2\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\u00042\u0006\u0010\u0015\u001A\u00020\u00042\u0012\u0010\u0017\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0016\"\u00020\u0001H\u0007¢\u0006\u0004\b\u0013\u0010\u0018JC\u0010\u0013\u001A\u00020\n2\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u0012\u001A\u00020\u00042\u0006\u0010\u0015\u001A\u00020\u00042\u0012\u0010\u0017\u001A\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0016\"\u00020\u0001H\u0007¢\u0006\u0004\b\u0013\u0010\u001BJ/\u0010\u0013\u001A\u00020\n2\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u0012\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0013\u0010\u001CR\u0014\u0010\u001D\u001A\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001D\u0010\u001ER0\u0010!\u001A\u001E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001Fj\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004` 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/facebook/internal/Logger$Companion;", "", "<init>", "()V", "", "string", "replaceStrings", "(Ljava/lang/String;)Ljava/lang/String;", "original", "replace", "Lie/H;", "registerStringToReplace", "(Ljava/lang/String;Ljava/lang/String;)V", "accessToken", "registerAccessToken", "(Ljava/lang/String;)V", "Lcom/facebook/LoggingBehavior;", "behavior", "tag", "log", "(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;)V", "format", "", "args", "(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "", "priority", "(Lcom/facebook/LoggingBehavior;ILjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "(Lcom/facebook/LoggingBehavior;ILjava/lang/String;Ljava/lang/String;)V", "LOG_TAG_BASE", "Ljava/lang/String;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "stringsToReplace", "Ljava/util/HashMap;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public static final String access$replaceStrings(Companion logger$Companion0, String s) {
            return logger$Companion0.replaceStrings(s);
        }

        public final void log(@NotNull LoggingBehavior loggingBehavior0, int v, @NotNull String s, @NotNull String s1) {
            q.g(loggingBehavior0, "behavior");
            q.g(s, "tag");
            q.g(s1, "string");
            if(FacebookSdk.isLoggingBehaviorEnabled(loggingBehavior0)) {
                String s2 = this.replaceStrings(s1);
                if(!v.r0(s, "FacebookSDK.", false)) {
                    s = "FacebookSDK." + s;
                }
                Log.println(v, s, s2);
                if(loggingBehavior0 == LoggingBehavior.DEVELOPER_ERRORS) {
                    new Exception().printStackTrace();
                }
            }
        }

        public final void log(@NotNull LoggingBehavior loggingBehavior0, int v, @NotNull String s, @NotNull String s1, @NotNull Object[] arr_object) {
            q.g(loggingBehavior0, "behavior");
            q.g(s, "tag");
            q.g(s1, "format");
            q.g(arr_object, "args");
            if(FacebookSdk.isLoggingBehaviorEnabled(loggingBehavior0)) {
                Object[] arr_object1 = Arrays.copyOf(arr_object, arr_object.length);
                this.log(loggingBehavior0, v, s, String.format(s1, Arrays.copyOf(arr_object1, arr_object1.length)));
            }
        }

        public final void log(@NotNull LoggingBehavior loggingBehavior0, @NotNull String s, @NotNull String s1) {
            q.g(loggingBehavior0, "behavior");
            q.g(s, "tag");
            q.g(s1, "string");
            this.log(loggingBehavior0, 3, s, s1);
        }

        public final void log(@NotNull LoggingBehavior loggingBehavior0, @NotNull String s, @NotNull String s1, @NotNull Object[] arr_object) {
            q.g(loggingBehavior0, "behavior");
            q.g(s, "tag");
            q.g(s1, "format");
            q.g(arr_object, "args");
            if(FacebookSdk.isLoggingBehaviorEnabled(loggingBehavior0)) {
                Object[] arr_object1 = Arrays.copyOf(arr_object, arr_object.length);
                this.log(loggingBehavior0, 3, s, String.format(s1, Arrays.copyOf(arr_object1, arr_object1.length)));
            }
        }

        public final void registerAccessToken(@NotNull String s) {
            synchronized(this) {
                q.g(s, "accessToken");
                if(!FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.INCLUDE_ACCESS_TOKENS)) {
                    this.registerStringToReplace(s, "ACCESS_TOKEN_REMOVED");
                }
            }
        }

        public final void registerStringToReplace(@NotNull String s, @NotNull String s1) {
            synchronized(this) {
                q.g(s, "original");
                q.g(s1, "replace");
                Logger.stringsToReplace.put(s, s1);
            }
        }

        private final String replaceStrings(String s) {
            synchronized(this) {
                for(Object object0: Logger.stringsToReplace.entrySet()) {
                    s = v.p0(s, ((String)((Map.Entry)object0).getKey()), ((String)((Map.Entry)object0).getValue()));
                }
                return s;
            }
        }
    }

    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String LOG_TAG_BASE = "FacebookSDK.";
    @NotNull
    private final LoggingBehavior behavior;
    @NotNull
    private StringBuilder contents;
    private int priority;
    @NotNull
    private static final HashMap stringsToReplace;
    @NotNull
    private final String tag;

    static {
        Logger.Companion = new Companion(null);
        Logger.stringsToReplace = new HashMap();
    }

    public Logger(@NotNull LoggingBehavior loggingBehavior0, @NotNull String s) {
        q.g(loggingBehavior0, "behavior");
        q.g(s, "tag");
        super();
        this.priority = 3;
        this.behavior = loggingBehavior0;
        this.tag = "FacebookSDK." + Validate.notNullOrEmpty(s, "tag");
        this.contents = new StringBuilder();
    }

    public final void append(@NotNull String s) {
        q.g(s, "string");
        if(this.shouldLog()) {
            this.contents.append(s);
        }
    }

    public final void append(@NotNull String s, @NotNull Object[] arr_object) {
        q.g(s, "format");
        q.g(arr_object, "args");
        if(this.shouldLog()) {
            StringBuilder stringBuilder0 = this.contents;
            Object[] arr_object1 = Arrays.copyOf(arr_object, arr_object.length);
            stringBuilder0.append(String.format(s, Arrays.copyOf(arr_object1, arr_object1.length)));
        }
    }

    public final void append(@NotNull StringBuilder stringBuilder0) {
        q.g(stringBuilder0, "stringBuilder");
        if(this.shouldLog()) {
            this.contents.append(stringBuilder0);
        }
    }

    public final void appendKeyValue(@NotNull String s, @NotNull Object object0) {
        q.g(s, "key");
        q.g(object0, "value");
        this.append("  %s:\t%s\n", new Object[]{s, object0});
    }

    @NotNull
    public final String getContents() {
        String s = this.contents.toString();
        q.f(s, "contents.toString()");
        return Companion.access$replaceStrings(Logger.Companion, s);
    }

    public final int getPriority() {
        return this.priority;
    }

    public static final void log(@NotNull LoggingBehavior loggingBehavior0, int v, @NotNull String s, @NotNull String s1) {
        Logger.Companion.log(loggingBehavior0, v, s, s1);
    }

    public static final void log(@NotNull LoggingBehavior loggingBehavior0, int v, @NotNull String s, @NotNull String s1, @NotNull Object[] arr_object) {
        Logger.Companion.log(loggingBehavior0, v, s, s1, arr_object);
    }

    public static final void log(@NotNull LoggingBehavior loggingBehavior0, @NotNull String s, @NotNull String s1) {
        Logger.Companion.log(loggingBehavior0, s, s1);
    }

    public static final void log(@NotNull LoggingBehavior loggingBehavior0, @NotNull String s, @NotNull String s1, @NotNull Object[] arr_object) {
        Logger.Companion.log(loggingBehavior0, s, s1, arr_object);
    }

    public final void log() {
        String s = this.contents.toString();
        q.f(s, "contents.toString()");
        this.logString(s);
        this.contents = new StringBuilder();
    }

    public final void logString(@NotNull String s) {
        q.g(s, "string");
        Logger.Companion.log(this.behavior, this.priority, this.tag, s);
    }

    public static final void registerAccessToken(@NotNull String s) {
        synchronized(Logger.class) {
            Logger.Companion.registerAccessToken(s);
        }
    }

    public static final void registerStringToReplace(@NotNull String s, @NotNull String s1) {
        synchronized(Logger.class) {
            Logger.Companion.registerStringToReplace(s, s1);
        }
    }

    public final void setPriority(int v) {
        Validate.oneOf(v, "value", new Object[]{7, 3, 6, 4, 2, 5});
        this.setPriority(v);
    }

    private final boolean shouldLog() {
        return FacebookSdk.isLoggingBehaviorEnabled(this.behavior);
    }
}

