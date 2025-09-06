package jd;

import Cb.i;
import J8.r;
import Xb.j;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import androidx.lifecycle.f0;
import b0.Q;
import com.google.android.exoplayer2.SimpleExoPlayer.Builder;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.activity.ErrorReportActivity;
import com.iloen.melon.activity.PopupFragmentBaseActivity;
import com.iloen.melon.offline.OfflineDownloadService;
import com.iloen.melon.playback.playlist.add.AddRequestPlayableListInfo;
import com.iloen.melon.player.trackzero.SinglePlayer;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.network.UrlUtil;
import com.iloen.melon.utils.system.NotificationHelper;
import com.melon.ui.playermusic.PlayerMoreView;
import d8.d;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.util.ArrayList;
import java.util.HashSet;
import je.p;
import k5.A;
import k5.b;
import k5.e;
import k5.h;
import k5.k;
import k5.l;
import k5.n;
import k5.z;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import ld.x;
import okio.BufferedSource;
import okio.Okio;
import okio.internal.ResourceFileSystem;
import p8.s;
import sc.S2;
import sc.y0;
import t5.o;
import td.A1;
import u5.f;
import ud.I;
import ud.K;
import vd.B;
import vd.J;
import vd.L;
import vd.T;
import vd.V;
import vd.X;
import we.a;
import y2.g;

public final class e3 implements a {
    public final int a;
    public final Object b;

    public e3(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        Bitmap bitmap1;
        Bitmap bitmap0;
        double f3;
        int v8;
        boolean z1;
        k k0;
        H h0 = H.a;
        Object object0 = this.b;
        switch(this.a) {
            case 0: {
                BuildersKt__Builders_commonKt.launch$default(f0.h(((l3)object0)), Dispatchers.getIO(), null, new k3(((l3)object0), null), 2, null);
                return h0;
            }
            case 1: {
                return q.j(((Object[])object0));
            }
            case 2: {
                return ((Iterable)object0).iterator();
            }
            case 3: {
                BitmapFactory.Options bitmapFactory$Options0 = new BitmapFactory.Options();
                o o0 = ((e)object0).b;
                z z0 = ((e)object0).a;
                b b0 = new b(z0.p());
                BufferedSource bufferedSource0 = Okio.buffer(b0);
                bitmapFactory$Options0.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(bufferedSource0.peek().inputStream(), null, bitmapFactory$Options0);
                Exception exception0 = (Exception)b0.b;
                if(exception0 != null) {
                    throw exception0;
                }
                bitmapFactory$Options0.inJustDecodeBounds = false;
                String s = bitmapFactory$Options0.outMimeType;
                switch(((e)object0).d.ordinal()) {
                    case 0: {
                        k0 = k.c;
                        break;
                    }
                    case 1: {
                        if(s == null || !k5.o.a.contains(s)) {
                            k0 = k.c;
                            break;
                        }
                        goto label_27;
                    }
                    case 2: {
                    label_27:
                        g g0 = new g(new l(bufferedSource0.peek().inputStream()));
                        switch(g0.c()) {
                            case 2: 
                            case 4: 
                            case 5: 
                            case 7: {
                                z1 = true;
                                break;
                            }
                            default: {
                                z1 = false;
                            }
                        }
                        k0 = new k(z1, g0.l());
                        break;
                    }
                    default: {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                }
                int v = k0.b;
                boolean z2 = k0.a;
                Exception exception1 = (Exception)b0.b;
                if(exception1 != null) {
                    throw exception1;
                }
                bitmapFactory$Options0.inMutable = false;
                ColorSpace colorSpace0 = o0.c;
                Context context0 = o0.a;
                u5.g g1 = o0.d;
                if(colorSpace0 != null) {
                    bitmapFactory$Options0.inPreferredColorSpace = colorSpace0;
                }
                bitmapFactory$Options0.inPremultiplied = o0.h;
                Bitmap.Config bitmap$Config0 = !z2 && v <= 0 || o0.b != null && o0.b != Bitmap.Config.HARDWARE ? o0.b : Bitmap.Config.ARGB_8888;
                if(o0.g && bitmap$Config0 == Bitmap.Config.ARGB_8888 && q.b(bitmapFactory$Options0.outMimeType, "image/jpeg")) {
                    bitmap$Config0 = Bitmap.Config.RGB_565;
                }
                Bitmap.Config bitmap$Config1 = Bitmap.Config.RGBA_F16;
                if(bitmapFactory$Options0.outConfig == bitmap$Config1 && bitmap$Config0 != Bitmap.Config.HARDWARE) {
                    bitmap$Config0 = bitmap$Config1;
                }
                bitmapFactory$Options0.inPreferredConfig = bitmap$Config0;
                e.k k1 = z0.o();
                if(!(k1 instanceof A) || !q.b(g1, u5.g.c)) {
                    int v1 = bitmapFactory$Options0.outWidth;
                    if(v1 > 0) {
                        int v2 = bitmapFactory$Options0.outHeight;
                        if(v2 > 0) {
                            int v3 = v == 90 || v == 270 ? v2 : v1;
                            if(v != 90 && v != 270) {
                                v1 = v2;
                            }
                            f f0 = o0.e;
                            int v4 = q.b(g1, u5.g.c) ? v3 : x5.g.e(g1.a, f0);
                            int v5 = q.b(g1, u5.g.c) ? v1 : x5.g.e(g1.b, f0);
                            int v6 = Integer.highestOneBit(v3 / v4);
                            int v7 = Integer.highestOneBit(v1 / v5);
                            switch(f0.ordinal()) {
                                case 0: {
                                    v8 = Math.min(v6, v7);
                                    break;
                                }
                                case 1: {
                                    v8 = Math.max(v6, v7);
                                    break;
                                }
                                default: {
                                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                }
                            }
                            if(v8 < 1) {
                                v8 = 1;
                            }
                            bitmapFactory$Options0.inSampleSize = v8;
                            double f1 = ((double)v4) / (((double)v3) / ((double)v8));
                            double f2 = ((double)v5) / (((double)v1) / ((double)v8));
                            switch(f0.ordinal()) {
                                case 0: {
                                    f3 = Math.max(f1, f2);
                                    break;
                                }
                                case 1: {
                                    f3 = Math.min(f1, f2);
                                    break;
                                }
                                default: {
                                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                }
                            }
                            if(o0.f && f3 > 1.0) {
                                f3 = 1.0;
                            }
                            int v9 = f3 == 1.0 ? 1 : 0;
                            bitmapFactory$Options0.inScaled = v9 ^ 1;
                            if(v9 == 0) {
                                if(Double.compare(f3, 1.0) > 0) {
                                    bitmapFactory$Options0.inDensity = ye.a.U(2147483647.0 / f3);
                                    bitmapFactory$Options0.inTargetDensity = 0x7FFFFFFF;
                                }
                                else {
                                    bitmapFactory$Options0.inDensity = 0x7FFFFFFF;
                                    bitmapFactory$Options0.inTargetDensity = ye.a.U(2147483647.0 * f3);
                                }
                            }
                        }
                        else {
                            bitmapFactory$Options0.inSampleSize = 1;
                            bitmapFactory$Options0.inScaled = false;
                        }
                    }
                    else {
                        bitmapFactory$Options0.inSampleSize = 1;
                        bitmapFactory$Options0.inScaled = false;
                    }
                }
                else {
                    bitmapFactory$Options0.inSampleSize = 1;
                    bitmapFactory$Options0.inScaled = true;
                    bitmapFactory$Options0.inDensity = ((A)k1).h;
                    bitmapFactory$Options0.inTargetDensity = context0.getResources().getDisplayMetrics().densityDpi;
                }
                try {
                    bitmap0 = BitmapFactory.decodeStream(bufferedSource0.inputStream(), null, bitmapFactory$Options0);
                }
                catch(Throwable throwable0) {
                    d.l(bufferedSource0, throwable0);
                    throw throwable0;
                }
                bufferedSource0.close();
                Exception exception2 = (Exception)b0.b;
                if(exception2 != null) {
                    throw exception2;
                }
                if(bitmap0 == null) {
                    throw new IllegalStateException("BitmapFactory returned a null bitmap. Often this means BitmapFactory could not decode the image data read from the input source (e.g. network, disk, or memory) as it\'s not encoded as a valid image format.");
                }
                bitmap0.setDensity(context0.getResources().getDisplayMetrics().densityDpi);
                if(z2 || v > 0) {
                    Matrix matrix0 = new Matrix();
                    float f4 = ((float)bitmap0.getWidth()) / 2.0f;
                    float f5 = ((float)bitmap0.getHeight()) / 2.0f;
                    if(z2) {
                        matrix0.postScale(-1.0f, 1.0f, f4, f5);
                    }
                    if(v > 0) {
                        matrix0.postRotate(((float)v), f4, f5);
                    }
                    RectF rectF0 = new RectF(0.0f, 0.0f, ((float)bitmap0.getWidth()), ((float)bitmap0.getHeight()));
                    matrix0.mapRect(rectF0);
                    float f6 = rectF0.left;
                    if(f6 != 0.0f || rectF0.top != 0.0f) {
                        matrix0.postTranslate(-f6, -rectF0.top);
                    }
                    if(v == 90 || v == 270) {
                        int v12 = bitmap0.getHeight();
                        int v13 = bitmap0.getWidth();
                        Bitmap.Config bitmap$Config3 = bitmap0.getConfig();
                        if(bitmap$Config3 == null) {
                            bitmap$Config3 = Bitmap.Config.ARGB_8888;
                        }
                        bitmap1 = Bitmap.createBitmap(v12, v13, bitmap$Config3);
                    }
                    else {
                        int v10 = bitmap0.getWidth();
                        int v11 = bitmap0.getHeight();
                        Bitmap.Config bitmap$Config2 = bitmap0.getConfig();
                        if(bitmap$Config2 == null) {
                            bitmap$Config2 = Bitmap.Config.ARGB_8888;
                        }
                        bitmap1 = Bitmap.createBitmap(v10, v11, bitmap$Config2);
                    }
                    new Canvas(bitmap1).drawBitmap(bitmap0, matrix0, n.a);
                    bitmap0.recycle();
                    bitmap0 = bitmap1;
                }
                BitmapDrawable bitmapDrawable0 = new BitmapDrawable(context0.getResources(), bitmap0);
                return bitmapFactory$Options0.inSampleSize > 1 || bitmapFactory$Options0.inScaled ? new h(bitmapDrawable0, true) : new h(bitmapDrawable0, false);
            }
            case 4: {
                return new pd.f(((MelonAppBase)object0).getPlaybackManager(), ((MelonAppBase)object0).getPlayerUseCase());
            }
            case 5: {
                return new NotificationHelper(((OfflineDownloadService)object0));
            }
            case 6: {
                return ((ErrorReportActivity)object0).lambda$showErrorReportPopup$1();
            }
            case 7: {
                return PopupFragmentBaseActivity.progressManager_delegate$lambda$0(((PopupFragmentBaseActivity)object0));
            }
            case 8: {
                int v14 = ((lc.g)object0).b;
                AddRequestPlayableListInfo addRequestPlayableListInfo0 = ((lc.g)object0).i.c;
                if(((lc.g)object0).i.b) {
                    Iterable iterable0 = addRequestPlayableListInfo0.getUserRequestedPlaylist();
                    ArrayList arrayList0 = new ArrayList();
                    ArrayList arrayList1 = new ArrayList();
                    for(Object object1: iterable0) {
                        arrayList1.add(object1);
                    }
                    HashSet hashSet0 = new HashSet();
                    ArrayList arrayList2 = new ArrayList();
                    for(Object object2: arrayList0) {
                        if(hashSet0.add("")) {
                            arrayList2.add(object2);
                        }
                    }
                    return p.L0(v14, p.A0(arrayList2, arrayList1));
                }
                return p.L0(v14, addRequestPlayableListInfo0.getUserRequestedPlaylist());
            }
            case 9: {
                H0.e.w(((ld.b)object0));
                return h0;
            }
            case 10: {
                N2 n20 = new N2(1, ((x)object0), x.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 15);
                s s1 = ((x)object0).getTiaraProperty();
                return new Jd.a(((x)object0).h, n20, s1);
            }
            case 11: {
                Intent intent0 = new Intent("android.intent.action.VIEW");
                intent0.setFlags(0x10000000);
                intent0.setData(UrlUtil.getMelonAppMarketUri());
                BaseActivity baseActivity0 = ((m8.g)object0).a;
                if(baseActivity0 != null) {
                    baseActivity0.startActivity(intent0);
                }
                return h0;
            }
            case 12: {
                SimpleExoPlayer simpleExoPlayer0 = new Builder(((SinglePlayer)object0).a).build();
                simpleExoPlayer0.addListener(((SinglePlayer)object0).f);
                return simpleExoPlayer0;
            }
            case 13: {
                return ResourceFileSystem.c(((ResourceFileSystem)object0));
            }
            case 14: {
                return "handlePlaybackUiEvent() Keep Event: " + i.o(((j)object0));
            }
            case 15: {
                sc.i i0 = ((S2)object0).g;
                if(i0 != null) {
                    y0 y00 = new y0(i0.a, null);
                    BuildersKt__Builders_commonKt.launch$default(i0.a.c, null, null, y00, 3, null);
                }
                return h0;
            }
            case 16: {
                ((PlayerMoreView)object0).post(new A1(((PlayerMoreView)object0), 1));
                return h0;
            }
            case 17: {
                return (float)((((Q)object0).b() - ((Q)object0).b.a) / (((Q)object0).b.b - ((Q)object0).b.a));
            }
            case 18: {
                return new I(((K)object0).g);
            }
            case 19: {
                return ((r)object0).b;
            }
            case 20: {
                ((vd.f)object0).dismiss();
                return h0;
            }
            case 21: {
                ((vd.g)object0).dismiss();
                return h0;
            }
            case 22: {
                ((vd.i)object0).dismiss();
                return h0;
            }
            case 23: {
                ((B)object0).dismiss();
                return h0;
            }
            case 24: {
                Navigator.openLoginView(((Uri)object0));
                return h0;
            }
            case 25: {
                ((J)object0).dismiss();
                return h0;
            }
            case 26: {
                ((L)object0).dismiss();
                return h0;
            }
            case 27: {
                ((T)object0).dismissAllowingStateLoss();
                return h0;
            }
            case 28: {
                ((V)object0).dismiss();
                return h0;
            }
            default: {
                ((X)object0).dismiss();
                return h0;
            }
        }
    }
}

