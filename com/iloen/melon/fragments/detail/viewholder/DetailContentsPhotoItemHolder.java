package com.iloen.melon.fragments.detail.viewholder;

import De.I;
import J8.b;
import J8.p1;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.O0;
import com.bumptech.glide.Glide;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.net.v5x.response.DetailBaseRes.PHOTO;
import com.iloen.melon.utils.ui.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001F\u0010\r\u001A\u00020\f2\b\u0010\t\u001A\u0004\u0018\u00010\b2\u0006\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\r\u0010\u000ER\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000FR\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsPhotoItemHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/p1;", "binding", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsPhotoItemHolder$PhotoActionListener;", "actionListener", "<init>", "(LJ8/p1;Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsPhotoItemHolder$PhotoActionListener;)V", "Lcom/iloen/melon/net/v5x/response/DetailBaseRes$PHOTO;", "item", "", "position", "Lie/H;", "bind", "(Lcom/iloen/melon/net/v5x/response/DetailBaseRes$PHOTO;I)V", "LJ8/p1;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsPhotoItemHolder$PhotoActionListener;", "Companion", "PhotoActionListener", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DetailContentsPhotoItemHolder extends O0 {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsPhotoItemHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsPhotoItemHolder;", "parent", "Landroid/view/ViewGroup;", "actionListener", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsPhotoItemHolder$PhotoActionListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final DetailContentsPhotoItemHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull PhotoActionListener detailContentsPhotoItemHolder$PhotoActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailContentsPhotoItemHolder$PhotoActionListener0, "actionListener");
            View view0 = LayoutInflater.from(viewGroup0.getContext()).inflate(0x7F0D041B, viewGroup0, false);  // layout:griditem_photo
            int v = 0x7F0A0610;  // id:iv_check
            if(((ImageView)I.C(view0, 0x7F0A0610)) != null && ((ImageView)I.C(view0, 0x7F0A0632)) != null) {  // id:iv_check
                v = 0x7F0A0B72;  // id:thumb_container
                View view1 = I.C(view0, 0x7F0A0B72);  // id:thumb_container
                if(view1 != null) {
                    b b0 = b.c(view1);
                    if(((MelonTextView)I.C(view0, 0x7F0A0C71)) != null) {  // id:tv_event_label
                        return new DetailContentsPhotoItemHolder(new p1(((RelativeLayout)view0), b0), detailContentsPhotoItemHolder$PhotoActionListener0, null);
                    }
                    v = 0x7F0A0C71;  // id:tv_event_label
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
        }
    }

    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsPhotoItemHolder$PhotoActionListener;", "", "Lcom/iloen/melon/net/v5x/response/DetailBaseRes$PHOTO;", "photo", "", "position", "Lie/H;", "onClickPhoto", "(Lcom/iloen/melon/net/v5x/response/DetailBaseRes$PHOTO;I)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface PhotoActionListener {
        void onClickPhoto(@Nullable PHOTO arg1, int arg2);
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final PhotoActionListener actionListener;
    @NotNull
    private final p1 binding;

    static {
        DetailContentsPhotoItemHolder.Companion = new Companion(null);
        DetailContentsPhotoItemHolder.$stable = 8;
    }

    private DetailContentsPhotoItemHolder(p1 p10, PhotoActionListener detailContentsPhotoItemHolder$PhotoActionListener0) {
        super(p10.a);
        this.binding = p10;
        this.actionListener = detailContentsPhotoItemHolder$PhotoActionListener0;
    }

    public DetailContentsPhotoItemHolder(p1 p10, PhotoActionListener detailContentsPhotoItemHolder$PhotoActionListener0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(p10, detailContentsPhotoItemHolder$PhotoActionListener0);
    }

    public final void bind(@Nullable PHOTO detailBaseRes$PHOTO0, int v) {
        MelonImageView melonImageView0 = (MelonImageView)this.binding.b.c;
        String s = null;
        Glide.with(melonImageView0).load((detailBaseRes$PHOTO0 == null ? null : detailBaseRes$PHOTO0.photoImg)).into(melonImageView0);
        RelativeLayout relativeLayout0 = this.binding.a;
        relativeLayout0.setOnClickListener(new l(this, detailBaseRes$PHOTO0, v, 2));
        Context context0 = relativeLayout0.getContext();
        if(detailBaseRes$PHOTO0 != null) {
            s = detailBaseRes$PHOTO0.photoName;
        }
        ViewUtils.setContentDescriptionWithButtonClassName(relativeLayout0, context0.getString(0x7F130BB3, new Object[]{s}));  // string:talkback_photo_item "%1$s, 포토, 상세보기"
    }

    private static final void bind$lambda$2$lambda$1(DetailContentsPhotoItemHolder detailContentsPhotoItemHolder0, PHOTO detailBaseRes$PHOTO0, int v, View view0) {
        detailContentsPhotoItemHolder0.actionListener.onClickPhoto(detailBaseRes$PHOTO0, v);
    }
}

