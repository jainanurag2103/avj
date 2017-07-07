package infectedart.avj;

/**
 * Created by Infected on 11-Jun-17.
 */

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ItemViewHolder extends RecyclerView.ViewHolder{
    public TextView itemContent;
    public RelativeLayout item_layout;
    public ItemViewHolder(View itemView) {
        super(itemView);
        itemContent = (TextView)itemView.findViewById(R.id.item_content);
        item_layout = (RelativeLayout) itemView.findViewById(R.id.item_layout);
    }
}