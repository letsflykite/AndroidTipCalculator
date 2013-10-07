package codepath.apps.tipcalculator;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	public EditText etAmount;
	public TextView tvTipLabel;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);//inflate the view, turn it into an object
		etAmount = (EditText) findViewById(R.id.etAmount);
		//fieldName = (viewType)findViewById()
		tvTipLabel = (TextView) findViewById(R.id.tvTipLabel);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void on10Percent(View v) {
		// fire when the button is pressed
		calculateTip(10);
	}

	public void on15Percent(View v) {
		// fire when the button is pressed
		//Toast.makeText(this, "hello world", Toast.LENGTH_LONG).show();
		calculateTip(15);
	}
	public void on20Percent(View v) {
		// fire when the button is pressed
		//Toast.makeText(this, "hello world", Toast.LENGTH_LONG).show();
		calculateTip(20);
	}
	
	private void calculateTip(double tipPercent) {
		String fieldValue = etAmount.getText().toString();
		if (fieldValue.length()==0){
			tvTipLabel.setText("Cannot calculate tip, please input a valid number");
			return;
		}
		double dollarAmount;
		try  
	    {  
			dollarAmount = Double.parseDouble( fieldValue );  
	    }  
	    catch( Exception e)  
 	    {  
	    	tvTipLabel.setText("Cannot calculate tip, please input a valid number");
		    return;  
		}  
		DecimalFormat df = new DecimalFormat();
		df.setMinimumFractionDigits(2);
	    df.setMaximumFractionDigits(2);
		fieldValue = "Tip is:  $"+String.valueOf(df.format(dollarAmount*tipPercent/100.0));
		//Toast.makeText(this, fieldValue, Toast.LENGTH_LONG).show();
		//change the text label
		tvTipLabel.setText(fieldValue);
	}

}