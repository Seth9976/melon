package v2;

import M6.z;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import androidx.emoji2.text.EmojiCompatInitializer;
import androidx.lifecycle.D;
import androidx.lifecycle.f;
import androidx.lifecycle.t;

public final class i implements f {
    public final t a;

    public i(EmojiCompatInitializer emojiCompatInitializer0, t t0) {
        this.a = t0;
    }

    @Override  // androidx.lifecycle.f
    public final void onResume(D d0) {
        (Build.VERSION.SDK_INT < 28 ? new Handler(Looper.getMainLooper()) : a.a(Looper.getMainLooper())).postDelayed(new z(2), 500L);
        this.a.c(this);
    }
}

