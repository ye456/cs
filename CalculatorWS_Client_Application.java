/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorws_client_application;

/**
 *
 * @author Rashmi Kabra
 */
public class CalculatorWS_Client_Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        org.me.calculator.client.CalculatorWS_Service service = new org.me.calculator.client.CalculatorWS_Service();
        org.me.calculator.client.CalculatorWS port = service.getCalculatorWSPort();
        int i= 7;
        int j= 5;
        int result = port.add(i, j);
        System.out.println("Result"+result);
       }

   
    
    
}
