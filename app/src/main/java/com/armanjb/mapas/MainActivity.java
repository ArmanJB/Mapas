package com.armanjb.mapas;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import org.osmdroid.bonuspack.overlays.Marker;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;

public class MainActivity extends AppCompatActivity{

    private CheckBox policial;
    private MapView osm;
    private MapController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        osm = (MapView) findViewById(R.id.map);
        osm.setTileSource(TileSourceFactory.MAPQUESTOSM);
        osm.setBuiltInZoomControls(true);
        osm.setMultiTouchControls(true);
        osm.getOverlays().clear();
        controller = (MapController) osm.getController();

        policial = (CheckBox) findViewById(R.id.policia);
        policial.setChecked(true);
        policial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(policial.isChecked()){
                    osm.getOverlays().clear();
                    colocarEstaciones();
                }else{
                    osm.getOverlays().clear();
                }
            }
        });

        GeoPoint center = new GeoPoint(16.500, -88.000);//Para Nicaragua
        controller.setZoom(7);
        controller.animateTo(center);

        colocarEstaciones();
    }

    public void colocarEstaciones(){
        addMarker(new GeoPoint(12.145498, -86.260820), getResources().getDrawable(R.mipmap.ic_pol));
        addMarker(new GeoPoint(12.155457, -86.304896), getResources().getDrawable(R.mipmap.ic_pol));
        addMarker(new GeoPoint(12.130801, -86.299586), getResources().getDrawable(R.mipmap.ic_pol));
        addMarker(new GeoPoint(12.151845, -86.247636), getResources().getDrawable(R.mipmap.ic_pol));
        addMarker(new GeoPoint(12.117261, -86.249775), getResources().getDrawable(R.mipmap.ic_pol));
        addMarker(new GeoPoint(12.147403, -86.195954), getResources().getDrawable(R.mipmap.ic_pol));
        addMarker(new GeoPoint(12.123590, -86.211976), getResources().getDrawable(R.mipmap.ic_pol));
        addMarker(new GeoPoint(12.19370, -86.10077), getResources().getDrawable(R.mipmap.ic_pol));
        addMarker(new GeoPoint(11.848019, -86.441377), getResources().getDrawable(R.mipmap.ic_pol));
        addMarker(new GeoPoint(12.163079, -86.356579), getResources().getDrawable(R.mipmap.ic_pol));
    }

    public void addMarker(GeoPoint point, Drawable icon){
        Marker marker = new Marker(osm);
        marker.setPosition(point);
        marker.setIcon(icon);

        osm.getOverlays().add(marker);
    }

}
