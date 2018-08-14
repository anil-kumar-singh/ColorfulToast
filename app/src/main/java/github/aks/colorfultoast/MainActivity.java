package github.aks.colorfultoast;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import github.aks.colorfultoastlib.ColorfulToast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDefaultToast = findViewById(R.id.btn_default_toast);
        btnDefaultToast.setOnClickListener(this);

        Button btnInfoToast = findViewById(R.id.btn_info_toast);
        btnInfoToast.setOnClickListener(this);

        Button btnSuccessToast = findViewById(R.id.btn_success_toast);
        btnSuccessToast.setOnClickListener(this);

        Button btnErrorToast = findViewById(R.id.btn_error_toast);
        btnErrorToast.setOnClickListener(this);

        Button btnWarningToast = findViewById(R.id.btn_warning_toast);
        btnWarningToast.setOnClickListener(this);

        Button btnHideIocnToast = findViewById(R.id.btn_hide_icon);
        btnHideIocnToast.setOnClickListener(this);

        Button btnCustomToast= findViewById(R.id.btn_custom_toast);
        btnCustomToast.setOnClickListener(this);

        Button btnGravityTop= findViewById(R.id.btn_gravity_changed);
        btnGravityTop.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_default_toast:
                new ColorfulToast.Builder(this)
                        .text("Default Toast")
                        .duration(ColorfulToast.LENGTH_SHORT)
                        .build()
                        .show();

                break;
            case R.id.btn_info_toast:
                new ColorfulToast.Builder(this)
                        .text("Info Toast")
                        .duration(ColorfulToast.LENGTH_SHORT)
                        .type(ColorfulToast.TYPE_INFO)
                        .build()
                        .show();
                break;

            case R.id.btn_success_toast:
                new ColorfulToast.Builder(this)
                        .text("Success Toast")
                        .duration(ColorfulToast.LENGTH_SHORT)
                        .type(ColorfulToast.TYPE_SUCCESS)
                        .build()
                        .show();
                break;
            case R.id.btn_error_toast:
                new ColorfulToast.Builder(this)
                        .text("Error Toast")
                        .duration(ColorfulToast.LENGTH_SHORT)
                        .type(ColorfulToast.TYPE_ERROR)
                        .build()
                        .show();
                break;
            case R.id.btn_warning_toast:
                new ColorfulToast.Builder(this)
                        .text("Warning Toast")
                        .duration(ColorfulToast.LENGTH_LONG)
                        .type(ColorfulToast.TYPE_WARNING)
                        .build()
                        .show();
                break;

            case R.id.btn_hide_icon:
                new ColorfulToast.Builder(this)
                        .text("Hide Icon")
                        .duration(ColorfulToast.LENGTH_LONG)
                        .type(ColorfulToast.TYPE_WARNING)
                        .hideIcon()
                        .build()
                        .show();
                break;
            case R.id.btn_custom_toast:
                new ColorfulToast.Builder(this)
                        .text("Custom Toast")
                        .duration(ColorfulToast.LENGTH_LONG)
                        .type(ColorfulToast.TYPE_CUSTOM)
                        .textColor(Color.YELLOW)
                        .backgroundColor(Color.parseColor("#2c387e"))
                        .icon(R.drawable.ic_android_24px)
                        .build()
                        .show();
                break;

            case R.id.btn_gravity_changed:
                new ColorfulToast.Builder(this)
                        .text("Gravity Top")
                        .duration(ColorfulToast.LENGTH_SHORT)
                        .type(ColorfulToast.TYPE_SUCCESS)
                        .gravity(Gravity.TOP)
                        .build()
                        .show();
                break;


        }
    }
}
