package com.hirumi.visualnovelstrider;

import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;

import org.jetbrains.annotations.NotNull;

public class LanguageButton extends androidx.appcompat.widget.AppCompatButton {

    final float dpScale;

    public LanguageButton(@NonNull @NotNull Context context) {
        super(context);

        //TODO extract to util
        dpScale = context.getResources().getDisplayMetrics().density;

        int height = (int) (18 * dpScale + 0.5f);
        int width = (int) (55 * dpScale + 0.5f);
        int margin = (int) (5 * dpScale + 0.5f);

        //size
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);

        //margin
        params.setMargins(0, 0, margin, margin);

        setLayoutParams(params);
        setGravity(Gravity.CENTER);
        setTextAlignment(TEXT_ALIGNMENT_CENTER);
        setBackgroundResource(R.drawable.bg);
        setAllCaps(false);
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 8);
        setTypeface(ResourcesCompat.getFont(context, R.font.nunito_regular));
        setTextColor(getResources().getColor(R.color.primaryDarkColor));
    }
}
