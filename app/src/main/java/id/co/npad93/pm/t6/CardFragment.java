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

public class CardFragment extends Fragment implements IdolAdapter.OnItemClick {
    public CardFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_card, container, false);

        // Init recycler view
        final RecyclerView recyclerView = view.findViewById(R.id.recyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Load data
        if (cards == null) {
            SchoolIdolApi schoolIdolApi = ApiHelper.getRetrofitInstance().create(SchoolIdolApi.class);
            Call<CardResponse> cardResponseCall = schoolIdolApi.getCards(25, 1, "UR");
            cardResponseCall.enqueue(new Callback<CardResponse>() {
                @Override
                public void onResponse(Call<CardResponse> call, Response<CardResponse> response) {
                    if (response.isSuccessful()) {
                        CardResponse cardResponse = response.body();

                        if (cardResponse != null) {
                            CardFragment.this.cards = cardResponse;
                            updateAdapter(recyclerView);
                        }
                    }
                }

                @Override
                public void onFailure(Call<CardResponse> call, Throwable t) {
                    Log.d("npad93.pm.t6", "onFailure", t);
                    Toast.makeText(getActivity(), "Failed: " + t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        } else {
            updateAdapter(recyclerView);
        }

        return view;
    }

    @Override
    public void onClick(int i) {
        // TODO intent
    }

    private void updateAdapter(RecyclerView recyclerView) {
        recyclerView.setAdapter(new CardAdapter(cards.getResults(), this));
    }

    private CardResponse cards;
}
