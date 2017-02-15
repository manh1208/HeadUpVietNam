package com.superapp.ruothinhbatchu.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.superapp.ruothinhbatchu.R;
import com.superapp.ruothinhbatchu.adapter.ListResultAdapter;
import com.superapp.ruothinhbatchu.model.Result;

import java.util.HashMap;

/**
 * Created by ManhNV on 2/24/2016.
 */
public class ResultDialog extends Dialog {
    protected static final String     TAG     = ResultDialog.class.getSimpleName();
    private HashMap<Integer,Result> mlistResult;
    private int mScore;
    private Context mContext;
    private TextView txtScore;
    private ListView listView;
    private ImageButton mPlayAgain;
    private ImageButton mCancel;

    public ResultDialog(Context context,int score,HashMap<Integer,Result> listResult ) {
        super(context);
        mContext=context;
        mScore=score;
        mlistResult=listResult;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_result);
        txtScore = (TextView) findViewById(R.id.result_score);
        listView = (ListView) findViewById(R.id.lv_result);
        txtScore.setText(mScore + "");
        Log.d(TAG,"Chiều dài mảng:"+mlistResult.size());
        ListResultAdapter adapter = new ListResultAdapter(mContext, R.layout.result_item,mlistResult);
        listView.setAdapter(adapter);
        mPlayAgain = (ImageButton) findViewById(R.id.btn_play_gain);
        mPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClickHandle buttonClickHandle = (ButtonClickHandle) mContext;
                buttonClickHandle.playAgain();
            }
        });
        mCancel = (ImageButton) findViewById(R.id.btn_cancel);
        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClickHandle buttonClickHandle = (ButtonClickHandle) mContext;
                buttonClickHandle.cancel();
            }
        });
    }

    public interface ButtonClickHandle{
        void playAgain();
        void cancel();
    }

    @Override
    public void onBackPressed() {
        ButtonClickHandle buttonClickHandle = (ButtonClickHandle) mContext;
        buttonClickHandle.cancel();
    }
}
