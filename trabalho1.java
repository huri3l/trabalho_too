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
public class trabalho1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String name = "";
        Float salary = 0f;
        Float liquid_salary = 0f;
        Float inss = 0f;
        Float inss_roof = 0f;
        boolean error = false;
        
        do {
            error = false;
            
            if(!error) {
                try {     
                    System.out.println("Informe seu nome: ");
                    name = input.nextLine();
                    
                    if(name.length() <= 0) 
                        throw new Exception("O nome precisa ter ao menos 1 caractere!");
                } catch (Exception e) {
                    System.out.println(e);
                    error = true;
                }
            }
            
            if(!error) {
                try {
                    System.out.println("Informe seu salário: ");
                    salary = Float.parseFloat(input.nextLine());
            
                    if(salary <= 0)
                        throw new Exception("O salário informado é inválido.");
                } catch (NumberFormatException e) {
                    System.out.println("Número inválido");
                    error = true;
                } catch (Exception e) {
                    System.out.println("O salário informado é inválido.");
                    error = true;
                }
            } 
        } while(error == true);
        
        if(salary > 6433.57)
            inss_roof = 6433.57f;
        else
            inss_roof = salary;
        
        if(inss_roof <= 1100)
            inss = (inss_roof * 7.5f) / 100;
        
        else if(inss_roof > 1100 && inss_roof <= 2203.48f)
            inss = (inss_roof * 9.0f) / 100;
        
        else if(inss_roof > 2203.48f && inss_roof <= 3305.22f)
            inss = (inss_roof * 12.0f) / 100;
        
        else if (inss_roof > 3305.23f && inss_roof <= 6433.57f)
            inss = (inss_roof * 14.0f) / 100;
        
        liquid_salary = salary - inss;
        
        System.out.println("Nome:" + name);
        System.out.println("Salário bruto: " + salary);
        System.out.println("INSS: " + inss);
        System.out.println("Salário líquido: " + liquid_salary);   
    }
}
