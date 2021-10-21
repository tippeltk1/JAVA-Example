
import java.util.Random;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;


/** 
* 
* @author Kasey, Rachel, Hunter 
*/ 
public class Sorts extends GUI
{
   
   // Does selection sort when called 
   // @Author Kasey 
   public static void SelectionSort(int arr[], TextArea txtOutput, 
         Button iStep)    
   { 
     int i, j, min; 
     arrayPrint(arr, txtOutput);
     for( i = 0; i < arr.length - 1; i ++ ) 
     { 
        min = i; 
        passPrint(i, txtOutput, arr, min);
        // print numbers before J here and color them.
        for( j = i + 1; j < arr.length; j ++ ) 
        { 
           //TimeUnit.SECONDS.sleep(1);
           selectionPrint(txtOutput, arr, i, min, j);
           if ( arr[j] < arr[min] ) 
           {
              min = j;
              //minPrint(txtOutput, arr, min);
           }      
        } 
        swap(arr, i, min); 
        swapPrint(txtOutput, arr, i, min);
     } 
   } 
   
   // Does insertion sort when called 
   // @Author Kasey 
   public static void InsertionSort (int [] arr, TextArea txtOutput, 
           Button iStep) 
   { 
      int key, j; 
      arrayPrint(arr, txtOutput);
      for ( int i = 1; i < arr.length; i ++ ) 
      { 
         key = arr[i]; 
         j =  i - 1; 
         insertionPassPrint(i, txtOutput, arr, key);
         while( j >= 0 && arr[j] > key ) 
         {    
            insertionPrint(j, txtOutput, arr);
            arr[j + 1] = arr[j]; 
            j -= 1;  
         } 
         arr[j+1] = key; 
         insertionSwap(j, txtOutput, arr, key , i);
      } 
   } 
   
   // does bubble sort when called 
   // @author Kasey 
   public static void BubbleSort(int arr[] , TextArea txtOutput, Button iStep)  // check this to make sure it's working 
   {   
      int i, j, count;   
      arrayPrint(arr, txtOutput);
      for (i = 1; i < arr.length; i++) 
      { 
         bubblePass(txtOutput, i);
         count = 0;
         for (j = 0; j < arr.length - i; j++) 
         { 
            bubblePrint(arr, txtOutput, j, i);
            if (arr[j] > arr[j+1])
            {
                swap(arr, j, j+1);
                bubbleSwap(arr, txtOutput, j, i);
                count ++;
            }  
         }
         finalBubble(txtOutput, count, arr, i ,j);
      }
      finalArray(txtOutput, arr);
   }   
   
   // Swaps the numbers in the array 
   // @author Kasey 
   public static void swap(int [] arr, int index1, int index2) 
   { 
      int temp = arr[index1]; 
      arr[index1] = arr[index2]; 
      arr[index2] = temp; 
   }   
   
 
   
   public static void fill(int arrLength, int[] arr)
   {
      Random random = new Random();
      for (int i = 0; i < arrLength; i++)
      {
         arr[i] = random.nextInt(200);
      }
   }
}
