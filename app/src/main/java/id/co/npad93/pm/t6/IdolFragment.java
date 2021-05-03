package id.co.npad93.pm.t6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IdolFragment extends Fragment implements IdolAdapter.OnItemClick {
    public IdolFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_idol, container, false);

        // Init recycler view
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Load data
        SchoolIdolApi schoolIdolApi = ApiHelper.getRetrofitInstance().create(SchoolIdolApi.class);
        Call<IdolResponse> idolResponseCall = schoolIdolApi.getIdols(20, 1);
        idolResponseCall.enqueue(new Callback<IdolResponse>() {
            @Override
            public void onResponse(Call<IdolResponse> call, Response<IdolResponse> response) {
                if (response.isSuccessful()) {
                    IdolResponse idolResponse = response.body();

                    if (idolResponse != null) {
                        recyclerView.setAdapter(new IdolAdapter(idolResponse.getResults(), IdolFragment.this));
                    }
                }
            }

            @Override
            public void onFailure(Call<IdolResponse> call, Throwable t) {
                Log.d("npad93.pm.t6", "onFailure", t);
                Toast.makeText(getActivity(), "Failed: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

    @Override
    public void onClick(int i) {
        // TODO intent
    }

    private RecyclerView recyclerView;
}
