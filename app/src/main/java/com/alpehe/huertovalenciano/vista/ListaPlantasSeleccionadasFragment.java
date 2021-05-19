package com.alpehe.huertovalenciano.vista;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alpehe.huertovalenciano.R;
import com.alpehe.huertovalenciano.commons.AdaptadorPlantas;
import com.alpehe.huertovalenciano.commons.AdaptadorPlantasSeleccionadas;
import com.alpehe.huertovalenciano.commons.Aplicacion;
import com.alpehe.huertovalenciano.commons.ControladorDatos;
import com.alpehe.huertovalenciano.datos.RepositorioPlantasSeleccionadas;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListaPlantasSeleccionadasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaPlantasSeleccionadasFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView recyclerView;
    public AdaptadorPlantasSeleccionadas adaptadorS;
    public ControladorDatos cDatos;
    private RepositorioPlantasSeleccionadas plantasS;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ListaPlantasSeleccionadasFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaPlantasSeleccionadasFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaPlantasSeleccionadasFragment newInstance(String param1, String param2) {
        ListaPlantasSeleccionadasFragment fragment = new ListaPlantasSeleccionadasFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_lista_plantas_seleccionadas, container, false);

        plantasS = ((Aplicacion) requireActivity().getApplication()).getPlantasSeleccionadas();
        cDatos = new ControladorDatos(getActivity(), plantasS);

        adaptadorS = ((Aplicacion) requireActivity().getApplication()).adaptadorS;
        recyclerView = v.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adaptadorS);
        adaptadorS.setOnItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = recyclerView.getChildAdapterPosition(v);
                cDatos.mostrar(pos,2);
            }
        });

        if(adaptadorS.getItemCount() == 0){
            TextView texto = v.findViewById(R.id.textView);
            texto.setVisibility(View.VISIBLE);
        }

        return v;
    }
}