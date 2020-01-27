package garg.sarthik.starbugs.Adapters;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import garg.sarthik.starbugs.POJO.Event;
import garg.sarthik.starbugs.R;
import garg.sarthik.starbugs.Statics.Functions;


public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {


    private String TAG = "NA";

    private List<Event> events;
    private Context ctx;

    public NotificationAdapter(List<Event> events, Context ctx) {
        this.events = events;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(ctx).inflate(R.layout.layout_event_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Event event = events.get(position);

        LatLng latlng = Functions.getLatLng(event.getEventLatlng());

        Geocoder geocoder = new Geocoder(ctx, Locale.getDefault());


        try {
            String address =  geocoder.getFromLocation(latlng.latitude, latlng.longitude, 1).get(0).getAddressLine(0);
            holder.tvItemLocation.setText(address);
        } catch (IOException e) {
            e.printStackTrace();
        }
        holder.tvItemDate.setText(Functions.formatDateTime(event.getEventStartTime()));

        holder.mapView.onCreate(null);
        holder.mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                googleMap.getUiSettings().setAllGesturesEnabled(false);

                Event event = events.get(position);
                LatLng latlng = Functions.getLatLng(event.getEventLatlng());

                googleMap.addMarker(new MarkerOptions().position(latlng).title(event.getEventLatlng()).draggable(false));
                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 13));

                Log.i(TAG, "" + latlng.latitude + " " + latlng.longitude);
            }
        });
        holder.mapView.onResume();

    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        MapView mapView;
        TextView tvItemDate;
        TextView tvItemLocation;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvItemDate = itemView.findViewById(R.id.tvItemDate);
            tvItemLocation = itemView.findViewById(R.id.tvItemLocation);
            mapView = itemView.findViewById(R.id.itemMapView);


        }

    }
}
