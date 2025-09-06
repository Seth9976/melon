package com.iloen.melon.fragments.artistchannel.topic;

import Cb.k;
import J8.f3;
import J8.k3;
import J8.l3;
import J8.m3;
import J8.n3;
import J8.o3;
import J8.p3;
import J8.q3;
import P1.c;
import Q4.a;
import Tf.o;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.recyclerview.widget.O0;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.fragments.FetcherBaseFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v6x.request.GoscrapKakaoReq;
import com.iloen.melon.net.v6x.response.ArtistContentsArtistTopicInfoRes.RESPONSE.TOPICCONTENTSLIST;
import com.iloen.melon.net.v6x.response.GoscrapKakaoRes.IMAGE;
import com.iloen.melon.net.v6x.response.GoscrapKakaoRes.OPENGRAPH;
import com.iloen.melon.net.v6x.response.GoscrapKakaoRes;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.LyricHighlightUtils;
import ie.H;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import we.n;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\b\'\u0018\u0000 \u00172\u00020\u0001:\b\u0017\u0018\u0019\u001A\u001B\u001C\u001D\u001EB\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR$\u0010\f\u001A\u0004\u0018\u00010\u000B8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\f\u0010\r\u001A\u0004\b\u000E\u0010\u000F\"\u0004\b\u0010\u0010\u0011R\u001C\u0010\u0013\u001A\u0004\u0018\u00010\u00128\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001A\u0004\b\u0015\u0010\u0016¨\u0006\u001F"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/topic/TopicContentsViewHolder;", "Landroidx/recyclerview/widget/O0;", "LQ4/a;", "binding", "<init>", "(LQ4/a;)V", "Lcom/iloen/melon/net/v6x/response/ArtistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST;", "topicContents", "Lie/H;", "bind", "(Lcom/iloen/melon/net/v6x/response/ArtistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST;)V", "Lcom/iloen/melon/fragments/artistchannel/topic/TopicContentsViewHolder$OnViewHolderClickListener;", "onViewHolderClickListener", "Lcom/iloen/melon/fragments/artistchannel/topic/TopicContentsViewHolder$OnViewHolderClickListener;", "getOnViewHolderClickListener", "()Lcom/iloen/melon/fragments/artistchannel/topic/TopicContentsViewHolder$OnViewHolderClickListener;", "setOnViewHolderClickListener", "(Lcom/iloen/melon/fragments/artistchannel/topic/TopicContentsViewHolder$OnViewHolderClickListener;)V", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Companion", "TopicContentsImageViewHolder", "TopicContentsTextViewHolder", "TopicContentsMvViewHolder", "TopicContentsSongViewHolder", "TopicContentsLinkViewHolder", "TopicContentsUnknownViewHolder", "OnViewHolderClickListener", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public abstract class TopicContentsViewHolder extends O0 {
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/topic/TopicContentsViewHolder$Companion;", "", "<init>", "()V", "TAG", "", "OK_CODE", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/topic/TopicContentsViewHolder$OnViewHolderClickListener;", "", "Lcom/iloen/melon/net/v6x/response/ArtistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST;", "topicContents", "Lie/H;", "onViewClick", "(Lcom/iloen/melon/net/v6x/response/ArtistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST;)V", "onPlayClick", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface OnViewHolderClickListener {
        void onPlayClick(@NotNull TOPICCONTENTSLIST arg1);

        void onViewClick(@NotNull TOPICCONTENTSLIST arg1);
    }

    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/topic/TopicContentsViewHolder$TopicContentsImageViewHolder;", "Lcom/iloen/melon/fragments/artistchannel/topic/TopicContentsViewHolder;", "LJ8/k3;", "binding", "<init>", "(LJ8/k3;)V", "Lcom/iloen/melon/net/v6x/response/ArtistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST;", "topicContents", "Lie/H;", "bind", "(Lcom/iloen/melon/net/v6x/response/ArtistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST;)V", "LJ8/k3;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class TopicContentsImageViewHolder extends TopicContentsViewHolder {
        public static final int $stable = 8;
        @NotNull
        private final k3 binding;

        public TopicContentsImageViewHolder(@NotNull k3 k30) {
            q.g(k30, "binding");
            super(k30);
            this.binding = k30;
        }

        @Override  // com.iloen.melon.fragments.artistchannel.topic.TopicContentsViewHolder
        public void bind(@NotNull TOPICCONTENTSLIST artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0) {
            q.g(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, "topicContents");
            if(this.getContext() == null) {
                return;
            }
            Glide.with(this.getContext()).load(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.imageUrl).into(this.binding.b.b);
            e e0 = new e(2, this, artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0);
            this.binding.a.setOnClickListener(e0);
        }

        private static final void bind$lambda$0(TopicContentsImageViewHolder topicContentsViewHolder$TopicContentsImageViewHolder0, TOPICCONTENTSLIST artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, View view0) {
            OnViewHolderClickListener topicContentsViewHolder$OnViewHolderClickListener0 = topicContentsViewHolder$TopicContentsImageViewHolder0.getOnViewHolderClickListener();
            if(topicContentsViewHolder$OnViewHolderClickListener0 != null) {
                topicContentsViewHolder$OnViewHolderClickListener0.onViewClick(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0);
            }
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000B\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\bH\u0002¢\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\r\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u000E\u001A\u00020\n2\u0006\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\u000E\u0010\fR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000FR\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/topic/TopicContentsViewHolder$TopicContentsLinkViewHolder;", "Lcom/iloen/melon/fragments/artistchannel/topic/TopicContentsViewHolder;", "LQ4/a;", "binding", "Lcom/iloen/melon/fragments/FetcherBaseFragment;", "fragment", "<init>", "(LQ4/a;Lcom/iloen/melon/fragments/FetcherBaseFragment;)V", "Lcom/iloen/melon/net/v6x/response/ArtistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST;", "topicContents", "Lie/H;", "bindWithoutOgTag", "(Lcom/iloen/melon/net/v6x/response/ArtistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST;)V", "bindWithOgTag", "bind", "LQ4/a;", "Lcom/iloen/melon/fragments/FetcherBaseFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class TopicContentsLinkViewHolder extends TopicContentsViewHolder {
        public static final int $stable = 8;
        @NotNull
        private final a binding;
        @NotNull
        private final FetcherBaseFragment fragment;

        public TopicContentsLinkViewHolder(@NotNull a a0, @NotNull FetcherBaseFragment fetcherBaseFragment0) {
            q.g(a0, "binding");
            q.g(fetcherBaseFragment0, "fragment");
            super(a0);
            this.binding = a0;
            this.fragment = fetcherBaseFragment0;
        }

        public static void b(TopicContentsLinkViewHolder topicContentsViewHolder$TopicContentsLinkViewHolder0, TOPICCONTENTSLIST artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, View view0) {
            TopicContentsLinkViewHolder.bindWithoutOgTag$lambda$4(topicContentsViewHolder$TopicContentsLinkViewHolder0, artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, view0);
        }

        @Override  // com.iloen.melon.fragments.artistchannel.topic.TopicContentsViewHolder
        public void bind(@NotNull TOPICCONTENTSLIST artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0) {
            q.g(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, "topicContents");
            if(this.getContext() == null) {
                return;
            }
            if(!artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.isLinkTagFetched && (artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.linkUrl != null && !o.H0(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.linkUrl))) {
                JSONObject jSONObject0 = new JSONObject();
                jSONObject0.put("url", artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.linkUrl);
                jSONObject0.put("origin", "Melon");
                RequestBuilder.newInstance(new GoscrapKakaoReq(this.getContext(), jSONObject0.toString())).tag(this.fragment.getRequestTag()).listener(new b(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, this)).errorListener(new b(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, this)).request();
                return;
            }
            String s = artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.linkTitle;
            q.f(s, "linkTitle");
            if(!o.H0(s)) {
                this.bindWithOgTag(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0);
                return;
            }
            this.bindWithoutOgTag(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0);
        }

        private static final void bind$lambda$1(TOPICCONTENTSLIST artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, TopicContentsLinkViewHolder topicContentsViewHolder$TopicContentsLinkViewHolder0, GoscrapKakaoRes goscrapKakaoRes0) {
            String s3;
            String s2;
            String s1;
            artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.isLinkTagFetched = true;
            if(!topicContentsViewHolder$TopicContentsLinkViewHolder0.fragment.isFragmentValid()) {
                return;
            }
            if(!"0".equals((goscrapKakaoRes0 == null ? null : goscrapKakaoRes0.code))) {
                topicContentsViewHolder$TopicContentsLinkViewHolder0.bindWithoutOgTag(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0);
                return;
            }
            IMAGE goscrapKakaoRes$IMAGE0 = goscrapKakaoRes0.image;
            String s = "";
            if(goscrapKakaoRes$IMAGE0 == null) {
                s1 = "";
            }
            else {
                s1 = goscrapKakaoRes$IMAGE0.url;
                if(s1 == null) {
                    s1 = "";
                }
            }
            artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.linkImage = s1;
            OPENGRAPH goscrapKakaoRes$OPENGRAPH0 = goscrapKakaoRes0.opengraph;
            if(goscrapKakaoRes$OPENGRAPH0 == null) {
                s2 = "";
            }
            else {
                s2 = goscrapKakaoRes$OPENGRAPH0.ogTitle;
                if(s2 == null) {
                    s2 = "";
                }
            }
            artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.linkTitle = s2;
            if(goscrapKakaoRes$OPENGRAPH0 == null) {
                s3 = "";
            }
            else {
                s3 = goscrapKakaoRes$OPENGRAPH0.ogDescription;
                if(s3 == null) {
                    s3 = "";
                }
            }
            artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.linkDesc = s3;
            String s4 = goscrapKakaoRes0.host;
            if(s4 != null) {
                s = s4;
            }
            artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.linkHost = s;
            if(!o.H0(s2)) {
                topicContentsViewHolder$TopicContentsLinkViewHolder0.bindWithOgTag(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0);
                return;
            }
            topicContentsViewHolder$TopicContentsLinkViewHolder0.bindWithoutOgTag(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0);
        }

        private static final void bind$lambda$2(TOPICCONTENTSLIST artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, TopicContentsLinkViewHolder topicContentsViewHolder$TopicContentsLinkViewHolder0, VolleyError volleyError0) {
            H0.b.w("GoscrapKakaoReq() exception, ", volleyError0.getMessage(), LogU.Companion, "TopicModuleViewHolder");
            artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.isLinkTagFetched = true;
            topicContentsViewHolder$TopicContentsLinkViewHolder0.bindWithoutOgTag(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0);
        }

        private final void bindWithOgTag(TOPICCONTENTSLIST artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0) {
            if(this.getContext() == null) {
                return;
            }
            a a0 = this.binding;
            String s = "";
            if(a0 instanceof l3) {
                ((l3)a0).f.setVisibility(8);
                ((l3)this.binding).g.setVisibility(0);
                ((l3)this.binding).h.setVisibility(0);
                if(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.linkImage == null || o.H0(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.linkImage)) {
                    ((l3)this.binding).d.setVisibility(8);
                }
                else {
                    ((l3)this.binding).d.setVisibility(0);
                    float f = (float)ScreenUtils.dipToPixel(this.getContext(), 4.0f);
                    com.bumptech.glide.RequestBuilder requestBuilder0 = Glide.with(this.getContext()).asBitmap();
                    String s1 = artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.linkImage;
                    if(s1 != null) {
                        s = s1;
                    }
                    q.d(((com.bumptech.glide.RequestBuilder)requestBuilder0.load(s).transform(new Transformation[]{new CenterCrop(), new GranularRoundedCorners(f, f, 0.0f, 0.0f)})).into(((l3)this.binding).e));
                }
                ((l3)this.binding).j.setText(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.linkTitle);
                ((l3)this.binding).c.setText(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.linkHost);
                if(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.linkDesc == null || !o.H0(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.linkDesc) != 1) {
                    ((l3)this.binding).b.setVisibility(8);
                    ViewGroup.LayoutParams viewGroup$LayoutParams1 = ((l3)this.binding).i.getLayoutParams();
                    viewGroup$LayoutParams1.height = ScreenUtils.dipToPixel(this.getContext(), 70.0f);
                }
                else {
                    ((l3)this.binding).b.setVisibility(0);
                    ((l3)this.binding).b.setText(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.linkDesc);
                    ViewGroup.LayoutParams viewGroup$LayoutParams0 = ((l3)this.binding).i.getLayoutParams();
                    viewGroup$LayoutParams0.height = ScreenUtils.dipToPixel(this.getContext(), 90.0f);
                }
            }
            else if(a0 instanceof m3) {
                ((m3)a0).f.setVisibility(8);
                ((m3)this.binding).g.setVisibility(0);
                ((m3)this.binding).h.setVisibility(0);
                if(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.linkImage == null || o.H0(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.linkImage)) {
                    ((m3)this.binding).d.setVisibility(8);
                }
                else {
                    ((m3)this.binding).d.setVisibility(0);
                    float f1 = (float)ScreenUtils.dipToPixel(this.getContext(), 4.0f);
                    com.bumptech.glide.RequestBuilder requestBuilder1 = Glide.with(this.getContext()).asBitmap();
                    String s2 = artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.linkImage;
                    if(s2 != null) {
                        s = s2;
                    }
                    q.d(((com.bumptech.glide.RequestBuilder)requestBuilder1.load(s).transform(new Transformation[]{new CenterCrop(), new GranularRoundedCorners(f1, 0.0f, 0.0f, f1)})).into(((m3)this.binding).e));
                }
                ((m3)this.binding).i.setText(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.linkTitle);
                ((m3)this.binding).c.setText(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.linkHost);
                if(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.linkDesc == null || !o.H0(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.linkDesc) != 1) {
                    ((m3)this.binding).b.setVisibility(8);
                }
                else {
                    ((m3)this.binding).b.setVisibility(0);
                    ((m3)this.binding).b.setText(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.linkDesc);
                }
            }
            this.binding.getRoot().setOnClickListener(new com.iloen.melon.fragments.artistchannel.topic.a(this, artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, 2));
        }

        private static final void bindWithOgTag$lambda$5(TopicContentsLinkViewHolder topicContentsViewHolder$TopicContentsLinkViewHolder0, TOPICCONTENTSLIST artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, View view0) {
            OnViewHolderClickListener topicContentsViewHolder$OnViewHolderClickListener0 = topicContentsViewHolder$TopicContentsLinkViewHolder0.getOnViewHolderClickListener();
            if(topicContentsViewHolder$OnViewHolderClickListener0 != null) {
                topicContentsViewHolder$OnViewHolderClickListener0.onViewClick(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0);
            }
        }

        private final void bindWithoutOgTag(TOPICCONTENTSLIST artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0) {
            a a0 = this.binding;
            if(a0 instanceof l3) {
                ((l3)a0).f.setText(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.linkUrl);
                ((l3)this.binding).f.setPaintFlags(8);
                ((l3)this.binding).g.setVisibility(8);
                ((l3)this.binding).h.setVisibility(8);
                ((l3)this.binding).f.setVisibility(0);
                com.iloen.melon.fragments.artistchannel.topic.a a1 = new com.iloen.melon.fragments.artistchannel.topic.a(this, artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, 0);
                ((l3)this.binding).f.setOnClickListener(a1);
                return;
            }
            if(a0 instanceof m3) {
                ((m3)a0).f.setText(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.linkUrl);
                ((m3)this.binding).f.setPaintFlags(8);
                ((m3)this.binding).g.setVisibility(8);
                ((m3)this.binding).h.setVisibility(8);
                ((m3)this.binding).f.setVisibility(0);
                com.iloen.melon.fragments.artistchannel.topic.a a2 = new com.iloen.melon.fragments.artistchannel.topic.a(this, artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, 1);
                ((m3)this.binding).f.setOnClickListener(a2);
            }
        }

        private static final void bindWithoutOgTag$lambda$3(TopicContentsLinkViewHolder topicContentsViewHolder$TopicContentsLinkViewHolder0, TOPICCONTENTSLIST artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, View view0) {
            OnViewHolderClickListener topicContentsViewHolder$OnViewHolderClickListener0 = topicContentsViewHolder$TopicContentsLinkViewHolder0.getOnViewHolderClickListener();
            if(topicContentsViewHolder$OnViewHolderClickListener0 != null) {
                topicContentsViewHolder$OnViewHolderClickListener0.onViewClick(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0);
            }
        }

        private static final void bindWithoutOgTag$lambda$4(TopicContentsLinkViewHolder topicContentsViewHolder$TopicContentsLinkViewHolder0, TOPICCONTENTSLIST artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, View view0) {
            OnViewHolderClickListener topicContentsViewHolder$OnViewHolderClickListener0 = topicContentsViewHolder$TopicContentsLinkViewHolder0.getOnViewHolderClickListener();
            if(topicContentsViewHolder$OnViewHolderClickListener0 != null) {
                topicContentsViewHolder$OnViewHolderClickListener0.onViewClick(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0);
            }
        }

        public static void c(TopicContentsLinkViewHolder topicContentsViewHolder$TopicContentsLinkViewHolder0, TOPICCONTENTSLIST artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, View view0) {
            TopicContentsLinkViewHolder.bindWithoutOgTag$lambda$3(topicContentsViewHolder$TopicContentsLinkViewHolder0, artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, view0);
        }

        public static void d(TopicContentsLinkViewHolder topicContentsViewHolder$TopicContentsLinkViewHolder0, TOPICCONTENTSLIST artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, View view0) {
            TopicContentsLinkViewHolder.bindWithOgTag$lambda$5(topicContentsViewHolder$TopicContentsLinkViewHolder0, artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, view0);
        }

        public static void e(TOPICCONTENTSLIST artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, TopicContentsLinkViewHolder topicContentsViewHolder$TopicContentsLinkViewHolder0, VolleyError volleyError0) {
            TopicContentsLinkViewHolder.bind$lambda$2(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, topicContentsViewHolder$TopicContentsLinkViewHolder0, volleyError0);
        }
    }

    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/topic/TopicContentsViewHolder$TopicContentsMvViewHolder;", "Lcom/iloen/melon/fragments/artistchannel/topic/TopicContentsViewHolder;", "LJ8/n3;", "binding", "<init>", "(LJ8/n3;)V", "Lcom/iloen/melon/net/v6x/response/ArtistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST;", "topicContents", "Lie/H;", "bind", "(Lcom/iloen/melon/net/v6x/response/ArtistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST;)V", "LJ8/n3;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class TopicContentsMvViewHolder extends TopicContentsViewHolder {
        public static final int $stable = 8;
        @NotNull
        private final n3 binding;

        public TopicContentsMvViewHolder(@NotNull n3 n30) {
            q.g(n30, "binding");
            super(n30);
            this.binding = n30;
        }

        @Override  // com.iloen.melon.fragments.artistchannel.topic.TopicContentsViewHolder
        public void bind(@NotNull TOPICCONTENTSLIST artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0) {
            q.g(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, "topicContents");
            if(this.getContext() == null) {
                return;
            }
            Glide.with(this.getContext()).load(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.imageUrl).into(((MelonImageView)this.binding.c.d));
            String s = artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.playTime == null ? null : k.f(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.playTime);
            this.binding.d.setText(s);
            int v = "19".equals(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.adultGrade) ? 0 : 8;
            this.binding.b.setVisibility(v);
            e e0 = new e(3, this, artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0);
            ((ConstraintLayout)this.binding.c.b).setOnClickListener(e0);
        }

        private static final void bind$lambda$0(TopicContentsMvViewHolder topicContentsViewHolder$TopicContentsMvViewHolder0, TOPICCONTENTSLIST artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, View view0) {
            OnViewHolderClickListener topicContentsViewHolder$OnViewHolderClickListener0 = topicContentsViewHolder$TopicContentsMvViewHolder0.getOnViewHolderClickListener();
            if(topicContentsViewHolder$OnViewHolderClickListener0 != null) {
                topicContentsViewHolder$OnViewHolderClickListener0.onViewClick(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0);
            }
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004\u0012\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\n\u0010\u000BJ\u0017\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\r\u001A\u00020\fH\u0016¢\u0006\u0004\b\u000F\u0010\u0010R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011R \u0010\u0007\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0012R\u0014\u0010\t\u001A\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/topic/TopicContentsViewHolder$TopicContentsSongViewHolder;", "Lcom/iloen/melon/fragments/artistchannel/topic/TopicContentsViewHolder;", "LJ8/o3;", "binding", "", "", "Landroid/graphics/Bitmap;", "blurViewBgMap", "Landroidx/lifecycle/D;", "lifecycleOwner", "<init>", "(LJ8/o3;Ljava/util/Map;Landroidx/lifecycle/D;)V", "Lcom/iloen/melon/net/v6x/response/ArtistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST;", "topicContents", "Lie/H;", "bind", "(Lcom/iloen/melon/net/v6x/response/ArtistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST;)V", "LJ8/o3;", "Ljava/util/Map;", "Landroidx/lifecycle/D;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class TopicContentsSongViewHolder extends TopicContentsViewHolder {
        public static final int $stable = 8;
        @NotNull
        private final o3 binding;
        @NotNull
        private final Map blurViewBgMap;
        @NotNull
        private final D lifecycleOwner;

        public TopicContentsSongViewHolder(@NotNull o3 o30, @NotNull Map map0, @NotNull D d0) {
            q.g(o30, "binding");
            q.g(map0, "blurViewBgMap");
            q.g(d0, "lifecycleOwner");
            super(o30);
            this.binding = o30;
            this.blurViewBgMap = map0;
            this.lifecycleOwner = d0;
            f3 f30 = o30.c;
            f30.c.setImageDrawable(null);
            Context context0 = this.getContext();
            if(context0 != null) {
                Drawable drawable0 = c.getDrawable(context0, 0x7F0808E0);  // drawable:shape_rectangle_gray601s_round4
                f30.c.setBackground(drawable0);
            }
        }

        public static void a(TopicContentsSongViewHolder topicContentsViewHolder$TopicContentsSongViewHolder0, TOPICCONTENTSLIST artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, View view0) {
            TopicContentsSongViewHolder.bind$lambda$1(topicContentsViewHolder$TopicContentsSongViewHolder0, artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, view0);
        }

        public static void b(TopicContentsSongViewHolder topicContentsViewHolder$TopicContentsSongViewHolder0, TOPICCONTENTSLIST artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, View view0) {
            TopicContentsSongViewHolder.bind$lambda$2(topicContentsViewHolder$TopicContentsSongViewHolder0, artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, view0);
        }

        @Override  // com.iloen.melon.fragments.artistchannel.topic.TopicContentsViewHolder
        public void bind(@NotNull TOPICCONTENTSLIST artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0) {
            q.g(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, "topicContents");
            if(this.getContext() == null) {
                return;
            }
            String s = artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.imageUrl;
            Glide.with(this.getContext()).asBitmap().load(s).into(new CustomTarget() {
                @Override  // com.bumptech.glide.request.target.Target
                public void onLoadCleared(Drawable drawable0) {
                }

                public void onResourceReady(Bitmap bitmap0, Transition transition0) {
                    q.g(bitmap0, "resource");
                    Glide.with(s.getContext()).load(bitmap0).into(s.binding.d.b);
                    Bitmap bitmap1 = (Bitmap)s.blurViewBgMap.get(this.$imageUrl);
                    if(bitmap1 != null) {
                        s.binding.c.b.setImageBitmap(bitmap1);
                        return;
                    }
                    BuildersKt__Builders_commonKt.launch$default(f0.f(s.lifecycleOwner), Dispatchers.getDefault(), null, new n(bitmap0, this.$imageUrl, null) {
                        final String $imageUrl;
                        final Bitmap $resource;
                        int label;

                        {
                            TopicContentsSongViewHolder.this = topicContentsViewHolder$TopicContentsSongViewHolder0;
                            this.$resource = bitmap0;
                            this.$imageUrl = s;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            return new com.iloen.melon.fragments.artistchannel.topic.TopicContentsViewHolder.TopicContentsSongViewHolder.bind.1.onResourceReady.2.1(TopicContentsSongViewHolder.this, this.$resource, this.$imageUrl, continuation0);
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                        }

                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                            return ((com.iloen.melon.fragments.artistchannel.topic.TopicContentsViewHolder.TopicContentsSongViewHolder.bind.1.onResourceReady.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            if(this.label != 0) {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                            d5.n.D(object0);
                            Context context0 = TopicContentsSongViewHolder.this.binding.a.getContext();
                            q.f(context0, "getContext(...)");
                            Bitmap bitmap0 = com.iloen.melon.utils.ui.LyricHighlightUtils.Companion.drawPalette$default(LyricHighlightUtils.Companion, context0, this.$resource, false, false, 4, null);
                            TopicContentsSongViewHolder.this.blurViewBgMap.put(this.$imageUrl, bitmap0);
                            BuildersKt__Builders_commonKt.launch$default(f0.f(TopicContentsSongViewHolder.this.lifecycleOwner), Dispatchers.getMain(), null, new n(bitmap0, null) {
                                final Bitmap $bgBitmap;
                                int label;

                                {
                                    TopicContentsSongViewHolder.this = topicContentsViewHolder$TopicContentsSongViewHolder0;
                                    this.$bgBitmap = bitmap0;
                                    super(2, continuation0);
                                }

                                @Override  // oe.a
                                public final Continuation create(Object object0, Continuation continuation0) {
                                    return new com.iloen.melon.fragments.artistchannel.topic.TopicContentsViewHolder.TopicContentsSongViewHolder.bind.1.onResourceReady.2.1.1(TopicContentsSongViewHolder.this, this.$bgBitmap, continuation0);
                                }

                                @Override  // we.n
                                public Object invoke(Object object0, Object object1) {
                                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                }

                                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                    return ((com.iloen.melon.fragments.artistchannel.topic.TopicContentsViewHolder.TopicContentsSongViewHolder.bind.1.onResourceReady.2.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                }

                                @Override  // oe.a
                                public final Object invokeSuspend(Object object0) {
                                    if(this.label != 0) {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                    d5.n.D(object0);
                                    TopicContentsSongViewHolder.this.binding.c.b.setImageBitmap(this.$bgBitmap);
                                    return H.a;
                                }
                            }, 2, null);
                            return H.a;
                        }
                    }, 2, null);
                }

                @Override  // com.bumptech.glide.request.target.Target
                public void onResourceReady(Object object0, Transition transition0) {
                    this.onResourceReady(((Bitmap)object0), transition0);
                }
            });
            this.binding.f.setText(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.songName);
            this.binding.f.setCompoundDrawablesWithIntrinsicBounds((artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.isAdult ? 0x7F0803D4 : 0), 0, 0, 0);  // drawable:ic_common_19_2
            String s1 = ProtocolUtils.getArtistNames(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.artistList);
            this.binding.b.setText(s1);
            com.iloen.melon.fragments.artistchannel.topic.c c0 = new com.iloen.melon.fragments.artistchannel.topic.c(this, artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, 0);
            this.binding.d.a.setOnClickListener(c0);
            com.iloen.melon.fragments.artistchannel.topic.c c1 = new com.iloen.melon.fragments.artistchannel.topic.c(this, artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, 1);
            this.binding.e.setOnClickListener(c1);
        }

        private static final void bind$lambda$1(TopicContentsSongViewHolder topicContentsViewHolder$TopicContentsSongViewHolder0, TOPICCONTENTSLIST artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, View view0) {
            OnViewHolderClickListener topicContentsViewHolder$OnViewHolderClickListener0 = topicContentsViewHolder$TopicContentsSongViewHolder0.getOnViewHolderClickListener();
            if(topicContentsViewHolder$OnViewHolderClickListener0 != null) {
                topicContentsViewHolder$OnViewHolderClickListener0.onViewClick(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0);
            }
        }

        private static final void bind$lambda$2(TopicContentsSongViewHolder topicContentsViewHolder$TopicContentsSongViewHolder0, TOPICCONTENTSLIST artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, View view0) {
            OnViewHolderClickListener topicContentsViewHolder$OnViewHolderClickListener0 = topicContentsViewHolder$TopicContentsSongViewHolder0.getOnViewHolderClickListener();
            if(topicContentsViewHolder$OnViewHolderClickListener0 != null) {
                topicContentsViewHolder$OnViewHolderClickListener0.onPlayClick(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/topic/TopicContentsViewHolder$TopicContentsTextViewHolder;", "Lcom/iloen/melon/fragments/artistchannel/topic/TopicContentsViewHolder;", "LJ8/p3;", "binding", "<init>", "(LJ8/p3;)V", "Lcom/iloen/melon/net/v6x/response/ArtistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST;", "topicContents", "Lie/H;", "bind", "(Lcom/iloen/melon/net/v6x/response/ArtistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST;)V", "LJ8/p3;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class TopicContentsTextViewHolder extends TopicContentsViewHolder {
        public static final int $stable = 8;
        @NotNull
        private final p3 binding;

        public TopicContentsTextViewHolder(@NotNull p3 p30) {
            q.g(p30, "binding");
            super(p30);
            this.binding = p30;
        }

        @Override  // com.iloen.melon.fragments.artistchannel.topic.TopicContentsViewHolder
        public void bind(@NotNull TOPICCONTENTSLIST artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0) {
            q.g(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, "topicContents");
            this.binding.b.setText(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.text);
        }
    }

    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000B¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/artistchannel/topic/TopicContentsViewHolder$TopicContentsUnknownViewHolder;", "Lcom/iloen/melon/fragments/artistchannel/topic/TopicContentsViewHolder;", "LJ8/q3;", "binding", "<init>", "(LJ8/q3;)V", "Lcom/iloen/melon/net/v6x/response/ArtistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST;", "topicContents", "Lie/H;", "bind", "(Lcom/iloen/melon/net/v6x/response/ArtistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST;)V", "LJ8/q3;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class TopicContentsUnknownViewHolder extends TopicContentsViewHolder {
        public static final int $stable = 8;
        @NotNull
        private final q3 binding;

        public TopicContentsUnknownViewHolder(@NotNull q3 q30) {
            q.g(q30, "binding");
            super(q30);
            this.binding = q30;
        }

        @Override  // com.iloen.melon.fragments.artistchannel.topic.TopicContentsViewHolder
        public void bind(@NotNull TOPICCONTENTSLIST artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0) {
            q.g(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, "topicContents");
            this.binding.b.setText(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0.text);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String OK_CODE = "0";
    @NotNull
    private static final String TAG = "TopicModuleViewHolder";
    @Nullable
    private final Context context;
    @Nullable
    private OnViewHolderClickListener onViewHolderClickListener;

    static {
        TopicContentsViewHolder.Companion = new Companion(null);
        TopicContentsViewHolder.$stable = 8;
    }

    public TopicContentsViewHolder(@NotNull a a0) {
        q.g(a0, "binding");
        super(a0.getRoot());
        this.context = a0.getRoot().getContext();
    }

    public void bind(@NotNull TOPICCONTENTSLIST artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0) {
        q.g(artistContentsArtistTopicInfoRes$RESPONSE$TOPICCONTENTSLIST0, "topicContents");
    }

    @Nullable
    public final Context getContext() {
        return this.context;
    }

    @Nullable
    public final OnViewHolderClickListener getOnViewHolderClickListener() {
        return this.onViewHolderClickListener;
    }

    public final void setOnViewHolderClickListener(@Nullable OnViewHolderClickListener topicContentsViewHolder$OnViewHolderClickListener0) {
        this.onViewHolderClickListener = topicContentsViewHolder$OnViewHolderClickListener0;
    }
}

