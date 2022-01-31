package ClockProject;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.text.SimpleDateFormat;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class main {

	protected Shell shell;
	private Text tbShowHour;
	private Text tbShowMinute;
	private Text tbShowSecond;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			main window = new main();
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(423, 325);
		shell.setText("SWT Application");
		
		Button btnNormal = new Button(shell, SWT.NONE);
		btnNormal.setBounds(61, 152, 136, 44);
		btnNormal.setText("Normal");
		
		Button btnCountdown = new Button(shell, SWT.NONE);
		btnCountdown.setBounds(116, 202, 176, 44);
		btnCountdown.setText("Countdown");
		
		Button btnAlert = new Button(shell, SWT.NONE);
		btnAlert.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnAlert.setBounds(203, 152, 136, 44);
		btnAlert.setText("Alert");
		
		Label lblShowTitleHour = new Label(shell, SWT.NONE);
		lblShowTitleHour.setBounds(61, 42, 55, 15);
		lblShowTitleHour.setText("Hour");
		
		Label lblShowTitleMinute = new Label(shell, SWT.NONE);
		lblShowTitleMinute.setBounds(184, 42, 55, 15);
		lblShowTitleMinute.setText("Minute");
		
		Label lblShowTitleSecond = new Label(shell, SWT.NONE);
		lblShowTitleSecond.setBounds(300, 42, 55, 15);
		lblShowTitleSecond.setText("Second");
		
		tbShowHour = new Text(shell, SWT.BORDER);
		tbShowHour.setBounds(42, 63, 76, 60);
		
		tbShowMinute = new Text(shell, SWT.BORDER);
		tbShowMinute.setBounds(167, 63, 76, 60);
		
		tbShowSecond = new Text(shell, SWT.BORDER);
		tbShowSecond.setBounds(279, 63, 76, 60);

	}
}
