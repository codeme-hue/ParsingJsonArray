package id.kardihaekal.parsingjsonarray.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import id.kardihaekal.parsingjsonarray.Pojo.Contact;
import id.kardihaekal.parsingjsonarray.R;
import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

  private ArrayList<Contact> arrayList;

  public DataAdapter(ArrayList<Contact> arrayList) {
    this.arrayList = arrayList;
  }

  @NonNull
  @Override
  public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

    View view = LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.card_layout, viewGroup, false);

    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

    viewHolder.tv_id.setText(arrayList.get(i).getId());
    viewHolder.tv_name.setText(arrayList.get(i).getName());
    viewHolder.tv_email.setText(arrayList.get(i).getEmail());
    viewHolder.tv_address.setText(arrayList.get(i).getAddress());
    viewHolder.tv_gender.setText(arrayList.get(i).getGender());
    viewHolder.tv_home.setText(arrayList.get(i).getPhone().getHome());
    viewHolder.tv_office.setText(arrayList.get(i).getPhone().getOffice());
    viewHolder.tv_mobile.setText(arrayList.get(i).getPhone().getMobile());

  }

  @Override
  public int getItemCount() {
    return arrayList.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    TextView tv_id, tv_name, tv_email, tv_address, tv_gender, tv_home, tv_mobile, tv_office;

    public ViewHolder(@NonNull View itemView) {
      super(itemView);

      tv_id = itemView.findViewById(R.id.tv_id);
      tv_name = itemView.findViewById(R.id.tv_name);
      tv_email = itemView.findViewById(R.id.tv_email);
      tv_address = itemView.findViewById(R.id.tv_address);
      tv_gender = itemView.findViewById(R.id.tv_gender);
      tv_home = itemView.findViewById(R.id.tv_home);
      tv_mobile = itemView.findViewById(R.id.tv_mobile);
      tv_office = itemView.findViewById(R.id.tv_office);

    }
  }

}
