package repositories;

import models.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {
    //Gate table
    private Map<Long, Gate> gates = new HashMap<>();

    // CRUD operations on Gate table
    // save
    public Gate save(Gate gate) {
        gates.put(gate.getId(), gate);
        return gate;
    }
    // read
    public Optional<Gate> findByGateId(Long id) {
        return Optional.ofNullable(gates.get(id));
    }
}
