package com.iloen.melon.fragments.melonchart;

import Ub.s;
import Ub.u;
import Xd.a;
import com.iloen.melon.fragments.MelonBaseFragment_MembersInjector;
import ge.b;
import kc.s2;

public final class StreamingCardFragment_MembersInjector implements a {
    private final b blockingProgressDialogManageProvider;
    private final b playlistManagerProvider;
    private final b remotePlayerManagerProvider;
    private final b screenCaptureUseCaseProvider;
    private final b streamingCardUseCaseProvider;
    private final b vodRepeatManagerProvider;

    public StreamingCardFragment_MembersInjector(b b0, b b1, b b2, b b3, b b4, b b5) {
        this.blockingProgressDialogManageProvider = b0;
        this.playlistManagerProvider = b1;
        this.vodRepeatManagerProvider = b2;
        this.remotePlayerManagerProvider = b3;
        this.screenCaptureUseCaseProvider = b4;
        this.streamingCardUseCaseProvider = b5;
    }

    public static a create(b b0, b b1, b b2, b b3, b b4, b b5) {
        return new StreamingCardFragment_MembersInjector(b0, b1, b2, b3, b4, b5);
    }

    public void injectMembers(StreamingCardFragment streamingCardFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(streamingCardFragment0, ((k8.a)this.blockingProgressDialogManageProvider.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(streamingCardFragment0, ((s2)this.playlistManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(streamingCardFragment0, ((u)this.vodRepeatManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(streamingCardFragment0, ((s)this.remotePlayerManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(streamingCardFragment0, ((eb.u)this.screenCaptureUseCaseProvider.get()));
        StreamingCardFragment_MembersInjector.injectStreamingCardUseCase(streamingCardFragment0, ((yb.b)this.streamingCardUseCaseProvider.get()));
    }

    public void injectMembers(Object object0) {
        this.injectMembers(((StreamingCardFragment)object0));
    }

    public static void injectStreamingCardUseCase(StreamingCardFragment streamingCardFragment0, yb.b b0) {
        streamingCardFragment0.streamingCardUseCase = b0;
    }
}

