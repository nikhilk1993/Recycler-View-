package com.developers.star.recyclerview;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Nikhil khadilkar on 11/02/16.
 */
public class ContactViewHolder extends RecyclerView.ViewHolder {

    public ImageView contactImage;
    public TextView contactNameView;
    public TextView contactNumberView;

    private String contactName;
    private String contactNumber;
    private String imageUri;

    public ContactViewHolder(View v){
        super(v);
        contactImage = (ImageView) v.findViewById(R.id.iv_contact_image);
        contactNameView = (TextView) v.findViewById(R.id.tv_contact_name);
        contactNumberView = (TextView) v.findViewById(R.id.tv_contact_number);

    }

    public void bindData(ContactInfo info ){
        this.imageUri = info.getContactImage();
        this.contactName = info.getContactName();
        this.contactNumber = info.getMobNumber();
        contactNameView.setText(contactName);
        contactNumberView.setText(contactNumber);
        if(imageUri != null){
            contactImage.setImageURI(Uri.parse(imageUri));
        } else {
            contactImage.setImageURI(null);
        }
    }

}
