package com.iloen.melon.fragments.mymusic.playlist;

import Cc.U3;
import Cc.V3;
import Cc.W3;
import Kd.h;
import Pc.d;
import Ud.e;
import Ud.g;
import android.net.Uri;
import androidx.lifecycle.f0;
import com.iloen.melon.custom.L0;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.melon.net.res.MyMusicOrcRes.Response;
import com.melon.net.res.common.SongInfoBase;
import com.melon.ui.I4;
import com.melon.ui.K4;
import com.melon.ui.U0;
import com.melon.ui.Z0;
import com.melon.ui.a1;
import com.melon.ui.b1;
import com.melon.ui.c1;
import com.melon.ui.d1;
import com.melon.ui.g1;
import com.melon.ui.k1;
import com.melon.ui.q3;
import com.melon.ui.t3;
import com.melon.utils.image.ImageUtils;
import i.n.i.b.a.s.e.M3;
import ie.H;
import ie.j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;
import je.w;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.n;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oe.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.s;
import va.e0;
import va.o;
import we.k;
import zb.b;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 N2\u00020\u0001:\u0001NB!\b\u0007\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006\u00A2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\nH\u0096@\u00A2\u0006\u0004\b\r\u0010\u000EJ\r\u0010\u000F\u001A\u00020\f\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0015\u0010\u0013\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\u0011\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001A\u00020\f2\u0006\u0010\u0016\u001A\u00020\u0015H\u0014\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u001E\u0010\u001C\u001A\u00020\f2\f\u0010\u001B\u001A\b\u0012\u0004\u0012\u00020\u001A0\u0019H\u0082@\u00A2\u0006\u0004\b\u001C\u0010\u001DJ%\u0010#\u001A\u00020\"2\f\u0010\u001F\u001A\b\u0012\u0004\u0012\u00020\u001E0\u00192\u0006\u0010!\u001A\u00020 H\u0002\u00A2\u0006\u0004\b#\u0010$J\u0017\u0010%\u001A\u00020\f2\u0006\u0010%\u001A\u00020\u001EH\u0002\u00A2\u0006\u0004\b%\u0010&R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0003\u0010\'R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0005\u0010(R\u0014\u0010\u0007\u001A\u00020\u00068\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0007\u0010)R\u0014\u0010+\u001A\u00020*8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b+\u0010,R\"\u0010.\u001A\u00020-8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\b.\u0010/\u001A\u0004\b0\u00101\"\u0004\b2\u00103R6\u00106\u001A\u0016\u0012\u0004\u0012\u00020\u001A\u0018\u000104j\n\u0012\u0004\u0012\u00020\u001A\u0018\u0001`58\u0006@\u0006X\u0086\u000E\u00A2\u0006\u0012\n\u0004\b6\u00107\u001A\u0004\b8\u00109\"\u0004\b:\u0010;R\u001A\u0010>\u001A\b\u0012\u0004\u0012\u00020=0<8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b>\u0010?R\u001A\u0010A\u001A\b\u0012\u0004\u0012\u00020\u001E0@8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bA\u0010BR\u001B\u0010H\u001A\u00020C8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\bD\u0010E\u001A\u0004\bF\u0010GR\u0011\u0010I\u001A\u00020\u00118F\u00A2\u0006\u0006\u001A\u0004\bI\u0010JR\u0014\u0010K\u001A\u00020\u00118TX\u0094\u0004\u00A2\u0006\u0006\u001A\u0004\bK\u0010JR\u0016\u0010M\u001A\u0004\u0018\u00010\"8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b#\u0010L\u00A8\u0006O"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistViewModel;", "Lcom/melon/ui/k1;", "Lzb/b;", "uploadImageUseCase", "Lcom/melon/ui/t3;", "putPopupUserEventHelper", "LPc/d;", "stringProvider", "<init>", "(Lzb/b;Lcom/melon/ui/t3;LPc/d;)V", "Lcom/melon/ui/g1;", "type", "Lie/H;", "onFetchStart", "(Lcom/melon/ui/g1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reSelectImage", "()V", "", "select", "selectAll", "(Z)V", "LPc/e;", "userEvent", "onUserEvent", "(LPc/e;)V", "", "Landroid/net/Uri;", "uriList", "uploadImages", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "LKd/g;", "songListItemUiState", "", "ocrGroupId", "Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistUiState$Success;", "getSuccessUiState", "(Ljava/util/List;Ljava/lang/String;)Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistUiState$Success;", "selectItem", "(LKd/g;)V", "Lzb/b;", "Lcom/melon/ui/t3;", "LPc/d;", "Lcom/iloen/melon/utils/log/LogU;", "log", "Lcom/iloen/melon/utils/log/LogU;", "Lcom/melon/utils/image/ImageUtils;", "imageUtils", "Lcom/melon/utils/image/ImageUtils;", "getImageUtils", "()Lcom/melon/utils/image/ImageUtils;", "setImageUtils", "(Lcom/melon/utils/image/ImageUtils;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "imageUriList", "Ljava/util/ArrayList;", "getImageUriList", "()Ljava/util/ArrayList;", "setImageUriList", "(Ljava/util/ArrayList;)V", "", "", "selectedUriList", "Ljava/util/List;", "LUd/g;", "selectHelper", "LUd/g;", "LJd/a;", "toolBarEventHelper$delegate", "Lie/j;", "getToolBarEventHelper", "()LJd/a;", "toolBarEventHelper", "isLoginUser", "()Z", "isFetchEnabled", "()Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistUiState$Success;", "successUiState", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ImageToPlaylistViewModel extends k1 {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistViewModel$Companion;", "", "<init>", "()V", "TAG", "", "RESIZE_TARGET", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final long RESIZE_TARGET = 0x7D000L;
    @NotNull
    private static final String TAG = "ImageToPlaylistViewModel";
    @Nullable
    private ArrayList imageUriList;
    @Inject
    public ImageUtils imageUtils;
    @NotNull
    private final LogU log;
    @NotNull
    private final t3 putPopupUserEventHelper;
    @NotNull
    private final g selectHelper;
    @NotNull
    private final List selectedUriList;
    @NotNull
    private final d stringProvider;
    @NotNull
    private final j toolBarEventHelper$delegate;
    @NotNull
    private final b uploadImageUseCase;

    static {
        ImageToPlaylistViewModel.Companion = new Companion(null);
        ImageToPlaylistViewModel.$stable = 8;
    }

    @Inject
    public ImageToPlaylistViewModel(@NotNull b b0, @NotNull t3 t30, @NotNull d d0) {
        q.g(b0, "uploadImageUseCase");
        q.g(t30, "putPopupUserEventHelper");
        q.g(d0, "stringProvider");
        super();
        this.uploadImageUseCase = b0;
        this.putPopupUserEventHelper = t30;
        this.stringProvider = d0;
        LogU logU0 = new LogU("ImageToPlaylistViewModel");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        this.log = logU0;
        this.selectedUriList = new ArrayList();
        g g0 = new g(new com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistViewModel.selectHelper.1());
        g0.c = new com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistViewModel.selectHelper.2.1();
        this.selectHelper = g0;
        this.toolBarEventHelper$delegate = d3.g.Q(new com.iloen.melon.fragments.mymusic.playlist.d(this, 1));

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001F\u0010\u0006\u001A\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistViewModel$selectHelper$1", "LUd/e;", "LKd/g;", "state", "", "select", "onChange", "(LKd/g;Z)LKd/g;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistViewModel.selectHelper.1 implements e {
            public Kd.g onChange(Kd.g g0, boolean z) {
                q.g(g0, "state");
                return g0.i ? Kd.g.a(g0, null, false, z, 0x7FFFFF) : g0;
            }

            @Override  // Ud.e
            public Object onChange(Object object0, boolean z) {
                return this.onChange(((Kd.g)object0), z);
            }
        }


        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001F\u0010\u0006\u001A\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"com/iloen/melon/fragments/mymusic/playlist/ImageToPlaylistViewModel$selectHelper$2$1", "LUd/d;", "LKd/g;", "state", "", "marquee", "onChange", "(LKd/g;Z)LKd/g;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistViewModel.selectHelper.2.1 implements Ud.d {
            public Kd.g onChange(Kd.g g0, boolean z) {
                q.g(g0, "state");
                return Kd.g.a(g0, null, z, false, 0xBFFFFF);
            }

            @Override  // Ud.d
            public Object onChange(Object object0, boolean z) {
                return this.onChange(((Kd.g)object0), z);
            }
        }


        @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
        final class com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistViewModel.toolBarEventHelper.2.1 extends n implements k {
            public com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistViewModel.toolBarEventHelper.2.1(Object object0) {
                super(1, 0, ImageToPlaylistViewModel.class, object0, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V");
            }

            @Override  // we.k
            public Object invoke(Object object0) {
                this.invoke(((I4)object0));
                return H.a;
            }

            public final void invoke(I4 i40) {
                q.g(i40, "p0");
                ImageToPlaylistViewModel.access$sendUiEvent(((ImageToPlaylistViewModel)this.receiver), i40);
            }
        }

    }

    public static final Object access$uploadImages(ImageToPlaylistViewModel imageToPlaylistViewModel0, List list0, Continuation continuation0) {
        return imageToPlaylistViewModel0.uploadImages(list0, continuation0);
    }

    @Nullable
    public final ArrayList getImageUriList() {
        return this.imageUriList;
    }

    @NotNull
    public final ImageUtils getImageUtils() {
        ImageUtils imageUtils0 = this.imageUtils;
        if(imageUtils0 != null) {
            return imageUtils0;
        }
        q.m("imageUtils");
        throw null;
    }

    private final Success getSuccessUiState() {
        Object object0 = this.getUiState().getValue();
        return object0 instanceof Success ? ((Success)object0) : null;
    }

    private final Success getSuccessUiState(List list0, String s) {
        Success imageToPlaylistUiState$Success0 = this.getSuccessUiState();
        if(imageToPlaylistUiState$Success0 != null) {
            Success imageToPlaylistUiState$Success1 = Success.copy$default(imageToPlaylistUiState$Success0, false, list0, null, 5, null);
            return imageToPlaylistUiState$Success1 == null ? new Success(false, list0, new U3(700, false, true, 0, new f(this, s))) : imageToPlaylistUiState$Success1;
        }
        return new Success(false, list0, new U3(700, false, true, 0, new f(this, s)));

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @oe.e(c = "com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistViewModel$getSuccessUiState$2$1$1", f = "ImageToPlaylistViewModel.kt", l = {0xEF}, m = "invokeSuspend")
        final class com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistViewModel.getSuccessUiState.2.1.1 extends i implements we.n {
            final String $ocrGroupId;
            final List $selectedList;
            final Jd.b $userEvent;
            int label;

            public com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistViewModel.getSuccessUiState.2.1.1(Jd.b b0, ImageToPlaylistViewModel imageToPlaylistViewModel0, List list0, String s, Continuation continuation0) {
                this.$userEvent = b0;
                ImageToPlaylistViewModel.this = imageToPlaylistViewModel0;
                this.$selectedList = list0;
                this.$ocrGroupId = s;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistViewModel.getSuccessUiState.2.1.1(this.$userEvent, ImageToPlaylistViewModel.this, this.$selectedList, this.$ocrGroupId, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistViewModel.getSuccessUiState.2.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                H h0 = H.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        String s = ImageToPlaylistViewModel.this.getMenuId();
                        this.$userEvent.b(s);
                        this.$userEvent.b = ImageToPlaylistViewModel.this.getStatsElements();
                        Jd.a a1 = ImageToPlaylistViewModel.this.getToolBarEventHelper();
                        this.label = 1;
                        a1.a(this.$userEvent, this.$selectedList, this.$ocrGroupId);
                        return h0 == a0 ? a0 : h0;
                    }
                    case 1: {
                        d5.n.D(object0);
                        return h0;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }

    }

    private static final H getSuccessUiState$lambda$9(ImageToPlaylistViewModel imageToPlaylistViewModel0, String s, W3 w30) {
        q.g(w30, "toolBarUserEvent");
        if(!(w30 instanceof V3)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        Jd.b b0 = ((V3)w30).b == 2 ? Jd.b.c : null;
        if(b0 != null) {
            Success imageToPlaylistUiState$Success0 = imageToPlaylistViewModel0.getSuccessUiState();
            if(imageToPlaylistUiState$Success0 != null) {
                ArrayList arrayList0 = new ArrayList();
                for(Object object0: imageToPlaylistUiState$Success0.getList()) {
                    if(((Kd.g)object0).N) {
                        arrayList0.add(object0);
                    }
                }
                ArrayList arrayList1 = new ArrayList(je.q.Q(10, arrayList0));
                for(Object object1: arrayList0) {
                    arrayList1.add(h.b(((Kd.g)object1), imageToPlaylistViewModel0.getMenuId()));
                }
                BuildersKt__Builders_commonKt.launch$default(f0.h(imageToPlaylistViewModel0), null, null, new com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistViewModel.getSuccessUiState.2.1.1(b0, imageToPlaylistViewModel0, arrayList1, s, null), 3, null);
            }
        }
        return H.a;
    }

    private final Jd.a getToolBarEventHelper() {
        return (Jd.a)this.toolBarEventHelper$delegate.getValue();
    }

    @Override  // com.melon.ui.k1
    public boolean isFetchEnabled() {
        return super.isFetchEnabled() && this.getSuccessUiState() == null;
    }

    public final boolean isLoginUser() {
        return ((e0)o.a()).m();
    }

    @Override  // com.melon.ui.k1
    @Nullable
    public Object onFetchStart(@NotNull g1 g10, @NotNull Continuation continuation0) {
        LogU.Companion.d("ImageToPlaylistViewModel", "onFetchStart()");
        H h0 = H.a;
        if(this.imageUriList != null && !this.imageUriList.isEmpty()) {
            this.updateUiState(new com.iloen.melon.fragments.mymusic.playlist.e(2));
            ArrayList arrayList0 = this.imageUriList;
            if(arrayList0 == null) {
                arrayList0 = w.a;
            }
            Object object0 = this.uploadImages(arrayList0, continuation0);
            return object0 == a.a ? object0 : h0;
        }
        this.updateUiState(new com.iloen.melon.fragments.mymusic.playlist.e(1));
        return h0;
    }

    private static final K4 onFetchStart$lambda$3(K4 k40) {
        q.g(k40, "it");
        return new Empty(new U0("", null, 29));
    }

    private static final K4 onFetchStart$lambda$4(K4 k40) {
        q.g(k40, "it");
        return Loading.INSTANCE;
    }

    @Override  // com.melon.ui.k1
    public void onUserEvent(@NotNull Pc.e e0) {
        q.g(e0, "userEvent");
        if(e0 instanceof Kd.b) {
            this.selectItem(((Kd.b)e0).a);
            return;
        }
        if(e0 instanceof ToggleSelectAll) {
            Success imageToPlaylistUiState$Success0 = this.getSuccessUiState();
            this.selectAll(imageToPlaylistUiState$Success0 != null && !imageToPlaylistUiState$Success0.getCheckAll());
            return;
        }
        if(e0 instanceof StartFetch) {
            this.selectedUriList.clear();
            ArrayList arrayList0 = this.imageUriList;
            if(arrayList0 != null) {
                arrayList0.clear();
            }
            ArrayList arrayList1 = this.imageUriList;
            if(arrayList1 != null) {
                arrayList1.addAll(((StartFetch)e0).getList());
            }
            k1.startFetch$default(this, true, null, null, 6, null);
            return;
        }
        if(e0 instanceof q3) {
            T2.a a0 = f0.h(this);
            boolean z = this.isLoginUser();
            com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistViewModel.onUserEvent.1 imageToPlaylistViewModel$onUserEvent$10 = new k() {
                {
                    super(1, 0, ImageToPlaylistViewModel.class, object0, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V");
                }

                @Override  // we.k
                public Object invoke(Object object0) {
                    this.invoke(((I4)object0));
                    return H.a;
                }

                public final void invoke(I4 i40) {
                    q.g(i40, "p0");
                    ((ImageToPlaylistViewModel)this.receiver).sendUiEvent(i40);
                }
            };
            L0 l00 = this.getProgressUpdater();
            this.putPopupUserEventHelper.a(((q3)e0), a0, z, imageToPlaylistViewModel$onUserEvent$10, l00);
            return;
        }
        super.onUserEvent(e0);
    }

    public final void reSelectImage() {
        this.cancelFetch();
        ArrayList arrayList0 = this.imageUriList;
        if(arrayList0 != null) {
            arrayList0.clear();
        }
    }

    public final void selectAll(boolean z) {
        Success imageToPlaylistUiState$Success0 = this.getSuccessUiState();
        if(imageToPlaylistUiState$Success0 != null) {
            List list0 = imageToPlaylistUiState$Success0.getList();
            if(!list0.isEmpty()) {
                this.updateUiState(new f(3, this.selectHelper.a(list0, z), imageToPlaylistUiState$Success0));
            }
        }
    }

    private static final K4 selectAll$lambda$12$lambda$11(List list0, Success imageToPlaylistUiState$Success0, K4 k40) {
        q.g(k40, "it");
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: list0) {
            if(((Kd.g)object0).N) {
                arrayList0.add(object0);
            }
        }
        int v = arrayList0.size();
        return v <= 0 ? imageToPlaylistUiState$Success0.copy(false, list0, U3.a(imageToPlaylistUiState$Success0.getToolBarUiState(), 0, false, v, 23)) : imageToPlaylistUiState$Success0.copy(true, list0, U3.a(imageToPlaylistUiState$Success0.getToolBarUiState(), 0, false, v, 23));
    }

    private final void selectItem(Kd.g g0) {
        LogU.debug$default(this.log, "selectItem() selectItem\'s songName:" + g0.b, null, false, 6, null);
        Success imageToPlaylistUiState$Success0 = this.getSuccessUiState();
        if(imageToPlaylistUiState$Success0 != null) {
            List list0 = imageToPlaylistUiState$Success0.getList();
            if(!list0.isEmpty()) {
                this.updateUiState(new f(2, this.selectHelper.b(list0, g0), imageToPlaylistUiState$Success0));
            }
        }
    }

    private static final K4 selectItem$lambda$15$lambda$14(List list0, Success imageToPlaylistUiState$Success0, K4 k40) {
        q.g(k40, "it");
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: list0) {
            if(((Kd.g)object0).N) {
                arrayList0.add(object0);
            }
        }
        int v = arrayList0.size();
        return v <= 0 ? imageToPlaylistUiState$Success0.copy(false, list0, U3.a(imageToPlaylistUiState$Success0.getToolBarUiState(), 0, false, v, 23)) : imageToPlaylistUiState$Success0.copy(true, list0, U3.a(imageToPlaylistUiState$Success0.getToolBarUiState(), 0, false, v, 23));
    }

    public final void setImageUriList(@Nullable ArrayList arrayList0) {
        this.imageUriList = arrayList0;
    }

    public final void setImageUtils(@NotNull ImageUtils imageUtils0) {
        q.g(imageUtils0, "<set-?>");
        this.imageUtils = imageUtils0;
    }

    private static final Jd.a toolBarEventHelper_delegate$lambda$2(ImageToPlaylistViewModel imageToPlaylistViewModel0) {
        com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistViewModel.toolBarEventHelper.2.1 imageToPlaylistViewModel$toolBarEventHelper$2$10 = new com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistViewModel.toolBarEventHelper.2.1(imageToPlaylistViewModel0);
        s s0 = imageToPlaylistViewModel0.getTiaraProperty();
        return new Jd.a(imageToPlaylistViewModel0.stringProvider, imageToPlaylistViewModel$toolBarEventHelper$2$10, s0);
    }

    private final Object uploadImages(List list0, Continuation continuation0) {
        Object object0 = BuildersKt.withContext(Dispatchers.getIO(), new we.n(this, null) {
            final List $uriList;
            int I$0;
            private Object L$0;
            int label;

            {
                this.$uriList = list0;
                ImageToPlaylistViewModel.this = imageToPlaylistViewModel0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                Continuation continuation1 = new com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistViewModel.uploadImages.2(this.$uriList, ImageToPlaylistViewModel.this, continuation0);
                continuation1.L$0 = object0;
                return continuation1;
            }

            public static K4 f(K4 k40, K4 k41) {
                return k40;
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.mymusic.playlist.ImageToPlaylistViewModel.uploadImages.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                byte[] arr_b;
                CoroutineScope coroutineScope0 = (CoroutineScope)this.L$0;
                a a0 = a.a;
                H h0 = H.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        int v = this.$uriList.size();
                        if(v > 5) {
                            v = 5;
                        }
                        if(ImageToPlaylistViewModel.this.selectedUriList.isEmpty()) {
                            for(int v1 = 0; v1 < v; ++v1) {
                                if(!CoroutineScopeKt.isActive(coroutineScope0)) {
                                    return h0;
                                }
                                Uri uri0 = (Uri)this.$uriList.get(v1);
                                LogU.Companion.d("ImageToPlaylistViewModel", "Selected URI: " + uri0);
                                try {
                                    arr_b = ImageToPlaylistViewModel.this.getImageUtils().d(uri0);
                                }
                                catch(Exception exception0) {
                                    Y.w("exception: ", exception0.getMessage(), LogU.Companion, "ImageToPlaylistViewModel");
                                    continue;
                                }
                                ImageToPlaylistViewModel.this.selectedUriList.add(arr_b);
                            }
                        }
                        if(ImageToPlaylistViewModel.this.selectedUriList.isEmpty()) {
                            com.iloen.melon.fragments.mymusic.playlist.e e0 = new com.iloen.melon.fragments.mymusic.playlist.e(0);
                            ImageToPlaylistViewModel.this.updateUiState(e0);
                            return h0;
                        }
                        this.L$0 = null;
                        this.I$0 = v;
                        this.label = 1;
                        object0 = ImageToPlaylistViewModel.this.uploadImageUseCase.a(ImageToPlaylistViewModel.this.selectedUriList, this);
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
                f f0 = new f(0, ((Na.f)object0), ImageToPlaylistViewModel.this);
                K4 k40 = ImageToPlaylistViewModel.this.handleDefaultHttpResponseResult(((Na.f)object0), f0);
                if(k40 != null) {
                    com.iloen.melon.fragments.mymusic.playlist.g g0 = new com.iloen.melon.fragments.mymusic.playlist.g(k40, 0);
                    ImageToPlaylistViewModel.this.updateUiState(g0);
                }
                return h0;
            }

            // 去混淆评级： 低(20)
            private static final K4 invokeSuspend$lambda$0(K4 k40) {
                return new Empty(new U0("", null, 29));
            }

            private static final K4 invokeSuspend$lambda$2(Na.f f0, ImageToPlaylistViewModel imageToPlaylistViewModel0, d1 d10) {
                if(d10 instanceof Z0) {
                    if(f0.a() instanceof CancellationException) {
                        return null;
                    }
                    LogU.debug$default(imageToPlaylistViewModel0.log, va.e.b("uploadImages() Error message: ", ((Z0)d10).a.a), null, false, 6, null);
                    return new Error(((Z0)d10).a);
                }
                if(d10 instanceof b1) {
                    LogU.debug$default(imageToPlaylistViewModel0.log, va.e.b("uploadImages() Noti message: ", ((b1)d10).a.b), null, false, 6, null);
                    return new NotificationScreen(((b1)d10).a);
                }
                if(d10 instanceof c1) {
                    Response myMusicOrcRes$Response0 = (Response)((c1)d10).a;
                    ArrayList arrayList0 = myMusicOrcRes$Response0.getSongList();
                    if(arrayList0 != null && !arrayList0.isEmpty()) {
                        ArrayList arrayList1 = myMusicOrcRes$Response0.getSongList();
                        if(arrayList1 != null) {
                            ArrayList arrayList2 = new ArrayList(je.q.Q(10, arrayList1));
                            for(Object object0: arrayList1) {
                                arrayList2.add(h.c(((SongInfoBase)object0)));
                            }
                            return imageToPlaylistViewModel0.getSuccessUiState(arrayList2, (myMusicOrcRes$Response0.getOcrGroupId() == null ? "" : myMusicOrcRes$Response0.getOcrGroupId()));
                        }
                        return imageToPlaylistViewModel0.getSuccessUiState(w.a, (myMusicOrcRes$Response0.getOcrGroupId() == null ? "" : myMusicOrcRes$Response0.getOcrGroupId()));
                    }
                    return new Empty(new U0("", null, 29));
                }
                if(!(d10 instanceof a1)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                return null;
            }

            private static final K4 invokeSuspend$lambda$3(K4 k40, K4 k41) [...] // Inlined contents
        }, continuation0);
        return object0 == a.a ? object0 : H.a;
    }
}

