package nqn.app.martinromero.example.com.myappmr;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements OnClickListener {
    Button btn_back;
    TextView texto;
    ListView lv;
    String[] valores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
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

        btn_back = (Button) findViewById(R.id.btn_volver);
        btn_back.setOnClickListener(this);
        texto = (TextView) findViewById(R.id.text_sec);
    /*    valores = new String[]{"Holanda","China","Argentina","Brasil","India","Suiza","Suecia"};
        lv = (ListView) findViewById(R.id.lista);
        //adaptador para como se van a mostrar las cosas
        //el sabe como acomomdar las cosas
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,valores);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent,View view,int position,long id){
                Toast.makeText(getApplicationContext(),"Posicion: "+position,Toast.LENGTH_SHORT).show();
            }
        });
*/
        //aca recibo el dato de la main_Activity
        Intent intent = getIntent();
        Bundle extra = intent.getExtras(); //coloco todo lo que viene de otra activity en el bundle

        if (!extra.isEmpty()){
            String dato = extra.getString("CADENA"); //aca elijo que es lo que quiero recuperar del bundle
            texto.setText(dato);
        }

        //aca manejo mi lista personalizada
        Bandas bandas_data[] = new Bandas[]{
                new Bandas(R.drawable.ic_launcher,"ColdPlay"),
                new Bandas(R.drawable.ic_launcher,"Limp Bizkit"),
                new Bandas(R.drawable.ic_launcher,"The Killers"),
                new Bandas(R.drawable.ic_launcher,"Mala Fama"),
                new Bandas(R.drawable.ic_launcher,"Natalia Oreiro"),
                new Bandas(R.drawable.ic_launcher,"Nirvana"),
                new Bandas(R.drawable.ic_launcher,"Pearl Jam"),
                new Bandas(R.drawable.ic_launcher,"Blink"),
                new Bandas(R.drawable.ic_launcher,"AudioSlave"),
                new Bandas(R.drawable.ic_launcher,"Placebo"),

        };
        //ahora necesito adaptarlas. con un adaptador creado por mi
        BandasAdapter adapter = new BandasAdapter(this,R.layout.listview_item_row,bandas_data);
        lv = (ListView) findViewById(R.id.lista);
        View header= (View) getLayoutInflater().inflate(R.layout.list_header_row,null);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView v = (TextView) view.findViewById(R.id.tv);
                Toast.makeText(getApplicationContext(),v.getText(),Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_volver:
                Intent intento = new Intent(SecondActivity.this,MainActivity.class);
                startActivity(intento);
                break;
        }
    }
}
