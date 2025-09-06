package com.facebook.messenger;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0011B+\u0012\u0006\u0010\u0002\u001A\u00020\u0003\u0012\u0006\u0010\u0004\u001A\u00020\u0005\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0002\u0010\tR\u0011\u0010\u0006\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\n\u0010\u000BR\u0011\u0010\u0002\u001A\u00020\u0003¢\u0006\b\n\u0000\u001A\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001A\u0004\b\u000E\u0010\u000FR\u0011\u0010\u0004\u001A\u00020\u0005¢\u0006\b\n\u0000\u001A\u0004\b\u0010\u0010\u000B¨\u0006\u0012"}, d2 = {"Lcom/facebook/messenger/MessengerThreadParams;", "", "origin", "Lcom/facebook/messenger/MessengerThreadParams$Origin;", "threadToken", "", "metadata", "participants", "", "(Lcom/facebook/messenger/MessengerThreadParams$Origin;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getMetadata", "()Ljava/lang/String;", "getOrigin", "()Lcom/facebook/messenger/MessengerThreadParams$Origin;", "getParticipants", "()Ljava/util/List;", "getThreadToken", "Origin", "facebook-messenger_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
public final class MessengerThreadParams {
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/facebook/messenger/MessengerThreadParams$Origin;", "", "(Ljava/lang/String;I)V", "REPLY_FLOW", "COMPOSE_FLOW", "UNKNOWN", "facebook-messenger_release"}, k = 1, mv = {1, 8, 0}, xi = 0x30)
    public static enum Origin {
        REPLY_FLOW,
        COMPOSE_FLOW,
        UNKNOWN;

        private static final Origin[] $values() [...] // Inlined contents
    }

    @NotNull
    private final String metadata;
    @NotNull
    private final Origin origin;
    @NotNull
    private final List participants;
    @NotNull
    private final String threadToken;

    public MessengerThreadParams(@NotNull Origin messengerThreadParams$Origin0, @NotNull String s, @NotNull String s1, @NotNull List list0) {
        q.g(messengerThreadParams$Origin0, "origin");
        q.g(s, "threadToken");
        q.g(s1, "metadata");
        q.g(list0, "participants");
        super();
        this.origin = messengerThreadParams$Origin0;
        this.threadToken = s;
        this.metadata = s1;
        this.participants = list0;
    }

    @NotNull
    public final String getMetadata() {
        return this.metadata;
    }

    @NotNull
    public final Origin getOrigin() {
        return this.origin;
    }

    @NotNull
    public final List getParticipants() {
        return this.participants;
    }

    @NotNull
    public final String getThreadToken() {
        return this.threadToken;
    }
}

