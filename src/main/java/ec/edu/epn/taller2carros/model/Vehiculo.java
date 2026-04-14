package ec.edu.epn.taller2carros.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {
    private String codigo;
    private String marca;
    private String modelo;
    private double precio;
}