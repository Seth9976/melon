package com.iloen.melon.fragments.melonchart;

import Ae.f;
import De.I;
import J8.f3;
import J8.s;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri.Builder;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v6x.request.ChartStreamingCardReq;
import com.iloen.melon.net.v6x.response.ChartStreamingCardRes.Response;
import com.iloen.melon.net.v6x.response.ChartStreamingCardRes;
import com.iloen.melon.net.v6x.response.ChartStreamingCardUploadRes.RESPONSE;
import com.iloen.melon.net.v6x.response.ChartStreamingCardUploadRes;
import com.iloen.melon.responsecache.a;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.sns.model.SharableStreamingCard;
import com.iloen.melon.utils.FileUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import d5.w;
import d8.d;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import javax.inject.Inject;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.MediaType;
import okhttp3.MultipartBody.Part;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.g;
import v9.h;
import v9.i;
import we.n;
import yb.b;

@Metadata(d1 = {"\u0000\u009A\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 P2\u00020\u0001:\u0002PQB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0002\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001A\u00020\t2\u0006\u0010\b\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b\n\u0010\u000BJ\u000F\u0010\f\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b\f\u0010\u0003J!\u0010\u000F\u001A\u00020\t2\b\u0010\u000E\u001A\u0004\u0018\u00010\r2\u0006\u0010\b\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0019\u0010\u0011\u001A\u00020\t2\b\u0010\u000E\u001A\u0004\u0018\u00010\rH\u0002\u00A2\u0006\u0004\b\u0011\u0010\u0012J+\u0010\u0017\u001A\u00020\u00152\u0006\u0010\u0014\u001A\u00020\u00132\b\u0010\u000E\u001A\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0016\u001A\u00020\u0015H\u0002\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u000F\u0010\u001A\u001A\u00020\u0019H\u0016\u00A2\u0006\u0004\b\u001A\u0010\u001BJ-\u0010\"\u001A\u0004\u0018\u00010\r2\u0006\u0010\u001D\u001A\u00020\u001C2\b\u0010\u001F\u001A\u0004\u0018\u00010\u001E2\b\u0010!\u001A\u0004\u0018\u00010 H\u0016\u00A2\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001A\u00020\t2\u0006\u0010$\u001A\u00020 H\u0014\u00A2\u0006\u0004\b%\u0010&J\u0017\u0010(\u001A\u00020\t2\u0006\u0010\'\u001A\u00020 H\u0016\u00A2\u0006\u0004\b(\u0010&J!\u0010)\u001A\u00020\t2\u0006\u0010\u000E\u001A\u00020\r2\b\u0010!\u001A\u0004\u0018\u00010 H\u0016\u00A2\u0006\u0004\b)\u0010*J\u000F\u0010+\u001A\u00020\tH\u0016\u00A2\u0006\u0004\b+\u0010\u0003J\u000F\u0010,\u001A\u00020\u0015H\u0016\u00A2\u0006\u0004\b,\u0010-J\u001D\u0010/\u001A\b\u0012\u0002\b\u0003\u0018\u00010.2\u0006\u0010\u0014\u001A\u00020\u0013H\u0014\u00A2\u0006\u0004\b/\u00100J\u0011\u00102\u001A\u0004\u0018\u000101H\u0014\u00A2\u0006\u0004\b2\u00103J-\u00109\u001A\u00020\u00152\b\u00105\u001A\u0004\u0018\u0001042\b\u00107\u001A\u0004\u0018\u0001062\b\u00108\u001A\u0004\u0018\u00010\u0019H\u0014\u00A2\u0006\u0004\b9\u0010:J\u0011\u0010<\u001A\u0004\u0018\u00010;H\u0014\u00A2\u0006\u0004\b<\u0010=R\u0018\u0010?\u001A\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010A\u001A\u00020\u00198\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010D\u001A\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010G\u001A\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bG\u0010HR\"\u0010J\u001A\u00020I8\u0006@\u0006X\u0087.\u00A2\u0006\u0012\n\u0004\bJ\u0010K\u001A\u0004\bL\u0010M\"\u0004\bN\u0010O\u00A8\u0006R"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/StreamingCardFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "Lcom/iloen/melon/net/v6x/response/ChartStreamingCardRes;", "fetchData", "()Lcom/iloen/melon/net/v6x/response/ChartStreamingCardRes;", "Lcom/iloen/melon/net/v6x/response/ChartStreamingCardRes$Response;", "response", "Lie/H;", "updateUi", "(Lcom/iloen/melon/net/v6x/response/ChartStreamingCardRes$Response;)V", "showCardInfoPage", "Landroid/view/View;", "view", "shareStreamingCard", "(Landroid/view/View;Lcom/iloen/melon/net/v6x/response/ChartStreamingCardRes$Response;)V", "saveStreamingCard", "(Landroid/view/View;)V", "Landroid/content/Context;", "context", "", "usePrivateStorage", "saveCardFileFromView", "(Landroid/content/Context;Landroid/view/View;Z)Z", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "isScreenLandscapeSupported", "()Z", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Lcom/iloen/melon/sns/model/Sharable;", "getSNSSharable", "()Lcom/iloen/melon/sns/model/Sharable;", "LJ8/s;", "binding", "LJ8/s;", "songId", "Ljava/lang/String;", "Lcom/iloen/melon/fragments/melonchart/StreamingCardFragment$ShareImageData;", "shareImageData", "Lcom/iloen/melon/fragments/melonchart/StreamingCardFragment$ShareImageData;", "Landroid/net/Uri;", "savedImageUri", "Landroid/net/Uri;", "Lyb/b;", "streamingCardUseCase", "Lyb/b;", "getStreamingCardUseCase", "()Lyb/b;", "setStreamingCardUseCase", "(Lyb/b;)V", "Companion", "ShareImageData", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class StreamingCardFragment extends Hilt_StreamingCardFragment {
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001A\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000BR\u0016\u0010\f\u001A\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000B¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/StreamingCardFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_SONG_ID", "SC_FILE_NAME", "bgStreamingCards", "", "", "[Ljava/lang/Integer;", "bgInstagram", "newInstance", "Lcom/iloen/melon/fragments/melonchart/StreamingCardFragment;", "songId", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final StreamingCardFragment newInstance(@NotNull String s) {
            q.g(s, "songId");
            StreamingCardFragment streamingCardFragment0 = new StreamingCardFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("arg_song_id", s);
            streamingCardFragment0.setArguments(bundle0);
            return streamingCardFragment0;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001B\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/melonchart/StreamingCardFragment$ShareImageData;", "", "shareImagePath", "", "shareImageAccessKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getShareImagePath", "()Ljava/lang/String;", "getShareImageAccessKey", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class ShareImageData {
        @Nullable
        private final String shareImageAccessKey;
        @Nullable
        private final String shareImagePath;

        public ShareImageData(@Nullable String s, @Nullable String s1) {
            this.shareImagePath = s;
            this.shareImageAccessKey = s1;
        }

        @Nullable
        public final String getShareImageAccessKey() {
            return this.shareImageAccessKey;
        }

        @Nullable
        public final String getShareImagePath() {
            return this.shareImagePath;
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_SONG_ID = "arg_song_id";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String SC_FILE_NAME = "melon_stcard_";
    @NotNull
    public static final String TAG = "StreamingCardFragment";
    @NotNull
    private static final Integer[] bgInstagram;
    @NotNull
    private static final Integer[] bgStreamingCards;
    @Nullable
    private s binding;
    @Nullable
    private Uri savedImageUri;
    @Nullable
    private ShareImageData shareImageData;
    private String songId;
    @Inject
    public b streamingCardUseCase;

    static {
        StreamingCardFragment.Companion = new Companion(null);
        StreamingCardFragment.$stable = 8;
        StreamingCardFragment.bgStreamingCards = new Integer[]{0x7F0800D7, 0x7F0800D8, 0x7F0800D9};  // drawable:bg_streamingcard_1
        StreamingCardFragment.bgInstagram = new Integer[]{0x7F0800CD, 0x7F0800CE};  // drawable:bg_instastory_1
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return null;
    }

    public static void d0(StreamingCardFragment streamingCardFragment0, Response chartStreamingCardRes$Response0, View view0) {
        StreamingCardFragment.updateUi$lambda$11$lambda$9(streamingCardFragment0, chartStreamingCardRes$Response0, view0);
    }

    public static void e0(StreamingCardFragment streamingCardFragment0, View view0) {
        StreamingCardFragment.updateUi$lambda$11$lambda$5(streamingCardFragment0, view0);
    }

    public static void f0(StreamingCardFragment streamingCardFragment0, View view0) {
        StreamingCardFragment.showCardInfoPage$lambda$12(streamingCardFragment0, view0);
    }

    private final ChartStreamingCardRes fetchData() {
        ChartStreamingCardRes chartStreamingCardRes0;
        Closeable closeable0 = a.f(this.getContext(), this.getCacheKey());
        try {
            chartStreamingCardRes0 = (ChartStreamingCardRes)a.d(((Cursor)closeable0), ChartStreamingCardRes.class);
        }
        catch(Throwable throwable0) {
            d.l(closeable0, throwable0);
            throw throwable0;
        }
        d.l(closeable0, null);
        return chartStreamingCardRes0;
    }

    public static void g0(StreamingCardFragment streamingCardFragment0, ChartStreamingCardRes chartStreamingCardRes0) {
        StreamingCardFragment.onFetchStart$lambda$1(streamingCardFragment0, chartStreamingCardRes0);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        Uri.Builder uri$Builder0 = MelonContentUris.t0.buildUpon();
        String s = this.songId;
        if(s != null) {
            return l1.f(uri$Builder0, "songId", s, "toString(...)");
        }
        q.m("songId");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    @Nullable
    public Sharable getSNSSharable() {
        String s4;
        Response chartStreamingCardRes$Response0 = this.mResponse instanceof Response ? ((Response)this.mResponse) : null;
        if(chartStreamingCardRes$Response0 != null) {
            String s = this.songId;
            if(s != null) {
                String s1 = chartStreamingCardRes$Response0.songName;
                String s2 = "";
                if(s1 == null) {
                    s1 = "";
                }
                String s3 = chartStreamingCardRes$Response0.artistName == null ? "" : chartStreamingCardRes$Response0.artistName;
                ShareImageData streamingCardFragment$ShareImageData0 = this.shareImageData;
                if(streamingCardFragment$ShareImageData0 == null) {
                    s4 = "";
                }
                else {
                    s4 = streamingCardFragment$ShareImageData0.getShareImagePath();
                    if(s4 == null) {
                        s4 = "";
                    }
                }
                ShareImageData streamingCardFragment$ShareImageData1 = this.shareImageData;
                if(streamingCardFragment$ShareImageData1 != null) {
                    String s5 = streamingCardFragment$ShareImageData1.getShareImageAccessKey();
                    if(s5 != null) {
                        s2 = s5;
                    }
                }
                String s6 = String.valueOf(this.savedImageUri);
                Integer[] arr_integer = StreamingCardFragment.bgInstagram;
                q.g(arr_integer, "<this>");
                if(arr_integer.length == 0) {
                    throw new NoSuchElementException("Array is empty.");
                }
                int v = arr_integer[f.b.c(arr_integer.length)].intValue();
                Sharable sharable0 = new SharableStreamingCard();  // 初始化器: Ljava/lang/Object;-><init>()V
                sharable0.a = s;
                sharable0.b = s1;
                sharable0.d = s4;
                sharable0.e = s3;
                sharable0.f = s2;
                sharable0.g = s6;
                sharable0.h = v;
                return sharable0;
            }
            q.m("songId");
            throw null;
        }
        return null;
    }

    @NotNull
    public final b getStreamingCardUseCase() {
        b b0 = this.streamingCardUseCase;
        if(b0 != null) {
            return b0;
        }
        q.m("streamingCardUseCase");
        throw null;
    }

    public static void h0(StreamingCardFragment streamingCardFragment0, Response chartStreamingCardRes$Response0, View view0) {
        StreamingCardFragment.updateUi$lambda$11$lambda$10(streamingCardFragment0, chartStreamingCardRes$Response0, view0);
    }

    public static void i0(StreamingCardFragment streamingCardFragment0, VolleyError volleyError0) {
        StreamingCardFragment.onFetchStart$lambda$2(streamingCardFragment0, volleyError0);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean isScreenLandscapeSupported() {
        return false;
    }

    @NotNull
    public static final StreamingCardFragment newInstance(@NotNull String s) {
        return StreamingCardFragment.Companion.newInstance(s);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @Nullable
    public RecyclerView onCreateRecyclerView() {
        return null;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D0137, viewGroup0, false);  // layout:chart_streaming_card_layout
        int v = 0x7F0A01F7;  // id:card_album_image
        View view1 = I.C(view0, 0x7F0A01F7);  // id:card_album_image
        if(view1 != null) {
            f3 f30 = f3.a(view1);
            v = 0x7F0A01F8;  // id:card_artist_name
            View view2 = I.C(view0, 0x7F0A01F8);  // id:card_artist_name
            if(((MelonTextView)view2) != null) {
                v = 0x7F0A01F9;  // id:card_background
                View view3 = I.C(view0, 0x7F0A01F9);  // id:card_background
                if(((MelonImageView)view3) != null) {
                    v = 0x7F0A01FA;  // id:card_container
                    View view4 = I.C(view0, 0x7F0A01FA);  // id:card_container
                    if(((ConstraintLayout)view4) != null) {
                        v = 0x7F0A01FB;  // id:card_date
                        View view5 = I.C(view0, 0x7F0A01FB);  // id:card_date
                        if(((MelonTextView)view5) != null) {
                            v = 0x7F0A01FC;  // id:card_info
                            View view6 = I.C(view0, 0x7F0A01FC);  // id:card_info
                            if(((MelonTextView)view6) != null) {
                                v = 0x7F0A01FD;  // id:card_info_close
                                View view7 = I.C(view0, 0x7F0A01FD);  // id:card_info_close
                                if(((ImageView)view7) != null) {
                                    v = 0x7F0A01FE;  // id:card_info_container
                                    View view8 = I.C(view0, 0x7F0A01FE);  // id:card_info_container
                                    if(((ConstraintLayout)view8) != null && ((MelonTextView)I.C(view0, 0x7F0A01FF)) != null && (((ImageView)I.C(view0, 0x7F0A0200)) != null && ((MelonImageView)I.C(view0, 0x7F0A0201)) != null)) {  // id:card_info_desc
                                        v = 0x7F0A0202;  // id:card_my_streaming_count
                                        View view9 = I.C(view0, 0x7F0A0202);  // id:card_my_streaming_count
                                        if(((MelonTextView)view9) != null) {
                                            v = 0x7F0A0203;  // id:card_my_streaming_title
                                            View view10 = I.C(view0, 0x7F0A0203);  // id:card_my_streaming_title
                                            if(((MelonTextView)view10) != null) {
                                                v = 0x7F0A0206;  // id:card_root
                                                View view11 = I.C(view0, 0x7F0A0206);  // id:card_root
                                                if(((NestedScrollView)view11) != null) {
                                                    v = 0x7F0A0207;  // id:card_save
                                                    View view12 = I.C(view0, 0x7F0A0207);  // id:card_save
                                                    if(((ImageView)view12) != null) {
                                                        v = 0x7F0A0208;  // id:card_share
                                                        View view13 = I.C(view0, 0x7F0A0208);  // id:card_share
                                                        if(((ImageView)view13) != null) {
                                                            v = 0x7F0A0209;  // id:card_song_title
                                                            View view14 = I.C(view0, 0x7F0A0209);  // id:card_song_title
                                                            if(((MelonTextView)view14) != null) {
                                                                v = 0x7F0A020A;  // id:card_stream_user_count
                                                                View view15 = I.C(view0, 0x7F0A020A);  // id:card_stream_user_count
                                                                if(((MelonTextView)view15) != null) {
                                                                    v = 0x7F0A020B;  // id:card_stream_user_emoji
                                                                    View view16 = I.C(view0, 0x7F0A020B);  // id:card_stream_user_emoji
                                                                    if(((MelonImageView)view16) != null && ((MelonTextView)I.C(view0, 0x7F0A020C)) != null) {  // id:card_stream_user_title
                                                                        v = 0x7F0A020D;  // id:card_streaming_count
                                                                        View view17 = I.C(view0, 0x7F0A020D);  // id:card_streaming_count
                                                                        if(((MelonTextView)view17) != null) {
                                                                            v = 0x7F0A020E;  // id:card_streaming_emoji
                                                                            View view18 = I.C(view0, 0x7F0A020E);  // id:card_streaming_emoji
                                                                            if(((MelonImageView)view18) != null && ((MelonTextView)I.C(view0, 0x7F0A020F)) != null) {  // id:card_streaming_title
                                                                                v = 0x7F0A03D5;  // id:divider
                                                                                View view19 = I.C(view0, 0x7F0A03D5);  // id:divider
                                                                                if(((ImageView)view19) != null) {
                                                                                    v = 0x7F0A044A;  // id:error_layout
                                                                                    View view20 = I.C(view0, 0x7F0A044A);  // id:error_layout
                                                                                    if(((ConstraintLayout)view20) != null && ((ImageView)I.C(view0, 0x7F0A044B)) != null && (((MelonTextView)I.C(view0, 0x7F0A044C)) != null && ((Guideline)I.C(view0, 0x7F0A0509)) != null) && (((Guideline)I.C(view0, 0x7F0A050A)) != null && ((Guideline)I.C(view0, 0x7F0A050D)) != null && (((Guideline)I.C(view0, 0x7F0A050E)) != null && ((Guideline)I.C(view0, 0x7F0A050F)) != null)) && (((Guideline)I.C(view0, 0x7F0A0510)) != null && ((Guideline)I.C(view0, 0x7F0A0511)) != null && (((Guideline)I.C(view0, 0x7F0A0512)) != null && ((Guideline)I.C(view0, 0x7F0A0519)) != null))) {  // id:error_logo
                                                                                        v = 0x7F0A0BAD;  // id:titlebar
                                                                                        View view21 = I.C(view0, 0x7F0A0BAD);  // id:titlebar
                                                                                        if(view21 != null) {
                                                                                            TitleBar titleBar0 = (TitleBar)view21;
                                                                                            this.binding = new s(((LinearLayout)view0), f30, ((MelonTextView)view2), ((MelonImageView)view3), ((ConstraintLayout)view4), ((MelonTextView)view5), ((MelonTextView)view6), ((ImageView)view7), ((ConstraintLayout)view8), ((MelonTextView)view9), ((MelonTextView)view10), ((NestedScrollView)view11), ((ImageView)view12), ((ImageView)view13), ((MelonTextView)view14), ((MelonTextView)view15), ((MelonImageView)view16), ((MelonTextView)view17), ((MelonImageView)view18), ((ImageView)view19), ((ConstraintLayout)view20));
                                                                                            return (LinearLayout)view0;
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        String s1 = this.songId;
        if(s1 != null) {
            if(s1.length() != 0) {
                Context context0 = this.getContext();
                if(a.e(300000L, this.getCacheKey(), context0)) {
                    this.savedImageUri = null;
                    this.shareImageData = null;
                    Context context1 = this.getContext();
                    String s2 = this.songId;
                    if(s2 != null) {
                        RequestBuilder.newInstance(new ChartStreamingCardReq(context1, s2)).tag(this.getRequestTag()).listener(new M(this)).errorListener(new M(this)).request();
                        return true;
                    }
                    q.m("songId");
                    throw null;
                }
                ChartStreamingCardRes chartStreamingCardRes0 = this.fetchData();
                if(chartStreamingCardRes0 != null) {
                    Response chartStreamingCardRes$Response0 = chartStreamingCardRes0.response;
                    if(chartStreamingCardRes$Response0 != null) {
                        this.mMelonTiaraProperty = new p8.s(chartStreamingCardRes$Response0.section, chartStreamingCardRes$Response0.page, chartStreamingCardRes$Response0.menuId, null);
                        this.updateUi(chartStreamingCardRes$Response0);
                    }
                }
            }
            return false;
        }
        q.m("songId");
        throw null;
    }

    private static final void onFetchStart$lambda$1(StreamingCardFragment streamingCardFragment0, ChartStreamingCardRes chartStreamingCardRes0) {
        if(!streamingCardFragment0.prepareFetchComplete(chartStreamingCardRes0)) {
            s s0 = streamingCardFragment0.binding;
            if(s0 != null) {
                s0.l.setVisibility(8);
            }
            return;
        }
        a.a(streamingCardFragment0.getContext(), chartStreamingCardRes0, streamingCardFragment0.getCacheKey());
        if((chartStreamingCardRes0 == null ? null : chartStreamingCardRes0.response) != null) {
            streamingCardFragment0.mMelonTiaraProperty = new p8.s(chartStreamingCardRes0.response.section, chartStreamingCardRes0.response.page, "", null);
            Response chartStreamingCardRes$Response0 = chartStreamingCardRes0.response;
            q.f(chartStreamingCardRes$Response0, "response");
            streamingCardFragment0.updateUi(chartStreamingCardRes$Response0);
        }
        streamingCardFragment0.performFetchCompleteOnlyViews();
    }

    private static final void onFetchStart$lambda$2(StreamingCardFragment streamingCardFragment0, VolleyError volleyError0) {
        s s0 = streamingCardFragment0.binding;
        if(s0 != null) {
            NestedScrollView nestedScrollView0 = s0.l;
            if(nestedScrollView0 != null) {
                nestedScrollView0.setVisibility(8);
            }
        }
        streamingCardFragment0.performFetchError(volleyError0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        this.songId = l1.g(bundle0, "inState", "arg_song_id", "", "getString(...)");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        String s = this.songId;
        if(s != null) {
            bundle0.putString("arg_song_id", s);
            return;
        }
        q.m("songId");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(B.a.s(1));
            titleBar0.setTitle(this.getString(0x7F1305EF));  // string:melon_chart_streaming_card "이 곡의 스트리밍 카드"
            titleBar0.f(true);
        }
        this.mEmptyView = this.findViewById(0x7F0A08A5);  // id:network_error_layout
    }

    private final boolean saveCardFileFromView(Context context0, View view0, boolean z) {
        Uri uri0;
        Bitmap bitmap0 = ViewUtils.getViewCapture(view0);
        if(bitmap0 != null) {
            try {
                uri0 = null;
                FileUtils fileUtils0 = FileUtils.INSTANCE;
                String s = this.songId;
                if(s == null) {
                    q.m("songId");
                    throw null;
                }
                uri0 = fileUtils0.saveImageFile(context0, bitmap0, "melon_stcard_" + s + "_", z);
            }
            catch(IOException unused_ex) {
            }
            this.savedImageUri = uri0;
        }
        return this.savedImageUri != null;
    }

    public static boolean saveCardFileFromView$default(StreamingCardFragment streamingCardFragment0, Context context0, View view0, boolean z, int v, Object object0) {
        if((v & 4) != 0) {
            z = false;
        }
        return streamingCardFragment0.saveCardFileFromView(context0, view0, z);
    }

    private final void saveStreamingCard(View view0) {
        Context context0 = this.getContext();
        if(context0 != null) {
            if(StreamingCardFragment.saveCardFileFromView$default(this, context0, view0, false, 4, null)) {
                ToastManager.show(this.getString(0x7F1305F5));  // string:melon_chart_streaming_card_save "스트리밍 카드가 저장되었습니다."
                return;
            }
            ToastManager.show(this.getString(0x7F1305F6));  // string:melon_chart_streaming_card_save_fail "스트리밍 카드 저장이 실패하였습니다."
        }
    }

    public final void setStreamingCardUseCase(@NotNull b b0) {
        q.g(b0, "<set-?>");
        this.streamingCardUseCase = b0;
    }

    private final void shareStreamingCard(View view0, Response chartStreamingCardRes$Response0) {
        InputStream inputStream0;
        if(this.shareImageData == null) {
            if(this.savedImageUri == null) {
                Context context0 = this.getContext();
                if(context0 != null && !StreamingCardFragment.saveCardFileFromView$default(this, context0, view0, false, 4, null)) {
                    ToastManager.show(this.getString(0x7F1305F6));  // string:melon_chart_streaming_card_save_fail "스트리밍 카드 저장이 실패하였습니다."
                }
            }
            Uri uri0 = this.savedImageUri;
            if(uri0 != null) {
                try {
                    Context context1 = this.getContext();
                    if(context1 == null) {
                        inputStream0 = null;
                    }
                    else {
                        ContentResolver contentResolver0 = context1.getContentResolver();
                        inputStream0 = contentResolver0 == null ? null : contentResolver0.openInputStream(uri0);
                    }
                    Context context2 = this.getContext();
                    String s = FileUtils.INSTANCE.getImageFilePathForUri(context2, uri0);
                    String s1 = "";
                    if(s != null) {
                        s1 = new File(s).getName();
                        q.f(s1, "getName(...)");
                    }
                    if(inputStream0 != null) {
                        MediaType mediaType0 = MediaType.Companion.parse("image/*");
                        byte[] arr_b = w.N(inputStream0);
                        RequestBody requestBody0 = okhttp3.RequestBody.Companion.create$default(RequestBody.Companion, arr_b, mediaType0, 0, 0, 6, null);
                        Part multipartBody$Part0 = Part.Companion.createFormData("imgFile", s1, requestBody0);
                        D d0 = this.getViewLifecycleOwner();
                        q.f(d0, "getViewLifecycleOwner(...)");
                        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new n(multipartBody$Part0, chartStreamingCardRes$Response0, null) {
                            @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
                            public static final class WhenMappings {
                                public static final int[] $EnumSwitchMapping$0;

                                static {
                                    int[] arr_v = new int[Na.a.values().length];
                                    try {
                                        arr_v[0] = 1;
                                    }
                                    catch(NoSuchFieldError unused_ex) {
                                    }
                                    try {
                                        arr_v[1] = 2;
                                    }
                                    catch(NoSuchFieldError unused_ex) {
                                    }
                                    WhenMappings.$EnumSwitchMapping$0 = arr_v;
                                }
                            }

                            final Part $multipartBodyPart;
                            final Response $response;
                            int label;

                            {
                                StreamingCardFragment.this = streamingCardFragment0;
                                this.$multipartBodyPart = multipartBody$Part0;
                                this.$response = chartStreamingCardRes$Response0;
                                super(2, continuation0);
                            }

                            @Override  // oe.a
                            public final Continuation create(Object object0, Continuation continuation0) {
                                return new com.iloen.melon.fragments.melonchart.StreamingCardFragment.shareStreamingCard.3.2(StreamingCardFragment.this, this.$multipartBodyPart, this.$response, continuation0);
                            }

                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                            }

                            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                return ((com.iloen.melon.fragments.melonchart.StreamingCardFragment.shareStreamingCard.3.2)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                            }

                            @Override  // oe.a
                            public final Object invokeSuspend(Object object0) {
                                String s2;
                                ne.a a0 = ne.a.a;
                                switch(this.label) {
                                    case 0: {
                                        d5.n.D(object0);
                                        StreamingCardFragment.this.showProgress(true);
                                        b b0 = StreamingCardFragment.this.getStreamingCardUseCase();
                                        String s = this.$response.songId;
                                        q.f(s, "songId");
                                        this.label = 1;
                                        object0 = b0.a(this.$multipartBodyPart, s, this);
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
                                switch(((Na.f)object0).getResult().ordinal()) {
                                    case 0: {
                                        StreamingCardFragment.this.showProgress(false);
                                        HttpResponse httpResponse0 = ((Na.f)object0).b();
                                        String s1 = null;
                                        ChartStreamingCardUploadRes chartStreamingCardUploadRes0 = httpResponse0 instanceof ChartStreamingCardUploadRes ? ((ChartStreamingCardUploadRes)httpResponse0) : null;
                                        StreamingCardFragment streamingCardFragment0 = StreamingCardFragment.this;
                                        if(chartStreamingCardUploadRes0 == null) {
                                            s2 = null;
                                        }
                                        else {
                                            RESPONSE chartStreamingCardUploadRes$RESPONSE0 = chartStreamingCardUploadRes0.response;
                                            s2 = chartStreamingCardUploadRes$RESPONSE0 == null ? null : chartStreamingCardUploadRes$RESPONSE0.imgUrl;
                                        }
                                        if(chartStreamingCardUploadRes0 != null) {
                                            RESPONSE chartStreamingCardUploadRes$RESPONSE1 = chartStreamingCardUploadRes0.response;
                                            if(chartStreamingCardUploadRes$RESPONSE1 != null) {
                                                s1 = chartStreamingCardUploadRes$RESPONSE1.accessKey;
                                            }
                                        }
                                        streamingCardFragment0.shareImageData = new ShareImageData(s2, s1);
                                        Sharable sharable0 = StreamingCardFragment.this.getSNSSharable();
                                        if(sharable0 != null) {
                                            StreamingCardFragment.this.showSNSListPopup(sharable0);
                                        }
                                        return H.a;
                                    }
                                    case 1: {
                                        StreamingCardFragment.this.showProgress(false);
                                        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
                                        return H.a;
                                    }
                                    default: {
                                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                    }
                                }
                            }
                        }, 3, null);
                        return;
                    }
                    this.showProgress(false);
                    ToastManager.show(this.getString(0x7F1305F6));  // string:melon_chart_streaming_card_save_fail "스트리밍 카드 저장이 실패하였습니다."
                }
                catch(Exception unused_ex) {
                    ToastManager.show(this.getString(0x7F1305F6));  // string:melon_chart_streaming_card_save_fail "스트리밍 카드 저장이 실패하였습니다."
                }
            }
        }
        else {
            Sharable sharable0 = this.getSNSSharable();
            if(sharable0 != null) {
                this.showSNSListPopup(sharable0);
            }
        }
    }

    private final void showCardInfoPage() {
        s s0 = this.binding;
        if(s0 != null) {
            N n0 = new N(this, 1);
            s0.h.setOnClickListener(n0);
        }
        if(this.binding == null || this.binding.i.getVisibility() != 0) {
            s s2 = this.binding;
            if(s2 != null) {
                s2.i.setVisibility(0);
            }
        }
        else {
            s s1 = this.binding;
            if(s1 != null) {
                s1.i.setVisibility(8);
            }
        }
    }

    private static final void showCardInfoPage$lambda$12(StreamingCardFragment streamingCardFragment0, View view0) {
        s s0 = streamingCardFragment0.binding;
        if(s0 != null) {
            ConstraintLayout constraintLayout0 = s0.i;
            if(constraintLayout0 != null) {
                constraintLayout0.setVisibility(8);
            }
        }
    }

    private final void updateUi(Response chartStreamingCardRes$Response0) {
        s s0 = this.binding;
        if(s0 != null) {
            N n0 = new N(this, 0);
            s0.g.setOnClickListener(n0);
        }
        if(chartStreamingCardRes$Response0.streamCount != null || chartStreamingCardRes$Response0.streamUser != null || chartStreamingCardRes$Response0.myStreamCount != null) {
            s s4 = this.binding;
            if(s4 != null) {
                s4.u.setVisibility(8);
            }
            s s5 = this.binding;
            if(s5 != null) {
                MelonImageView melonImageView0 = s5.d;
                Integer[] arr_integer = StreamingCardFragment.bgStreamingCards;
                q.g(arr_integer, "<this>");
                if(arr_integer.length == 0) {
                    throw new NoSuchElementException("Array is empty.");
                }
                melonImageView0.setBackgroundResource(arr_integer[f.b.c(arr_integer.length)].intValue());
            }
            s s6 = this.binding;
            if(s6 != null) {
                s6.l.setVisibility(0);
            }
            s s7 = this.binding;
            String s8 = "";
            if(s7 != null) {
                s7.o.setText((chartStreamingCardRes$Response0.songName == null ? "" : chartStreamingCardRes$Response0.songName));
            }
            s s9 = this.binding;
            if(s9 != null) {
                MelonTextView melonTextView0 = s9.c;
                String s10 = chartStreamingCardRes$Response0.artistName;
                if(s10 != null) {
                    s8 = s10;
                }
                melonTextView0.setText(s8);
            }
            s s11 = this.binding;
            if(s11 != null) {
                Glide.with(this).load(chartStreamingCardRes$Response0.albumImg).apply(new RequestOptions().centerCrop()).into(s11.b.b);
            }
            if(chartStreamingCardRes$Response0.streamCountEmoji == null || chartStreamingCardRes$Response0.streamCountEmoji.length() == 0) {
                s s14 = this.binding;
                if(s14 != null) {
                    s14.s.setVisibility(8);
                }
            }
            else {
                s s12 = this.binding;
                if(s12 != null) {
                    s12.s.setVisibility(0);
                }
                s s13 = this.binding;
                if(s13 != null) {
                    Glide.with(this).load(chartStreamingCardRes$Response0.streamCountEmoji).into(s13.s);
                }
            }
            if(chartStreamingCardRes$Response0.streamUserEmoji == null || chartStreamingCardRes$Response0.streamUserEmoji.length() == 0) {
                s s17 = this.binding;
                if(s17 != null) {
                    s17.q.setVisibility(8);
                }
            }
            else {
                s s15 = this.binding;
                if(s15 != null) {
                    s15.q.setVisibility(0);
                }
                s s16 = this.binding;
                if(s16 != null) {
                    Glide.with(this).load(chartStreamingCardRes$Response0.streamUserEmoji).into(s16.q);
                }
            }
            float f = this.getResources().getDimension(0x7F070443);  // dimen:streaming_card_sub_updating
            float f1 = this.getResources().getDimension(0x7F070441);  // dimen:streaming_card_sub_count
            if(chartStreamingCardRes$Response0.streamCount == null || chartStreamingCardRes$Response0.streamCount.length() == 0) {
                s s22 = this.binding;
                if(s22 != null) {
                    String s23 = this.getString(0x7F1305F7);  // string:melon_chart_streaming_card_updating "업데이트 중"
                    s22.r.setText(s23);
                }
                s s24 = this.binding;
                if(s24 != null) {
                    s24.r.setTextSize(0, f);
                }
                s s25 = this.binding;
                if(s25 != null) {
                    int v1 = ColorUtils.getColor(this.getContext(), 0x7F060159);  // color:gray400s_support_high_contrast
                    s25.r.setTextColor(v1);
                }
                s s26 = this.binding;
                if(s26 != null) {
                    Typeface typeface1 = d5.f.G(this.getContext());
                    s26.r.setTypeface(typeface1);
                }
            }
            else {
                s s18 = this.binding;
                if(s18 != null) {
                    s18.r.setText(chartStreamingCardRes$Response0.streamCount);
                }
                s s19 = this.binding;
                if(s19 != null) {
                    s19.r.setTextSize(0, f1);
                }
                s s20 = this.binding;
                if(s20 != null) {
                    int v = ColorUtils.getColor(this.getContext(), 0x7F0604A1);  // color:white000e
                    s20.r.setTextColor(v);
                }
                s s21 = this.binding;
                if(s21 != null) {
                    Typeface typeface0 = d5.f.F(this.getContext());
                    s21.r.setTypeface(typeface0);
                }
            }
            if(chartStreamingCardRes$Response0.streamUser == null || chartStreamingCardRes$Response0.streamUser.length() == 0) {
                s s31 = this.binding;
                if(s31 != null) {
                    String s32 = this.getString(0x7F1305F7);  // string:melon_chart_streaming_card_updating "업데이트 중"
                    s31.p.setText(s32);
                }
                s s33 = this.binding;
                if(s33 != null) {
                    s33.p.setTextSize(0, f);
                }
                s s34 = this.binding;
                if(s34 != null) {
                    int v3 = ColorUtils.getColor(this.getContext(), 0x7F060159);  // color:gray400s_support_high_contrast
                    s34.p.setTextColor(v3);
                }
                s s35 = this.binding;
                if(s35 != null) {
                    Typeface typeface3 = d5.f.G(this.getContext());
                    s35.p.setTypeface(typeface3);
                }
            }
            else {
                s s27 = this.binding;
                if(s27 != null) {
                    s27.p.setText(chartStreamingCardRes$Response0.streamUser);
                }
                s s28 = this.binding;
                if(s28 != null) {
                    s28.p.setTextSize(0, f1);
                }
                s s29 = this.binding;
                if(s29 != null) {
                    int v2 = ColorUtils.getColor(this.getContext(), 0x7F0604A1);  // color:white000e
                    s29.p.setTextColor(v2);
                }
                s s30 = this.binding;
                if(s30 != null) {
                    Typeface typeface2 = d5.f.F(this.getContext());
                    s30.p.setTypeface(typeface2);
                }
            }
            if(chartStreamingCardRes$Response0.myStreamCount == null || chartStreamingCardRes$Response0.myStreamCount.length() == 0) {
                s s39 = this.binding;
                if(s39 != null) {
                    s39.k.setVisibility(4);
                }
                s s40 = this.binding;
                if(s40 != null) {
                    s40.j.setVisibility(4);
                }
            }
            else {
                s s36 = this.binding;
                if(s36 != null) {
                    s36.k.setVisibility(0);
                }
                s s37 = this.binding;
                if(s37 != null) {
                    s37.j.setVisibility(0);
                }
                s s38 = this.binding;
                if(s38 != null) {
                    s38.j.setText(chartStreamingCardRes$Response0.myStreamCount);
                }
            }
            ViewUtils.hideWhen((this.binding == null ? null : this.binding.t), chartStreamingCardRes$Response0.updtDate == null || chartStreamingCardRes$Response0.updtDate.length() == 0);
            s s41 = this.binding;
            if(s41 != null) {
                s41.f.setText(chartStreamingCardRes$Response0.updtDate);
            }
            s s42 = this.binding;
            if(s42 != null) {
                O o0 = new O(this, chartStreamingCardRes$Response0, 0);
                s42.m.setOnClickListener(o0);
            }
            s s43 = this.binding;
            if(s43 != null) {
                O o1 = new O(this, chartStreamingCardRes$Response0, 1);
                s43.n.setOnClickListener(o1);
            }
        }
        else {
            s s1 = this.binding;
            if(s1 != null) {
                s1.u.setVisibility(0);
            }
            s s2 = this.binding;
            if(s2 != null) {
                s2.m.setVisibility(4);
            }
            s s3 = this.binding;
            if(s3 != null) {
                s3.n.setVisibility(4);
            }
        }
    }

    private static final void updateUi$lambda$11$lambda$10(StreamingCardFragment streamingCardFragment0, Response chartStreamingCardRes$Response0, View view0) {
        String s = null;
        streamingCardFragment0.shareStreamingCard((streamingCardFragment0.binding == null ? null : streamingCardFragment0.binding.e), chartStreamingCardRes$Response0);
        g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
        g0.I = streamingCardFragment0.mMelonTiaraProperty == null ? null : streamingCardFragment0.mMelonTiaraProperty.c;
        g0.a = "공유";
        p8.s s1 = streamingCardFragment0.mMelonTiaraProperty;
        g0.b = s1 == null ? null : s1.a;
        if(s1 != null) {
            s = s1.b;
        }
        g0.c = s;
        g0.d = ActionKind.Share;
        g0.y = streamingCardFragment0.getString(0x7F13100F);  // string:tiara_streaming_card_layer1 "스트리밍카드"
        g0.F = streamingCardFragment0.getString(0x7F13100E);  // string:tiara_streaming_card_copy_share "공유하기"
        g0.e = chartStreamingCardRes$Response0.songId;
        g0.f = Y.i(ContsTypeCode.SONG, "code(...)");
        g0.g = chartStreamingCardRes$Response0.songName;
        g0.a().track();
    }

    private static final void updateUi$lambda$11$lambda$5(StreamingCardFragment streamingCardFragment0, View view0) {
        streamingCardFragment0.showCardInfoPage();
    }

    private static final void updateUi$lambda$11$lambda$9(StreamingCardFragment streamingCardFragment0, Response chartStreamingCardRes$Response0, View view0) {
        String s = null;
        streamingCardFragment0.saveStreamingCard((streamingCardFragment0.binding == null ? null : streamingCardFragment0.binding.e));
        g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
        g0.I = streamingCardFragment0.mMelonTiaraProperty == null ? null : streamingCardFragment0.mMelonTiaraProperty.c;
        g0.a = "페이지이동";
        p8.s s1 = streamingCardFragment0.mMelonTiaraProperty;
        g0.b = s1 == null ? null : s1.a;
        if(s1 != null) {
            s = s1.b;
        }
        g0.c = s;
        g0.d = ActionKind.ClickContent;
        g0.y = streamingCardFragment0.getString(0x7F13100F);  // string:tiara_streaming_card_layer1 "스트리밍카드"
        g0.F = streamingCardFragment0.getString(0x7F13100D);  // string:tiara_streaming_card_copy_download "다운로드"
        g0.e = chartStreamingCardRes$Response0.songId;
        g0.f = Y.i(ContsTypeCode.SONG, "code(...)");
        g0.g = chartStreamingCardRes$Response0.songName;
        g0.a().track();
    }
}

