package com.iloen.melon.utils.system;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.widget.Toast;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.log.LogU;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import k8.Y;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001J/\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0016\u0010\u0005\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\t\u001A\u00020\u00062\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0007¢\u0006\u0004\b\t\u0010\rJ\u0017\u0010\u000E\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\u000E\u0010\nJ\u0019\u0010\u000E\u001A\u00020\u00062\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0007¢\u0006\u0004\b\u000E\u0010\rJ\u0019\u0010\u000F\u001A\u00020\u00062\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0007¢\u0006\u0004\b\u000F\u0010\rJ-\u0010\u0010\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0016\u0010\u0005\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0004\"\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0010\u0010\bR\u0014\u0010\u0012\u001A\u00020\u00118\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/utils/system/ToastManager;", "", "", "resId", "", "formatArgs", "Lie/H;", "showFormatted", "(I[Ljava/lang/Object;)V", "show", "(I)V", "", "text", "(Ljava/lang/CharSequence;)V", "showShort", "debug", "showFormattedShort", "", "MIN_TOAST_INTERVAL_MILLIS", "J", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ToastManager {
    public static final int $stable = 0;
    @NotNull
    public static final ToastManager INSTANCE = null;
    public static final long MIN_TOAST_INTERVAL_MILLIS = 300L;
    public static WeakReference a;
    public static long b;
    public static final Mutex c;
    public static final CoroutineScope d;

    static {
        ToastManager.INSTANCE = new ToastManager();  // 初始化器: Ljava/lang/Object;-><init>()V
        ToastManager.c = MutexKt.Mutex$default(false, 1, null);
        ToastManager.special..inlined.CoroutineExceptionHandler.1 toastManager$special$$inlined$CoroutineExceptionHandler$10 = new ToastManager.special..inlined.CoroutineExceptionHandler.1(CoroutineExceptionHandler.Key);
        ToastManager.d = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default(null, 1, null)).plus(toastManager$special$$inlined$CoroutineExceptionHandler$10));
        ToastManager.$stable = 8;
    }

    public static SpannableStringBuilder a(CharSequence charSequence0) {
        SpannableStringBuilder spannableStringBuilder0 = new SpannableStringBuilder(charSequence0);
        int v = spannableStringBuilder0.length();
        for(int v1 = 0; v1 < v; ++v1) {
            if(spannableStringBuilder0.charAt(v1) == 10) {
                spannableStringBuilder0.replace(v1, v1 + 1, " ");
            }
        }
        return spannableStringBuilder0;
    }

    public static final long access$getElapsedTime(ToastManager toastManager0) {
        toastManager0.getClass();
        return System.currentTimeMillis() - ToastManager.b;
    }

    public static final void access$makeToast(ToastManager toastManager0, CharSequence charSequence0, int v) {
        synchronized(toastManager0) {
            try {
                WeakReference weakReference0 = ToastManager.a;
                if(weakReference0 != null) {
                    Toast toast0 = (Toast)weakReference0.get();
                    if(toast0 != null) {
                        toast0.cancel();
                    }
                    ToastManager.a = null;
                }
                CharSequence charSequence1 = ToastManager.a(charSequence0);
                MelonAppBase.Companion.getClass();
                Toast toast1 = Toast.makeText(t.a().getContext(), charSequence1, v);
                toast1.show();
                ToastManager.b = System.currentTimeMillis();
                ToastManager.a = new WeakReference(toast1);
                return;
            }
            catch(IllegalStateException illegalStateException0) {
            }
            catch(NullPointerException nullPointerException0) {
                LogU.Companion.e("ToastManager", "makeToast() error:" + nullPointerException0 + ", text:" + charSequence0);
                return;
            }
        }
        LogU.Companion.e("ToastManager", "makeToast() error:" + illegalStateException0 + ", text:" + charSequence0);
    }

    public final void b(CharSequence charSequence0, int v) {
        synchronized(this) {
            if(charSequence0 != null && charSequence0.length() != 0) {
                ToastManager.postToast.1 toastManager$postToast$10 = new ToastManager.postToast.1(charSequence0, v, null);
                BuildersKt__Builders_commonKt.launch$default(ToastManager.d, null, null, toastManager$postToast$10, 3, null);
            }
        }
    }

    public static final void debug(@Nullable CharSequence charSequence0) {
    }

    public static final void show(int v) {
        Context context0 = Y.a(MelonAppBase.Companion);
        if(context0 == null) {
            return;
        }
        CharSequence charSequence0 = context0.getText(v);
        ToastManager.INSTANCE.b(charSequence0, 1);
    }

    public static final void show(@Nullable CharSequence charSequence0) {
        ToastManager.INSTANCE.b(charSequence0, 1);
    }

    public static final void showFormatted(int v, @NotNull Object[] arr_object) {
        q.g(arr_object, "formatArgs");
        Context context0 = Y.a(MelonAppBase.Companion);
        if(context0 == null) {
            return;
        }
        String s = context0.getString(v);
        q.f(s, "getString(...)");
        Object[] arr_object1 = Arrays.copyOf(arr_object, arr_object.length);
        ToastManager.show(String.format(s, Arrays.copyOf(arr_object1, arr_object1.length)));
    }

    public final void showFormattedShort(int v, @NotNull Object[] arr_object) {
        q.g(arr_object, "formatArgs");
        Context context0 = Y.a(MelonAppBase.Companion);
        if(context0 == null) {
            return;
        }
        String s = context0.getString(v);
        q.f(s, "getString(...)");
        Object[] arr_object1 = Arrays.copyOf(arr_object, arr_object.length);
        this.b(String.format(s, Arrays.copyOf(arr_object1, arr_object1.length)), 0);
    }

    public static final void showShort(int v) {
        Context context0 = Y.a(MelonAppBase.Companion);
        if(context0 == null) {
            return;
        }
        CharSequence charSequence0 = context0.getText(v);
        ToastManager.INSTANCE.b(charSequence0, 0);
    }

    public static final void showShort(@Nullable CharSequence charSequence0) {
        ToastManager.INSTANCE.b(charSequence0, 0);
    }
}

