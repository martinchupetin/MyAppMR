package nqn.app.martinromero.example.com.myappmr;

import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener,SensorEventListener {
    TextView campo_texto, tv;
    EditText ed;
    ImageView img;
    Button btn_Inicio,btn_registro,btn_t;
    LinearLayout ln;
    SensorManager sn;
    Sensor sensor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        campo_texto = (TextView) findViewById(R.id.tex);
        ed = (EditText) findViewById(R.id.user);
        btn_Inicio = (Button) findViewById(R.id.btn_ini);
        btn_registro = (Button) findViewById(R.id.btn_reg);
        btn_t = (Button) findViewById(R.id.btn_toast);

        ln = (LinearLayout) findViewById(R.id.linear);
        tv = (TextView) findViewById(R.id.text_sensor);
        sn = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sn.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        btn_Inicio.setOnClickListener(this);
        btn_registro.setOnClickListener(this);
        btn_t.setOnClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_ini :
                    String dato = ed.getText().toString();
                    campo_texto.setText(dato);
                break;
            case R.id.btn_reg:
                String cadena = ed.getText().toString();
                Intent intent = new Intent(MainActivity.this,SecondActivity.class); //paso de un activity a otra
                intent.putExtra("CADENA",cadena); //envio datos a otra actividad

                startActivity(intent); //ejecuto la segunda actividad
                break;
            case R.id.btn_toast:
                Toast.makeText(getApplicationContext(),"Esto es un Toast",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        String txt = String.valueOf(event.values[0]); //recibe el valor de lo que cambia en el evento
        tv.setText(txt);

        float valor = Float.parseFloat(txt);

        if(valor==0){
            ln.setBackgroundColor(Color.BLUE);
        }else{
            ln.setBackgroundColor(Color.YELLOW);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
