package com.iloen.melon.fragments.mymusic;

import A7.d;
import De.I;
import J8.b;
import J8.q2;
import J8.r2;
import J8.s2;
import J8.t2;
import J8.u2;
import J8.v2;
import J8.w2;
import J8.x2;
import J8.x;
import J8.y2;
import Q4.a;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.appcompat.app.o;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.A0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.BorderImageView;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.fragments.musicmessage.MusicMessageBlockListFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.DeleteUserImgReq;
import com.iloen.melon.net.v4x.request.UpdateUserImgReq;
import com.iloen.melon.net.v4x.response.DeleteUserImgRes;
import com.iloen.melon.net.v4x.response.UpdateUserImgRes;
import com.iloen.melon.net.v6x.request.DjSnsUseAgreeReq;
import com.iloen.melon.net.v6x.request.MyMusicSettingInformProfileSimpleReq;
import com.iloen.melon.net.v6x.request.MyMusicSiteChannelUpdateRepntReq;
import com.iloen.melon.net.v6x.request.MyMusicUpdateMyProfileOpenYnReq;
import com.iloen.melon.net.v6x.response.DjSnsUseAgreeRes.RESPONSE.OPTION;
import com.iloen.melon.net.v6x.response.DjSnsUseAgreeRes;
import com.iloen.melon.net.v6x.response.MyMusicSettingInformProfileSimpleRes.RESPONSE.DJPICKPLAYLIST;
import com.iloen.melon.net.v6x.response.MyMusicSettingInformProfileSimpleRes.RESPONSE;
import com.iloen.melon.net.v6x.response.MyMusicSettingInformProfileSimpleRes;
import com.iloen.melon.net.v6x.response.MyMusicSiteChannelUpdateRepntRes;
import com.iloen.melon.net.v6x.response.MyMusicUpdateMyProfileOpenYnRes;
import com.iloen.melon.net.v6x.response.ProfileBaseRes.SnsInfoBase;
import com.iloen.melon.popup.MelonTextPopup;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.TimeExpiredCache;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.image.ImageSelector.ImageSelectorListener;
import com.iloen.melon.utils.image.ImageSelector.Request;
import com.iloen.melon.utils.image.ImageSelector;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.system.ToastManager;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.ui.K1;
import com.melon.ui.k2;
import e.k;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import m4.e;
import m4.g;
import m4.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;
import v9.h;
import we.n;
import zd.M;
import zd.z0;

@Metadata(d1 = {"\u0000\u00E4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n*\u0002ou\b\u0007\u0018\u0000 \u007F2\u00020\u00012\u00020\u0002:\u0005\u007F\u0080\u0001\u0081\u0001B\u0007\u00A2\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001A\u00020\u00072\u0006\u0010\u0006\u001A\u00020\u0005H\u0016\u00A2\u0006\u0004\b\b\u0010\tJ-\u0010\u0011\u001A\u0004\u0018\u00010\u00102\u0006\u0010\u000B\u001A\u00020\n2\b\u0010\r\u001A\u0004\u0018\u00010\f2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0016\u00A2\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001A\u00020\u00072\u0006\u0010\u0013\u001A\u00020\u00102\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J\u000F\u0010\u0017\u001A\u00020\u0016H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001A\u001A\u00020\u00072\u0006\u0010\u0019\u001A\u00020\u000EH\u0014\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\u000F\u0010\u001C\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\u001C\u0010\u0004J\u000F\u0010\u001D\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\u001D\u0010\u0004J\u000F\u0010\u001E\u001A\u00020\u0007H\u0016\u00A2\u0006\u0004\b\u001E\u0010\u0004J-\u0010%\u001A\u00020$2\b\u0010 \u001A\u0004\u0018\u00010\u001F2\b\u0010\"\u001A\u0004\u0018\u00010!2\b\u0010#\u001A\u0004\u0018\u00010\u0016H\u0014\u00A2\u0006\u0004\b%\u0010&J\u000F\u0010(\u001A\u00020\'H\u0014\u00A2\u0006\u0004\b(\u0010)J\u001B\u0010-\u001A\u0006\u0012\u0002\b\u00030,2\u0006\u0010+\u001A\u00020*H\u0014\u00A2\u0006\u0004\b-\u0010.J\u000F\u0010/\u001A\u00020$H\u0016\u00A2\u0006\u0004\b/\u00100J\u000F\u00101\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b1\u0010\u0004J\u0017\u00104\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010302H\u0002\u00A2\u0006\u0004\b4\u00105J\u000F\u00106\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b6\u0010\u0004J\u001F\u00109\u001A\u00020\u00072\u0006\u00107\u001A\u00020\u00162\u0006\u00108\u001A\u00020\u0016H\u0002\u00A2\u0006\u0004\b9\u0010:J7\u0010?\u001A\u0012\u0012\u0004\u0012\u00020<0;j\b\u0012\u0004\u0012\u00020<`=2\u0016\u0010>\u001A\u0012\u0012\u0004\u0012\u00020<0;j\b\u0012\u0004\u0012\u00020<`=H\u0002\u00A2\u0006\u0004\b?\u0010@J\u0017\u0010C\u001A\u00020B2\u0006\u0010A\u001A\u00020\u0016H\u0002\u00A2\u0006\u0004\bC\u0010DJ+\u0010F\u001A\u00020\u00072\u001A\u0010E\u001A\u0016\u0012\u0004\u0012\u00020<\u0018\u00010;j\n\u0012\u0004\u0012\u00020<\u0018\u0001`=H\u0002\u00A2\u0006\u0004\bF\u0010GJ\u0017\u0010J\u001A\u00020\u00072\u0006\u0010I\u001A\u00020HH\u0002\u00A2\u0006\u0004\bJ\u0010KJ\u000F\u0010L\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\bL\u0010\u0004J+\u0010M\u001A\u00020\u00072\u001A\u0010E\u001A\u0016\u0012\u0004\u0012\u00020<\u0018\u00010;j\n\u0012\u0004\u0012\u00020<\u0018\u0001`=H\u0002\u00A2\u0006\u0004\bM\u0010GJ\u001F\u0010P\u001A\u00020\u00072\u0006\u0010N\u001A\u00020\u00162\u0006\u0010O\u001A\u00020BH\u0002\u00A2\u0006\u0004\bP\u0010QJ\u0017\u0010R\u001A\u00020\u00072\u0006\u0010O\u001A\u00020BH\u0002\u00A2\u0006\u0004\bR\u0010SJ\u001F\u0010U\u001A\u00020\u00072\u0006\u0010 \u001A\u00020\u00162\u0006\u0010T\u001A\u00020\u0016H\u0002\u00A2\u0006\u0004\bU\u0010:J\u0011\u0010W\u001A\u0004\u0018\u00010VH\u0002\u00A2\u0006\u0004\bW\u0010XJ\'\u0010\\\u001A\u00020\u00072\u0006\u0010Y\u001A\u00020\u00162\u0006\u0010Z\u001A\u00020\u00162\u0006\u0010[\u001A\u00020\u0016H\u0002\u00A2\u0006\u0004\b\\\u0010]R\u0014\u0010_\u001A\u00020^8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010b\u001A\u00020a8\u0002@\u0002X\u0082.\u00A2\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010e\u001A\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010h\u001A\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bh\u0010iR*\u0010j\u001A\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010;j\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`=8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010m\u001A\u0004\u0018\u00010l8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bm\u0010nR\u0014\u0010p\u001A\u00020o8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bp\u0010qR\u0014\u0010s\u001A\u00020r8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bs\u0010tR\u0014\u0010v\u001A\u00020u8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\bv\u0010wR\u0014\u0010{\u001A\u00020x8VX\u0096\u0004\u00A2\u0006\u0006\u001A\u0004\by\u0010zR\u0014\u0010~\u001A\u00020g8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b|\u0010}\u00A8\u0006\u0082\u0001"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "Landroid/content/res/Configuration;", "newConfig", "Lie/H;", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "getCacheKey", "()Ljava/lang/String;", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "onResume", "onPause", "onDestroy", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "shouldShowMiniPlayer", "()Z", "initTitleBar", "Lkotlinx/coroutines/Deferred;", "Lcom/iloen/melon/net/v6x/response/MyMusicSettingInformProfileSimpleRes;", "requestProfileSettingInformAsync", "()Lkotlinx/coroutines/Deferred;", "showCleanPopUp", "title", "desc", "showInfoPopup", "(Ljava/lang/String;Ljava/lang/String;)V", "Ljava/util/ArrayList;", "Lcom/iloen/melon/net/v6x/response/ProfileBaseRes$SnsInfoBase;", "Lkotlin/collections/ArrayList;", "list", "getSnsOrderList", "(Ljava/util/ArrayList;)Ljava/util/ArrayList;", "snsType", "", "getSnsImage", "(Ljava/lang/String;)I", "snsInfo", "showSnsChannelPopup", "(Ljava/util/ArrayList;)V", "Landroid/net/Uri;", "uri", "setUserProfileImage", "(Landroid/net/Uri;)V", "deleteProfileImg", "requestDjTermSnsAgree", "infoCode", "selectPos", "requestSiteChannelUpdateRepnt", "(Ljava/lang/String;I)V", "updateToggleBtn", "(I)V", "yn", "requestOpenYn", "Lp8/f;", "getTiaraEventBuilder", "()Lp8/f;", "clickLayer1", "clickCopy", "onOff", "toggleClickLog", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "mainExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lcom/iloen/melon/custom/BorderImageView;", "ivProfileThumb", "Lcom/iloen/melon/custom/BorderImageView;", "Lcom/iloen/melon/popup/MelonTextPopup;", "infoPopup", "Lcom/iloen/melon/popup/MelonTextPopup;", "LJ8/s2;", "_binding", "LJ8/s2;", "snsToggleGroup", "Ljava/util/ArrayList;", "Lcom/iloen/melon/net/v6x/response/MyMusicSettingInformProfileSimpleRes$RESPONSE;", "profileInformRes", "Lcom/iloen/melon/net/v6x/response/MyMusicSettingInformProfileSimpleRes$RESPONSE;", "com/iloen/melon/fragments/mymusic/MemberProfileEditFragment$imageSelectorListener$1", "imageSelectorListener", "Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$imageSelectorListener$1;", "Lcom/iloen/melon/utils/image/ImageSelector;", "imageSelector", "Lcom/iloen/melon/utils/image/ImageSelector;", "com/iloen/melon/fragments/mymusic/MemberProfileEditFragment$onScrollListener$1", "onScrollListener", "Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$onScrollListener$1;", "Lme/i;", "getCoroutineContext", "()Lme/i;", "coroutineContext", "getBinding", "()LJ8/s2;", "binding", "Companion", "MemberProfileEditAdapter", "UserType", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MemberProfileEditFragment extends MetaContentBaseFragment implements CoroutineScope {
    @Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001A\u00020\bH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$Companion;", "", "<init>", "()V", "TAG", "", "TAG_PROFILE", "newInstance", "Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MemberProfileEditFragment newInstance() {
            return new MemberProfileEditFragment();
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0082\u0004\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\b+,-./012B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ-\u0010\u0011\u001A\u00020\u00102\b\u0010\u000B\u001A\u0004\u0018\u00010\n2\b\u0010\r\u001A\u0004\u0018\u00010\f2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u001F\u0010\u0015\u001A\u00020\u00022\u0006\u0010\u0013\u001A\u00020\u00022\u0006\u0010\u0014\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u001A\u001A\u00020\u00032\b\u0010\u0018\u001A\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u001A\u0010\u001BJ)\u0010\u001E\u001A\u00020\u001D2\b\u0010\u001C\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001A\u00020\u00022\u0006\u0010\u0014\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u001E\u0010\u001FR\u0014\u0010 \u001A\u00020\u00028\u0002X\u0082D¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\"\u001A\u00020\u00028\u0002X\u0082D¢\u0006\u0006\n\u0004\b\"\u0010!R\u0014\u0010#\u001A\u00020\u00028\u0002X\u0082D¢\u0006\u0006\n\u0004\b#\u0010!R\u0014\u0010$\u001A\u00020\u00028\u0002X\u0082D¢\u0006\u0006\n\u0004\b$\u0010!R\u0014\u0010%\u001A\u00020\u00028\u0002X\u0082D¢\u0006\u0006\n\u0004\b%\u0010!R\u0014\u0010&\u001A\u00020\u00028\u0002X\u0082D¢\u0006\u0006\n\u0004\b&\u0010!R\u0014\u0010\'\u001A\u00020\u00028\u0002X\u0082D¢\u0006\u0006\n\u0004\b\'\u0010!R\u0016\u0010)\u001A\u00020(8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b)\u0010*¨\u00063"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$MemberProfileEditAdapter;", "Lcom/iloen/melon/adapters/common/p;", "", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "obj", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment;Landroid/content/Context;Ljava/util/List;)V", "", "key", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "response", "", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_THUMB", "I", "VIEW_TYPE_NICKNAME_EDIT", "VIEW_TYPE_DJ_INTRODUCE", "VIEW_TYPE_SNS_CONNECT", "VIEW_TYPE_DJ_PICK", "VIEW_TYPE_PRIVATE_SETTING", "VIEW_TYPE_MESSAGE_SETTING", "Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$UserType;", "userType", "Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$UserType;", "ProfileEditBaseViewHolder", "ProfileThumbViewHolder", "NickNameEditViewHolder", "DjIntroduceViewHolder", "SnsConnectViewHolder", "DjPickViewHolder", "PrivateSettingViewHolder", "MessageSettingViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class MemberProfileEditAdapter extends p {
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003B\u000F\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u000B\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$MemberProfileEditAdapter$DjIntroduceViewHolder;", "Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$MemberProfileEditAdapter$ProfileEditBaseViewHolder;", "Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$MemberProfileEditAdapter;", "Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment;", "LJ8/q2;", "binding", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$MemberProfileEditAdapter;LJ8/q2;)V", "Lie/H;", "bindItem", "()V", "bind", "LJ8/q2;", "getBind", "()LJ8/q2;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class DjIntroduceViewHolder extends ProfileEditBaseViewHolder {
            @NotNull
            private final q2 bind;

            public DjIntroduceViewHolder(@NotNull q2 q20) {
                q.g(q20, "binding");
                MemberProfileEditAdapter.this = memberProfileEditFragment$MemberProfileEditAdapter0;
                super(q20);
                this.bind = q20;
                Context context0 = memberProfileEditFragment$MemberProfileEditAdapter0.getContext();
                CharSequence charSequence0 = context0 == null ? null : context0.getText(0x7F13103C);  // string:title_dj_introduce "DJ 소개 한마디"
                ((MelonTextView)q20.b.d).setText(charSequence0);
            }

            @Override  // com.iloen.melon.fragments.mymusic.MemberProfileEditFragment$MemberProfileEditAdapter$ProfileEditBaseViewHolder
            public void bindItem() {
                CharSequence charSequence0;
                RESPONSE myMusicSettingInformProfileSimpleRes$RESPONSE0 = MemberProfileEditFragment.this.profileInformRes;
                if(myMusicSettingInformProfileSimpleRes$RESPONSE0 != null) {
                    if(myMusicSettingInformProfileSimpleRes$RESPONSE0.djTitleToolTip == null || myMusicSettingInformProfileSimpleRes$RESPONSE0.djTitleToolTip.length() == 0) {
                        ((ImageView)this.bind.b.c).setVisibility(8);
                    }
                    else {
                        ((ImageView)this.bind.b.c).setVisibility(0);
                        String s = MemberProfileEditAdapter.this.getContext() == null ? null : "DJ 소개 한마디 정보";
                        ((ImageView)this.bind.b.c).setContentDescription(s);
                        com.iloen.melon.fragments.mymusic.q q0 = new com.iloen.melon.fragments.mymusic.q(MemberProfileEditFragment.this, MemberProfileEditAdapter.this, myMusicSettingInformProfileSimpleRes$RESPONSE0, 0);
                        ((ImageView)this.bind.b.c).setOnClickListener(q0);
                    }
                    if(myMusicSettingInformProfileSimpleRes$RESPONSE0.djTitle == null || myMusicSettingInformProfileSimpleRes$RESPONSE0.djTitle.length() == 0) {
                        MelonTextView melonTextView0 = this.bind.c;
                        Context context0 = MemberProfileEditAdapter.this.getContext();
                        if(context0 == null) {
                            charSequence0 = "";
                        }
                        else {
                            charSequence0 = context0.getText(0x7F130C94);  // string:text_dj_pick_introduce_default "DJ 컨셉을 한 줄로 표현해주세요."
                            if(charSequence0 == null) {
                                charSequence0 = "";
                            }
                        }
                        melonTextView0.setText(charSequence0);
                        int v1 = ColorUtils.getColor(MemberProfileEditAdapter.this.getContext(), 0x7F060159);  // color:gray400s_support_high_contrast
                        this.bind.c.setTextColor(v1);
                    }
                    else {
                        this.bind.c.setText(myMusicSettingInformProfileSimpleRes$RESPONSE0.djTitle);
                        int v = ColorUtils.getColor(MemberProfileEditAdapter.this.getContext(), 0x7F06016D);  // color:gray900s
                        this.bind.c.setTextColor(v);
                    }
                    r r0 = new r(MemberProfileEditFragment.this, MemberProfileEditAdapter.this, 0);
                    this.bind.c.setOnClickListener(r0);
                }
            }

            private static final void bindItem$lambda$0(MemberProfileEditFragment memberProfileEditFragment0, MemberProfileEditAdapter memberProfileEditFragment$MemberProfileEditAdapter0, RESPONSE myMusicSettingInformProfileSimpleRes$RESPONSE0, View view0) {
                Context context0 = memberProfileEditFragment$MemberProfileEditAdapter0.getContext();
                CharSequence charSequence0 = context0 == null ? null : context0.getText(0x7F13103C);  // string:title_dj_introduce "DJ 소개 한마디"
                String s = myMusicSettingInformProfileSimpleRes$RESPONSE0.djTitleToolTip;
                q.f(s, "djTitleToolTip");
                memberProfileEditFragment0.showInfoPopup(String.valueOf(charSequence0), s);
            }

            private static final void bindItem$lambda$2(MemberProfileEditFragment memberProfileEditFragment0, MemberProfileEditAdapter memberProfileEditFragment$MemberProfileEditAdapter0, View view0) {
                String s1;
                RESPONSE myMusicSettingInformProfileSimpleRes$RESPONSE0 = memberProfileEditFragment0.profileInformRes;
                if(myMusicSettingInformProfileSimpleRes$RESPONSE0 != null && myMusicSettingInformProfileSimpleRes$RESPONSE0.isBlackList) {
                    memberProfileEditFragment0.showCleanPopUp();
                    return;
                }
                RESPONSE myMusicSettingInformProfileSimpleRes$RESPONSE1 = memberProfileEditFragment0.profileInformRes;
                String s = "";
                if(myMusicSettingInformProfileSimpleRes$RESPONSE1 == null) {
                    s1 = "";
                }
                else {
                    s1 = myMusicSettingInformProfileSimpleRes$RESPONSE1.djTitle;
                    if(s1 == null) {
                        s1 = "";
                    }
                }
                String s2 = "페이지이동";
                Navigator.open(ProfileEditFragment.newInstance(2, s1));
                TimeExpiredCache.getInstance().removeLike(MelonContentUris.Z0.toString());
                f f0 = memberProfileEditFragment0.getTiaraEventBuilder();
                if(f0 != null) {
                    if(memberProfileEditFragment$MemberProfileEditAdapter0.getContext() == null) {
                        s2 = "";
                    }
                    f0.a = s2;
                    if(memberProfileEditFragment$MemberProfileEditAdapter0.getContext() != null) {
                        s = "소개편집";
                    }
                    f0.y = s;
                    f0.a().track();
                }
            }

            @NotNull
            public final q2 getBind() {
                return this.bind;
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003B\u000F\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u000B\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$MemberProfileEditAdapter$DjPickViewHolder;", "Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$MemberProfileEditAdapter$ProfileEditBaseViewHolder;", "Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$MemberProfileEditAdapter;", "Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment;", "LJ8/r2;", "binding", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$MemberProfileEditAdapter;LJ8/r2;)V", "Lie/H;", "bindItem", "()V", "bind", "LJ8/r2;", "getBind", "()LJ8/r2;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class DjPickViewHolder extends ProfileEditBaseViewHolder {
            @NotNull
            private final r2 bind;

            public DjPickViewHolder(@NotNull r2 r20) {
                q.g(r20, "binding");
                MemberProfileEditAdapter.this = memberProfileEditFragment$MemberProfileEditAdapter0;
                super(r20);
                this.bind = r20;
                Context context0 = memberProfileEditFragment$MemberProfileEditAdapter0.getContext();
                CharSequence charSequence0 = context0 == null ? null : context0.getText(0x7F13103D);  // string:title_dj_pick "DJ PICK"
                ((MelonTextView)r20.i.d).setText(charSequence0);
            }

            @Override  // com.iloen.melon.fragments.mymusic.MemberProfileEditFragment$MemberProfileEditAdapter$ProfileEditBaseViewHolder
            public void bindItem() {
                RESPONSE myMusicSettingInformProfileSimpleRes$RESPONSE0 = MemberProfileEditFragment.this.profileInformRes;
                DJPICKPLAYLIST myMusicSettingInformProfileSimpleRes$RESPONSE$DJPICKPLAYLIST0 = null;
                String s = myMusicSettingInformProfileSimpleRes$RESPONSE0 == null ? null : myMusicSettingInformProfileSimpleRes$RESPONSE0.djPickToolTip;
                if(s == null || s.length() == 0) {
                    ((ImageView)this.bind.i.c).setVisibility(8);
                }
                else {
                    String s1 = MemberProfileEditAdapter.this.getContext() == null ? null : "디제이 픽 정보";
                    ((ImageView)this.bind.i.c).setContentDescription(s1);
                    ((ImageView)this.bind.i.c).setVisibility(0);
                    com.iloen.melon.fragments.mymusic.q q0 = new com.iloen.melon.fragments.mymusic.q(MemberProfileEditFragment.this, MemberProfileEditAdapter.this, myMusicSettingInformProfileSimpleRes$RESPONSE0, 1);
                    ((ImageView)this.bind.i.c).setOnClickListener(q0);
                }
                if(myMusicSettingInformProfileSimpleRes$RESPONSE0 != null) {
                    myMusicSettingInformProfileSimpleRes$RESPONSE$DJPICKPLAYLIST0 = myMusicSettingInformProfileSimpleRes$RESPONSE0.djPickPlaylist;
                }
                if(myMusicSettingInformProfileSimpleRes$RESPONSE$DJPICKPLAYLIST0 == null) {
                    int v1 = ColorUtils.getColor(MemberProfileEditAdapter.this.getContext(), 0x7F0604AA);  // color:white000s_support_high_contrast
                    this.bind.e.setCardBackgroundColor(v1);
                    int v2 = ColorUtils.getColor(MemberProfileEditAdapter.this.getContext(), 0x7F060141);  // color:gray001s
                    this.bind.f.setBackgroundColor(v2);
                    this.bind.c.setVisibility(8);
                    ((RelativeLayout)this.bind.h.b).setVisibility(8);
                    this.bind.d.setVisibility(0);
                    this.bind.g.setVisibility(0);
                }
                else {
                    this.bind.c.setVisibility(0);
                    ((RelativeLayout)this.bind.h.b).setVisibility(0);
                    this.bind.d.setVisibility(8);
                    this.bind.g.setVisibility(8);
                    int v = ColorUtils.getColor(MemberProfileEditAdapter.this.getContext(), 0x7F060155);  // color:gray300a
                    this.bind.f.setBackgroundColor(v);
                    Glide.with(MemberProfileEditAdapter.this.getContext()).asBitmap().load(myMusicSettingInformProfileSimpleRes$RESPONSE0.djPickPlaylist.thumbimg).into(new CustomTarget() {
                        @Override  // com.bumptech.glide.request.target.Target
                        public void onLoadCleared(Drawable drawable0) {
                        }

                        public void onResourceReady(Bitmap bitmap0, Transition transition0) {
                            q.g(bitmap0, "resource");
                            e e0 = new e(bitmap0);
                            e0.a = 24;
                            g g0 = e0.a().a(i.h);
                            if(g0 != null) {
                                ColorStateList colorStateList0 = new ColorStateList(new int[][]{new int[0]}, new int[]{g0.d});
                                DjPickViewHolder.this.getBind().e.setCardBackgroundColor(colorStateList0);
                            }
                            ((MelonImageView)DjPickViewHolder.this.getBind().h.c).setImageBitmap(bitmap0);
                        }

                        @Override  // com.bumptech.glide.request.target.Target
                        public void onResourceReady(Object object0, Transition transition0) {
                            this.onResourceReady(((Bitmap)object0), transition0);
                        }
                    });
                    this.bind.j.setText(myMusicSettingInformProfileSimpleRes$RESPONSE0.djPickPlaylist.plylsttitle);
                }
                r r0 = new r(MemberProfileEditFragment.this, MemberProfileEditAdapter.this, 1);
                this.bind.b.setOnClickListener(r0);
            }

            private static final void bindItem$lambda$0(MemberProfileEditFragment memberProfileEditFragment0, MemberProfileEditAdapter memberProfileEditFragment$MemberProfileEditAdapter0, RESPONSE myMusicSettingInformProfileSimpleRes$RESPONSE0, View view0) {
                String s1;
                Context context0 = memberProfileEditFragment$MemberProfileEditAdapter0.getContext();
                String s = String.valueOf((context0 == null ? null : context0.getText(0x7F13103D)));  // string:title_dj_pick "DJ PICK"
                if(myMusicSettingInformProfileSimpleRes$RESPONSE0 == null) {
                    s1 = "";
                }
                else {
                    s1 = myMusicSettingInformProfileSimpleRes$RESPONSE0.djPickToolTip;
                    if(s1 == null) {
                        s1 = "";
                    }
                }
                memberProfileEditFragment0.showInfoPopup(s, s1);
            }

            private static final void bindItem$lambda$2(MemberProfileEditFragment memberProfileEditFragment0, MemberProfileEditAdapter memberProfileEditFragment$MemberProfileEditAdapter0, View view0) {
                Navigator.open(com.iloen.melon.fragments.mymusic.ProfileDjPickListFragment.Companion.newInstance$default(ProfileDjPickListFragment.Companion, 0, 1, null));
                f f0 = memberProfileEditFragment0.getTiaraEventBuilder();
                if(f0 != null) {
                    String s = "페이지이동";
                    String s1 = "";
                    if(memberProfileEditFragment$MemberProfileEditAdapter0.getContext() == null) {
                        s = "";
                    }
                    f0.a = s;
                    if(memberProfileEditFragment$MemberProfileEditAdapter0.getContext() != null) {
                        s1 = "DJPICK";
                    }
                    f0.y = s1;
                    f0.a().track();
                }
            }

            @NotNull
            public final r2 getBind() {
                return this.bind;
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003B\u000F\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u000B\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$MemberProfileEditAdapter$MessageSettingViewHolder;", "Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$MemberProfileEditAdapter$ProfileEditBaseViewHolder;", "Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$MemberProfileEditAdapter;", "Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment;", "LJ8/t2;", "binding", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$MemberProfileEditAdapter;LJ8/t2;)V", "Lie/H;", "bindItem", "()V", "bind", "LJ8/t2;", "getBind", "()LJ8/t2;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class MessageSettingViewHolder extends ProfileEditBaseViewHolder {
            @NotNull
            private final t2 bind;

            public MessageSettingViewHolder(@NotNull t2 t20) {
                q.g(t20, "binding");
                MemberProfileEditAdapter.this = memberProfileEditFragment$MemberProfileEditAdapter0;
                super(t20);
                this.bind = t20;
                Context context0 = memberProfileEditFragment$MemberProfileEditAdapter0.getContext();
                CharSequence charSequence0 = context0 == null ? null : context0.getText(0x7F131047);  // string:title_msg_setting "메시지 설정"
                ((MelonTextView)t20.d.d).setText(charSequence0);
            }

            public static void b(boolean z, MemberProfileEditFragment memberProfileEditFragment0, String s, String s1, H h0, MemberProfileEditAdapter memberProfileEditFragment$MemberProfileEditAdapter0, String s2, View view0) {
                MessageSettingViewHolder.bindItem$lambda$0(z, h0, memberProfileEditFragment$MemberProfileEditAdapter0, memberProfileEditFragment0, s, s1, s2, view0);
            }

            @Override  // com.iloen.melon.fragments.mymusic.MemberProfileEditFragment$MemberProfileEditAdapter$ProfileEditBaseViewHolder
            public void bindItem() {
                String s = "메시지설정";
                RESPONSE myMusicSettingInformProfileSimpleRes$RESPONSE0 = MemberProfileEditFragment.this.profileInformRes;
                if(myMusicSettingInformProfileSimpleRes$RESPONSE0 != null) {
                    if(MemberProfileEditAdapter.this.getContext() == null) {
                        s = "";
                    }
                    H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
                    Context context0 = MemberProfileEditAdapter.this.getContext();
                    String s1 = null;
                    String s2 = context0 == null || context0.getResources() == null ? null : "메세지 설정 온";
                    Context context1 = MemberProfileEditAdapter.this.getContext();
                    if(context1 != null && context1.getResources() != null) {
                        s1 = "메세지 설정 오프";
                    }
                    boolean z = ProtocolUtils.parseBoolean(myMusicSettingInformProfileSimpleRes$RESPONSE0.msgRecvFlag);
                    this.bind.b.setChecked(z);
                    this.bind.b.setContentDescription((z ? s2 : s1));
                    s s3 = new s(z, h0, MemberProfileEditAdapter.this, MemberProfileEditFragment.this, s1, s2, s);
                    this.bind.b.setOnClickListener(s3);
                    r r0 = new r(MemberProfileEditFragment.this, MemberProfileEditAdapter.this, 2);
                    this.bind.c.setOnClickListener(r0);
                }
            }

            private static final void bindItem$lambda$0(boolean z, H h0, MemberProfileEditAdapter memberProfileEditFragment$MemberProfileEditAdapter0, MemberProfileEditFragment memberProfileEditFragment0, String s, String s1, String s2, View view0) {
                h0.a = memberProfileEditFragment$MemberProfileEditAdapter0.getContext() == null ? "" : "메시지받기";
                memberProfileEditFragment0.requestOpenYn("MSGRECV", (z ? "N" : "Y"));
                if(!z) {
                    s = s1;
                }
                view0.setContentDescription(s);
                memberProfileEditFragment0.toggleClickLog(s2, ((String)h0.a), (z ? "N" : "Y"));
            }

            private static final void bindItem$lambda$2(MemberProfileEditFragment memberProfileEditFragment0, MemberProfileEditAdapter memberProfileEditFragment$MemberProfileEditAdapter0, View view0) {
                Navigator.open(MusicMessageBlockListFragment.Companion.newInstance());
                f f0 = memberProfileEditFragment0.getTiaraEventBuilder();
                if(f0 != null) {
                    String s = "페이지이동";
                    String s1 = "";
                    if(memberProfileEditFragment$MemberProfileEditAdapter0.getContext() == null) {
                        s = "";
                    }
                    String s2 = "메시지설정";
                    f0.a = s;
                    if(memberProfileEditFragment$MemberProfileEditAdapter0.getContext() == null) {
                        s2 = "";
                    }
                    f0.y = s2;
                    if(memberProfileEditFragment$MemberProfileEditAdapter0.getContext() != null) {
                        s1 = "차단목록";
                    }
                    f0.F = s1;
                    f0.a().track();
                }
            }

            @NotNull
            public final t2 getBind() {
                return this.bind;
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003B\u000F\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u000B\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$MemberProfileEditAdapter$NickNameEditViewHolder;", "Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$MemberProfileEditAdapter$ProfileEditBaseViewHolder;", "Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$MemberProfileEditAdapter;", "Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment;", "LJ8/u2;", "binding", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$MemberProfileEditAdapter;LJ8/u2;)V", "Lie/H;", "bindItem", "()V", "bind", "LJ8/u2;", "getBind", "()LJ8/u2;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class NickNameEditViewHolder extends ProfileEditBaseViewHolder {
            @NotNull
            private final u2 bind;

            public NickNameEditViewHolder(@NotNull u2 u20) {
                q.g(u20, "binding");
                MemberProfileEditAdapter.this = memberProfileEditFragment$MemberProfileEditAdapter0;
                super(u20);
                this.bind = u20;
            }

            @Override  // com.iloen.melon.fragments.mymusic.MemberProfileEditFragment$MemberProfileEditAdapter$ProfileEditBaseViewHolder
            public void bindItem() {
                CharSequence charSequence0 = null;
                RESPONSE myMusicSettingInformProfileSimpleRes$RESPONSE0 = MemberProfileEditFragment.this.profileInformRes;
                if(myMusicSettingInformProfileSimpleRes$RESPONSE0 != null) {
                    if(myMusicSettingInformProfileSimpleRes$RESPONSE0.memberNickName == null || myMusicSettingInformProfileSimpleRes$RESPONSE0.memberNickName.length() == 0) {
                        Context context0 = MemberProfileEditAdapter.this.getContext();
                        CharSequence charSequence1 = context0 == null ? null : context0.getText(0x7F130CA6);  // string:text_nickname "닉네임"
                        this.bind.c.setText(charSequence1);
                        int v1 = ColorUtils.getColor(MemberProfileEditAdapter.this.getContext(), 0x7F060159);  // color:gray400s_support_high_contrast
                        this.bind.c.setTextColor(v1);
                    }
                    else {
                        this.bind.c.setText(myMusicSettingInformProfileSimpleRes$RESPONSE0.memberNickName);
                        int v = ColorUtils.getColor(MemberProfileEditAdapter.this.getContext(), 0x7F06016D);  // color:gray900s
                        this.bind.c.setTextColor(v);
                    }
                    if(myMusicSettingInformProfileSimpleRes$RESPONSE0.myPageDesc == null || myMusicSettingInformProfileSimpleRes$RESPONSE0.myPageDesc.length() == 0) {
                        MelonTextView melonTextView0 = this.bind.b;
                        Context context1 = MemberProfileEditAdapter.this.getContext();
                        if(context1 != null) {
                            charSequence0 = context1.getText(0x7F1308A6);  // string:profile_setting_introduction_message "소개글을 입력해주세요."
                        }
                        melonTextView0.setText(charSequence0);
                        int v3 = ColorUtils.getColor(MemberProfileEditAdapter.this.getContext(), 0x7F060159);  // color:gray400s_support_high_contrast
                        this.bind.b.setTextColor(v3);
                    }
                    else {
                        this.bind.b.setText(myMusicSettingInformProfileSimpleRes$RESPONSE0.myPageDesc);
                        int v2 = ColorUtils.getColor(MemberProfileEditAdapter.this.getContext(), 0x7F06016D);  // color:gray900s
                        this.bind.b.setTextColor(v2);
                    }
                    r r0 = new r(MemberProfileEditFragment.this, MemberProfileEditAdapter.this, 3);
                    this.bind.c.setOnClickListener(r0);
                    r r1 = new r(MemberProfileEditFragment.this, MemberProfileEditAdapter.this, 4);
                    this.bind.b.setOnClickListener(r1);
                }
            }

            private static final void bindItem$lambda$1(MemberProfileEditFragment memberProfileEditFragment0, MemberProfileEditAdapter memberProfileEditFragment$MemberProfileEditAdapter0, View view0) {
                String s1;
                RESPONSE myMusicSettingInformProfileSimpleRes$RESPONSE0 = memberProfileEditFragment0.profileInformRes;
                if(myMusicSettingInformProfileSimpleRes$RESPONSE0 != null && myMusicSettingInformProfileSimpleRes$RESPONSE0.isBlackList) {
                    memberProfileEditFragment0.showCleanPopUp();
                    return;
                }
                RESPONSE myMusicSettingInformProfileSimpleRes$RESPONSE1 = memberProfileEditFragment0.profileInformRes;
                String s = "";
                if(myMusicSettingInformProfileSimpleRes$RESPONSE1 == null) {
                    s1 = "";
                }
                else {
                    s1 = myMusicSettingInformProfileSimpleRes$RESPONSE1.realNickName;
                    if(s1 == null) {
                        s1 = "";
                    }
                }
                String s2 = "페이지이동";
                Navigator.open(ProfileEditFragment.newInstance(0, s1));
                TimeExpiredCache.getInstance().removeLike(MelonContentUris.Z0.toString());
                f f0 = memberProfileEditFragment0.getTiaraEventBuilder();
                if(f0 != null) {
                    if(memberProfileEditFragment$MemberProfileEditAdapter0.getContext() == null) {
                        s2 = "";
                    }
                    String s3 = "프로필편집";
                    f0.a = s2;
                    if(memberProfileEditFragment$MemberProfileEditAdapter0.getContext() == null) {
                        s3 = "";
                    }
                    f0.y = s3;
                    if(memberProfileEditFragment$MemberProfileEditAdapter0.getContext() != null) {
                        s = "닉네임";
                    }
                    f0.F = s;
                    f0.a().track();
                }
            }

            private static final void bindItem$lambda$3(MemberProfileEditFragment memberProfileEditFragment0, MemberProfileEditAdapter memberProfileEditFragment$MemberProfileEditAdapter0, View view0) {
                String s1;
                RESPONSE myMusicSettingInformProfileSimpleRes$RESPONSE0 = memberProfileEditFragment0.profileInformRes;
                if(myMusicSettingInformProfileSimpleRes$RESPONSE0 != null && myMusicSettingInformProfileSimpleRes$RESPONSE0.isBlackList) {
                    memberProfileEditFragment0.showCleanPopUp();
                    return;
                }
                RESPONSE myMusicSettingInformProfileSimpleRes$RESPONSE1 = memberProfileEditFragment0.profileInformRes;
                String s = "";
                if(myMusicSettingInformProfileSimpleRes$RESPONSE1 == null) {
                    s1 = "";
                }
                else {
                    s1 = myMusicSettingInformProfileSimpleRes$RESPONSE1.myPageDesc;
                    if(s1 == null) {
                        s1 = "";
                    }
                }
                String s2 = "페이지이동";
                Navigator.open(ProfileEditFragment.newInstance(1, s1));
                TimeExpiredCache.getInstance().removeLike(MelonContentUris.Z0.toString());
                f f0 = memberProfileEditFragment0.getTiaraEventBuilder();
                if(f0 != null) {
                    if(memberProfileEditFragment$MemberProfileEditAdapter0.getContext() == null) {
                        s2 = "";
                    }
                    String s3 = "프로필편집";
                    f0.a = s2;
                    if(memberProfileEditFragment$MemberProfileEditAdapter0.getContext() == null) {
                        s3 = "";
                    }
                    f0.y = s3;
                    if(memberProfileEditFragment$MemberProfileEditAdapter0.getContext() != null) {
                        s = "소개글";
                    }
                    f0.F = s;
                    f0.a().track();
                }
            }

            @NotNull
            public final u2 getBind() {
                return this.bind;
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003B\u000F\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u000B\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$MemberProfileEditAdapter$PrivateSettingViewHolder;", "Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$MemberProfileEditAdapter$ProfileEditBaseViewHolder;", "Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$MemberProfileEditAdapter;", "Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment;", "LJ8/v2;", "binding", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$MemberProfileEditAdapter;LJ8/v2;)V", "Lie/H;", "bindItem", "()V", "bind", "LJ8/v2;", "getBind", "()LJ8/v2;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class PrivateSettingViewHolder extends ProfileEditBaseViewHolder {
            @NotNull
            private final v2 bind;

            public PrivateSettingViewHolder(@NotNull v2 v20) {
                q.g(v20, "binding");
                MemberProfileEditAdapter.this = memberProfileEditFragment$MemberProfileEditAdapter0;
                super(v20);
                this.bind = v20;
                Context context0 = memberProfileEditFragment$MemberProfileEditAdapter0.getContext();
                CharSequence charSequence0 = context0 == null ? null : context0.getText(0x7F13104B);  // string:title_private_setting "공개 설정"
                ((MelonTextView)v20.l.d).setText(charSequence0);
            }

            @Override  // com.iloen.melon.fragments.mymusic.MemberProfileEditFragment$MemberProfileEditAdapter$ProfileEditBaseViewHolder
            public void bindItem() {
                String s = "공개설정";
                RESPONSE myMusicSettingInformProfileSimpleRes$RESPONSE0 = MemberProfileEditFragment.this.profileInformRes;
                if(myMusicSettingInformProfileSimpleRes$RESPONSE0 != null) {
                    if(MemberProfileEditAdapter.this.getContext() == null) {
                        s = "";
                    }
                    H h0 = new H();  // 初始化器: Ljava/lang/Object;-><init>()V
                    if(MemberProfileEditAdapter.this.userType.isArtist()) {
                        this.bind.b.setVisibility(0);
                        this.bind.c.setChecked(ProtocolUtils.parseBoolean(myMusicSettingInformProfileSimpleRes$RESPONSE0.artistChnFlag));
                        t t0 = new t(MemberProfileEditFragment.this, h0, MemberProfileEditAdapter.this, s, 0);
                        this.bind.c.setOnClickListener(t0);
                    }
                    else {
                        this.bind.b.setVisibility(8);
                    }
                    Context context0 = MemberProfileEditAdapter.this.getContext();
                    String s1 = null;
                    String s2 = context0 == null || context0.getResources() == null ? null : "공개 설정 온";
                    Context context1 = MemberProfileEditAdapter.this.getContext();
                    if(context1 != null && context1.getResources() != null) {
                        s1 = "공개 설정 오프";
                    }
                    if(MemberProfileEditAdapter.this.userType.isDj()) {
                        this.bind.i.setVisibility(0);
                        this.bind.j.setVisibility(0);
                        boolean z = ProtocolUtils.parseBoolean(myMusicSettingInformProfileSimpleRes$RESPONSE0.djPickFlag);
                        boolean z1 = ProtocolUtils.parseBoolean(myMusicSettingInformProfileSimpleRes$RESPONSE0.djCmtOpenFlag);
                        this.bind.d.setChecked(z);
                        this.bind.d.setContentDescription((z ? s2 : s1));
                        this.bind.e.setChecked(z1);
                        this.bind.e.setContentDescription((z1 ? s2 : s1));
                        s s3 = new s(z, MemberProfileEditFragment.this, s1, s2, h0, MemberProfileEditAdapter.this, s, 1);
                        this.bind.d.setOnClickListener(s3);
                        s s4 = new s(z1, MemberProfileEditFragment.this, s1, s2, h0, MemberProfileEditAdapter.this, s, 2);
                        this.bind.e.setOnClickListener(s4);
                    }
                    else {
                        this.bind.i.setVisibility(8);
                        this.bind.j.setVisibility(8);
                    }
                    boolean z2 = ProtocolUtils.parseBoolean(myMusicSettingInformProfileSimpleRes$RESPONSE0.likeOpenFlag);
                    this.bind.h.setChecked(z2);
                    this.bind.h.setContentDescription((z2 ? s2 : s1));
                    s s5 = new s(z2, MemberProfileEditFragment.this, s1, s2, h0, MemberProfileEditAdapter.this, s, 3);
                    this.bind.h.setOnClickListener(s5);
                    boolean z3 = ProtocolUtils.parseBoolean(myMusicSettingInformProfileSimpleRes$RESPONSE0.friendOpenFlag);
                    this.bind.g.setChecked(z3);
                    this.bind.g.setContentDescription((z3 ? s2 : s1));
                    s s6 = new s(z3, MemberProfileEditFragment.this, s1, s2, h0, MemberProfileEditAdapter.this, s, 4);
                    this.bind.g.setOnClickListener(s6);
                    String s7 = myMusicSettingInformProfileSimpleRes$RESPONSE0.fanLoungeOpenFlag;
                    if(s7 != null) {
                        this.bind.k.setVisibility(0);
                        boolean z4 = ProtocolUtils.parseBoolean(s7);
                        this.bind.f.setChecked(z4);
                        this.bind.f.setContentDescription((z4 ? s2 : s1));
                        s s8 = new s(z4, MemberProfileEditFragment.this, s1, s2, h0, MemberProfileEditAdapter.this, s, 5);
                        this.bind.f.setOnClickListener(s8);
                        return;
                    }
                    this.bind.k.setVisibility(8);
                }
            }

            private static final void bindItem$lambda$0(MemberProfileEditFragment memberProfileEditFragment0, H h0, MemberProfileEditAdapter memberProfileEditFragment$MemberProfileEditAdapter0, String s, View view0) {
                RESPONSE myMusicSettingInformProfileSimpleRes$RESPONSE0 = memberProfileEditFragment0.profileInformRes;
                String s1 = "Y".equals((myMusicSettingInformProfileSimpleRes$RESPONSE0 == null ? null : myMusicSettingInformProfileSimpleRes$RESPONSE0.artistChnFlag)) ? "N" : "Y";
                String s2 = "아티스트채널";
                memberProfileEditFragment0.requestOpenYn("ARTISTCHN", s1);
                if(memberProfileEditFragment$MemberProfileEditAdapter0.getContext() == null) {
                    s2 = "";
                }
                h0.a = s2;
                memberProfileEditFragment0.toggleClickLog(s, s2, s1);
            }

            private static final void bindItem$lambda$1(boolean z, MemberProfileEditFragment memberProfileEditFragment0, String s, String s1, H h0, MemberProfileEditAdapter memberProfileEditFragment$MemberProfileEditAdapter0, String s2, View view0) {
                memberProfileEditFragment0.requestOpenYn("DJPICK", (z ? "N" : "Y"));
                if(!z) {
                    s = s1;
                }
                String s3 = "DJPICK";
                view0.setContentDescription(s);
                if(memberProfileEditFragment$MemberProfileEditAdapter0.getContext() == null) {
                    s3 = "";
                }
                h0.a = s3;
                memberProfileEditFragment0.toggleClickLog(s2, s3, (z ? "N" : "Y"));
            }

            private static final void bindItem$lambda$2(boolean z, MemberProfileEditFragment memberProfileEditFragment0, String s, String s1, H h0, MemberProfileEditAdapter memberProfileEditFragment$MemberProfileEditAdapter0, String s2, View view0) {
                memberProfileEditFragment0.requestOpenYn("DJCMT", (z ? "N" : "Y"));
                if(!z) {
                    s = s1;
                }
                String s3 = "DJ에게한마디";
                view0.setContentDescription(s);
                if(memberProfileEditFragment$MemberProfileEditAdapter0.getContext() == null) {
                    s3 = "";
                }
                h0.a = s3;
                memberProfileEditFragment0.toggleClickLog(s2, s3, (z ? "N" : "Y"));
            }

            private static final void bindItem$lambda$3(boolean z, MemberProfileEditFragment memberProfileEditFragment0, String s, String s1, H h0, MemberProfileEditAdapter memberProfileEditFragment$MemberProfileEditAdapter0, String s2, View view0) {
                memberProfileEditFragment0.requestOpenYn("LIKE", (z ? "N" : "Y"));
                if(!z) {
                    s = s1;
                }
                String s3 = "좋아요";
                view0.setContentDescription(s);
                if(memberProfileEditFragment$MemberProfileEditAdapter0.getContext() == null) {
                    s3 = "";
                }
                h0.a = s3;
                memberProfileEditFragment0.toggleClickLog(s2, s3, (z ? "N" : "Y"));
            }

            private static final void bindItem$lambda$4(boolean z, MemberProfileEditFragment memberProfileEditFragment0, String s, String s1, H h0, MemberProfileEditAdapter memberProfileEditFragment$MemberProfileEditAdapter0, String s2, View view0) {
                memberProfileEditFragment0.requestOpenYn("FRIEND", (z ? "N" : "Y"));
                if(!z) {
                    s = s1;
                }
                String s3 = "팔로우";
                view0.setContentDescription(s);
                if(memberProfileEditFragment$MemberProfileEditAdapter0.getContext() == null) {
                    s3 = "";
                }
                h0.a = s3;
                memberProfileEditFragment0.toggleClickLog(s2, s3, (z ? "N" : "Y"));
            }

            private static final void bindItem$lambda$5(boolean z, MemberProfileEditFragment memberProfileEditFragment0, String s, String s1, H h0, MemberProfileEditAdapter memberProfileEditFragment$MemberProfileEditAdapter0, String s2, View view0) {
                memberProfileEditFragment0.requestOpenYn("FANLOUNGE", (z ? "N" : "Y"));
                if(!z) {
                    s = s1;
                }
                String s3 = "팬라운지";
                view0.setContentDescription(s);
                if(memberProfileEditFragment$MemberProfileEditAdapter0.getContext() == null) {
                    s3 = "";
                }
                h0.a = s3;
                memberProfileEditFragment0.toggleClickLog(s2, s3, (z ? "N" : "Y"));
            }

            @NotNull
            public final v2 getBind() {
                return this.bind;
            }
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b¢\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000F\u0010\u0007\u001A\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$MemberProfileEditAdapter$ProfileEditBaseViewHolder;", "Landroidx/recyclerview/widget/O0;", "LQ4/a;", "binding", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$MemberProfileEditAdapter;LQ4/a;)V", "Lie/H;", "bindItem", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        abstract class ProfileEditBaseViewHolder extends O0 {
            public ProfileEditBaseViewHolder(@NotNull a a0) {
                q.g(a0, "binding");
                MemberProfileEditAdapter.this = memberProfileEditFragment$MemberProfileEditAdapter0;
                super(a0.getRoot());
            }

            public abstract void bindItem();
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003B\u000F\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u000B\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$MemberProfileEditAdapter$ProfileThumbViewHolder;", "Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$MemberProfileEditAdapter$ProfileEditBaseViewHolder;", "Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$MemberProfileEditAdapter;", "Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment;", "LJ8/y2;", "binding", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$MemberProfileEditAdapter;LJ8/y2;)V", "Lie/H;", "bindItem", "()V", "bind", "LJ8/y2;", "getBind", "()LJ8/y2;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class ProfileThumbViewHolder extends ProfileEditBaseViewHolder {
            @NotNull
            private final y2 bind;

            public ProfileThumbViewHolder(@NotNull y2 y20) {
                q.g(y20, "binding");
                MemberProfileEditAdapter.this = memberProfileEditFragment$MemberProfileEditAdapter0;
                super(y20);
                this.bind = y20;
                q.f(y20.c.b, "ivThumbCircle");
                MemberProfileEditFragment.this.ivProfileThumb = y20.c.b;
                int v = ScreenUtils.dipToPixel(memberProfileEditFragment$MemberProfileEditAdapter0.getContext(), 96.0f);
                ViewUtils.setDefaultImage(y20.c.c, v, true);
                BorderImageView borderImageView0 = MemberProfileEditFragment.this.ivProfileThumb;
                if(borderImageView0 != null) {
                    borderImageView0.setBorderWidth(ScreenUtils.dipToPixel(memberProfileEditFragment$MemberProfileEditAdapter0.getContext(), 0.5f));
                    BorderImageView borderImageView1 = MemberProfileEditFragment.this.ivProfileThumb;
                    if(borderImageView1 != null) {
                        borderImageView1.setBorderColor(ColorUtils.getColor(memberProfileEditFragment$MemberProfileEditAdapter0.getContext(), 0x7F06014A));  // color:gray100a
                        return;
                    }
                    q.m("ivProfileThumb");
                    throw null;
                }
                q.m("ivProfileThumb");
                throw null;
            }

            @Override  // com.iloen.melon.fragments.mymusic.MemberProfileEditFragment$MemberProfileEditAdapter$ProfileEditBaseViewHolder
            public void bindItem() {
                RESPONSE myMusicSettingInformProfileSimpleRes$RESPONSE0 = MemberProfileEditFragment.this.profileInformRes;
                if(myMusicSettingInformProfileSimpleRes$RESPONSE0 != null) {
                    BorderImageView borderImageView0 = MemberProfileEditFragment.this.ivProfileThumb;
                    if(borderImageView0 != null) {
                        RequestBuilder requestBuilder0 = Glide.with(borderImageView0.getContext()).load(myMusicSettingInformProfileSimpleRes$RESPONSE0.myPageImg).apply(RequestOptions.circleCropTransform());
                        BorderImageView borderImageView1 = MemberProfileEditFragment.this.ivProfileThumb;
                        if(borderImageView1 != null) {
                            requestBuilder0.into(borderImageView1);
                            r r0 = new r(MemberProfileEditFragment.this, MemberProfileEditAdapter.this, 5);
                            this.bind.b.setOnClickListener(r0);
                            return;
                        }
                        q.m("ivProfileThumb");
                        throw null;
                    }
                    q.m("ivProfileThumb");
                    throw null;
                }
            }

            private static final void bindItem$lambda$2(MemberProfileEditFragment memberProfileEditFragment0, MemberProfileEditAdapter memberProfileEditFragment$MemberProfileEditAdapter0, View view0) {
                RESPONSE myMusicSettingInformProfileSimpleRes$RESPONSE0 = memberProfileEditFragment0.profileInformRes;
                if(myMusicSettingInformProfileSimpleRes$RESPONSE0 != null && myMusicSettingInformProfileSimpleRes$RESPONSE0.isBlackList) {
                    memberProfileEditFragment0.showCleanPopUp();
                    return;
                }
                memberProfileEditFragment0.imageSelector.startSelector(Request.newNormalImage("tag_profile"), null, true, new u(memberProfileEditFragment0, 0));
                f f0 = memberProfileEditFragment0.getTiaraEventBuilder();
                if(f0 != null) {
                    String s = "페이지이동";
                    String s1 = "";
                    if(memberProfileEditFragment$MemberProfileEditAdapter0.getContext() == null) {
                        s = "";
                    }
                    String s2 = "프로필편집";
                    f0.a = s;
                    if(memberProfileEditFragment$MemberProfileEditAdapter0.getContext() == null) {
                        s2 = "";
                    }
                    f0.y = s2;
                    if(memberProfileEditFragment$MemberProfileEditAdapter0.getContext() != null) {
                        s1 = "카메라";
                    }
                    f0.F = s1;
                    f0.a().track();
                }
            }

            private static final void bindItem$lambda$2$lambda$0(MemberProfileEditFragment memberProfileEditFragment0) {
                memberProfileEditFragment0.deleteProfileImg();
            }

            @NotNull
            public final y2 getBind() {
                return this.bind;
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\n0\u0001R\u00060\u0002R\u00020\u0003B\u000F\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u000B\u001A\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000B\u0010\f\u001A\u0004\b\r\u0010\u000E¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$MemberProfileEditAdapter$SnsConnectViewHolder;", "Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$MemberProfileEditAdapter$ProfileEditBaseViewHolder;", "Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$MemberProfileEditAdapter;", "Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment;", "LJ8/w2;", "binding", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$MemberProfileEditAdapter;LJ8/w2;)V", "Lie/H;", "bindItem", "()V", "bind", "LJ8/w2;", "getBind", "()LJ8/w2;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class SnsConnectViewHolder extends ProfileEditBaseViewHolder {
            @NotNull
            private final w2 bind;

            public SnsConnectViewHolder(@NotNull w2 w20) {
                q.g(w20, "binding");
                MemberProfileEditAdapter.this = memberProfileEditFragment$MemberProfileEditAdapter0;
                super(w20);
                this.bind = w20;
                Context context0 = memberProfileEditFragment$MemberProfileEditAdapter0.getContext();
                CharSequence charSequence0 = context0 == null ? null : context0.getText(0x7F13105D);  // string:title_sns_connect "SNS 연결"
                ((MelonTextView)w20.d.d).setText(charSequence0);
            }

            @Override  // com.iloen.melon.fragments.mymusic.MemberProfileEditFragment$MemberProfileEditAdapter$ProfileEditBaseViewHolder
            public void bindItem() {
                RESPONSE myMusicSettingInformProfileSimpleRes$RESPONSE0 = MemberProfileEditFragment.this.profileInformRes;
                if(myMusicSettingInformProfileSimpleRes$RESPONSE0 != null) {
                    com.iloen.melon.fragments.mymusic.q q0 = new com.iloen.melon.fragments.mymusic.q(MemberProfileEditFragment.this, myMusicSettingInformProfileSimpleRes$RESPONSE0, MemberProfileEditAdapter.this);
                    this.bind.b.setOnClickListener(q0);
                    if(myMusicSettingInformProfileSimpleRes$RESPONSE0.siteChnlToolTip == null || myMusicSettingInformProfileSimpleRes$RESPONSE0.siteChnlToolTip.length() == 0) {
                        ((ImageView)this.bind.d.c).setVisibility(8);
                    }
                    else {
                        ((ImageView)this.bind.d.c).setVisibility(0);
                        String s = MemberProfileEditAdapter.this.getContext() == null ? null : "SNS 연결 정보";
                        ((ImageView)this.bind.d.c).setContentDescription(s);
                        com.iloen.melon.fragments.mymusic.q q1 = new com.iloen.melon.fragments.mymusic.q(MemberProfileEditFragment.this, MemberProfileEditAdapter.this, myMusicSettingInformProfileSimpleRes$RESPONSE0, 3);
                        ((ImageView)this.bind.d.c).setOnClickListener(q1);
                    }
                    this.bind.c.removeAllViews();
                    ArrayList arrayList0 = myMusicSettingInformProfileSimpleRes$RESPONSE0.snsInfo;
                    q.f(arrayList0, "snsInfo");
                    ArrayList arrayList1 = MemberProfileEditFragment.this.getSnsOrderList(arrayList0);
                    ArrayList arrayList2 = new ArrayList();
                    MemberProfileEditFragment.this.snsToggleGroup = arrayList2;
                    MemberProfileEditAdapter memberProfileEditFragment$MemberProfileEditAdapter0 = MemberProfileEditAdapter.this;
                    MemberProfileEditFragment memberProfileEditFragment0 = MemberProfileEditFragment.this;
                    int v = 0;
                    for(Object object0: arrayList1) {
                        if(v >= 0) {
                            View view0 = LayoutInflater.from(memberProfileEditFragment$MemberProfileEditAdapter0.getContext()).inflate(0x7F0D0510, null, false);  // layout:member_profile_sns_item
                            int v1 = 0x7F0A0635;  // id:iv_icon
                            View view1 = I.C(view0, 0x7F0A0635);  // id:iv_icon
                            if(((ImageView)view1) == null) {
                                throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v1));
                            }
                            v1 = 0x7F0A09F7;  // id:right_container
                            View view2 = I.C(view0, 0x7F0A09F7);  // id:right_container
                            if(((LinearLayout)view2) == null) {
                                throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v1));
                            }
                            v1 = 0x7F0A0AA0;  // id:sns_container
                            View view3 = I.C(view0, 0x7F0A0AA0);  // id:sns_container
                            if(((LinearLayout)view3) == null) {
                                throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v1));
                            }
                            v1 = 0x7F0A0BBA;  // id:toggle_check
                            View view4 = I.C(view0, 0x7F0A0BBA);  // id:toggle_check
                            if(((ToggleButton)view4) == null) {
                                throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v1));
                            }
                            v1 = 0x7F0A0CFD;  // id:tv_representaion
                            View view5 = I.C(view0, 0x7F0A0CFD);  // id:tv_representaion
                            if(((MelonTextView)view5) == null) {
                                throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v1));
                            }
                            v1 = 0x7F0A0D12;  // id:tv_sns
                            View view6 = I.C(view0, 0x7F0A0D12);  // id:tv_sns
                            if(((MelonTextView)view6) == null) {
                                throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v1));
                            }
                            x2 x20 = new x2(((RelativeLayout)view0), ((ImageView)view1), ((LinearLayout)view2), ((LinearLayout)view3), ((ToggleButton)view4), ((MelonTextView)view5), ((MelonTextView)view6));
                            ArrayList arrayList3 = memberProfileEditFragment0.snsToggleGroup;
                            if(arrayList3 != null) {
                                arrayList3.add(((RelativeLayout)view0));
                            }
                            if(((SnsInfoBase)object0).isRepnt) {
                                ((MelonTextView)view5).setVisibility(0);
                                ((ToggleButton)view4).setChecked(true);
                            }
                            else {
                                ((MelonTextView)view5).setVisibility(4);
                                ((ToggleButton)view4).setChecked(false);
                            }
                            String s1 = ((SnsInfoBase)object0).dtlInfoCode;
                            q.f(s1, "dtlInfoCode");
                            int v2 = memberProfileEditFragment0.getSnsImage(s1);
                            if(v2 == -1) {
                                ((ImageView)view1).setVisibility(4);
                            }
                            else {
                                ((ImageView)view1).setVisibility(0);
                                ((ImageView)view1).setImageResource(v2);
                            }
                            ((MelonTextView)view6).setText(((SnsInfoBase)object0).dtlInfoCodeStr);
                            if(arrayList1.size() == 1) {
                                ((LinearLayout)view2).setVisibility(8);
                            }
                            else {
                                ((LinearLayout)view2).setVisibility(0);
                                ((LinearLayout)view2).setOnClickListener(new v(x20, memberProfileEditFragment0, ((SnsInfoBase)object0), v, memberProfileEditFragment$MemberProfileEditAdapter0));
                            }
                            ((LinearLayout)view3).setOnClickListener(new w(((SnsInfoBase)object0), 0));
                            this.bind.c.addView(((RelativeLayout)view0));
                            ++v;
                            continue;
                        }
                        k.O();
                        throw null;
                    }
                }
            }

            private static final void bindItem$lambda$1(MemberProfileEditFragment memberProfileEditFragment0, RESPONSE myMusicSettingInformProfileSimpleRes$RESPONSE0, MemberProfileEditAdapter memberProfileEditFragment$MemberProfileEditAdapter0, View view0) {
                memberProfileEditFragment0.requestDjTermSnsAgree(myMusicSettingInformProfileSimpleRes$RESPONSE0.snsInfo);
                f f0 = memberProfileEditFragment0.getTiaraEventBuilder();
                if(f0 != null) {
                    String s = "페이지이동";
                    String s1 = "";
                    if(memberProfileEditFragment$MemberProfileEditAdapter0.getContext() == null) {
                        s = "";
                    }
                    String s2 = "SNS연결";
                    f0.a = s;
                    if(memberProfileEditFragment$MemberProfileEditAdapter0.getContext() == null) {
                        s2 = "";
                    }
                    f0.y = s2;
                    if(memberProfileEditFragment$MemberProfileEditAdapter0.getContext() != null) {
                        s1 = "채널추가";
                    }
                    f0.F = s1;
                    f0.a().track();
                }
            }

            private static final void bindItem$lambda$2(MemberProfileEditFragment memberProfileEditFragment0, MemberProfileEditAdapter memberProfileEditFragment$MemberProfileEditAdapter0, RESPONSE myMusicSettingInformProfileSimpleRes$RESPONSE0, View view0) {
                Context context0 = memberProfileEditFragment$MemberProfileEditAdapter0.getContext();
                CharSequence charSequence0 = context0 == null ? null : context0.getText(0x7F13105D);  // string:title_sns_connect "SNS 연결"
                String s = myMusicSettingInformProfileSimpleRes$RESPONSE0.siteChnlToolTip;
                q.f(s, "siteChnlToolTip");
                memberProfileEditFragment0.showInfoPopup(String.valueOf(charSequence0), s);
            }

            private static final void bindItem$lambda$6$lambda$4(x2 x20, MemberProfileEditFragment memberProfileEditFragment0, SnsInfoBase profileBaseRes$SnsInfoBase0, int v, MemberProfileEditAdapter memberProfileEditFragment$MemberProfileEditAdapter0, View view0) {
                if(!x20.b.isChecked()) {
                    String s = profileBaseRes$SnsInfoBase0.dtlInfoCode;
                    q.f(s, "dtlInfoCode");
                    memberProfileEditFragment0.requestSiteChannelUpdateRepnt(s, v);
                    f f0 = memberProfileEditFragment0.getTiaraEventBuilder();
                    if(f0 != null) {
                        String s1 = "페이지이동";
                        String s2 = "";
                        if(memberProfileEditFragment$MemberProfileEditAdapter0.getContext() == null) {
                            s1 = "";
                        }
                        String s3 = "SNS연결";
                        f0.a = s1;
                        if(memberProfileEditFragment$MemberProfileEditAdapter0.getContext() == null) {
                            s3 = "";
                        }
                        f0.y = s3;
                        if(memberProfileEditFragment$MemberProfileEditAdapter0.getContext() != null) {
                            s2 = "대표";
                        }
                        f0.F = s2;
                        f0.a().track();
                    }
                }
            }

            private static final void bindItem$lambda$6$lambda$5(SnsInfoBase profileBaseRes$SnsInfoBase0, View view0) {
                Navigator.open(ProfileEditFragment.newInstance(4, profileBaseRes$SnsInfoBase0.dtlInfoVal, profileBaseRes$SnsInfoBase0.dtlInfoCodeStr, profileBaseRes$SnsInfoBase0.dtlInfoCode));
            }

            public static void d(MemberProfileEditFragment memberProfileEditFragment0, MemberProfileEditAdapter memberProfileEditFragment$MemberProfileEditAdapter0, RESPONSE myMusicSettingInformProfileSimpleRes$RESPONSE0, View view0) {
                SnsConnectViewHolder.bindItem$lambda$1(memberProfileEditFragment0, myMusicSettingInformProfileSimpleRes$RESPONSE0, memberProfileEditFragment$MemberProfileEditAdapter0, view0);
            }

            @NotNull
            public final w2 getBind() {
                return this.bind;
            }
        }

        private final int VIEW_TYPE_DJ_INTRODUCE;
        private final int VIEW_TYPE_DJ_PICK;
        private final int VIEW_TYPE_MESSAGE_SETTING;
        private final int VIEW_TYPE_NICKNAME_EDIT;
        private final int VIEW_TYPE_PRIVATE_SETTING;
        private final int VIEW_TYPE_SNS_CONNECT;
        private final int VIEW_TYPE_THUMB;
        @NotNull
        private UserType userType;

        public MemberProfileEditAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            MemberProfileEditFragment.this = memberProfileEditFragment0;
            super(context0, list0);
            this.VIEW_TYPE_NICKNAME_EDIT = 1;
            this.VIEW_TYPE_DJ_INTRODUCE = 2;
            this.VIEW_TYPE_SNS_CONNECT = 3;
            this.VIEW_TYPE_DJ_PICK = 4;
            this.VIEW_TYPE_PRIVATE_SETTING = 5;
            this.VIEW_TYPE_MESSAGE_SETTING = 6;
            this.userType = new UserType(false, false, false, 7, null);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            Integer integer0 = (Integer)this.getItem(v1);
            return integer0 == null ? -1 : ((int)integer0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(@Nullable String s, @Nullable v9.i i0, @Nullable HttpResponse httpResponse0) {
            if(httpResponse0 instanceof MyMusicSettingInformProfileSimpleRes) {
                RESPONSE myMusicSettingInformProfileSimpleRes$RESPONSE0 = ((MyMusicSettingInformProfileSimpleRes)httpResponse0).response;
                if(myMusicSettingInformProfileSimpleRes$RESPONSE0 != null) {
                    MemberProfileEditFragment.this.profileInformRes = myMusicSettingInformProfileSimpleRes$RESPONSE0;
                    this.setMenuId(myMusicSettingInformProfileSimpleRes$RESPONSE0.menuId);
                    this.setHasMore(false);
                    this.userType = new UserType(myMusicSettingInformProfileSimpleRes$RESPONSE0.isDj, myMusicSettingInformProfileSimpleRes$RESPONSE0.isPowerDj, myMusicSettingInformProfileSimpleRes$RESPONSE0.isArtistUser);
                    this.add(this.VIEW_TYPE_THUMB);
                    this.add(this.VIEW_TYPE_NICKNAME_EDIT);
                    if(this.userType.isPowerDj()) {
                        this.add(this.VIEW_TYPE_DJ_INTRODUCE);
                    }
                    if(this.userType.isPowerDj() && !myMusicSettingInformProfileSimpleRes$RESPONSE0.isUnderFourTeenMember) {
                        this.add(this.VIEW_TYPE_SNS_CONNECT);
                    }
                    if(this.userType.isDj()) {
                        this.add(this.VIEW_TYPE_DJ_PICK);
                    }
                    this.add(this.VIEW_TYPE_PRIVATE_SETTING);
                    this.add(this.VIEW_TYPE_MESSAGE_SETTING);
                }
            }
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            if(o00 instanceof ProfileEditBaseViewHolder) {
                ((ProfileEditBaseViewHolder)o00).bindItem();
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@Nullable ViewGroup viewGroup0, int v) {
            int v1 = 0x7F0A0B96;  // id:title_container
            int v2 = 0x7F0A0C90;  // id:tv_introduce
            if(v == this.VIEW_TYPE_THUMB) {
                return new ProfileThumbViewHolder(this, y2.a(LayoutInflater.from(this.getContext()), viewGroup0));
            }
            if(v == this.VIEW_TYPE_NICKNAME_EDIT) {
                View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D050D, viewGroup0, false);  // layout:member_profile_nickname_introduce
                if(((RelativeLayout)I.C(view0, 0x7F0A08B5)) == null) {  // id:nickname_container
                    v2 = 0x7F0A08B5;  // id:nickname_container
                }
                else {
                    MelonTextView melonTextView0 = (MelonTextView)I.C(view0, 0x7F0A0C90);  // id:tv_introduce
                    if(melonTextView0 != null) {
                        v2 = 0x7F0A0CCD;  // id:tv_nickname
                        MelonTextView melonTextView1 = (MelonTextView)I.C(view0, 0x7F0A0CCD);  // id:tv_nickname
                        if(melonTextView1 != null) {
                            return new NickNameEditViewHolder(this, new u2(((RelativeLayout)view0), melonTextView0, melonTextView1));
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v2));
            }
            if(v == this.VIEW_TYPE_DJ_INTRODUCE) {
                View view1 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0509, viewGroup0, false);  // layout:member_profile_dj_introduce
                View view2 = I.C(view1, 0x7F0A0B96);  // id:title_container
                if(view2 == null) {
                    v2 = 0x7F0A0B96;  // id:title_container
                }
                else {
                    x x0 = x.a(view2);
                    MelonTextView melonTextView2 = (MelonTextView)I.C(view1, 0x7F0A0C90);  // id:tv_introduce
                    if(melonTextView2 != null) {
                        return new DjIntroduceViewHolder(this, new q2(((RelativeLayout)view1), x0, melonTextView2));
                    }
                }
                throw new NullPointerException("Missing required view with ID: " + view1.getResources().getResourceName(v2));
            }
            if(v == this.VIEW_TYPE_SNS_CONNECT) {
                View view3 = LayoutInflater.from(this.getContext()).inflate(0x7F0D050F, viewGroup0, false);  // layout:member_profile_sns_connect
                MelonTextView melonTextView3 = (MelonTextView)I.C(view3, 0x7F0A0148);  // id:btn_channel_add
                if(melonTextView3 == null) {
                    v1 = 0x7F0A0148;  // id:btn_channel_add
                }
                else {
                    LinearLayout linearLayout0 = (LinearLayout)I.C(view3, 0x7F0A05A7);  // id:item_container
                    if(linearLayout0 == null) {
                        v1 = 0x7F0A05A7;  // id:item_container
                    }
                    else {
                        View view4 = I.C(view3, 0x7F0A0B96);  // id:title_container
                        if(view4 != null) {
                            return new SnsConnectViewHolder(this, new w2(((RelativeLayout)view3), melonTextView3, linearLayout0, x.a(view4)));
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: " + view3.getResources().getResourceName(v1));
            }
            if(v == this.VIEW_TYPE_DJ_PICK) {
                View view5 = LayoutInflater.from(this.getContext()).inflate(0x7F0D050A, viewGroup0, false);  // layout:member_profile_dj_pick
                View view6 = I.C(view5, 0x7F0A02C3);  // id:click_container
                if(((RelativeLayout)view6) == null) {
                    v1 = 0x7F0A02C3;  // id:click_container
                }
                else {
                    View view7 = I.C(view5, 0x7F0A03DE);  // id:dj_pick_title_container
                    if(((LinearLayout)view7) == null) {
                        v1 = 0x7F0A03DE;  // id:dj_pick_title_container
                    }
                    else {
                        View view8 = I.C(view5, 0x7F0A0429);  // id:empty_dj_pick
                        if(((MelonTextView)view8) == null) {
                            v1 = 0x7F0A0429;  // id:empty_dj_pick
                        }
                        else {
                            View view9 = I.C(view5, 0x7F0A05FE);  // id:iv_bg
                            if(((CardView)view9) == null) {
                                v1 = 0x7F0A05FE;  // id:iv_bg
                            }
                            else {
                                View view10 = I.C(view5, 0x7F0A0625);  // id:iv_dim
                                if(((MelonImageView)view10) == null) {
                                    v1 = 0x7F0A0625;  // id:iv_dim
                                }
                                else {
                                    View view11 = I.C(view5, 0x7F0A062A);  // id:iv_empty_thumb
                                    if(((ImageView)view11) == null) {
                                        v1 = 0x7F0A062A;  // id:iv_empty_thumb
                                    }
                                    else {
                                        View view12 = I.C(view5, 0x7F0A0939);  // id:playlist_thumb_container
                                        if(view12 == null) {
                                            v1 = 0x7F0A0939;  // id:playlist_thumb_container
                                        }
                                        else {
                                            b b0 = b.c(view12);
                                            if(((FrameLayout)I.C(view5, 0x7F0A0B72)) == null) {  // id:thumb_container
                                                v1 = 0x7F0A0B72;  // id:thumb_container
                                            }
                                            else {
                                                View view13 = I.C(view5, 0x7F0A0B96);  // id:title_container
                                                if(view13 != null) {
                                                    x x1 = x.a(view13);
                                                    v1 = 0x7F0A0C65;  // id:tv_dj_pick
                                                    if(((MelonTextView)I.C(view5, 0x7F0A0C65)) != null) {  // id:tv_dj_pick
                                                        v1 = 0x7F0A0C66;  // id:tv_dj_pick_title
                                                        View view14 = I.C(view5, 0x7F0A0C66);  // id:tv_dj_pick_title
                                                        if(((MelonTextView)view14) != null) {
                                                            return new DjPickViewHolder(this, new r2(((RelativeLayout)view5), ((RelativeLayout)view6), ((LinearLayout)view7), ((MelonTextView)view8), ((CardView)view9), ((MelonImageView)view10), ((ImageView)view11), b0, x1, ((MelonTextView)view14)));
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
                throw new NullPointerException("Missing required view with ID: " + view5.getResources().getResourceName(v1));
            }
            if(v == this.VIEW_TYPE_PRIVATE_SETTING) {
                View view15 = LayoutInflater.from(this.getContext()).inflate(0x7F0D050E, viewGroup0, false);  // layout:member_profile_private_setting
                View view16 = I.C(view15, 0x7F0A00B3);  // id:artist_container
                if(((RelativeLayout)view16) == null) {
                    v1 = 0x7F0A00B3;  // id:artist_container
                }
                else {
                    View view17 = I.C(view15, 0x7F0A013F);  // id:btn_artist_check
                    if(((ToggleButton)view17) == null) {
                        v1 = 0x7F0A013F;  // id:btn_artist_check
                    }
                    else {
                        View view18 = I.C(view15, 0x7F0A015A);  // id:btn_dj_pick_check
                        if(((ToggleButton)view18) == null) {
                            v1 = 0x7F0A015A;  // id:btn_dj_pick_check
                        }
                        else {
                            View view19 = I.C(view15, 0x7F0A015B);  // id:btn_dj_talk_check
                            if(((ToggleButton)view19) == null) {
                                v1 = 0x7F0A015B;  // id:btn_dj_talk_check
                            }
                            else {
                                View view20 = I.C(view15, 0x7F0A0160);  // id:btn_fan_lounge_check
                                if(((ToggleButton)view20) == null) {
                                    v1 = 0x7F0A0160;  // id:btn_fan_lounge_check
                                }
                                else {
                                    View view21 = I.C(view15, 0x7F0A0162);  // id:btn_follow_check
                                    if(((ToggleButton)view21) == null) {
                                        v1 = 0x7F0A0162;  // id:btn_follow_check
                                    }
                                    else {
                                        View view22 = I.C(view15, 0x7F0A0171);  // id:btn_liked_check
                                        if(((ToggleButton)view22) == null) {
                                            v1 = 0x7F0A0171;  // id:btn_liked_check
                                        }
                                        else {
                                            View view23 = I.C(view15, 0x7F0A03DD);  // id:dj_pick_container
                                            if(((RelativeLayout)view23) == null) {
                                                v1 = 0x7F0A03DD;  // id:dj_pick_container
                                            }
                                            else {
                                                View view24 = I.C(view15, 0x7F0A03DF);  // id:dj_talk_container
                                                if(((RelativeLayout)view24) == null) {
                                                    v1 = 0x7F0A03DF;  // id:dj_talk_container
                                                }
                                                else {
                                                    View view25 = I.C(view15, 0x7F0A0491);  // id:fan_lounge_container
                                                    if(((RelativeLayout)view25) == null || ((RelativeLayout)I.C(view15, 0x7F0A04D1)) == null || ((RelativeLayout)I.C(view15, 0x7F0A076C)) == null) {  // id:follow_container
                                                        v1 = 0x7F0A0491;  // id:fan_lounge_container
                                                    }
                                                    else {
                                                        View view26 = I.C(view15, 0x7F0A0B96);  // id:title_container
                                                        if(view26 != null) {
                                                            return new PrivateSettingViewHolder(this, new v2(((RelativeLayout)view15), ((RelativeLayout)view16), ((ToggleButton)view17), ((ToggleButton)view18), ((ToggleButton)view19), ((ToggleButton)view20), ((ToggleButton)view21), ((ToggleButton)view22), ((RelativeLayout)view23), ((RelativeLayout)view24), ((RelativeLayout)view25), x.a(view26)));
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
                throw new NullPointerException("Missing required view with ID: " + view15.getResources().getResourceName(v1));
            }
            if(v == this.VIEW_TYPE_MESSAGE_SETTING) {
                View view27 = LayoutInflater.from(this.getContext()).inflate(0x7F0D050C, viewGroup0, false);  // layout:member_profile_message_setting
                View view28 = I.C(view27, 0x7F0A017C);  // id:btn_msg_receive_check
                if(((ToggleButton)view28) == null) {
                    v1 = 0x7F0A017C;  // id:btn_msg_receive_check
                }
                else {
                    View view29 = I.C(view27, 0x7F0A0867);  // id:msg_block_container
                    if(((RelativeLayout)view29) == null || ((RelativeLayout)I.C(view27, 0x7F0A0868)) == null) {  // id:msg_receive_container
                        v1 = 0x7F0A0867;  // id:msg_block_container
                    }
                    else {
                        View view30 = I.C(view27, 0x7F0A0B96);  // id:title_container
                        if(view30 != null) {
                            x x2 = x.a(view30);
                            v1 = 0x7F0A0D6B;  // id:underline
                            View view31 = I.C(view27, 0x7F0A0D6B);  // id:underline
                            if(view31 != null) {
                                return new MessageSettingViewHolder(this, new t2(((RelativeLayout)view27), ((ToggleButton)view28), ((RelativeLayout)view29), x2, view31));
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: " + view27.getResources().getResourceName(v1));
            }
            return new ProfileThumbViewHolder(this, y2.a(LayoutInflater.from(this.getContext()), viewGroup0));
        }
    }

    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\t\u001A\u00020\u0003HÆ\u0003J\t\u0010\n\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000B\u001A\u00020\u0003HÆ\u0003J\'\u0010\f\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001A\u00020\u00032\b\u0010\u000E\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000F\u001A\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001A\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0004\u0010\bR\u0011\u0010\u0005\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0005\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MemberProfileEditFragment$UserType;", "", "isDj", "", "isPowerDj", "isArtist", "<init>", "(ZZZ)V", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    static final class UserType {
        private final boolean isArtist;
        private final boolean isDj;
        private final boolean isPowerDj;

        public UserType() {
            this(false, false, false, 7, null);
        }

        public UserType(boolean z, boolean z1, boolean z2) {
            this.isDj = z;
            this.isPowerDj = z1;
            this.isArtist = z2;
        }

        public UserType(boolean z, boolean z1, boolean z2, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 1) != 0) {
                z = false;
            }
            if((v & 2) != 0) {
                z1 = false;
            }
            if((v & 4) != 0) {
                z2 = false;
            }
            this(z, z1, z2);
        }

        public final boolean component1() {
            return this.isDj;
        }

        public final boolean component2() {
            return this.isPowerDj;
        }

        public final boolean component3() {
            return this.isArtist;
        }

        @NotNull
        public final UserType copy(boolean z, boolean z1, boolean z2) {
            return new UserType(z, z1, z2);
        }

        public static UserType copy$default(UserType memberProfileEditFragment$UserType0, boolean z, boolean z1, boolean z2, int v, Object object0) {
            if((v & 1) != 0) {
                z = memberProfileEditFragment$UserType0.isDj;
            }
            if((v & 2) != 0) {
                z1 = memberProfileEditFragment$UserType0.isPowerDj;
            }
            if((v & 4) != 0) {
                z2 = memberProfileEditFragment$UserType0.isArtist;
            }
            return memberProfileEditFragment$UserType0.copy(z, z1, z2);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof UserType)) {
                return false;
            }
            if(this.isDj != ((UserType)object0).isDj) {
                return false;
            }
            return this.isPowerDj == ((UserType)object0).isPowerDj ? this.isArtist == ((UserType)object0).isArtist : false;
        }

        @Override
        public int hashCode() {
            return Boolean.hashCode(this.isArtist) + d.e(Boolean.hashCode(this.isDj) * 0x1F, 0x1F, this.isPowerDj);
        }

        public final boolean isArtist() {
            return this.isArtist;
        }

        public final boolean isDj() {
            return this.isDj;
        }

        public final boolean isPowerDj() {
            return this.isPowerDj;
        }

        @Override
        @NotNull
        public String toString() {
            return o.s(Y.q("UserType(isDj=", ", isPowerDj=", this.isDj, ", isArtist=", this.isPowerDj), this.isArtist, ")");
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "MemberProfileEditFragment";
    @NotNull
    private static final String TAG_PROFILE;
    @Nullable
    private s2 _binding;
    @NotNull
    private final ImageSelector imageSelector;
    @NotNull
    private final com.iloen.melon.fragments.mymusic.MemberProfileEditFragment.imageSelectorListener.1 imageSelectorListener;
    @Nullable
    private MelonTextPopup infoPopup;
    private BorderImageView ivProfileThumb;
    @NotNull
    private final CoroutineExceptionHandler mainExceptionHandler;
    @NotNull
    private final com.iloen.melon.fragments.mymusic.MemberProfileEditFragment.onScrollListener.1 onScrollListener;
    @Nullable
    private RESPONSE profileInformRes;
    @Nullable
    private ArrayList snsToggleGroup;

    static {
        MemberProfileEditFragment.Companion = new Companion(null);
        MemberProfileEditFragment.$stable = 8;
        MemberProfileEditFragment.TAG_PROFILE = "tag_profile";
    }

    public MemberProfileEditFragment() {
        this.mainExceptionHandler = new CoroutineExceptionHandler(this) {
            @Override  // kotlinx.coroutines.CoroutineExceptionHandler
            public void handleException(me.i i0, Throwable throwable0) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new com.iloen.melon.fragments.mymusic.MemberProfileEditFragment.mainExceptionHandler.1.1(throwable0, MemberProfileEditFragment.this, null), 3, null);
            }
        };
        com.iloen.melon.fragments.mymusic.MemberProfileEditFragment.imageSelectorListener.1 memberProfileEditFragment$imageSelectorListener$10 = new ImageSelectorListener() {
            @Override  // com.iloen.melon.utils.image.ImageSelector$ImageSelectorListener
            public void onFinishBackgroundLoading() {
            }

            @Override  // com.iloen.melon.utils.image.ImageSelector$ImageSelectorListener
            public void onImageSelectorCanceled(ImageSelector imageSelector0, Request imageSelector$Request0) {
            }

            @Override  // com.iloen.melon.utils.image.ImageSelector$ImageSelectorListener
            public void onImageSelectorComplete(ImageSelector imageSelector0, Request imageSelector$Request0, Uri uri0) {
                q.g(imageSelector$Request0, "reqInfo");
                if(uri0 != null) {
                    MemberProfileEditFragment.access$setUserProfileImage(MemberProfileEditFragment.this, uri0);
                    TimeExpiredCache.getInstance().removeLike(MelonContentUris.Z0.toString());
                }
            }

            @Override  // com.iloen.melon.utils.image.ImageSelector$ImageSelectorListener
            public void onStartBackgroundLoading() {
            }
        };
        this.imageSelectorListener = memberProfileEditFragment$imageSelectorListener$10;
        this.imageSelector = new ImageSelector(this, memberProfileEditFragment$imageSelectorListener$10);
        this.onScrollListener = new A0() {
            @Override  // androidx.recyclerview.widget.A0
            public void onScrolled(RecyclerView recyclerView0, int v, int v1) {
                q.g(recyclerView0, "recyclerView");
                super.onScrolled(recyclerView0, v, v1);
                if(MemberProfileEditFragment.access$getMRecyclerView$p$s-1997470295(MemberProfileEditFragment.this) != null) {
                    if(!recyclerView0.canScrollVertically(-1)) {
                        MemberProfileEditFragment.access$getTitleBar(MemberProfileEditFragment.this).f(false);
                        return;
                    }
                    MemberProfileEditFragment.access$getTitleBar(MemberProfileEditFragment.this).f(true);
                }
            }
        };

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @oe.e(c = "com.iloen.melon.fragments.mymusic.MemberProfileEditFragment$mainExceptionHandler$1$1", f = "MemberProfileEditFragment.kt", l = {}, m = "invokeSuspend")
        final class com.iloen.melon.fragments.mymusic.MemberProfileEditFragment.mainExceptionHandler.1.1 extends oe.i implements n {
            final Throwable $throwable;
            int label;

            public com.iloen.melon.fragments.mymusic.MemberProfileEditFragment.mainExceptionHandler.1.1(Throwable throwable0, MemberProfileEditFragment memberProfileEditFragment0, Continuation continuation0) {
                this.$throwable = throwable0;
                MemberProfileEditFragment.this = memberProfileEditFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.mymusic.MemberProfileEditFragment.mainExceptionHandler.1.1(this.$throwable, MemberProfileEditFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.mymusic.MemberProfileEditFragment.mainExceptionHandler.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                Throwable throwable0 = this.$throwable;
                if(throwable0 instanceof VolleyError) {
                    Y.w("mainExceptionHandler message = ", throwable0.getMessage(), LogU.Companion, "MemberProfileEditFragment");
                    MemberProfileEditFragment.access$getMResponseErrorListener$p$s-1997470295(MemberProfileEditFragment.this).onErrorResponse(((VolleyError)this.$throwable));
                }
                return ie.H.a;
            }
        }

    }

    public static final RecyclerView access$getMRecyclerView$p$s-1997470295(MemberProfileEditFragment memberProfileEditFragment0) {
        return memberProfileEditFragment0.mRecyclerView;
    }

    public static final ErrorListener access$getMResponseErrorListener$p$s-1997470295(MemberProfileEditFragment memberProfileEditFragment0) {
        return memberProfileEditFragment0.mResponseErrorListener;
    }

    // 去混淆评级： 低(20)
    public static final String access$getTAG_PROFILE$cp() [...] // 潜在的解密器

    public static final TitleBar access$getTitleBar(MemberProfileEditFragment memberProfileEditFragment0) {
        return memberProfileEditFragment0.getTitleBar();
    }

    public static final void access$setUserProfileImage(MemberProfileEditFragment memberProfileEditFragment0, Uri uri0) {
        memberProfileEditFragment0.setUserProfileImage(uri0);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new MemberProfileEditAdapter(this, context0, null);
    }

    private final void deleteProfileImg() {
        com.iloen.melon.net.RequestBuilder.newInstance(new DeleteUserImgReq(this.getContext())).tag(this.getRequestTag()).listener(new u(this, 1)).errorListener(new W(6)).request();
    }

    private static final void deleteProfileImg$lambda$12(MemberProfileEditFragment memberProfileEditFragment0, DeleteUserImgRes deleteUserImgRes0) {
        if(memberProfileEditFragment0.isFragmentValid() && deleteUserImgRes0 != null && deleteUserImgRes0.isSuccessful()) {
            BorderImageView borderImageView0 = memberProfileEditFragment0.ivProfileThumb;
            if(borderImageView0 != null) {
                borderImageView0.setImageDrawable(null);
                TimeExpiredCache.getInstance().removeLike(MelonContentUris.Z0.toString());
                return;
            }
            q.m("ivProfileThumb");
            throw null;
        }
    }

    private static final void deleteProfileImg$lambda$13(VolleyError volleyError0) {
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    private final s2 getBinding() {
        s2 s20 = this._binding;
        q.d(s20);
        return s20;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        String s = MelonContentUris.a1.toString();
        q.f(s, "toString(...)");
        return s;
    }

    @Override  // kotlinx.coroutines.CoroutineScope
    @NotNull
    public me.i getCoroutineContext() {
        return Dispatchers.getIO();
    }

    private final int getSnsImage(String s) {
        if(q.b(s, "FACEBOOK")) {
            return 0x7F0803EA;  // drawable:ic_common_facebook_16
        }
        if(q.b(s, "INSTAGRAM")) {
            return 0x7F0803F5;  // drawable:ic_common_instagram_16
        }
        if(q.b(s, "KAKAO")) {
            return 0x7F0803F7;  // drawable:ic_common_kakao_16
        }
        if(q.b(s, "TIKTOK")) {
            return 0x7F080412;  // drawable:ic_common_tiktok_16
        }
        if(q.b(s, "TWITTER")) {
            return 0x7F0805FE;  // drawable:ic_x_16
        }
        return q.b(s, "YOUTUBE") ? 0x7F080421 : -1;  // drawable:ic_common_youtube_16
    }

    private final ArrayList getSnsOrderList(ArrayList arrayList0) {
        ArrayList arrayList1 = new ArrayList();
        if(arrayList0 != null && !arrayList0.isEmpty()) {
            Object object0 = null;
            for(Object object1: arrayList0) {
                if(((SnsInfoBase)object1).isRepnt) {
                    object0 = object1;
                    break;
                }
            }
            if(((SnsInfoBase)object0) != null) {
                arrayList1.add(((SnsInfoBase)object0));
            }
            for(Object object2: arrayList0) {
                SnsInfoBase profileBaseRes$SnsInfoBase0 = (SnsInfoBase)object2;
                if(!profileBaseRes$SnsInfoBase0.isRepnt) {
                    arrayList1.add(profileBaseRes$SnsInfoBase0);
                }
            }
        }
        return arrayList1;
    }

    private final f getTiaraEventBuilder() {
        if(this.mMelonTiaraProperty != null) {
            f f0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
            f0.b = this.mMelonTiaraProperty.a;
            f0.c = this.mMelonTiaraProperty.b;
            f0.I = this.mMelonTiaraProperty.c;
            return f0;
        }
        return null;
    }

    public static void h0(DialogInterface dialogInterface0, int v) {
    }

    private final void initTitleBar() {
        this.setTitleBar(((TitleBar)this.getBinding().c.c));
        this.setTitleBarCommonButtonEventListener(this.getTitleBar());
        this.getTitleBar().a(B.a.s(7));
        this.getTitleBar().setTitle((this.getContext() == null ? null : "프로필 편집"));
        this.getTitleBar().f(false);
    }

    @NotNull
    public static final MemberProfileEditFragment newInstance() {
        return MemberProfileEditFragment.Companion.newInstance();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        MelonTextPopup melonTextPopup0 = this.infoPopup;
        if(melonTextPopup0 != null) {
            melonTextPopup0.setConfigurationChanged(configuration0.orientation);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        s2 s20 = this.getBinding();
        q.f(s20.b, "recyclerView");
        LinearLayoutManager linearLayoutManager0 = new LinearLayoutManager(s20.b.getContext());
        s20.b.setLayoutManager(linearLayoutManager0);
        s20.b.setAdapter(this.mAdapter);
        s20.b.setHasFixedSize(false);
        return s20.b;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        View view0 = layoutInflater0.inflate(0x7F0D050B, viewGroup0, false);  // layout:member_profile_edit
        int v = 0x7F0A09D1;  // id:recycler_view
        RecyclerView recyclerView0 = (RecyclerView)I.C(view0, 0x7F0A09D1);  // id:recycler_view
        if(recyclerView0 != null) {
            v = 0x7F0A0BD5;  // id:top_titlebar
            View view1 = I.C(view0, 0x7F0A0BD5);  // id:top_titlebar
            if(view1 != null) {
                this._binding = new s2(((RelativeLayout)view0), recyclerView0, new b(((TitleBar)view1), ((TitleBar)view1), 12));
                return this.getBinding().a;
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onDestroy() {
        super.onDestroy();
        this._binding = null;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable v9.i i0, @Nullable h h0, @Nullable String s) {
        com.iloen.melon.fragments.mymusic.MemberProfileEditFragment.onFetchStart.1 memberProfileEditFragment$onFetchStart$10 = new n(i0, null) {
            final v9.i $type;
            Object L$0;
            Object L$1;
            int label;

            {
                MemberProfileEditFragment.this = memberProfileEditFragment0;
                this.$type = i0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.mymusic.MemberProfileEditFragment.onFetchStart.1(MemberProfileEditFragment.this, this.$type, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.mymusic.MemberProfileEditFragment.onFetchStart.1)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                ne.a a0 = ne.a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        Deferred deferred0 = MemberProfileEditFragment.this.requestProfileSettingInformAsync();
                        this.label = 1;
                        object0 = deferred0.await(this);
                        if(object0 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        d5.n.D(object0);
                        break;
                    }
                    case 2: {
                        me.i i0 = (me.i)this.L$1;
                        MyMusicSettingInformProfileSimpleRes myMusicSettingInformProfileSimpleRes0 = (MyMusicSettingInformProfileSimpleRes)this.L$0;
                        d5.n.D(object0);
                        return ie.H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                me.i i1 = Dispatchers.getMain().plus(MemberProfileEditFragment.this.mainExceptionHandler);
                com.iloen.melon.fragments.mymusic.MemberProfileEditFragment.onFetchStart.1.1 memberProfileEditFragment$onFetchStart$1$10 = new n(((MyMusicSettingInformProfileSimpleRes)object0), this.$type, null) {
                    final MyMusicSettingInformProfileSimpleRes $profileSettingInformRes;
                    final v9.i $type;
                    int label;

                    {
                        MemberProfileEditFragment.this = memberProfileEditFragment0;
                        this.$profileSettingInformRes = myMusicSettingInformProfileSimpleRes0;
                        this.$type = i0;
                        super(2, continuation0);
                    }

                    @Override  // oe.a
                    public final Continuation create(Object object0, Continuation continuation0) {
                        return new com.iloen.melon.fragments.mymusic.MemberProfileEditFragment.onFetchStart.1.1(MemberProfileEditFragment.this, this.$profileSettingInformRes, this.$type, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                    }

                    public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                        return ((com.iloen.melon.fragments.mymusic.MemberProfileEditFragment.onFetchStart.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
                    }

                    @Override  // oe.a
                    public final Object invokeSuspend(Object object0) {
                        if(this.label != 0) {
                            throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                        }
                        d5.n.D(object0);
                        boolean z = MemberProfileEditFragment.this.prepareFetchComplete(this.$profileSettingInformRes);
                        ie.H h0 = ie.H.a;
                        if(!z) {
                            return h0;
                        }
                        MyMusicSettingInformProfileSimpleRes myMusicSettingInformProfileSimpleRes0 = this.$profileSettingInformRes;
                        if(myMusicSettingInformProfileSimpleRes0 != null) {
                            RESPONSE myMusicSettingInformProfileSimpleRes$RESPONSE0 = myMusicSettingInformProfileSimpleRes0.response;
                            if(myMusicSettingInformProfileSimpleRes$RESPONSE0 != null) {
                                p8.s s0 = new p8.s(myMusicSettingInformProfileSimpleRes$RESPONSE0.section, myMusicSettingInformProfileSimpleRes$RESPONSE0.page, myMusicSettingInformProfileSimpleRes$RESPONSE0.menuId, null);
                                MemberProfileEditFragment.this.mMelonTiaraProperty = s0;
                            }
                        }
                        MemberProfileEditFragment.this.performFetchComplete(this.$type, this.$profileSettingInformRes);
                        return h0;
                    }
                };
                this.L$0 = null;
                this.L$1 = null;
                this.label = 2;
                return BuildersKt.withContext(i1, memberProfileEditFragment$onFetchStart$1$10, this) == a0 ? a0 : ie.H.a;
            }
        };
        BuildersKt__Builders_commonKt.launch$default(this, this.mainExceptionHandler, null, memberProfileEditFragment$onFetchStart$10, 2, null);
        return true;
    }

    @Override  // com.iloen.melon.fragments.MetaContentBaseFragment
    public void onPause() {
        super.onPause();
        RecyclerView recyclerView0 = this.mRecyclerView;
        if(recyclerView0 != null) {
            recyclerView0.removeOnScrollListener(this.onScrollListener);
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onResume() {
        super.onResume();
        RecyclerView recyclerView0 = this.mRecyclerView;
        if(recyclerView0 != null) {
            recyclerView0.addOnScrollListener(this.onScrollListener);
        }
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.initTitleBar();
    }

    private final void requestDjTermSnsAgree(ArrayList arrayList0) {
        com.iloen.melon.net.RequestBuilder.newInstance(new DjSnsUseAgreeReq(this.getContext())).tag("MemberProfileEditFragment").listener(new com.iloen.melon.fragments.mymusic.g(this, arrayList0, 10)).errorListener(this.mResponseErrorListener).request();
    }

    private static final void requestDjTermSnsAgree$lambda$15(MemberProfileEditFragment memberProfileEditFragment0, ArrayList arrayList0, Object object0) {
        String s1;
        if(object0 instanceof DjSnsUseAgreeRes && ((DjSnsUseAgreeRes)object0).isSuccessful()) {
            com.iloen.melon.net.v6x.response.DjSnsUseAgreeRes.RESPONSE djSnsUseAgreeRes$RESPONSE0 = ((DjSnsUseAgreeRes)object0).response;
            if(djSnsUseAgreeRes$RESPONSE0 != null) {
                if(djSnsUseAgreeRes$RESPONSE0.isAgree) {
                    memberProfileEditFragment0.showSnsChannelPopup(arrayList0);
                    return;
                }
                MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
                OPTION djSnsUseAgreeRes$RESPONSE$OPTION0 = ((DjSnsUseAgreeRes)object0).response.option;
                String s = "";
                if(djSnsUseAgreeRes$RESPONSE$OPTION0 == null) {
                    s1 = "";
                }
                else {
                    s1 = djSnsUseAgreeRes$RESPONSE$OPTION0.linkurl;
                    if(s1 == null) {
                        s1 = "";
                    }
                }
                melonLinkInfo0.b = s1;
                if(djSnsUseAgreeRes$RESPONSE$OPTION0 != null) {
                    String s2 = djSnsUseAgreeRes$RESPONSE$OPTION0.linktype;
                    if(s2 != null) {
                        s = s2;
                    }
                }
                melonLinkInfo0.a = s;
                MelonLinkExecutor.open(melonLinkInfo0);
            }
        }
    }

    private final void requestOpenYn(String s, String s1) {
        com.iloen.melon.net.RequestBuilder.newInstance(new MyMusicUpdateMyProfileOpenYnReq(this.getContext(), s, s1)).tag(this.getRequestTag()).listener(new u(this, 2)).errorListener(new W(7)).request();
    }

    private static final void requestOpenYn$lambda$18(MemberProfileEditFragment memberProfileEditFragment0, MyMusicUpdateMyProfileOpenYnRes myMusicUpdateMyProfileOpenYnRes0) {
        if(memberProfileEditFragment0.isFragmentValid() && ((myMusicUpdateMyProfileOpenYnRes0 == null ? null : myMusicUpdateMyProfileOpenYnRes0.response) != null && myMusicUpdateMyProfileOpenYnRes0.isSuccessful())) {
            String s = myMusicUpdateMyProfileOpenYnRes0.response.openFlag;
            String s1 = myMusicUpdateMyProfileOpenYnRes0.response.openFlagType;
            LogU.Companion.d("MemberProfileEditFragment", "openFlag : " + s + ", openFlagType : " + s1);
            if(s1 != null) {
                switch(s1) {
                    case "ARTISTCHN": {
                        RESPONSE myMusicSettingInformProfileSimpleRes$RESPONSE1 = memberProfileEditFragment0.profileInformRes;
                        if(myMusicSettingInformProfileSimpleRes$RESPONSE1 != null) {
                            myMusicSettingInformProfileSimpleRes$RESPONSE1.artistChnFlag = s;
                        }
                        break;
                    }
                    case "DJCMT": {
                        RESPONSE myMusicSettingInformProfileSimpleRes$RESPONSE3 = memberProfileEditFragment0.profileInformRes;
                        if(myMusicSettingInformProfileSimpleRes$RESPONSE3 != null) {
                            myMusicSettingInformProfileSimpleRes$RESPONSE3.djCmtOpenFlag = s;
                        }
                        break;
                    }
                    case "DJPICK": {
                        RESPONSE myMusicSettingInformProfileSimpleRes$RESPONSE4 = memberProfileEditFragment0.profileInformRes;
                        if(myMusicSettingInformProfileSimpleRes$RESPONSE4 != null) {
                            myMusicSettingInformProfileSimpleRes$RESPONSE4.djPickFlag = s;
                        }
                        break;
                    }
                    case "FANLOUNGE": {
                        RESPONSE myMusicSettingInformProfileSimpleRes$RESPONSE0 = memberProfileEditFragment0.profileInformRes;
                        if(myMusicSettingInformProfileSimpleRes$RESPONSE0 != null) {
                            myMusicSettingInformProfileSimpleRes$RESPONSE0.fanLoungeOpenFlag = s;
                        }
                        break;
                    }
                    case "FRIEND": {
                        RESPONSE myMusicSettingInformProfileSimpleRes$RESPONSE6 = memberProfileEditFragment0.profileInformRes;
                        if(myMusicSettingInformProfileSimpleRes$RESPONSE6 != null) {
                            myMusicSettingInformProfileSimpleRes$RESPONSE6.friendOpenFlag = s;
                        }
                        break;
                    }
                    case "LIKE": {
                        RESPONSE myMusicSettingInformProfileSimpleRes$RESPONSE2 = memberProfileEditFragment0.profileInformRes;
                        if(myMusicSettingInformProfileSimpleRes$RESPONSE2 != null) {
                            myMusicSettingInformProfileSimpleRes$RESPONSE2.likeOpenFlag = s;
                        }
                        break;
                    }
                    case "MSGRECV": {
                        RESPONSE myMusicSettingInformProfileSimpleRes$RESPONSE5 = memberProfileEditFragment0.profileInformRes;
                        if(myMusicSettingInformProfileSimpleRes$RESPONSE5 != null) {
                            myMusicSettingInformProfileSimpleRes$RESPONSE5.msgRecvFlag = s;
                        }
                    }
                }
            }
            j0 j00 = memberProfileEditFragment0.mAdapter;
            if(j00 instanceof MemberProfileEditAdapter) {
                j00.notifyDataSetChanged();
            }
            TimeExpiredCache.getInstance().removeLike(MelonContentUris.Z0.toString());
        }
    }

    private static final void requestOpenYn$lambda$19(VolleyError volleyError0) {
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    private final Deferred requestProfileSettingInformAsync() {
        return BuildersKt__Builders_commonKt.async$default(this, null, null, new n(null) {
            int label;

            {
                MemberProfileEditFragment.this = memberProfileEditFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.mymusic.MemberProfileEditFragment.requestProfileSettingInformAsync.1(MemberProfileEditFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.mymusic.MemberProfileEditFragment.requestProfileSettingInformAsync.1)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                if(this.label != 0) {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
                d5.n.D(object0);
                RequestFuture requestFuture0 = RequestFuture.newFuture();
                HttpResponse httpResponse0 = com.iloen.melon.net.RequestBuilder.newInstance(new MyMusicSettingInformProfileSimpleReq(MemberProfileEditFragment.this.getContext())).tag("MemberProfileEditFragment").listener(requestFuture0).errorListener(requestFuture0).requestSync(requestFuture0);
                q.e(httpResponse0, "null cannot be cast to non-null type com.iloen.melon.net.v6x.response.MyMusicSettingInformProfileSimpleRes");
                return (MyMusicSettingInformProfileSimpleRes)httpResponse0;
            }
        }, 3, null);
    }

    private final void requestSiteChannelUpdateRepnt(String s, int v) {
        com.iloen.melon.net.RequestBuilder.newInstance(new MyMusicSiteChannelUpdateRepntReq(this.getContext(), s, "Y")).tag("MemberProfileEditFragment").listener(new l(this, v)).errorListener(this.mResponseErrorListener).request();
    }

    private static final void requestSiteChannelUpdateRepnt$lambda$16(MemberProfileEditFragment memberProfileEditFragment0, int v, Object object0) {
        if(object0 instanceof MyMusicSiteChannelUpdateRepntRes && ((MyMusicSiteChannelUpdateRepntRes)object0).isSuccessful() && ((MyMusicSiteChannelUpdateRepntRes)object0).response != null) {
            memberProfileEditFragment0.updateToggleBtn(v);
            TimeExpiredCache.getInstance().removeLike(MelonContentUris.Z0.toString());
        }
    }

    private final void setUserProfileImage(Uri uri0) {
        if(q.b(Uri.EMPTY, uri0)) {
            LogU.Companion.e("MemberProfileEditFragment", "setUserProfileImage invalid photo uri");
            return;
        }
        String s = uri0.getPath();
        if(s == null) {
            s = "";
        }
        File file0 = new File(s);
        if(!file0.exists()) {
            LogU.Companion.e("MemberProfileEditFragment", "setUserProfileImage file doesn\'t exist : " + file0);
            return;
        }
        this.showProgress(true);
        com.iloen.melon.net.RequestBuilder.newInstance(new UpdateUserImgReq(this.getContext())).tag(this.getRequestTag()).file("imgFile", file0).listener(new u(this, 3)).errorListener(new u(this, 4)).request();
    }

    private static final void setUserProfileImage$lambda$10(MemberProfileEditFragment memberProfileEditFragment0, UpdateUserImgRes updateUserImgRes0) {
        memberProfileEditFragment0.showProgress(false);
        if(memberProfileEditFragment0.isFragmentValid() && ((updateUserImgRes0 == null ? null : updateUserImgRes0.response) != null && updateUserImgRes0.isSuccessful())) {
            RESPONSE myMusicSettingInformProfileSimpleRes$RESPONSE0 = memberProfileEditFragment0.profileInformRes;
            if(myMusicSettingInformProfileSimpleRes$RESPONSE0 != null) {
                myMusicSettingInformProfileSimpleRes$RESPONSE0.myPageImg = updateUserImgRes0.response.myPageImg;
            }
            String s = updateUserImgRes0.response.myPageImg;
            long v = StringUtils.getLong(updateUserImgRes0.response.sleepTime);
            new Handler(Looper.getMainLooper()).postDelayed(new com.iloen.melon.fragments.mymusic.p(memberProfileEditFragment0, s), v);
        }
    }

    private static final void setUserProfileImage$lambda$10$lambda$9(MemberProfileEditFragment memberProfileEditFragment0, String s) {
        if(memberProfileEditFragment0.isFragmentValid()) {
            BorderImageView borderImageView0 = memberProfileEditFragment0.ivProfileThumb;
            if(borderImageView0 != null) {
                borderImageView0.setImageDrawable(null);
                BorderImageView borderImageView1 = memberProfileEditFragment0.ivProfileThumb;
                if(borderImageView1 != null) {
                    RequestBuilder requestBuilder0 = Glide.with(borderImageView1.getContext()).load(s).apply(RequestOptions.skipMemoryCacheOf(true)).apply(RequestOptions.circleCropTransform());
                    BorderImageView borderImageView2 = memberProfileEditFragment0.ivProfileThumb;
                    if(borderImageView2 != null) {
                        requestBuilder0.into(borderImageView2);
                        return;
                    }
                    q.m("ivProfileThumb");
                    throw null;
                }
                q.m("ivProfileThumb");
                throw null;
            }
            q.m("ivProfileThumb");
            throw null;
        }
    }

    private static final void setUserProfileImage$lambda$11(MemberProfileEditFragment memberProfileEditFragment0, VolleyError volleyError0) {
        memberProfileEditFragment0.showProgress(false);
        ToastManager.show(0x7F1303C6);  // string:error_invalid_server_response "해당 페이지의 접속이 지연되고 있습니다.\n잠시 후 다시 이용해 주세요."
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return false;
    }

    private final void showCleanPopUp() {
        String s;
        com.iloen.melon.fragments.mymusic.MemberProfileEditFragment.showCleanPopUp.dig.1 memberProfileEditFragment$showCleanPopUp$dig$10 = new MelonTextPopup(/*ERROR_MISSING_ARG_0/*) {
            @Override  // com.iloen.melon.popup.MelonBaseButtonPopup
            public void onClick(View view0) {
                if(view0 == this.mLeftButton) {
                    DialogInterface.OnClickListener dialogInterface$OnClickListener0 = this.mPopupListener;
                    if(dialogInterface$OnClickListener0 != null) {
                        dialogInterface$OnClickListener0.onClick(this, -1);
                    }
                    this.dismiss();
                    return;
                }
                if(view0 == this.mRightButton) {
                    DialogInterface.OnClickListener dialogInterface$OnClickListener1 = this.mPopupListener;
                    if(dialogInterface$OnClickListener1 != null) {
                        dialogInterface$OnClickListener1.onClick(this, -2);
                    }
                    this.dismiss();
                }
            }
        };
        int v = q.b((this.profileInformRes == null ? null : this.profileInformRes.blindType), "B") ? 0x7F1308A4 : 0x7F1308A5;  // string:profile_setting_black_list_popup_left_text_b_type "규제 내역 보기"
        memberProfileEditFragment$showCleanPopUp$dig$10.setTitle(this.getString(0x7F1300D0));  // string:alert_dlg_title_info "안내"
        RESPONSE myMusicSettingInformProfileSimpleRes$RESPONSE0 = this.profileInformRes;
        if(myMusicSettingInformProfileSimpleRes$RESPONSE0 == null) {
            s = "";
        }
        else {
            s = myMusicSettingInformProfileSimpleRes$RESPONSE0.blindMsg;
            if(s == null) {
                s = "";
            }
        }
        memberProfileEditFragment$showCleanPopUp$dig$10.setBodyMsg(s);
        memberProfileEditFragment$showCleanPopUp$dig$10.setLeftBtnName(this.getString(v));
        memberProfileEditFragment$showCleanPopUp$dig$10.setRightBtnName(this.getString(0x7F130227));  // string:confirm "확인"
        memberProfileEditFragment$showCleanPopUp$dig$10.setPopupOnClickListener(new m(this, 0));
        memberProfileEditFragment$showCleanPopUp$dig$10.show();
    }

    private static final void showCleanPopUp$lambda$2(MemberProfileEditFragment memberProfileEditFragment0, DialogInterface dialogInterface0, int v) {
        if(v == -1) {
            MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
            melonLinkInfo0.b = memberProfileEditFragment0.profileInformRes == null ? null : memberProfileEditFragment0.profileInformRes.redirectUrl;
            melonLinkInfo0.a = "PA";
            MelonLinkExecutor.open(melonLinkInfo0);
        }
    }

    private final void showInfoPopup(String s, String s1) {
        String s2 = "닫기";
        MelonTextPopup melonTextPopup0 = new MelonTextPopup(this.getActivity(), 1);
        melonTextPopup0.setTitle(s);
        melonTextPopup0.setBodyMsg(s1);
        if(this.getContext() == null) {
            s2 = "";
        }
        melonTextPopup0.setCenterBtnName(s2);
        melonTextPopup0.setPopupOnClickListener(new com.iloen.melon.fragments.mymusic.n());  // 初始化器: Ljava/lang/Object;-><init>()V
        this.infoPopup = melonTextPopup0;
        melonTextPopup0.show();
    }

    private static final void showInfoPopup$lambda$3(DialogInterface dialogInterface0, int v) {
    }

    private final void showSnsChannelPopup(ArrayList arrayList0) {
        if(!this.isPossiblePopupShow()) {
            return;
        }
        ArrayList arrayList1 = new ArrayList();
        String s = this.getString(0x7F13105C);  // string:title_sns_channel_add "SNS 채널 추가"
        q.f(s, "getString(...)");
        arrayList1.add(zd.x.L);
        arrayList1.add(zd.x.M);
        arrayList1.add(zd.x.N);
        arrayList1.add(zd.x.P);
        arrayList1.add(zd.x.O);
        com.melon.ui.popup.b.o(this.getChildFragmentManager(), new z0(s, arrayList1), new com.iloen.melon.fragments.mymusic.o(0, arrayList0, this), 12);
    }

    private static final ie.H showSnsChannelPopup$lambda$8(ArrayList arrayList0, MemberProfileEditFragment memberProfileEditFragment0, k2 k20) {
        int v;
        String s2;
        String s1;
        String s;
        q.g(k20, "clickEvent");
        boolean z = arrayList0 == null || arrayList0.isEmpty();
        Object object0 = null;
        K1 k10 = k20 instanceof K1 ? ((K1)k20) : null;
        ie.H h0 = ie.H.a;
        if(k10 == null) {
            return h0;
        }
        M m0 = k10.b.a;
        if(m0 == zd.x.L.a) {
            s = memberProfileEditFragment0.getString(0x7F1304B2);  // string:instagram "인스타그램"
            s1 = "INSTAGRAM";
        }
        else if(m0 == zd.x.M.a) {
            s = memberProfileEditFragment0.getString(0x7F131104);  // string:x "X"
            s1 = "TWITTER";
        }
        else if(m0 == zd.x.N.a) {
            s = memberProfileEditFragment0.getString(0x7F13042D);  // string:facebook "페이스북"
            s1 = "FACEBOOK";
        }
        else if(m0 == zd.x.P.a) {
            s = memberProfileEditFragment0.getString(0x7F131106);  // string:youtube "Youtube"
            s1 = "YOUTUBE";
        }
        else if(m0 == zd.x.O.a) {
            s = memberProfileEditFragment0.getString(0x7F131037);  // string:tictok "틱톡"
            s1 = "TIKTOK";
        }
        else {
            s = null;
            s1 = null;
        }
        if(arrayList0 == null) {
            s2 = "";
        }
        else {
            for(Object object1: arrayList0) {
                if(q.b(((SnsInfoBase)object1).dtlInfoCode, s1)) {
                    object0 = object1;
                    break;
                }
                if(false) {
                    break;
                }
            }
            if(((SnsInfoBase)object0) == null) {
                s2 = "";
            }
            else {
                s2 = ((SnsInfoBase)object0).dtlInfoVal;
                if(s2 == null) {
                    s2 = "";
                }
            }
        }
        if(z) {
            v = 5;
        }
        else {
            v = s2.length() <= 0 ? 3 : 4;
        }
        Navigator.open(ProfileEditFragment.newInstance(v, s2, s, s1));
        return h0;
    }

    private final void toggleClickLog(String s, String s1, String s2) {
        String s3 = "on";
        String s4 = "";
        if(!"Y".equals(s2)) {
            if(this.getContext() == null) {
                s3 = "";
            }
        }
        else if(this.getContext() == null) {
            s3 = "";
        }
        f f0 = this.getTiaraEventBuilder();
        if(f0 != null) {
            if(this.getContext() != null) {
                s4 = "페이지이동";
            }
            f0.a = s4;
            f0.y = s;
            f0.F = s1;
            f0.V = s3;
            f0.a().track();
        }
    }

    private final void updateToggleBtn(int v) {
        ArrayList arrayList0 = this.snsToggleGroup;
        if(arrayList0 != null) {
            int v1 = 0;
            for(Object object0: arrayList0) {
                if(v1 >= 0) {
                    if(v1 == v) {
                        ((ToggleButton)((View)object0).findViewById(0x7F0A0BBA)).setChecked(true);  // id:toggle_check
                        ((TextView)((View)object0).findViewById(0x7F0A0CFD)).setVisibility(0);  // id:tv_representaion
                    }
                    else {
                        ((ToggleButton)((View)object0).findViewById(0x7F0A0BBA)).setChecked(false);  // id:toggle_check
                        ((TextView)((View)object0).findViewById(0x7F0A0CFD)).setVisibility(4);  // id:tv_representaion
                    }
                    ++v1;
                    continue;
                }
                k.O();
                throw null;
            }
        }
    }
}

