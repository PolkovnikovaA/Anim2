package com.example.anim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HomeK extends AppCompatActivity {

    View v;
    Connection connection;
    List<MaskK> data;
    ListView listView;
    AdapterK pAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_k);

        GetTextFromSQL(v);
    }

    public void enterMobile() {
        pAdapter.notifyDataSetInvalidated();
        listView.setAdapter(pAdapter);
    }

    public void GetTextFromSQL(View v) {
        data = new ArrayList<MaskK>();
        listView = findViewById(R.id.HomeK);
        pAdapter = new AdapterK(HomeK.this, data);
        try {
            ConnectionHelper connectionHelper = new ConnectionHelper();
            connection = connectionHelper.conclass();
            if (connection != null) {

                String query = "Select * From Cat";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    MaskK tempMask = new MaskK
                            (resultSet.getInt("ID"),
                                    resultSet.getString("Breed"),
                                    resultSet.getString("Country"),
                                    resultSet.getString("Image"),
                                    resultSet.getString("Lifespan"),
                                    resultSet.getString("Size"),
                                    resultSet.getString("Weight"),
                                    resultSet.getString("Wool_type"),
                                    resultSet.getString("Lifestyle"),
                                    resultSet.getString("Growth"),
                                    resultSet.getString("Origin"),
                                    resultSet.getString("Character"),
                                    resultSet.getString("Health"),
                                    resultSet.getString("Care"),
                                    resultSet.getString("Price")

                            );
                    data.add(tempMask);
                    pAdapter.notifyDataSetInvalidated();
                }
                connection.close();
            } else {
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        enterMobile();

    }
}