
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
public class trabalho4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        boolean error = false;
        String string_date = "";
        Calendar date= Calendar.getInstance();
        
        Float price = 0f;
        Integer quantity = 0;
        
        do {
            error = false;
            
            if(!error) {
                try {
                    System.out.println("Informe o valor da compra: ");
                    price = Float.parseFloat(input.nextLine());
                    
                    if(price <= 0) 
                        throw new Exception("O valor informado é inválido!");
                } catch (NumberFormatException ne) {
                    System.out.println("O valor informado é inválido!");
                    error = true;
                } catch (Exception e) {
                    System.out.println("Houve um erro com o valor informado: " + e.getMessage());
                    error = true;
                }
            }
            
            if(!error) {
                try {
                    System.out.println("Informe a quantidade de parcelas: ");
                    quantity = Integer.parseInt(input.nextLine());
                    
                    if(quantity <= 0) 
                        throw new Exception("A quantidade de parcelas informada é inválida!");
                } catch (NumberFormatException ne) {
                    System.out.println("A quantidade de parcelas informada é inválida!");
                    error = true;
                } catch (Exception e) {
                    System.out.println("Houve um erro com a quantidade de parcelas  informada: " + e.getMessage());
                    error = true;
                }
            }
        } while(error == true);
        
        float[] month_price = new float[quantity];
        Calendar[] payment_days = new Calendar[quantity];
        
        float month_payment = price / quantity;
        Calendar current_date = Calendar.getInstance();
        
        System.out.println("Valor da compra: " + price);
        System.out.println("Total de parcelas: " + quantity);
        
        for(int i = 0; i < quantity; i++) {
            month_price[i] = month_payment;
            current_date.add(Calendar.DATE, 30);
            
            payment_days[i] = current_date;
            
            System.out.println("Valor da parcela: " + month_price[i] + " Data do " + i + " vencimento: " + sdf.format(payment_days[i].getTime()));
        }
    }
}
