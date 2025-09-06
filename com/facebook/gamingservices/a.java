package com.facebook.gamingservices;

import android.content.Intent;
import com.facebook.internal.CallbackManagerImpl.Callback;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.share.internal.ResultProcessor;

public final class a implements Callback {
    public final int a;
    public final FacebookDialogBase b;
    public final ResultProcessor c;

    public a(FacebookDialogBase facebookDialogBase0, ResultProcessor resultProcessor0, int v) {
        this.a = v;
        this.b = facebookDialogBase0;
        this.c = resultProcessor0;
        super();
    }

    @Override  // com.facebook.internal.CallbackManagerImpl$Callback
    public final boolean onActivityResult(int v, Intent intent0) {
        switch(this.a) {
            case 0: {
                return ContextChooseDialog.registerCallbackImpl$lambda$4(((ContextChooseDialog)this.b), ((com.facebook.gamingservices.ContextChooseDialog.registerCallbackImpl.resultProcessor.1)this.c), v, intent0);
            }
            case 1: {
                return ContextCreateDialog.registerCallbackImpl$lambda$3(((ContextCreateDialog)this.b), ((com.facebook.gamingservices.ContextCreateDialog.registerCallbackImpl.resultProcessor.1)this.c), v, intent0);
            }
            case 2: {
                return ContextSwitchDialog.registerCallbackImpl$lambda$3(((ContextSwitchDialog)this.b), ((com.facebook.gamingservices.ContextSwitchDialog.registerCallbackImpl.resultProcessor.1)this.c), v, intent0);
            }
            case 3: {
                return TournamentJoinDialog.registerCallbackImpl$lambda$0(((TournamentJoinDialog)this.b), ((com.facebook.gamingservices.TournamentJoinDialog.registerCallbackImpl.resultProcessor.1)this.c), v, intent0);
            }
            default: {
                return TournamentShareDialog.registerCallbackImpl$lambda$0(((TournamentShareDialog)this.b), ((com.facebook.gamingservices.TournamentShareDialog.registerCallbackImpl.resultProcessor.1)this.c), v, intent0);
            }
        }
    }
}

