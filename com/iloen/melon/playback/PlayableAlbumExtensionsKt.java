package com.iloen.melon.playback;

import G8.f;
import android.net.Uri;
import android.text.TextUtils;
import com.iloen.melon.premium.PremiumContentsEntity;
import com.iloen.melon.utils.StorageUtils;
import com.iloen.melon.utils.image.ImageUrl;
import com.iloen.melon.utils.image.MelonImageFetcherType;
import com.iloen.melon.utils.image.MelonImageSource;
import d5.n;
import java.io.File;
import k9.d;
import k9.e;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\u001A\u001C\u0010\u0000\u001A\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u0005\u001A\u0016\u0010\u0006\u001A\u0004\u0018\u00010\u0007*\u0004\u0018\u00010\u0002H\u0086@¢\u0006\u0002\u0010\b\u001A\u0016\u0010\t\u001A\u0004\u0018\u00010\n*\u0004\u0018\u00010\u0002H\u0082@¢\u0006\u0002\u0010\b¨\u0006\u000B"}, d2 = {"getAlbumUri", "Lcom/iloen/melon/playback/PlayableAlbumUriData;", "Lcom/iloen/melon/playback/Playable;", "useOfflineImg", "", "(Lcom/iloen/melon/playback/Playable;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMediaImageSource", "Lcom/iloen/melon/utils/image/MelonImageSource;", "(Lcom/iloen/melon/playback/Playable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDisplayNameSafely", "", "app_playstoreProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 0x30)
public final class PlayableAlbumExtensionsKt {
    public static final Object access$getDisplayNameSafely(Playable playable0, Continuation continuation0) {
        return PlayableAlbumExtensionsKt.getDisplayNameSafely(playable0, continuation0);
    }

    @Nullable
    public static final Object getAlbumUri(@Nullable Playable playable0, boolean z, @NotNull Continuation continuation0) {
        H h3;
        H h2;
        H h1;
        H h0;
        com.iloen.melon.playback.PlayableAlbumExtensionsKt.getAlbumUri.1 playableAlbumExtensionsKt$getAlbumUri$10;
        if(continuation0 instanceof com.iloen.melon.playback.PlayableAlbumExtensionsKt.getAlbumUri.1) {
            playableAlbumExtensionsKt$getAlbumUri$10 = (com.iloen.melon.playback.PlayableAlbumExtensionsKt.getAlbumUri.1)continuation0;
            int v = playableAlbumExtensionsKt$getAlbumUri$10.label;
            if((v & 0x80000000) == 0) {
                playableAlbumExtensionsKt$getAlbumUri$10 = new c(continuation0) {
                    int I$0;
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    boolean Z$0;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return PlayableAlbumExtensionsKt.getAlbumUri(null, false, this);
                    }
                };
            }
            else {
                playableAlbumExtensionsKt$getAlbumUri$10.label = v ^ 0x80000000;
            }
        }
        else {
            playableAlbumExtensionsKt$getAlbumUri$10 = new c(continuation0) {
                int I$0;
                Object L$0;
                Object L$1;
                Object L$2;
                Object L$3;
                boolean Z$0;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return PlayableAlbumExtensionsKt.getAlbumUri(null, false, this);
                }
            };
        }
        Object object0 = playableAlbumExtensionsKt$getAlbumUri$10.result;
        a a0 = a.a;
        boolean z1 = true;
        switch(playableAlbumExtensionsKt$getAlbumUri$10.label) {
            case 0: {
                n.D(object0);
                if(playable0 == null) {
                    Uri uri0 = Uri.EMPTY;
                    q.f(uri0, "EMPTY");
                    q.f(uri0, "EMPTY");
                    return new PlayableAlbumUriData(uri0, uri0);
                }
                playableAlbumExtensionsKt$getAlbumUri$10.L$0 = playable0;
                playableAlbumExtensionsKt$getAlbumUri$10.Z$0 = z;
                playableAlbumExtensionsKt$getAlbumUri$10.label = 1;
                object0 = PlayableAlbumExtensionsKt.getMediaImageSource(playable0, playableAlbumExtensionsKt$getAlbumUri$10);
                if(object0 == a0) {
                    return a0;
                }
                goto label_29;
            }
            case 1: {
                z = playableAlbumExtensionsKt$getAlbumUri$10.Z$0;
                playable0 = (Playable)playableAlbumExtensionsKt$getAlbumUri$10.L$0;
                n.D(object0);
            label_29:
                if(MelonImageSource.NETWORK == ((MelonImageSource)object0)) {
                    h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
                    Uri uri1 = Uri.EMPTY;
                    h0.a = uri1;
                    h1 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
                    h1.a = uri1;
                    if(!z) {
                        goto label_65;
                    }
                    com.iloen.melon.playback.PlayableAlbumExtensionsKt.getAlbumUri.2 playableAlbumExtensionsKt$getAlbumUri$20 = new we.n(playable0, h0, h1, null) {
                        final H $largeAlbumUri;
                        final H $smallAlbumUri;
                        final Playable $this_getAlbumUri;
                        int label;

                        {
                            this.$this_getAlbumUri = playable0;
                            this.$smallAlbumUri = h0;
                            this.$largeAlbumUri = h1;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.playback.PlayableAlbumExtensionsKt.getAlbumUri.2(this.$this_getAlbumUri, this.$smallAlbumUri, this.$largeAlbumUri, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.playback.PlayableAlbumExtensionsKt.getAlbumUri.2)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            if(this.label != 0) {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                            n.D(object0);
                            PremiumContentsEntity premiumContentsEntity0 = e.b(this.$this_getAlbumUri.getSongidString(), this.$this_getAlbumUri.getCtype().getValue());
                            if(premiumContentsEntity0 != null) {
                                String s = ImageUrl.getOfflineImagePath(MelonImageFetcherType.Small, premiumContentsEntity0);
                                File file0 = new File(d.a, s);
                                String s1 = ImageUrl.getOfflineImagePath(MelonImageFetcherType.Large, premiumContentsEntity0);
                                File file1 = new File(d.a, s1);
                                if(file0.exists()) {
                                    H h0 = this.$smallAlbumUri;
                                    Uri uri0 = Uri.fromFile(file0);
                                    if(uri0 == null) {
                                        uri0 = Uri.EMPTY;
                                    }
                                    h0.a = uri0;
                                }
                                if(file1.exists()) {
                                    H h1 = this.$largeAlbumUri;
                                    Uri uri1 = Uri.fromFile(file1);
                                    if(uri1 == null) {
                                        uri1 = Uri.EMPTY;
                                    }
                                    h1.a = uri1;
                                }
                            }
                            return ie.H.a;
                        }
                    };
                    playableAlbumExtensionsKt$getAlbumUri$10.L$0 = playable0;
                    playableAlbumExtensionsKt$getAlbumUri$10.L$1 = null;
                    playableAlbumExtensionsKt$getAlbumUri$10.L$2 = h0;
                    playableAlbumExtensionsKt$getAlbumUri$10.L$3 = h1;
                    playableAlbumExtensionsKt$getAlbumUri$10.Z$0 = true;
                    playableAlbumExtensionsKt$getAlbumUri$10.label = 2;
                    if(BuildersKt.withContext(Dispatchers.getIO(), playableAlbumExtensionsKt$getAlbumUri$20, playableAlbumExtensionsKt$getAlbumUri$10) == a0) {
                        return a0;
                    }
                    h2 = h0;
                    h3 = h1;
                    goto label_63;
                }
                if(!playable0.isTypeOfMv() && !playable0.isTypeOfLive()) {
                    z1 = false;
                }
                com.iloen.melon.playback.PlayableAlbumExtensionsKt.getAlbumUri.3 playableAlbumExtensionsKt$getAlbumUri$30 = new we.n(z1, playable0, null) {
                    final boolean $isVideoType;
                    final Playable $this_getAlbumUri;
                    Object L$0;
                    int label;

                    {
                        this.$isVideoType = z;
                        this.$this_getAlbumUri = playable0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.playback.PlayableAlbumExtensionsKt.getAlbumUri.3(this.$isVideoType, this.$this_getAlbumUri, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.playback.PlayableAlbumExtensionsKt.getAlbumUri.3)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        a a0 = a.a;
                        switch(this.label) {
                            case 0: {
                                n.D(object0);
                                if(this.$isVideoType && this.$this_getAlbumUri.isOriginLocal()) {
                                    return ImageUrl.getBestVideoThumbnailUri(this.$this_getAlbumUri.getMediaStoreAlbumId(), "");
                                }
                                boolean z = !StorageUtils.isScopedStorage();
                                q.d("");
                                this.L$0 = null;
                                this.label = 1;
                                object0 = f.a.a(null, "", this.$this_getAlbumUri.getMediaStoreAlbumId(), "", this);
                                return object0 == a0 ? a0 : ((Uri)object0);
                            }
                            case 1: {
                                String s = (String)this.L$0;
                                n.D(object0);
                                return (Uri)object0;
                            }
                            default: {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                        }
                    }
                };
                playableAlbumExtensionsKt$getAlbumUri$10.L$0 = null;
                playableAlbumExtensionsKt$getAlbumUri$10.L$1 = null;
                playableAlbumExtensionsKt$getAlbumUri$10.Z$0 = z;
                playableAlbumExtensionsKt$getAlbumUri$10.I$0 = z1;
                playableAlbumExtensionsKt$getAlbumUri$10.label = 3;
                object0 = BuildersKt.withContext(Dispatchers.getIO(), playableAlbumExtensionsKt$getAlbumUri$30, playableAlbumExtensionsKt$getAlbumUri$10);
                if(object0 == a0) {
                    return a0;
                }
                goto label_78;
            }
            case 2: {
                h3 = (H)playableAlbumExtensionsKt$getAlbumUri$10.L$3;
                h2 = (H)playableAlbumExtensionsKt$getAlbumUri$10.L$2;
                MelonImageSource melonImageSource0 = (MelonImageSource)playableAlbumExtensionsKt$getAlbumUri$10.L$1;
                Playable playable1 = (Playable)playableAlbumExtensionsKt$getAlbumUri$10.L$0;
                n.D(object0);
            label_63:
                h1 = h3;
                h0 = h2;
            label_65:
                Uri uri2 = Uri.EMPTY;
                if(q.b(h0.a, uri2)) {
                    h0.a = uri2;
                }
                if(q.b(h1.a, uri2)) {
                    h1.a = uri2;
                }
                Object object1 = h0.a;
                q.f(object1, "element");
                Object object2 = h1.a;
                q.f(object2, "element");
                return new PlayableAlbumUriData(((Uri)object1), ((Uri)object2));
            }
            case 3: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        MelonImageSource melonImageSource1 = (MelonImageSource)playableAlbumExtensionsKt$getAlbumUri$10.L$1;
        Playable playable2 = (Playable)playableAlbumExtensionsKt$getAlbumUri$10.L$0;
        n.D(object0);
    label_78:
        Uri uri3 = (Uri)object0;
        Uri uri4 = uri3 == null ? Uri.EMPTY : uri3;
        q.d(uri4);
        if(uri3 == null) {
            uri3 = Uri.EMPTY;
        }
        q.d(uri3);
        return new PlayableAlbumUriData(uri4, uri3);
    }

    private static final Object getDisplayNameSafely(Playable playable0, Continuation continuation0) {
        return BuildersKt.withContext(Dispatchers.getIO(), new we.n(playable0, null) {
            final Playable $this_getDisplayNameSafely;
            int label;

            {
                this.$this_getDisplayNameSafely = playable0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.playback.PlayableAlbumExtensionsKt.getDisplayNameSafely.2(this.$this_getDisplayNameSafely, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.playback.PlayableAlbumExtensionsKt.getDisplayNameSafely.2)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                n.D(object0);
                Playable playable0 = this.$this_getDisplayNameSafely;
                return playable0 != null ? playable0.getDisplayName() : null;
            }
        }, continuation0);
    }

    @Nullable
    public static final Object getMediaImageSource(@Nullable Playable playable0, @NotNull Continuation continuation0) {
        com.iloen.melon.playback.PlayableAlbumExtensionsKt.getMediaImageSource.1 playableAlbumExtensionsKt$getMediaImageSource$10;
        if(continuation0 instanceof com.iloen.melon.playback.PlayableAlbumExtensionsKt.getMediaImageSource.1) {
            playableAlbumExtensionsKt$getMediaImageSource$10 = (com.iloen.melon.playback.PlayableAlbumExtensionsKt.getMediaImageSource.1)continuation0;
            int v = playableAlbumExtensionsKt$getMediaImageSource$10.label;
            if((v & 0x80000000) == 0) {
                playableAlbumExtensionsKt$getMediaImageSource$10 = new c(continuation0) {
                    Object L$0;
                    int label;
                    Object result;

                    @Override  // oe.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object object0) {
                        this.result = object0;
                        this.label |= 0x80000000;
                        return PlayableAlbumExtensionsKt.getMediaImageSource(null, this);
                    }
                };
            }
            else {
                playableAlbumExtensionsKt$getMediaImageSource$10.label = v ^ 0x80000000;
            }
        }
        else {
            playableAlbumExtensionsKt$getMediaImageSource$10 = new c(continuation0) {
                Object L$0;
                int label;
                Object result;

                @Override  // oe.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object object0) {
                    this.result = object0;
                    this.label |= 0x80000000;
                    return PlayableAlbumExtensionsKt.getMediaImageSource(null, this);
                }
            };
        }
        Object object0 = playableAlbumExtensionsKt$getMediaImageSource$10.result;
        a a0 = a.a;
        switch(playableAlbumExtensionsKt$getMediaImageSource$10.label) {
            case 0: {
                n.D(object0);
                if(playable0 != null) {
                    if(playable0.isOriginLocal()) {
                        playableAlbumExtensionsKt$getMediaImageSource$10.L$0 = playable0;
                        playableAlbumExtensionsKt$getMediaImageSource$10.label = 1;
                        object0 = PlayableAlbumExtensionsKt.getDisplayNameSafely(playable0, playableAlbumExtensionsKt$getMediaImageSource$10);
                        if(object0 == a0) {
                            return a0;
                        }
                        goto label_23;
                    }
                    goto label_25;
                }
                break;
            }
            case 1: {
                playable0 = (Playable)playableAlbumExtensionsKt$getMediaImageSource$10.L$0;
                n.D(object0);
            label_23:
                if(!TextUtils.isEmpty(((CharSequence)object0))) {
                    return MelonImageSource.INTERNAL;
                }
            label_25:
                if(playable0.hasSongId()) {
                    return MelonImageSource.NETWORK;
                }
                if(playable0.hasMv()) {
                    return MelonImageSource.NETWORK;
                }
                if(playable0.isTypeOfLive()) {
                    return MelonImageSource.NETWORK;
                }
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return null;
    }
}

