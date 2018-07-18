package com.whamu2.treeview.item;


import java.util.List;


interface _ItemParent {
    /**
     * 是否允许展开
     *
     * @return
     */
    boolean isCanExpand();

    /**
     * 展开后的回调
     */
    void onExpand();

    /**
     * 折叠后的回调
     */
    void onCollapse();

    /**
     * 获取子集
     *
     * @return
     */
    List<? extends TreeItem> getChilds();

}
