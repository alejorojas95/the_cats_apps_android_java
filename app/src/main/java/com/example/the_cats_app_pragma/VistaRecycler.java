package com.example.the_cats_app_pragma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class VistaRecycler extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdaptadorModel itemAdapter;
    private List<Models> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_recycler);

        recyclerView = findViewById(R.id.rcData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemList = new ArrayList<>();
        itemAdapter = new AdaptadorModel(this,itemList);
        recyclerView.setAdapter(itemAdapter);

        fetchItems();
    }



    private void fetchItems() {
        // URL de la API
        String apiUrl = "https://api.thecatapi.com/v1/breeds?api_key=bda53789-d59e-46cd-9bc4-2936630fde39";

        // Crea una RequestQueue usando Volley
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        // Crea una solicitud GET de tipo JsonArrayRequest
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, apiUrl, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        // Procesa la respuesta JSON
                        itemList.clear();

                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject itemJson = response.getJSONObject(i);
                                String breedname = itemJson.getString("name");
                                String imageUrl = itemJson.optString("reference_image_id", "0XYvRd7oD");
                                int afectionlevel = itemJson.getInt("affection_level");
                                String oringin = itemJson.getString("origin");
                                int intelligence = itemJson.getInt("intelligence");

                                String data ="id:"+i+" Breedname: " + breedname + "\norigen: " + oringin+ "\nafeccition_leven: " + afectionlevel + "\nIntelligence: " + intelligence + "\nimge_id: " + imageUrl;
                                Log.d("controlvista","datos: "+data);
                                String img= "https://cdn2.thecatapi.com/images/"+imageUrl+".jpg";
                                Models item = new Models( breedname,  img.trim(),  String.valueOf(afectionlevel),  oringin,  String.valueOf(intelligence)) ;
                                itemList.add(item);
                            }

                            itemAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(VistaRecycler.this, "error"+ response.toString(), Toast.LENGTH_SHORT).show();
                            Log.d("controlvista",e.toString());
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Maneja el error de la solicitud
                        error.printStackTrace();
                    }
                });

        // Agrega la solicitud a la RequestQueue
        requestQueue.add(request);
    }
}