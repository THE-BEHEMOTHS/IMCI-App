package org.ministryofhealth.imci.assessment.fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.ministryofhealth.imci.R;
import org.ministryofhealth.imci.assessment.model.Product;
import org.ministryofhealth.imci.assessment.model.Product.SubCategory;
import org.ministryofhealth.imci.assessment.model.Product.SubCategory.ItemList;

import java.util.ArrayList;

public class IDTreatment_Diarrhoea extends Fragment {

    private ArrayList<Product> pProductArrayList;
    private ArrayList<SubCategory> pSubItemArrayList;
    private ArrayList<SubCategory> pSubItemArrayList2;
    private ArrayList<SubCategory> pSubItemArrayList3;
    private LinearLayout mLinearListView;
    boolean isFirstViewClick = false;
    boolean isSecondViewClick = false;
    String signsSevereDehydration, signsSomeDehydration, signsnoDehydration,
            signsSeverePersistent, signsPeristentDiarrhoea,signsDysentry;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.universal_indicator,
                container, false);
        // mLinearListView = (LinearLayout) findViewById(R.id.linear_listview);
        mLinearListView = (LinearLayout) rootView
                .findViewById(R.id.linear_listview);
        /*
         * Declaration of String variables
		 */
        signsSevereDehydration = getString(R.string.severe_dehydration);
        signsSomeDehydration = getString(R.string.some_dehydration_treatment);
        signsnoDehydration = getString(R.string.no_dehydration_treatment);
        signsSeverePersistent = getString(R.string.severe_persistent_diarrhoea_treatment);
        signsPeristentDiarrhoea = getString(R.string.persistent_diarrhoea_treatment);
        signsDysentry = getString(R.string.dysentry_treatment);

		/*
		 * Third level String variables
		 */
        ArrayList<ItemList> mItemListArray = new ArrayList<ItemList>();
        mItemListArray.add(new ItemList("", signsSevereDehydration));

        ArrayList<ItemList> mItemListArray2 = new ArrayList<ItemList>();
        mItemListArray2.add(new ItemList("", signsSomeDehydration));

        ArrayList<ItemList> mItemListArray3 = new ArrayList<ItemList>();
        mItemListArray3.add(new ItemList("", signsnoDehydration));

        ArrayList<ItemList> mItemListArrayP1 = new ArrayList<ItemList>();
        mItemListArrayP1.add(new ItemList("", signsSeverePersistent));

        ArrayList<ItemList> mItemListArrayP2 = new ArrayList<ItemList>();
        mItemListArrayP2.add(new ItemList("", signsPeristentDiarrhoea));

        ArrayList<ItemList> mItemListArrayP3 = new ArrayList<ItemList>();
        mItemListArrayP3.add(new ItemList("", signsDysentry));


        /**
         * Second Level list items
         */
        pSubItemArrayList = new ArrayList<SubCategory>();
        pSubItemArrayList2 = new ArrayList<SubCategory>();
        pSubItemArrayList3 = new ArrayList<SubCategory>();

        pSubItemArrayList.add(new SubCategory("SEVERE DEHYDRATION", mItemListArray));
        pSubItemArrayList.add(new SubCategory("SOME DEHYDRATION", mItemListArray2));
        pSubItemArrayList.add(new SubCategory("NO DEHYDRATION", mItemListArray3));


        pSubItemArrayList2.add(new SubCategory("SEVERE PERSISTENT DIARRHOEA", mItemListArrayP1));
        pSubItemArrayList2.add(new SubCategory("PERSISTENT DIARRHOEA", mItemListArrayP2));

        pSubItemArrayList3.add(new SubCategory("DYSENTERY", mItemListArrayP3));

        pProductArrayList = new ArrayList<Product>();
        pProductArrayList.add(new Product("for DEHYDRATION", pSubItemArrayList));
        pProductArrayList.add(new Product("if diarrhoea is 14 days or more", pSubItemArrayList2));
        pProductArrayList.add(new Product("if blood in the stool", pSubItemArrayList3));

        /***
         * adding item into listview
         */
        for (int i = 0; i < pProductArrayList.size(); i++) {

            inflater = (LayoutInflater) getActivity().getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            View mLinearView = inflater.inflate(R.layout.row_first, null);

            final TextView mProductName = (TextView) mLinearView.findViewById(R.id.textViewName);
            final RelativeLayout mLinearFirstArrow = (RelativeLayout) mLinearView.findViewById(R.id.linearFirst);
            final ImageView mImageArrowFirst = (ImageView) mLinearView.findViewById(R.id.imageFirstArrow);
            final LinearLayout mLinearScrollSecond = (LinearLayout) mLinearView.findViewById(R.id.linear_scroll);

            if (isFirstViewClick == false) {
                // Off View becomes invisible
                mLinearScrollSecond.setVisibility(View.GONE);
				
				/*
				 * if the button is clicked a second or first time
				 * If it is clicked a first time the switch boolean goes on the if pressed again the 
				 * switch boolean goes off
				 * Let's start from off to on 
				 * Off is false when clicked it is supposed to go on.
				 * */
                mImageArrowFirst.setBackgroundResource(R.drawable.arrow_points_right);
            } else {
                // On view becomes visible
                mLinearScrollSecond.setVisibility(View.VISIBLE);
                mImageArrowFirst.setBackgroundResource(R.drawable.arrow_points_down);
            }
            mLinearFirstArrow.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    if (isFirstViewClick == false) {
                        isFirstViewClick = true;
                        mImageArrowFirst
                                .setBackgroundResource(R.drawable.arrow_points_down);
                        mLinearScrollSecond.setVisibility(View.VISIBLE);

                    } else {
                        isFirstViewClick = false;
                        mImageArrowFirst
                                .setBackgroundResource(R.drawable.arrow_points_right);
                        mLinearScrollSecond.setVisibility(View.GONE);
                    }
                }
            });
/*
			mLinearFirstArrow.setOnTouchListener(new OnTouchListener() {

				@Override
				public boolean onTouch(View v, MotionEvent event) {

					if (isFirstViewClick == false) {
						isFirstViewClick = true;
						mImageArrowFirst
								.setBackgroundResource(R.drawable.arrow_right);
						mLinearScrollSecond.setVisibility(View.VISIBLE);

					} else {
						isFirstViewClick = false;
						mImageArrowFirst
								.setBackgroundResource(R.drawable.arrow_right);
						mLinearScrollSecond.setVisibility(View.GONE);
					}
					return false;
				}
			});
*/
            final String name = pProductArrayList.get(i).getpName();
            mProductName.setText(name);

            /**
             *
             */
            for (int j = 0; j < pProductArrayList.get(i).getmSubCategoryList()
                    .size(); j++) {

                inflater = (LayoutInflater) getActivity().getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
                View mLinearView2 = inflater.inflate(R.layout.row_second, null);
                if (j == 0) {
                    mLinearView2.setBackgroundColor((Color
                            .parseColor("#ff69b4")));
                }
                if (j == 1) {
                    mLinearView2.setBackgroundColor((Color
                            .parseColor("#FFFF00")));

                }
                if (j == 2) {
                    mLinearView2.setBackgroundColor((Color
                            .parseColor("#90EE90")));

                }
                TextView mSubItemName = (TextView) mLinearView2
                        .findViewById(R.id.textViewTitle);
                final RelativeLayout mLinearSecondArrow = (RelativeLayout) mLinearView2
                        .findViewById(R.id.linearSecond);
                final ImageView mImageArrowSecond = (ImageView) mLinearView2
                        .findViewById(R.id.imageSecondArrow);
                final LinearLayout mLinearScrollThird = (LinearLayout) mLinearView2
                        .findViewById(R.id.linear_scroll_third);
                if (j == 0) {
                    mLinearView2.setBackgroundColor((Color
                            .parseColor("#ff69b4")));
                    mSubItemName.setBackgroundColor((Color
                            .parseColor("#ff69b4")));
                    mLinearSecondArrow.setBackgroundColor((Color
                            .parseColor("#ff69b4")));
                    mLinearScrollThird.setBackgroundColor((Color
                            .parseColor("#ff69b4")));

                }
                if (j == 1) {
                    mLinearView2.setBackgroundColor((Color
                            .parseColor("#FFFF00")));
                    mSubItemName.setBackgroundColor((Color
                            .parseColor("#FFFF00")));
                    mLinearSecondArrow.setBackgroundColor((Color
                            .parseColor("#FFFF00")));
                    mLinearScrollThird.setBackgroundColor((Color
                            .parseColor("#FFFF00")));

                }
                if (j == 2) {
                    mLinearView2.setBackgroundColor((Color
                            .parseColor("#90EE90")));
                    mSubItemName.setBackgroundColor((Color
                            .parseColor("#90EE90")));
                    mLinearSecondArrow.setBackgroundColor((Color
                            .parseColor("#90EE90")));
                    mLinearScrollThird.setBackgroundColor((Color
                            .parseColor("#90EE90")));

                }

                if (isSecondViewClick == false) {
                    mLinearScrollThird.setVisibility(View.GONE);
                    mImageArrowSecond
                            .setBackgroundResource(R.drawable.arrow_points_right);
                } else {
                    mLinearScrollThird.setVisibility(View.VISIBLE);
                    mImageArrowSecond
                            .setBackgroundResource(R.drawable.arrow_points_down);
                }

                mLinearSecondArrow.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        if (isSecondViewClick == false) {
                            isSecondViewClick = true;
                            // mLinearFirstArrow.setBackgroundColor(Color.parseColor("#FF0000"));
                            mImageArrowSecond
                                    .setBackgroundResource(R.drawable.arrow_points_down);
                            mLinearScrollThird.setVisibility(View.VISIBLE);

                        } else {
                            isSecondViewClick = false;
                            mImageArrowSecond
                                    .setBackgroundResource(R.drawable.arrow_points_right);
                            mLinearScrollThird.setVisibility(View.GONE);
                        }
                    }
                });
			/*	mLinearSecondArrow.setOnTouchListener(new OnTouchListener() {

					@Override
					public boolean onTouch(View v, MotionEvent event) {

						if (isSecondViewClick == false) {
							isSecondViewClick = true;
							// mLinearFirstArrow.setBackgroundColor(Color.parseColor("#FF0000"));
							mImageArrowSecond
									.setBackgroundResource(R.drawable.arrow_down);
							mLinearScrollThird.setVisibility(View.VISIBLE);

						} else {
							isSecondViewClick = false;
							mImageArrowSecond
									.setBackgroundResource(R.drawable.arrow_right);
							mLinearScrollThird.setVisibility(View.GONE);
						}
						return false;
					}
				});
*/
                final String catName = pProductArrayList.get(i)
                        .getmSubCategoryList().get(j).getpSubCatName();
                mSubItemName.setText(catName);
                /**
                 *
                 */
                for (int k = 0; k < pProductArrayList.get(i)
                        .getmSubCategoryList().get(j).getmItemListArray()
                        .size(); k++) {

                    inflater = (LayoutInflater) getActivity().getSystemService(
                            Context.LAYOUT_INFLATER_SERVICE);
                    View mLinearView3 = inflater.inflate(R.layout.row_third,
                            null);
                    if (j == 0) {
                        mLinearView3.setBackgroundColor((Color
                                .parseColor("#ff69b4")));
                    }
                    if (j == 1) {
                        mLinearView3.setBackgroundColor((Color
                                .parseColor("#FFFF00")));

                    }
                    if (j == 2) {
                        mLinearView3.setBackgroundColor((Color
                                .parseColor("#90EE90")));

                    }
                    TextView mItemName = (TextView) mLinearView3
                            .findViewById(R.id.textViewItemName);
                    TextView mItemPrice = (TextView) mLinearView3
                            .findViewById(R.id.textViewItemPrice);
                    final String itemName = pProductArrayList.get(i)
                            .getmSubCategoryList().get(j).getmItemListArray()
                            .get(k).getItemName();
                    final String itemPrice = pProductArrayList.get(i)
                            .getmSubCategoryList().get(j).getmItemListArray()
                            .get(k).getItemPrice();
                    mItemName.setText(itemName);
                    mItemPrice.setText(itemPrice);

                    mLinearScrollThird.addView(mLinearView3);
                }

                mLinearScrollSecond.addView(mLinearView2);

            }


            mLinearListView.addView(mLinearView);
        }

        return rootView;
    }
}
