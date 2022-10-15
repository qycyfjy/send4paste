package f4.simpletools.send4paste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        finish();

        if(getIntent() != null && getIntent().getAction().equals(Intent.ACTION_SEND)) {
            String received = getIntent().getStringExtra(Intent.EXTRA_TEXT);
            if(received == null || received.isEmpty()) {
                return;
            }
            ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            if(cm != null) {
                ClipData data = ClipData.newPlainText("", received);
                cm.setPrimaryClip(data);
            }
        }
    }
}