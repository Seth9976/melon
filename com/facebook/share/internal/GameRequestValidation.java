package com.facebook.share.internal;

import com.facebook.internal.Validate;
import com.facebook.share.model.GameRequestContent.ActionType;
import com.facebook.share.model.GameRequestContent;

public class GameRequestValidation {
    public static void validate(GameRequestContent gameRequestContent0) {
        Validate.notNull(gameRequestContent0.getMessage(), "message");
        int v = 0;
        if(((gameRequestContent0.getObjectId() == null ? 0 : 1) ^ (gameRequestContent0.getActionType() == ActionType.ASKFOR || gameRequestContent0.getActionType() == ActionType.SEND ? 1 : 0)) != 0) {
            throw new IllegalArgumentException("Object id should be provided if and only if action type is send or askfor");
        }
        if(gameRequestContent0.getRecipients() != null) {
            v = 1;
        }
        if(gameRequestContent0.getSuggestions() != null) {
            ++v;
        }
        if(gameRequestContent0.getFilters() != null) {
            ++v;
        }
        if(v > 1) {
            throw new IllegalArgumentException("Parameters to, filters and suggestions are mutually exclusive");
        }
    }
}

