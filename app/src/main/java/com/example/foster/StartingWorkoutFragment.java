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
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
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

        tv5min = view.findViewById(R.id.TV5MinFifthExercise);
        tvSets = view.findViewById(R.id.TVSetFifthExercise);
        tvStart = view.findViewById(R.id.TVStartFifthExercise);
        setExerciseTextAndImage();

    }

    private TextView tv5min, tvStart, tvSets;
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

        int[] beginnerDay1 = {R.drawable.img_jumpingjack, R.drawable.img_pushup, R.drawable.img_lunges, R.drawable.img_plank, R.drawable.img_bcrucnhes};

        int[] beginnerDay2 = {R.drawable.img_squat, R.drawable.img_tridips, R.drawable.img_burpees, R.drawable.img_sideplank, R.drawable.img_highknees};
        int[] beginnerDay3 = {R.drawable.img_boxjumps, R.drawable.img_stepups, R.drawable.img_russiantwist, R.drawable.img_legraises}; //4
        int[] beginnerDay4 = {R.drawable.img_pushup, R.drawable.img_squat, R.drawable.img_situps, R.drawable.img_mountain}; //4
        int[] beginnerDay5 = {R.drawable.img_plyojumps, R.drawable.img_revcrunches, R.drawable.img_heeltouchs, R.drawable.img_legraises}; //4
        int[] beginnerDay6 = {R.drawable.img_jumpingjack, R.drawable.img_pushup, R.drawable.img_lunges, R.drawable.img_plank, R.drawable.img_sideplank};
        int[] beginnerDay7 = {R.drawable.img_bcrucnhes, R.drawable.img_lunges, R.drawable.img_russiantwist, R.drawable.img_tridips, R.drawable.img_pushup};

        int[] intermediateDay1 = {R.drawable.img_pushup, R.drawable.img_benchpress, R.drawable.img_latpulls, R.drawable.img_tridips, R.drawable.img_bicepcurls};
        int[] intermediateDay2 = {R.drawable.img_squat, R.drawable.img_lunges, R.drawable.img_legpress, R.drawable.img_legcurls, R.drawable.img_calfraises};
        int[] intermediateDay3 = {R.drawable.img_burpees, R.drawable.img_boxjumps, R.drawable.img_highknees, R.drawable.img_mountain, R.drawable.img_tuckjumps};
        int[] intermediateDay4 = {R.drawable.img_deadlifts, R.drawable.img_stepups, R.drawable.img_glutebridges, R.drawable.img_hipthrusts, R.drawable.img_plank};
        int[] intermediateDay5 = {R.drawable.img_pushup, R.drawable.img_benchpress, R.drawable.img_latpulls, R.drawable.img_tridips, R.drawable.img_bicepcurls};
        int[] intermediateDay6 = {R.drawable.img_squat, R.drawable.img_lunges, R.drawable.img_legpress, R.drawable.img_legcurls, R.drawable.img_calfraises};
        int[] intermediateDay7 = {R.drawable.img_burpees, R.drawable.img_boxjumps, R.drawable.img_highknees, R.drawable.img_mountain, R.drawable.img_tuckjumps};

        int[] fatlossDay1 = {R.drawable.img_jumpingjack, R.drawable.img_highknees, R.drawable.img_buttkicks, R.drawable.img_plankjacks, R.drawable.img_sideshuffles};
        int[] fatlossDay2 = {R.drawable.img_mountain, R.drawable.img_squatjumps, R.drawable.img_lunges, R.drawable.img_skaters, R.drawable.img_burpees};
        int[] fatlossDay3 = {R.drawable.img_tuckjumps, R.drawable.img_boxjumps, R.drawable.img_jumpingjack, R.drawable.img_jumpropes, R.drawable.img_buttkicks};
        int[] fatlossDay4 = {R.drawable.img_highknees, R.drawable.img_jumpingjack, R.drawable.img_powerskips, R.drawable.img_plankjacks, R.drawable.img_sideshuffles};
        int[] fatlossDay5 = {R.drawable.img_squatjumps, R.drawable.img_lunges, R.drawable.img_mountain, R.drawable.img_skaters, R.drawable.img_burpees};
        int[] fatlossDay6 = {R.drawable.img_boxjumps, R.drawable.img_tuckjumps, R.drawable.img_jumpingjack, R.drawable.img_jumpropes, R.drawable.img_buttkicks};
        int[] fatlossDay7 = {R.drawable.img_highknees, R.drawable.img_jumpingjack, R.drawable.img_powerskips, R.drawable.img_plankjacks, R.drawable.img_sideshuffles};

        int[] expertDay1 = {R.drawable.img_plyopushups, R.drawable.img_benchpress, R.drawable.img_latpulls, R.drawable.img_tridips, R.drawable.img_bicepcurls};
        int[] expertDay2 = {R.drawable.img_squat, R.drawable.img_lunges, R.drawable.img_legpress, R.drawable.img_legcurls, R.drawable.img_legraises};
        int[] expertDay3 = {R.drawable.img_burpees, R.drawable.img_boxjumps, R.drawable.img_highknees, R.drawable.img_mountain, R.drawable.img_tuckjumps};
        int[] expertDay4 = {R.drawable.img_deadlifts, R.drawable.img_stepups, R.drawable.img_glutebridges, R.drawable.img_hipthrusts, R.drawable.img_plank};
        int[] expertDay5 = {R.drawable.img_plyopushups, R.drawable.img_benchpress, R.drawable.img_latpulls, R.drawable.img_tridips, R.drawable.img_bicepcurls};
        int[] expertDay6 = {R.drawable.img_squat, R.drawable.img_lunges, R.drawable.img_legpress, R.drawable.img_legcurls, R.drawable.img_legraises};
        int[] expertDay7 = {R.drawable.img_burpees, R.drawable.img_boxjumps, R.drawable.img_highknees, R.drawable.img_mountain, R.drawable.img_tuckjumps};

        Object[] arrayText;
        Object[] arrayImage;
        LinkedHashMap<String, int[]> exerciseImage = new LinkedHashMap<>();
        exerciseImage.put("beginner_day1", beginnerDay1);
        exerciseImage.put("beginner_day2", beginnerDay2);
        exerciseImage.put("beginner_day3", beginnerDay3);
        exerciseImage.put("beginner_day4", beginnerDay4);
        exerciseImage.put("beginner_day5", beginnerDay5);
        exerciseImage.put("beginner_day6", beginnerDay6);
        exerciseImage.put("beginner_day7", beginnerDay7);
        exerciseImage.put("intermediate_day1", intermediateDay1);
        exerciseImage.put("intermediate_day2", intermediateDay2);
        exerciseImage.put("intermediate_day3", intermediateDay3);
        exerciseImage.put("intermediate_day4", intermediateDay4);
        exerciseImage.put("intermediate_day5", intermediateDay5);
        exerciseImage.put("intermediate_day6", intermediateDay6);
        exerciseImage.put("intermediate_day7", intermediateDay7);
        exerciseImage.put("expert_day1", expertDay1);
        exerciseImage.put("expert_day2", expertDay2);
        exerciseImage.put("expert_day3", expertDay3);
        exerciseImage.put("expert_day4", expertDay4);
        exerciseImage.put("expert_day5", expertDay5);
        exerciseImage.put("expert_day6", expertDay6);
        exerciseImage.put("expert_day7", expertDay7);
        exerciseImage.put("fatloss_day1", fatlossDay1);
        exerciseImage.put("fatloss_day2", fatlossDay2);
        exerciseImage.put("fatloss_day3", fatlossDay3);
        exerciseImage.put("fatloss_day4", fatlossDay4);
        exerciseImage.put("fatloss_day5", fatlossDay5);
        exerciseImage.put("fatloss_day6", fatlossDay6);
        exerciseImage.put("fatloss_day7", fatlossDay7);

//        exerciseImage.put("beginner_day1", )
        LinkedHashMap<String, Map<String, String>> exerciseText = new LinkedHashMap<>();
        exerciseText.put("beginner_day1", ExerciseEnum.BEGINNER_DAY_1.getExercises());
        exerciseText.put("beginner_day2", ExerciseEnum.BEGINNER_DAY_2.getExercises());
        exerciseText.put("beginner_day3", ExerciseEnum.BEGINNER_DAY_3.getExercises());
        exerciseText.put("beginner_day4", ExerciseEnum.BEGINNER_DAY_4.getExercises());
        exerciseText.put("beginner_day5", ExerciseEnum.BEGINNER_DAY_5.getExercises());
        exerciseText.put("beginner_day6", ExerciseEnum.BEGINNER_DAY_6.getExercises());
        exerciseText.put("beginner_day7", ExerciseEnum.BEGINNER_DAY_7.getExercises());
        exerciseText.put("intermediate_day1", ExerciseEnum.INTERMEDIATE_DAY_1.getExercises());
        exerciseText.put("intermediate_day2", ExerciseEnum.INTERMEDIATE_DAY_2.getExercises());
        exerciseText.put("intermediate_day3", ExerciseEnum.INTERMEDIATE_DAY_3.getExercises());
        exerciseText.put("intermediate_day4", ExerciseEnum.INTERMEDIATE_DAY_4.getExercises());
        exerciseText.put("intermediate_day5", ExerciseEnum.INTERMEDIATE_DAY_5.getExercises());
        exerciseText.put("intermediate_day6", ExerciseEnum.INTERMEDIATE_DAY_6.getExercises());
        exerciseText.put("intermediate_day7", ExerciseEnum.INTERMEDIATE_DAY_7.getExercises());
        exerciseText.put("expert_day1", ExerciseEnum.EXPERT_DAY_1.getExercises());
        exerciseText.put("expert_day2", ExerciseEnum.EXPERT_DAY_2.getExercises());
        exerciseText.put("expert_day3", ExerciseEnum.EXPERT_DAY_3.getExercises());
        exerciseText.put("expert_day4", ExerciseEnum.EXPERT_DAY_4.getExercises());
        exerciseText.put("expert_day5", ExerciseEnum.EXPERT_DAY_5.getExercises());
        exerciseText.put("expert_day6", ExerciseEnum.EXPERT_DAY_6.getExercises());
        exerciseText.put("expert_day7", ExerciseEnum.EXPERT_DAY_7.getExercises());
        exerciseText.put("fatloss_day1", ExerciseEnum.FATLOSS_DAY_1.getExercises());
        exerciseText.put("fatloss_day2", ExerciseEnum.FATLOSS_DAY_2.getExercises());
        exerciseText.put("fatloss_day3", ExerciseEnum.FATLOSS_DAY_3.getExercises());
        exerciseText.put("fatloss_day4", ExerciseEnum.FATLOSS_DAY_4.getExercises());
        exerciseText.put("fatloss_day5", ExerciseEnum.FATLOSS_DAY_5.getExercises());
        exerciseText.put("fatloss_day6", ExerciseEnum.FATLOSS_DAY_6.getExercises());
        exerciseText.put("fatloss_day7", ExerciseEnum.FATLOSS_DAY_7.getExercises());

        Map<String, String> chosenExerciseMap = exerciseText.get(value);
        arrayText = chosenExerciseMap.values().toArray();

        int []chosenImagesArray=exerciseImage.get(value);
//        chosenExerciseMap = exerciseImage.get(value);
        // Then, to retrieve the values for a given key:
        arrayImage = chosenExerciseMap.values().toArray();
        for (int i = 0; i < chosenExerciseMap.size(); i++) {
            tvArr[i].setText((String) arrayText[i]);
            assert chosenImagesArray != null;
            ivArr[i].setImageResource(chosenImagesArray[i]);
        }
        if (ivArr.length > chosenExerciseMap.size()) {
            ivArr[4].setVisibility(View.GONE);
            tv5min.setVisibility(View.GONE);
            tvStart.setVisibility(View.GONE);
            tvSets.setVisibility(View.GONE);
        }
    }
}

class ExerciseObject {
    TextView textView;
    ImageView imageView;

    public ExerciseObject(TextView textView, ImageView imageView) {
        this.textView = textView;
        this.imageView = imageView;
    }
}