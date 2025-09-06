package com.iloen.melon.utils;

import Cb.i;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.popup.H;
import d3.g;
import d5.f;
import d8.d;
import ie.r;
import java.io.File;
import k8.t;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r2.a;
import we.n;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000E\n\u0002\b\u001A\bÇ\u0002\u0018\u00002\u00020\u0001J!\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000B\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\t2\b\b\u0002\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u000B\u0010\fJ!\u0010\u000B\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u000B\u0010\bJ!\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u000F\u0010\u0010J#\u0010\u0013\u001A\u00020\u00062\b\u0010\u0011\u001A\u0004\u0018\u00010\u000E2\b\u0010\u0012\u001A\u0004\u0018\u00010\u000EH\u0007¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0017\u001A\u00020\u00062\b\u0010\u0015\u001A\u0004\u0018\u00010\u000E2\b\u0010\u0016\u001A\u0004\u0018\u00010\u000EH\u0007¢\u0006\u0004\b\u0017\u0010\u0014J\u001F\u0010\u001A\u001A\u00020\u00062\u0006\u0010\u0018\u001A\u00020\t2\u0006\u0010\u0019\u001A\u00020\tH\u0007¢\u0006\u0004\b\u001A\u0010\u001BJ \u0010\u001C\u001A\u00020\u00062\u0006\u0010\r\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H\u0086@¢\u0006\u0004\b\u001C\u0010\u001DR!\u0010 \u001A\u00020\u00068FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u001E\u0010\u001F\u0012\u0004\b\"\u0010#\u001A\u0004\b \u0010!R!\u0010\'\u001A\u00020\u00068FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b$\u0010\u001F\u0012\u0004\b&\u0010#\u001A\u0004\b%\u0010!¨\u0006("}, d2 = {"Lcom/iloen/melon/utils/StorageUtils;", "", "Landroid/net/Uri;", "contentUri", "Landroid/content/Context;", "context", "", "existLocalContent", "(Landroid/net/Uri;Landroid/content/Context;)Z", "Lcom/iloen/melon/playback/Playable;", "playable", "isDcfContent", "(Lcom/iloen/melon/playback/Playable;Landroid/content/Context;)Z", "uri", "", "getDisplayName", "(Landroid/net/Uri;Landroid/content/Context;)Ljava/lang/String;", "uriString1", "uriString2", "equalsUri", "(Ljava/lang/String;Ljava/lang/String;)Z", "path1", "path2", "equalsPath", "playable1", "playable2", "equalsLocalFile", "(Lcom/iloen/melon/playback/Playable;Lcom/iloen/melon/playback/Playable;)Z", "exist", "(Landroid/net/Uri;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "Lie/j;", "isScopedStorage", "()Z", "isScopedStorage$annotations", "()V", "b", "getNeedsLocalPlaylistMig", "getNeedsLocalPlaylistMig$annotations", "needsLocalPlaylistMig", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class StorageUtils {
    public static final int $stable;
    @NotNull
    public static final StorageUtils INSTANCE;
    public static final r a;
    public static final r b;

    static {
        StorageUtils.INSTANCE = new StorageUtils();  // 初始化器: Ljava/lang/Object;-><init>()V
        StorageUtils.a = g.Q(new H(8));
        StorageUtils.b = g.Q(new H(9));
        StorageUtils.$stable = 8;
    }

    public static Context a() {
        MelonAppBase.Companion.getClass();
        Context context0 = t.a().getContext().getApplicationContext();
        q.f(context0, "getApplicationContext(...)");
        return context0;
    }

    // 去混淆评级： 低(33)
    public static final boolean equalsLocalFile(@NotNull Playable playable0, @NotNull Playable playable1) {
        q.g(playable0, "playable1");
        q.g(playable1, "playable2");
        return StorageUtils.isScopedStorage() ? StorageUtils.equalsUri("", "") : StorageUtils.equalsPath("", "");
    }

    public static final boolean equalsPath(@Nullable String s, @Nullable String s1) {
        return s == null || s1 == null ? s == null && s1 == null : new File(s).equals(new File(s1));
    }

    public static final boolean equalsUri(@Nullable String s, @Nullable String s1) {
        return s == null || s1 == null ? s == null && s1 == null : q.b(Uri.parse(s), Uri.parse(s1));
    }

    @Nullable
    public final Object exist(@NotNull Uri uri0, @NotNull Context context0, @NotNull Continuation continuation0) {
        return BuildersKt.withContext(Dispatchers.getIO(), new n(context0, null) {
            public final Uri r;
            public final Context w;

            {
                this.r = uri0;
                this.w = context0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.utils.StorageUtils.exist.2(this.r, this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.utils.StorageUtils.exist.2)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                d5.n.D(object0);
                Uri uri0 = this.r;
                String s = uri0.getScheme();
                boolean z = false;
                if(s != null) {
                    switch(s) {
                        case "content": {
                            Context context0 = this.w;
                            if(DocumentsContract.isDocumentUri(context0, uri0)) {
                                return Boolean.valueOf(a.d(context0, uri0).c());
                            }
                            Cursor cursor0 = i.n(this.w, this.r, new String[]{"_id"}, null, null, 28);
                            if(cursor0 != null) {
                                try {
                                    if(cursor0.getCount() > 0) {
                                        z = true;
                                    }
                                }
                                catch(Throwable throwable0) {
                                    d.l(cursor0, throwable0);
                                    throw throwable0;
                                }
                                cursor0.close();
                                return Boolean.valueOf(z);
                            }
                            break;
                        }
                        case "file": {
                            return Boolean.valueOf(f.V(uri0).exists());
                        }
                        default: {
                            return false;
                        }
                    }
                }
                return false;
            }
        }, continuation0);
    }

    public static final boolean existLocalContent(@NotNull Uri uri0, @NotNull Context context0) {
        q.g(uri0, "contentUri");
        q.g(context0, "context");
        String s = uri0.getScheme();
        boolean z = false;
        if(s != null) {
            switch(s) {
                case "content": {
                    if(DocumentsContract.isDocumentUri(context0, uri0)) {
                        return a.d(context0, uri0).c();
                    }
                    Cursor cursor0 = i.n(context0, uri0, new String[]{"_id"}, null, null, 28);
                    if(cursor0 != null) {
                        try {
                            if(cursor0.getCount() > 0) {
                                z = true;
                            }
                        }
                        catch(Throwable throwable0) {
                            d.l(cursor0, throwable0);
                            throw throwable0;
                        }
                        cursor0.close();
                        return z;
                    }
                    break;
                }
                case "file": {
                    return f.V(uri0).exists();
                }
                default: {
                    return false;
                }
            }
        }
        return false;
    }

    public static boolean existLocalContent$default(Uri uri0, Context context0, int v, Object object0) {
        if((v & 2) != 0) {
            StorageUtils.INSTANCE.getClass();
            context0 = StorageUtils.a();
        }
        return StorageUtils.existLocalContent(uri0, context0);
    }

    @NotNull
    public static final String getDisplayName(@NotNull Uri uri0, @NotNull Context context0) {
        q.g(uri0, "uri");
        q.g(context0, "context");
        String s = "";
        if(!Uri.EMPTY.equals(uri0)) {
            String s1 = uri0.getScheme();
            if(s1 != null) {
                switch(s1) {
                    case "content": {
                        if(DocumentsContract.isDocumentUri(context0, uri0)) {
                            String s4 = a.d(context0, uri0).e();
                            return s4 == null ? "" : s4;
                        }
                        Cursor cursor0 = i.n(context0, uri0, new String[]{"_display_name"}, null, null, 28);
                        if(cursor0 != null) {
                            try {
                                if(cursor0.moveToFirst()) {
                                    s = i.j(cursor0, "_display_name");
                                }
                            }
                            catch(Throwable throwable0) {
                                d.l(cursor0, throwable0);
                                throw throwable0;
                            }
                            cursor0.close();
                            return s;
                        }
                        break;
                    }
                    case "file": {
                        String s2 = uri0.getPath();
                        q.d(s2);
                        String s3 = new File(s2).getName();
                        q.f(s3, "getName(...)");
                        return s3;
                    }
                    default: {
                        return "";
                    }
                }
            }
        }
        return "";
    }

    public static String getDisplayName$default(Uri uri0, Context context0, int v, Object object0) {
        if((v & 2) != 0) {
            StorageUtils.INSTANCE.getClass();
            context0 = StorageUtils.a();
        }
        return StorageUtils.getDisplayName(uri0, context0);
    }

    public static final boolean getNeedsLocalPlaylistMig() {
        return ((Boolean)StorageUtils.b.getValue()).booleanValue();
    }

    public static void getNeedsLocalPlaylistMig$annotations() {
    }

    public static final boolean isDcfContent(@NotNull Uri uri0, @NotNull Context context0) {
        q.g(uri0, "contentUri");
        q.g(context0, "context");
        String s = uri0.getScheme();
        if(s != null) {
            switch(s) {
                case "content": {
                    a a0 = a.d(context0, uri0);
                    return a0.c() && FilenameUtils.isDcf(a0.e());
                }
                case "file": {
                    File file0 = f.V(uri0);
                    return file0.exists() && FilenameUtils.isDcf(file0.getName());
                }
                default: {
                    return false;
                }
            }
        }
        return false;
    }

    public static final boolean isDcfContent(@NotNull Playable playable0, @NotNull Context context0) {
        q.g(playable0, "playable");
        q.g(context0, "context");
        Uri uri0 = playable0.getLocalContentUri();
        q.f(uri0, "getLocalContentUri(...)");
        return StorageUtils.isDcfContent(uri0, context0);
    }

    public static boolean isDcfContent$default(Uri uri0, Context context0, int v, Object object0) {
        if((v & 2) != 0) {
            StorageUtils.INSTANCE.getClass();
            context0 = StorageUtils.a();
        }
        return StorageUtils.isDcfContent(uri0, context0);
    }

    public static boolean isDcfContent$default(Playable playable0, Context context0, int v, Object object0) {
        if((v & 2) != 0) {
            StorageUtils.INSTANCE.getClass();
            context0 = StorageUtils.a();
        }
        return StorageUtils.isDcfContent(playable0, context0);
    }

    public static final boolean isScopedStorage() {
        return ((Boolean)StorageUtils.a.getValue()).booleanValue();
    }

    public static void isScopedStorage$annotations() {
    }
}

