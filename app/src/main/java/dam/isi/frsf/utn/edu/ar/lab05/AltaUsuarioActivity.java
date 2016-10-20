package dam.isi.frsf.utn.edu.ar.lab05;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class AltaUsuarioActivity extends AppCompatActivity {

    //EditText mName;
    EditText mEmailAddress;
    EditText mPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_usuario);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //mName = (EditText) findViewById(R.id.editName);
        mEmailAddress = (EditText) findViewById(R.id.editEmail);
        mPhoneNumber = (EditText) findViewById(R.id.editPhone);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                agregarUsuario();
            }
        });
    }

    private void agregarUsuario(){
        // Creates a new Intent to insert a contact
        Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
        // Sets the MIME type to match the Contacts Provider
        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

        // Inserts a name
        intent//.putExtra(ContactsContract.Intents.Insert.NAME, mName.getText())

            // Inserts an email address
            /*
             * In this example, sets the email type to be a work email.
             * You can set other email types as necessary.
             */
            .putExtra(ContactsContract.Intents.Insert.EMAIL, mEmailAddress.getText())
            .putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE, ContactsContract.CommonDataKinds.Email.TYPE_WORK)


            .putExtra(ContactsContract.Intents.Insert.PHONE, mPhoneNumber.getText())
            .putExtra(ContactsContract.Intents.Insert.PHONE_TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_WORK);

        //Sends the Intent
        startActivity(intent);
    }

}
