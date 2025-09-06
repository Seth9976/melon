package com.iloen.melon.fragments.local;

import Bc.h;
import android.app.PendingIntent;
import android.app.RecoverableSecurityException;
import android.content.Context;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Process;
import android.provider.MediaStore;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.fragment.app.f0;
import com.iloen.melon.utils.StorageUtils;
import e.b;
import e9.a;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kc.s2;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import ob.z;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\'\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001A\u00020\b2\u0010\u0010\u0007\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ+\u0010\u0010\u001A\b\u0012\u0004\u0012\u00020\u000E0\r2\u0006\u0010\f\u001A\u00020\u000B2\f\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u000E0\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0012\u001A\u00020\b2\u0010\u0010\u0007\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005H\u0004¢\u0006\u0004\b\u0012\u0010\nR\"\u0010\u0014\u001A\u00020\u00138\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001A\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001B\u001A\u00020\u001A8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u001D\u0010\u001E\"\u0004\b\u001F\u0010 R\"\u0010\"\u001A\u00020!8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b\"\u0010#\u001A\u0004\b$\u0010%\"\u0004\b&\u0010\'R \u0010(\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b(\u0010)R\"\u0010-\u001A\u0010\u0012\f\u0012\n ,*\u0004\u0018\u00010+0+0*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lcom/iloen/melon/fragments/local/LocalContentListFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "Le9/a;", "<init>", "()V", "", "", "removeList", "Lie/H;", "remove", "([Ljava/lang/String;)V", "Landroid/content/Context;", "context", "", "Landroid/net/Uri;", "selections", "neededPermissions", "(Landroid/content/Context;Ljava/util/List;)Ljava/util/List;", "removeSongs", "Lkc/s2;", "playlistManager", "Lkc/s2;", "getPlaylistManager", "()Lkc/s2;", "setPlaylistManager", "(Lkc/s2;)V", "Lob/z;", "playerUseCase", "Lob/z;", "getPlayerUseCase", "()Lob/z;", "setPlayerUseCase", "(Lob/z;)V", "LBc/h;", "playerUiHelper", "LBc/h;", "getPlayerUiHelper", "()LBc/h;", "setPlayerUiHelper", "(LBc/h;)V", "deletedSongList", "[Ljava/lang/String;", "Le/b;", "Landroidx/activity/result/IntentSenderRequest;", "kotlin.jvm.PlatformType", "activityResult", "Le/b;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class LocalContentListFragment extends Hilt_LocalContentListFragment implements a {
    public static final int $stable = 8;
    @NotNull
    private final b activityResult;
    @Nullable
    private String[] deletedSongList;
    @Inject
    public h playerUiHelper;
    @Inject
    public z playerUseCase;
    @Inject
    public s2 playlistManager;

    public LocalContentListFragment() {
        b b0 = this.registerForActivityResult(new f0(3), new p(this, 0));
        q.f(b0, "registerForActivityResult(...)");
        this.activityResult = b0;
    }

    private static final void activityResult$lambda$0(LocalContentListFragment localContentListFragment0, ActivityResult activityResult0) {
        q.g(activityResult0, "result");
        if(activityResult0.a == -1) {
            localContentListFragment0.remove(localContentListFragment0.deletedSongList);
        }
    }

    @NotNull
    public final h getPlayerUiHelper() {
        h h0 = this.playerUiHelper;
        if(h0 != null) {
            return h0;
        }
        q.m("playerUiHelper");
        throw null;
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

    private final List neededPermissions(Context context0, List list0) {
        List list1 = new ArrayList();
        for(Object object0: list0) {
            if(context0.checkUriPermission(((Uri)object0), Process.myPid(), Process.myUid(), 2) != 0) {
                list1.add(object0);
            }
        }
        return list1;
    }

    @Override  // e9.a
    public abstract void onRemoveComplete(int arg1, @Nullable Object arg2);

    @Override  // e9.a
    public void onThrowRecoverableSecurityException(@NotNull RecoverableSecurityException recoverableSecurityException0) {
        q.g(recoverableSecurityException0, "exception");
    }

    private final void remove(String[] arr_s) {
        Context context0 = this.getContext();
        if(context0 == null) {
            return;
        }
        e9.b b0 = new e9.b(context0, this);
        b0.d = 0;
        b0.a(arr_s, null);
    }

    public final void removeSongs(@Nullable String[] arr_s) {
        List list0;
        if(StorageUtils.isScopedStorage()) {
            this.deletedSongList = arr_s;
            Context context0 = this.getContext();
            if(context0 == null) {
                return;
            }
            String[] arr_s1 = this.deletedSongList;
            if(arr_s1 == null) {
                list0 = null;
            }
            else {
                ArrayList arrayList0 = new ArrayList(arr_s1.length);
                for(int v = 0; v < arr_s1.length; ++v) {
                    arrayList0.add(Uri.parse(arr_s1[v]));
                }
                list0 = this.neededPermissions(context0, arrayList0);
            }
            if(list0 != null && !list0.isEmpty()) {
                PendingIntent pendingIntent0 = MediaStore.createDeleteRequest(context0.getContentResolver(), list0);
                q.f(pendingIntent0, "createDeleteRequest(...)");
                IntentSender intentSender0 = pendingIntent0.getIntentSender();
                q.f(intentSender0, "getIntentSender(...)");
                IntentSenderRequest intentSenderRequest0 = new IntentSenderRequest(intentSender0, null, 0, 0);
                this.activityResult.b(intentSenderRequest0);
                return;
            }
            this.remove(arr_s);
            return;
        }
        this.remove(arr_s);
    }

    public final void setPlayerUiHelper(@NotNull h h0) {
        q.g(h0, "<set-?>");
        this.playerUiHelper = h0;
    }

    public final void setPlayerUseCase(@NotNull z z0) {
        q.g(z0, "<set-?>");
        this.playerUseCase = z0;
    }

    public final void setPlaylistManager(@NotNull s2 s20) {
        q.g(s20, "<set-?>");
        this.playlistManager = s20;
    }
}

