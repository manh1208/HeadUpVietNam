package com.superapp.ruothinhbatchu.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import com.superapp.ruothinhbatchu.R;
import com.superapp.ruothinhbatchu.activity.HowToPlayActivity;
import com.superapp.ruothinhbatchu.dialog.ConfirmDialog;

import java.util.List;

/**
 * Created by ManhNV on 2/21/2016.
 */
public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder>  {
    private List<Integer> mlistMenu;
    private Context mContext;
    public MenuAdapter(Context context, List<Integer> data){
        mlistMenu = data;
        mContext = context;
    }
    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.menu_item, parent, false);
        MenuViewHolder viewHolder =new MenuViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, final int position) {
        final int image = mlistMenu.get(position);
        holder.imageView.setImageResource(image);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mp;
                mp = MediaPlayer.create(mContext, R.raw.click);
                mp.start();
                Uri uri;
                Intent intent;
                switch (image){
                    case R.drawable.likeus:
                         uri = Uri.parse("https://www.facebook.com/supercoolappteam");
                         intent = new Intent(Intent.ACTION_VIEW, uri);
                        mContext.startActivity(intent);
                        break;
                    case R.drawable.rating:
                         uri=Uri.parse("http://www.amazon.com/gp/mas/dl/android?p=com.superapp.headsupvietnamesedoanchucungbanbe");
//                        uri=Uri.parse("http://appvn.com/android/details?id=com.superapp.headsupvietnamesedoanchucungbanbebatquizgameshow");
//                        uri=Uri.parse("http://play.google.com/store/apps/details?id=com.superapp.headsupvietnamesedoanchucungbanbe");
//                         uri = Uri.parse("http://www.bestappsforphone.com/");
//                         uri = Uri.parse("https://play.google.com/store/apps/dev?id=5225382885613170851&hl=en");

                        intent = new Intent(Intent.ACTION_VIEW, uri);
                        mContext.startActivity(intent);
                        break;
                    case R.drawable.hotgame:
//                        uri=Uri.parse("http://www.bestappsforphone.com/appotagameofthemonth");
                        uri =Uri.parse("http://www.bestappsforphone.com/kindlegameofthemonth");
//                        uri=Uri.parse("http://www.bestappsforphone.com/gameofthemonth");
//                         uri = Uri.parse("http://www.bestappsforphone.com/");
//                        uri = Uri.parse("https://play.google.com/store/apps/dev?id=5225382885613170851&hl=en");
                        intent = new Intent(Intent.ACTION_VIEW, uri);
                        mContext.startActivity(intent);
                        break;
                    case R.drawable.aboutus:
                        uri = Uri.parse("http://www.bestappsforphone.com");
                        intent = new Intent(Intent.ACTION_VIEW, uri);
                        mContext.startActivity(intent);
                        break;
                    case R.drawable.howtoplay:
                        intent = new Intent(mContext, HowToPlayActivity.class);
                        mContext.startActivity(intent);
                        break;

                    default:

                        ConfirmDialog dialog = new ConfirmDialog(mContext,image,R.style.customDialog);
                        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                        dialog.show();
                        break;
                }


            }
        });
    }

    @Override
    public int getItemCount() {
        return mlistMenu.size();
    }

    class MenuViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        public MenuViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.menu_image);
        }

    }

    public interface HandleClick{
        void onShowRewardVideo( int imageResult);
    }
}


