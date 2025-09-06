package io.netty.handler.timeout;

import androidx.appcompat.app.o;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public class IdleStateEvent {
    static final class DefaultIdleStateEvent extends IdleStateEvent {
        private final String representation;

        public DefaultIdleStateEvent(IdleState idleState0, boolean z) {
            super(idleState0, z);
            StringBuilder stringBuilder0 = new StringBuilder("IdleStateEvent(");
            stringBuilder0.append(idleState0);
            this.representation = o.r(stringBuilder0, (z ? ", first" : ""), ')');
        }

        @Override  // io.netty.handler.timeout.IdleStateEvent
        public String toString() {
            return this.representation;
        }
    }

    public static final IdleStateEvent ALL_IDLE_STATE_EVENT;
    public static final IdleStateEvent FIRST_ALL_IDLE_STATE_EVENT;
    public static final IdleStateEvent FIRST_READER_IDLE_STATE_EVENT;
    public static final IdleStateEvent FIRST_WRITER_IDLE_STATE_EVENT;
    public static final IdleStateEvent READER_IDLE_STATE_EVENT;
    public static final IdleStateEvent WRITER_IDLE_STATE_EVENT;
    private final boolean first;
    private final IdleState state;

    static {
        IdleStateEvent.FIRST_READER_IDLE_STATE_EVENT = new DefaultIdleStateEvent(IdleState.READER_IDLE, true);
        IdleStateEvent.READER_IDLE_STATE_EVENT = new DefaultIdleStateEvent(IdleState.READER_IDLE, false);
        IdleStateEvent.FIRST_WRITER_IDLE_STATE_EVENT = new DefaultIdleStateEvent(IdleState.WRITER_IDLE, true);
        IdleStateEvent.WRITER_IDLE_STATE_EVENT = new DefaultIdleStateEvent(IdleState.WRITER_IDLE, false);
        IdleStateEvent.FIRST_ALL_IDLE_STATE_EVENT = new DefaultIdleStateEvent(IdleState.ALL_IDLE, true);
        IdleStateEvent.ALL_IDLE_STATE_EVENT = new DefaultIdleStateEvent(IdleState.ALL_IDLE, false);
    }

    public IdleStateEvent(IdleState idleState0, boolean z) {
        this.state = (IdleState)ObjectUtil.checkNotNull(idleState0, "state");
        this.first = z;
    }

    public boolean isFirst() {
        return this.first;
    }

    public IdleState state() {
        return this.state;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(StringUtil.simpleClassName(this));
        stringBuilder0.append('(');
        stringBuilder0.append(this.state);
        return this.first ? o.r(stringBuilder0, ", first", ')') : o.r(stringBuilder0, "", ')');
    }
}

