package itemtouchhelper.demo.carl.co.itemtouchhelper;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by Host-0 on 2017/3/7.
 */

public class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerListAdapter.ViewHolder> implements ItemTouchHelperAdapter {
    private List<String> mList;
    public ViewHolder mViewHolder;

    public RecyclerListAdapter(Context context, List<String> myList){
        mList = myList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return mViewHolder = new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(mList, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public void onItemDismiss(int position) {
        mList.remove(position);
        notifyItemRemoved(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public RelativeLayout mItem;
        public TextView mTextView;
        public FrameLayout mFlItem;
        public TextView mDeleteText;
        public ViewHolder(View itemView){
            super(itemView);
            mTextView = (TextView)itemView.findViewById(R.id.text);
            mItem = (RelativeLayout)itemView.findViewById(R.id.item);
            mFlItem = (FrameLayout)itemView.findViewById(R.id.fl_item);
            mDeleteText = (TextView)itemView.findViewById(R.id.tv_delete);
        }
    }
}
