package org.example.ovnis;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UfoSightingService {
    private final UfoSightingRepository repository;

    public UfoSightingService(UfoSightingRepository repository) {
        this.repository = repository;
    }

    public List<UfoSighting> getAll() {
        return repository.findAll();
    }

    public UfoSighting save(UfoSighting sighting) {
        return repository.save(sighting);
    }
}
