[ ![Download](https://api.bintray.com/packages/adisiji/ExpandableTextView/ExpandableTextView/images/download.svg) ](https://bintray.com/adisiji/ExpandableTextView/ExpandableTextView/_latestVersion)
# ExpandableTextView
Fully customized TextView Android which can expanded and collapsed with animation

## Getting Started
This library was designed from [here](https://github.com/freecats/TextViewExpandableAnimation)
<br>This thing can be placed inside RecyclerView
### Preview
![preview](https://github.com/adisiji/ExpandableTextView/blob/master/raw/preview_rv.gif)

## How to Install
This library is stored in jcenter, if you use Gradle, then just add <code>compile nb.scode:ExpandableTextView:version</code> in your gradle module

## How to Use
example in XML :
```java
<nb.scode.lib.ExpandableTextView
        android:id="@+id/exp_textview"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:etv_animationTime="5"
        app:etv_expandLines="3"
        app:etv_showLine="false"
        app:etv_textContentSize="12sp"
        app:etv_expandBitmap="@drawable/ic_keyboard_arrow_right_black_24dp"
        app:etv_shrinkBitmap="@drawable/ic_keyboard_arrow_left_black_24dp"
        app:etv_textContentColor="@android:color/darker_gray"
        app:etv_textExpand="More"
        app:etv_textShrink="Less"
        app:etv_textStateColor="@android:color/holo_green_dark"
        />
```
### Use in RecyclerView
If you use it as an item in `RecyclerView`, you may have to make sure  your `RecyclerView Adapter's onBindViewHolder` looks like this to avoid `Unexpected Shrink/Expand State`.
```java
@Override public void onBindViewHolder(ViewHolder holder, final int position) {
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
  ```
  Or maybe you can check it in [sample](https://github.com/adisiji/ExpandableTextView/blob/master/sample/src/main/java/nb/scode/demoexpandabletextview/ItemAdapter.java) to get the full code.
  
<br>Attributes Support as below

| Attributes            |Format| Description |
| -------------|------------- |------------|
| etv_expandLines      | integer | Minimum lines to be shown when in Shrink state|
| etv_expandBitmap     | reference | Image for expand |
| etv_shrinkBitmap     |reference  | Image for shrink |
| etv_textContentColor | color| Color for the content|
| etv_textContentSize  |dimension  | Size of text content(in sp), default is 14sp|
| etv_textExpand       |string | Text status to be shown in Shrink state|
| etv_textShrink       |string  | Text status to be shown in Expand state|
| etv_textStateColor   |color | Color for related status state|
| etv_showLine          |boolean| Show line at bottom |
| etv_animationTime     |integer| Speed controller for animation (bigger = slower animation) |

# License
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
