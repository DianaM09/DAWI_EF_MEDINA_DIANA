package pe.edu.i202030258.medina_diana.response;

import pe.edu.i202030258.medina_diana.dto.CarDetailDto;

public record GetDetailCarResponse(String code,
                                   String error,
                                   CarDetailDto carDetailDto) {
}
