package silkroad;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import silkroad.R;

import java.util.List;

public class TourOfferAdapter extends RecyclerView.Adapter<TourOfferAdapter.TourOfferViewHolder> {

    public interface OnTourOfferActionListener {
        void onAccept(int position);
        void onReject(int position);
    }

    public static class TourOffer {
        public String title;
        public String date;
        public String description;

        public TourOffer(String title, String date, String description) {
            this.title = title;
            this.date = date;
            this.description = description;
        }
    }

    private final List<TourOffer> offerList;
    private final OnTourOfferActionListener actionListener;

    public TourOfferAdapter(List<TourOffer> offerList, OnTourOfferActionListener actionListener) {
        this.offerList = offerList;
        this.actionListener = actionListener;
    }

    @NonNull
    @Override
    public TourOfferViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_tour_offer, parent, false);
        return new TourOfferViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TourOfferViewHolder holder, int position) {
        TourOffer offer = offerList.get(position);
        holder.textTourTitle.setText(offer.title);
        holder.textTourDate.setText(offer.date);
        holder.textTourDescription.setText(offer.description);

        holder.btnAcceptTour.setOnClickListener(v -> {
            if (actionListener != null) actionListener.onAccept(position);
        });
        holder.btnRejectTour.setOnClickListener(v -> {
            if (actionListener != null) actionListener.onReject(position);
        });
    }

    @Override
    public int getItemCount() {
        return offerList != null ? offerList.size() : 0;
    }

    public static class TourOfferViewHolder extends RecyclerView.ViewHolder {
        TextView textTourTitle, textTourDate, textTourDescription;
        Button btnAcceptTour, btnRejectTour;

        public TourOfferViewHolder(@NonNull View itemView) {
            super(itemView);
            textTourTitle = itemView.findViewById(R.id.textTourTitle);
            textTourDate = itemView.findViewById(R.id.textTourDate);
            textTourDescription = itemView.findViewById(R.id.textTourDescription);
            btnAcceptTour = itemView.findViewById(R.id.btnAcceptTour);
            btnRejectTour = itemView.findViewById(R.id.btnRejectTour);
        }
    }
}