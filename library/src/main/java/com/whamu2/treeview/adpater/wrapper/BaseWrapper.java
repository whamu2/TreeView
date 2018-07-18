package com.whamu2.treeview.adpater.wrapper;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.whamu2.treeview.base.BaseRecyclerAdapter;
import com.whamu2.treeview.base.ViewHolder;
import com.whamu2.treeview.manager.ItemManager;

import java.util.List;


public class BaseWrapper<T> extends BaseRecyclerAdapter<T> {

    protected BaseRecyclerAdapter<T> mAdapter;

    public BaseWrapper(BaseRecyclerAdapter<T> adapter) {
        mAdapter = adapter;
        mAdapter.getItemManager().setAdapter(this);
    }

    @Override
    public void addCheckItemInterfaces(CheckItemInterface itemInterface) {
        mAdapter.addCheckItemInterfaces(itemInterface);
    }

    @Override
    public void removeCheckItemInterfaces(CheckItemInterface itemInterface) {
        mAdapter.removeCheckItemInterfaces(itemInterface);
    }

    @Override
    public void onBindViewHolderClick(ViewHolder holder, View view) {
        mAdapter.onBindViewHolderClick(holder, view);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return mAdapter.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        mAdapter.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onViewAttachedToWindow(ViewHolder holder) {
        mAdapter.onViewAttachedToWindow(holder);
    }

    @Override
    public int getItemViewType(int position) {
        return mAdapter.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        mAdapter.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return mAdapter.getItemCount();
    }


    @Override
    public int getLayoutId(int position) {
        return mAdapter.getLayoutId(position);
    }

    @Override
    public T getData(int position) {
        return mAdapter.getData(position);
    }

    @Override
    public List<T> getDatas() {
        return mAdapter.getDatas();
    }

    @Override
    public void setDatas(List<T> datas) {
        mAdapter.setDatas(datas);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, T t, int position) {
        mAdapter.onBindViewHolder(holder, t, position);
    }

    @Override
    public int checkPosition(int position) {
        return mAdapter.checkPosition(position);
    }


    @Override
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mAdapter.setOnItemClickListener(onItemClickListener);
    }

    @Override
    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        mAdapter.setOnItemLongClickListener(onItemLongClickListener);
    }

    @Override
    public ItemManager<T> getItemManager() {
        return mAdapter.getItemManager();
    }

    @Override
    public void setItemManager(ItemManager<T> itemManager) {
        mAdapter.setItemManager(itemManager);
    }
}
