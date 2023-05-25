package com.example.app_test_user.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.app_test_user.R;
import com.example.app_test_user.TestResult;

public class TestResultFragment extends Fragment {

    private TestResult userTestResult;
    private TextView txtBasic, txtCollections, txtExceptions, txtOOP, txtOperators;

    private Button txtWork, txtAll;
    int r = 0;

    public TestResultFragment() {
        // Required empty public constructor
    }

    public TestResultFragment(TestResult testResult) {
        userTestResult = testResult;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_test_result_show, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        initView();
        int allPoints = userTestResult.getPointsAll();
        r = 0;
        txtAll.setText("Всего Вы набрали\n" + allPoints + " из 100 баллов");
        if (allPoints >= 85) {
            txtWork.setText("Поздравляем! Вы набрали впечатляющий балл! Исходя из результатов, которые Вы набрали в результате тестирования, " +
                    "мы можем предложить Вам продолжить собеседование на одну из следующих вакансий, связанных с Java:" +
                    "\n  - Juniuor-разработчик;" +
                    "\n  - Middle-разработчик;" +
                    "\n  - Senior-разработчик;");
        } else if (allPoints > 70 && allPoints < 85) {
            txtWork.setText("Поздравляем! Вы набрали впечатляющий балл! Исходя из результатов, которые Вы набрали в результате тестирования, " +
                    "мы можем предложить Вам продолжить собеседование на одну из следующих вакансий, связанных с Java:" +
                    "\n     - Juniuor-разработчик;" +
                    "\n     - Middle-разработчик;");
        } else if (allPoints > 50 && allPoints < 70) {
            txtWork.setText("Поздравляем! Вы набрали впечатляющий балл! Исходя из результатов, которые Вы набрали в результате тестирования, " +
                    "мы можем предложить Вам продолжить собеседование на следующую вакансию, связанную с Java:" +
                    "\n     - Juniuor-разработчик;");
        } else
            txtWork.setText("Вы набрали впечатляющий балл! Мы Вам перезвоним)))");


        txtBasic.setText("Раздел Basic\n" + userTestResult.getPointsBasic() + " из 20 баллов");
        txtCollections.setText("Раздел Colltctions\n" + userTestResult.getPointsCollections() + " из 20 баллов");
        txtExceptions.setText("Раздел Exceptions\n" + userTestResult.getPointsExceptions() + " из 20 баллов");
        txtOOP.setText("Раздел OOP\n" + userTestResult.getPointsOOP() + " из 20 баллов");
        txtOperators.setText("Раздел Operators\n" + userTestResult.getPointsOperators() + " из 20 баллов");

        txtBasic.setVisibility(View.GONE);
        txtCollections.setVisibility(View.GONE);
        txtExceptions.setVisibility(View.GONE);
        txtOOP.setVisibility(View.GONE);
        txtOperators.setVisibility(View.GONE);

        txtAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (r == 0) {
                    r = 1;
                    txtWork.setVisibility(View.GONE);
                    txtBasic.setVisibility(View.VISIBLE);
                    txtCollections.setVisibility(View.VISIBLE);
                    txtExceptions.setVisibility(View.VISIBLE);
                    txtOOP.setVisibility(View.VISIBLE);
                    txtOperators.setVisibility(View.VISIBLE);
                } else {
                    r = 0;
                    txtBasic.setVisibility(View.GONE);
                    txtCollections.setVisibility(View.GONE);
                    txtExceptions.setVisibility(View.GONE);
                    txtOOP.setVisibility(View.GONE);
                    txtOperators.setVisibility(View.GONE);
                    txtWork.setVisibility(View.VISIBLE);
                }

            }
        });


    }

    private void initView() {

        txtAll = (Button) getActivity().findViewById(R.id.tvAllPoints);
        txtWork = (Button) getActivity().findViewById(R.id.txtWork);
        txtBasic = (TextView) getActivity().findViewById(R.id.tvBasic);
        txtCollections = (TextView) getActivity().findViewById(R.id.tvCollections);
        txtExceptions = (TextView) getActivity().findViewById(R.id.tvExceptions);
        txtOOP = (TextView) getActivity().findViewById(R.id.tvOOP);
        txtOperators = (TextView) getActivity().findViewById(R.id.tvOperstors);

    }
}