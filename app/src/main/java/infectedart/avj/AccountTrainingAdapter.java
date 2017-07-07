package infectedart.avj;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Infected on 12-Jun-17.
 */

    public class AccountTrainingAdapter extends RecyclerView.Adapter<AccountTrainingAdapter.ViewHolder> {
        private ArrayList<Training> accTrainings = new ArrayList<>();
        public AccountTrainingAdapter(ArrayList<Training> accTrainings){
            this.accTrainings = accTrainings;
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            private CardView cardView;
            public ViewHolder(CardView v) {
                super(v);
                cardView = v;
            }
        }
        @Override
        public AccountTrainingAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
            CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.acc_training_card_view, parent, false);
            return new ViewHolder(cv);
        }
        @Override
        public void onBindViewHolder(ViewHolder holder,final int position) {
            CardView cardView = holder.cardView;
            final TextView training_name = (TextView) cardView.findViewById(R.id.training_name_content);
            final TextView duration = (TextView) cardView.findViewById(R.id.duration_content);
            final TextView training_fee = (TextView) cardView.findViewById(R.id.training_fee_content);
            final TextView training_desc = (TextView) cardView.findViewById(R.id.training_desc_content);

            training_name.setText(accTrainings.get(position).getTraining_name());
            duration.setText(accTrainings.get(position).getTraining_duration());
            training_fee.setText(accTrainings.get(position).getTraining_fee());
            training_desc.setText(accTrainings.get(position).getTraining_desc());
            Button register = (Button) cardView.findViewById(R.id.register);

            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(v.getContext(),RegisterTraining.class);
                    intent.putExtra("position",position);
                    intent.putExtra("training_name",accTrainings.get(position).getTraining_name().toString());
                    intent.putExtra("duration",accTrainings.get(position).getTraining_duration().toString());
                    intent.putExtra("training_fee",accTrainings.get(position).getTraining_fee().toString());
                    intent.putExtra("training_desc",accTrainings.get(position).getTraining_desc().toString());
                    v.getContext().startActivity(intent);

                }
            });

        }
        @Override public int getItemCount (){
            return accTrainings.size();
        }
    }