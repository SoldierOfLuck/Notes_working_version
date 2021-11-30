package ru.lukmanov.noteswork;

import static Notes.NotesDataFragment.ARG_INDEX;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import Notes.NotesDataFragment;


public class AppDataFragment extends Fragment {

    private static final String CURRENT_NOTE = "CurrentNote";
    // Текущая позиция (выбранный город)
    private int currentPosition = 0;
    // При создании фрагмента укажем его макет
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_app_data, container, false);
    }
    // Этот метод вызывается, когда макет экрана создан и готов к отображению информации
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Восстановление текущей позиции
        if (savedInstanceState != null) {
            currentPosition = savedInstanceState.getInt(CURRENT_NOTE, 0);
        }
        initList(view);
        // отображение открытой заметки в ландшафтной ориентации
        if (isLandscape()) {
            showDataLand(currentPosition);
        }
    }
    private void initList(View view) {
        LinearLayout layoutView = (LinearLayout) view;
            TextView tv = new TextView(getContext());
            tv.setText("Сведение о приложении");
            tv.setTextSize(30);
            layoutView.addView(tv);
    }

    private void showData(int index) {
        if (isLandscape()) {
            showDataLand(index);
        } else {
            showDataPort(index);
        }
    }
    private void showDataPort(int index) {
        Activity activity = requireActivity();
        final Intent intent = new Intent(activity, NoteActivity.class);
        intent.putExtra(ARG_INDEX, index);
        activity.startActivity(intent);
    }
    private void showDataLand(int index) {
// Создаём новый фрагмент с текущей позицией для вывода герба
        NotesDataFragment detail = NotesDataFragment.newInstance(index);
// Выполняем транзакцию по замене фрагмента
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_data_container, detail); //замена фрагмента
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(CURRENT_NOTE, currentPosition);
        super.onSaveInstanceState(outState);
    }
    private boolean isLandscape() {
        return getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }
}