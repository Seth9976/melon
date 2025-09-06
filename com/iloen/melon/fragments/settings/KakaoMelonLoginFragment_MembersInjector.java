package com.iloen.melon.fragments.settings;

import Ub.s;
import Ub.u;
import Xd.a;
import com.iloen.melon.fragments.MelonBaseFragment_MembersInjector;
import ge.b;
import kc.s2;
import mb.f;
import mb.k;
import mb.o;
import ob.z;

public final class KakaoMelonLoginFragment_MembersInjector implements a {
    private final b blockingProgressDialogManageProvider;
    private final b kakaoLoginUseCaseProvider;
    private final b melonLoginUseCaseProvider;
    private final b playerUseCaseProvider;
    private final b playlistManagerProvider;
    private final b remotePlayerManagerProvider;
    private final b screenCaptureUseCaseProvider;
    private final b simpleAccountUseCaseProvider;
    private final b vodRepeatManagerProvider;

    public KakaoMelonLoginFragment_MembersInjector(b b0, b b1, b b2, b b3, b b4, b b5, b b6, b b7, b b8) {
        this.blockingProgressDialogManageProvider = b0;
        this.playlistManagerProvider = b1;
        this.vodRepeatManagerProvider = b2;
        this.remotePlayerManagerProvider = b3;
        this.screenCaptureUseCaseProvider = b4;
        this.melonLoginUseCaseProvider = b5;
        this.kakaoLoginUseCaseProvider = b6;
        this.simpleAccountUseCaseProvider = b7;
        this.playerUseCaseProvider = b8;
    }

    public static a create(b b0, b b1, b b2, b b3, b b4, b b5, b b6, b b7, b b8) {
        return new KakaoMelonLoginFragment_MembersInjector(b0, b1, b2, b3, b4, b5, b6, b7, b8);
    }

    public static void injectKakaoLoginUseCase(KakaoMelonLoginFragment kakaoMelonLoginFragment0, f f0) {
        kakaoMelonLoginFragment0.kakaoLoginUseCase = f0;
    }

    public static void injectMelonLoginUseCase(KakaoMelonLoginFragment kakaoMelonLoginFragment0, k k0) {
        kakaoMelonLoginFragment0.melonLoginUseCase = k0;
    }

    public void injectMembers(KakaoMelonLoginFragment kakaoMelonLoginFragment0) {
        MelonBaseFragment_MembersInjector.injectBlockingProgressDialogManage(kakaoMelonLoginFragment0, ((k8.a)this.blockingProgressDialogManageProvider.get()));
        MelonBaseFragment_MembersInjector.injectPlaylistManager(kakaoMelonLoginFragment0, ((s2)this.playlistManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectVodRepeatManager(kakaoMelonLoginFragment0, ((u)this.vodRepeatManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectRemotePlayerManager(kakaoMelonLoginFragment0, ((s)this.remotePlayerManagerProvider.get()));
        MelonBaseFragment_MembersInjector.injectScreenCaptureUseCase(kakaoMelonLoginFragment0, ((eb.u)this.screenCaptureUseCaseProvider.get()));
        KakaoMelonLoginFragment_MembersInjector.injectMelonLoginUseCase(kakaoMelonLoginFragment0, ((k)this.melonLoginUseCaseProvider.get()));
        KakaoMelonLoginFragment_MembersInjector.injectKakaoLoginUseCase(kakaoMelonLoginFragment0, ((f)this.kakaoLoginUseCaseProvider.get()));
        KakaoMelonLoginFragment_MembersInjector.injectSimpleAccountUseCase(kakaoMelonLoginFragment0, ((o)this.simpleAccountUseCaseProvider.get()));
        KakaoMelonLoginFragment_MembersInjector.injectPlayerUseCase(kakaoMelonLoginFragment0, ((z)this.playerUseCaseProvider.get()));
    }

    public void injectMembers(Object object0) {
        this.injectMembers(((KakaoMelonLoginFragment)object0));
    }

    public static void injectPlayerUseCase(KakaoMelonLoginFragment kakaoMelonLoginFragment0, z z0) {
        kakaoMelonLoginFragment0.playerUseCase = z0;
    }

    public static void injectSimpleAccountUseCase(KakaoMelonLoginFragment kakaoMelonLoginFragment0, o o0) {
        kakaoMelonLoginFragment0.simpleAccountUseCase = o0;
    }
}

