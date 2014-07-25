package com.benjaminafallon.shaperace;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class StarButton extends ImageButton {
	
	private boolean has_star = false;

	public StarButton(Context context) {
		super(context);
	}

	public StarButton(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public StarButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public boolean getHasStar() {
		return has_star;
	}

	public void setHasStar(boolean has_star) {
		this.has_star = has_star;
	}
	
}
