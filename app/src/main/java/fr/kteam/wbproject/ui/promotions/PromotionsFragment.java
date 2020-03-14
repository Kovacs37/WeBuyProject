package fr.kteam.wbproject.ui.promotions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

import fr.kteam.wbproject.R;

public class PromotionsFragment extends Fragment implements ClickDetectorOnRecycler {

    private PromotionsViewModel mViewModel;

    public static PromotionsFragment newInstance() {
        return new PromotionsFragment();
    }
    private RecyclerView recyclerView;
    private PromotionsAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_promotions, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        // recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        ArrayList<promotion> promos = new ArrayList<>();
        promos.add(new promotion());
        promos.add(new promotion());

        mAdapter = new PromotionsAdapter(promos);
        recyclerView.setAdapter(mAdapter);

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(PromotionsViewModel.class);
        // TODO: Use the ViewModel
        PromotionsViewModel pvm = new PromotionsViewModel() ;
        mAdapter.setClickDetectorOnRecycler( this);

    }

    @Override
    public void onResume() {
        super.onResume();
        mAdapter.setClickDetectorOnRecycler( this);
    }


    @Override
    public void clickOnRecyclerItem(int position, View v) {
        Toast.makeText(getActivity(), "Clic sur l'item "+position, Toast.LENGTH_LONG).show();

             AppCompatActivity activity = (AppCompatActivity) v.getContext();
        //   Toast.makeText(activity, "Current location:\n" , Toast.LENGTH_LONG).show();
           // PromotionsDetail myFragment = new PromotionsDetail();
          //  activity.getSupportFragmentManager().beginTransaction().replace(R.id.promotions, myFragment).addToBackStack(null).commit();

        PromotionsDetail newGamefragment = new PromotionsDetail();
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.promotions, newGamefragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }
}
