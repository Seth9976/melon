package com.airbnb.lottie.compose;

import Tf.v;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieTask;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import d5.n;
import e1.u;
import i.n.i.b.a.s.e.M3;
import ie.H;
import ie.o;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipInputStream;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import va.e;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001Ao\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0001\u001A\u00020\u00002\n\b\u0002\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0004\u001A\u00020\u00022\b\b\u0002\u0010\u0005\u001A\u00020\u00022\n\b\u0002\u0010\u0006\u001A\u0004\u0018\u00010\u00022*\b\u0002\u0010\r\u001A$\b\u0001\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000B0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0007H\u0007\u00A2\u0006\u0004\b\u000F\u0010\u0010\u001AF\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0001\u001A\u00020\u00002\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\b\u0010\u0004\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001A\u00020\u00022\b\u0010\u0006\u001A\u0004\u0018\u00010\u0002H\u0082@\u00A2\u0006\u0004\b\u0014\u0010\u0015\u001A9\u0010\u0018\u001A\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00172\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0001\u001A\u00020\u00002\b\u0010\u0006\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b\u0018\u0010\u0019\u001A \u0010\u001B\u001A\u00028\u0000\"\u0004\b\u0000\u0010\u001A*\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0082@\u00A2\u0006\u0004\b\u001B\u0010\u001C\u001A*\u0010\u001F\u001A\u00020\u001E2\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u001D\u001A\u00020\u00132\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0082@\u00A2\u0006\u0004\b\u001F\u0010 \u001A)\u0010#\u001A\u00020\u001E2\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\"\u001A\u00020!2\b\u0010\u0003\u001A\u0004\u0018\u00010\u0002H\u0002\u00A2\u0006\u0004\b#\u0010$\u001A\u0017\u0010%\u001A\u00020\u001E2\u0006\u0010\"\u001A\u00020!H\u0002\u00A2\u0006\u0004\b%\u0010&\u001A2\u0010\'\u001A\u00020\u001E2\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u001D\u001A\u00020\u00132\b\u0010\u0004\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001A\u00020\u0002H\u0082@\u00A2\u0006\u0004\b\'\u0010(\u001A1\u0010+\u001A\u00020\u001E2\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010*\u001A\u00020)2\b\u0010\u0004\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001A\u00020\u0002H\u0002\u00A2\u0006\u0004\b+\u0010,\u001A!\u00100\u001A\u0004\u0018\u00010-2\u0006\u0010.\u001A\u00020-2\u0006\u0010/\u001A\u00020\u0002H\u0002\u00A2\u0006\u0004\b0\u00101\u001A\u0017\u00102\u001A\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0002H\u0002\u00A2\u0006\u0004\b2\u00103\u001A\u0013\u00104\u001A\u00020\u0002*\u00020\u0002H\u0002\u00A2\u0006\u0004\b4\u00103\"\u0014\u00105\u001A\u00020\u00028\u0002X\u0082T\u00A2\u0006\u0006\n\u0004\b5\u00106\u00A8\u00069\u00B2\u0006\f\u00108\u001A\u0002078\nX\u008A\u0084\u0002"}, d2 = {"Lcom/airbnb/lottie/compose/LottieCompositionSpec;", "spec", "", "imageAssetsFolder", "fontAssetsFolder", "fontFileExtension", "cacheKey", "Lkotlin/Function3;", "", "", "Lkotlin/coroutines/Continuation;", "", "", "onRetry", "Lcom/airbnb/lottie/compose/LottieCompositionResult;", "rememberLottieComposition", "(Lcom/airbnb/lottie/compose/LottieCompositionSpec;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lwe/o;Landroidx/compose/runtime/l;II)Lcom/airbnb/lottie/compose/LottieCompositionResult;", "Landroid/content/Context;", "context", "Lcom/airbnb/lottie/LottieComposition;", "lottieComposition", "(Landroid/content/Context;Lcom/airbnb/lottie/compose/LottieCompositionSpec;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isWarmingCache", "Lcom/airbnb/lottie/LottieTask;", "lottieTask", "(Landroid/content/Context;Lcom/airbnb/lottie/compose/LottieCompositionSpec;Ljava/lang/String;Z)Lcom/airbnb/lottie/LottieTask;", "T", "await", "(Lcom/airbnb/lottie/LottieTask;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "composition", "Lie/H;", "loadImagesFromAssets", "(Landroid/content/Context;Lcom/airbnb/lottie/LottieComposition;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/airbnb/lottie/LottieImageAsset;", "asset", "maybeLoadImageFromAsset", "(Landroid/content/Context;Lcom/airbnb/lottie/LottieImageAsset;Ljava/lang/String;)V", "maybeDecodeBase64Image", "(Lcom/airbnb/lottie/LottieImageAsset;)V", "loadFontsFromAssets", "(Landroid/content/Context;Lcom/airbnb/lottie/LottieComposition;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/airbnb/lottie/model/Font;", "font", "maybeLoadTypefaceFromAssets", "(Landroid/content/Context;Lcom/airbnb/lottie/model/Font;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/graphics/Typeface;", "typeface", "style", "typefaceForStyle", "(Landroid/graphics/Typeface;Ljava/lang/String;)Landroid/graphics/Typeface;", "ensureTrailingSlash", "(Ljava/lang/String;)Ljava/lang/String;", "ensureLeadingPeriod", "DefaultCacheKey", "Ljava/lang/String;", "Lcom/airbnb/lottie/compose/LottieCompositionResultImpl;", "result", "lottie-compose_release"}, k = 2, mv = {1, 9, 0}, xi = 0x30)
public final class RememberLottieCompositionKt {
    @NotNull
    private static final String DefaultCacheKey = "__LottieInternalDefaultCacheKey__";

    public static final Object access$await(LottieTask lottieTask0, Continuation continuation0) {
        return RememberLottieCompositionKt.await(lottieTask0, continuation0);
    }

    public static final Object access$loadFontsFromAssets(Context context0, LottieComposition lottieComposition0, String s, String s1, Continuation continuation0) {
        return RememberLottieCompositionKt.loadFontsFromAssets(context0, lottieComposition0, s, s1, continuation0);
    }

    public static final Object access$loadImagesFromAssets(Context context0, LottieComposition lottieComposition0, String s, Continuation continuation0) {
        return RememberLottieCompositionKt.loadImagesFromAssets(context0, lottieComposition0, s, continuation0);
    }

    private static final Object await(LottieTask lottieTask0, Continuation continuation0) {
        CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(continuation0), 1);
        cancellableContinuationImpl0.initCancellability();
        lottieTask0.addListener(new LottieListener() {
            @Override  // com.airbnb.lottie.LottieListener
            public final void onResult(Object object0) {
                if(!cancellableContinuationImpl0.isCompleted()) {
                    cancellableContinuationImpl0.resumeWith(object0);
                }
            }
        }).addFailureListener(new LottieListener() {
            @Override  // com.airbnb.lottie.LottieListener
            public void onResult(Object object0) {
                this.onResult(((Throwable)object0));
            }

            public final void onResult(Throwable throwable0) {
                if(!cancellableContinuationImpl0.isCompleted()) {
                    q.d(throwable0);
                    o o0 = n.t(throwable0);
                    cancellableContinuationImpl0.resumeWith(o0);
                }
            }
        });
        return cancellableContinuationImpl0.getResult();
    }

    // 去混淆评级： 低(20)
    private static final String ensureLeadingPeriod(String s) {
        return !Tf.o.H0(s) && !v.r0(s, ".", false) ? "." + s : s;
    }

    private static final String ensureTrailingSlash(String s) {
        if(s != null && !Tf.o.H0(s)) {
            return Tf.o.A0(s, '/') ? s : s + "/";
        }
        return null;
    }

    private static final Object loadFontsFromAssets(Context context0, LottieComposition lottieComposition0, String s, String s1, Continuation continuation0) {
        H h0 = H.a;
        if(lottieComposition0.getFonts().isEmpty()) {
            return h0;
        }
        Object object0 = BuildersKt.withContext(Dispatchers.getIO(), new we.n(lottieComposition0, context0, s, s1, null) {
            final LottieComposition $composition;
            final Context $context;
            final String $fontAssetsFolder;
            final String $fontFileExtension;
            int label;

            {
                this.$composition = lottieComposition0;
                this.$context = context0;
                this.$fontAssetsFolder = s;
                this.$fontFileExtension = s1;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new com.airbnb.lottie.compose.RememberLottieCompositionKt.loadFontsFromAssets.2(this.$composition, this.$context, this.$fontAssetsFolder, this.$fontFileExtension, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope0, @Nullable Continuation continuation0) {
                return ((com.airbnb.lottie.compose.RememberLottieCompositionKt.loadFontsFromAssets.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                n.D(object0);
                for(Object object1: this.$composition.getFonts().values()) {
                    q.d(((Font)object1));
                    RememberLottieCompositionKt.maybeLoadTypefaceFromAssets(this.$context, ((Font)object1), this.$fontAssetsFolder, this.$fontFileExtension);
                }
                return H.a;
            }
        }, continuation0);
        return object0 == a.a ? object0 : h0;
    }

    private static final Object loadImagesFromAssets(Context context0, LottieComposition lottieComposition0, String s, Continuation continuation0) {
        H h0 = H.a;
        if(!lottieComposition0.hasImages()) {
            return h0;
        }
        Object object0 = BuildersKt.withContext(Dispatchers.getIO(), new we.n(lottieComposition0, context0, s, null) {
            final LottieComposition $composition;
            final Context $context;
            final String $imageAssetsFolder;
            int label;

            {
                this.$composition = lottieComposition0;
                this.$context = context0;
                this.$imageAssetsFolder = s;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new com.airbnb.lottie.compose.RememberLottieCompositionKt.loadImagesFromAssets.2(this.$composition, this.$context, this.$imageAssetsFolder, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope0, @Nullable Continuation continuation0) {
                return ((com.airbnb.lottie.compose.RememberLottieCompositionKt.loadImagesFromAssets.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                n.D(object0);
                for(Object object1: this.$composition.getImages().values()) {
                    q.d(((LottieImageAsset)object1));
                    RememberLottieCompositionKt.maybeDecodeBase64Image(((LottieImageAsset)object1));
                    RememberLottieCompositionKt.maybeLoadImageFromAsset(this.$context, ((LottieImageAsset)object1), this.$imageAssetsFolder);
                }
                return H.a;
            }
        }, continuation0);
        return object0 == a.a ? object0 : h0;
    }

    private static final Object lottieComposition(Context context0, LottieCompositionSpec lottieCompositionSpec0, String s, String s1, String s2, String s3, Continuation continuation0) {
        String s5;
        LottieComposition lottieComposition1;
        Context context1;
        String s4;
        com.airbnb.lottie.compose.RememberLottieCompositionKt.lottieComposition.1 rememberLottieCompositionKt$lottieComposition$10;
        if(continuation0 instanceof com.airbnb.lottie.compose.RememberLottieCompositionKt.lottieComposition.1) {
            rememberLottieCompositionKt$lottieComposition$10 = (com.airbnb.lottie.compose.RememberLottieCompositionKt.lottieComposition.1)continuation0;
            int v = rememberLottieCompositionKt$lottieComposition$10.label;
            if((v & 0x80000000) == 0) {
                rememberLottieCompositionKt$lottieComposition$10 = new c(continuation0) {
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
                        return RememberLottieCompositionKt.lottieComposition(null, null, null, null, null, null, this);
                    }
                };
            }
            else {
                rememberLottieCompositionKt$lottieComposition$10.label = v ^ 0x80000000;
            }
        }
        else {
            rememberLottieCompositionKt$lottieComposition$10 = new c(continuation0) {
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
                    return RememberLottieCompositionKt.lottieComposition(null, null, null, null, null, null, this);
                }
            };
        }
        Object object0 = rememberLottieCompositionKt$lottieComposition$10.result;
        a a0 = a.a;
        switch(rememberLottieCompositionKt$lottieComposition$10.label) {
            case 0: {
                n.D(object0);
                LottieTask lottieTask0 = RememberLottieCompositionKt.lottieTask(context0, lottieCompositionSpec0, s3, false);
                if(lottieTask0 == null) {
                    throw new IllegalArgumentException(("Unable to create parsing task for " + lottieCompositionSpec0 + ".").toString());
                }
                rememberLottieCompositionKt$lottieComposition$10.L$0 = context0;
                rememberLottieCompositionKt$lottieComposition$10.L$1 = s;
                rememberLottieCompositionKt$lottieComposition$10.L$2 = s1;
                rememberLottieCompositionKt$lottieComposition$10.L$3 = s2;
                rememberLottieCompositionKt$lottieComposition$10.label = 1;
                object0 = RememberLottieCompositionKt.await(lottieTask0, rememberLottieCompositionKt$lottieComposition$10);
                if(object0 == a0) {
                    return a0;
                }
                goto label_33;
            }
            case 1: {
                s2 = (String)rememberLottieCompositionKt$lottieComposition$10.L$3;
                s1 = (String)rememberLottieCompositionKt$lottieComposition$10.L$2;
                s = (String)rememberLottieCompositionKt$lottieComposition$10.L$1;
                context0 = (Context)rememberLottieCompositionKt$lottieComposition$10.L$0;
                n.D(object0);
            label_33:
                rememberLottieCompositionKt$lottieComposition$10.L$0 = context0;
                rememberLottieCompositionKt$lottieComposition$10.L$1 = s1;
                rememberLottieCompositionKt$lottieComposition$10.L$2 = s2;
                rememberLottieCompositionKt$lottieComposition$10.L$3 = (LottieComposition)object0;
                rememberLottieCompositionKt$lottieComposition$10.label = 2;
                if(RememberLottieCompositionKt.loadImagesFromAssets(context0, ((LottieComposition)object0), s, rememberLottieCompositionKt$lottieComposition$10) == a0) {
                    return a0;
                }
                s4 = s1;
                context1 = context0;
                lottieComposition1 = (LottieComposition)object0;
                s5 = s2;
                break;
            }
            case 2: {
                lottieComposition1 = (LottieComposition)rememberLottieCompositionKt$lottieComposition$10.L$3;
                s5 = (String)rememberLottieCompositionKt$lottieComposition$10.L$2;
                s4 = (String)rememberLottieCompositionKt$lottieComposition$10.L$1;
                context1 = (Context)rememberLottieCompositionKt$lottieComposition$10.L$0;
                n.D(object0);
                break;
            }
            case 3: {
                LottieComposition lottieComposition0 = (LottieComposition)rememberLottieCompositionKt$lottieComposition$10.L$0;
                n.D(object0);
                return lottieComposition0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        rememberLottieCompositionKt$lottieComposition$10.L$0 = lottieComposition1;
        rememberLottieCompositionKt$lottieComposition$10.L$1 = null;
        rememberLottieCompositionKt$lottieComposition$10.L$2 = null;
        rememberLottieCompositionKt$lottieComposition$10.L$3 = null;
        rememberLottieCompositionKt$lottieComposition$10.label = 3;
        return RememberLottieCompositionKt.loadFontsFromAssets(context1, lottieComposition1, s4, s5, rememberLottieCompositionKt$lottieComposition$10) == a0 ? a0 : lottieComposition1;
    }

    private static final LottieTask lottieTask(Context context0, LottieCompositionSpec lottieCompositionSpec0, String s, boolean z) {
        if(lottieCompositionSpec0 instanceof RawRes) {
            return q.b(s, "__LottieInternalDefaultCacheKey__") ? LottieCompositionFactory.fromRawRes(context0, ((RawRes)lottieCompositionSpec0).unbox-impl()) : LottieCompositionFactory.fromRawRes(context0, ((RawRes)lottieCompositionSpec0).unbox-impl(), s);
        }
        if(lottieCompositionSpec0 instanceof Url) {
            return q.b(s, "__LottieInternalDefaultCacheKey__") ? LottieCompositionFactory.fromUrl(context0, ((Url)lottieCompositionSpec0).unbox-impl()) : LottieCompositionFactory.fromUrl(context0, ((Url)lottieCompositionSpec0).unbox-impl(), s);
        }
        if(lottieCompositionSpec0 instanceof File) {
            if(z) {
                return null;
            }
            FileInputStream fileInputStream0 = new FileInputStream(((File)lottieCompositionSpec0).unbox-impl());
            if(q.b(s, "__LottieInternalDefaultCacheKey__")) {
                s = ((File)lottieCompositionSpec0).unbox-impl();
            }
            if(v.i0(((File)lottieCompositionSpec0).unbox-impl(), "zip", false)) {
                return LottieCompositionFactory.fromZipStream(new ZipInputStream(fileInputStream0), s);
            }
            return v.i0(((File)lottieCompositionSpec0).unbox-impl(), "tgs", false) ? LottieCompositionFactory.fromJsonInputStream(new GZIPInputStream(fileInputStream0), s) : LottieCompositionFactory.fromJsonInputStream(fileInputStream0, s);
        }
        if(lottieCompositionSpec0 instanceof Asset) {
            return q.b(s, "__LottieInternalDefaultCacheKey__") ? LottieCompositionFactory.fromAsset(context0, ((Asset)lottieCompositionSpec0).unbox-impl()) : LottieCompositionFactory.fromAsset(context0, ((Asset)lottieCompositionSpec0).unbox-impl(), s);
        }
        if(lottieCompositionSpec0 instanceof JsonString) {
            if(q.b(s, "__LottieInternalDefaultCacheKey__")) {
                s = String.valueOf(((JsonString)lottieCompositionSpec0).unbox-impl().hashCode());
            }
            return LottieCompositionFactory.fromJsonString(((JsonString)lottieCompositionSpec0).unbox-impl(), s);
        }
        if(!(lottieCompositionSpec0 instanceof ContentProvider)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        InputStream inputStream0 = context0.getContentResolver().openInputStream(((ContentProvider)lottieCompositionSpec0).unbox-impl());
        if(q.b(s, "__LottieInternalDefaultCacheKey__")) {
            s = ((ContentProvider)lottieCompositionSpec0).unbox-impl().toString();
        }
        return LottieCompositionFactory.fromInputStream(context0, inputStream0, s);
    }

    private static final void maybeDecodeBase64Image(LottieImageAsset lottieImageAsset0) {
        if(lottieImageAsset0.getBitmap() == null) {
            String s = lottieImageAsset0.getFileName();
            q.d(s);
            if(v.r0(s, "data:", false) && Tf.o.F0(s, "base64,", 0, false, 6) > 0) {
                try {
                    String s1 = s.substring(Tf.o.E0(s, ',', 0, 6) + 1);
                    q.f(s1, "substring(...)");
                    byte[] arr_b = Base64.decode(s1, 0);
                    BitmapFactory.Options bitmapFactory$Options0 = new BitmapFactory.Options();
                    bitmapFactory$Options0.inScaled = true;
                    bitmapFactory$Options0.inDensity = 0xA0;
                    lottieImageAsset0.setBitmap(BitmapFactory.decodeByteArray(arr_b, 0, arr_b.length, bitmapFactory$Options0));
                }
                catch(IllegalArgumentException illegalArgumentException0) {
                    Logger.warning("data URL did not have correct base64 format.", illegalArgumentException0);
                }
            }
        }
    }

    private static final void maybeLoadImageFromAsset(Context context0, LottieImageAsset lottieImageAsset0, String s) {
        InputStream inputStream0;
        if(lottieImageAsset0.getBitmap() == null && s != null) {
            try {
                inputStream0 = context0.getAssets().open(s + lottieImageAsset0.getFileName());
            }
            catch(IOException iOException0) {
                Logger.warning("Unable to open asset.", iOException0);
                return;
            }
            q.d(inputStream0);
            Bitmap bitmap0 = null;
            try {
                BitmapFactory.Options bitmapFactory$Options0 = new BitmapFactory.Options();
                bitmapFactory$Options0.inScaled = true;
                bitmapFactory$Options0.inDensity = 0xA0;
                bitmap0 = BitmapFactory.decodeStream(inputStream0, null, bitmapFactory$Options0);
            }
            catch(IllegalArgumentException illegalArgumentException0) {
                Logger.warning("Unable to decode image.", illegalArgumentException0);
            }
            if(bitmap0 != null) {
                lottieImageAsset0.setBitmap(Utils.resizeBitmapIfNeeded(bitmap0, lottieImageAsset0.getWidth(), lottieImageAsset0.getHeight()));
            }
        }
    }

    private static final void maybeLoadTypefaceFromAssets(Context context0, Font font0, String s, String s1) {
        Typeface typeface0;
        String s2 = e.c(s, font0.getFamily(), s1);
        try {
            typeface0 = Typeface.createFromAsset(context0.getAssets(), s2);
        }
        catch(Exception exception0) {
            Logger.error(("Failed to find typeface in assets with path " + s2 + "."), exception0);
            return;
        }
        try {
            q.d(typeface0);
            String s3 = font0.getStyle();
            q.f(s3, "getStyle(...)");
            font0.setTypeface(RememberLottieCompositionKt.typefaceForStyle(typeface0, s3));
        }
        catch(Exception exception1) {
            Logger.error(("Failed to create " + font0.getFamily() + " typeface with style=" + font0.getStyle() + "!"), exception1);
        }
    }

    @NotNull
    public static final LottieCompositionResult rememberLottieComposition(@NotNull LottieCompositionSpec lottieCompositionSpec0, @Nullable String s, @Nullable String s1, @Nullable String s2, @Nullable String s3, @Nullable we.o o0, @Nullable l l0, int v, int v1) {
        q.g(lottieCompositionSpec0, "spec");
        ((p)l0).b0(0xB595CDFE);
        String s4 = (v1 & 16) == 0 ? s3 : "__LottieInternalDefaultCacheKey__";
        we.o o1 = (v1 & 0x20) == 0 ? o0 : new we.o(null) {
            int label;

            {
                super(3, continuation0);
            }

            @Nullable
            public final Object invoke(int v, @NotNull Throwable throwable0, @Nullable Continuation continuation0) {
                return new com.airbnb.lottie.compose.RememberLottieCompositionKt.rememberLottieComposition.1(continuation0).invokeSuspend(H.a);
            }

            @Override  // we.o
            public Object invoke(Object object0, Object object1, Object object2) {
                return this.invoke(((Number)object0).intValue(), ((Throwable)object1), ((Continuation)object2));
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                n.D(object0);
                return false;
            }
        };
        Context context0 = (Context)((p)l0).k(AndroidCompositionLocals_androidKt.b);
        ((p)l0).b0(0x52C617E1);
        int v2 = v & 14 ^ 6;
        boolean z = v2 > 4 && ((p)l0).g(lottieCompositionSpec0) || (v & 6) == 4;
        b0 b00 = ((p)l0).N();
        V v3 = k.a;
        if(z || b00 == v3) {
            b00 = w.s(new LottieCompositionResultImpl());
            ((p)l0).l0(b00);
        }
        ((p)l0).p(false);
        ((p)l0).b0(0x52C61904);
        int v4 = (v2 <= 4 || !((p)l0).g(lottieCompositionSpec0)) && (v & 6) != 4 ? 0 : 1;
        if(((((0xE000 & v ^ 0x6000) <= 0x4000 || !((p)l0).g(s4)) && (v & 0x6000) != 0x4000 ? 0 : 1) | v4) != 0 || ((p)l0).N() == v3) {
            ((p)l0).l0(RememberLottieCompositionKt.lottieTask(context0, lottieCompositionSpec0, s4, true));
        }
        ((p)l0).p(false);
        J.f(lottieCompositionSpec0, s4, new we.n(o1, context0, lottieCompositionSpec0, ((v1 & 2) == 0 ? s : null), ((v1 & 4) == 0 ? s1 : "fonts/"), ((v1 & 8) == 0 ? s2 : ".ttf"), s4, b00, null) {
            final String $cacheKey;
            final Context $context;
            final String $fontAssetsFolder;
            final String $fontFileExtension;
            final String $imageAssetsFolder;
            final we.o $onRetry;
            final b0 $result$delegate;
            final LottieCompositionSpec $spec;
            int I$0;
            Object L$0;
            int label;

            {
                this.$onRetry = o0;
                this.$context = context0;
                this.$spec = lottieCompositionSpec0;
                this.$imageAssetsFolder = s;
                this.$fontAssetsFolder = s1;
                this.$fontFileExtension = s2;
                this.$cacheKey = s3;
                this.$result$delegate = b00;
                super(2, continuation0);
            }

            @Override  // oe.a
            @NotNull
            public final Continuation create(@Nullable Object object0, @NotNull Continuation continuation0) {
                return new com.airbnb.lottie.compose.RememberLottieCompositionKt.rememberLottieComposition.3(this.$onRetry, this.$context, this.$spec, this.$imageAssetsFolder, this.$fontAssetsFolder, this.$fontFileExtension, this.$cacheKey, this.$result$delegate, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            @Nullable
            public final Object invoke(@NotNull CoroutineScope coroutineScope0, @Nullable Continuation continuation0) {
                return ((com.airbnb.lottie.compose.RememberLottieCompositionKt.rememberLottieComposition.3)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object object0) {
                int v2;
                Throwable throwable1;
                int v1;
                Throwable throwable0;
                int v;
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        n.D(object0);
                        v = 0;
                        throwable0 = null;
                        goto label_22;
                    }
                    case 1: {
                        v = this.I$0;
                        throwable0 = (Throwable)this.L$0;
                        n.D(object0);
                        goto label_30;
                    }
                    case 2: {
                        v1 = this.I$0;
                        throwable1 = (Throwable)this.L$0;
                        try {
                            n.D(object0);
                            break;
                        }
                        catch(Throwable throwable2) {
                            throwable0 = throwable2;
                            v2 = v1;
                            v = v2 + 1;
                            goto label_22;
                        }
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                while(true) {
                    try {
                    label_19:
                        RememberLottieCompositionKt.rememberLottieComposition$lambda$1(this.$result$delegate).complete$lottie_compose_release(((LottieComposition)object0));
                        throwable0 = throwable1;
                        v = v1;
                    }
                    catch(Throwable throwable3) {
                        break;
                    }
                label_22:
                    if(RememberLottieCompositionKt.rememberLottieComposition$lambda$1(this.$result$delegate).isSuccess()) {
                        goto label_47;
                    }
                    if(v != 0) {
                        q.d(throwable0);
                        this.L$0 = throwable0;
                        this.I$0 = v;
                        this.label = 1;
                        object0 = this.$onRetry.invoke(new Integer(v), throwable0, this);
                        if(object0 == a0) {
                            return a0;
                        }
                    label_30:
                        if(((Boolean)object0).booleanValue()) {
                            goto label_31;
                        }
                        goto label_47;
                    }
                    try {
                    label_31:
                        v1 = v;
                        throwable1 = throwable0;
                        String s = RememberLottieCompositionKt.ensureTrailingSlash(this.$imageAssetsFolder);
                        String s1 = RememberLottieCompositionKt.ensureTrailingSlash(this.$fontAssetsFolder);
                        String s2 = RememberLottieCompositionKt.ensureLeadingPeriod(this.$fontFileExtension);
                        this.L$0 = throwable1;
                        this.I$0 = v1;
                        this.label = 2;
                        object0 = RememberLottieCompositionKt.lottieComposition(this.$context, this.$spec, s, s1, s2, this.$cacheKey, this);
                        if(object0 != a0) {
                            goto label_19;
                        }
                        return a0;
                    }
                    catch(Throwable throwable3) {
                        break;
                    }
                }
                throwable0 = throwable3;
                v2 = v1;
                v = v2 + 1;
                goto label_22;
            label_47:
                if(!RememberLottieCompositionKt.rememberLottieComposition$lambda$1(this.$result$delegate).isComplete() && throwable0 != null) {
                    RememberLottieCompositionKt.rememberLottieComposition$lambda$1(this.$result$delegate).completeExceptionally$lottie_compose_release(throwable0);
                }
                return H.a;
            }
        }, ((p)l0));
        LottieCompositionResult lottieCompositionResult0 = RememberLottieCompositionKt.rememberLottieComposition$lambda$1(b00);
        ((p)l0).p(false);
        return lottieCompositionResult0;
    }

    private static final LottieCompositionResultImpl rememberLottieComposition$lambda$1(b0 b00) {
        return (LottieCompositionResultImpl)b00.getValue();
    }

    private static final Typeface typefaceForStyle(Typeface typeface0, String s) {
        int v = 0;
        boolean z = Tf.o.v0(s, "Italic", false);
        boolean z1 = Tf.o.v0(s, "Bold", false);
        if(z && z1) {
            return typeface0.getStyle() == 3 ? typeface0 : Typeface.create(typeface0, 3);
        }
        if(z) {
            return typeface0.getStyle() == 2 ? typeface0 : Typeface.create(typeface0, 2);
        }
        if(z1) {
            v = 1;
        }
        return typeface0.getStyle() == v ? typeface0 : Typeface.create(typeface0, v);
    }
}

