package id.kardihaekal.parsingjsonarray.Interface;

import id.kardihaekal.parsingjsonarray.Pojo.Movie;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterfacae {

  @GET("/contacts/")
  Call<Movie> getMovies();

}
