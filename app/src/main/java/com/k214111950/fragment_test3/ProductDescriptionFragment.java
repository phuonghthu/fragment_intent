package com.k214111950.fragment_test3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.k214111950.fragment_test3.databinding.FragmentProductDescriptionBinding;
import com.k214111950.model.Product;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductDescriptionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductDescriptionFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    FragmentProductDescriptionBinding binding;

    public ProductDescriptionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProductDescriptionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductDescriptionFragment newInstance(String param1, String param2) {
        ProductDescriptionFragment fragment = new ProductDescriptionFragment();
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
        binding = FragmentProductDescriptionBinding.inflate(inflater, container, false);

        getData(); //nhận dữ liệu
        return binding.getRoot();
    }

    private void getData() {
        Bundle bundle = getArguments();
        Product p = (Product) bundle.getSerializable(Utils.SELECTED_PRODUCT);
        assert p != null;
        binding.txtName.setText(p.getProductName());
        binding.txtPrice.setText(String.format("%.0f d", p.getProductPrice()));
        binding.txtDescription.setText(p.getProductDescription());
        
    }
}