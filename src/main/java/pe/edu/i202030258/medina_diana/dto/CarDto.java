package pe.edu.i202030258.medina_diana.dto;

public record CarDto(Integer carId,
                     String ownerName,
                     String ownerContact,
                     String color,
                     Integer mileage,
                     String insuranceCompany,
                     String insurancePolicyNumber) {
}
