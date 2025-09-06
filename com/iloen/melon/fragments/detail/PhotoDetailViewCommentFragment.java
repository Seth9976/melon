package com.iloen.melon.fragments.detail;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/fragments/detail/PhotoDetailViewCommentFragment;", "Lcom/iloen/melon/fragments/detail/PhotoDetailViewFragment;", "<init>", "()V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PhotoDetailViewCommentFragment extends PhotoDetailViewFragment {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\n\b\u0002\u0010\n\u001A\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000B\u001A\u0004\u0018\u00010\u0007H\u0007¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/detail/PhotoDetailViewCommentFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/iloen/melon/fragments/detail/PhotoDetailViewCommentFragment;", "photoId", "", "openReply", "", "channelSeq", "commentSeq", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final PhotoDetailViewCommentFragment newInstance(@Nullable String s) {
            return Companion.newInstance$default(this, s, false, null, null, 14, null);
        }

        @NotNull
        public final PhotoDetailViewCommentFragment newInstance(@Nullable String s, boolean z) {
            return Companion.newInstance$default(this, s, z, null, null, 12, null);
        }

        @NotNull
        public final PhotoDetailViewCommentFragment newInstance(@Nullable String s, boolean z, @Nullable String s1) {
            return Companion.newInstance$default(this, s, z, s1, null, 8, null);
        }

        @NotNull
        public final PhotoDetailViewCommentFragment newInstance(@Nullable String s, boolean z, @Nullable String s1, @Nullable String s2) {
            PhotoInfoList photoDetailViewFragment$PhotoInfoList0 = new PhotoInfoList();
            photoDetailViewFragment$PhotoInfoList0.setType(Etc.INSTANCE);
            photoDetailViewFragment$PhotoInfoList0.getPhotoItems().add(new PhotoItem(s, null, null, null, null, 30, null));
            PhotoDetailViewCommentFragment photoDetailViewCommentFragment0 = new PhotoDetailViewCommentFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putSerializable("argPhotoInfoList", photoDetailViewFragment$PhotoInfoList0);
            bundle0.putBoolean("argDirectOpenFragment", true);
            bundle0.putBoolean("argDirectOpenReply", z);
            bundle0.putString("argReplyChannelSeq", s1);
            bundle0.putString("argReplyCommentSeq", s2);
            photoDetailViewCommentFragment0.setArguments(bundle0);
            return photoDetailViewCommentFragment0;
        }

        public static PhotoDetailViewCommentFragment newInstance$default(Companion photoDetailViewCommentFragment$Companion0, String s, boolean z, String s1, String s2, int v, Object object0) {
            if((v & 2) != 0) {
                z = false;
            }
            if((v & 4) != 0) {
                s1 = null;
            }
            if((v & 8) != 0) {
                s2 = null;
            }
            return photoDetailViewCommentFragment$Companion0.newInstance(s, z, s1, s2);
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;

    static {
        PhotoDetailViewCommentFragment.Companion = new Companion(null);
        PhotoDetailViewCommentFragment.$stable = 8;
    }

    @NotNull
    public static final PhotoDetailViewCommentFragment newInstance(@Nullable String s) {
        return PhotoDetailViewCommentFragment.Companion.newInstance(s);
    }

    @NotNull
    public static final PhotoDetailViewCommentFragment newInstance(@Nullable String s, boolean z) {
        return PhotoDetailViewCommentFragment.Companion.newInstance(s, z);
    }

    @NotNull
    public static final PhotoDetailViewCommentFragment newInstance(@Nullable String s, boolean z, @Nullable String s1) {
        return PhotoDetailViewCommentFragment.Companion.newInstance(s, z, s1);
    }

    @NotNull
    public static final PhotoDetailViewCommentFragment newInstance(@Nullable String s, boolean z, @Nullable String s1, @Nullable String s2) {
        return PhotoDetailViewCommentFragment.Companion.newInstance(s, z, s1, s2);
    }
}

