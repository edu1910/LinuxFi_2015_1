package br.com.ceducarneiro.exerciciofinal.view;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import br.com.ceducarneiro.exerciciofinal.R;
import br.com.ceducarneiro.exerciciofinal.model.Book;
import butterknife.Bind;
import butterknife.ButterKnife;

public class EditBookActivity extends ActionBarActivity {

    public static final String KEY_BOOK_ID = "book_id";
    private Book book;

    @Bind(R.id.edtTitle)
    EditText edtTitle;
    @Bind(R.id.edtDescription)
    EditText edtDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_book);

        ButterKnife.bind(this);

        Long bookId = getIntent().getLongExtra(KEY_BOOK_ID, 0);
        book = Book.findById(Book.class, bookId);

        if (book == null) {
            finish();
        } else {
            edtTitle.setText(book.getTitle());
            edtDescription.setText(book.getDescription());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit_book, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_save) {
            book.setTitle(edtTitle.getText().toString());
            book.setDescription(edtDescription.getText().toString());
            book.setModified(true);
            book.save();
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
