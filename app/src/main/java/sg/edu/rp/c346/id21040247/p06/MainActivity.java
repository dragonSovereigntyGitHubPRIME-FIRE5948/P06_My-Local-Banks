package sg.edu.rp.c346.id21040247.p06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //XML View Variables
    TextView tvDBS;
    TextView tvUOB;
    TextView tvOCBC;

    boolean favoriteBank;
    String wordClicked = "";
    String languageSelected = "ENG";


    //onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //XML View Initialisation
        tvDBS = findViewById(R.id.textDBS);
        tvOCBC = findViewById(R.id.textOCBC);
        tvUOB = findViewById(R.id.textUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }


    //Context Menu

    //1. onCreateContextMenu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if(languageSelected == "ENG") {
            menu.add(0, 0, 0, getString(R.string.website));
            menu.add(0, 1, 1, getString(R.string.contactbank));
            menu.add(0, 2, 2, getString(R.string.togglefavorite));
        } else if(languageSelected == "CH") {
            menu.add(0, 0, 0, getString(R.string.website_ch));
            menu.add(0, 1, 1, getString(R.string.contactbank_ch));
            menu.add(0, 2, 2, getString(R.string.togglefavorite_ch));
        } else if(languageSelected == "MLY") {
            menu.add(0, 0, 0, getString(R.string.website_mly));
            menu.add(0, 1, 1, getString(R.string.contactbank_mly));
            menu.add(0, 2, 2, getString(R.string.togglefavorite_mly));
        } else if(languageSelected == "TML") {
            menu.add(0, 0, 0, getString(R.string.website_tml));
            menu.add(0, 1, 1, getString(R.string.contactbank_tml));
            menu.add(0, 2, 2, getString(R.string.togglefavorite_tml));
        }

        if (v == tvDBS) {
            wordClicked = getString(R.string.DBS);
        } else if (v == tvOCBC) {
            wordClicked = getString(R.string.OCBC);
        } else if (v == tvUOB) {
            wordClicked = getString(R.string.UOB);
        }
    }

    //2. OnContextItemSelected

    @Override
    public boolean onContextItemSelected(MenuItem option) {

        //DBS
        if (wordClicked.equalsIgnoreCase(getString(R.string.DBS))) {
            if (option.getItemId() == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.DBS_Link)));
                startActivity(intent);
                return true;
            } else if (option.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.DBS_Number)));
                startActivity(intentCall);
                return true;
            } else if (option.getItemId() == 2) {
                if (favoriteBank) {
                    tvDBS.setTextColor(this.getResources().getColor(R.color.black));
                    favoriteBank = false;
                }else{
                    tvDBS.setTextColor(this.getResources().getColor(R.color.red));
                    favoriteBank = true;
                }
            }
        }

            //UOB
            if (wordClicked.equalsIgnoreCase(getString(R.string.UOB))) {
                if (option.getItemId() == 0) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.UOB_Link)));
                    startActivity(intent);
                    return true;
                } else if (option.getItemId() == 1) {
                    Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.UOB_Number)));
                    startActivity(intentCall);
                    return true;
                }else if (option.getItemId() == 2) {
                    if (favoriteBank) {
                        tvUOB.setTextColor(this.getResources().getColor(R.color.black));
                        favoriteBank = false;
                    }else{
                        tvUOB.setTextColor(this.getResources().getColor(R.color.red));
                        favoriteBank = true;
                    }
                }
            }

            //OCBC
            if (wordClicked.equalsIgnoreCase(getString(R.string.OCBC))) {
                if (option.getItemId() == 0) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.OCBC_Link)));
                    startActivity(intent);
                    return true;
                } else if (option.getItemId() == 1) {
                    Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.OCBC_Number)));
                    startActivity(intentCall);
                    return true;
                }else if (option.getItemId() == 2) {
                    if (favoriteBank) {
                        tvOCBC.setTextColor(this.getResources().getColor(R.color.black));
                        favoriteBank = false;
                    }else{
                        tvOCBC.setTextColor(this.getResources().getColor(R.color.red));
                        favoriteBank = true;
                    }
                }
            }
            return super.onContextItemSelected(option); //pass menu item to the superclass implementation
        }

        //Options Menu

        //1. onCreateOptionsMenu
        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        //2. onOptionsItemSelected
        @Override
        public boolean onOptionsItemSelected (MenuItem banks){

            int id = banks.getItemId();

            //English
            if (id == R.id.EnglishSelection) {
                tvUOB.setText(getString(R.string.UOB));
                tvOCBC.setText(getString(R.string.OCBC));
                tvDBS.setText(getString(R.string.DBS));
                languageSelected = "ENG";
                return true;
                //Chinese
            } else if (id == R.id.ChineseSelection) {
                tvUOB.setText(getString(R.string.UOB_Chinese));
                tvOCBC.setText(getString(R.string.OCBC_Chinese));
                tvDBS.setText(getString(R.string.DBS_Chinese));
                languageSelected = "CH";
                return true;
                //Malay
            } else if (id == R.id.MalaySelection) {
                tvUOB.setText(getString(R.string.UOB_Malay));
                tvOCBC.setText(getString(R.string.OCBC_Malay));
                tvDBS.setText(getString(R.string.DBS_Malay));
                languageSelected = "MLY";
                return true;
                //Tamil
            } else if (id == R.id.TamilSelection) {
                tvUOB.setText(getString(R.string.UOB_Tamil));
                tvOCBC.setText(getString(R.string.OCBC_Tamil));
                tvDBS.setText(getString(R.string.DBS_Tamil));
                languageSelected = "TML";
                return true;
                //None Selection
            } else
                tvDBS.setText(getString(R.string.error));
            tvOCBC.setText(getString(R.string.error));
            tvUOB.setText(getString(R.string.error));
            {
                return super.onOptionsItemSelected(banks);
            }
        }
    }


