package com.facebook.internal;

import android.content.Intent;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0003\u0017\u0016\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001D\u0010\t\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000B\u001A\u00020\b2\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u000B\u0010\fJ)\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\r\u001A\u00020\u00042\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R \u0010\u0014\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/facebook/internal/CallbackManagerImpl;", "Lcom/facebook/CallbackManager;", "<init>", "()V", "", "requestCode", "Lcom/facebook/internal/CallbackManagerImpl$Callback;", "callback", "Lie/H;", "registerCallback", "(ILcom/facebook/internal/CallbackManagerImpl$Callback;)V", "unregisterCallback", "(I)V", "resultCode", "Landroid/content/Intent;", "data", "", "onActivityResult", "(IILandroid/content/Intent;)Z", "", "callbacks", "Ljava/util/Map;", "Companion", "Callback", "RequestCodeOffset", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class CallbackManagerImpl implements CallbackManager {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001A\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/facebook/internal/CallbackManagerImpl$Callback;", "", "onActivityResult", "", "resultCode", "", "data", "Landroid/content/Intent;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public interface Callback {
        boolean onActivityResult(int arg1, @Nullable Intent arg2);
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0003¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\r\u001A\u00020\f2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\t\u001A\u00020\u00042\b\u0010\u000B\u001A\u0004\u0018\u00010\nH\u0003¢\u0006\u0004\b\r\u0010\u000EJ\u001F\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u0006H\u0007¢\u0006\u0004\b\u0011\u0010\u0012R \u0010\u0014\u001A\u000E\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/facebook/internal/CallbackManagerImpl$Companion;", "", "<init>", "()V", "", "requestCode", "Lcom/facebook/internal/CallbackManagerImpl$Callback;", "getStaticCallback", "(I)Lcom/facebook/internal/CallbackManagerImpl$Callback;", "resultCode", "Landroid/content/Intent;", "data", "", "runStaticCallback", "(IILandroid/content/Intent;)Z", "callback", "Lie/H;", "registerStaticCallback", "(ILcom/facebook/internal/CallbackManagerImpl$Callback;)V", "", "staticCallbacks", "Ljava/util/Map;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public static final Callback access$getStaticCallback(Companion callbackManagerImpl$Companion0, int v) {
            return callbackManagerImpl$Companion0.getStaticCallback(v);
        }

        public static final boolean access$runStaticCallback(Companion callbackManagerImpl$Companion0, int v, int v1, Intent intent0) {
            return callbackManagerImpl$Companion0.runStaticCallback(v, v1, intent0);
        }

        private final Callback getStaticCallback(int v) {
            synchronized(this) {
                return (Callback)CallbackManagerImpl.staticCallbacks.get(v);
            }
        }

        public final void registerStaticCallback(int v, @NotNull Callback callbackManagerImpl$Callback0) {
            synchronized(this) {
                q.g(callbackManagerImpl$Callback0, "callback");
                if(CallbackManagerImpl.staticCallbacks.containsKey(v)) {
                    return;
                }
                CallbackManagerImpl.staticCallbacks.put(v, callbackManagerImpl$Callback0);
            }
        }

        private final boolean runStaticCallback(int v, int v1, Intent intent0) {
            Callback callbackManagerImpl$Callback0 = this.getStaticCallback(v);
            return callbackManagerImpl$Callback0 == null ? false : callbackManagerImpl$Callback0.onActivityResult(v1, intent0);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000F\b\u0002\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001A\u00020\u0003R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000Bj\u0002\b\fj\u0002\b\rj\u0002\b\u000Ej\u0002\b\u000Fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/facebook/internal/CallbackManagerImpl$RequestCodeOffset;", "", "offset", "", "(Ljava/lang/String;II)V", "toRequestCode", "Login", "Share", "Message", "Like", "GameRequest", "AppGroupCreate", "AppGroupJoin", "AppInvite", "DeviceShare", "GamingFriendFinder", "GamingGroupIntegration", "Referral", "GamingContextCreate", "GamingContextSwitch", "GamingContextChoose", "TournamentShareDialog", "TournamentJoinDialog", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static enum RequestCodeOffset {
        Login(0),
        Share(1),
        Message(2),
        Like(3),
        GameRequest(4),
        AppGroupCreate(5),
        AppGroupJoin(6),
        AppInvite(7),
        DeviceShare(8),
        GamingFriendFinder(9),
        GamingGroupIntegration(10),
        Referral(11),
        GamingContextCreate(12),
        GamingContextSwitch(13),
        GamingContextChoose(14),
        TournamentShareDialog(15),
        TournamentJoinDialog(16);

        private final int offset;

        private static final RequestCodeOffset[] $values() [...] // Inlined contents

        private RequestCodeOffset(int v1) {
            this.offset = v1;
        }

        public final int toRequestCode() {
            return FacebookSdk.getCallbackRequestCodeOffset() + this.offset;
        }
    }

    @NotNull
    public static final Companion Companion;
    @NotNull
    private final Map callbacks;
    @NotNull
    private static final Map staticCallbacks;

    static {
        CallbackManagerImpl.Companion = new Companion(null);
        CallbackManagerImpl.staticCallbacks = new HashMap();
    }

    public CallbackManagerImpl() {
        this.callbacks = new HashMap();
    }

    private static final Callback getStaticCallback(int v) {
        synchronized(CallbackManagerImpl.class) {
            return Companion.access$getStaticCallback(CallbackManagerImpl.Companion, v);
        }
    }

    @Override  // com.facebook.CallbackManager
    public boolean onActivityResult(int v, int v1, @Nullable Intent intent0) {
        Callback callbackManagerImpl$Callback0 = (Callback)this.callbacks.get(v);
        return callbackManagerImpl$Callback0 == null ? Companion.access$runStaticCallback(CallbackManagerImpl.Companion, v, v1, intent0) : callbackManagerImpl$Callback0.onActivityResult(v1, intent0);
    }

    public final void registerCallback(int v, @NotNull Callback callbackManagerImpl$Callback0) {
        q.g(callbackManagerImpl$Callback0, "callback");
        this.callbacks.put(v, callbackManagerImpl$Callback0);
    }

    public static final void registerStaticCallback(int v, @NotNull Callback callbackManagerImpl$Callback0) {
        synchronized(CallbackManagerImpl.class) {
            CallbackManagerImpl.Companion.registerStaticCallback(v, callbackManagerImpl$Callback0);
        }
    }

    private static final boolean runStaticCallback(int v, int v1, Intent intent0) {
        return Companion.access$runStaticCallback(CallbackManagerImpl.Companion, v, v1, intent0);
    }

    public final void unregisterCallback(int v) {
        this.callbacks.remove(v);
    }
}

