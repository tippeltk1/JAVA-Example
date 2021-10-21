/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hunter Liddell, Kasey Tippelt, Rachel Soucie
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.scene.control.TextArea;


public class GUI extends Application{
   
   public static void main(String[] args){
      launch(args);
   }
   
   
   @Override
   public void start(Stage primaryStage) throws Exception {
      
      primaryStage.setTitle("OOPS");
      GridPane pane = new GridPane();
      Scene scene = new Scene(pane, 584, 425);
      
      //Sets spacing throughout the GUI
      pane.setPadding(new Insets(11,12,13,14));
      pane.setHgap(5);
      pane.setVgap(15);
      
      //Button, Label, and text field Declarations
      Button btnSelection = new Button("Selection");
      Button btnInsertion = new Button("Insertion");
      Button btnBubble = new Button("Bubble");
      Button iStep = new Button("  i++  ");
      
      Label label = new Label("Enter the amount of numbers: ");
      Label blank = new Label("                                     ");
      TextField txtInput = new TextField();
      TextArea txtOutput = new TextArea();
      txtOutput.setPrefHeight(300);
      
      //Labels
      pane.add(label, 0, 0);
      pane.add(blank, 3, 0);
      
      //Text boxes
      pane.add(txtInput, 1, 0);
      pane.add(txtOutput, 0, 2, 5, 1);
      
      //Buttons
      pane.add(btnSelection, 0, 1);
      pane.add(btnInsertion, 1, 1);
      pane.add(btnBubble, 2, 1);
      pane.add(iStep, 4, 0);
      
      //Stores the array length
      btnSelection.setOnAction (e -> calcSelection( txtInput, txtOutput, iStep));
      btnInsertion.setOnAction(e -> calcInsertion( txtInput, txtOutput, iStep));
      btnBubble.setOnAction(e-> calcBubble( txtInput, txtOutput, iStep));
      primaryStage.setScene(scene);
      primaryStage.show();
      
   }
   
   // This shows the selectionsort path
   public void calcSelection(TextField txtInput, TextArea txtOutput, 
            Button iStep)
   {
      int arrLength;
      int MAX_VALUE = 15, MIN_VALUE = 0;
      int selection[];
      try{
         arrLength = Integer.valueOf(txtInput.getText());
         if (arrLength <= MAX_VALUE && arrLength >= MIN_VALUE)
         {
            selection = new int[arrLength];
            Sorts.fill(arrLength, selection);
            Sorts.SelectionSort(selection, txtOutput, iStep);
         }
         else
         {
             txtOutput.setText("Please enter and number above 0 and below 15.");
         }
      }
      catch(NumberFormatException ex)
      {
         txtOutput.appendText("\nPlease enter integer value.");
      }
   }
   
   // this shows the insertionsort path
   public void calcInsertion(TextField txtInput, TextArea txtOutput, 
           Button iStep)
   {
       int arrLength;
      int MAX_VALUE = 15, MIN_VALUE = 0;
      int insertion[];
      try{
         arrLength = Integer.valueOf(txtInput.getText());
         if (arrLength <= MAX_VALUE && arrLength >= MIN_VALUE)
         {
            insertion = new int[arrLength];
            Sorts.fill(arrLength, insertion);
            Sorts.InsertionSort(insertion, txtOutput, iStep);
         }
         else
         {
             txtOutput.setText("Please enter and number above 0 and below 15.");
         }
      }
      catch(NumberFormatException ex)
      {
         txtOutput.appendText("\nPlease enter integer value.");
      }
   }
   
   //this shows the bubblesort path
   public void calcBubble(TextField txtInput, TextArea txtOutput, Button iStep)
   {
       int arrLength;
      int MAX_VALUE = 15, MIN_VALUE = 0;
      int bubble[];
      try{
         arrLength = Integer.valueOf(txtInput.getText());
         if (arrLength <= MAX_VALUE && arrLength >= MIN_VALUE)
         {
            bubble = new int[arrLength];
            Sorts.fill(arrLength, bubble);
            Sorts.BubbleSort(bubble, txtOutput, iStep);
         }
         else
         {
             txtOutput.setText("Please enter and number above 0 and below 15.");
         }
      }
      catch(NumberFormatException ex)
      {
         txtOutput.appendText("\nPlease enter integer value.");
      }
   }
   
   
   
   
   public static void selectionPrint(TextArea txtOutput, int[] arr, int i, 
           int min, int j)
   {
      txtOutput.appendText(Integer.toString(arr[j]) + " "); // print numbers before j
   }
   
   public static void newLine(TextArea txtOutput)
   {
      txtOutput.appendText("\n");
   }
   
   public static void arrayPrint( int[] arr, TextArea txtOutput)
   {
      txtOutput.setText("This is the array: ");
      for (int i = 0; i < arr.length; i++)
         txtOutput.appendText(Integer.toString(arr[i])+ " ");
      txtOutput.appendText("\n\n");
   }
   
   public static void passPrint(int i, TextArea txtOutput, int[] arr, int min)
   {
       txtOutput.appendText("The 'min' in this passthrough is: " + 
               Integer.toString(arr[min]) + "\n"); // make red
       txtOutput.appendText("Pass through " + Integer.toString(i + 1) + ": ");
   }
   
   public static void swapPrint(TextArea txtOutput, int[] arr, int i, int min)
   {
      // swaps arr[i] and arr of [min]
       if (arr[min] != arr[i])
       {
            txtOutput.appendText("\nIn this run, the numbers swapped were: " +
               Integer.toString(arr[i]) + " and " + Integer.toString(arr[min]) +
               "\n");
            txtOutput.appendText("This is the array after swap number " + 
               Integer.toString(i + 1) + ": " );
            for (int j = 0; j < arr.length; j++)
                txtOutput.appendText(Integer.toString(arr[j])+ " ");
            txtOutput.appendText("\n\n");
       }
       else
       {
            txtOutput.appendText("\nIn this run, the 'min' was in the right"
                   + " place in the array\n");
            txtOutput.appendText("The array is still: ");
            for (int j = 0; j < arr.length; j++)
                txtOutput.appendText(Integer.toString(arr[j])+ " ");
            txtOutput.appendText("\n\n");
       }
   }
   
   public static void minPrint(TextArea txtOutput, int[] arr, int min)
   {
      txtOutput.appendText("The new 'min' is: " + Integer.toString(arr[min]) +
              "\n"); 
   }
   
   public static void insertionPassPrint(int i, TextArea txtOutput, int[] arr,
           int key)
   {
       txtOutput.appendText("The 'key' in this passthrough is: " + 
               Integer.toString(key)); // make red
       txtOutput.appendText("\nPass through " + Integer.toString(i) + ": \n");
   }
   
   public static void insertionPrint(int j, TextArea txtOutput, int[] arr)
   {
       
       for (int i = 0; i < arr.length; i++)
            txtOutput.appendText(Integer.toString(arr[i])+ " ");
       txtOutput.appendText("\n");
   }
   
   public static void insertionSwap(int j, TextArea txtOutput, int[] arr, 
           int key, int i)
   {
       if (j == -1)
           j = 0;
       if (arr[j] <= key && i == 1)
       {
           txtOutput.appendText(Integer.toString(arr[j]) + " is already less "
                   + "than " + Integer.toString(key) + "\n");
           txtOutput.appendText("The array is still: ");
           for (int k = 0; k < arr.length; k++)
               txtOutput.appendText(Integer.toString(arr[k])+ " ");
           txtOutput.appendText("\n\n");
       }
       else
       {
           txtOutput.appendText("The array after swap number " + 
                   Integer.toString(i) + " is: \n");
           for (int k = 0; k < arr.length; k++)
               txtOutput.appendText(Integer.toString(arr[k])+ " ");
           txtOutput.appendText("\n\n");
       }
   }
   public static void bubbleSwap(int[] arr, TextArea txtOutput, int j, int i)
   {
       txtOutput.appendText(Integer.toString(arr[j + 1]) + " was swapped with "
               + Integer.toString(arr[j]) + "\n");
       if(j == (arr.length -i -1))
       {
          for (int k = 0; k < arr.length - i + 1; k++)
             txtOutput.appendText(Integer.toString(arr[k])+ " ");
           txtOutput.appendText("\n");
       }
   }
   
    public static void bubblePrint(int[] arr, TextArea txtOutput, int j, int i)
    {
        for (int k = 0; k < (j + 2); k++)
        {
            txtOutput.appendText(Integer.toString(arr[k])+ " ");
        }
        txtOutput.appendText("\n");
    }
    
    public static void finalBubble(TextArea txtOutput, int count, int[] arr, 
            int i, int j)
    {
        if (count == 0)
        {
            txtOutput.appendText("No numbers were swapped this run.\n");
            for (int k = 0; k < j; k++)
             txtOutput.appendText(Integer.toString(arr[k])+ " ");
           txtOutput.appendText("\n");
        }
        
    }
    
    public static void bubblePass(TextArea txtOutput, int i)
    {
        txtOutput.appendText("\nPass through " + Integer.toString(i) + ": \n");
    }
    
    public static void finalArray(TextArea txtOutput, int[] arr)
    {
        txtOutput.appendText("\nThe final array is: \n");
            for (int k = 0; k < arr.length; k++)
             txtOutput.appendText(Integer.toString(arr[k])+ " ");
    }
}

