package org.ministryofhealth.imci.assessment.treatchild;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.ministryofhealth.imci.R;
import org.ministryofhealth.imci.assessment.counsel_mother.CareForDevelopmentUniversal;
import org.ministryofhealth.imci.assessment.counsel_mother.FeedingAdvice_NotBreastfeed;

/**
 * Created by InclusionOne on 9/21/2015.
 */
public class Young_Home_Care extends Activity {
    TextView txt;
    Button btn1, btn2;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActionBar().setHomeButtonEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setTitle("Advise mother on when to return");
        setContentView(R.layout.young_home_care);

        txt = (TextView) findViewById(R.id.textView10);
        // feeding advise on mother who has chosen not to breastfeed
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Young_Home_Care.this, FeedingAdvice_NotBreastfeed.class);
                startActivity(intent);
            }
        });
        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Young_Home_Care.this, CareForDevelopmentUniversal.class);
                intent.putExtra("CareForDevelopmentAndNvp", 15);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Young_Home_Care.this, CareForDevelopmentUniversal.class);
                intent.putExtra("CareForDevelopmentAndNvp", 16);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        System.out.println("----Fragmentactivity---onStart---");
        overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;

    }

}
