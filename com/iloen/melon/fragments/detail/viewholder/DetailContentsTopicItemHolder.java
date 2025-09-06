package com.iloen.melon.fragments.detail.viewholder;

import Cb.k;
import Ce.g;
import De.I;
import J8.Y1;
import J8.f3;
import J8.s3;
import J8.t3;
import P4.a;
import Tf.o;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.recyclerview.widget.O0;
import b.l;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.iloen.melon.custom.AlphaControlCheckButton;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v6x.common.TopicInfoBase.CMTLIST;
import com.iloen.melon.net.v6x.common.TopicInfoBase;
import com.iloen.melon.utils.ResourceUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.LyricHighlightUtils;
import ie.H;
import java.util.List;
import java.util.Map;
import je.p;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.n;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000E\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u0000 \u001D2\u00020\u0001:\u0002\u001D\u001EB5\b\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0012\u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0006\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000F\u001A\u00020\u000E¢\u0006\u0004\b\u000F\u0010\u0010J\'\u0010\u0017\u001A\u00020\u000E2\u0006\u0010\u0012\u001A\u00020\u00112\u0006\u0010\u0014\u001A\u00020\u00132\b\u0010\u0016\u001A\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001AR \u0010\t\u001A\u000E\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001BR\u0014\u0010\u000B\u001A\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000B\u0010\u001C¨\u0006\u001F"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsTopicItemHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/Y1;", "binding", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsTopicItemHolder$TopicActionListener;", "actionListener", "", "", "Landroid/graphics/Bitmap;", "blurViewBgMap", "", "isHorizontal", "<init>", "(LJ8/Y1;Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsTopicItemHolder$TopicActionListener;Ljava/util/Map;Z)V", "Lie/H;", "initViewHolder", "()V", "Lcom/iloen/melon/net/v6x/common/TopicInfoBase;", "item", "", "position", "Landroidx/lifecycle/D;", "lifecycleOwner", "bind", "(Lcom/iloen/melon/net/v6x/common/TopicInfoBase;ILandroidx/lifecycle/D;)V", "LJ8/Y1;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsTopicItemHolder$TopicActionListener;", "Ljava/util/Map;", "Z", "Companion", "TopicActionListener", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DetailContentsTopicItemHolder extends O0 {
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000E0\r2\u0006\u0010\u000F\u001A\u00020\u0010R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsTopicItemHolder$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsTopicItemHolder;", "parent", "Landroid/view/ViewGroup;", "actionListener", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsTopicItemHolder$TopicActionListener;", "blurViewBgMap", "", "Landroid/graphics/Bitmap;", "isHorizontal", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final DetailContentsTopicItemHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull TopicActionListener detailContentsTopicItemHolder$TopicActionListener0, @NotNull Map map0, boolean z) {
            q.g(viewGroup0, "parent");
            q.g(detailContentsTopicItemHolder$TopicActionListener0, "actionListener");
            q.g(map0, "blurViewBgMap");
            View view0 = LayoutInflater.from(viewGroup0.getContext()).inflate(0x7F0D0489, viewGroup0, false);  // layout:listitem_detail_topic
            int v = 0x7F0A02EC;  // id:comment
            View view1 = I.C(view0, 0x7F0A02EC);  // id:comment
            if(((MelonTextView)view1) != null) {
                v = 0x7F0A02ED;  // id:commentAll
                View view2 = I.C(view0, 0x7F0A02ED);  // id:commentAll
                if(((MelonTextView)view2) != null) {
                    v = 0x7F0A02EE;  // id:commentOneDegree
                    View view3 = I.C(view0, 0x7F0A02EE);  // id:commentOneDegree
                    if(((ImageView)view3) != null) {
                        v = 0x7F0A02EF;  // id:commentOneNickname
                        View view4 = I.C(view0, 0x7F0A02EF);  // id:commentOneNickname
                        if(((MelonTextView)view4) != null) {
                            v = 0x7F0A02F0;  // id:commentOneTemperature
                            View view5 = I.C(view0, 0x7F0A02F0);  // id:commentOneTemperature
                            if(((MelonTextView)view5) != null) {
                                v = 0x7F0A02F1;  // id:commentOneText
                                View view6 = I.C(view0, 0x7F0A02F1);  // id:commentOneText
                                if(((MelonTextView)view6) != null) {
                                    v = 0x7F0A02F2;  // id:commentTwoDegree
                                    View view7 = I.C(view0, 0x7F0A02F2);  // id:commentTwoDegree
                                    if(((ImageView)view7) != null) {
                                        v = 0x7F0A02F3;  // id:commentTwoNickname
                                        View view8 = I.C(view0, 0x7F0A02F3);  // id:commentTwoNickname
                                        if(((MelonTextView)view8) != null) {
                                            v = 0x7F0A02F4;  // id:commentTwoTemperature
                                            View view9 = I.C(view0, 0x7F0A02F4);  // id:commentTwoTemperature
                                            if(((MelonTextView)view9) != null) {
                                                v = 0x7F0A02F5;  // id:commentTwoText
                                                View view10 = I.C(view0, 0x7F0A02F5);  // id:commentTwoText
                                                if(((MelonTextView)view10) != null) {
                                                    v = 0x7F0A0761;  // id:likeButton
                                                    View view11 = I.C(view0, 0x7F0A0761);  // id:likeButton
                                                    if(((AlphaControlCheckButton)view11) != null) {
                                                        v = 0x7F0A0762;  // id:likeTv
                                                        View view12 = I.C(view0, 0x7F0A0762);  // id:likeTv
                                                        if(((MelonTextView)view12) != null) {
                                                            v = 0x7F0A0BD7;  // id:topic
                                                            View view13 = I.C(view0, 0x7F0A0BD7);  // id:topic
                                                            if(((FrameLayout)view13) != null) {
                                                                return new DetailContentsTopicItemHolder(new Y1(((ConstraintLayout)view0), ((MelonTextView)view1), ((MelonTextView)view2), ((ImageView)view3), ((MelonTextView)view4), ((MelonTextView)view5), ((MelonTextView)view6), ((ImageView)view7), ((MelonTextView)view8), ((MelonTextView)view9), ((MelonTextView)view10), ((AlphaControlCheckButton)view11), ((MelonTextView)view12), ((FrameLayout)view13)), detailContentsTopicItemHolder$TopicActionListener0, map0, z, null);
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
    }

    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001F\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001F\u0010\t\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bJ\u001F\u0010\n\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\n\u0010\b¨\u0006\u000BÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsTopicItemHolder$TopicActionListener;", "", "Lcom/iloen/melon/net/v6x/common/TopicInfoBase;", "topic", "", "position", "Lie/H;", "onClickTopic", "(Lcom/iloen/melon/net/v6x/common/TopicInfoBase;I)V", "onClickLike", "onClickViewAllComment", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface TopicActionListener {
        void onClickLike(@NotNull TopicInfoBase arg1, int arg2);

        void onClickTopic(@NotNull TopicInfoBase arg1, int arg2);

        void onClickViewAllComment(@NotNull TopicInfoBase arg1, int arg2);
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "DetailContentsTopicItemHolder";
    @NotNull
    private final TopicActionListener actionListener;
    @NotNull
    private final Y1 binding;
    @NotNull
    private final Map blurViewBgMap;
    private final boolean isHorizontal;

    static {
        DetailContentsTopicItemHolder.Companion = new Companion(null);
        DetailContentsTopicItemHolder.$stable = 8;
    }

    private DetailContentsTopicItemHolder(Y1 y10, TopicActionListener detailContentsTopicItemHolder$TopicActionListener0, Map map0, boolean z) {
        super(y10.a);
        this.binding = y10;
        this.actionListener = detailContentsTopicItemHolder$TopicActionListener0;
        this.blurViewBgMap = map0;
        this.isHorizontal = z;
    }

    public DetailContentsTopicItemHolder(Y1 y10, TopicActionListener detailContentsTopicItemHolder$TopicActionListener0, Map map0, boolean z, DefaultConstructorMarker defaultConstructorMarker0) {
        this(y10, detailContentsTopicItemHolder$TopicActionListener0, map0, z);
    }

    public static void b(t3 t30, DetailContentsTopicItemHolder detailContentsTopicItemHolder0) {
        DetailContentsTopicItemHolder.bind$lambda$2(t30, detailContentsTopicItemHolder0);
    }

    public final void bind(@NotNull TopicInfoBase topicInfoBase0, int v, @Nullable D d0) {
        String s8;
        String s3;
        ConstraintLayout constraintLayout1;
        q.g(topicInfoBase0, "item");
        ConstraintLayout constraintLayout0 = this.binding.a;
        q.f(constraintLayout0, "getRoot(...)");
        Context context0 = constraintLayout0.getContext();
        if(context0 != null) {
            if(this.isHorizontal) {
                ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.binding.a.getLayoutParams();
                viewGroup$LayoutParams0.width = ScreenUtils.dipToPixel(context0, 320.0f);
            }
            else {
                this.initViewHolder();
                this.binding.a.getLayoutParams().width = -1;
            }
            int v1 = 0x7F0A0BAA;  // id:title_tv
            int v2 = 0x7F0A00E6;  // id:background
            if(q.b("T10004", topicInfoBase0.contsTypeCode)) {
                View view0 = LayoutInflater.from(context0).inflate(0x7F0D08AA, constraintLayout0, false);  // layout:topic_song
                View view1 = I.C(view0, 0x7F0A007F);  // id:album
                if(view1 == null) {
                    v1 = 0x7F0A007F;  // id:album
                }
                else {
                    f3 f30 = f3.a(view1);
                    if(((Guideline)I.C(view0, 0x7F0A0084)) == null) {  // id:album_guideline
                        v1 = 0x7F0A0084;  // id:album_guideline
                    }
                    else {
                        View view2 = I.C(view0, 0x7F0A00B1);  // id:artist
                        if(((MelonTextView)view2) == null) {
                            v1 = 0x7F0A00B1;  // id:artist
                        }
                        else {
                            View view3 = I.C(view0, 0x7F0A00E6);  // id:background
                            if(view3 == null) {
                                v1 = 0x7F0A00E6;  // id:background
                            }
                            else {
                                f3 f31 = f3.a(view3);
                                View view4 = I.C(view0, 0x7F0A0AA2);  // id:song
                                if(((MelonTextView)view4) == null) {
                                    v1 = 0x7F0A0AA2;  // id:song
                                }
                                else {
                                    View view5 = I.C(view0, 0x7F0A0BAA);  // id:title_tv
                                    if(((MelonTextView)view5) != null) {
                                        constraintLayout1 = (ConstraintLayout)view0;
                                        s3 s30 = new s3(constraintLayout1, f30, ((MelonTextView)view2), f31, ((MelonTextView)view4), ((MelonTextView)view5));
                                        f31.c.setVisibility(8);
                                        String s = topicInfoBase0.imageUrl;
                                        Glide.with(context0).asBitmap().load(s).into(new CustomTarget() {
                                            @Override  // com.bumptech.glide.request.target.Target
                                            public void onLoadCleared(Drawable drawable0) {
                                            }

                                            public void onResourceReady(Bitmap bitmap0, Transition transition0) {
                                                q.g(bitmap0, "resource");
                                                Glide.with(s30).load(bitmap0).into(this.b.b);
                                                Bitmap bitmap1 = (Bitmap)s.blurViewBgMap.get(d0);
                                                if(bitmap1 != null) {
                                                    this.c.b.setImageBitmap(bitmap1);
                                                    return;
                                                }
                                                D d0 = this.$lifecycleOwner;
                                                Context context0 = s30;
                                                DetailContentsTopicItemHolder detailContentsTopicItemHolder0 = s;
                                                String s = d0;
                                                s3 s30 = this;
                                                if(d0 != null) {
                                                    BuildersKt__Builders_commonKt.launch$default(f0.f(d0), Dispatchers.getDefault(), null, new n(bitmap0, detailContentsTopicItemHolder0, s, d0, s30, null) {
                                                        final Context $context;
                                                        final String $imageUrl;
                                                        final D $lifecycleOwner;
                                                        final Bitmap $resource;
                                                        final s3 $songBinding;
                                                        int label;

                                                        {
                                                            this.$context = context0;
                                                            this.$resource = bitmap0;
                                                            DetailContentsTopicItemHolder.this = detailContentsTopicItemHolder0;
                                                            this.$imageUrl = s;
                                                            this.$lifecycleOwner = d0;
                                                            this.$songBinding = s30;
                                                            super(2, continuation0);
                                                        }

                                                        @Override  // oe.a
                                                        public final Continuation create(Object object0, Continuation continuation0) {
                                                            return new com.iloen.melon.fragments.detail.viewholder.DetailContentsTopicItemHolder.bind.topicView.1.onResourceReady.2.1(this.$context, this.$resource, DetailContentsTopicItemHolder.this, this.$imageUrl, this.$lifecycleOwner, this.$songBinding, continuation0);
                                                        }

                                                        @Override  // we.n
                                                        public Object invoke(Object object0, Object object1) {
                                                            return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                        }

                                                        public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                            return ((com.iloen.melon.fragments.detail.viewholder.DetailContentsTopicItemHolder.bind.topicView.1.onResourceReady.2.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                        }

                                                        @Override  // oe.a
                                                        public final Object invokeSuspend(Object object0) {
                                                            if(this.label != 0) {
                                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                            }
                                                            d5.n.D(object0);
                                                            Bitmap bitmap0 = com.iloen.melon.utils.ui.LyricHighlightUtils.Companion.drawPalette$default(LyricHighlightUtils.Companion, this.$context, this.$resource, false, false, 4, null);
                                                            DetailContentsTopicItemHolder.this.blurViewBgMap.put(this.$imageUrl, bitmap0);
                                                            BuildersKt__Builders_commonKt.launch$default(f0.f(this.$lifecycleOwner), Dispatchers.getMain(), null, new n(bitmap0, null) {
                                                                final Bitmap $bgBitmap;
                                                                final s3 $songBinding;
                                                                int label;

                                                                {
                                                                    this.$songBinding = s30;
                                                                    this.$bgBitmap = bitmap0;
                                                                    super(2, continuation0);
                                                                }

                                                                @Override  // oe.a
                                                                public final Continuation create(Object object0, Continuation continuation0) {
                                                                    return new com.iloen.melon.fragments.detail.viewholder.DetailContentsTopicItemHolder.bind.topicView.1.onResourceReady.2.1.1(this.$songBinding, this.$bgBitmap, continuation0);
                                                                }

                                                                @Override  // we.n
                                                                public Object invoke(Object object0, Object object1) {
                                                                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                                                                }

                                                                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                                                                    return ((com.iloen.melon.fragments.detail.viewholder.DetailContentsTopicItemHolder.bind.topicView.1.onResourceReady.2.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                                                                }

                                                                @Override  // oe.a
                                                                public final Object invokeSuspend(Object object0) {
                                                                    if(this.label != 0) {
                                                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                                                    }
                                                                    d5.n.D(object0);
                                                                    this.$songBinding.c.b.setImageBitmap(this.$bgBitmap);
                                                                    return H.a;
                                                                }
                                                            }, 2, null);
                                                            return H.a;
                                                        }
                                                    }, 2, null);
                                                }
                                            }

                                            @Override  // com.bumptech.glide.request.target.Target
                                            public void onResourceReady(Object object0, Transition transition0) {
                                                this.onResourceReady(((Bitmap)object0), transition0);
                                            }
                                        });
                                        ((MelonTextView)view4).setText(topicInfoBase0.songName);
                                        ((MelonTextView)view2).setText(ProtocolUtils.getArtistNames(topicInfoBase0.artistList));
                                        ((MelonTextView)view5).setText(topicInfoBase0.title);
                                        goto label_109;
                                    }
                                }
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v1));
            }
            else if(q.b(topicInfoBase0.gradationYn, "Y")) {
                View view6 = LayoutInflater.from(context0).inflate(0x7F0D08A9, constraintLayout0, false);  // layout:topic_image
                View view7 = I.C(view6, 0x7F0A00E6);  // id:background
                if(view7 == null) {
                    v1 = 0x7F0A00E6;  // id:background
                }
                else {
                    f3 f32 = f3.a(view7);
                    MelonImageView melonImageView0 = (MelonImageView)I.C(view6, 0x7F0A04F6);  // id:gradation
                    if(melonImageView0 == null) {
                        v1 = 0x7F0A04F6;  // id:gradation
                    }
                    else {
                        MelonTextView melonTextView0 = (MelonTextView)I.C(view6, 0x7F0A08C7);  // id:number_tv
                        if(melonTextView0 == null) {
                            v1 = 0x7F0A08C7;  // id:number_tv
                        }
                        else {
                            MelonTextView melonTextView1 = (MelonTextView)I.C(view6, 0x7F0A0BAA);  // id:title_tv
                            if(melonTextView1 != null) {
                                constraintLayout1 = (ConstraintLayout)view6;
                                f32.c.setImageResource(0x7F080786);  // drawable:noimage_logo_large
                                Glide.with(context0).load(topicInfoBase0.gradationUrl).into(melonImageView0);
                                Glide.with(context0).load(topicInfoBase0.imageUrl).into(f32.b);
                                if(topicInfoBase0.imageCnt == null || o.H0(topicInfoBase0.imageCnt)) {
                                    melonTextView0.setVisibility(8);
                                }
                                else {
                                    melonTextView0.setText(topicInfoBase0.imageCnt);
                                    melonTextView0.setVisibility(0);
                                }
                                melonTextView1.setText(topicInfoBase0.title);
                                goto label_109;
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: " + view6.getResources().getResourceName(v1));
            }
            else {
                View view8 = LayoutInflater.from(context0).inflate(0x7F0D08AB, constraintLayout0, false);  // layout:topic_text
                View view9 = I.C(view8, 0x7F0A00E6);  // id:background
                if(view9 == null) {
                    throw new NullPointerException("Missing required view with ID: " + view8.getResources().getResourceName(v2));
                }
                f3 f33 = f3.a(view9);
                v2 = 0x7F0A0113;  // id:bottomGuide
                View view10 = I.C(view8, 0x7F0A0113);  // id:bottomGuide
                if(((Guideline)view10) == null) {
                    throw new NullPointerException("Missing required view with ID: " + view8.getResources().getResourceName(v2));
                }
                v2 = 0x7F0A098F;  // id:quoteLeft
                View view11 = I.C(view8, 0x7F0A098F);  // id:quoteLeft
                if(((ImageView)view11) == null) {
                    throw new NullPointerException("Missing required view with ID: " + view8.getResources().getResourceName(v2));
                }
                v2 = 0x7F0A0990;  // id:quoteRight
                View view12 = I.C(view8, 0x7F0A0990);  // id:quoteRight
                if(((ImageView)view12) == null) {
                    throw new NullPointerException("Missing required view with ID: " + view8.getResources().getResourceName(v2));
                }
                v2 = 0x7F0A0B8D;  // id:title
                View view13 = I.C(view8, 0x7F0A0B8D);  // id:title
                if(((MelonTextView)view13) == null) {
                    throw new NullPointerException("Missing required view with ID: " + view8.getResources().getResourceName(v2));
                }
                v2 = 0x7F0A0B8F;  // id:titleLayout
                View view14 = I.C(view8, 0x7F0A0B8F);  // id:titleLayout
                if(((LinearLayout)view14) == null) {
                    throw new NullPointerException("Missing required view with ID: " + view8.getResources().getResourceName(v2));
                }
                t3 t30 = new t3(((ConstraintLayout)view8), f33, ((Guideline)view10), ((ImageView)view11), ((ImageView)view12), ((MelonTextView)view13), ((LinearLayout)view14));
                if(!this.isHorizontal) {
                    ViewGroup.LayoutParams viewGroup$LayoutParams1 = this.binding.n.getLayoutParams();
                    viewGroup$LayoutParams1.height = ScreenUtils.dipToPixel(context0, 220.0f);
                    ViewGroup.LayoutParams viewGroup$LayoutParams2 = ((LinearLayout)view14).getLayoutParams();
                    if(viewGroup$LayoutParams2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                    }
                    ((LayoutParams)viewGroup$LayoutParams2).l = ((Guideline)view10).getId();
                    ((LinearLayout)view14).setLayoutParams(((LayoutParams)viewGroup$LayoutParams2));
                }
                f33.c.setVisibility(8);
                Glide.with(context0).load(topicInfoBase0.imageUrl).into(f33.b);
                ((MelonTextView)view13).setText(topicInfoBase0.title);
                ((MelonTextView)view13).post(new l(22, t30, this));
                constraintLayout1 = (ConstraintLayout)view8;
            }
        label_109:
            q.d(constraintLayout1);
            this.binding.n.addView(constraintLayout1);
            constraintLayout1.setOnClickListener(new com.iloen.melon.fragments.detail.viewholder.o(this, topicInfoBase0, v, 0));
            this.binding.l.setChecked(topicInfoBase0.isLike);
            com.iloen.melon.fragments.detail.viewholder.o o0 = new com.iloen.melon.fragments.detail.viewholder.o(this, topicInfoBase0, v, 1);
            this.binding.l.setOnClickListener(o0);
            MelonTextView melonTextView2 = this.binding.m;
            String s1 = topicInfoBase0.likeCnt;
            String s2 = "0";
            if(s1 == null) {
                s3 = "0";
            }
            else {
                s3 = k.a(context0, s1);
                if(s3 == null) {
                    s3 = "0";
                }
            }
            melonTextView2.setText(s3);
            String s4 = topicInfoBase0.totalCmtCnt;
            if(s4 != null) {
                String s5 = k.a(context0, s4);
                if(s5 != null) {
                    s2 = s5;
                }
            }
            this.binding.b.setText(s2);
            List list0 = topicInfoBase0.cmtList;
            String s6 = "";
            if(list0 != null) {
                CMTLIST topicInfoBase$CMTLIST0 = (CMTLIST)p.n0(0, list0);
                if(topicInfoBase$CMTLIST0 != null) {
                    for(Object object0: e.k.A(new View[]{this.binding.e, this.binding.f, this.binding.d, this.binding.g})) {
                        ((View)object0).setVisibility(0);
                    }
                    if(topicInfoBase$CMTLIST0.memberNickname.length() > 15) {
                        String s7 = topicInfoBase$CMTLIST0.memberNickname;
                        q.f(s7, "memberNickname");
                        g g0 = a.K(0, 15);
                        q.g(g0, "indices");
                        s8 = g0.isEmpty() ? "" : o.V0(s7, g0);
                    }
                    else {
                        s8 = topicInfoBase$CMTLIST0.memberNickname;
                    }
                    this.binding.e.setText(s8);
                    this.binding.f.setText(topicInfoBase$CMTLIST0.artistTemperature);
                    int v3 = ProtocolUtils.parseInt(topicInfoBase$CMTLIST0.artistTemperature, 0);
                    int v4 = ResourceUtils.getFriendlyColorId(context0, v3);
                    this.binding.f.setTextColor(v4);
                    this.binding.d.setImageResource(ResourceUtils.INSTANCE.get3dpDegreeImageResId(v3));
                    this.binding.g.setText(topicInfoBase$CMTLIST0.cmtCont);
                    String s9 = context0.getString(0x7F130210, new Object[]{s2});  // string:comment_all_view "댓글 %1$s개 모두 보기"
                    this.binding.c.setText(s9);
                    this.binding.c.setVisibility(0);
                    com.iloen.melon.fragments.detail.viewholder.o o1 = new com.iloen.melon.fragments.detail.viewholder.o(this, topicInfoBase0, v, 2);
                    this.binding.c.setOnClickListener(o1);
                }
            }
            List list1 = topicInfoBase0.cmtList;
            if(list1 != null) {
                CMTLIST topicInfoBase$CMTLIST1 = (CMTLIST)p.n0(1, list1);
                if(topicInfoBase$CMTLIST1 != null) {
                    for(Object object1: e.k.A(new View[]{this.binding.i, this.binding.j, this.binding.h, this.binding.k})) {
                        ((View)object1).setVisibility(0);
                    }
                    if(topicInfoBase$CMTLIST1.memberNickname.length() > 15) {
                        String s10 = topicInfoBase$CMTLIST1.memberNickname;
                        q.f(s10, "memberNickname");
                        g g1 = a.K(0, 15);
                        q.g(g1, "indices");
                        if(!g1.isEmpty()) {
                            s6 = o.V0(s10, g1);
                        }
                    }
                    else {
                        s6 = topicInfoBase$CMTLIST1.memberNickname;
                    }
                    this.binding.i.setText(s6);
                    this.binding.j.setText(topicInfoBase$CMTLIST1.artistTemperature);
                    int v5 = ProtocolUtils.parseInt(topicInfoBase$CMTLIST1.artistTemperature, 0);
                    int v6 = ResourceUtils.getFriendlyColorId(context0, v5);
                    this.binding.j.setTextColor(v6);
                    this.binding.h.setImageResource(ResourceUtils.INSTANCE.get3dpDegreeImageResId(v5));
                    this.binding.k.setText(topicInfoBase$CMTLIST1.cmtCont);
                }
            }
        }
    }

    private static final void bind$lambda$2(t3 t30, DetailContentsTopicItemHolder detailContentsTopicItemHolder0) {
        float f = t30.d.getLineCount() <= 1 ? 24.0f : 20.0f;
        t30.d.setTextSize(1, f);
        q.f(t30.d, "title");
        int v = 0;
        t30.d.setVisibility(0);
        q.f(t30.b, "quoteLeft");
        t30.b.setVisibility(0);
        ImageView imageView0 = t30.c;
        q.f(imageView0, "quoteRight");
        if(!detailContentsTopicItemHolder0.isHorizontal) {
            v = 8;
        }
        imageView0.setVisibility(v);
    }

    private static final void bind$lambda$3(DetailContentsTopicItemHolder detailContentsTopicItemHolder0, TopicInfoBase topicInfoBase0, int v, View view0) {
        detailContentsTopicItemHolder0.actionListener.onClickTopic(topicInfoBase0, v);
    }

    private static final void bind$lambda$4(DetailContentsTopicItemHolder detailContentsTopicItemHolder0, TopicInfoBase topicInfoBase0, int v, View view0) {
        detailContentsTopicItemHolder0.actionListener.onClickLike(topicInfoBase0, v);
    }

    private static final void bind$lambda$7$lambda$6(DetailContentsTopicItemHolder detailContentsTopicItemHolder0, TopicInfoBase topicInfoBase0, int v, View view0) {
        detailContentsTopicItemHolder0.actionListener.onClickViewAllComment(topicInfoBase0, v);
    }

    public final void initViewHolder() {
        this.binding.n.removeAllViews();
        this.binding.n.getLayoutParams().height = 0;
        q.f(this.binding.e, "commentOneNickname");
        q.f(this.binding.f, "commentOneTemperature");
        q.f(this.binding.d, "commentOneDegree");
        q.f(this.binding.g, "commentOneText");
        q.f(this.binding.i, "commentTwoNickname");
        q.f(this.binding.j, "commentTwoTemperature");
        q.f(this.binding.h, "commentTwoDegree");
        q.f(this.binding.k, "commentTwoText");
        q.f(this.binding.c, "commentAll");
        for(Object object0: e.k.A(new View[]{this.binding.e, this.binding.f, this.binding.d, this.binding.g, this.binding.i, this.binding.j, this.binding.h, this.binding.k, this.binding.c})) {
            ((View)object0).setVisibility(8);
        }
    }
}

