package br.com.ceducarneiro.exerciciofinal.view;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

import br.com.ceducarneiro.exerciciofinal.model.Book;

public class BookAdapter extends ArrayAdapter<Book> {

    public BookAdapter(Context context, int resource, List<Book> objects) {
        super(context, resource, objects);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }
}
