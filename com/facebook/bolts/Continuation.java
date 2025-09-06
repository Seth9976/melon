package com.facebook.bolts;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J\u001D\u0010\u0004\u001A\u0004\u0018\u00018\u00012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u00028\u00000\u0006H&¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/bolts/Continuation;", "TTaskResult", "TContinuationResult", "", "then", "task", "Lcom/facebook/bolts/Task;", "(Lcom/facebook/bolts/Task;)Ljava/lang/Object;", "facebook-bolts_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public interface Continuation {
    @Nullable
    Object then(@NotNull Task arg1);
}

