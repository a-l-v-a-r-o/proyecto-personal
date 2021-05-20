package com.alpehe.huertovalenciano.vista;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.alpehe.huertovalenciano.R;
import com.alpehe.huertovalenciano.commons.Preferencias;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalendarioFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalendarioFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Spinner spnSemana;
    CalendarView calendario;
    LinearLayout linearLayout;

    public CalendarioFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalendarioFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CalendarioFragment newInstance(String param1, String param2) {
        CalendarioFragment fragment = new CalendarioFragment();
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
        View viewCalendario = inflater.inflate(R.layout.fragment_calendario, container, false);

        //Spinner Dias Semana
        ArrayAdapter<CharSequence> adapterSemana = ArrayAdapter.createFromResource(getContext(),R.array.diasSemana, android.R.layout.simple_spinner_item);
        adapterSemana.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnSemana = viewCalendario.findViewById(R.id.spnSemana);
        spnSemana.setAdapter(adapterSemana);
        spnSemana.setSelection(Preferencias.getPreferenciasInteger(getContext(), "diasSemana"));

        //Calendario
        calendario = viewCalendario.findViewById(R.id.calendario);
        linearLayout = viewCalendario.findViewById(R.id.linearLayout);

        iniciarAcciones();

        return viewCalendario;
    }

    public void iniciarAcciones(){
        spnSemana.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                Preferencias.setPreferenciasInteger(getContext(),"diasSemana", position);

                ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) linearLayout.getLayoutParams();
                switch (position){
                    case 0:
                        params.horizontalBias = position;
                        linearLayout.setLayoutParams(params);
                        break;
                    case 1:
                        params.horizontalBias = 0.16f;
                        linearLayout.setLayoutParams(params);
                        break;
                    case 2:
                        params.horizontalBias = 0.32f;
                        linearLayout.setLayoutParams(params);
                        break;
                    case 3:
                        params.horizontalBias = 0.50f;
                        linearLayout.setLayoutParams(params);
                        break;
                    case 4:
                        params.horizontalBias = 0.67f;
                        linearLayout.setLayoutParams(params);
                        break;
                    case 5:
                        params.horizontalBias = 0.83f;
                        linearLayout.setLayoutParams(params);
                        break;
                    case 6:
                        params.horizontalBias = 1.0f;
                        linearLayout.setLayoutParams(params);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}