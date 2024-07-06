package com.sanderpiva.appmatematico.View;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.sanderpiva.appmatematico.R;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private int[] mImageIds = { R.drawable.i_area_quadrado, R.drawable.i_perimetro_quadrado,
            R.drawable.i_seno_cosseno_tangente, R.drawable.i_pitagoras, R.drawable.i_pa, R.drawable.i_pg,
            R.drawable.i_proporcao, R.drawable.i_porcentagem, R.drawable.i_eq_1_grau, R.drawable.image6a};

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mImageIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // Cria uma nova ImageView para cada item referenciado pelo Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // Se não foi reutilizado, inicializa algumas propriedades
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(350, 250));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);//8
            imageView.setPadding(12, 12, 12, 12);
        } else {
            imageView = (ImageView) convertView;
        }

        // Define a imagem de origem para a ImageView
        imageView.setImageResource(mImageIds[position]);
        return imageView;
    }
}

