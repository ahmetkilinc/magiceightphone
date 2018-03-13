+Phone shakeListener with Seismic -> https://github.com/square/seismic library.

How to use seismic:

1) add library to dependencies:

dependencies{
...
compile 'com.squareup:seismic:1.0.2'
...
}

2) implement ShakeDetector.Listener to the class which you want to enable the sensor:

public class yourClassName extends AppCompatActivity implements ShakeDetector.Listener{

...
}

3) define objects:

SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
ShakeDetector sd = new ShakeDetector(this);
sd.start(sensorManager);

4) Events after shake detection:

@Override public void hearShake() {

Toast.makeText(this, "Shake Detected.", Toast.LENGTH_SHORT).show();
}

+ActionBar colors

+Custom Toast Messages with GentleToast -> https://android-arsenal.com/details/1/6332
