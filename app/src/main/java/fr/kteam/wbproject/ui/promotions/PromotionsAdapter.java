package fr.kteam.wbproject.ui.promotions;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fr.kteam.wbproject.R;

public class PromotionsAdapter extends RecyclerView.Adapter<PromotionsAdapter.PromotionsViewHolder> {


    private ArrayList<promotion> promos;
    private static fr.kteam.wbproject.ui.promotions.ClickDetectorOnRecycler ClickDetectorOnRecycler;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class PromotionsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public CardView cardView;
        public PromotionsViewHolder(CardView v) {
            super(v);
            cardView= v;
            itemView.setOnClickListener(this);
        }
        //      @Override
       // public void onClick(View v) {

                        //     AppCompatActivity activity = (AppCompatActivity) v.getContext();
                        //   Toast.makeText(activity, "Current location:\n" , Toast.LENGTH_LONG).show();
                        //    PromotionsDetail myFragment = new PromotionsDetail();
        //    activity.getSupportFragmentManager().beginTransaction().replace(R.id.promotions, myFragment).addToBackStack(null).commit();

                //  }


        @Override
        public void onClick(View v) {
            ClickDetectorOnRecycler.clickOnRecyclerItem(getAdapterPosition(), v);
        }
    }


    public PromotionsAdapter(ArrayList<promotion> promos) {
        this.promos = promos;
    }

    @NonNull
    @Override
    public PromotionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create a new view
        CardView v = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.promotion_card, parent, false);
        PromotionsViewHolder vh = new PromotionsViewHolder(v);
        return vh;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull PromotionsAdapter.PromotionsViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.cardView.setCardBackgroundColor(R.color.colorPrimary);
    }


    @Override
    public int getItemCount() {
        return promos.size();
    }

    public void setClickDetectorOnRecycler(ClickDetectorOnRecycler detecteurDeClicSurRecycler) {
        ClickDetectorOnRecycler = detecteurDeClicSurRecycler;
    }






}
