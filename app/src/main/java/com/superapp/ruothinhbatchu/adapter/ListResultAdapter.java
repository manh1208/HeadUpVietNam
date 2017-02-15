package com.superapp.ruothinhbatchu.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.superapp.ruothinhbatchu.R;
import com.superapp.ruothinhbatchu.model.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ManhNV on 2/24/2016.
 */
public class ListResultAdapter extends ArrayAdapter<Result> {
    protected static final String     TAG     = ListResultAdapter.class.getSimpleName();
    private Context mContext;
    private int mResource;
    private HashMap<Integer,Result> mList;
    private List<Integer> mListKey;
    private TextView mContent;
    private ImageView imageView;

    public ListResultAdapter(Context context, int resource,HashMap<Integer,Result> list) {
        super(context, resource);
        mContext = context;
        mResource = resource;
        mList = list;
        mListKey= new ArrayList<>( mList.keySet());
        Log.d(TAG,"Độ dài hashmap:"+mList.size()+". Độ dài list:"+mListKey);
    }

    @Override
    public int getCount() {
        Log.d(TAG,"Độ dài kết quả:"+mListKey.size());
        return mListKey.size();
    }

    @Override
    public Result getItem(int position) {
        Log.d(TAG,"Position:"+position+". Key:"+mListKey.get(position)+". Value:"+mList.get(mListKey.get(position)));
        return mList.get(mListKey.get(position));
    }

    @Override
    public long getItemId(int position) {
        return mListKey.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.result_item,parent,false);
        }
        Result result = getItem(position);
        Log.d(TAG,"Vị trí:"+position+"");
        Log.d(TAG,"Result:"+result.toString()+"");
        Log.d(TAG,"Content:"+result.getContent());
        Log.d(TAG,"đúng:"+result.isRight()+"");
        mContent = (TextView) convertView.findViewById(R.id.txtContent);
        imageView = (ImageView) convertView.findViewById(R.id.iv_result);

        mContent.setText(result.getContent());
        if (result.isRight()){
            imageView.setImageResource(R.drawable.correct);
        }else{
            imageView.setImageResource(R.drawable.wrong);
        }
        return convertView;
    }
}
