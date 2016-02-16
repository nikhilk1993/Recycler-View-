package com.developers.star.recyclerview;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class ContactListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    List <ContactInfo> contactInfos = new ArrayList<>();

    private RecyclerView.LayoutManager layoutManager;
    private ContactListAdapter contactListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        recyclerView = (RecyclerView) findViewById(R.id.rv_contact_list);
        contactListAdapter = new ContactListAdapter();
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        initializeRecyclerView();
        getContactInfo();
        contactListAdapter.setContactList(contactInfos);
    }

    private void initializeRecyclerView(){
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(contactListAdapter);
    }

    private void getContactInfo(){
        Cursor contacts = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null,null, ContactsContract.CommonDataKinds.Phone.LAST_TIME_CONTACTED + " DESC LIMIT 50 ");
        while (contacts.moveToNext()){
            String name = contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String number = contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            String imageUri = contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_URI));
            ContactInfo contactInfo = new ContactInfo();
            contactInfo.setContactName(name);
            contactInfo.setMobNumber(number);
            contactInfo.setContactImage(imageUri);
            contactInfos.add(contactInfo);
        }
        contacts.close();
    }

}
