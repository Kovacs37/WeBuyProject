package fr.kteam.wbproject.ui.promotions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

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

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<promotion> promos = new ArrayList<>();


        // AJOUT DES PROMOTIONS QUI SE FERONT :
        // Soit toutes les promotions autour de soi si on clique sur l'onglet promotions
        // soit les promotions associées au magasin sur lequel on a cliqué
        promos.add(new promotion());
        promos.add(new promotion());

        mAdapter = new PromotionsAdapter(promos);
        recyclerView.setAdapter(mAdapter);

        FloatingActionButton fab = getActivity().findViewById(R.id.fab);
        fab.setVisibility(View.INVISIBLE);

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
