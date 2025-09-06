package com.iloen.melon.fragments.main.common;

import com.kakao.tiara.data.ViewImpContent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001F\u0010\u0007\u001A\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000B\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\tH&¢\u0006\u0004\b\u000B\u0010\fJ\u0017\u0010\r\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\tH&¢\u0006\u0004\b\r\u0010\fJ\u000F\u0010\u000F\u001A\u00020\u000EH&¢\u0006\u0004\b\u000F\u0010\u0010¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lcom/iloen/melon/fragments/main/common/OnImpLogListener;", "", "", "key", "Lcom/kakao/tiara/data/ViewImpContent;", "viewImpContent", "Lie/H;", "onImpLogListener", "(Ljava/lang/String;Lcom/kakao/tiara/data/ViewImpContent;)V", "Lcom/iloen/melon/fragments/main/common/ViewableCheckViewHolder$OnStateChangeListener;", "listener", "addOnStateChangeListener", "(Lcom/iloen/melon/fragments/main/common/ViewableCheckViewHolder$OnStateChangeListener;)V", "removeOnStateChangeListener", "", "isForegroundFragment", "()Z", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public interface OnImpLogListener {
    void addOnStateChangeListener(@NotNull OnStateChangeListener arg1);

    boolean isForegroundFragment();

    void onImpLogListener(@NotNull String arg1, @NotNull ViewImpContent arg2);

    void removeOnStateChangeListener(@NotNull OnStateChangeListener arg1);
}

