package com.example.snacktrack.explore.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.snacktrack.R;
import com.example.snacktrack.explore.model.CategoriesList;
import com.example.snacktrack.explore.presenter.ExplorePresenter;
import com.example.snacktrack.explore.presenter.ExploreView;
import com.example.snacktrack.explore.view.adapter.CategoriesAdapter;

public class ExploreFragment extends Fragment implements ExploreView {
    ExplorePresenter explorePresenter ;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.explore_fragment, container, false);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView= view.findViewById(R.id.recyclerView);
        explorePresenter= new ExplorePresenter(this);
        explorePresenter.getCategoriesRepository();
    }

    @Override
    public void showCategoriesList(CategoriesList categoriesList) {
        CategoriesAdapter categoriesAdapter= new CategoriesAdapter(categoriesList.categories, category->{
       // ExploreFragmentDirections.exploreToCategoryListExpanded(category);
            NavHostFragment.findNavController(this).navigate(ExploreFragmentDirections.exploreToCategoryListExpanded(category));
        });
        recyclerView.setAdapter(categoriesAdapter);
    }
}
