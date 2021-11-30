package ru.lukmanov.noteswork;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import Notes.NotesDataFragment;
import static Notes.NotesDataFragment.ARG_INDEX;

public class NoteActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        if (getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_LANDSCAPE) {
// Если устройство перевернули в альбомную ориентацию, то надо эту activity закрыть
            finish();
            return;
        }
// Если эта activity запускается первый раз (с каждым новым гербом первый раз),
// то перенаправим параметр фрагменту и запустим фрагмент
        if (savedInstanceState == null)
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.coat_of_arms_fragment_container,
                            NotesDataFragment.newInstance(getIntent().getExtras().getInt(ARG_INDEX))).commit();
    }
}