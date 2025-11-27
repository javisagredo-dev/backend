package cl.duocuc.huertohogar.backend.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
// Es el request completo para crear un ticket (la compra)
// Es el body del POST /api/tickets
// Lo recibe el controller
// El service lo usa para crear Ticket + TicketDetail y calcular el total
@Data
public class TicketCreateRequestDTO {

    private Long userId; 
    private List<TicketCreateItemDTO> items;
    private BigDecimal total;        // Total calculado en el front
    private LocalDateTime purchaseDate;  // Fecha desde el front
}