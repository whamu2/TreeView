# TreeView RecyclerView二级列表
<p align="left">
   <a href="https://jitpack.io/#whamu2/TreeView">
    <img src="https://jitpack.io/v/whamu2/TreeView.svg" alt="Latest Stable Version" />
  </a>
  <a href="https://developer.android.com/about/versions/android-4.4.html">
    <img src="https://img.shields.io/badge/API-19%2B-blue.svg?style=flat-square" alt="Min Sdk Version" />
  </a>
  <a href="https://opensource.org/licenses/MIT">
    <img src="https://img.shields.io/badge/License-MIT-blue.svg?style=flat-square" alt="License" />
  </a>
  <a href="https://github.com/whamu2">
    <img src="https://img.shields.io/badge/Author-whamu2-orange.svg?style=flat-square" alt="Author" />
  </a>
</p>

## Getting started

### Setting up the dependency

Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

```groovy
allprojects {
	repositories {
		maven { url 'https://jitpack.io' }
	}
}
```

Step 2. Add the dependency

```groovy
dependencies {
        implementation 'com.github.whamu2:TreeView:V1.1.0'
}
```

Step 3. use

private TreeRecyclerAdapter mTreeRecyclerAdapter = new TreeRecyclerAdapter(TreeRecyclerType.SHOW_ALL);

List<TreeItem> treeItemList = ItemHelperFactory.createTreeItemList(strings, DemoTreeItemGroup.class, null);
mRecyclerView.setAdapter(mTreeRecyclerAdapter);
mTreeRecyclerAdapter.getItemManager().replaceAllItem(treeItemList);
