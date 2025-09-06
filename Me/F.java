package me;

import kotlin.coroutines.Continuation;

public interface f extends g {
    Continuation interceptContinuation(Continuation arg1);

    void releaseInterceptedContinuation(Continuation arg1);
}

