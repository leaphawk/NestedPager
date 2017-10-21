package com.leaphawk.nestedpager;

/**
 * Created by ghgf on 10/21/2017.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static com.leaphawk.nestedpager.R.layout.editor;

public class ChildPagerFragment extends Fragment {
    private static final String KEY_POSITION="position";

    static ChildPagerFragment newInstance(int position) {
        ChildPagerFragment frag=new ChildPagerFragment();
        Bundle args=new Bundle();

        args.putInt(KEY_POSITION, position);
        frag.setArguments(args);

        return(frag);
    }

    static String getTitle(Context ctxt, int position) {
        return(String.format("hint", position + 1));
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View result=inflater.inflate(editor, container, false);

        ViewPager pager=(ViewPager) result.findViewById(R.id.childPager);

        pager.setAdapter(buildAdapter());


        int position=getArguments().getInt(KEY_POSITION, -1);


        return(result);
    }

    private PagerAdapter buildAdapter() {
        return(new ChildAdapter(getActivity(), getChildFragmentManager()));
    }
}
