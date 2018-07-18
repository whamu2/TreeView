package com.whamu2.treeview.item;

import android.support.annotation.NonNull;

import com.whamu2.treeview.base.ViewHolder;
import com.whamu2.treeview.widget.swipe.SwipeItemMangerInterface;
import com.whamu2.treeview.widget.swipe.SwipeLayout;



public interface SwipeItem {

    int getSwipeLayoutId();

    SwipeLayout.DragEdge getDragEdge();

    void onBindSwipeView(@NonNull ViewHolder viewHolder, int position, SwipeItemMangerInterface swipeManger);

    void openCallback();
}
