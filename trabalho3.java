
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author huriel.lopes
 */
public class trabalho3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        boolean error = false;
        String string_date = "";
        Calendar date= Calendar.getInstance();
        
        do {
            error = false;
            
            if(!error) {
                try {
                    System.out.println("Informe a primeira data de pagamento no formato dd/mm/aaaa: ");
                    string_date = input.nextLine();
                    
                    sdf.setLenient(false);

                    date.setTime(sdf.parse(string_date));
                    
                } catch (Exception e) {
                    System.out.println("Houve um erro com a data informada: " + e.getMessage());
                    error = true;
                }
            }
        } while(error == true);
        
        Calendar current_date = date;
        
        System.out.println("Data informada: " + sdf.format(date.getTime()));
        for(int i = 0; i < 5; i++) {
            current_date.add(Calendar.DATE, 7);
            System.out.println("Data de pagamento: " + sdf.format(current_date.getTime()));
        }
    }
}
