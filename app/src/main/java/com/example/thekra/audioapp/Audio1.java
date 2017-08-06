package com.example.thekra.audioapp;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import static android.media.AudioManager.AUDIOFOCUS_GAIN;
import static android.media.AudioManager.AUDIOFOCUS_GAIN_TRANSIENT;
import static android.media.AudioManager.AUDIOFOCUS_LOSS;
import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT;
import static android.media.AudioManager.AUDIOFOCUS_REQUEST_GRANTED;

public class Audio1 extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private ImageView image;
    private AudioManager audioManager;
    final AudioManager.OnAudioFocusChangeListener audioFocusChange = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AUDIOFOCUS_LOSS_TRANSIENT) {
                mediaPlayer.pause();
            } else if (focusChange == AUDIOFOCUS_GAIN) {
                mediaPlayer.start();
            } else if (focusChange == AUDIOFOCUS_LOSS) {
                relaseAudio();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio1);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        image = (ImageView) findViewById(R.id.playImage);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int request = audioManager.requestAudioFocus(audioFocusChange, AudioManager.STREAM_MUSIC, AUDIOFOCUS_GAIN_TRANSIENT);
                if (request == AUDIOFOCUS_REQUEST_GRANTED) {
                    if (mediaPlayer == null) {
                        mediaPlayer = MediaPlayer.create(Audio1.this, R.raw.car);
                        image.setImageResource(R.drawable.end);
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(complete);
                    } else {
                        relaseAudio();
                    }
                }
            }
        });

    }

    public void relaseAudio() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
            audioManager.abandonAudioFocus(audioFocusChange);
            image.setImageResource(R.drawable.play);

        }
    }

    MediaPlayer.OnCompletionListener complete = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            relaseAudio();
        }
    };


}
