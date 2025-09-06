package v2;

import Z1.a;
import a7.b;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.view.inputmethod.EditorInfo;
import androidx.collection.g;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import y8.s;

public final class h {
    public final ReentrantReadWriteLock a;
    public final g b;
    public volatile int c;
    public final Handler d;
    public final b e;
    public final v2.g f;
    public final e3.h g;
    public final int h;
    public final c i;
    public static final Object j;
    public static volatile h k;

    static {
        h.j = new Object();
    }

    public h(o o0) {
        ReentrantReadWriteLock reentrantReadWriteLock0 = new ReentrantReadWriteLock();
        this.a = reentrantReadWriteLock0;
        this.c = 3;
        v2.g g0 = o0.a;
        this.f = g0;
        int v = o0.b;
        this.h = v;
        this.i = o0.c;
        this.d = new Handler(Looper.getMainLooper());
        this.b = new g(0);
        this.g = new e3.h();  // 初始化器: Ljava/lang/Object;-><init>()V
        b b0 = new b(this);
        this.e = b0;
        reentrantReadWriteLock0.writeLock().lock();
        if(v == 0) {
            this.c = 0;
        }
        reentrantReadWriteLock0.writeLock().unlock();
        if(this.c() == 0) {
            try {
                g0.a(new d(b0));
            }
            catch(Throwable throwable0) {
                this.f(throwable0);
            }
        }
    }

    public static h a() {
        synchronized(h.j) {
            h h0 = h.k;
            Q1.c.p("EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK\'s manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.", h0 != null);
            return h0;
        }
    }

    public final int b(CharSequence charSequence0, int v) {
        Q1.c.p("Not initialized yet", this.c() == 1);
        Q1.c.o(charSequence0, "charSequence cannot be null");
        s s0 = (s)this.e.b;
        s0.getClass();
        if(v >= 0 && v < charSequence0.length()) {
            if(charSequence0 instanceof Spanned) {
                t[] arr_t = (t[])((Spanned)charSequence0).getSpans(v, v + 1, t.class);
                return arr_t.length <= 0 ? ((m)s0.t(charSequence0, Math.max(0, v - 16), Math.min(charSequence0.length(), v + 16), 0x7FFFFFFF, true, new m(v))).b : ((Spanned)charSequence0).getSpanStart(arr_t[0]);
            }
            return ((m)s0.t(charSequence0, Math.max(0, v - 16), Math.min(charSequence0.length(), v + 16), 0x7FFFFFFF, true, new m(v))).b;
        }
        return -1;
    }

    public final int c() {
        this.a.readLock().lock();
        int v = this.c;
        this.a.readLock().unlock();
        return v;
    }

    public static boolean d() [...] // 潜在的解密器

    public final void e() {
        Q1.c.p("Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading", this.h == 1);
        if(this.c() == 1) {
            return;
        }
        this.a.writeLock().lock();
        if(this.c == 0) {
            this.a.writeLock().unlock();
            return;
        }
        this.c = 0;
        this.a.writeLock().unlock();
        h h0 = (h)this.e.a;
        try {
            d d0 = new d(this.e);
            h0.f.a(d0);
        }
        catch(Throwable throwable0) {
            h0.f(throwable0);
        }
    }

    public final void f(Throwable throwable0) {
        ArrayList arrayList0 = new ArrayList();
        this.a.writeLock().lock();
        try {
            this.c = 2;
            arrayList0.addAll(this.b);
            this.b.clear();
        }
        finally {
            this.a.writeLock().unlock();
        }
        a a0 = new a(arrayList0, this.c, throwable0);
        this.d.post(a0);
    }

    public final CharSequence g(int v, int v1, int v2, CharSequence charSequence0) {
        v v7;
        Throwable throwable2;
        Q1.c.p("Not initialized yet", this.c() == 1);
        Q1.c.n(v, "start cannot be negative");
        Q1.c.n(v1, "end cannot be negative");
        Q1.c.n(0x7FFFFFFF, "maxEmojiCount cannot be negative");
        Q1.c.l(v <= v1, "start should be <= than end");
        v v4 = null;
        if(charSequence0 == null) {
            return null;
        }
        Q1.c.l(v <= charSequence0.length(), "start should be < than charSequence length");
        Q1.c.l(v1 <= charSequence0.length(), "end should be < than charSequence length");
        if(charSequence0.length() != 0 && v != v1) {
            s s0 = (s)this.e.b;
            s0.getClass();
            if(charSequence0 instanceof r) {
                ((r)charSequence0).a();
            }
            Class class0 = t.class;
            if(charSequence0 instanceof r) {
                v4 = new v(((Spannable)charSequence0));
            }
            else {
                try {
                    if(charSequence0 instanceof Spannable) {
                        v4 = new v(((Spannable)charSequence0));
                    }
                    else if(charSequence0 instanceof Spanned && ((Spanned)charSequence0).nextSpanTransition(v - 1, v1 + 1, class0) <= v1) {
                        v4 = new v();  // 初始化器: Ljava/lang/Object;-><init>()V
                        v4.a = false;
                        v4.b = new SpannableString(charSequence0);
                    }
                    goto label_27;
                }
                catch(Throwable throwable0) {
                    throwable2 = throwable0;
                    goto label_51;
                }
                try {
                    v4 = new v(((Spannable)charSequence0));
                }
                catch(Throwable throwable1) {
                    goto label_50;
                }
            }
            try {
            label_27:
                if(v4 != null) {
                    t[] arr_t = (t[])v4.b.getSpans(v, v1, class0);
                    if(arr_t != null && arr_t.length > 0) {
                        for(int v3 = 0; v3 < arr_t.length; ++v3) {
                            t t0 = arr_t[v3];
                            int v5 = v4.b.getSpanStart(t0);
                            int v6 = v4.b.getSpanEnd(t0);
                            if(v5 != v1) {
                                v4.removeSpan(t0);
                            }
                            v = Math.min(v5, v);
                            v1 = Math.max(v6, v1);
                        }
                    }
                }
                if(v == v1) {
                    goto label_60;
                }
                else {
                    goto label_45;
                }
                return charSequence0;
            }
            catch(Throwable throwable0) {
                throwable2 = throwable0;
                goto label_51;
            }
            try {
            label_45:
                if(v < charSequence0.length()) {
                    v7 = (v)s0.t(charSequence0, v, v1, 0x7FFFFFFF, v2 == 1, new x9.b(v4, ((e3.h)s0.a)));
                    if(v7 != null) {
                        goto label_54;
                    }
                    goto label_58;
                }
                else {
                    goto label_60;
                }
                return charSequence0;
            }
            catch(Throwable throwable1) {
            label_50:
                throwable2 = throwable1;
            }
        label_51:
            if(charSequence0 instanceof r) {
                ((r)charSequence0).b();
            }
            throw throwable2;
        label_54:
            CharSequence charSequence1 = v7.b;
            if(charSequence0 instanceof r) {
                ((r)charSequence0).b();
            }
            return charSequence1;
        label_58:
            if(charSequence0 instanceof r) {
                ((r)charSequence0).b();
                return charSequence0;
            label_60:
                if(charSequence0 instanceof r) {
                    ((r)charSequence0).b();
                    return charSequence0;
                }
            }
        }
        return charSequence0;
    }

    public final void h(f f0) {
        Q1.c.o(f0, "initCallback cannot be null");
        this.a.writeLock().lock();
        try {
            if(this.c == 1 || this.c == 2) {
                int v1 = this.c;
                a a0 = new a(Arrays.asList(new f[]{f0}), v1, null);
                this.d.post(a0);
            }
            else {
                this.b.add(f0);
            }
        }
        finally {
            this.a.writeLock().unlock();
        }
    }

    public final void i(EditorInfo editorInfo0) {
        if(this.c() != 1 || editorInfo0 == null) {
            return;
        }
        if(editorInfo0.extras == null) {
            editorInfo0.extras = new Bundle();
        }
        this.e.getClass();
        Bundle bundle0 = editorInfo0.extras;
        w2.b b0 = (w2.b)((o9.b)this.e.c).a;
        int v = b0.a(4);
        bundle0.putInt("android.support.text.emoji.emojiCompat_metadataVersion", (v == 0 ? 0 : ((ByteBuffer)b0.d).getInt(v + b0.a)));
        editorInfo0.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", false);
    }
}

