package nb.scode.demoexpandabletextview;

/**
 * Created by neobyte on 8/15/2017.
 */

public class ContentItem {
  private String title;
  private String content;
  private boolean isShrink = true;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public boolean isShrink() {
    return isShrink;
  }

  public void setShrink(boolean shrink) {
    isShrink = shrink;
  }
}
