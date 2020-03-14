package fr.kteam.wbproject.ui.magasins;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.location.Location;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


import fr.kteam.wbproject.R;
import fr.kteam.wbproject.ui.promotions.PromotionsFragment;

public class MagasinsFragment extends Fragment implements GoogleMap.OnMyLocationButtonClickListener,
        GoogleMap.OnMyLocationClickListener, GoogleMap.OnInfoWindowClickListener,
        OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private MagasinsViewModel mViewModel;
    private SupportMapFragment mapFragment;
    public static MagasinsFragment newInstance() {
        return new MagasinsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

      //  SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.googleMap);

        //if (mapFragment != null) {
        //    mapFragment.getMapAsync(this);

        //}


        if (mapFragment == null) {
            mapFragment = SupportMapFragment.newInstance();
            mapFragment.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {
                    LatLng latLng = new LatLng(47.356007, 0.698019);
                    googleMap.addMarker(new MarkerOptions().position(latLng)
                            .title("Leclerc")
                            .flat(true)
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.leclerc)));

                    googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {

                        @Override
                        public void onInfoWindowClick(Marker marker) {
                            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                            navController.navigate(R.id.promotions);
                        }
                    });



                    googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                        @Override
                        public boolean onMarkerClick(Marker marker) {
                            //int position = (int)(marker.getTag());
                            Toast.makeText(getActivity(), "clicked", Toast.LENGTH_SHORT).show();
                            //Using position get Value from arraylist



                            return false;
                        }
                    });

                    googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
                    // TODO: Before enabling the My Location layer, you must request

                }
            });




        }


        getChildFragmentManager().beginTransaction().replace(R.id.googleMap, mapFragment).commit();


        return inflater.inflate(R.layout.fragment_magasins, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MagasinsViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onMapReady(GoogleMap map) {
        map.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));


        CameraUpdate point = CameraUpdateFactory.newLatLng(new LatLng(53, 2));

// moves camera to coordinates
        map.moveCamera(point);
// animates camera to coordinates
        map.animateCamera(point);

    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {
        Toast.makeText(getActivity(), "Current location:\n" + location, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(getActivity(), "MyLocation button clicked", Toast.LENGTH_SHORT).show();
        // Return false so that we don't consume the event and the default behavior still occurs
        // (the camera animates to the user's current position).
        return false;
    }


    @Override
    public void onInfoWindowClick(Marker marker) {
        Toast.makeText(getActivity(), "clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Toast.makeText(getActivity(), "clicked", Toast.LENGTH_SHORT).show();
        return false;
    }
}
