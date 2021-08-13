/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Calendar;

/**
 *
 * @author huriel.lopes
 */
public class trabalho2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        boolean error = false;
        Float diary = 0f;
        String string_date_location = "";
        String string_date_devolution = ""; 
        Calendar date_location = Calendar.getInstance();
        Calendar date_devolution = Calendar.getInstance();
        
        do {
            error = false;
            
            if(!error) {
                try {     
                    System.out.println("Informe o valor da diária: ");
                    diary = Float.parseFloat(input.nextLine());
                    
                    if(diary <= 0) 
                        throw new Exception("A diária informada é inválida!");
                } catch (NumberFormatException ne) {
                    System.out.println("A o valor de diária informada é inválido!");
                    error = true;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    error = true;
                }
            }
            
            if(!error) {
                try {
                    System.out.println("Informe a data de locação no formato dd/mm/aaaa: ");
                    string_date_location = input.nextLine();
                    
                    sdf.setLenient(false);

                    date_location.setTime(sdf.parse(string_date_location));
                    date_location.set(Calendar.HOUR, 12);
                    
                    Calendar today_date = Calendar.getInstance();
                    today_date.set(Calendar.MILLISECOND, 0);
                    today_date.set(Calendar.SECOND, 0);
                    today_date.set(Calendar.MINUTE, 0);
                    today_date.set(Calendar.HOUR, 0);
                    
                    int date_comparison_result = date_location.compareTo(today_date);
                    
                    if (date_comparison_result < 0)
                        throw new Exception("A data de locação informada não pode ser anterior ao dia de hoje.");
                } catch (Exception e) {
                    System.out.println("Houve um erro ao tentar usar a data de locação informada: " + e.getMessage());
                    error = true;
                }
            }
            
            if(!error) {
                try {
                    System.out.println("Informe uma data de devolução no formato dd/mm/aaaa: ");
                    string_date_devolution = input.nextLine();
                    
                    sdf.setLenient(false);
                    date_devolution.setTime(sdf.parse(string_date_devolution));
                    date_devolution.set(Calendar.HOUR, 12);
                    
                    Calendar today_date = Calendar.getInstance();
                    today_date.set(Calendar.MILLISECOND, 0);
                    today_date.set(Calendar.SECOND, 0);
                    today_date.set(Calendar.MINUTE, 0);
                    today_date.set(Calendar.HOUR, 0);
                    
                    int date_comparison_result = date_devolution.compareTo(today_date);
                    
                    if (date_comparison_result < 0)
                        throw new Exception("A data de devolução informada não pode ser anterior ao dia de hoje.");
                } catch (Exception e) {
                    System.out.println("Houve um erro ao tentar usar a data de devolução informada: " + e.getMessage());
                    error = true;
                }
            } 
            
            if(!error) {
                try {              
                    sdf.setLenient(false);
                    date_location.setTime(sdf.parse(string_date_location));
                    date_location.set(Calendar.HOUR, 12);
                    
                    date_devolution.setTime(sdf.parse(string_date_devolution));
                    date_devolution.set(Calendar.HOUR, 12);
                    
                    int date_comparison_result = date_location.compareTo(date_devolution);
                    
                    if (date_comparison_result > 0)
                        throw new Exception("A data de devolução informada não pode ser anterior ao dia de locação.");
                } catch (Exception e) {
                    System.out.println("Houve um erro ao tentar usar a data de devolução informada: " + e.getMessage());
                    error = true;
                }
            }
        } while(error == true);
        
        int location_days = date_devolution.get(Calendar.DAY_OF_YEAR) - date_location.get(Calendar.DAY_OF_YEAR);
        
        Float total_location_price = diary * location_days;
        
        System.out.println("Valor da diária: " + diary);
        System.out.println("Data de locação: " + sdf.format(date_location.getTime()));
        System.out.println("Data de devolução: " + sdf.format(date_devolution.getTime()));
        System.out.println("Dias de locação: " + location_days);
        System.out.println("Valor total da locação: " + total_location_price);
    }
}
