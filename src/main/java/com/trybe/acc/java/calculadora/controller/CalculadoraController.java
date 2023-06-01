package com.trybe.acc.java.calculadora.controller;

import com.trybe.acc.java.calculadora.domain.Resultado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraController {


  /**
   * Método calcular.
   */
  @GetMapping("/")
  public ResponseEntity<Resultado> calcular(@RequestParam("primeiroValor") int priValor,
      @RequestParam("segundoValor") int secValor, @RequestParam("operacao") String operacao) {
    int resultado = 0;
    switch (Operacao.valueOf(operacao.toUpperCase())) {
      case ADICAO:
        resultado = priValor + secValor;
        break;
      case SUBTRACAO:
        resultado = priValor - secValor;
        break;
      case MULTIPLICACAO:
        resultado = priValor * secValor;
        break;
      case DIVISAO:
        if (secValor != 0) {
          resultado = priValor / secValor;
        }
        break;
      default:
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
    return ResponseEntity.ok(new Resultado(resultado));
  }
}
