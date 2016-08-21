package com.example.kuhyebin.projectapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OilActivity extends AppCompatActivity {
    @BindView(R.id.group_select)
    RadioGroup groupView;
    @BindView(R.id.appearancetoolbar)
    Toolbar toolbar;
    @BindView(R.id.button_brand)
    Button buttonbrand;
    @BindView(R.id.text_brand)
    TextView brandtextView;
    @BindView(R.id.text_area)
    TextView areatextView;
    @BindView(R.id.text_subarea)
    TextView subareatextView;
    PopupMenu popupbrand;
    CheckBox checkbox1;
    RelativeLayout Layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oil);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.backbutton);

        checkbox1 = (CheckBox)findViewById(R.id.check_pickup);
        Layout = (RelativeLayout)findViewById(R.id.Layout);
        Layout.setVisibility(View.GONE);

        popupbrand = new PopupMenu(this, buttonbrand);
        popupbrand.setOnMenuItemClickListener(
                new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case 1:
                                brandtextView.setText("현대");
                                break;
                            case 2:
                                brandtextView.setText("기아");
                                break;
                            case 3:
                                brandtextView.setText("쉐보레");
                                break;
                        }
                        return false;
                    }
                }
        );

        Menu menu = popupbrand.getMenu();
        menu.add(0, 1, 0, "현대");
        menu.add(0, 2, 0, "기아");
        menu.add(0, 3, 0, "쉐보레");

        checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    Layout.setVisibility(View.VISIBLE);
                else
                    Layout.setVisibility(View.GONE);
            }
        });
    }
    public void brandOnClick(View v) {
        Log.v("출력", "팝업");
        popupbrand.show();
    }


    int id;
    String[] areaitems = {"서울특별시", "경기도"};
    int selectedPosition = -1;
    public void onSingleChoice(View view) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        selectedPosition = 2;
        builder.setSingleChoiceItems(areaitems, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                areatextView.setText(areaitems[i]);
                switch (i) {
                    case 0:
                        id = R.array.seoul;
                        break;
                    case 1:
                        id = R.array.gyeonggido;
                        break;
                }
                dialogInterface.dismiss();
            }
        });
        builder.create().show();

    }

    int subselectedPosition = -1;
    public void onSingleChoiceSub(View view) {
        final AlertDialog.Builder subbuilder = new AlertDialog.Builder(this);
        subbuilder.setIcon(android.R.drawable.ic_dialog_alert);
        subselectedPosition = 2;
        subbuilder.setSingleChoiceItems(getResources().getStringArray(id), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface subdialogInterface, int item) {
                subareatextView.setText(getResources().getStringArray(id)[item]);
                subdialogInterface.dismiss();
            }
        });
        subbuilder.create().show();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
