package github.aks.colorfultoastlib;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ColorfulToast {
    public static final int LENGTH_SHORT = 0;
    public static final int LENGTH_LONG = 1;

    public static final int TYPE_DEFAULT = 0;
    public static final int TYPE_SUCCESS = 1;
    public static final int TYPE_WARNING = 2;
    public static final int TYPE_ERROR = 3;
    public static final int TYPE_INFO = 4;
    public static final int TYPE_CUSTOM = 5;

    private final Context context;
    private final String text;
    private final int duration;
    private final int type;
    private final boolean hideIcon;
    private final int textColor;
    private final int backgroundColor;
    private final boolean isBackgroundColorSet;
    private final boolean isTextColorSet;
    private final int icon;
    private final int gravity;
    private final int offsetX;
    private final int offsetY;


    private ColorfulToast(Builder builder) {
        this.text = builder.text;
        this.duration = builder.duration;
        this.context = builder.context;
        this.type = builder.type;
        this.hideIcon = builder.hideIcon;
        this.textColor = builder.textColor;
        this.backgroundColor = builder.backgroundColor;
        this.isBackgroundColorSet = builder.isBackgroundColorSet;
        this.isTextColorSet = builder.isTextColorSet;
        this.icon = builder.icon;
        this.gravity = builder.gravity;
        this.offsetX = builder.offsetX;
        this.offsetY = builder.offsetY;

    }


    public static class Builder {
        private Context context;
        private String text;
        private int duration;
        private int type;
        private boolean hideIcon;
        private int textColor;
        private int backgroundColor;
        private boolean isBackgroundColorSet;
        private boolean isTextColorSet;
        private int icon;
        private int gravity;
        private int offsetX;
        private int offsetY;


        public Builder(Context context) {
            this.context = context;
        }

        public Builder text(String message) {
            this.text = message;
            return this;
        }

        public Builder duration(int duration) {
            this.duration = duration;
            return this;
        }

        public Builder type(int type) {
            this.type = type;
            if (type == TYPE_CUSTOM) {
                this.hideIcon = true;
            }
            return this;
        }

        public Builder hideIcon() {
            this.hideIcon = true;
            return this;
        }

        public Builder textColor(int color) {
            this.textColor = color;
            this.isTextColorSet = true;
            return this;
        }

        public Builder backgroundColor(int color) {
            this.backgroundColor = color;
            this.isBackgroundColorSet = true;
            return this;
        }

        public Builder icon(int iconRes) {
            this.icon = iconRes;
            this.hideIcon = false;
            return this;
        }

        public Builder gravity(int gravity) {
            this.gravity = gravity;
            return this;
        }

        public Builder gravityWithOffset(int gravity, int offsetX, int offsetY) {
            this.gravity = gravity;
            this.offsetX = offsetX;
            this.offsetY = offsetY;
            return this;
        }

        public ColorfulToast build() {
            return new ColorfulToast(this);
        }

    }


    public void show() {
        if (type == TYPE_DEFAULT) {
            Toast.makeText(context, text, duration).show();

        } else {
            Toast toast = new Toast(context);
            toast.setDuration(duration);

            View layout = LayoutInflater.from(context).inflate(R.layout.colorful_layout, null, false);
            TextView tvMessage = layout.findViewById(R.id.message);
            LinearLayout containerLayout = layout.findViewById(R.id.container);
            ImageView iVIcon = layout.findViewById(R.id.icon);

            tvMessage.setText(text);

            setGravity(toast);


            switch (type) {
                case TYPE_SUCCESS:
                    containerLayout.setBackgroundResource(R.drawable.bg_success_toast);
                    iVIcon.setImageResource(R.drawable.ic_outline_done_24px);

                    break;
                case TYPE_WARNING:
                    containerLayout.setBackgroundResource(R.drawable.bg_warning_toast);
                    iVIcon.setImageResource(R.drawable.ic_warning_24px);

                    break;
                case TYPE_ERROR:
                    containerLayout.setBackgroundResource(R.drawable.bg_error_toast);
                    iVIcon.setImageResource(R.drawable.ic_error_outline_24px);
                    break;
                case TYPE_INFO  :
                    containerLayout.setBackgroundResource(R.drawable.bg_info_toast);
                    iVIcon.setImageResource(R.drawable.ic_info_24px);

                    break;
                case TYPE_CUSTOM:
                    Drawable bg = containerLayout.getBackground();
                    if (isBackgroundColorSet) {
                        bg.setColorFilter(backgroundColor, PorterDuff.Mode.SRC_ATOP);
                    } else {
                        bg.setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_ATOP);

                    }
                    containerLayout.setBackground(bg);
                    if (isTextColorSet) {
                        tvMessage.setTextColor(textColor);

                    }

                    if (icon > 0) {
                        iVIcon.setImageResource(icon);
                    }

                    break;

            }

            showHideIcon(iVIcon);


            toast.setView(layout);
            toast.show();

        }
    }

    private void showHideIcon(ImageView iVIcon) {
        if (hideIcon) {
            iVIcon.setVisibility(View.GONE);
        } else {
            iVIcon.setVisibility(View.VISIBLE);

        }
    }

    private void setGravity(Toast toast) {
        if (gravity > 0) {
            toast.setGravity(gravity,
                    offsetX == 0 ? toast.getXOffset() : offsetX,
                    offsetY == 0 ? toast.getYOffset() : offsetY);
        }
    }
}
