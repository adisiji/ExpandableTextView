package nb.scode.demoexpandabletextview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import nb.scode.lib.ExpandableTextView;

/**
 * Created by neobyte on 8/15/2017.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

  private final List<ContentItem> itemList;

  public ItemAdapter(List<ContentItem> itemList) {
    this.itemList = itemList;
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ViewHolder(
        LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false));
  }

  @Override public void onBindViewHolder(ViewHolder holder, final int position) {
    holder.tvTitle.setText(itemList.get(position).getTitle());
    //record its state
    holder.expandableTextView.setOnStateChangeListener(
        new ExpandableTextView.OnStateChangeListener() {
          @Override public void onStateChange(boolean isShrink) {
            ContentItem contentItem = itemList.get(position);
            contentItem.setShrink(isShrink);
            itemList.set(position, contentItem);
          }
        });
    holder.expandableTextView.setText(itemList.get(position).getContent());
    //important! reset its state as where it left
    holder.expandableTextView.resetState(itemList.get(position).isShrink());
  }

  @Override public int getItemCount() {
    return itemList.size();
  }

  static class ViewHolder extends RecyclerView.ViewHolder {

    TextView tvTitle;
    ExpandableTextView expandableTextView;

    public ViewHolder(View itemView) {
      super(itemView);
      tvTitle = itemView.findViewById(R.id.tv_title);
      expandableTextView = itemView.findViewById(R.id.exp_textview);
    }
  }
}
