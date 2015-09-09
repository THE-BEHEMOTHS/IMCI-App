package org.chai.imci.treatchild;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.chai.imci.R;

public class TreatTheChildActivity extends Activity implements View.OnClickListener {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatthechild);

        findViewById(R.id.two_months).setOnClickListener(this);
        findViewById(R.id.sixty_months).setOnClickListener(this);

    }

    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        System.out.println("----Fragmentactivity---onStart---");
        overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.two_months:
                intent = new Intent(TreatTheChildActivity.this,
                        Oral_Drugs_0_2_At.class);
                startActivity(intent);

                break;
            case R.id.sixty_months:
                intent = new Intent(TreatTheChildActivity.this,
                        Oral_Drugs_2_60_At.class);
                startActivity(intent);
                break;
        }
    }
}

