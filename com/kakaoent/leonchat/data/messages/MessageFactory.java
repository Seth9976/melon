package com.kakaoent.leonchat.data.messages;

import android.util.Log;
import com.google.gson.n;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/kakaoent/leonchat/data/messages/MessageFactory;", "", "", "TYPE_ERROR_TYPE", "Ljava/lang/String;", "leonchat-android-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 0x30)
public final class MessageFactory {
    @NotNull
    public static final MessageFactory INSTANCE = null;
    @NotNull
    private static final String TYPE_ERROR_TYPE = "ERROR_MESSAGE";

    static {
        MessageFactory.INSTANCE = new MessageFactory();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public static MessageEntity a(String s) {
        Class class0;
        try {
            class0 = MessageEntity.class;
            String s1 = new JSONObject(s).getString("type");
            Log.i("MessageFactory", "createMessage() - type : " + s1);
            if(s1 != null) {
                switch(s1) {
                    case "ARTIST_FIXED_MESSAGE": 
                    case "ARTIST_MESSAGE": {
                        Object object0 = new n().e(s, ArtistMessageEntity.class);
                        q.f(object0, "Gson().fromJson(rowData,…essageEntity::class.java)");
                        return (MessageEntity)object0;
                    }
                    case "BLOCK_USER": {
                        Object object11 = new n().e(s, BlockUserMessageEntity.class);
                        q.f(object11, "Gson().fromJson(rowData,…essageEntity::class.java)");
                        return (MessageEntity)object11;
                    }
                    case "CHANGE_ROOM": {
                        Object object7 = new n().e(s, ChangeRoomMessageEntity.class);
                        q.f(object7, "Gson().fromJson(rowData,…essageEntity::class.java)");
                        return (MessageEntity)object7;
                    }
                    case "ERROR_MESSAGE": {
                        Object object9 = new n().e(s, ErrorMessageMessageEntity.class);
                        q.f(object9, "Gson().fromJson(rowData,…essageEntity::class.java)");
                        return (MessageEntity)object9;
                    }
                    case "FREEZE_CHAT": {
                        Object object6 = new n().e(s, FreezeChatMessageEntity.class);
                        q.f(object6, "Gson().fromJson(rowData,…essageEntity::class.java)");
                        return (MessageEntity)object6;
                    }
                    case "INIT_MESSAGE": {
                        Object object3 = new n().e(s, InitMessageEntity.class);
                        q.f(object3, "Gson().fromJson(rowData,…essageEntity::class.java)");
                        return (MessageEntity)object3;
                    }
                    case "NOTICE_FIXED_MESSAGE": 
                    case "NOTICE_MESSAGE": {
                        Object object8 = new n().e(s, NoticeMessageEntity.class);
                        q.f(object8, "Gson().fromJson(rowData,…essageEntity::class.java)");
                        return (MessageEntity)object8;
                    }
                    case "PONG": {
                        Object object5 = new n().e(s, PongMessageEntity.class);
                        q.f(object5, "Gson().fromJson(rowData,…essageEntity::class.java)");
                        return (MessageEntity)object5;
                    }
                    case "SLOW_CHAT": {
                        Object object4 = new n().e(s, SlowChatMessageEntity.class);
                        q.f(object4, "Gson().fromJson(rowData,…essageEntity::class.java)");
                        return (MessageEntity)object4;
                    }
                    case "USER_FIXED_MESSAGE": 
                    case "USER_MESSAGE": {
                        Object object1 = new n().e(s, UserMessageEntity.class);
                        q.f(object1, "Gson().fromJson(rowData,…essageEntity::class.java)");
                        return (MessageEntity)object1;
                    }
                    case "USER_JOIN_ROOM": {
                        Object object10 = new n().e(s, UserJoinRoomMessageEntity.class);
                        q.f(object10, "Gson().fromJson(rowData,…essageEntity::class.java)");
                        return (MessageEntity)object10;
                    }
                    case "USER_LEFT_ROOM": {
                        Object object2 = new n().e(s, UserLeftRoomMessageEntity.class);
                        q.f(object2, "Gson().fromJson(rowData,…essageEntity::class.java)");
                        return (MessageEntity)object2;
                    }
                }
            }
            Object object12 = new n().e(s, class0);
            q.f(object12, "Gson().fromJson(rowData,…essageEntity::class.java)");
            return (MessageEntity)object12;
        }
        catch(Exception exception0) {
        }
        Log.e("MessageFactory", "exception : " + exception0);
        Log.e("MessageFactory", "rowData : " + s);
        Object object13 = new n().e(s, class0);
        q.f(object13, "Gson().fromJson(rowData,…essageEntity::class.java)");
        return (MessageEntity)object13;
    }
}

