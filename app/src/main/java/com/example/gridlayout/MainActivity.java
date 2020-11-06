package com.example.gridlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    String[] namedh = {"Giày Basas Suede","Giày sneaker Jockey","Giày Basas Bumber","Giày Juno Sneaker","Giày Basas PNJ","Giày nam công sở buộc dây"};
    int[] images = {R.drawable.giay1,R.drawable.giay2,R.drawable.giay3,R.drawable.giay4,R.drawable.giay5,R.drawable.giay6};
    String[] giadh = {"450.000 ₫","3.170.000 ₫","2.670.000 ₫","12.900.000 ₫","10.350.000 ₫","2.200.000 ₫"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //finding listview
        gridView = findViewById(R.id.gridview);

        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),namedh[i],Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(),GridItemActivity.class);
                intent.putExtra("name",namedh[i]);
                intent.putExtra("image",images[i]);
                intent.putExtra("gia",giadh[i]);
                startActivity(intent);
            }
        });


    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return namedh.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.row_data,null);
            //getting view in row_data
            TextView name = view1.findViewById(R.id.iddongho);
            ImageView image = view1.findViewById(R.id.imageView);
            TextView gia = view1.findViewById(R.id.idgia);

            name.setText(namedh[i]);
            image.setImageResource(images[i]);
            gia.setText(giadh[i]);
            return view1;
        }
    }
}