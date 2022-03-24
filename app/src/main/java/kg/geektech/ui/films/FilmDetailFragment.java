package kg.geektech.ui.films;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import kg.geektech.android3.App;
import kg.geektech.android3.R;
import kg.geektech.android3.data.models.Film;
import kg.geektech.android3.databinding.FragmentFilmDetailBinding;
import kg.geektech.android3.databinding.FragmentFilmsBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FilmDetailFragment extends Fragment {
    private FragmentFilmDetailBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmDetailBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String id = getArguments().getString("id");
        App.api.getFilmDetail(id).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                if (response.isSuccessful()&& response.body() != null ){
                    Film film = response.body();
                    binding.tvTitle.setText(film.getTitle());
                    binding.tvDirector.setText(film.getDirector());
                    binding.tvProducer.setText(film.getProducer());
                    binding.tvData.setText(film.getReleaseDate());
                    binding.tvOrig.setText(film.getOriginalTitle());
                    Glide.with(requireActivity()).load(film.getMovieBanner()).into(binding.tvImage);

                }
            }
            @Override
            public void onFailure(Call<Film> call, Throwable t) {
            }
        });
    }
}