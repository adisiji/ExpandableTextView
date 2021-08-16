package nb.scode.demoexpandabletextview;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

  private RecyclerView recyclerView;
  private ItemAdapter adapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    recyclerView = findViewById(R.id.recycler_view);
    setupRecycler();
  }

  private void setupRecycler() {
    try {
      adapter = new ItemAdapter(createDummyContent(30));
      recyclerView.setNestedScrollingEnabled(true);
      LinearLayoutManager linearLayoutManager =
          new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
      recyclerView.setLayoutManager(linearLayoutManager);
      recyclerView.setAdapter(adapter);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private List<ContentItem> createDummyContent(int i) throws Exception {
    List<ContentItem> itemList = new ArrayList<>();
    if (i > 0) {
      for (int j = 0; j < i; j++) {
        ContentItem contentItem = new ContentItem();
        contentItem.setTitle("Title " + String.valueOf(j + 1));
        if (j % 2 == 0) {
          contentItem.setContent(getString(R.string.sample_long_text));
        } else {
          contentItem.setContent(getString(R.string.sample_list_text));
        }
        itemList.add(contentItem);
      }
      return itemList;
    } else {
      throw new Exception("Content must not be zero");
    }
  }
}
