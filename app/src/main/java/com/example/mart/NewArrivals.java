package com.example.mart;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewArrivals#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewArrivals extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String url = "https://mobileapp25.blob.core.windows.net/json/item_data1.json";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView itemRV;
    ArrayList<ItemModel> itemModelArrayList;
    Context con = getActivity();
    View testview;

    public NewArrivals() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewArrivals.
     */
    // TODO: Rename and change types and number of parameters
    public static NewArrivals newInstance(String param1, String param2) {
        NewArrivals fragment = new NewArrivals();
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
        testview = inflater.inflate(R.layout.fragment_new_arrivals, container, false);


        itemRV = testview.findViewById(R.id.RecyclerHome);

        // here we have created new array list and added data to it.
        /* itemModelArrayList = new ArrayList<>();
        itemModelArrayList.add(new ItemModel("Parle G Rs 5", "Most eco biscuit XD",5, R.drawable.ic_cart));
        itemModelArrayList.add(new ItemModel("MarieGold Rs 10", "Decent eco biscuit XD",4, R.drawable.ic_orders));
        itemModelArrayList.add(new ItemModel("Goodday Rs 25", "Special ocassion biscuit XD",3, R.drawable.ic_star));
        itemModelArrayList.add(new ItemModel("Dark Fantasy Rs 50", "Ameero ke shauk XD",1, R.drawable.ic_remove));
        itemModelArrayList.add(new ItemModel("Dark Fantasy Rs 50", "Mehenga hai par le le :)",1, R.drawable.ic_remove));
        itemModelArrayList.add(new ItemModel("Dark Fantasy Rs 50", "Kya kanjoosi karra h le le!!",1, R.drawable.ic_remove));
        itemModelArrayList.add(new ItemModel("Dark Fantasy Rs 45", "10 takka off chal.",1, R.drawable.ic_remove));
        itemModelArrayList.add(new ItemModel("Dark Fantasy Rs 40", "Tere liye khaas 20 takka off <3",1, R.drawable.ic_remove));
        itemModelArrayList.add(new ItemModel("Dark Fantasy Rs 25", "Ab isse kamm nhi hoga thike.",1, R.drawable.ic_remove));
        itemModelArrayList.add(new ItemModel("Dark Fantasy Rs 0", "Ab toh le le free hai ab toh",1, R.drawable.ic_remove));
        itemModelArrayList.add(new ItemModel("Dark Fantasy", "Chchod bhai tu logout kar tere se na ho payega!",1, R.drawable.ic_remove));


        // we are initializing our adapter class and passing our arraylist to it.
        ItemAdapter itemAdapter = new ItemAdapter(getActivity(), itemModelArrayList);
*/
        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        itemRV.setLayoutManager(linearLayoutManager);



        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                Item []items = gson.fromJson(response,Item[].class);

                itemRV.setAdapter(new ItemAdapter(getActivity(),items));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(request);
        return testview;
    }
}