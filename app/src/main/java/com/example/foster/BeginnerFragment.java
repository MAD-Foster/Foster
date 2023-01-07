package com.example.foster;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BeginnerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BeginnerFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BeginnerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BeginnerTopFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BeginnerFragment newInstance(String param1, String param2) {

        BeginnerFragment fragment = new BeginnerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_beginner,container,false);
        ImageView img=view.findViewById(R.id.GO_beginner_day1);
        img.setOnClickListener(view1 -> {
            System.out.println(12312);
            Fragment startWorkout=new StartingWorkoutFragment();
            FragmentTransaction fm=getActivity().getSupportFragmentManager().beginTransaction();
            fm.replace(R.id.NHFSpecificExercise,startWorkout).commit();
        });
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_beginner, container, false);

    }

//    ImageView IVDay1, IVDay2, IVDay3, IVDay4, IVDay5, IVDay6, IVDay7;
//
//    @Override
//    public void onViewCreated(View view, Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        IVDay1 = view.findViewById(R.id.GO_beginner_day1);
//        IVDay2 = view.findViewById(R.id.GO_beginner_day2);
//        IVDay3 = view.findViewById(R.id.GO_beginner_day3);
//        IVDay4 = view.findViewById(R.id.GO_beginner_day4);
//        IVDay5 = view.findViewById(R.id.GO_beginner_day5);
//        IVDay6 = view.findViewById(R.id.GO_beginner_day6);
//        IVDay7 = view.findViewById(R.id.GO_beginner_day7);
//        IVDay1.setOnClickListener(this);
//    }

//    @Override
//    public void onClick(View v) {
//        System.out.println("test");
//        switch (v.getId()) {
//            case R.id.GO_beginner_day1:
//                loadFragment(new StartingWorkoutFragment());
//                break;
//
//        }

//    }

//    public void loadFragment(View v) {
//        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
////frame_container is your layout name in xml file
//        transaction.replace(R.id.NHFSpecificExercise,new StartingWorkoutFragment());
//        transaction.addToBackStack(null);
//        transaction.commit();
//    }
}


