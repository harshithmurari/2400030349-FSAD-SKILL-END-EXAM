package com.klef.fsaad.exam.controller;

import com.klef.fsaad.exam.entity.Transport;
import com.klef.fsaad.exam.repository.TransportRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

import java.util.Map;

@RestController
@RequestMapping("/api/transports")
public class TransportController {

    private final TransportRepository transportRepository;

    public TransportController(TransportRepository transportRepository) {
        this.transportRepository = transportRepository;
    }

    @PostMapping
    public ResponseEntity<?> addTransport(@Valid @RequestBody Transport transport) {
        if (transport.getTransportId() != null && transportRepository.existsById(transport.getTransportId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("message", "Transport with this ID already exists"));
        }

        Transport saved = transportRepository.save(transport);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<Transport>> getAllTransports() {
        List<Transport> list = transportRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTransportById(@PathVariable Integer id) {
        Optional<Transport> opt = transportRepository.findById(id);
        if (opt.isPresent()) {
            return ResponseEntity.ok(opt.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("message", "Transport not found"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTransport(@PathVariable Integer id) {
        if (!transportRepository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "Transport not found"));
        }

        transportRepository.deleteById(id);
        return ResponseEntity.ok(Map.of("message", "Transport deleted successfully"));
    }
}
