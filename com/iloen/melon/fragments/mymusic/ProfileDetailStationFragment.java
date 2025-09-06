package com.iloen.melon.fragments.mymusic;

import B.a;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.android.volley.Response.Listener;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.HttpResponse;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v5x.request.CastMemberDetailReq.Params;
import com.iloen.melon.net.v5x.request.CastMemberDetailReq;
import com.iloen.melon.net.v5x.response.CastMemberDetailRes.RESPONSE.PROGRAM;
import com.iloen.melon.net.v5x.response.CastMemberDetailRes.RESPONSE;
import com.iloen.melon.net.v5x.response.CastMemberDetailRes;
import com.iloen.melon.net.v5x.response.ProgramBase.Cast;
import com.iloen.melon.net.v5x.response.ProgramBase;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import com.kakao.tiara.data.ActionKind;
import e.k;
import java.util.ArrayList;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.f;
import p8.g;
import p8.s;
import v9.h;
import v9.i;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 ;2\u00020\u0001:\u0005;<=>?B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000B\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\r\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\tH\u0002\u00A2\u0006\u0004\b\r\u0010\fJ\u000F\u0010\u000F\u001A\u00020\u000EH\u0014\u00A2\u0006\u0004\b\u000F\u0010\u0010J\u0019\u0010\u0013\u001A\u00020\u00062\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011H\u0016\u00A2\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001A\u00020\u00062\u0006\u0010\u0015\u001A\u00020\u0011H\u0014\u00A2\u0006\u0004\b\u0016\u0010\u0014J\u0017\u0010\u0018\u001A\u00020\u00062\u0006\u0010\u0017\u001A\u00020\u0011H\u0016\u00A2\u0006\u0004\b\u0018\u0010\u0014J-\u0010\u001E\u001A\u0004\u0018\u00010\u001D2\u0006\u0010\u001A\u001A\u00020\u00192\b\u0010\u001C\u001A\u0004\u0018\u00010\u001B2\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011H\u0016\u00A2\u0006\u0004\b\u001E\u0010\u001FJ!\u0010!\u001A\u00020\u00062\u0006\u0010 \u001A\u00020\u001D2\b\u0010\u0012\u001A\u0004\u0018\u00010\u0011H\u0016\u00A2\u0006\u0004\b!\u0010\"J\u001B\u0010&\u001A\u0006\u0012\u0002\b\u00030%2\u0006\u0010$\u001A\u00020#H\u0014\u00A2\u0006\u0004\b&\u0010\'J\u000F\u0010)\u001A\u00020(H\u0014\u00A2\u0006\u0004\b)\u0010*J\u000F\u0010,\u001A\u00020+H\u0016\u00A2\u0006\u0004\b,\u0010-J-\u00103\u001A\u00020\u000E2\b\u0010/\u001A\u0004\u0018\u00010.2\b\u00101\u001A\u0004\u0018\u0001002\b\u00102\u001A\u0004\u0018\u00010+H\u0014\u00A2\u0006\u0004\b3\u00104R\u0016\u00105\u001A\u00020+8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010:\u001A\u0002078BX\u0082\u0004\u00A2\u0006\u0006\u001A\u0004\b8\u00109\u00A8\u0006@"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/ProfileDetailStationFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "<init>", "()V", "Lcom/iloen/melon/net/v5x/response/ProgramBase;", "program", "Lie/H;", "tiaraLogShowAllProgram", "(Lcom/iloen/melon/net/v5x/response/ProgramBase;)V", "Lcom/iloen/melon/net/v5x/response/ProgramBase$Cast;", "cast", "tiaraLogPlayStation", "(Lcom/iloen/melon/net/v5x/response/ProgramBase$Cast;)V", "tiaraLogMoveStationEpisodeDetail", "", "hasScrolledLine", "()Z", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "inState", "onRestoreInstanceState", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "", "getCacheKey", "()Ljava/lang/String;", "Lv9/i;", "type", "Lv9/h;", "param", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "creatorId", "Ljava/lang/String;", "Lp8/f;", "getBaseTiaraLogEventBuilder", "()Lp8/f;", "baseTiaraLogEventBuilder", "Companion", "CastProgramAdapter", "ProgramTitleViewHolder", "ProgramViewHolder", "CastItemHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class ProfileDetailStationFragment extends MetaContentBaseFragment {
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001E2\u00020\u0001:\u0001\u001EB\u0019\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000B\u001A\u00020\n2\b\u0010\t\u001A\u0004\u0018\u00010\b¢\u0006\u0004\b\u000B\u0010\fR\u0014\u0010\u000E\u001A\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000E\u0010\u000FR\u0017\u0010\u0011\u001A\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001A\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001A\u00020\r8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u000F\u001A\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001A\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001AR\u0017\u0010\u001B\u001A\u00020\u00188\u0006¢\u0006\f\n\u0004\b\u001B\u0010\u001A\u001A\u0004\b\u001C\u0010\u001D¨\u0006\u001F"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/ProfileDetailStationFragment$CastItemHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "", "isHorizontalPadding", "<init>", "(Landroid/view/View;Z)V", "Lcom/iloen/melon/net/v5x/response/ProgramBase$Cast;", "cast", "Lie/H;", "bind", "(Lcom/iloen/melon/net/v5x/response/ProgramBase$Cast;)V", "Landroid/widget/ImageView;", "defaultIv", "Landroid/widget/ImageView;", "Lcom/iloen/melon/custom/MelonImageView;", "thumbIv", "Lcom/iloen/melon/custom/MelonImageView;", "getThumbIv", "()Lcom/iloen/melon/custom/MelonImageView;", "playIv", "getPlayIv", "()Landroid/widget/ImageView;", "Landroid/widget/TextView;", "titleSTv", "Landroid/widget/TextView;", "dateTv", "getDateTv", "()Landroid/widget/TextView;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class CastItemHolder extends O0 {
        @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/ProfileDetailStationFragment$CastItemHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/mymusic/ProfileDetailStationFragment$CastItemHolder;", "parent", "Landroid/view/ViewGroup;", "isHorizontalPadding", "", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class Companion {
            private Companion() {
            }

            public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            @NotNull
            public final CastItemHolder newInstance(@NotNull ViewGroup viewGroup0, boolean z) {
                q.g(viewGroup0, "parent");
                View view0 = LayoutInflater.from(viewGroup0.getContext()).inflate(0x7F0D0486, viewGroup0, false);  // layout:listitem_detail_station
                q.d(view0);
                return new CastItemHolder(view0, z);
            }

            public static CastItemHolder newInstance$default(Companion profileDetailStationFragment$CastItemHolder$Companion0, ViewGroup viewGroup0, boolean z, int v, Object object0) {
                if((v & 2) != 0) {
                    z = false;
                }
                return profileDetailStationFragment$CastItemHolder$Companion0.newInstance(viewGroup0, z);
            }
        }

        public static final int $stable;
        @NotNull
        public static final Companion Companion;
        @NotNull
        private final TextView dateTv;
        @NotNull
        private final ImageView defaultIv;
        @NotNull
        private final ImageView playIv;
        @NotNull
        private final MelonImageView thumbIv;
        @NotNull
        private final TextView titleSTv;

        static {
            CastItemHolder.Companion = new Companion(null);
            CastItemHolder.$stable = 8;
        }

        public CastItemHolder(@NotNull View view0, boolean z) {
            q.g(view0, "view");
            super(view0);
            View view1 = view0.findViewById(0x7F0A069E);  // id:iv_thumb_default
            q.e(view1, "null cannot be cast to non-null type android.widget.ImageView");
            this.defaultIv = (ImageView)view1;
            View view2 = view0.findViewById(0x7F0A069A);  // id:iv_thumb
            q.e(view2, "null cannot be cast to non-null type com.iloen.melon.custom.MelonImageView");
            this.thumbIv = (MelonImageView)view2;
            View view3 = view0.findViewById(0x7F0A091D);  // id:play_button
            q.e(view3, "null cannot be cast to non-null type android.widget.ImageView");
            this.playIv = (ImageView)view3;
            View view4 = view0.findViewById(0x7F0A0B8D);  // id:title
            q.e(view4, "null cannot be cast to non-null type android.widget.TextView");
            this.titleSTv = (TextView)view4;
            View view5 = view0.findViewById(0x7F0A00B8);  // id:artist_name
            q.e(view5, "null cannot be cast to non-null type android.widget.TextView");
            this.dateTv = (TextView)view5;
            if(z) {
                int v = this.itemView.getContext().getResources().getDimensionPixelSize(0x7F0700E3);  // dimen:detail_list_padding_left_right
                int v1 = this.itemView.getPaddingTop();
                int v2 = this.itemView.getPaddingBottom();
                this.itemView.setPadding(v, v1, v, v2);
            }
            ViewUtils.setDefaultImage(((ImageView)view1), ScreenUtils.dipToPixel(this.itemView.getContext(), 78.0f), false);
            View view6 = view0.findViewById(0x7F0A0D61);  // id:type_name
            if(view6 != null) {
                view6.setVisibility(8);
            }
            ((TextView)view5).setTextColor(ColorUtils.getColor(this.itemView.getContext(), 0x7F06015D));  // color:gray500s_support_high_contrast
            ((TextView)view5).setTextSize(1, 12.0f);
            int v3 = ScreenUtils.dipToPixel(((TextView)view5).getContext(), 4.0f);
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = ((TextView)view5).getLayoutParams();
            ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0) : null;
            if(viewGroup$MarginLayoutParams0 != null) {
                viewGroup$MarginLayoutParams0.setMargins(viewGroup$MarginLayoutParams0.leftMargin, v3, viewGroup$MarginLayoutParams0.rightMargin, viewGroup$MarginLayoutParams0.bottomMargin);
            }
        }

        public CastItemHolder(View view0, boolean z, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 2) != 0) {
                z = false;
            }
            this(view0, z);
        }

        public final void bind(@Nullable Cast programBase$Cast0) {
            if(programBase$Cast0 == null) {
                this.itemView.setVisibility(8);
                return;
            }
            this.itemView.setVisibility(0);
            String s = programBase$Cast0.verticalImgUrl == null || programBase$Cast0.verticalImgUrl.length() <= 0 ? programBase$Cast0.castImgUrl : programBase$Cast0.verticalImgUrl;
            Glide.with(this.itemView.getContext()).load(s).into(this.thumbIv);
            this.titleSTv.setText(programBase$Cast0.castTitle);
            this.dateTv.setText(programBase$Cast0.castDate);
        }

        @NotNull
        public final TextView getDateTv() {
            return this.dateTv;
        }

        @NotNull
        public final ImageView getPlayIv() {
            return this.playIv;
        }

        @NotNull
        public final MelonImageView getThumbIv() {
            return this.thumbIv;
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ-\u0010\u0011\u001A\u00020\u00102\b\u0010\u000B\u001A\u0004\u0018\u00010\n2\b\u0010\r\u001A\u0004\u0018\u00010\f2\b\u0010\u000F\u001A\u0004\u0018\u00010\u000EH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u001F\u0010\u0016\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001B\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u001A\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u001B\u0010\u001CJ\'\u0010\u001F\u001A\u00020\u001E2\u0006\u0010\u001D\u001A\u00020\u00032\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u0013H\u0016¢\u0006\u0004\b\u001F\u0010 ¨\u0006!"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/ProfileDetailStationFragment$CastProgramAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/iloen/melon/fragments/mymusic/DataWrapper;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/mymusic/ProfileDetailStationFragment;Landroid/content/Context;Ljava/util/List;)V", "", "key", "Lv9/i;", "type", "Lcom/iloen/melon/net/HttpResponse;", "responseContainer", "", "handleResponse", "(Ljava/lang/String;Lv9/i;Lcom/iloen/melon/net/HttpResponse;)Z", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class CastProgramAdapter extends p {
        public CastProgramAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            ProfileDetailStationFragment.this = profileDetailStationFragment0;
            super(context0, list0);
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return ((DataWrapper)this.getItem(v1)).getViewType();
        }

        @Override  // com.iloen.melon.adapters.common.p
        public boolean handleResponse(@Nullable String s, @Nullable i i0, @Nullable HttpResponse httpResponse0) {
            if(httpResponse0 instanceof CastMemberDetailRes) {
                RESPONSE castMemberDetailRes$RESPONSE0 = ((CastMemberDetailRes)httpResponse0).response;
                if(castMemberDetailRes$RESPONSE0 != null) {
                    this.setMenuId(castMemberDetailRes$RESPONSE0.menuId);
                    this.setHasMore(false);
                    this.updateModifiedTime(s);
                    ArrayList arrayList0 = castMemberDetailRes$RESPONSE0.programList;
                    if(arrayList0 != null) {
                        if(arrayList0.size() == 1) {
                            ArrayList arrayList1 = new ArrayList();
                            PROGRAM castMemberDetailRes$RESPONSE$PROGRAM0 = (PROGRAM)arrayList0.get(0);
                            String s1 = castMemberDetailRes$RESPONSE$PROGRAM0.progTitle;
                            q.f(s1, "progTitle");
                            arrayList1.add(new ProgramTitle(s1));
                            List list0 = castMemberDetailRes$RESPONSE$PROGRAM0.castList;
                            q.f(list0, "castList");
                            ArrayList arrayList2 = new ArrayList(je.q.Q(10, list0));
                            for(Object object0: list0) {
                                q.d(((Cast)object0));
                                arrayList2.add(new CastItem(((Cast)object0)));
                            }
                            arrayList1.addAll(arrayList2);
                            this.addAll(arrayList1);
                            return true;
                        }
                        ArrayList arrayList3 = new ArrayList(je.q.Q(10, arrayList0));
                        for(Object object1: arrayList0) {
                            q.d(((PROGRAM)object1));
                            arrayList3.add(new Program(((PROGRAM)object1)));
                        }
                        this.addAll(arrayList3);
                    }
                }
            }
            return true;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@NotNull O0 o00, int v, int v1) {
            q.g(o00, "viewHolder");
            DataWrapper dataWrapper0 = (DataWrapper)this.getItem(v1);
            String s = null;
            if(o00 instanceof ProgramTitleViewHolder) {
                ProgramTitle dataWrapper$ProgramTitle0 = dataWrapper0 instanceof ProgramTitle ? ((ProgramTitle)dataWrapper0) : null;
                if(dataWrapper$ProgramTitle0 != null) {
                    s = dataWrapper$ProgramTitle0.getTitle();
                }
                ((ProgramTitleViewHolder)o00).getTitleTv().setText(s);
                ((ProgramTitleViewHolder)o00).getViewAllTv().setVisibility(8);
                return;
            }
            if(o00 instanceof CastItemHolder) {
                CastItem dataWrapper$CastItem0 = dataWrapper0 instanceof CastItem ? ((CastItem)dataWrapper0) : null;
                Cast programBase$Cast0 = dataWrapper$CastItem0 == null ? null : dataWrapper$CastItem0.getCast();
                ((CastItemHolder)o00).bind(programBase$Cast0);
                if(programBase$Cast0 != null) {
                    s = programBase$Cast0.castSeq;
                }
                ((CastItemHolder)o00).getPlayIv().setOnClickListener(new g0(s, this, ProfileDetailStationFragment.this, programBase$Cast0, 0));
                h0 h00 = new h0(s, ProfileDetailStationFragment.this, programBase$Cast0, 0);
                o00.itemView.setOnClickListener(h00);
                return;
            }
            if(o00 instanceof ProgramViewHolder) {
                Program dataWrapper$Program0 = dataWrapper0 instanceof Program ? ((Program)dataWrapper0) : null;
                PROGRAM castMemberDetailRes$RESPONSE$PROGRAM0 = dataWrapper$Program0 == null ? null : dataWrapper$Program0.getProgram();
                String s1 = castMemberDetailRes$RESPONSE$PROGRAM0 == null ? null : castMemberDetailRes$RESPONSE$PROGRAM0.progSeq;
                ((ProgramViewHolder)o00).getTitleTv().setText((castMemberDetailRes$RESPONSE$PROGRAM0 == null ? null : castMemberDetailRes$RESPONSE$PROGRAM0.progTitle));
                TextView textView0 = ((ProgramViewHolder)o00).getViewAllTv();
                int v2 = 0;
                ViewUtils.showWhen(textView0, (castMemberDetailRes$RESPONSE$PROGRAM0 == null ? false : castMemberDetailRes$RESPONSE$PROGRAM0.moreData));
                textView0.setOnClickListener(new z(s1, ProfileDetailStationFragment.this, castMemberDetailRes$RESPONSE$PROGRAM0, 1));
                List list0 = castMemberDetailRes$RESPONSE$PROGRAM0 == null ? null : castMemberDetailRes$RESPONSE$PROGRAM0.castList;
                ProfileDetailStationFragment profileDetailStationFragment0 = ProfileDetailStationFragment.this;
                for(Object object0: ((ProgramViewHolder)o00).getItems()) {
                    if(v2 >= 0) {
                        Cast programBase$Cast1 = list0 == null ? null : ((Cast)je.p.n0(v2, list0));
                        ((CastItemHolder)object0).bind(programBase$Cast1);
                        String s2 = programBase$Cast1 == null ? null : programBase$Cast1.castSeq;
                        ((CastItemHolder)object0).getPlayIv().setOnClickListener(new g0(s2, this, profileDetailStationFragment0, programBase$Cast1, 1));
                        h0 h01 = new h0(s2, profileDetailStationFragment0, programBase$Cast1, 1);
                        ((CastItemHolder)object0).itemView.setOnClickListener(h01);
                        ++v2;
                        continue;
                    }
                    k.O();
                    throw null;
                }
            }
        }

        private static final void onBindViewImpl$lambda$2(String s, CastProgramAdapter profileDetailStationFragment$CastProgramAdapter0, ProfileDetailStationFragment profileDetailStationFragment0, Cast programBase$Cast0, View view0) {
            if(s != null && s.length() > 0) {
                String s1 = profileDetailStationFragment$CastProgramAdapter0.getMenuId();
                Navigator.INSTANCE.openStationListen(s, s1);
                profileDetailStationFragment0.tiaraLogPlayStation(programBase$Cast0);
            }
        }

        private static final void onBindViewImpl$lambda$3(String s, ProfileDetailStationFragment profileDetailStationFragment0, Cast programBase$Cast0, View view0) {
            if(s != null && s.length() > 0) {
                Navigator.INSTANCE.openCastEpisodeDetail(s);
                profileDetailStationFragment0.tiaraLogMoveStationEpisodeDetail(programBase$Cast0);
            }
        }

        private static final void onBindViewImpl$lambda$5$lambda$4(String s, ProfileDetailStationFragment profileDetailStationFragment0, PROGRAM castMemberDetailRes$RESPONSE$PROGRAM0, View view0) {
            if(s != null && s.length() > 0) {
                Navigator.INSTANCE.openStationProgram(s);
                profileDetailStationFragment0.tiaraLogShowAllProgram(castMemberDetailRes$RESPONSE$PROGRAM0);
            }
        }

        private static final void onBindViewImpl$lambda$8$lambda$6(String s, CastProgramAdapter profileDetailStationFragment$CastProgramAdapter0, ProfileDetailStationFragment profileDetailStationFragment0, Cast programBase$Cast0, View view0) {
            if(s != null && s.length() > 0) {
                String s1 = profileDetailStationFragment$CastProgramAdapter0.getMenuId();
                Navigator.INSTANCE.openStationListen(s, s1);
                profileDetailStationFragment0.tiaraLogPlayStation(programBase$Cast0);
            }
        }

        private static final void onBindViewImpl$lambda$8$lambda$7(String s, ProfileDetailStationFragment profileDetailStationFragment0, Cast programBase$Cast0, View view0) {
            if(s != null && s.length() > 0) {
                Navigator.INSTANCE.openCastEpisodeDetail(s);
                profileDetailStationFragment0.tiaraLogMoveStationEpisodeDetail(programBase$Cast0);
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        @Nullable
        public O0 onCreateViewHolderImpl(@NotNull ViewGroup viewGroup0, int v) {
            q.g(viewGroup0, "parent");
            switch(v) {
                case 0: {
                    return ProgramTitleViewHolder.Companion.newInstance(viewGroup0);
                }
                case 1: {
                    return CastItemHolder.Companion.newInstance(viewGroup0, true);
                }
                case 2: {
                    return ProgramViewHolder.Companion.newInstance(viewGroup0);
                }
                default: {
                    return null;
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/ProfileDetailStationFragment$Companion;", "", "<init>", "()V", "TAG", "", "ARG_CREATOR_ID", "newInstance", "Lcom/iloen/melon/fragments/mymusic/ProfileDetailStationFragment;", "creatorId", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class com.iloen.melon.fragments.mymusic.ProfileDetailStationFragment.Companion {
        private com.iloen.melon.fragments.mymusic.ProfileDetailStationFragment.Companion() {
        }

        public com.iloen.melon.fragments.mymusic.ProfileDetailStationFragment.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final ProfileDetailStationFragment newInstance(@NotNull String s) {
            q.g(s, "creatorId");
            ProfileDetailStationFragment profileDetailStationFragment0 = new ProfileDetailStationFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putString("argCreatorId", s);
            profileDetailStationFragment0.setArguments(bundle0);
            return profileDetailStationFragment0;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u0017\u0010\u000B\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000B\u0010\b\u001A\u0004\b\f\u0010\n¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/ProfileDetailStationFragment$ProgramTitleViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "Landroid/widget/TextView;", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "viewAllTv", "getViewAllTv", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ProgramTitleViewHolder extends O0 {
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/ProfileDetailStationFragment$ProgramTitleViewHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/mymusic/ProfileDetailStationFragment$ProgramTitleViewHolder;", "parent", "Landroid/view/ViewGroup;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.iloen.melon.fragments.mymusic.ProfileDetailStationFragment.ProgramTitleViewHolder.Companion {
            private com.iloen.melon.fragments.mymusic.ProfileDetailStationFragment.ProgramTitleViewHolder.Companion() {
            }

            public com.iloen.melon.fragments.mymusic.ProfileDetailStationFragment.ProgramTitleViewHolder.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            @NotNull
            public final ProgramTitleViewHolder newInstance(@NotNull ViewGroup viewGroup0) {
                q.g(viewGroup0, "parent");
                View view0 = LayoutInflater.from(viewGroup0.getContext()).inflate(0x7F0D023B, viewGroup0, false);  // layout:dj_brand_radio_detail_title
                q.d(view0);
                return new ProgramTitleViewHolder(view0);
            }
        }

        public static final int $stable;
        @NotNull
        public static final com.iloen.melon.fragments.mymusic.ProfileDetailStationFragment.ProgramTitleViewHolder.Companion Companion;
        @NotNull
        private final TextView titleTv;
        @NotNull
        private final TextView viewAllTv;

        static {
            ProgramTitleViewHolder.Companion = new com.iloen.melon.fragments.mymusic.ProfileDetailStationFragment.ProgramTitleViewHolder.Companion(null);
            ProgramTitleViewHolder.$stable = 8;
        }

        public ProgramTitleViewHolder(@NotNull View view0) {
            q.g(view0, "view");
            super(view0);
            View view1 = view0.findViewById(0x7F0A0B8D);  // id:title
            q.e(view1, "null cannot be cast to non-null type android.widget.TextView");
            this.titleTv = (TextView)view1;
            View view2 = view0.findViewById(0x7F0A0DBB);  // id:view_all
            q.e(view2, "null cannot be cast to non-null type android.widget.TextView");
            this.viewAllTv = (TextView)view2;
            int v = this.itemView.getContext().getResources().getDimensionPixelSize(0x7F0700E3);  // dimen:detail_list_padding_left_right
            int v1 = this.itemView.getPaddingTop();
            int v2 = this.itemView.getPaddingBottom();
            this.itemView.setPadding(v, v1, v, v2);
        }

        @NotNull
        public final TextView getTitleTv() {
            return this.titleTv;
        }

        @NotNull
        public final TextView getViewAllTv() {
            return this.viewAllTv;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\nR\u0017\u0010\u000B\u001A\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u000B\u0010\b\u001A\u0004\b\f\u0010\nR\u001D\u0010\u000F\u001A\b\u0012\u0004\u0012\u00020\u000E0\r8\u0006¢\u0006\f\n\u0004\b\u000F\u0010\u0010\u001A\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/ProfileDetailStationFragment$ProgramViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "Landroid/widget/TextView;", "titleTv", "Landroid/widget/TextView;", "getTitleTv", "()Landroid/widget/TextView;", "viewAllTv", "getViewAllTv", "", "Lcom/iloen/melon/fragments/mymusic/ProfileDetailStationFragment$CastItemHolder;", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class ProgramViewHolder extends O0 {
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/mymusic/ProfileDetailStationFragment$ProgramViewHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/mymusic/ProfileDetailStationFragment$ProgramViewHolder;", "parent", "Landroid/view/ViewGroup;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public static final class com.iloen.melon.fragments.mymusic.ProfileDetailStationFragment.ProgramViewHolder.Companion {
            private com.iloen.melon.fragments.mymusic.ProfileDetailStationFragment.ProgramViewHolder.Companion() {
            }

            public com.iloen.melon.fragments.mymusic.ProfileDetailStationFragment.ProgramViewHolder.Companion(DefaultConstructorMarker defaultConstructorMarker0) {
            }

            @NotNull
            public final ProgramViewHolder newInstance(@NotNull ViewGroup viewGroup0) {
                q.g(viewGroup0, "parent");
                View view0 = LayoutInflater.from(viewGroup0.getContext()).inflate(0x7F0D023A, viewGroup0, false);  // layout:dj_brand_radio_detail_item
                q.d(view0);
                return new ProgramViewHolder(view0);
            }
        }

        public static final int $stable;
        @NotNull
        public static final com.iloen.melon.fragments.mymusic.ProfileDetailStationFragment.ProgramViewHolder.Companion Companion;
        @NotNull
        private final List items;
        @NotNull
        private final TextView titleTv;
        @NotNull
        private final TextView viewAllTv;

        static {
            ProgramViewHolder.Companion = new com.iloen.melon.fragments.mymusic.ProfileDetailStationFragment.ProgramViewHolder.Companion(null);
            ProgramViewHolder.$stable = 8;
        }

        public ProgramViewHolder(@NotNull View view0) {
            q.g(view0, "view");
            super(view0);
            View view1 = view0.findViewById(0x7F0A0B8D);  // id:title
            q.e(view1, "null cannot be cast to non-null type android.widget.TextView");
            this.titleTv = (TextView)view1;
            View view2 = view0.findViewById(0x7F0A0DBB);  // id:view_all
            q.e(view2, "null cannot be cast to non-null type android.widget.TextView");
            this.viewAllTv = (TextView)view2;
            View view3 = view0.findViewById(0x7F0A077F);  // id:list_item1
            q.f(view3, "findViewById(...)");
            CastItemHolder profileDetailStationFragment$CastItemHolder0 = new CastItemHolder(view3, false, 2, null);
            View view4 = view0.findViewById(0x7F0A0780);  // id:list_item2
            q.f(view4, "findViewById(...)");
            CastItemHolder profileDetailStationFragment$CastItemHolder1 = new CastItemHolder(view4, false, 2, null);
            View view5 = view0.findViewById(0x7F0A0781);  // id:list_item3
            q.f(view5, "findViewById(...)");
            this.items = k.A(new CastItemHolder[]{profileDetailStationFragment$CastItemHolder0, profileDetailStationFragment$CastItemHolder1, new CastItemHolder(view5, false, 2, null)});
        }

        @NotNull
        public final List getItems() {
            return this.items;
        }

        @NotNull
        public final TextView getTitleTv() {
            return this.titleTv;
        }

        @NotNull
        public final TextView getViewAllTv() {
            return this.viewAllTv;
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_CREATOR_ID = "argCreatorId";
    @NotNull
    public static final com.iloen.melon.fragments.mymusic.ProfileDetailStationFragment.Companion Companion = null;
    @NotNull
    private static final String TAG = "ProfileDetailStationFragment";
    @NotNull
    private String creatorId;

    static {
        ProfileDetailStationFragment.Companion = new com.iloen.melon.fragments.mymusic.ProfileDetailStationFragment.Companion(null);
        ProfileDetailStationFragment.$stable = 8;
    }

    public ProfileDetailStationFragment() {
        this.creatorId = "";
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new CastProgramAdapter(this, context0, null);
    }

    private final f getBaseTiaraLogEventBuilder() {
        f f0 = new g();  // 初始化器: Lp8/f;-><init>()V
        s s0 = this.mMelonTiaraProperty;
        String s1 = null;
        f0.b = s0 == null ? null : s0.a;
        if(s0 != null) {
            s1 = s0.b;
        }
        f0.c = s1;
        f0.I = this.getMenuId();
        return f0;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment, com.iloen.melon.fragments.CacheTag
    @NotNull
    public String getCacheKey() {
        return l1.f(MelonContentUris.g0.buildUpon(), "argCreatorId", this.creatorId, "toString(...)");
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean hasScrolledLine() {
        return true;
    }

    @NotNull
    public static final ProfileDetailStationFragment newInstance(@NotNull String s) {
        return ProfileDetailStationFragment.Companion.newInstance(s);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        if(bundle0 != null) {
            String s = bundle0.getString("argCreatorId", "");
            q.f(s, "getString(...)");
            this.creatorId = s;
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A09D1);  // id:recycler_view
        q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).setHasFixedSize(true);
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(((RecyclerView)view0).getContext()));
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        int v = ScreenUtils.dipToPixel(((RecyclerView)view0).getContext(), 4.0f);
        ((RecyclerView)view0).setPadding(((RecyclerView)view0).getPaddingLeft(), v, ((RecyclerView)view0).getPaddingRight(), ((RecyclerView)view0).getPaddingBottom());
        return (RecyclerView)view0;
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D0206, viewGroup0, false);  // layout:detail_contents_fragment
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        Params castMemberDetailReq$Params0 = new Params();
        castMemberDetailReq$Params0.creatorId = this.creatorId;
        RequestBuilder.newInstance(new CastMemberDetailReq(this.getContext(), castMemberDetailReq$Params0)).tag(this.getRequestTag()).listener(new Listener() {
            public void onResponse(CastMemberDetailRes castMemberDetailRes0) {
                if(!i0.prepareFetchComplete(castMemberDetailRes0)) {
                    return;
                }
                RESPONSE castMemberDetailRes$RESPONSE0 = castMemberDetailRes0 == null ? null : castMemberDetailRes0.response;
                if(castMemberDetailRes$RESPONSE0 != null) {
                    s s0 = new s(castMemberDetailRes$RESPONSE0.section, castMemberDetailRes$RESPONSE0.page, castMemberDetailRes$RESPONSE0.menuId, null);
                    i0.mMelonTiaraProperty = s0;
                }
                i0.performFetchComplete(this.$type, castMemberDetailRes0);
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((CastMemberDetailRes)object0));
            }
        }).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        this.creatorId = l1.g(bundle0, "inState", "argCreatorId", "", "getString(...)");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "outState");
        super.onSaveInstanceState(bundle0);
        bundle0.putString("argCreatorId", this.creatorId);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        TitleBar titleBar0 = this.getTitleBar();
        if(titleBar0 != null) {
            titleBar0.a(a.s(1));
            titleBar0.setTitle(this.getString(0x7F130AA4));  // string:station_title "스테이션"
        }
    }

    private final void tiaraLogMoveStationEpisodeDetail(Cast programBase$Cast0) {
        f f0 = this.getBaseTiaraLogEventBuilder();
        f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        f0.d = ActionKind.ClickContent;
        f0.y = this.getString(0x7F130FB5);  // string:tiara_profile_layer1_each_program "프로그램별"
        f0.e = programBase$Cast0.castSeq;
        f0.f = Y.i(ContsTypeCode.RADIO_CAST, "code(...)");
        f0.g = programBase$Cast0.castTitle;
        f0.a().track();
    }

    private final void tiaraLogPlayStation(Cast programBase$Cast0) {
        f f0 = this.getBaseTiaraLogEventBuilder();
        f0.a = this.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
        f0.d = ActionKind.PlayMusic;
        f0.y = this.getString(0x7F130FB5);  // string:tiara_profile_layer1_each_program "프로그램별"
        f0.e = programBase$Cast0.castSeq;
        f0.f = Y.i(ContsTypeCode.RADIO_CAST, "code(...)");
        f0.g = programBase$Cast0.castTitle;
        f0.a().track();
    }

    private final void tiaraLogShowAllProgram(ProgramBase programBase0) {
        f f0 = this.getBaseTiaraLogEventBuilder();
        f0.a = this.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        f0.d = ActionKind.ClickContent;
        f0.y = this.getString(0x7F130FB5);  // string:tiara_profile_layer1_each_program "프로그램별"
        f0.F = this.getString(0x7F130DB1);  // string:tiara_click_copy_view_all "전체보기"
        f0.e = programBase0.progSeq;
        f0.f = Y.i(ContsTypeCode.RADIO_PROGRAM, "code(...)");
        f0.g = programBase0.progTitle;
        f0.a().track();
    }
}

