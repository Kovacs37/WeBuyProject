package fr.kteam.wbproject.ui.home;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import fr.kteam.wbproject.MainActivity;
import fr.kteam.wbproject.R;
import fr.kteam.wbproject.ui.magasins.MagasinsFragment;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;


    GridLayout mainGrid;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
       // final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
             //   textView.setText(s);
            }
        });


        // this can crash
       // mainGrid = (GridLayout) root.findViewById(R.id.mainGrid);

        //Set Event
       // setSingleEvent(mainGrid);


        return root;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mainGrid = (GridLayout) view.findViewById(R.id.mainGrid);
        // or
        setSingleEvent(mainGrid);
        //view.findViewById(R.id.mainGrid).setOnClickListener((View.OnClickListener) this);
       // getActivity().findViewById(R.id.yourId).setOnClickListener(this);
    }




    private void setToggleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            final CardView cardView = (CardView) mainGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                       // Toast.makeText(MainActivity.this, "State : True", Toast.LENGTH_SHORT).show();

                    } else {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                     //   Toast.makeText(MainActivity.this, "State : False", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setSingleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = null;

                    NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);


                    switch (finalI){
                        case 0:
                            navController.navigate(R.id.magasins);
                            break;
                        case 1:
                           //  intent = new Intent(getActivity(), ShopActivity.class);
                            break;
                        default:
                          //   intent = new Intent(getActivity(), ShopActivity.class);
                            break;
                    }
                    //intent.putExtra("info","This is activity from card item index  "+finalI);
                   // startActivity(intent);

                }
            });
        }
    }




}
