package com.iloen.melon.utils.contacts;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Contacts.People;

public class ContactAccessorSdk3_4 extends ContactAccessor {
    @Override  // com.iloen.melon.utils.contacts.ContactAccessor
    public Intent getPickContactIntent() {
        return new Intent("android.intent.action.PICK", Contacts.People.CONTENT_URI);
    }

    @Override  // com.iloen.melon.utils.contacts.ContactAccessor
    public ContactInfo loadContact(ContentResolver contentResolver0, Uri uri0) {
        ContactInfo contactInfo0;
        contactInfo0 = new ContactInfo();
        try(Cursor cursor0 = contentResolver0.query(uri0, new String[]{"display_name"}, null, null, null)) {
            if(cursor0.moveToFirst()) {
                contactInfo0.setDisplayName(cursor0.getString(0));
            }
        }
        try(Cursor cursor1 = contentResolver0.query(Uri.withAppendedPath(uri0, "phones"), new String[]{"number"}, null, null, "isprimary DESC")) {
            if(cursor1.moveToFirst()) {
                contactInfo0.setPhoneNumber(cursor1.getString(0));
                return contactInfo0;
            }
        }
        return contactInfo0;
    }
}

