package com.example.foster;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StartingWorkoutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StartingWorkoutFragment extends Fragment {
    String value;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public StartingWorkoutFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StartingWorkoutFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StartingWorkoutFragment newInstance(String param1, String param2) {
        StartingWorkoutFragment fragment = new StartingWorkoutFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        SpecificExerciseActivity specificExerciseActivity = (SpecificExerciseActivity) getActivity();
        value = specificExerciseActivity.getCondition();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
//        setExerciseTextAndImage();
        return inflater.inflate(R.layout.fragment_starting_workout, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        View view = inflater.inflate(R.layout.fragment_starting_workout, container, false);
        firstTV = view.findViewById(R.id.TVFirstExercise);
        secondTV = view.findViewById(R.id.TVSecondExercise);
        thirdTV = view.findViewById(R.id.TVThirdExercise);
        fourthTV = view.findViewById(R.id.TVFourthExercise);
        fifthTV = view.findViewById(R.id.TVFifthExercise);
        firstIV = view.findViewById(R.id.IVFirstExercise);
        secondIV = view.findViewById(R.id.IVSecondExercise);
        thirdIV = view.findViewById(R.id.IVThirdExercise);
        fourthIV = view.findViewById(R.id.IVFourthExercise);
        fifthIV = view.findViewById(R.id.IVFifthExercise);
        setExerciseTextAndImage();

    }

    private TextView firstTV,
            secondTV,
            thirdTV,
            fourthTV,
            fifthTV;
    private ImageView firstIV,
            secondIV,
            thirdIV,
            fourthIV,
            fifthIV;
//    HashMap<String,> hashMap = new HashMap<>();


    public void setExerciseTextAndImage() {
        TextView[] tvArr = {firstTV, secondTV, thirdTV, fourthTV, fifthTV};
        ImageView[] ivArr = {firstIV, secondIV, thirdIV, fourthIV, fifthIV};
        //    BEGINNER_DAY_1("Jumping jacks", " Push-ups", "Lunges", " Plank", "Bicycle crunches"),
        int[] beginnerDay1 = {R.drawable.img_jumpingjack,R.drawable.img_pushup,R.drawable.img_lunges,R.drawable.img_plank,R.drawable.img_bcrucnhes};
        Object[] array;
//        Bundle b = this.getArguments();
//        String value = b.getString("key");
//        switch (value) {
//            case "beginner_day1":
//                array = ExerciseEnum.BEGINNER_DAY_1.getExercises().values().toArray();
//                break;
//            case "beginner_day2":
//                array = ExerciseEnum.BEGINNER_DAY_2.getExercises().values().toArray();
//                break;
//            case "beginner_day3":
//                array = ExerciseEnum.BEGINNER_DAY_3.getExercises().values().toArray();
//                break;
//            case "beginner_day4":
//                array = ExerciseEnum.BEGINNER_DAY_4.getExercises().values().toArray();
//                break;
//            case "beginner_day5":
//                array = ExerciseEnum.BEGINNER_DAY_5.getExercises().values().toArray();
//                break;
//            case "beginner_day6":
//                array = ExerciseEnum.BEGINNER_DAY_6.getExercises().values().toArray();
//                break;
//            case "beginner_day7":
//                array = ExerciseEnum.BEGINNER_DAY_7.getExercises().values().toArray();
//                break;
//            default:
//                array = ExerciseEnum.BEGINNER_DAY_1.getExercises().values().toArray();
//
//        }
        Map<String, int[]> exerciseImage = new HashMap<>();

//        exerciseImage.put("beginner_day1", )
        Map<String, Map<String, String>> exerciseText = new HashMap<>();
        exerciseText.put("beginner_day1", ExerciseEnum.BEGINNER_DAY_1.getExercises());
        exerciseText.put("beginner_day2", ExerciseEnum.BEGINNER_DAY_2.getExercises());
        exerciseText.put("beginner_day3", ExerciseEnum.BEGINNER_DAY_3.getExercises());
        exerciseText.put("beginner_day4", ExerciseEnum.BEGINNER_DAY_4.getExercises());
        exerciseText.put("beginner_day5", ExerciseEnum.BEGINNER_DAY_5.getExercises());
        exerciseText.put("beginner_day6", ExerciseEnum.BEGINNER_DAY_6.getExercises());
        exerciseText.put("beginner_day7", ExerciseEnum.BEGINNER_DAY_7.getExercises());
        Map<String, String> chosenExerciseMap = exerciseText.get(value);
        // Then, to retrieve the values for a given key:
        array = chosenExerciseMap.values().toArray();
        for (int i = 0; i < chosenExerciseMap.size(); i++) {
            tvArr[i].setText((String) array[i]);
            ivArr[i].setImageResource(beginnerDay1[i]);
        }
    }
}

class ExerciseObject {
    TextView textView;
    ImageView imageView;


}