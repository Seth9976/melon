package com.iloen.melon.fragments.artistchannel;

import H0.b;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View.AccessibilityDelegate;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.adapters.common.y;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.AlphaControlCheckButton;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.tablayout.TagLayout;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.fragments.webview.MelonWebViewFullScreenWithBarFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.UserActionsReq.Params;
import com.iloen.melon.net.v4x.request.UserActionsReq;
import com.iloen.melon.net.v4x.response.UserActionsRes.Response;
import com.iloen.melon.net.v4x.response.UserActionsRes;
import com.iloen.melon.net.v6x.request.ArtistDetailInfoReq;
import com.iloen.melon.net.v6x.response.ArtistDetailInfoRes.RESPONSE.AWARDLIST;
import com.iloen.melon.net.v6x.response.ArtistDetailInfoRes.RESPONSE.CREDITINFO;
import com.iloen.melon.net.v6x.response.ArtistDetailInfoRes.RESPONSE.DEBUTSONG;
import com.iloen.melon.net.v6x.response.ArtistDetailInfoRes.RESPONSE.GROUPLIST;
import com.iloen.melon.net.v6x.response.ArtistDetailInfoRes.RESPONSE.MEMBERLIST;
import com.iloen.melon.net.v6x.response.ArtistDetailInfoRes.RESPONSE.SNSLIST;
import com.iloen.melon.net.v6x.response.ArtistDetailInfoRes.RESPONSE.WEEKAWARDLIST;
import com.iloen.melon.net.v6x.response.ArtistDetailInfoRes.RESPONSE;
import com.iloen.melon.net.v6x.response.ArtistDetailInfoRes.RelatedArtistsInfoBase;
import com.iloen.melon.net.v6x.response.ArtistDetailInfoRes;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.task.request.LikeUpdateAsyncTask.OnJobFinishListener;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.AppUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import com.iloen.melon.viewholders.ArtistHolder;
import com.kakao.tiara.data.ActionKind;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000E\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 I2\u00020\u0001:\u0002IJB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0014\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\n\u0010\bJ\u000F\u0010\f\u001A\u00020\u000BH\u0014\u00A2\u0006\u0004\b\f\u0010\rJ-\u0010\u0014\u001A\u0004\u0018\u00010\u00132\u0006\u0010\u000F\u001A\u00020\u000E2\b\u0010\u0011\u001A\u0004\u0018\u00010\u00102\b\u0010\u0012\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0017\u001A\u00020\u00062\u0006\u0010\u0016\u001A\u00020\u00132\b\u0010\u0012\u001A\u0004\u0018\u00010\u0004H\u0016\u00A2\u0006\u0004\b\u0017\u0010\u0018J\u000F\u0010\u001A\u001A\u00020\u0019H\u0016\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\'\u0010!\u001A\u00020\u000B2\u0006\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u001F\u001A\u00020\u001E2\u0006\u0010 \u001A\u00020\u0019H\u0014\u00A2\u0006\u0004\b!\u0010\"J\u001B\u0010&\u001A\u0006\u0012\u0002\b\u00030%2\u0006\u0010$\u001A\u00020#H\u0014\u00A2\u0006\u0004\b&\u0010\'J\u000F\u0010)\u001A\u00020(H\u0014\u00A2\u0006\u0004\b)\u0010*J\u0017\u0010-\u001A\u00020\u000B2\u0006\u0010,\u001A\u00020+H\u0002\u00A2\u0006\u0004\b-\u0010.J\u001F\u00100\u001A\u00020\u00062\u0006\u0010,\u001A\u00020+2\u0006\u0010/\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b0\u00101J\u001F\u00103\u001A\u00020\u00062\u0006\u0010,\u001A\u00020+2\u0006\u00102\u001A\u00020+H\u0002\u00A2\u0006\u0004\b3\u00104J\u0017\u00105\u001A\u00020+2\u0006\u0010,\u001A\u00020+H\u0002\u00A2\u0006\u0004\b5\u00106R\u0018\u00107\u001A\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b7\u00108R\u0018\u00109\u001A\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b9\u00108R\u0014\u0010;\u001A\u00020:8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010>\u001A\u00020=8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010@\u001A\u00020+8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010B\u001A\u00020+8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bB\u0010AR\u0016\u0010C\u001A\u00020+8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bC\u0010AR\u0016\u0010D\u001A\u00020+8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bD\u0010AR\u0014\u0010H\u001A\u00020E8BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\bF\u0010G\u00A8\u0006K"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailDetailInfoFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "Landroid/os/Bundle;", "inState", "Lie/H;", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "", "hasScrolledLine", "()Z", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "getCacheKey", "()Ljava/lang/String;", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "", "relationType", "isExpandState", "(I)Z", "state", "setExpandState", "(IZ)V", "position", "setGroupTitlePosition", "(II)V", "getGroupTitlePosition", "(I)I", "artistId", "Ljava/lang/String;", "artistName", "", "expandStates", "[Z", "", "groupTitlePosition", "[I", "awardListCount", "I", "displayAwardListLimit", "weekAwardCount", "displayWeekAwardLimit", "Lp8/f;", "getTiaraEventBuilder", "()Lp8/f;", "tiaraEventBuilder", "Companion", "DetailInfoAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ArtistDetailDetailInfoFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u000F\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0016\u001A\u00020\u00172\b\u0010\u0018\u001A\u0004\u0018\u00010\u0005H\u0007J\u001A\u0010\u0016\u001A\u00020\u00172\b\u0010\u0018\u001A\u0004\u0018\u00010\u00052\b\u0010\u0019\u001A\u0004\u0018\u00010\u0005R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\f\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\r\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000E\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000F\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0010\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0011\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0012\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0013\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0014\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0015\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailDetailInfoFragment$Companion;", "", "<init>", "()V", "TAG", "", "SNS_LINK_TYPE_HOME", "", "SNS_LINK_TYPE_X", "SNS_LINK_TYPE_FACEBOOK", "SNS_LINK_TYPE_INSTAGRAM", "RELATION_TYPE_AWARD_LIST", "RELATION_TYPE_WEEK_AWARD", "RELATION_TYPE_GROUP", "RELATION_TYPE_COMPANY", "RELATION_TYPE_SIMILAR", "RELATION_LESS_ITEM", "FOLDED_INTRO_MAX_LINE", "DISPLAY_ITEM_MAX_LIMIT", "POSITION_NO_SCROLL", "ARG_ARTIST_ID", "ARG_ARTIST_NAME", "newInstance", "Lcom/iloen/melon/fragments/artistchannel/ArtistDetailDetailInfoFragment;", "artistId", "artistName", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ArtistDetailDetailInfoFragment newInstance(@Nullable String s) {
            ArtistDetailDetailInfoFragment artistDetailDetailInfoFragment0 = new ArtistDetailDetailInfoFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argArtistId", s);
            artistDetailDetailInfoFragment0.setArguments(bundle0);
            return artistDetailDetailInfoFragment0;
        }

        @NotNull
        public final ArtistDetailDetailInfoFragment newInstance(@Nullable String s, @Nullable String s1) {
            ArtistDetailDetailInfoFragment artistDetailDetailInfoFragment0 = new ArtistDetailDetailInfoFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argArtistId", s);
            bundle0.putString("argArtistName", s1);
            artistDetailDetailInfoFragment0.setArguments(bundle0);
            return artistDetailDetailInfoFragment0;
        }
    }

    @Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001B\b\u0082\u0004\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\b:;<=>?@AB!\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0010\u0010\u0007\u001A\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0006\u00A2\u0006\u0004\b\b\u0010\tJ!\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u000B\u001A\u00020\n2\b\b\u0002\u0010\r\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b\u000F\u0010\u0010J3\u0010\u0016\u001A\u00020\u000E2\u001A\u0010\u0014\u001A\u0016\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011j\n\u0012\u0006\b\u0001\u0012\u00020\u0012`\u00132\u0006\u0010\u0015\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001A\u001A\u00020\u000E2\b\u0010\u0019\u001A\u0004\u0018\u00010\u00182\u0006\u0010\r\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b\u001A\u0010\u001BJ\'\u0010\"\u001A\u00020!2\u0006\u0010\u001D\u001A\u00020\u001C2\u0006\u0010\u001F\u001A\u00020\u001E2\u0006\u0010\u000B\u001A\u00020 H\u0014\u00A2\u0006\u0004\b\"\u0010#J\u001F\u0010%\u001A\u00020\f2\u0006\u0010$\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b%\u0010&J!\u0010*\u001A\u0004\u0018\u00010\u00032\u0006\u0010(\u001A\u00020\'2\u0006\u0010)\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b*\u0010+J)\u0010-\u001A\u00020\u000E2\b\u0010,\u001A\u0004\u0018\u00010\u00032\u0006\u0010$\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\fH\u0016\u00A2\u0006\u0004\b-\u0010.R\u0014\u0010/\u001A\u00020\f8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00101\u001A\u00020\f8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b1\u00100R\u0014\u00102\u001A\u00020\f8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b2\u00100R\u0014\u00103\u001A\u00020\f8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b3\u00100R\u0014\u00104\u001A\u00020\f8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b4\u00100R\u0014\u00105\u001A\u00020\f8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b5\u00100R\u0014\u00106\u001A\u00020\f8\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b6\u00100R\u0018\u00107\u001A\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b7\u00108R\u0018\u00109\u001A\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b9\u00108\u00A8\u0006B"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailDetailInfoFragment$DetailInfoAdapter;", "Lcom/iloen/melon/adapters/common/p;", "", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailDetailInfoFragment;Landroid/content/Context;Ljava/util/List;)V", "Lcom/iloen/melon/net/v6x/response/ArtistDetailInfoRes$RESPONSE;", "response", "", "position", "Lie/H;", "updateResponse", "(Lcom/iloen/melon/net/v6x/response/ArtistDetailInfoRes$RESPONSE;I)V", "Ljava/util/ArrayList;", "Lcom/iloen/melon/net/v6x/response/ArtistDetailInfoRes$RelatedArtistsInfoBase;", "Lkotlin/collections/ArrayList;", "itemList", "relationType", "setRelatedArtistList", "(Ljava/util/ArrayList;I)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "requestFocusRecyclerItemView", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "", "key", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "rawPosition", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_DETAIL_INFO_ITEM", "I", "VIEW_TYPE_AWARD_LIST", "VIEW_TYPE_DETAIL_INTRO_ITEM", "VIEW_TYPE_WEEK_AWARD_LIST", "VIEW_TYPE_RELATED_ARTIST_SUBTITLE", "VIEW_TYPE_RELATED_ARTIST_EXPANDABLE_BUTTON", "VIEW_TYPE_RELATED_ARTIST_ITEM", "awardListRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "weekAwardListRecyclerView", "DetailInfoHolder", "IntroHolder", "SubTitleViewHolder", "ExpandableButtonViewHolder", "RelatedArtistHolder", "AwardListHolder", "WeekAwardListHolder", "ServerWrapperData", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class DetailInfoAdapter extends p {
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001:\u0001\rB\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\u000B\u001A\u00020\n2\u001A\u0010\t\u001A\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\b¢\u0006\u0004\b\u000B\u0010\f¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailDetailInfoFragment$DetailInfoAdapter$AwardListHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailDetailInfoFragment$DetailInfoAdapter;Landroid/view/View;)V", "Ljava/util/ArrayList;", "Lcom/iloen/melon/net/v6x/response/ArtistDetailInfoRes$RESPONSE$AWARDLIST;", "Lkotlin/collections/ArrayList;", "awardList", "Lie/H;", "bind", "(Ljava/util/ArrayList;)V", "AwardListAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class AwardListHolder extends O0 {
            @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001BB-\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u001A\u0010\b\u001A\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0002`\u0007¢\u0006\u0004\b\t\u0010\nJ\u001F\u0010\u000F\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\rH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\'\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0011\u001A\u00020\u00032\u0006\u0010\u0012\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\rH\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001C\u0010\u0019\u001A\n \u0018*\u0004\u0018\u00010\u00170\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001A¨\u0006\u001C"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailDetailInfoFragment$DetailInfoAdapter$AwardListHolder$AwardListAdapter;", "Lcom/iloen/melon/adapters/common/y;", "Lcom/iloen/melon/net/v6x/response/ArtistDetailInfoRes$RESPONSE$AWARDLIST;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "list", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailDetailInfoFragment$DetailInfoAdapter$AwardListHolder;Landroid/content/Context;Ljava/util/ArrayList;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "rawPosition", "position", "Lie/H;", "onBindViewHolder", "(Landroidx/recyclerview/widget/O0;II)V", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "mInflater", "Landroid/view/LayoutInflater;", "AwardItemHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            final class AwardListAdapter extends y {
                @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailDetailInfoFragment$DetailInfoAdapter$AwardListHolder$AwardListAdapter$AwardItemHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailDetailInfoFragment$DetailInfoAdapter$AwardListHolder$AwardListAdapter;Landroid/view/View;)V", "Landroid/widget/TextView;", "awardTv", "Landroid/widget/TextView;", "getAwardTv", "()Landroid/widget/TextView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
                final class AwardItemHolder extends O0 {
                    @NotNull
                    private final TextView awardTv;

                    public AwardItemHolder(@NotNull View view0) {
                        q.g(view0, "itemView");
                        AwardListAdapter.this = artistDetailDetailInfoFragment$DetailInfoAdapter$AwardListHolder$AwardListAdapter0;
                        super(view0);
                        View view1 = view0.findViewById(0x7F0A00E3);  // id:award_tv
                        q.f(view1, "findViewById(...)");
                        this.awardTv = (TextView)view1;
                    }

                    @NotNull
                    public final TextView getAwardTv() {
                        return this.awardTv;
                    }
                }

                private final LayoutInflater mInflater;

                public AwardListAdapter(@Nullable Context context0, @NotNull ArrayList arrayList0) {
                    q.g(arrayList0, "list");
                    AwardListHolder.this = artistDetailDetailInfoFragment$DetailInfoAdapter$AwardListHolder0;
                    super(context0, arrayList0);
                    this.mInflater = LayoutInflater.from(context0);
                }

                @Override  // com.iloen.melon.adapters.common.y
                public void onBindViewHolder(@NotNull O0 o00, int v, int v1) {
                    q.g(o00, "viewHolder");
                    AWARDLIST artistDetailInfoRes$RESPONSE$AWARDLIST0 = (AWARDLIST)this.getItem(v1);
                    if(artistDetailInfoRes$RESPONSE$AWARDLIST0 == null) {
                        return;
                    }
                    ((AwardItemHolder)o00).getAwardTv().setText(ArtistDetailDetailInfoFragment.this.getString(0x7F130116, new Object[]{artistDetailInfoRes$RESPONSE$AWARDLIST0.name, artistDetailInfoRes$RESPONSE$AWARDLIST0.priot}));  // string:artist_channel_user_detail_award_history "%1$s %2$s"
                }

                @Override  // androidx.recyclerview.widget.j0
                @NotNull
                public O0 onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
                    q.g(viewGroup0, "parent");
                    View view0 = this.mInflater.inflate(0x7F0D0050, viewGroup0, false);  // layout:artist_info_listitem_award_list
                    q.d(view0);
                    return new AwardItemHolder(this, view0);
                }
            }

            public AwardListHolder(@NotNull View view0) {
                q.g(view0, "view");
                DetailInfoAdapter.this = artistDetailDetailInfoFragment$DetailInfoAdapter0;
                super(view0);
                artistDetailDetailInfoFragment$DetailInfoAdapter0.awardListRecyclerView = (RecyclerView)view0.findViewById(0x7F0A09D1);  // id:recycler_view
                int v = ScreenUtils.dipToPixel(artistDetailDetailInfoFragment$DetailInfoAdapter0.getContext(), (ArtistDetailDetailInfoFragment.this.awardListCount <= 3 ? -2.0f : 4.0f));
                view0.setPadding(view0.getPaddingLeft(), view0.getPaddingTop(), view0.getPaddingRight(), v);
            }

            public final void bind(@NotNull ArrayList arrayList0) {
                q.g(arrayList0, "awardList");
                RecyclerView recyclerView0 = DetailInfoAdapter.this.awardListRecyclerView;
                if(recyclerView0 != null) {
                    recyclerView0.setAdapter(new AwardListAdapter(this, DetailInfoAdapter.this.getContext(), arrayList0));
                }
            }
        }

        @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000F\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\u0006H\u0002\u00A2\u0006\u0004\b\f\u0010\nJ\u0015\u0010\u000F\u001A\u00020\b2\u0006\u0010\u000E\u001A\u00020\r\u00A2\u0006\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0011\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0015\u001A\u00020\u00148\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0017\u0010\u0012R\u0014\u0010\u0018\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0018\u0010\u0012R\u0014\u0010\u0019\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0019\u0010\u0012R\u0014\u0010\u001A\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u001A\u0010\u0012R\u0014\u0010\u001B\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u001B\u0010\u0012R\u0014\u0010\u001C\u001A\u00020\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u001C\u0010\u0012R\u0014\u0010\u001D\u001A\u00020\u00148\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u001D\u0010\u0016R\u0014\u0010\u001F\u001A\u00020\u001E8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u001F\u0010 R\u0014\u0010\"\u001A\u00020!8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010$\u001A\u00020\u001E8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b$\u0010 R\u0014\u0010%\u001A\u00020\u001E8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b%\u0010 R\u0014\u0010&\u001A\u00020\u001E8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b&\u0010 R\u0014\u0010\'\u001A\u00020\u001E8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\'\u0010 R\u0014\u0010(\u001A\u00020\u001E8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b(\u0010 R\u0014\u0010*\u001A\u00020)8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010,\u001A\u00020)8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b,\u0010+R\u0014\u0010-\u001A\u00020)8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b-\u0010+R\u0014\u0010.\u001A\u00020)8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b.\u0010+R\u0014\u0010/\u001A\u00020)8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b/\u0010+R\u0014\u00100\u001A\u00020!8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b0\u0010#R\u0014\u00101\u001A\u00020!8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b1\u0010#R\u0014\u00102\u001A\u00020!8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b2\u0010#R\u0014\u00103\u001A\u00020!8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b3\u0010#R\u0014\u00104\u001A\u00020\u001E8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b4\u0010 R\u0014\u00105\u001A\u00020\u001E8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b5\u0010 R\u0014\u00106\u001A\u00020\u001E8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b6\u0010 R\u0014\u00107\u001A\u00020\u001E8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b7\u0010 \u00A8\u00068"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailDetailInfoFragment$DetailInfoAdapter$DetailInfoHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailDetailInfoFragment$DetailInfoAdapter;Landroid/view/View;)V", "", "url", "Lie/H;", "openSNS", "(Ljava/lang/String;)V", "copy", "trackTiaraSNSOpen", "Lcom/iloen/melon/net/v6x/response/ArtistDetailInfoRes$RESPONSE;", "response", "bind", "(Lcom/iloen/melon/net/v6x/response/ArtistDetailInfoRes$RESPONSE;)V", "layoutUserBasicInfo", "Landroid/view/View;", "layoutMember", "Lcom/iloen/melon/custom/tablayout/TagLayout;", "memberLayout", "Lcom/iloen/melon/custom/tablayout/TagLayout;", "layoutCredit", "layoutDebutDate", "layoutDebutSong", "layoutType", "layoutGenre", "layoutCompany", "tagLayoutCredit", "Landroid/widget/TextView;", "tvDebutDate", "Landroid/widget/TextView;", "Landroid/widget/ImageView;", "ivDebutThumb", "Landroid/widget/ImageView;", "tvDebutSongTitle", "tvDebutSongArtist", "tvArtistActType", "tvArtistGenre", "tvArtistCompany", "Landroid/widget/LinearLayout;", "snsLayout", "Landroid/widget/LinearLayout;", "layoutSnsHome", "layoutSnsTwitter", "layoutSnsFacebook", "layoutSnsInstagram", "ivHomeIcon", "ivTwitterIcon", "ivFacebookIcon", "ivInstaIcon", "tvHome", "tvTwitter", "tvFacebook", "tvInsta", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class DetailInfoHolder extends O0 {
            @NotNull
            private final ImageView ivDebutThumb;
            @NotNull
            private final ImageView ivFacebookIcon;
            @NotNull
            private final ImageView ivHomeIcon;
            @NotNull
            private final ImageView ivInstaIcon;
            @NotNull
            private final ImageView ivTwitterIcon;
            @NotNull
            private final View layoutCompany;
            @NotNull
            private final View layoutCredit;
            @NotNull
            private final View layoutDebutDate;
            @NotNull
            private final View layoutDebutSong;
            @NotNull
            private final View layoutGenre;
            @NotNull
            private final View layoutMember;
            @NotNull
            private final LinearLayout layoutSnsFacebook;
            @NotNull
            private final LinearLayout layoutSnsHome;
            @NotNull
            private final LinearLayout layoutSnsInstagram;
            @NotNull
            private final LinearLayout layoutSnsTwitter;
            @NotNull
            private final View layoutType;
            @NotNull
            private final View layoutUserBasicInfo;
            @NotNull
            private final TagLayout memberLayout;
            @NotNull
            private final LinearLayout snsLayout;
            @NotNull
            private final TagLayout tagLayoutCredit;
            @NotNull
            private final TextView tvArtistActType;
            @NotNull
            private final TextView tvArtistCompany;
            @NotNull
            private final TextView tvArtistGenre;
            @NotNull
            private final TextView tvDebutDate;
            @NotNull
            private final TextView tvDebutSongArtist;
            @NotNull
            private final TextView tvDebutSongTitle;
            @NotNull
            private final TextView tvFacebook;
            @NotNull
            private final TextView tvHome;
            @NotNull
            private final TextView tvInsta;
            @NotNull
            private final TextView tvTwitter;

            public DetailInfoHolder(@NotNull View view0) {
                q.g(view0, "view");
                DetailInfoAdapter.this = artistDetailDetailInfoFragment$DetailInfoAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A06F3);  // id:layoutUserBasicInfo
                q.f(view1, "findViewById(...)");
                this.layoutUserBasicInfo = view1;
                View view2 = view0.findViewById(0x7F0A06E5);  // id:layoutMember
                q.f(view2, "findViewById(...)");
                this.layoutMember = view2;
                View view3 = view0.findViewById(0x7F0A07F6);  // id:memberLayout
                q.f(view3, "findViewById(...)");
                this.memberLayout = (TagLayout)view3;
                View view4 = view0.findViewById(0x7F0A06DB);  // id:layoutCredit
                q.f(view4, "findViewById(...)");
                this.layoutCredit = view4;
                View view5 = view0.findViewById(0x7F0A06DC);  // id:layoutDebutDate
                q.f(view5, "findViewById(...)");
                this.layoutDebutDate = view5;
                View view6 = view0.findViewById(0x7F0A06DD);  // id:layoutDebutSong
                q.f(view6, "findViewById(...)");
                this.layoutDebutSong = view6;
                View view7 = view0.findViewById(0x7F0A06F2);  // id:layoutType
                q.f(view7, "findViewById(...)");
                this.layoutType = view7;
                View view8 = view0.findViewById(0x7F0A06DE);  // id:layoutGenre
                q.f(view8, "findViewById(...)");
                this.layoutGenre = view8;
                View view9 = view0.findViewById(0x7F0A06DA);  // id:layoutCompany
                q.f(view9, "findViewById(...)");
                this.layoutCompany = view9;
                View view10 = view0.findViewById(0x7F0A0B1B);  // id:tagLayoutCredit
                q.f(view10, "findViewById(...)");
                this.tagLayoutCredit = (TagLayout)view10;
                View view11 = view0.findViewById(0x7F0A0BF5);  // id:tvDebutDate
                q.f(view11, "findViewById(...)");
                this.tvDebutDate = (TextView)view11;
                View view12 = view0.findViewById(0x7F0A069A);  // id:iv_thumb
                q.f(view12, "findViewById(...)");
                this.ivDebutThumb = (ImageView)view12;
                View view13 = view0.findViewById(0x7F0A0D34);  // id:tv_title
                q.f(view13, "findViewById(...)");
                this.tvDebutSongTitle = (TextView)view13;
                View view14 = view0.findViewById(0x7F0A0C12);  // id:tv_artist
                q.f(view14, "findViewById(...)");
                this.tvDebutSongArtist = (TextView)view14;
                View view15 = view0.findViewById(0x7F0A0BEE);  // id:tvArtistActType
                q.f(view15, "findViewById(...)");
                this.tvArtistActType = (TextView)view15;
                View view16 = view0.findViewById(0x7F0A0BF0);  // id:tvArtistGenre
                q.f(view16, "findViewById(...)");
                this.tvArtistGenre = (TextView)view16;
                View view17 = view0.findViewById(0x7F0A0BEF);  // id:tvArtistCompany
                q.f(view17, "findViewById(...)");
                this.tvArtistCompany = (TextView)view17;
                View view18 = view0.findViewById(0x7F0A0A9F);  // id:snsLayout
                q.f(view18, "findViewById(...)");
                this.snsLayout = (LinearLayout)view18;
                View view19 = view0.findViewById(0x7F0A06EA);  // id:layoutSnsHome
                q.f(view19, "findViewById(...)");
                this.layoutSnsHome = (LinearLayout)view19;
                View view20 = view0.findViewById(0x7F0A06EC);  // id:layoutSnsTwitter
                q.f(view20, "findViewById(...)");
                this.layoutSnsTwitter = (LinearLayout)view20;
                View view21 = view0.findViewById(0x7F0A06E9);  // id:layoutSnsFacebook
                q.f(view21, "findViewById(...)");
                this.layoutSnsFacebook = (LinearLayout)view21;
                View view22 = view0.findViewById(0x7F0A06EB);  // id:layoutSnsInstagram
                q.f(view22, "findViewById(...)");
                this.layoutSnsInstagram = (LinearLayout)view22;
                View view23 = view0.findViewById(0x7F0A05DB);  // id:ivHomeIcon
                q.f(view23, "findViewById(...)");
                this.ivHomeIcon = (ImageView)view23;
                View view24 = view0.findViewById(0x7F0A05DE);  // id:ivTwitterIcon
                q.f(view24, "findViewById(...)");
                this.ivTwitterIcon = (ImageView)view24;
                View view25 = view0.findViewById(0x7F0A05D9);  // id:ivFacebookIcon
                q.f(view25, "findViewById(...)");
                this.ivFacebookIcon = (ImageView)view25;
                View view26 = view0.findViewById(0x7F0A05DC);  // id:ivInstaIcon
                q.f(view26, "findViewById(...)");
                this.ivInstaIcon = (ImageView)view26;
                View view27 = view0.findViewById(0x7F0A0BF8);  // id:tvHome
                q.f(view27, "findViewById(...)");
                this.tvHome = (TextView)view27;
                View view28 = view0.findViewById(0x7F0A0C02);  // id:tvTwitter
                q.f(view28, "findViewById(...)");
                this.tvTwitter = (TextView)view28;
                View view29 = view0.findViewById(0x7F0A0BF6);  // id:tvFacebook
                q.f(view29, "findViewById(...)");
                this.tvFacebook = (TextView)view29;
                View view30 = view0.findViewById(0x7F0A0BF9);  // id:tvInsta
                q.f(view30, "findViewById(...)");
                this.tvInsta = (TextView)view30;
                ViewUtils.setDefaultImage(((ImageView)view0.findViewById(0x7F0A069E)), ScreenUtils.dipToPixel(artistDetailDetailInfoFragment$DetailInfoAdapter0.getContext(), 48.0f));  // id:iv_thumb_default
            }

            public final void bind(@NotNull RESPONSE artistDetailInfoRes$RESPONSE0) {
                q.g(artistDetailInfoRes$RESPONSE0, "response");
                TitleBar titleBar0 = ArtistDetailDetailInfoFragment.this.getTitleBar();
                if(titleBar0 != null) {
                    titleBar0.setTitle(artistDetailInfoRes$RESPONSE0.artistName);
                }
                if(artistDetailInfoRes$RESPONSE0.debutSong != null) {
                    j j0 = new j(1, artistDetailInfoRes$RESPONSE0, ArtistDetailDetailInfoFragment.this);
                    this.layoutDebutSong.setOnClickListener(j0);
                }
                CREDITINFO artistDetailInfoRes$RESPONSE$CREDITINFO0 = artistDetailInfoRes$RESPONSE0.creditInfo;
                int v = 0;
                this.layoutCredit.setVisibility((artistDetailInfoRes$RESPONSE$CREDITINFO0 == null ? 0 : 8));
                this.layoutDebutDate.setVisibility((artistDetailInfoRes$RESPONSE0.debutDate == null || artistDetailInfoRes$RESPONSE0.debutDate.length() <= 0 ? 8 : 0));
                this.layoutDebutSong.setVisibility((artistDetailInfoRes$RESPONSE0.debutSong == null ? 8 : 0));
                this.layoutGenre.setVisibility((artistDetailInfoRes$RESPONSE0.actGenre == null || artistDetailInfoRes$RESPONSE0.actGenre.length() <= 0 ? 8 : 0));
                this.layoutCompany.setVisibility((artistDetailInfoRes$RESPONSE0.compName == null || artistDetailInfoRes$RESPONSE0.compName.length() <= 0 ? 8 : 0));
                this.layoutType.setVisibility(((artistDetailInfoRes$RESPONSE0.nationality == null || artistDetailInfoRes$RESPONSE0.nationality.length() <= 0) && (artistDetailInfoRes$RESPONSE0.gender == null || artistDetailInfoRes$RESPONSE0.gender.length() <= 0) && (artistDetailInfoRes$RESPONSE0.actType == null || artistDetailInfoRes$RESPONSE0.actType.length() <= 0) ? 8 : 0));
                this.tagLayoutCredit.removeAllViews();
                int v1 = ScreenUtils.dipToPixel(DetailInfoAdapter.this.getContext(), 5.0f);
                this.tagLayoutCredit.setHorizontalSpace(v1);
                int v2 = ScreenUtils.dipToPixel(DetailInfoAdapter.this.getContext(), 3.0f);
                this.tagLayoutCredit.setVerticalSpace(v2);
                boolean z = artistDetailInfoRes$RESPONSE$CREDITINFO0 != null && artistDetailInfoRes$RESPONSE$CREDITINFO0.releaseSongCount > 0;
                boolean z1 = artistDetailInfoRes$RESPONSE$CREDITINFO0 != null && artistDetailInfoRes$RESPONSE$CREDITINFO0.featSongCount > 0;
                boolean z2 = artistDetailInfoRes$RESPONSE$CREDITINFO0 != null && artistDetailInfoRes$RESPONSE$CREDITINFO0.lyricCompoSongCount > 0;
                if(z || z1 || z2) {
                    if(z) {
                        View view2 = LayoutInflater.from(ArtistDetailDetailInfoFragment.this.getActivity()).inflate(0x7F0D004D, null, false);  // layout:artist_info_credit_item
                        View view3 = view2.findViewById(0x7F0A0365);  // id:credit_tv
                        q.f(view3, "findViewById(...)");
                        Object[] arr_object = {StringUtils.getFormattedStringNumber(artistDetailInfoRes$RESPONSE$CREDITINFO0.releaseSongCount)};
                        ((TextView)view3).setText(ArtistDetailDetailInfoFragment.this.getString(0x7F130112, arr_object));  // string:artist_channel_release "발매곡 %1$s"
                        this.tagLayoutCredit.addView(view2);
                    }
                    if(z1) {
                        View view4 = LayoutInflater.from(ArtistDetailDetailInfoFragment.this.getActivity()).inflate(0x7F0D004D, null, false);  // layout:artist_info_credit_item
                        View view5 = view4.findViewById(0x7F0A0365);  // id:credit_tv
                        q.f(view5, "findViewById(...)");
                        Object[] arr_object1 = {StringUtils.getFormattedStringNumber(artistDetailInfoRes$RESPONSE$CREDITINFO0.featSongCount)};
                        ((TextView)view5).setText(ArtistDetailDetailInfoFragment.this.getString(0x7F130103, arr_object1));  // string:artist_channel_feat "참여 %1$s"
                        if(z) {
                            ((TextView)view5).setCompoundDrawablesWithIntrinsicBounds(0x7F080850, 0, 0, 0);  // drawable:shape_circle_gray400s_dark_2dp
                        }
                        this.tagLayoutCredit.addView(view4);
                    }
                    if(z2) {
                        View view6 = LayoutInflater.from(ArtistDetailDetailInfoFragment.this.getActivity()).inflate(0x7F0D004D, null, false);  // layout:artist_info_credit_item
                        View view7 = view6.findViewById(0x7F0A0365);  // id:credit_tv
                        q.f(view7, "findViewById(...)");
                        Object[] arr_object2 = {StringUtils.getFormattedStringNumber(artistDetailInfoRes$RESPONSE$CREDITINFO0.lyricCompoSongCount)};
                        ((TextView)view7).setText(ArtistDetailDetailInfoFragment.this.getString(0x7F13010C, arr_object2));  // string:artist_channel_lyric_compose "작사/작곡 %1$s"
                        if(z || z1) {
                            ((TextView)view7).setCompoundDrawablesWithIntrinsicBounds(0x7F080850, 0, 0, 0);  // drawable:shape_circle_gray400s_dark_2dp
                        }
                        this.tagLayoutCredit.addView(view6);
                    }
                }
                else {
                    View view0 = LayoutInflater.from(ArtistDetailDetailInfoFragment.this.getActivity()).inflate(0x7F0D004D, null, false);  // layout:artist_info_credit_item
                    View view1 = view0.findViewById(0x7F0A0365);  // id:credit_tv
                    q.f(view1, "findViewById(...)");
                    ((TextView)view1).setText(ArtistDetailDetailInfoFragment.this.getString(0x7F130A6A));  // string:song_detail_extra_dash "-"
                    this.tagLayoutCredit.addView(view0);
                }
                this.tvDebutDate.setText(artistDetailInfoRes$RESPONSE0.debutDate);
                this.tvArtistGenre.setText(artistDetailInfoRes$RESPONSE0.actGenre);
                this.tvArtistCompany.setText(artistDetailInfoRes$RESPONSE0.compName);
                StringBuilder stringBuilder0 = new StringBuilder();
                if(artistDetailInfoRes$RESPONSE0.nationality != null && artistDetailInfoRes$RESPONSE0.nationality.length() > 0) {
                    stringBuilder0.append(artistDetailInfoRes$RESPONSE0.nationality);
                }
                if(artistDetailInfoRes$RESPONSE0.gender != null && artistDetailInfoRes$RESPONSE0.gender.length() > 0) {
                    if(stringBuilder0.length() > 0) {
                        stringBuilder0.append("/");
                    }
                    stringBuilder0.append(artistDetailInfoRes$RESPONSE0.gender);
                }
                if(artistDetailInfoRes$RESPONSE0.actType != null && artistDetailInfoRes$RESPONSE0.actType.length() > 0) {
                    if(stringBuilder0.length() > 0) {
                        stringBuilder0.append("/");
                    }
                    stringBuilder0.append(artistDetailInfoRes$RESPONSE0.actType);
                }
                this.tvArtistActType.setText(stringBuilder0.toString());
                DEBUTSONG artistDetailInfoRes$RESPONSE$DEBUTSONG0 = artistDetailInfoRes$RESPONSE0.debutSong;
                if(artistDetailInfoRes$RESPONSE$DEBUTSONG0 != null) {
                    this.tvDebutSongTitle.setText(artistDetailInfoRes$RESPONSE$DEBUTSONG0.songName);
                    String s = ProtocolUtils.getArtistNames(artistDetailInfoRes$RESPONSE$DEBUTSONG0.artistList);
                    this.tvDebutSongArtist.setText(s);
                    Glide.with(DetailInfoAdapter.this.getContext()).load(artistDetailInfoRes$RESPONSE$DEBUTSONG0.albumImg).into(this.ivDebutThumb);
                    Object[] arr_object3 = {this.tvDebutSongTitle.getText(), this.tvDebutSongArtist.getText()};
                    String s1 = ArtistDetailDetailInfoFragment.this.getString(0x7F130B0A, arr_object3);  // string:talkback_debut_song_play "데뷔곡, %1$s, 아티스트 : %2$s, 곡 재생하기"
                    ViewUtils.setContentDescriptionWithButtonClassName(this.layoutDebutSong, s1);
                }
                this.memberLayout.removeAllViews();
                int v3 = ScreenUtils.dipToPixel(this.memberLayout.getContext(), 14.0f);
                this.memberLayout.setHorizontalSpace(v3);
                int v4 = ScreenUtils.dipToPixel(this.memberLayout.getContext(), 11.0f);
                this.memberLayout.setVerticalSpace(v4);
                ArrayList arrayList0 = artistDetailInfoRes$RESPONSE0.memberList;
                if(arrayList0 != null) {
                    int v5 = arrayList0.size();
                    for(int v6 = 0; v6 < v5; ++v6) {
                        MEMBERLIST artistDetailInfoRes$RESPONSE$MEMBERLIST0 = (MEMBERLIST)artistDetailInfoRes$RESPONSE0.memberList.get(v6);
                        String s2 = artistDetailInfoRes$RESPONSE$MEMBERLIST0 == null ? null : artistDetailInfoRes$RESPONSE$MEMBERLIST0.getArtistName();
                        if(s2 != null && s2.length() != 0) {
                            View view8 = LayoutInflater.from(ArtistDetailDetailInfoFragment.this.getActivity()).inflate(0x7F0D0052, null, false);  // layout:artist_info_member_tag
                            View view9 = view8.findViewById(0x7F0A0B34);  // id:tag_tv
                            q.e(view9, "null cannot be cast to non-null type android.widget.TextView");
                            ((TextView)view9).setText(artistDetailInfoRes$RESPONSE$MEMBERLIST0.getArtistName());
                            view8.setOnClickListener(new l(ArtistDetailDetailInfoFragment.this, artistDetailInfoRes$RESPONSE$MEMBERLIST0, v6 + 1));
                            this.memberLayout.addView(view8);
                        }
                    }
                }
                this.layoutMember.setVisibility((arrayList0 == null ? 0 : 8));
                String s3 = ArtistDetailDetailInfoFragment.this.getString(0x7F130BA5);  // string:talkback_no_link ", 링크 없음"
                q.f(s3, "getString(...)");
                String s4 = ArtistDetailDetailInfoFragment.this.getString(0x7F130BA5);  // string:talkback_no_link ", 링크 없음"
                q.f(s4, "getString(...)");
                String s5 = ArtistDetailDetailInfoFragment.this.getString(0x7F130BA5);  // string:talkback_no_link ", 링크 없음"
                q.f(s5, "getString(...)");
                String s6 = ArtistDetailDetailInfoFragment.this.getString(0x7F130BA5);  // string:talkback_no_link ", 링크 없음"
                q.f(s6, "getString(...)");
                this.layoutSnsHome.setEnabled(false);
                this.layoutSnsTwitter.setEnabled(false);
                this.layoutSnsFacebook.setEnabled(false);
                this.layoutSnsInstagram.setEnabled(false);
                ArrayList arrayList1 = artistDetailInfoRes$RESPONSE0.snsList;
                if(arrayList1 != null && !arrayList1.isEmpty() == 1) {
                    this.snsLayout.setVisibility(0);
                    Iterator iterator0 = arrayList1.iterator();
                    q.f(iterator0, "iterator(...)");
                    while(iterator0.hasNext()) {
                        Object object0 = iterator0.next();
                        SNSLIST artistDetailInfoRes$RESPONSE$SNSLIST0 = (SNSLIST)object0;
                        int v7 = ProtocolUtils.parseInt(artistDetailInfoRes$RESPONSE$SNSLIST0.type, -1);
                        if(v7 >= 0 && (artistDetailInfoRes$RESPONSE$SNSLIST0.url != null && artistDetailInfoRes$RESPONSE$SNSLIST0.url.length() != 0)) {
                            switch(v7) {
                                case 0: {
                                    this.ivHomeIcon.setImageResource(0x7F0803F1);  // drawable:ic_common_home_16
                                    int v8 = ColorUtils.getColor(DetailInfoAdapter.this.getContext(), 0x7F06016D);  // color:gray900s
                                    this.tvHome.setTextColor(v8);
                                    this.layoutSnsHome.setTag(artistDetailInfoRes$RESPONSE$SNSLIST0.url);
                                    this.layoutSnsHome.setEnabled(true);
                                    s3 = ArtistDetailDetailInfoFragment.this.getString(0x7F130B8D);  // string:talkback_move_app ", 앱으로 이동"
                                    q.f(s3, "getString(...)");
                                    break;
                                }
                                case 1: {
                                    this.ivTwitterIcon.setImageResource(0x7F0805FE);  // drawable:ic_x_16
                                    int v9 = ColorUtils.getColor(DetailInfoAdapter.this.getContext(), 0x7F06016D);  // color:gray900s
                                    this.tvTwitter.setTextColor(v9);
                                    this.layoutSnsTwitter.setTag(artistDetailInfoRes$RESPONSE$SNSLIST0.url);
                                    this.layoutSnsTwitter.setEnabled(true);
                                    s4 = ArtistDetailDetailInfoFragment.this.getString(0x7F130B8D);  // string:talkback_move_app ", 앱으로 이동"
                                    q.f(s4, "getString(...)");
                                    break;
                                }
                                case 2: {
                                    this.ivFacebookIcon.setImageResource(0x7F0803EA);  // drawable:ic_common_facebook_16
                                    int v10 = ColorUtils.getColor(DetailInfoAdapter.this.getContext(), 0x7F06016D);  // color:gray900s
                                    this.tvFacebook.setTextColor(v10);
                                    this.layoutSnsFacebook.setTag(artistDetailInfoRes$RESPONSE$SNSLIST0.url);
                                    this.layoutSnsFacebook.setEnabled(true);
                                    s5 = ArtistDetailDetailInfoFragment.this.getString(0x7F130B8D);  // string:talkback_move_app ", 앱으로 이동"
                                    q.f(s5, "getString(...)");
                                    break;
                                }
                                case 3: {
                                    this.ivInstaIcon.setImageResource(0x7F0803F5);  // drawable:ic_common_instagram_16
                                    int v11 = ColorUtils.getColor(DetailInfoAdapter.this.getContext(), 0x7F06016D);  // color:gray900s
                                    this.tvInsta.setTextColor(v11);
                                    this.layoutSnsInstagram.setTag(artistDetailInfoRes$RESPONSE$SNSLIST0.url);
                                    this.layoutSnsInstagram.setEnabled(true);
                                    s6 = ArtistDetailDetailInfoFragment.this.getString(0x7F130B8D);  // string:talkback_move_app ", 앱으로 이동"
                                    q.f(s6, "getString(...)");
                                }
                            }
                        }
                    }
                    m m0 = new m(this, ArtistDetailDetailInfoFragment.this, 0);
                    this.layoutSnsHome.setOnClickListener(m0);
                    m m1 = new m(this, ArtistDetailDetailInfoFragment.this, 1);
                    this.layoutSnsTwitter.setOnClickListener(m1);
                    m m2 = new m(this, ArtistDetailDetailInfoFragment.this, 2);
                    this.layoutSnsFacebook.setOnClickListener(m2);
                    m m3 = new m(this, ArtistDetailDetailInfoFragment.this, 3);
                    this.layoutSnsInstagram.setOnClickListener(m3);
                    String s7 = ArtistDetailDetailInfoFragment.this.getString(0x7F130110);  // string:artist_channel_official_site "공식 사이트"
                    ViewUtils.setContentDescriptionWithButtonClassName(this.layoutSnsHome, s7 + " " + s3);
                    String s8 = ArtistDetailDetailInfoFragment.this.getString(0x7F131104);  // string:x "X"
                    ViewUtils.setContentDescriptionWithButtonClassName(this.layoutSnsTwitter, s8 + " " + s4);
                    String s9 = ArtistDetailDetailInfoFragment.this.getString(0x7F13042D);  // string:facebook "페이스북"
                    ViewUtils.setContentDescriptionWithButtonClassName(this.layoutSnsFacebook, s9 + " " + s5);
                    String s10 = ArtistDetailDetailInfoFragment.this.getString(0x7F1304B2);  // string:instagram "인스타그램"
                    ViewUtils.setContentDescriptionWithButtonClassName(this.layoutSnsInstagram, s10 + " " + s6);
                }
                boolean z3 = artistDetailInfoRes$RESPONSE0.awardList != null && !artistDetailInfoRes$RESPONSE0.awardList.isEmpty() == 1;
                ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.layoutUserBasicInfo.getLayoutParams();
                q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                if(!z3) {
                    Context context0 = DetailInfoAdapter.this.getContext();
                    if(context0 != null) {
                        Resources resources0 = context0.getResources();
                        if(resources0 != null) {
                            v = (int)resources0.getDimension(0x7F070053);  // dimen:artist_detail_viewholder_spacing
                        }
                    }
                }
                ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).bottomMargin = v;
            }

            private static final void bind$lambda$0(RESPONSE artistDetailInfoRes$RESPONSE0, ArtistDetailDetailInfoFragment artistDetailDetailInfoFragment0, View view0) {
                DEBUTSONG artistDetailInfoRes$RESPONSE$DEBUTSONG0 = artistDetailInfoRes$RESPONSE0.debutSong;
                if(artistDetailInfoRes$RESPONSE$DEBUTSONG0 != null) {
                    artistDetailDetailInfoFragment0.playSong(Playable.from(artistDetailInfoRes$RESPONSE$DEBUTSONG0, artistDetailInfoRes$RESPONSE0.menuId, null), true);
                    if(artistDetailDetailInfoFragment0.mMelonTiaraProperty != null) {
                        f f0 = artistDetailDetailInfoFragment0.getTiaraEventBuilder();
                        f0.a = artistDetailDetailInfoFragment0.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
                        f0.d = ActionKind.PlayMusic;
                        f0.y = artistDetailDetailInfoFragment0.getString(0x7F130CD4);  // string:tiara_artist_detail_info_debut_song "데뷔곡"
                        f0.F = artistDetailDetailInfoFragment0.getString(0x7F130CD4);  // string:tiara_artist_detail_info_debut_song "데뷔곡"
                        f0.e = artistDetailInfoRes$RESPONSE$DEBUTSONG0.songId;
                        f0.f = Y.i(ContsTypeCode.SONG, "code(...)");
                        f0.g = artistDetailInfoRes$RESPONSE$DEBUTSONG0.songName;
                        f0.a().track();
                    }
                }
            }

            private static final void bind$lambda$3(ArtistDetailDetailInfoFragment artistDetailDetailInfoFragment0, MEMBERLIST artistDetailInfoRes$RESPONSE$MEMBERLIST0, int v, View view0) {
                artistDetailDetailInfoFragment0.showArtistInfoPage(artistDetailInfoRes$RESPONSE$MEMBERLIST0.getArtistId());
                if(artistDetailDetailInfoFragment0.mMelonTiaraProperty != null) {
                    f f0 = artistDetailDetailInfoFragment0.getTiaraEventBuilder();
                    f0.a = artistDetailDetailInfoFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                    f0.d = ActionKind.ClickContent;
                    f0.y = artistDetailDetailInfoFragment0.getString(0x7F130CD7);  // string:tiara_artist_detail_info_member "멤버"
                    f0.F = artistDetailDetailInfoFragment0.getString(0x7F130CD7);  // string:tiara_artist_detail_info_member "멤버"
                    f0.C = String.valueOf(v);
                    f0.a().track();
                }
            }

            private static final void bind$lambda$4(DetailInfoHolder artistDetailDetailInfoFragment$DetailInfoAdapter$DetailInfoHolder0, ArtistDetailDetailInfoFragment artistDetailDetailInfoFragment0, View view0) {
                q.g(view0, "v");
                Object object0 = view0.getTag();
                q.e(object0, "null cannot be cast to non-null type kotlin.String");
                artistDetailDetailInfoFragment$DetailInfoAdapter$DetailInfoHolder0.openSNS(((String)object0));
                String s = artistDetailDetailInfoFragment0.getString(0x7F130CD2);  // string:tiara_artist_detail_info_copy_official_site "공식사이트"
                q.f(s, "getString(...)");
                artistDetailDetailInfoFragment$DetailInfoAdapter$DetailInfoHolder0.trackTiaraSNSOpen(s);
            }

            private static final void bind$lambda$5(DetailInfoHolder artistDetailDetailInfoFragment$DetailInfoAdapter$DetailInfoHolder0, ArtistDetailDetailInfoFragment artistDetailDetailInfoFragment0, View view0) {
                q.g(view0, "v");
                Object object0 = view0.getTag();
                q.e(object0, "null cannot be cast to non-null type kotlin.String");
                artistDetailDetailInfoFragment$DetailInfoAdapter$DetailInfoHolder0.openSNS(((String)object0));
                String s = artistDetailDetailInfoFragment0.getString(0x7F130CD3);  // string:tiara_artist_detail_info_copy_twitter "트위터"
                q.f(s, "getString(...)");
                artistDetailDetailInfoFragment$DetailInfoAdapter$DetailInfoHolder0.trackTiaraSNSOpen(s);
            }

            private static final void bind$lambda$6(DetailInfoHolder artistDetailDetailInfoFragment$DetailInfoAdapter$DetailInfoHolder0, ArtistDetailDetailInfoFragment artistDetailDetailInfoFragment0, View view0) {
                q.g(view0, "v");
                Object object0 = view0.getTag();
                q.e(object0, "null cannot be cast to non-null type kotlin.String");
                artistDetailDetailInfoFragment$DetailInfoAdapter$DetailInfoHolder0.openSNS(((String)object0));
                String s = artistDetailDetailInfoFragment0.getString(0x7F130CD0);  // string:tiara_artist_detail_info_copy_facebook "페이스북"
                q.f(s, "getString(...)");
                artistDetailDetailInfoFragment$DetailInfoAdapter$DetailInfoHolder0.trackTiaraSNSOpen(s);
            }

            private static final void bind$lambda$7(DetailInfoHolder artistDetailDetailInfoFragment$DetailInfoAdapter$DetailInfoHolder0, ArtistDetailDetailInfoFragment artistDetailDetailInfoFragment0, View view0) {
                q.g(view0, "v");
                Object object0 = view0.getTag();
                q.e(object0, "null cannot be cast to non-null type kotlin.String");
                artistDetailDetailInfoFragment$DetailInfoAdapter$DetailInfoHolder0.openSNS(((String)object0));
                String s = artistDetailDetailInfoFragment0.getString(0x7F130CD1);  // string:tiara_artist_detail_info_copy_instagram "인스타그램"
                q.f(s, "getString(...)");
                artistDetailDetailInfoFragment$DetailInfoAdapter$DetailInfoHolder0.trackTiaraSNSOpen(s);
            }

            private final void openSNS(String s) {
                LogU.Companion.d("ArtistDetailDetailInfoFragment", "BasicInfoHolder.openSNS() >> url: " + s);
                if(s.length() == 0) {
                    return;
                }
                try {
                    Intent intent0 = new Intent("android.intent.action.VIEW", Uri.parse(s));
                    ArtistDetailDetailInfoFragment.this.startActivity(intent0);
                }
                catch(Exception exception0) {
                    LogU.Companion.e("ArtistDetailDetailInfoFragment", "BasicInfoHolder.openSNS() Go SNS Page >> Err: " + exception0);
                }
            }

            private final void trackTiaraSNSOpen(String s) {
                f f0 = ArtistDetailDetailInfoFragment.this.getTiaraEventBuilder();
                f0.a = ArtistDetailDetailInfoFragment.this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                f0.y = ArtistDetailDetailInfoFragment.this.getString(0x7F130CD6);  // string:tiara_artist_detail_info_layer1_sns "SNS"
                f0.F = s;
                f0.a().track();
            }
        }

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001D\u0010\n\u001A\u00020\t2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\b\u001A\u00020\u0006¢\u0006\u0004\b\n\u0010\u000BR\u0014\u0010\f\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000F\u001A\u00020\u000E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0012\u001A\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailDetailInfoFragment$DetailInfoAdapter$ExpandableButtonViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailDetailInfoFragment$DetailInfoAdapter;Landroid/view/View;)V", "", "relationType", "position", "Lie/H;", "bind", "(II)V", "expandLayout", "Landroid/view/View;", "Landroid/widget/TextView;", "expandTv", "Landroid/widget/TextView;", "Lcom/iloen/melon/custom/AlphaControlCheckButton;", "expandableButton", "Lcom/iloen/melon/custom/AlphaControlCheckButton;", "bottomLine", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class ExpandableButtonViewHolder extends O0 {
            @NotNull
            private final View bottomLine;
            @NotNull
            private final View expandLayout;
            @NotNull
            private final TextView expandTv;
            @NotNull
            private final AlphaControlCheckButton expandableButton;

            public ExpandableButtonViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                DetailInfoAdapter.this = artistDetailDetailInfoFragment$DetailInfoAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0476);  // id:expand_layout
                q.f(view1, "findViewById(...)");
                this.expandLayout = view1;
                View view2 = view0.findViewById(0x7F0A0478);  // id:expand_tv
                q.f(view2, "findViewById(...)");
                this.expandTv = (TextView)view2;
                View view3 = view0.findViewById(0x7F0A0473);  // id:expand_btn
                q.f(view3, "findViewById(...)");
                this.expandableButton = (AlphaControlCheckButton)view3;
                View view4 = view0.findViewById(0x7F0A011F);  // id:bottom_line
                q.f(view4, "findViewById(...)");
                this.bottomLine = view4;
            }

            public final void bind(int v, int v1) {
                int v2 = 0x7F1306AE;  // string:more_title "더보기"
                switch(v) {
                    case 0: {
                        this.expandLayout.setVisibility(0);
                        this.bottomLine.setVisibility(0);
                        boolean z1 = ArtistDetailDetailInfoFragment.this.isExpandState(0);
                        TextView textView1 = this.expandTv;
                        ArtistDetailDetailInfoFragment artistDetailDetailInfoFragment1 = ArtistDetailDetailInfoFragment.this;
                        if(z1) {
                            v2 = 0x7F130104;  // string:artist_channel_fold "접기"
                        }
                        textView1.setText(artistDetailDetailInfoFragment1.getString(v2));
                        this.expandableButton.setChecked(z1);
                        n n0 = new n(DetailInfoAdapter.this, z1, ArtistDetailDetailInfoFragment.this, 0);
                        this.itemView.setOnClickListener(n0);
                        return;
                    }
                    case 1: {
                        this.expandLayout.setVisibility(0);
                        this.bottomLine.setVisibility(0);
                        boolean z2 = ArtistDetailDetailInfoFragment.this.isExpandState(1);
                        TextView textView2 = this.expandTv;
                        ArtistDetailDetailInfoFragment artistDetailDetailInfoFragment2 = ArtistDetailDetailInfoFragment.this;
                        if(z2) {
                            v2 = 0x7F130104;  // string:artist_channel_fold "접기"
                        }
                        textView2.setText(artistDetailDetailInfoFragment2.getString(v2));
                        this.expandableButton.setChecked(z2);
                        n n1 = new n(DetailInfoAdapter.this, z2, ArtistDetailDetailInfoFragment.this, 1);
                        this.itemView.setOnClickListener(n1);
                        return;
                    }
                    case 5: {
                        this.expandLayout.setVisibility(8);
                        this.bottomLine.setVisibility(8);
                        this.itemView.setOnClickListener(null);
                        return;
                    }
                    default: {
                        this.expandLayout.setVisibility(0);
                        this.bottomLine.setVisibility(0);
                        boolean z = ArtistDetailDetailInfoFragment.this.isExpandState(v);
                        TextView textView0 = this.expandTv;
                        ArtistDetailDetailInfoFragment artistDetailDetailInfoFragment0 = ArtistDetailDetailInfoFragment.this;
                        if(z) {
                            v2 = 0x7F130104;  // string:artist_channel_fold "접기"
                        }
                        textView0.setText(artistDetailDetailInfoFragment0.getString(v2));
                        this.expandableButton.setChecked(z);
                        o o0 = new o(DetailInfoAdapter.this, ArtistDetailDetailInfoFragment.this, v, z, v1);
                        this.itemView.setOnClickListener(o0);
                    }
                }
            }

            private static final void bind$lambda$0(DetailInfoAdapter artistDetailDetailInfoFragment$DetailInfoAdapter0, boolean z, ArtistDetailDetailInfoFragment artistDetailDetailInfoFragment0, View view0) {
                HttpResponse httpResponse0 = artistDetailDetailInfoFragment$DetailInfoAdapter0.getResponse();
                ArtistDetailInfoRes artistDetailInfoRes0 = httpResponse0 instanceof ArtistDetailInfoRes ? ((ArtistDetailInfoRes)httpResponse0) : null;
                if(artistDetailInfoRes0 != null) {
                    RESPONSE artistDetailInfoRes$RESPONSE0 = artistDetailInfoRes0.response;
                    if(artistDetailInfoRes$RESPONSE0 != null) {
                        if(z) {
                            artistDetailDetailInfoFragment0.displayAwardListLimit = 3;
                            artistDetailDetailInfoFragment0.setExpandState(0, false);
                            artistDetailDetailInfoFragment$DetailInfoAdapter0.updateResponse(artistDetailInfoRes$RESPONSE0, artistDetailDetailInfoFragment0.getGroupTitlePosition(0));
                            return;
                        }
                        int v = artistDetailDetailInfoFragment0.displayAwardListLimit;
                        artistDetailDetailInfoFragment0.displayAwardListLimit = artistDetailDetailInfoFragment0.awardListCount;
                        artistDetailDetailInfoFragment0.setExpandState(0, true);
                        artistDetailDetailInfoFragment$DetailInfoAdapter0.updateResponse(artistDetailInfoRes$RESPONSE0, -1);
                        if(AppUtils.isAccessibilityTalkbackOn()) {
                            artistDetailDetailInfoFragment$DetailInfoAdapter0.requestFocusRecyclerItemView(artistDetailDetailInfoFragment$DetailInfoAdapter0.awardListRecyclerView, v);
                        }
                    }
                }
            }

            private static final void bind$lambda$1(DetailInfoAdapter artistDetailDetailInfoFragment$DetailInfoAdapter0, boolean z, ArtistDetailDetailInfoFragment artistDetailDetailInfoFragment0, View view0) {
                HttpResponse httpResponse0 = artistDetailDetailInfoFragment$DetailInfoAdapter0.getResponse();
                ArtistDetailInfoRes artistDetailInfoRes0 = httpResponse0 instanceof ArtistDetailInfoRes ? ((ArtistDetailInfoRes)httpResponse0) : null;
                if(artistDetailInfoRes0 != null) {
                    RESPONSE artistDetailInfoRes$RESPONSE0 = artistDetailInfoRes0.response;
                    if(artistDetailInfoRes$RESPONSE0 != null) {
                        if(z) {
                            artistDetailDetailInfoFragment0.displayWeekAwardLimit = 3;
                            artistDetailDetailInfoFragment0.setExpandState(1, false);
                            artistDetailDetailInfoFragment$DetailInfoAdapter0.updateResponse(artistDetailInfoRes$RESPONSE0, artistDetailDetailInfoFragment0.getGroupTitlePosition(1));
                            return;
                        }
                        int v = artistDetailDetailInfoFragment0.displayWeekAwardLimit;
                        artistDetailDetailInfoFragment0.displayWeekAwardLimit = artistDetailDetailInfoFragment0.weekAwardCount;
                        artistDetailDetailInfoFragment0.setExpandState(1, true);
                        artistDetailDetailInfoFragment$DetailInfoAdapter0.updateResponse(artistDetailInfoRes$RESPONSE0, -1);
                        if(AppUtils.isAccessibilityTalkbackOn()) {
                            artistDetailDetailInfoFragment$DetailInfoAdapter0.requestFocusRecyclerItemView(artistDetailDetailInfoFragment$DetailInfoAdapter0.weekAwardListRecyclerView, v);
                        }
                    }
                }
            }

            private static final void bind$lambda$2(DetailInfoAdapter artistDetailDetailInfoFragment$DetailInfoAdapter0, ArtistDetailDetailInfoFragment artistDetailDetailInfoFragment0, int v, boolean z, int v1, View view0) {
                HttpResponse httpResponse0 = artistDetailDetailInfoFragment$DetailInfoAdapter0.getResponse();
                ArtistDetailInfoRes artistDetailInfoRes0 = httpResponse0 instanceof ArtistDetailInfoRes ? ((ArtistDetailInfoRes)httpResponse0) : null;
                if(artistDetailInfoRes0 != null) {
                    RESPONSE artistDetailInfoRes$RESPONSE0 = artistDetailInfoRes0.response;
                    if(artistDetailInfoRes$RESPONSE0 != null) {
                        artistDetailDetailInfoFragment0.setExpandState(v, !z);
                        if(z) {
                            artistDetailDetailInfoFragment$DetailInfoAdapter0.updateResponse(artistDetailInfoRes$RESPONSE0, artistDetailDetailInfoFragment0.getGroupTitlePosition(v));
                            return;
                        }
                        artistDetailDetailInfoFragment$DetailInfoAdapter0.updateResponse(artistDetailInfoRes$RESPONSE0, -1);
                        if(AppUtils.isAccessibilityTalkbackOn()) {
                            artistDetailDetailInfoFragment$DetailInfoAdapter0.requestFocusRecyclerItemView(artistDetailDetailInfoFragment0.mRecyclerView, v1);
                        }
                    }
                }
            }
        }

        @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\u000B\u001A\u00020\bH\u0002¢\u0006\u0004\b\u000B\u0010\fJ\u001D\u0010\u0011\u001A\u00020\b2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\u000F¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001A\u00020\u000F8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001A\u00020\u000F8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0016\u001A\u00020\u000F8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0017\u001A\u00020\u000F8\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0017\u0010\u0014R\u0016\u0010\u0018\u001A\u00020\u000F8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u0016\u0010\u001A\u001A\u00020\u00198\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001A\u0010\u001BR\u0014\u0010\u001D\u001A\u00020\u001C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001D\u0010\u001ER\u0014\u0010 \u001A\u00020\u001F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010#\u001A\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010%\u001A\u00020\u001F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010!R\u0014\u0010&\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010\'R\u0014\u0010(\u001A\u00020\u001F8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010!¨\u0006)"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailDetailInfoFragment$DetailInfoAdapter$IntroHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailDetailInfoFragment$DetailInfoAdapter;Landroid/view/View;)V", "", "introduceText", "Lie/H;", "checkNUpdateIntroLayout", "(Ljava/lang/String;)V", "updateIntroduceLayout", "()V", "Lcom/iloen/melon/net/v6x/response/ArtistDetailInfoRes$RESPONSE;", "response", "", "position", "bind", "(Lcom/iloen/melon/net/v6x/response/ArtistDetailInfoRes$RESPONSE;I)V", "LAYOUT_STATE_NONE", "I", "LAYOUT_STATE_NORMAL", "LAYOUT_STATE_CLOSED", "LAYOUT_STATE_OPENED", "introduceLayoutState", "", "hasWikiInfo", "Z", "Landroid/widget/LinearLayout;", "layoutIntroduceExpandButton", "Landroid/widget/LinearLayout;", "Landroid/widget/TextView;", "tvIntroduceExpand", "Landroid/widget/TextView;", "Lcom/iloen/melon/custom/AlphaControlCheckButton;", "accbIntroduceExpand", "Lcom/iloen/melon/custom/AlphaControlCheckButton;", "tvArtistIntroduce", "tvArtistIntroduceWikiButton", "Landroid/view/View;", "tvArtistIntroduceLicense", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class IntroHolder extends O0 {
            private final int LAYOUT_STATE_CLOSED;
            private final int LAYOUT_STATE_NONE;
            private final int LAYOUT_STATE_NORMAL;
            private final int LAYOUT_STATE_OPENED;
            @NotNull
            private final AlphaControlCheckButton accbIntroduceExpand;
            private boolean hasWikiInfo;
            private int introduceLayoutState;
            @NotNull
            private final LinearLayout layoutIntroduceExpandButton;
            @NotNull
            private final TextView tvArtistIntroduce;
            @NotNull
            private final TextView tvArtistIntroduceLicense;
            @NotNull
            private final View tvArtistIntroduceWikiButton;
            @NotNull
            private final TextView tvIntroduceExpand;

            public IntroHolder(@NotNull View view0) {
                q.g(view0, "view");
                DetailInfoAdapter.this = artistDetailDetailInfoFragment$DetailInfoAdapter0;
                super(view0);
                this.LAYOUT_STATE_NONE = -1;
                this.LAYOUT_STATE_CLOSED = 1;
                this.LAYOUT_STATE_OPENED = 2;
                this.introduceLayoutState = -1;
                View view1 = view0.findViewById(0x7F0A06E0);  // id:layoutIntroduceExpandButton
                q.f(view1, "findViewById(...)");
                this.layoutIntroduceExpandButton = (LinearLayout)view1;
                View view2 = view0.findViewById(0x7F0A0478);  // id:expand_tv
                q.f(view2, "findViewById(...)");
                this.tvIntroduceExpand = (TextView)view2;
                View view3 = view0.findViewById(0x7F0A0473);  // id:expand_btn
                q.f(view3, "findViewById(...)");
                this.accbIntroduceExpand = (AlphaControlCheckButton)view3;
                View view4 = view0.findViewById(0x7F0A0BF1);  // id:tvArtistIntroduce
                q.f(view4, "findViewById(...)");
                this.tvArtistIntroduce = (TextView)view4;
                View view5 = view0.findViewById(0x7F0A0BF3);  // id:tvArtistIntroduceWikiButton
                q.f(view5, "findViewById(...)");
                this.tvArtistIntroduceWikiButton = view5;
                View view6 = view0.findViewById(0x7F0A0BF2);  // id:tvArtistIntroduceLicense
                q.f(view6, "findViewById(...)");
                this.tvArtistIntroduceLicense = (TextView)view6;
            }

            public final void bind(@NotNull RESPONSE artistDetailInfoRes$RESPONSE0, int v) {
                q.g(artistDetailInfoRes$RESPONSE0, "response");
                com.iloen.melon.fragments.artistchannel.p p0 = new com.iloen.melon.fragments.artistchannel.p(this, DetailInfoAdapter.this, ArtistDetailDetailInfoFragment.this, v, 0);
                this.layoutIntroduceExpandButton.setOnClickListener(p0);
                String s = artistDetailInfoRes$RESPONSE0.intro;
                q.f(s, "intro");
                this.checkNUpdateIntroLayout(s);
                boolean z = q.b(artistDetailInfoRes$RESPONSE0.wikiButtonYn, "Y");
                this.hasWikiInfo = z;
                if(z) {
                    com.iloen.melon.fragments.artistchannel.q q0 = new com.iloen.melon.fragments.artistchannel.q(artistDetailInfoRes$RESPONSE0, 0);
                    this.tvArtistIntroduceWikiButton.setOnClickListener(q0);
                    ViewUtilsKt.setAccessibilityButtonClassName(this.tvArtistIntroduceWikiButton);
                    this.tvArtistIntroduceWikiButton.setVisibility(0);
                    this.tvArtistIntroduceLicense.setText((artistDetailInfoRes$RESPONSE0.wikiInfo == null ? null : artistDetailInfoRes$RESPONSE0.wikiInfo.license));
                    return;
                }
                this.tvArtistIntroduceWikiButton.setVisibility(8);
                this.tvArtistIntroduceLicense.setVisibility(8);
            }

            private static final void bind$lambda$0(IntroHolder artistDetailDetailInfoFragment$DetailInfoAdapter$IntroHolder0, DetailInfoAdapter artistDetailDetailInfoFragment$DetailInfoAdapter0, ArtistDetailDetailInfoFragment artistDetailDetailInfoFragment0, int v, View view0) {
                int v1 = artistDetailDetailInfoFragment$DetailInfoAdapter$IntroHolder0.introduceLayoutState;
                int v2 = artistDetailDetailInfoFragment$DetailInfoAdapter$IntroHolder0.LAYOUT_STATE_CLOSED;
                if(v1 == v2) {
                    artistDetailDetailInfoFragment$DetailInfoAdapter$IntroHolder0.introduceLayoutState = artistDetailDetailInfoFragment$DetailInfoAdapter$IntroHolder0.LAYOUT_STATE_OPENED;
                    artistDetailDetailInfoFragment$DetailInfoAdapter$IntroHolder0.updateIntroduceLayout();
                    if(AppUtils.isAccessibilityTalkbackOn()) {
                        artistDetailDetailInfoFragment$DetailInfoAdapter0.requestFocusRecyclerItemView(artistDetailDetailInfoFragment0.mRecyclerView, v);
                    }
                }
                else if(v1 == artistDetailDetailInfoFragment$DetailInfoAdapter$IntroHolder0.LAYOUT_STATE_OPENED) {
                    artistDetailDetailInfoFragment$DetailInfoAdapter$IntroHolder0.introduceLayoutState = v2;
                    artistDetailDetailInfoFragment0.mRecyclerView.scrollToPosition(v);
                    artistDetailDetailInfoFragment$DetailInfoAdapter$IntroHolder0.updateIntroduceLayout();
                    if(AppUtils.isAccessibilityTalkbackOn()) {
                        artistDetailDetailInfoFragment$DetailInfoAdapter0.requestFocusRecyclerItemView(artistDetailDetailInfoFragment0.mRecyclerView, v);
                    }
                }
            }

            private static final void bind$lambda$1(RESPONSE artistDetailInfoRes$RESPONSE0, View view0) {
                Navigator.open(MelonWebViewFullScreenWithBarFragment.newInstance(artistDetailInfoRes$RESPONSE0.wikiInfo.linkurl, false));
            }

            private final void checkNUpdateIntroLayout(String s) {
                this.tvArtistIntroduce.setText(s);
                if(this.introduceLayoutState == this.LAYOUT_STATE_NONE) {
                    this.tvArtistIntroduce.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                        @Override  // android.view.ViewTreeObserver$OnPreDrawListener
                        public boolean onPreDraw() {
                            int v = IntroHolder.this.tvArtistIntroduce.getLineCount() <= 8 ? IntroHolder.this.LAYOUT_STATE_NORMAL : IntroHolder.this.LAYOUT_STATE_CLOSED;
                            IntroHolder.this.introduceLayoutState = v;
                            IntroHolder.this.tvArtistIntroduce.getViewTreeObserver().removeOnPreDrawListener(this);
                            IntroHolder.this.updateIntroduceLayout();
                            return false;
                        }
                    });
                    return;
                }
                this.updateIntroduceLayout();
            }

            private final void updateIntroduceLayout() {
                boolean z;
                int v = this.introduceLayoutState;
                int v1 = 8;
                int v2 = 0;
                if(v == this.LAYOUT_STATE_NORMAL) {
                    TextView textView0 = this.tvArtistIntroduceLicense;
                    if(!this.hasWikiInfo) {
                        v2 = 8;
                    }
                    textView0.setVisibility(v2);
                    this.layoutIntroduceExpandButton.setVisibility(8);
                    return;
                }
                if(v == this.LAYOUT_STATE_CLOSED) {
                    this.tvArtistIntroduce.setMaxLines(8);
                    this.tvArtistIntroduce.setEllipsize(TextUtils.TruncateAt.END);
                    this.tvArtistIntroduceLicense.setVisibility(8);
                    z = false;
                }
                else if(v == this.LAYOUT_STATE_OPENED) {
                    this.tvArtistIntroduce.setMaxLines(0x7FFFFFFF);
                    this.tvArtistIntroduce.setEllipsize(null);
                    TextView textView1 = this.tvArtistIntroduceLicense;
                    if(this.hasWikiInfo) {
                        v1 = 0;
                    }
                    textView1.setVisibility(v1);
                    z = true;
                }
                else {
                    z = false;
                }
                this.layoutIntroduceExpandButton.setVisibility(0);
                this.tvIntroduceExpand.setText(ArtistDetailDetailInfoFragment.this.getString((z ? 0x7F130104 : 0x7F1306AE)));  // string:artist_channel_fold "접기"
                this.accbIntroduceExpand.setChecked(z);
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\t\u0010\nR$\u0010\r\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000B8\u0002@BX\u0082\u000E¢\u0006\f\n\u0004\b\r\u0010\u000E\"\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailDetailInfoFragment$DetailInfoAdapter$RelatedArtistHolder;", "Lcom/iloen/melon/viewholders/ArtistHolder;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailDetailInfoFragment$DetailInfoAdapter;Landroid/view/View;)V", "Lcom/iloen/melon/net/v6x/response/ArtistDetailInfoRes$RelatedArtistsInfoBase;", "artistData", "Lie/H;", "bind", "(Lcom/iloen/melon/net/v6x/response/ArtistDetailInfoRes$RelatedArtistsInfoBase;)V", "", "value", "isArtistFan", "Z", "setArtistFan", "(Z)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class RelatedArtistHolder extends ArtistHolder {
            private boolean isArtistFan;

            public RelatedArtistHolder(@NotNull View view0) {
                q.g(view0, "view");
                DetailInfoAdapter.this = artistDetailDetailInfoFragment$DetailInfoAdapter0;
                super(view0);
                ImageView imageView0 = this.fanIv;
                if(imageView0 != null) {
                    imageView0.setVisibility(0);
                }
                View view1 = this.friendshipLayout;
                if(view1 != null) {
                    view1.setVisibility(8);
                }
            }

            public final void bind(@NotNull RelatedArtistsInfoBase artistDetailInfoRes$RelatedArtistsInfoBase0) {
                q.g(artistDetailInfoRes$RelatedArtistsInfoBase0, "artistData");
                View view0 = this.rootView;
                if(view0 != null) {
                    view0.setOnClickListener(new j(2, ArtistDetailDetailInfoFragment.this, artistDetailInfoRes$RelatedArtistsInfoBase0));
                }
                ImageView imageView0 = this.thumbIv;
                if(imageView0 != null) {
                    Glide.with(DetailInfoAdapter.this.getContext()).load(artistDetailInfoRes$RelatedArtistsInfoBase0.getArtistImg()).apply(RequestOptions.circleCropTransform()).into(imageView0);
                }
                TextView textView0 = this.artistNameTv;
                if(textView0 != null) {
                    textView0.setText(artistDetailInfoRes$RelatedArtistsInfoBase0.getArtistName());
                }
                TextView textView1 = this.artistNewsTv;
                if(textView1 != null) {
                    textView1.setText(artistDetailInfoRes$RelatedArtistsInfoBase0.actgenre);
                }
                Params userActionsReq$Params0 = new Params();
                userActionsReq$Params0.fields = "fan";
                userActionsReq$Params0.contsTypeCode = "N10006";
                userActionsReq$Params0.contsId = artistDetailInfoRes$RelatedArtistsInfoBase0.getArtistId();
                RequestBuilder.newInstance(new UserActionsReq(DetailInfoAdapter.this.getContext(), userActionsReq$Params0)).tag(ArtistDetailDetailInfoFragment.this.getRequestTag()).listener(new r(this, 0)).errorListener(new s(0)).request();
                ImageView imageView1 = this.fanIv;
                if(imageView1 != null) {
                    imageView1.setOnClickListener(new d(this, ArtistDetailDetailInfoFragment.this, artistDetailInfoRes$RelatedArtistsInfoBase0, 4));
                }
                View view1 = this.rootView;
                if(view1 != null) {
                    view1.setAccessibilityDelegate(new View.AccessibilityDelegate() {
                        @Override  // android.view.View$AccessibilityDelegate
                        public void onInitializeAccessibilityNodeInfo(View view0, AccessibilityNodeInfo accessibilityNodeInfo0) {
                            q.g(view0, "host");
                            q.g(accessibilityNodeInfo0, "info");
                            super.onInitializeAccessibilityNodeInfo(view0, accessibilityNodeInfo0);
                            if(ArtistDetailDetailInfoFragment.this.getContext() == null) {
                                return;
                            }
                            accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(0x7F130B3A, this.getString(0x7F130B3A)));  // string:talkback_go_to_artist_channel_button "아티스트 채널 가기"
                            if(!artistDetailInfoRes$RelatedArtistsInfoBase0.isArtistFan) {
                                accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(0x7F130B25, this.getString(0x7F130B25)));  // string:talkback_fan_on "팬맺기"
                            }
                            StringBuilder stringBuilder0 = new StringBuilder(this.$artistData.getArtistName());
                            String s = this.$artistData.actgenre;
                            if(s != null && s.length() > 0) {
                                stringBuilder0.append(", ");
                                stringBuilder0.append(this.getString(0x7F130B2F, new Object[]{this.$artistData.actgenre}));  // string:talkback_genre "장르 : %1$s"
                            }
                            if(artistDetailInfoRes$RelatedArtistsInfoBase0.isArtistFan) {
                                stringBuilder0.append(", ");
                                stringBuilder0.append(this.getString(0x7F130B55));  // string:talkback_is_fan "팬맺음"
                            }
                            accessibilityNodeInfo0.setContentDescription(stringBuilder0);
                            accessibilityNodeInfo0.setClassName("android.widget.Button");
                            accessibilityNodeInfo0.setHintText(this.getString(0x7F130BA8, new Object[]{this.$artistData.shownItemCount, this.$artistData.ordNum}));  // string:talkback_number_out_of_number "%1$d개중 %2$d번째"
                        }

                        @Override  // android.view.View$AccessibilityDelegate
                        public boolean performAccessibilityAction(View view0, int v, Bundle bundle0) {
                            q.g(view0, "host");
                            switch(v) {
                                case 0x7F130B25: {  // string:talkback_fan_on "팬맺기"
                                    return artistDetailInfoRes$RelatedArtistsInfoBase0.fanIv.performClick();
                                }
                                case 0x7F130B3A: {  // string:talkback_go_to_artist_channel_button "아티스트 채널 가기"
                                    return artistDetailInfoRes$RelatedArtistsInfoBase0.rootView.performClick();
                                }
                                default: {
                                    return super.performAccessibilityAction(view0, v, bundle0);
                                }
                            }
                        }
                    });
                }

                @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\'\u0010\u000B\u001A\u00020\u00022\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\tH\u0016¢\u0006\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"com/iloen/melon/fragments/artistchannel/ArtistDetailDetailInfoFragment$DetailInfoAdapter$RelatedArtistHolder$bind$5$1", "Lcom/iloen/melon/task/request/LikeUpdateAsyncTask$OnJobFinishListener;", "Lie/H;", "onStartAsyncTask", "()V", "", "errorMsg", "", "sumCount", "", "isLike", "onJobComplete", "(Ljava/lang/String;IZ)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
                public final class com.iloen.melon.fragments.artistchannel.ArtistDetailDetailInfoFragment.DetailInfoAdapter.RelatedArtistHolder.bind.5.1 implements OnJobFinishListener {
                    public com.iloen.melon.fragments.artistchannel.ArtistDetailDetailInfoFragment.DetailInfoAdapter.RelatedArtistHolder.bind.5.1(ArtistDetailDetailInfoFragment artistDetailDetailInfoFragment0, RelatedArtistHolder artistDetailDetailInfoFragment$DetailInfoAdapter$RelatedArtistHolder0) {
                    }

                    @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
                    public void onJobComplete(String s, int v, boolean z) {
                        q.g(s, "errorMsg");
                        if(!ArtistDetailDetailInfoFragment.this.isFragmentValid() || s.length() > 0) {
                            return;
                        }
                        RelatedArtistHolder.this.setArtistFan(true);
                    }

                    @Override  // com.iloen.melon.task.request.LikeUpdateAsyncTask$OnJobFinishListener
                    public void onStartAsyncTask() {
                    }
                }

            }

            private static final void bind$lambda$0(ArtistDetailDetailInfoFragment artistDetailDetailInfoFragment0, RelatedArtistsInfoBase artistDetailInfoRes$RelatedArtistsInfoBase0, View view0) {
                artistDetailDetailInfoFragment0.showArtistInfoPage(artistDetailInfoRes$RelatedArtistsInfoBase0.getArtistId());
            }

            private static final void bind$lambda$4(RelatedArtistHolder artistDetailDetailInfoFragment$DetailInfoAdapter$RelatedArtistHolder0, UserActionsRes userActionsRes0) {
                q.g(userActionsRes0, "response");
                Cb.j.b(userActionsRes0.notification, false, 3);
                if(Cb.j.d(userActionsRes0)) {
                    Response userActionsRes$Response0 = userActionsRes0.response;
                    if(userActionsRes$Response0 != null) {
                        artistDetailDetailInfoFragment$DetailInfoAdapter$RelatedArtistHolder0.setArtistFan(userActionsRes$Response0.isFan());
                    }
                }
            }

            private static final void bind$lambda$5(VolleyError volleyError0) {
                q.g(volleyError0, "error");
                b.w("RelatedArtistAdapter.onBindViewImpl$onErrorResponse() - error : ", volleyError0.getMessage(), LogU.Companion, "ArtistDetailDetailInfoFragment");
            }

            private static final void bind$lambda$6(RelatedArtistHolder artistDetailDetailInfoFragment$DetailInfoAdapter$RelatedArtistHolder0, ArtistDetailDetailInfoFragment artistDetailDetailInfoFragment0, RelatedArtistsInfoBase artistDetailInfoRes$RelatedArtistsInfoBase0, View view0) {
                if(!artistDetailDetailInfoFragment$DetailInfoAdapter$RelatedArtistHolder0.isArtistFan) {
                    ContsTypeCode contsTypeCode0 = ContsTypeCode.ARTIST;
                    artistDetailDetailInfoFragment0.updateFan(artistDetailInfoRes$RelatedArtistsInfoBase0.getArtistId(), "N10006", true, artistDetailInfoRes$RelatedArtistsInfoBase0.getMenuId(), new com.iloen.melon.fragments.artistchannel.ArtistDetailDetailInfoFragment.DetailInfoAdapter.RelatedArtistHolder.bind.5.1(artistDetailDetailInfoFragment0, artistDetailDetailInfoFragment$DetailInfoAdapter$RelatedArtistHolder0));
                    if(artistDetailInfoRes$RelatedArtistsInfoBase0 instanceof GROUPLIST && artistDetailDetailInfoFragment0.mMelonTiaraProperty != null) {
                        f f0 = artistDetailDetailInfoFragment0.getTiaraEventBuilder();
                        f0.a = artistDetailDetailInfoFragment0.getString(0x7F130DC8);  // string:tiara_common_action_name_like "좋아요"
                        f0.d = ActionKind.Like;
                        f0.y = artistDetailDetailInfoFragment0.getString(0x7F130CD5);  // string:tiara_artist_detail_info_layer1_group_unit_artist "소속그룹/유닛아티스트"
                        f0.C = String.valueOf(artistDetailInfoRes$RelatedArtistsInfoBase0.ordNum);
                        f0.e = artistDetailInfoRes$RelatedArtistsInfoBase0.getArtistId();
                        f0.f = Y.i(contsTypeCode0, "code(...)");
                        f0.g = artistDetailInfoRes$RelatedArtistsInfoBase0.getArtistName();
                        f0.U = artistDetailDetailInfoFragment0.getString(0x7F130FCD);  // string:tiara_props_like "like"
                        f0.a().track();
                    }
                }
            }

            private final void setArtistFan(boolean z) {
                this.isArtistFan = z;
                ImageView imageView0 = this.fanIv;
                if(imageView0 != null) {
                    imageView0.setImageResource((z ? 0x7F08013E : 0x7F08013C));  // drawable:btn_common_fan_22_on
                }
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001A\u00020\u0001¢\u0006\b\n\u0000\u001A\u0004\b\t\u0010\n¨\u0006\u000B"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailDetailInfoFragment$DetailInfoAdapter$ServerWrapperData;", "", "viewType", "", "data", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailDetailInfoFragment$DetailInfoAdapter;ILjava/lang/Object;)V", "getViewType", "()I", "getData", "()Ljava/lang/Object;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class ServerWrapperData {
            @NotNull
            private final Object data;
            private final int viewType;

            public ServerWrapperData(int v, @NotNull Object object0) {
                q.g(object0, "data");
                DetailInfoAdapter.this = artistDetailDetailInfoFragment$DetailInfoAdapter0;
                super();
                this.viewType = v;
                this.data = object0;
            }

            @NotNull
            public final Object getData() {
                return this.data;
            }

            public final int getViewType() {
                return this.viewType;
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001A\u00020\u000B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailDetailInfoFragment$DetailInfoAdapter$SubTitleViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailDetailInfoFragment$DetailInfoAdapter;Landroid/view/View;)V", "", "subTitle", "Lie/H;", "bind", "(Ljava/lang/String;)V", "Landroid/widget/TextView;", "subTitleTv", "Landroid/widget/TextView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class SubTitleViewHolder extends O0 {
            @NotNull
            private final TextView subTitleTv;

            public SubTitleViewHolder(@NotNull View view0) {
                q.g(view0, "view");
                DetailInfoAdapter.this = artistDetailDetailInfoFragment$DetailInfoAdapter0;
                super(view0);
                View view1 = view0.findViewById(0x7F0A0AFE);  // id:sub_title_tv
                q.f(view1, "findViewById(...)");
                this.subTitleTv = (TextView)view1;
            }

            public final void bind(@NotNull String s) {
                q.g(s, "subTitle");
                this.subTitleTv.setText(s);
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001:\u0001\rB\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\u000B\u001A\u00020\n2\u001A\u0010\t\u001A\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\b¢\u0006\u0004\b\u000B\u0010\f¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailDetailInfoFragment$DetailInfoAdapter$WeekAwardListHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailDetailInfoFragment$DetailInfoAdapter;Landroid/view/View;)V", "Ljava/util/ArrayList;", "Lcom/iloen/melon/net/v6x/response/ArtistDetailInfoRes$RESPONSE$WEEKAWARDLIST;", "Lkotlin/collections/ArrayList;", "weekAwardList", "Lie/H;", "bind", "(Ljava/util/ArrayList;)V", "WeekAwardListAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class WeekAwardListHolder extends O0 {
            @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001BB-\u0012\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004\u0012\u001A\u0010\b\u001A\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0002`\u0007¢\u0006\u0004\b\t\u0010\nJ\u001F\u0010\u000F\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\rH\u0016¢\u0006\u0004\b\u000F\u0010\u0010J\'\u0010\u0015\u001A\u00020\u00142\u0006\u0010\u0011\u001A\u00020\u00032\u0006\u0010\u0012\u001A\u00020\r2\u0006\u0010\u0013\u001A\u00020\rH\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001C\u0010\u0019\u001A\n \u0018*\u0004\u0018\u00010\u00170\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001A¨\u0006\u001C"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailDetailInfoFragment$DetailInfoAdapter$WeekAwardListHolder$WeekAwardListAdapter;", "Lcom/iloen/melon/adapters/common/y;", "Lcom/iloen/melon/net/v6x/response/ArtistDetailInfoRes$RESPONSE$WEEKAWARDLIST;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "list", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailDetailInfoFragment$DetailInfoAdapter$WeekAwardListHolder;Landroid/content/Context;Ljava/util/ArrayList;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "rawPosition", "position", "Lie/H;", "onBindViewHolder", "(Landroidx/recyclerview/widget/O0;II)V", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "inflater", "Landroid/view/LayoutInflater;", "WeekAwardItemHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
            final class WeekAwardListAdapter extends y {
                @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u0017\u0010\f\u001A\u00020\u000B8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000FR\u0017\u0010\u0010\u001A\u00020\u000B8\u0006¢\u0006\f\n\u0004\b\u0010\u0010\r\u001A\u0004\b\u0011\u0010\u000F¨\u0006\u0012"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/ArtistDetailDetailInfoFragment$DetailInfoAdapter$WeekAwardListHolder$WeekAwardListAdapter$WeekAwardItemHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/iloen/melon/fragments/artistchannel/ArtistDetailDetailInfoFragment$DetailInfoAdapter$WeekAwardListHolder$WeekAwardListAdapter;Landroid/view/View;)V", "Landroid/widget/ImageView;", "thumbIv", "Landroid/widget/ImageView;", "getThumbIv", "()Landroid/widget/ImageView;", "Landroid/widget/TextView;", "awardTv", "Landroid/widget/TextView;", "getAwardTv", "()Landroid/widget/TextView;", "songTv", "getSongTv", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
                final class WeekAwardItemHolder extends O0 {
                    @NotNull
                    private final TextView awardTv;
                    @NotNull
                    private final TextView songTv;
                    @NotNull
                    private final ImageView thumbIv;

                    public WeekAwardItemHolder(@NotNull View view0) {
                        q.g(view0, "itemView");
                        WeekAwardListAdapter.this = artistDetailDetailInfoFragment$DetailInfoAdapter$WeekAwardListHolder$WeekAwardListAdapter0;
                        super(view0);
                        View view1 = view0.findViewById(0x7F0A069A);  // id:iv_thumb
                        q.f(view1, "findViewById(...)");
                        this.thumbIv = (ImageView)view1;
                        View view2 = view0.findViewById(0x7F0A00E3);  // id:award_tv
                        q.f(view2, "findViewById(...)");
                        this.awardTv = (TextView)view2;
                        View view3 = view0.findViewById(0x7F0A0AB7);  // id:song_tv
                        q.f(view3, "findViewById(...)");
                        this.songTv = (TextView)view3;
                    }

                    @NotNull
                    public final TextView getAwardTv() {
                        return this.awardTv;
                    }

                    @NotNull
                    public final TextView getSongTv() {
                        return this.songTv;
                    }

                    @NotNull
                    public final ImageView getThumbIv() {
                        return this.thumbIv;
                    }
                }

                private final LayoutInflater inflater;

                public WeekAwardListAdapter(@Nullable Context context0, @NotNull ArrayList arrayList0) {
                    q.g(arrayList0, "list");
                    WeekAwardListHolder.this = artistDetailDetailInfoFragment$DetailInfoAdapter$WeekAwardListHolder0;
                    super(context0, arrayList0);
                    this.inflater = LayoutInflater.from(context0);
                }

                @Override  // com.iloen.melon.adapters.common.y
                public void onBindViewHolder(@NotNull O0 o00, int v, int v1) {
                    q.g(o00, "viewHolder");
                    WEEKAWARDLIST artistDetailInfoRes$RESPONSE$WEEKAWARDLIST0 = (WEEKAWARDLIST)this.getItem(v1);
                    if(artistDetailInfoRes$RESPONSE$WEEKAWARDLIST0 == null) {
                        return;
                    }
                    Glide.with(this.getContext()).load(artistDetailInfoRes$RESPONSE$WEEKAWARDLIST0.albumimg).into(((WeekAwardItemHolder)o00).getThumbIv());
                    ((WeekAwardItemHolder)o00).getThumbIv().setOnClickListener(new d(ArtistDetailDetailInfoFragment.this, artistDetailInfoRes$RESPONSE$WEEKAWARDLIST0, DetailInfoAdapter.this, 5));
                    String s = ArtistDetailDetailInfoFragment.this.getString(0x7F130117, new Object[]{artistDetailInfoRes$RESPONSE$WEEKAWARDLIST0.awardmonth, artistDetailInfoRes$RESPONSE$WEEKAWARDLIST0.awardweek, artistDetailInfoRes$RESPONSE$WEEKAWARDLIST0.awardrank});  // string:artist_channel_week_award_format "%1$s %2$s %3$s"
                    q.f(s, "getString(...)");
                    ((WeekAwardItemHolder)o00).getAwardTv().setText(s);
                    String s1 = ArtistDetailDetailInfoFragment.this.getString(0x7F130118, new Object[]{artistDetailInfoRes$RESPONSE$WEEKAWARDLIST0.artistname, artistDetailInfoRes$RESPONSE$WEEKAWARDLIST0.songname});  // string:artist_channel_week_award_song_format "%1$s - %2$s"
                    q.f(s1, "getString(...)");
                    ((WeekAwardItemHolder)o00).getSongTv().setText(s1);
                    ViewUtils.setContentDescriptionWithButtonClassName(((WeekAwardItemHolder)o00).getThumbIv(), ArtistDetailDetailInfoFragment.this.getString(0x7F130C84, new Object[]{s, s1}));  // string:talkback_week_award_play "%1$s, %2$s, 곡 재생하기"
                }

                private static final void onBindViewHolder$lambda$0(ArtistDetailDetailInfoFragment artistDetailDetailInfoFragment0, WEEKAWARDLIST artistDetailInfoRes$RESPONSE$WEEKAWARDLIST0, DetailInfoAdapter artistDetailDetailInfoFragment$DetailInfoAdapter0, View view0) {
                    artistDetailDetailInfoFragment0.playSong(artistDetailInfoRes$RESPONSE$WEEKAWARDLIST0.songid, artistDetailDetailInfoFragment$DetailInfoAdapter0.getMenuId());
                }

                @Override  // androidx.recyclerview.widget.j0
                @NotNull
                public O0 onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
                    q.g(viewGroup0, "parent");
                    View view0 = this.inflater.inflate(0x7F0D0051, viewGroup0, false);  // layout:artist_info_listitem_week_award
                    q.d(view0);
                    return new WeekAwardItemHolder(this, view0);
                }
            }

            public WeekAwardListHolder(@NotNull View view0) {
                q.g(view0, "view");
                DetailInfoAdapter.this = artistDetailDetailInfoFragment$DetailInfoAdapter0;
                super(view0);
                artistDetailDetailInfoFragment$DetailInfoAdapter0.weekAwardListRecyclerView = (RecyclerView)view0.findViewById(0x7F0A09D1);  // id:recycler_view
            }

            public final void bind(@NotNull ArrayList arrayList0) {
                q.g(arrayList0, "weekAwardList");
                RecyclerView recyclerView0 = DetailInfoAdapter.this.weekAwardListRecyclerView;
                if(recyclerView0 != null) {
                    recyclerView0.setAdapter(new WeekAwardListAdapter(this, DetailInfoAdapter.this.getContext(), arrayList0));
                }
            }
        }

        private final int VIEW_TYPE_AWARD_LIST;
        private final int VIEW_TYPE_DETAIL_INFO_ITEM;
        private final int VIEW_TYPE_DETAIL_INTRO_ITEM;
        private final int VIEW_TYPE_RELATED_ARTIST_EXPANDABLE_BUTTON;
        private final int VIEW_TYPE_RELATED_ARTIST_ITEM;
        private final int VIEW_TYPE_RELATED_ARTIST_SUBTITLE;
        private final int VIEW_TYPE_WEEK_AWARD_LIST;
        @Nullable
        private RecyclerView awardListRecyclerView;
        @Nullable
        private RecyclerView weekAwardListRecyclerView;

        public DetailInfoAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            ArtistDetailDetailInfoFragment.this = artistDetailDetailInfoFragment0;
            super(context0, list0);
            this.VIEW_TYPE_DETAIL_INFO_ITEM = 1;
            this.VIEW_TYPE_AWARD_LIST = 2;
            this.VIEW_TYPE_DETAIL_INTRO_ITEM = 3;
            this.VIEW_TYPE_WEEK_AWARD_LIST = 4;
            this.VIEW_TYPE_RELATED_ARTIST_SUBTITLE = 5;
            this.VIEW_TYPE_RELATED_ARTIST_EXPANDABLE_BUTTON = 6;
            this.VIEW_TYPE_RELATED_ARTIST_ITEM = 7;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            ServerWrapperData artistDetailDetailInfoFragment$DetailInfoAdapter$ServerWrapperData0 = (ServerWrapperData)this.getItem(v1);
            return artistDetailDetailInfoFragment$DetailInfoAdapter$ServerWrapperData0 == null ? -1 : artistDetailDetailInfoFragment$DetailInfoAdapter$ServerWrapperData0.getViewType();
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(@NotNull String s, @NotNull i i0, @NotNull HttpResponse httpResponse0) {
            q.g(s, "key");
            q.g(i0, "type");
            q.g(httpResponse0, "response");
            RESPONSE artistDetailInfoRes$RESPONSE0 = ((ArtistDetailInfoRes)httpResponse0).response;
            if(Cb.i.l(artistDetailInfoRes$RESPONSE0)) {
                this.setMenuId(artistDetailInfoRes$RESPONSE0.menuId);
                this.updateModifiedTime(this.getCacheKey());
                DetailInfoAdapter.updateResponse$default(this, artistDetailInfoRes$RESPONSE0, 0, 2, null);
            }
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            ServerWrapperData artistDetailDetailInfoFragment$DetailInfoAdapter$ServerWrapperData0 = (ServerWrapperData)this.getItem(v1);
            if(artistDetailDetailInfoFragment$DetailInfoAdapter$ServerWrapperData0 != null) {
                Object object0 = artistDetailDetailInfoFragment$DetailInfoAdapter$ServerWrapperData0.getData();
                if(object0 != null) {
                    Integer integer0 = o00 == null ? null : o00.getItemViewType();
                    if(integer0 == null || ((int)integer0) != this.VIEW_TYPE_DETAIL_INFO_ITEM) {
                        if(integer0 != null && ((int)integer0) == this.VIEW_TYPE_AWARD_LIST) {
                            q.e(o00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailDetailInfoFragment.DetailInfoAdapter.AwardListHolder");
                            ((AwardListHolder)o00).bind(((ArrayList)object0));
                            return;
                        }
                        if(integer0 == null || ((int)integer0) != this.VIEW_TYPE_DETAIL_INTRO_ITEM) {
                            if(integer0 != null && ((int)integer0) == this.VIEW_TYPE_WEEK_AWARD_LIST) {
                                q.e(o00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailDetailInfoFragment.DetailInfoAdapter.WeekAwardListHolder");
                                ((WeekAwardListHolder)o00).bind(((ArrayList)object0));
                                return;
                            }
                            if(integer0 != null && ((int)integer0) == this.VIEW_TYPE_RELATED_ARTIST_SUBTITLE) {
                                if(object0 instanceof String) {
                                    q.e(o00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailDetailInfoFragment.DetailInfoAdapter.SubTitleViewHolder");
                                    ((SubTitleViewHolder)o00).bind(((String)object0));
                                }
                            }
                            else if(integer0 != null && ((int)integer0) == this.VIEW_TYPE_RELATED_ARTIST_EXPANDABLE_BUTTON) {
                                if(object0 instanceof Integer) {
                                    q.e(o00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailDetailInfoFragment.DetailInfoAdapter.ExpandableButtonViewHolder");
                                    ((ExpandableButtonViewHolder)o00).bind(((Number)object0).intValue(), v1);
                                }
                            }
                            else if(integer0 != null && ((int)integer0) == this.VIEW_TYPE_RELATED_ARTIST_ITEM && object0 instanceof RelatedArtistsInfoBase) {
                                q.e(o00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailDetailInfoFragment.DetailInfoAdapter.RelatedArtistHolder");
                                ((RelatedArtistHolder)o00).bind(((RelatedArtistsInfoBase)object0));
                            }
                        }
                        else if(object0 instanceof RESPONSE) {
                            q.e(o00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailDetailInfoFragment.DetailInfoAdapter.IntroHolder");
                            ((IntroHolder)o00).bind(((RESPONSE)object0), v1);
                        }
                    }
                    else if(object0 instanceof RESPONSE) {
                        q.e(o00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailDetailInfoFragment.DetailInfoAdapter.DetailInfoHolder");
                        ((DetailInfoHolder)o00).bind(((RESPONSE)object0));
                    }
                }
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        @Nullable
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            if(v == this.VIEW_TYPE_DETAIL_INFO_ITEM) {
                View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D004E, viewGroup0, false);  // layout:artist_info_detail
                q.f(view0, "inflate(...)");
                return new DetailInfoHolder(this, view0);
            }
            if(v == this.VIEW_TYPE_AWARD_LIST) {
                View view1 = LayoutInflater.from(this.getContext()).inflate(0x7F0D004C, viewGroup0, false);  // layout:artist_info_award_list
                q.f(view1, "inflate(...)");
                return new AwardListHolder(this, view1);
            }
            if(v == this.VIEW_TYPE_DETAIL_INTRO_ITEM) {
                View view2 = LayoutInflater.from(this.getContext()).inflate(0x7F0D004F, viewGroup0, false);  // layout:artist_info_intro
                q.f(view2, "inflate(...)");
                return new IntroHolder(this, view2);
            }
            if(v == this.VIEW_TYPE_WEEK_AWARD_LIST) {
                View view3 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0055, viewGroup0, false);  // layout:artist_info_week_award_list
                q.f(view3, "inflate(...)");
                return new WeekAwardListHolder(this, view3);
            }
            if(v == this.VIEW_TYPE_RELATED_ARTIST_SUBTITLE) {
                View view4 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0054, viewGroup0, false);  // layout:artist_info_related_subtitle_item
                q.f(view4, "inflate(...)");
                return new SubTitleViewHolder(this, view4);
            }
            if(v == this.VIEW_TYPE_RELATED_ARTIST_EXPANDABLE_BUTTON) {
                View view5 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0053, viewGroup0, false);  // layout:artist_info_related_expandable_button_item
                q.f(view5, "inflate(...)");
                return new ExpandableButtonViewHolder(this, view5);
            }
            if(v == this.VIEW_TYPE_RELATED_ARTIST_ITEM) {
                View view6 = LayoutInflater.from(this.getContext()).inflate(0x7F0D045D, viewGroup0, false);  // layout:listitem_artist_margin_20
                q.f(view6, "inflate(...)");
                return new RelatedArtistHolder(this, view6);
            }
            return null;
        }

        private final void requestFocusRecyclerItemView(RecyclerView recyclerView0, int v) {
            if(recyclerView0 != null) {
                ViewTreeObserver viewTreeObserver0 = recyclerView0.getViewTreeObserver();
                if(viewTreeObserver0 != null) {
                    viewTreeObserver0.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                        @Override  // android.view.ViewTreeObserver$OnPreDrawListener
                        public boolean onPreDraw() {
                            O0 o00 = v.findViewHolderForAdapterPosition(this.$position);
                            if(o00 != null) {
                                View view0 = o00.itemView;
                                if(view0 != null) {
                                    ViewTreeObserver viewTreeObserver0 = v.getViewTreeObserver();
                                    if(viewTreeObserver0 != null) {
                                        viewTreeObserver0.removeOnPreDrawListener(this);
                                    }
                                    view0.sendAccessibilityEvent(8);
                                }
                            }
                            return false;
                        }
                    });
                }
            }
        }

        private final void setRelatedArtistList(ArrayList arrayList0, int v) {
            if(arrayList0.isEmpty()) {
                return;
            }
            int v1 = arrayList0.size();
            boolean z = ArtistDetailDetailInfoFragment.this.isExpandState(v);
            int v2 = 0;
            while(true) {
                int v3 = 3;
                if(v2 >= v1 || v2 >= 3 && !z) {
                    break;
                }
                int v4 = this.VIEW_TYPE_RELATED_ARTIST_ITEM;
                Object object0 = arrayList0.get(v2);
                q.f(object0, "get(...)");
                ++v2;
                ((RelatedArtistsInfoBase)object0).ordNum = v2;
                if(z) {
                    v3 = v1;
                }
                else if(v1 <= 3) {
                    v3 = v1;
                }
                ((RelatedArtistsInfoBase)object0).shownItemCount = v3;
                this.add(new ServerWrapperData(this, v4, object0));
            }
            if(v1 > 3) {
                this.add(new ServerWrapperData(this, this.VIEW_TYPE_RELATED_ARTIST_EXPANDABLE_BUTTON, v));
                return;
            }
            this.add(new ServerWrapperData(this, this.VIEW_TYPE_RELATED_ARTIST_EXPANDABLE_BUTTON, 5));
        }

        private final void updateResponse(RESPONSE artistDetailInfoRes$RESPONSE0, int v) {
            j0 j00 = ArtistDetailDetailInfoFragment.this.mAdapter;
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.artistchannel.ArtistDetailDetailInfoFragment.DetailInfoAdapter");
            ((DetailInfoAdapter)j00).clear();
            this.add(new ServerWrapperData(this, this.VIEW_TYPE_DETAIL_INFO_ITEM, artistDetailInfoRes$RESPONSE0));
            ArrayList arrayList0 = artistDetailInfoRes$RESPONSE0.awardList;
            if(arrayList0 != null && !arrayList0.isEmpty() == 1) {
                ArtistDetailDetailInfoFragment.this.awardListCount = arrayList0.size();
                int v1 = ArtistDetailDetailInfoFragment.this.awardListCount;
                int v2 = ArtistDetailDetailInfoFragment.this.displayAwardListLimit;
                if(v1 > v2) {
                    v1 = v2;
                }
                ArrayList arrayList1 = new ArrayList(arrayList0.subList(0, v1));
                int v3 = this.getCount();
                ArtistDetailDetailInfoFragment.this.setGroupTitlePosition(0, v3);
                this.add(new ServerWrapperData(this, this.VIEW_TYPE_AWARD_LIST, arrayList1));
                if(ArtistDetailDetailInfoFragment.this.awardListCount > 3) {
                    this.add(new ServerWrapperData(this, this.VIEW_TYPE_RELATED_ARTIST_EXPANDABLE_BUTTON, 0));
                }
                else {
                    this.add(new ServerWrapperData(this, this.VIEW_TYPE_RELATED_ARTIST_EXPANDABLE_BUTTON, 5));
                }
            }
            if(artistDetailInfoRes$RESPONSE0.intro != null && !Tf.o.H0(artistDetailInfoRes$RESPONSE0.intro) == 1) {
                this.add(new ServerWrapperData(this, this.VIEW_TYPE_DETAIL_INTRO_ITEM, artistDetailInfoRes$RESPONSE0));
            }
            ArrayList arrayList2 = artistDetailInfoRes$RESPONSE0.weekAwardList;
            if(arrayList2 != null && !arrayList2.isEmpty() == 1) {
                ArtistDetailDetailInfoFragment.this.weekAwardCount = arrayList2.size();
                int v4 = ArtistDetailDetailInfoFragment.this.weekAwardCount;
                int v5 = ArtistDetailDetailInfoFragment.this.displayWeekAwardLimit;
                if(v4 > v5) {
                    v4 = v5;
                }
                ArrayList arrayList3 = new ArrayList(arrayList2.subList(0, v4));
                int v6 = this.getCount();
                ArtistDetailDetailInfoFragment.this.setGroupTitlePosition(1, v6);
                this.add(new ServerWrapperData(this, this.VIEW_TYPE_WEEK_AWARD_LIST, arrayList3));
                if(ArtistDetailDetailInfoFragment.this.weekAwardCount > 3) {
                    this.add(new ServerWrapperData(this, this.VIEW_TYPE_RELATED_ARTIST_EXPANDABLE_BUTTON, 1));
                }
                else {
                    this.add(new ServerWrapperData(this, this.VIEW_TYPE_RELATED_ARTIST_EXPANDABLE_BUTTON, 5));
                }
            }
            if(artistDetailInfoRes$RESPONSE0.groupList != null && !artistDetailInfoRes$RESPONSE0.groupList.isEmpty() == 1) {
                int v7 = this.getCount();
                ArtistDetailDetailInfoFragment.this.setGroupTitlePosition(2, v7);
                String s = ArtistDetailDetailInfoFragment.this.getString(0x7F130148);  // string:artist_info_group_and_unit_artist "소속 그룹/유닛 아티스트"
                q.f(s, "getString(...)");
                this.add(new ServerWrapperData(this, this.VIEW_TYPE_RELATED_ARTIST_SUBTITLE, s));
                ArrayList arrayList4 = artistDetailInfoRes$RESPONSE0.groupList;
                q.f(arrayList4, "groupList");
                this.setRelatedArtistList(arrayList4, 2);
            }
            if(artistDetailInfoRes$RESPONSE0.compArtistList != null && !artistDetailInfoRes$RESPONSE0.compArtistList.isEmpty() == 1) {
                int v8 = this.getCount();
                ArtistDetailDetailInfoFragment.this.setGroupTitlePosition(3, v8);
                String s1 = ArtistDetailDetailInfoFragment.this.getString(0x7F130147);  // string:artist_info_compartist "같은 소속사 아티스트"
                q.f(s1, "getString(...)");
                this.add(new ServerWrapperData(this, this.VIEW_TYPE_RELATED_ARTIST_SUBTITLE, s1));
                ArrayList arrayList5 = artistDetailInfoRes$RESPONSE0.compArtistList;
                q.f(arrayList5, "compArtistList");
                this.setRelatedArtistList(arrayList5, 3);
            }
            if(artistDetailInfoRes$RESPONSE0.simArtistList != null && !artistDetailInfoRes$RESPONSE0.simArtistList.isEmpty() == 1) {
                int v9 = this.getCount();
                ArtistDetailDetailInfoFragment.this.setGroupTitlePosition(4, v9);
                String s2 = ArtistDetailDetailInfoFragment.this.getString(0x7F130152);  // string:artist_info_simartist "유사 아티스트"
                q.f(s2, "getString(...)");
                this.add(new ServerWrapperData(this, this.VIEW_TYPE_RELATED_ARTIST_SUBTITLE, s2));
                ArrayList arrayList6 = artistDetailInfoRes$RESPONSE0.simArtistList;
                q.f(arrayList6, "simArtistList");
                this.setRelatedArtistList(arrayList6, 4);
            }
            if(v >= 0) {
                RecyclerView recyclerView0 = ArtistDetailDetailInfoFragment.this.mRecyclerView;
                if(recyclerView0 != null) {
                    recyclerView0.scrollToPosition(v);
                }
                if(AppUtils.isAccessibilityTalkbackOn()) {
                    this.requestFocusRecyclerItemView(ArtistDetailDetailInfoFragment.this.mRecyclerView, v);
                }
            }
        }

        public static void updateResponse$default(DetailInfoAdapter artistDetailDetailInfoFragment$DetailInfoAdapter0, RESPONSE artistDetailInfoRes$RESPONSE0, int v, int v1, Object object0) {
            if((v1 & 2) != 0) {
                v = 0;
            }
            artistDetailDetailInfoFragment$DetailInfoAdapter0.updateResponse(artistDetailInfoRes$RESPONSE0, v);
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_ARTIST_ID = "argArtistId";
    @NotNull
    private static final String ARG_ARTIST_NAME = "argArtistName";
    @NotNull
    public static final Companion Companion = null;
    private static final int DISPLAY_ITEM_MAX_LIMIT = 3;
    private static final int FOLDED_INTRO_MAX_LINE = 8;
    private static final int POSITION_NO_SCROLL = -1;
    private static final int RELATION_LESS_ITEM = 5;
    private static final int RELATION_TYPE_AWARD_LIST = 0;
    private static final int RELATION_TYPE_COMPANY = 3;
    private static final int RELATION_TYPE_GROUP = 2;
    private static final int RELATION_TYPE_SIMILAR = 4;
    private static final int RELATION_TYPE_WEEK_AWARD = 1;
    private static final int SNS_LINK_TYPE_FACEBOOK = 2;
    private static final int SNS_LINK_TYPE_HOME = 0;
    private static final int SNS_LINK_TYPE_INSTAGRAM = 3;
    private static final int SNS_LINK_TYPE_X = 1;
    @NotNull
    private static final String TAG = "ArtistDetailDetailInfoFragment";
    @Nullable
    private String artistId;
    @Nullable
    private String artistName;
    private int awardListCount;
    private int displayAwardListLimit;
    private int displayWeekAwardLimit;
    @NotNull
    private final boolean[] expandStates;
    @NotNull
    private final int[] groupTitlePosition;
    private int weekAwardCount;

    static {
        ArtistDetailDetailInfoFragment.Companion = new Companion(null);
        ArtistDetailDetailInfoFragment.$stable = 8;
    }

    public ArtistDetailDetailInfoFragment() {
        this.expandStates = new boolean[]{false, false, false, false, false};
        this.groupTitlePosition = new int[]{0, 0, 0, 0, 0};
        this.displayAwardListLimit = 3;
        this.displayWeekAwardLimit = 3;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new DetailInfoAdapter(this, context0, null);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.e(MelonContentUris.c.buildUpon().appendPath("detailInfo"), this.artistId, "toString(...)");
    }

    private final int getGroupTitlePosition(int v) {
        return v < 0 || v > 4 ? 0 : this.groupTitlePosition[v];
    }

    private final f getTiaraEventBuilder() {
        f f0 = new g();  // 初始化器: Lp8/f;-><init>()V
        f0.b = this.mMelonTiaraProperty.a;
        f0.c = this.mMelonTiaraProperty.b;
        f0.o = this.artistId;
        f0.p = Y.i(ContsTypeCode.ARTIST, "code(...)");
        f0.q = this.artistName;
        f0.I = this.mMelonTiaraProperty.c;
        return f0;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean hasScrolledLine() {
        return true;
    }

    private final boolean isExpandState(int v) {
        return v < 0 || v > 4 ? false : this.expandStates[v];
    }

    @NotNull
    public static final ArtistDetailDetailInfoFragment newInstance(@Nullable String s) {
        return ArtistDetailDetailInfoFragment.Companion.newInstance(s);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(((RecyclerView)view0).getContext()));
        ((RecyclerView)view0).setHasFixedSize(true);
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D0296, viewGroup0, false);  // layout:fragment_artist_info_detail_info
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull i i0, @NotNull h h0, @NotNull String s) {
        q.g(i0, "type");
        q.g(h0, "param");
        q.g(s, "reason");
        RequestBuilder.newInstance(new ArtistDetailInfoReq(this.getContext(), this.artistId)).tag(this.getRequestTag()).listener(new r(this, 3)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final void onFetchStart$lambda$2(ArtistDetailDetailInfoFragment artistDetailDetailInfoFragment0, ArtistDetailInfoRes artistDetailInfoRes0) {
        q.g(artistDetailInfoRes0, "response");
        if(artistDetailDetailInfoFragment0.prepareFetchComplete(artistDetailInfoRes0)) {
            RESPONSE artistDetailInfoRes$RESPONSE0 = artistDetailInfoRes0.response;
            if(artistDetailInfoRes$RESPONSE0 != null) {
                artistDetailDetailInfoFragment0.mMelonTiaraProperty = new p8.s(artistDetailInfoRes$RESPONSE0.section, artistDetailInfoRes$RESPONSE0.page, artistDetailInfoRes$RESPONSE0.menuId, null);
                artistDetailDetailInfoFragment0.performFetchComplete(artistDetailInfoRes0);
            }
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        this.artistId = bundle0.getString("argArtistId");
        this.artistName = bundle0.getString("argArtistName");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argArtistId", this.artistId);
        bundle0.putString("argArtistName", this.artistName);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        F8.p p0 = new F8.p(1);
        String s = this.getString(0x7F130809);  // string:playList_talkback_detail_info_close "상세정보 닫기"
        q.f(s, "getString(...)");
        p0.d = s;
        p0.c = new com.iloen.melon.fragments.artistchannel.q(this, 2);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            p0.g(new F8.m(2, false));
            titleBar0.a(p0);
            titleBar0.setTitle(this.artistName);
        }
    }

    private static final void onViewCreated$lambda$0(ArtistDetailDetailInfoFragment artistDetailDetailInfoFragment0, View view0) {
        artistDetailDetailInfoFragment0.performBackPress();
    }

    private final void setExpandState(int v, boolean z) {
        if(v >= 0 && v <= 4) {
            this.expandStates[v] = z;
        }
    }

    private final void setGroupTitlePosition(int v, int v1) {
        if(v >= 0 && v <= 4) {
            this.groupTitlePosition[v] = v1;
        }
    }
}

