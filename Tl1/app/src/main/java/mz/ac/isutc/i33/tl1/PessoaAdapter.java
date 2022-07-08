package mz.ac.isutc.i33.tl1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PessoaAdapter extends ArrayAdapter<Pessoa> {

    private ArrayList<Pessoa> PessoaList;

    public PessoaAdapter(@NonNull Context context, int resource, ArrayList<Pessoa> PessoaList) {
        super(context, resource);
        this.PessoaList = PessoaList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,
                    parent, false);
        }

        ImageView PessoaImage = convertView.findViewById(R.id.Pessoa_imageview);
        TextView NomeTV = convertView.findViewById(R.id.tbNome);
        TextView IdadeTv = convertView.findViewById(R.id.tbIdade);
        TextView PesoTv = convertView.findViewById(R.id.tbPeso);
        TextView AlturaTv = convertView.findViewById(R.id.tbAltura);
        TextView SexoTv = convertView.findViewById(R.id.tbGenero);
        TextView ProvTv = convertView.findViewById(R.id.tbProvincia);
        TextView DefTv = convertView.findViewById(R.id.tbDificiencia);

        PessoaImage.setImageResource(PessoaList.get(position).getPessoaImageId());
        NomeTV.setText(PessoaList.get(position).getNome());
        IdadeTv.setText(PessoaList.get(position).getIdade());
        PesoTv.setText((int) PessoaList.get(position).getPeso());
        AlturaTv.setText((int) PessoaList.get(position).getAltura());
        SexoTv.setText(PessoaList.get(position).getSexo());
        ProvTv.setText(PessoaList.get(position).getProvincia());
        DefTv.setText(PessoaList.get(position).getDeficiencia());


        return convertView;
    }
    }

