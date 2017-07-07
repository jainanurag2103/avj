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

public class RecruitmentAdapter extends RecyclerView.Adapter<RecruitmentAdapter.ViewHolder> {
    private ArrayList<RecruitmentPost> all_posts = new ArrayList<>();
    public RecruitmentAdapter(ArrayList<RecruitmentPost> all_posts){
        this.all_posts = all_posts;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        public ViewHolder(CardView v) {
            super(v);
            cardView = v;
        }
    }
    @Override
    public RecruitmentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        CardView cv = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.recruitment_card_view, parent, false);
        return new ViewHolder(cv);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder,final int position) {
        CardView cardView = holder.cardView;
        final TextView recruitment_post_content = (TextView) cardView.findViewById(R.id.recruitment_post_content);
        final TextView charges_content = (TextView) cardView.findViewById(R.id.charges_content);

        recruitment_post_content.setText(all_posts.get(position).getPost_name());
        charges_content.setText(all_posts.get(position).getPost_charges());

        Button recruit = (Button) cardView.findViewById(R.id.recruit);

        recruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(),RecruitmentRegistrationActivity.class);
                intent.putExtra("position",position);
                intent.putExtra("recruitment_post_name",all_posts.get(position).getPost_name().toString());
                v.getContext().startActivity(intent);

            }
        });

    }
    @Override public int getItemCount (){
        return all_posts.size();
    }
}