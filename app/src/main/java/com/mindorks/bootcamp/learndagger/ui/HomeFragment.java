package com.mindorks.bootcamp.learndagger.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mindorks.bootcamp.learndagger.MyApplication;
import com.mindorks.bootcamp.learndagger.R;
import com.mindorks.bootcamp.learndagger.di.component.DaggerFragmentComponent;
import com.mindorks.bootcamp.learndagger.di.module.FragmentModule;

import javax.inject.Inject;


public class HomeFragment extends Fragment {

    @Inject
    HomeViewModel homeViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDependencies();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tv = getView().findViewById(R.id.tvTextView);
        tv.setText(homeViewModel.getSomeData());
    }

    private void getDependencies() {
        /*  We are doing .applicationComponent() bcoz i think Fragment component is
         *  dependent on application component
         */
        DaggerFragmentComponent
                .builder()
                .applicationComponent(((MyApplication) getContext().getApplicationContext())
                        .applicationComponent)
                .fragmentModule(new FragmentModule(this))
                .build()
                .inject(this);
    }
}
