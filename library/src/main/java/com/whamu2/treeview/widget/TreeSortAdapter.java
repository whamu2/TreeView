package com.whamu2.treeview.widget;

import com.whamu2.treeview.adpater.TreeRecyclerAdapter;
import com.whamu2.treeview.adpater.TreeRecyclerType;
import com.whamu2.treeview.base.BaseRecyclerAdapter;
import com.whamu2.treeview.item.TreeItem;
import com.whamu2.treeview.item.TreeSortItem;
import com.whamu2.treeview.manager.ItemManager;

import java.util.HashMap;
import java.util.List;



public class TreeSortAdapter extends TreeRecyclerAdapter {
    private final HashMap<Object, Integer> sortMap = new HashMap<>();
    private TreeSortManageWrapper manageWrapper;

    public TreeSortAdapter() {

    }

    public TreeSortAdapter(TreeRecyclerType treeRecyclerType) {
        super(treeRecyclerType);
    }

    @Override
    public void setDatas(List<TreeItem> datas) {
        super.setDatas(datas);
        getItemManager().updateSorts(getDatas());
    }


    public int getSortIndex(Object o) {
        if (o == null) {
            return -1;
        }
        Integer integer = sortMap.get(o);
        return integer == null ? -1 : integer;
    }

    @Override
    public TreeSortManageWrapper getItemManager() {
        if (manageWrapper == null) {
            manageWrapper = new TreeSortManageWrapper(this, super.getItemManager());
        }
        return manageWrapper;
    }

    public class TreeSortManageWrapper extends ItemManager<TreeItem> {
        ItemManager<TreeItem> manager;

        public TreeSortManageWrapper(BaseRecyclerAdapter adapter, ItemManager<TreeItem> manager) {
            super(adapter);
            this.manager = manager;
        }

        @Override
        public void addItem(TreeItem treeItem) {
            manager.addItem(treeItem);
            updateSort(manager.getItemPosition(treeItem), treeItem);
        }


        @Override
        public void addItem(int i, TreeItem treeItem) {
            manager.addItem(i, treeItem);
            updateSort(i, treeItem);
        }

        @Override
        public void addItems(List<TreeItem> list) {
            manager.addItems(list);
            updateSorts(list);
        }

        @Override
        public void addItems(int i, List<TreeItem> list) {
            manager.addItems(i, list);
            updateSorts(list);
        }

        @Override
        public void setAdapter(BaseRecyclerAdapter<TreeItem> adapter) {
            manager.setAdapter(adapter);
        }

        @Override
        public BaseRecyclerAdapter getAdapter() {
            return manager.getAdapter();
        }

        @Override
        public void removeItem(TreeItem treeItem) {
            manager.removeItem(treeItem);
            updateSort(getItemPosition(treeItem), treeItem);
        }

        @Override
        public void removeItem(int i) {
            TreeItem item = manager.getItem(i);
            if (item instanceof TreeSortItem) {
                sortMap.remove(((TreeSortItem) item).getSortKey());
            }
            manager.removeItem(i);
        }

        @Override
        public void removeItems(List<TreeItem> list) {
            manager.removeItems(list);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                TreeItem item = list.get(i);
                if (item instanceof TreeSortItem) {
                    sortMap.remove(((TreeSortItem) item).getSortKey());
                }
            }
        }


        @Override
        public void replaceItem(int i, TreeItem treeItem) {
            manager.replaceItem(i, treeItem);
            updateSort(i, treeItem);
        }

        @Override
        public void replaceAllItem(List<TreeItem> list) {
            manager.replaceAllItem(list);
            updateSorts(list);
        }

        @Override
        public TreeItem getItem(int i) {
            return manager.getItem(i);
        }

        @Override
        public int getItemPosition(TreeItem treeItem) {
            return manager.getItemPosition(treeItem);
        }

        @Override
        public void clean() {
            manager.clean();
        }

        public void updateSorts(List<TreeItem> treeItems) {
            int size = treeItems.size();
            for (int i = 0; i < size; i++) {
                TreeItem treeItem = treeItems.get(i);
                if (treeItem instanceof TreeSortItem) {
                    sortMap.put(((TreeSortItem) treeItem).getSortKey(), getItemPosition(treeItem));
                }
            }
        }

        public void updateSort(TreeItem treeItem) {
            if (treeItem instanceof TreeSortItem) {
                sortMap.put(((TreeSortItem) treeItem).getSortKey(), getItemPosition(treeItem));
            }
        }

        public void updateSort(int position, TreeItem treeItem) {
            if (treeItem instanceof TreeSortItem) {
                sortMap.put(((TreeSortItem) treeItem).getSortKey(), position);
            }
        }

        @Override
        public void notifyDataChanged() {
            manager.notifyDataChanged();
        }
    }
}
