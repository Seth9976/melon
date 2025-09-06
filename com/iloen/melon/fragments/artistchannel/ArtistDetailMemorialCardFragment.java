package com.iloen.melon.fragments.artistchannel;

import Cb.j;
import De.I;
import J8.P0;
import J8.f3;
import J8.x;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ToggleButton;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.l0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.gson.n;
import com.iloen.melon.custom.BorderImageView;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.FetcherBaseFragment;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.request.ContsPvLogDummyReq.Params;
import com.iloen.melon.net.v4x.request.ContsPvLogDummyReq;
import com.iloen.melon.net.v4x.request.PvLogDummyReq;
import com.iloen.melon.net.v6x.common.MemorialCardInfoBase;
import com.iloen.melon.net.v6x.request.ArtistTemperatureDetailReq;
import com.iloen.melon.net.v6x.request.ArtistTemperatureRegMemorialCardRelayReq;
import com.iloen.melon.net.v6x.request.ArtistTemperatureShareImgReq;
import com.iloen.melon.net.v6x.response.ArtistTemperatureDetailRes.RESPONSE.INFO;
import com.iloen.melon.net.v6x.response.ArtistTemperatureDetailRes.RESPONSE.MEMORIALLIST;
import com.iloen.melon.net.v6x.response.ArtistTemperatureDetailRes.RESPONSE;
import com.iloen.melon.net.v6x.response.ArtistTemperatureDetailRes;
import com.iloen.melon.net.v6x.response.ArtistTemperatureShareImgRes;
import com.iloen.melon.responsecache.a;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.sns.model.SharableMemorialCard;
import com.iloen.melon.utils.FileUtils;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.LyricHighlightUtils;
import com.iloen.melon.utils.ui.MemorialCardUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import com.melon.ui.popup.b;
import e1.u;
import ie.H;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;
import p8.g;
import v9.h;
import v9.i;
import va.e0;
import va.o;

@Metadata(d1 = {"\u0000\u00A6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 Y2\u00020\u0001:\u0003YZ[B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001A\u00020\f2\u0006\u0010\u000B\u001A\u00020\nH\u0014\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0010\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\nH\u0016\u00A2\u0006\u0004\b\u0010\u0010\u000EJ\u000F\u0010\u0012\u001A\u00020\u0011H\u0014\u00A2\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u001A\u001A\u0004\u0018\u00010\u00192\u0006\u0010\u0015\u001A\u00020\u00142\b\u0010\u0017\u001A\u0004\u0018\u00010\u00162\b\u0010\u0018\u001A\u0004\u0018\u00010\nH\u0016\u00A2\u0006\u0004\b\u001A\u0010\u001BJ!\u0010\u001D\u001A\u00020\f2\u0006\u0010\u001C\u001A\u00020\u00192\b\u0010\u0018\u001A\u0004\u0018\u00010\nH\u0016\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u000F\u0010\u001F\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b\u001F\u0010\u0003J\u0011\u0010!\u001A\u0004\u0018\u00010 H\u0014\u00A2\u0006\u0004\b!\u0010\"J\u0019\u0010%\u001A\u0004\u0018\u00010 2\u0006\u0010$\u001A\u00020#H\u0014\u00A2\u0006\u0004\b%\u0010&J-\u0010,\u001A\u00020\u00042\b\u0010(\u001A\u0004\u0018\u00010\'2\b\u0010*\u001A\u0004\u0018\u00010)2\b\u0010+\u001A\u0004\u0018\u00010\u0007H\u0014\u00A2\u0006\u0004\b,\u0010-J\u000F\u0010/\u001A\u00020.H\u0014\u00A2\u0006\u0004\b/\u00100J\u0011\u00102\u001A\u0004\u0018\u000101H\u0002\u00A2\u0006\u0004\b2\u00103J\u0017\u00106\u001A\u00020\f2\u0006\u00105\u001A\u000204H\u0002\u00A2\u0006\u0004\b6\u00107J\u000F\u00108\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b8\u0010\u0003J\u0017\u0010;\u001A\u00020\f2\u0006\u0010:\u001A\u000209H\u0002\u00A2\u0006\u0004\b;\u0010<J\u0017\u0010=\u001A\u00020\f2\u0006\u0010:\u001A\u000209H\u0002\u00A2\u0006\u0004\b=\u0010<J\u0019\u0010>\u001A\u00020\f2\b\u0010\u001C\u001A\u0004\u0018\u00010\u0019H\u0002\u00A2\u0006\u0004\b>\u0010?J\u0019\u0010@\u001A\u00020\f2\b\u0010\u001C\u001A\u0004\u0018\u00010\u0019H\u0002\u00A2\u0006\u0004\b@\u0010?J)\u0010B\u001A\u00020\u00042\u0006\u0010$\u001A\u00020#2\u0006\u0010\u001C\u001A\u00020\u00192\b\b\u0002\u0010A\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\bB\u0010CJ\u0017\u0010D\u001A\u00020\u00072\u0006\u0010(\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\bD\u0010EJ\u0011\u0010G\u001A\u0004\u0018\u00010FH\u0002\u00A2\u0006\u0004\bG\u0010HR\u0018\u0010J\u001A\u0004\u0018\u00010I8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010L\u001A\u00020\u00078\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010N\u001A\u00020\u00078\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bN\u0010MR\u0016\u0010O\u001A\u00020\u00078\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bO\u0010MR\u0016\u0010P\u001A\u00020\u00078\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bP\u0010MR\u0018\u0010R\u001A\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010T\u001A\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bT\u0010SR\u0018\u0010V\u001A\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010X\u001A\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bX\u0010W\u00A8\u0006\\"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailMemorialCardFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "", "isScreenLandscapeSupported", "()Z", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "getPvDummyLogRequest", "()Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "", "onCreateRecyclerView", "()Ljava/lang/Void;", "Landroid/content/Context;", "context", "createRecyclerViewAdapter", "(Landroid/content/Context;)Ljava/lang/Void;", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Lcom/iloen/melon/sns/model/Sharable;", "getSNSSharable", "()Lcom/iloen/melon/sns/model/Sharable;", "Lcom/iloen/melon/net/v6x/response/ArtistTemperatureDetailRes;", "fetchData", "()Lcom/iloen/melon/net/v6x/response/ArtistTemperatureDetailRes;", "Lcom/iloen/melon/net/v6x/response/ArtistTemperatureDetailRes$RESPONSE$MEMORIALLIST;", "memorialCard", "updateUi", "(Lcom/iloen/melon/net/v6x/response/ArtistTemperatureDetailRes$RESPONSE$MEMORIALLIST;)V", "updateToggleUi", "Lcom/iloen/melon/net/v6x/common/MemorialCardInfoBase;", "info", "showRegisterCardRelayPopUp", "(Lcom/iloen/melon/net/v6x/common/MemorialCardInfoBase;)V", "registerCardRelay", "shareMemorialCard", "(Landroid/view/View;)V", "saveMemorialCard", "usePrivateStorage", "saveCardFileFromView", "(Landroid/content/Context;Landroid/view/View;Z)Z", "getMemorialTypeForFileName", "(Ljava/lang/String;)Ljava/lang/String;", "Lp8/f;", "getTiaraEventBuilder", "()Lp8/f;", "LJ8/P0;", "binding", "LJ8/P0;", "temperatureCacheKey", "Ljava/lang/String;", "artistId", "artistName", "cardType", "Lcom/iloen/melon/fragments/artistchannel/ArtistDetailMemorialCardFragment$ShareImageData;", "shareRecordOnImageData", "Lcom/iloen/melon/fragments/artistchannel/ArtistDetailMemorialCardFragment$ShareImageData;", "shareRecordOffImageData", "Landroid/net/Uri;", "savedRecordOnImageUri", "Landroid/net/Uri;", "savedRecordOffImageUri", "Companion", "RegMemorialCardRelayParams", "ShareImageData", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ArtistDetailMemorialCardFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u00052\u0006\u0010\u000E\u001A\u00020\u00052\u0006\u0010\u000F\u001A\u00020\u00052\u0006\u0010\u0010\u001A\u00020\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailMemorialCardFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_CACHE_KEY", "ARG_ARTIST_NAME", "ARG_CARD_TYPE", "DUMMY_CONTS_TYPE_ARTIST", "ME_FILE_NAME", "newInstance", "Lcom/iloen/melon/fragments/artistchannel/ArtistDetailMemorialCardFragment;", "temperatureCacheKey", "artistId", "artistName", "cardType", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ArtistDetailMemorialCardFragment newInstance(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull String s3) {
            q.g(s, "temperatureCacheKey");
            q.g(s1, "artistId");
            q.g(s2, "artistName");
            q.g(s3, "cardType");
            ArtistDetailMemorialCardFragment artistDetailMemorialCardFragment0 = new ArtistDetailMemorialCardFragment();
            Bundle bundle0 = Y.c("argCacheKey", s, "argItemId", s1);
            bundle0.putString("argArtistName", s2);
            bundle0.putString("argCardType", s3);
            artistDetailMemorialCardFragment0.setArguments(bundle0);
            return artistDetailMemorialCardFragment0;
        }
    }

    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0003\u0012\u0006\u0010\u0005\u001A\u00020\u0003\u0012\u0006\u0010\u0006\u001A\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\u000BR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\r\u0010\u000BR\u0011\u0010\u0006\u001A\u00020\u0007¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000F¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailMemorialCardFragment$RegMemorialCardRelayParams;", "", "memberKey", "", "artistId", "type", "info", "Lcom/iloen/melon/net/v6x/common/MemorialCardInfoBase;", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailMemorialCardFragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/iloen/melon/net/v6x/common/MemorialCardInfoBase;)V", "getMemberKey", "()Ljava/lang/String;", "getArtistId", "getType", "getInfo", "()Lcom/iloen/melon/net/v6x/common/MemorialCardInfoBase;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class RegMemorialCardRelayParams {
        @NotNull
        private final String artistId;
        @NotNull
        private final MemorialCardInfoBase info;
        @NotNull
        private final String memberKey;
        @NotNull
        private final String type;

        public RegMemorialCardRelayParams(@NotNull String s, @NotNull String s1, @NotNull String s2, @NotNull MemorialCardInfoBase memorialCardInfoBase0) {
            q.g(s, "memberKey");
            q.g(s1, "artistId");
            q.g(s2, "type");
            q.g(memorialCardInfoBase0, "info");
            ArtistDetailMemorialCardFragment.this = artistDetailMemorialCardFragment0;
            super();
            this.memberKey = s;
            this.artistId = s1;
            this.type = s2;
            this.info = memorialCardInfoBase0;
        }

        @NotNull
        public final String getArtistId() {
            return this.artistId;
        }

        @NotNull
        public final MemorialCardInfoBase getInfo() {
            return this.info;
        }

        @NotNull
        public final String getMemberKey() {
            return this.memberKey;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001B\u0012\b\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0002\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001A\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailMemorialCardFragment$ShareImageData;", "", "shareImagePath", "", "shareImageAccessKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getShareImagePath", "()Ljava/lang/String;", "getShareImageAccessKey", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
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
    private static final String ARG_ARTIST_NAME = "argArtistName";
    @NotNull
    private static final String ARG_CACHE_KEY = "argCacheKey";
    @NotNull
    private static final String ARG_CARD_TYPE = "argCardType";
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String DUMMY_CONTS_TYPE_ARTIST = "ARTIST";
    @NotNull
    private static final String ME_FILE_NAME = "melon_mecard_";
    @NotNull
    public static final String TAG = "ArtistDetailMemorialCardFragment";
    private String artistId;
    private String artistName;
    @Nullable
    private P0 binding;
    private String cardType;
    @Nullable
    private Uri savedRecordOffImageUri;
    @Nullable
    private Uri savedRecordOnImageUri;
    @Nullable
    private ShareImageData shareRecordOffImageData;
    @Nullable
    private ShareImageData shareRecordOnImageData;
    private String temperatureCacheKey;

    static {
        ArtistDetailMemorialCardFragment.Companion = new Companion(null);
        ArtistDetailMemorialCardFragment.$stable = 8;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public j0 createRecyclerViewAdapter(Context context0) {
        return (j0)this.createRecyclerViewAdapter(context0);
    }

    @Nullable
    public Void createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return null;
    }

    private final ArtistTemperatureDetailRes fetchData() {
        Cursor cursor0 = a.f(this.getContext(), this.getCacheKey());
        if(cursor0 != null && cursor0.getCount() > 0) {
            ArtistTemperatureDetailRes artistTemperatureDetailRes0 = (ArtistTemperatureDetailRes)a.d(cursor0, ArtistTemperatureDetailRes.class);
            if(!cursor0.isClosed()) {
                cursor0.close();
            }
            if(artistTemperatureDetailRes0 == null) {
                LogU.Companion.w("ArtistDetailMemorialCardFragment", "fetchData() failed to extract contents");
                return null;
            }
            return artistTemperatureDetailRes0;
        }
        LogU.Companion.w("ArtistDetailMemorialCardFragment", "fetchData() invalid cursor");
        return null;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = this.temperatureCacheKey;
        if(s != null) {
            return s;
        }
        q.m("temperatureCacheKey");
        throw null;
    }

    private final String getMemorialTypeForFileName(String s) {
        switch(s) {
            case "BIRTH_DAY": {
                return "birth";
            }
            case "DEBUT_DAY": {
                return "debut";
            }
            case "FAN_DAY": {
                return "fan";
            }
            case "FIRST_LIKE_SONG": {
                return "first-like";
            }
            case "FIRST_SONG": {
                return "firstsong";
            }
            case "HOT_DAY": {
                return "friendship";
            }
            case "LAST_SONG": {
                return "lastsong";
            }
            case "MAX_MONTH": {
                return "max-month";
            }
            case "TEMPERATURE_TOP": {
                return "top1percent";
            }
            default: {
                return "";
            }
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    @NotNull
    public PvLogDummyReq getPvDummyLogRequest() {
        Params contsPvLogDummyReq$Params0 = new Params();
        String s = this.artistId;
        if(s != null) {
            contsPvLogDummyReq$Params0.contsId = s;
            contsPvLogDummyReq$Params0.contsType = "ARTIST";
            return new ContsPvLogDummyReq(this.getContext(), "artistTemperatureMemorialCard", contsPvLogDummyReq$Params0);
        }
        q.m("artistId");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    @NotNull
    public Sharable getSNSSharable() {
        String s3;
        ShareImageData artistDetailMemorialCardFragment$ShareImageData0 = this.binding == null || (this.binding.n == null || !this.binding.n.isChecked()) ? this.shareRecordOffImageData : this.shareRecordOnImageData;
        Uri uri0 = this.binding == null || (this.binding.n == null || !this.binding.n.isChecked()) ? this.savedRecordOffImageUri : this.savedRecordOnImageUri;
        String s = this.artistId;
        if(s != null) {
            String s1 = "";
            String s2 = this.artistName;
            if(s2 != null) {
                if(artistDetailMemorialCardFragment$ShareImageData0 == null) {
                    s3 = "";
                }
                else {
                    s3 = artistDetailMemorialCardFragment$ShareImageData0.getShareImagePath();
                    if(s3 == null) {
                        s3 = "";
                    }
                }
                if(artistDetailMemorialCardFragment$ShareImageData0 != null) {
                    String s4 = artistDetailMemorialCardFragment$ShareImageData0.getShareImageAccessKey();
                    if(s4 != null) {
                        s1 = s4;
                    }
                }
                Sharable sharable0 = new SharableMemorialCard();  // 初始化器: Ljava/lang/Object;-><init>()V
                sharable0.a = s;
                sharable0.b = s3;
                sharable0.d = s2;
                sharable0.e = s1;
                sharable0.f = String.valueOf(uri0);
                return sharable0;
            }
            q.m("artistName");
            throw null;
        }
        q.m("artistId");
        throw null;
    }

    private final f getTiaraEventBuilder() {
        if(this.mResponse == null) {
            return null;
        }
        f f0 = new g();  // 初始化器: Lp8/f;-><init>()V
        f0.b = this.mResponse.section;
        f0.c = this.mResponse.page;
        String s = this.artistId;
        if(s != null) {
            f0.o = s;
            f0.p = Y.i(ContsTypeCode.ARTIST, "code(...)");
            String s1 = this.artistName;
            if(s1 != null) {
                f0.q = s1;
                f0.I = this.mResponse.menuId;
                return f0;
            }
            q.m("artistName");
            throw null;
        }
        q.m("artistId");
        throw null;
    }

    public static H h0(ArtistDetailMemorialCardFragment artistDetailMemorialCardFragment0, MemorialCardInfoBase memorialCardInfoBase0) {
        return ArtistDetailMemorialCardFragment.showRegisterCardRelayPopUp$lambda$17(artistDetailMemorialCardFragment0, memorialCardInfoBase0);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean isScreenLandscapeSupported() {
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public RecyclerView onCreateRecyclerView() {
        return null;
    }

    @Nullable
    public Void onCreateRecyclerView() [...] // Inlined contents

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D0294, viewGroup0, false);  // layout:fragment_artist_detail_memorial_card
        int v = 0x7F0A00B5;  // id:artist_desc_tv
        View view1 = I.C(view0, 0x7F0A00B5);  // id:artist_desc_tv
        if(((MelonTextView)view1) != null) {
            v = 0x7F0A00BA;  // id:artist_name_tv
            View view2 = I.C(view0, 0x7F0A00BA);  // id:artist_name_tv
            if(((MelonTextView)view2) != null) {
                v = 0x7F0A0105;  // id:bg_iv
                View view3 = I.C(view0, 0x7F0A0105);  // id:bg_iv
                if(((MelonImageView)view3) != null) {
                    v = 0x7F0A0206;  // id:card_root
                    View view4 = I.C(view0, 0x7F0A0206);  // id:card_root
                    if(((NestedScrollView)view4) != null && ((CardView)I.C(view0, 0x7F0A0211)) != null) {  // id:card_view
                        v = 0x7F0A0240;  // id:center_tv
                        View view5 = I.C(view0, 0x7F0A0240);  // id:center_tv
                        if(((MelonTextView)view5) != null && ((LinearLayout)I.C(view0, 0x7F0A03A3)) != null) {  // id:desc1_layout
                            v = 0x7F0A03A4;  // id:desc1_tv
                            View view6 = I.C(view0, 0x7F0A03A4);  // id:desc1_tv
                            if(((MelonTextView)view6) != null && ((LinearLayout)I.C(view0, 0x7F0A03A5)) != null) {  // id:desc2_layout
                                v = 0x7F0A03D1;  // id:divide_point
                                View view7 = I.C(view0, 0x7F0A03D1);  // id:divide_point
                                if(((ImageView)view7) != null) {
                                    v = 0x7F0A03ED;  // id:download_iv
                                    View view8 = I.C(view0, 0x7F0A03ED);  // id:download_iv
                                    if(((ImageView)view8) != null) {
                                        v = 0x7F0A04DF;  // id:frame_layout
                                        View view9 = I.C(view0, 0x7F0A04DF);  // id:frame_layout
                                        if(((FrameLayout)view9) != null && ((MelonTextView)I.C(view0, 0x7F0A0508)) != null) {  // id:guide_tv
                                            v = 0x7F0A0513;  // id:guideline_center_tv
                                            View view10 = I.C(view0, 0x7F0A0513);  // id:guideline_center_tv
                                            if(((Guideline)view10) != null && ((Guideline)I.C(view0, 0x7F0A0516)) != null && (((Guideline)I.C(view0, 0x7F0A0517)) != null && ((Guideline)I.C(view0, 0x7F0A051B)) != null) && ((Guideline)I.C(view0, 0x7F0A051C)) != null) {  // id:guideline_count
                                                v = 0x7F0A051F;  // id:guideline_thumb_bottom
                                                View view11 = I.C(view0, 0x7F0A051F);  // id:guideline_thumb_bottom
                                                if(((Guideline)view11) != null) {
                                                    v = 0x7F0A0520;  // id:guideline_thumb_top
                                                    View view12 = I.C(view0, 0x7F0A0520);  // id:guideline_thumb_top
                                                    if(((Guideline)view12) != null && ((Guideline)I.C(view0, 0x7F0A0521)) != null) {  // id:guideline_title
                                                        v = 0x7F0A09CB;  // id:record_toggle_btn
                                                        View view13 = I.C(view0, 0x7F0A09CB);  // id:record_toggle_btn
                                                        if(((ToggleButton)view13) != null) {
                                                            v = 0x7F0A09CC;  // id:record_toggle_layout
                                                            View view14 = I.C(view0, 0x7F0A09CC);  // id:record_toggle_layout
                                                            if(((LinearLayout)view14) != null) {
                                                                v = 0x7F0A09D8;  // id:register_btn
                                                                View view15 = I.C(view0, 0x7F0A09D8);  // id:register_btn
                                                                if(((MelonTextView)view15) != null) {
                                                                    v = 0x7F0A0A83;  // id:share_iv
                                                                    View view16 = I.C(view0, 0x7F0A0A83);  // id:share_iv
                                                                    if(((ImageView)view16) != null) {
                                                                        v = 0x7F0A0B43;  // id:temperature_degree_iv
                                                                        View view17 = I.C(view0, 0x7F0A0B43);  // id:temperature_degree_iv
                                                                        if(((ImageView)view17) != null) {
                                                                            v = 0x7F0A0B83;  // id:thumbnail_border_layout
                                                                            View view18 = I.C(view0, 0x7F0A0B83);  // id:thumbnail_border_layout
                                                                            if(view18 != null) {
                                                                                x x0 = x.b(view18);
                                                                                v = 0x7F0A0B85;  // id:thumbnail_layout
                                                                                View view19 = I.C(view0, 0x7F0A0B85);  // id:thumbnail_layout
                                                                                if(view19 != null) {
                                                                                    f3 f30 = f3.a(view19);
                                                                                    v = 0x7F0A0B9E;  // id:title_layout
                                                                                    if(((LinearLayout)I.C(view0, 0x7F0A0B9E)) != null) {  // id:title_layout
                                                                                        v = 0x7F0A0BAA;  // id:title_tv
                                                                                        View view20 = I.C(view0, 0x7F0A0BAA);  // id:title_tv
                                                                                        if(((MelonTextView)view20) != null) {
                                                                                            v = 0x7F0A0BAD;  // id:titlebar
                                                                                            View view21 = I.C(view0, 0x7F0A0BAD);  // id:titlebar
                                                                                            if(view21 != null) {
                                                                                                TitleBar titleBar0 = (TitleBar)view21;
                                                                                                v = 0x7F0A0D6B;  // id:underline
                                                                                                View view22 = I.C(view0, 0x7F0A0D6B);  // id:underline
                                                                                                if(view22 != null) {
                                                                                                    this.binding = new P0(((LinearLayout)view0), ((MelonTextView)view1), ((MelonTextView)view2), ((MelonImageView)view3), ((NestedScrollView)view4), ((MelonTextView)view5), ((MelonTextView)view6), ((ImageView)view7), ((ImageView)view8), ((FrameLayout)view9), ((Guideline)view10), ((Guideline)view11), ((Guideline)view12), ((ToggleButton)view13), ((LinearLayout)view14), ((MelonTextView)view15), ((ImageView)view16), ((ImageView)view17), x0, f30, ((MelonTextView)view20), view22);
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
        this.shareRecordOnImageData = null;
        this.shareRecordOffImageData = null;
        this.savedRecordOnImageUri = null;
        this.savedRecordOffImageUri = null;
        ArtistTemperatureDetailRes artistTemperatureDetailRes0 = this.fetchData();
        if(artistTemperatureDetailRes0 != null) {
            Context context0 = this.getContext();
            String s1 = this.getCacheKey();
            if(!a.e(FetcherBaseFragment.EXPIRED_TIME_LIMIT, s1, context0)) {
                ArrayList arrayList0 = artistTemperatureDetailRes0.response == null ? null : artistTemperatureDetailRes0.response.memorialList;
                if(arrayList0 != null) {
                    Iterator iterator0 = arrayList0.iterator();
                    q.f(iterator0, "iterator(...)");
                    while(iterator0.hasNext()) {
                        Object object0 = iterator0.next();
                        MEMORIALLIST artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0 = (MEMORIALLIST)object0;
                        String s2 = this.cardType;
                        if(s2 != null) {
                            if(!s2.equals(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.type)) {
                                continue;
                            }
                            this.updateUi(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0);
                            continue;
                        }
                        q.m("cardType");
                        throw null;
                    }
                }
                return false;
            }
        }
        Context context1 = this.getContext();
        String s3 = this.artistId;
        if(s3 != null) {
            RequestBuilder.newInstance(new ArtistTemperatureDetailReq(context1, s3, false)).tag(this.getRequestTag()).listener(new C(this, 0)).errorListener(new C(this, 1)).request();
            return true;
        }
        q.m("artistId");
        throw null;
    }

    private static final void onFetchStart$lambda$1(ArtistDetailMemorialCardFragment artistDetailMemorialCardFragment0, ArtistTemperatureDetailRes artistTemperatureDetailRes0) {
        ArrayList arrayList0;
        if(!artistDetailMemorialCardFragment0.prepareFetchComplete(artistTemperatureDetailRes0)) {
            return;
        }
        a.a(artistDetailMemorialCardFragment0.getContext(), artistTemperatureDetailRes0, artistDetailMemorialCardFragment0.getCacheKey());
        if(artistTemperatureDetailRes0 == null) {
            arrayList0 = null;
        }
        else {
            RESPONSE artistTemperatureDetailRes$RESPONSE0 = artistTemperatureDetailRes0.response;
            arrayList0 = artistTemperatureDetailRes$RESPONSE0 == null ? null : artistTemperatureDetailRes$RESPONSE0.memorialList;
        }
        if(arrayList0 != null) {
            Iterator iterator0 = arrayList0.iterator();
            q.f(iterator0, "iterator(...)");
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                MEMORIALLIST artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0 = (MEMORIALLIST)object0;
                String s = artistDetailMemorialCardFragment0.cardType;
                if(s != null) {
                    if(!s.equals(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.type)) {
                        continue;
                    }
                    artistDetailMemorialCardFragment0.updateUi(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0);
                    continue;
                }
                q.m("cardType");
                throw null;
            }
        }
        artistDetailMemorialCardFragment0.performFetchCompleteOnlyViews();
    }

    private static final void onFetchStart$lambda$2(ArtistDetailMemorialCardFragment artistDetailMemorialCardFragment0, VolleyError volleyError0) {
        P0 p00 = artistDetailMemorialCardFragment0.binding;
        if(p00 != null) {
            NestedScrollView nestedScrollView0 = p00.e;
            if(nestedScrollView0 != null) {
                nestedScrollView0.setVisibility(8);
            }
        }
        artistDetailMemorialCardFragment0.performFetchError(volleyError0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        this.temperatureCacheKey = l1.g(bundle0, "inState", "argCacheKey", "", "getString(...)");
        String s = bundle0.getString("argItemId", "");
        q.f(s, "getString(...)");
        this.artistId = s;
        String s1 = bundle0.getString("argArtistName", "");
        q.f(s1, "getString(...)");
        this.artistName = s1;
        String s2 = bundle0.getString("argCardType", "");
        q.f(s2, "getString(...)");
        this.cardType = s2;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        String s = this.temperatureCacheKey;
        if(s != null) {
            bundle0.putString("argCacheKey", s);
            String s1 = this.artistId;
            if(s1 != null) {
                bundle0.putString("argItemId", s1);
                String s2 = this.artistName;
                if(s2 != null) {
                    bundle0.putString("argArtistName", s2);
                    String s3 = this.cardType;
                    if(s3 != null) {
                        bundle0.putString("argCardType", s3);
                        return;
                    }
                    q.m("cardType");
                    throw null;
                }
                q.m("artistName");
                throw null;
            }
            q.m("artistId");
            throw null;
        }
        q.m("temperatureCacheKey");
        throw null;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.getTitleBar().a(B.a.s(1));
        TitleBar titleBar0 = this.getTitleBar();
        com.iloen.melon.utils.ui.MemorialCardUtils.Companion memorialCardUtils$Companion0 = MemorialCardUtils.Companion;
        Context context0 = this.getContext();
        String s = this.cardType;
        if(s != null) {
            titleBar0.setTitle(memorialCardUtils$Companion0.getMemorialTitle(context0, s));
            this.mEmptyView = this.findViewById(0x7F0A08A5);  // id:network_error_layout
            return;
        }
        q.m("cardType");
        throw null;
    }

    private final void registerCardRelay(MemorialCardInfoBase memorialCardInfoBase0) {
        String s = u.v(((e0)o.a()).j());
        String s1 = this.artistId;
        if(s1 != null) {
            String s2 = this.cardType;
            if(s2 != null) {
                RegMemorialCardRelayParams artistDetailMemorialCardFragment$RegMemorialCardRelayParams0 = new RegMemorialCardRelayParams(this, s, s1, s2, memorialCardInfoBase0);
                String s3 = new n().k(artistDetailMemorialCardFragment$RegMemorialCardRelayParams0);
                RequestBuilder.newInstance(new ArtistTemperatureRegMemorialCardRelayReq(this.getContext(), s3)).tag(this.getRequestTag()).listener(new C(this, 2)).errorListener(new s(4)).request();
                return;
            }
            q.m("cardType");
            throw null;
        }
        q.m("artistId");
        throw null;
    }

    private static final void registerCardRelay$lambda$19(ArtistDetailMemorialCardFragment artistDetailMemorialCardFragment0, Object object0) {
        q.e(object0, "null cannot be cast to non-null type com.iloen.melon.net.HttpResponse");
        j.b(((HttpResponse)object0).notification, false, 3);
        if(j.d(((HttpResponse)object0)) && ((HttpResponse)object0).notification == null) {
            com.iloen.melon.fragments.artistchannel.ArtistDetailFanListFragment.Companion artistDetailFanListFragment$Companion0 = ArtistDetailFanListFragment.Companion;
            String s = artistDetailMemorialCardFragment0.artistId;
            if(s != null) {
                String s1 = artistDetailMemorialCardFragment0.artistName;
                if(s1 != null) {
                    Navigator.open(artistDetailFanListFragment$Companion0.newInstance(s, s1));
                    return;
                }
                q.m("artistName");
                throw null;
            }
            q.m("artistId");
            throw null;
        }
    }

    private static final void registerCardRelay$lambda$20(VolleyError volleyError0) {
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    private final boolean saveCardFileFromView(Context context0, View view0, boolean z) {
        Bitmap bitmap0 = ViewUtils.getViewCapture(view0);
        Uri uri0 = null;
        if(bitmap0 != null) {
            try {
                String s = this.cardType;
                if(s == null) {
                    q.m("cardType");
                    throw null;
                }
                String s1 = this.getMemorialTypeForFileName(s);
                String s2 = this.binding == null || (this.binding.n == null || !this.binding.n.isChecked()) ? "" : "streaming_";
                String s3 = this.artistId;
                if(s3 == null) {
                    q.m("artistId");
                    throw null;
                }
                uri0 = FileUtils.INSTANCE.saveImageFile(context0, bitmap0, "melon_mecard_" + s1 + "_" + s3 + "_" + s2, z);
            }
            catch(IOException unused_ex) {
            }
            if(this.binding != null && (this.binding.n != null && this.binding.n.isChecked())) {
                this.savedRecordOnImageUri = uri0;
                return uri0 != null;
            }
            this.savedRecordOffImageUri = uri0;
        }
        return uri0 != null;
    }

    public static boolean saveCardFileFromView$default(ArtistDetailMemorialCardFragment artistDetailMemorialCardFragment0, Context context0, View view0, boolean z, int v, Object object0) {
        if((v & 4) != 0) {
            z = false;
        }
        return artistDetailMemorialCardFragment0.saveCardFileFromView(context0, view0, z);
    }

    private final void saveMemorialCard(View view0) {
        if(view0 != null) {
            Context context0 = this.getContext();
            if(context0 != null) {
                if(ArtistDetailMemorialCardFragment.saveCardFileFromView$default(this, context0, view0, false, 4, null)) {
                    ToastManager.show(this.getString(0x7F130156));  // string:artist_memorial_card_save "메모리얼 카드가 저장되었습니다."
                    return;
                }
                ToastManager.show(this.getString(0x7F130157));  // string:artist_memorial_card_save_fail "메모리얼 카드 저장이 실패하였습니다."
            }
        }
    }

    private final void shareMemorialCard(View view0) {
        ShareImageData artistDetailMemorialCardFragment$ShareImageData0 = this.binding == null || !this.binding.n.isChecked() ? this.shareRecordOffImageData : this.shareRecordOnImageData;
        Uri uri0 = this.binding == null || !this.binding.n.isChecked() ? this.savedRecordOffImageUri : this.savedRecordOnImageUri;
        if(artistDetailMemorialCardFragment$ShareImageData0 != null) {
            this.showSNSListPopup(this.getSNSSharable());
            return;
        }
        Context context0 = this.getContext();
        if(context0 != null && view0 != null) {
            if(this.saveCardFileFromView(context0, view0, true)) {
                uri0 = this.binding == null || !this.binding.n.isChecked() ? this.savedRecordOffImageUri : this.savedRecordOnImageUri;
            }
            else {
                ToastManager.show(this.getString(0x7F130157));  // string:artist_memorial_card_save_fail "메모리얼 카드 저장이 실패하였습니다."
            }
        }
        if(uri0 != null) {
            this.showProgress(true);
            Context context1 = this.getContext();
            String s = FileUtils.INSTANCE.getImageFilePathForUri(context1, uri0);
            if(s != null) {
                RequestBuilder.newInstance(new ArtistTemperatureShareImgReq(this.getContext(), "MEMORIAL_CARD")).tag(this.getRequestTag()).file("imgFile", new File(s)).listener(new C(this, 3)).errorListener(new C(this, 4)).request();
                return;
            }
            this.showProgress(false);
            ToastManager.show(this.getString(0x7F130157));  // string:artist_memorial_card_save_fail "메모리얼 카드 저장이 실패하였습니다."
        }
    }

    private static final void shareMemorialCard$lambda$25$lambda$23(ArtistDetailMemorialCardFragment artistDetailMemorialCardFragment0, ArtistTemperatureShareImgRes artistTemperatureShareImgRes0) {
        if(artistDetailMemorialCardFragment0.isFragmentValid()) {
            artistDetailMemorialCardFragment0.showProgress(false);
            if((artistTemperatureShareImgRes0 == null ? null : artistTemperatureShareImgRes0.response) != null) {
                j.b(artistTemperatureShareImgRes0.notification, false, 3);
                if(j.d(artistTemperatureShareImgRes0)) {
                    if(artistDetailMemorialCardFragment0.binding == null || !artistDetailMemorialCardFragment0.binding.n.isChecked()) {
                        artistDetailMemorialCardFragment0.shareRecordOffImageData = new ShareImageData(artistTemperatureShareImgRes0.response.imgUrl, artistTemperatureShareImgRes0.response.kageAccessKey);
                    }
                    else {
                        artistDetailMemorialCardFragment0.shareRecordOnImageData = new ShareImageData(artistTemperatureShareImgRes0.response.imgUrl, artistTemperatureShareImgRes0.response.kageAccessKey);
                    }
                    artistDetailMemorialCardFragment0.showSNSListPopup(artistDetailMemorialCardFragment0.getSNSSharable());
                }
            }
        }
    }

    private static final void shareMemorialCard$lambda$25$lambda$24(ArtistDetailMemorialCardFragment artistDetailMemorialCardFragment0, VolleyError volleyError0) {
        artistDetailMemorialCardFragment0.showProgress(false);
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    private final void showRegisterCardRelayPopUp(MemorialCardInfoBase memorialCardInfoBase0) {
        l0 l00 = this.getChildFragmentManager();
        String s = this.getString(0x7F13016A);  // string:artist_memorial_register_popup_message "카드릴레이에\n참여하시겠습니까?\n(카드별 1일 1회 참여 
                                                // 가능)"
        String s1 = this.getString(0x7F130227);  // string:confirm "확인"
        b.x(l00, null, s, false, false, this.getString(0x7F130199), s1, new A(this, memorialCardInfoBase0, 1), null, null, null, 3640);  // string:cancel "취소"
    }

    private static final H showRegisterCardRelayPopUp$lambda$17(ArtistDetailMemorialCardFragment artistDetailMemorialCardFragment0, MemorialCardInfoBase memorialCardInfoBase0) {
        artistDetailMemorialCardFragment0.registerCardRelay(memorialCardInfoBase0);
        return H.a;
    }

    private final void updateToggleUi() {
        if(this.binding == null || (this.binding.n == null || !this.binding.n.isChecked())) {
            P0 p02 = this.binding;
            if(p02 != null) {
                ImageView imageView1 = p02.h;
                if(imageView1 != null) {
                    imageView1.setVisibility(8);
                }
            }
            P0 p03 = this.binding;
            if(p03 != null) {
                MelonTextView melonTextView1 = p03.b;
                if(melonTextView1 != null) {
                    melonTextView1.setVisibility(8);
                }
            }
        }
        else {
            P0 p00 = this.binding;
            if(p00 != null) {
                ImageView imageView0 = p00.h;
                if(imageView0 != null) {
                    imageView0.setVisibility(0);
                }
            }
            P0 p01 = this.binding;
            if(p01 != null) {
                MelonTextView melonTextView0 = p01.b;
                if(melonTextView0 != null) {
                    melonTextView0.setVisibility(0);
                }
            }
        }
    }

    private final void updateUi(MEMORIALLIST artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0) {
        String s11;
        String s3;
        Context context0 = this.getContext();
        String s = artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.type;
        q.f(s, "type");
        String s1 = MemorialCardUtils.Companion.getMemorialTitle(context0, s);
        P0 p00 = this.binding;
        if(p00 != null) {
            MelonTextView melonTextView0 = p00.u;
            String s2 = artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.type;
            if(q.b(s2, "BIRTH_DAY")) {
                s3 = this.getString(0x7F13015F);  // string:artist_memorial_happy_birthday "HAPPY BIRTHDAY"
            }
            else if(q.b(s2, "DEBUT_DAY")) {
                String s4 = this.getString(0x7F130154);  // string:artist_memorial_anniversary "%1$s ANNIVERSARY"
                q.f(s4, "getString(...)");
                s3 = String.format(s4, Arrays.copyOf(new Object[]{artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.years}, 1));
            }
            else {
                s3 = s1;
            }
            melonTextView0.setText(s3);
        }
        String s5 = artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.type;
        if(s5 == null) {
        label_41:
            P0 p06 = this.binding;
            if(p06 != null) {
                ((FrameLayout)p06.s.b).setVisibility(0);
            }
            P0 p07 = this.binding;
            if(p07 != null) {
                p07.t.a.setVisibility(8);
            }
            P0 p08 = this.binding;
            if(p08 != null) {
                ((BorderImageView)p08.s.d).setBorderWidth(0);
            }
            if(q.b(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.type, "TEMPERATURE_TOP") || q.b(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.type, "MAX_MONTH") || q.b(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.type, "HOT_DAY")) {
                Context context1 = this.getContext();
                if(context1 != null) {
                    P0 p09 = this.binding;
                    if(p09 != null) {
                        Glide.with(context1).load(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.bgImg).into(p09.d);
                    }
                }
                P0 p010 = this.binding;
                if(p010 != null) {
                    p010.m.setGuidelinePercent(0.262f);
                }
                P0 p011 = this.binding;
                if(p011 != null) {
                    p011.l.setGuidelinePercent(0.569f);
                }
            }
            P0 p012 = this.binding;
            if(p012 != null) {
                ((ImageView)p012.s.c).setImageResource(0x7F080788);  // drawable:noimage_logo_medium
            }
            q.d(((com.iloen.melon.fragments.artistchannel.ArtistDetailMemorialCardFragment.updateUi.1.4.1)Glide.with(this).asBitmap().load(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.artistImg).into(new CustomTarget() {
                @Override  // com.bumptech.glide.request.target.Target
                public void onLoadCleared(Drawable drawable0) {
                }

                public void onResourceReady(Bitmap bitmap0, Transition transition0) {
                    q.g(bitmap0, "resource");
                    P0 p00 = artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.binding;
                    if(p00 != null) {
                        x x0 = p00.s;
                        if(x0 != null) {
                            BorderImageView borderImageView0 = (BorderImageView)x0.d;
                            if(borderImageView0 != null) {
                                Glide.with(this.$it).load(bitmap0).apply(RequestOptions.circleCropTransform()).into(borderImageView0);
                            }
                        }
                    }
                    if(!q.b(this.type, "TEMPERATURE_TOP") && !q.b(this.type, "MAX_MONTH") && !q.b(this.type, "HOT_DAY")) {
                        Context context0 = artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.getContext();
                        if(context0 != null) {
                            P0 p01 = artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.binding;
                            if(p01 != null) {
                                MelonImageView melonImageView0 = p01.d;
                                if(melonImageView0 != null) {
                                    melonImageView0.setImageBitmap(com.iloen.melon.utils.ui.LyricHighlightUtils.Companion.drawPalette$default(LyricHighlightUtils.Companion, context0, bitmap0, false, false, 12, null));
                                }
                            }
                        }
                    }
                    P0 p02 = artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.binding;
                    if(p02 != null) {
                        x x1 = p02.s;
                        if(x1 != null) {
                            BorderImageView borderImageView1 = (BorderImageView)x1.d;
                            if(borderImageView1 != null) {
                                borderImageView1.setBorderWidth(ScreenUtils.dipToPixel(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.getContext(), 0.5f));
                            }
                        }
                    }
                }

                @Override  // com.bumptech.glide.request.target.Target
                public void onResourceReady(Object object0, Transition transition0) {
                    this.onResourceReady(((Bitmap)object0), transition0);
                }
            })));
        }
        else {
            switch(s5) {
                case "FIRST_LIKE_SONG": 
                case "FIRST_SONG": 
                case "LAST_SONG": {
                    P0 p01 = this.binding;
                    if(p01 != null) {
                        ((FrameLayout)p01.s.b).setVisibility(8);
                    }
                    P0 p02 = this.binding;
                    if(p02 != null) {
                        p02.t.a.setVisibility(0);
                    }
                    P0 p03 = this.binding;
                    if(p03 != null) {
                        p03.t.c.setImageResource(0x7F080788);  // drawable:noimage_logo_medium
                    }
                    com.iloen.melon.fragments.artistchannel.ArtistDetailMemorialCardFragment.updateUi.1.1.1 artistDetailMemorialCardFragment$updateUi$1$1$10 = (com.iloen.melon.fragments.artistchannel.ArtistDetailMemorialCardFragment.updateUi.1.1.1)Glide.with(this).asBitmap().load(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.albumImg).into(new CustomTarget() {
                        @Override  // com.bumptech.glide.request.target.Target
                        public void onLoadCleared(Drawable drawable0) {
                        }

                        public void onResourceReady(Bitmap bitmap0, Transition transition0) {
                            q.g(bitmap0, "resource");
                            P0 p00 = ArtistDetailMemorialCardFragment.this.binding;
                            if(p00 != null) {
                                f3 f30 = p00.t;
                                if(f30 != null) {
                                    MelonImageView melonImageView0 = f30.b;
                                    if(melonImageView0 != null) {
                                        melonImageView0.setImageBitmap(bitmap0);
                                    }
                                }
                            }
                            Context context0 = ArtistDetailMemorialCardFragment.this.getContext();
                            if(context0 != null) {
                                P0 p01 = ArtistDetailMemorialCardFragment.this.binding;
                                if(p01 != null) {
                                    MelonImageView melonImageView1 = p01.d;
                                    if(melonImageView1 != null) {
                                        melonImageView1.setImageBitmap(com.iloen.melon.utils.ui.LyricHighlightUtils.Companion.drawPalette$default(LyricHighlightUtils.Companion, context0, bitmap0, false, false, 12, null));
                                    }
                                }
                            }
                        }

                        @Override  // com.bumptech.glide.request.target.Target
                        public void onResourceReady(Object object0, Transition transition0) {
                            this.onResourceReady(((Bitmap)object0), transition0);
                        }
                    });
                    P0 p04 = this.binding;
                    if(p04 != null) {
                        p04.o.setVisibility(0);
                    }
                    P0 p05 = this.binding;
                    if(p05 != null) {
                        D d0 = new D(this);
                        p05.n.setOnCheckedChangeListener(d0);
                    }
                    this.updateToggleUi();
                    break;
                }
                default: {
                    goto label_41;
                }
            }
        }
        String s6 = artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.type;
        if(s6 != null) {
            switch(s6) {
                case "BIRTH_DAY": {
                    String s15 = artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.date;
                    if(s15.length() >= 5) {
                        String s16 = this.getString(0x7F130167);  // string:artist_memorial_month_day "%1$s월 %2$s일"
                        q.f(s16, "getString(...)");
                        s15 = String.format(s16, Arrays.copyOf(new Object[]{Tf.o.V0(s15, new Ce.g(0, 1, 1)), Tf.o.V0(s15, new Ce.g(3, 4, 1))}, 2));  // 初始化器: LCe/e;-><init>(III)V / 初始化器: LCe/e;-><init>(III)V
                    }
                    P0 p030 = this.binding;
                    if(p030 != null) {
                        p030.g.setText(s15);
                    }
                    P0 p031 = this.binding;
                    if(p031 != null) {
                        p031.c.setText(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.artistName);
                    }
                    P0 p032 = this.binding;
                    if(p032 != null) {
                        String s17 = this.getString(0x7F130158);  // string:artist_memorial_celebrate_birthday "의 생일을 축하합니다 ♡"
                        p032.b.setText(s17);
                    }
                    break;
                }
                case "DEBUT_DAY": {
                    String s7 = artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.date;
                    if(s7.length() >= 10) {
                        String s8 = this.getString(0x7F130170);  // string:artist_memorial_year_month_day "%1$s년 %2$s월 %3$s일"
                        q.f(s8, "getString(...)");
                        s7 = String.format(s8, Arrays.copyOf(new Object[]{Tf.o.V0(s7, new Ce.g(0, 3, 1)), Tf.o.V0(s7, new Ce.g(5, 6, 1)), Tf.o.V0(s7, new Ce.g(8, 9, 1))}, 3));  // 初始化器: LCe/e;-><init>(III)V / 初始化器: LCe/e;-><init>(III)V / 初始化器: LCe/e;-><init>(III)V
                    }
                    P0 p013 = this.binding;
                    if(p013 != null) {
                        p013.g.setText(s7);
                    }
                    P0 p014 = this.binding;
                    if(p014 != null) {
                        String s9 = this.getString(0x7F13016E);  // string:artist_memorial_today "오늘은 %1$s"
                        q.f(s9, "getString(...)");
                        l1.D(new Object[]{artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.artistName}, 1, s9, p014.c);
                    }
                    P0 p015 = this.binding;
                    if(p015 != null) {
                        String s10 = this.getString(0x7F130168);  // string:artist_memorial_of_debut_day "의 데뷔기념일!"
                        p015.b.setText(s10);
                    }
                    break;
                }
                case "FAN_DAY": {
                    P0 p022 = this.binding;
                    if(p022 != null) {
                        String s14 = this.getString(0x7F13015B);  // string:artist_memorial_fan_day_desc "만난지 %1$s일 째"
                        q.f(s14, "getString(...)");
                        l1.D(new Object[]{artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.days}, 1, s14, p022.g);
                    }
                    P0 p023 = this.binding;
                    if(p023 != null) {
                        p023.c.setText(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.artistName);
                    }
                    P0 p024 = this.binding;
                    if(p024 != null) {
                        p024.h.setVisibility(0);
                    }
                    P0 p025 = this.binding;
                    if(p025 != null) {
                        p025.b.setText(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.date);
                    }
                    break;
                }
                case "FIRST_LIKE_SONG": 
                case "FIRST_SONG": 
                case "LAST_SONG": {
                    P0 p026 = this.binding;
                    if(p026 != null) {
                        p026.g.setText(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.songName);
                    }
                    P0 p027 = this.binding;
                    if(p027 != null) {
                        p027.c.setText(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.artistName);
                    }
                    P0 p028 = this.binding;
                    if(p028 != null) {
                        p028.h.setVisibility(0);
                    }
                    P0 p029 = this.binding;
                    if(p029 != null) {
                        p029.b.setText(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.date);
                    }
                    break;
                }
                case "HOT_DAY": {
                    P0 p033 = this.binding;
                    if(p033 != null) {
                        p033.k.setGuidelinePercent(0.502f);
                    }
                    P0 p034 = this.binding;
                    if(p034 != null) {
                        p034.f.setText(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.userMaxTemper);
                    }
                    Context context2 = this.getContext();
                    if(context2 != null) {
                        P0 p035 = this.binding;
                        if(p035 != null) {
                            float f = context2.getResources().getDimension(0x7F070313);  // dimen:memorial_card_temperature_tv
                            p035.f.setTextSize(0, f);
                        }
                    }
                    P0 p036 = this.binding;
                    if(p036 != null) {
                        p036.r.setVisibility(0);
                    }
                    P0 p037 = this.binding;
                    if(p037 != null) {
                        p037.g.setText(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.artistName);
                    }
                    P0 p038 = this.binding;
                    if(p038 != null) {
                        p038.c.setText(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.date);
                    }
                    break;
                }
                case "MAX_MONTH": {
                    P0 p019 = this.binding;
                    if(p019 != null) {
                        p019.f.setText(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.date);
                    }
                    P0 p020 = this.binding;
                    if(p020 != null) {
                        p020.g.setText(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.artistName);
                    }
                    P0 p021 = this.binding;
                    if(p021 != null) {
                        String s13 = this.getString(0x7F130166);  // string:artist_memorial_max_month_desc "%1$s회 감상"
                        q.f(s13, "getString(...)");
                        l1.D(new Object[]{artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.streamCnt}, 1, s13, p021.c);
                    }
                    break;
                }
                case "TEMPERATURE_TOP": {
                    P0 p016 = this.binding;
                    if(p016 != null) {
                        p016.f.setText(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.date);
                    }
                    P0 p017 = this.binding;
                    if(p017 != null) {
                        p017.g.setText(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.artistName);
                    }
                    P0 p018 = this.binding;
                    if(p018 != null) {
                        MelonTextView melonTextView1 = p018.c;
                        if(q.b(artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.days, "0")) {
                            s11 = this.getString(0x7F13016C);  // string:artist_memorial_temperature_top_desc "1% 달성!"
                        }
                        else {
                            String s12 = this.getString(0x7F13016D);  // string:artist_memorial_temperature_top_maintain_desc "%1$s일 동안 유지중"
                            q.f(s12, "getString(...)");
                            s11 = String.format(s12, Arrays.copyOf(new Object[]{artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info.days}, 1));
                        }
                        melonTextView1.setText(s11);
                    }
                }
            }
        }
        P0 p039 = this.binding;
        if(p039 != null) {
            E e0 = new E(this, 0);
            p039.i.setOnClickListener(e0);
        }
        MelonTextView melonTextView2 = null;
        ViewUtils.setContentDescriptionWithButtonClassName((this.binding == null ? null : this.binding.i), U4.x.l(s1, " ", this.getString(0x7F130B7E), " ", this.getString(0x7F130B1B)));  // string:talkback_memorail_card "메모리얼 카드"
        P0 p040 = this.binding;
        if(p040 != null) {
            E e1 = new E(this, 1);
            p040.q.setOnClickListener(e1);
        }
        ViewUtils.setContentDescriptionWithButtonClassName((this.binding == null ? null : this.binding.q), U4.x.l(s1, " ", this.getString(0x7F130B7E), " ", this.getString(0x7F130C47)));  // string:talkback_memorail_card "메모리얼 카드"
        P0 p041 = this.binding;
        if(p041 != null) {
            com.iloen.melon.fragments.artistchannel.j j0 = new com.iloen.melon.fragments.artistchannel.j(5, this, artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0);
            p041.p.setOnClickListener(j0);
        }
        P0 p042 = this.binding;
        if(p042 != null) {
            melonTextView2 = p042.p;
        }
        ViewUtils.setContentDescriptionWithButtonClassName(melonTextView2, this.getString(0x7F1304BC));  // string:join "참여하기"
    }

    private static final void updateUi$lambda$16$lambda$11(ArtistDetailMemorialCardFragment artistDetailMemorialCardFragment0, View view0) {
        artistDetailMemorialCardFragment0.saveMemorialCard((artistDetailMemorialCardFragment0.binding == null ? null : artistDetailMemorialCardFragment0.binding.j));
        f f0 = artistDetailMemorialCardFragment0.getTiaraEventBuilder();
        if(f0 != null) {
            f0.a = artistDetailMemorialCardFragment0.getString(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
            f0.d = ActionKind.ClickContent;
            f0.y = artistDetailMemorialCardFragment0.getString(0x7F130EEE);  // string:tiara_memorial_layer1_memorial_card "메모리얼카드"
            f0.F = artistDetailMemorialCardFragment0.getString(0x7F130EEA);  // string:tiara_memorial_card_copy_save "저장"
            f0.a().track();
        }
    }

    private static final void updateUi$lambda$16$lambda$13(ArtistDetailMemorialCardFragment artistDetailMemorialCardFragment0, View view0) {
        artistDetailMemorialCardFragment0.shareMemorialCard((artistDetailMemorialCardFragment0.binding == null ? null : artistDetailMemorialCardFragment0.binding.j));
        f f0 = artistDetailMemorialCardFragment0.getTiaraEventBuilder();
        if(f0 != null) {
            f0.a = artistDetailMemorialCardFragment0.getString(0x7F130DD1);  // string:tiara_common_action_name_share "공유"
            f0.d = ActionKind.Share;
            f0.y = artistDetailMemorialCardFragment0.getString(0x7F130EEE);  // string:tiara_memorial_layer1_memorial_card "메모리얼카드"
            f0.F = artistDetailMemorialCardFragment0.getString(0x7F130EEB);  // string:tiara_memorial_card_copy_share "공유"
            f0.a().track();
        }
    }

    private static final void updateUi$lambda$16$lambda$15(ArtistDetailMemorialCardFragment artistDetailMemorialCardFragment0, MEMORIALLIST artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0, View view0) {
        INFO artistTemperatureDetailRes$RESPONSE$INFO0 = artistTemperatureDetailRes$RESPONSE$MEMORIALLIST0.info;
        q.f(artistTemperatureDetailRes$RESPONSE$INFO0, "info");
        artistDetailMemorialCardFragment0.showRegisterCardRelayPopUp(artistTemperatureDetailRes$RESPONSE$INFO0);
        f f0 = artistDetailMemorialCardFragment0.getTiaraEventBuilder();
        if(f0 != null) {
            f0.a = artistDetailMemorialCardFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.d = ActionKind.ClickContent;
            f0.y = artistDetailMemorialCardFragment0.getString(0x7F130EED);  // string:tiara_memorial_layer1_card_relay "카드릴레이"
            f0.F = artistDetailMemorialCardFragment0.getString(0x7F130EE9);  // string:tiara_memorial_card_copy_card_relay "카드릴레이"
            f0.a().track();
        }
    }

    private static final void updateUi$lambda$16$lambda$5(ArtistDetailMemorialCardFragment artistDetailMemorialCardFragment0, CompoundButton compoundButton0, boolean z) {
        f f0 = artistDetailMemorialCardFragment0.getTiaraEventBuilder();
        if(f0 != null) {
            f0.a = artistDetailMemorialCardFragment0.getString(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
            f0.d = ActionKind.ClickContent;
            f0.y = artistDetailMemorialCardFragment0.getString(0x7F130EEE);  // string:tiara_memorial_layer1_memorial_card "메모리얼카드"
            f0.F = artistDetailMemorialCardFragment0.getString(0x7F130EEC);  // string:tiara_memorial_card_copy_streaming_record "감상이력"
            f0.V = artistDetailMemorialCardFragment0.getString((z ? 0x7F130FCF : 0x7F130FCE));  // string:tiara_props_on "on"
            f0.a().track();
        }
        artistDetailMemorialCardFragment0.updateToggleUi();
    }
}

