package nqn.app.martinromero.example.com.myappmr;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.zip.Inflater;

/**
 * Created by Martin on 01/04/2016.
 */
public class BandasAdapter extends ArrayAdapter<Bandas>{
    Context context;
    int layoutResourceId;
    Bandas data[] = null;
    public BandasAdapter(Context contexto,int layoutResourceId,Bandas[] data){
        super(contexto,layoutResourceId,data);
        this.context = contexto;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;
        BandasHolder holder = null;
        if(row==null){
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId,parent,false);

            holder = new BandasHolder();
            holder.imagen = (ImageView) row.findViewById(R.id.img_lv);
            holder.texto = (TextView) row.findViewById(R.id.tv);
            row.setTag(holder);
        }else{
            holder = (BandasHolder) row.getTag();
        }

        Bandas bandas = data[position];
        holder.texto.setText(bandas.title);
        holder.imagen.setImageResource(bandas.icon);


        return row;
    }

    static class BandasHolder{
        ImageView imagen;
        TextView texto;
    }


}
