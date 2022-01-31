package ClockProject;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;

import java.io.Closeable;
import java.text.MessageFormat;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.link.LinkedModeUI.ExitFlags;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class AlertClock {

	protected Shell shlAlert;
	private Text tbShowHour;
	private Text tbShowMinute;
	private Text tbShowSecond;
	private int tempHour 	= 0 ;
	private int tempMinute 	= 0 ;
	private int tempSecond 	= 0 ;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AlertClock window = new AlertClock();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlAlert.open();
		shlAlert.layout();
		while (!shlAlert.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlAlert = new Shell();
		shlAlert.setSize(425, 280);
		shlAlert.setText("Alert");
		
		Label lblShowHour = new Label(shlAlert, SWT.NONE);
		lblShowHour.setFont(SWTResourceManager.getFont("Itim", 15, SWT.NORMAL));
		lblShowHour.setAlignment(SWT.CENTER);
		lblShowHour.setBounds(36, 39, 76, 24);
		lblShowHour.setText("Hour");
		
		Label lblShowMinute = new Label(shlAlert, SWT.NONE);
		lblShowMinute.setFont(SWTResourceManager.getFont("Itim", 15, SWT.NORMAL));
		lblShowMinute.setAlignment(SWT.CENTER);
		lblShowMinute.setText("Minute");
		lblShowMinute.setBounds(167, 39, 76, 24);
		
		Label lblShowSecond = new Label(shlAlert, SWT.NONE);
		lblShowSecond.setFont(SWTResourceManager.getFont("Itim", 15, SWT.NORMAL));
		lblShowSecond.setAlignment(SWT.CENTER);
		lblShowSecond.setText("Second");
		lblShowSecond.setBounds(297, 39, 76, 24);
		
		Button btnSubmitAlert = new Button(shlAlert, SWT.NONE);
		btnSubmitAlert.setFont(SWTResourceManager.getFont("Itim", 15, SWT.NORMAL));
		btnSubmitAlert.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				tempHour 	= Integer.parseInt( tbShowHour.getText() );
				tempMinute 	= Integer.parseInt( tbShowMinute.getText() );
				tempSecond 	= Integer.parseInt( tbShowSecond.getText() );
				if( (( tempHour <= 24 && tempHour >= 0 ) && ( tempMinute <= 60 && tempMinute >=0 )) && ( tempSecond <= 60 && tempSecond >= 0 ) ) {
					
				} /* end if */ else {
					System.out.println( "Error" );
					MessageDialog.openError(shlAlert, "Error!!", "Please fill out the correct information.");
					System.exit(0);
				}// end else 
			} // end method 
		});
		btnSubmitAlert.setBounds(55, 167, 308, 49);
		btnSubmitAlert.setText("Submit Alert Setting");
		
		tbShowHour = new Text(shlAlert, SWT.BORDER | SWT.CENTER);
		tbShowHour.setText("00");
		tbShowHour.setFont(SWTResourceManager.getFont("Itim", 26, SWT.BOLD));
		tbShowHour.setBounds(36, 78, 76, 54);
		
		tbShowMinute = new Text(shlAlert, SWT.BORDER | SWT.CENTER);
		tbShowMinute.setText("00");
		tbShowMinute.setFont(SWTResourceManager.getFont("Itim", 26, SWT.BOLD));
		tbShowMinute.setBounds(167, 78, 76, 54);
		
		tbShowSecond = new Text(shlAlert, SWT.BORDER | SWT.CENTER);
		tbShowSecond.setText("00");
		tbShowSecond.setFont(SWTResourceManager.getFont("Itim", 26, SWT.BOLD));
		tbShowSecond.setBounds(297, 78, 76, 54);
	}
}