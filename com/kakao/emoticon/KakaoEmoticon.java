package com.kakao.emoticon;

import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.kakao.emoticon.auth.EmoticonAdapter;
import com.kakao.emoticon.auth.EmoticonConfig;
import com.kakao.emoticon.auth.IdpType;
import com.kakao.emoticon.controller.EmoticonManager;
import com.kakao.emoticon.db.DatabaseAdapter;
import com.kakao.emoticon.image.AnimatedItemImageLoader;
import com.kakao.emoticon.interfaces.EmoticonAuthListener;
import com.kakao.emoticon.model.EmoticonViewParam;
import com.kakao.emoticon.util.ActionTracker;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000E\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00C6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0007\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000B\u001A\u00020\u00062\b\u0010\n\u001A\u0004\u0018\u00010\tH\u0007\u00A2\u0006\u0004\b\u000B\u0010\fJ-\u0010\u000B\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\t2\u0014\u0010\u000F\u001A\u0010\u0012\u0004\u0012\u00020\u000E\u0012\u0004\u0012\u00020\u000E\u0018\u00010\rH\u0007\u00A2\u0006\u0004\b\u000B\u0010\u0010J\u000F\u0010\u0011\u001A\u00020\u0006H\u0007\u00A2\u0006\u0004\b\u0011\u0010\u0003J\u000F\u0010\u0012\u001A\u00020\u0006H\u0007\u00A2\u0006\u0004\b\u0012\u0010\u0003J\u000F\u0010\u0013\u001A\u0004\u0018\u00010\u000E\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0015\u001A\u0004\u0018\u00010\u000E\u00A2\u0006\u0004\b\u0015\u0010\u0014R \u0010\u0017\u001A\u00020\u00168\u0006X\u0087\u0004\u00A2\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u0012\u0004\b\u001B\u0010\u0003\u001A\u0004\b\u0019\u0010\u001AR.\u0010\u001D\u001A\u0004\u0018\u00010\u00162\b\u0010\u001C\u001A\u0004\u0018\u00010\u00168\u0006@BX\u0087\u000E\u00A2\u0006\u0012\n\u0004\b\u001D\u0010\u0018\u0012\u0004\b\u001F\u0010\u0003\u001A\u0004\b\u001E\u0010\u001AR(\u0010!\u001A\u00020 8\u0006@\u0006X\u0087\u000E\u00A2\u0006\u0018\n\u0004\b!\u0010\"\u0012\u0004\b&\u0010\u0003\u001A\u0004\b!\u0010#\"\u0004\b$\u0010%R\u0018\u0010\'\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\'\u0010(R\u001C\u0010-\u001A\u0004\u0018\u00010)8FX\u0087\u0004\u00A2\u0006\f\u0012\u0004\b,\u0010\u0003\u001A\u0004\b*\u0010+R\u001A\u0010.\u001A\u00020 8FX\u0087\u0004\u00A2\u0006\f\u0012\u0004\b/\u0010\u0003\u001A\u0004\b.\u0010#R\u001A\u00100\u001A\u00020 8FX\u0087\u0004\u00A2\u0006\f\u0012\u0004\b1\u0010\u0003\u001A\u0004\b0\u0010#R\u001A\u00106\u001A\u0002028FX\u0087\u0004\u00A2\u0006\f\u0012\u0004\b5\u0010\u0003\u001A\u0004\b3\u00104R\u001C\u00109\u001A\u0004\u0018\u00010\u000E8FX\u0087\u0004\u00A2\u0006\f\u0012\u0004\b8\u0010\u0003\u001A\u0004\b7\u0010\u0014R\u001C\u0010>\u001A\u0004\u0018\u00010:8FX\u0087\u0004\u00A2\u0006\f\u0012\u0004\b=\u0010\u0003\u001A\u0004\b;\u0010<\u00A8\u0006?"}, d2 = {"Lcom/kakao/emoticon/KakaoEmoticon;", "", "<init>", "()V", "Lcom/kakao/emoticon/auth/EmoticonAdapter;", "emoticonAdapter", "Lie/H;", "init", "(Lcom/kakao/emoticon/auth/EmoticonAdapter;)V", "Lcom/kakao/emoticon/model/EmoticonViewParam;", "emoticonViewParam", "pushLog", "(Lcom/kakao/emoticon/model/EmoticonViewParam;)V", "", "", "extraMeta", "(Lcom/kakao/emoticon/model/EmoticonViewParam;Ljava/util/Map;)V", "updateSessionState", "reloadEmoticonKeyboard", "getKAHeader", "()Ljava/lang/String;", "getAppKey", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "getMainHandler$annotations", "<set-?>", "backgroundHandler", "getBackgroundHandler", "getBackgroundHandler$annotations", "", "isSupportDecodeScale", "Z", "()Z", "setSupportDecodeScale", "(Z)V", "isSupportDecodeScale$annotations", "emoticonKakaoAdapter", "Lcom/kakao/emoticon/auth/EmoticonAdapter;", "Landroid/app/Application;", "getApplication", "()Landroid/app/Application;", "getApplication$annotations", "application", "isEnabledLoginTab", "isEnabledLoginTab$annotations", "isConnectedAccount", "isConnectedAccount$annotations", "Lcom/kakao/emoticon/auth/IdpType;", "getIdpType", "()Lcom/kakao/emoticon/auth/IdpType;", "getIdpType$annotations", "idpType", "getIdpToken", "getIdpToken$annotations", "idpToken", "Lcom/kakao/emoticon/interfaces/EmoticonAuthListener;", "getAuthListener", "()Lcom/kakao/emoticon/interfaces/EmoticonAuthListener;", "getAuthListener$annotations", "authListener", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public final class KakaoEmoticon {
    public static final KakaoEmoticon INSTANCE;
    @Nullable
    private static Handler backgroundHandler;
    private static EmoticonAdapter emoticonKakaoAdapter;
    private static boolean isSupportDecodeScale;
    @NotNull
    private static final Handler mainHandler;

    static {
        KakaoEmoticon.INSTANCE = new KakaoEmoticon();
        KakaoEmoticon.mainHandler = new Handler(Looper.getMainLooper());
        KakaoEmoticon.isSupportDecodeScale = true;
    }

    @Nullable
    public final String getAppKey() {
        EmoticonAdapter emoticonAdapter0 = KakaoEmoticon.emoticonKakaoAdapter;
        if(emoticonAdapter0 != null) {
            EmoticonConfig emoticonConfig0 = emoticonAdapter0.getEmoticonServiceConfig();
            return emoticonConfig0 == null ? null : emoticonConfig0.getAppKey();
        }
        return null;
    }

    @Nullable
    public static final Application getApplication() {
        EmoticonAdapter emoticonAdapter0 = KakaoEmoticon.emoticonKakaoAdapter;
        if(emoticonAdapter0 != null) {
            EmoticonConfig emoticonConfig0 = emoticonAdapter0.getEmoticonServiceConfig();
            if((emoticonConfig0 == null ? null : emoticonConfig0.getApplication()) != null) {
                EmoticonAdapter emoticonAdapter1 = KakaoEmoticon.emoticonKakaoAdapter;
                q.d(emoticonAdapter1);
                return emoticonAdapter1.getEmoticonServiceConfig().getApplication();
            }
        }
        throw new RuntimeException("You must call init() on your Application Class!");
    }

    public static void getApplication$annotations() {
    }

    @Nullable
    public static final EmoticonAuthListener getAuthListener() {
        EmoticonAdapter emoticonAdapter0 = KakaoEmoticon.emoticonKakaoAdapter;
        if(emoticonAdapter0 != null) {
            EmoticonConfig emoticonConfig0 = emoticonAdapter0.getEmoticonServiceConfig();
            return emoticonConfig0 == null ? null : emoticonConfig0.getEmoticonAuthListener();
        }
        return null;
    }

    public static void getAuthListener$annotations() {
    }

    @Nullable
    public static final Handler getBackgroundHandler() {
        return KakaoEmoticon.backgroundHandler;
    }

    public static void getBackgroundHandler$annotations() {
    }

    @Nullable
    public static final String getIdpToken() {
        EmoticonAdapter emoticonAdapter0 = KakaoEmoticon.emoticonKakaoAdapter;
        if(emoticonAdapter0 != null) {
            EmoticonConfig emoticonConfig0 = emoticonAdapter0.getEmoticonServiceConfig();
            return emoticonConfig0 == null ? null : emoticonConfig0.getIdpToken();
        }
        return null;
    }

    public static void getIdpToken$annotations() {
    }

    @NotNull
    public static final IdpType getIdpType() {
        EmoticonAdapter emoticonAdapter0 = KakaoEmoticon.emoticonKakaoAdapter;
        q.d(emoticonAdapter0);
        return emoticonAdapter0.getEmoticonServiceConfig().getIdpType();
    }

    public static void getIdpType$annotations() {
    }

    @Nullable
    public final String getKAHeader() {
        EmoticonAdapter emoticonAdapter0 = KakaoEmoticon.emoticonKakaoAdapter;
        if(emoticonAdapter0 != null) {
            EmoticonConfig emoticonConfig0 = emoticonAdapter0.getEmoticonServiceConfig();
            return emoticonConfig0 == null ? null : emoticonConfig0.getKaHeader();
        }
        return null;
    }

    @NotNull
    public static final Handler getMainHandler() {
        return KakaoEmoticon.mainHandler;
    }

    public static void getMainHandler$annotations() {
    }

    public static final void init(@Nullable EmoticonAdapter emoticonAdapter0) {
        synchronized(KakaoEmoticon.class) {
            if(emoticonAdapter0 != null) {
                KakaoEmoticon.emoticonKakaoAdapter = emoticonAdapter0;
                AnimatedItemImageLoader.INSTANCE.resetMemoryCache();
                HandlerThread handlerThread0 = new HandlerThread("BackgroundHandlerThread");
                handlerThread0.start();
                KakaoEmoticon.backgroundHandler = new Handler(handlerThread0.getLooper());
                DatabaseAdapter.getInstance();
                ActionTracker.INSTANCE.sendLog();
                return;
            }
        }
        throw new RuntimeException("EmoticonAdapter Can\'t be null!");
    }

    public static final boolean isConnectedAccount() {
        boolean z = false;
        synchronized(KakaoEmoticon.class) {
            if(KakaoEmoticon.emoticonKakaoAdapter != null && KakaoEmoticon.emoticonKakaoAdapter.getEmoticonServiceConfig().getIdpToken() != null) {
                z = true;
            }
            return z;
        }
    }

    public static void isConnectedAccount$annotations() {
    }

    public static final boolean isEnabledLoginTab() {
        EmoticonAdapter emoticonAdapter0 = KakaoEmoticon.emoticonKakaoAdapter;
        q.d(emoticonAdapter0);
        return emoticonAdapter0.getEmoticonServiceConfig().enableLoginTab();
    }

    public static void isEnabledLoginTab$annotations() {
    }

    public static final boolean isSupportDecodeScale() [...] // 潜在的解密器

    public static void isSupportDecodeScale$annotations() {
    }

    public static final void pushLog(@Nullable EmoticonViewParam emoticonViewParam0) {
        if(emoticonViewParam0 != null) {
            ActionTracker.INSTANCE.pushLog(emoticonViewParam0, null);
        }
    }

    public static final void pushLog(@NotNull EmoticonViewParam emoticonViewParam0, @Nullable Map map0) {
        q.g(emoticonViewParam0, "emoticonViewParam");
        ActionTracker.INSTANCE.pushLog(emoticonViewParam0, map0);
    }

    public static final void reloadEmoticonKeyboard() {
        EmoticonManager.INSTANCE.setNeedSyncKeyboard(true);
    }

    public static final void setSupportDecodeScale(boolean z) {
        KakaoEmoticon.isSupportDecodeScale = z;
    }

    public static final void updateSessionState() {
        EmoticonManager.INSTANCE.updateSessionState();
    }
}

