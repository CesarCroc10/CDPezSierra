package com.example.cdpezsierra.controllers;

import com.example.cdpezsierra.models.Pago;
import com.example.cdpezsierra.services.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    // Método para obtener todos los pagos (API REST)
    @GetMapping
    @ResponseBody
    public List<Pago> getAllPagos() {
        return pagoService.getAllPagos();
    }

    // Método para obtener un pago por ID (API REST)
    @GetMapping("/{id}")
    @ResponseBody
    public Pago getPagoById(@PathVariable int id) {
        return pagoService.getPagoById(id);
    }

    // Método para crear un pago (API REST)
    @PostMapping
    @ResponseBody
    public Pago createPago(@RequestBody Pago pago) {
        return pagoService.createPago(pago);
    }

    // Método para actualizar un pago (API REST)
    @PutMapping("/{id}")
    @ResponseBody
    public Pago updatePago(@PathVariable int id, @RequestBody Pago pago) {
        return pagoService.updatePago(id, pago);
    }

    // Método para eliminar un pago (API REST)
    @DeleteMapping("/{id}")
    @ResponseBody
    public void deletePago(@PathVariable int id) {
        pagoService.deletePago(id);
    }

    // Método para mostrar los pagos en la vista HTML (Thymeleaf)
    @GetMapping("/vista")
    public String mostrarPagos(Model model) {
        // Obtener la lista de pagos y agregarla al modelo
        model.addAttribute("pagos", pagoService.getAllPagos());
        return "pagos"; // Nombre del archivo HTML (src/main/resources/templates/pagos.html)
    }
}
	