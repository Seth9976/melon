package com.facebook.appevents.codeless.internal;

import android.util.Log;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0005\u001A\u0006\u0012\u0002\b\u00030\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\f\u001A\u00020\u000B2\b\u0010\b\u001A\u0004\u0018\u00010\u00072\b\u0010\t\u001A\u0004\u0018\u00010\u00072\b\u0010\n\u001A\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000E\u001A\u00020\u000BH\u0007¢\u0006\u0004\b\u000E\u0010\u0003J\u0019\u0010\u0010\u001A\u00020\u000B2\b\u0010\u000F\u001A\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u001C\u0010\u0013\u001A\n \u0012*\u0004\u0018\u00010\u00070\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001A\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001A\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0017\u001A\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0014R\u0014\u0010\u0018\u001A\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0014\u0010\u0019\u001A\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0014R\u001A\u0010\u001A\u001A\u0006\u0012\u0002\b\u00030\u00048\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001A\u0010\u001B¨\u0006\u001C"}, d2 = {"Lcom/facebook/appevents/codeless/internal/UnityReflection;", "", "<init>", "()V", "Ljava/lang/Class;", "getUnityPlayerClass", "()Ljava/lang/Class;", "", "unityObject", "unityMethod", "message", "Lie/H;", "sendMessage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "captureViewHierarchy", "eventMapping", "sendEventMapping", "(Ljava/lang/String;)V", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "UNITY_PLAYER_CLASS", "UNITY_SEND_MESSAGE_METHOD", "FB_UNITY_GAME_OBJECT", "CAPTURE_VIEW_HIERARCHY_METHOD", "EVENT_MAPPING_METHOD", "unityPlayer", "Ljava/lang/Class;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class UnityReflection {
    @NotNull
    private static final String CAPTURE_VIEW_HIERARCHY_METHOD = "CaptureViewHierarchy";
    @NotNull
    private static final String EVENT_MAPPING_METHOD = "OnReceiveMapping";
    @NotNull
    private static final String FB_UNITY_GAME_OBJECT = "UnityFacebookSDKPlugin";
    @NotNull
    public static final UnityReflection INSTANCE = null;
    private static final String TAG = null;
    @NotNull
    private static final String UNITY_PLAYER_CLASS = "com.unity3d.player.UnityPlayer";
    @NotNull
    private static final String UNITY_SEND_MESSAGE_METHOD = "UnitySendMessage";
    private static Class unityPlayer;

    static {
        UnityReflection.INSTANCE = new UnityReflection();
        UnityReflection.TAG = UnityReflection.class.getCanonicalName();
    }

    public static final void captureViewHierarchy() {
        UnityReflection.sendMessage("UnityFacebookSDKPlugin", "CaptureViewHierarchy", "");
    }

    private final Class getUnityPlayerClass() {
        return Class.forName("com.unity3d.player.UnityPlayer");
    }

    public static final void sendEventMapping(@Nullable String s) {
        UnityReflection.sendMessage("UnityFacebookSDKPlugin", "OnReceiveMapping", s);
    }

    public static final void sendMessage(@Nullable String s, @Nullable String s1, @Nullable String s2) {
        try {
            Class class0 = String.class;
            if(UnityReflection.unityPlayer == null) {
                UnityReflection.unityPlayer = UnityReflection.INSTANCE.getUnityPlayerClass();
            }
            Class class1 = UnityReflection.unityPlayer;
            if(class1 != null) {
                Method method0 = class1.getMethod("UnitySendMessage", class0, class0, class0);
                Class class2 = UnityReflection.unityPlayer;
                if(class2 != null) {
                    method0.invoke(class2, s, s1, s2);
                    return;
                }
                q.m("unityPlayer");
                throw null;
            }
            q.m("unityPlayer");
            throw null;
        }
        catch(Exception exception0) {
            Log.e(UnityReflection.TAG, "Failed to send message to Unity", exception0);
        }
    }
}

