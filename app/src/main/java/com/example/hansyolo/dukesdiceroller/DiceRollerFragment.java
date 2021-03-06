package com.example.hansyolo.dukesdiceroller;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.widget.Toast;

import com.example.hansyolo.dukesdiceroller.listeners.OnSwipeTouchListener;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DiceRollerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DiceRollerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DiceRollerFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    GestureDetector gestureScanner;

    public DiceRollerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DiceRollerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DiceRollerFragment newInstance(String param1, String param2) {
        DiceRollerFragment fragment = new DiceRollerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dice_roller, container, false);

        v.setOnTouchListener(new OnSwipeTouchListener(getActivity().getApplicationContext()) {
            @Override
            public void onSwipeDown() {
                Toast.makeText(getActivity(), "Down", Toast.LENGTH_SHORT).show();
            }

            public void onSwipeLeft() {
                ImageView imageView = (ImageView)getView().findViewById(R.id.die_view);
                imageView.setImageResource(R.drawable.ic_check_box_outline_blank_black_24dp);
            }

            public void onSwipeRight() {
                ImageView imageView = (ImageView)getView().findViewById(R.id.die_view);
                imageView.setImageResource(R.drawable.ic_noun_dice_10653);
            }
        });
        
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
