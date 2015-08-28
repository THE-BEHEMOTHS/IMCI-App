package org.chai.imci.assessment;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import org.chai.imci.assessment.fragment.Diagnosing_Ear_Infection;
import org.chai.imci.assessment.fragment.Signs_EarProblem;
import org.chai.imci.assessment.fragment.Treatment_EarProblem;

public class TabsPagerAdapterEarproblem extends FragmentPagerAdapter {

	public TabsPagerAdapterEarproblem(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			
			return new Diagnosing_Ear_Infection();
		case 1:
			
			return new Signs_EarProblem();
		case 2:
			
			return new Treatment_EarProblem();
		}

		return null;
	}

	@Override
	public int getCount() {
		// get item count - equal to number of tabs
		return 3;
	}

}
