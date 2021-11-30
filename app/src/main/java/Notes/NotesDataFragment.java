package Notes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import ru.lukmanov.noteswork.R;

public class NotesDataFragment extends Fragment {
    public static final String ARG_INDEX = "index";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes_data, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            int index = arguments.getInt(ARG_INDEX);
            initNote(index);
            initData(view, index);
        }
    }
    private void initNote(int index){
        Notes note = new Notes();
        note.setTitle(getResources().getStringArray(R.array.notes)[index]);
        note.setContent(getResources().getStringArray(R.array.notes_content)[index]);
        note.setDate(getResources().getStringArray(R.array.notes_date)[index]);
        note.setPlace(getResources().getStringArray(R.array.notes_place)[index]);
    }
    private void initData(View view, int index) {
        TextView title = view.findViewById(R.id.note_title);
        title.setText(Notes.getTitle());
        TextView cont = view.findViewById(R.id.note_content);
        cont.setText(Notes.getContent());
        TextView dat = view.findViewById(R.id.note_date);
        dat.setText(Notes.getDate());
        TextView plac = view.findViewById(R.id.note_place);
        plac.setText(Notes.getPlace());
    }
    // Фабричный метод создания фрагмента
// Фрагменты рекомендуется создавать через фабричные методы
    public static NotesDataFragment newInstance(int index) {
// Создание фрагмента
        NotesDataFragment fragment = new NotesDataFragment();
// Передача параметра через бандл
        Bundle args = new Bundle();
        args.putInt(ARG_INDEX, index);
        fragment.setArguments(args);
        return fragment;
    }
}