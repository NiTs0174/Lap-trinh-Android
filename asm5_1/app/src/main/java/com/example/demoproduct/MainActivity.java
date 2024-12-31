package com.example.demoproduct;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.demoproduct.adapter.ProductAdapter;
import com.example.demoproduct.models.Product;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Product> listProduct = new ArrayList<>();
        listProduct.add(new Product( "Học sinh 09 Trường THPT khu vực quận Bình Thạnh và TP. Thủ Đức sôi nổi tranh tài tại Chung kết “Đổi mới sáng tạo cùng tiếng Nhật 2023” của VJIT", "https://www.hutech.edu.vn/homepage/tin-tuc/tin-hutech/14614440-video-hoc-sinh-09-truong-thpt-khu-vuc-quan-binh-thanh-va-tp-thu-duc-soi-noi-tranh-tai-tai-chung-ket-", "https://file1.hutech.edu.vn/file/news/5303281703130538.jpg"));

        ProductAdapter adapter = new ProductAdapter(listProduct);
        RecyclerView rcvProduct = findViewById(R.id.rcvProduct);
        rcvProduct.setAdapter(adapter);
        rcvProduct.setLayoutManager(new LinearLayoutManager(this));

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvProduct.addItemDecoration(itemDecoration);

        FloatingActionButton btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                View viewDialog = getLayoutInflater().inflate(R.layout.dialog_product, null);
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setView(viewDialog);
                AlertDialog alert = builder.create();
                alert.show();
                EditText txtName = viewDialog.findViewById(R.id.edtName);
                EditText txtImage = viewDialog.findViewById(R.id.edtImage);
                EditText txturl = viewDialog.findViewById(R.id.edtUrl);
                //Save
                viewDialog.findViewById(R.id.btnDialogSaveProduct).setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        Product p = new Product( txtName.getText().toString(), txturl.getText().toString(), txtImage.getText().toString());
                        listProduct.add(p);
                        adapter.notifyItemInserted(listProduct.size()-1);
                        Toast.makeText(viewDialog.getContext(), "thêm dữ liệu thành công", Toast.LENGTH_SHORT).show();
                        alert.dismiss();
                    }
                });
            }
        });
    }
}