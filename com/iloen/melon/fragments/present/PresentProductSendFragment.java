package com.iloen.melon.fragments.present;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.media3.session.S0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import com.iloen.melon.adapters.common.q;
import com.iloen.melon.custom.ToReceiverViewForPresent;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.GiftInformProdGiftBoxReq;
import com.iloen.melon.net.v4x.response.GiftInformProdGiftBoxRes.RESPONSE;
import com.iloen.melon.net.v4x.response.GiftInformProdGiftBoxRes;
import com.iloen.melon.utils.Presentable.Builder;
import com.iloen.melon.utils.Presentable;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtils;
import java.util.ArrayList;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.h;
import v9.i;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\'\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\bH\u0014¢\u0006\u0004\b\u000B\u0010\fJ\u001B\u0010\u0010\u001A\u0006\u0012\u0002\b\u00030\u000F2\u0006\u0010\u000E\u001A\u00020\rH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u000F\u0010\u0013\u001A\u00020\u0012H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u000F\u0010\u0016\u001A\u00020\u0015H\u0014¢\u0006\u0004\b\u0016\u0010\u0003J\u000F\u0010\u0018\u001A\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000F\u0010\u001A\u001A\u00020\u0017H\u0016¢\u0006\u0004\b\u001A\u0010\u0019R\u001A\u0010\u001B\u001A\u00020\b8\u0016X\u0096D¢\u0006\f\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u001D\u0010\u001ER\u001A\u0010\u001F\u001A\u00020\u00178\u0016X\u0096D¢\u0006\f\n\u0004\b\u001F\u0010 \u001A\u0004\b!\u0010\u0019¨\u0006$"}, d2 = {"Lcom/iloen/melon/fragments/present/PresentProductSendFragment;", "Lcom/iloen/melon/fragments/present/PresentSendFragment;", "<init>", "()V", "Lv9/i;", "type", "Lv9/h;", "param", "", "reason", "", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Lie/H;", "sendMessage", "", "getMaxReceiverCount", "()I", "getPresentCount", "TAG", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "MAX_RECEIVER_COUNT", "I", "getMAX_RECEIVER_COUNT", "Companion", "ProductAdaptor", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PresentProductSendFragment extends PresentSendFragment {
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u00072\u001A\u0010\b\u001A\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\u00072\b\u0010\r\u001A\u0004\u0018\u00010\u0007H\u0007¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/fragments/present/PresentProductSendFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/present/PresentProductSendFragment;", "menuId", "", "receivers", "Ljava/util/ArrayList;", "Lcom/iloen/melon/custom/ToReceiverView$Receiver;", "Lkotlin/collections/ArrayList;", "prodId", "eventAuthKey", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final PresentProductSendFragment newInstance(@Nullable String s, @Nullable ArrayList arrayList0, @Nullable String s1, @Nullable String s2) {
            PresentProductSendFragment presentProductSendFragment0 = new PresentProductSendFragment();
            Bundle bundle0 = Y.c("menuId", s, "presentProductId", s1);
            bundle0.putString("presentEventEnterAuthKey", s2);
            bundle0.putParcelableArrayList("presentReceiverList", arrayList0);
            presentProductSendFragment0.setArguments(bundle0);
            return presentProductSendFragment0;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n0\u0003R\u00060\u0000R\u00020\u00040\u0001:\u0001\u001CB\u001F\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u000E\u0010\b\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000F\u0010\f\u001A\u00020\u000BH\u0014¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000E\u001A\u00020\u000BH\u0014¢\u0006\u0004\b\u000E\u0010\rJ\u0017\u0010\u0010\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u0015\u001A\u00020\u00142\u000E\u0010\u0012\u001A\n0\u0003R\u00060\u0000R\u00020\u00042\u0006\u0010\u0013\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\'\u0010\u001A\u001A\n0\u0003R\u00060\u0000R\u00020\u00042\u0006\u0010\u0018\u001A\u00020\u00172\u0006\u0010\u0019\u001A\u00020\u000BH\u0016¢\u0006\u0004\b\u001A\u0010\u001B¨\u0006\u001D"}, d2 = {"Lcom/iloen/melon/fragments/present/PresentProductSendFragment$ProductAdaptor;", "Lcom/iloen/melon/adapters/common/q;", "Lcom/iloen/melon/net/v4x/response/GiftInformProdGiftBoxRes$RESPONSE;", "Lcom/iloen/melon/fragments/present/PresentProductSendFragment$ProductAdaptor$ViewHolder;", "Lcom/iloen/melon/fragments/present/PresentProductSendFragment;", "Landroid/content/Context;", "context", "", "list", "<init>", "(Lcom/iloen/melon/fragments/present/PresentProductSendFragment;Landroid/content/Context;Ljava/util/List;)V", "", "getHeaderViewCount", "()I", "getFooterViewCount", "position", "getItemViewType", "(I)I", "viewHolder", "rawPosition", "Lie/H;", "onBindViewHolder", "(Lcom/iloen/melon/fragments/present/PresentProductSendFragment$ProductAdaptor$ViewHolder;II)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/iloen/melon/fragments/present/PresentProductSendFragment$ProductAdaptor$ViewHolder;", "ViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class ProductAdaptor extends q {
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R$\u0010\u0007\u001A\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\f¨\u0006\r"}, d2 = {"Lcom/iloen/melon/fragments/present/PresentProductSendFragment$ProductAdaptor$ViewHolder;", "Landroidx/recyclerview/widget/O0;", "Landroid/view/View;", "view", "<init>", "(Lcom/iloen/melon/fragments/present/PresentProductSendFragment$ProductAdaptor;Landroid/view/View;)V", "Landroid/widget/TextView;", "prodName", "Landroid/widget/TextView;", "getProdName", "()Landroid/widget/TextView;", "setProdName", "(Landroid/widget/TextView;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        public final class ViewHolder extends O0 {
            @Nullable
            private TextView prodName;

            public ViewHolder(@NotNull View view0) {
                kotlin.jvm.internal.q.g(view0, "view");
                ProductAdaptor.this = presentProductSendFragment$ProductAdaptor0;
                super(view0);
                this.prodName = (TextView)view0.findViewById(0x7F0A096A);  // id:product_name
                ImageView imageView0 = (ImageView)view0.findViewById(0x7F0A0549);  // id:icon_bg
                if(imageView0 != null) {
                    imageView0.setBackgroundResource(0x7F0808B9);  // drawable:shape_rectangle_gray100a_0_5dp_blue400s_bg_round4
                }
                ViewUtils.hideWhen(view0.findViewById(0x7F0A01C3), true);  // id:btn_use
            }

            @Nullable
            public final TextView getProdName() {
                return this.prodName;
            }

            public final void setProdName(@Nullable TextView textView0) {
                this.prodName = textView0;
            }
        }

        public ProductAdaptor(@NotNull Context context0, @Nullable List list0) {
            kotlin.jvm.internal.q.g(context0, "context");
            PresentProductSendFragment.this = presentProductSendFragment0;
            super(context0, list0);
        }

        @Override  // com.iloen.melon.adapters.common.y
        public int getFooterViewCount() [...] // Inlined contents

        @Override  // com.iloen.melon.adapters.common.y
        public int getHeaderViewCount() [...] // Inlined contents

        @Override  // androidx.recyclerview.widget.j0
        public int getItemViewType(int v) {
            if(v == 0) {
                return 0;
            }
            int v1 = this.getItemCount();
            if(v == v1 - 2) {
                return 2;
            }
            return v == v1 - 1 ? 3 : 1;
        }

        @Override  // com.iloen.melon.adapters.common.y
        public void onBindViewHolder(O0 o00, int v, int v1) {
            this.onBindViewHolder(((ViewHolder)o00), v, v1);
        }

        public void onBindViewHolder(@NotNull ViewHolder presentProductSendFragment$ProductAdaptor$ViewHolder0, int v, int v1) {
            kotlin.jvm.internal.q.g(presentProductSendFragment$ProductAdaptor$ViewHolder0, "viewHolder");
            if(this.getItemViewType(v) == 1) {
                RESPONSE giftInformProdGiftBoxRes$RESPONSE0 = (RESPONSE)this.getItem(v1);
                if(giftInformProdGiftBoxRes$RESPONSE0 != null) {
                    TextView textView0 = presentProductSendFragment$ProductAdaptor$ViewHolder0.getProdName();
                    if(textView0 != null) {
                        textView0.setText(giftInformProdGiftBoxRes$RESPONSE0.prodName);
                    }
                }
            }
        }

        @Override  // androidx.recyclerview.widget.j0
        public O0 onCreateViewHolder(ViewGroup viewGroup0, int v) {
            return this.onCreateViewHolder(viewGroup0, v);
        }

        @NotNull
        public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup0, int v) {
            View view0;
            kotlin.jvm.internal.q.g(viewGroup0, "parent");
            if(v == 0) {
                return new ViewHolder(this, PresentProductSendFragment.this.getMHeaderView());
            }
            switch(v) {
                case 1: {
                    view0 = this.mInflater.inflate(0x7F0D05B4, null);  // layout:present_detail_product_item
                    kotlin.jvm.internal.q.f(view0, "inflate(...)");
                    return new ViewHolder(this, view0);
                }
                case 2: {
                    return new ViewHolder(this, PresentProductSendFragment.this.getMMessageContainer());
                }
                case 3: {
                    return new ViewHolder(this, PresentProductSendFragment.this.getMDescriptionContainer());
                }
                default: {
                    view0 = this.mInflater.inflate(0x7F0D05B4, null);  // layout:present_detail_product_item
                    kotlin.jvm.internal.q.f(view0, "inflate(...)");
                    return new ViewHolder(this, view0);
                }
            }
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    private final int MAX_RECEIVER_COUNT;
    @NotNull
    private final String TAG;

    static {
        PresentProductSendFragment.Companion = new Companion(null);
        PresentProductSendFragment.$stable = 8;
    }

    public PresentProductSendFragment() {
        this.TAG = "PresentProductSendFragment";
        this.MAX_RECEIVER_COUNT = 5;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        kotlin.jvm.internal.q.g(context0, "context");
        return new ProductAdaptor(this, context0, null);
    }

    @Override  // com.iloen.melon.fragments.present.PresentSendFragment
    public int getMAX_RECEIVER_COUNT() {
        return this.MAX_RECEIVER_COUNT;
    }

    @Override  // com.iloen.melon.fragments.present.PresentSendFragment
    public int getMaxReceiverCount() {
        return this.getMAX_RECEIVER_COUNT();
    }

    @Override  // com.iloen.melon.fragments.present.PresentSendFragment
    public int getPresentCount() {
        ProductAdaptor presentProductSendFragment$ProductAdaptor0 = this.mAdapter instanceof ProductAdaptor ? ((ProductAdaptor)this.mAdapter) : null;
        return presentProductSendFragment$ProductAdaptor0 == null ? 0 : presentProductSendFragment$ProductAdaptor0.getCount();
    }

    @Override  // com.iloen.melon.fragments.present.PresentSendFragment
    @NotNull
    public String getTAG() {
        return this.TAG;
    }

    @NotNull
    public static final PresentProductSendFragment newInstance(@Nullable String s, @Nullable ArrayList arrayList0, @Nullable String s1, @Nullable String s2) {
        return PresentProductSendFragment.Companion.newInstance(s, arrayList0, s1, s2);
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        View view0 = this.findViewById(0x7F0A0779);  // id:list
        kotlin.jvm.internal.q.e(view0, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView)view0).getContext();
        ((RecyclerView)view0).setLayoutManager(new LinearLayoutManager(1, false));
        ((RecyclerView)view0).setHasFixedSize(true);
        ((RecyclerView)view0).setAdapter(this.mAdapter);
        return (RecyclerView)view0;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@NotNull i i0, @NotNull h h0, @NotNull String s) {
        kotlin.jvm.internal.q.g(i0, "type");
        kotlin.jvm.internal.q.g(h0, "param");
        kotlin.jvm.internal.q.g(s, "reason");
        boolean z = i.c.equals(i0);
        RequestBuilder.newInstance(new GiftInformProdGiftBoxReq(this.getContext(), this.getMProdId())).tag(this.getTAG()).listener(new S0(this, z, 4)).errorListener(this.mResponseErrorListener).request();
        return true;
    }

    private static final void onFetchStart$lambda$0(PresentProductSendFragment presentProductSendFragment0, boolean z, GiftInformProdGiftBoxRes giftInformProdGiftBoxRes0) {
        if(presentProductSendFragment0.prepareFetchComplete(giftInformProdGiftBoxRes0)) {
            j0 j00 = presentProductSendFragment0.mAdapter;
            if(j00 instanceof ProductAdaptor) {
                kotlin.jvm.internal.q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.present.PresentProductSendFragment.ProductAdaptor");
                if(!z) {
                    ((ProductAdaptor)j00).clear();
                }
                RESPONSE giftInformProdGiftBoxRes$RESPONSE0 = giftInformProdGiftBoxRes0.response;
                if(giftInformProdGiftBoxRes$RESPONSE0 != null) {
                    ((ProductAdaptor)j00).addAll(new RESPONSE[]{giftInformProdGiftBoxRes$RESPONSE0});
                }
                OnListViewChangedListener presentSendFragment$OnListViewChangedListener0 = presentProductSendFragment0.getMOnChangedListener();
                if(presentSendFragment$OnListViewChangedListener0 != null) {
                    presentSendFragment$OnListViewChangedListener0.onDataChanged();
                }
                presentProductSendFragment0.performFetchCompleteOnlyViews();
            }
        }
    }

    public static void p0(PresentProductSendFragment presentProductSendFragment0, boolean z, GiftInformProdGiftBoxRes giftInformProdGiftBoxRes0) {
        PresentProductSendFragment.onFetchStart$lambda$0(presentProductSendFragment0, z, giftInformProdGiftBoxRes0);
    }

    @Override  // com.iloen.melon.fragments.present.PresentSendFragment
    public void sendMessage() {
        Editable editable0;
        ArrayList arrayList0;
        if(TextUtils.isEmpty(this.getMProdId())) {
            LogU.Companion.d(this.getTAG(), "send - Product Object is NULL!");
            return;
        }
        if(this.getPresentCount() > 0) {
            j0 j00 = this.mAdapter;
            kotlin.jvm.internal.q.e(j00, "null cannot be cast to non-null type com.iloen.melon.fragments.present.PresentProductSendFragment.ProductAdaptor");
            RESPONSE giftInformProdGiftBoxRes$RESPONSE0 = (RESPONSE)((ProductAdaptor)j00).getItem(0);
            if(giftInformProdGiftBoxRes$RESPONSE0 != null) {
                Builder presentable$Builder0 = Presentable.newBuilder(giftInformProdGiftBoxRes$RESPONSE0, this.getMenuId());
                ToReceiverViewForPresent toReceiverViewForPresent0 = this.getMToSendersView();
                if(toReceiverViewForPresent0 == null) {
                    arrayList0 = new ArrayList();
                }
                else {
                    arrayList0 = toReceiverViewForPresent0.getList();
                    if(arrayList0 == null) {
                        arrayList0 = new ArrayList();
                    }
                }
                presentable$Builder0.setReceiver(arrayList0);
                EditText editText0 = this.getMMessageView();
                if(editText0 == null) {
                    editable0 = "";
                }
                else {
                    editable0 = editText0.getText();
                    if(editable0 == null) {
                        editable0 = "";
                    }
                }
                presentable$Builder0.sendMsgCont(editable0.toString());
                presentable$Builder0.eventEnterAuthKey(this.getMEventAuthKey());
                Presentable presentable0 = presentable$Builder0.build();
                if(presentable0 != null) {
                    presentable0.openPaymentPage();
                    this.setMIsCloseConfirm(true);
                    this.performBackPress();
                }
            }
        }
    }
}

