/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03a;

import javax.swing.*;
import java.text.*;

public class BasicMethodsLab {

   public static void main( String args[] ) {

    String grossPayStr;     // Value entered by user; string type
    String taxRateStr;      // Value entered by user; string type
    String taxpayerTypeStr;
    String taxpayerTypeName;
    char taxpayerType = ' ';
    double grossPay;        // The double form of the user-entered gross pay
    double taxRate = 0;     // The double form of the user-entered tax rate
    double tax = 0;         // The tax for the pay period
    double netPay = 0;
    int resp = 0;           // The user's response as to whether to continue
    DecimalFormat prec1 = new DecimalFormat("#.0%");
    DecimalFormat prec2 = new DecimalFormat("$#.00");
    

    

    // Initialize the output string to the empty string
    String outputStr = "";

    while (true) {
      // Read in gross pay from user as a string
      grossPayStr = JOptionPane.showInputDialog("Enter gross pay for the pay period");

      // Convert from type String to type double
      grossPay = Double.parseDouble(grossPayStr);

      // Read in tax rate from user as a string
      taxRateStr = JOptionPane.showInputDialog("Enter tax rate as a percent");

      // Convert from type String to type double
      taxRate = Double.parseDouble(taxRateStr);

      taxpayerTypeStr = JOptionPane.showInputDialog("Enter the taxpayer type (enter w, b, or m)\n"
        + "w: Weekly\n" + "b: Biweekly\n" + "m: Monthly\n");
      
      switch(taxpayerTypeStr)
      {
          case "w":
              taxpayerType = 'w';
              break;
          case "b":
              taxpayerType = 'b';
              break;
          case "m":
              taxpayerType = 'm';
              break;
          default:
              JOptionPane.showMessageDialog(null, "Invalid taxpayer type entered.",
                      "Error", JOptionPane.INFORMATION_MESSAGE);
      }
      
      // Echo print the entered values
      outputStr = outputStr + "Gross pay: " + prec2.format(grossPay) + ", ";
      outputStr = outputStr + "Tax rate: " + prec1.format(taxRate) + ", ";
      
      taxpayerTypeName = getTaxpayerTypeName(taxpayerType);
      
      outputStr = outputStr + "Taxpayer type: " + taxpayerTypeName;

      // Calculate tax for the pay period
      tax = calculateTax(grossPay, taxRate, taxpayerType);

      netPay = calculateNetPay(grossPay, tax);
      // Print the tax
      outputStr = outputStr + ", " + "Tax: " + prec2.format(tax);
      
      outputStr = outputStr + ", " + "Net pay: " + prec2.format(netPay) + "\n";

      // Determine whether the user wants to continue the loop
      resp = JOptionPane.showConfirmDialog(null, outputStr + "\nContinue?", "Confirm",
                                           JOptionPane.YES_NO_OPTION,
                                           JOptionPane.QUESTION_MESSAGE);

      if (resp == JOptionPane.NO_OPTION)
        break;
    }

    // Display final output to the user
    JOptionPane.showMessageDialog(
       null, outputStr, "Final Results", JOptionPane.INFORMATION_MESSAGE);

    
  }
   
   private static double calculateTax(double grossPay, double taxRate, char taxpayerType)
   {
       double calculatedTax = grossPay * taxRate;
       return calculatedTax;
   }
   
   private static double calculateNetPay(double grossPay, double tax)
   {
       double netPay = grossPay - tax;
       return netPay;
   }
   
   private static String getTaxpayerTypeName(char taxpayerType)
   {
       String taxpayerTypeName = "";
       switch(taxpayerType)
       {
           case 'w':
               taxpayerTypeName = "weekly";
               break;
           case 'b':
               taxpayerTypeName = "biweekly";
               break;
           case 'm':
               taxpayerTypeName = "monthly";
               break;
           default:
               JOptionPane.showMessageDialog(null, "Invalid taxpayer type entered.",
                      "Error", JOptionPane.INFORMATION_MESSAGE);
       }
       return taxpayerTypeName;
   }
}

