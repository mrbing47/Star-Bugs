package garg.sarthik.starbugs.Adapters;

import android.content.Context;
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

import java.util.List;

import garg.sarthik.starbugs.POJO.Event;
import garg.sarthik.starbugs.R;


public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {


    List<Event> events;
    Context ctx;


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
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Event event = events.get(position);

        holder.tvItemLocation.setText(event.getEventLatlng());
        holder.tvItemDate.setText(event.getEventStartTime());

        /* TODO
            Extract LatLng from event.getEventLatLng() and store them to the following fn variables
         */

        double lat = 90;
        double lng = 40;

        if(holder.gMap != null)
        {
            holder.gMap.getUiSettings().setAllGesturesEnabled(false);
            holder.gMap.addMarker(new MarkerOptions().position(new LatLng(lat, lng)).title(event.getEventLatlng()).draggable(false));
            holder.gMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat, lng), 12));
        }


    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements OnMapReadyCallback {

        GoogleMap gMap = null;
        MapView mapView;
        TextView tvItemDate;
        TextView tvItemLocation;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvItemDate = itemView.findViewById(R.id.tvItemDate);
            tvItemLocation = itemView.findViewById(R.id.tvItemLocation);
            mapView = itemView.findViewById(R.id.itemMapView);

            mapView.getMapAsync(this);

        }

        @Override
        public void onMapReady(GoogleMap googleMap) {
            gMap = googleMap;
        }
    }
}
