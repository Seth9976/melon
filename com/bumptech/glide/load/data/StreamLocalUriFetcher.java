package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class StreamLocalUriFetcher extends LocalUriFetcher {
    private static final int ID_CONTACTS_CONTACT = 3;
    private static final int ID_CONTACTS_LOOKUP = 1;
    private static final int ID_CONTACTS_PHOTO = 4;
    private static final int ID_CONTACTS_THUMBNAIL = 2;
    private static final int ID_LOOKUP_BY_PHONE = 5;
    private static final UriMatcher URI_MATCHER;

    static {
        UriMatcher uriMatcher0 = new UriMatcher(-1);
        StreamLocalUriFetcher.URI_MATCHER = uriMatcher0;
        uriMatcher0.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        uriMatcher0.addURI("com.android.contacts", "contacts/lookup/*", 1);
        uriMatcher0.addURI("com.android.contacts", "contacts/#/photo", 2);
        uriMatcher0.addURI("com.android.contacts", "contacts/#", 3);
        uriMatcher0.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        uriMatcher0.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    public StreamLocalUriFetcher(ContentResolver contentResolver0, Uri uri0) {
        super(contentResolver0, uri0);
    }

    public void close(InputStream inputStream0) {
        inputStream0.close();
    }

    @Override  // com.bumptech.glide.load.data.LocalUriFetcher
    public void close(Object object0) {
        this.close(((InputStream)object0));
    }

    @Override  // com.bumptech.glide.load.data.DataFetcher
    public Class getDataClass() {
        return InputStream.class;
    }

    public InputStream loadResource(Uri uri0, ContentResolver contentResolver0) {
        InputStream inputStream0 = this.loadResourceFromUri(uri0, contentResolver0);
        if(inputStream0 == null) {
            throw new FileNotFoundException("InputStream is null for " + uri0);
        }
        return inputStream0;
    }

    @Override  // com.bumptech.glide.load.data.LocalUriFetcher
    public Object loadResource(Uri uri0, ContentResolver contentResolver0) {
        return this.loadResource(uri0, contentResolver0);
    }

    private InputStream loadResourceFromUri(Uri uri0, ContentResolver contentResolver0) {
        switch(StreamLocalUriFetcher.URI_MATCHER.match(uri0)) {
            case 3: {
                return this.openContactPhotoInputStream(contentResolver0, uri0);
            }
            case 1: 
            case 5: {
                Uri uri1 = ContactsContract.Contacts.lookupContact(contentResolver0, uri0);
                if(uri1 == null) {
                    throw new FileNotFoundException("Contact cannot be found");
                }
                return this.openContactPhotoInputStream(contentResolver0, uri1);
            }
            default: {
                return contentResolver0.openInputStream(uri0);
            }
        }
    }

    private InputStream openContactPhotoInputStream(ContentResolver contentResolver0, Uri uri0) {
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver0, uri0, true);
    }
}

