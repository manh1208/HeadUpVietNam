package com.superapp.ruothinhbatchu.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.superapp.ruothinhbatchu.R;
import com.superapp.ruothinhbatchu.activity.GameActivity;
import com.superapp.ruothinhbatchu.adapter.MenuAdapter;
import com.superapp.ruothinhbatchu.utils.DataUtils;

/**
 * Created by ManhNV on 2/22/2016.
 */
public class ConfirmDialog extends Dialog {
    private Context mContext;
    private int mImageResources;
    private ImageView mImage;
    private ImageButton mBtnStart;
    private TextView mTxtLock;

    public ConfirmDialog(Context context, int image, int customStyle) {
        super(context,customStyle);
        mContext = context;
        mImageResources = image;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_confirm);
        mImage = (ImageView) findViewById(R.id.imageConfirm);
        mImage.setImageResource(mImageResources);
        mBtnStart = (ImageButton) findViewById(R.id.btn_start);

        mTxtLock = (TextView) findViewById(R.id.txtLock);
        if (DataUtils.getINSTANCE().getListLock().containsKey(mImageResources) && DataUtils.getINSTANCE().getListLock().get(mImageResources)){
            mTxtLock.setVisibility(View.VISIBLE);
            mBtnStart.setImageResource(R.drawable.btnviewads);
            mBtnStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                    MenuAdapter.HandleClick click = (MenuAdapter.HandleClick) mContext;
                    click.onShowRewardVideo(mImageResources);

                }
            });
        }else{
            mTxtLock.setVisibility(View.GONE);
            mBtnStart.setImageResource(R.drawable.start);
            mBtnStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MediaPlayer mp;
                    mp = MediaPlayer.create(mContext, R.raw.click);
                    mp.start();
                    dismiss();
                    Intent intent = new Intent(mContext, GameActivity.class);
                    intent.putExtra("id", mImageResources);
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
