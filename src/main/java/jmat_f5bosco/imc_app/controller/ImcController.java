package jmat_f5bosco.imc_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/principal")


public class ImcController {

    @PostMapping("/calculo-imc")
    public String calcularIMC(@RequestParam("peso") double peso, @RequestParam("altura") double altura, Model model) {
        
        double imc = peso / Math.pow(altura,2); 

        
        String imcMessage;
        if (imc < 18.5) {
            imcMessage = "Bajo peso";
        } else if (imc < 24.9) {
            imcMessage = "Saludable";
        } else if (imc < 29.9) {
            imcMessage = "Sobrepeso";
        } else {
            imcMessage = "Obesidad";
        }

        
        model.addAttribute("imcMessage", imcMessage);
        model.addAttribute("imc", imc);

        
        return "index";
    }
}
