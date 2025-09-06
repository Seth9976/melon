package com.kakao.emoticon.controller;

import H0.b;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.kakao.digitalitem.image.lib.AnimatedItemImage.Type;
import com.kakao.digitalitem.image.lib.AnimatedItemImageContainer;
import com.kakao.emoticon.R.drawable;
import com.kakao.emoticon.cache.DataCacheWriter;
import com.kakao.emoticon.cache.Key;
import com.kakao.emoticon.cache.module.DiskCache;
import com.kakao.emoticon.cache.module.EmoticonDiskCacheFactory;
import com.kakao.emoticon.cache.module.MemoryLruCache;
import com.kakao.emoticon.cache.signature.EmoticonVersionSignature;
import com.kakao.emoticon.image.AnimatedItemImageLoader;
import com.kakao.emoticon.interfaces.EmoticonViewLoadListener;
import com.kakao.emoticon.model.DrawType;
import com.kakao.emoticon.model.EmoticonLoadParam;
import com.kakao.emoticon.model.EmoticonViewParam;
import com.kakao.emoticon.net.EmoticonApiError;
import com.kakao.emoticon.net.EmoticonApiService.DefaultImpls;
import com.kakao.emoticon.net.EmoticonApiService;
import com.kakao.emoticon.net.EmoticonApiServiceImpl;
import com.kakao.emoticon.net.response.Emoticon;
import com.kakao.emoticon.ui.widget.EmoticonSpan;
import com.kakao.emoticon.ui.widget.EmoticonView;
import com.kakao.emoticon.util.DigitalItemSoundPlay;
import com.kakao.emoticon.util.SafetyBitmapFactory;
import ie.H;
import ie.m;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oe.c;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import te.j;
import we.k;
import we.n;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00C6\u0002\u0018\u00002\u00020\u0001:\u0001LB\t\b\u0002\u00A2\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\b\u00A2\u0006\u0004\b\u000B\u0010\fJ)\u0010\u000E\u001A\u00020\n2\u0006\u0010\u0005\u001A\u00020\r2\u0006\u0010\u0007\u001A\u00020\u00062\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\b\u00A2\u0006\u0004\b\u000E\u0010\u000FJ\u001D\u0010\u0012\u001A\u00020\n2\u0006\u0010\u0005\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\u0010\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u001D\u0010\u0014\u001A\u00020\n2\u0006\u0010\u0005\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\u0010\u00A2\u0006\u0004\b\u0014\u0010\u0013J\u001D\u0010\u0015\u001A\u00020\n2\u0006\u0010\u0005\u001A\u00020\r2\u0006\u0010\u0011\u001A\u00020\u0010\u00A2\u0006\u0004\b\u0015\u0010\u0013J)\u0010\u0018\u001A\u00020\n2\u0006\u0010\u0005\u001A\u00020\r2\u0006\u0010\u0017\u001A\u00020\u00162\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\b\u00A2\u0006\u0004\b\u0018\u0010\u0019J\u001F\u0010\u001A\u001A\u00020\n2\u0006\u0010\u0007\u001A\u00020\u00062\b\u0010\t\u001A\u0004\u0018\u00010\b\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u001B\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u0017\u001A\u00020\u0016H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\u001D\u0010\u001EJ-\u0010\"\u001A\u0004\u0018\u00010\u001C2\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010 \u001A\u00020\u001F2\u0006\u0010!\u001A\u00020\u0016H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0004\b\"\u0010#J-\u0010%\u001A\u0004\u0018\u00010$2\u0006\u0010\u0017\u001A\u00020\u00162\u0006\u0010 \u001A\u00020\u001F2\u0006\u0010!\u001A\u00020\u0016H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0004\b%\u0010#J\u001D\u0010(\u001A\u0004\u0018\u00010$2\u0006\u0010\'\u001A\u00020&H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0004\b(\u0010)J\u001D\u0010+\u001A\u00020\n2\b\u0010*\u001A\u0004\u0018\u00010\u0004H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0004\b+\u0010,J%\u0010/\u001A\u00020\n2\b\u0010\u0005\u001A\u0004\u0018\u00010\r2\u0006\u0010.\u001A\u00020-H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0004\b/\u00100J%\u00101\u001A\u00020\n2\b\u0010\u0005\u001A\u0004\u0018\u00010\r2\u0006\u0010.\u001A\u00020-H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0004\b1\u00100J%\u00102\u001A\u0004\u0018\u00010\u001C2\u0006\u0010 \u001A\u00020\u001F2\u0006\u0010!\u001A\u00020\u0016H\u0082@\u00F8\u0001\u0000\u00A2\u0006\u0004\b2\u00103J\u001D\u00105\u001A\u0002042\u0006\u0010 \u001A\u00020\u001F2\u0006\u0010!\u001A\u00020\u0016\u00A2\u0006\u0004\b5\u00106J+\u00107\u001A\u00020\n2\u0006\u0010\u0005\u001A\u00020\r2\u0006\u0010\u0017\u001A\u00020\u00162\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\bH\u0002\u00A2\u0006\u0004\b7\u0010\u0019J+\u00108\u001A\u00020\n2\u0006\u0010\u0005\u001A\u00020\r2\u0006\u0010\'\u001A\u00020&2\n\b\u0002\u0010\t\u001A\u0004\u0018\u00010\bH\u0002\u00A2\u0006\u0004\b8\u00109J!\u0010:\u001A\u00020\n2\u0006\u0010\'\u001A\u00020&2\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0002\u00A2\u0006\u0004\b:\u0010;J)\u0010<\u001A\u00020\n2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\'\u001A\u00020&2\b\u0010\t\u001A\u0004\u0018\u00010\bH\u0002\u00A2\u0006\u0004\b<\u0010=J!\u0010?\u001A\u00020\n2\b\u0010>\u001A\u0004\u0018\u00010$2\u0006\u0010*\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b?\u0010@J\u001F\u0010B\u001A\u00020\n2\u0006\u0010A\u001A\u00020\u00012\u0006\u0010 \u001A\u00020\u0016H\u0002\u00A2\u0006\u0004\bB\u0010CJ\u001F\u0010D\u001A\u0002042\u0006\u0010A\u001A\u00020\u00012\u0006\u0010 \u001A\u00020\u0016H\u0002\u00A2\u0006\u0004\bD\u0010ER\u0014\u0010G\u001A\u00020F8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bG\u0010HR \u0010J\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160I8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bJ\u0010K\u0082\u0002\u0004\n\u0002\b\u0019\u00A8\u0006M"}, d2 = {"Lcom/kakao/emoticon/controller/EmoticonResourceLoader;", "", "<init>", "()V", "Lcom/kakao/digitalitem/image/lib/AnimatedItemImageContainer;", "view", "Lcom/kakao/emoticon/model/EmoticonViewParam;", "viewParam", "Lcom/kakao/emoticon/interfaces/EmoticonViewLoadListener;", "listener", "Lie/H;", "loadEmoticon", "(Lcom/kakao/digitalitem/image/lib/AnimatedItemImageContainer;Lcom/kakao/emoticon/model/EmoticonViewParam;Lcom/kakao/emoticon/interfaces/EmoticonViewLoadListener;)V", "Landroid/widget/ImageView;", "loadThumbnail", "(Landroid/widget/ImageView;Lcom/kakao/emoticon/model/EmoticonViewParam;Lcom/kakao/emoticon/interfaces/EmoticonViewLoadListener;)V", "Lcom/kakao/emoticon/net/response/Emoticon;", "emoticon", "loadTitle", "(Landroid/widget/ImageView;Lcom/kakao/emoticon/net/response/Emoticon;)V", "loadOnIcon", "loadOffIcon", "", "url", "loadUrl", "(Landroid/widget/ImageView;Ljava/lang/String;Lcom/kakao/emoticon/interfaces/EmoticonViewLoadListener;)V", "downloadEmoticon", "(Lcom/kakao/emoticon/model/EmoticonViewParam;Lcom/kakao/emoticon/interfaces/EmoticonViewLoadListener;)V", "Landroid/graphics/Bitmap;", "getBitmapFromExternalUrl", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/kakao/emoticon/cache/Key;", "key", "dirKey", "getRemoteBitmap", "(Ljava/lang/String;Lcom/kakao/emoticon/cache/Key;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/io/File;", "downloadFile", "Lcom/kakao/emoticon/model/EmoticonLoadParam;", "loadParam", "loadSoundPath", "(Lcom/kakao/emoticon/model/EmoticonLoadParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "container", "drawError", "(Lcom/kakao/digitalitem/image/lib/AnimatedItemImageContainer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "resId", "drawBackgroundRes", "(Landroid/widget/ImageView;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "drawImageRes", "getBitmapFromCache", "(Lcom/kakao/emoticon/cache/Key;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "isCachedItem", "(Lcom/kakao/emoticon/cache/Key;Ljava/lang/String;)Z", "executeLoadUrl", "executeLoadResource", "(Landroid/widget/ImageView;Lcom/kakao/emoticon/model/EmoticonLoadParam;Lcom/kakao/emoticon/interfaces/EmoticonViewLoadListener;)V", "executeDownloadEmoticon", "(Lcom/kakao/emoticon/model/EmoticonLoadParam;Lcom/kakao/emoticon/interfaces/EmoticonViewLoadListener;)V", "executeLoadEmoticon", "(Lcom/kakao/digitalitem/image/lib/AnimatedItemImageContainer;Lcom/kakao/emoticon/model/EmoticonLoadParam;Lcom/kakao/emoticon/interfaces/EmoticonViewLoadListener;)V", "soundFile", "setupSoundView", "(Ljava/io/File;Lcom/kakao/digitalitem/image/lib/AnimatedItemImageContainer;)V", "obj", "setViewKey", "(Ljava/lang/Object;Ljava/lang/String;)V", "isSameKeySet", "(Ljava/lang/Object;Ljava/lang/String;)Z", "Lcom/kakao/emoticon/cache/module/EmoticonDiskCacheFactory;", "diskCacheFactory", "Lcom/kakao/emoticon/cache/module/EmoticonDiskCacheFactory;", "Ljava/util/WeakHashMap;", "loadViewKeyMap", "Ljava/util/WeakHashMap;", "EmoticonLoadException", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
public final class EmoticonResourceLoader {
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000F\b\u0000\u0012\u0006\u0010\u0003\u001A\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/kakao/emoticon/controller/EmoticonResourceLoader$EmoticonLoadException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "msg", "", "(Ljava/lang/String;)V", "kakaoemoticon-sdk-lib_release"}, k = 1, mv = {1, 4, 0})
    static final class EmoticonLoadException extends Exception {
        public EmoticonLoadException(@NotNull String s) {
            q.g(s, "msg");
            super(s);
        }
    }

    public static final EmoticonResourceLoader INSTANCE;
    private static final EmoticonDiskCacheFactory diskCacheFactory;
    private static final WeakHashMap loadViewKeyMap;

    static {
        EmoticonResourceLoader.INSTANCE = new EmoticonResourceLoader();
        EmoticonResourceLoader.diskCacheFactory = new EmoticonDiskCacheFactory();
        EmoticonResourceLoader.loadViewKeyMap = new WeakHashMap();
    }

    public static final EmoticonDiskCacheFactory access$getDiskCacheFactory$p(EmoticonResourceLoader emoticonResourceLoader0) {
        return EmoticonResourceLoader.diskCacheFactory;
    }

    public final void downloadEmoticon(@NotNull EmoticonViewParam emoticonViewParam0, @Nullable EmoticonViewLoadListener emoticonViewLoadListener0) {
        q.g(emoticonViewParam0, "viewParam");
        this.executeDownloadEmoticon(new EmoticonLoadParam(emoticonViewParam0, DrawType.EMOTICON), emoticonViewLoadListener0);
    }

    @Nullable
    public final Object downloadFile(@NotNull String s, @NotNull Key key0, @NotNull String s1, @NotNull Continuation continuation0) {
        return BuildersKt.withContext(Dispatchers.getIO(), new n(key0, s, null) {
            final String $dirKey;
            final Key $key;
            final String $url;
            Object L$0;
            Object L$1;
            int label;
            private CoroutineScope p$;

            {
                this.$dirKey = s;
                this.$key = key0;
                this.$url = s1;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                q.g(continuation0, "completion");
                Continuation continuation1 = new com.kakao.emoticon.controller.EmoticonResourceLoader.downloadFile.2(this.$dirKey, this.$key, this.$url, continuation0);
                continuation1.p$ = (CoroutineScope)object0;
                return continuation1;
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((com.kakao.emoticon.controller.EmoticonResourceLoader.downloadFile.2)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                DiskCache diskCache1;
                DiskCache diskCache0;
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        CoroutineScope coroutineScope0 = this.p$;
                        diskCache0 = EmoticonResourceLoader.access$getDiskCacheFactory$p(EmoticonResourceLoader.INSTANCE).build(this.$dirKey);
                        if((diskCache0 == null ? null : diskCache0.get(this.$key)) == null) {
                            EmoticonApiService emoticonApiService0 = EmoticonApiServiceImpl.INSTANCE.getApiClass();
                            this.L$0 = coroutineScope0;
                            this.L$1 = diskCache0;
                            this.label = 1;
                            object0 = DefaultImpls.downloadEmoticonResource$default(emoticonApiService0, this.$url, null, this, 2, null);
                            if(object0 == a0) {
                                return a0;
                            }
                            diskCache1 = diskCache0;
                            goto label_19;
                        }
                        break;
                    }
                    case 1: {
                        diskCache1 = (DiskCache)this.L$1;
                        CoroutineScope coroutineScope1 = (CoroutineScope)this.L$0;
                        d5.n.D(object0);
                    label_19:
                        byte[] arr_b = ((ResponseBody)object0).source().getBuffer().snapshot().toByteArray();
                        if(diskCache1 != null) {
                            DataCacheWriter dataCacheWriter0 = new DataCacheWriter(new ByteArrayInputStream(arr_b));
                            diskCache1.put(this.$key, dataCacheWriter0);
                        }
                        diskCache0 = diskCache1;
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                return diskCache0 != null ? diskCache0.get(this.$key) : null;
            }
        }, continuation0);
    }

    @Nullable
    public final Object drawBackgroundRes(@Nullable ImageView imageView0, int v, @NotNull Continuation continuation0) {
        H h0 = H.a;
        if(imageView0 != null && v != -1) {
            Object object0 = BuildersKt.withContext(Dispatchers.getMain(), new n(v, null) {
                final int $resId;
                final ImageView $view;
                int label;
                private CoroutineScope p$;

                {
                    this.$view = imageView0;
                    this.$resId = v;
                    super(2, continuation0);
                }

                @Override  // oe.a
                @NotNull
                public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                    q.g(continuation0, "completion");
                    Continuation continuation1 = new com.kakao.emoticon.controller.EmoticonResourceLoader.drawBackgroundRes.2(this.$view, this.$resId, continuation0);
                    continuation1.p$ = (CoroutineScope)object0;
                    return continuation1;
                }

                @Override  // we.n
                public final Object invoke(Object object0, Object object1) {
                    return ((com.kakao.emoticon.controller.EmoticonResourceLoader.drawBackgroundRes.2)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
                }

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    if(this.label != 0) {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                    d5.n.D(object0);
                    this.$view.setBackgroundResource(this.$resId);
                    this.$view.setImageResource(0);
                    return H.a;
                }
            }, continuation0);
            if(object0 == a.a) {
                return object0;
            }
        }
        return h0;
    }

    @Nullable
    public final Object drawError(@Nullable AnimatedItemImageContainer animatedItemImageContainer0, @NotNull Continuation continuation0) {
        H h0 = H.a;
        if(animatedItemImageContainer0 == null) {
            return h0;
        }
        Object object0 = BuildersKt.withContext(Dispatchers.getMain(), new n(null) {
            final AnimatedItemImageContainer $container;
            int label;
            private CoroutineScope p$;

            {
                this.$container = animatedItemImageContainer0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                q.g(continuation0, "completion");
                Continuation continuation1 = new com.kakao.emoticon.controller.EmoticonResourceLoader.drawError.2(this.$container, continuation0);
                continuation1.p$ = (CoroutineScope)object0;
                return continuation1;
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((com.kakao.emoticon.controller.EmoticonResourceLoader.drawError.2)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                if(this.$container instanceof EmoticonView && ((EmoticonView)this.$container).getTag() != null && "EmoticonPreview".equals(((EmoticonView)this.$container).getTag())) {
                    this.$container.setBackgroundResource(drawable.emoticon_not_found);
                    return H.a;
                }
                this.$container.setBackgroundResource(drawable.emoticon_not_found_padding);
                return H.a;
            }
        }, continuation0);
        return object0 == a.a ? object0 : h0;
    }

    @Nullable
    public final Object drawImageRes(@Nullable ImageView imageView0, int v, @NotNull Continuation continuation0) {
        H h0 = H.a;
        if(imageView0 != null && v != -1) {
            Object object0 = BuildersKt.withContext(Dispatchers.getMain(), new n(v, null) {
                final int $resId;
                final ImageView $view;
                int label;
                private CoroutineScope p$;

                {
                    this.$view = imageView0;
                    this.$resId = v;
                    super(2, continuation0);
                }

                @Override  // oe.a
                @NotNull
                public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                    q.g(continuation0, "completion");
                    Continuation continuation1 = new com.kakao.emoticon.controller.EmoticonResourceLoader.drawImageRes.2(this.$view, this.$resId, continuation0);
                    continuation1.p$ = (CoroutineScope)object0;
                    return continuation1;
                }

                @Override  // we.n
                public final Object invoke(Object object0, Object object1) {
                    return ((com.kakao.emoticon.controller.EmoticonResourceLoader.drawImageRes.2)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
                }

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    if(this.label != 0) {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                    d5.n.D(object0);
                    this.$view.setBackgroundResource(0);
                    this.$view.setImageResource(this.$resId);
                    return H.a;
                }
            }, continuation0);
            if(object0 == a.a) {
                return object0;
            }
        }
        return h0;
    }

    private final void executeDownloadEmoticon(EmoticonLoadParam emoticonLoadParam0, EmoticonViewLoadListener emoticonViewLoadListener0) {
        com.kakao.emoticon.controller.EmoticonResourceLoader.executeDownloadEmoticon.1 emoticonResourceLoader$executeDownloadEmoticon$10 = new k(null) {
            final EmoticonLoadParam $loadParam;
            int label;

            {
                this.$loadParam = emoticonLoadParam0;
                super(1, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@NotNull Continuation continuation0) {
                q.g(continuation0, "completion");
                return new com.kakao.emoticon.controller.EmoticonResourceLoader.executeDownloadEmoticon.1(this.$loadParam, continuation0);
            }

            @Override  // we.k
            public final Object invoke(Object object0) {
                return ((com.kakao.emoticon.controller.EmoticonResourceLoader.executeDownloadEmoticon.1)this.create(((Continuation)object0))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                a a0 = a.a;
                boolean z = true;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        String s = this.$loadParam.getResourceUrl();
                        EmoticonVersionSignature emoticonVersionSignature0 = this.$loadParam.getSignature();
                        this.label = 1;
                        object0 = EmoticonResourceLoader.INSTANCE.downloadFile(s, emoticonVersionSignature0, this.$loadParam.getEmoticonId(), this);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        d5.n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                if(((File)object0) == null) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        };
        com.kakao.emoticon.controller.EmoticonResourceLoader.executeDownloadEmoticon.2 emoticonResourceLoader$executeDownloadEmoticon$20 = new n(null) {
            final EmoticonViewLoadListener $listener;
            int label;
            private boolean p$0;

            {
                this.$listener = emoticonViewLoadListener0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                q.g(continuation0, "completion");
                Continuation continuation1 = new com.kakao.emoticon.controller.EmoticonResourceLoader.executeDownloadEmoticon.2(this.$listener, continuation0);
                ((Boolean)object0).getClass();
                continuation1.p$0 = ((Boolean)object0).booleanValue();
                return continuation1;
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((com.kakao.emoticon.controller.EmoticonResourceLoader.executeDownloadEmoticon.2)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                EmoticonViewLoadListener emoticonViewLoadListener0 = this.$listener;
                if(emoticonViewLoadListener0 != null) {
                    emoticonViewLoadListener0.onLoadComplete();
                }
                return H.a;
            }
        };
        com.kakao.emoticon.controller.EmoticonResourceLoader.executeDownloadEmoticon.3 emoticonResourceLoader$executeDownloadEmoticon$30 = new n(null) {
            final EmoticonViewLoadListener $listener;
            int label;
            private EmoticonApiError p$0;

            {
                this.$listener = emoticonViewLoadListener0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                q.g(continuation0, "completion");
                Continuation continuation1 = new com.kakao.emoticon.controller.EmoticonResourceLoader.executeDownloadEmoticon.3(this.$listener, continuation0);
                continuation1.p$0 = (EmoticonApiError)object0;
                return continuation1;
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((com.kakao.emoticon.controller.EmoticonResourceLoader.executeDownloadEmoticon.3)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                EmoticonViewLoadListener emoticonViewLoadListener0 = this.$listener;
                if(emoticonViewLoadListener0 != null) {
                    emoticonViewLoadListener0.onLoadFailed();
                }
                return H.a;
            }
        };
        EmoticonLoadLauncher.launch$default(EmoticonLoadLauncher.INSTANCE, emoticonResourceLoader$executeDownloadEmoticon$10, emoticonResourceLoader$executeDownloadEmoticon$20, emoticonResourceLoader$executeDownloadEmoticon$30, null, 8, null);
    }

    private final void executeLoadEmoticon(AnimatedItemImageContainer animatedItemImageContainer0, EmoticonLoadParam emoticonLoadParam0, EmoticonViewLoadListener emoticonViewLoadListener0) {
        this.setViewKey(animatedItemImageContainer0, emoticonLoadParam0.getKey());
        com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadEmoticon.1 emoticonResourceLoader$executeLoadEmoticon$10 = new k(null) {
            final EmoticonLoadParam $loadParam;
            Object L$0;
            int label;

            {
                this.$loadParam = emoticonLoadParam0;
                super(1, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@NotNull Continuation continuation0) {
                q.g(continuation0, "completion");
                return new com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadEmoticon.1(this.$loadParam, continuation0);
            }

            @Override  // we.k
            public final Object invoke(Object object0) {
                return ((com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadEmoticon.1)this.create(((Continuation)object0))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                Object object1;
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        String s = this.$loadParam.getResourceUrl();
                        EmoticonVersionSignature emoticonVersionSignature0 = this.$loadParam.getSignature();
                        this.label = 1;
                        object0 = EmoticonResourceLoader.INSTANCE.downloadFile(s, emoticonVersionSignature0, this.$loadParam.getEmoticonId(), this);
                        if(object0 == a0) {
                            return a0;
                        }
                        goto label_11;
                    }
                    case 1: {
                        d5.n.D(object0);
                    label_11:
                        object1 = null;
                        if(((File)object0) != null) {
                            String s1 = ((File)object0).getAbsolutePath();
                            if(s1 != null) {
                                if(this.$loadParam.isSoundCon()) {
                                    this.L$0 = s1;
                                    this.label = 2;
                                    Object object2 = EmoticonResourceLoader.INSTANCE.loadSoundPath(this.$loadParam, this);
                                    if(object2 == a0) {
                                        return a0;
                                    }
                                    object1 = (File)object2;
                                }
                                object1 = new m(s1, object1);
                            }
                        }
                        break;
                    }
                    case 2: {
                        String s2 = (String)this.L$0;
                        d5.n.D(object0);
                        object1 = new m(s2, ((File)object0));
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                q.d(object1);
                return object1;
            }
        };
        com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadEmoticon.2 emoticonResourceLoader$executeLoadEmoticon$20 = new n(emoticonLoadParam0, emoticonViewLoadListener0, null) {
            final EmoticonViewLoadListener $listener;
            final EmoticonLoadParam $loadParam;
            final AnimatedItemImageContainer $view;
            int label;
            private m p$0;

            {
                this.$view = animatedItemImageContainer0;
                this.$loadParam = emoticonLoadParam0;
                this.$listener = emoticonViewLoadListener0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                q.g(continuation0, "completion");
                Continuation continuation1 = new com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadEmoticon.2(this.$view, this.$loadParam, this.$listener, continuation0);
                continuation1.p$0 = (m)object0;
                return continuation1;
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadEmoticon.2)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                m m0 = this.p$0;
                EmoticonResourceLoader emoticonResourceLoader0 = EmoticonResourceLoader.INSTANCE;
                String s = this.$loadParam.getKey();
                if(emoticonResourceLoader0.isSameKeySet(this.$view, s)) {
                    Object object1 = m0.a;
                    emoticonResourceLoader0.setupSoundView(((File)m0.b), this.$view);
                    this.$view.setBackgroundResource(0);
                    switch(EmoticonResourceLoader.WhenMappings.$EnumSwitchMapping$0[this.$loadParam.getEmoticonType().ordinal()]) {
                        case 1: 
                        case 2: {
                            AnimatedItemImageLoader.INSTANCE.loadImage(this.$view, ((String)object1), Type.GIF, false);
                            break;
                        }
                        case 3: 
                        case 4: {
                            AnimatedItemImageLoader.INSTANCE.loadImage(this.$view, ((String)object1), Type.WEBP, false);
                            break;
                        }
                        case 5: {
                            Bitmap bitmap0 = SafetyBitmapFactory.decodeFile(((String)object1));
                            this.$view.setAnimatedImage(null);
                            this.$view.setImageBitmap(bitmap0);
                        }
                    }
                }
                EmoticonViewLoadListener emoticonViewLoadListener0 = this.$listener;
                if(emoticonViewLoadListener0 != null) {
                    emoticonViewLoadListener0.onLoadComplete();
                }
                return H.a;
            }
        };
        com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadEmoticon.3 emoticonResourceLoader$executeLoadEmoticon$30 = new n(emoticonViewLoadListener0, null) {
            final EmoticonViewLoadListener $listener;
            final AnimatedItemImageContainer $view;
            Object L$0;
            int label;
            private EmoticonApiError p$0;

            {
                this.$view = animatedItemImageContainer0;
                this.$listener = emoticonViewLoadListener0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                q.g(continuation0, "completion");
                Continuation continuation1 = new com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadEmoticon.3(this.$view, this.$listener, continuation0);
                continuation1.p$0 = (EmoticonApiError)object0;
                return continuation1;
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadEmoticon.3)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        this.L$0 = this.p$0;
                        this.label = 1;
                        if(EmoticonResourceLoader.INSTANCE.drawError(this.$view, this) == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        EmoticonApiError emoticonApiError0 = (EmoticonApiError)this.L$0;
                        d5.n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                EmoticonViewLoadListener emoticonViewLoadListener0 = this.$listener;
                if(emoticonViewLoadListener0 != null) {
                    emoticonViewLoadListener0.onLoadFailed();
                }
                return H.a;
            }
        };
        EmoticonLoadLauncher.launch$default(EmoticonLoadLauncher.INSTANCE, emoticonResourceLoader$executeLoadEmoticon$10, emoticonResourceLoader$executeLoadEmoticon$20, emoticonResourceLoader$executeLoadEmoticon$30, null, 8, null);
    }

    private final void executeLoadResource(ImageView imageView0, EmoticonLoadParam emoticonLoadParam0, EmoticonViewLoadListener emoticonViewLoadListener0) {
        this.setViewKey(imageView0, emoticonLoadParam0.getKey());
        com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadResource.1 emoticonResourceLoader$executeLoadResource$10 = new k(emoticonLoadParam0, null) {
            final EmoticonLoadParam $loadParam;
            final ImageView $view;
            int label;

            {
                this.$view = imageView0;
                this.$loadParam = emoticonLoadParam0;
                super(1, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@NotNull Continuation continuation0) {
                q.g(continuation0, "completion");
                return new com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadResource.1(this.$view, this.$loadParam, continuation0);
            }

            @Override  // we.k
            public final Object invoke(Object object0) {
                return ((com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadResource.1)this.create(((Continuation)object0))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        int v = this.$loadParam.getDrawType().getPlaceHolder();
                        this.label = 1;
                        if(EmoticonResourceLoader.INSTANCE.drawImageRes(this.$view, v, this) == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        d5.n.D(object0);
                        break;
                    }
                    case 2: {
                        d5.n.D(object0);
                        return object0;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadResource.1.1 emoticonResourceLoader$executeLoadResource$1$10 = new n(null) {
                    Object L$0;
                    Object L$1;
                    int label;
                    private CoroutineScope p$;

                    {
                        com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadResource.1.this = emoticonResourceLoader$executeLoadResource$10;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    @NotNull
                    public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                        q.g(continuation0, "completion");
                        Continuation continuation1 = new com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadResource.1.1(com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadResource.1.this, continuation0);
                        continuation1.p$ = (CoroutineScope)object0;
                        return continuation1;
                    }

                    @Override  // we.n
                    public final Object invoke(Object object0, Object object1) {
                        return ((com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadResource.1.1)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        CoroutineScope coroutineScope2;
                        CoroutineScope coroutineScope1;
                        a a0 = a.a;
                        switch(this.label) {
                            case 0: {
                                d5.n.D(object0);
                                CoroutineScope coroutineScope0 = this.p$;
                                EmoticonVersionSignature emoticonVersionSignature0 = com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadResource.1.this.$loadParam.getSignature();
                                this.L$0 = coroutineScope0;
                                this.label = 1;
                                Object object1 = EmoticonResourceLoader.INSTANCE.getBitmapFromCache(emoticonVersionSignature0, com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadResource.1.this.$loadParam.getEmoticonId(), this);
                                if(object1 == a0) {
                                    return a0;
                                }
                                coroutineScope1 = coroutineScope0;
                                object0 = object1;
                                goto label_15;
                            }
                            case 1: {
                                coroutineScope1 = (CoroutineScope)this.L$0;
                                d5.n.D(object0);
                            label_15:
                                if(((Bitmap)object0) != null) {
                                    return (Bitmap)object0;
                                }
                                int v = com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadResource.1.this.$loadParam.getDrawType().getPlaceHolder();
                                this.L$0 = coroutineScope1;
                                this.L$1 = coroutineScope1;
                                this.label = 2;
                                if(EmoticonResourceLoader.INSTANCE.drawImageRes(com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadResource.1.this.$view, v, this) == a0) {
                                    return a0;
                                }
                                coroutineScope2 = coroutineScope1;
                                goto label_27;
                            }
                            case 2: {
                                coroutineScope1 = (CoroutineScope)this.L$1;
                                coroutineScope2 = (CoroutineScope)this.L$0;
                                d5.n.D(object0);
                            label_27:
                                String s = com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadResource.1.this.$loadParam.getResourceUrl();
                                EmoticonVersionSignature emoticonVersionSignature1 = com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadResource.1.this.$loadParam.getSignature();
                                this.L$0 = coroutineScope2;
                                this.L$1 = coroutineScope1;
                                this.label = 3;
                                object0 = EmoticonResourceLoader.INSTANCE.getRemoteBitmap(s, emoticonVersionSignature1, com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadResource.1.this.$loadParam.getEmoticonId(), this);
                                if(object0 == a0) {
                                    return a0;
                                }
                                break;
                            }
                            case 3: {
                                CoroutineScope coroutineScope3 = (CoroutineScope)this.L$1;
                                CoroutineScope coroutineScope4 = (CoroutineScope)this.L$0;
                                d5.n.D(object0);
                                break;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                        q.d(((Bitmap)object0));
                        return (Bitmap)object0;
                    }
                };
                this.label = 2;
                Object object1 = BuildersKt.withContext(Dispatchers.getIO(), emoticonResourceLoader$executeLoadResource$1$10, this);
                return object1 == a0 ? a0 : object1;
            }
        };
        com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadResource.2 emoticonResourceLoader$executeLoadResource$20 = new n(emoticonLoadParam0, emoticonViewLoadListener0, null) {
            final EmoticonViewLoadListener $listener;
            final EmoticonLoadParam $loadParam;
            final ImageView $view;
            int label;
            private Bitmap p$0;

            {
                this.$view = imageView0;
                this.$loadParam = emoticonLoadParam0;
                this.$listener = emoticonViewLoadListener0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                q.g(continuation0, "completion");
                Continuation continuation1 = new com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadResource.2(this.$view, this.$loadParam, this.$listener, continuation0);
                continuation1.p$0 = (Bitmap)object0;
                return continuation1;
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadResource.2)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                Bitmap bitmap0 = this.p$0;
                String s = this.$loadParam.getKey();
                if(EmoticonResourceLoader.INSTANCE.isSameKeySet(this.$view, s)) {
                    this.$view.setBackgroundResource(0);
                    this.$view.setImageBitmap(bitmap0);
                }
                EmoticonViewLoadListener emoticonViewLoadListener0 = this.$listener;
                if(emoticonViewLoadListener0 != null) {
                    emoticonViewLoadListener0.onLoadComplete();
                }
                return H.a;
            }
        };
        com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadResource.3 emoticonResourceLoader$executeLoadResource$30 = new n(emoticonLoadParam0, emoticonViewLoadListener0, null) {
            final EmoticonViewLoadListener $listener;
            final EmoticonLoadParam $loadParam;
            final ImageView $view;
            Object L$0;
            int label;
            private EmoticonApiError p$0;

            {
                this.$view = imageView0;
                this.$loadParam = emoticonLoadParam0;
                this.$listener = emoticonViewLoadListener0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                q.g(continuation0, "completion");
                Continuation continuation1 = new com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadResource.3(this.$view, this.$loadParam, this.$listener, continuation0);
                continuation1.p$0 = (EmoticonApiError)object0;
                return continuation1;
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadResource.3)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        EmoticonApiError emoticonApiError0 = this.p$0;
                        int v = this.$loadParam.getDrawType().getPlaceHolder();
                        this.L$0 = emoticonApiError0;
                        this.label = 1;
                        if(EmoticonResourceLoader.INSTANCE.drawImageRes(this.$view, v, this) == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        EmoticonApiError emoticonApiError1 = (EmoticonApiError)this.L$0;
                        d5.n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                EmoticonViewLoadListener emoticonViewLoadListener0 = this.$listener;
                if(emoticonViewLoadListener0 != null) {
                    emoticonViewLoadListener0.onLoadFailed();
                }
                return H.a;
            }
        };
        EmoticonLoadLauncher.launch$default(EmoticonLoadLauncher.INSTANCE, emoticonResourceLoader$executeLoadResource$10, emoticonResourceLoader$executeLoadResource$20, emoticonResourceLoader$executeLoadResource$30, null, 8, null);
    }

    public static void executeLoadResource$default(EmoticonResourceLoader emoticonResourceLoader0, ImageView imageView0, EmoticonLoadParam emoticonLoadParam0, EmoticonViewLoadListener emoticonViewLoadListener0, int v, Object object0) {
        if((v & 4) != 0) {
            emoticonViewLoadListener0 = null;
        }
        emoticonResourceLoader0.executeLoadResource(imageView0, emoticonLoadParam0, emoticonViewLoadListener0);
    }

    private final void executeLoadUrl(ImageView imageView0, String s, EmoticonViewLoadListener emoticonViewLoadListener0) {
        this.setViewKey(imageView0, s);
        com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadUrl.1 emoticonResourceLoader$executeLoadUrl$10 = new k(null) {
            final String $url;
            int label;

            {
                this.$url = s;
                super(1, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@NotNull Continuation continuation0) {
                q.g(continuation0, "completion");
                return new com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadUrl.1(this.$url, continuation0);
            }

            @Override  // we.k
            public final Object invoke(Object object0) {
                return ((com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadUrl.1)this.create(((Continuation)object0))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        this.label = 1;
                        Object object1 = EmoticonResourceLoader.INSTANCE.getBitmapFromExternalUrl(this.$url, this);
                        return object1 == a0 ? a0 : object1;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return object0;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        };
        com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadUrl.2 emoticonResourceLoader$executeLoadUrl$20 = new n(s, emoticonViewLoadListener0, null) {
            final EmoticonViewLoadListener $listener;
            final String $url;
            final ImageView $view;
            int label;
            private Bitmap p$0;

            {
                this.$view = imageView0;
                this.$url = s;
                this.$listener = emoticonViewLoadListener0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                q.g(continuation0, "completion");
                Continuation continuation1 = new com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadUrl.2(this.$view, this.$url, this.$listener, continuation0);
                continuation1.p$0 = (Bitmap)object0;
                return continuation1;
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadUrl.2)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                Bitmap bitmap0 = this.p$0;
                if(EmoticonResourceLoader.INSTANCE.isSameKeySet(this.$view, this.$url)) {
                    this.$view.setImageBitmap(bitmap0);
                }
                EmoticonViewLoadListener emoticonViewLoadListener0 = this.$listener;
                if(emoticonViewLoadListener0 != null) {
                    emoticonViewLoadListener0.onLoadComplete();
                }
                return H.a;
            }
        };
        com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadUrl.3 emoticonResourceLoader$executeLoadUrl$30 = new n(emoticonViewLoadListener0, null) {
            final EmoticonViewLoadListener $listener;
            final ImageView $view;
            Object L$0;
            int label;
            private EmoticonApiError p$0;

            {
                this.$view = imageView0;
                this.$listener = emoticonViewLoadListener0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                q.g(continuation0, "completion");
                Continuation continuation1 = new com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadUrl.3(this.$view, this.$listener, continuation0);
                continuation1.p$0 = (EmoticonApiError)object0;
                return continuation1;
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((com.kakao.emoticon.controller.EmoticonResourceLoader.executeLoadUrl.3)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        this.L$0 = this.p$0;
                        this.label = 1;
                        if(EmoticonResourceLoader.INSTANCE.drawBackgroundRes(this.$view, drawable.emoticon_default_bg, this) == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        EmoticonApiError emoticonApiError0 = (EmoticonApiError)this.L$0;
                        d5.n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                EmoticonViewLoadListener emoticonViewLoadListener0 = this.$listener;
                if(emoticonViewLoadListener0 != null) {
                    emoticonViewLoadListener0.onLoadFailed();
                }
                return H.a;
            }
        };
        EmoticonLoadLauncher.launch$default(EmoticonLoadLauncher.INSTANCE, emoticonResourceLoader$executeLoadUrl$10, emoticonResourceLoader$executeLoadUrl$20, emoticonResourceLoader$executeLoadUrl$30, null, 8, null);
    }

    public static void executeLoadUrl$default(EmoticonResourceLoader emoticonResourceLoader0, ImageView imageView0, String s, EmoticonViewLoadListener emoticonViewLoadListener0, int v, Object object0) {
        if((v & 4) != 0) {
            emoticonViewLoadListener0 = null;
        }
        emoticonResourceLoader0.executeLoadUrl(imageView0, s, emoticonViewLoadListener0);
    }

    @Nullable
    public final Object getBitmapFromCache(@NotNull Key key0, @NotNull String s, @NotNull Continuation continuation0) {
        byte[] arr_b = MemoryLruCache.INSTANCE.getFromMemCache(key0);
        return arr_b != null ? SafetyBitmapFactory.decodeByteArray(arr_b, arr_b.length) : BuildersKt.withContext(Dispatchers.getIO(), new n(key0, null) {
            final String $dirKey;
            final Key $key;
            int label;
            private CoroutineScope p$;

            {
                this.$dirKey = s;
                this.$key = key0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                q.g(continuation0, "completion");
                Continuation continuation1 = new com.kakao.emoticon.controller.EmoticonResourceLoader.getBitmapFromCache.3(this.$dirKey, this.$key, continuation0);
                continuation1.p$ = (CoroutineScope)object0;
                return continuation1;
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((com.kakao.emoticon.controller.EmoticonResourceLoader.getBitmapFromCache.3)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                DiskCache diskCache0 = EmoticonResourceLoader.access$getDiskCacheFactory$p(EmoticonResourceLoader.INSTANCE).build(this.$dirKey);
                if(diskCache0 != null) {
                    File file0 = diskCache0.get(this.$key);
                    if(file0 != null) {
                        byte[] arr_b = j.B(file0);
                        MemoryLruCache.INSTANCE.addToMemoryCache(this.$key, arr_b);
                        return SafetyBitmapFactory.decodeByteArray(arr_b, arr_b.length);
                    }
                }
                return null;
            }
        }, continuation0);
    }

    @Nullable
    public final Object getBitmapFromExternalUrl(@NotNull String s, @NotNull Continuation continuation0) {
        EmoticonResourceLoader emoticonResourceLoader0;
        Object object1;
        kotlin.jvm.internal.H h0;
        com.kakao.emoticon.controller.EmoticonResourceLoader.getBitmapFromExternalUrl.1 emoticonResourceLoader$getBitmapFromExternalUrl$10;
        if(continuation0 instanceof com.kakao.emoticon.controller.EmoticonResourceLoader.getBitmapFromExternalUrl.1) {
            emoticonResourceLoader$getBitmapFromExternalUrl$10 = (com.kakao.emoticon.controller.EmoticonResourceLoader.getBitmapFromExternalUrl.1)continuation0;
            int v = emoticonResourceLoader$getBitmapFromExternalUrl$10.label;
            if((v & 0x80000000) == 0) {
                emoticonResourceLoader$getBitmapFromExternalUrl$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.getBitmapFromExternalUrl(null, this);
                    }
                };
            }
            else {
                emoticonResourceLoader$getBitmapFromExternalUrl$10.label = v ^ 0x80000000;
            }
        }
        else {
            emoticonResourceLoader$getBitmapFromExternalUrl$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                Object L$2;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.getBitmapFromExternalUrl(null, this);
                }
            };
        }
        Object object0 = emoticonResourceLoader$getBitmapFromExternalUrl$10.result;
        a a0 = a.a;
        switch(emoticonResourceLoader$getBitmapFromExternalUrl$10.label) {
            case 0: {
                h0 = b.p(object0);
                EmoticonVersionSignature emoticonVersionSignature0 = new EmoticonVersionSignature(s, 0);
                h0.a = emoticonVersionSignature0;
                emoticonResourceLoader$getBitmapFromExternalUrl$10.L$0 = this;
                emoticonResourceLoader$getBitmapFromExternalUrl$10.L$1 = s;
                emoticonResourceLoader$getBitmapFromExternalUrl$10.L$2 = h0;
                emoticonResourceLoader$getBitmapFromExternalUrl$10.label = 1;
                object1 = this.getBitmapFromCache(emoticonVersionSignature0, "external", emoticonResourceLoader$getBitmapFromExternalUrl$10);
                if(object1 == a0) {
                    return a0;
                }
                emoticonResourceLoader0 = this;
                goto label_31;
            }
            case 1: {
                kotlin.jvm.internal.H h1 = (kotlin.jvm.internal.H)emoticonResourceLoader$getBitmapFromExternalUrl$10.L$2;
                String s1 = (String)emoticonResourceLoader$getBitmapFromExternalUrl$10.L$1;
                emoticonResourceLoader0 = (EmoticonResourceLoader)emoticonResourceLoader$getBitmapFromExternalUrl$10.L$0;
                d5.n.D(object0);
                h0 = h1;
                s = s1;
                object1 = object0;
            label_31:
                if(((Bitmap)object1) != null) {
                    return (Bitmap)object1;
                }
                com.kakao.emoticon.controller.EmoticonResourceLoader.getBitmapFromExternalUrl.3 emoticonResourceLoader$getBitmapFromExternalUrl$30 = new n(h0, null) {
                    final kotlin.jvm.internal.H $signature;
                    final String $url;
                    Object L$0;
                    int label;
                    private CoroutineScope p$;

                    {
                        this.$url = s;
                        this.$signature = h0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    @NotNull
                    public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                        q.g(continuation0, "completion");
                        Continuation continuation1 = new com.kakao.emoticon.controller.EmoticonResourceLoader.getBitmapFromExternalUrl.3(this.$url, this.$signature, continuation0);
                        continuation1.p$ = (CoroutineScope)object0;
                        return continuation1;
                    }

                    @Override  // we.n
                    public final Object invoke(Object object0, Object object1) {
                        return ((com.kakao.emoticon.controller.EmoticonResourceLoader.getBitmapFromExternalUrl.3)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
                    }

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        a a0 = a.a;
                        switch(this.label) {
                            case 0: {
                                d5.n.D(object0);
                                CoroutineScope coroutineScope0 = this.p$;
                                EmoticonApiService emoticonApiService0 = EmoticonApiServiceImpl.INSTANCE.getApiClass();
                                this.L$0 = coroutineScope0;
                                this.label = 1;
                                object0 = emoticonApiService0.downloadFileWithDynamicUrl(this.$url, this);
                                if(object0 == a0) {
                                    return a0;
                                }
                                break;
                            }
                            case 1: {
                                CoroutineScope coroutineScope1 = (CoroutineScope)this.L$0;
                                d5.n.D(object0);
                                break;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                        DiskCache diskCache0 = EmoticonResourceLoader.access$getDiskCacheFactory$p(EmoticonResourceLoader.INSTANCE).build("external");
                        byte[] arr_b = ((ResponseBody)object0).source().getBuffer().snapshot().toByteArray();
                        if(diskCache0 != null) {
                            diskCache0.put(((EmoticonVersionSignature)this.$signature.a), new DataCacheWriter(new ByteArrayInputStream(arr_b)));
                        }
                        return SafetyBitmapFactory.decodeByteArray(arr_b, arr_b.length);
                    }
                };
                emoticonResourceLoader$getBitmapFromExternalUrl$10.L$0 = emoticonResourceLoader0;
                emoticonResourceLoader$getBitmapFromExternalUrl$10.L$1 = s;
                emoticonResourceLoader$getBitmapFromExternalUrl$10.L$2 = h0;
                emoticonResourceLoader$getBitmapFromExternalUrl$10.label = 2;
                object0 = BuildersKt.withContext(Dispatchers.getIO(), emoticonResourceLoader$getBitmapFromExternalUrl$30, emoticonResourceLoader$getBitmapFromExternalUrl$10);
                if(object0 == a0) {
                    return a0;
                }
                q.f(object0, "withContext(Dispatchers.…es, bytes.size)\n        }");
                return object0;
            }
            case 2: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        kotlin.jvm.internal.H h2 = (kotlin.jvm.internal.H)emoticonResourceLoader$getBitmapFromExternalUrl$10.L$2;
        String s2 = (String)emoticonResourceLoader$getBitmapFromExternalUrl$10.L$1;
        EmoticonResourceLoader emoticonResourceLoader1 = (EmoticonResourceLoader)emoticonResourceLoader$getBitmapFromExternalUrl$10.L$0;
        d5.n.D(object0);
        q.f(object0, "withContext(Dispatchers.…es, bytes.size)\n        }");
        return object0;
    }

    @Nullable
    public final Object getRemoteBitmap(@NotNull String s, @NotNull Key key0, @NotNull String s1, @NotNull Continuation continuation0) {
        EmoticonResourceLoader emoticonResourceLoader1;
        com.kakao.emoticon.controller.EmoticonResourceLoader.getRemoteBitmap.1 emoticonResourceLoader$getRemoteBitmap$10;
        if(continuation0 instanceof com.kakao.emoticon.controller.EmoticonResourceLoader.getRemoteBitmap.1) {
            emoticonResourceLoader$getRemoteBitmap$10 = (com.kakao.emoticon.controller.EmoticonResourceLoader.getRemoteBitmap.1)continuation0;
            int v = emoticonResourceLoader$getRemoteBitmap$10.label;
            if((v & 0x80000000) == 0) {
                emoticonResourceLoader$getRemoteBitmap$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return continuation0.getRemoteBitmap(null, null, null, this);
                    }
                };
            }
            else {
                emoticonResourceLoader$getRemoteBitmap$10.label = v ^ 0x80000000;
            }
        }
        else {
            emoticonResourceLoader$getRemoteBitmap$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return continuation0.getRemoteBitmap(null, null, null, this);
                }
            };
        }
        Object object0 = emoticonResourceLoader$getRemoteBitmap$10.result;
        a a0 = a.a;
        switch(emoticonResourceLoader$getRemoteBitmap$10.label) {
            case 0: {
                d5.n.D(object0);
                emoticonResourceLoader$getRemoteBitmap$10.L$0 = this;
                emoticonResourceLoader$getRemoteBitmap$10.L$1 = s;
                emoticonResourceLoader$getRemoteBitmap$10.L$2 = key0;
                emoticonResourceLoader$getRemoteBitmap$10.L$3 = s1;
                emoticonResourceLoader$getRemoteBitmap$10.label = 1;
                object0 = this.getBitmapFromCache(key0, s1, emoticonResourceLoader$getRemoteBitmap$10);
                if(object0 == a0) {
                    return a0;
                }
                emoticonResourceLoader1 = this;
                break;
            }
            case 1: {
                s1 = (String)emoticonResourceLoader$getRemoteBitmap$10.L$3;
                key0 = (Key)emoticonResourceLoader$getRemoteBitmap$10.L$2;
                s = (String)emoticonResourceLoader$getRemoteBitmap$10.L$1;
                emoticonResourceLoader1 = (EmoticonResourceLoader)emoticonResourceLoader$getRemoteBitmap$10.L$0;
                d5.n.D(object0);
                break;
            }
            case 2: {
                String s2 = (String)emoticonResourceLoader$getRemoteBitmap$10.L$3;
                Key key1 = (Key)emoticonResourceLoader$getRemoteBitmap$10.L$2;
                String s3 = (String)emoticonResourceLoader$getRemoteBitmap$10.L$1;
                EmoticonResourceLoader emoticonResourceLoader0 = (EmoticonResourceLoader)emoticonResourceLoader$getRemoteBitmap$10.L$0;
                d5.n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        if(((Bitmap)object0) != null) {
            return (Bitmap)object0;
        }
        com.kakao.emoticon.controller.EmoticonResourceLoader.getRemoteBitmap.3 emoticonResourceLoader$getRemoteBitmap$30 = new n(s1, key0, null) {
            final String $dirKey;
            final Key $key;
            final String $url;
            Object L$0;
            int label;
            private CoroutineScope p$;

            {
                this.$url = s;
                this.$dirKey = s1;
                this.$key = key0;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                q.g(continuation0, "completion");
                Continuation continuation1 = new com.kakao.emoticon.controller.EmoticonResourceLoader.getRemoteBitmap.3(this.$url, this.$dirKey, this.$key, continuation0);
                continuation1.p$ = (CoroutineScope)object0;
                return continuation1;
            }

            @Override  // we.n
            public final Object invoke(Object object0, Object object1) {
                return ((com.kakao.emoticon.controller.EmoticonResourceLoader.getRemoteBitmap.3)this.create(object0, ((Continuation)object1))).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        CoroutineScope coroutineScope0 = this.p$;
                        EmoticonApiService emoticonApiService0 = EmoticonApiServiceImpl.INSTANCE.getApiClass();
                        this.L$0 = coroutineScope0;
                        this.label = 1;
                        object0 = DefaultImpls.downloadEmoticonResource$default(emoticonApiService0, this.$url, null, this, 2, null);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        CoroutineScope coroutineScope1 = (CoroutineScope)this.L$0;
                        d5.n.D(object0);
                        break;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                DiskCache diskCache0 = EmoticonResourceLoader.access$getDiskCacheFactory$p(EmoticonResourceLoader.INSTANCE).build(this.$dirKey);
                byte[] arr_b = ((ResponseBody)object0).source().getBuffer().snapshot().toByteArray();
                MemoryLruCache.INSTANCE.addToMemoryCache(this.$key, arr_b);
                if(diskCache0 != null) {
                    DataCacheWriter dataCacheWriter0 = new DataCacheWriter(new ByteArrayInputStream(arr_b));
                    diskCache0.put(this.$key, dataCacheWriter0);
                }
                return SafetyBitmapFactory.decodeByteArray(arr_b, arr_b.length);
            }
        };
        emoticonResourceLoader$getRemoteBitmap$10.L$0 = emoticonResourceLoader1;
        emoticonResourceLoader$getRemoteBitmap$10.L$1 = s;
        emoticonResourceLoader$getRemoteBitmap$10.L$2 = key0;
        emoticonResourceLoader$getRemoteBitmap$10.L$3 = s1;
        emoticonResourceLoader$getRemoteBitmap$10.label = 2;
        Object object1 = BuildersKt.withContext(Dispatchers.getIO(), emoticonResourceLoader$getRemoteBitmap$30, emoticonResourceLoader$getRemoteBitmap$10);
        return object1 == a0 ? a0 : object1;
    }

    public final boolean isCachedItem(@NotNull Key key0, @NotNull String s) {
        q.g(key0, "key");
        q.g(s, "dirKey");
        DiskCache diskCache0 = EmoticonResourceLoader.diskCacheFactory.build(s);
        return (diskCache0 == null ? null : diskCache0.get(key0)) != null;
    }

    private final boolean isSameKeySet(Object object0, String s) {
        return q.b(((String)EmoticonResourceLoader.loadViewKeyMap.get(object0)), s);
    }

    public final void loadEmoticon(@NotNull AnimatedItemImageContainer animatedItemImageContainer0, @NotNull EmoticonViewParam emoticonViewParam0, @Nullable EmoticonViewLoadListener emoticonViewLoadListener0) {
        q.g(animatedItemImageContainer0, "view");
        q.g(emoticonViewParam0, "viewParam");
        this.executeLoadEmoticon(animatedItemImageContainer0, new EmoticonLoadParam(emoticonViewParam0, DrawType.EMOTICON), emoticonViewLoadListener0);
    }

    public static void loadEmoticon$default(EmoticonResourceLoader emoticonResourceLoader0, AnimatedItemImageContainer animatedItemImageContainer0, EmoticonViewParam emoticonViewParam0, EmoticonViewLoadListener emoticonViewLoadListener0, int v, Object object0) {
        if((v & 4) != 0) {
            emoticonViewLoadListener0 = null;
        }
        emoticonResourceLoader0.loadEmoticon(animatedItemImageContainer0, emoticonViewParam0, emoticonViewLoadListener0);
    }

    public final void loadOffIcon(@NotNull ImageView imageView0, @NotNull Emoticon emoticon0) {
        q.g(imageView0, "view");
        q.g(emoticon0, "emoticon");
        EmoticonResourceLoader.executeLoadResource$default(this, imageView0, new EmoticonLoadParam(emoticon0, DrawType.ICON_OFF), null, 4, null);
    }

    public final void loadOnIcon(@NotNull ImageView imageView0, @NotNull Emoticon emoticon0) {
        q.g(imageView0, "view");
        q.g(emoticon0, "emoticon");
        EmoticonResourceLoader.executeLoadResource$default(this, imageView0, new EmoticonLoadParam(emoticon0, DrawType.ICON_ON), null, 4, null);
    }

    @Nullable
    public final Object loadSoundPath(@NotNull EmoticonLoadParam emoticonLoadParam0, @NotNull Continuation continuation0) {
        if(!emoticonLoadParam0.isSoundCon()) {
            throw new EmoticonLoadException("this type does not support sound.");
        }
        EmoticonVersionSignature emoticonVersionSignature0 = new EmoticonVersionSignature(emoticonLoadParam0.getSoundUrl(), emoticonLoadParam0.getVersion());
        String s = emoticonLoadParam0.getSoundUrl();
        q.d(s);
        return this.downloadFile(s, emoticonVersionSignature0, emoticonLoadParam0.getEmoticonId(), continuation0);
    }

    public final void loadThumbnail(@NotNull ImageView imageView0, @NotNull EmoticonViewParam emoticonViewParam0, @Nullable EmoticonViewLoadListener emoticonViewLoadListener0) {
        q.g(imageView0, "view");
        q.g(emoticonViewParam0, "viewParam");
        this.executeLoadResource(imageView0, new EmoticonLoadParam(emoticonViewParam0, DrawType.THUMB), emoticonViewLoadListener0);
    }

    public static void loadThumbnail$default(EmoticonResourceLoader emoticonResourceLoader0, ImageView imageView0, EmoticonViewParam emoticonViewParam0, EmoticonViewLoadListener emoticonViewLoadListener0, int v, Object object0) {
        if((v & 4) != 0) {
            emoticonViewLoadListener0 = null;
        }
        emoticonResourceLoader0.loadThumbnail(imageView0, emoticonViewParam0, emoticonViewLoadListener0);
    }

    public final void loadTitle(@NotNull ImageView imageView0, @NotNull Emoticon emoticon0) {
        q.g(imageView0, "view");
        q.g(emoticon0, "emoticon");
        EmoticonResourceLoader.executeLoadResource$default(this, imageView0, new EmoticonLoadParam(emoticon0, DrawType.TITLE), null, 4, null);
    }

    public final void loadUrl(@NotNull ImageView imageView0, @NotNull String s, @Nullable EmoticonViewLoadListener emoticonViewLoadListener0) {
        q.g(imageView0, "view");
        q.g(s, "url");
        if(TextUtils.isEmpty(s)) {
            if(emoticonViewLoadListener0 != null) {
                emoticonViewLoadListener0.onLoadFailed();
            }
            return;
        }
        this.executeLoadUrl(imageView0, s, emoticonViewLoadListener0);
    }

    public static void loadUrl$default(EmoticonResourceLoader emoticonResourceLoader0, ImageView imageView0, String s, EmoticonViewLoadListener emoticonViewLoadListener0, int v, Object object0) {
        if((v & 4) != 0) {
            emoticonViewLoadListener0 = null;
        }
        emoticonResourceLoader0.loadUrl(imageView0, s, emoticonViewLoadListener0);
    }

    private final void setViewKey(Object object0, String s) {
        EmoticonResourceLoader.loadViewKeyMap.put(object0, s);
    }

    private final void setupSoundView(File file0, AnimatedItemImageContainer animatedItemImageContainer0) {
        if(file0 == null || !file0.exists()) {
            animatedItemImageContainer0.setPlayMethod(null);
            animatedItemImageContainer0.setSoundPath(null);
        }
        else {
            animatedItemImageContainer0.setPlayMethod(DigitalItemSoundPlay.INSTANCE);
            animatedItemImageContainer0.setSoundPath(file0.getPath());
        }
        if(animatedItemImageContainer0 instanceof EmoticonView && ((EmoticonView)animatedItemImageContainer0).isAutoSoundPlay()) {
            animatedItemImageContainer0.playSoundIfSoundEmoticon();
            return;
        }
        if(animatedItemImageContainer0 instanceof EmoticonSpan && ((EmoticonSpan)animatedItemImageContainer0).isAutoSoundPlay()) {
            animatedItemImageContainer0.playSoundIfSoundEmoticon();
        }
    }
}

