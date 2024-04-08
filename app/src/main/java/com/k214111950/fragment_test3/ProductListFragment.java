package com.k214111950.fragment_test3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.k214111950.adapters.ProductAdapter;
import com.k214111950.fragment_test3.databinding.FragmentProductListBinding;
import com.k214111950.interfaces.ProductInterface;
import com.k214111950.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    FragmentProductListBinding binding;

    ProductAdapter adapter;
    ArrayList<Product> products;

    public ProductListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProductListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductListFragment newInstance(String param1, String param2) {
        ProductListFragment fragment = new ProductListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentProductListBinding.inflate(inflater, container, false);

        loadData();
        addEvents();

        return binding.getRoot();
    }

    private void loadData() {
        adapter = new ProductAdapter(getContext(), R.layout.item_list, initData());
        binding.lvProduct.setAdapter(adapter);
    }

    private void addEvents() {
        binding.lvProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 // Tạo interface
                ProductInterface productInterface = (ProductInterface) getActivity();
                assert productInterface != null;
                productInterface.replaceFragment((Product) adapter.getItem(position));

            }
        });

    }

    private List<Product> initData() {
        products = new ArrayList<>();
        products.add(new Product(1, "Beer333", 19000, R.drawable.beer333,
                "Beer333"));
        products.add(new Product(2, "Heineken", 19000, R.drawable.heineken,
                "Brewing a Better World"));
        products.add(new Product(3, "Tiger", 19000, R.drawable.tiger,
                "Tiger - Nhưng chắc chắn là Tiger"));
        products.add(new Product(4, "Sapporo", 19000, R.drawable.sapporo,
                "Con sông lớn chảy qua đồng bằng"));
        return products;
    }
}