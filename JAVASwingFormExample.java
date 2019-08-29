package swing_1;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.Stream;
import java.awt.event.ActionEvent; 
import java.awt.*; 
import javax.swing.*;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class JAVASwingFormExample{

	public Hashtable<String,ArrayList<String>> hash;
	public JTextArea textArea_1;
	public JScrollPane scroll;
	public JTextField textField;
	public JFileChooser jFileChooser;
	public JFrame frame;
	public JButton btnSubmit;
	public File tempFile;
	public File fileName;
	
	public String ABFinalColor;
	public String CFinalColor;
	public String DEFGFinalColor;
	public String HIFinalColor;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JAVASwingFormExample window = new JAVASwingFormExample();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JAVASwingFormExample() throws IOException, ParseException{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws IOException, ParseException{
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblSingleSequence = new JLabel("Sequence Entry");
		lblSingleSequence.setForeground(Color.MAGENTA);
		lblSingleSequence.setBounds(65, 31, 130, 14);
		frame.getContentPane().add(lblSingleSequence);
		textArea_1 = new JTextArea();
		
		textArea_1.setLineWrap(true);
		scroll = new JScrollPane (textArea_1);
		scroll.setBounds(205, 31, 700, 170);
		frame.getContentPane().add(scroll);

		JButton btnFile = new JButton("Choose File");
		//btnFile.setBackground(Color.BLUE);
		btnFile.setForeground(Color.MAGENTA);
		btnFile.setBounds(65, 250, 120, 23);
		frame.getContentPane().add(btnFile);

		textField = new JTextField ("");
		textField.setBounds(205, 250, 700, 23);
		frame.getContentPane().add(textField);

		JLabel lblNumbering = new JLabel("Numbering Scheme");
		lblNumbering.setForeground(Color.MAGENTA);
		lblNumbering.setBounds(65, 320, 120, 14);
		frame.getContentPane().add(lblNumbering);

		JLabel lblKabat = new JLabel("Kabat-default");
		lblKabat.setBounds(210, 320, 100, 14);
		frame.getContentPane().add(lblKabat);

		JLabel lblChotia = new JLabel("Chotia");
		lblChotia.setBounds(430, 320, 46, 14);
		frame.getContentPane().add(lblChotia);

		JLabel lblImgt = new JLabel("IMGT");
		lblImgt.setBounds(595, 320, 46, 14);
		frame.getContentPane().add(lblImgt);

		JLabel lblMartin = new JLabel("Martin");
		lblMartin.setBounds(750, 320, 46, 14);
		frame.getContentPane().add(lblMartin);

		JLabel lblAHo = new JLabel("AHo");
		lblAHo.setBounds(905, 320, 46, 14);
		frame.getContentPane().add(lblAHo);

		JRadioButton radioButton = new JRadioButton("");
		radioButton.setBounds(315, 320, 109, 23);
		radioButton.setActionCommand("Kabat-default");
		frame.getContentPane().add(radioButton);

		JRadioButton radioButton_2 = new JRadioButton("");
		radioButton_2.setBounds(481, 320, 109, 23);
		radioButton_2.setActionCommand("Chotia");
		frame.getContentPane().add(radioButton_2);

		JRadioButton radioButton_3 = new JRadioButton("");
		radioButton_3.setBounds(641, 320, 109, 23);
		radioButton_3.setActionCommand("IMGT");
		frame.getContentPane().add(radioButton_3);

		JRadioButton radioButton_4 = new JRadioButton("");
		radioButton_4.setBounds(796, 320, 109, 23);
		radioButton_4.setActionCommand("Martin");
		frame.getContentPane().add(radioButton_4);

		JRadioButton radioButton_5 = new JRadioButton("");
		radioButton_5.setBounds(951, 320, 109, 23);
		radioButton_5.setActionCommand("AHo");
		frame.getContentPane().add(radioButton_5);

		ButtonGroup group = new ButtonGroup();
		group.add(radioButton);
		group.add(radioButton_2);
		group.add(radioButton_3);
		group.add(radioButton_4);
		group.add(radioButton_5);
		
		JLabel highlightColors = new JLabel("Pattern Highlights");
		highlightColors.setForeground(Color.MAGENTA);
		highlightColors.setBounds(65, 370, 120, 14);
		frame.getContentPane().add(highlightColors);
		
		JLabel ABProblem = new JLabel("ABProblem");
		ABProblem.setBounds(205, 370, 109, 23);
		frame.getContentPane().add(ABProblem);
		
		JLabel CProblem = new JLabel("CProblem");
		CProblem.setBounds(205, 400, 109, 23);
		frame.getContentPane().add(CProblem);
		
		JLabel DEFGProblem = new JLabel("DEFGProblem");
		DEFGProblem.setBounds(205, 430, 109, 23);
		frame.getContentPane().add(DEFGProblem);
		
		JLabel HIProblem = new JLabel("HIProblem");
		HIProblem.setBounds(205, 460, 109, 23);
		frame.getContentPane().add(HIProblem);
		
		String[] colors = { "green", "red", "cyan", "magenta", "none"};
		JComboBox ABColor = new JComboBox(colors);
		ABColor.setBounds(350, 370, 109, 23);
		ABColor.setSelectedIndex(4);
		frame.getContentPane().add(ABColor);
		
		JComboBox CColor = new JComboBox(colors);
		CColor.setBounds(350, 400, 109, 23);
		CColor.setSelectedIndex(4);
		frame.getContentPane().add(CColor);
		
		JComboBox DEFGColor = new JComboBox(colors);
		DEFGColor.setBounds(350, 430, 109, 23);
		DEFGColor.setSelectedIndex(4);
		frame.getContentPane().add(DEFGColor);
		
		JComboBox HIColor = new JComboBox(colors);
		HIColor.setBounds(350, 460, 109, 23);
		HIColor.setSelectedIndex(4);
		frame.getContentPane().add(HIColor);
		
		
		/*ButtonGroup checkBoxes = new ButtonGroup();
		checkBoxes.add(ABProblem);
		checkBoxes.add(CProblem);
		checkBoxes.add(DEFGProblem);
		checkBoxes.add(HIProblem);*/
		//System.out.println(checkBoxes.getSelection().getActionCommand());
		
		JButton btnClear = new JButton("Clear");
		btnClear.setForeground(Color.MAGENTA);
		btnClear.setBounds(312, 600, 89, 23);
		frame.getContentPane().add(btnClear);

		btnSubmit = new JButton("submit");
		btnSubmit.setBackground(Color.BLUE);
		btnSubmit.setForeground(Color.MAGENTA);
		btnSubmit.setBounds(65, 600, 89, 23);
		frame.getContentPane().add(btnSubmit);


		btnFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jFileChooser = new JFileChooser();
				jFileChooser.setCurrentDirectory(null);
				int result = jFileChooser.showOpenDialog(new JFrame());
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = jFileChooser.getSelectedFile();
					textField.setText(selectedFile.getAbsolutePath());
				}
			}
		});

		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				if((textArea_1.getText().isEmpty() && textField.getText().isEmpty())||((radioButton_5.isSelected())&&(radioButton_4.isSelected())&&(radioButton_3.isSelected())&&(radioButton_2.isSelected())&&(radioButton.isSelected())))
					JOptionPane.showMessageDialog(null, "Data Missing");
				else if(((!radioButton_5.isSelected())&&(!radioButton_4.isSelected())&&(!radioButton_3.isSelected())&&(!radioButton_2.isSelected())&&(!radioButton.isSelected()))) {
					JOptionPane.showMessageDialog(null, "Choose a numbering scheme");
				}
				else if (!textArea_1.getText().isEmpty() && !textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Choose either file upload or manually enter sequence");
				}
				else if (textField.getText().isEmpty() && !textArea_1.getText().isEmpty()){
					try {
						tempFile = File.createTempFile("Sequence", ".tmp");
					} catch (IOException e) {
						e.printStackTrace();
					}
					String sequenceEntry = textArea_1.getText();
					BufferedWriter writer;
					try {
						writer = new BufferedWriter(new FileWriter(tempFile));
						writer.write(sequenceEntry);				     
						writer.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						hash = getHash();
					} catch (ParseException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//System.out.println(ABColor.getSelectedItem().toString() + " " + CColor.getSelectedItem().toString() + " " + DEFGColor.getSelectedItem().toString());
					ABFinalColor = ABColor.getSelectedItem().toString();
					CFinalColor = CColor.getSelectedItem().toString();
					DEFGFinalColor = DEFGColor.getSelectedItem().toString();
					HIFinalColor = HIColor.getSelectedItem().toString();
					
					if (ABFinalColor.equals("green")) {
						ABFinalColor = "darkYellow";
					}
					if (CFinalColor.equals("green")) {
						CFinalColor = "darkYellow";
					}
					if (DEFGFinalColor.equals("green")) {
						DEFGFinalColor = "darkYellow";
					}
					if (HIFinalColor.equals("green")) {
						HIFinalColor = "darkYellow";
					}
					String selection = group.getSelection().getActionCommand();
					highlightSequence(hash, selection, ABFinalColor, CFinalColor, DEFGFinalColor, HIFinalColor);
	/*delete file*/	tempFile.delete();
					JOptionPane.showMessageDialog(null, "Data Submitted");
				}
				else if (!textField.getText().isEmpty() && textArea_1.getText().isEmpty()){
					try {
						hash = getHash();
					} catch (ParseException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					fileName = jFileChooser.getSelectedFile();
					ABFinalColor = ABColor.getSelectedItem().toString();
					CFinalColor = CColor.getSelectedItem().toString();
					DEFGFinalColor = DEFGColor.getSelectedItem().toString();
					HIFinalColor = HIColor.getSelectedItem().toString();
					
					if (ABFinalColor.equals("green")) {
						ABFinalColor = "darkYellow";
					}
					if (CFinalColor.equals("green")) {
						CFinalColor = "darkYellow";
					}
					if (DEFGFinalColor.equals("green")) {
						DEFGFinalColor = "darkYellow";
					}
					if (HIFinalColor.equals("green")) {
						HIFinalColor = "darkYellow";
					}
					String selection = group.getSelection().getActionCommand();
					highlightSequence(hash, selection, ABFinalColor, CFinalColor, DEFGFinalColor, HIFinalColor);
					JOptionPane.showMessageDialog(null, "Data Submitted");
				}

			}
		});

		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textArea_1.setText(null);
				radioButton.setSelected(false);
				radioButton_2.setSelected(false);
				radioButton_3.setSelected(false);
				radioButton_4.setSelected(false);
				radioButton_5.setSelected(false);	
				group.clearSelection();
				ABColor.setSelectedIndex(4);
				CColor.setSelectedIndex(4);
				DEFGColor.setSelectedIndex(4);
				HIColor.setSelectedIndex(4);
			}
		});

		//BEGINNING OF NEXT STEP
	}

	public ArrayList<Integer> sequenceSize(Hashtable<String,ArrayList<String>> hash) {
		return null;
		
	}
	public void highlightSequence(Hashtable<String,ArrayList<String>> hash, String selection, String ABFinalColor, String CFinalColor, String DEFGFinalColor, String HIFinalColor) {
		XWPFDocument newDoc = new XWPFDocument(); //Doc to write new doc to
		XWPFParagraph para = newDoc.createParagraph(); //Paragraph
		XWPFRun run = para.createRun();  //Where the text will be written from
		ArrayList<String> chainType = hash.get("chain_type");
		boolean problemDEFG = false;
		boolean problemAB = false;
		int ABTracker = 0;
		boolean invalidChar = false;
		boolean priortyProblem = false;
		boolean hallmark = false;
		int cIterate = 0;
		int seqCount = 1;
		int lines = hash.get(String.valueOf(seqCount)).size();
		ArrayList<String> hallmarkResidue = new ArrayList<String>();
		
		for (cIterate = 0; cIterate < lines; cIterate++) {
			seqCount = 1;
			problemDEFG = false;
			problemAB = false;
			ABTracker = 0;
			invalidChar = false;
			priortyProblem = false;
			run = para.createRun();
			
			String identifer = hash.get("Id").get(cIterate);
			run.setText(">" + identifer);
			run.addBreak();
			try {
				while(hash.get(String.valueOf(seqCount)).get(cIterate) != null){
					run = para.createRun();	
					//System.out.println(seqCount + " " + (hash.get(String.valueOf(seqCount)).get(0)));
	/*Kabat*/		if (selection.equals("Kabat-default")){
						//System.out.print(subtract);
		/*Light*/		if(chainType.get(cIterate).equals("L")){					
		/*CDR1*/			if (!hash.get(String.valueOf(seqCount)).get(cIterate).equals("-") && (seqCount >= 24) && (seqCount <= 34)) {
								run.setTextHighlightColor("yellow");
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equals("W")) {
									run.setTextHighlightColor(HIFinalColor);
								}
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equals("M")) {
									run.setTextHighlightColor(HIFinalColor);
								}
							}
		/*CDR2*/			if (!hash.get(String.valueOf(seqCount)).get(cIterate).equals("-") && (seqCount >= 50) && (seqCount <= 56)) {
								run.setTextHighlightColor("yellow");
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equals("W")) {
									run.setTextHighlightColor(HIFinalColor);
								}
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equals("M")) {
									run.setTextHighlightColor(HIFinalColor);
								}
							}
		/*CDR3*/			if (!hash.get(String.valueOf(seqCount)).get(cIterate).equals("-") && (seqCount >= 89) && (seqCount <= 97)) {
								run.setTextHighlightColor("yellow");
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equals("W")) {
									run.setTextHighlightColor(HIFinalColor);
								}
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equals("M")) {
									run.setTextHighlightColor(HIFinalColor);
								}
							}
		
	/*hallmark*/			if (seqCount == 23 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("C")) {
								hallmarkResidue.add("Missing C at position 23 in Kabat light chain");
								hallmark = true;
							}
							if (seqCount == 35 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
								hallmarkResidue.add("Missing W at position 35 in Kabat light chain");
								hallmark = true;
							}
							if (seqCount == 88 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("C")) {
								hallmarkResidue.add("Missing C at position 88 in Kabat light chain");
								hallmark = true;
							}
							if (seqCount == 98 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("F")) {
								hallmarkResidue.add("Missing F at position 98 in Kabat light chain");
								hallmark = true;
							}
						}
	
		/*Heavy*/		else if(chainType.get(cIterate).equals("H")){
		/*CDR1*/			if ((!hash.get(String.valueOf(seqCount)).get(cIterate).equals("-")) && (seqCount >= 30) && (seqCount < 36)) {
								run.setTextHighlightColor("yellow");
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
									run.setTextHighlightColor(HIFinalColor);
								}
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("M")) {
									run.setTextHighlightColor(HIFinalColor);
								}
							}
		/*CDR2*/			if (!hash.get(String.valueOf(seqCount)).get(cIterate).equals("-") && (seqCount >= 50) && (seqCount <= 65)) {
								run.setTextHighlightColor("yellow");
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
									run.setTextHighlightColor(HIFinalColor);
								}
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("M")) {
									run.setTextHighlightColor(HIFinalColor);
								}
							}
		/*CDR3*/			if (!hash.get(String.valueOf(seqCount)).get(cIterate).equals("-") && (seqCount >= 95) && (seqCount <= 102)) {
								run.setTextHighlightColor("yellow");
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
									run.setTextHighlightColor(HIFinalColor);
								}
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("M")) {
									run.setTextHighlightColor(HIFinalColor);
								}
							}
				
	/*hallmark*/			if (seqCount == 22 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("C")) {
								hallmarkResidue.add("Missing C at position 22 in Kabat heavy chain");
								hallmark = true;
							}
							if (seqCount == 36 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
								hallmarkResidue.add("Missing W at position 36 in Kabat heavy chain");
								hallmark = true;
							}
							if (seqCount == 92 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("C")) {
								hallmarkResidue.add("Missing C at position 92 in Kabat heavy chain");
								hallmark = true;
							}
							if (seqCount == 103 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
								hallmarkResidue.add("Missing F at position 103 in Kabat heavy chain");
								hallmark = true;
							}
						}
					}
	/*Chotia*/		else if (selection.equals("Chotia")){
						//System.out.print(subtract);
		/*Light*/		if(chainType.get(cIterate).equals("L")){					
		/*CDR1*/			if (!hash.get(String.valueOf(seqCount)).get(cIterate).equals("-") && (seqCount >= 26) && (seqCount <= 32)) {
								run.setTextHighlightColor("yellow");
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
									run.setTextHighlightColor(HIFinalColor);
								}
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("M")) {
									run.setTextHighlightColor(HIFinalColor);
								}
							}
		/*CDR2*/			if (!hash.get(String.valueOf(seqCount)).get(cIterate).equals("-") && (seqCount >= 50) && (seqCount <= 52)) {
								run.setTextHighlightColor("yellow");
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
									run.setTextHighlightColor(HIFinalColor);
								}
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("M")) {
									run.setTextHighlightColor(HIFinalColor);
								}
							}
		/*CDR3*/			if (!hash.get(String.valueOf(seqCount)).get(cIterate).equals("-") && (seqCount >= 91) && (seqCount <= 96)) {
								run.setTextHighlightColor("yellow");
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
									run.setTextHighlightColor(HIFinalColor);
								}
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("M")) {
									run.setTextHighlightColor(HIFinalColor);
								}
							}
		
		/*hallmark*/		if (seqCount == 23 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("C")) {
								hallmarkResidue.add("Missing C at position 23 in Chotia light chain");
								hallmark = true;
							}
							if (seqCount == 35 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
								hallmarkResidue.add("Missing W at position 35 in Chotia light chain");
								hallmark = true;
							}
							if (seqCount == 88 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("C")) {
								hallmarkResidue.add("Missing C at position 88 in Chotia light chain");
								hallmark = true;
							}
							if (seqCount == 98 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("F")) {
								hallmarkResidue.add("Missing F at position 98 in Chotia light chain");
								hallmark = true;
							}
						}
	
		/*Heavy*/		else if(chainType.get(cIterate).equals("H")){
		/*CDR1*/			if ((!hash.get(String.valueOf(seqCount)).get(cIterate).equals("-")) && (seqCount >= 26) && (seqCount <= 32)) {
								run.setTextHighlightColor("yellow");
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
									run.setTextHighlightColor(HIFinalColor);
								}
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("M")) {
									run.setTextHighlightColor(HIFinalColor);
								}
							}
		/*CDR2*/			if (!hash.get(String.valueOf(seqCount)).get(cIterate).equals("-") && (seqCount >= 52) && (seqCount <= 56)) {
								run.setTextHighlightColor("yellow");
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
									run.setTextHighlightColor(HIFinalColor);
								}
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("M")) {
									run.setTextHighlightColor(HIFinalColor);
								}
							}	
		/*CDR3*/			if (!hash.get(String.valueOf(seqCount)).get(cIterate).equals("-") && (seqCount >= 95) && (seqCount <= 102)) {
								run.setTextHighlightColor("yellow");
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
									run.setTextHighlightColor(HIFinalColor);
								}
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("M")) {
									run.setTextHighlightColor(HIFinalColor);
								}
							}
		
		/*hallmark*/		if (seqCount == 22 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("C")) {
								hallmarkResidue.add("Missing C at position 22 in Chotia heavy chain");
								hallmark = true;
							}
							if (seqCount == 36 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
								hallmarkResidue.add("Missing W at position 36 in Chotia heavy chain");
								hallmark = true;
							}
							if (seqCount == 92 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("C")) {
								hallmarkResidue.add("Missing C at position 92 in Chotia heavy chain");
								hallmark = true;
							}
							if (seqCount == 103 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
								hallmarkResidue.add("Missing F at position 103 in Chotia heavy chain");
								hallmark = true;
							}
						}
					}
	/*IMGT*/		else if (selection.equals("IMGT")){
		/*Light*/		if(chainType.get(cIterate).equals("L")){					
		/*CDR1*/			if (!hash.get(String.valueOf(seqCount)).get(cIterate).equals("-") && (seqCount >= 27) && (seqCount <= 38)) {
								run.setTextHighlightColor("yellow");
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
									run.setTextHighlightColor(HIFinalColor);
								}
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("M")) {
									run.setTextHighlightColor(HIFinalColor);
								}
							}
		/*CDR2*/			if (!hash.get(String.valueOf(seqCount)).get(cIterate).equals("-") && (seqCount >= 56) && (seqCount <= 65)) {
								run.setTextHighlightColor("yellow");
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
									run.setTextHighlightColor(HIFinalColor);
								}
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("M")) {
									run.setTextHighlightColor(HIFinalColor);
								}
							}
		/*CDR3*/			if (!hash.get(String.valueOf(seqCount)).get(cIterate).equals("-") && (seqCount >= 105) && (seqCount <= 117)) {
								run.setTextHighlightColor("yellow");
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
									run.setTextHighlightColor(HIFinalColor);
								}
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("M")) {
									run.setTextHighlightColor(HIFinalColor);
								}
							}
		
		/*hallmark*/		if (seqCount == 23 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("C")) {
								hallmarkResidue.add("Missing C at position 23 in IMGT light chain");
								hallmark = true;
							}
							if (seqCount == 41 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
								hallmarkResidue.add("Missing W at position 41 in IMGT light chain");
								hallmark = true;
							}
							if (seqCount == 104 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("C")) {
								hallmarkResidue.add("Missing C at position 104 in IMGT light chain");
								hallmark = true;
							}
							if (seqCount == 118 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("F")) {
								hallmarkResidue.add("Missing F at position 118 in IMGT light chain");
								hallmark = true;
							}
						}
	
		/*Heavy*/		else if(chainType.get(cIterate).equals("H")){
		/*CDR1*/			if ((!hash.get(String.valueOf(seqCount)).get(cIterate).equals("-")) && (seqCount >= 27) && (seqCount <= 38)) {
								run.setTextHighlightColor("yellow");
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
									run.setTextHighlightColor(HIFinalColor);
								}
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("M")) {
									run.setTextHighlightColor(HIFinalColor);
								}
							}
		/*CDR2*/			if (!hash.get(String.valueOf(seqCount)).get(cIterate).equals("-") && (seqCount >= 56) && (seqCount <= 65)) {
								run.setTextHighlightColor("yellow");
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
									run.setTextHighlightColor(HIFinalColor);
								}
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("M")) {
									run.setTextHighlightColor(HIFinalColor);
								}
							}	
		/*CDR3*/			if (!hash.get(String.valueOf(seqCount)).get(cIterate).equals("-") && (seqCount >= 105) && (seqCount <= 117)) {
								run.setTextHighlightColor("yellow");
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
									run.setTextHighlightColor(HIFinalColor);
								}
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("M")) {
									run.setTextHighlightColor(HIFinalColor);
								}
							}
		
		/*hallmark*/		if (seqCount == 23 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("C")) {
								hallmarkResidue.add("Missing C at position 23 in IMGT heavy chain");
								hallmark = true;
							}
							if (seqCount == 41 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
								hallmarkResidue.add("Missing W at position 41 in IMGT heavy chain");
								hallmark = true;
							}
							if (seqCount == 104 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("C")) {
								hallmarkResidue.add("Missing C at position 104 in IMGT heavy chain");
								hallmark = true;
							}
							if (seqCount == 118 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
								hallmarkResidue.add("Missing F at position 118 in IMGT heavy chain");
								hallmark = true;
							}
						}
					}
	/*Martin*/		else if (selection.equals("Martin")){
		/*Light*/		if(chainType.get(cIterate).equals("L")){					
		/*CDR1*/			if (!hash.get(String.valueOf(seqCount)).get(cIterate).equals("-") && (seqCount >= 30) && (seqCount <= 34)) {
								run.setTextHighlightColor("yellow");
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
									run.setTextHighlightColor(HIFinalColor);
								}
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("M")) {
									run.setTextHighlightColor(HIFinalColor);
								}
							}
		/*CDR2*/			if (!hash.get(String.valueOf(seqCount)).get(cIterate).equals("-") && (seqCount >= 46) && (seqCount <= 55)) {
								run.setTextHighlightColor("yellow");
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
									run.setTextHighlightColor(HIFinalColor);
								}
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("M")) {
									run.setTextHighlightColor(HIFinalColor);
								}
							}
		/*CDR3*/			if (!hash.get(String.valueOf(seqCount)).get(cIterate).equals("-") && (seqCount >= 89) && (seqCount <= 97)) {
								run.setTextHighlightColor("yellow");
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
									run.setTextHighlightColor(HIFinalColor);
								}
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("M")) {
									run.setTextHighlightColor(HIFinalColor);
								}
							}
		
		/*hallmark*/		if (seqCount == 23 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("C")) {
								hallmarkResidue.add("Missing C at position 23 in Martin light chain");
								hallmark = true;
							}
							if (seqCount == 35 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
								hallmarkResidue.add("Missing W at position 35 in Martin light chain");
								hallmark = true;
							}
							if (seqCount == 88 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("C")) {
								hallmarkResidue.add("Missing C at position 88 in Martin light chain");
								hallmark = true;
							}
							if (seqCount == 98 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("F")) {
								hallmarkResidue.add("Missing F at position 98 in Martin light chain");
								hallmark = true;
							}
						}
	
		/*Heavy*/		else if(chainType.get(cIterate).equals("H")){
		/*CDR1*/			if ((!hash.get(String.valueOf(seqCount)).get(cIterate).equals("-")) && (seqCount >= 30) && (seqCount <= 35)) {
								run.setTextHighlightColor("yellow");
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
									run.setTextHighlightColor(HIFinalColor);
								}
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("M")) {
									run.setTextHighlightColor(HIFinalColor);
								}
							}
		/*CDR2*/			if (!hash.get(String.valueOf(seqCount)).get(cIterate).equals("-") && (seqCount >= 47) && (seqCount <= 58)) {
								run.setTextHighlightColor("yellow");
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
									run.setTextHighlightColor(HIFinalColor);
								}
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("M")) {
									run.setTextHighlightColor(HIFinalColor);
								}
							}	
		/*CDR3*/			if (!hash.get(String.valueOf(seqCount)).get(cIterate).equals("-") && (seqCount >= 95) && (seqCount <= 101)) {
								run.setTextHighlightColor("yellow");
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
									run.setTextHighlightColor(HIFinalColor);
								}
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("M")) {
									run.setTextHighlightColor(HIFinalColor);
								}
							}
		
		/*hallmark*/		if (seqCount == 22 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("C")) {
								hallmarkResidue.add("Missing C at position 22 in Martin heavy chain");
								hallmark = true;
							}
							if (seqCount == 36 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
								hallmarkResidue.add("Missing W at position 36 in Martin heavy chain");
								hallmark = true;
							}
							if (seqCount == 92 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("C")) {
								hallmarkResidue.add("Missing C at position 92 in Martin heavy chain");
								hallmark = true;
							}
							if (seqCount == 103 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
								hallmarkResidue.add("Missing F at position 103 in Martin heavy chain");
								hallmark = true;
							}
						}
					}
	/*AHo*/			else if (selection.equals("AHo")){
		/*Light*/		if(chainType.get(cIterate).equals("L")){					
		/*CDR1*/			if (!hash.get(String.valueOf(seqCount)).get(cIterate).equals("-") && (seqCount >= 25) && (seqCount <= 40)) {
								run.setTextHighlightColor("yellow");
								if (hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W") && !HIFinalColor.equals("none")) {
									run.setTextHighlightColor(HIFinalColor);
								}
								if (hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("M") && !HIFinalColor.equals("none")) {
									run.setTextHighlightColor(HIFinalColor);
								}
							}
		/*CDR2*/			if (!hash.get(String.valueOf(seqCount)).get(cIterate).equals("-") && (seqCount >= 58) && (seqCount <= 77)) {
								run.setTextHighlightColor("yellow");
								if (hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W") && !HIFinalColor.equals("none")) {
									run.setTextHighlightColor(HIFinalColor);
								}
								if (hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("M") && !HIFinalColor.equals("none")) {
									run.setTextHighlightColor(HIFinalColor);
								}
							}
		/*CDR3*/			if (!hash.get(String.valueOf(seqCount)).get(cIterate).equals("-") && (seqCount >= 109) && (seqCount <= 137)) {
								run.setTextHighlightColor("yellow");
								if (hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W") && !HIFinalColor.equals("none")) {
									run.setTextHighlightColor(HIFinalColor);
								}
								if (hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("M") && !HIFinalColor.equals("none")) {
									run.setTextHighlightColor(HIFinalColor);
								}
							}
		
		/*hallmark*/		if (seqCount == 23 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("C")) {
								hallmarkResidue.add("Missing C at position 23 in AHo light chain");
								hallmark = true;
							}
							if (seqCount == 43 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
								hallmarkResidue.add("Missing W at position 43 in AHo light chain");
								hallmark = true;
							}
							if (seqCount == 106 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("C")) {
								hallmarkResidue.add("Missing C at position 106 in AHo light chain");
								hallmark = true;
							}
							if (seqCount == 139 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("F")) {
								hallmarkResidue.add("Missing F at position 139 in AHo light chain");
								hallmark = true;
							}
						}
	
		/*Heavy*/		else if(chainType.get(cIterate).equals("H")){
		/*CDR1*/			if ((!hash.get(String.valueOf(seqCount)).get(cIterate).equals("-")) && (seqCount >= 25) && (seqCount <= 40)) {
								run.setTextHighlightColor("yellow");
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
									run.setTextHighlightColor(HIFinalColor);
								}
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("M")) {
									run.setTextHighlightColor(HIFinalColor);
								}
							}
		/*CDR2*/			if (!hash.get(String.valueOf(seqCount)).get(cIterate).equals("-") && (seqCount >= 58) && (seqCount <= 77)) {
								run.setTextHighlightColor("yellow");
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
									run.setTextHighlightColor(HIFinalColor);
								}
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("M")) {
									run.setTextHighlightColor(HIFinalColor);
								}
							}	
		/*CDR3*/			if (!hash.get(String.valueOf(seqCount)).get(cIterate).equals("-") && (seqCount >= 109) && (seqCount <= 137)) {
								run.setTextHighlightColor("yellow");
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
									run.setTextHighlightColor(HIFinalColor);
								}
								if (!HIFinalColor.equals("none") && hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("M")) {
									run.setTextHighlightColor(HIFinalColor);
								}
							}
		
		/*hallmark*/		if (seqCount == 23 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("C")) {
								hallmarkResidue.add("Missing C at position 23 in AHo heavy chain");
								hallmark = true;
							}
							if (seqCount == 43 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
								hallmarkResidue.add("Missing W at position 43 in AHo heavy chain");
								hallmark = true;
							}
							if (seqCount == 106 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("C")) {
								hallmarkResidue.add("Missing C at position 106 in AHo heavy chain");
								hallmark = true;
							}
							if (seqCount == 139 && !hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("W")) {
								hallmarkResidue.add("Missing F at position 139 in AHo heavy chain");
								hallmark = true;
							}
						}
					}
	
	/*Problems*/	if (!CFinalColor.equals("none")) {
						switch (selection) {
							case "Kabat-default":
								if (chainType.get(cIterate).equals("L")) {
									if (hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("C") && seqCount != 23 && seqCount != 88) {
										run.setTextHighlightColor(CFinalColor);
										priortyProblem = true;
									}
								}
								else if (chainType.get(cIterate).equals("H")) {
									if (hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("C") && seqCount != 22 && seqCount != 92) {
										run.setTextHighlightColor(CFinalColor);
										priortyProblem = true;
									}
								}
								break;
							case "Chotia":
								if (chainType.get(cIterate).equals("L")) {
									if (hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("C") && seqCount != 23 && seqCount != 88) {
										run.setTextHighlightColor(CFinalColor);
										priortyProblem = true;
									}
								}
								else if (chainType.get(cIterate).equals("H")) {
									if (hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("C") && seqCount != 22 && seqCount != 92) {
										run.setTextHighlightColor(CFinalColor);
										priortyProblem = true;
									}
								}
								break;
							case "IMGT":
								if (chainType.get(cIterate).equals("L")) {
									if (hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("C") && seqCount != 23 && seqCount != 104) {
										run.setTextHighlightColor(CFinalColor);
										priortyProblem = true;
									}
								}
								else if (chainType.get(cIterate).equals("H")) {
									if (hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("C") && seqCount != 23 && seqCount != 104) {
										run.setTextHighlightColor(CFinalColor);
										priortyProblem = true;
									}
								}
								break;
							case "Martin":
								if (chainType.get(cIterate).equals("L")) {
									if (hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("C") && seqCount != 23 && seqCount != 88) {
										run.setTextHighlightColor(CFinalColor);
										priortyProblem = true;
									}
								}
								else if (chainType.get(cIterate).equals("H")) {
									if (hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("C") && seqCount != 22 && seqCount != 92) {
										run.setTextHighlightColor(CFinalColor);
										priortyProblem = true;
									}
								}
								break;
							case "AHo":
								if (chainType.get(cIterate).equals("L")) {
									if (hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("C") && seqCount != 23 && seqCount != 106) {
										run.setTextHighlightColor(CFinalColor);
										priortyProblem = true;
									}
								}
								else if (chainType.get(cIterate).equals("H")) {
									if (hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("C") && seqCount != 23 && seqCount != 106) {
										run.setTextHighlightColor(CFinalColor);
										priortyProblem = true;
									}
								}
								break;
							default:
								priortyProblem = false;
						}
					}
					if (!ABFinalColor.equals("none")) {
						if (problemAB) {
							run.setTextHighlightColor(ABFinalColor);
							if (ABTracker == 2) {
								problemAB = false;
								ABTracker = 0;
							}
							else
								ABTracker++;
							//run.setText(hash.get(String.valueOf(seqCount)).get(cIterate)); 
							//run.setFontFamily("Courier");
							//seqCount++;
							//if (seqCount + 1 <= subtract)
							//	continue;
							System.out.println("Problem AB: " + seqCount);
						}
						try {
							if (hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("N") && (!hash.get(String.valueOf(seqCount + 1)).get(cIterate).matches(".*[BJOUZ].*") && !hash.get(String.valueOf(seqCount + 1)).get(cIterate).equalsIgnoreCase("P")) && (hash.get(String.valueOf(seqCount + 2)).get(cIterate).equalsIgnoreCase("T") || hash.get(String.valueOf(seqCount + 2)).get(cIterate).equalsIgnoreCase("S"))) {
								run.setTextHighlightColor(ABFinalColor);
								problemAB = true;
								ABTracker++;
							}
						}
						catch (IndexOutOfBoundsException e) {
							//System.out.println(seqCount + " ");
						}
					}
					//finish doing this for every problem
					if (!DEFGFinalColor.equals("none")) {
						if (problemDEFG) {
							run.setTextHighlightColor(DEFGFinalColor);
							problemDEFG = false;
							//run.setText(hash.get(String.valueOf(seqCount)).get(cIterate)); 
							//run.setFontFamily("Courier");
							//seqCount++;
						
							//if (seqCount + 1 <= subtract)
							//	continue;
						}
						
						if (hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("D") && (hash.get(String.valueOf(seqCount + 1)).get(cIterate).equalsIgnoreCase("G") || hash.get(String.valueOf(seqCount + 1)).get(cIterate).equalsIgnoreCase("N") || hash.get(String.valueOf(seqCount + 1)).get(cIterate).equalsIgnoreCase("S") || hash.get(String.valueOf(seqCount + 1)).get(cIterate).equalsIgnoreCase("T"))) {
							run.setTextHighlightColor(DEFGFinalColor);
							problemDEFG = true;
						}
					}
					if (hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("B") || hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("J") || hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("O") || hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("U") || hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("Z") || hash.get(String.valueOf(seqCount)).get(cIterate).equalsIgnoreCase("X")) {
						run.setTextHighlightColor("green");
						invalidChar = true;
					}
					
					if (!hash.get(String.valueOf(seqCount)).get(cIterate).equals("-")) {
						run.setText(hash.get(String.valueOf(seqCount)).get(cIterate)); 
						run.setFontFamily("Courier");
					}
					invalidChar = false;
					seqCount++;
				}
			}
			catch (NullPointerException e) {
				
			}
			catch (IndexOutOfBoundsException e) {
				
			}
			if (hallmark) {				
				for (int i = 0; i < hallmarkResidue.size(); i++) {
					run.addBreak();
					//run.addBreak();
					run = para.createRun();
					run.setText(hallmarkResidue.get(i));
					if (i == hallmarkResidue.size() - 1)
						run.addBreak();
				}
				hallmarkResidue.clear();
				hallmark = false;
			}
			run.addBreak();
		}
		try {
			newDoc.write(new FileOutputStream(new File("C:\\Users\\Vishnu\\Documents\\createparagraph.docx")));

			//View our document
			if(Desktop.isDesktopSupported()){
				Desktop.getDesktop().open(new File("C:\\Users\\Vishnu\\Documents\\createparagraph.docx"));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} //save*/
	}

	public static Hashtable<String,ArrayList<String>> getHash() throws ParseException, IOException{
		// TODO Auto-generated method stub
		int z = 0;
		int y = 0;
		int counter = 0;
		int keyCounter = 0;
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Vishnu\\Downloads\\test_H.csv"));
		List<String> lines = new ArrayList<>();
	    String line =  null;
	    Hashtable<String, ArrayList<String>> h = new Hashtable<String, ArrayList<String>>();
	   
	    
	    //System.out.println(map);
	    for (int i=0;i<1;i++)
	    {
	    	while((line=br.readLine())!=null && (counter !=1))
	    	{
	    		//lines.add(line);
	    		String str[] = line.split("\n");
	    		String label[] = str[i].split(",");
	    		
	    		for (int x=0;x<label.length;x++)
	    		{
		    			ArrayList<String> temp = new ArrayList<String>();
		    			if(z != 1)
		    			{	
		    				line = br.readLine();
		    			}
		    			//System.out.println(line);
		    			String s1[] = line.split(",");
		    			//System.out.println(s1.length);
		    			temp.add(s1[x]);
		    			//System.out.println(z);
		    			h.put(label[keyCounter], temp);
		    			//System.out.println(h);
		    			keyCounter++;
		    			z = 1;
		    			
	    		}
	    		keyCounter = 0;	
	    		line = br.readLine();
    			String s1[] = line.split(",");

	    		for (int x=0;x<s1.length;x++)
	    		{

	    			ArrayList<String> temp = new ArrayList<String>();
	    			/*if(y != 1)
	    			{	
	    				line = br.readLine();
	    			}*/
	    			//String s1[] = line.split(",");
	    			//System.out.println(s1[x]);
	    			putOne(h, label[keyCounter], s1[x]);
	    			keyCounter++;
	    			y = 1;
	    		}
	    		counter++;
	    		
	    	}
	    }
		return h;
	}

	public static void putOne(Hashtable<String,ArrayList<String>> h1, String key, String value)
	{
		ArrayList<String> list = h1.get(key);
        if (list == null) 
        {
            list = new ArrayList<String>();
            h1.put(key, list);
        }
        list.add(value);
        //System.out.println(h1);
	}
}