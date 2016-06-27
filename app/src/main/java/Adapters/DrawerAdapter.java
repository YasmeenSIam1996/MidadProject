package Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yasmeensiam.midadproject.R;

import java.util.List;

import Model.ItemDrawer;

/**
 * Created by Yasmeen Siam on 25/06/2016.
 */
public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.ViewHolders> {

    private List<ItemDrawer> itemDrawers;
    Context context;

    public DrawerAdapter(List<ItemDrawer> itemDrawers, Context context) {
        this.itemDrawers = itemDrawers;
        this.context = context;
    }

    @Override
    public ViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_drawer, parent, false);

        return new ViewHolders(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolders holder, int position) {
        ItemDrawer item = itemDrawers.get(position);
        holder.itemName.setText(item.getItemName());
    }

    @Override
    public int getItemCount() {
        return itemDrawers.size();
    }

    public class ViewHolders extends RecyclerView.ViewHolder {
        ImageView itemIcon;
        TextView itemName;

        public ViewHolders(View itemView) {
            super(itemView);
            itemIcon = (ImageView) itemView.findViewById(R.id.itemIcon);
            itemName = (TextView) itemView.findViewById(R.id.itemName);
        }
    }
}
