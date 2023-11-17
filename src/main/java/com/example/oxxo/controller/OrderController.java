package com.example.oxxo.controller;

import java.util.List;

import com.example.oxxo.model.request.UpdateOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.oxxo.entity.Order;
import com.example.oxxo.model.request.CreateOrderRequest;
import com.example.oxxo.model.response.MessageResponse;
import com.example.oxxo.service.OrderService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "*",maxAge = 3600)
public class OrderController {
    @Autowired
    private OrderService orderService;


    @GetMapping("/")
    @Operation(summary="Obtener la lista de pedidos")
    public ResponseEntity<List<Order>> getList(){
        List<Order> list = orderService.getList();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/user")
    @Operation(summary="Recuperar la lista de pedidos de usuarios por nombre de usuario")
    public ResponseEntity<List<Order>> getListByUser(@RequestParam("username") String username){
        List<Order> list = orderService.getOrderByUser(username);

        return ResponseEntity.ok(list);
    }

    @PostMapping("/create")
    @Operation(summary="Pedir productos")
    public ResponseEntity<?> placeOrder(@RequestBody CreateOrderRequest request){

        orderService.placeOrder(request);

        return ResponseEntity.ok(new MessageResponse("¡Orden Colocada!"));
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Actualizar un pedido por ID")
    public ResponseEntity<?> updateOrder(
            @PathVariable("id") Long id,
            @RequestBody UpdateOrderRequest request) {

        orderService.updateOrder(id, request);

        return ResponseEntity.ok(new MessageResponse("¡Pedido actualizado!"));
    }

}
