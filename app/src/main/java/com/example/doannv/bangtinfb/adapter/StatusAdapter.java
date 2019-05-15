package com.example.doannv.bangtinfb.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.doannv.bangtinfb.R;
import com.example.doannv.bangtinfb.model.Status;
import com.example.doannv.bangtinfb.unti.Server;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import de.hdodenhof.circleimageview.CircleImageView;

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.ItemHolder> {

    Context context;
    ArrayList<Status> arrayStatus;

    public StatusAdapter(Context context, ArrayList<Status> arrayStatus) {
        this.context = context;
        this.arrayStatus = arrayStatus;
    }



    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recipe_list_item,null);
            ItemHolder itemHolder = new ItemHolder(view);
            return itemHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder itemHolder, int i) {
        Status status = arrayStatus.get(i);

            Calendar calendarone = Calendar.getInstance();
            int phut = status.getPhut();
            int gio = status.getGio();
            int ngay = status.getNgay();
            int thang = status.getThang();
            int nam = status.getNam();
            calendarone.set(nam,thang,ngay,gio,phut);
        Calendar calendartwo = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
        String ngay1 = dateFormat.format(calendartwo.getTime());
        int ngay2 = Integer.valueOf(ngay1);
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("MM");
        String thang1 = dateFormat1.format(calendartwo.getTime());
        int thang2 = Integer.valueOf(thang1);
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy");
        String nam1 = dateFormat2.format(calendartwo.getTime());
        int nam2 = Integer.valueOf(nam1);
        SimpleDateFormat dateFormat3 = new SimpleDateFormat("mm");
        String phut1 = dateFormat3.format(calendartwo.getTime());
        int phut2 = Integer.valueOf(phut1);
        SimpleDateFormat dateFormat4 = new SimpleDateFormat("HH");
        String gio1 = dateFormat4.format(calendartwo.getTime());
        int gio2 = Integer.valueOf(gio1);
        calendartwo.set(nam2,thang2,ngay2,gio2,phut2);
        int x = ngay2-ngay;

        if (nam2-nam>=1 && thang2-thang>=0){
            itemHolder.Timestamp.setText((nam2-nam)+" năm trước");
        }else if (nam2-nam>1 && thang2-thang<0){
            itemHolder.Timestamp.setText((nam2-nam-1)+" năm trước");
        }else if (nam2-nam==1 && thang2-thang<0 ){
            itemHolder.Timestamp.setText((thang2-thang+12)+" tháng trước");
        }else if (thang2-thang>=1 && ngay2-ngay>=0){
            itemHolder.Timestamp.setText(thang2-thang+" tháng trước");
        }else if (thang2-thang>1 && ngay2-ngay<0){
            itemHolder.Timestamp.setText((thang2-thang-1)+" tháng trước");
        }else if (thang2-thang==1 && ngay2-ngay<0){
            itemHolder.Timestamp.setText(ngay+" tháng "+thang+"  "+gio+":"+phut);
        }else if (ngay2-ngay>1 && gio2-gio>=0){
            if ((x)/7<1){
                itemHolder.Timestamp.setText( x +" ngày trước");
            }else if ((x)/7 >=1 && (x)/7<2){
                itemHolder.Timestamp.setText("1 tuần trước");
            }else if ((x)/7>=2 && (x)/7<3){
                itemHolder.Timestamp.setText("2 tuần tuần trước");
            }else if ((x)/7>=3 && (x)/7<4){
                itemHolder.Timestamp.setText("3 tuần tuần trước");
            }


        } else if (ngay2-ngay>1 && gio2-gio<0 ){
            if ((x-1)/7<1){
                itemHolder.Timestamp.setText( x +" ngày trước");
            }else if ((x-1)/7 >=1 && (x-1)/7<2){
                itemHolder.Timestamp.setText("1 tuần trước");
            }else if ((x-1)/7>=2 && (x-1)/7<3){
                itemHolder.Timestamp.setText("2 tuần tuần trước");
            }else if ((x-1)/7>=3 && (x-1)/7<4){
                itemHolder.Timestamp.setText("3 tuần tuần trước");
            }
        }else if (ngay2-ngay == 1 && gio2-gio>=0){
            itemHolder.Timestamp.setText("Hôm qua " +gio+":"+phut);
        } else if (ngay2-ngay==1 && gio2-gio<0){
            itemHolder.Timestamp.setText("Hôm qua " +gio+":"+phut);
        }else if (gio2-gio>=1 && phut2-phut>=0){
            itemHolder.Timestamp.setText(gio2-gio +" giờ trước");
        }else if (gio2-gio>1 && phut2-phut<0){
            itemHolder.Timestamp.setText(gio2-gio-1 +" giờ trước");
        }else if (gio2-gio==1 && phut2-phut<0){
            itemHolder.Timestamp.setText((phut2-phut+60) +" phút trước");
        }else if (phut2-phut>0){
            itemHolder.Timestamp.setText(phut2-phut +" phút trước");
        }else {
            itemHolder.Timestamp.setText("1 phút trước");
        }
            itemHolder.Name.setText(status.getName());
            if (status.getStatus().equals("")){
                itemHolder.Descriptio.setVisibility(View.GONE);
            }else {
                itemHolder.Descriptio.setText(status.getStatus());
            }
            Picasso.get().load(Server.duongdananh+status.getAnh())
                    .placeholder(R.drawable.ic_avatar)
                    .error(R.drawable.ic_avatar)
                    .into(itemHolder.Thumbnail);

            if (status.getImgstatus().equals("")){
                itemHolder.Imgstatus.setVisibility(View.GONE);
            }else {
                Picasso.get().load(Server.duongdananh+status.getImgstatus())
                        .placeholder(R.drawable.ic_avatar)
                        .error(R.drawable.ic_avatar)
                        .into(itemHolder.Imgstatus);
            }
        }

    @Override
    public int getItemCount() {
        return arrayStatus.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        public CircleImageView Thumbnail;
        public TextView Name,Timestamp,Descriptio;
        public ImageView Imgstatus;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            Thumbnail = itemView.findViewById(R.id.thumbnail);
            Name = itemView.findViewById(R.id.name);
            Timestamp = itemView.findViewById(R.id.timestamp);
            Descriptio = itemView.findViewById(R.id.description);
            Imgstatus = itemView.findViewById(R.id.imgstatus);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(context, ChiTietSpActivity.class);
//                    intent.putExtra("thongtinsanpham", arraySanpham.get(getPosition()));
//                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    context.startActivity(intent);
//                }
//            });

        }
    }
}
