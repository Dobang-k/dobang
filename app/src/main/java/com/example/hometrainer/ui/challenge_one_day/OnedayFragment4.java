package com.example.hometrainer.ui.challenge_one_day;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hometrainer.R;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragmentX;


public class OnedayFragment4 extends Fragment {

    private static final String API_KEY ="AIzaSyCWEKIZHSd0tKdOKb8ZIs1lwoNNx10dB4c";

    private static String VIDEO_ID = "t70t-sklypk&";

    public static OnedayFragment4 newInstance() {

        return new OnedayFragment4();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview =inflater.inflate(R.layout.fragment_challenge_oneday_4, container, false);

        YouTubePlayerSupportFragmentX youTubePlayerFragment = YouTubePlayerSupportFragmentX.newInstance();

        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.youtube_layout4,youTubePlayerFragment).commit();

        youTubePlayerFragment.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
                if (!wasRestored) {
                    player.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                    player.loadVideo(VIDEO_ID);
                    player.play();
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult error) {
                String errorMessage = error.toString();
                Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();

            }
        });

        return rootview;
    }
}
