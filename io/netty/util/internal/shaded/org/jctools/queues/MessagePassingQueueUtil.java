package io.netty.util.internal.shaded.org.jctools.queues;

import io.netty.util.internal.shaded.org.jctools.util.PortableJvmInfo;

public final class MessagePassingQueueUtil {
    public static int drain(MessagePassingQueue messagePassingQueue0, Consumer messagePassingQueue$Consumer0) {
        if(messagePassingQueue$Consumer0 == null) {
            throw new IllegalArgumentException("c is null");
        }
        int v = 0;
        Object object0;
        while((object0 = messagePassingQueue0.relaxedPoll()) != null) {
            ++v;
            messagePassingQueue$Consumer0.accept(object0);
        }
        return v;
    }

    public static int drain(MessagePassingQueue messagePassingQueue0, Consumer messagePassingQueue$Consumer0, int v) {
        int v1 = 0;
        if(messagePassingQueue$Consumer0 == null) {
            throw new IllegalArgumentException("c is null");
        }
        if(v < 0) {
            throw new IllegalArgumentException("limit is negative: " + v);
        }
        if(v == 0) {
            return 0;
        }
        while(v1 < v) {
            Object object0 = messagePassingQueue0.relaxedPoll();
            if(object0 == null) {
                break;
            }
            messagePassingQueue$Consumer0.accept(object0);
            ++v1;
        }
        return v1;
    }

    public static void drain(MessagePassingQueue messagePassingQueue0, Consumer messagePassingQueue$Consumer0, WaitStrategy messagePassingQueue$WaitStrategy0, ExitCondition messagePassingQueue$ExitCondition0) {
        if(messagePassingQueue$Consumer0 == null) {
            throw new IllegalArgumentException("c is null");
        }
        if(messagePassingQueue$WaitStrategy0 == null) {
            throw new IllegalArgumentException("wait is null");
        }
        if(messagePassingQueue$ExitCondition0 == null) {
            throw new IllegalArgumentException("exit condition is null");
        }
    alab1:
        while(true) {
            for(int v = 0; true; v = messagePassingQueue$WaitStrategy0.idle(v)) {
                if(!messagePassingQueue$ExitCondition0.keepRunning()) {
                    break alab1;
                }
                Object object0 = messagePassingQueue0.relaxedPoll();
                if(object0 != null) {
                    messagePassingQueue$Consumer0.accept(object0);
                    break;
                }
            }
        }
    }

    public static void fill(MessagePassingQueue messagePassingQueue0, Supplier messagePassingQueue$Supplier0, WaitStrategy messagePassingQueue$WaitStrategy0, ExitCondition messagePassingQueue$ExitCondition0) {
        if(messagePassingQueue$WaitStrategy0 == null) {
            throw new IllegalArgumentException("waiter is null");
        }
        if(messagePassingQueue$ExitCondition0 == null) {
            throw new IllegalArgumentException("exit condition is null");
        }
    alab1:
        while(true) {
            for(int v = 0; true; v = messagePassingQueue$WaitStrategy0.idle(v)) {
                if(!messagePassingQueue$ExitCondition0.keepRunning()) {
                    break alab1;
                }
                if(messagePassingQueue0.fill(messagePassingQueue$Supplier0, PortableJvmInfo.RECOMENDED_OFFER_BATCH) != 0) {
                    break;
                }
            }
        }
    }

    public static int fillBounded(MessagePassingQueue messagePassingQueue0, Supplier messagePassingQueue$Supplier0) {
        return MessagePassingQueueUtil.fillInBatchesToLimit(messagePassingQueue0, messagePassingQueue$Supplier0, PortableJvmInfo.RECOMENDED_OFFER_BATCH, messagePassingQueue0.capacity());
    }

    public static int fillInBatchesToLimit(MessagePassingQueue messagePassingQueue0, Supplier messagePassingQueue$Supplier0, int v, int v1) {
        long v2 = 0L;
        do {
            int v3 = messagePassingQueue0.fill(messagePassingQueue$Supplier0, v);
            if(v3 == 0) {
                return (int)v2;
            }
            v2 += (long)v3;
        }
        while(v2 <= ((long)v1));
        return (int)v2;
    }

    public static int fillUnbounded(MessagePassingQueue messagePassingQueue0, Supplier messagePassingQueue$Supplier0) {
        return MessagePassingQueueUtil.fillInBatchesToLimit(messagePassingQueue0, messagePassingQueue$Supplier0, PortableJvmInfo.RECOMENDED_OFFER_BATCH, 0x1000);
    }
}

