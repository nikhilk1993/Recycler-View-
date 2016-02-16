package com.developers.star.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikhil khadilkar on 11/02/16.
 */
public class ContactListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List <ContactInfo> contactList = new ArrayList<ContactInfo>() {
    };

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_card_view, parent, false);
        return new ContactViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ContactViewHolder ){
            ContactViewHolder vh = (ContactViewHolder)holder;
            vh.bindData(contactList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        if(contactList == null){
            return 0;
        }
        return contactList.size();
    }

    public void setContactList(List <ContactInfo> infos){
        this.contactList = infos;
        notifyDataSetChanged();
    }
}
