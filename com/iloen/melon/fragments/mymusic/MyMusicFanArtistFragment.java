package com.iloen.melon.fragments.mymusic;

import B9.e;
import Tf.v;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.BorderImageView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.HttpResponse.Notification;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v4x.request.UserActionsReq.Params;
import com.iloen.melon.net.v4x.request.UserActionsReq;
import com.iloen.melon.net.v4x.response.UserActionsRes.Response.RelationList;
import com.iloen.melon.net.v4x.response.UserActionsRes;
import com.iloen.melon.net.v6x.request.ListArtistMyFanReq;
import com.iloen.melon.net.v6x.request.ListMyFriendlyArtistReq;
import com.iloen.melon.net.v6x.response.ListArtistMyFanRes.RESPONSE.ARTISTLIST;
import com.iloen.melon.net.v6x.response.ListArtistMyFanRes.RESPONSE;
import com.iloen.melon.net.v6x.response.ListArtistMyFanRes;
import com.iloen.melon.net.v6x.response.ListMyFriendlyArtistRes.RESPONSE.CONTENTSLIST;
import com.iloen.melon.net.v6x.response.ListMyFriendlyArtistRes;
import com.iloen.melon.popup.BottomSingleFilterListPopup;
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.a;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.track.Event;
import e1.u;
import ie.H;
import ie.j;
import ie.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import je.n;
import je.w;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.s;
import q8.b;
import q8.c;
import q8.d;
import v9.h;
import v9.i;
import va.e0;
import va.o;

@Metadata(d1 = {"\u0000\u008E\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\n\b\u0007\u0018\u0000 I2\u00020\u0001:\u0003IJKB\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0016\u00A2\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000E\u001A\u0004\u0018\u00010\r2\u0006\u0010\b\u001A\u00020\u00072\b\u0010\n\u001A\u0004\u0018\u00010\t2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0016\u00A2\u0006\u0004\b\u000E\u0010\u000FJ!\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0010\u001A\u00020\r2\b\u0010\f\u001A\u0004\u0018\u00010\u000BH\u0016\u00A2\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u000BH\u0014\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001A\u00020\u00112\u0006\u0010\u0017\u001A\u00020\u000BH\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0016J-\u0010\u001F\u001A\u00020\u001E2\b\u0010\u001A\u001A\u0004\u0018\u00010\u00192\b\u0010\u001C\u001A\u0004\u0018\u00010\u001B2\b\u0010\u001D\u001A\u0004\u0018\u00010\u0004H\u0014\u00A2\u0006\u0004\b\u001F\u0010 J\u000F\u0010\"\u001A\u00020!H\u0014\u00A2\u0006\u0004\b\"\u0010#J\u001B\u0010\'\u001A\u0006\u0012\u0002\b\u00030&2\u0006\u0010%\u001A\u00020$H\u0014\u00A2\u0006\u0004\b\'\u0010(J\u0019\u0010)\u001A\u00020\u00112\b\u0010\u001A\u001A\u0004\u0018\u00010\u0019H\u0002\u00A2\u0006\u0004\b)\u0010*J\u001F\u0010.\u001A\u00020\u00112\u000E\u0010-\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010,0+H\u0002\u00A2\u0006\u0004\b.\u0010/J\u000F\u00100\u001A\u00020\u0011H\u0002\u00A2\u0006\u0004\b0\u0010\u0003JS\u00109\u001A\u00020\u00112\n\b\u0002\u00102\u001A\u0004\u0018\u0001012\u0006\u00103\u001A\u00020\u00042\n\b\u0002\u00105\u001A\u0004\u0018\u0001042\n\b\u0002\u00106\u001A\u0004\u0018\u00010\u00042\u0016\b\u0002\u00108\u001A\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u000107H\u0002\u00A2\u0006\u0004\b9\u0010:R\u0016\u0010;\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010=\u001A\u0002048\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010?\u001A\u0002048\u0002X\u0082D\u00A2\u0006\u0006\n\u0004\b?\u0010>R\u0016\u0010@\u001A\u0002048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b@\u0010>R\u0016\u0010A\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\bA\u0010<R)\u0010H\u001A\u0010\u0012\f\u0012\n C*\u0004\u0018\u00010\u00040\u00040B8BX\u0082\u0084\u0002\u00A2\u0006\f\n\u0004\bD\u0010E\u001A\u0004\bF\u0010G\u00A8\u0006L"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicFanArtistFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "", "getCacheKey", "()Ljava/lang/String;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lie/H;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "requestListArtistMyFan", "(Lv9/i;)V", "Ljava/util/ArrayList;", "Lcom/iloen/melon/net/v6x/response/ListArtistMyFanRes$RESPONSE$ARTISTLIST;", "artistList", "getTemperatureInfoFromServer", "(Ljava/util/ArrayList;)V", "requestListMyFriendlyArtist", "Lcom/kakao/tiara/data/ActionKind;", "actionKind", "layer1", "", "ordNum", "copy", "Lie/m;", "eventMeta", "sentTiaraClickLog", "(Lcom/kakao/tiara/data/ActionKind;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lie/m;)V", "memberKey", "Ljava/lang/String;", "START_INDEX", "I", "PAGE_SIZE", "filterIndex", "tabType", "", "kotlin.jvm.PlatformType", "filterTexts$delegate", "Lie/j;", "getFilterTexts", "()Ljava/util/List;", "filterTexts", "Companion", "FanArtistAdapter", "ServerDataWrapper", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MyMusicFanArtistFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u00052\u0006\u0010\u000E\u001A\u00020\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicFanArtistFragment$Companion;", "", "<init>", "()V", "TAG", "", "TAG_FAN", "CPLAN_TEMPERATURE", "", "SORT_JOIN_ORDER", "SORT_ALPHABET", "newInstance", "Lcom/iloen/melon/fragments/mymusic/MyMusicFanArtistFragment;", "tabType", "targetMemberKey", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MyMusicFanArtistFragment newInstance(@NotNull String s, @NotNull String s1) {
            q.g(s, "tabType");
            q.g(s1, "targetMemberKey");
            MyMusicFanArtistFragment myMusicFanArtistFragment0 = new MyMusicFanArtistFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argTabType", s);
            bundle0.putString("argMemberKey", s1);
            myMusicFanArtistFragment0.setArguments(bundle0);
            return myMusicFanArtistFragment0;
        }
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0082\u0004\u0018\u00002\u0012\u0012\b\u0012\u00060\u0002R\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001*B#\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0012\u0010\b\u001A\u000E\u0012\b\u0012\u00060\u0002R\u00020\u0003\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ-\u0010\u0012\u001A\u00020\u00112\b\u0010\f\u001A\u0004\u0018\u00010\u000B2\b\u0010\u000E\u001A\u0004\u0018\u00010\r2\b\u0010\u0010\u001A\u0004\u0018\u00010\u000FH\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u000F\u0010\u0015\u001A\u00020\u0014H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u001F\u0010\u0019\u001A\u00020\u00142\u0006\u0010\u0017\u001A\u00020\u00142\u0006\u0010\u0018\u001A\u00020\u0014H\u0016¢\u0006\u0004\b\u0019\u0010\u001AJ\u001F\u0010\u001E\u001A\u00020\u00042\u0006\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u001D\u001A\u00020\u0014H\u0016¢\u0006\u0004\b\u001E\u0010\u001FJ)\u0010\"\u001A\u00020!2\b\u0010 \u001A\u0004\u0018\u00010\u00042\u0006\u0010\u0017\u001A\u00020\u00142\u0006\u0010\u0018\u001A\u00020\u0014H\u0016¢\u0006\u0004\b\"\u0010#R\u0014\u0010$\u001A\u00020\u00148\u0002X\u0082D¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010&\u001A\u00020\u00148\u0002X\u0082D¢\u0006\u0006\n\u0004\b&\u0010%R\u0014\u0010\'\u001A\u00020\u00148\u0002X\u0082D¢\u0006\u0006\n\u0004\b\'\u0010%R\u0016\u0010(\u001A\u00020\u00118\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicFanArtistFragment$FanArtistAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/fragments/mymusic/MyMusicFanArtistFragment$ServerDataWrapper;", "Lcom/iloen/melon/fragments/mymusic/MyMusicFanArtistFragment;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "list", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MyMusicFanArtistFragment;Landroid/content/Context;Ljava/util/ArrayList;)V", "", "key", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "response", "", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "", "getHeaderViewItemCount", "()I", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "VIEW_TYPE_HEADER", "I", "VIEW_TYPE_FAN_JOINED", "VIEW_TYPE_FRIENDLY", "isToggleView", "Z", "ArtistItemHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class FanArtistAdapter extends p {
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001A\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001A\u0004\b\n\u0010\bR\u0017\u0010\f\u001A\u00020\u000B8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000FR\u0017\u0010\u0011\u001A\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001A\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001A\u0004\b\u0016\u0010\u0014R\u0017\u0010\u0017\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0006\u001A\u0004\b\u0018\u0010\bR\u0017\u0010\u0019\u001A\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0012\u001A\u0004\b\u001A\u0010\u0014R\u0017\u0010\u001C\u001A\u00020\u001B8\u0006¢\u0006\f\n\u0004\b\u001C\u0010\u001D\u001A\u0004\b\u001E\u0010\u001F¨\u0006 "}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicFanArtistFragment$FanArtistAdapter$ArtistItemHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MyMusicFanArtistFragment$FanArtistAdapter;Landroid/view/View;)V", "Landroid/view/View;", "getView", "()Landroid/view/View;", "dotIv", "getDotIv", "Lcom/iloen/melon/custom/BorderImageView;", "thumbIv", "Lcom/iloen/melon/custom/BorderImageView;", "getThumbIv", "()Lcom/iloen/melon/custom/BorderImageView;", "Landroid/widget/TextView;", "nameTv", "Landroid/widget/TextView;", "getNameTv", "()Landroid/widget/TextView;", "descriptionTv", "getDescriptionTv", "temperatureLayout", "getTemperatureLayout", "temperatureTv", "getTemperatureTv", "Landroid/widget/ImageView;", "degreeIv", "Landroid/widget/ImageView;", "getDegreeIv", "()Landroid/widget/ImageView;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class ArtistItemHolder extends O0 {
            @NotNull
            private final ImageView degreeIv;
            @NotNull
            private final TextView descriptionTv;
            @NotNull
            private final View dotIv;
            @NotNull
            private final TextView nameTv;
            @NotNull
            private final View temperatureLayout;
            @NotNull
            private final TextView temperatureTv;
            @NotNull
            private final BorderImageView thumbIv;
            @NotNull
            private final View view;

            public ArtistItemHolder(@NotNull View view0) {
                q.g(view0, "view");
                FanArtistAdapter.this = myMusicFanArtistFragment$FanArtistAdapter0;
                super(view0);
                this.view = view0;
                View view1 = view0.findViewById(0x7F0A03E1);  // id:dot
                q.f(view1, "findViewById(...)");
                this.dotIv = view1;
                View view2 = view0.findViewById(0x7F0A0893);  // id:name
                q.f(view2, "findViewById(...)");
                this.nameTv = (TextView)view2;
                View view3 = view0.findViewById(0x7F0A03AF);  // id:description
                q.f(view3, "findViewById(...)");
                this.descriptionTv = (TextView)view3;
                View view4 = view0.findViewById(0x7F0A0B46);  // id:temperature_layout
                q.f(view4, "findViewById(...)");
                this.temperatureLayout = view4;
                View view5 = view4.findViewById(0x7F0A0B40);  // id:temperature
                q.f(view5, "findViewById(...)");
                this.temperatureTv = (TextView)view5;
                View view6 = view4.findViewById(0x7F0A039A);  // id:degree
                q.f(view6, "findViewById(...)");
                this.degreeIv = (ImageView)view6;
                View view7 = view0.findViewById(0x7F0A00BF);  // id:artist_thumb_layout
                View view8 = view7.findViewById(0x7F0A069C);  // id:iv_thumb_circle_default
                q.f(view8, "findViewById(...)");
                ViewUtils.setDefaultImage(((ImageView)view8), ScreenUtils.dipToPixel(MyMusicFanArtistFragment.this.getActivity(), 72.0f), true);
                View view9 = view7.findViewById(0x7F0A069B);  // id:iv_thumb_circle
                q.f(view9, "findViewById(...)");
                this.thumbIv = (BorderImageView)view9;
                ((BorderImageView)view9).setBorderWidth(ScreenUtils.dipToPixel(myMusicFanArtistFragment$FanArtistAdapter0.getContext(), 0.5f));
                ((BorderImageView)view9).setBorderColor(ColorUtils.getColor(myMusicFanArtistFragment$FanArtistAdapter0.getContext(), 0x7F06014A));  // color:gray100a
            }

            @NotNull
            public final ImageView getDegreeIv() {
                return this.degreeIv;
            }

            @NotNull
            public final TextView getDescriptionTv() {
                return this.descriptionTv;
            }

            @NotNull
            public final View getDotIv() {
                return this.dotIv;
            }

            @NotNull
            public final TextView getNameTv() {
                return this.nameTv;
            }

            @NotNull
            public final View getTemperatureLayout() {
                return this.temperatureLayout;
            }

            @NotNull
            public final TextView getTemperatureTv() {
                return this.temperatureTv;
            }

            @NotNull
            public final BorderImageView getThumbIv() {
                return this.thumbIv;
            }

            @NotNull
            public final View getView() {
                return this.view;
            }
        }

        private final int VIEW_TYPE_FAN_JOINED;
        private final int VIEW_TYPE_FRIENDLY;
        private final int VIEW_TYPE_HEADER;
        private boolean isToggleView;

        public FanArtistAdapter(@NotNull Context context0, @Nullable ArrayList arrayList0) {
            q.g(context0, "context");
            MyMusicFanArtistFragment.this = myMusicFanArtistFragment0;
            super(context0, arrayList0);
            this.VIEW_TYPE_HEADER = 1;
            this.VIEW_TYPE_FAN_JOINED = 2;
            this.VIEW_TYPE_FRIENDLY = 3;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getHeaderViewItemCount() {
            return this.isToggleView;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return v != 0 || !this.isToggleView ? ((ServerDataWrapper)this.getItem(v1)).getViewType() : this.VIEW_TYPE_HEADER;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(@Nullable String s, @Nullable i i0, @Nullable HttpResponse httpResponse0) {
            if(httpResponse0 instanceof ListArtistMyFanRes) {
                RESPONSE listArtistMyFanRes$RESPONSE0 = ((ListArtistMyFanRes)httpResponse0).getResponse();
                if(listArtistMyFanRes$RESPONSE0 != null) {
                    MyMusicFanArtistFragment myMusicFanArtistFragment0 = MyMusicFanArtistFragment.this;
                    this.setMenuId(listArtistMyFanRes$RESPONSE0.menuId);
                    this.setHasMore(listArtistMyFanRes$RESPONSE0.getHasMore());
                    ArrayList arrayList0 = listArtistMyFanRes$RESPONSE0.getArtistList();
                    this.isToggleView = (arrayList0 == null || arrayList0.isEmpty() ? 1 : 0) ^ 1;
                    ArrayList arrayList1 = listArtistMyFanRes$RESPONSE0.getArtistList();
                    if(arrayList1 != null) {
                        for(Object object0: je.p.i0(arrayList1)) {
                            ServerDataWrapper myMusicFanArtistFragment$ServerDataWrapper0 = new ServerDataWrapper(myMusicFanArtistFragment0);
                            myMusicFanArtistFragment$ServerDataWrapper0.setViewType(this.VIEW_TYPE_FAN_JOINED);
                            myMusicFanArtistFragment$ServerDataWrapper0.setListArtistMyFan(((ARTISTLIST)object0));
                            this.add(myMusicFanArtistFragment$ServerDataWrapper0);
                        }
                    }
                }
            }
            else if(httpResponse0 instanceof ListMyFriendlyArtistRes) {
                com.iloen.melon.net.v6x.response.ListMyFriendlyArtistRes.RESPONSE listMyFriendlyArtistRes$RESPONSE0 = ((ListMyFriendlyArtistRes)httpResponse0).getResponse();
                if(listMyFriendlyArtistRes$RESPONSE0 != null) {
                    MyMusicFanArtistFragment myMusicFanArtistFragment1 = MyMusicFanArtistFragment.this;
                    this.setMenuId(listMyFriendlyArtistRes$RESPONSE0.menuId);
                    ArrayList arrayList2 = listMyFriendlyArtistRes$RESPONSE0.getContentsList();
                    if(arrayList2 != null && !arrayList2.isEmpty()) {
                        ArrayList arrayList3 = listMyFriendlyArtistRes$RESPONSE0.getContentsList();
                        if(arrayList3 != null) {
                            for(Object object1: je.p.i0(arrayList3)) {
                                ServerDataWrapper myMusicFanArtistFragment$ServerDataWrapper1 = new ServerDataWrapper(myMusicFanArtistFragment1);
                                myMusicFanArtistFragment$ServerDataWrapper1.setViewType(this.VIEW_TYPE_FRIENDLY);
                                myMusicFanArtistFragment$ServerDataWrapper1.setListMyFriendlyContents(((CONTENTSLIST)object1));
                                this.add(myMusicFanArtistFragment$ServerDataWrapper1);
                            }
                        }
                    }
                }
            }
            this.updateModifiedTime(this.getCacheKey());
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            if(o00 instanceof e) {
                ((e)o00).a.setVisibility(4);
                List list0 = MyMusicFanArtistFragment.this.getFilterTexts();
                String s = (String)je.p.n0(MyMusicFanArtistFragment.this.filterIndex, list0);
                ((e)o00).b.setText(s);
                com.iloen.melon.fragments.mymusic.e e0 = new com.iloen.melon.fragments.mymusic.e(2, MyMusicFanArtistFragment.this, ((e)o00));
                ((e)o00).b.setOnClickListener(e0);
                return;
            }
            if(o00 instanceof ArtistItemHolder) {
                MyMusicFanArtistFragment myMusicFanArtistFragment0 = MyMusicFanArtistFragment.this;
                ArtistItemHolder myMusicFanArtistFragment$FanArtistAdapter$ArtistItemHolder0 = (ArtistItemHolder)o00;
                ServerDataWrapper myMusicFanArtistFragment$ServerDataWrapper0 = (ServerDataWrapper)this.getItem(v1);
                int v2 = 8;
                if(myMusicFanArtistFragment$ServerDataWrapper0.getViewType() == this.VIEW_TYPE_FAN_JOINED) {
                    ARTISTLIST listArtistMyFanRes$RESPONSE$ARTISTLIST0 = myMusicFanArtistFragment$ServerDataWrapper0.getListArtistMyFan();
                    myMusicFanArtistFragment$FanArtistAdapter$ArtistItemHolder0.getView().setOnClickListener(new f(myMusicFanArtistFragment0, v1, listArtistMyFanRes$RESPONSE$ARTISTLIST0, 1));
                    myMusicFanArtistFragment$FanArtistAdapter$ArtistItemHolder0.getDotIv().setVisibility((q.b(listArtistMyFanRes$RESPONSE$ARTISTLIST0.newIconYn, "Y") ? 0 : 8));
                    Glide.with(myMusicFanArtistFragment$FanArtistAdapter$ArtistItemHolder0.getThumbIv().getContext()).load(listArtistMyFanRes$RESPONSE$ARTISTLIST0.getArtistImg()).apply(RequestOptions.circleCropTransform()).into(myMusicFanArtistFragment$FanArtistAdapter$ArtistItemHolder0.getThumbIv());
                    myMusicFanArtistFragment$FanArtistAdapter$ArtistItemHolder0.getNameTv().setText(listArtistMyFanRes$RESPONSE$ARTISTLIST0.getArtistName());
                    myMusicFanArtistFragment$FanArtistAdapter$ArtistItemHolder0.getDescriptionTv().setVisibility(8);
                    int v3 = ProtocolUtils.parseInt("", -1000);
                    if(v3 >= 0) {
                        myMusicFanArtistFragment$FanArtistAdapter$ArtistItemHolder0.getTemperatureTv().setText("");
                        myMusicFanArtistFragment$FanArtistAdapter$ArtistItemHolder0.getTemperatureTv().setTextColor(ResourceUtils.getFriendlyColorId(myMusicFanArtistFragment0.getActivity(), v3));
                        myMusicFanArtistFragment$FanArtistAdapter$ArtistItemHolder0.getDegreeIv().setBackgroundResource(ResourceUtils.get6dpDegreeImageResId(v3));
                    }
                    View view0 = myMusicFanArtistFragment$FanArtistAdapter$ArtistItemHolder0.getTemperatureLayout();
                    if(v3 >= 0) {
                        v2 = 0;
                    }
                    view0.setVisibility(v2);
                    return;
                }
                if(myMusicFanArtistFragment$ServerDataWrapper0.getViewType() == this.VIEW_TYPE_FRIENDLY) {
                    CONTENTSLIST listMyFriendlyArtistRes$RESPONSE$CONTENTSLIST0 = myMusicFanArtistFragment$ServerDataWrapper0.getListMyFriendlyContents();
                    myMusicFanArtistFragment$FanArtistAdapter$ArtistItemHolder0.getView().setOnClickListener(new f(myMusicFanArtistFragment0, v1, listMyFriendlyArtistRes$RESPONSE$CONTENTSLIST0, 2));
                    myMusicFanArtistFragment$FanArtistAdapter$ArtistItemHolder0.getDotIv().setVisibility((q.b(listMyFriendlyArtistRes$RESPONSE$CONTENTSLIST0.getNewIconYn(), "Y") ? 0 : 8));
                    Glide.with(myMusicFanArtistFragment$FanArtistAdapter$ArtistItemHolder0.getThumbIv().getContext()).load(listMyFriendlyArtistRes$RESPONSE$CONTENTSLIST0.getArtistImg()).apply(RequestOptions.circleCropTransform()).into(myMusicFanArtistFragment$FanArtistAdapter$ArtistItemHolder0.getThumbIv());
                    myMusicFanArtistFragment$FanArtistAdapter$ArtistItemHolder0.getNameTv().setText(listMyFriendlyArtistRes$RESPONSE$CONTENTSLIST0.getArtistName());
                    String s1 = myMusicFanArtistFragment0.getString(0x7F13076E);  // string:mymusic_fan_artist_rank "%1$s명 중 %2$s번째 팬"
                    q.f(s1, "getString(...)");
                    myMusicFanArtistFragment$FanArtistAdapter$ArtistItemHolder0.getDescriptionTv().setText(String.format(s1, Arrays.copyOf(new Object[]{listMyFriendlyArtistRes$RESPONSE$CONTENTSLIST0.getTotalUserRank(), listMyFriendlyArtistRes$RESPONSE$CONTENTSLIST0.getUserRank()}, 2)));
                    myMusicFanArtistFragment$FanArtistAdapter$ArtistItemHolder0.getDescriptionTv().setVisibility(0);
                    String s2 = listMyFriendlyArtistRes$RESPONSE$CONTENTSLIST0.getUserTemper();
                    Integer integer0 = s2 == null ? null : v.t0(s2);
                    if(integer0 != null) {
                        myMusicFanArtistFragment$FanArtistAdapter$ArtistItemHolder0.getTemperatureTv().setText(listMyFriendlyArtistRes$RESPONSE$CONTENTSLIST0.getUserTemper());
                        myMusicFanArtistFragment$FanArtistAdapter$ArtistItemHolder0.getTemperatureTv().setTextColor(ResourceUtils.getFriendlyColorId(myMusicFanArtistFragment0.getActivity(), ((int)integer0)));
                        myMusicFanArtistFragment$FanArtistAdapter$ArtistItemHolder0.getDegreeIv().setBackgroundResource(ResourceUtils.get6dpDegreeImageResId(((int)integer0)));
                        myMusicFanArtistFragment$FanArtistAdapter$ArtistItemHolder0.getTemperatureLayout().setVisibility(0);
                        return;
                    }
                    myMusicFanArtistFragment$FanArtistAdapter$ArtistItemHolder0.getTemperatureLayout().setVisibility(8);
                }
            }
        }

        private static final void onBindViewImpl$lambda$11$lambda$10(MyMusicFanArtistFragment myMusicFanArtistFragment0, int v, CONTENTSLIST listMyFriendlyArtistRes$RESPONSE$CONTENTSLIST0, View view0) {
            ActionKind actionKind0 = ActionKind.ClickContent;
            String s = myMusicFanArtistFragment0.getString(0x7F130EC5);  // string:tiara_library_layer1_friendly_list "친한목록"
            q.f(s, "getString(...)");
            Integer integer0 = (int)(v + 1);
            String s1 = listMyFriendlyArtistRes$RESPONSE$CONTENTSLIST0.getArtistId();
            String s2 = "";
            if(s1 == null) {
                s1 = "";
            }
            String s3 = listMyFriendlyArtistRes$RESPONSE$CONTENTSLIST0.getArtistName();
            if(s3 != null) {
                s2 = s3;
            }
            MyMusicFanArtistFragment.sentTiaraClickLog$default(myMusicFanArtistFragment0, actionKind0, s, integer0, null, new m(s1, s2), 8, null);
            myMusicFanArtistFragment0.showArtistInfoPage(listMyFriendlyArtistRes$RESPONSE$CONTENTSLIST0.getArtistId());
        }

        private static final void onBindViewImpl$lambda$11$lambda$9(MyMusicFanArtistFragment myMusicFanArtistFragment0, int v, ARTISTLIST listArtistMyFanRes$RESPONSE$ARTISTLIST0, View view0) {
            ActionKind actionKind0 = ActionKind.ClickContent;
            String s = myMusicFanArtistFragment0.getString(0x7F130EC4);  // string:tiara_library_layer1_fan_list "팬맺은목록"
            q.f(s, "getString(...)");
            Integer integer0 = (int)(v + 1);
            String s1 = listArtistMyFanRes$RESPONSE$ARTISTLIST0.getArtistId();
            String s2 = "";
            if(s1 == null) {
                s1 = "";
            }
            String s3 = listArtistMyFanRes$RESPONSE$ARTISTLIST0.getArtistName();
            if(s3 != null) {
                s2 = s3;
            }
            MyMusicFanArtistFragment.sentTiaraClickLog$default(myMusicFanArtistFragment0, actionKind0, s, integer0, null, new m(s1, s2), 8, null);
            myMusicFanArtistFragment0.showArtistInfoPage(listArtistMyFanRes$RESPONSE$ARTISTLIST0.getArtistId());
        }

        private static final void onBindViewImpl$lambda$8$lambda$7(MyMusicFanArtistFragment myMusicFanArtistFragment0, O0 o00, View view0) {
            if(myMusicFanArtistFragment0.isPossiblePopupShow()) {
                FragmentActivity fragmentActivity0 = myMusicFanArtistFragment0.getActivity();
                if(fragmentActivity0 != null) {
                    String s = myMusicFanArtistFragment0.getString(0x7F1307D1);  // string:order_by "정렬"
                    q.f(s, "getString(...)");
                    MyMusicFanArtistFragment.sentTiaraClickLog$default(myMusicFanArtistFragment0, null, s, null, myMusicFanArtistFragment0.getString(0x7F1307D1), null, 21, null);  // string:order_by "정렬"
                    BottomSingleFilterListPopup bottomSingleFilterListPopup0 = new BottomSingleFilterListPopup(fragmentActivity0);
                    bottomSingleFilterListPopup0.setTitle(0x7F1307D1);  // string:order_by "정렬"
                    bottomSingleFilterListPopup0.setFilterItem(myMusicFanArtistFragment0.getFilterTexts(), myMusicFanArtistFragment0.filterIndex);
                    bottomSingleFilterListPopup0.setFilterListener(new g(myMusicFanArtistFragment0, o00, 1));
                    bottomSingleFilterListPopup0.setOnDismissListener(myMusicFanArtistFragment0.mDialogDismissListener);
                    myMusicFanArtistFragment0.mRetainDialog = bottomSingleFilterListPopup0;
                    bottomSingleFilterListPopup0.show();
                }
            }
        }

        private static final void onBindViewImpl$lambda$8$lambda$7$lambda$6(MyMusicFanArtistFragment myMusicFanArtistFragment0, O0 o00, int v) {
            myMusicFanArtistFragment0.filterIndex = v;
            j0 j00 = myMusicFanArtistFragment0.getAdapter();
            FanArtistAdapter myMusicFanArtistFragment$FanArtistAdapter0 = j00 instanceof FanArtistAdapter ? ((FanArtistAdapter)j00) : null;
            if(myMusicFanArtistFragment$FanArtistAdapter0 != null) {
                myMusicFanArtistFragment$FanArtistAdapter0.clear(true);
            }
            String s = (String)je.p.n0(myMusicFanArtistFragment0.filterIndex, myMusicFanArtistFragment0.getFilterTexts());
            ((e)o00).b.setText(s);
            myMusicFanArtistFragment0.startFetch("filter change");
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            if(v == this.VIEW_TYPE_HEADER) {
                return z6.f.p(viewGroup0, 0.0f, 6);
            }
            View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0564, viewGroup0, false);  // layout:mymusic_fan_artist_item
            q.f(view0, "inflate(...)");
            return new ArtistItemHolder(this, view0);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001A\u0010\n\u001A\u00020\u000BX\u0086.¢\u0006\u000E\n\u0000\u001A\u0004\b\f\u0010\r\"\u0004\b\u000E\u0010\u000FR\u001A\u0010\u0010\u001A\u00020\u0011X\u0086.¢\u0006\u000E\n\u0000\u001A\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/MyMusicFanArtistFragment$ServerDataWrapper;", "", "<init>", "(Lcom/iloen/melon/fragments/mymusic/MyMusicFanArtistFragment;)V", "viewType", "", "getViewType", "()I", "setViewType", "(I)V", "listArtistMyFan", "Lcom/iloen/melon/net/v6x/response/ListArtistMyFanRes$RESPONSE$ARTISTLIST;", "getListArtistMyFan", "()Lcom/iloen/melon/net/v6x/response/ListArtistMyFanRes$RESPONSE$ARTISTLIST;", "setListArtistMyFan", "(Lcom/iloen/melon/net/v6x/response/ListArtistMyFanRes$RESPONSE$ARTISTLIST;)V", "listMyFriendlyContents", "Lcom/iloen/melon/net/v6x/response/ListMyFriendlyArtistRes$RESPONSE$CONTENTSLIST;", "getListMyFriendlyContents", "()Lcom/iloen/melon/net/v6x/response/ListMyFriendlyArtistRes$RESPONSE$CONTENTSLIST;", "setListMyFriendlyContents", "(Lcom/iloen/melon/net/v6x/response/ListMyFriendlyArtistRes$RESPONSE$CONTENTSLIST;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class ServerDataWrapper {
        public ARTISTLIST listArtistMyFan;
        public CONTENTSLIST listMyFriendlyContents;
        private int viewType;

        public ServerDataWrapper() {
            this.viewType = -1;
        }

        @NotNull
        public final ARTISTLIST getListArtistMyFan() {
            ARTISTLIST listArtistMyFanRes$RESPONSE$ARTISTLIST0 = this.listArtistMyFan;
            if(listArtistMyFanRes$RESPONSE$ARTISTLIST0 != null) {
                return listArtistMyFanRes$RESPONSE$ARTISTLIST0;
            }
            q.m("listArtistMyFan");
            throw null;
        }

        @NotNull
        public final CONTENTSLIST getListMyFriendlyContents() {
            CONTENTSLIST listMyFriendlyArtistRes$RESPONSE$CONTENTSLIST0 = this.listMyFriendlyContents;
            if(listMyFriendlyArtistRes$RESPONSE$CONTENTSLIST0 != null) {
                return listMyFriendlyArtistRes$RESPONSE$CONTENTSLIST0;
            }
            q.m("listMyFriendlyContents");
            throw null;
        }

        public final int getViewType() {
            return this.viewType;
        }

        public final void setListArtistMyFan(@NotNull ARTISTLIST listArtistMyFanRes$RESPONSE$ARTISTLIST0) {
            q.g(listArtistMyFanRes$RESPONSE$ARTISTLIST0, "<set-?>");
            this.listArtistMyFan = listArtistMyFanRes$RESPONSE$ARTISTLIST0;
        }

        public final void setListMyFriendlyContents(@NotNull CONTENTSLIST listMyFriendlyArtistRes$RESPONSE$CONTENTSLIST0) {
            q.g(listMyFriendlyArtistRes$RESPONSE$CONTENTSLIST0, "<set-?>");
            this.listMyFriendlyContents = listMyFriendlyArtistRes$RESPONSE$CONTENTSLIST0;
        }

        public final void setViewType(int v) {
            this.viewType = v;
        }
    }

    public static final int $stable = 0;
    private static final int CPLAN_TEMPERATURE = -1000;
    @NotNull
    public static final Companion Companion = null;
    private final int PAGE_SIZE;
    private static final int SORT_ALPHABET = 1;
    private static final int SORT_JOIN_ORDER = 0;
    private final int START_INDEX;
    @NotNull
    private static final String TAG = "MyMusicFanArtistFragment";
    @NotNull
    private static final String TAG_FAN = "MyMusicFanArtistFragment_FAN";
    private int filterIndex;
    @NotNull
    private final j filterTexts$delegate;
    @NotNull
    private String memberKey;
    @NotNull
    private String tabType;

    static {
        MyMusicFanArtistFragment.Companion = new Companion(null);
        MyMusicFanArtistFragment.$stable = 8;
    }

    public MyMusicFanArtistFragment() {
        this.memberKey = "";
        this.START_INDEX = 1;
        this.PAGE_SIZE = 100;
        this.tabType = "fan_joined";
        this.filterTexts$delegate = d3.g.Q(new k(this, 1));
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        j0 j00 = new FanArtistAdapter(this, context0, null);
        v9.e e0 = new v9.e();  // 初始化器: Ljava/lang/Object;-><init>()V
        e0.d = -1;
        e0.e = -1;
        e0.g = -1;
        e0.i = -1;
        e0.k = -1;
        e0.l = -1;
        e0.c = ScreenUtils.dipToPixel(context0, 432.0f);
        ((p)j00).setEmptyViewInfo(e0);
        return j00;
    }

    private static final List filterTexts_delegate$lambda$0(MyMusicFanArtistFragment myMusicFanArtistFragment0) {
        Context context0 = myMusicFanArtistFragment0.getContext();
        if(context0 != null) {
            Resources resources0 = context0.getResources();
            if(resources0 != null) {
                String[] arr_s = resources0.getStringArray(0x7F03001D);  // array:my_music_fan_artist_fan_filter_type
                if(arr_s != null) {
                    return n.N(arr_s);
                }
            }
        }
        return w.a;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.f(MelonContentUris.c0.buildUpon().appendQueryParameter("tabType", this.tabType).appendQueryParameter("filterIndex", String.valueOf(this.filterIndex)), "targetMemberKey", this.memberKey, "toString(...)");
    }

    private final List getFilterTexts() {
        return (List)this.filterTexts$delegate.getValue();
    }

    private final void getTemperatureInfoFromServer(ArrayList arrayList0) {
        if(this.isLoginUser()) {
            StringBuilder stringBuilder0 = new StringBuilder();
            Iterator iterator0 = arrayList0.iterator();
            q.f(iterator0, "iterator(...)");
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                ARTISTLIST listArtistMyFanRes$RESPONSE$ARTISTLIST0 = (ARTISTLIST)object0;
                try {
                    stringBuilder0.append((listArtistMyFanRes$RESPONSE$ARTISTLIST0 == null ? null : listArtistMyFanRes$RESPONSE$ARTISTLIST0.getArtistId()));
                    stringBuilder0.append(",");
                }
                catch(Exception unused_ex) {
                }
            }
            int v = stringBuilder0.length();
            if(v != 0) {
                stringBuilder0.setLength(v - 1);
                Params userActionsReq$Params0 = new Params();
                userActionsReq$Params0.fields = "temperature";
                userActionsReq$Params0.contsTypeCode = "N10006";
                userActionsReq$Params0.contsId = stringBuilder0.toString();
                RequestBuilder.newInstance(new UserActionsReq(this.getContext(), userActionsReq$Params0)).tag(this.getRequestTag()).listener(new g(this, arrayList0, 12)).errorListener(new W(8)).request();
            }
        }
    }

    private static final void getTemperatureInfoFromServer$lambda$7(MyMusicFanArtistFragment myMusicFanArtistFragment0, ArrayList arrayList0, UserActionsRes userActionsRes0) {
        if(myMusicFanArtistFragment0.isFragmentValid() && userActionsRes0 != null) {
            Notification httpResponse$Notification0 = userActionsRes0.notification;
            if(httpResponse$Notification0 == null) {
                httpResponse$Notification0 = null;
            }
            else {
                Cb.j.b(httpResponse$Notification0, false, 3);
            }
            if(Cb.j.c(httpResponse$Notification0) && userActionsRes0.response != null) {
                int v1 = arrayList0.size();
                for(int v = 0; v < v1; ++v) {
                    try {
                        RelationList userActionsRes$Response$RelationList0 = (RelationList)userActionsRes0.response.relationList.get(v);
                        ARTISTLIST listArtistMyFanRes$RESPONSE$ARTISTLIST0 = (ARTISTLIST)arrayList0.get(v);
                        if(listArtistMyFanRes$RESPONSE$ARTISTLIST0 != null) {
                            String s = userActionsRes$Response$RelationList0.fields.temperature;
                            q.f(s, "temperature");
                            listArtistMyFanRes$RESPONSE$ARTISTLIST0.setTemperature(s);
                        }
                    }
                    catch(Exception unused_ex) {
                    }
                }
                myMusicFanArtistFragment0.getAdapter().notifyDataSetChanged();
            }
        }
    }

    private static final void getTemperatureInfoFromServer$lambda$8(VolleyError volleyError0) {
        a.v("error : ", volleyError0.getMessage(), LogU.Companion, "MyMusicFanArtistFragment");
    }

    public static void i0(MyMusicFanArtistFragment myMusicFanArtistFragment0, ListMyFriendlyArtistRes listMyFriendlyArtistRes0) {
        MyMusicFanArtistFragment.requestListMyFriendlyArtist$lambda$10(myMusicFanArtistFragment0, listMyFriendlyArtistRes0);
    }

    @NotNull
    public static final MyMusicFanArtistFragment newInstance(@NotNull String s, @NotNull String s1) {
        return MyMusicFanArtistFragment.Companion.newInstance(s, s1);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setHasFixedSize(true);
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(((RecyclerView)view0).getContext()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D0570, viewGroup0, false);  // layout:myrmusic_fan_artist_more
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        if(i.b.equals(i0)) {
            j0 j00 = this.mAdapter;
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.MyMusicFanArtistFragment.FanArtistAdapter");
            ((FanArtistAdapter)j00).clear();
        }
        String s1 = this.tabType;
        if(q.b(s1, "fan_joined")) {
            this.requestListArtistMyFan(i0);
            return true;
        }
        if(q.b(s1, "friendly")) {
            this.requestListMyFriendlyArtist();
            return true;
        }
        this.requestListArtistMyFan(i0);
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
        String s = bundle0.getString("argTabType");
        String s1 = "";
        if(s == null) {
            s = "";
        }
        this.tabType = s;
        String s2 = bundle0.getString("argMemberKey");
        if(s2 != null) {
            s1 = s2;
        }
        this.memberKey = s1;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argTabType", this.tabType);
        bundle0.putString("argMemberKey", this.memberKey);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        this.getTitleBar().setVisibility(8);
        View view1 = this.findViewById(0x7F0A0430);  // id:empty_view
        this.mEmptyView = view1;
        ViewUtils.showWhen(view1, this.getItemCount() == 0);
    }

    private final void requestListArtistMyFan(i i0) {
        int v;
        com.iloen.melon.net.v6x.request.ListArtistMyFanReq.Params listArtistMyFanReq$Params0 = new com.iloen.melon.net.v6x.request.ListArtistMyFanReq.Params();
        if(i.b.equals(i0)) {
            v = this.START_INDEX;
        }
        else {
            j0 j00 = this.getAdapter();
            q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.mymusic.MyMusicFanArtistFragment.FanArtistAdapter");
            v = ((FanArtistAdapter)j00).getCount() + 1;
        }
        listArtistMyFanReq$Params0.startIndex = v;
        listArtistMyFanReq$Params0.orderBy = this.filterIndex == 1 ? "ALPHABET" : "NEW";
        listArtistMyFanReq$Params0.pageSize = this.PAGE_SIZE;
        listArtistMyFanReq$Params0.targetMemberKey = u.v(((e0)o.a()).j());
        RequestBuilder.newInstance(new ListArtistMyFanReq(this.getContext(), listArtistMyFanReq$Params0)).tag(this.getRequestTag()).listener(new g(this, i0, 13)).errorListener(this.mResponseErrorListener).request();
    }

    private static final void requestListArtistMyFan$lambda$4(MyMusicFanArtistFragment myMusicFanArtistFragment0, i i0, ListArtistMyFanRes listArtistMyFanRes0) {
        if(myMusicFanArtistFragment0.prepareFetchComplete(listArtistMyFanRes0)) {
            RESPONSE listArtistMyFanRes$RESPONSE0 = listArtistMyFanRes0.getResponse();
            if(listArtistMyFanRes$RESPONSE0 != null) {
                myMusicFanArtistFragment0.mMelonTiaraProperty = new s(listArtistMyFanRes$RESPONSE0.section, listArtistMyFanRes$RESPONSE0.page, listArtistMyFanRes$RESPONSE0.menuId, null);
            }
            myMusicFanArtistFragment0.performFetchComplete(i0, listArtistMyFanRes0);
            RESPONSE listArtistMyFanRes$RESPONSE1 = listArtistMyFanRes0.getResponse();
            if(listArtistMyFanRes$RESPONSE1 != null) {
                ArrayList arrayList0 = listArtistMyFanRes$RESPONSE1.getArtistList();
                if(arrayList0 != null) {
                    myMusicFanArtistFragment0.getTemperatureInfoFromServer(arrayList0);
                }
            }
        }
    }

    private final void requestListMyFriendlyArtist() {
        RequestBuilder.newInstance(new ListMyFriendlyArtistReq(this.getContext())).tag(this.getRequestTag()).listener(new B(this, 8)).errorListener(this.mResponseErrorListener).request();
    }

    private static final void requestListMyFriendlyArtist$lambda$10(MyMusicFanArtistFragment myMusicFanArtistFragment0, ListMyFriendlyArtistRes listMyFriendlyArtistRes0) {
        if(!myMusicFanArtistFragment0.prepareFetchComplete(listMyFriendlyArtistRes0)) {
            return;
        }
        com.iloen.melon.net.v6x.response.ListMyFriendlyArtistRes.RESPONSE listMyFriendlyArtistRes$RESPONSE0 = listMyFriendlyArtistRes0.getResponse();
        if(listMyFriendlyArtistRes$RESPONSE0 != null) {
            myMusicFanArtistFragment0.mMelonTiaraProperty = new s(listMyFriendlyArtistRes$RESPONSE0.section, listMyFriendlyArtistRes$RESPONSE0.page, listMyFriendlyArtistRes$RESPONSE0.menuId, null);
        }
        myMusicFanArtistFragment0.performFetchComplete(listMyFriendlyArtistRes0);
    }

    private final void sentTiaraClickLog(ActionKind actionKind0, String s, Integer integer0, String s1, m m0) {
        s s2 = this.mMelonTiaraProperty;
        if(s2 != null) {
            d d0 = new d();  // 初始化器: LQb/h;-><init>()V
            MyMusicFanArtistFragment.sentTiaraClickLog$lambda$31$lambda$30(m0, this, s2, actionKind0, s, integer0, s1, d0);
            ((Event)d0.p()).track();
        }
    }

    public static void sentTiaraClickLog$default(MyMusicFanArtistFragment myMusicFanArtistFragment0, ActionKind actionKind0, String s, Integer integer0, String s1, m m0, int v, Object object0) {
        if((v & 1) != 0) {
            actionKind0 = null;
        }
        if((v & 4) != 0) {
            integer0 = null;
        }
        if((v & 8) != 0) {
            s1 = null;
        }
        if((v & 16) != 0) {
            m0 = null;
        }
        myMusicFanArtistFragment0.sentTiaraClickLog(actionKind0, s, integer0, s1, m0);
    }

    private static final H sentTiaraClickLog$lambda$31$lambda$30(m m0, MyMusicFanArtistFragment myMusicFanArtistFragment0, s s0, ActionKind actionKind0, String s1, Integer integer0, String s2, d d0) {
        q.g(d0, "$this$tiaraEventLogBuilder");
        MyMusicFanArtistFragment.sentTiaraClickLog$lambda$31$lambda$30$lambda$14(myMusicFanArtistFragment0, ((q8.h)d0.b));
        b b0 = (b)d0.c;
        if(b0 == null) {
            b b1 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
            MyMusicFanArtistFragment.sentTiaraClickLog$lambda$31$lambda$30$lambda$18(s0, actionKind0, b1);
            d0.c = b1;
        }
        else {
            MyMusicFanArtistFragment.sentTiaraClickLog$lambda$31$lambda$30$lambda$18(s0, actionKind0, b0);
        }
        q8.a a0 = (q8.a)d0.d;
        if(a0 == null) {
            q8.a a1 = new q8.a();  // 初始化器: Lcom/kakao/tiara/data/Click$Builder;-><init>()V
            MyMusicFanArtistFragment.sentTiaraClickLog$lambda$31$lambda$30$lambda$22(s1, integer0, s2, a1);
            d0.d = a1;
        }
        else {
            MyMusicFanArtistFragment.sentTiaraClickLog$lambda$31$lambda$30$lambda$22(s1, integer0, s2, a0);
        }
        if(m0 != null) {
            q8.f f0 = (q8.f)d0.e;
            if(f0 == null) {
                q8.f f1 = new q8.f();  // 初始化器: Ljava/lang/Object;-><init>()V
                MyMusicFanArtistFragment.sentTiaraClickLog$lambda$31$lambda$30$lambda$27$lambda$26(m0, myMusicFanArtistFragment0, f1);
                d0.e = f1;
            }
            else {
                MyMusicFanArtistFragment.sentTiaraClickLog$lambda$31$lambda$30$lambda$27$lambda$26(m0, myMusicFanArtistFragment0, f0);
            }
        }
        c c0 = new c();
        MyMusicFanArtistFragment.sentTiaraClickLog$lambda$31$lambda$30$lambda$29(s0, c0);
        ((LinkedHashMap)d0.g).putAll(c0.a);
        return H.a;
    }

    private static final H sentTiaraClickLog$lambda$31$lambda$30$lambda$14(MyMusicFanArtistFragment myMusicFanArtistFragment0, q8.h h0) {
        q.g(h0, "$this$track");
        String s = MyMusicFanArtistFragment.sentTiaraClickLog$lambda$31$lambda$30$lambda$14$lambda$13(myMusicFanArtistFragment0);
        if(s == null) {
            s = "";
        }
        h0.a = s;
        return H.a;
    }

    private static final String sentTiaraClickLog$lambda$31$lambda$30$lambda$14$lambda$13(MyMusicFanArtistFragment myMusicFanArtistFragment0) {
        return myMusicFanArtistFragment0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
    }

    private static final H sentTiaraClickLog$lambda$31$lambda$30$lambda$18(s s0, ActionKind actionKind0, b b0) {
        q.g(b0, "$this$common");
        b0.a = MyMusicFanArtistFragment.sentTiaraClickLog$lambda$31$lambda$30$lambda$18$lambda$15(s0);
        b0.b = MyMusicFanArtistFragment.sentTiaraClickLog$lambda$31$lambda$30$lambda$18$lambda$16(s0);
        b0.c = actionKind0;
        return H.a;
    }

    private static final String sentTiaraClickLog$lambda$31$lambda$30$lambda$18$lambda$15(s s0) {
        return s0.a;
    }

    private static final String sentTiaraClickLog$lambda$31$lambda$30$lambda$18$lambda$16(s s0) {
        return s0.b;
    }

    private static final ActionKind sentTiaraClickLog$lambda$31$lambda$30$lambda$18$lambda$17(ActionKind actionKind0) [...] // Inlined contents

    private static final H sentTiaraClickLog$lambda$31$lambda$30$lambda$22(String s, Integer integer0, String s1, q8.a a0) {
        q.g(a0, "$this$click");
        a0.a = s;
        a0.e = MyMusicFanArtistFragment.sentTiaraClickLog$lambda$31$lambda$30$lambda$22$lambda$20(integer0);
        a0.g = s1;
        return H.a;
    }

    private static final String sentTiaraClickLog$lambda$31$lambda$30$lambda$22$lambda$19(String s) [...] // Inlined contents

    private static final String sentTiaraClickLog$lambda$31$lambda$30$lambda$22$lambda$20(Integer integer0) {
        return integer0 == null ? null : integer0.toString();
    }

    private static final String sentTiaraClickLog$lambda$31$lambda$30$lambda$22$lambda$21(String s) [...] // Inlined contents

    private static final H sentTiaraClickLog$lambda$31$lambda$30$lambda$27$lambda$26(m m0, MyMusicFanArtistFragment myMusicFanArtistFragment0, q8.f f0) {
        q.g(f0, "$this$eventMeta");
        f0.a = MyMusicFanArtistFragment.sentTiaraClickLog$lambda$31$lambda$30$lambda$27$lambda$26$lambda$23(m0);
        f0.b = MyMusicFanArtistFragment.sentTiaraClickLog$lambda$31$lambda$30$lambda$27$lambda$26$lambda$24(myMusicFanArtistFragment0);
        f0.c = MyMusicFanArtistFragment.sentTiaraClickLog$lambda$31$lambda$30$lambda$27$lambda$26$lambda$25(m0);
        return H.a;
    }

    private static final String sentTiaraClickLog$lambda$31$lambda$30$lambda$27$lambda$26$lambda$23(m m0) {
        return (String)m0.a;
    }

    private static final String sentTiaraClickLog$lambda$31$lambda$30$lambda$27$lambda$26$lambda$24(MyMusicFanArtistFragment myMusicFanArtistFragment0) {
        return myMusicFanArtistFragment0.getString(0x7F130EF1);  // string:tiara_meta_type_artist "아티스트"
    }

    private static final String sentTiaraClickLog$lambda$31$lambda$30$lambda$27$lambda$26$lambda$25(m m0) {
        return (String)m0.b;
    }

    private static final H sentTiaraClickLog$lambda$31$lambda$30$lambda$29(s s0, c c0) {
        q.g(c0, "$this$customProps");
        String s1 = MyMusicFanArtistFragment.sentTiaraClickLog$lambda$31$lambda$30$lambda$29$lambda$28(s0);
        c0.a.put("menuid", s1);
        return H.a;
    }

    private static final String sentTiaraClickLog$lambda$31$lambda$30$lambda$29$lambda$28(s s0) {
        return s0.c == null ? "" : s0.c;
    }
}

