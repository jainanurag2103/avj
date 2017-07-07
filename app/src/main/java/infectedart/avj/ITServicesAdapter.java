package infectedart.avj;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Infected on 11-Jun-17.
 */


public class ITServicesAdapter extends RecyclerView.Adapter<ITServicesAdapter.ViewHolder> {
    private ArrayList<AllITServices> ITServices = new ArrayList<>();
    public ITServicesAdapter(ArrayList<AllITServices> ITServices){
        this.ITServices = ITServices;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }
    @Override
    public ITServicesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.it_services_card_view, parent, false);
        return new ViewHolder(cv);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CardView cardView = holder.cardView;
        TextView heading = (TextView) cardView.findViewById(R.id.it_serv_text_heading);
        TextView detail = (TextView) cardView.findViewById(R.id.it_serv_text_details);
        heading.setText(ITServices.get(position).getIt_serv_name());
        detail.setText(ITServices.get(position).getIt_serv_detail());
    }
    @Override public int getItemCount (){
        return ITServices.size();
    }
}
