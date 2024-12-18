package pe.edu.i202030258.medina_diana.response;

import pe.edu.i202030258.medina_diana.dto.CarDto;

import java.util.List;

public record GetAllCarResponse(String code,
                                String error,
                                List<CarDto> cars) {
}
