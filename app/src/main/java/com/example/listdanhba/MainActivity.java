package com.example.listdanhba;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;

    private ListView listProduct;
    Context context;
    ArrayList<Model> data;
    CustomerAdapter customerAdapter;
    Model model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;
        setContentView(R.layout.activity_main);





        listProduct=findViewById(R.id.listProduct);
        registerForContextMenu(listProduct);
        data=new ArrayList<>();

        populateData();
        customerAdapter=new CustomerAdapter(context,data);
        listProduct.setAdapter(customerAdapter);


        tabLayout=(TabLayout) findViewById(R.id.tabLayout);
        viewPager=(ViewPager) findViewById(R.id.viewpager);
        adapter=new ViewPagerAdapter(getSupportFragmentManager());


        adapter.AddFragment(new Call(),"Danh bạ");
        adapter.AddFragment(new Contact(),"Gần đây");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);



    }

    private void populateData(){

        model=new Model();
        model.setId(1);
        model.setName("Minh Quyền");
        model.setSdt("0367148396");
        model.setImage(R.drawable.avt);
        data.add(model);

        model=new Model();
        model.setId(1);
        model.setName("PHAN AN ML");
        model.setSdt("0352997674");
        model.setImage(R.drawable.avt1);
        data.add(model);

        model=new Model();
        model.setId(1);
        model.setName("Hoàng Bảo");
        model.setSdt("02356615959");
        model.setImage(R.drawable.avt);
        data.add(model);

        model=new Model();
        model.setId(1);
        model.setName("Xuân Châu");
        model.setSdt("07995628416");
        model.setImage(R.drawable.avt1);
        data.add(model);
    }


}