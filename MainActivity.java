package vinayak.enigma;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick1(View v)
    {
        EditText t1=(EditText)findViewById(R.id.editText2);
        String s = String.valueOf(t1.getText());
        Encrypt enc=new Encrypt((String) s);
        enc.Encryptit();
        String x=enc.Display();
        t1.setText(x);


    }

    public void onButtonClick2(View v)
    {
        EditText t1=(EditText)findViewById(R.id.editText2);
        String p = String.valueOf(t1.getText());
        Decrypt decrypt=new Decrypt(p);
        decrypt.Decryptit();
        String y=decrypt.Display();
        t1.setText(y);

    }

    public void onButtonClick3(View v)
    {
        EditText t1=(EditText)findViewById(R.id.editText2);
        String q = String.valueOf(t1.getText());
        Intent sendIntent=new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,q);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);

    }

    public void onButtonClick4(View v)
    {
        EditText t1=(EditText)findViewById(R.id.editText2);
        ClipboardManager myClipboard;
        myClipboard=(ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        ClipData abc=myClipboard.getPrimaryClip();
        ClipData.Item item=abc.getItemAt(0);
        String text =item.getText().toString();
        t1.setText(text);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
