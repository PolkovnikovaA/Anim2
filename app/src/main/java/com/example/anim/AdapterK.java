package com.example.anim;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterK extends BaseAdapter {

    private Context nContext;
    private ArrayList<MaskK> mMask;
    private OnItemClickListener mListener;
    String img="";

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener=listener;
    }


    public AdapterK(Context nContext, List<MaskK> maskList) {
        this.nContext = nContext;
        this.maskList = maskList;
    }

    List<MaskK>  maskList;

    @Override
    public int getCount() {
        return maskList.size();
    }

    @Override
    public Object getItem(int i) {return maskList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private Bitmap getImage(String encodedImg)
    {
        byte[] bytes;
        if(encodedImg!=null&& !encodedImg.equals("null")) {
            bytes = Base64.decode(encodedImg, Base64.DEFAULT);
            return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        }
        else
        {

        }
        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View v = View.inflate(nContext,R.layout.mask_home_k,null);

        TextView Breed = v.findViewById(R.id.MaskaHomeKBreed);
        TextView Country = v.findViewById(R.id.MaskaHomeKCountry);
        ImageView Image = v.findViewById(R.id.MaskaHomeKImage1);

        MaskK mask = maskList.get(position);

        Breed.setText(mask.getBreed());
        Country.setText(mask.getCountry());

        Image.setImageBitmap(getImage(mask.getImage()));

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenDetalis = new Intent(nContext,InfoK.class);
                intenDetalis.putExtra("Cat", mask);
                nContext.startActivity(intenDetalis);
            }
        });
        return v;
    }
}
