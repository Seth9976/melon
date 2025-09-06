package com.iloen.melon.player.playlist.viewholder;

import J8.w1;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.O0;
import com.airbnb.lottie.LottieAnimationView;
import com.iloen.melon.custom.CheckableImageView;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.utils.color.ColorUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000B\b\u0017\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u00A2\u0006\u0004\b\u0004\u0010\u0005J-\u0010\r\u001A\u00020\f2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\n\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\b\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0015\u0010\u0010\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\b\u00A2\u0006\u0004\b\u0010\u0010\u0011J\u001D\u0010\u0013\u001A\u00020\f2\u0006\u0010\u0012\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006\u00A2\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0016\u001A\u00020\u00158\u0006\u00A2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001A\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001B\u001A\u00020\u001A8\u0006\u00A2\u0006\f\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u001D\u0010\u001ER\u0017\u0010 \u001A\u00020\u001F8\u0006\u00A2\u0006\f\n\u0004\b \u0010!\u001A\u0004\b\"\u0010#R\u0017\u0010$\u001A\u00020\u00158\u0006\u00A2\u0006\f\n\u0004\b$\u0010\u0017\u001A\u0004\b%\u0010\u0019R\u0017\u0010\'\u001A\u00020&8\u0006\u00A2\u0006\f\n\u0004\b\'\u0010(\u001A\u0004\b)\u0010*R\u0017\u0010,\u001A\u00020+8\u0006\u00A2\u0006\f\n\u0004\b,\u0010-\u001A\u0004\b.\u0010/R\u0017\u00100\u001A\u00020&8\u0006\u00A2\u0006\f\n\u0004\b0\u0010(\u001A\u0004\b1\u0010*R\u0017\u00103\u001A\u0002028\u0006\u00A2\u0006\f\n\u0004\b3\u00104\u001A\u0004\b5\u00106R\u0017\u00108\u001A\u0002078\u0006\u00A2\u0006\f\n\u0004\b8\u00109\u001A\u0004\b:\u0010;R\u0017\u0010<\u001A\u00020\u00158\u0006\u00A2\u0006\f\n\u0004\b<\u0010\u0017\u001A\u0004\b=\u0010\u0019R\u0017\u0010>\u001A\u0002078\u0006\u00A2\u0006\f\n\u0004\b>\u00109\u001A\u0004\b?\u0010;R\u0017\u0010A\u001A\u00020@8\u0006\u00A2\u0006\f\n\u0004\bA\u0010B\u001A\u0004\bC\u0010DR\u0017\u0010F\u001A\u00020E8\u0006\u00A2\u0006\f\n\u0004\bF\u0010G\u001A\u0004\bH\u0010IR\u0017\u0010J\u001A\u00020\u001F8\u0006\u00A2\u0006\f\n\u0004\bJ\u0010!\u001A\u0004\bK\u0010#R\u0017\u0010L\u001A\u00020\u001F8\u0006\u00A2\u0006\f\n\u0004\bL\u0010!\u001A\u0004\bM\u0010#R\u0017\u0010N\u001A\u00020\u001F8\u0006\u00A2\u0006\f\n\u0004\bN\u0010!\u001A\u0004\bO\u0010#\u00A8\u0006P"}, d2 = {"Lcom/iloen/melon/player/playlist/viewholder/NewSongViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/w1;", "binding", "<init>", "(LJ8/w1;)V", "Landroid/content/Context;", "context", "", "isFocus", "showAnimation", "playAnimation", "Lie/H;", "setPlayingUi", "(Landroid/content/Context;ZZZ)V", "show", "setPremiumIcon", "(Z)V", "isChecked", "setCheckBoxColorTint", "(ZLandroid/content/Context;)V", "Lcom/iloen/melon/custom/MelonTextView;", "songTitle", "Lcom/iloen/melon/custom/MelonTextView;", "getSongTitle", "()Lcom/iloen/melon/custom/MelonTextView;", "Lcom/iloen/melon/custom/CheckableImageView;", "checkBox", "Lcom/iloen/melon/custom/CheckableImageView;", "getCheckBox", "()Lcom/iloen/melon/custom/CheckableImageView;", "Landroid/widget/ImageView;", "adultImg", "Landroid/widget/ImageView;", "getAdultImg", "()Landroid/widget/ImageView;", "artistTv", "getArtistTv", "Lcom/iloen/melon/custom/MelonImageView;", "albumImg", "Lcom/iloen/melon/custom/MelonImageView;", "getAlbumImg", "()Lcom/iloen/melon/custom/MelonImageView;", "Landroidx/cardview/widget/CardView;", "thumbContainer", "Landroidx/cardview/widget/CardView;", "getThumbContainer", "()Landroidx/cardview/widget/CardView;", "ivNowPlayingBg", "getIvNowPlayingBg", "Lcom/airbnb/lottie/LottieAnimationView;", "ivNowPlaying", "Lcom/airbnb/lottie/LottieAnimationView;", "getIvNowPlaying", "()Lcom/airbnb/lottie/LottieAnimationView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "layoutSectionTitle", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getLayoutSectionTitle", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "tvSectionTitle", "getTvSectionTitle", "songLayout", "getSongLayout", "Landroid/widget/FrameLayout;", "btnMore", "Landroid/widget/FrameLayout;", "getBtnMore", "()Landroid/widget/FrameLayout;", "Landroid/widget/RelativeLayout;", "btnMove", "Landroid/widget/RelativeLayout;", "getBtnMove", "()Landroid/widget/RelativeLayout;", "btnMoveImg", "getBtnMoveImg", "ivPremium", "getIvPremium", "ivContentType", "getIvContentType", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class NewSongViewHolder extends O0 {
    public static final int $stable = 8;

    public NewSongViewHolder(@NotNull w1 w10) {
        q.g(w10, "binding");
        throw null;
    }

    @NotNull
    public final ImageView getAdultImg() {
        return null;
    }

    @NotNull
    public final MelonImageView getAlbumImg() {
        return null;
    }

    @NotNull
    public final MelonTextView getArtistTv() {
        return null;
    }

    @NotNull
    public final FrameLayout getBtnMore() {
        return null;
    }

    @NotNull
    public final RelativeLayout getBtnMove() {
        return null;
    }

    @NotNull
    public final ImageView getBtnMoveImg() {
        return null;
    }

    @NotNull
    public final CheckableImageView getCheckBox() {
        return null;
    }

    @NotNull
    public final ImageView getIvContentType() {
        return null;
    }

    @NotNull
    public final LottieAnimationView getIvNowPlaying() {
        return null;
    }

    @NotNull
    public final MelonImageView getIvNowPlayingBg() {
        return null;
    }

    @NotNull
    public final ImageView getIvPremium() {
        return null;
    }

    @NotNull
    public final ConstraintLayout getLayoutSectionTitle() {
        return null;
    }

    @NotNull
    public final ConstraintLayout getSongLayout() {
        return null;
    }

    @NotNull
    public final MelonTextView getSongTitle() {
        return null;
    }

    @NotNull
    public final CardView getThumbContainer() {
        return null;
    }

    @NotNull
    public final MelonTextView getTvSectionTitle() {
        return null;
    }

    public final void setCheckBoxColorTint(boolean z, @NotNull Context context0) {
        q.g(context0, "context");
        throw null;
    }

    public final void setPlayingUi(@NotNull Context context0, boolean z, boolean z1, boolean z2) {
        q.g(context0, "context");
        if(z) {
            ColorUtils.getColor(context0, 0x7F060179);  // color:green490e
            throw null;
        }
        ColorUtils.getColor(context0, 0x7F0604A1);  // color:white000e
        throw null;
    }

    public final void setPremiumIcon(boolean z) {
        throw null;
    }
}

