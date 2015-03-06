package com.chai.imci.Assessment;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.chai.imci.Assessment.Fragment.Diagnosing_0_2SpecialTreatments;
import com.chai.imci.Assessment.Fragment.Signs_0_2Special_Treatment;
import com.chai.imci.Assessment.Fragment.Treatment_0_2Special_Treatment;

public class TabsPagerAdapter0_2SpecialTreatment extends FragmentPagerAdapter {

	public TabsPagerAdapter0_2SpecialTreatment(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			// Top Rated fragment activity
			return new Diagnosing_0_2SpecialTreatments();
		case 1:
			// Games fragment activity
			return new Signs_0_2Special_Treatment();
		case 2:
			// Movies fragment activity
			return new Treatment_0_2Special_Treatment();
		}

		return null;
	}


	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 3;
	}

}
