
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SystemTestGUI extends Application
{
	//stage and scene attributes
	Stage stage;
	Scene scene, sceneC4;
	
	//declare attributes used
	 String response;
	 int memorySize;
	 double hardDiskSize;
	 double purchaseCost;
	 
	//create object from System class
	System st = new System("Dell", "Inspiron", 2);
	
	@Override
	public void start(Stage stage)
	{

		//create labels for choices
		Label menuTitle = new Label("System Program Menu");
		menuTitle.setTextFill(Color.DARKBLUE);
		menuTitle.setFont(Font.font("Helvetica", FontWeight.BOLD, 24));
		
		Label choice1 = new Label("Choice 1 – Print System Details");
		choice1.setFont(Font.font("Helvetica", 14));
		
		Label choice2 = new Label("Choice 2 - Display System Properties");
		choice2.setFont(Font.font("Helvetica", 14));
		
		Label choice3 = new Label("Choice 3 – Diagnose System");
		choice3.setFont(Font.font("Helvetica", 14));
		
		Label choice4 = new Label("Choice 4 – Set Details");
		choice4.setFont(Font.font("Helvetica", 14));
		
		//create and configure text field for input
		TextField choiceField = new TextField();
		choiceField.setMaxWidth(50);
		
		//create and configure non-editable text area to display results
		TextArea display = new TextArea();
		display.setEditable(false);
		display.setMinSize(440, 200);
		display.setMaxSize(440, 200);
		
		//create and configure non-editable text area to display results for choice 4
		Text displayChoice = new Text();
		displayChoice.setFont(Font.font("Helvetica", FontWeight.BOLD, 14));
		displayChoice.setFill(Color.RED);
	
		//create and configure labels for text fields
		Label choiceLabel = new Label("Enter your choice (e.g 1 for Choice 1)");
		choiceLabel.setFont(Font.font("Helvetica", FontWeight.BOLD, 14));
		
		//display alert on error for incorrect input
		Alert a = new Alert(AlertType.ERROR);
		a.setContentText("Please enter correct values" + "\n" +
					"Memory Size should be an integer." + "\n" +
					"Hard Disk Size and Purchase should be numeric."); 
		
		//create buttons to perform selection and display of choices
		Button okButton = new Button();
		okButton.setText("OK");
		okButton.setFont(Font.font("Helvetica"));
		okButton.setOnAction( e ->
							{
								response = choiceField.getText();
								//check if a value is selected
								if (response.isEmpty())
								{
									display.setText("Please enter a your choice.");
								}
								else if (response.equals("1"))
								{
									display.setText(st.displayDetails());
									
								}
								else if (response.equals("2"))
								{
									display.setText(st.displaySystemProperties());
									
								}
								else if (response.equals("3"))
								{
									display.setText(st.diagnoseSystem());
									
								}
								else if (response.equals("4"))
								{
									//go to choice 4 scene
									stage.setScene(sceneC4);
									
								}
								else
								{
									display.setText("Please enter a the correct choice using the numbers 0 - 4.");
								}
							}
		);
		
		//create reset button to clear all the fields and display
		Button resetButton = new Button();
		resetButton.setText("Reset");
		resetButton.setFont(Font.font("Helvetica"));
		resetButton.setOnAction(e -> {
										choiceField.setText("");
										display.setText("");
									}
		);
		
		//create quit button to close program
		Button quitButton = new Button();
		quitButton.setText("Quit");
		quitButton.setFont(Font.font("Helvetica"));
		quitButton.setOnAction(e ->{
										Platform.exit();
									}
		);
		
		
		//create and configure an HBox for labels and text input
		HBox inputComponents = new HBox(10);
		inputComponents.setAlignment(Pos.CENTER);
		inputComponents.getChildren().addAll(choiceLabel, choiceField, okButton);
		
		//Configure an VBox for choices
		VBox choiceOptions = new VBox(25);
		choiceOptions.setAlignment(Pos.BASELINE_CENTER);
		choiceOptions.getChildren().addAll(choice1,choice2,choice3,choice4);
		
		//create and configure HBox to hold the reset and quit buttons
		HBox resetQuitBox = new HBox(10);
		resetQuitBox.setAlignment(Pos.CENTER);
		resetQuitBox.getChildren().addAll(resetButton,quitButton);
		
		//create and configure vertical container to hold all components
		VBox root = new VBox(25);
		root.setAlignment(Pos.TOP_CENTER);
		root.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID,
													new CornerRadii(0), new BorderWidths(2))));
		root.getChildren().addAll(menuTitle,choiceOptions,inputComponents,display,resetQuitBox);
		
		//creating and configuring Choice 4 scene
		//create labels and text fields for Choice 4
		Label memorySizeLabel = new Label("Memory Size (MB):    ");
		memorySizeLabel.setFont(Font.font("Helvetica", 14));
		Label diskSizeLabel = new Label("Hard Disk Size (GB): ");
		diskSizeLabel.setFont(Font.font("Helvetica", 14));
		Label costLabel = new Label("Purchase Cost ($):   ");
		costLabel.setFont(Font.font("Helvetica", 14));
		TextField memorySizeText = new TextField();
		TextField diskSizeText = new TextField();
		TextField costText = new TextField();
		
		//creating buttons for choice 4
		Button resetButtonC4 = new Button();
		resetButtonC4.setText("Reset");
		resetButtonC4.setFont(Font.font("Helvetica", 14));
		resetButtonC4.setOnAction(e -> {
											memorySizeText.setText("");
											diskSizeText.setText("");
											costText.setText("");
									}
		);
		
		//OK button for Choice 4
		Button okButtonC4 = new Button();
		okButtonC4.setText("OK");
		okButtonC4.setFont(Font.font("Helvetica", 14));
		okButtonC4.setOnAction(e -> {
										//assign values to set methods
										if (memorySizeText.getText().isEmpty() || diskSizeText.getText().isEmpty() || costText.getText().isEmpty())
										{
												displayChoice.setText("Please enter all values do not leave blanks.");
										}
										else
										{
										//check if correct data types have been entered
										try
										{
											int memoryValue = Integer.parseInt(memorySizeText.getText());
											double hardDiskValue = Double.parseDouble(diskSizeText.getText());
											double costValue = Double.parseDouble(costText.getText());
									
											st.setMemory(memoryValue);
											st.setHardDisk(hardDiskValue);
											st.setPurchaseCost(costValue);
											//display values for the main scene
											display.setText("The values have been set");
											//return to main scene
											stage.setScene(scene);
										}
										catch (NumberFormatException er)
										{
											a.show();
										}
											
									}			
									
		}
		);
		
		//HBox for Memory Size
		HBox memoryHBox = new HBox(10);
		memoryHBox.setAlignment(Pos.CENTER);
		memoryHBox.getChildren().addAll(memorySizeLabel, memorySizeText);
		
		//HBox for Disk Size
		HBox diskHBox = new HBox(10);
		diskHBox.setAlignment(Pos.CENTER);
		diskHBox.getChildren().addAll(diskSizeLabel, diskSizeText);
		
		//HBox for Purchase Cost
		HBox costHBox = new HBox(10);
		costHBox.setAlignment(Pos.CENTER);
		costHBox.getChildren().addAll(costLabel, costText);
		
		//HBox for reset and ok buttons for scene4
		HBox resetOkC4 = new HBox(10);
		resetOkC4.setAlignment(Pos.CENTER);
		resetOkC4.getChildren().addAll(resetButtonC4, okButtonC4);
		
		//creating VBox for choice 4
		VBox choice4VBox = new VBox(25);
		choice4VBox.setAlignment(Pos.CENTER);
		choice4VBox.getChildren().addAll(memoryHBox, diskHBox, costHBox, displayChoice, resetOkC4);
		
		//create a scene when choice 4 is selected
		sceneC4 = new Scene(choice4VBox, 350, 300);
		
		
		//create a new scene and add it to the stage
		scene = new Scene(root, 520, 700);
		stage.setScene(scene);
		stage.setTitle("System Program Menu");
		stage.show();
	}

	public static void main(String[] args) 
	{
		
		
		//create object from System class
		System stt = new System("Dell", "Inspiron", 2);
		//testing methods
		//get value of getMake() method
		 java.lang.System.out.println();
		 java.lang.System.out.println("***Testing getMake method***");
		 java.lang.System.out.println(stt.getMake());
		 java.lang.System.out.println();
		 
		//get value of getModel() method
		 java.lang.System.out.println("***Testing getModel method***");
		 java.lang.System.out.println(stt.getModel());
		 java.lang.System.out.println();
		 
		//get value of getProcessorSpeed() method
		 java.lang.System.out.println("***Testing getProcessorSpeed***");
		 java.lang.System.out.println(stt.getProcessorSpeed());
		 
		 //set memory method and print value
		 stt.setMemory(64);
		 java.lang.System.out.println();
		 
		//set hard disk size
		 stt.setHardDisk(2.4);
		 java.lang.System.out.println();
		 
		//set purchase cost
		 stt.setPurchaseCost(147.69);
		 java.lang.System.out.println();
		 
		 //display details
		 java.lang.System.out.println("***Testing displayDetails***");
		 java.lang.System.out.println(stt.displayDetails());
		 java.lang.System.out.println();
		 
		 //check HD status
		 java.lang.System.out.println("***Testing checkHDStatus***");
		 java.lang.System.out.println(stt.checkHDStatus());
		 java.lang.System.out.println();
		 
		 //check if memory size is good
		 java.lang.System.out.println("***Testing goodMemorySize***");
		 java.lang.System.out.println(stt.goodMemorySize());
		 java.lang.System.out.println();
		 
		 //diagnose system method
		 java.lang.System.out.println("***Testing the diagnoseSystem***");
		 java.lang.System.out.println(stt.diagnoseSystem());	 
		 java.lang.System.out.println();
		 
		 //testing the system properties method
		 java.lang.System.out.println(stt.displaySystemProperties());
		 
		 launch(args);

	}

}
