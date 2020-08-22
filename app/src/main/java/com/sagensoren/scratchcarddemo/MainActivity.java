package com.sagensoren.scratchcarddemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.anupkumarpanwar.scratchview.ScratchView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements OnCardItemClickListener {
    RecyclerView recyclerView;
    ScratchAdapter adapter;
    private List<ScratchModel> modelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(null);


        // ScratchView scratchView = findViewById(R.id.scratch_view);

        adapter = new ScratchAdapter(modelList,this);
        recyclerView = findViewById(R.id.my_rv);
        RecyclerView.LayoutManager manager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        getListData();
    }

    private void getListData() {
        ScratchModel scratchModel = new ScratchModel(R.drawable.rectangle_green);
        modelList.add(scratchModel);
        scratchModel = new ScratchModel(R.drawable.ic_rectangle);
        modelList.add(scratchModel);
        scratchModel = new ScratchModel(R.drawable.rectangle_green_light);
        modelList.add(scratchModel);
        scratchModel = new ScratchModel(R.drawable.rectangle_tw);
        modelList.add(scratchModel);
     /*   scratchModel = new ScratchModel(R.drawable.rectangle_tn);
        modelList.add(scratchModel);
        scratchModel = new ScratchModel(R.drawable.rectangle_lgt_yelo);
        modelList.add(scratchModel);
        scratchModel = new ScratchModel(R.drawable.rectangle_onw);
        modelList.add(scratchModel);
        scratchModel = new ScratchModel(R.drawable.rectangle_yelo);
        modelList.add(scratchModel);
        scratchModel = new ScratchModel(R.drawable.rectangle_green_light);
        modelList.add(scratchModel);
        scratchModel = new ScratchModel(R.drawable.rectangle_yelo);
        modelList.add(scratchModel);*/


    }

    @Override
    public void cardItemClicked(int position) {
     //   Toast.makeText(this, "Cart item clicked!"+ position, Toast.LENGTH_SHORT).show();
        customAlertDialog();
    }
    private void customAlertDialog(){
       final AlertDialog.Builder builder =  new AlertDialog.Builder(this);
        LayoutInflater inflater =  getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.custom_alert_dialog,null);
        builder.setView(dialogView);

       final AlertDialog dialog = builder.create();
       dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        ScratchView scratchView = dialogView.findViewById(R.id.scratch_view);
        ImageView  imgView = dialogView.findViewById(R.id.img_view);
        TextView txtView = dialogView.findViewById(R.id.text_view);


        scratchView.setRevealListener(new ScratchView.IRevealListener() {
            @Override
            public void onRevealed(ScratchView scratchView) {
                Toast.makeText(getApplicationContext(), "Reveled", Toast.LENGTH_LONG).show();
                ;
            }

            @Override
            public void onRevealPercentChangedListener(ScratchView scratchView, float percent) {
                if (percent >= 0.5) {
                    Log.d("Reveal Percentage", "onRevealPercentChangedListener: " + String.valueOf(percent));
                }
            }
        });
    }
}