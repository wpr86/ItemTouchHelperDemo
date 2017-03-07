package itemtouchhelper.demo.carl.co.itemtouchhelper;

/**
 * Created by Host-0 on 2017/3/7.
 */

public interface ItemTouchHelperAdapter {
    boolean onItemMove(int fromPosition, int toPosition);
    void onItemDismiss(int position);
}
