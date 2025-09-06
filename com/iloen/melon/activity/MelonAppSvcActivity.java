package com.iloen.melon.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.lifecycle.f0;
import b.n;
import com.iloen.melon.utils.log.LogU;
import javax.inject.Inject;
import kc.s2;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import l8.r;
import l8.s;
import l8.t;
import ob.z;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qd.V;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 /2\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\r\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\t2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0002¢\u0006\u0004\b\r\u0010\u000EJ\u0019\u0010\u0011\u001A\u00020\u00062\b\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0014¢\u0006\u0004\b\u0013\u0010\bJ\u000F\u0010\u0014\u001A\u00020\u0006H\u0014¢\u0006\u0004\b\u0014\u0010\u0003J\r\u0010\u0015\u001A\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0003R\u0018\u0010\u0016\u001A\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001A\u00020\u00188\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001A\u001A\u0004\b\u001B\u0010\u001C\"\u0004\b\u001D\u0010\u001ER\"\u0010 \u001A\u00020\u001F8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b \u0010!\u001A\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010\'\u001A\u00020&8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\'\u0010(\u001A\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0014\u0010\u0015\u001A\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010.¨\u00061"}, d2 = {"Lcom/iloen/melon/activity/MelonAppSvcActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "Landroid/content/Intent;", "intent", "Lie/H;", "handleIntent", "(Landroid/content/Intent;)V", "Landroid/app/Activity;", "context", "Landroid/net/Uri;", "uri", "handleMelonAppUri", "(Landroid/app/Activity;Landroid/net/Uri;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "onNewIntent", "onResume", "onBackPressedCallback", "pendingIntent", "Landroid/content/Intent;", "Lkc/s2;", "playlistManager", "Lkc/s2;", "getPlaylistManager", "()Lkc/s2;", "setPlaylistManager", "(Lkc/s2;)V", "Lob/z;", "playerUseCase", "Lob/z;", "getPlayerUseCase", "()Lob/z;", "setPlayerUseCase", "(Lob/z;)V", "Lqd/V;", "shuffleRepeatChangeNotifier", "Lqd/V;", "getShuffleRepeatChangeNotifier", "()Lqd/V;", "setShuffleRepeatChangeNotifier", "(Lqd/V;)V", "Lb/n;", "Lb/n;", "Companion", "l8/r", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonAppSvcActivity extends Hilt_MelonAppSvcActivity {
    public static final int $stable = 8;
    @NotNull
    public static final r Companion = null;
    @NotNull
    private static final String TAG = "MelonAppSvcActivity";
    @NotNull
    private final n onBackPressedCallback;
    @Nullable
    private Intent pendingIntent;
    @Inject
    public z playerUseCase;
    @Inject
    public s2 playlistManager;
    @Inject
    public V shuffleRepeatChangeNotifier;

    static {
        MelonAppSvcActivity.Companion = new r();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public MelonAppSvcActivity() {
        this.onBackPressedCallback = new t(this);
    }

    @NotNull
    public final z getPlayerUseCase() {
        z z0 = this.playerUseCase;
        if(z0 != null) {
            return z0;
        }
        q.m("playerUseCase");
        throw null;
    }

    @NotNull
    public final s2 getPlaylistManager() {
        s2 s20 = this.playlistManager;
        if(s20 != null) {
            return s20;
        }
        q.m("playlistManager");
        throw null;
    }

    @NotNull
    public final V getShuffleRepeatChangeNotifier() {
        V v0 = this.shuffleRepeatChangeNotifier;
        if(v0 != null) {
            return v0;
        }
        q.m("shuffleRepeatChangeNotifier");
        throw null;
    }

    private final void handleIntent(Intent intent0) {
        if(intent0 == null) {
            LogU.Companion.e("MelonAppSvcActivity", "handleIntent() invalid intent");
            return;
        }
        this.pendingIntent = null;
        String s = intent0.getAction();
        Uri uri0 = intent0.getData();
        LogU.Companion.d("MelonAppSvcActivity", "handleIntent action: " + s + ", uri:" + uri0);
        this.handleMelonAppUri(this, uri0);
        this.finish();
    }

    private final void handleMelonAppUri(Activity activity0, Uri uri0) {
        if(uri0 != null && !q.b(Uri.EMPTY, uri0)) {
            BuildersKt__Builders_commonKt.launch$default(f0.f(this), Dispatchers.getMain(), null, new s(uri0, this, activity0, null), 2, null);
            return;
        }
        LogU.Companion.e("MelonAppSvcActivity", "handleMelonAppUri - empty: " + uri0);
    }

    public final void onBackPressedCallback() {
        this.finish();
    }

    @Override  // com.iloen.melon.activity.Hilt_MelonAppSvcActivity
    public void onCreate(@Nullable Bundle bundle0) {
        LogU.Companion.v("MelonAppSvcActivity", "onCreate() savedInstanceState: " + bundle0);
        super.onCreate(bundle0);
        this.setContentView(0x7F0D001F);  // layout:activity_melonappsvc
        this.getOnBackPressedDispatcher().a(this, this.onBackPressedCallback);
        Intent intent0 = this.getIntent();
        if(bundle0 == null) {
            synchronized(this) {
                this.pendingIntent = intent0;
            }
        }
    }

    @Override  // androidx.activity.ComponentActivity
    public void onNewIntent(@NotNull Intent intent0) {
        q.g(intent0, "intent");
        LogU.Companion.v("MelonAppSvcActivity", "onNewIntent() intent: " + intent0);
        super.onNewIntent(intent0);
        synchronized(this) {
            this.pendingIntent = intent0;
        }
    }

    @Override  // androidx.fragment.app.FragmentActivity
    public void onResume() {
        LogU.Companion.v("MelonAppSvcActivity", "onResume()");
        super.onResume();
        synchronized(this) {
            Intent intent0 = this.pendingIntent;
            if(intent0 != null) {
                this.handleIntent(intent0);
            }
        }
    }

    public final void setPlayerUseCase(@NotNull z z0) {
        q.g(z0, "<set-?>");
        this.playerUseCase = z0;
    }

    public final void setPlaylistManager(@NotNull s2 s20) {
        q.g(s20, "<set-?>");
        this.playlistManager = s20;
    }

    public final void setShuffleRepeatChangeNotifier(@NotNull V v0) {
        q.g(v0, "<set-?>");
        this.shuffleRepeatChangeNotifier = v0;
    }
}

