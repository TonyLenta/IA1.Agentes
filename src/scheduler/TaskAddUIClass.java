package scheduler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class TaskAddUIClass extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public JLabel burstLabel, arrivalLabel, deadlineLabel, notifyLabel;
	public JTextField burstText, arrivalText, deadlineText;
	public  JButton addButton, submitButton;
	private AddUIListener listener;
	
	public static final ArrayList<Task> taskList = new ArrayList<Task>();
	
	public TaskAddUIClass() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		pack();
		setupUI();
	}
	
	private void setupUI() {
		burstLabel = new JLabel();
		arrivalLabel = new JLabel();
		deadlineLabel = new JLabel();
		notifyLabel = new JLabel();
		
		burstText = new JTextField();
		arrivalText = new JTextField();
		deadlineText = new JTextField();
		
		addButton = new JButton();
		submitButton = new JButton();
		
		burstLabel.setText("Tiempo maximo ejecucion (Ci)");
		burstLabel.setBounds(100, 20, 100, 50);
		getContentPane().add(burstLabel);
		
		burstText.setBounds(200, 25, 100, 30);
		getContentPane().add(burstText);
		
		arrivalLabel.setText("Tiempo real de tarea (Ti)");
		arrivalLabel.setBounds(325, 20, 100, 50);
		getContentPane().add(arrivalLabel);
		
		arrivalText.setBounds(425, 25, 100, 30);
		getContentPane().add(arrivalText);
		
		deadlineLabel.setText("Tiempo de plazo maximo de terminacion (Di)");
		deadlineLabel.setBounds(550, 20, 100, 50);
		getContentPane().add(deadlineLabel);
		
		deadlineText.setBounds(650, 25, 100, 30);
		getContentPane().add(deadlineText);
		
		notifyLabel.setBounds(300, 75, 300, 50);
		getContentPane().add(notifyLabel);
		
		addButton.setText("Agregar comportamiento de agente");
		addButton.setBounds(200, 150, 100, 50);
		getContentPane().add(addButton);
		
		addButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String burst = burstText.getText();
				String arrival = arrivalText.getText();
				String deadline = deadlineText.getText();
				
				int burstTime = -10, arrivalTime = -10, deadlineTime = -10;
				
				
				if(burst == null || burst.equals("") || burst.equals("0")) {
					notifyError();
				}
				else {
					burstTime = Integer.parseInt(burst);
				}
				
				if(arrival == null || arrival.equals("")) {
					notifyError();
				}
				else {
					arrivalTime = Integer.parseInt(arrival);
				}
				
				if(deadline == null || deadline.equals("")) {
					notifyError();
				}
				else {
					deadlineTime = Integer.parseInt(deadline);
				}
				
				if(burstTime > 0 && arrivalTime >= 0 && deadlineTime > 0) {
					notifyAdded();
					taskList.add(new Task(burstTime, arrivalTime, deadlineTime));
					burstText.setText("");
					arrivalText.setText("");
					deadlineText.setText("");
				}
				else if(burst.equals("0") || arrival.equals("0") || deadline.equals("0")){
					notifyWrongValues();
				}
				else {
					notifyError();
				}
				
			}
		});
		
		submitButton.setText("Ejecutar comportamientos");
		submitButton.setBounds(400, 150, 150, 50);
		getContentPane().add(submitButton);
		
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(listener != null)
					listener.onAddActionSubmit(taskList);
			}
		});
		
	}
	
	public void notifyError() {
		notifyLabel.setText("All 3 fields must be filled");
	}
	
	public void notifyAdded() {
		notifyLabel.setText("Added Succesfully");
	}
	
	private void notifyWrongValues() {
		notifyLabel.setText("Wrong values as input");
	}
	
	public void setAddUIListener(AddUIListener listener) {
		this.listener = listener;
	}
	
	
        public interface AddUIListener {
		void onAddActionSubmit(ArrayList<Task> taskList);
	}
	
}
