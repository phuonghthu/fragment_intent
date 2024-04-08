package com.k214111950.fragment_test3;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.k214111950.fragment_test3.databinding.ActivityMain2Binding;
import com.k214111950.fragment_test3.databinding.ActivityMainBinding;
import com.k214111950.fragment_test3.databinding.FragmentProductDescriptionBinding;
import com.k214111950.interfaces.ProductInterface;
import com.k214111950.model.Product;

public class MainActivity2 extends AppCompatActivity implements ProductInterface {

    ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loadFragment();
    }

    private void loadFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.containerLayout, new ProductListFragment());
        transaction.commit();
    }

    @Override
    public void replaceFragment(Product p) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        // Thay thế fragment
        ProductDescriptionFragment fragment = new ProductDescriptionFragment();

        // Gửi dữ liệu
        Bundle bundle = new Bundle();
        bundle.putSerializable(Utils.SELECTED_PRODUCT, p); // Đặt dữ liệu vào Bundle trước
        fragment.setArguments(bundle); // Truyền Bundle vào Fragment

        transaction.replace(R.id.containerLayout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}