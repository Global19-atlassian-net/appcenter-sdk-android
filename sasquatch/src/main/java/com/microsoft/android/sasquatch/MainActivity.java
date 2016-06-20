package com.microsoft.android.sasquatch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.microsoft.android.AvalancheHub;
import com.microsoft.android.utils.AvalancheLog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button mCrashButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AvalancheHub.use(getApplication());


        boolean crashManagerAvailable = AvalancheHub.isFeatureAvailable(AvalancheHub.FEATURE_CRASH);

        AvalancheLog.info("crash available: " + crashManagerAvailable);

        boolean crashManagerEnabled = AvalancheHub.getSharedInstance().isFeatureEnabled(AvalancheHub.FEATURE_CRASH);

        AvalancheLog.info("crash enabled: " + crashManagerEnabled);

        mCrashButton = (Button) findViewById(R.id.button_crash);
        mCrashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> fakeList = new ArrayList<>();
                fakeList.get(1000);
            }
        });
    }
}
