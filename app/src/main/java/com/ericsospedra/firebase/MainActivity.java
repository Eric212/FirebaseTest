package com.ericsospedra.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Categoria categoria = new Categoria("Lacteos", "imagen");
        Producto producto = new Producto("Yogurt Liquido", "imagen yogurt", categoria,5.3f);
        FirebaseFirestore firebase = FirebaseFirestore.getInstance();
        firebase.collection("Producto").add(producto).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Log.d(MainActivity.class.getSimpleName(),"Producto añadido correctamente con id:" + documentReference.getId());
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(MainActivity.class.getSimpleName(),"Error al añadir el producto");
                Log.e(MainActivity.class.getSimpleName(),e.getMessage());
            }
        });
//        firebase.collection("Producto").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                if (task.isSuccessful()) {
//                    for (QueryDocumentSnapshot documentSnapshots : task.getResult()) {
////                        Producto p = documentSnapshots.toObject(Producto.class);
////                        Log.d(MainActivity.class.getSimpleName(), p.toString());
//                        Map<String, Object> map = documentSnapshots.getData();
//                        for (Map.Entry entry : map.entrySet()) {
//                            Producto p;
//                            String nombreProducto = (String) map.get("nombre");
//                            String imagenProdcuto = (String) map.get("imagen");
//                            Map<String, Object> mapCategoria = (Map<String, Object>) map.get("categoria");
//                            String nombreCategoria = (String) mapCategoria.get("nombre");
//                            String imagenCategoria = (String) mapCategoria.get("imagen");
//                            Categoria categoria = new Categoria(nombreCategoria, imagenCategoria);
//                            p = new Producto(nombreProducto, imagenProdcuto, categoria);
//                            Log.d(MainActivity.class.getSimpleName(), p.toString());
//                        }
//                    }
//                } else {
//                    Log.e(MainActivity.class.getSimpleName(), "Error al recuperar los productos");
//                }
//            }
//        });

        firebase.collection("Producto")
                //.whereEqualTo("nombre", "Leche")
                .orderBy("precio")
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot documentSnapshots : task.getResult()) {
                                Log.d(MainActivity.class.getSimpleName(), documentSnapshots.getData().toString());
                            }
                        }
                    }
                });

    }
}