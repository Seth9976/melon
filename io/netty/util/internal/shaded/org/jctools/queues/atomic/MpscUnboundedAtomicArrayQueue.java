package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Consumer;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.ExitCondition;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.Supplier;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue.WaitStrategy;
import io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueueUtil;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class MpscUnboundedAtomicArrayQueue extends BaseMpscLinkedAtomicArrayQueue {
    byte b000;
    byte b001;
    byte b002;
    byte b003;
    byte b004;
    byte b005;
    byte b006;
    byte b007;
    byte b010;
    byte b011;
    byte b012;
    byte b013;
    byte b014;
    byte b015;
    byte b016;
    byte b017;
    byte b020;
    byte b021;
    byte b022;
    byte b023;
    byte b024;
    byte b025;
    byte b026;
    byte b027;
    byte b030;
    byte b031;
    byte b032;
    byte b033;
    byte b034;
    byte b035;
    byte b036;
    byte b037;
    byte b040;
    byte b041;
    byte b042;
    byte b043;
    byte b044;
    byte b045;
    byte b046;
    byte b047;
    byte b050;
    byte b051;
    byte b052;
    byte b053;
    byte b054;
    byte b055;
    byte b056;
    byte b057;
    byte b060;
    byte b061;
    byte b062;
    byte b063;
    byte b064;
    byte b065;
    byte b066;
    byte b067;
    byte b070;
    byte b071;
    byte b072;
    byte b073;
    byte b074;
    byte b075;
    byte b076;
    byte b077;
    byte b100;
    byte b101;
    byte b102;
    byte b103;
    byte b104;
    byte b105;
    byte b106;
    byte b107;
    byte b110;
    byte b111;
    byte b112;
    byte b113;
    byte b114;
    byte b115;
    byte b116;
    byte b117;
    byte b120;
    byte b121;
    byte b122;
    byte b123;
    byte b124;
    byte b125;
    byte b126;
    byte b127;
    byte b130;
    byte b131;
    byte b132;
    byte b133;
    byte b134;
    byte b135;
    byte b136;
    byte b137;
    byte b140;
    byte b141;
    byte b142;
    byte b143;
    byte b144;
    byte b145;
    byte b146;
    byte b147;
    byte b150;
    byte b151;
    byte b152;
    byte b153;
    byte b154;
    byte b155;
    byte b156;
    byte b157;
    byte b160;
    byte b161;
    byte b162;
    byte b163;
    byte b164;
    byte b165;
    byte b166;
    byte b167;
    byte b170;
    byte b171;
    byte b172;
    byte b173;
    byte b174;
    byte b175;
    byte b176;
    byte b177;

    public MpscUnboundedAtomicArrayQueue(int v) {
        super(v);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue
    public long availableInQueue(long v, long v1) {
        return 0x7FFFFFFFL;
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue
    public int capacity() {
        return -1;
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue
    public long currentConsumerIndex() {
        return super.currentConsumerIndex();
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue
    public long currentProducerIndex() {
        return super.currentProducerIndex();
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue
    public int drain(Consumer messagePassingQueue$Consumer0) {
        return this.drain(messagePassingQueue$Consumer0, 0x1000);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue
    public int drain(Consumer messagePassingQueue$Consumer0, int v) {
        return super.drain(messagePassingQueue$Consumer0, v);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue
    public void drain(Consumer messagePassingQueue$Consumer0, WaitStrategy messagePassingQueue$WaitStrategy0, ExitCondition messagePassingQueue$ExitCondition0) {
        super.drain(messagePassingQueue$Consumer0, messagePassingQueue$WaitStrategy0, messagePassingQueue$ExitCondition0);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue
    public int fill(Supplier messagePassingQueue$Supplier0) {
        return MessagePassingQueueUtil.fillUnbounded(this, messagePassingQueue$Supplier0);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue
    public int fill(Supplier messagePassingQueue$Supplier0, int v) {
        return super.fill(messagePassingQueue$Supplier0, v);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue
    public void fill(Supplier messagePassingQueue$Supplier0, WaitStrategy messagePassingQueue$WaitStrategy0, ExitCondition messagePassingQueue$ExitCondition0) {
        super.fill(messagePassingQueue$Supplier0, messagePassingQueue$WaitStrategy0, messagePassingQueue$ExitCondition0);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue
    public long getCurrentBufferCapacity(long v) {
        return v;
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue
    public int getNextBufferSize(AtomicReferenceArray atomicReferenceArray0) {
        return AtomicQueueUtil.length(atomicReferenceArray0);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue
    public Iterator iterator() {
        return super.iterator();
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue
    public boolean offer(Object object0) {
        return super.offer(object0);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue
    public Object peek() {
        return super.peek();
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue
    public Object poll() {
        return super.poll();
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue
    public boolean relaxedOffer(Object object0) {
        return super.relaxedOffer(object0);
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue
    public Object relaxedPeek() {
        return super.relaxedPeek();
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue
    public Object relaxedPoll() {
        return super.relaxedPoll();
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue
    public int size() {
        return super.size();
    }

    @Override  // io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue
    public String toString() {
        return super.toString();
    }
}

