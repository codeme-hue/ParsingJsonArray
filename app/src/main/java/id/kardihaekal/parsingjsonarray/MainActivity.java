package id.kardihaekal.parsingjsonarray;

import android.provider.ContactsContract.Data;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import id.kardihaekal.parsingjsonarray.Adapter.DataAdapter;
import id.kardihaekal.parsingjsonarray.Interface.ApiInterfacae;
import id.kardihaekal.parsingjsonarray.Pojo.Contact;
import id.kardihaekal.parsingjsonarray.Pojo.Movie;
import id.kardihaekal.parsingjsonarray.Util.ApiClient;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

  private RecyclerView recyclerView;
  private DataAdapter dataAdapter;
  ApiInterfacae apiInterfacae;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
    RecyclerView.LayoutManager layoutManager =
        new LinearLayoutManager(getApplicationContext());
    recyclerView.setLayoutManager(layoutManager);

    loadData();
  }

  private void loadData() {
    apiInterfacae = ApiClient.getClient().create(ApiInterfacae.class);
    apiInterfacae.getMovies().enqueue(new Callback<Movie>() {
      @Override
      public void onResponse(Call<Movie> call, Response<Movie> response) {

        if(response.isSuccessful()) {
          List<Contact> contactList = response.body().getContacts();
          for (int i=0; i < contactList.size(); i++) {

           dataAdapter = new DataAdapter((ArrayList<Contact>)contactList);
           dataAdapter.notifyDataSetChanged();
           recyclerView.setAdapter(dataAdapter);

          }
        }
      }

      @Override
      public void onFailure(Call<Movie> call, Throwable t) {

      }
    });

  }
}
