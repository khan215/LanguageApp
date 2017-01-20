    package com.example.khan.musicapp;

    import android.content.Context;
    import android.media.AudioManager;
    import android.media.MediaPlayer;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.view.*;
    import android.widget.AdapterView;
    import android.widget.ListView;
    import android.widget.Toast;

    import java.util.ArrayList;


    public class FamilyActivity extends AppCompatActivity {
        private MediaPlayer mMediaPlayer;
        private AudioManager mAudioManager;

        AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
                new AudioManager.OnAudioFocusChangeListener() {
                    public void onAudioFocusChange(int focusChange) {
                        if (focusChange == AudioManager.AUDIOFOCUS_LOSS || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                            mMediaPlayer.pause();
                            mMediaPlayer.seekTo(0);
                        } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                            mMediaPlayer.start();
                            // Your app has been granted audio focus again
                            // Raise volume to normal, restart playback if necessary
                        } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                            releaseMediaPlayer();
                        }
                    }
                };
        private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener(){
            @Override
            public void onCompletion(MediaPlayer mp){
                releaseMediaPlayer();
            }
        };

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.word_list);

            mAudioManager =(AudioManager) getSystemService(Context.AUDIO_SERVICE);

            final ArrayList<Word> words = new ArrayList<Word>();
            words.add(new Word("One","Aik",R.drawable.family,R.raw.alone));
            words.add(new Word("Two","Do",R.drawable.family,R.raw.faded));
            words.add(new Word("Three","Teen",R.drawable.family,R.raw.faded));
            words.add(new Word("Four","Chaar",R.drawable.family,R.raw.alone));
            words.add(new Word("Five","Paanch",R.drawable.family,R.raw.faded));
            words.add(new Word("Six","Chay",R.drawable.family,R.raw.alone));
            words.add(new Word("Seven","Saaat",R.drawable.family,R.raw.alone));
            words.add(new Word("Eight","Aaath",R.drawable.family,R.raw.alone));
            words.add(new Word("Nine","No",R.drawable.family,R.raw.faded));
            words.add(new Word("Ten","Das",R.drawable.family,R.raw.alone));


            WordAdapter adapter = new WordAdapter(this,words,R.color.family_color);
            ListView listView = (ListView) findViewById(R.id.list);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> parent, View view,int position , long id){
                    Word word = words.get(position);
                    int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                            // Use the music stream.
                            AudioManager.STREAM_MUSIC,
                            // Request permanent focus.
                            AudioManager.AUDIOFOCUS_GAIN);

                    if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

                        // Start playback}

                        releaseMediaPlayer();
                        mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getAudioFile());
                        mMediaPlayer.start();
                        mMediaPlayer.setOnCompletionListener(mCompletionListener);
                    }
                }
            });
        }
            @Override
            protected void onStop(){
                super.onStop();
                releaseMediaPlayer();
            }
            private void releaseMediaPlayer(){
                if (mMediaPlayer != null) {
                    mMediaPlayer.release();
                    mMediaPlayer = null;
                    mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);

                }
            }
    }



