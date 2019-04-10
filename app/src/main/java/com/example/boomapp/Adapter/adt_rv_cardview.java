package com.example.boomapp.Adapter;

import android.content.Context;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.boomapp.usingrecyclerview.R;
import com.example.boomapp.usingrecyclerview.model.Product;

import java.util.ArrayList;
import java.util.List;

public class adt_rv_cardview extends androidx.recyclerview.widget.RecyclerView.Adapter<adt_rv_cardview.ViewHolder>{
    private List<Product> lst;
    private Context ctx;

    public adt_rv_cardview() {
        lst = new ArrayList<Product>();

        Product p = new Product();
        p.setTitle("การใช้งาน Android Studio");
        p.setDescription("เริ่มต้นพัฒนา Android Apps ด้วยภาษา JAVA");
        p.setCover(R.mipmap.androidstudio);
        lst.add(p);

        p = new Product();
        p.setTitle("พัฒนาเว็บแอพด้วย ASP.NET Core MVC");
        p.setDescription("เรียนรู้ตั้งแต่พื้นฐานจนใช้งานได้จริง");
        p.setCover(R.mipmap.aspdotnet);
        lst.add(p);

        p = new Product();
        p.setTitle("เขียนโปรกรมด้วยภาษา C# 2015");
        p.setDescription("เริ่มต้นเขียนโปรแกรมแบบ Step by Step");
        p.setCover(R.mipmap.csharp2015);
        lst.add(p);

        p = new Product();
        p.setTitle("เขียนโปรกรมด้วยภาษา VB 2015");
        p.setDescription("เริ่มต้นเขียนโปรแกรมแบบ Step by Step");
        p.setCover(R.mipmap.vb2015);
        lst.add(p);
    }

    @Override
    public adt_rv_cardview.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_card, parent, false);
        ctx = parent.getContext();
        return new ViewHolder(v);
    }

    public class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder{
        private androidx.cardview.widget.CardView cvProduct;
        private ImageView imgCover;
        private TextView tvTitle;
        private TextView tvDescription;

        public ViewHolder(View v) {
            super(v);
            cvProduct = v.findViewById(R.id.cvProduct);
            imgCover = v.findViewById(R.id.imgCover);
            tvTitle = v.findViewById(R.id.tvTitle);
            tvDescription = v.findViewById(R.id.tvDescription);
        }
    }

    @Override
    public void onBindViewHolder(adt_rv_cardview.ViewHolder holder, final int position) {
        Product p = lst.get(position);
        holder.imgCover.setImageResource(p.getCover());
        holder.tvTitle.setText(p.getTitle());
        holder.tvDescription.setText(p.getDescription());

        holder.cvProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ctx, lst.get(position).getTitle(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return lst.size();
    }
}
