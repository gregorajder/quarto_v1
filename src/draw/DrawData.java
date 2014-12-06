package draw;

import android.util.Log;

import com.gregorajder.quarto1.R;

/**
 * 
 * DrawData.java figures images pictures name must comply ordinal value in array
 * each figure characteristic represented by 0 or 1 in binary code pictures
 * number
 */

public class DrawData {

	private static final String TAG = "gregLogs";
	static int visible[] = new int[17];
	static int unVisible[] = new int[17];

	public DrawData() {
		// Log.d (TAG, "инициализация масивов картинок");
		for (int i = 0, v = R.drawable.v0000, uv = R.drawable.uv0000; i <= 15; i++, v++, uv++) {
			visible[i] = v;
			unVisible[i] = uv;
		}
		visible[16] = R.drawable.fnll;
		unVisible[16] = R.drawable.fnll;
	}
}
