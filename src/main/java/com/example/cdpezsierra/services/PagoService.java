package com.example.cdpezsierra.services;

import com.example.cdpezsierra.models.Pago;
import com.example.cdpezsierra.repositories.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    public List<Pago> getAllPagos() {
        return pagoRepository.findAll();
    }

    public Pago getPagoById(int id) {
        return pagoRepository.findById(id).orElse(null);
    }

    public Pago createPago(Pago pago) {
        return pagoRepository.save(pago);
    }

    public Pago updatePago(int id, Pago pago) {
        if (pagoRepository.existsById(id)) {
            pago.setIdPago(id);;
            return pagoRepository.save(pago);
        }
        return null;
    }

    public void deletePago(int id) {
        pagoRepository.deleteById(id);
    }
}
