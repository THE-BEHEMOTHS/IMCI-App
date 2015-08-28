package org.chai.imci.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.chai.imci.R;
import org.chai.imci.treatthechild.oral_drugs.Oral_Antibiotic;

public class Immunization_Table extends Fragment {
    Intent intent;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater
                .inflate(R.layout.immunization_table, container, false);

        Button button = (Button) rootView.findViewById(R.id.view_immunization_tbl);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Oral_Antibiotic.class);
                intent.putExtra("Position", 3);
                startActivity(intent);
            }
        });
        return rootView;
    }

}
